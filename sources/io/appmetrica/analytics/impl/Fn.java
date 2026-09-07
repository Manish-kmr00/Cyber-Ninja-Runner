package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class Fn extends MessageNano {
    public static volatile Fn[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cn[] f11148a;

    public Fn() {
        a();
    }

    public static Fn[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Fn[0];
                }
            }
        }
        return b;
    }

    public final Fn a() {
        this.f11148a = Cn.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Cn[] cnArr = this.f11148a;
        if (cnArr != null && cnArr.length > 0) {
            int i = 0;
            while (true) {
                Cn[] cnArr2 = this.f11148a;
                if (i >= cnArr2.length) {
                    break;
                }
                Cn cn = cnArr2[i];
                if (cn != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cn);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Cn[] cnArr = this.f11148a;
        if (cnArr != null && cnArr.length > 0) {
            int i = 0;
            while (true) {
                Cn[] cnArr2 = this.f11148a;
                if (i >= cnArr2.length) {
                    break;
                }
                Cn cn = cnArr2[i];
                if (cn != null) {
                    codedOutputByteBufferNano.writeMessage(1, cn);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Fn mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Cn[] cnArr = this.f11148a;
                int length = cnArr == null ? 0 : cnArr.length;
                int i = repeatedFieldArrayLength + length;
                Cn[] cnArr2 = new Cn[i];
                if (length != 0) {
                    System.arraycopy(cnArr, 0, cnArr2, 0, length);
                }
                while (length < i - 1) {
                    Cn cn = new Cn();
                    cnArr2[length] = cn;
                    codedInputByteBufferNano.readMessage(cn);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Cn cn2 = new Cn();
                cnArr2[length] = cn2;
                codedInputByteBufferNano.readMessage(cn2);
                this.f11148a = cnArr2;
            }
        }
    }

    public static Fn b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Fn().mergeFrom(codedInputByteBufferNano);
    }

    public static Fn a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Fn) MessageNano.mergeFrom(new Fn(), bArr);
    }
}
