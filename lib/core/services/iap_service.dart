import 'dart:async';
import 'package:flutter/foundation.dart';
import 'package:in_app_purchase/in_app_purchase.dart';
import '../storage/save_service.dart';

/// In-App Purchase Service for Cyber Ninja Runner.
/// Manages consumable Cyber Point (CP) recharge purchases via Google Play Billing.
class IAPService extends ChangeNotifier {
  static final IAPService _instance = IAPService._internal();
  factory IAPService() => _instance;
  IAPService._internal();

  final InAppPurchase _iap = InAppPurchase.instance;
  StreamSubscription<List<PurchaseDetails>>? _subscription;

  // Google Play Console Consumable Product IDs
  static const String idCP1000 = 'cp_1000';
  static const String idCP5000 = 'cp_5000';
  static const String idCP10000 = 'cp_10000';

  static const Set<String> kProductIds = {idCP1000, idCP5000, idCP10000};

  static const Map<String, int> kCPAmounts = {
    idCP1000: 1000,
    idCP5000: 5000,
    idCP10000: 10000,
    // Backward compatibility aliases if needed
    'cp_500': 1000,
    'cp_2000': 5000,
  };

  static const Map<String, String> kFallbackPrices = {
    idCP1000: '\$0.99',
    idCP5000: '\$2.99',
    idCP10000: '\$5.99',
    'cp_500': '\$0.99',
    'cp_2000': '\$2.99',
  };

  SaveService? _saveService;
  bool _isAvailable = false;
  bool _isLoading = false;
  String? _errorMessage;
  String? _successMessage;

  final Map<String, ProductDetails> _products = {};

  bool get isAvailable => _isAvailable;
  bool get isLoading => _isLoading;
  String? get errorMessage => _errorMessage;
  String? get successMessage => _successMessage;
  Map<String, ProductDetails> get products => _products;

  /// Initialize the In-App Purchase service with reference to SaveService
  Future<void> init(SaveService saveService) async {
    _saveService = saveService;

    // Listen to incoming purchases from Google Play
    _subscription = _iap.purchaseStream.listen(
      _onPurchaseUpdates,
      onDone: () => _subscription?.cancel(),
      onError: (error) {
        debugPrint('[IAP] Purchase stream error: $error');
        _errorMessage = 'Purchase stream error: $error';
        notifyListeners();
      },
    );

    await checkAvailabilityAndLoadProducts();
  }

  /// Checks if Google Play Billing is available and queries products
  Future<void> checkAvailabilityAndLoadProducts() async {
    try {
      _isAvailable = await _iap.isAvailable();
      if (!_isAvailable) {
        debugPrint(
          '[IAP] Google Play Billing is NOT available on this device/environment.',
        );
        notifyListeners();
        return;
      }

      final ProductDetailsResponse response = await _iap.queryProductDetails(
        kProductIds,
      );

      if (response.error != null) {
        debugPrint('[IAP] Query products error: ${response.error!.message}');
        _errorMessage = response.error!.message;
      }

      for (final product in response.productDetails) {
        _products[product.id] = product;
        debugPrint('[IAP] Loaded product: ${product.id} -> ${product.price}');
      }

      if (response.notFoundIDs.isNotEmpty) {
        debugPrint(
          '[IAP] Products not found in Play Console yet: ${response.notFoundIDs}',
        );
      }
    } catch (e) {
      debugPrint('[IAP] Initialization exception: $e');
      _errorMessage = e.toString();
    } finally {
      notifyListeners();
    }
  }

  /// Gets localized price string from Google Play (e.g. "₹89.00" or "$0.99") or fallback tag
  String getPrice(String productId) {
    final product = _products[productId];
    if (product != null && product.price.isNotEmpty) {
      return product.price;
    }
    return kFallbackPrices[productId] ?? '\$0.99';
  }

  /// Triggers the Google Play purchase sheet for a CP product
  Future<bool> buyCP(String productId) async {
    _errorMessage = null;
    _successMessage = null;

    if (!_isAvailable) {
      // In development / emulator where Google Play services are absent
      _errorMessage = 'Google Play Store unavailable on this device.';
      notifyListeners();
      return false;
    }

    final product = _products[productId];
    if (product == null) {
      _errorMessage =
          'Product $productId not yet active on Google Play Console.';
      notifyListeners();
      return false;
    }

    _isLoading = true;
    notifyListeners();

    try {
      final PurchaseParam purchaseParam = PurchaseParam(
        productDetails: product,
      );
      // Digital CP coins are consumable: players can buy them multiple times
      final success = await _iap.buyConsumable(
        purchaseParam: purchaseParam,
        autoConsume: true,
      );
      return success;
    } catch (e) {
      debugPrint('[IAP] Buy exception: $e');
      _errorMessage = 'Could not start purchase: $e';
      _isLoading = false;
      notifyListeners();
      return false;
    }
  }

  /// Handles purchase status changes from Google Play
  Future<void> _onPurchaseUpdates(
    List<PurchaseDetails> purchaseDetailsList,
  ) async {
    for (final purchaseDetails in purchaseDetailsList) {
      debugPrint(
        '[IAP] Update for ${purchaseDetails.productID}: status=${purchaseDetails.status}',
      );

      switch (purchaseDetails.status) {
        case PurchaseStatus.pending:
          _isLoading = true;
          _errorMessage = null;
          notifyListeners();
          break;

        case PurchaseStatus.purchased:
        case PurchaseStatus.restored:
          await _deliverProduct(purchaseDetails);
          break;

        case PurchaseStatus.error:
          _isLoading = false;
          _errorMessage = purchaseDetails.error?.message ?? 'Purchase failed';
          debugPrint('[IAP] Purchase error: $_errorMessage');
          if (purchaseDetails.pendingCompletePurchase) {
            await _iap.completePurchase(purchaseDetails);
          }
          notifyListeners();
          break;

        case PurchaseStatus.canceled:
          _isLoading = false;
          _errorMessage = 'Purchase cancelled.';
          if (purchaseDetails.pendingCompletePurchase) {
            await _iap.completePurchase(purchaseDetails);
          }
          notifyListeners();
          break;
      }
    }
  }

  /// Delivers the purchased Cyber Points to the player and consumes the item on Google Play
  Future<void> _deliverProduct(PurchaseDetails purchaseDetails) async {
    final productId = purchaseDetails.productID;
    final cpAmount = kCPAmounts[productId];

    if (cpAmount != null && _saveService != null) {
      // 1. Credit the CP coins to the player's vault
      _saveService!.addCyberPoints(cpAmount);
      _successMessage = '+$cpAmount Cyber Points (CP) added to Vault!';
      debugPrint('[IAP] Successfully credited $cpAmount CP to player.');
    }

    // 2. Acknowledge and consume the purchase on Google Play
    // Crucial: Google refunds the user if purchases are not completed within 3 days!
    if (purchaseDetails.pendingCompletePurchase) {
      try {
        await _iap.completePurchase(purchaseDetails);
        debugPrint('[IAP] Completed and consumed purchase for $productId');
      } catch (e) {
        debugPrint('[IAP] Error completing purchase: $e');
      }
    }

    _isLoading = false;
    notifyListeners();
  }

  void clearMessages() {
    _errorMessage = null;
    _successMessage = null;
    notifyListeners();
  }

  @override
  void dispose() {
    _subscription?.cancel();
    super.dispose();
  }
}
