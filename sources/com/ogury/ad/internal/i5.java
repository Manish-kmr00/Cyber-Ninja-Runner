package com.ogury.ad.internal;

import com.ogury.ad.mraid.browser.listeners.CloseSystemDialogsListener;
import com.ogury.ad.mraid.browser.listeners.OrientationListener;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i5 {
    public static final a l = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7321a;
    public final Map<String, d5> b;
    public final Map<String, aa> c;
    public final y0 d;
    public final k5 e;
    public final OrientationListener f;
    public final d4 g;
    public final i2 h;
    public final CloseSystemDialogsListener i;
    public m5 j;
    public final Pattern k;

    public static final class a {
    }

    public i5(c cVar, Map map, Map map2, y0 y0Var, k5 k5Var, OrientationListener orientationListener, d4 d4Var, i2 i2Var, CloseSystemDialogsListener closeSystemDialogsListener) {
        z3 z3Var = z3.f7460a;
        this.f7321a = cVar;
        this.b = map;
        this.c = map2;
        this.d = y0Var;
        this.e = k5Var;
        this.f = orientationListener;
        this.g = d4Var;
        this.h = i2Var;
        this.i = closeSystemDialogsListener;
        this.k = Pattern.compile(cVar.j);
    }

    public final void a(String str, o7 o7Var) {
        String str2;
        if (Intrinsics.areEqual(str, "browser-landing-page")) {
            d4 d4Var = this.g;
            c cVar = this.f7321a;
            Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
            r3 r3Var = this.f7321a.A.f7388a;
            Intrinsics.checkNotNullParameter(r3Var, "<this>");
            int iOrdinal = r3Var.ordinal();
            if (iOrdinal == 0) {
                str2 = "format";
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                str2 = "sdk";
            }
            Pair pair2 = TuplesKt.to("loaded_source", str2);
            Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(this.f7321a.J));
            int i = this.f7321a.K;
            d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
        }
    }
}
