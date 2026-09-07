package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.x8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4559x8 extends MessageNano {
    public static volatile C4559x8[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4459t8 f11842a;
    public C4534w8 b;

    public C4559x8() {
        a();
    }

    public static C4559x8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C4559x8[0];
                }
            }
        }
        return c;
    }

    public final C4559x8 a() {
        this.f11842a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4459t8 c4459t8 = this.f11842a;
        if (c4459t8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c4459t8);
        }
        C4534w8 c4534w8 = this.b;
        return c4534w8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, c4534w8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4459t8 c4459t8 = this.f11842a;
        if (c4459t8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c4459t8);
        }
        C4534w8 c4534w8 = this.b;
        if (c4534w8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4534w8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4559x8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.f11842a == null) {
                    this.f11842a = new C4459t8();
                }
                codedInputByteBufferNano.readMessage(this.f11842a);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.b == null) {
                    this.b = new C4534w8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
    }

    public static C4559x8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4559x8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4559x8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4559x8) MessageNano.mergeFrom(new C4559x8(), bArr);
    }
}
