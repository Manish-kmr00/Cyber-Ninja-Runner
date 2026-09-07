package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.m9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4286m9 extends MessageNano {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 6;
    public static final int k = 7;
    public static final int l = 8;
    public static final int m = 9;
    public static final int n = 10;
    public static final int o = 11;
    public static final int p = 12;
    public static volatile C4286m9[] q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11668a;
    public C4261l9 b;
    public C4236k9[] c;

    public C4286m9() {
        a();
    }

    public static C4286m9[] b() {
        if (q == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (q == null) {
                    q = new C4286m9[0];
                }
            }
        }
        return q;
    }

    public final C4286m9 a() {
        this.f11668a = 0L;
        this.b = null;
        this.c = C4236k9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeUInt64Size = CodedOutputByteBufferNano.computeUInt64Size(1, this.f11668a) + super.computeSerializedSize();
        C4261l9 c4261l9 = this.b;
        if (c4261l9 != null) {
            iComputeUInt64Size += CodedOutputByteBufferNano.computeMessageSize(2, c4261l9);
        }
        C4236k9[] c4236k9Arr = this.c;
        if (c4236k9Arr != null && c4236k9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C4236k9[] c4236k9Arr2 = this.c;
                if (i2 >= c4236k9Arr2.length) {
                    break;
                }
                C4236k9 c4236k9 = c4236k9Arr2[i2];
                if (c4236k9 != null) {
                    iComputeUInt64Size += CodedOutputByteBufferNano.computeMessageSize(3, c4236k9);
                }
                i2++;
            }
        }
        return iComputeUInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f11668a);
        C4261l9 c4261l9 = this.b;
        if (c4261l9 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4261l9);
        }
        C4236k9[] c4236k9Arr = this.c;
        if (c4236k9Arr != null && c4236k9Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C4236k9[] c4236k9Arr2 = this.c;
                if (i2 >= c4236k9Arr2.length) {
                    break;
                }
                C4236k9 c4236k9 = c4236k9Arr2[i2];
                if (c4236k9 != null) {
                    codedOutputByteBufferNano.writeMessage(3, c4236k9);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4286m9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.f11668a = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C4261l9();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                C4236k9[] c4236k9Arr = this.c;
                int length = c4236k9Arr == null ? 0 : c4236k9Arr.length;
                int i2 = repeatedFieldArrayLength + length;
                C4236k9[] c4236k9Arr2 = new C4236k9[i2];
                if (length != 0) {
                    System.arraycopy(c4236k9Arr, 0, c4236k9Arr2, 0, length);
                }
                while (length < i2 - 1) {
                    C4236k9 c4236k9 = new C4236k9();
                    c4236k9Arr2[length] = c4236k9;
                    codedInputByteBufferNano.readMessage(c4236k9);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4236k9 c4236k10 = new C4236k9();
                c4236k9Arr2[length] = c4236k10;
                codedInputByteBufferNano.readMessage(c4236k10);
                this.c = c4236k9Arr2;
            }
        }
    }

    public static C4286m9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4286m9().mergeFrom(codedInputByteBufferNano);
    }

    public static C4286m9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4286m9) MessageNano.mergeFrom(new C4286m9(), bArr);
    }
}
