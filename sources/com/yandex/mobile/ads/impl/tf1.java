package com.yandex.mobile.ads.impl;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class tf1 extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g31 f10296a;
    private final c31 b;
    private boolean c;

    public tf1(g31 multiBannerEventTracker, c31 c31Var) {
        Intrinsics.checkNotNullParameter(multiBannerEventTracker, "multiBannerEventTracker");
        this.f10296a = multiBannerEventTracker;
        this.b = c31Var;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrollStateChanged(int i) {
        if (i == 0) {
            this.c = false;
        } else {
            if (i != 1) {
                return;
            }
            c31 c31Var = this.b;
            if (c31Var != null) {
                c31Var.a();
            }
            this.c = true;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageSelected(int i) {
        if (this.c) {
            this.f10296a.c();
            this.c = false;
        }
    }
}
