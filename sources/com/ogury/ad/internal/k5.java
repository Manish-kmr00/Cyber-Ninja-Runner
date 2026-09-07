package com.ogury.ad.internal;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, d5> f7339a;
    public final Map<String, aa> b;

    public k5(Map<String, d5> webViewsMap, Map<String, aa> webViewStates) {
        Intrinsics.checkNotNullParameter(webViewsMap, "webViewsMap");
        Intrinsics.checkNotNullParameter(webViewStates, "webViewStates");
        this.f7339a = webViewsMap;
        this.b = webViewStates;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        for (d5 d5Var : this.f7339a.values()) {
            aa aaVar = this.b.get(z0.a((WebView) d5Var));
            if (aaVar != null && aaVar.d) {
                arrayList.add(d5Var);
            }
        }
        return arrayList;
    }

    public static void a(d5 webView, String callbackId, String webViewId) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(webViewId, "webViewId");
        h5.a(webView, o4.b(callbackId, "{webviewId:\"" + webViewId + "\"}"));
    }
}
