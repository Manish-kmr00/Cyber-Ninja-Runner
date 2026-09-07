package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.n8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4310n8 extends MessageNano {
    public static volatile C4310n8[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f11682a;
    public byte[] b;
    public C4409r8 c;
    public C4335o8[] d;
    public int e;

    public C4310n8() {
        a();
    }

    public static C4310n8[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C4310n8[0];
                }
            }
        }
        return f;
    }

    public final C4310n8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f11682a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = C4335o8.b();
        this.e = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f11682a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f11682a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C4409r8 c4409r8 = this.c;
        if (c4409r8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c4409r8);
        }
        C4335o8[] c4335o8Arr = this.d;
        if (c4335o8Arr != null && c4335o8Arr.length > 0) {
            int i = 0;
            while (true) {
                C4335o8[] c4335o8Arr2 = this.d;
                if (i >= c4335o8Arr2.length) {
                    break;
                }
                C4335o8 c4335o8 = c4335o8Arr2[i];
                if (c4335o8 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c4335o8);
                }
                i++;
            }
        }
        int i2 = this.e;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i2) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f11682a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f11682a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C4409r8 c4409r8 = this.c;
        if (c4409r8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c4409r8);
        }
        C4335o8[] c4335o8Arr = this.d;
        if (c4335o8Arr != null && c4335o8Arr.length > 0) {
            int i = 0;
            while (true) {
                C4335o8[] c4335o8Arr2 = this.d;
                if (i >= c4335o8Arr2.length) {
                    break;
                }
                C4335o8 c4335o8 = c4335o8Arr2[i];
                if (c4335o8 != null) {
                    codedOutputByteBufferNano.writeMessage(4, c4335o8);
                }
                i++;
            }
        }
        int i2 = this.e;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4310n8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.f11682a = codedInputByteBufferNano.readBytes();
            } else if (tag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C4409r8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                C4335o8[] c4335o8Arr = this.d;
                int length = c4335o8Arr == null ? 0 : c4335o8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C4335o8[] c4335o8Arr2 = new C4335o8[i];
                if (length != 0) {
                    System.arraycopy(c4335o8Arr, 0, c4335o8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C4335o8 c4335o8 = new C4335o8();
                    c4335o8Arr2[length] = c4335o8;
                    codedInputByteBufferNano.readMessage(c4335o8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4335o8 c4335o9 = new C4335o8();
                c4335o8Arr2[length] = c4335o9;
                codedInputByteBufferNano.readMessage(c4335o9);
                this.d = c4335o8Arr2;
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.e = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static C4310n8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4310n8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4310n8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4310n8) MessageNano.mergeFrom(new C4310n8(), bArr);
    }
}
