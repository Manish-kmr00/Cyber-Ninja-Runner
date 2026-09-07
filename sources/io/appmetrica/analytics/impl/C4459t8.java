package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.t8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4459t8 extends MessageNano {
    public static volatile C4459t8[] h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f11777a;
    public byte[] b;
    public C4260l8 c;
    public C4409r8 d;
    public C4434s8 e;
    public C4434s8 f;
    public C4484u8[] g;

    public C4459t8() {
        a();
    }

    public static C4459t8[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new C4459t8[0];
                }
            }
        }
        return h;
    }

    public final C4459t8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f11777a = bArr;
        this.b = bArr;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = C4484u8.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f11777a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f11777a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.b);
        }
        C4260l8 c4260l8 = this.c;
        if (c4260l8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c4260l8);
        }
        C4409r8 c4409r8 = this.d;
        if (c4409r8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c4409r8);
        }
        C4434s8 c4434s8 = this.e;
        if (c4434s8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c4434s8);
        }
        C4434s8 c4434s9 = this.f;
        if (c4434s9 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, c4434s9);
        }
        C4484u8[] c4484u8Arr = this.g;
        if (c4484u8Arr != null && c4484u8Arr.length > 0) {
            int i = 0;
            while (true) {
                C4484u8[] c4484u8Arr2 = this.g;
                if (i >= c4484u8Arr2.length) {
                    break;
                }
                C4484u8 c4484u8 = c4484u8Arr2[i];
                if (c4484u8 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, c4484u8);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f11777a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f11777a);
        }
        if (!Arrays.equals(this.b, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.b);
        }
        C4260l8 c4260l8 = this.c;
        if (c4260l8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c4260l8);
        }
        C4409r8 c4409r8 = this.d;
        if (c4409r8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c4409r8);
        }
        C4434s8 c4434s8 = this.e;
        if (c4434s8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c4434s8);
        }
        C4434s8 c4434s9 = this.f;
        if (c4434s9 != null) {
            codedOutputByteBufferNano.writeMessage(6, c4434s9);
        }
        C4484u8[] c4484u8Arr = this.g;
        if (c4484u8Arr != null && c4484u8Arr.length > 0) {
            int i = 0;
            while (true) {
                C4484u8[] c4484u8Arr2 = this.g;
                if (i >= c4484u8Arr2.length) {
                    break;
                }
                C4484u8 c4484u8 = c4484u8Arr2[i];
                if (c4484u8 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c4484u8);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4459t8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.f11777a = codedInputByteBufferNano.readBytes();
            } else if (tag == 18) {
                this.b = codedInputByteBufferNano.readBytes();
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C4260l8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag == 34) {
                if (this.d == null) {
                    this.d = new C4409r8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (tag == 42) {
                if (this.e == null) {
                    this.e = new C4434s8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (tag == 50) {
                if (this.f == null) {
                    this.f = new C4434s8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C4484u8[] c4484u8Arr = this.g;
                int length = c4484u8Arr == null ? 0 : c4484u8Arr.length;
                int i = repeatedFieldArrayLength + length;
                C4484u8[] c4484u8Arr2 = new C4484u8[i];
                if (length != 0) {
                    System.arraycopy(c4484u8Arr, 0, c4484u8Arr2, 0, length);
                }
                while (length < i - 1) {
                    C4484u8 c4484u8 = new C4484u8();
                    c4484u8Arr2[length] = c4484u8;
                    codedInputByteBufferNano.readMessage(c4484u8);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4484u8 c4484u9 = new C4484u8();
                c4484u8Arr2[length] = c4484u9;
                codedInputByteBufferNano.readMessage(c4484u9);
                this.g = c4484u8Arr2;
            }
        }
    }

    public static C4459t8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4459t8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4459t8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4459t8) MessageNano.mergeFrom(new C4459t8(), bArr);
    }
}
