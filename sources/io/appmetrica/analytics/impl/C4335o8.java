package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.o8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4335o8 extends MessageNano {
    public static volatile C4335o8[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11699a;
    public C4235k8 b;

    public C4335o8() {
        a();
    }

    public static C4335o8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C4335o8[0];
                }
            }
        }
        return c;
    }

    public final C4335o8 a() {
        this.f11699a = 0;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.f11699a;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        C4235k8 c4235k8 = this.b;
        return c4235k8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, c4235k8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f11699a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        C4235k8 c4235k8 = this.b;
        if (c4235k8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4235k8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4335o8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.f11699a = codedInputByteBufferNano.readUInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.b == null) {
                    this.b = new C4235k8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
    }

    public static C4335o8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4335o8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4335o8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4335o8) MessageNano.mergeFrom(new C4335o8(), bArr);
    }
}
