package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class pj extends tg0 {
    private final zy1 o;
    private ob0 p;
    private boolean q;
    private int r;
    private int s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pj(Context context, o8<?> adResponse, o3 adConfiguration, zy1 configurationSizeInfo) {
        super(context, adResponse, adConfiguration);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(configurationSizeInfo, "configurationSizeInfo");
        this.o = configurationSizeInfo;
        this.q = true;
        if (n()) {
            this.r = configurationSizeInfo.c(context);
            this.s = configurationSizeInfo.a(context);
        } else {
            this.r = adResponse.r() == 0 ? configurationSizeInfo.c(context) : adResponse.r();
            this.s = adResponse.c();
        }
        this.p = a(this.r, this.s);
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

    @Override // com.yandex.mobile.ads.impl.tg0
    public final void b(int i, String str) {
        if (k().c() != 0) {
            i = k().c();
        }
        this.s = i;
        super.b(i, str);
    }

    @Override // com.yandex.mobile.ads.impl.tg0, com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk
    public final String c() {
        String strA;
        if (k().U()) {
            int i = jj2.c;
            strA = jj2.a(this.r);
        } else {
            strA = "";
        }
        zy1 zy1Var = this.o;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int iC = zy1Var.c(context);
        zy1 zy1Var2 = this.o;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        return strA + (n() ? jj2.a(iC, zy1Var2.a(context2)) : "") + super.c();
    }

    public final zy1 o() {
        return this.p;
    }

    public final void setBannerWidth(int i) {
        this.r = i;
    }

    public final void setBannerHeight(int i) {
        this.s = i;
    }

    public final boolean n() {
        if (m() && k().r() == 0 && k().c() == 0) {
            zy1 zy1Var = this.o;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (zy1Var.c(context) > 0) {
                zy1 zy1Var2 = this.o;
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                if (zy1Var2.a(context2) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.uf1
    protected final void h() {
        if (this.q) {
            this.p = new ob0(this.r, this.s, this.o.a());
            ah0 ah0VarJ = j();
            if (ah0VarJ != null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                if (!qa.a(context, this.p, this.o) && !k().N()) {
                    Context context2 = getContext();
                    zy1 zy1Var = this.o;
                    Intrinsics.checkNotNull(context2);
                    w3 w3VarA = w7.a(zy1Var.c(context2), this.o.a(context2), this.p.getWidth(), this.p.getHeight(), oh2.c(context2), oh2.b(context2));
                    dp0.a(w3VarA.d(), new Object[0]);
                    ah0VarJ.a(w3VarA);
                } else {
                    ah0VarJ.a(this, l());
                }
            }
            this.q = false;
        }
    }

    private final ob0 a(int i, int i2) {
        return new ob0(i, i2, this.o.a());
    }
}
