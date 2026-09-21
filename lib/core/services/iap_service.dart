import 'dart:async';
import 'package:flutter/foundation.dart';
import 'package:in_app_purchase/in_app_purchase.dart';
import 'package:in_app_purchase_android/in_app_purchase_android.dart';
import '../storage/save_service.dart';

/// In-App Purchase Service for Cyber Ninja Runner.
/// Manages consumable Cyber Point (CP) recharge purchases via Google Play Billing.
class IAPService extends ChangeNotifier {
  static final IAPService _instance = IAPService._internal();
  factory IAPService() => _instance;
  IAPService._internal();

  static const String kPackageName = 'com.moonedgestudio.cyberninjarunner';

  InAppPurchase? _customIap;
  InAppPurchase get _iap => _customIap ?? InAppPurchase.instance;
  StreamSubscription<List<PurchaseDetails>>? _subscription;

  /// Injection hook for automated unit tests
  @visibleForTesting
  set iapInstance(InAppPurchase instance) => _customIap = instance;

  // Google Play Console Consumable Product IDs — Exactly three active products
  static const String idCP1000 = 'cp_1000'; // Starter Pack: 5,000 CP ($0.99)
  static const String idCP5000 = 'cp_5000'; // Operative Pack: 10,000 CP ($2.99)
  static const String idCP10000 =
      'cp_10000'; // Cyber Overlord: 20,000 CP ($5.99)

  /// The only official and active Google Play CP product IDs
  static const Set<String> kProductIds = {idCP1000, idCP5000, idCP10000};

  /// Authoritative CP reward mapping: Product ID -> Cyber Points
  static const Map<String, int> kCPAmounts = {
    idCP1000: 5000, // Starter Pack
    idCP5000: 10000, // Operative Pack
    idCP10000: 20000, // Cyber Overlord
  };

  /// Isolated strictly for development UI display when Google Play ProductDetails
  /// are not yet loaded (e.g. running offline or in an emulator).
  /// Google Play localized price (ProductDetails.price) always takes precedence.
  static const Map<String, String> kDevelopmentFallbackPrices = {
    idCP1000: '\$0.99',
    idCP5000: '\$2.99',
    idCP10000: '\$5.99',
  };

  /// Backwards-compatible alias for development fallback prices
  static Map<String, String> get kFallbackPrices => kDevelopmentFallbackPrices;

  /// Returns the trusted CP amount for an official product ID (or 0 if unknown)
  static int getCPAmount(String productId) => kCPAmounts[productId] ?? 0;

  /// Validates whether a product ID is one of the three official active products
  static bool isValidProductId(String productId) =>
      kProductIds.contains(productId);

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

    // Cancel any previous stream subscription to prevent duplicate listeners
    await _subscription?.cancel();
    _subscription = null;

    // Listen to incoming purchases from Google Play
    _subscription = _iap.purchaseStream.listen(
      _onPurchaseUpdates,
      onDone: () => _subscription?.cancel(),
      onError: (error) {
        debugPrint('[IAP] Purchase stream error: $error');
        _errorMessage = 'Purchase stream error: $error';
        _isLoading = false;
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

  /// Gets localized price string from Google Play (e.g. "₹89.00" or "$0.99")
  /// or falls back to development placeholder if product is not yet loaded.
  String getPrice(String productId) {
    final product = _products[productId];
    if (product != null && product.price.trim().isNotEmpty) {
      return product.price;
    }
    return kDevelopmentFallbackPrices[productId] ?? '\$0.99';
  }

  /// Triggers the Google Play purchase sheet for a CP product
  Future<bool> buyCP(String productId) async {
    _errorMessage = null;
    _successMessage = null;

    // Unknown product protection
    if (!isValidProductId(productId)) {
      debugPrint(
        '[IAP] Rejected purchase attempt for unknown product ID: $productId',
      );
      _errorMessage = 'Unknown product: $productId';
      _isLoading = false;
      notifyListeners();
      return false;
    }

    if (!_isAvailable) {
      // In development / emulator where Google Play services are absent
      _errorMessage = 'Google Play Store unavailable on this device.';
      _isLoading = false;
      notifyListeners();
      return false;
    }

    final product = _products[productId];
    if (product == null) {
      _errorMessage =
          'Product $productId not yet active on Google Play Console.';
      _isLoading = false;
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
      if (!success) {
        _isLoading = false;
        _errorMessage = 'Purchase initiation failed.';
        notifyListeners();
      }
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
          await _deliverProduct(purchaseDetails);
          break;

        case PurchaseStatus.restored:
          // Consumables (CP) cannot be re-credited on restore to prevent duplicate/infinite rewards.
          debugPrint(
            '[IAP] Restored status received for consumable ${purchaseDetails.productID}. Consumables are not credited on restore.',
          );
          if (purchaseDetails.pendingCompletePurchase) {
            try {
              await _iap.completePurchase(purchaseDetails);
            } catch (e) {
              debugPrint('[IAP] Error completing restored purchase: $e');
            }
          }
          _isLoading = false;
          notifyListeners();
          break;

        case PurchaseStatus.error:
          _isLoading = false;
          _errorMessage = purchaseDetails.error?.message ?? 'Purchase failed';
          debugPrint('[IAP] Purchase error: $_errorMessage');
          if (purchaseDetails.pendingCompletePurchase) {
            try {
              await _iap.completePurchase(purchaseDetails);
            } catch (e) {
              debugPrint('[IAP] Error completing failed purchase: $e');
            }
          }
          notifyListeners();
          break;

        case PurchaseStatus.canceled:
          _isLoading = false;
          _errorMessage = 'Purchase cancelled.';
          if (purchaseDetails.pendingCompletePurchase) {
            try {
              await _iap.completePurchase(purchaseDetails);
            } catch (e) {
              debugPrint('[IAP] Error completing cancelled purchase: $e');
            }
          }
          notifyListeners();
          break;
      }
    }
  }

  /// Delivers the purchased Cyber Points to the player and consumes the item on Google Play
  /// with local purchase-token idempotency protection.
  Future<void> _deliverProduct(PurchaseDetails purchaseDetails) async {
    final productId = purchaseDetails.productID;

    // 1. Unknown product protection: unknown product IDs NEVER receive CP
    if (!isValidProductId(productId)) {
      debugPrint(
        '[IAP] Unknown or unsupported product ID received: $productId. CP will NOT be granted.',
      );
      if (purchaseDetails.pendingCompletePurchase) {
        try {
          await _iap.completePurchase(purchaseDetails);
        } catch (e) {
          debugPrint('[IAP] Error completing unsupported product purchase: $e');
        }
      }
      _isLoading = false;
      notifyListeners();
      return;
    }

    // 2. Resolve Google Play Purchase Token (FIX 1: primary idempotency key)
    final String purchaseToken = _resolvePurchaseToken(purchaseDetails);

    if (purchaseToken.isEmpty) {
      debugPrint(
        '[IAP] Missing or empty Google Play purchase token for $productId. Cannot verify purchase.',
      );
      _errorMessage = 'Purchase verification failed: missing purchase token.';
      if (purchaseDetails.pendingCompletePurchase) {
        try {
          await _iap.completePurchase(purchaseDetails);
        } catch (e) {
          debugPrint('[IAP] Error completing invalid purchase: $e');
        }
      }
      _isLoading = false;
      notifyListeners();
      return;
    }

    // 3. Local Idempotency Check: was this purchase token already processed?
    if (_saveService != null &&
        _saveService!.isPurchaseTokenProcessed(purchaseToken)) {
      debugPrint(
        '[IAP] Duplicate purchase blocked for token $purchaseToken ($productId). CP was already credited.',
      );
      if (purchaseDetails.pendingCompletePurchase) {
        try {
          await _iap.completePurchase(purchaseDetails);
        } catch (e) {
          debugPrint('[IAP] Error completing duplicate purchase: $e');
        }
      }
      _isLoading = false;
      notifyListeners();
      return;
    }

    // 4. Authoritative client-side CP entitlement strictly determined by product ID mapping
    final int cpAmount = getCPAmount(productId);
    if (cpAmount <= 0) {
      debugPrint(
        '[IAP] No CP reward mapped for product ID: $productId. Entitlement denied.',
      );
      if (purchaseDetails.pendingCompletePurchase) {
        try {
          await _iap.completePurchase(purchaseDetails);
        } catch (e) {
          debugPrint('[IAP] Error completing unmapped product purchase: $e');
        }
      }
      _isLoading = false;
      notifyListeners();
      return;
    }

    // 5. Grant CP to player vault and persist purchase token
    if (_saveService != null) {
      _saveService!.addCyberPoints(cpAmount);

      // Persist purchase token as processed (and purchaseID for backward compatibility)
      _saveService!.recordProcessedPurchaseToken(purchaseToken);
      if (purchaseDetails.purchaseID != null &&
          purchaseDetails.purchaseID!.trim().isNotEmpty) {
        _saveService!.recordProcessedPurchaseToken(
          purchaseDetails.purchaseID!.trim(),
        );
      }

      _successMessage = '+$cpAmount Cyber Points (CP) added to Vault!';
      debugPrint(
        '[IAP] Successfully credited $cpAmount CP to player (token: $purchaseToken).',
      );
    }

    // 6. Complete and consume purchase on Google Play Billing
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

  /// Resolves the authentic Google Play purchase token from PurchaseDetails.
  /// Strictly rejects orderId / purchaseID as the primary idempotency key.
  String _resolvePurchaseToken(PurchaseDetails purchaseDetails) {
    if (purchaseDetails is GooglePlayPurchaseDetails) {
      final token = purchaseDetails.billingClientPurchase.purchaseToken.trim();
      if (token.isNotEmpty) return token;
    }
    final serverData = purchaseDetails.verificationData.serverVerificationData
        .trim();
    if (serverData.isNotEmpty) {
      return serverData;
    }
    return '';
  }

  /// Exposes purchase updates handling for automated unit tests
  @visibleForTesting
  Future<void> handlePurchaseUpdatesForTesting(
    List<PurchaseDetails> purchaseDetailsList,
  ) => _onPurchaseUpdates(purchaseDetailsList);

  /// Sets loaded product details for testing
  @visibleForTesting
  void setProductForTesting(ProductDetails product) {
    _products[product.id] = product;
    _isAvailable = true;
  }

  /// Sets available state for testing
  @visibleForTesting
  void setAvailableForTesting(bool available) {
    _isAvailable = available;
  }

  /// Resets internal state for unit test isolation
  @visibleForTesting
  void resetForTesting() {
    _products.clear();
    _isAvailable = false;
    _isLoading = false;
    _errorMessage = null;
    _successMessage = null;
    _subscription?.cancel();
    _subscription = null;
    _saveService = null;
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
