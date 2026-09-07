package com.ogury.ad.internal;

import android.webkit.WebView;
import com.ogury.core.internal.IntegrationLogger;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j3 implements v9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d5 f7327a;
    public final c b;
    public final m4 c;
    public final u5 d;
    public final d4 e;
    public l3 f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;

    public j3(d5 webView, c ad, m4 webViewCache, u5 oguryAdGateway, d4 monitoringEventLogger) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(webViewCache, "webViewCache");
        Intrinsics.checkNotNullParameter(oguryAdGateway, "oguryAdGateway");
        Intrinsics.checkNotNullParameter(monitoringEventLogger, "monitoringEventLogger");
        this.f7327a = webView;
        this.b = ad;
        this.c = webViewCache;
        this.d = oguryAdGateway;
        this.e = monitoringEventLogger;
        webView.setClientAdapter(new i3(this));
    }

    public static final void a(j3 j3Var, d5 d5Var, c cVar) {
        j3Var.getClass();
        ca.a((WebView) d5Var);
        z3 z3Var = z3.f7460a;
        z3.a(new h9("loaded_error", cVar));
    }

    public static final void f(j3 j3Var) {
        String str;
        if (!j3Var.j && j3Var.h && j3Var.g) {
            c cVar = j3Var.b;
            if (cVar.A.f7388a != r3.LOADED_SOURCE_FORMAT || j3Var.i) {
                j3Var.j = true;
                d4 d4Var = j3Var.e;
                o7 o7Var = o7.LI_008_SDK_EVENT_AD_PRECACHED;
                Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
                r3 r3Var = j3Var.b.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var, "<this>");
                int iOrdinal = r3Var.ordinal();
                if (iOrdinal == 0) {
                    str = "format";
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "sdk";
                }
                Pair pair2 = TuplesKt.to("loaded_source", str);
                Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(j3Var.b.J));
                int i = j3Var.k;
                d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
                z3 z3Var = z3.f7460a;
                z3.a(new h9(com.ironsource.b9.h.r, j3Var.b));
                l4 mraidCacheItem = new l4(new WeakReference(j3Var.d), j3Var.f7327a, j3Var.b);
                j3Var.c.getClass();
                Intrinsics.checkNotNullParameter(mraidCacheItem, "mraidCacheItem");
                m4.b.put(mraidCacheItem.c.f7272a, mraidCacheItem);
                m4.d();
                l3 l3Var = j3Var.f;
                if (l3Var != null) {
                    l3Var.c(j3Var.b);
                }
            }
        }
    }

    public static final void g(j3 j3Var) {
        l3 l3Var = j3Var.f;
        if (l3Var != null) {
            l3Var.b(j3Var.b);
        }
    }

    @Override // com.ogury.ad.internal.v9
    public final boolean b() {
        return this.j;
    }

    @Override // com.ogury.ad.internal.v9
    public final void a(l3 loadCallback, int i) {
        String str;
        Intrinsics.checkNotNullParameter(loadCallback, "loadCallback");
        this.k = i;
        loadCallback.a(this.b);
        d4 d4Var = this.e;
        o7 o7Var = o7.LI_005_SDK_EVENT_AD_PRECACHING;
        c cVar = this.b;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
        r3 r3Var = this.b.A.f7388a;
        Intrinsics.checkNotNullParameter(r3Var, "<this>");
        int iOrdinal = r3Var.ordinal();
        if (iOrdinal == 0) {
            str = "format";
        } else if (iOrdinal == 1) {
            str = "sdk";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        d4Var.a(o7Var, cVar, p7.a(pair, TuplesKt.to("loaded_source", str), TuplesKt.to("reload", Boolean.valueOf(this.b.J)), TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
        this.f = loadCallback;
        d5 d5Var = this.f7327a;
        c ad = this.b;
        Intrinsics.checkNotNullParameter(d5Var, "<this>");
        Intrinsics.checkNotNullParameter(ad, "ad");
        String str2 = ad.i;
        if (str2.length() == 0) {
            str2 = "http://ads-test.st.ogury.com/";
        }
        String str3 = str2;
        String str4 = ad.c;
        if (str4.length() == 0) {
            str4 = "The ad contains no ad_content";
        }
        try {
            d5Var.loadDataWithBaseURL(str3, str4, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
        } catch (Throwable th) {
            IntegrationLogger.e(th);
        }
    }

    @Override // com.ogury.ad.internal.v9
    public final void a() {
        this.f = null;
        this.f7327a.setClientAdapter(null);
        this.f7327a.setDestroyed(true);
        ca.a((WebView) this.f7327a);
    }
}
