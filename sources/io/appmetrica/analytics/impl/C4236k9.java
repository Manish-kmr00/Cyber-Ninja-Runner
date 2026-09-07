package io.appmetrica.analytics.impl;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.k9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4236k9 extends MessageNano {
    public static final int A = 17;
    public static final int B = 18;
    public static final int C = 19;
    public static final int D = 20;
    public static final int E = 21;
    public static final int F = 25;
    public static final int G = 26;
    public static final int H = 27;
    public static final int I = 29;
    public static final int J = 35;
    public static final int K = 38;
    public static final int L = 40;
    public static final int M = 42;
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 0;
    public static final int R = 1;
    public static volatile C4236k9[] S = null;
    public static final int t = 1;
    public static final int u = 2;
    public static final int v = 4;
    public static final int w = 5;
    public static final int x = 7;
    public static final int y = 13;
    public static final int z = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11634a;
    public long b;
    public int c;
    public String d;
    public byte[] e;
    public C4112f9 f;
    public C4211j9 g;
    public String h;
    public int i;
    public int j;
    public int k;
    public byte[] l;
    public int m;
    public long n;
    public long o;
    public int p;
    public boolean q;
    public long r;
    public C4187i9[] s;

    public C4236k9() {
        a();
    }

    public static C4236k9[] b() {
        if (S == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (S == null) {
                    S = new C4236k9[0];
                }
            }
        }
        return S;
    }

    public final C4236k9 a() {
        this.f11634a = 0L;
        this.b = 0L;
        this.c = 0;
        this.d = "";
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.e = bArr;
        this.f = null;
        this.g = null;
        this.h = "";
        this.i = 0;
        this.j = 0;
        this.k = -1;
        this.l = bArr;
        this.m = -1;
        this.n = 0L;
        this.o = 0L;
        this.p = 0;
        this.q = false;
        this.r = 1L;
        this.s = C4187i9.b();
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeUInt32Size = CodedOutputByteBufferNano.computeUInt32Size(3, this.c) + CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(1, this.f11634a) + super.computeSerializedSize();
        if (!this.d.equals("")) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        byte[] bArr = this.e;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(5, this.e);
        }
        C4112f9 c4112f9 = this.f;
        if (c4112f9 != null) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c4112f9);
        }
        C4211j9 c4211j9 = this.g;
        if (c4211j9 != null) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeMessageSize(7, c4211j9);
        }
        if (!this.h.equals("")) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeStringSize(8, this.h);
        }
        int i = this.i;
        if (i != 0) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeUInt32Size(10, i);
        }
        int i2 = this.j;
        if (i2 != 0) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeInt32Size(12, i2);
        }
        int i3 = this.k;
        if (i3 != -1) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeInt32Size(13, i3);
        }
        if (!Arrays.equals(this.l, bArr2)) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeBytesSize(14, this.l);
        }
        int i4 = this.m;
        if (i4 != -1) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeInt32Size(15, i4);
        }
        long j = this.n;
        if (j != 0) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeUInt64Size(16, j);
        }
        long j2 = this.o;
        if (j2 != 0) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeUInt64Size(17, j2);
        }
        int i5 = this.p;
        if (i5 != 0) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeInt32Size(22, i5);
        }
        boolean z2 = this.q;
        if (z2) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeBoolSize(23, z2);
        }
        long j3 = this.r;
        if (j3 != 1) {
            iComputeUInt32Size += CodedOutputByteBufferNano.computeUInt64Size(24, j3);
        }
        C4187i9[] c4187i9Arr = this.s;
        if (c4187i9Arr != null && c4187i9Arr.length > 0) {
            int i6 = 0;
            while (true) {
                C4187i9[] c4187i9Arr2 = this.s;
                if (i6 >= c4187i9Arr2.length) {
                    break;
                }
                C4187i9 c4187i9 = c4187i9Arr2[i6];
                if (c4187i9 != null) {
                    iComputeUInt32Size += CodedOutputByteBufferNano.computeMessageSize(25, c4187i9);
                }
                i6++;
            }
        }
        return iComputeUInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f11634a);
        codedOutputByteBufferNano.writeUInt64(2, this.b);
        codedOutputByteBufferNano.writeUInt32(3, this.c);
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        byte[] bArr = this.e;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.e);
        }
        C4112f9 c4112f9 = this.f;
        if (c4112f9 != null) {
            codedOutputByteBufferNano.writeMessage(6, c4112f9);
        }
        C4211j9 c4211j9 = this.g;
        if (c4211j9 != null) {
            codedOutputByteBufferNano.writeMessage(7, c4211j9);
        }
        if (!this.h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.h);
        }
        int i = this.i;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i);
        }
        int i2 = this.j;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i2);
        }
        int i3 = this.k;
        if (i3 != -1) {
            codedOutputByteBufferNano.writeInt32(13, i3);
        }
        if (!Arrays.equals(this.l, bArr2)) {
            codedOutputByteBufferNano.writeBytes(14, this.l);
        }
        int i4 = this.m;
        if (i4 != -1) {
            codedOutputByteBufferNano.writeInt32(15, i4);
        }
        long j = this.n;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j);
        }
        long j2 = this.o;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(17, j2);
        }
        int i5 = this.p;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(22, i5);
        }
        boolean z2 = this.q;
        if (z2) {
            codedOutputByteBufferNano.writeBool(23, z2);
        }
        long j3 = this.r;
        if (j3 != 1) {
            codedOutputByteBufferNano.writeUInt64(24, j3);
        }
        C4187i9[] c4187i9Arr = this.s;
        if (c4187i9Arr != null && c4187i9Arr.length > 0) {
            int i6 = 0;
            while (true) {
                C4187i9[] c4187i9Arr2 = this.s;
                if (i6 >= c4187i9Arr2.length) {
                    break;
                }
                C4187i9 c4187i9 = c4187i9Arr2[i6];
                if (c4187i9 != null) {
                    codedOutputByteBufferNano.writeMessage(25, c4187i9);
                }
                i6++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static C4236k9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C4236k9().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4236k9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.f11634a = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.b = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.c = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.e = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    if (this.f == null) {
                        this.f = new C4112f9();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    if (this.g == null) {
                        this.g = new C4211j9();
                    }
                    codedInputByteBufferNano.readMessage(this.g);
                    break;
                case 66:
                    this.h = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.i = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.j = int32;
                    }
                    break;
                case 104:
                    int int33 = codedInputByteBufferNano.readInt32();
                    if (int33 == -1 || int33 == 0 || int33 == 1) {
                        this.k = int33;
                    }
                    break;
                case 114:
                    this.l = codedInputByteBufferNano.readBytes();
                    break;
                case 120:
                    int int34 = codedInputByteBufferNano.readInt32();
                    if (int34 == -1 || int34 == 0 || int34 == 1) {
                        this.m = int34;
                    }
                    break;
                case 128:
                    this.n = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.o = codedInputByteBufferNano.readUInt64();
                    break;
                case 176:
                    int int35 = codedInputByteBufferNano.readInt32();
                    if (int35 == 0 || int35 == 1) {
                        this.p = int35;
                    }
                    break;
                case 184:
                    this.q = codedInputByteBufferNano.readBool();
                    break;
                case 192:
                    this.r = codedInputByteBufferNano.readUInt64();
                    break;
                case 202:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 202);
                    C4187i9[] c4187i9Arr = this.s;
                    int length = c4187i9Arr == null ? 0 : c4187i9Arr.length;
                    int i = repeatedFieldArrayLength + length;
                    C4187i9[] c4187i9Arr2 = new C4187i9[i];
                    if (length != 0) {
                        System.arraycopy(c4187i9Arr, 0, c4187i9Arr2, 0, length);
                    }
                    while (length < i - 1) {
                        C4187i9 c4187i9 = new C4187i9();
                        c4187i9Arr2[length] = c4187i9;
                        codedInputByteBufferNano.readMessage(c4187i9);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    C4187i9 c4187i10 = new C4187i9();
                    c4187i9Arr2[length] = c4187i10;
                    codedInputByteBufferNano.readMessage(c4187i10);
                    this.s = c4187i9Arr2;
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

    public static C4236k9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C4236k9) MessageNano.mergeFrom(new C4236k9(), bArr);
    }
}
