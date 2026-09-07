package io.appmetrica.analytics.impl;

import com.inmobi.commons.core.configs.AdConfig;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class Ql extends MessageNano {
    public static volatile Ql[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11318a;
    public int b;

    public Ql() {
        a();
    }

    public static Ql[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new Ql[0];
                }
            }
        }
        return c;
    }

    public final Ql a() {
        this.f11318a = AdConfig.DEFAULT_CONTEXTUAL_DATA_EXPIRY_TIME;
        this.b = AdConfig.DEFAULT_CONTEXTUAL_DATA_EXPIRY_TIME;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.f11318a;
        if (i != 86400) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.b;
        return i2 != 86400 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i2) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f11318a;
        if (i != 86400) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.b;
        if (i2 != 86400) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Ql mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.f11318a = codedInputByteBufferNano.readInt32();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.b = codedInputByteBufferNano.readInt32();
            }
        }
    }

    public static Ql b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ql().mergeFrom(codedInputByteBufferNano);
    }

    public static Ql a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ql) MessageNano.mergeFrom(new Ql(), bArr);
    }
}
