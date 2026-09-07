package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.yi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4594yi extends MessageNano {
    public static volatile C4594yi[] e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11862a;
    public C4619zi b;
    public int c;
    public byte[] d;

    public C4594yi() {
        a();
    }

    public static C4594yi[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C4594yi[0];
                }
            }
        }
        return e;
    }

    public final C4594yi a() {
        this.f11862a = 0L;
        this.b = null;
        this.c = 0;
        this.d = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.f11862a;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        C4619zi c4619zi = this.b;
        if (c4619zi != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4619zi);
        }
        int i = this.c;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        return !Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.d) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j = this.f11862a;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        C4619zi c4619zi = this.b;
        if (c4619zi != null) {
            codedOutputByteBufferNano.writeMessage(2, c4619zi);
        }
        int i = this.c;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        if (!Arrays.equals(this.d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4594yi mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.f11862a = codedInputByteBufferNano.readInt64();
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C4619zi();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 24) {
                this.c = codedInputByteBufferNano.readUInt32();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.d = codedInputByteBufferNano.readBytes();
            }
        }
    }

    public static C4594yi b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4594yi().mergeFrom(codedInputByteBufferNano);
    }

    public static C4594yi a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4594yi) MessageNano.mergeFrom(new C4594yi(), bArr);
    }
}
