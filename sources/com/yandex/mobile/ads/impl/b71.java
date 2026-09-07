package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class b71 implements ja1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w71 f8480a;
    private final o8<?> b;
    private final ch1 c;
    private c71 d;

    public f92 a(Context context, f92.a status, boolean z, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(status, "status");
        return new f92(status);
    }

    public /* synthetic */ b71(Context context, k41 k41Var, o8 o8Var) {
        this(context, k41Var, o8Var, ch1.h.a(context));
    }

    @Override // com.yandex.mobile.ads.impl.ja1
    public final boolean b() {
        c71 c71Var = this.d;
        View viewE = c71Var != null ? c71Var.e() : null;
        if (viewE != null) {
            return oh2.d(viewE);
        }
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.ja1
    public final boolean c() {
        c71 c71Var = this.d;
        View viewE = c71Var != null ? c71Var.e() : null;
        return viewE != null && oh2.b(viewE) >= 1;
    }

    public b71(Context context, k41 nativeAdAssetsValidator, o8 adResponse, ch1 phoneStateTracker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdAssetsValidator, "nativeAdAssetsValidator");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(phoneStateTracker, "phoneStateTracker");
        this.f8480a = nativeAdAssetsValidator;
        this.b = adResponse;
        this.c = phoneStateTracker;
    }

    @Override // com.yandex.mobile.ads.impl.ja1
    public final f92 b(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Pair<f92.a, String> pairA = a(context, i, !this.c.b(), true);
        f92 f92VarA = a(context, pairA.getFirst(), true, i);
        f92VarA.a(pairA.getSecond());
        return f92VarA;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x008d  */
    public Pair<f92.a, String> a(Context context, int i, boolean z, boolean z2) {
        f92.a aVarB;
        Intrinsics.checkNotNullParameter(context, "context");
        String strW = this.b.w();
        String strA = null;
        if (z && !z2) {
            aVarB = f92.a.d;
        } else if (b()) {
            aVarB = f92.a.m;
        } else {
            c71 c71Var = this.d;
            View view = c71Var != null ? c71Var.e() : null;
            if (view != null) {
                int i2 = oh2.b;
                Intrinsics.checkNotNullParameter(view, "view");
                if (view.getWidth() >= 10 && view.getHeight() >= 10) {
                    c71 c71Var2 = this.d;
                    View viewE = c71Var2 != null ? c71Var2.e() : null;
                    if (viewE != null && oh2.b(viewE) >= 1) {
                        c71 c71Var3 = this.d;
                        View viewE2 = c71Var3 != null ? c71Var3.e() : null;
                        if ((viewE2 == null || !oh2.a(viewE2, i)) && !z2) {
                            aVarB = f92.a.j;
                        } else if (!Intrinsics.areEqual(d10.DIV_KIT.a(), strW)) {
                            v71 v71VarA = this.f8480a.a(z2);
                            strA = v71VarA.a();
                            aVarB = v71VarA.b();
                        } else {
                            aVarB = f92.a.c;
                        }
                    } else {
                        aVarB = f92.a.o;
                    }
                } else {
                    aVarB = f92.a.n;
                }
            } else {
                aVarB = f92.a.n;
            }
        }
        return new Pair<>(aVarB, strA);
    }

    @Override // com.yandex.mobile.ads.impl.ja1
    public final void a(c71 c71Var) {
        this.f8480a.a(c71Var);
        this.d = c71Var;
    }

    @Override // com.yandex.mobile.ads.impl.ja1
    public final jq1 a() {
        return this.f8480a.a();
    }

    @Override // com.yandex.mobile.ads.impl.ja1
    public final f92 a(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Pair<f92.a, String> pairA = a(context, i, !this.c.b(), false);
        f92 f92VarA = a(context, pairA.getFirst(), false, i);
        f92VarA.a(pairA.getSecond());
        return f92VarA;
    }
}
