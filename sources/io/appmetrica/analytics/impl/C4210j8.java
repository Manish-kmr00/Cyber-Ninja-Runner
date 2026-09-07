package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.j8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4210j8 extends MessageNano {
    public static volatile C4210j8[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4235k8 f11614a;

    public C4210j8() {
        a();
    }

    public static C4210j8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C4210j8[0];
                }
            }
        }
        return b;
    }

    public final C4210j8 a() {
        this.f11614a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4235k8 c4235k8 = this.f11614a;
        return c4235k8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, c4235k8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4235k8 c4235k8 = this.f11614a;
        if (c4235k8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c4235k8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4210j8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.f11614a == null) {
                    this.f11614a = new C4235k8();
                }
                codedInputByteBufferNano.readMessage(this.f11614a);
            }
        }
    }

    public static C4210j8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4210j8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4210j8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4210j8) MessageNano.mergeFrom(new C4210j8(), bArr);
    }
}
