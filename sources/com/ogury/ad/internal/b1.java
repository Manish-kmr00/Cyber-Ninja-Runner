package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7265a = "";
    public int b = -1;

    public final void a(d5 webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        if (this.f7265a.length() == 0) {
            String userAgentString = webView.getSettings().getUserAgentString();
            this.f7265a = userAgentString;
            int iIndexOf = StringsKt.indexOf((CharSequence) userAgentString, "chrome/", 0, true);
            if (iIndexOf == -1) {
                return;
            }
            try {
                String strSubstring = this.f7265a.substring(iIndexOf + 7, iIndexOf + 9);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                this.b = Integer.parseInt(strSubstring);
            } catch (Throwable th) {
                Intrinsics.checkNotNullParameter(th, "<this>");
                u3.f7411a.getClass();
            }
        }
    }
}
