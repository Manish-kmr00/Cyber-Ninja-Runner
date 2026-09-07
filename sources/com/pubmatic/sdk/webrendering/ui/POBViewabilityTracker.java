package com.pubmatic.sdk.webrendering.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import com.pubmatic.sdk.common.utility.POBUtils;

/* JADX INFO: loaded from: classes3.dex */
public class POBViewabilityTracker implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnWindowFocusChangeListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f7940a;
    private OnViewabilityChangedListener b;
    private float c;
    private int d;
    private boolean e;
    private boolean f;

    public interface OnViewabilityChangedListener {
        void onViewabilityChanged(boolean z);
    }

    public POBViewabilityTracker(View view) {
        this.f7940a = view;
        this.f = false;
        this.e = false;
        view.addOnAttachStateChangeListener(this);
    }

    private void a() {
        if (this.f7940a.getViewTreeObserver().isAlive()) {
            this.f7940a.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        }
    }

    private void b() {
        if (this.f7940a.getViewTreeObserver().isAlive()) {
            this.f7940a.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.f7940a.getViewTreeObserver().addOnScrollChangedListener(this);
        }
    }

    private void c() {
        if (this.f7940a.getViewTreeObserver().isAlive()) {
            this.f7940a.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
        }
    }

    private void d() {
        if (this.f7940a.getViewTreeObserver().isAlive()) {
            this.f7940a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.f7940a.getViewTreeObserver().removeOnScrollChangedListener(this);
        }
    }

    private void e() {
        boolean z;
        int i = this.d;
        if (i != 0) {
            z = POBUtils.isViewVisible(this.f7940a, i) && this.f7940a.hasWindowFocus();
            OnViewabilityChangedListener onViewabilityChangedListener = this.b;
            if (onViewabilityChangedListener != null) {
                onViewabilityChangedListener.onViewabilityChanged(z);
            }
            this.f = z;
            return;
        }
        z = POBUtils.getVisiblePercent(this.f7940a) >= this.c && this.f7940a.hasWindowFocus();
        if (this.f != z) {
            OnViewabilityChangedListener onViewabilityChangedListener2 = this.b;
            if (onViewabilityChangedListener2 != null) {
                onViewabilityChangedListener2.onViewabilityChanged(z);
            }
            this.f = z;
        }
    }

    public void destroy() {
        d();
        c();
        this.f7940a.removeOnAttachStateChangeListener(this);
    }

    public boolean isViewable() {
        return this.f;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        e();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        a();
        if (this.e) {
            b();
        }
        e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        d();
        c();
        e();
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        e();
    }

    public void setAllowViewTreeObserverRegistration(boolean z) {
        this.e = z;
    }

    public void setOnExposureChangeWithThresholdListener(OnViewabilityChangedListener onViewabilityChangedListener) {
        this.b = onViewabilityChangedListener;
    }

    public POBViewabilityTracker(View view, float f) {
        this(view);
        this.c = f;
    }

    public POBViewabilityTracker(View view, int i) {
        this(view);
        this.d = i;
    }
}
