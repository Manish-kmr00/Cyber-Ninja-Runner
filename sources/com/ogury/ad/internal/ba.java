package com.ogury.ad.internal;

import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ba extends WebChromeClient {
    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        Logger.d("Ogury|SafeDK: Execution> Lcom/ogury/ad/internal/ba;->onCreateWindow(Landroid/webkit/WebView;ZZLandroid/os/Message;)Z");
        boolean zSafedk_ba_onCreateWindow_741cb2b079b22f04af230f88f80fe5fa = safedk_ba_onCreateWindow_741cb2b079b22f04af230f88f80fe5fa(webView, z, z2, message);
        BrandSafetyUtils.onWebChromeClientCreateWindow("io.presage", webView, message, zSafedk_ba_onCreateWindow_741cb2b079b22f04af230f88f80fe5fa);
        return zSafedk_ba_onCreateWindow_741cb2b079b22f04af230f88f80fe5fa;
    }

    public boolean safedk_ba_onCreateWindow_741cb2b079b22f04af230f88f80fe5fa(WebView view, boolean p1, boolean p2, Message p3) {
        Intrinsics.checkNotNullParameter(view, "view");
        String extra = view.getHitTestResult().getExtra();
        if (extra == null) {
            return false;
        }
        boolean p4 = StringsKt.isBlank(extra);
        if (p4) {
            return false;
        }
        view.loadUrl(extra);
        return false;
    }
}
