package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.s8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4434s8 extends MessageNano {
    public static volatile C4434s8[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4186i8 f11761a;
    public C4186i8[] b;

    public C4434s8() {
        a();
    }

    public static C4434s8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C4434s8[0];
                }
            }
        }
        return c;
    }

    public final C4434s8 a() {
        this.f11761a = null;
        this.b = C4186i8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4186i8 c4186i8 = this.f11761a;
        if (c4186i8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c4186i8);
        }
        C4186i8[] c4186i8Arr = this.b;
        if (c4186i8Arr != null && c4186i8Arr.length > 0) {
            int i = 0;
            while (true) {
                C4186i8[] c4186i8Arr2 = this.b;
                if (i >= c4186i8Arr2.length) {
                    break;
                }
                C4186i8 c4186i9 = c4186i8Arr2[i];
                if (c4186i9 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4186i9);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4186i8 c4186i8 = this.f11761a;
        if (c4186i8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c4186i8);
        }
        C4186i8[] c4186i8Arr = this.b;
        if (c4186i8Arr != null && c4186i8Arr.length > 0) {
            int i = 0;
            while (true) {
                C4186i8[] c4186i8Arr2 = this.b;
                if (i >= c4186i8Arr2.length) {
                    break;
                }
                C4186i8 c4186i9 = c4186i8Arr2[i];
                if (c4186i9 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c4186i9);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4434s8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.f11761a == null) {
                    this.f11761a = new C4186i8();
                }
                codedInputByteBufferNano.readMessage(this.f11761a);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C4186i8[] c4186i8Arr = this.b;
                int length = c4186i8Arr == null ? 0 : c4186i8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C4186i8[] c4186i8Arr2 = new C4186i8[i];
                if (length != 0) {
                    System.arraycopy(c4186i8Arr, 0, c4186i8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C4186i8 c4186i8 = new C4186i8();
                    c4186i8Arr2[length] = c4186i8;
                    codedInputByteBufferNano.readMessage(c4186i8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4186i8 c4186i9 = new C4186i8();
                c4186i8Arr2[length] = c4186i9;
                codedInputByteBufferNano.readMessage(c4186i9);
                this.b = c4186i8Arr2;
            }
        }
    }

    public static C4434s8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4434s8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4434s8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4434s8) MessageNano.mergeFrom(new C4434s8(), bArr);
    }
}
