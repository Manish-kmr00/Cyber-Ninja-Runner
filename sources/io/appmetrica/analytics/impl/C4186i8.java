package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.i8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4186i8 extends MessageNano {
    public static volatile C4186i8[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f11598a;
    public C4285m8 b;

    public C4186i8() {
        a();
    }

    public static C4186i8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C4186i8[0];
                }
            }
        }
        return c;
    }

    public final C4186i8 a() {
        this.f11598a = WireFormatNano.EMPTY_BYTES;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!Arrays.equals(this.f11598a, WireFormatNano.EMPTY_BYTES)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f11598a);
        }
        C4285m8 c4285m8 = this.b;
        return c4285m8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, c4285m8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f11598a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f11598a);
        }
        C4285m8 c4285m8 = this.b;
        if (c4285m8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4285m8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4186i8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.f11598a = codedInputByteBufferNano.readBytes();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.b == null) {
                    this.b = new C4285m8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
    }

    public static C4186i8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4186i8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4186i8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4186i8) MessageNano.mergeFrom(new C4186i8(), bArr);
    }
}
