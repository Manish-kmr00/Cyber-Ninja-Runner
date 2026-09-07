package com.ogury.ad.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class q0 implements c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f7385a;
    public final z9 b;
    public d2 c;
    public final o9 d;
    public final ViewTreeObserver.OnScrollChangedListener e;
    public final View f;

    public static final class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ViewTreeObserver viewTreeObserver = q0.this.f7385a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(q0.this.e);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            q0.this.f7385a.getViewTreeObserver().removeOnScrollChangedListener(q0.this.e);
        }
    }

    public q0(ViewGroup adContainer, z9 rectHelper) {
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(rectHelper, "rectHelper");
        this.f7385a = adContainer;
        this.b = rectHelper;
        this.d = new o9(adContainer);
        this.e = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.ogury.ad.internal.q0$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                q0.a(this.f$0);
            }
        };
        adContainer.addOnAttachStateChangeListener(new a());
        this.f = adContainer.getRootView();
    }

    @Override // com.ogury.ad.internal.c2
    public final void a() {
        this.c = null;
    }

    @Override // com.ogury.ad.internal.c2
    public final void b() {
        int childCount = this.f7385a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f7385a.getChildAt(i);
            if (childAt instanceof d5) {
                d5 d5Var = (d5) childAt;
                if (d5Var.getContainsMraid()) {
                    e adExposure = new e();
                    z9 z9Var = this.b;
                    ViewGroup viewGroup = this.f7385a;
                    z9Var.getClass();
                    Rect rectB = z9.b(viewGroup);
                    int measuredHeight = this.f7385a.getMeasuredHeight() * this.f7385a.getMeasuredWidth();
                    if (measuredHeight != 0) {
                        Rect rect = new Rect();
                        this.f.getHitRect(rect);
                        adExposure.c = 100.0f - (((measuredHeight - ((!this.f7385a.getLocalVisibleRect(rect) || this.f7385a.getWindowToken() == null) ? 0 : rectB.height() * rectB.width())) * 100.0f) / measuredHeight);
                    }
                    if (adExposure.c == 0.0f) {
                        adExposure.f7286a = null;
                    } else {
                        adExposure.f7286a = rectB;
                    }
                    if (d5Var.k && !d5Var.l) {
                        o9 o9Var = this.d;
                        o9Var.getClass();
                        Intrinsics.checkNotNullParameter(adExposure, "adExposure");
                        ViewParent parent = o9Var.f7378a.getParent();
                        ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                        if (viewGroup2 != null && viewGroup2.getVisibility() != 0) {
                            adExposure.c = 0.0f;
                        }
                        d5Var.getMraidCommandExecutor().a(adExposure);
                        d2 d2Var = this.c;
                        if (d2Var != null) {
                            d2Var.a(adExposure.c);
                        }
                    }
                }
            }
        }
    }

    @Override // com.ogury.ad.internal.c2
    public final void a(d2 d2Var) {
        this.c = d2Var;
    }

    public static final void a(q0 q0Var) {
        q0Var.b();
    }
}
