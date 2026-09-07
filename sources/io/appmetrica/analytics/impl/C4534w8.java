package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.w8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4534w8 extends MessageNano {
    public static volatile C4534w8[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f11829a;
    public C4260l8 b;
    public byte[] c;
    public C4409r8 d;

    public C4534w8() {
        a();
    }

    public static C4534w8[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C4534w8[0];
                }
            }
        }
        return e;
    }

    public final C4534w8 a() {
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.f11829a = bArr;
        this.b = null;
        this.c = bArr;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        byte[] bArr = this.f11829a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f11829a);
        }
        C4260l8 c4260l8 = this.b;
        if (c4260l8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4260l8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.c);
        }
        C4409r8 c4409r8 = this.d;
        return c4409r8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, c4409r8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        byte[] bArr = this.f11829a;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(1, this.f11829a);
        }
        C4260l8 c4260l8 = this.b;
        if (c4260l8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4260l8);
        }
        if (!Arrays.equals(this.c, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.c);
        }
        C4409r8 c4409r8 = this.d;
        if (c4409r8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c4409r8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4534w8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.f11829a = codedInputByteBufferNano.readBytes();
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C4260l8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 26) {
                this.c = codedInputByteBufferNano.readBytes();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.d == null) {
                    this.d = new C4409r8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
    }

    public static C4534w8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4534w8().mergeFrom(codedInputByteBufferNano);
    }

    public static C4534w8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4534w8) MessageNano.mergeFrom(new C4534w8(), bArr);
    }
}
