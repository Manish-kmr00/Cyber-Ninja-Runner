package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ok, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4347ok extends MessageNano {
    public static volatile C4347ok[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4372pk[] f11705a;

    public C4347ok() {
        a();
    }

    public static C4347ok[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C4347ok[0];
                }
            }
        }
        return b;
    }

    public final C4347ok a() {
        this.f11705a = C4372pk.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4372pk[] c4372pkArr = this.f11705a;
        if (c4372pkArr != null && c4372pkArr.length > 0) {
            int i = 0;
            while (true) {
                C4372pk[] c4372pkArr2 = this.f11705a;
                if (i >= c4372pkArr2.length) {
                    break;
                }
                C4372pk c4372pk = c4372pkArr2[i];
                if (c4372pk != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c4372pk);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4372pk[] c4372pkArr = this.f11705a;
        if (c4372pkArr != null && c4372pkArr.length > 0) {
            int i = 0;
            while (true) {
                C4372pk[] c4372pkArr2 = this.f11705a;
                if (i >= c4372pkArr2.length) {
                    break;
                }
                C4372pk c4372pk = c4372pkArr2[i];
                if (c4372pk != null) {
                    codedOutputByteBufferNano.writeMessage(1, c4372pk);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4347ok mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                C4372pk[] c4372pkArr = this.f11705a;
                int length = c4372pkArr == null ? 0 : c4372pkArr.length;
                int i = repeatedFieldArrayLength + length;
                C4372pk[] c4372pkArr2 = new C4372pk[i];
                if (length != 0) {
                    System.arraycopy(c4372pkArr, 0, c4372pkArr2, 0, length);
                }
                while (length < i - 1) {
                    C4372pk c4372pk = new C4372pk();
                    c4372pkArr2[length] = c4372pk;
                    codedInputByteBufferNano.readMessage(c4372pk);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4372pk c4372pk2 = new C4372pk();
                c4372pkArr2[length] = c4372pk2;
                codedInputByteBufferNano.readMessage(c4372pk2);
                this.f11705a = c4372pkArr2;
            }
        }
    }

    public static C4347ok b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4347ok().mergeFrom(codedInputByteBufferNano);
    }

    public static C4347ok a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4347ok) MessageNano.mergeFrom(new C4347ok(), bArr);
    }
}
