package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class Q3 extends MessageNano {
    public static volatile Q3[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P3[] f11305a;

    public Q3() {
        a();
    }

    public static Q3[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Q3[0];
                }
            }
        }
        return b;
    }

    public final Q3 a() {
        this.f11305a = P3.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        P3[] p3Arr = this.f11305a;
        if (p3Arr != null && p3Arr.length > 0) {
            int i = 0;
            while (true) {
                P3[] p3Arr2 = this.f11305a;
                if (i >= p3Arr2.length) {
                    break;
                }
                P3 p3 = p3Arr2[i];
                if (p3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, p3);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        P3[] p3Arr = this.f11305a;
        if (p3Arr != null && p3Arr.length > 0) {
            int i = 0;
            while (true) {
                P3[] p3Arr2 = this.f11305a;
                if (i >= p3Arr2.length) {
                    break;
                }
                P3 p3 = p3Arr2[i];
                if (p3 != null) {
                    codedOutputByteBufferNano.writeMessage(1, p3);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Q3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                P3[] p3Arr = this.f11305a;
                int length = p3Arr == null ? 0 : p3Arr.length;
                int i = repeatedFieldArrayLength + length;
                P3[] p3Arr2 = new P3[i];
                if (length != 0) {
                    System.arraycopy(p3Arr, 0, p3Arr2, 0, length);
                }
                while (length < i - 1) {
                    P3 p3 = new P3();
                    p3Arr2[length] = p3;
                    codedInputByteBufferNano.readMessage(p3);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                P3 p4 = new P3();
                p3Arr2[length] = p4;
                codedInputByteBufferNano.readMessage(p4);
                this.f11305a = p3Arr2;
            }
        }
    }

    public static Q3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Q3().mergeFrom(codedInputByteBufferNano);
    }

    public static Q3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Q3) MessageNano.mergeFrom(new Q3(), bArr);
    }
}
