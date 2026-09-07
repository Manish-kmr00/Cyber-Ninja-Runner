package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.z8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4609z8 extends MessageNano {
    public static volatile C4609z8[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4534w8 f11872a;

    public C4609z8() {
        a();
    }

    public static C4609z8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C4609z8[0];
                }
            }
        }
        return b;
    }

    public final C4609z8 a() {
        this.f11872a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4534w8 c4534w8 = this.f11872a;
        return c4534w8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, c4534w8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4534w8 c4534w8 = this.f11872a;
        if (c4534w8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c4534w8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4609z8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f11872a == null) {
                    this.f11872a = new C4534w8();
                }
                codedInputByteBufferNano.readMessage(this.f11872a);
            }
        }
    }

    public static C4609z8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4609z8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4609z8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4609z8) MessageNano.mergeFrom(new C4609z8(), bArr);
    }
}
