package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public final class Z1 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = -1;
    public static final int j = 0;
    public static final int k = 1;
    public static volatile Z1[] l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11444a;
    public int b;

    public Z1() {
        a();
    }

    public static Z1[] b() {
        if (l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (l == null) {
                    l = new Z1[0];
                }
            }
        }
        return l;
    }

    public final Z1 a() {
        this.f11444a = 0;
        this.b = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeInt32Size(3, this.b) + CodedOutputByteBufferNano.computeInt32Size(2, this.f11444a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(2, this.f11444a);
        codedOutputByteBufferNano.writeInt32(3, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Z1 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5) {
                    this.f11444a = int32;
                }
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int33 = codedInputByteBufferNano.readInt32();
                if (int33 == -1 || int33 == 0 || int33 == 1) {
                    this.b = int33;
                }
            }
        }
    }

    public static Z1 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Z1().mergeFrom(codedInputByteBufferNano);
    }

    public static Z1 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Z1) MessageNano.mergeFrom(new Z1(), bArr);
    }
}
