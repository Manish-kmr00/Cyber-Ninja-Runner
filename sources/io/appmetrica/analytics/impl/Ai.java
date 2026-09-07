package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public final class Ai extends MessageNano {
    public static volatile Ai[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11061a;
    public C4619zi b;
    public C4594yi c;

    public Ai() {
        a();
    }

    public static Ai[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new Ai[0];
                }
            }
        }
        return d;
    }

    public final Ai a() {
        this.f11061a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.f11061a;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        C4619zi c4619zi = this.b;
        if (c4619zi != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4619zi);
        }
        C4594yi c4594yi = this.c;
        return c4594yi != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, c4594yi) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f11061a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        C4619zi c4619zi = this.b;
        if (c4619zi != null) {
            codedOutputByteBufferNano.writeMessage(2, c4619zi);
        }
        C4594yi c4594yi = this.c;
        if (c4594yi != null) {
            codedOutputByteBufferNano.writeMessage(3, c4594yi);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Ai mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.f11061a = codedInputByteBufferNano.readBool();
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C4619zi();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.c == null) {
                    this.c = new C4594yi();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
    }

    public static Ai b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ai().mergeFrom(codedInputByteBufferNano);
    }

    public static Ai a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ai) MessageNano.mergeFrom(new Ai(), bArr);
    }
}
