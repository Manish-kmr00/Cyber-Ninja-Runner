package com.five_corp.ad.internal.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes10.dex */
public abstract class G extends FrameLayout {
    public static final /* synthetic */ int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1566a;
    public final com.five_corp.ad.internal.context.l b;
    public final C3050h c;
    public final com.five_corp.ad.f d;
    public final com.five_corp.ad.internal.logger.a e;
    public final com.five_corp.ad.internal.k f;
    public int g;
    public int h;

    static {
        G.class.toString();
    }

    public G(Context context, com.five_corp.ad.internal.context.l lVar, com.five_corp.ad.internal.k kVar, com.five_corp.ad.f fVar, com.five_corp.ad.internal.logger.a aVar) {
        super(context);
        this.f1566a = context;
        this.b = lVar;
        this.d = fVar;
        new Handler(Looper.getMainLooper());
        this.f = kVar;
        this.e = aVar;
        C3050h c3050h = new C3050h(context, new FrameLayout.LayoutParams(0, 0));
        this.c = c3050h;
        addView(c3050h, new FrameLayout.LayoutParams(-1, -1));
    }

    public abstract void a(com.five_corp.ad.internal.viewability.b bVar);

    public abstract void a(boolean z);

    public abstract boolean c();

    public abstract void d();

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract int getCurrentPositionMs();

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.five_corp.ad.internal.k kVar = this.f;
        if (kVar.b) {
            return;
        }
        kVar.b = true;
        if (kVar.c) {
            kVar.f1412a.m();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.five_corp.ad.internal.k kVar = this.f;
        boolean z = kVar.b;
        boolean z2 = z && kVar.c;
        if (z) {
            kVar.b = false;
            if (z2) {
                kVar.f1412a.n();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        try {
            if (this.g != i2 || this.h != i3) {
                this.g = i2;
                this.h = i3;
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i3);
                C3050h c3050h = this.c;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size, size2);
                c3050h.f1571a = layoutParams;
                for (int i4 = 0; i4 < c3050h.getChildCount(); i4++) {
                    c3050h.getChildAt(i4).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            this.e.a(th);
        }
        super.onMeasure(i2, i3);
    }
}
