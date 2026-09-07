package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class O3 extends MessageNano {
    public static volatile O3[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Q3 f11276a;
    public int b;

    public O3() {
        a();
    }

    public static O3[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new O3[0];
                }
            }
        }
        return c;
    }

    public final O3 a() {
        this.f11276a = null;
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Q3 q3 = this.f11276a;
        if (q3 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, q3);
        }
        int i = this.b;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Q3 q3 = this.f11276a;
        if (q3 != null) {
            codedOutputByteBufferNano.writeMessage(1, q3);
        }
        int i = this.b;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final O3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.f11276a == null) {
                    this.f11276a = new Q3();
                }
                codedInputByteBufferNano.readMessage(this.f11276a);
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.b = int32;
                }
            }
        }
    }

    public static O3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new O3().mergeFrom(codedInputByteBufferNano);
    }

    public static O3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (O3) MessageNano.mergeFrom(new O3(), bArr);
    }
}
