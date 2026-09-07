package io.appmetrica.analytics.impl;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class Zl extends MessageNano {
    public static final int E = -1;
    public static final int F = 0;
    public static final int G = 1;
    public static volatile Zl[] H;
    public Pl A;
    public Xl B;
    public Vl[] C;
    public Tl D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11452a;
    public long b;
    public String[] c;
    public String d;
    public String e;
    public String[] f;
    public String[] g;
    public Sl[] h;
    public Ul i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String[] o;
    public Yl p;
    public boolean q;
    public String r;
    public long s;
    public long t;
    public boolean u;
    public Wl v;
    public int w;
    public int x;
    public Rl y;
    public Ql z;

    public Zl() {
        a();
    }

    public static Zl[] b() {
        if (H == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (H == null) {
                    H = new Zl[0];
                }
            }
        }
        return H;
    }

    public final Zl a() {
        this.f11452a = "";
        this.b = 0L;
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.c = strArr;
        this.d = "";
        this.e = "";
        this.f = strArr;
        this.g = strArr;
        this.h = Sl.b();
        this.i = null;
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = false;
        this.n = "";
        this.o = strArr;
        this.p = null;
        this.q = false;
        this.r = "";
        this.s = 0L;
        this.t = 0L;
        this.u = false;
        this.v = null;
        this.w = 600;
        this.x = 1;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = Vl.b();
        this.D = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.f11452a.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f11452a);
        }
        int iComputeInt64Size = CodedOutputByteBufferNano.computeInt64Size(2, this.b) + iComputeSerializedSize;
        String[] strArr = this.c;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i2++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag + i3;
        }
        if (!this.d.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(4, this.d);
        }
        if (!this.e.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(5, this.e);
        }
        String[] strArr3 = this.f;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            int iComputeStringSizeNoTag2 = 0;
            int i5 = 0;
            while (true) {
                String[] strArr4 = this.f;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    i5++;
                    iComputeStringSizeNoTag2 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i4++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag2 + i5;
        }
        String[] strArr5 = this.g;
        if (strArr5 != null && strArr5.length > 0) {
            int i6 = 0;
            int iComputeStringSizeNoTag3 = 0;
            int i7 = 0;
            while (true) {
                String[] strArr6 = this.g;
                if (i6 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i6];
                if (str3 != null) {
                    i7++;
                    iComputeStringSizeNoTag3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i6++;
            }
            iComputeInt64Size = iComputeInt64Size + iComputeStringSizeNoTag3 + i7;
        }
        Sl[] slArr = this.h;
        if (slArr != null && slArr.length > 0) {
            int i8 = 0;
            while (true) {
                Sl[] slArr2 = this.h;
                if (i8 >= slArr2.length) {
                    break;
                }
                Sl sl = slArr2[i8];
                if (sl != null) {
                    iComputeInt64Size += CodedOutputByteBufferNano.computeMessageSize(8, sl);
                }
                i8++;
            }
        }
        Ul ul = this.i;
        if (ul != null) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeMessageSize(9, ul);
        }
        if (!this.j.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(10, this.j);
        }
        if (!this.k.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(11, this.k);
        }
        if (!this.l.equals("")) {
            iComputeInt64Size += CodedOutputByteBufferNano.computeStringSize(12, this.l);
        }
        int iComputeBoolSize = CodedOutputByteBufferNano.computeBoolSize(13, this.m) + iComputeInt64Size;
        if (!this.n.equals("")) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeStringSize(14, this.n);
        }
        String[] strArr7 = this.o;
        if (strArr7 != null && strArr7.length > 0) {
            int i9 = 0;
            int iComputeStringSizeNoTag4 = 0;
            int i10 = 0;
            while (true) {
                String[] strArr8 = this.o;
                if (i9 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i9];
                if (str4 != null) {
                    i10++;
                    iComputeStringSizeNoTag4 += CodedOutputByteBufferNano.computeStringSizeNoTag(str4);
                }
                i9++;
            }
            iComputeBoolSize = iComputeBoolSize + iComputeStringSizeNoTag4 + i10;
        }
        Yl yl = this.p;
        if (yl != null) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeMessageSize(16, yl);
        }
        boolean z = this.q;
        if (z) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        if (!this.r.equals("")) {
            iComputeBoolSize += CodedOutputByteBufferNano.computeStringSize(20, this.r);
        }
        int iComputeInt64Size2 = CodedOutputByteBufferNano.computeInt64Size(22, this.t) + CodedOutputByteBufferNano.computeInt64Size(21, this.s) + iComputeBoolSize;
        boolean z2 = this.u;
        if (z2) {
            iComputeInt64Size2 += CodedOutputByteBufferNano.computeBoolSize(23, z2);
        }
        Wl wl = this.v;
        if (wl != null) {
            iComputeInt64Size2 += CodedOutputByteBufferNano.computeMessageSize(24, wl);
        }
        int iComputeInt32Size = CodedOutputByteBufferNano.computeInt32Size(26, this.x) + CodedOutputByteBufferNano.computeInt32Size(25, this.w) + iComputeInt64Size2;
        Rl rl = this.y;
        if (rl != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(27, rl);
        }
        Ql ql = this.z;
        if (ql != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(28, ql);
        }
        Pl pl = this.A;
        if (pl != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(29, pl);
        }
        Xl xl = this.B;
        if (xl != null) {
            iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(30, xl);
        }
        Vl[] vlArr = this.C;
        if (vlArr != null && vlArr.length > 0) {
            while (true) {
                Vl[] vlArr2 = this.C;
                if (i >= vlArr2.length) {
                    break;
                }
                Vl vl = vlArr2[i];
                if (vl != null) {
                    iComputeInt32Size += CodedOutputByteBufferNano.computeMessageSize(31, vl);
                }
                i++;
            }
        }
        Tl tl = this.D;
        return tl != null ? iComputeInt32Size + CodedOutputByteBufferNano.computeMessageSize(32, tl) : iComputeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f11452a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f11452a);
        }
        codedOutputByteBufferNano.writeInt64(2, this.b);
        String[] strArr = this.c;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.c;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i2++;
            }
        }
        if (!this.d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.d);
        }
        if (!this.e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.e);
        }
        String[] strArr3 = this.f;
        if (strArr3 != null && strArr3.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr4 = this.f;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(6, str2);
                }
                i3++;
            }
        }
        String[] strArr5 = this.g;
        if (strArr5 != null && strArr5.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr6 = this.g;
                if (i4 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i4];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(7, str3);
                }
                i4++;
            }
        }
        Sl[] slArr = this.h;
        if (slArr != null && slArr.length > 0) {
            int i5 = 0;
            while (true) {
                Sl[] slArr2 = this.h;
                if (i5 >= slArr2.length) {
                    break;
                }
                Sl sl = slArr2[i5];
                if (sl != null) {
                    codedOutputByteBufferNano.writeMessage(8, sl);
                }
                i5++;
            }
        }
        Ul ul = this.i;
        if (ul != null) {
            codedOutputByteBufferNano.writeMessage(9, ul);
        }
        if (!this.j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.j);
        }
        if (!this.k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.k);
        }
        if (!this.l.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.l);
        }
        codedOutputByteBufferNano.writeBool(13, this.m);
        if (!this.n.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.n);
        }
        String[] strArr7 = this.o;
        if (strArr7 != null && strArr7.length > 0) {
            int i6 = 0;
            while (true) {
                String[] strArr8 = this.o;
                if (i6 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i6];
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(15, str4);
                }
                i6++;
            }
        }
        Yl yl = this.p;
        if (yl != null) {
            codedOutputByteBufferNano.writeMessage(16, yl);
        }
        boolean z = this.q;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        if (!this.r.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.r);
        }
        codedOutputByteBufferNano.writeInt64(21, this.s);
        codedOutputByteBufferNano.writeInt64(22, this.t);
        boolean z2 = this.u;
        if (z2) {
            codedOutputByteBufferNano.writeBool(23, z2);
        }
        Wl wl = this.v;
        if (wl != null) {
            codedOutputByteBufferNano.writeMessage(24, wl);
        }
        codedOutputByteBufferNano.writeInt32(25, this.w);
        codedOutputByteBufferNano.writeInt32(26, this.x);
        Rl rl = this.y;
        if (rl != null) {
            codedOutputByteBufferNano.writeMessage(27, rl);
        }
        Ql ql = this.z;
        if (ql != null) {
            codedOutputByteBufferNano.writeMessage(28, ql);
        }
        Pl pl = this.A;
        if (pl != null) {
            codedOutputByteBufferNano.writeMessage(29, pl);
        }
        Xl xl = this.B;
        if (xl != null) {
            codedOutputByteBufferNano.writeMessage(30, xl);
        }
        Vl[] vlArr = this.C;
        if (vlArr != null && vlArr.length > 0) {
            while (true) {
                Vl[] vlArr2 = this.C;
                if (i >= vlArr2.length) {
                    break;
                }
                Vl vl = vlArr2[i];
                if (vl != null) {
                    codedOutputByteBufferNano.writeMessage(31, vl);
                }
                i++;
            }
        }
        Tl tl = this.D;
        if (tl != null) {
            codedOutputByteBufferNano.writeMessage(32, tl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Zl b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Zl().mergeFrom(codedInputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Zl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.f11452a = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.b = codedInputByteBufferNano.readInt64();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr = this.c;
                    int length = strArr == null ? 0 : strArr.length;
                    int i = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.c = strArr2;
                    break;
                case 34:
                    this.d = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr3 = this.f;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    int i2 = repeatedFieldArrayLength2 + length2;
                    String[] strArr4 = new String[i2];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i2 - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.f = strArr4;
                    break;
                case TokenParametersOuterClass$TokenParameters.LASTADVERTISEDBUNDLES_FIELD_NUMBER /* 58 */:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    String[] strArr5 = this.g;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    int i3 = repeatedFieldArrayLength3 + length3;
                    String[] strArr6 = new String[i3];
                    if (length3 != 0) {
                        System.arraycopy(strArr5, 0, strArr6, 0, length3);
                    }
                    while (length3 < i3 - 1) {
                        strArr6[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr6[length3] = codedInputByteBufferNano.readString();
                    this.g = strArr6;
                    break;
                case 66:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    Sl[] slArr = this.h;
                    int length4 = slArr == null ? 0 : slArr.length;
                    int i4 = repeatedFieldArrayLength4 + length4;
                    Sl[] slArr2 = new Sl[i4];
                    if (length4 != 0) {
                        System.arraycopy(slArr, 0, slArr2, 0, length4);
                    }
                    while (length4 < i4 - 1) {
                        Sl sl = new Sl();
                        slArr2[length4] = sl;
                        codedInputByteBufferNano.readMessage(sl);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    Sl sl2 = new Sl();
                    slArr2[length4] = sl2;
                    codedInputByteBufferNano.readMessage(sl2);
                    this.h = slArr2;
                    break;
                case 74:
                    if (this.i == null) {
                        this.i = new Ul();
                    }
                    codedInputByteBufferNano.readMessage(this.i);
                    break;
                case IronSourceConstants.TROUBLESHOOTING_AD_QUALITY_SDK_WAS_ALREADY_INITIALIZED_EVENT /* 82 */:
                    this.j = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.k = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.l = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.m = codedInputByteBufferNano.readBool();
                    break;
                case 114:
                    this.n = codedInputByteBufferNano.readString();
                    break;
                case INVALID_ADS_ENDPOINT_VALUE:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE);
                    String[] strArr7 = this.o;
                    int length5 = strArr7 == null ? 0 : strArr7.length;
                    int i5 = repeatedFieldArrayLength5 + length5;
                    String[] strArr8 = new String[i5];
                    if (length5 != 0) {
                        System.arraycopy(strArr7, 0, strArr8, 0, length5);
                    }
                    while (length5 < i5 - 1) {
                        strArr8[length5] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    strArr8[length5] = codedInputByteBufferNano.readString();
                    this.o = strArr8;
                    break;
                case 130:
                    if (this.p == null) {
                        this.p = new Yl();
                    }
                    codedInputByteBufferNano.readMessage(this.p);
                    break;
                case 136:
                    this.q = codedInputByteBufferNano.readBool();
                    break;
                case 162:
                    this.r = codedInputByteBufferNano.readString();
                    break;
                case 168:
                    this.s = codedInputByteBufferNano.readInt64();
                    break;
                case 176:
                    this.t = codedInputByteBufferNano.readInt64();
                    break;
                case 184:
                    this.u = codedInputByteBufferNano.readBool();
                    break;
                case 194:
                    if (this.v == null) {
                        this.v = new Wl();
                    }
                    codedInputByteBufferNano.readMessage(this.v);
                    break;
                case 200:
                    this.w = codedInputByteBufferNano.readInt32();
                    break;
                case 208:
                    this.x = codedInputByteBufferNano.readInt32();
                    break;
                case MRAID_JS_DOES_NOT_EXIST_VALUE:
                    if (this.y == null) {
                        this.y = new Rl();
                    }
                    codedInputByteBufferNano.readMessage(this.y);
                    break;
                case 226:
                    if (this.z == null) {
                        this.z = new Ql();
                    }
                    codedInputByteBufferNano.readMessage(this.z);
                    break;
                case 234:
                    if (this.A == null) {
                        this.A = new Pl();
                    }
                    codedInputByteBufferNano.readMessage(this.A);
                    break;
                case 242:
                    if (this.B == null) {
                        this.B = new Xl();
                    }
                    codedInputByteBufferNano.readMessage(this.B);
                    break;
                case 250:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 250);
                    Vl[] vlArr = this.C;
                    int length6 = vlArr == null ? 0 : vlArr.length;
                    int i6 = repeatedFieldArrayLength6 + length6;
                    Vl[] vlArr2 = new Vl[i6];
                    if (length6 != 0) {
                        System.arraycopy(vlArr, 0, vlArr2, 0, length6);
                    }
                    while (length6 < i6 - 1) {
                        Vl vl = new Vl();
                        vlArr2[length6] = vl;
                        codedInputByteBufferNano.readMessage(vl);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    Vl vl2 = new Vl();
                    vlArr2[length6] = vl2;
                    codedInputByteBufferNano.readMessage(vl2);
                    this.C = vlArr2;
                    break;
                case 258:
                    if (this.D == null) {
                        this.D = new Tl();
                    }
                    codedInputByteBufferNano.readMessage(this.D);
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

    public static Zl a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Zl) MessageNano.mergeFrom(new Zl(), bArr);
    }
}
