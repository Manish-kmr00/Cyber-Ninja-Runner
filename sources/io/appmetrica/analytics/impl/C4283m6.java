package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.m6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4283m6 extends MessageNano {
    public static volatile C4283m6[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11665a;
    public String b;
    public C4233k6[] c;
    public C4283m6 d;
    public C4283m6[] e;

    public C4283m6() {
        a();
    }

    public static C4283m6[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C4283m6[0];
                }
            }
        }
        return f;
    }

    public final C4283m6 a() {
        this.f11665a = "";
        this.b = "";
        this.c = C4233k6.b();
        this.d = null;
        this.e = b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeStringSize = CodedOutputByteBufferNano.computeStringSize(1, this.f11665a) + super.computeSerializedSize();
        if (!this.b.equals("")) {
            iComputeStringSize += CodedOutputByteBufferNano.computeStringSize(2, this.b);
        }
        C4233k6[] c4233k6Arr = this.c;
        int i = 0;
        if (c4233k6Arr != null && c4233k6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C4233k6[] c4233k6Arr2 = this.c;
                if (i2 >= c4233k6Arr2.length) {
                    break;
                }
                C4233k6 c4233k6 = c4233k6Arr2[i2];
                if (c4233k6 != null) {
                    iComputeStringSize += CodedOutputByteBufferNano.computeMessageSize(3, c4233k6);
                }
                i2++;
            }
        }
        C4283m6 c4283m6 = this.d;
        if (c4283m6 != null) {
            iComputeStringSize += CodedOutputByteBufferNano.computeMessageSize(4, c4283m6);
        }
        C4283m6[] c4283m6Arr = this.e;
        if (c4283m6Arr != null && c4283m6Arr.length > 0) {
            while (true) {
                C4283m6[] c4283m6Arr2 = this.e;
                if (i >= c4283m6Arr2.length) {
                    break;
                }
                C4283m6 c4283m7 = c4283m6Arr2[i];
                if (c4283m7 != null) {
                    iComputeStringSize += CodedOutputByteBufferNano.computeMessageSize(5, c4283m7);
                }
                i++;
            }
        }
        return iComputeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f11665a);
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.b);
        }
        C4233k6[] c4233k6Arr = this.c;
        int i = 0;
        if (c4233k6Arr != null && c4233k6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C4233k6[] c4233k6Arr2 = this.c;
                if (i2 >= c4233k6Arr2.length) {
                    break;
                }
                C4233k6 c4233k6 = c4233k6Arr2[i2];
                if (c4233k6 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c4233k6);
                }
                i2++;
            }
        }
        C4283m6 c4283m6 = this.d;
        if (c4283m6 != null) {
            codedOutputByteBufferNano.writeMessage(4, c4283m6);
        }
        C4283m6[] c4283m6Arr = this.e;
        if (c4283m6Arr != null && c4283m6Arr.length > 0) {
            while (true) {
                C4283m6[] c4283m6Arr2 = this.e;
                if (i >= c4283m6Arr2.length) {
                    break;
                }
                C4283m6 c4283m7 = c4283m6Arr2[i];
                if (c4283m7 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c4283m7);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4283m6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.f11665a = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C4233k6[] c4233k6Arr = this.c;
                int length = c4233k6Arr == null ? 0 : c4233k6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C4233k6[] c4233k6Arr2 = new C4233k6[i];
                if (length != 0) {
                    System.arraycopy(c4233k6Arr, 0, c4233k6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C4233k6 c4233k6 = new C4233k6();
                    c4233k6Arr2[length] = c4233k6;
                    codedInputByteBufferNano.readMessage(c4233k6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4233k6 c4233k7 = new C4233k6();
                c4233k6Arr2[length] = c4233k7;
                codedInputByteBufferNano.readMessage(c4233k7);
                this.c = c4233k6Arr2;
            } else if (tag == 34) {
                if (this.d == null) {
                    this.d = new C4283m6();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                C4283m6[] c4283m6Arr = this.e;
                int length2 = c4283m6Arr == null ? 0 : c4283m6Arr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                C4283m6[] c4283m6Arr2 = new C4283m6[i2];
                if (length2 != 0) {
                    System.arraycopy(c4283m6Arr, 0, c4283m6Arr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    C4283m6 c4283m6 = new C4283m6();
                    c4283m6Arr2[length2] = c4283m6;
                    codedInputByteBufferNano.readMessage(c4283m6);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C4283m6 c4283m7 = new C4283m6();
                c4283m6Arr2[length2] = c4283m7;
                codedInputByteBufferNano.readMessage(c4283m7);
                this.e = c4283m6Arr2;
            }
        }
    }

    public static C4283m6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4283m6().mergeFrom(codedInputByteBufferNano);
    }

    public static C4283m6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4283m6) MessageNano.mergeFrom(new C4283m6(), bArr);
    }
}
