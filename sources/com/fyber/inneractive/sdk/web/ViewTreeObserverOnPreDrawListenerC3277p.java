package com.fyber.inneractive.sdk.web;

import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class ViewTreeObserverOnPreDrawListenerC3277p implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f2417a;

    public ViewTreeObserverOnPreDrawListenerC3277p(I i) {
        this.f2417a = i;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        C3274m c3274m = this.f2417a.b;
        if (c3274m == null) {
            return false;
        }
        c3274m.getViewTreeObserver().removeOnPreDrawListener(this);
        I i = this.f2417a;
        i.a(i.b.getContext(), true);
        return false;
    }
}
