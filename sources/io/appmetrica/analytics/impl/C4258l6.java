package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.l6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4258l6 extends MessageNano {
    public static volatile C4258l6[] g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11645a;
    public int b;
    public long c;
    public String d;
    public int e;
    public C4233k6[] f;

    public C4258l6() {
        a();
    }

    public static C4258l6[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C4258l6[0];
                }
            }
        }
        return g;
    }

    public final C4258l6 a() {
        this.f11645a = "";
        this.b = 0;
        this.c = 0L;
        this.d = "";
        this.e = 0;
        this.f = C4233k6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSInt64Size = CodedOutputByteBufferNano.computeSInt64Size(3, this.c) + CodedOutputByteBufferNano.computeSInt32Size(2, this.b) + CodedOutputByteBufferNano.computeStringSize(1, this.f11645a) + super.computeSerializedSize();
        if (!this.d.equals("")) {
            iComputeSInt64Size += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            iComputeSInt64Size += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        C4233k6[] c4233k6Arr = this.f;
        if (c4233k6Arr != null && c4233k6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C4233k6[] c4233k6Arr2 = this.f;
                if (i2 >= c4233k6Arr2.length) {
                    break;
                }
                C4233k6 c4233k6 = c4233k6Arr2[i2];
                if (c4233k6 != null) {
                    iComputeSInt64Size += CodedOutputByteBufferNano.computeMessageSize(6, c4233k6);
                }
                i2++;
            }
        }
        return iComputeSInt64Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f11645a);
        codedOutputByteBufferNano.writeSInt32(2, this.b);
        codedOutputByteBufferNano.writeSInt64(3, this.c);
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        int i = this.e;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        C4233k6[] c4233k6Arr = this.f;
        if (c4233k6Arr != null && c4233k6Arr.length > 0) {
            int i2 = 0;
            while (true) {
                C4233k6[] c4233k6Arr2 = this.f;
                if (i2 >= c4233k6Arr2.length) {
                    break;
                }
                C4233k6 c4233k6 = c4233k6Arr2[i2];
                if (c4233k6 != null) {
                    codedOutputByteBufferNano.writeMessage(6, c4233k6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4258l6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.f11645a = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.b = codedInputByteBufferNano.readSInt32();
            } else if (tag == 24) {
                this.c = codedInputByteBufferNano.readSInt64();
            } else if (tag == 34) {
                this.d = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.e = codedInputByteBufferNano.readUInt32();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                C4233k6[] c4233k6Arr = this.f;
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
                this.f = c4233k6Arr2;
            }
        }
    }

    public static C4258l6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4258l6().mergeFrom(codedInputByteBufferNano);
    }

    public static C4258l6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4258l6) MessageNano.mergeFrom(new C4258l6(), bArr);
    }
}
