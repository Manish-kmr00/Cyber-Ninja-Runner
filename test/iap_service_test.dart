import 'dart:async';
import 'package:flutter_test/flutter_test.dart';
import 'package:in_app_purchase/in_app_purchase.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:cyber_ninja_runner/core/services/iap_service.dart';
import 'package:cyber_ninja_runner/core/storage/save_models.dart';
import 'package:cyber_ninja_runner/core/storage/save_service.dart';

/// Fake InAppPurchase for unit testing purchase flows and edge cases
class FakeInAppPurchase implements InAppPurchase {
  final StreamController<List<PurchaseDetails>> _streamController =
      StreamController<List<PurchaseDetails>>.broadcast();

  bool isAvailableResult = true;
  bool buyConsumableResult = true;
  bool shouldThrowOnBuy = false;
  List<PurchaseDetails> completedPurchases = [];

  @override
  Stream<List<PurchaseDetails>> get purchaseStream => _streamController.stream;

  void emitPurchaseUpdates(List<PurchaseDetails> updates) {
    _streamController.add(updates);
  }

  @override
  Future<bool> isAvailable() async => isAvailableResult;

  @override
  Future<ProductDetailsResponse> queryProductDetails(
    Set<String> identifiers,
  ) async {
    final List<ProductDetails> found = [];
    final List<String> notFound = [];

    for (final id in identifiers) {
      if (IAPService.kProductIds.contains(id)) {
        found.add(
          ProductDetails(
            id: id,
            title: 'Title for $id',
            description: 'Desc for $id',
            price: id == IAPService.idCP1000 ? '₹89.00' : '\$2.99',
            rawPrice: 0.99,
            currencyCode: 'INR',
          ),
        );
      } else {
        notFound.add(id);
      }
    }

    return ProductDetailsResponse(productDetails: found, notFoundIDs: notFound);
  }

  @override
  Future<bool> buyConsumable({
    required PurchaseParam purchaseParam,
    bool autoConsume = true,
  }) async {
    if (shouldThrowOnBuy) {
      throw Exception('Billing network error');
    }
    return buyConsumableResult;
  }

  @override
  Future<bool> buyNonConsumable({required PurchaseParam purchaseParam}) async {
    return false;
  }

  @override
  Future<void> completePurchase(PurchaseDetails purchase) async {
    completedPurchases.add(purchase);
  }

  @override
  Future<void> restorePurchases({String? applicationUserName}) async {}

  @override
  Future<String> countryCode() async => 'IN';

  @override
  dynamic noSuchMethod(Invocation invocation) => super.noSuchMethod(invocation);

  void dispose() {
    _streamController.close();
  }
}

PurchaseDetails createTestPurchaseDetails({
  required String transactionId,
  required String productId,
  required PurchaseStatus status,
  bool pendingCompletePurchase = true,
  IAPError? error,
}) {
  final details = PurchaseDetails(
    purchaseID: transactionId,
    productID: productId,
    verificationData: PurchaseVerificationData(
      localVerificationData: '{"orderId":"$transactionId"}',
      serverVerificationData: 'token_$transactionId',
      source: 'google_play',
    ),
    transactionDate: DateTime.now().millisecondsSinceEpoch.toString(),
    status: status,
  );
  details.pendingCompletePurchase = pendingCompletePurchase;
  details.error = error;
  return details;
}

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  late SaveService saveService;
  late IAPService iapService;
  late FakeInAppPurchase fakeIAP;

  setUp(() async {
    SharedPreferences.setMockInitialValues({});
    saveService = SaveService();
    await saveService.init();
    saveService.player.cyberPoints.value = 1000;

    fakeIAP = FakeInAppPurchase();
    iapService = IAPService();
    iapService.resetForTesting();
    iapService.iapInstance = fakeIAP;
  });

  tearDown(() {
    fakeIAP.dispose();
    iapService.resetForTesting();
  });

  group('IAPService Consolidation & Safety Tests', () {
    test('1. Product IDs: Exactly three active official products exist', () {
      expect(IAPService.kProductIds.length, 3);
      expect(
        IAPService.kProductIds,
        containsAll([
          IAPService.idCP1000,
          IAPService.idCP5000,
          IAPService.idCP10000,
        ]),
      );
      expect(IAPService.idCP1000, 'cp_1000');
      expect(IAPService.idCP5000, 'cp_5000');
      expect(IAPService.idCP10000, 'cp_10000');
    });

    test('2. CP Mapping: Centralized reward values are authoritative', () {
      expect(IAPService.getCPAmount('cp_1000'), 5000);
      expect(IAPService.getCPAmount('cp_5000'), 10000);
      expect(IAPService.getCPAmount('cp_10000'), 20000);

      expect(IAPService.kCPAmounts['cp_1000'], 5000);
      expect(IAPService.kCPAmounts['cp_5000'], 10000);
      expect(IAPService.kCPAmounts['cp_10000'], 20000);
    });

    test('3. Legacy IDs rejected from active configuration', () {
      const legacyIds = ['cp_20000', 'cp_500', 'cp_2000'];
      for (final legacyId in legacyIds) {
        expect(IAPService.isValidProductId(legacyId), isFalse);
        expect(IAPService.kProductIds.contains(legacyId), isFalse);
        expect(IAPService.kCPAmounts.containsKey(legacyId), isFalse);
        expect(IAPService.getCPAmount(legacyId), 0);
      }
    });

    test('4. Unknown product ID does not grant CP', () async {
      await iapService.init(saveService);
      const unknownId = 'cp_99999_invalid';

      // buyCP should reject unknown product immediately
      final buyResult = await iapService.buyCP(unknownId);
      expect(buyResult, isFalse);
      expect(iapService.isLoading, isFalse);
      expect(iapService.errorMessage, contains('Unknown product'));

      // If an unknown product ID somehow arrives from purchaseStream
      final initialCP = saveService.player.cyberPoints.value;
      final fakePurchase = createTestPurchaseDetails(
        transactionId: 'tx_unknown_1',
        productId: unknownId,
        status: PurchaseStatus.purchased,
      );

      await iapService.handlePurchaseUpdatesForTesting([fakePurchase]);

      // CP must NOT increase
      expect(saveService.player.cyberPoints.value, initialCP);
      expect(saveService.isTransactionDelivered('tx_unknown_1'), isFalse);
    });

    test(
      '5. Duplicate transaction protection: Same transaction never grants CP twice',
      () async {
        await iapService.init(saveService);
        final initialCP = saveService.player.cyberPoints.value; // 1000

        final purchase = createTestPurchaseDetails(
          transactionId: 'GPA.1234-5678-9012-34567',
          productId: IAPService.idCP1000,
          status: PurchaseStatus.purchased,
        );

        // First delivery: grants 5000 CP
        await iapService.handlePurchaseUpdatesForTesting([purchase]);
        expect(saveService.player.cyberPoints.value, initialCP + 5000);
        expect(
          saveService.isTransactionDelivered('GPA.1234-5678-9012-34567'),
          isTrue,
        );

        // Duplicate callback with same transaction ID
        await iapService.handlePurchaseUpdatesForTesting([purchase]);

        // Balance must NOT increase again
        expect(saveService.player.cyberPoints.value, initialCP + 5000);
      },
    );

    test(
      '6. Different purchases of the same product CAN each grant CP (consumable)',
      () async {
        await iapService.init(saveService);
        final initialCP = saveService.player.cyberPoints.value; // 1000

        // Purchase A: cp_1000 (+5000 CP)
        final purchaseA = createTestPurchaseDetails(
          transactionId: 'GPA.1111-2222-3333-00001',
          productId: IAPService.idCP1000,
          status: PurchaseStatus.purchased,
        );
        await iapService.handlePurchaseUpdatesForTesting([purchaseA]);
        expect(saveService.player.cyberPoints.value, initialCP + 5000);

        // Purchase B: cp_1000 (+5000 CP) with distinct transaction ID
        final purchaseB = createTestPurchaseDetails(
          transactionId: 'GPA.1111-2222-3333-00002',
          productId: IAPService.idCP1000,
          status: PurchaseStatus.purchased,
        );
        await iapService.handlePurchaseUpdatesForTesting([purchaseB]);
        expect(saveService.player.cyberPoints.value, initialCP + 10000);

        expect(
          saveService.isTransactionDelivered('GPA.1111-2222-3333-00001'),
          isTrue,
        );
        expect(
          saveService.isTransactionDelivered('GPA.1111-2222-3333-00002'),
          isTrue,
        );
      },
    );

    test(
      '7. Purchase failure (PurchaseStatus.error) does not grant CP',
      () async {
        await iapService.init(saveService);
        final initialCP = saveService.player.cyberPoints.value;

        final failedPurchase = createTestPurchaseDetails(
          transactionId: 'tx_failed_1',
          productId: IAPService.idCP5000,
          status: PurchaseStatus.error,
          error: IAPError(
            source: 'google_play',
            code: 'billing_error',
            message: 'Payment declined',
          ),
        );

        await iapService.handlePurchaseUpdatesForTesting([failedPurchase]);

        expect(saveService.player.cyberPoints.value, initialCP);
        expect(iapService.isLoading, isFalse);
        expect(iapService.errorMessage, contains('Payment declined'));
        expect(saveService.isTransactionDelivered('tx_failed_1'), isFalse);
      },
    );

    test(
      '8. Purchase cancellation (PurchaseStatus.canceled) does not grant CP',
      () async {
        await iapService.init(saveService);
        final initialCP = saveService.player.cyberPoints.value;

        final canceledPurchase = createTestPurchaseDetails(
          transactionId: 'tx_canceled_1',
          productId: IAPService.idCP10000,
          status: PurchaseStatus.canceled,
        );

        await iapService.handlePurchaseUpdatesForTesting([canceledPurchase]);

        expect(saveService.player.cyberPoints.value, initialCP);
        expect(iapService.isLoading, isFalse);
        expect(iapService.errorMessage, contains('cancelled'));
        expect(saveService.isTransactionDelivered('tx_canceled_1'), isFalse);
      },
    );

    test(
      '9. Loading state resets after buyCP initiation failure / exception',
      () async {
        await iapService.init(saveService);

        // A: buyConsumable returns false
        fakeIAP.buyConsumableResult = false;
        final resultFalse = await iapService.buyCP(IAPService.idCP1000);
        expect(resultFalse, isFalse);
        expect(iapService.isLoading, isFalse);
        expect(iapService.errorMessage, isNotNull);

        // B: buyConsumable throws exception
        fakeIAP.shouldThrowOnBuy = true;
        final resultThrow = await iapService.buyCP(IAPService.idCP1000);
        expect(resultThrow, isFalse);
        expect(iapService.isLoading, isFalse);
        expect(iapService.errorMessage, contains('Could not start purchase'));
      },
    );

    test(
      '10. Localized ProductDetails price is preferred over fallback price',
      () async {
        // Fallback price when no ProductDetails loaded
        expect(iapService.getPrice(IAPService.idCP1000), '\$0.99');

        // Set localized Google Play price (e.g. INR price from Google Play)
        iapService.setProductForTesting(
          ProductDetails(
            id: IAPService.idCP1000,
            title: 'Starter Pack',
            description: '5,000 CP',
            price: '₹89.00',
            rawPrice: 89.0,
            currencyCode: 'INR',
          ),
        );

        // When ProductDetails is present, localized price must be returned
        expect(iapService.getPrice(IAPService.idCP1000), '₹89.00');
      },
    );

    test(
      '11. Restored consumable purchase (PurchaseStatus.restored) does NOT grant CP',
      () async {
        await iapService.init(saveService);
        final initialCP = saveService.player.cyberPoints.value;

        final restoredPurchase = createTestPurchaseDetails(
          transactionId: 'GPA.RESTORED-12345',
          productId: IAPService.idCP1000,
          status: PurchaseStatus.restored,
        );

        await iapService.handlePurchaseUpdatesForTesting([restoredPurchase]);

        // Consumables must NEVER grant CP on restore
        expect(saveService.player.cyberPoints.value, initialCP);
        expect(iapService.isLoading, isFalse);
        expect(
          saveService.isTransactionDelivered('GPA.RESTORED-12345'),
          isFalse,
        );
        // But pending complete purchase should be acknowledged to clear the queue
        expect(fakeIAP.completedPurchases.contains(restoredPurchase), isTrue);
      },
    );

    test(
      '12. SaveService persistence: delivered transactions persist and reload',
      () async {
        expect(saveService.isTransactionDelivered('TX_PERSIST_TEST'), isFalse);

        saveService.recordDeliveredTransaction('TX_PERSIST_TEST');
        expect(saveService.isTransactionDelivered('TX_PERSIST_TEST'), isTrue);

        // Verify serialization in PlayerData
        final json = saveService.player.toJson();
        expect(json['deliveredTransactionIds'], contains('TX_PERSIST_TEST'));

        // Verify deserialization
        final newPlayer = PlayerData();
        newPlayer.loadJson(json);
        expect(
          newPlayer.deliveredTransactionIds.contains('TX_PERSIST_TEST'),
          isTrue,
        );
      },
    );
  });
}
