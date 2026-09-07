package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.k8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4235k8 extends MessageNano {
    public static volatile C4235k8[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4459t8 f11633a;
    public C4509v8 b;
    public C4285m8 c;
    public C4434s8 d;

    public C4235k8() {
        a();
    }

    public static C4235k8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C4235k8[0];
                }
            }
        }
        return e;
    }

    public final C4235k8 a() {
        this.f11633a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4459t8 c4459t8 = this.f11633a;
        if (c4459t8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c4459t8);
        }
        C4509v8 c4509v8 = this.b;
        if (c4509v8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4509v8);
        }
        C4285m8 c4285m8 = this.c;
        if (c4285m8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c4285m8);
        }
        C4434s8 c4434s8 = this.d;
        return c4434s8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, c4434s8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4459t8 c4459t8 = this.f11633a;
        if (c4459t8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c4459t8);
        }
        C4509v8 c4509v8 = this.b;
        if (c4509v8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4509v8);
        }
        C4285m8 c4285m8 = this.c;
        if (c4285m8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c4285m8);
        }
        C4434s8 c4434s8 = this.d;
        if (c4434s8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c4434s8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4235k8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.f11633a == null) {
                    this.f11633a = new C4459t8();
                }
                codedInputByteBufferNano.readMessage(this.f11633a);
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C4509v8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C4285m8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.d == null) {
                    this.d = new C4434s8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
    }

    public static C4235k8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4235k8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4235k8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4235k8) MessageNano.mergeFrom(new C4235k8(), bArr);
    }
}
