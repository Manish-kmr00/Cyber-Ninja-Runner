package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.p8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4360p8 extends MessageNano {
    public static volatile C4360p8[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4310n8 f11716a;

    public C4360p8() {
        a();
    }

    public static C4360p8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C4360p8[0];
                }
            }
        }
        return b;
    }

    public final C4360p8 a() {
        this.f11716a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4310n8 c4310n8 = this.f11716a;
        return c4310n8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, c4310n8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4310n8 c4310n8 = this.f11716a;
        if (c4310n8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c4310n8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4360p8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f11716a == null) {
                    this.f11716a = new C4310n8();
                }
                codedInputByteBufferNano.readMessage(this.f11716a);
            }
        }
    }

    public static C4360p8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4360p8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4360p8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4360p8) MessageNano.mergeFrom(new C4360p8(), bArr);
    }
}
