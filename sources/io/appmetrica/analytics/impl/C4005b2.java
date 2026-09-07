package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.b2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4005b2 extends MessageNano {
    public static volatile C4005b2[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3980a2[] f11472a;
    public Z1 b;
    public String[] c;

    public C4005b2() {
        a();
    }

    public static C4005b2[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C4005b2[0];
                }
            }
        }
        return d;
    }

    public final C4005b2 a() {
        this.f11472a = C3980a2.b();
        this.b = null;
        this.c = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C3980a2[] c3980a2Arr = this.f11472a;
        int i = 0;
        if (c3980a2Arr != null && c3980a2Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C3980a2[] c3980a2Arr2 = this.f11472a;
                if (i2 >= c3980a2Arr2.length) {
                    break;
                }
                C3980a2 c3980a2 = c3980a2Arr2[i2];
                if (c3980a2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c3980a2);
                }
                i2++;
            }
        }
        Z1 z1 = this.b;
        if (z1 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, z1);
        }
        String[] strArr = this.c;
        if (strArr == null || strArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeStringSizeNoTag = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.c;
            if (i >= strArr2.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag + i3;
            }
            String str = strArr2[i];
            if (str != null) {
                i3++;
                iComputeStringSizeNoTag = CodedOutputByteBufferNano.computeStringSizeNoTag(str) + iComputeStringSizeNoTag;
            }
            i++;
        }
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C3980a2[] c3980a2Arr = this.f11472a;
        int i = 0;
        if (c3980a2Arr != null && c3980a2Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C3980a2[] c3980a2Arr2 = this.f11472a;
                if (i2 >= c3980a2Arr2.length) {
                    break;
                }
                C3980a2 c3980a2 = c3980a2Arr2[i2];
                if (c3980a2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c3980a2);
                }
                i2++;
            }
        }
        Z1 z1 = this.b;
        if (z1 != null) {
            codedOutputByteBufferNano.writeMessage(2, z1);
        }
        String[] strArr = this.c;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.c;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4005b2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C3980a2[] c3980a2Arr = this.f11472a;
                int length = c3980a2Arr == null ? 0 : c3980a2Arr.length;
                int i = repeatedFieldArrayLength + length;
                C3980a2[] c3980a2Arr2 = new C3980a2[i];
                if (length != 0) {
                    System.arraycopy(c3980a2Arr, 0, c3980a2Arr2, 0, length);
                }
                while (length < i - 1) {
                    C3980a2 c3980a2 = new C3980a2();
                    c3980a2Arr2[length] = c3980a2;
                    codedInputByteBufferNano.readMessage(c3980a2);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C3980a2 c3980a3 = new C3980a2();
                c3980a2Arr2[length] = c3980a3;
                codedInputByteBufferNano.readMessage(c3980a3);
                this.f11472a = c3980a2Arr2;
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new Z1();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                String[] strArr = this.c;
                int length2 = strArr == null ? 0 : strArr.length;
                int i2 = repeatedFieldArrayLength2 + length2;
                String[] strArr2 = new String[i2];
                if (length2 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length2);
                }
                while (length2 < i2 - 1) {
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                strArr2[length2] = codedInputByteBufferNano.readString();
                this.c = strArr2;
            }
        }
    }

    public static C4005b2 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4005b2().mergeFrom(codedInputByteBufferNano);
    }

    public static C4005b2 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4005b2) MessageNano.mergeFrom(new C4005b2(), bArr);
    }
}
