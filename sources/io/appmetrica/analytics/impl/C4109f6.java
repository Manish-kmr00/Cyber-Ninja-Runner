package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.f6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4109f6 extends MessageNano {
    public static volatile C4109f6[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f11545a;
    public C4208j6 b;

    public C4109f6() {
        a();
    }

    public static C4109f6[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C4109f6[0];
                }
            }
        }
        return c;
    }

    public final C4109f6 a() {
        this.f11545a = WireFormatNano.EMPTY_BYTES;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f11545a, WireFormatNano.EMPTY_BYTES)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f11545a);
        }
        C4208j6 c4208j6 = this.b;
        return c4208j6 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, c4208j6) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f11545a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f11545a);
        }
        C4208j6 c4208j6 = this.b;
        if (c4208j6 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4208j6);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4109f6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.f11545a = codedInputByteBufferNano.readBytes();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.b == null) {
                    this.b = new C4208j6();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
    }

    public static C4109f6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4109f6().mergeFrom(codedInputByteBufferNano);
    }

    public static C4109f6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4109f6) MessageNano.mergeFrom(new C4109f6(), bArr);
    }
}
