package com.ogury.ad.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.Locale;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class m5 implements b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i5 f7355a;
    public final k5 b;
    public Function0<Unit> c;
    public Function0<Unit> d;
    public final t2 e;
    public final String[] f;

    public m5(i5 browser, k5 multiWebViewCommandExecutor) {
        Intrinsics.checkNotNullParameter(browser, "browser");
        Intrinsics.checkNotNullParameter(multiWebViewCommandExecutor, "multiWebViewCommandExecutor");
        this.f7355a = browser;
        this.b = multiWebViewCommandExecutor;
        this.e = new t2();
        this.f = new String[]{"ogyCreateWebView", "ogyUpdateWebView", "ogyCloseWebView", "ogyNavigateBack", "ogyNavigateForward"};
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.ogury.ad.internal.b5
    public final boolean a(String url, d5 webView, c ad) {
        d5 d5Var;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(url, "<this>");
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = url.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        m5 m5Var = null;
        if (!StringsKt.startsWith$default(lowerCase, "http://ogymraid", false, 2, (Object) null) && !StringsKt.startsWith$default(lowerCase, "https://ogymraid", false, 2, (Object) null)) {
            return false;
        }
        JSONObject jSONObject = new JSONObject(m9.a(x8.a(url)));
        String strOptString = jSONObject.optString("method", "");
        String strOptString2 = jSONObject.optString("callbackId", "");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("args");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        Intrinsics.checkNotNull(strOptString);
        Intrinsics.checkNotNull(strOptString2);
        switch (strOptString.hashCode()) {
            case -1797727422:
                if (strOptString.equals("ogyCloseWebView")) {
                    String webViewName = jSONObjectOptJSONObject.optString("webViewId", "");
                    i5 i5Var = this.f7355a;
                    Intrinsics.checkNotNull(webViewName);
                    i5Var.getClass();
                    Intrinsics.checkNotNullParameter(webViewName, "webViewName");
                    d5 webView2 = i5Var.b.get(webViewName);
                    if (webView2 != null) {
                        i5Var.a(webViewName, o7.SI_011_SDK_EVENT_AD_CLOSE_LANDING_PAGE);
                        y0 y0Var = i5Var.d;
                        y0Var.getClass();
                        Intrinsics.checkNotNullParameter(webView2, "webView");
                        y0Var.b.removeView(webView2);
                        i5Var.a(webViewName, o7.SI_012_SDK_EVENT_AD_LANDING_PAGE_CLOSED);
                    }
                    i5Var.b.remove(webViewName);
                    i5Var.c.remove(webViewName);
                    this.b.getClass();
                    k5.a(webView, strOptString2, webViewName);
                }
                break;
            case -1244773540:
                if (strOptString.equals("ogyCreateWebView")) {
                    t2 t2Var = this.e;
                    Context context = webView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    if (!t2Var.a(context)) {
                        Function0<Unit> function0 = this.d;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    } else {
                        q9 webViewArgs = r9.a(jSONObjectOptJSONObject);
                        i5 i5Var2 = this.f7355a;
                        i5Var2.getClass();
                        Intrinsics.checkNotNullParameter(webViewArgs, "webViewArgs");
                        i5Var2.a(webViewArgs.c, o7.SI_009_SDK_EVENT_AD_OPEN_LANDING_PAGE);
                        y0 y0Var2 = i5Var2.d;
                        y0Var2.getClass();
                        Intrinsics.checkNotNullParameter(webViewArgs, "webViewArgs");
                        FrameLayout.LayoutParams layoutParamsA = y0.a(webViewArgs, null);
                        d5 d5VarA = h5.a(y0Var2.f7445a, y0Var2.c);
                        if (d5VarA == null) {
                            d5Var = null;
                        } else {
                            d5VarA.setTag(webViewArgs.c);
                            z0.a(d5VarA);
                            y0Var2.b.addView(d5VarA, layoutParamsA);
                            d5Var = d5VarA;
                        }
                        if (d5Var != null) {
                            i5Var2.b.put(webViewArgs.c, d5Var);
                            i5Var2.c.put(webViewArgs.c, new aa(webViewArgs.h, webViewArgs.i, webViewArgs.f7391a, false, 56));
                            m5 m5Var2 = i5Var2.j;
                            if (m5Var2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("multiWebViewUrlHandler");
                            } else {
                                m5Var = m5Var2;
                            }
                            d5Var.setMraidUrlHandler(new j1(new b5[]{m5Var, i5Var2.h.a(d5Var)}));
                            d5Var.setClientAdapter(new j5(i5Var2, d5Var));
                            Intrinsics.checkNotNullParameter(d5Var, "<this>");
                            d5Var.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                            d5Var.getSettings().setSupportMultipleWindows(true);
                            d5Var.setWebChromeClient(new ba());
                            if (webViewArgs.j) {
                                ca.a(d5Var);
                                d5Var.getSettings().setCacheMode(1);
                            }
                            if (webViewArgs.f7391a.length() > 0) {
                                d5Var.loadUrl(webViewArgs.f7391a);
                            } else {
                                d5Var.loadDataWithBaseURL(i5Var2.f7321a.i, webViewArgs.b, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
                            }
                            i5Var2.a(webViewArgs.c, o7.SI_010_SDK_EVENT_AD_LANDING_PAGE_OPENED);
                        }
                        k5 k5Var = this.b;
                        String str = webViewArgs.c;
                        k5Var.getClass();
                        k5.a(webView, strOptString2, str);
                        Function0<Unit> function1 = this.c;
                        if (function1 != null) {
                            function1.invoke();
                        }
                    }
                }
                break;
            case -692274449:
                if (strOptString.equals("ogyUpdateWebView")) {
                    q9 webViewArgs2 = r9.a(jSONObjectOptJSONObject);
                    i5 i5Var3 = this.f7355a;
                    i5Var3.getClass();
                    Intrinsics.checkNotNullParameter(webViewArgs2, "webViewArgs");
                    d5 webView3 = i5Var3.b.get(webViewArgs2.c);
                    if (webView3 != null) {
                        i5Var3.d.getClass();
                        Intrinsics.checkNotNullParameter(webView3, "webView");
                        Intrinsics.checkNotNullParameter(webViewArgs2, "webViewArgs");
                        ViewGroup.LayoutParams layoutParams = webView3.getLayoutParams();
                        webView3.setLayoutParams(y0.a(webViewArgs2, layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null));
                        if (webViewArgs2.f7391a.length() > 0 || webViewArgs2.b.length() > 0) {
                            if (webViewArgs2.f7391a.length() > 0) {
                                webView3.loadUrl(webViewArgs2.f7391a);
                            } else {
                                webView3.loadDataWithBaseURL(i5Var3.f7321a.i, webViewArgs2.b, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
                            }
                        }
                    }
                    k5 k5Var2 = this.b;
                    String str2 = webViewArgs2.c;
                    k5Var2.getClass();
                    k5.a(webView, strOptString2, str2);
                }
                break;
            case 960350259:
                if (strOptString.equals("ogyNavigateForward")) {
                    String webViewName2 = jSONObjectOptJSONObject.optString("webViewId", "");
                    i5 i5Var4 = this.f7355a;
                    Intrinsics.checkNotNull(webViewName2);
                    i5Var4.getClass();
                    Intrinsics.checkNotNullParameter(webViewName2, "webViewName");
                    d5 d5Var2 = i5Var4.b.get(webViewName2);
                    if (d5Var2 != null && d5Var2.canGoForward()) {
                        d5Var2.goForward();
                    }
                }
                break;
            case 1635219001:
                if (strOptString.equals("ogyNavigateBack")) {
                    String webViewName3 = jSONObjectOptJSONObject.optString("webViewId", "");
                    i5 i5Var5 = this.f7355a;
                    Intrinsics.checkNotNull(webViewName3);
                    i5Var5.getClass();
                    Intrinsics.checkNotNullParameter(webViewName3, "webViewName");
                    d5 d5Var3 = i5Var5.b.get(webViewName3);
                    if (d5Var3 != null && d5Var3.canGoBack()) {
                        d5Var3.goBack();
                    }
                }
                break;
        }
        return ArraysKt.contains(this.f, strOptString);
    }
}
