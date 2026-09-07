package com.yandex.mobile.ads.impl;

import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public final class u implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v f10342a = new v();
    private final wf1 b = new wf1(16384);
    private boolean c;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.u$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return u.a();
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.f10342a.a(y70Var, new i72.d(Integer.MIN_VALUE, 0, 1));
        y70Var.a();
        y70Var.a(new xw1.b(-9223372036854775807L, 0L));
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        int i = ((tz) x70Var).read(this.b.c(), 0, 16384);
        if (i == -1) {
            return -1;
        }
        this.b.e(0);
        this.b.d(i);
        if (!this.c) {
            this.f10342a.a(4, 0L);
            this.c = true;
        }
        this.f10342a.a(this.b);
        return 0;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        this.c = false;
        this.f10342a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w70[] a() {
        return new w70[]{new u()};
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        tz tzVar;
        int i;
        wf1 wf1Var = new wf1(10);
        int i2 = 0;
        while (true) {
            tzVar = (tz) x70Var;
            tzVar.b(wf1Var.c(), 0, 10, false);
            wf1Var.e(0);
            if (wf1Var.w() != 4801587) {
                break;
            }
            wf1Var.f(3);
            int iS = wf1Var.s();
            i2 += iS + 10;
            tzVar.a(false, iS);
        }
        tzVar.c();
        tzVar.a(false, i2);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = 7;
            tzVar.b(wf1Var.c(), 0, 7, false);
            wf1Var.e(0);
            int iZ = wf1Var.z();
            if (iZ == 44096 || iZ == 44097) {
                i3++;
                if (i3 >= 4) {
                    return true;
                }
                byte[] bArrC = wf1Var.c();
                if (bArrC.length < 7) {
                    i = -1;
                } else {
                    int i6 = ((bArrC[2] & 255) << 8) | (bArrC[3] & 255);
                    if (i6 == 65535) {
                        i6 = ((bArrC[4] & 255) << 16) | ((bArrC[5] & 255) << 8) | (bArrC[6] & 255);
                    } else {
                        i5 = 4;
                    }
                    if (iZ == 44097) {
                        i5 += 2;
                    }
                    i = i6 + i5;
                }
                if (i == -1) {
                    return false;
                }
                tzVar.a(false, i - 7);
            } else {
                tzVar.c();
                i4++;
                if (i4 - i2 >= 8192) {
                    return false;
                }
                tzVar.a(false, i4);
                i3 = 0;
            }
        }
    }
}
