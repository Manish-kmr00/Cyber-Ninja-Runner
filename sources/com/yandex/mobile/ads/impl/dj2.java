package com.yandex.mobile.ads.impl;

import android.util.Pair;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class dj2 implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y70 f8700a;
    private t52 b;
    private b e;
    private int c = 0;
    private long d = -1;
    private int f = -1;
    private long g = -1;

    private interface b {
        void a(int i, long j) throws ag1;

        void a(long j);

        boolean a(tz tzVar, long j) throws IOException;
    }

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.dj2$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return dj2.a();
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.f8700a = y70Var;
        this.b = y70Var.a(0, 1);
        y70Var.a();
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0107  */
    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        int i;
        if (this.b != null) {
            int i2 = x82.f10629a;
            int i3 = this.c;
            int iB = 4;
            if (i3 == 0) {
                tz tzVar = (tz) x70Var;
                if (tzVar.a() == 0) {
                    int i4 = this.f;
                    if (i4 != -1) {
                        tzVar.a(i4);
                        this.c = 4;
                    } else if (fj2.a(tzVar)) {
                        tzVar.a((int) (tzVar.d() - tzVar.a()));
                        this.c = 1;
                    } else {
                        throw ag1.a("Unsupported or unrecognized wav file type.", (Exception) null);
                    }
                    return 0;
                }
                throw new IllegalStateException();
            }
            long jL = -1;
            if (i3 == 1) {
                wf1 wf1Var = new wf1(8);
                tz tzVar2 = (tz) x70Var;
                fj2.a aVarA = fj2.a.a(tzVar2, wf1Var);
                if (aVarA.f8902a != 1685272116) {
                    tzVar2.c();
                } else {
                    tzVar2.a(false, 8);
                    wf1Var.e(0);
                    tzVar2.b(wf1Var.c(), 0, 8, false);
                    jL = wf1Var.l();
                    tzVar2.a(((int) aVarA.b) + 8);
                }
                this.d = jL;
                this.c = 2;
                return 0;
            }
            if (i3 == 2) {
                ej2 ej2VarB = fj2.b((tz) x70Var);
                int i5 = ej2VarB.f8805a;
                if (i5 == 17) {
                    this.e = new a(this.f8700a, this.b, ej2VarB);
                } else if (i5 == 6) {
                    this.e = new c(this.f8700a, this.b, ej2VarB, "audio/g711-alaw", -1);
                } else if (i5 == 7) {
                    this.e = new c(this.f8700a, this.b, ej2VarB, "audio/g711-mlaw", -1);
                } else {
                    int i6 = ej2VarB.e;
                    if (i5 == 1) {
                        iB = x82.b(i6);
                        i = iB;
                    } else {
                        if (i5 != 3) {
                            if (i5 == 65534) {
                                iB = x82.b(i6);
                                i = iB;
                            }
                        } else if (i6 == 32) {
                            i = iB;
                        }
                        i = 0;
                    }
                    if (i != 0) {
                        this.e = new c(this.f8700a, this.b, ej2VarB, "audio/raw", i);
                    } else {
                        throw ag1.a("Unsupported WAV format type: " + ej2VarB.f8805a);
                    }
                }
                this.c = 3;
                return 0;
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    throw new IllegalStateException();
                }
                long j = this.g;
                if (j != -1) {
                    tz tzVar3 = (tz) x70Var;
                    long jA = j - tzVar3.a();
                    b bVar = this.e;
                    bVar.getClass();
                    return bVar.a(tzVar3, jA) ? -1 : 0;
                }
                throw new IllegalStateException();
            }
            tz tzVar4 = (tz) x70Var;
            Pair pairC = fj2.c(tzVar4);
            this.f = ((Long) pairC.first).intValue();
            long jLongValue = ((Long) pairC.second).longValue();
            long j2 = this.d;
            if (j2 != -1 && jLongValue == 4294967295L) {
                jLongValue = j2;
            }
            this.g = ((long) this.f) + jLongValue;
            long jB = tzVar4.b();
            if (jB != -1 && this.g > jB) {
                at0.d("WavExtractor", "Data exceeds input length: " + this.g + ", " + jB);
                this.g = jB;
            }
            b bVar2 = this.e;
            bVar2.getClass();
            bVar2.a(this.f, this.g);
            this.c = 4;
            return 0;
        }
        throw new IllegalStateException();
    }

    private static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y70 f8702a;
        private final t52 b;
        private final ej2 c;
        private final gc0 d;
        private final int e;
        private long f;
        private int g;
        private long h;

        public c(y70 y70Var, t52 t52Var, ej2 ej2Var, String str, int i) throws ag1 {
            this.f8702a = y70Var;
            this.b = t52Var;
            this.c = ej2Var;
            int i2 = (ej2Var.b * ej2Var.e) / 8;
            if (ej2Var.d == i2) {
                int i3 = ej2Var.c * i2;
                int i4 = i3 * 8;
                int iMax = Math.max(i2, i3 / 10);
                this.e = iMax;
                this.d = new gc0.a().e(str).b(i4).j(i4).h(iMax).c(ej2Var.b).l(ej2Var.c).i(i).a();
                return;
            }
            throw ag1.a("Expected block size: " + i2 + "; got: " + ej2Var.d, (Exception) null);
        }

        @Override // com.yandex.mobile.ads.impl.dj2.b
        public final void a(int i, long j) {
            this.f8702a.a(new gj2(this.c, 1, i, j));
            this.b.a(this.d);
        }

        @Override // com.yandex.mobile.ads.impl.dj2.b
        public final void a(long j) {
            this.f = j;
            this.g = 0;
            this.h = 0L;
        }

        @Override // com.yandex.mobile.ads.impl.dj2.b
        public final boolean a(tz tzVar, long j) throws IOException {
            int i;
            int i2;
            long j2 = j;
            while (j2 > 0 && (i = this.g) < (i2 = this.e)) {
                int iB = this.b.b(tzVar, (int) Math.min(i2 - i, j2), true);
                if (iB == -1) {
                    j2 = 0;
                } else {
                    this.g += iB;
                    j2 -= (long) iB;
                }
            }
            ej2 ej2Var = this.c;
            int i3 = ej2Var.d;
            int i4 = this.g / i3;
            if (i4 > 0) {
                long jA = this.f + x82.a(this.h, 1000000L, ej2Var.c);
                int i5 = i4 * i3;
                int i6 = this.g - i5;
                this.b.a(jA, 1, i5, i6, null);
                this.h += (long) i4;
                this.g = i6;
            }
            return j2 <= 0;
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.c = j == 0 ? 0 : 4;
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(j2);
        }
    }

    private static final class a implements b {
        private static final int[] m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y70 f8701a;
        private final t52 b;
        private final ej2 c;
        private final int d;
        private final byte[] e;
        private final wf1 f;
        private final int g;
        private final gc0 h;
        private int i;
        private long j;
        private int k;
        private long l;

        private static int a(int i, int i2) {
            return i * 2 * i2;
        }

        public a(y70 y70Var, t52 t52Var, ej2 ej2Var) throws ag1 {
            this.f8701a = y70Var;
            this.b = t52Var;
            this.c = ej2Var;
            int iMax = Math.max(1, ej2Var.c / 10);
            this.g = iMax;
            wf1 wf1Var = new wf1(ej2Var.f);
            wf1Var.o();
            int iO = wf1Var.o();
            this.d = iO;
            int i = ej2Var.b;
            int i2 = (((ej2Var.d - (i * 4)) * 8) / (ej2Var.e * i)) + 1;
            if (iO == i2) {
                int iA = x82.a(iMax, iO);
                this.e = new byte[ej2Var.d * iA];
                this.f = new wf1(iA * a(iO, i));
                int i3 = ((ej2Var.c * ej2Var.d) * 8) / iO;
                this.h = new gc0.a().e("audio/raw").b(i3).j(i3).h(a(iMax, i)).c(ej2Var.b).l(ej2Var.c).i(2).a();
                return;
            }
            throw ag1.a("Expected frames per block: " + i2 + "; got: " + iO, (Exception) null);
        }

        @Override // com.yandex.mobile.ads.impl.dj2.b
        public final void a(int i, long j) {
            this.f8701a.a(new gj2(this.c, this.d, i, j));
            this.b.a(this.h);
        }

        @Override // com.yandex.mobile.ads.impl.dj2.b
        public final void a(long j) {
            this.i = 0;
            this.j = j;
            this.k = 0;
            this.l = 0L;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0042 A[LOOP:0: B:6:0x0025->B:12:0x0042, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:41:0x0048 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:43:0x0040 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0027  */
        /* JADX WARN: Code duplicated, block: B:9:0x002b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003e -> B:11:0x0040). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // com.yandex.mobile.ads.impl.dj2.b
        public final boolean a(com.yandex.mobile.ads.impl.tz r21, long r22) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 453
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.dj2.a.a(com.yandex.mobile.ads.impl.tz, long):boolean");
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        return fj2.a((tz) x70Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w70[] a() {
        return new w70[]{new dj2()};
    }
}
