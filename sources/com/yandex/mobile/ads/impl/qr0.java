package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
public final class qr0 implements ul1 {
    static final /* synthetic */ KProperty<Object>[] d = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(qr0.class, "progressBar", "getProgressBar()Landroid/widget/ProgressBar;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pr0 f10045a;
    private final yd b;
    private final zn1 c;

    public qr0() {
        this(0);
    }

    @Override // com.yandex.mobile.ads.impl.ul1
    public final void a(long j, long j2) {
        ProgressBar progressBar = (ProgressBar) this.c.getValue(this, d[0]);
        if (progressBar != null) {
            this.b.getClass();
            yd.a(progressBar, j, j2);
        }
    }

    public final void b() {
        this.c.setValue(this, d[0], null);
    }

    public /* synthetic */ qr0(int i) {
        this(new pr0(), new yd());
    }

    @Override // com.yandex.mobile.ads.impl.ul1
    public final void a() {
        ProgressBar progressBar = (ProgressBar) this.c.getValue(this, d[0]);
        if (progressBar != null) {
            long max = progressBar.getMax();
            this.b.getClass();
            yd.a(progressBar, max, max);
        }
    }

    public qr0(pr0 progressBarProvider, yd animatedProgressBarController) {
        Intrinsics.checkNotNullParameter(progressBarProvider, "progressBarProvider");
        Intrinsics.checkNotNullParameter(animatedProgressBarController, "animatedProgressBarController");
        this.f10045a = progressBarProvider;
        this.b = animatedProgressBarController;
        this.c = ao1.a(null);
    }

    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f10045a.getClass();
        Intrinsics.checkNotNullParameter(view, "view");
        View viewFindViewWithTag = view.findViewWithTag("linear_progress_view");
        this.c.setValue(this, d[0], viewFindViewWithTag instanceof ProgressBar ? (ProgressBar) viewFindViewWithTag : null);
    }
}
