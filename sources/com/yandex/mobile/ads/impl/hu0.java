package com.yandex.mobile.ads.impl;

import android.util.Pair;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes8.dex */
public final class hu0 implements w70 {
    private static final byte[] c0;
    private static final byte[] d0;
    private static final byte[] e0;
    private static final byte[] f0;
    private static final UUID g0;
    private static final Map<String, Integer> h0;
    private long A;
    private long B;
    private ct0 C;
    private ct0 D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private byte Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x40 f9135a;
    private boolean a0;
    private final i92 b;
    private y70 b0;
    private final SparseArray<b> c;
    private final boolean d;
    private final wf1 e;
    private final wf1 f;
    private final wf1 g;
    private final wf1 h;
    private final wf1 i;
    private final wf1 j;
    private final wf1 k;
    private final wf1 l;
    private final wf1 m;
    private final wf1 n;
    private ByteBuffer o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private b u;
    private boolean v;
    private int w;
    private long x;
    private boolean y;
    private long z;

    /* JADX INFO: Access modifiers changed from: private */
    final class a implements w40 {
        public final void a(int i, int i2, tz tzVar) throws IOException {
            int i3;
            long j;
            int i4;
            int i5;
            int i6;
            hu0 hu0Var = hu0.this;
            hu0Var.getClass();
            int i7 = 4;
            int i8 = 1;
            int i9 = 0;
            if (i != 161 && i != 163) {
                if (i == 165) {
                    if (hu0Var.G != 2) {
                        return;
                    }
                    b bVar = (b) hu0Var.c.get(hu0Var.M);
                    if (hu0Var.P != 4 || !"V_VP9".equals(bVar.b)) {
                        tzVar.a(i2);
                        return;
                    } else {
                        hu0Var.n.c(i2);
                        tzVar.a(hu0Var.n.c(), 0, i2, false);
                        return;
                    }
                }
                if (i == 16877) {
                    hu0Var.a(i);
                    b bVar2 = hu0Var.u;
                    int i10 = bVar2.g;
                    if (i10 != 1685485123 && i10 != 1685480259) {
                        tzVar.a(i2);
                        return;
                    }
                    byte[] bArr = new byte[i2];
                    bVar2.N = bArr;
                    tzVar.a(bArr, 0, i2, false);
                    return;
                }
                if (i == 16981) {
                    hu0Var.a(i);
                    byte[] bArr2 = new byte[i2];
                    hu0Var.u.i = bArr2;
                    tzVar.a(bArr2, 0, i2, false);
                    return;
                }
                if (i == 18402) {
                    byte[] bArr3 = new byte[i2];
                    tzVar.a(bArr3, 0, i2, false);
                    hu0Var.a(i);
                    hu0Var.u.j = new t52.a(1, 0, 0, bArr3);
                    return;
                }
                if (i == 21419) {
                    Arrays.fill(hu0Var.i.c(), (byte) 0);
                    tzVar.a(hu0Var.i.c(), 4 - i2, i2, false);
                    hu0Var.i.e(0);
                    hu0Var.w = (int) hu0Var.i.v();
                    return;
                }
                if (i == 25506) {
                    hu0Var.a(i);
                    byte[] bArr4 = new byte[i2];
                    hu0Var.u.k = bArr4;
                    tzVar.a(bArr4, 0, i2, false);
                    return;
                }
                if (i != 30322) {
                    throw ag1.a("Unexpected id: " + i, (Exception) null);
                }
                hu0Var.a(i);
                byte[] bArr5 = new byte[i2];
                hu0Var.u.v = bArr5;
                tzVar.a(bArr5, 0, i2, false);
                return;
            }
            if (hu0Var.G == 0) {
                hu0Var.M = (int) hu0Var.b.a(tzVar, false, true, 8);
                hu0Var.N = hu0Var.b.a();
                hu0Var.I = -9223372036854775807L;
                hu0Var.G = 1;
                hu0Var.g.c(0);
            }
            b bVar3 = (b) hu0Var.c.get(hu0Var.M);
            if (bVar3 == null) {
                tzVar.a(i2 - hu0Var.N);
                hu0Var.G = 0;
                return;
            }
            bVar3.X.getClass();
            if (hu0Var.G == 1) {
                hu0Var.a(tzVar, 3);
                int i11 = (hu0Var.g.c()[2] & 6) >> 1;
                if (i11 == 0) {
                    hu0Var.K = 1;
                    int[] iArr = hu0Var.L;
                    if (iArr == null) {
                        iArr = new int[1];
                    } else if (iArr.length < 1) {
                        iArr = new int[Math.max(iArr.length * 2, 1)];
                    }
                    hu0Var.L = iArr;
                    iArr[0] = (i2 - hu0Var.N) - 3;
                } else {
                    hu0Var.a(tzVar, 4);
                    int i12 = (hu0Var.g.c()[3] & 255) + 1;
                    hu0Var.K = i12;
                    int[] iArr2 = hu0Var.L;
                    if (iArr2 == null) {
                        iArr2 = new int[i12];
                    } else if (iArr2.length < i12) {
                        iArr2 = new int[Math.max(iArr2.length * 2, i12)];
                    }
                    hu0Var.L = iArr2;
                    if (i11 == 2) {
                        int i13 = (i2 - hu0Var.N) - 4;
                        int i14 = hu0Var.K;
                        Arrays.fill(iArr2, 0, i14, i13 / i14);
                    } else if (i11 == 1) {
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i4 = hu0Var.K - 1;
                            if (i15 >= i4) {
                                break;
                            }
                            hu0Var.L[i15] = 0;
                            while (true) {
                                i5 = i7 + 1;
                                hu0Var.a(tzVar, i5);
                                int i17 = hu0Var.g.c()[i7] & 255;
                                int[] iArr3 = hu0Var.L;
                                i6 = iArr3[i15] + i17;
                                iArr3[i15] = i6;
                                if (i17 != 255) {
                                    break;
                                } else {
                                    i7 = i5;
                                }
                            }
                            i16 += i6;
                            i15++;
                            i7 = i5;
                        }
                        hu0Var.L[i4] = ((i2 - hu0Var.N) - i7) - i16;
                    } else {
                        if (i11 != 3) {
                            throw ag1.a("Unexpected lacing value: " + i11, (Exception) null);
                        }
                        int i18 = 0;
                        int i19 = 0;
                        while (true) {
                            int i20 = hu0Var.K - i8;
                            if (i18 >= i20) {
                                hu0Var.L[i20] = ((i2 - hu0Var.N) - i7) - i19;
                                break;
                            }
                            hu0Var.L[i18] = i9;
                            int i21 = i7 + 1;
                            hu0Var.a(tzVar, i21);
                            if (hu0Var.g.c()[i7] == 0) {
                                throw ag1.a("No valid varint length mask found", (Exception) null);
                            }
                            int i22 = i9;
                            int i23 = 8;
                            while (true) {
                                if (i22 >= i23) {
                                    j = 0;
                                    i7 = i21;
                                    break;
                                }
                                int i24 = i8 << (7 - i22);
                                if ((hu0Var.g.c()[i7] & i24) != 0) {
                                    int i25 = i21 + i22;
                                    hu0Var.a(tzVar, i25);
                                    j = hu0Var.g.c()[i7] & 255 & (~i24);
                                    while (i21 < i25) {
                                        j = (j << 8) | ((long) (hu0Var.g.c()[i21] & 255));
                                        i21++;
                                    }
                                    if (i18 > 0) {
                                        j -= (1 << ((i22 * 7) + 6)) - 1;
                                    }
                                    i7 = i25;
                                    break;
                                }
                                i22++;
                                i23 = 8;
                                i8 = 1;
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                throw ag1.a("EBML lacing sample size out of range.", (Exception) null);
                            }
                            int i26 = (int) j;
                            int[] iArr4 = hu0Var.L;
                            if (i18 != 0) {
                                i26 += iArr4[i18 - 1];
                            }
                            iArr4[i18] = i26;
                            i19 += i26;
                            i18++;
                            i8 = 1;
                            i9 = 0;
                        }
                    }
                }
                hu0Var.H = hu0Var.B + hu0Var.a((hu0Var.g.c()[0] << 8) | (hu0Var.g.c()[1] & 255));
                hu0Var.O = (bVar3.d == 2 || (i == 163 && (hu0Var.g.c()[2] & 128) == 128)) ? 1 : 0;
                hu0Var.G = 2;
                hu0Var.J = 0;
                i3 = 163;
            } else {
                i3 = 163;
            }
            if (i == i3) {
                while (true) {
                    int i27 = hu0Var.J;
                    if (i27 >= hu0Var.K) {
                        hu0Var.G = 0;
                        return;
                    } else {
                        hu0Var.a(bVar3, hu0Var.H + ((long) ((hu0Var.J * bVar3.e) / 1000)), hu0Var.O, hu0Var.a(tzVar, bVar3, hu0Var.L[i27], false), 0);
                        hu0Var.J++;
                    }
                }
            } else {
                while (true) {
                    int i28 = hu0Var.J;
                    if (i28 >= hu0Var.K) {
                        return;
                    }
                    int[] iArr5 = hu0Var.L;
                    iArr5[i28] = hu0Var.a(tzVar, bVar3, iArr5[i28], true);
                    hu0Var.J++;
                }
            }
        }

        private a() {
        }

        public final void a(int i, double d) throws ag1 {
            hu0 hu0Var = hu0.this;
            if (i == 181) {
                hu0Var.a(i);
                hu0Var.u.Q = (int) d;
                return;
            }
            if (i != 17545) {
                switch (i) {
                    case 21969:
                        hu0Var.a(i);
                        hu0Var.u.D = (float) d;
                        break;
                    case 21970:
                        hu0Var.a(i);
                        hu0Var.u.E = (float) d;
                        break;
                    case 21971:
                        hu0Var.a(i);
                        hu0Var.u.F = (float) d;
                        break;
                    case 21972:
                        hu0Var.a(i);
                        hu0Var.u.G = (float) d;
                        break;
                    case 21973:
                        hu0Var.a(i);
                        hu0Var.u.H = (float) d;
                        break;
                    case 21974:
                        hu0Var.a(i);
                        hu0Var.u.I = (float) d;
                        break;
                    case 21975:
                        hu0Var.a(i);
                        hu0Var.u.J = (float) d;
                        break;
                    case 21976:
                        hu0Var.a(i);
                        hu0Var.u.K = (float) d;
                        break;
                    case 21977:
                        hu0Var.a(i);
                        hu0Var.u.L = (float) d;
                        break;
                    case 21978:
                        hu0Var.a(i);
                        hu0Var.u.M = (float) d;
                        break;
                    default:
                        switch (i) {
                            case 30323:
                                hu0Var.a(i);
                                hu0Var.u.s = (float) d;
                                break;
                            case 30324:
                                hu0Var.a(i);
                                hu0Var.u.t = (float) d;
                                break;
                            case 30325:
                                hu0Var.a(i);
                                hu0Var.u.u = (float) d;
                                break;
                            default:
                                hu0Var.getClass();
                                break;
                        }
                        break;
                }
                return;
            }
            hu0Var.s = (long) d;
        }

        public final void a(int i, long j) throws ag1 {
            ct0 ct0Var;
            hu0 hu0Var = hu0.this;
            hu0Var.getClass();
            if (i == 20529) {
                if (j != 0) {
                    throw ag1.a("ContentEncodingOrder " + j + " not supported", (Exception) null);
                }
                return;
            }
            if (i == 20530) {
                if (j != 1) {
                    throw ag1.a("ContentEncodingScope " + j + " not supported", (Exception) null);
                }
                return;
            }
            int i2 = 3;
            int i3 = 2;
            switch (i) {
                case MRAID_JS_WRITE_FAILED_VALUE:
                    hu0Var.a(i);
                    hu0Var.u.d = (int) j;
                    return;
                case 136:
                    hu0Var.a(i);
                    hu0Var.u.V = j == 1;
                    return;
                case 155:
                    hu0Var.I = hu0Var.a(j);
                    return;
                case 159:
                    hu0Var.a(i);
                    hu0Var.u.O = (int) j;
                    return;
                case 176:
                    hu0Var.a(i);
                    hu0Var.u.m = (int) j;
                    return;
                case 179:
                    ct0 ct0Var2 = hu0Var.C;
                    if (ct0Var2 != null && hu0Var.D != null) {
                        ct0Var2.a(hu0Var.a(j));
                        return;
                    }
                    throw ag1.a("Element " + i + " must be in a Cues", (Exception) null);
                case 186:
                    hu0Var.a(i);
                    hu0Var.u.n = (int) j;
                    return;
                case AD_RESPONSE_EMPTY_VALUE:
                    hu0Var.a(i);
                    hu0Var.u.c = (int) j;
                    return;
                case 231:
                    hu0Var.B = hu0Var.a(j);
                    return;
                case 238:
                    hu0Var.P = (int) j;
                    return;
                case 241:
                    if (hu0Var.E) {
                        return;
                    }
                    if (hu0Var.C != null && (ct0Var = hu0Var.D) != null) {
                        ct0Var.a(j);
                        hu0Var.E = true;
                        return;
                    }
                    throw ag1.a("Element " + i + " must be in a Cues", (Exception) null);
                case 251:
                    hu0Var.Q = true;
                    return;
                case 16871:
                    hu0Var.a(i);
                    hu0Var.u.g = (int) j;
                    return;
                case 16980:
                    if (j != 3) {
                        throw ag1.a("ContentCompAlgo " + j + " not supported", (Exception) null);
                    }
                    return;
                case 17029:
                    if (j < 1 || j > 2) {
                        throw ag1.a("DocTypeReadVersion " + j + " not supported", (Exception) null);
                    }
                    return;
                case 17143:
                    if (j != 1) {
                        throw ag1.a("EBMLReadVersion " + j + " not supported", (Exception) null);
                    }
                    return;
                case 18401:
                    if (j != 5) {
                        throw ag1.a("ContentEncAlgo " + j + " not supported", (Exception) null);
                    }
                    return;
                case 18408:
                    if (j != 1) {
                        throw ag1.a("AESSettingsCipherMode " + j + " not supported", (Exception) null);
                    }
                    return;
                case 21420:
                    hu0Var.x = j + hu0Var.q;
                    return;
                case 21432:
                    int i4 = (int) j;
                    hu0Var.a(i);
                    if (i4 == 0) {
                        hu0Var.u.w = 0;
                        return;
                    }
                    if (i4 == 1) {
                        hu0Var.u.w = 2;
                        return;
                    } else if (i4 == 3) {
                        hu0Var.u.w = 1;
                        return;
                    } else {
                        if (i4 != 15) {
                            return;
                        }
                        hu0Var.u.w = 3;
                        return;
                    }
                case 21680:
                    hu0Var.a(i);
                    hu0Var.u.o = (int) j;
                    return;
                case 21682:
                    hu0Var.a(i);
                    hu0Var.u.q = (int) j;
                    return;
                case 21690:
                    hu0Var.a(i);
                    hu0Var.u.p = (int) j;
                    return;
                case 21930:
                    hu0Var.a(i);
                    hu0Var.u.U = j == 1;
                    return;
                case 21998:
                    hu0Var.a(i);
                    hu0Var.u.f = (int) j;
                    return;
                case 22186:
                    hu0Var.a(i);
                    hu0Var.u.R = j;
                    return;
                case 22203:
                    hu0Var.a(i);
                    hu0Var.u.S = j;
                    return;
                case 25188:
                    hu0Var.a(i);
                    hu0Var.u.P = (int) j;
                    return;
                case 30114:
                    hu0Var.R = j;
                    return;
                case 30321:
                    hu0Var.a(i);
                    int i5 = (int) j;
                    if (i5 == 0) {
                        hu0Var.u.r = 0;
                        return;
                    }
                    if (i5 == 1) {
                        hu0Var.u.r = 1;
                        return;
                    } else if (i5 == 2) {
                        hu0Var.u.r = 2;
                        return;
                    } else {
                        if (i5 != 3) {
                            return;
                        }
                        hu0Var.u.r = 3;
                        return;
                    }
                case 2352003:
                    hu0Var.a(i);
                    hu0Var.u.e = (int) j;
                    return;
                case 2807729:
                    hu0Var.r = j;
                    return;
                default:
                    switch (i) {
                        case 21945:
                            hu0Var.a(i);
                            int i6 = (int) j;
                            if (i6 == 1) {
                                hu0Var.u.A = 2;
                                return;
                            } else {
                                if (i6 != 2) {
                                    return;
                                }
                                hu0Var.u.A = 1;
                                return;
                            }
                        case 21946:
                            hu0Var.a(i);
                            int i7 = (int) j;
                            jm.a<pq> aVar = pq.g;
                            if (i7 != 1) {
                                if (i7 == 16) {
                                    i2 = 6;
                                } else if (i7 == 18) {
                                    i2 = 7;
                                } else if (i7 != 6 && i7 != 7) {
                                    i2 = -1;
                                }
                            }
                            if (i2 != -1) {
                                hu0Var.u.z = i2;
                                return;
                            }
                            return;
                        case 21947:
                            hu0Var.a(i);
                            b bVar = hu0Var.u;
                            bVar.x = true;
                            int i8 = (int) j;
                            jm.a<pq> aVar2 = pq.g;
                            if (i8 == 1) {
                                i3 = 1;
                            } else if (i8 == 9) {
                                i3 = 6;
                            } else if (i8 != 4 && i8 != 5 && i8 != 6 && i8 != 7) {
                                i3 = -1;
                            }
                            if (i3 != -1) {
                                bVar.y = i3;
                                return;
                            }
                            return;
                        case 21948:
                            hu0Var.a(i);
                            hu0Var.u.B = (int) j;
                            return;
                        case 21949:
                            hu0Var.a(i);
                            hu0Var.u.C = (int) j;
                            return;
                        default:
                            return;
                    }
            }
        }

        public final void a(int i, long j, long j2) throws ag1 {
            hu0 hu0Var = hu0.this;
            y70 y70Var = hu0Var.b0;
            if (y70Var == null) {
                throw new IllegalStateException();
            }
            if (i == 160) {
                hu0Var.Q = false;
                hu0Var.R = 0L;
                return;
            }
            if (i == 174) {
                hu0Var.u = new b();
                return;
            }
            if (i == 187) {
                hu0Var.E = false;
                return;
            }
            if (i == 19899) {
                hu0Var.w = -1;
                hu0Var.x = -1L;
                return;
            }
            if (i == 20533) {
                hu0Var.a(i);
                hu0Var.u.h = true;
                return;
            }
            if (i == 21968) {
                hu0Var.a(i);
                hu0Var.u.x = true;
                return;
            }
            if (i == 408125543) {
                long j3 = hu0Var.q;
                if (j3 != -1 && j3 != j) {
                    throw ag1.a("Multiple Segment elements not supported", (Exception) null);
                }
                hu0Var.q = j;
                hu0Var.p = j2;
                return;
            }
            if (i != 475249515) {
                if (i == 524531317 && !hu0Var.v) {
                    if (hu0Var.d && hu0Var.z != -1) {
                        hu0Var.y = true;
                        return;
                    } else {
                        y70Var.a(new xw1.b(hu0Var.t, 0L));
                        hu0Var.v = true;
                        return;
                    }
                }
                return;
            }
            hu0Var.C = new ct0(0);
            hu0Var.D = new ct0(0);
        }

        public final void a(int i, String str) throws ag1 {
            hu0 hu0Var = hu0.this;
            hu0Var.getClass();
            if (i == 134) {
                hu0Var.a(i);
                hu0Var.u.b = str;
                return;
            }
            if (i == 17026) {
                if (!"webm".equals(str) && !"matroska".equals(str)) {
                    throw ag1.a("DocType " + str + " not supported", (Exception) null);
                }
            } else if (i == 21358) {
                hu0Var.a(i);
                hu0Var.u.f9137a = str;
            } else {
                if (i != 2274716) {
                    return;
                }
                hu0Var.a(i);
                hu0Var.u.W = str;
            }
        }
    }

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.hu0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return hu0.a();
            }
        };
        c0 = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        d0 = x82.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
        e0 = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        f0 = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        g0 = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        gu0.a(0, map, "htc_video_rotA-000", 90, "htc_video_rotA-090");
        gu0.a(180, map, "htc_video_rotA-180", 270, "htc_video_rotA-270");
        h0 = Collections.unmodifiableMap(map);
    }

    /* JADX WARN: Code duplicated, block: B:373:0x05e2 A[PHI: r15
  0x05e2: PHI (r15v8 int) = (r15v1 int), (r15v0 int), (r15v6 int), (r15v7 int), (r15v10 int) binds: [B:479:0x0822, B:381:0x060d, B:378:0x05ed, B:376:0x05e9, B:371:0x05c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:490:0x085e  */
    /* JADX WARN: Code duplicated, block: B:495:0x0875  */
    /* JADX WARN: Code duplicated, block: B:496:0x0877  */
    /* JADX WARN: Code duplicated, block: B:499:0x0884  */
    /* JADX WARN: Code duplicated, block: B:500:0x0896  */
    /* JADX WARN: Code duplicated, block: B:502:0x089c  */
    /* JADX WARN: Code duplicated, block: B:504:0x08a0  */
    /* JADX WARN: Code duplicated, block: B:506:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:509:0x08ac  */
    /* JADX WARN: Code duplicated, block: B:513:0x08b6  */
    /* JADX WARN: Code duplicated, block: B:516:0x08c4  */
    /* JADX WARN: Code duplicated, block: B:519:0x08c9  */
    /* JADX WARN: Code duplicated, block: B:521:0x08cf  */
    /* JADX WARN: Code duplicated, block: B:541:0x0995  */
    /* JADX WARN: Code duplicated, block: B:543:0x09a3  */
    /* JADX WARN: Code duplicated, block: B:546:0x09a8  */
    /* JADX WARN: Code duplicated, block: B:548:0x09b0  */
    /* JADX WARN: Code duplicated, block: B:549:0x09bd  */
    /* JADX WARN: Code duplicated, block: B:552:0x09c2  */
    /* JADX WARN: Code duplicated, block: B:571:0x0a11  */
    /* JADX WARN: Code duplicated, block: B:573:0x0a37  */
    /* JADX WARN: Code duplicated, block: B:575:0x0a3f  */
    /* JADX WARN: Code duplicated, block: B:591:0x0a75  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [com.yandex.mobile.ads.impl.hu0$b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r10v6, types: [boolean] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    protected final void b(int i) throws ag1 {
        byte b2;
        byte b3;
        List<byte[]> list;
        String str;
        int i2;
        Pair pair;
        String str2;
        List<byte[]> list2;
        String str3;
        List<byte[]> list3;
        List<byte[]> list4;
        List<byte[]> listSingletonList;
        byte[] bArr;
        String str4;
        int i3;
        gc0.a aVar;
        int i4;
        int i5;
        float f;
        pq pqVar;
        String str5;
        int iIntValue;
        int i6;
        Map<String, Integer> map;
        byte[] bArr2;
        int i7;
        int i8;
        int i9;
        String str6;
        q30 q30VarA;
        xw1 bVar;
        int i10;
        y70 y70Var = this.b0;
        if (y70Var == null) {
            throw new IllegalStateException();
        }
        if (i == 160) {
            if (this.G != 2) {
                return;
            }
            b bVar2 = this.c.get(this.M);
            bVar2.X.getClass();
            if (this.R > 0 && "A_OPUS".equals(bVar2.b)) {
                this.n.a(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.K; i12++) {
                i11 += this.L[i12];
            }
            int i13 = 0;
            while (i13 < this.K) {
                long j = this.H + ((long) ((bVar2.e * i13) / 1000));
                int i14 = this.O;
                if (i13 == 0 && !this.Q) {
                    i14 |= 1;
                }
                int i15 = this.L[i13];
                int i16 = i11 - i15;
                a(bVar2, j, i14, i15, i16);
                i13++;
                i11 = i16;
            }
            this.G = 0;
            return;
        }
        String str7 = "MatroskaExtractor";
        if (i != 174) {
            if (i == 19899) {
                int i17 = this.w;
                if (i17 != -1) {
                    long j2 = this.x;
                    if (j2 != -1) {
                        if (i17 == 475249515) {
                            this.z = j2;
                            return;
                        }
                        return;
                    }
                }
                throw ag1.a("Mandatory element SeekID or SeekPosition not found", (Exception) null);
            }
            if (i == 25152) {
                a(i);
                b bVar3 = this.u;
                if (bVar3.h) {
                    t52.a aVar2 = bVar3.j;
                    if (aVar2 == null) {
                        throw ag1.a("Encrypted Track found but ContentEncKeyID was not found", (Exception) null);
                    }
                    bVar3.l = new c40(new c40.b(qm.f10035a, null, "video/webm", aVar2.b));
                    return;
                }
                return;
            }
            if (i == 28032) {
                a(i);
                b bVar4 = this.u;
                if (bVar4.h && bVar4.i != null) {
                    throw ag1.a("Combining encryption and compression is not supported", (Exception) null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.r == -9223372036854775807L) {
                    this.r = 1000000L;
                }
                long j3 = this.s;
                if (j3 != -9223372036854775807L) {
                    this.t = a(j3);
                    return;
                }
                return;
            }
            if (i == 374648427) {
                if (this.c.size() == 0) {
                    throw ag1.a("No valid tracks were found", (Exception) null);
                }
                this.b0.a();
                return;
            }
            if (i != 475249515) {
                return;
            }
            if (!this.v) {
                ct0 ct0Var = this.C;
                ct0 ct0Var2 = this.D;
                if (this.q == -1 || this.t == -9223372036854775807L || ct0Var == null || ct0Var.a() == 0 || ct0Var2 == null || ct0Var2.a() != ct0Var.a()) {
                    bVar = new xw1.b(this.t, 0L);
                } else {
                    int iA = ct0Var.a();
                    int[] iArrCopyOf = new int[iA];
                    long[] jArrCopyOf = new long[iA];
                    long[] jArrCopyOf2 = new long[iA];
                    long[] jArrCopyOf3 = new long[iA];
                    int i18 = 0;
                    while (i18 < iA) {
                        jArrCopyOf3[i18] = ct0Var.a(i18);
                        jArrCopyOf[i18] = ct0Var2.a(i18) + this.q;
                        i18++;
                        str7 = str7;
                    }
                    String str8 = str7;
                    int i19 = 0;
                    while (true) {
                        i10 = iA - 1;
                        if (i19 >= i10) {
                            break;
                        }
                        int i20 = i19 + 1;
                        iArrCopyOf[i19] = (int) (jArrCopyOf[i20] - jArrCopyOf[i19]);
                        jArrCopyOf2[i19] = jArrCopyOf3[i20] - jArrCopyOf3[i19];
                        i19 = i20;
                    }
                    iArrCopyOf[i10] = (int) ((this.q + this.p) - jArrCopyOf[i10]);
                    long j4 = this.t - jArrCopyOf3[i10];
                    jArrCopyOf2[i10] = j4;
                    if (j4 <= 0) {
                        at0.d(str8, "Discarding last cue point with unexpected duration: " + j4);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i10);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i10);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i10);
                        jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i10);
                    }
                    bVar = new lo(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
                }
                y70Var.a(bVar);
                this.v = true;
            }
            this.C = null;
            this.D = null;
            return;
        }
        ?? r0 = this.u;
        if (r0 == 0) {
            throw new IllegalStateException();
        }
        String str9 = r0.b;
        if (str9 == null) {
            throw ag1.a("CodecId is missing in TrackEntry element", (Exception) null);
        }
        str9.hashCode();
        int iB = 4;
        switch (str9.hashCode()) {
            case -2095576542:
                b2 = str9.equals("V_MPEG4/ISO/AP") ? (byte) 0 : (byte) -1;
                break;
            case -2095575984:
                b2 = str9.equals("V_MPEG4/ISO/SP") ? (byte) 1 : (byte) -1;
                break;
            case -1985379776:
                b2 = str9.equals("A_MS/ACM") ? (byte) 2 : (byte) -1;
                break;
            case -1784763192:
                b2 = str9.equals("A_TRUEHD") ? (byte) 3 : (byte) -1;
                break;
            case -1730367663:
                b2 = str9.equals("A_VORBIS") ? (byte) 4 : (byte) -1;
                break;
            case -1482641358:
                b2 = str9.equals("A_MPEG/L2") ? (byte) 5 : (byte) -1;
                break;
            case -1482641357:
                b2 = str9.equals("A_MPEG/L3") ? (byte) 6 : (byte) -1;
                break;
            case -1373388978:
                b2 = str9.equals("V_MS/VFW/FOURCC") ? (byte) 7 : (byte) -1;
                break;
            case -933872740:
                b2 = str9.equals("S_DVBSUB") ? (byte) 8 : (byte) -1;
                break;
            case -538363189:
                b2 = str9.equals("V_MPEG4/ISO/ASP") ? (byte) 9 : (byte) -1;
                break;
            case -538363109:
                b2 = str9.equals("V_MPEG4/ISO/AVC") ? (byte) 10 : (byte) -1;
                break;
            case -425012669:
                b2 = str9.equals("S_VOBSUB") ? Ascii.VT : (byte) -1;
                break;
            case -356037306:
                b2 = str9.equals("A_DTS/LOSSLESS") ? Ascii.FF : (byte) -1;
                break;
            case 62923557:
                b2 = str9.equals("A_AAC") ? Ascii.CR : (byte) -1;
                break;
            case 62923603:
                b2 = str9.equals("A_AC3") ? Ascii.SO : (byte) -1;
                break;
            case 62927045:
                b2 = str9.equals("A_DTS") ? Ascii.SI : (byte) -1;
                break;
            case 82318131:
                b2 = str9.equals("V_AV1") ? (byte) 16 : (byte) -1;
                break;
            case 82338133:
                b2 = str9.equals("V_VP8") ? (byte) 17 : (byte) -1;
                break;
            case 82338134:
                b2 = str9.equals("V_VP9") ? Ascii.DC2 : (byte) -1;
                break;
            case 99146302:
                b2 = str9.equals("S_HDMV/PGS") ? (byte) 19 : (byte) -1;
                break;
            case 444813526:
                b2 = str9.equals("V_THEORA") ? Ascii.DC4 : (byte) -1;
                break;
            case 542569478:
                b2 = str9.equals("A_DTS/EXPRESS") ? Ascii.NAK : (byte) -1;
                break;
            case 635596514:
                b2 = str9.equals("A_PCM/FLOAT/IEEE") ? Ascii.SYN : (byte) -1;
                break;
            case 725948237:
                b2 = str9.equals("A_PCM/INT/BIG") ? Ascii.ETB : (byte) -1;
                break;
            case 725957860:
                b2 = str9.equals("A_PCM/INT/LIT") ? Ascii.CAN : (byte) -1;
                break;
            case 738597099:
                b2 = str9.equals("S_TEXT/ASS") ? Ascii.EM : (byte) -1;
                break;
            case 855502857:
                b2 = str9.equals("V_MPEGH/ISO/HEVC") ? Ascii.SUB : (byte) -1;
                break;
            case 1045209816:
                b2 = str9.equals("S_TEXT/WEBVTT") ? Ascii.ESC : (byte) -1;
                break;
            case 1422270023:
                b2 = str9.equals("S_TEXT/UTF8") ? Ascii.FS : (byte) -1;
                break;
            case 1809237540:
                b2 = str9.equals("V_MPEG2") ? Ascii.GS : (byte) -1;
                break;
            case 1950749482:
                b2 = str9.equals("A_EAC3") ? Ascii.RS : (byte) -1;
                break;
            case 1950789798:
                b2 = str9.equals("A_FLAC") ? Ascii.US : (byte) -1;
                break;
            case 1951062397:
                b2 = str9.equals("A_OPUS") ? (byte) 32 : (byte) -1;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                int i21 = r0.c;
                str9.getClass();
                str9.hashCode();
                switch (str9) {
                    case "V_MPEG4/ISO/AP":
                        b3 = 0;
                        break;
                    case "V_MPEG4/ISO/SP":
                        b3 = 1;
                        break;
                    case "A_MS/ACM":
                        b3 = 2;
                        break;
                    case "A_TRUEHD":
                        b3 = 3;
                        break;
                    case "A_VORBIS":
                        b3 = 4;
                        break;
                    case "A_MPEG/L2":
                        b3 = 5;
                        break;
                    case "A_MPEG/L3":
                        b3 = 6;
                        break;
                    case "V_MS/VFW/FOURCC":
                        b3 = 7;
                        break;
                    case "S_DVBSUB":
                        b3 = 8;
                        break;
                    case "V_MPEG4/ISO/ASP":
                        b3 = 9;
                        break;
                    case "V_MPEG4/ISO/AVC":
                        b3 = 10;
                        break;
                    case "S_VOBSUB":
                        b3 = Ascii.VT;
                        break;
                    case "A_DTS/LOSSLESS":
                        b3 = Ascii.FF;
                        break;
                    case "A_AAC":
                        b3 = Ascii.CR;
                        break;
                    case "A_AC3":
                        b3 = Ascii.SO;
                        break;
                    case "A_DTS":
                        b3 = Ascii.SI;
                        break;
                    case "V_AV1":
                        b3 = 16;
                        break;
                    case "V_VP8":
                        b3 = 17;
                        break;
                    case "V_VP9":
                        b3 = Ascii.DC2;
                        break;
                    case "S_HDMV/PGS":
                        b3 = 19;
                        break;
                    case "V_THEORA":
                        b3 = Ascii.DC4;
                        break;
                    case "A_DTS/EXPRESS":
                        b3 = Ascii.NAK;
                        break;
                    case "A_PCM/FLOAT/IEEE":
                        b3 = Ascii.SYN;
                        break;
                    case "A_PCM/INT/BIG":
                        b3 = Ascii.ETB;
                        break;
                    case "A_PCM/INT/LIT":
                        b3 = Ascii.CAN;
                        break;
                    case "S_TEXT/ASS":
                        b3 = Ascii.EM;
                        break;
                    case "V_MPEGH/ISO/HEVC":
                        b3 = Ascii.SUB;
                        break;
                    case "S_TEXT/WEBVTT":
                        b3 = Ascii.ESC;
                        break;
                    case "S_TEXT/UTF8":
                        b3 = Ascii.FS;
                        break;
                    case "V_MPEG2":
                        b3 = Ascii.GS;
                        break;
                    case "A_EAC3":
                        b3 = Ascii.RS;
                        break;
                    case "A_FLAC":
                        b3 = Ascii.US;
                        break;
                    case "A_OPUS":
                        b3 = 32;
                        break;
                    default:
                        b3 = -1;
                        break;
                }
                String str10 = "audio/raw";
                switch (b3) {
                    case 0:
                    case 1:
                    case 9:
                        byte[] bArr3 = r0.k;
                        str10 = "video/mp4v-es";
                        if (bArr3 != null) {
                            listSingletonList = Collections.singletonList(bArr3);
                            i2 = -1;
                            iB = -1;
                            list4 = listSingletonList;
                            str = null;
                            list = list4;
                            bArr = r0.N;
                            if (bArr != null && (q30VarA = q30.a(new wf1(bArr))) != null) {
                                str = q30VarA.f9977a;
                                str10 = "video/dolby-vision";
                            }
                            str4 = str10;
                            ?? r10 = r0.V;
                            if (r0.U) {
                                i3 = 2;
                            } else {
                                i3 = 0;
                            }
                            int i22 = r10 | i3;
                            aVar = new gc0.a();
                            if (s01.d(str4)) {
                                aVar.c(r0.O).l(r0.Q).i(iB);
                                i4 = 1;
                            } else if (s01.f(str4)) {
                                if (r0.q == 0) {
                                    i8 = r0.o;
                                    if (i8 == -1) {
                                        i8 = r0.m;
                                    }
                                    r0.o = i8;
                                    i9 = r0.p;
                                    if (i9 == -1) {
                                        i9 = r0.n;
                                    }
                                    r0.p = i9;
                                }
                                i5 = r0.o;
                                if (i5 != -1 || (i7 = r0.p) == -1) {
                                    f = -1.0f;
                                } else {
                                    f = (r0.n * i5) / (r0.m * i7);
                                }
                                if (r0.x) {
                                    if (r0.D != -1.0f || r0.E == -1.0f || r0.F == -1.0f || r0.G == -1.0f || r0.H == -1.0f || r0.I == -1.0f || r0.J == -1.0f || r0.K == -1.0f || r0.L == -1.0f || r0.M == -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = new byte[25];
                                        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr2).order(ByteOrder.LITTLE_ENDIAN);
                                        byteBufferOrder.put((byte) 0);
                                        byteBufferOrder.putShort((short) ((r0.D * 50000.0f) + 0.5f));
                                        byteBufferOrder.putShort((short) ((r0.E * 50000.0f) + 0.5f));
                                        byteBufferOrder.putShort((short) ((r0.F * 50000.0f) + 0.5f));
                                        byteBufferOrder.putShort((short) ((r0.G * 50000.0f) + 0.5f));
                                        byteBufferOrder.putShort((short) ((r0.H * 50000.0f) + 0.5f));
                                        byteBufferOrder.putShort((short) ((r0.I * 50000.0f) + 0.5f));
                                        byteBufferOrder.putShort((short) ((r0.J * 50000.0f) + 0.5f));
                                        byteBufferOrder.putShort((short) ((r0.K * 50000.0f) + 0.5f));
                                        byteBufferOrder.putShort((short) (r0.L + 0.5f));
                                        byteBufferOrder.putShort((short) (r0.M + 0.5f));
                                        byteBufferOrder.putShort((short) r0.B);
                                        byteBufferOrder.putShort((short) r0.C);
                                    }
                                    pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                                } else {
                                    pqVar = null;
                                }
                                str5 = r0.f9137a;
                                if (str5 != null) {
                                    map = h0;
                                    if (map.containsKey(str5)) {
                                        iIntValue = map.get(r0.f9137a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.r == 0 || Float.compare(r0.s, 0.0f) != 0 || Float.compare(r0.t, 0.0f) != 0) {
                                    i6 = iIntValue;
                                } else if (Float.compare(r0.u, 0.0f) == 0) {
                                    i6 = 0;
                                } else if (Float.compare(r0.t, 90.0f) == 0) {
                                    i6 = 90;
                                } else if (Float.compare(r0.t, -180.0f) == 0 || Float.compare(r0.t, 180.0f) == 0) {
                                    i6 = 180;
                                } else if (Float.compare(r0.t, -90.0f) == 0) {
                                    i6 = 270;
                                } else {
                                    i6 = iIntValue;
                                }
                                aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                                i4 = 2;
                            } else {
                                if ("application/x-subrip".equals(str4) && !"text/x-ssa".equals(str4) && !"text/vtt".equals(str4) && !"application/vobsub".equals(str4) && !"application/pgs".equals(str4) && !"application/dvbsubs".equals(str4)) {
                                    throw ag1.a("Unexpected MIME type.", (Exception) null);
                                }
                                i4 = 3;
                            }
                            str6 = r0.f9137a;
                            if (str6 != null && !h0.containsKey(str6)) {
                                aVar.c(r0.f9137a);
                            }
                            gc0 gc0VarA = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i22).a(list).a(str).a(r0.l).a();
                            t52 t52VarA = y70Var.a(r0.c, i4);
                            r0.X = t52VarA;
                            t52VarA.a(gc0VarA);
                            this.c.put(r0.c, (b) r0);
                        }
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r11 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i23 = r11 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA2 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i23).a(list).a(str).a(r0.l).a();
                        t52 t52VarA2 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA2;
                        t52VarA2.a(gc0VarA2);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 2:
                        wf1 wf1Var = new wf1(r0.a(r0.b));
                        try {
                            int iO = wf1Var.o();
                            if (iO != 1) {
                                if (iO == 65534) {
                                    wf1Var.e(24);
                                    long jP = wf1Var.p();
                                    UUID uuid = g0;
                                    if (jP != uuid.getMostSignificantBits() || wf1Var.p() != uuid.getLeastSignificantBits()) {
                                    }
                                    i2 = -1;
                                    iB = -1;
                                    str10 = "audio/x-unknown";
                                    list4 = null;
                                    str = null;
                                    list = list4;
                                    bArr = r0.N;
                                    if (bArr != null) {
                                        str = q30VarA.f9977a;
                                        str10 = "video/dolby-vision";
                                    }
                                    str4 = str10;
                                    ?? r12 = r0.V;
                                    if (r0.U) {
                                        i3 = 2;
                                    } else {
                                        i3 = 0;
                                    }
                                    int i24 = r12 | i3;
                                    aVar = new gc0.a();
                                    if (s01.d(str4)) {
                                        aVar.c(r0.O).l(r0.Q).i(iB);
                                        i4 = 1;
                                    } else if (s01.f(str4)) {
                                        if (r0.q == 0) {
                                            i8 = r0.o;
                                            if (i8 == -1) {
                                                i8 = r0.m;
                                            }
                                            r0.o = i8;
                                            i9 = r0.p;
                                            if (i9 == -1) {
                                                i9 = r0.n;
                                            }
                                            r0.p = i9;
                                        }
                                        i5 = r0.o;
                                        if (i5 != -1) {
                                            f = -1.0f;
                                        } else {
                                            f = -1.0f;
                                        }
                                        if (r0.x) {
                                            if (r0.D != -1.0f) {
                                                bArr2 = null;
                                            } else {
                                                bArr2 = null;
                                            }
                                            pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                                        } else {
                                            pqVar = null;
                                        }
                                        str5 = r0.f9137a;
                                        if (str5 != null) {
                                            map = h0;
                                            if (map.containsKey(str5)) {
                                                iIntValue = map.get(r0.f9137a).intValue();
                                            } else {
                                                iIntValue = -1;
                                            }
                                        } else {
                                            iIntValue = -1;
                                        }
                                        if (r0.r == 0) {
                                            i6 = iIntValue;
                                        } else {
                                            i6 = iIntValue;
                                        }
                                        aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                                        i4 = 2;
                                    } else {
                                        if ("application/x-subrip".equals(str4)) {
                                        }
                                        i4 = 3;
                                    }
                                    str6 = r0.f9137a;
                                    if (str6 != null) {
                                        aVar.c(r0.f9137a);
                                    }
                                    gc0 gc0VarA3 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i24).a(list).a(str).a(r0.l).a();
                                    t52 t52VarA3 = y70Var.a(r0.c, i4);
                                    r0.X = t52VarA3;
                                    t52VarA3.a(gc0VarA3);
                                    this.c.put(r0.c, (b) r0);
                                }
                                at0.d("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                                i2 = -1;
                                iB = -1;
                                str10 = "audio/x-unknown";
                                list4 = null;
                                str = null;
                                list = list4;
                                bArr = r0.N;
                                if (bArr != null) {
                                    str = q30VarA.f9977a;
                                    str10 = "video/dolby-vision";
                                }
                                str4 = str10;
                                ?? r13 = r0.V;
                                if (r0.U) {
                                    i3 = 2;
                                } else {
                                    i3 = 0;
                                }
                                int i25 = r13 | i3;
                                aVar = new gc0.a();
                                if (s01.d(str4)) {
                                    aVar.c(r0.O).l(r0.Q).i(iB);
                                    i4 = 1;
                                } else if (s01.f(str4)) {
                                    if (r0.q == 0) {
                                        i8 = r0.o;
                                        if (i8 == -1) {
                                            i8 = r0.m;
                                        }
                                        r0.o = i8;
                                        i9 = r0.p;
                                        if (i9 == -1) {
                                            i9 = r0.n;
                                        }
                                        r0.p = i9;
                                    }
                                    i5 = r0.o;
                                    if (i5 != -1) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (r0.x) {
                                        if (r0.D != -1.0f) {
                                            bArr2 = null;
                                        } else {
                                            bArr2 = null;
                                        }
                                        pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                                    } else {
                                        pqVar = null;
                                    }
                                    str5 = r0.f9137a;
                                    if (str5 != null) {
                                        map = h0;
                                        if (map.containsKey(str5)) {
                                            iIntValue = map.get(r0.f9137a).intValue();
                                        } else {
                                            iIntValue = -1;
                                        }
                                    } else {
                                        iIntValue = -1;
                                    }
                                    if (r0.r == 0) {
                                        i6 = iIntValue;
                                    } else {
                                        i6 = iIntValue;
                                    }
                                    aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                                    i4 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str4)) {
                                    }
                                    i4 = 3;
                                }
                                str6 = r0.f9137a;
                                if (str6 != null) {
                                    aVar.c(r0.f9137a);
                                }
                                gc0 gc0VarA4 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i25).a(list).a(str).a(r0.l).a();
                                t52 t52VarA4 = y70Var.a(r0.c, i4);
                                r0.X = t52VarA4;
                                t52VarA4.a(gc0VarA4);
                                this.c.put(r0.c, (b) r0);
                                break;
                            }
                            iB = x82.b(r0.P);
                            if (iB == 0) {
                                at0.d("MatroskaExtractor", "Unsupported PCM bit depth: " + r0.P + ". Setting mimeType to audio/x-unknown");
                                i2 = -1;
                                iB = -1;
                                str10 = "audio/x-unknown";
                            } else {
                                i2 = -1;
                            }
                            list4 = null;
                            str = null;
                            list = list4;
                            bArr = r0.N;
                            if (bArr != null) {
                                str = q30VarA.f9977a;
                                str10 = "video/dolby-vision";
                            }
                            str4 = str10;
                            ?? r14 = r0.V;
                            if (r0.U) {
                                i3 = 2;
                            } else {
                                i3 = 0;
                            }
                            int i26 = r14 | i3;
                            aVar = new gc0.a();
                            if (s01.d(str4)) {
                                aVar.c(r0.O).l(r0.Q).i(iB);
                                i4 = 1;
                            } else if (s01.f(str4)) {
                                if (r0.q == 0) {
                                    i8 = r0.o;
                                    if (i8 == -1) {
                                        i8 = r0.m;
                                    }
                                    r0.o = i8;
                                    i9 = r0.p;
                                    if (i9 == -1) {
                                        i9 = r0.n;
                                    }
                                    r0.p = i9;
                                }
                                i5 = r0.o;
                                if (i5 != -1) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (r0.x) {
                                    if (r0.D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                                } else {
                                    pqVar = null;
                                }
                                str5 = r0.f9137a;
                                if (str5 != null) {
                                    map = h0;
                                    if (map.containsKey(str5)) {
                                        iIntValue = map.get(r0.f9137a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.r == 0) {
                                    i6 = iIntValue;
                                } else {
                                    i6 = iIntValue;
                                }
                                aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                                i4 = 2;
                            } else {
                                if ("application/x-subrip".equals(str4)) {
                                }
                                i4 = 3;
                            }
                            str6 = r0.f9137a;
                            if (str6 != null) {
                                aVar.c(r0.f9137a);
                            }
                            gc0 gc0VarA5 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i26).a(list).a(str).a(r0.l).a();
                            t52 t52VarA5 = y70Var.a(r0.c, i4);
                            r0.X = t52VarA5;
                            t52VarA5.a(gc0VarA5);
                            this.c.put(r0.c, (b) r0);
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            throw ag1.a("Error parsing MS/ACM codec private", (Exception) null);
                        }
                        break;
                    case 3:
                        r0.T = new b72();
                        str10 = "audio/true-hd";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r15 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i27 = r15 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA6 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i27).a(list).a(str).a(r0.l).a();
                        t52 t52VarA6 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA6;
                        t52VarA6.a(gc0VarA6);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 4:
                        byte[] bArrA = r0.a(r0.b);
                        try {
                            try {
                                if (bArrA[0] != 2) {
                                    throw ag1.a("Error parsing vorbis codec private", (Exception) null);
                                }
                                int i28 = 1;
                                int i29 = 0;
                                while (true) {
                                    int i30 = bArrA[i28] & 255;
                                    if (i30 != 255) {
                                        int i31 = i28 + 1;
                                        int i32 = i29 + i30;
                                        int i33 = 0;
                                        while (true) {
                                            int i34 = bArrA[i31] & 255;
                                            if (i34 != 255) {
                                                int i35 = i31 + 1;
                                                int i36 = i33 + i34;
                                                if (bArrA[i35] != 1) {
                                                    throw ag1.a("Error parsing vorbis codec private", (Exception) null);
                                                }
                                                byte[] bArr4 = new byte[i32];
                                                System.arraycopy(bArrA, i35, bArr4, 0, i32);
                                                int i37 = i35 + i32;
                                                if (bArrA[i37] != 3) {
                                                    throw ag1.a("Error parsing vorbis codec private", (Exception) null);
                                                }
                                                int i38 = i37 + i36;
                                                if (bArrA[i38] != 5) {
                                                    throw ag1.a("Error parsing vorbis codec private", (Exception) null);
                                                }
                                                byte[] bArr5 = new byte[bArrA.length - i38];
                                                System.arraycopy(bArrA, i38, bArr5, 0, bArrA.length - i38);
                                                ArrayList arrayList = new ArrayList(2);
                                                arrayList.add(bArr4);
                                                arrayList.add(bArr5);
                                                str10 = "audio/vorbis";
                                                list = arrayList;
                                                iB = -1;
                                                str = null;
                                                i2 = 8192;
                                                bArr = r0.N;
                                                if (bArr != null) {
                                                    str = q30VarA.f9977a;
                                                    str10 = "video/dolby-vision";
                                                }
                                                str4 = str10;
                                                ?? r16 = r0.V;
                                                if (r0.U) {
                                                    i3 = 2;
                                                } else {
                                                    i3 = 0;
                                                }
                                                int i210 = r16 | i3;
                                                aVar = new gc0.a();
                                                if (s01.d(str4)) {
                                                    aVar.c(r0.O).l(r0.Q).i(iB);
                                                    i4 = 1;
                                                } else if (s01.f(str4)) {
                                                    if (r0.q == 0) {
                                                        i8 = r0.o;
                                                        if (i8 == -1) {
                                                            i8 = r0.m;
                                                        }
                                                        r0.o = i8;
                                                        i9 = r0.p;
                                                        if (i9 == -1) {
                                                            i9 = r0.n;
                                                        }
                                                        r0.p = i9;
                                                    }
                                                    i5 = r0.o;
                                                    if (i5 != -1) {
                                                        f = -1.0f;
                                                    } else {
                                                        f = -1.0f;
                                                    }
                                                    if (r0.x) {
                                                        if (r0.D != -1.0f) {
                                                            bArr2 = null;
                                                        } else {
                                                            bArr2 = null;
                                                        }
                                                        pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                                                    } else {
                                                        pqVar = null;
                                                    }
                                                    str5 = r0.f9137a;
                                                    if (str5 != null) {
                                                        map = h0;
                                                        if (map.containsKey(str5)) {
                                                            iIntValue = map.get(r0.f9137a).intValue();
                                                        } else {
                                                            iIntValue = -1;
                                                        }
                                                    } else {
                                                        iIntValue = -1;
                                                    }
                                                    if (r0.r == 0) {
                                                        i6 = iIntValue;
                                                    } else {
                                                        i6 = iIntValue;
                                                    }
                                                    aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                                                    i4 = 2;
                                                } else {
                                                    if ("application/x-subrip".equals(str4)) {
                                                    }
                                                    i4 = 3;
                                                }
                                                str6 = r0.f9137a;
                                                if (str6 != null) {
                                                    aVar.c(r0.f9137a);
                                                }
                                                gc0 gc0VarA7 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i210).a(list).a(str).a(r0.l).a();
                                                t52 t52VarA7 = y70Var.a(r0.c, i4);
                                                r0.X = t52VarA7;
                                                t52VarA7.a(gc0VarA7);
                                                this.c.put(r0.c, (b) r0);
                                            } else {
                                                i33 += 255;
                                                i31++;
                                            }
                                        }
                                    } else {
                                        i29 += 255;
                                        i28++;
                                    }
                                    break;
                                }
                            } catch (ArrayIndexOutOfBoundsException unused2) {
                            }
                        } catch (ArrayIndexOutOfBoundsException unused3) {
                            r0 = 0;
                        }
                        throw ag1.a("Error parsing vorbis codec private", (Exception) r0);
                    case 5:
                        str10 = "audio/mpeg-L2";
                        i2 = 4096;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r17 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i211 = r17 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA8 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i211).a(list).a(str).a(r0.l).a();
                        t52 t52VarA8 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA8;
                        t52VarA8.a(gc0VarA8);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 6:
                        str10 = "audio/mpeg";
                        i2 = 4096;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r18 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i212 = r18 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA9 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i212).a(list).a(str).a(r0.l).a();
                        t52 t52VarA9 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA9;
                        t52VarA9.a(gc0VarA9);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 7:
                        wf1 wf1Var2 = new wf1(r0.a(r0.b));
                        try {
                            wf1Var2.f(16);
                            long jN = wf1Var2.n();
                            if (jN == 1482049860) {
                                pair = new Pair("video/divx", null);
                            } else if (jN != 859189832) {
                                if (jN == 826496599) {
                                    int iD = wf1Var2.d() + 20;
                                    byte[] bArrC = wf1Var2.c();
                                    while (true) {
                                        if (iD >= bArrC.length - 4) {
                                            throw ag1.a("Failed to find FourCC VC1 initialization data", (Exception) null);
                                        }
                                        if (bArrC[iD] == 0 && bArrC[iD + 1] == 0 && bArrC[iD + 2] == 1 && bArrC[iD + 3] == 15) {
                                            pair = new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrC, iD, bArrC.length)));
                                        } else {
                                            iD++;
                                        }
                                    }
                                } else {
                                    at0.d("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                                    str2 = null;
                                    pair = new Pair("video/x-unknown", null);
                                }
                                str10 = (String) pair.first;
                                str = str2;
                                list3 = (List) pair.second;
                                i2 = -1;
                                iB = -1;
                                list = list3;
                                bArr = r0.N;
                                if (bArr != null) {
                                    str = q30VarA.f9977a;
                                    str10 = "video/dolby-vision";
                                }
                                str4 = str10;
                                ?? r19 = r0.V;
                                if (r0.U) {
                                    i3 = 2;
                                } else {
                                    i3 = 0;
                                }
                                int i213 = r19 | i3;
                                aVar = new gc0.a();
                                if (s01.d(str4)) {
                                    aVar.c(r0.O).l(r0.Q).i(iB);
                                    i4 = 1;
                                } else if (s01.f(str4)) {
                                    if (r0.q == 0) {
                                        i8 = r0.o;
                                        if (i8 == -1) {
                                            i8 = r0.m;
                                        }
                                        r0.o = i8;
                                        i9 = r0.p;
                                        if (i9 == -1) {
                                            i9 = r0.n;
                                        }
                                        r0.p = i9;
                                    }
                                    i5 = r0.o;
                                    if (i5 != -1) {
                                        f = -1.0f;
                                    } else {
                                        f = -1.0f;
                                    }
                                    if (r0.x) {
                                        if (r0.D != -1.0f) {
                                            bArr2 = null;
                                        } else {
                                            bArr2 = null;
                                        }
                                        pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                                    } else {
                                        pqVar = null;
                                    }
                                    str5 = r0.f9137a;
                                    if (str5 != null) {
                                        map = h0;
                                        if (map.containsKey(str5)) {
                                            iIntValue = map.get(r0.f9137a).intValue();
                                        } else {
                                            iIntValue = -1;
                                        }
                                    } else {
                                        iIntValue = -1;
                                    }
                                    if (r0.r == 0) {
                                        i6 = iIntValue;
                                    } else {
                                        i6 = iIntValue;
                                    }
                                    aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                                    i4 = 2;
                                } else {
                                    if ("application/x-subrip".equals(str4)) {
                                    }
                                    i4 = 3;
                                }
                                str6 = r0.f9137a;
                                if (str6 != null) {
                                    aVar.c(r0.f9137a);
                                }
                                gc0 gc0VarA10 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i213).a(list).a(str).a(r0.l).a();
                                t52 t52VarA10 = y70Var.a(r0.c, i4);
                                r0.X = t52VarA10;
                                t52VarA10.a(gc0VarA10);
                                this.c.put(r0.c, (b) r0);
                            } else {
                                pair = new Pair("video/3gpp", null);
                            }
                            str2 = null;
                            str10 = (String) pair.first;
                            str = str2;
                            list3 = (List) pair.second;
                            i2 = -1;
                            iB = -1;
                            list = list3;
                            bArr = r0.N;
                            if (bArr != null) {
                                str = q30VarA.f9977a;
                                str10 = "video/dolby-vision";
                            }
                            str4 = str10;
                            ?? r110 = r0.V;
                            if (r0.U) {
                                i3 = 2;
                            } else {
                                i3 = 0;
                            }
                            int i214 = r110 | i3;
                            aVar = new gc0.a();
                            if (s01.d(str4)) {
                                aVar.c(r0.O).l(r0.Q).i(iB);
                                i4 = 1;
                            } else if (s01.f(str4)) {
                                if (r0.q == 0) {
                                    i8 = r0.o;
                                    if (i8 == -1) {
                                        i8 = r0.m;
                                    }
                                    r0.o = i8;
                                    i9 = r0.p;
                                    if (i9 == -1) {
                                        i9 = r0.n;
                                    }
                                    r0.p = i9;
                                }
                                i5 = r0.o;
                                if (i5 != -1) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (r0.x) {
                                    if (r0.D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                                } else {
                                    pqVar = null;
                                }
                                str5 = r0.f9137a;
                                if (str5 != null) {
                                    map = h0;
                                    if (map.containsKey(str5)) {
                                        iIntValue = map.get(r0.f9137a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.r == 0) {
                                    i6 = iIntValue;
                                } else {
                                    i6 = iIntValue;
                                }
                                aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                                i4 = 2;
                            } else {
                                if ("application/x-subrip".equals(str4)) {
                                }
                                i4 = 3;
                            }
                            str6 = r0.f9137a;
                            if (str6 != null) {
                                aVar.c(r0.f9137a);
                            }
                            gc0 gc0VarA11 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i214).a(list).a(str).a(r0.l).a();
                            t52 t52VarA11 = y70Var.a(r0.c, i4);
                            r0.X = t52VarA11;
                            t52VarA11.a(gc0VarA11);
                            this.c.put(r0.c, (b) r0);
                        } catch (ArrayIndexOutOfBoundsException unused4) {
                            throw ag1.a("Error parsing FourCC private data", (Exception) null);
                        }
                        break;
                    case 8:
                        byte[] bArr6 = new byte[4];
                        System.arraycopy(r0.a(r0.b), 0, bArr6, 0, 4);
                        str10 = "application/dvbsubs";
                        listSingletonList = hk0.a(bArr6);
                        i2 = -1;
                        iB = -1;
                        list4 = listSingletonList;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r111 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i215 = r111 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA12 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i215).a(list).a(str).a(r0.l).a();
                        t52 t52VarA12 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA12;
                        t52VarA12.a(gc0VarA12);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 10:
                        mi miVarA = mi.a(new wf1(r0.a(r0.b)));
                        list2 = miVarA.f9640a;
                        r0.Y = miVarA.b;
                        str3 = miVarA.f;
                        str10 = "video/avc";
                        str = str3;
                        list3 = list2;
                        i2 = -1;
                        iB = -1;
                        list = list3;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r112 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i216 = r112 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA13 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i216).a(list).a(str).a(r0.l).a();
                        t52 t52VarA13 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA13;
                        t52VarA13.a(gc0VarA13);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 11:
                        str10 = "application/vobsub";
                        listSingletonList = hk0.a(r0.a(r0.b));
                        i2 = -1;
                        iB = -1;
                        list4 = listSingletonList;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r113 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i217 = r113 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA14 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i217).a(list).a(str).a(r0.l).a();
                        t52 t52VarA14 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA14;
                        t52VarA14.a(gc0VarA14);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 12:
                        str10 = "audio/vnd.dts.hd";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r114 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i218 = r114 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA15 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i218).a(list).a(str).a(r0.l).a();
                        t52 t52VarA15 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA15;
                        t52VarA15.a(gc0VarA15);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 13:
                        List<byte[]> listSingletonList2 = Collections.singletonList(r0.a(r0.b));
                        byte[] bArr7 = r0.k;
                        e.a aVarA = e.a(new vf1(bArr7.length, bArr7), false);
                        r0.Q = aVarA.f8746a;
                        r0.O = aVarA.b;
                        str10 = "audio/mp4a-latm";
                        str = aVarA.c;
                        list3 = listSingletonList2;
                        i2 = -1;
                        iB = -1;
                        list = list3;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r115 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i219 = r115 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA16 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i219).a(list).a(str).a(r0.l).a();
                        t52 t52VarA16 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA16;
                        t52VarA16.a(gc0VarA16);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 14:
                        str10 = "audio/ac3";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r116 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2110 = r116 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA17 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2110).a(list).a(str).a(r0.l).a();
                        t52 t52VarA17 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA17;
                        t52VarA17.a(gc0VarA17);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 15:
                    case 21:
                        str10 = "audio/vnd.dts";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r117 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2111 = r117 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA18 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2111).a(list).a(str).a(r0.l).a();
                        t52 t52VarA18 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA18;
                        t52VarA18.a(gc0VarA18);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 16:
                        str10 = "video/av01";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r118 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2112 = r118 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA19 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2112).a(list).a(str).a(r0.l).a();
                        t52 t52VarA19 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA19;
                        t52VarA19.a(gc0VarA19);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 17:
                        str10 = "video/x-vnd.on2.vp8";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r119 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2113 = r119 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA110 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2113).a(list).a(str).a(r0.l).a();
                        t52 t52VarA110 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA110;
                        t52VarA110.a(gc0VarA110);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 18:
                        str10 = "video/x-vnd.on2.vp9";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1110 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2114 = r1110 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA111 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2114).a(list).a(str).a(r0.l).a();
                        t52 t52VarA111 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA111;
                        t52VarA111.a(gc0VarA111);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 19:
                        str10 = "application/pgs";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1111 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2115 = r1111 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA112 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2115).a(list).a(str).a(r0.l).a();
                        t52 t52VarA112 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA112;
                        t52VarA112.a(gc0VarA112);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 20:
                        str10 = "video/x-unknown";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1112 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2116 = r1112 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA113 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2116).a(list).a(str).a(r0.l).a();
                        t52 t52VarA113 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA113;
                        t52VarA113.a(gc0VarA113);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 22:
                        if (r0.P == 32) {
                            i2 = -1;
                        } else {
                            at0.d("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + r0.P + ". Setting mimeType to audio/x-unknown");
                            i2 = -1;
                            iB = -1;
                            str10 = "audio/x-unknown";
                        }
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1113 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2117 = r1113 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA114 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2117).a(list).a(str).a(r0.l).a();
                        t52 t52VarA114 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA114;
                        t52VarA114.a(gc0VarA114);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 23:
                        int i39 = r0.P;
                        if (i39 == 8) {
                            iB = 3;
                        } else if (i39 != 16) {
                            at0.d("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + r0.P + ". Setting mimeType to audio/x-unknown");
                            i2 = -1;
                            iB = -1;
                            str10 = "audio/x-unknown";
                            list4 = null;
                            str = null;
                            list = list4;
                            bArr = r0.N;
                            if (bArr != null) {
                                str = q30VarA.f9977a;
                                str10 = "video/dolby-vision";
                            }
                            str4 = str10;
                            ?? r1114 = r0.V;
                            if (r0.U) {
                                i3 = 2;
                            } else {
                                i3 = 0;
                            }
                            int i2118 = r1114 | i3;
                            aVar = new gc0.a();
                            if (s01.d(str4)) {
                                aVar.c(r0.O).l(r0.Q).i(iB);
                                i4 = 1;
                            } else if (s01.f(str4)) {
                                if (r0.q == 0) {
                                    i8 = r0.o;
                                    if (i8 == -1) {
                                        i8 = r0.m;
                                    }
                                    r0.o = i8;
                                    i9 = r0.p;
                                    if (i9 == -1) {
                                        i9 = r0.n;
                                    }
                                    r0.p = i9;
                                }
                                i5 = r0.o;
                                if (i5 != -1) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (r0.x) {
                                    if (r0.D != -1.0f) {
                                        bArr2 = null;
                                    } else {
                                        bArr2 = null;
                                    }
                                    pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                                } else {
                                    pqVar = null;
                                }
                                str5 = r0.f9137a;
                                if (str5 != null) {
                                    map = h0;
                                    if (map.containsKey(str5)) {
                                        iIntValue = map.get(r0.f9137a).intValue();
                                    } else {
                                        iIntValue = -1;
                                    }
                                } else {
                                    iIntValue = -1;
                                }
                                if (r0.r == 0) {
                                    i6 = iIntValue;
                                } else {
                                    i6 = iIntValue;
                                }
                                aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                                i4 = 2;
                            } else {
                                if ("application/x-subrip".equals(str4)) {
                                }
                                i4 = 3;
                            }
                            str6 = r0.f9137a;
                            if (str6 != null) {
                                aVar.c(r0.f9137a);
                            }
                            gc0 gc0VarA115 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2118).a(list).a(str).a(r0.l).a();
                            t52 t52VarA115 = y70Var.a(r0.c, i4);
                            r0.X = t52VarA115;
                            t52VarA115.a(gc0VarA115);
                            this.c.put(r0.c, (b) r0);
                        } else {
                            iB = 268435456;
                        }
                        i2 = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1115 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i2119 = r1115 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA116 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i2119).a(list).a(str).a(r0.l).a();
                        t52 t52VarA116 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA116;
                        t52VarA116.a(gc0VarA116);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 24:
                        iB = x82.b(r0.P);
                        if (iB == 0) {
                            at0.d("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + r0.P + ". Setting mimeType to audio/x-unknown");
                            i2 = -1;
                            iB = -1;
                            str10 = "audio/x-unknown";
                        } else {
                            i2 = -1;
                        }
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1116 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21110 = r1116 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA117 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21110).a(list).a(str).a(r0.l).a();
                        t52 t52VarA117 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA117;
                        t52VarA117.a(gc0VarA117);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 25:
                        str10 = "text/x-ssa";
                        listSingletonList = hk0.a(d0, r0.a(r0.b));
                        i2 = -1;
                        iB = -1;
                        list4 = listSingletonList;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1117 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21111 = r1117 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA118 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21111).a(list).a(str).a(r0.l).a();
                        t52 t52VarA118 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA118;
                        t52VarA118.a(gc0VarA118);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 26:
                        qf0 qf0VarA = qf0.a(new wf1(r0.a(r0.b)));
                        list2 = qf0VarA.f10014a;
                        r0.Y = qf0VarA.b;
                        str3 = qf0VarA.d;
                        str10 = "video/hevc";
                        str = str3;
                        list3 = list2;
                        i2 = -1;
                        iB = -1;
                        list = list3;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1118 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21112 = r1118 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA119 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21112).a(list).a(str).a(r0.l).a();
                        t52 t52VarA119 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA119;
                        t52VarA119.a(gc0VarA119);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 27:
                        str10 = "text/vtt";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r1119 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21113 = r1119 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA1110 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21113).a(list).a(str).a(r0.l).a();
                        t52 t52VarA1110 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA1110;
                        t52VarA1110.a(gc0VarA1110);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 28:
                        str10 = "application/x-subrip";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r11110 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21114 = r11110 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA1111 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21114).a(list).a(str).a(r0.l).a();
                        t52 t52VarA1111 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA1111;
                        t52VarA1111.a(gc0VarA1111);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 29:
                        str10 = "video/mpeg2";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r11111 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21115 = r11111 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA1112 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21115).a(list).a(str).a(r0.l).a();
                        t52 t52VarA1112 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA1112;
                        t52VarA1112.a(gc0VarA1112);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 30:
                        str10 = "audio/eac3";
                        i2 = -1;
                        iB = -1;
                        list4 = null;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r11112 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21116 = r11112 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA1113 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21116).a(list).a(str).a(r0.l).a();
                        t52 t52VarA1113 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA1113;
                        t52VarA1113.a(gc0VarA1113);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 31:
                        str10 = "audio/flac";
                        listSingletonList = Collections.singletonList(r0.a(r0.b));
                        i2 = -1;
                        iB = -1;
                        list4 = listSingletonList;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r11113 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21117 = r11113 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA1114 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21117).a(list).a(str).a(r0.l).a();
                        t52 t52VarA1114 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA1114;
                        t52VarA1114.a(gc0VarA1114);
                        this.c.put(r0.c, (b) r0);
                        break;
                    case 32:
                        ArrayList arrayList2 = new ArrayList(3);
                        arrayList2.add(r0.a(r0.b));
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                        arrayList2.add(byteBufferAllocate.order(byteOrder).putLong(r0.R).array());
                        arrayList2.add(ByteBuffer.allocate(8).order(byteOrder).putLong(r0.S).array());
                        str10 = "audio/opus";
                        i2 = 5760;
                        iB = -1;
                        list4 = arrayList2;
                        str = null;
                        list = list4;
                        bArr = r0.N;
                        if (bArr != null) {
                            str = q30VarA.f9977a;
                            str10 = "video/dolby-vision";
                        }
                        str4 = str10;
                        ?? r11114 = r0.V;
                        if (r0.U) {
                            i3 = 2;
                        } else {
                            i3 = 0;
                        }
                        int i21118 = r11114 | i3;
                        aVar = new gc0.a();
                        if (s01.d(str4)) {
                            aVar.c(r0.O).l(r0.Q).i(iB);
                            i4 = 1;
                        } else if (s01.f(str4)) {
                            if (r0.q == 0) {
                                i8 = r0.o;
                                if (i8 == -1) {
                                    i8 = r0.m;
                                }
                                r0.o = i8;
                                i9 = r0.p;
                                if (i9 == -1) {
                                    i9 = r0.n;
                                }
                                r0.p = i9;
                            }
                            i5 = r0.o;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (r0.x) {
                                if (r0.D != -1.0f) {
                                    bArr2 = null;
                                } else {
                                    bArr2 = null;
                                }
                                pqVar = new pq(r0.y, r0.A, r0.z, bArr2);
                            } else {
                                pqVar = null;
                            }
                            str5 = r0.f9137a;
                            if (str5 != null) {
                                map = h0;
                                if (map.containsKey(str5)) {
                                    iIntValue = map.get(r0.f9137a).intValue();
                                } else {
                                    iIntValue = -1;
                                }
                            } else {
                                iIntValue = -1;
                            }
                            if (r0.r == 0) {
                                i6 = iIntValue;
                            } else {
                                i6 = iIntValue;
                            }
                            aVar.o(r0.m).f(r0.n).b(f).k(i6).a(r0.v).n(r0.w).a(pqVar);
                            i4 = 2;
                        } else {
                            if ("application/x-subrip".equals(str4)) {
                            }
                            i4 = 3;
                        }
                        str6 = r0.f9137a;
                        if (str6 != null) {
                            aVar.c(r0.f9137a);
                        }
                        gc0 gc0VarA1115 = aVar.g(i21).e(str4).h(i2).d(((b) r0).W).m(i21118).a(list).a(str).a(r0.l).a();
                        t52 t52VarA1115 = y70Var.a(r0.c, i4);
                        r0.X = t52VarA1115;
                        t52VarA1115.a(gc0VarA1115);
                        this.c.put(r0.c, (b) r0);
                        break;
                    default:
                        throw ag1.a("Unrecognized codec identifier.", (Exception) null);
                }
                break;
        }
        this.u = null;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    public hu0() {
        this(new rz());
    }

    hu0(rz rzVar) {
        this.q = -1L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.f9135a = rzVar;
        rzVar.a(new a());
        this.d = true;
        this.b = new i92();
        this.c = new SparseArray<>();
        this.g = new wf1(4);
        this.h = new wf1(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new wf1(4);
        this.e = new wf1(a41.f8364a);
        this.f = new wf1(4);
        this.j = new wf1();
        this.k = new wf1();
        this.l = new wf1(8);
        this.m = new wf1();
        this.n = new wf1();
        this.L = new int[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNull({"currentTrack"})
    public void a(int i) throws ag1 {
        if (this.u == null) {
            throw ag1.a("Element " + i + " must be in a TrackEntry", (Exception) null);
        }
    }

    protected static final class b {
        public byte[] N;
        public b72 T;
        public boolean U;
        public t52 X;
        public int Y;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9137a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        private int g;
        public boolean h;
        public byte[] i;
        public t52.a j;
        public byte[] k;
        public c40 l;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = 0;
        public int r = -1;
        public float s = 0.0f;
        public float t = 0.0f;
        public float u = 0.0f;
        public byte[] v = null;
        public int w = -1;
        public boolean x = false;
        public int y = -1;
        public int z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        private String W = "eng";

        protected b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @EnsuresNonNull({"codecPrivate"})
        public byte[] a(String str) throws ag1 {
            byte[] bArr = this.k;
            if (bArr != null) {
                return bArr;
            }
            throw ag1.a("Missing CodecPrivate for codec " + str, (Exception) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"#1.output"})
    public void a(b bVar, long j, int i, int i2, int i3) {
        byte[] bArrA;
        int i4;
        int iE;
        b72 b72Var = bVar.T;
        if (b72Var != null) {
            b72Var.a(bVar.X, j, i, i2, i3, bVar.j);
        } else {
            if ("S_TEXT/UTF8".equals(bVar.b) || "S_TEXT/ASS".equals(bVar.b) || "S_TEXT/WEBVTT".equals(bVar.b)) {
                if (this.K > 1) {
                    at0.d("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.I;
                    if (j2 == -9223372036854775807L) {
                        at0.d("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        String str = bVar.b;
                        byte[] bArrC = this.k.c();
                        str.getClass();
                        str.hashCode();
                        switch (str) {
                            case "S_TEXT/ASS":
                                bArrA = a("%01d:%02d:%02d:%02d", j2, 10000L);
                                i4 = 21;
                                break;
                            case "S_TEXT/WEBVTT":
                                bArrA = a("%02d:%02d:%02d.%03d", j2, 1000L);
                                i4 = 25;
                                break;
                            case "S_TEXT/UTF8":
                                bArrA = a("%02d:%02d:%02d,%03d", j2, 1000L);
                                i4 = 19;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                        System.arraycopy(bArrA, 0, bArrC, i4, bArrA.length);
                        for (int iD = this.k.d(); iD < this.k.e(); iD++) {
                            if (this.k.c()[iD] == 0) {
                                this.k.d(iD);
                                t52 t52Var = bVar.X;
                                wf1 wf1Var = this.k;
                                t52Var.a(wf1Var.e(), wf1Var);
                                iE = this.k.e() + i2;
                            }
                        }
                        t52 t52Var2 = bVar.X;
                        wf1 wf1Var2 = this.k;
                        t52Var2.a(wf1Var2.e(), wf1Var2);
                        iE = this.k.e() + i2;
                    }
                }
                iE = i2;
            } else {
                iE = i2;
            }
            if ((i & 268435456) != 0) {
                if (this.K > 1) {
                    this.n.c(0);
                } else {
                    int iE2 = this.n.e();
                    bVar.X.b(iE2, this.n);
                    iE += iE2;
                }
            }
            bVar.X.a(j, i, iE, i3, bVar.j);
        }
        this.F = true;
    }

    private static byte[] a(String str, long j, long j2) {
        if (j != -9223372036854775807L) {
            int i = (int) (j / 3600000000L);
            long j3 = j - (((long) i) * 3600000000L);
            int i2 = (int) (j3 / 60000000);
            long j4 = j3 - (((long) i2) * 60000000);
            int i3 = (int) (j4 / 1000000);
            return x82.c(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
        }
        throw new IllegalArgumentException();
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.b0 = y70Var;
    }

    private void b() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.a0 = false;
        this.j.c(0);
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        this.F = false;
        boolean zA = true;
        while (zA && !this.F) {
            tz tzVar = (tz) x70Var;
            zA = ((rz) this.f9135a).a(tzVar);
            if (zA) {
                long jA = tzVar.a();
                if (this.y) {
                    this.A = jA;
                    lj1Var.f9531a = this.z;
                    this.y = false;
                } else if (this.v) {
                    long j = this.A;
                    if (j != -1) {
                        lj1Var.f9531a = j;
                        this.A = -1L;
                    }
                } else {
                    continue;
                }
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i = 0; i < this.c.size(); i++) {
            b bVarValueAt = this.c.valueAt(i);
            bVarValueAt.X.getClass();
            b72 b72Var = bVarValueAt.T;
            if (b72Var != null) {
                b72Var.a(bVarValueAt.X, bVarValueAt.j);
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(tz tzVar, int i) throws IOException {
        if (this.g.e() >= i) {
            return;
        }
        if (this.g.b() < i) {
            wf1 wf1Var = this.g;
            wf1Var.a(Math.max(wf1Var.b() * 2, i));
        }
        tzVar.a(this.g.c(), this.g.e(), i - this.g.e(), false);
        this.g.d(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a(long j) throws ag1 {
        long j2 = this.r;
        if (j2 != -9223372036854775807L) {
            return x82.a(j, j2, 1000L);
        }
        throw ag1.a("Can't scale timecode prior to timecodeScale being set.", (Exception) null);
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.B = -9223372036854775807L;
        this.G = 0;
        ((rz) this.f9135a).a();
        this.b.b();
        b();
        for (int i = 0; i < this.c.size(); i++) {
            b72 b72Var = this.c.valueAt(i).T;
            if (b72Var != null) {
                b72Var.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"#2.output"})
    public int a(tz tzVar, b bVar, int i, boolean z) throws IOException {
        int iB;
        int iB2;
        int i2;
        if ("S_TEXT/UTF8".equals(bVar.b)) {
            a(tzVar, c0, i);
            int i3 = this.T;
            b();
            return i3;
        }
        if ("S_TEXT/ASS".equals(bVar.b)) {
            a(tzVar, e0, i);
            int i4 = this.T;
            b();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(bVar.b)) {
            a(tzVar, f0, i);
            int i5 = this.T;
            b();
            return i5;
        }
        t52 t52Var = bVar.X;
        if (!this.V) {
            if (bVar.h) {
                this.O &= -1073741825;
                if (!this.W) {
                    tzVar.a(this.g.c(), 0, 1, false);
                    this.S++;
                    if ((this.g.c()[0] & 128) != 128) {
                        this.Z = this.g.c()[0];
                        this.W = true;
                    } else {
                        throw ag1.a("Extension bit is set in signal byte", (Exception) null);
                    }
                }
                byte b2 = this.Z;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.a0) {
                        tzVar.a(this.l.c(), 0, 8, false);
                        this.S += 8;
                        this.a0 = true;
                        this.g.c()[0] = (byte) ((z2 ? 128 : 0) | 8);
                        this.g.e(0);
                        t52Var.b(1, this.g);
                        this.T++;
                        this.l.e(0);
                        t52Var.b(8, this.l);
                        this.T += 8;
                    }
                    if (z2) {
                        if (!this.X) {
                            tzVar.a(this.g.c(), 0, 1, false);
                            this.S++;
                            this.g.e(0);
                            this.Y = this.g.t();
                            this.X = true;
                        }
                        int i6 = this.Y * 4;
                        this.g.c(i6);
                        tzVar.a(this.g.c(), 0, i6, false);
                        this.S += i6;
                        short s = (short) ((this.Y / 2) + 1);
                        int i7 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.o;
                        if (byteBuffer == null || byteBuffer.capacity() < i7) {
                            this.o = ByteBuffer.allocate(i7);
                        }
                        this.o.position(0);
                        this.o.putShort(s);
                        int i8 = 0;
                        int i9 = 0;
                        while (true) {
                            i2 = this.Y;
                            if (i8 >= i2) {
                                break;
                            }
                            int iX = this.g.x();
                            if (i8 % 2 == 0) {
                                this.o.putShort((short) (iX - i9));
                            } else {
                                this.o.putInt(iX - i9);
                            }
                            i8++;
                            i9 = iX;
                        }
                        int i10 = (i - this.S) - i9;
                        if (i2 % 2 == 1) {
                            this.o.putInt(i10);
                        } else {
                            this.o.putShort((short) i10);
                            this.o.putInt(0);
                        }
                        this.m.a(i7, this.o.array());
                        t52Var.b(i7, this.m);
                        this.T += i7;
                    }
                }
            } else {
                byte[] bArr = bVar.i;
                if (bArr != null) {
                    this.j.a(bArr.length, bArr);
                }
            }
            if (!"A_OPUS".equals(bVar.b) ? bVar.f > 0 : z) {
                this.O |= 268435456;
                this.n.c(0);
                int iE = (this.j.e() + i) - this.S;
                this.g.c(4);
                this.g.c()[0] = (byte) ((iE >> 24) & 255);
                this.g.c()[1] = (byte) ((iE >> 16) & 255);
                this.g.c()[2] = (byte) ((iE >> 8) & 255);
                this.g.c()[3] = (byte) (iE & 255);
                t52Var.b(4, this.g);
                this.T += 4;
            }
            this.V = true;
        }
        int iE2 = this.j.e() + i;
        if (!"V_MPEG4/ISO/AVC".equals(bVar.b) && !"V_MPEGH/ISO/HEVC".equals(bVar.b)) {
            if (bVar.T != null) {
                if (this.j.e() == 0) {
                    bVar.T.a(tzVar);
                } else {
                    throw new IllegalStateException();
                }
            }
            while (true) {
                int i11 = this.S;
                if (i11 >= iE2) {
                    break;
                }
                int i12 = iE2 - i11;
                int iA = this.j.a();
                if (iA > 0) {
                    iB2 = Math.min(i12, iA);
                    t52Var.a(iB2, this.j);
                } else {
                    iB2 = t52Var.b(tzVar, i12, false);
                }
                this.S += iB2;
                this.T += iB2;
            }
        } else {
            byte[] bArrC = this.f.c();
            bArrC[0] = 0;
            bArrC[1] = 0;
            bArrC[2] = 0;
            int i13 = bVar.Y;
            int i14 = 4 - i13;
            while (this.S < iE2) {
                int i15 = this.U;
                if (i15 == 0) {
                    int iMin = Math.min(i13, this.j.a());
                    tzVar.a(bArrC, i14 + iMin, i13 - iMin, false);
                    if (iMin > 0) {
                        this.j.a(bArrC, i14, iMin);
                    }
                    this.S += i13;
                    this.f.e(0);
                    this.U = this.f.x();
                    this.e.e(0);
                    t52Var.a(4, this.e);
                    this.T += 4;
                } else {
                    int iA2 = this.j.a();
                    if (iA2 > 0) {
                        iB = Math.min(i15, iA2);
                        t52Var.a(iB, this.j);
                    } else {
                        iB = t52Var.b(tzVar, i15, false);
                    }
                    this.S += iB;
                    this.T += iB;
                    this.U -= iB;
                }
            }
        }
        if ("A_VORBIS".equals(bVar.b)) {
            this.h.e(0);
            t52Var.a(4, this.h);
            this.T += 4;
        }
        int i16 = this.T;
        b();
        return i16;
    }

    private void a(tz tzVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        if (this.k.b() < length) {
            this.k.a(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.k.c(), 0, bArr.length);
        }
        tzVar.a(this.k.c(), bArr.length, i, false);
        this.k.e(0);
        this.k.d(length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static w70[] a() {
        return new w70[]{new hu0(new rz())};
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        return new o02().b((tz) x70Var);
    }
}
