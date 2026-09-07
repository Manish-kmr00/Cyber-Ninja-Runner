package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.c6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4034c6 extends MessageNano {
    public static volatile C4034c6[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4258l6 f11491a;
    public C4258l6[] b;
    public String c;

    public C4034c6() {
        a();
    }

    public static C4034c6[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new C4034c6[0];
                }
            }
        }
        return d;
    }

    public final C4034c6 a() {
        this.f11491a = null;
        this.b = C4258l6.b();
        this.c = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4258l6 c4258l6 = this.f11491a;
        if (c4258l6 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c4258l6);
        }
        C4258l6[] c4258l6Arr = this.b;
        if (c4258l6Arr != null && c4258l6Arr.length > 0) {
            int i = 0;
            while (true) {
                C4258l6[] c4258l6Arr2 = this.b;
                if (i >= c4258l6Arr2.length) {
                    break;
                }
                C4258l6 c4258l7 = c4258l6Arr2[i];
                if (c4258l7 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4258l7);
                }
                i++;
            }
        }
        return !this.c.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.c) : iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4258l6 c4258l6 = this.f11491a;
        if (c4258l6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c4258l6);
        }
        C4258l6[] c4258l6Arr = this.b;
        if (c4258l6Arr != null && c4258l6Arr.length > 0) {
            int i = 0;
            while (true) {
                C4258l6[] c4258l6Arr2 = this.b;
                if (i >= c4258l6Arr2.length) {
                    break;
                }
                C4258l6 c4258l7 = c4258l6Arr2[i];
                if (c4258l7 != null) {
                    codedOutputByteBufferNano.writeMessage(2, c4258l7);
                }
                i++;
            }
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4034c6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.f11491a == null) {
                    this.f11491a = new C4258l6();
                }
                codedInputByteBufferNano.readMessage(this.f11491a);
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                C4258l6[] c4258l6Arr = this.b;
                int length = c4258l6Arr == null ? 0 : c4258l6Arr.length;
                int i = repeatedFieldArrayLength + length;
                C4258l6[] c4258l6Arr2 = new C4258l6[i];
                if (length != 0) {
                    System.arraycopy(c4258l6Arr, 0, c4258l6Arr2, 0, length);
                }
                while (length < i - 1) {
                    C4258l6 c4258l6 = new C4258l6();
                    c4258l6Arr2[length] = c4258l6;
                    codedInputByteBufferNano.readMessage(c4258l6);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4258l6 c4258l7 = new C4258l6();
                c4258l6Arr2[length] = c4258l7;
                codedInputByteBufferNano.readMessage(c4258l7);
                this.b = c4258l6Arr2;
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.c = codedInputByteBufferNano.readString();
            }
        }
    }

    public static C4034c6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4034c6().mergeFrom(codedInputByteBufferNano);
    }

    public static C4034c6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4034c6) MessageNano.mergeFrom(new C4034c6(), bArr);
    }
}
