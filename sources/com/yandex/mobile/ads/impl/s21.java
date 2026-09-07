package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s21 extends uf1 {
    private final j21 k;
    private a l;
    private final w21 m;
    private ou0 n;
    private boolean o;

    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s21(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        j21 j21Var = new j21();
        this.k = j21Var;
        this.m = new w21(this, j21Var);
        this.n = new ky1();
    }

    public final void c(String htmlResponse) {
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        if (this.o) {
            return;
        }
        this.m.b(htmlResponse);
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.y, this, me);
        return super.dispatchTouchEvent(me);
    }

    public final void setClickListener(xo clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.m.a(clickListener);
    }

    public final j21 k() {
        return this.k;
    }

    public final void setPreloadListener(a aVar) {
        this.l = aVar;
    }

    public final void setAspectRatio(float f) {
        this.n = new hm1(f);
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.yg0
    public final void a() {
        super.a();
        a aVar = this.l;
        if (aVar != null) {
            this.o = true;
            aVar.b();
            this.l = null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.uf1
    public final void h() {
        this.m.a();
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.uk, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        ou0.a aVarA = this.n.a(i, i2);
        super.onMeasure(aVarA.f9859a, aVarA.b);
    }

    @Override // com.yandex.mobile.ads.impl.uf1, com.yandex.mobile.ads.impl.yg0
    public final void a(int i) {
        super.a(i);
        if (this.l != null) {
            stopLoading();
            a aVar = this.l;
            if (aVar != null) {
                aVar.a();
            }
            this.l = null;
        }
    }
}
