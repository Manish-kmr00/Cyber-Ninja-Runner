package com.yandex.mobile.ads.impl;

import android.view.ViewTreeObserver;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wt1 implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wi f10592a;
    private final et0 b;
    private final a c;

    public wt1(jp0 adView, wi contentController, et0 mainThreadHandler, a removePreviousBannerRunnable) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(contentController, "contentController");
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        Intrinsics.checkNotNullParameter(removePreviousBannerRunnable, "removePreviousBannerRunnable");
        this.f10592a = contentController;
        this.b = mainThreadHandler;
        this.c = removePreviousBannerRunnable;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        String str = "onPreDraw(), clazz = " + this;
        op0.d(new Object[0]);
        this.f10592a.m();
        this.b.a(this.c);
        return true;
    }

    public static final class a implements Runnable {
        private final jp0 b;

        public a(jp0 adView) {
            Intrinsics.checkNotNullParameter(adView, "adView");
            this.b = adView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rg2.a(this.b, false);
        }
    }
}
