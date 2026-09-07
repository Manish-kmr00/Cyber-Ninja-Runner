package com.five_corp.ad.internal.movie.partialcache;

import android.media.MediaFormat;
import com.five_corp.ad.internal.movie.C2985g;
import com.five_corp.ad.internal.movie.RunnableC2990l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class p1 implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3000e f1494a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ byte[] e;
    public final /* synthetic */ s1 f;

    public p1(s1 s1Var, C3000e c3000e, int i, int i2, int i3, byte[] bArr) {
        this.f = s1Var;
        this.f1494a = c3000e;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = bArr;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:112:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:114:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:190:0x0386 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0386 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x0351 A[SYNTHETIC] */
    @Override // com.five_corp.ad.internal.movie.partialcache.u1
    public final void a(Object obj) {
        C3017m0 c3017m0;
        int i;
        C3013k0 c3013k0;
        F0 f0;
        B0 b0;
        C3005g0 c3005g0;
        Y y;
        V v;
        V v2;
        C3039y c3039y;
        C3041z c3041z;
        t1 t1Var = (t1) obj;
        if (t1Var.d != 3 && t1Var.f1498a == this.f1494a) {
            int i2 = this.b;
            if (i2 <= 0) {
                s1 s1Var = this.f;
                com.five_corp.ad.internal.o oVar = new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.p5, String.format("onLoadNewData: offsetFromStartByteInclusive: %d, size: %d, offsetFromResourceFileHead: %d", Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(this.d)), null, null);
                s1Var.getClass();
                if (t1Var.d == 3) {
                    return;
                }
                t1Var.d = 3;
                s1Var.e.a(oVar);
                return;
            }
            com.five_corp.ad.internal.util.g gVarA = t1Var.b.a(this.e, this.c, i2, this.d);
            if (!gVarA.f1560a) {
                s1 s1Var2 = this.f;
                com.five_corp.ad.internal.o oVar2 = gVarA.b;
                s1Var2.getClass();
                if (t1Var.d == 3) {
                    return;
                }
                t1Var.d = 3;
                s1Var2.e.a(oVar2);
                return;
            }
            int i3 = 2;
            boolean z = true;
            if (t1Var.d == 1) {
                s1 s1Var3 = this.f;
                s1Var3.getClass();
                k1 k1Var = t1Var.c;
                com.five_corp.ad.internal.util.c cVar = t1Var.b;
                char c = 0;
                if (k1Var.k) {
                    i = 2;
                } else {
                    if (k1Var.b == null) {
                        k1Var.b = new C3021o0(cVar, k1Var.f1481a);
                    }
                    C3021o0 c3021o0 = k1Var.b;
                    int i4 = 4;
                    if (c3021o0.c == null) {
                        while (true) {
                            int i5 = AbstractC3037x.f1506a[c3021o0.b.ordinal()];
                            if (i5 == z) {
                                c3021o0.g = 0L;
                                com.five_corp.ad.internal.util.c cVar2 = c3021o0.f1493a;
                                if (cVar2.g < cVar2.h + i4) {
                                    break;
                                }
                                z = true;
                                int iB = cVar2.b();
                                HashMap map = h1.f1479a;
                                long j = iB;
                                if (iB < 0) {
                                    j += 4294967296L;
                                }
                                c3021o0.d = j;
                                c3021o0.b = EnumC3019n0.AfterSize;
                                c3021o0.g += 4;
                                i3 = 2;
                                c = 0;
                                i4 = 4;
                            } else if (i5 == i3) {
                                com.five_corp.ad.internal.util.c cVar3 = c3021o0.f1493a;
                                if (cVar3.g < cVar3.h + i4) {
                                    break;
                                }
                                cVar3.a(c3021o0.e);
                                c3021o0.b = EnumC3019n0.AfterType;
                                c3021o0.g += 4;
                                i3 = 2;
                                z = true;
                            } else if (i5 == 3) {
                                long j2 = c3021o0.d;
                                if (j2 == 0) {
                                    c3021o0.b = EnumC3019n0.AfterExtendedSze;
                                    break;
                                }
                                if (j2 == 1) {
                                    com.five_corp.ad.internal.util.c cVar4 = c3021o0.f1493a;
                                    if (cVar4.g < cVar4.h + 8) {
                                        break;
                                    }
                                    c3021o0.d = cVar4.c();
                                    c3021o0.b = EnumC3019n0.AfterExtendedSze;
                                    c3021o0.g += 8;
                                } else {
                                    c3021o0.b = EnumC3019n0.AfterExtendedSze;
                                }
                                i3 = 2;
                                z = true;
                            } else if (i5 == i4) {
                                if (Arrays.equals(c3021o0.e, B.e)) {
                                    com.five_corp.ad.internal.util.c cVar5 = c3021o0.f1493a;
                                    int i6 = cVar5.g;
                                    int i7 = cVar5.h;
                                    byte[] bArr = c3021o0.f;
                                    if (i6 < i7 + bArr.length) {
                                        break;
                                    }
                                    cVar5.a(bArr);
                                    c3021o0.b = EnumC3019n0.InBox;
                                    c3021o0.g += 16;
                                } else {
                                    c3021o0.b = EnumC3019n0.InBox;
                                }
                                i3 = 2;
                                z = true;
                            } else if (i5 != 5) {
                                continue;
                            } else {
                                int i8 = (int) ((((long) c3021o0.f1493a.h) + c3021o0.d) - c3021o0.g);
                                byte[] bArr2 = c3021o0.e;
                                byte[] bArr3 = B.e;
                                if (Arrays.equals(bArr2, (byte[]) h1.f1479a.get(C3017m0.class))) {
                                    com.five_corp.ad.internal.util.c cVar6 = c3021o0.f1493a;
                                    if (cVar6.g < i8) {
                                        break;
                                    }
                                    try {
                                        c3021o0.c = (C3017m0) h1.a(cVar6, c3021o0.d, c3021o0.e, c3021o0.f, (int) c3021o0.g, c3021o0.h);
                                        break;
                                    } catch (C3036w0 e) {
                                        HashMap map2 = h1.f1479a;
                                        e.getMessage();
                                        break;
                                    }
                                }
                                com.five_corp.ad.internal.util.c cVar7 = c3021o0.f1493a;
                                if (cVar7.g < i8) {
                                    break;
                                }
                                cVar7.b(i8);
                                c3021o0.b = EnumC3019n0.BeforeBox;
                                i3 = 2;
                                z = true;
                            }
                        }
                    }
                    if (!k1Var.k && (c3017m0 = k1Var.b.c) != null) {
                        k1Var.c = c3017m0;
                        C3030t0 c3030t0 = (C3030t0) j1.a(c3017m0, C3030t0.class);
                        if (c3030t0 != null) {
                            k1Var.f = (int) ((c3030t0.i * 1000) / ((long) c3030t0.h));
                            C3017m0 c3017m1 = k1Var.c;
                            ArrayList arrayList = new ArrayList();
                            for (B b : c3017m1.c) {
                                if (X0.class.isInstance(b)) {
                                    arrayList.add(b);
                                }
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                C3007h0 c3007h0 = (C3007h0) j1.a((X0) it.next(), C3007h0.class);
                                if (c3007h0 != null) {
                                    C3011j0 c3011j0 = (C3011j0) j1.a(c3007h0, C3011j0.class);
                                    C2999d0 c2999d0 = (C2999d0) j1.a(c3007h0, C2999d0.class);
                                    if (c2999d0 != null) {
                                        if (Arrays.equals(c2999d0.h, "vide".getBytes())) {
                                            C3013k0 c3013k1 = (C3013k0) j1.a(c3007h0, C3013k0.class);
                                            if (c3013k1 != null) {
                                                F0 f1 = (F0) j1.a(c3013k1, F0.class);
                                                if (c3011j0 != null) {
                                                    k1Var.i = new i1(c3011j0.h, f1);
                                                    B0 b1 = (B0) j1.a(f1, B0.class);
                                                    if (b1 != null && (c3039y = (C3039y) j1.a(b1, C3039y.class)) != null && (c3041z = (C3041z) j1.a(c3039y, C3041z.class)) != null) {
                                                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(c3041z.i[c].length + i4);
                                                        byte[] bArr4 = new byte[i4];
                                                        // fill-array-data instruction
                                                        bArr4[0] = 0;
                                                        bArr4[1] = 0;
                                                        bArr4[2] = 0;
                                                        bArr4[3] = 1;
                                                        byteBufferAllocate.put(bArr4);
                                                        byteBufferAllocate.put(c3041z.i[c]);
                                                        byteBufferAllocate.rewind();
                                                        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(c3041z.j[c].length + i4);
                                                        byte[] bArr5 = new byte[i4];
                                                        // fill-array-data instruction
                                                        bArr5[0] = 0;
                                                        bArr5[1] = 0;
                                                        bArr5[2] = 0;
                                                        bArr5[3] = 1;
                                                        byteBufferAllocate2.put(bArr5);
                                                        byteBufferAllocate2.put(c3041z.j[c]);
                                                        byteBufferAllocate2.rewind();
                                                        k1Var.g = new w1(c3039y.f, c3039y.g, byteBufferAllocate, byteBufferAllocate2, c3041z.f, c3041z.g);
                                                        if (!Arrays.equals(c2999d0.h, "soun".getBytes())) {
                                                            c3013k0 = (C3013k0) j1.a(c3007h0, C3013k0.class);
                                                            if (c3013k0 != null) {
                                                                f0 = (F0) j1.a(c3013k0, F0.class);
                                                                if (c3011j0 != null) {
                                                                    k1Var.j = new i1(c3011j0.h, f0);
                                                                    b0 = (B0) j1.a(f0, B0.class);
                                                                    if (b0 == null) {
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        c = 0;
                                                        i4 = 4;
                                                    }
                                                }
                                            }
                                        } else {
                                            if (!Arrays.equals(c2999d0.h, "soun".getBytes())) {
                                                c3013k0 = (C3013k0) j1.a(c3007h0, C3013k0.class);
                                                if (c3013k0 != null) {
                                                    f0 = (F0) j1.a(c3013k0, F0.class);
                                                    if (c3011j0 != null) {
                                                        k1Var.j = new i1(c3011j0.h, f0);
                                                        b0 = (B0) j1.a(f0, B0.class);
                                                        if (b0 == null && (c3005g0 = (C3005g0) j1.a(b0, C3005g0.class)) != null && (y = (Y) j1.a(c3005g0, Y.class)) != null) {
                                                            Iterator it2 = y.h.f1462a.iterator();
                                                            do {
                                                                if (!it2.hasNext()) {
                                                                    v = null;
                                                                    break;
                                                                }
                                                                v = (V) it2.next();
                                                            } while (!T.class.isInstance(v));
                                                            T t = (T) v;
                                                            if (t != null) {
                                                                Iterator it3 = t.f1462a.iterator();
                                                                do {
                                                                    if (!it3.hasNext()) {
                                                                        v2 = null;
                                                                        break;
                                                                    }
                                                                    v2 = (V) it3.next();
                                                                } while (!U.class.isInstance(v2));
                                                                U u = (U) v2;
                                                                if (u != null) {
                                                                    k1Var.h = new C2992a(c3005g0.g, c3005g0.f, ByteBuffer.wrap(u.b));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            c = 0;
                                            i4 = 4;
                                        }
                                    }
                                }
                            }
                            k1Var.b = null;
                            z = true;
                            k1Var.k = true;
                            i = 2;
                        }
                        throw new RuntimeException();
                    }
                }
                t1Var.d = i;
                k1 k1Var2 = t1Var.c;
                int i9 = k1Var2.f;
                MediaFormat mediaFormatB = k1Var2.b();
                MediaFormat mediaFormatA = t1Var.c.a();
                if (mediaFormatA == null) {
                    z = false;
                }
                t1Var.e = z;
                com.five_corp.ad.internal.movie.x xVar = s1Var3.e;
                xVar.getClass();
                xVar.n.post(new RunnableC2990l(xVar, new C2985g(xVar, mediaFormatB, mediaFormatA)));
            }
            if (t1Var.d == 2) {
                s1.a(this.f, t1Var);
            }
        }
    }
}
