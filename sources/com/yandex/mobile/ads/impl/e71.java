package com.yandex.mobile.ads.impl;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class e71 implements ViewTreeObserver.OnGlobalLayoutListener {
    static final /* synthetic */ KProperty<Object>[] d = {ta.a(e71.class, "viewReference", "getViewReference()Landroid/view/View;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o62.a f8770a;
    private final zn1 b;
    private Integer c;

    public e71(View view, o62.a trackingListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
        this.f8770a = trackingListener;
        this.b = ao1.a(view);
    }

    public final void a() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.b.getValue(this, d[0]);
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    public final void b() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.b.getValue(this, d[0]);
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        View view = (View) this.b.getValue(this, d[0]);
        if (view != null) {
            int visibility = view.getVisibility();
            Integer num = this.c;
            if (num != null && visibility == num.intValue()) {
                return;
            }
            this.c = Integer.valueOf(visibility);
            if (visibility == 0) {
                this.f8770a.a();
            } else {
                this.f8770a.b();
            }
        }
    }
}
