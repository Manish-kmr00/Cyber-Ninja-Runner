package com.yandex.mobile.ads.impl;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class af0 implements y40 {
    private static final float[] l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w82 f8401a;
    private b f;
    private long g;
    private String h;
    private t52 i;
    private boolean j;
    private final boolean[] c = new boolean[4];
    private final a d = new a();
    private long k = -9223372036854775807L;
    private final z31 e = new z31(178);
    private final wf1 b = new wf1();

    @Override // com.yandex.mobile.ads.impl.y40
    public final void b() {
    }

    af0(w82 w82Var) {
        this.f8401a = w82Var;
    }

    /* JADX WARN: Code duplicated, block: B:120:0x02a4  */
    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(wf1 wf1Var) {
        int i;
        boolean z;
        int i2;
        int i3;
        float f;
        if (this.f != null) {
            if (this.i != null) {
                int iD = wf1Var.d();
                int iE = wf1Var.e();
                byte[] bArrC = wf1Var.c();
                this.g += (long) wf1Var.a();
                this.i.a(wf1Var.a(), wf1Var);
                while (true) {
                    int iA = a41.a(bArrC, iD, iE, this.c);
                    if (iA == iE) {
                        if (!this.j) {
                            this.d.a(bArrC, iD, iE);
                        }
                        b bVar = this.f;
                        if (bVar.c) {
                            int i4 = bVar.f;
                            int i5 = (iD + 1) - i4;
                            if (i5 < iE) {
                                bVar.d = ((bArrC[i5] & 192) >> 6) == 0;
                                bVar.c = false;
                            } else {
                                bVar.f = (iE - iD) + i4;
                            }
                        }
                        z31 z31Var = this.e;
                        if (z31Var != null) {
                            z31Var.a(bArrC, iD, iE);
                            return;
                        }
                        return;
                    }
                    int i6 = iA + 3;
                    int i7 = wf1Var.c()[i6];
                    int i8 = i7 & 255;
                    int i9 = iA - iD;
                    if (this.j) {
                        i = i6;
                    } else {
                        if (i9 > 0) {
                            this.d.a(bArrC, iD, iA);
                        }
                        int i10 = i9 < 0 ? -i9 : 0;
                        a aVar = this.d;
                        int i11 = aVar.b;
                        if (i11 == 0) {
                            i = i6;
                            i3 = 0;
                            if (i8 == 176) {
                                aVar.b = 1;
                                aVar.f8402a = true;
                            }
                        } else if (i11 == 1) {
                            i = i6;
                            i3 = 0;
                            if (i8 != 181) {
                                at0.d("H263Reader", "Unexpected start code value");
                                aVar.f8402a = false;
                                aVar.c = 0;
                                aVar.b = 0;
                            } else {
                                aVar.b = 2;
                            }
                        } else if (i11 == 2) {
                            i = i6;
                            i3 = 0;
                            if (i8 > 31) {
                                at0.d("H263Reader", "Unexpected start code value");
                                aVar.f8402a = false;
                                aVar.c = 0;
                                aVar.b = 0;
                            } else {
                                aVar.b = 3;
                            }
                        } else if (i11 == 3) {
                            i = i6;
                            if ((i7 & 240) != 32) {
                                at0.d("H263Reader", "Unexpected start code value");
                                i3 = 0;
                                aVar.f8402a = false;
                                aVar.c = 0;
                                aVar.b = 0;
                            } else {
                                i3 = 0;
                                aVar.d = aVar.c;
                                aVar.b = 4;
                            }
                        } else {
                            if (i11 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i8 == 179 || i8 == 181) {
                                aVar.c -= i10;
                                aVar.f8402a = false;
                                t52 t52Var = this.i;
                                int i12 = aVar.d;
                                String str = this.h;
                                str.getClass();
                                byte[] bArrCopyOf = Arrays.copyOf(aVar.e, aVar.c);
                                vf1 vf1Var = new vf1(bArrCopyOf.length, bArrCopyOf);
                                vf1Var.e(i12);
                                vf1Var.e(4);
                                vf1Var.h();
                                vf1Var.d(8);
                                if (vf1Var.f()) {
                                    vf1Var.d(4);
                                    vf1Var.d(3);
                                }
                                int iB = vf1Var.b(4);
                                i = i6;
                                if (iB == 15) {
                                    int iB2 = vf1Var.b(8);
                                    int iB3 = vf1Var.b(8);
                                    if (iB3 == 0) {
                                        at0.d("H263Reader", "Invalid aspect ratio");
                                        f = 1.0f;
                                    } else {
                                        f = iB2 / iB3;
                                    }
                                } else {
                                    float[] fArr = l;
                                    if (iB < 7) {
                                        f = fArr[iB];
                                    } else {
                                        at0.d("H263Reader", "Invalid aspect ratio");
                                        f = 1.0f;
                                    }
                                }
                                if (vf1Var.f()) {
                                    vf1Var.d(2);
                                    vf1Var.d(1);
                                    if (vf1Var.f()) {
                                        vf1Var.d(15);
                                        vf1Var.h();
                                        vf1Var.d(15);
                                        vf1Var.h();
                                        vf1Var.d(15);
                                        vf1Var.h();
                                        vf1Var.d(3);
                                        vf1Var.d(11);
                                        vf1Var.h();
                                        vf1Var.d(15);
                                        vf1Var.h();
                                    }
                                }
                                if (vf1Var.b(2) != 0) {
                                    at0.d("H263Reader", "Unhandled video object layer shape");
                                }
                                vf1Var.h();
                                int iB4 = vf1Var.b(16);
                                vf1Var.h();
                                if (vf1Var.f()) {
                                    if (iB4 == 0) {
                                        at0.d("H263Reader", "Invalid vop_increment_time_resolution");
                                    } else {
                                        int i13 = 0;
                                        for (int i14 = iB4 - 1; i14 > 0; i14 >>= 1) {
                                            i13++;
                                        }
                                        vf1Var.d(i13);
                                    }
                                }
                                vf1Var.h();
                                int iB5 = vf1Var.b(13);
                                vf1Var.h();
                                int iB6 = vf1Var.b(13);
                                vf1Var.h();
                                vf1Var.h();
                                t52Var.a(new gc0.a().b(str).e("video/mp4v-es").o(iB5).f(iB6).b(f).a(Collections.singletonList(bArrCopyOf)).a());
                                this.j = true;
                            } else {
                                i = i6;
                                i3 = 0;
                            }
                        }
                        aVar.a(a.f, i3, 3);
                    }
                    b bVar2 = this.f;
                    if (bVar2.c) {
                        int i15 = bVar2.f;
                        int i16 = (iD + 1) - i15;
                        if (i16 < iA) {
                            bVar2.d = ((bArrC[i16] & 192) >> 6) == 0;
                            bVar2.c = false;
                        } else {
                            bVar2.f = i15 + i9;
                        }
                    }
                    z31 z31Var2 = this.e;
                    if (z31Var2 == null) {
                        z = true;
                    } else {
                        if (i9 > 0) {
                            z31Var2.a(bArrC, iD, iA);
                            i2 = 0;
                        } else {
                            i2 = -i9;
                        }
                        if (this.e.a(i2)) {
                            z31 z31Var3 = this.e;
                            int iA2 = a41.a(z31Var3.e, z31Var3.d);
                            wf1 wf1Var2 = this.b;
                            int i17 = x82.f10629a;
                            wf1Var2.a(iA2, this.e.d);
                            this.f8401a.a(this.k, this.b);
                        }
                        if (i8 == 178) {
                            z = true;
                            if (wf1Var.c()[iA + 2] == 1) {
                                this.e.b(i8);
                            }
                        } else {
                            z = true;
                        }
                    }
                    int i18 = iE - iA;
                    long j = this.g - ((long) i18);
                    b bVar3 = this.f;
                    boolean z2 = this.j;
                    if (bVar3.e == 182 && z2 && bVar3.b) {
                        long j2 = bVar3.h;
                        if (j2 != -9223372036854775807L) {
                            bVar3.f8403a.a(j2, bVar3.d ? 1 : 0, (int) (j - bVar3.g), i18, null);
                        }
                    }
                    if (bVar3.e != 179) {
                        bVar3.g = j;
                    }
                    b bVar4 = this.f;
                    long j3 = this.k;
                    bVar4.e = i8;
                    bVar4.d = false;
                    bVar4.b = (i8 == 182 || i8 == 179) ? z : false;
                    if (i8 != 182) {
                        z = false;
                    }
                    bVar4.c = z;
                    bVar4.f = 0;
                    bVar4.h = j3;
                    iD = i;
                }
            } else {
                throw new IllegalStateException();
            }
        } else {
            throw new IllegalStateException();
        }
    }

    private static final class a {
        private static final byte[] f = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8402a;
        private int b;
        public int c;
        public int d;
        public byte[] e = new byte[128];

        public final void a(byte[] bArr, int i, int i2) {
            if (this.f8402a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.e;
                int length = bArr2.length;
                int i4 = this.c + i3;
                if (length < i4) {
                    this.e = Arrays.copyOf(bArr2, i4 * 2);
                }
                System.arraycopy(bArr, i, this.e, this.c, i3);
                this.c += i3;
            }
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t52 f8403a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;
        private int f;
        private long g;
        private long h;

        public b(t52 t52Var) {
            this.f8403a = t52Var;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(y70 y70Var, i72.d dVar) {
        dVar.a();
        this.h = dVar.b();
        t52 t52VarA = y70Var.a(dVar.c(), 2);
        this.i = t52VarA;
        this.f = new b(t52VarA);
        w82 w82Var = this.f8401a;
        if (w82Var != null) {
            w82Var.a(y70Var, dVar);
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a(int i, long j) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    @Override // com.yandex.mobile.ads.impl.y40
    public final void a() {
        a41.a(this.c);
        a aVar = this.d;
        aVar.f8402a = false;
        aVar.c = 0;
        aVar.b = 0;
        b bVar = this.f;
        if (bVar != null) {
            bVar.b = false;
            bVar.c = false;
            bVar.d = false;
            bVar.e = -1;
        }
        z31 z31Var = this.e;
        if (z31Var != null) {
            z31Var.b();
        }
        this.g = 0L;
        this.k = -9223372036854775807L;
    }
}
