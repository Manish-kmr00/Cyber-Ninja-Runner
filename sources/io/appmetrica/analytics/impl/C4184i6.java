package io.appmetrica.analytics.impl;

import com.json.mediationsdk.utils.IronSourceConstants;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.i6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4184i6 extends MessageNano {
    public static final int l = 0;
    public static final int m = 1;
    public static volatile C4184i6[] n;
    public static byte[] o;
    public static volatile boolean p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C4283m6 f11596a;
    public C4034c6 b;
    public String c;
    public int d;
    public C4233k6[] e;
    public String f;
    public int g;
    public C4159h6 h;
    public byte[] i;
    public byte[] j;
    public C4084e6[] k;

    public C4184i6() {
        if (!p) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (!p) {
                    o = InternalNano.bytesDefaultValue("JVM");
                    p = true;
                }
            }
        }
        a();
    }

    public static C4184i6[] b() {
        if (n == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (n == null) {
                    n = new C4184i6[0];
                }
            }
        }
        return n;
    }

    public final C4184i6 a() {
        this.f11596a = null;
        this.b = null;
        this.c = "";
        this.d = -1;
        this.e = C4233k6.b();
        this.f = "";
        this.g = 0;
        this.h = null;
        this.i = (byte[]) o.clone();
        this.j = WireFormatNano.EMPTY_BYTES;
        this.k = C4084e6.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        C4283m6 c4283m6 = this.f11596a;
        if (c4283m6 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c4283m6);
        }
        C4034c6 c4034c6 = this.b;
        if (c4034c6 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c4034c6);
        }
        if (!this.c.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        C4233k6[] c4233k6Arr = this.e;
        int i2 = 0;
        if (c4233k6Arr != null && c4233k6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C4233k6[] c4233k6Arr2 = this.e;
                if (i3 >= c4233k6Arr2.length) {
                    break;
                }
                C4233k6 c4233k6 = c4233k6Arr2[i3];
                if (c4233k6 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c4233k6);
                }
                i3++;
            }
        }
        if (!this.f.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f);
        }
        int i4 = this.g;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i4);
        }
        C4159h6 c4159h6 = this.h;
        if (c4159h6 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, c4159h6);
        }
        if (!Arrays.equals(this.i, o)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.j);
        }
        C4084e6[] c4084e6Arr = this.k;
        if (c4084e6Arr != null && c4084e6Arr.length > 0) {
            while (true) {
                C4084e6[] c4084e6Arr2 = this.k;
                if (i2 >= c4084e6Arr2.length) {
                    break;
                }
                C4084e6 c4084e6 = c4084e6Arr2[i2];
                if (c4084e6 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, c4084e6);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C4283m6 c4283m6 = this.f11596a;
        if (c4283m6 != null) {
            codedOutputByteBufferNano.writeMessage(1, c4283m6);
        }
        C4034c6 c4034c6 = this.b;
        if (c4034c6 != null) {
            codedOutputByteBufferNano.writeMessage(2, c4034c6);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        int i = this.d;
        if (i != -1) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        C4233k6[] c4233k6Arr = this.e;
        int i2 = 0;
        if (c4233k6Arr != null && c4233k6Arr.length > 0) {
            int i3 = 0;
            while (true) {
                C4233k6[] c4233k6Arr2 = this.e;
                if (i3 >= c4233k6Arr2.length) {
                    break;
                }
                C4233k6 c4233k6 = c4233k6Arr2[i3];
                if (c4233k6 != null) {
                    codedOutputByteBufferNano.writeMessage(5, c4233k6);
                }
                i3++;
            }
        }
        if (!this.f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f);
        }
        int i4 = this.g;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i4);
        }
        C4159h6 c4159h6 = this.h;
        if (c4159h6 != null) {
            codedOutputByteBufferNano.writeMessage(8, c4159h6);
        }
        if (!Arrays.equals(this.i, o)) {
            codedOutputByteBufferNano.writeBytes(9, this.i);
        }
        if (!Arrays.equals(this.j, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(10, this.j);
        }
        C4084e6[] c4084e6Arr = this.k;
        if (c4084e6Arr != null && c4084e6Arr.length > 0) {
            while (true) {
                C4084e6[] c4084e6Arr2 = this.k;
                if (i2 >= c4084e6Arr2.length) {
                    break;
                }
                C4084e6 c4084e6 = c4084e6Arr2[i2];
                if (c4084e6 != null) {
                    codedOutputByteBufferNano.writeMessage(11, c4084e6);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C4184i6 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4184i6().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4184i6 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    if (this.f11596a == null) {
                        this.f11596a = new C4283m6();
                    }
                    codedInputByteBufferNano.readMessage(this.f11596a);
                    break;
                case 18:
                    if (this.b == null) {
                        this.b = new C4034c6();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                    break;
                case 26:
                    this.c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == -1 || int32 == 0 || int32 == 1) {
                        this.d = int32;
                    }
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    C4233k6[] c4233k6Arr = this.e;
                    int length = c4233k6Arr == null ? 0 : c4233k6Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C4233k6[] c4233k6Arr2 = new C4233k6[i];
                    if (length != 0) {
                        System.arraycopy(c4233k6Arr, 0, c4233k6Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C4233k6 c4233k6 = new C4233k6();
                        c4233k6Arr2[length] = c4233k6;
                        codedInputByteBufferNano.readMessage(c4233k6);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C4233k6 c4233k7 = new C4233k6();
                    c4233k6Arr2[length] = c4233k7;
                    codedInputByteBufferNano.readMessage(c4233k7);
                    this.e = c4233k6Arr2;
                    break;
                case 50:
                    this.f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    int int33 = codedInputByteBufferNano.readInt32();
                    if (int33 == 0 || int33 == 1) {
                        this.g = int33;
                    }
                    break;
                case 66:
                    if (this.h == null) {
                        this.h = new C4159h6();
                    }
                    codedInputByteBufferNano.readMessage(this.h);
                    break;
                case 74:
                    this.i = codedInputByteBufferNano.readBytes();
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT /* 82 */:
                    this.j = codedInputByteBufferNano.readBytes();
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    C4084e6[] c4084e6Arr = this.k;
                    int length2 = c4084e6Arr == null ? 0 : c4084e6Arr.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    C4084e6[] c4084e6Arr2 = new C4084e6[i2];
                    if (length2 != 0) {
                        System.arraycopy(c4084e6Arr, 0, c4084e6Arr2, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        C4084e6 c4084e6 = new C4084e6();
                        c4084e6Arr2[length2] = c4084e6;
                        codedInputByteBufferNano.readMessage(c4084e6);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    C4084e6 c4084e7 = new C4084e6();
                    c4084e6Arr2[length2] = c4084e7;
                    codedInputByteBufferNano.readMessage(c4084e7);
                    this.k = c4084e6Arr2;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
                    break;
            }
        }
    }

    public static C4184i6 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4184i6) MessageNano.mergeFrom(new C4184i6(), bArr);
    }
}
