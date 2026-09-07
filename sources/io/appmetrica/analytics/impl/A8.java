package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes13.dex */
public final class A8 extends MessageNano {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static volatile A8[] o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11056a;
    public C4609z8 b;
    public C4559x8 c;
    public C4584y8 d;
    public C4210j8 e;
    public C4360p8 f;

    public A8() {
        a();
    }

    public static A8[] b() {
        if (o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (o == null) {
                    o = new A8[0];
                }
            }
        }
        return o;
    }

    public final A8 a() {
        this.f11056a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i2 = this.f11056a;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i2);
        }
        C4609z8 c4609z8 = this.b;
        if (c4609z8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4609z8);
        }
        C4559x8 c4559x8 = this.c;
        if (c4559x8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c4559x8);
        }
        C4584y8 c4584y8 = this.d;
        if (c4584y8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c4584y8);
        }
        C4210j8 c4210j8 = this.e;
        if (c4210j8 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c4210j8);
        }
        C4360p8 c4360p8 = this.f;
        return c4360p8 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, c4360p8) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i2 = this.f11056a;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i2);
        }
        C4609z8 c4609z8 = this.b;
        if (c4609z8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4609z8);
        }
        C4559x8 c4559x8 = this.c;
        if (c4559x8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c4559x8);
        }
        C4584y8 c4584y8 = this.d;
        if (c4584y8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c4584y8);
        }
        C4210j8 c4210j8 = this.e;
        if (c4210j8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c4210j8);
        }
        C4360p8 c4360p8 = this.f;
        if (c4360p8 != null) {
            codedOutputByteBufferNano.writeMessage(6, c4360p8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final A8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        this.f11056a = int32;
                        break;
                }
            } else if (tag == 18) {
                if (this.b == null) {
                    this.b = new C4609z8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (tag == 26) {
                if (this.c == null) {
                    this.c = new C4559x8();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (tag == 34) {
                if (this.d == null) {
                    this.d = new C4584y8();
                }
                codedInputByteBufferNano.readMessage(this.d);
            } else if (tag == 42) {
                if (this.e == null) {
                    this.e = new C4210j8();
                }
                codedInputByteBufferNano.readMessage(this.e);
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.f == null) {
                    this.f = new C4360p8();
                }
                codedInputByteBufferNano.readMessage(this.f);
            }
        }
    }

    public static A8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new A8().mergeFrom(codedInputByteBufferNano);
    }

    public static A8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (A8) MessageNano.mergeFrom(new A8(), bArr);
    }
}
