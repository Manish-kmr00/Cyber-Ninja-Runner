package com.ogury.ad.internal;

import android.content.Context;
import android.webkit.WebView;
import com.ogury.core.internal.IntegrationLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h5 {
    public static final void a(d5 d5Var, String javascript) {
        Intrinsics.checkNotNullParameter(d5Var, "<this>");
        Intrinsics.checkNotNullParameter(javascript, "javascript");
        try {
            u3 u3Var = u3.f7411a;
            String str = z0.a((WebView) d5Var) + " >> " + javascript;
            u3Var.getClass();
            d5Var.loadUrl("javascript:" + javascript);
        } catch (Throwable th) {
            IntegrationLogger.e(th);
        }
    }

    public static final d5 a(Context context, c ad) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ad, "ad");
        try {
            d5 d5Var = new d5(context, ad);
            d5Var.setBackgroundColor(0);
            d5Var.setLayerType(2, null);
            return d5Var;
        } catch (Throwable th) {
            IntegrationLogger.e(th);
            return null;
        }
    }
}
