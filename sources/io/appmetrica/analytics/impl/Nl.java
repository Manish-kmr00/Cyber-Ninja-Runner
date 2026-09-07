package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class Nl extends MessageNano {
    public static volatile Nl[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11272a;

    public Nl() {
        a();
    }

    public static Nl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Nl[0];
                }
            }
        }
        return b;
    }

    public final Nl a() {
        this.f11272a = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.f11272a.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.f11272a) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f11272a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f11272a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Nl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.f11272a = codedInputByteBufferNano.readString();
            }
        }
    }

    public static Nl b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Nl().mergeFrom(codedInputByteBufferNano);
    }

    public static Nl a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Nl) MessageNano.mergeFrom(new Nl(), bArr);
    }
}
