package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.webkit.WebView;
import com.json.cc;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.internal.partials.MolocoAdsNetworkBridge;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6540a = "https://appassets.androidplatform.net";
    public static final String b = "\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> \n    <style> body { margin:0; padding:0; overflow:hidden; } </style>\n";

    public static final void a(WebView webView, String data) {
        Intrinsics.checkNotNullParameter(webView, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        MolocoAdsNetworkBridge.webviewLoadDataWithBaseURL(webView, f6540a, data, POBCommonConstants.CONTENT_TYPE_HTML, cc.N, null);
    }

    public static final String a(String toHtml) {
        Intrinsics.checkNotNullParameter(toHtml, "toHtml");
        return b + toHtml;
    }
}
