package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
public final class j71 implements View.OnAttachStateChangeListener {
    static final /* synthetic */ KProperty<Object>[] e = {ta.a(j71.class, "viewReference", "getViewReference()Landroid/view/View;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o62.a f9292a;
    private final f71 b;
    private e71 c;
    private final zn1 d;

    public j71(View view, w81 trackingListener, f71 globalLayoutListenerFactory) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
        Intrinsics.checkNotNullParameter(globalLayoutListenerFactory, "globalLayoutListenerFactory");
        this.f9292a = trackingListener;
        this.b = globalLayoutListenerFactory;
        this.d = ao1.a(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.f9292a.a();
        View nativeAdView = (View) this.d.getValue(this, e[0]);
        if (nativeAdView != null && nativeAdView.isAttachedToWindow()) {
            f71 f71Var = this.b;
            o62.a trackingListener = this.f9292a;
            f71Var.getClass();
            Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
            Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
            e71 e71Var = new e71(nativeAdView, trackingListener);
            this.c = e71Var;
            e71Var.a();
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        e71 e71Var = this.c;
        if (e71Var != null) {
            e71Var.b();
        }
        this.c = null;
        this.f9292a.b();
    }

    public final void a() {
        zn1 zn1Var = this.d;
        KProperty<?>[] kPropertyArr = e;
        View view = (View) zn1Var.getValue(this, kPropertyArr[0]);
        if (view != null) {
            view.addOnAttachStateChangeListener(this);
        }
        View nativeAdView = (View) this.d.getValue(this, kPropertyArr[0]);
        if (nativeAdView != null && nativeAdView.isAttachedToWindow()) {
            f71 f71Var = this.b;
            o62.a trackingListener = this.f9292a;
            f71Var.getClass();
            Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
            Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
            e71 e71Var = new e71(nativeAdView, trackingListener);
            this.c = e71Var;
            e71Var.a();
        }
    }

    public final void b() {
        e71 e71Var = this.c;
        if (e71Var != null) {
            e71Var.b();
        }
        this.c = null;
        View view = (View) this.d.getValue(this, e[0]);
        if (view != null) {
            view.removeOnAttachStateChangeListener(this);
        }
    }
}
