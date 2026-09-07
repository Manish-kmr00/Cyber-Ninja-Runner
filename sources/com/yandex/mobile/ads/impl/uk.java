package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class uk extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f10397a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected uk(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10397a = new LinkedHashMap();
        g();
    }

    @Override // android.webkit.WebView
    public final void addJavascriptInterface(Object any, String jsName) {
        Intrinsics.checkNotNullParameter(any, "any");
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        super.addJavascriptInterface(any, jsName);
        this.f10397a.put(jsName, any);
    }

    public final void b(String sourcePageData) {
        Intrinsics.checkNotNullParameter(sourcePageData, "sourcePageData");
        loadDataWithBaseURL("https://yandex.ru", a(sourcePageData), POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
    }

    public String c() {
        return "";
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final void e() {
        int i = oa.b;
        try {
            WebView.class.getDeclaredMethod(com.ironsource.b9.h.t0, new Class[0]).invoke(this, new Object[0]);
        } catch (Exception unused) {
        }
        op0.d(getClass().toString());
    }

    public final void f() {
        int i = oa.b;
        try {
            WebView.class.getDeclaredMethod(com.ironsource.b9.h.u0, new Class[0]).invoke(this, new Object[0]);
        } catch (Exception unused) {
        }
        op0.d(getClass().toString());
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.webkit.WebView
    public final void removeJavascriptInterface(String jsName) {
        Intrinsics.checkNotNullParameter(jsName, "jsName");
        if (pa.a(11)) {
            super.removeJavascriptInterface(jsName);
        }
    }

    private final void g() {
        WebSettings settings = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setAllowFileAccess(false);
        if (pa.a(11)) {
            settings.setAllowContentAccess(false);
            if (pa.a(16)) {
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
        }
    }

    public final void setDisplayZoomControls(boolean z) {
        if (pa.a(11)) {
            getSettings().setDisplayZoomControls(z);
        }
    }

    public void d() {
        oh2.a((ViewGroup) this);
        Iterator it = this.f10397a.keySet().iterator();
        while (it.hasNext()) {
            removeJavascriptInterface((String) it.next());
        }
        this.f10397a.clear();
        destroy();
        op0.f(getClass().toString());
    }

    private final String a(String str) {
        return str + c() + "<body style='margin:0; padding:0;'>";
    }
}
