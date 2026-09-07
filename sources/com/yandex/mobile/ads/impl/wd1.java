package com.yandex.mobile.ads.impl;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: loaded from: classes3.dex */
public final class wd1 implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y70 f10557a;
    private r22 b;
    private boolean c;

    static {
        new a80() { // from class: com.yandex.mobile.ads.impl.wd1$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.a80
            public final w70[] a() {
                return wd1.a();
            }
        };
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void release() {
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(y70 y70Var) {
        this.f10557a = y70Var;
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final int a(x70 x70Var, lj1 lj1Var) throws IOException {
        if (this.f10557a != null) {
            if (this.b == null) {
                tz tzVar = (tz) x70Var;
                if (a(tzVar)) {
                    tzVar.c();
                } else {
                    throw ag1.a("Failed to determine bitstream type", (Exception) null);
                }
            }
            if (!this.c) {
                t52 t52VarA = this.f10557a.a(0, 1);
                this.f10557a.a();
                this.b.a(this.f10557a, t52VarA);
                this.c = true;
            }
            return this.b.a((tz) x70Var, lj1Var);
        }
        throw new IllegalStateException();
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final void a(long j, long j2) {
        r22 r22Var = this.b;
        if (r22Var != null) {
            r22Var.a(j, j2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.w70
    public final boolean a(x70 x70Var) throws IOException {
        try {
            return a((tz) x70Var);
        } catch (ag1 unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w70[] a() {
        return new w70[]{new wd1()};
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private boolean a(tz tzVar) throws IOException {
        yd1 yd1Var = new yd1();
        if (yd1Var.a(tzVar, true) && (yd1Var.f10727a & 2) == 2) {
            int iMin = Math.min(yd1Var.e, 8);
            wf1 wf1Var = new wf1(iMin);
            tzVar.b(wf1Var.c(), 0, iMin, false);
            wf1Var.e(0);
            if (wf1Var.a() >= 5 && wf1Var.t() == 127 && wf1Var.v() == 1179402563) {
                this.b = new vb0();
            } else {
                wf1Var.e(0);
                try {
                    if (yi2.a(1, wf1Var, true)) {
                        this.b = new xi2();
                    } else {
                        wf1Var.e(0);
                        if (df1.b(wf1Var)) {
                            this.b = new df1();
                        }
                    }
                } catch (ag1 unused) {
                }
            }
            return true;
        }
        return false;
    }
}
