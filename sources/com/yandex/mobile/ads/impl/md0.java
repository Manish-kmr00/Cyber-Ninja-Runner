package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class md0 extends tg0 {
    private final nj2 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public md0(Context context, o8<?> adResponse, o3 adConfiguration) {
        super(context, adResponse, adConfiguration);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        this.o = new nj2(this);
    }

    @Override // com.yandex.mobile.ads.impl.tg0
    protected final void a(Context context, o3 adConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        addJavascriptInterface(b(context), "AdPerformActionsJSI");
    }

    @Override // com.yandex.mobile.ads.impl.tg0, com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.yandex.mobile.ads.impl.tg0, com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.yandex.mobile.ads.impl.uf1
    protected final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.a(context);
        WebSettings settings = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        settings.setDatabasePath(getContext().getDatabasePath("com.monetization.ads.db").getAbsolutePath());
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(-1);
    }

    @Override // com.yandex.mobile.ads.impl.uf1
    public final void h() {
        this.o.a(l());
    }
}
