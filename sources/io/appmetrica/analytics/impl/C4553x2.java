package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.x2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4553x2 extends MessageNano {
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static volatile C4553x2[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4528w2[] f11838a;
    public boolean b;

    public C4553x2() {
        a();
    }

    public static C4553x2[] b() {
        if (f == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f == null) {
                    f = new C4553x2[0];
                }
            }
        }
        return f;
    }

    public final C4553x2 a() {
        this.f11838a = C4528w2.b();
        this.b = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4528w2[] c4528w2Arr = this.f11838a;
        if (c4528w2Arr != null && c4528w2Arr.length > 0) {
            int i = 0;
            while (true) {
                C4528w2[] c4528w2Arr2 = this.f11838a;
                if (i >= c4528w2Arr2.length) {
                    break;
                }
                C4528w2 c4528w2 = c4528w2Arr2[i];
                if (c4528w2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c4528w2);
                }
                i++;
            }
        }
        return CodedOutputByteBufferNano.computeBoolSize(2, this.b) + iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4528w2[] c4528w2Arr = this.f11838a;
        if (c4528w2Arr != null && c4528w2Arr.length > 0) {
            int i = 0;
            while (true) {
                C4528w2[] c4528w2Arr2 = this.f11838a;
                if (i >= c4528w2Arr2.length) {
                    break;
                }
                C4528w2 c4528w2 = c4528w2Arr2[i];
                if (c4528w2 != null) {
                    codedOutputByteBufferNano.writeMessage(1, c4528w2);
                }
                i++;
            }
        }
        codedOutputByteBufferNano.writeBool(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4553x2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                C4528w2[] c4528w2Arr = this.f11838a;
                int length = c4528w2Arr == null ? 0 : c4528w2Arr.length;
                int i = repeatedFieldArrayLength + length;
                C4528w2[] c4528w2Arr2 = new C4528w2[i];
                if (length != 0) {
                    System.arraycopy(c4528w2Arr, 0, c4528w2Arr2, 0, length);
                }
                while (length < i - 1) {
                    C4528w2 c4528w2 = new C4528w2();
                    c4528w2Arr2[length] = c4528w2;
                    codedInputByteBufferNano.readMessage(c4528w2);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                C4528w2 c4528w3 = new C4528w2();
                c4528w2Arr2[length] = c4528w3;
                codedInputByteBufferNano.readMessage(c4528w3);
                this.f11838a = c4528w2Arr2;
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.b = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static C4553x2 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4553x2().mergeFrom(codedInputByteBufferNano);
    }

    public static C4553x2 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4553x2) MessageNano.mergeFrom(new C4553x2(), bArr);
    }
}
