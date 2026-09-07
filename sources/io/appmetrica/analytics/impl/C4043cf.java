package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.cf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes7.dex */
public final class C4043cf extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static volatile C4043cf[] g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3993af f11495a;
    public C4018bf[] b;

    public C4043cf() {
        a();
    }

    public static C4043cf[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C4043cf[0];
                }
            }
        }
        return g;
    }

    public final C4043cf a() {
        this.f11495a = null;
        this.b = C4018bf.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C3993af c3993af = this.f11495a;
        if (c3993af != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c3993af);
        }
        C4018bf[] c4018bfArr = this.b;
        if (c4018bfArr != null && c4018bfArr.length > 0) {
            int i = 0;
            while (true) {
                C4018bf[] c4018bfArr2 = this.b;
                if (i >= c4018bfArr2.length) {
                    break;
                }
                C4018bf c4018bf = c4018bfArr2[i];
                if (c4018bf != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4018bf);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C3993af c3993af = this.f11495a;
        if (c3993af != null) {
            codedOutputByteBufferNano.writeMessage(1, c3993af);
        }
        C4018bf[] c4018bfArr = this.b;
        if (c4018bfArr != null && c4018bfArr.length > 0) {
            int i = 0;
            while (true) {
                C4018bf[] c4018bfArr2 = this.b;
                if (i >= c4018bfArr2.length) {
                    break;
                }
                C4018bf c4018bf = c4018bfArr2[i];
                if (c4018bf != null) {
                    codedOutputByteBufferNano.writeMessage(2, c4018bf);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4043cf mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.f11495a == null) {
                    this.f11495a = new C3993af();
                }
                codedInputByteBufferNano.readMessage(this.f11495a);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C4018bf[] c4018bfArr = this.b;
                int length = c4018bfArr == null ? 0 : c4018bfArr.length;
                int i = repeatedFieldArrayLength + length;
                C4018bf[] c4018bfArr2 = new C4018bf[i];
                if (length != 0) {
                    System.arraycopy(c4018bfArr, 0, c4018bfArr2, 0, length);
                }
                while (length < i - 1) {
                    C4018bf c4018bf = new C4018bf();
                    c4018bfArr2[length] = c4018bf;
                    codedInputByteBufferNano.readMessage(c4018bf);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4018bf c4018bf2 = new C4018bf();
                c4018bfArr2[length] = c4018bf2;
                codedInputByteBufferNano.readMessage(c4018bf2);
                this.b = c4018bfArr2;
            }
        }
    }

    public static C4043cf b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4043cf().mergeFrom(codedInputByteBufferNano);
    }

    public static C4043cf a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4043cf) MessageNano.mergeFrom(new C4043cf(), bArr);
    }
}
