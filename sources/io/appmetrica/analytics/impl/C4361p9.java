package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.p9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4361p9 extends MessageNano {
    public static final int f = -1;
    public static final int g = 0;
    public static final int h = 1;
    public static volatile C4361p9[] i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4286m9[] f11717a;
    public C4162h9 b;
    public C4087e9[] c;
    public C4311n9[] d;
    public String[] e;

    public C4361p9() {
        a();
    }

    public static C4361p9[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new C4361p9[0];
                }
            }
        }
        return i;
    }

    public final C4361p9 a() {
        this.f11717a = C4286m9.b();
        this.b = null;
        this.c = C4087e9.b();
        this.d = C4311n9.b();
        this.e = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4286m9[] c4286m9Arr = this.f11717a;
        int i2 = 0;
        if (c4286m9Arr != null && c4286m9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C4286m9[] c4286m9Arr2 = this.f11717a;
                if (i3 >= c4286m9Arr2.length) {
                    break;
                }
                C4286m9 c4286m9 = c4286m9Arr2[i3];
                if (c4286m9 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c4286m9);
                }
                i3++;
            }
        }
        C4162h9 c4162h9 = this.b;
        if (c4162h9 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c4162h9);
        }
        C4087e9[] c4087e9Arr = this.c;
        if (c4087e9Arr != null && c4087e9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C4087e9[] c4087e9Arr2 = this.c;
                if (i4 >= c4087e9Arr2.length) {
                    break;
                }
                C4087e9 c4087e9 = c4087e9Arr2[i4];
                if (c4087e9 != null) {
                    iComputeSerializedSize = CodedOutputByteBufferNano.computeMessageSize(7, c4087e9) + iComputeSerializedSize;
                }
                i4++;
            }
        }
        C4311n9[] c4311n9Arr = this.d;
        if (c4311n9Arr != null && c4311n9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C4311n9[] c4311n9Arr2 = this.d;
                if (i5 >= c4311n9Arr2.length) {
                    break;
                }
                C4311n9 c4311n9 = c4311n9Arr2[i5];
                if (c4311n9 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, c4311n9);
                }
                i5++;
            }
        }
        String[] strArr = this.e;
        if (strArr == null || strArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeStringSizeNoTag = 0;
        int i6 = 0;
        while (true) {
            String[] strArr2 = this.e;
            if (i2 >= strArr2.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag + i6;
            }
            String str = strArr2[i2];
            if (str != null) {
                i6++;
                iComputeStringSizeNoTag = CodedOutputByteBufferNano.computeStringSizeNoTag(str) + iComputeStringSizeNoTag;
            }
            i2++;
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4286m9[] c4286m9Arr = this.f11717a;
        int i2 = 0;
        if (c4286m9Arr != null && c4286m9Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C4286m9[] c4286m9Arr2 = this.f11717a;
                if (i3 >= c4286m9Arr2.length) {
                    break;
                }
                C4286m9 c4286m9 = c4286m9Arr2[i3];
                if (c4286m9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c4286m9);
                }
                i3++;
            }
        }
        C4162h9 c4162h9 = this.b;
        if (c4162h9 != null) {
            codedOutputByteBufferNano.writeMessage(4, c4162h9);
        }
        C4087e9[] c4087e9Arr = this.c;
        if (c4087e9Arr != null && c4087e9Arr.length > 0) {
            int i4 = 0;
            while (true) {
                C4087e9[] c4087e9Arr2 = this.c;
                if (i4 >= c4087e9Arr2.length) {
                    break;
                }
                C4087e9 c4087e9 = c4087e9Arr2[i4];
                if (c4087e9 != null) {
                    codedOutputByteBufferNano.writeMessage(7, c4087e9);
                }
                i4++;
            }
        }
        C4311n9[] c4311n9Arr = this.d;
        if (c4311n9Arr != null && c4311n9Arr.length > 0) {
            int i5 = 0;
            while (true) {
                C4311n9[] c4311n9Arr2 = this.d;
                if (i5 >= c4311n9Arr2.length) {
                    break;
                }
                C4311n9 c4311n9 = c4311n9Arr2[i5];
                if (c4311n9 != null) {
                    codedOutputByteBufferNano.writeMessage(10, c4311n9);
                }
                i5++;
            }
        }
        String[] strArr = this.e;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.e;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4361p9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C4286m9[] c4286m9Arr = this.f11717a;
                int length = c4286m9Arr == null ? 0 : c4286m9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C4286m9[] c4286m9Arr2 = new C4286m9[i2];
                if (length != 0) {
                    System.arraycopy(c4286m9Arr, 0, c4286m9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C4286m9 c4286m9 = new C4286m9();
                    c4286m9Arr2[length] = c4286m9;
                    codedInputByteBufferNano.readMessage(c4286m9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4286m9 c4286m10 = new C4286m9();
                c4286m9Arr2[length] = c4286m10;
                codedInputByteBufferNano.readMessage(c4286m10);
                this.f11717a = c4286m9Arr2;
            } else if (tag == 34) {
                if (this.b == null) {
                    this.b = new C4162h9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                C4087e9[] c4087e9Arr = this.c;
                int length2 = c4087e9Arr == null ? 0 : c4087e9Arr.length;
                int i3 = repeatedFieldArrayLength2 + length2;
                C4087e9[] c4087e9Arr2 = new C4087e9[i3];
                if (length2 != 0) {
                    System.arraycopy(c4087e9Arr, 0, c4087e9Arr2, 0, length2);
                }
                while (length2 < i3 - 1) {
                    C4087e9 c4087e9 = new C4087e9();
                    c4087e9Arr2[length2] = c4087e9;
                    codedInputByteBufferNano.readMessage(c4087e9);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                C4087e9 c4087e10 = new C4087e9();
                c4087e9Arr2[length2] = c4087e10;
                codedInputByteBufferNano.readMessage(c4087e10);
                this.c = c4087e9Arr2;
            } else if (tag == 82) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                C4311n9[] c4311n9Arr = this.d;
                int length3 = c4311n9Arr == null ? 0 : c4311n9Arr.length;
                int i4 = repeatedFieldArrayLength3 + length3;
                C4311n9[] c4311n9Arr2 = new C4311n9[i4];
                if (length3 != 0) {
                    System.arraycopy(c4311n9Arr, 0, c4311n9Arr2, 0, length3);
                }
                while (length3 < i4 - 1) {
                    C4311n9 c4311n9 = new C4311n9();
                    c4311n9Arr2[length3] = c4311n9;
                    codedInputByteBufferNano.readMessage(c4311n9);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                C4311n9 c4311n10 = new C4311n9();
                c4311n9Arr2[length3] = c4311n10;
                codedInputByteBufferNano.readMessage(c4311n10);
                this.d = c4311n9Arr2;
            } else if (tag != 90) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                String[] strArr = this.e;
                int length4 = strArr == null ? 0 : strArr.length;
                int i5 = repeatedFieldArrayLength4 + length4;
                String[] strArr2 = new String[i5];
                if (length4 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length4);
                }
                while (length4 < i5 - 1) {
                    strArr2[length4] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length4++;
                }
                strArr2[length4] = codedInputByteBufferNano.readString();
                this.e = strArr2;
            }
        }
    }

    public static C4361p9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4361p9().mergeFrom(codedInputByteBufferNano);
    }

    public static C4361p9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4361p9) MessageNano.mergeFrom(new C4361p9(), bArr);
    }
}
