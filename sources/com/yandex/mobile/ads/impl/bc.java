package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bc extends uf1 {
    private final cc k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bc(Context context) {
        this(context, new wt0());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.yg0
    public final void a(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        this.k.a(url);
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.yandex.mobile.ads.impl.uf1
    protected final void h() {
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public final void setAdtuneWebViewListener(ec adtuneWebViewListener) {
        Intrinsics.checkNotNullParameter(adtuneWebViewListener, "adtuneWebViewListener");
        this.k.a(adtuneWebViewListener);
    }

    public /* synthetic */ bc(Context context, wt0 wt0Var) {
        ub ubVar = new ub(context);
        this(context, wt0Var, ubVar, new cc(ubVar));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(Context context, wt0 manufacturerChecker, ub optOutRenderer, cc adtuneWebViewController) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(manufacturerChecker, "manufacturerChecker");
        Intrinsics.checkNotNullParameter(optOutRenderer, "optOutRenderer");
        Intrinsics.checkNotNullParameter(adtuneWebViewController, "adtuneWebViewController");
        this.k = adtuneWebViewController;
        if (manufacturerChecker.a()) {
            setLayerType(2, null);
        }
        setVisibility(0);
        setHtmlWebViewErrorListener(adtuneWebViewController);
    }

    public final void setOptOutUrl(String str) {
        this.k.b(str);
    }
}
