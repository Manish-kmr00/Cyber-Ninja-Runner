import 'dart:math';
import 'dart:typed_data';

/// In-memory anti-tamper wrapper for integer values using dynamic XOR masking.
class SafeInt {
  int _maskedValue = 0;
  int _maskKey = 0;
  int _checksum = 0;

  SafeInt([int initialValue = 0]) {
    value = initialValue;
  }

  int get value {
    final computed = _maskedValue ^ _maskKey;
    if ((computed.hashCode ^ _maskKey) != _checksum) {
      // Memory tampering detected; return zero / fallback
      return 0;
    }
    return computed;
  }

  set value(int newValue) {
    _maskKey = Random().nextInt(0x7FFFFFFF);
    _maskedValue = newValue ^ _maskKey;
    _checksum = newValue.hashCode ^ _maskKey;
  }

  void add(int delta) {
    value = value + delta;
  }

  void subtract(int delta) {
    value = max(0, value - delta);
  }

  @override
  String toString() => value.toString();
}

/// In-memory anti-tamper wrapper for floating point values using IEEE 754 bit masking.
class SafeFloat {
  late SafeInt _internalBits;

  SafeFloat([double initialValue = 0.0]) {
    _internalBits = SafeInt();
    value = initialValue;
  }

  double get value {
    final bits = _internalBits.value;
    final buffer = ByteData(8)..setInt64(0, bits);
    return buffer.getFloat64(0);
  }

  set value(double newValue) {
    final buffer = ByteData(8)..setFloat64(0, newValue);
    _internalBits.value = buffer.getInt64(0);
  }

  @override
  String toString() => value.toString();
}
