package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public boolean L;
    public r O;
    public int P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2027a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public com.fyber.inneractive.sdk.player.exoplayer2.drm.d i;
    public int j = -1;
    public int k = -1;
    public int l = -1;
    public int m = -1;
    public int n = 0;
    public byte[] o = null;
    public int p = -1;
    public boolean q = false;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = 1000;
    public int v = 200;
    public float w = -1.0f;
    public float x = -1.0f;
    public float y = -1.0f;
    public float z = -1.0f;
    public float A = -1.0f;
    public float B = -1.0f;
    public float C = -1.0f;
    public float D = -1.0f;
    public float E = -1.0f;
    public float F = -1.0f;
    public int G = 1;
    public int H = -1;
    public int I = 8000;
    public long J = 0;
    public long K = 0;
    public boolean M = true;
    public String N = "eng";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:238:0x0436  */
    /* JADX WARN: Code duplicated, block: B:239:0x0438  */
    /* JADX WARN: Code duplicated, block: B:242:0x0446  */
    /* JADX WARN: Code duplicated, block: B:243:0x0471  */
    /* JADX WARN: Code duplicated, block: B:245:0x047d  */
    /* JADX WARN: Code duplicated, block: B:247:0x0481  */
    /* JADX WARN: Code duplicated, block: B:249:0x0486  */
    /* JADX WARN: Code duplicated, block: B:252:0x048e  */
    /* JADX WARN: Code duplicated, block: B:254:0x0493  */
    /* JADX WARN: Code duplicated, block: B:257:0x049a  */
    /* JADX WARN: Code duplicated, block: B:260:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:263:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:265:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:285:0x0562  */
    /* JADX WARN: Code duplicated, block: B:287:0x0572  */
    /* JADX WARN: Code duplicated, block: B:289:0x059b  */
    /* JADX WARN: Code duplicated, block: B:291:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:293:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:295:0x05cc  */
    /* JADX WARN: Code duplicated, block: B:4:0x0024  */
    public final void a(j jVar, int i) {
        byte b;
        List listSingletonList;
        String str;
        int iA;
        List list;
        int i2;
        int i3;
        List listSingletonList2;
        List list2;
        List list3;
        String str2;
        int i4;
        int i5;
        int i6;
        o oVar;
        int i7;
        int i8;
        int i9;
        float f;
        com.fyber.inneractive.sdk.player.exoplayer2.video.c cVar;
        byte[] bArr;
        int i10;
        int i11;
        int i12;
        String str3 = this.f2027a;
        str3.getClass();
        str3.hashCode();
        int i13 = 3;
        int i14 = 2;
        switch (str3) {
            case "V_MPEG4/ISO/AP":
                b = 0;
                break;
            case "V_MPEG4/ISO/SP":
                b = 1;
                break;
            case "A_MS/ACM":
                b = 2;
                break;
            case "A_TRUEHD":
                b = 3;
                break;
            case "A_VORBIS":
                b = 4;
                break;
            case "A_MPEG/L2":
                b = 5;
                break;
            case "A_MPEG/L3":
                b = 6;
                break;
            case "V_MS/VFW/FOURCC":
                b = 7;
                break;
            case "S_DVBSUB":
                b = 8;
                break;
            case "V_MPEG4/ISO/ASP":
                b = 9;
                break;
            case "V_MPEG4/ISO/AVC":
                b = 10;
                break;
            case "S_VOBSUB":
                b = Ascii.VT;
                break;
            case "A_DTS/LOSSLESS":
                b = Ascii.FF;
                break;
            case "A_AAC":
                b = Ascii.CR;
                break;
            case "A_AC3":
                b = Ascii.SO;
                break;
            case "A_DTS":
                b = Ascii.SI;
                break;
            case "V_VP8":
                b = 16;
                break;
            case "V_VP9":
                b = 17;
                break;
            case "S_HDMV/PGS":
                b = 18;
                break;
            case "V_THEORA":
                b = 19;
                break;
            case "A_DTS/EXPRESS":
                b = Ascii.DC4;
                break;
            case "A_PCM/INT/LIT":
                b = Ascii.NAK;
                break;
            case "V_MPEGH/ISO/HEVC":
                b = Ascii.SYN;
                break;
            case "S_TEXT/UTF8":
                b = Ascii.ETB;
                break;
            case "V_MPEG2":
                b = 24;
                break;
            case "A_EAC3":
                b = Ascii.EM;
                break;
            case "A_FLAC":
                b = Ascii.SUB;
                break;
            case "A_OPUS":
                b = Ascii.ESC;
                break;
            default:
                b = -1;
                break;
        }
        String str4 = "audio/x-unknown";
        switch (b) {
            case 0:
            case 1:
            case 9:
                byte[] bArr2 = this.h;
                listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str = "video/mp4v-es";
                i4 = -1;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                } else if ("video".equals(i.b(str))) {
                    if (this.n == 0) {
                        i11 = this.l;
                        i8 = -1;
                        if (i11 == -1) {
                            i11 = this.j;
                        }
                        this.l = i11;
                        i12 = this.m;
                        if (i12 == -1) {
                            i12 = this.k;
                        }
                        this.m = i12;
                    } else {
                        i8 = -1;
                    }
                    i9 = this.l;
                    if (i9 != i8 || (i10 = this.m) == i8) {
                        f = -1.0f;
                    } else {
                        f = (this.k * i9) / (this.j * i10);
                    }
                    if (this.q) {
                        if (this.w != -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                            bArr = null;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                            byteBufferWrap.put((byte) 0);
                            byteBufferWrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) (this.E + 0.5f));
                            byteBufferWrap.putShort((short) (this.F + 0.5f));
                            byteBufferWrap.putShort((short) this.u);
                            byteBufferWrap.putShort((short) this.v);
                        }
                        cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                    } else {
                        cVar = null;
                    }
                    oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                    i7 = i14;
                } else {
                    if ("application/x-subrip".equals(str)) {
                        oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                    } else {
                        if ("application/vobsub".equals(str) && !"application/pgs".equals(str) && !"application/dvbsubs".equals(str)) {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Unexpected MIME type.");
                        }
                        oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                    }
                    i7 = i13;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA = jVar.a(this.b, i7);
                this.O = gVarA;
                gVarA.a(oVar);
                return;
            case 2:
                i13 = 3;
                i14 = 2;
                n nVar = new n(this.h);
                try {
                    int iF = nVar.f();
                    if (iF != 1) {
                        if (iF == 65534) {
                            nVar.e(24);
                            long jG = nVar.g();
                            UUID uuid = e.b0;
                            if (jG != uuid.getMostSignificantBits() || nVar.g() != uuid.getLeastSignificantBits()) {
                            }
                            list2 = null;
                            iA = -1;
                            i4 = iA;
                            listSingletonList = list2;
                            str = str4;
                            list = listSingletonList;
                            i2 = i4;
                            i3 = -1;
                            boolean z2 = this.M;
                            if (this.L) {
                                i5 = i14;
                            } else {
                                i5 = 0;
                            }
                            i6 = (z2 ? 1 : 0) | i5;
                            if ("audio".equals(i.b(str))) {
                                if ("video".equals(i.b(str))) {
                                    if (this.n == 0) {
                                        i11 = this.l;
                                        i8 = -1;
                                        if (i11 == -1) {
                                            i11 = this.j;
                                        }
                                        this.l = i11;
                                        i12 = this.m;
                                        if (i12 == -1) {
                                            i12 = this.k;
                                        }
                                        this.m = i12;
                                    } else {
                                        i8 = -1;
                                    }
                                    i9 = this.l;
                                    if (i9 != i8) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (this.q) {
                                        if (this.w != -1.0f) {
                                            bArr = null;
                                        } else {
                                            bArr = null;
                                        }
                                        cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                                    } else {
                                        cVar = null;
                                    }
                                    oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                                    i7 = i14;
                                } else {
                                    if ("application/x-subrip".equals(str)) {
                                        oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                                    } else {
                                        if ("application/vobsub".equals(str)) {
                                        }
                                        oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                                    }
                                    i7 = i13;
                                }
                                break;
                            } else {
                                oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                                i7 = 1;
                            }
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA2 = jVar.a(this.b, i7);
                            this.O = gVarA2;
                            gVarA2.a(oVar);
                            return;
                        }
                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                        list2 = null;
                        iA = -1;
                        i4 = iA;
                        listSingletonList = list2;
                        str = str4;
                        list = listSingletonList;
                        i2 = i4;
                        i3 = -1;
                        boolean z3 = this.M;
                        if (this.L) {
                            i5 = i14;
                        } else {
                            i5 = 0;
                        }
                        i6 = (z3 ? 1 : 0) | i5;
                        if ("audio".equals(i.b(str))) {
                            if ("video".equals(i.b(str))) {
                                if (this.n == 0) {
                                    i11 = this.l;
                                    i8 = -1;
                                    if (i11 == -1) {
                                        i11 = this.j;
                                    }
                                    this.l = i11;
                                    i12 = this.m;
                                    if (i12 == -1) {
                                        i12 = this.k;
                                    }
                                    this.m = i12;
                                } else {
                                    i8 = -1;
                                }
                                i9 = this.l;
                                if (i9 != i8) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.q) {
                                    if (this.w != -1.0f) {
                                        bArr = null;
                                    } else {
                                        bArr = null;
                                    }
                                    cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                                } else {
                                    cVar = null;
                                }
                                oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                                i7 = i14;
                            } else {
                                if ("application/x-subrip".equals(str)) {
                                    oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                                } else {
                                    if ("application/vobsub".equals(str)) {
                                    }
                                    oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                                }
                                i7 = i13;
                            }
                            break;
                        } else {
                            oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                            i7 = 1;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA3 = jVar.a(this.b, i7);
                        this.O = gVarA3;
                        gVarA3.a(oVar);
                        return;
                    }
                    iA = z.a(this.H);
                    if (iA != 0) {
                        str4 = "audio/raw";
                        list2 = null;
                        i4 = iA;
                        listSingletonList = list2;
                        str = str4;
                        list = listSingletonList;
                        i2 = i4;
                        i3 = -1;
                        boolean z4 = this.M;
                        if (this.L) {
                            i5 = i14;
                        } else {
                            i5 = 0;
                        }
                        i6 = (z4 ? 1 : 0) | i5;
                        if ("audio".equals(i.b(str))) {
                            if ("video".equals(i.b(str))) {
                                if (this.n == 0) {
                                    i11 = this.l;
                                    i8 = -1;
                                    if (i11 == -1) {
                                        i11 = this.j;
                                    }
                                    this.l = i11;
                                    i12 = this.m;
                                    if (i12 == -1) {
                                        i12 = this.k;
                                    }
                                    this.m = i12;
                                } else {
                                    i8 = -1;
                                }
                                i9 = this.l;
                                if (i9 != i8) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.q) {
                                    if (this.w != -1.0f) {
                                        bArr = null;
                                    } else {
                                        bArr = null;
                                    }
                                    cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                                } else {
                                    cVar = null;
                                }
                                oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                                i7 = i14;
                            } else {
                                if ("application/x-subrip".equals(str)) {
                                    oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                                } else {
                                    if ("application/vobsub".equals(str)) {
                                    }
                                    oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                                }
                                i7 = i13;
                            }
                            break;
                        } else {
                            oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                            i7 = 1;
                        }
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA4 = jVar.a(this.b, i7);
                        this.O = gVarA4;
                        gVarA4.a(oVar);
                        return;
                    }
                    Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.H + ". Setting mimeType to audio/x-unknown");
                    list2 = null;
                    iA = -1;
                    i4 = iA;
                    listSingletonList = list2;
                    str = str4;
                    list = listSingletonList;
                    i2 = i4;
                    i3 = -1;
                    boolean z5 = this.M;
                    if (this.L) {
                        i5 = i14;
                    } else {
                        i5 = 0;
                    }
                    i6 = (z5 ? 1 : 0) | i5;
                    if ("audio".equals(i.b(str))) {
                        if ("video".equals(i.b(str))) {
                            if (this.n == 0) {
                                i11 = this.l;
                                i8 = -1;
                                if (i11 == -1) {
                                    i11 = this.j;
                                }
                                this.l = i11;
                                i12 = this.m;
                                if (i12 == -1) {
                                    i12 = this.k;
                                }
                                this.m = i12;
                            } else {
                                i8 = -1;
                            }
                            i9 = this.l;
                            if (i9 != i8) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.q) {
                                if (this.w != -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = null;
                                }
                                cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                            } else {
                                cVar = null;
                            }
                            oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                            i7 = i14;
                        } else {
                            if ("application/x-subrip".equals(str)) {
                                oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                            } else {
                                if ("application/vobsub".equals(str)) {
                                }
                                oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                            }
                            i7 = i13;
                        }
                        break;
                    } else {
                        oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                        i7 = 1;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA5 = jVar.a(this.b, i7);
                    this.O = gVarA5;
                    gVarA5.a(oVar);
                    return;
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing MS/ACM codec private");
                }
            case 3:
                i13 = 3;
                i14 = 2;
                str4 = "audio/true-hd";
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z6 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z6 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA6 = jVar.a(this.b, i7);
                this.O = gVarA6;
                gVarA6.a(oVar);
                return;
            case 4:
                byte[] bArr3 = this.h;
                try {
                    if (bArr3[0] != 2) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                    }
                    int i15 = 1;
                    int i16 = 0;
                    while (true) {
                        int i17 = bArr3[i15];
                        int i18 = -1;
                        if (i17 == -1) {
                            i16 += 255;
                            i15++;
                        } else {
                            int i19 = i15 + 1;
                            int i20 = i16 + i17;
                            int i21 = 0;
                            while (true) {
                                int i22 = bArr3[i19];
                                if (i22 != i18) {
                                    int i23 = i19 + 1;
                                    int i24 = i21 + i22;
                                    if (bArr3[i23] != 1) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                                    }
                                    byte[] bArr4 = new byte[i20];
                                    System.arraycopy(bArr3, i23, bArr4, 0, i20);
                                    int i25 = i23 + i20;
                                    i13 = 3;
                                    if (bArr3[i25] != 3) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                                    }
                                    int i26 = i25 + i24;
                                    if (bArr3[i26] != 5) {
                                        throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                                    }
                                    byte[] bArr5 = new byte[bArr3.length - i26];
                                    System.arraycopy(bArr3, i26, bArr5, 0, bArr3.length - i26);
                                    i14 = 2;
                                    ArrayList arrayList = new ArrayList(2);
                                    arrayList.add(bArr4);
                                    arrayList.add(bArr5);
                                    list = arrayList;
                                    i2 = -1;
                                    str = "audio/vorbis";
                                    i3 = 8192;
                                    boolean z7 = this.M;
                                    if (this.L) {
                                        i5 = i14;
                                    } else {
                                        i5 = 0;
                                    }
                                    i6 = (z7 ? 1 : 0) | i5;
                                    if ("audio".equals(i.b(str))) {
                                        if ("video".equals(i.b(str))) {
                                            if (this.n == 0) {
                                                i11 = this.l;
                                                i8 = -1;
                                                if (i11 == -1) {
                                                    i11 = this.j;
                                                }
                                                this.l = i11;
                                                i12 = this.m;
                                                if (i12 == -1) {
                                                    i12 = this.k;
                                                }
                                                this.m = i12;
                                            } else {
                                                i8 = -1;
                                            }
                                            i9 = this.l;
                                            if (i9 != i8) {
                                                f = -1.0f;
                                            } else {
                                                f = -1.0f;
                                            }
                                            if (this.q) {
                                                if (this.w != -1.0f) {
                                                    bArr = null;
                                                } else {
                                                    bArr = null;
                                                }
                                                cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                                            } else {
                                                cVar = null;
                                            }
                                            oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                                            i7 = i14;
                                        } else {
                                            if ("application/x-subrip".equals(str)) {
                                                oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                                            } else {
                                                if ("application/vobsub".equals(str)) {
                                                }
                                                oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                                            }
                                            i7 = i13;
                                        }
                                        break;
                                    } else {
                                        oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                                        i7 = 1;
                                    }
                                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA7 = jVar.a(this.b, i7);
                                    this.O = gVarA7;
                                    gVarA7.a(oVar);
                                    return;
                                }
                                i21 += 255;
                                i19++;
                                i18 = -1;
                            }
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException unused2) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing vorbis codec private");
                }
                break;
            case 5:
                str = "audio/mpeg-L2";
                i3 = 4096;
                list = null;
                i14 = 2;
                i13 = 3;
                i2 = -1;
                boolean z8 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z8 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA8 = jVar.a(this.b, i7);
                this.O = gVarA8;
                gVarA8.a(oVar);
                return;
            case 6:
                str = "audio/mpeg";
                i3 = 4096;
                list = null;
                i14 = 2;
                i13 = 3;
                i2 = -1;
                boolean z9 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z9 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA9 = jVar.a(this.b, i7);
                this.O = gVarA9;
                gVarA9.a(oVar);
                return;
            case 7:
                byte[] bArr6 = this.h;
                try {
                    if (16 > bArr6.length) {
                        throw new IllegalArgumentException();
                    }
                    if (((((long) bArr6[16]) & 255) | ((((long) bArr6[17]) & 255) << 8) | ((((long) bArr6[18]) & 255) << 16) | ((((long) bArr6[19]) & 255) << 24)) != 826496599) {
                        listSingletonList2 = null;
                    } else {
                        int i27 = 40;
                        while (true) {
                            if (i27 >= bArr6.length - 4) {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Failed to find FourCC VC1 initialization data");
                            }
                            if (bArr6[i27] == 0 && bArr6[i27 + 1] == 0 && bArr6[i27 + 2] == 1) {
                                if (bArr6[i27 + 3] == 15) {
                                    listSingletonList2 = Collections.singletonList(Arrays.copyOfRange(bArr6, i27, bArr6.length));
                                }
                            }
                            i27++;
                        }
                    }
                    if (listSingletonList2 != null) {
                        str4 = "video/wvc1";
                    } else {
                        Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                        str4 = "video/x-unknown";
                    }
                    list2 = listSingletonList2;
                    iA = -1;
                    i14 = 2;
                    i13 = 3;
                    i4 = iA;
                    listSingletonList = list2;
                    str = str4;
                    list = listSingletonList;
                    i2 = i4;
                    i3 = -1;
                    boolean z10 = this.M;
                    if (this.L) {
                        i5 = i14;
                    } else {
                        i5 = 0;
                    }
                    i6 = (z10 ? 1 : 0) | i5;
                    if ("audio".equals(i.b(str))) {
                        if ("video".equals(i.b(str))) {
                            if (this.n == 0) {
                                i11 = this.l;
                                i8 = -1;
                                if (i11 == -1) {
                                    i11 = this.j;
                                }
                                this.l = i11;
                                i12 = this.m;
                                if (i12 == -1) {
                                    i12 = this.k;
                                }
                                this.m = i12;
                            } else {
                                i8 = -1;
                            }
                            i9 = this.l;
                            if (i9 != i8) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.q) {
                                if (this.w != -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = null;
                                }
                                cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                            } else {
                                cVar = null;
                            }
                            oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                            i7 = i14;
                        } else {
                            if ("application/x-subrip".equals(str)) {
                                oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                            } else {
                                if ("application/vobsub".equals(str)) {
                                }
                                oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                            }
                            i7 = i13;
                        }
                        break;
                    } else {
                        oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                        i7 = 1;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA10 = jVar.a(this.b, i7);
                    this.O = gVarA10;
                    gVarA10.a(oVar);
                    return;
                } catch (ArrayIndexOutOfBoundsException unused3) {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Error parsing FourCC VC1 codec private");
                }
            case 8:
                byte[] bArr7 = this.h;
                listSingletonList = Collections.singletonList(new byte[]{bArr7[0], bArr7[1], bArr7[2], bArr7[3]});
                str = "application/dvbsubs";
                i4 = -1;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z11 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z11 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA11 = jVar.a(this.b, i7);
                this.O = gVarA11;
                gVarA11.a(oVar);
                return;
            case 10:
                com.fyber.inneractive.sdk.player.exoplayer2.video.a aVarA = com.fyber.inneractive.sdk.player.exoplayer2.video.a.a(new n(this.h));
                list3 = aVarA.f2194a;
                this.P = aVarA.b;
                str2 = "video/avc";
                i13 = 3;
                i14 = 2;
                i4 = -1;
                List list4 = list3;
                str = str2;
                listSingletonList = list4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z12 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z12 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA12 = jVar.a(this.b, i7);
                this.O = gVarA12;
                gVarA12.a(oVar);
                return;
            case 11:
                listSingletonList = Collections.singletonList(this.h);
                str = "application/vobsub";
                i4 = -1;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z13 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z13 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA13 = jVar.a(this.b, i7);
                this.O = gVarA13;
                gVarA13.a(oVar);
                return;
            case 12:
                str4 = "audio/vnd.dts.hd";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z14 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z14 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA14 = jVar.a(this.b, i7);
                this.O = gVarA14;
                gVarA14.a(oVar);
                return;
            case 13:
                listSingletonList = Collections.singletonList(this.h);
                str = "audio/mp4a-latm";
                i4 = -1;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z15 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z15 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA15 = jVar.a(this.b, i7);
                this.O = gVarA15;
                gVarA15.a(oVar);
                return;
            case 14:
                str4 = "audio/ac3";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z16 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z16 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA16 = jVar.a(this.b, i7);
                this.O = gVarA16;
                gVarA16.a(oVar);
                return;
            case 15:
            case 20:
                str4 = "audio/vnd.dts";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z17 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z17 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA17 = jVar.a(this.b, i7);
                this.O = gVarA17;
                gVarA17.a(oVar);
                return;
            case 16:
                str4 = "video/x-vnd.on2.vp8";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z18 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z18 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA18 = jVar.a(this.b, i7);
                this.O = gVarA18;
                gVarA18.a(oVar);
                return;
            case 17:
                str4 = "video/x-vnd.on2.vp9";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z19 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z19 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA19 = jVar.a(this.b, i7);
                this.O = gVarA19;
                gVarA19.a(oVar);
                return;
            case 18:
                str4 = "application/pgs";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z110 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z110 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA110 = jVar.a(this.b, i7);
                this.O = gVarA110;
                gVarA110.a(oVar);
                return;
            case 19:
                str4 = "video/x-unknown";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z111 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z111 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA111 = jVar.a(this.b, i7);
                this.O = gVarA111;
                gVarA111.a(oVar);
                return;
            case 21:
                iA = z.a(this.H);
                if (iA != 0) {
                    str4 = "audio/raw";
                    i13 = 3;
                    i14 = 2;
                    list2 = null;
                    i4 = iA;
                    listSingletonList = list2;
                    str = str4;
                    list = listSingletonList;
                    i2 = i4;
                    i3 = -1;
                    boolean z112 = this.M;
                    if (this.L) {
                        i5 = i14;
                    } else {
                        i5 = 0;
                    }
                    i6 = (z112 ? 1 : 0) | i5;
                    if ("audio".equals(i.b(str))) {
                        if ("video".equals(i.b(str))) {
                            if (this.n == 0) {
                                i11 = this.l;
                                i8 = -1;
                                if (i11 == -1) {
                                    i11 = this.j;
                                }
                                this.l = i11;
                                i12 = this.m;
                                if (i12 == -1) {
                                    i12 = this.k;
                                }
                                this.m = i12;
                            } else {
                                i8 = -1;
                            }
                            i9 = this.l;
                            if (i9 != i8) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.q) {
                                if (this.w != -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = null;
                                }
                                cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                            } else {
                                cVar = null;
                            }
                            oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                            i7 = i14;
                        } else {
                            if ("application/x-subrip".equals(str)) {
                                oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                            } else {
                                if ("application/vobsub".equals(str)) {
                                }
                                oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                            }
                            i7 = i13;
                        }
                        break;
                    } else {
                        oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                        i7 = 1;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA112 = jVar.a(this.b, i7);
                    this.O = gVarA112;
                    gVarA112.a(oVar);
                    return;
                }
                Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.H + ". Setting mimeType to audio/x-unknown");
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z113 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z113 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA113 = jVar.a(this.b, i7);
                this.O = gVarA113;
                gVarA113.a(oVar);
                return;
            case 22:
                com.fyber.inneractive.sdk.player.exoplayer2.video.d dVarA = com.fyber.inneractive.sdk.player.exoplayer2.video.d.a(new n(this.h));
                list3 = dVarA.f2196a;
                this.P = dVarA.b;
                str2 = "video/hevc";
                i13 = 3;
                i14 = 2;
                i4 = -1;
                List list5 = list3;
                str = str2;
                listSingletonList = list5;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z114 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z114 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA114 = jVar.a(this.b, i7);
                this.O = gVarA114;
                gVarA114.a(oVar);
                return;
            case 23:
                str4 = "application/x-subrip";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z115 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z115 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA115 = jVar.a(this.b, i7);
                this.O = gVarA115;
                gVarA115.a(oVar);
                return;
            case 24:
                str4 = "video/mpeg2";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z116 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z116 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA116 = jVar.a(this.b, i7);
                this.O = gVarA116;
                gVarA116.a(oVar);
                return;
            case 25:
                str4 = "audio/eac3";
                i13 = 3;
                i14 = 2;
                list2 = null;
                iA = -1;
                i4 = iA;
                listSingletonList = list2;
                str = str4;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z117 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z117 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA117 = jVar.a(this.b, i7);
                this.O = gVarA117;
                gVarA117.a(oVar);
                return;
            case 26:
                listSingletonList = Collections.singletonList(this.h);
                str = "audio/flac";
                i4 = -1;
                list = listSingletonList;
                i2 = i4;
                i3 = -1;
                boolean z118 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z118 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA118 = jVar.a(this.b, i7);
                this.O = gVarA118;
                gVarA118.a(oVar);
                return;
            case 27:
                ArrayList arrayList2 = new ArrayList(3);
                arrayList2.add(this.h);
                arrayList2.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                arrayList2.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                str = "audio/opus";
                list = arrayList2;
                i3 = 5760;
                i13 = 3;
                i14 = 2;
                i2 = -1;
                boolean z119 = this.M;
                if (this.L) {
                    i5 = i14;
                } else {
                    i5 = 0;
                }
                i6 = (z119 ? 1 : 0) | i5;
                if ("audio".equals(i.b(str))) {
                    if ("video".equals(i.b(str))) {
                        if (this.n == 0) {
                            i11 = this.l;
                            i8 = -1;
                            if (i11 == -1) {
                                i11 = this.j;
                            }
                            this.l = i11;
                            i12 = this.m;
                            if (i12 == -1) {
                                i12 = this.k;
                            }
                            this.m = i12;
                        } else {
                            i8 = -1;
                        }
                        i9 = this.l;
                        if (i9 != i8) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            cVar = new com.fyber.inneractive.sdk.player.exoplayer2.video.c(this.r, this.t, this.s, bArr);
                        } else {
                            cVar = null;
                        }
                        oVar = o.a(Integer.toString(i), str, i3, this.j, this.k, list, -1, f, this.o, this.p, cVar, this.i);
                        i7 = i14;
                    } else {
                        if ("application/x-subrip".equals(str)) {
                            oVar = o.a(Integer.toString(i), str, i6, this.N, -1, this.i, Long.MAX_VALUE, Collections.emptyList());
                        } else {
                            if ("application/vobsub".equals(str)) {
                            }
                            oVar = new o(Integer.toString(i), null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, this.N, -1, Long.MAX_VALUE, list, this.i, null);
                        }
                        i7 = i13;
                    }
                    break;
                } else {
                    oVar = o.a(Integer.toString(i), str, -1, i3, this.G, this.I, i2, -1, -1, list, this.i, i6, this.N, null);
                    i7 = 1;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVarA119 = jVar.a(this.b, i7);
                this.O = gVarA119;
                gVarA119.a(oVar);
                return;
            default:
                throw new com.fyber.inneractive.sdk.player.exoplayer2.r("Unrecognized codec identifier.");
        }
    }
}
