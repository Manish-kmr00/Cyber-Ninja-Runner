import 'package:flutter/foundation.dart';
import 'package:mmkv/mmkv.dart';

/// Clean shared counter abstraction backed by Tencent MMKV key-value storage.
///
/// Manages session and daily frequency counters under the 'monetization.*' namespace.
class SharedCounterService {
  static final SharedCounterService _instance =
      SharedCounterService._internal();
  factory SharedCounterService() => _instance;
  SharedCounterService._internal();

  MMKV? _mmkv;
  bool _isInitialized = false;
  final Map<String, int> _memoryFallback = {};
  String _currentDayKey = '';

  /// Initializes the MMKV storage engine with root directory.
  Future<void> init() async {
    if (_isInitialized) return;

    try {
      // Initialize MMKV native storage engine
      final rootDir = await MMKV.initialize();
      _mmkv = MMKV('monetization_storage');
      _isInitialized = true;
      _updateDayKey();
      debugPrint('[SharedCounterService] MMKV initialized at: $rootDir');
    } catch (e) {
      debugPrint(
        '[SharedCounterService] MMKV init warning (using in-memory fallback): $e',
      );
      _isInitialized = true; // Fallback ready
      _updateDayKey();
    }
  }

  void _updateDayKey() {
    final now = DateTime.now();
    _currentDayKey = '${now.year}-${now.month}-${now.day}';
    final savedDay = getString('monetization.last_recorded_day');
    if (savedDay != _currentDayKey) {
      // Day rollover: reset daily counters
      debugPrint(
        '[SharedCounterService] Day rollover detected ($savedDay -> $_currentDayKey). Resetting daily counters.',
      );
      reset('monetization.daily_interstitial_count');
      reset('monetization.daily_rewarded_count');
      setString('monetization.last_recorded_day', _currentDayKey);
    }
  }

  /// Increments counter by [delta] and returns the new value.
  int increment(String key, {int delta = 1}) {
    _updateDayKey();
    final current = get(key);
    final updated = current + delta;
    set(key, updated);
    return updated;
  }

  /// Gets counter value.
  int get(String key) {
    if (_mmkv != null) {
      try {
        return _mmkv!.decodeInt(key);
      } catch (_) {}
    }
    return _memoryFallback[key] ?? 0;
  }

  /// Sets counter to [value].
  void set(String key, int value) {
    if (_mmkv != null) {
      try {
        _mmkv!.encodeInt(key, value);
        return;
      } catch (_) {}
    }
    _memoryFallback[key] = value;
  }

  /// Resets counter to 0.
  void reset(String key) {
    set(key, 0);
  }

  /// Atomically increments the counter only if current < maxCap.
  /// Returns true if incremented, false if cap was reached.
  bool incrementIfAllowed(String key, int maxCap) {
    _updateDayKey();
    final current = get(key);
    if (current >= maxCap) {
      return false;
    }
    set(key, current + 1);
    return true;
  }

  // --- String / Timestamp storage helpers for monetization ---

  void setString(String key, String value) {
    if (_mmkv != null) {
      try {
        _mmkv!.encodeString(key, value);
        return;
      } catch (_) {}
    }
    _memoryFallbackStrings[key] = value;
  }

  String? getString(String key) {
    if (_mmkv != null) {
      try {
        final val = _mmkv!.decodeString(key);
        if (val != null && val.isNotEmpty) return val;
      } catch (_) {}
    }
    return _memoryFallbackStrings[key];
  }

  final Map<String, String> _memoryFallbackStrings = {};
}
