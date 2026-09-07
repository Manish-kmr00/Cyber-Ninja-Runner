package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class tg0 extends uf1 implements bh0 {
    private final o8<?> k;
    private final cg1 l;
    private ah0 m;
    private final LinkedHashMap n;

    protected abstract void a(Context context, o3 o3Var);

    public final a b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new a(context, this.l);
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        String str = "Configuration is changed for web view, new config: " + newConfig;
        op0.d(new Object[0]);
        Intrinsics.checkNotNullParameter("AdPerformActionsJSI", "jsName");
        Object obj = this.f10397a.get("AdPerformActionsJSI");
        if (obj != null && (obj instanceof a)) {
            op0.d(new Object[0]);
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public /* synthetic */ tg0(Context context, o8 o8Var, o3 o3Var) {
        this(context, o8Var, o3Var, new dg1());
    }

    public final LinkedHashMap l() {
        return this.n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected tg0(Context context, o8<?> adResponse, o3 adConfiguration, dg1 partnerCodeAdRendererFactory) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(partnerCodeAdRendererFactory, "partnerCodeAdRendererFactory");
        this.k = adResponse;
        partnerCodeAdRendererFactory.getClass();
        this.l = dg1.a(this);
        this.n = new LinkedHashMap();
        a(context, adConfiguration);
    }

    public final o8<?> k() {
        return this.k;
    }

    protected final boolean m() {
        return Intrinsics.areEqual("partner-code", this.k.k());
    }

    @Override // com.yandex.mobile.ads.impl.uf1
    public final ah0 j() {
        return this.m;
    }

    @Override // com.yandex.mobile.ads.impl.uf1
    public void setHtmlWebViewListener(ah0 ah0Var) {
        this.l.a(ah0Var);
        this.m = ah0Var;
    }

    @Override // com.yandex.mobile.ads.impl.bh0
    public final void a(int i, String str) {
        String str2 = "onHtmlWebViewRender, height = " + i + ", testTag = " + str;
        op0.d(new Object[0]);
        b(i, str);
        super.a();
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.yg0
    public final void a() {
        if (Intrinsics.areEqual("partner-code", this.k.k())) {
            this.l.b();
        } else {
            super.a();
        }
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk
    public String c() {
        String strC = super.c();
        String strB = jj2.b();
        if (!Intrinsics.areEqual("partner-code", this.k.k())) {
            strB = null;
        }
        if (strB == null) {
            strB = "";
        }
        return strC + strB;
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk
    public final void d() {
        this.l.a();
        super.d();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final cg1 f10297a;

        public a(Context context, cg1 partnerCodeAdRenderer) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(partnerCodeAdRenderer, "partnerCodeAdRenderer");
            this.f10297a = partnerCodeAdRenderer;
            new WeakReference(context);
        }

        @JavascriptInterface
        public final String getBannerInfo() {
            return "{\"isDelicate\": false}";
        }

        @JavascriptInterface
        public final void onAdRender(int i, String str) {
            this.f10297a.a(i, str);
        }
    }

    public void b(int i, String str) {
        if (str == null || str.length() == 0 || Intrinsics.areEqual(str, "undefined")) {
            return;
        }
        this.n.put("test-tag", str);
    }
}
