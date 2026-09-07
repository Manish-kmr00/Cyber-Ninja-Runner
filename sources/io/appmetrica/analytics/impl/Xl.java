package io.appmetrica.analytics.impl;

import com.inmobi.commons.core.configs.AdConfig;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public final class Xl extends MessageNano {
    public static volatile Xl[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11423a;

    public Xl() {
        a();
    }

    public static Xl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Xl[0];
                }
            }
        }
        return b;
    }

    public final Xl a() {
        this.f11423a = AdConfig.DEFAULT_CONTEXTUAL_DATA_EXPIRY_TIME;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.f11423a;
        return i != 86400 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f11423a;
        if (i != 86400) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Xl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.f11423a = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static Xl b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Xl().mergeFrom(codedInputByteBufferNano);
    }

    public static Xl a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Xl) MessageNano.mergeFrom(new Xl(), bArr);
    }
}
