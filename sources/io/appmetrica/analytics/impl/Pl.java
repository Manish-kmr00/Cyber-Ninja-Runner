package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class Pl extends MessageNano {
    public static volatile Pl[] b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Ol[] f11300a;

    public Pl() {
        a();
    }

    public static Pl[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new Pl[0];
                }
            }
        }
        return b;
    }

    public final Pl a() {
        this.f11300a = Ol.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Ol[] olArr = this.f11300a;
        if (olArr != null && olArr.length > 0) {
            int i = 0;
            while (true) {
                Ol[] olArr2 = this.f11300a;
                if (i >= olArr2.length) {
                    break;
                }
                Ol ol = olArr2[i];
                if (ol != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, ol);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Ol[] olArr = this.f11300a;
        if (olArr != null && olArr.length > 0) {
            int i = 0;
            while (true) {
                Ol[] olArr2 = this.f11300a;
                if (i >= olArr2.length) {
                    break;
                }
                Ol ol = olArr2[i];
                if (ol != null) {
                    codedOutputByteBufferNano.writeMessage(1, ol);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Pl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                Ol[] olArr = this.f11300a;
                int length = olArr == null ? 0 : olArr.length;
                int i = repeatedFieldArrayLength + length;
                Ol[] olArr2 = new Ol[i];
                if (length != 0) {
                    System.arraycopy(olArr, 0, olArr2, 0, length);
                }
                while (length < i - 1) {
                    Ol ol = new Ol();
                    olArr2[length] = ol;
                    codedInputByteBufferNano.readMessage(ol);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Ol ol2 = new Ol();
                olArr2[length] = ol2;
                codedInputByteBufferNano.readMessage(ol2);
                this.f11300a = olArr2;
            }
        }
    }

    public static Pl b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Pl().mergeFrom(codedInputByteBufferNano);
    }

    public static Pl a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Pl) MessageNano.mergeFrom(new Pl(), bArr);
    }
}
