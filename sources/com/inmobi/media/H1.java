package com.inmobi.media;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class H1 extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f3087a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H1(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3087a = LazyKt.lazy(new G1(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.i, this, me);
        return super.dispatchTouchEvent(me);
    }

    public abstract U5 g();

    public final U5 getLandingPageHandler() {
        return (U5) this.f3087a.getValue();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
