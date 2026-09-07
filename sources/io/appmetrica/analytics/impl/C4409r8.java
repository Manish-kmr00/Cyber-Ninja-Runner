package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.r8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4409r8 extends MessageNano {
    public static volatile C4409r8[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4385q8[] f11746a;
    public int b;

    public C4409r8() {
        a();
    }

    public static C4409r8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C4409r8[0];
                }
            }
        }
        return c;
    }

    public final C4409r8 a() {
        this.f11746a = C4385q8.b();
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4385q8[] c4385q8Arr = this.f11746a;
        if (c4385q8Arr != null && c4385q8Arr.length > 0) {
            int i = 0;
            while (true) {
                C4385q8[] c4385q8Arr2 = this.f11746a;
                if (i >= c4385q8Arr2.length) {
                    break;
                }
                C4385q8 c4385q8 = c4385q8Arr2[i];
                if (c4385q8 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c4385q8);
                }
                i++;
            }
        }
        int i2 = this.b;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4385q8[] c4385q8Arr = this.f11746a;
        if (c4385q8Arr != null && c4385q8Arr.length > 0) {
            int i = 0;
            while (true) {
                C4385q8[] c4385q8Arr2 = this.f11746a;
                if (i >= c4385q8Arr2.length) {
                    break;
                }
                C4385q8 c4385q8 = c4385q8Arr2[i];
                if (c4385q8 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c4385q8);
                }
                i++;
            }
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4409r8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C4385q8[] c4385q8Arr = this.f11746a;
                int length = c4385q8Arr == null ? 0 : c4385q8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C4385q8[] c4385q8Arr2 = new C4385q8[i];
                if (length != 0) {
                    System.arraycopy(c4385q8Arr, 0, c4385q8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C4385q8 c4385q8 = new C4385q8();
                    c4385q8Arr2[length] = c4385q8;
                    codedInputByteBufferNano.readMessage(c4385q8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4385q8 c4385q9 = new C4385q8();
                c4385q8Arr2[length] = c4385q9;
                codedInputByteBufferNano.readMessage(c4385q9);
                this.f11746a = c4385q8Arr2;
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.b = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static C4409r8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4409r8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4409r8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4409r8) MessageNano.mergeFrom(new C4409r8(), bArr);
    }
}
