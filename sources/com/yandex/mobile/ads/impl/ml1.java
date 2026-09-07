package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ml1 implements pp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f9650a;
    private final ProgressBar b;
    private final mp c;
    private final wp d;
    private final aw e;
    private final tl1 f;
    private final long g;
    private final ig1 h;
    private final kg1 i;
    private final f52 j;

    public ml1(View closeButton, ProgressBar closeProgressView, e50 closeAppearanceController, wp closeProgressAppearanceController, aw debugEventsReporter, tl1 progressIncrementer, long j) {
        Intrinsics.checkNotNullParameter(closeButton, "closeButton");
        Intrinsics.checkNotNullParameter(closeProgressView, "closeProgressView");
        Intrinsics.checkNotNullParameter(closeAppearanceController, "closeAppearanceController");
        Intrinsics.checkNotNullParameter(closeProgressAppearanceController, "closeProgressAppearanceController");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        Intrinsics.checkNotNullParameter(progressIncrementer, "progressIncrementer");
        this.f9650a = closeButton;
        this.b = closeProgressView;
        this.c = closeAppearanceController;
        this.d = closeProgressAppearanceController;
        this.e = debugEventsReporter;
        this.f = progressIncrementer;
        this.g = j;
        int i = ig1.f9217a;
        this.h = ig1.a.a(true);
        this.i = new b(d(), closeAppearanceController, debugEventsReporter);
        this.j = new a(closeProgressView, closeProgressAppearanceController, j);
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void a(boolean z) {
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final View d() {
        return this.f9650a;
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void c() {
        wp wpVar = this.d;
        ProgressBar progressBar = this.b;
        int i = (int) this.g;
        int iA = (int) this.f.a();
        wpVar.getClass();
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        progressBar.setMax(i);
        progressBar.setVisibility(0);
        progressBar.setProgress(iA);
        long jMax = Math.max(0L, this.g - this.f.a());
        if (jMax != 0) {
            this.c.a(this.f9650a);
            this.h.a(this.j);
            this.h.a(jMax, this.i);
            this.e.a(zv.d);
        }
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void b() {
        this.h.pause();
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void a() {
        this.h.resume();
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void invalidate() {
        this.h.invalidate();
    }

    private static final class b implements kg1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final mp f9652a;
        private final aw b;
        private final WeakReference<View> c;

        public b(View closeView, e50 closeAppearanceController, aw debugEventsReporter) {
            Intrinsics.checkNotNullParameter(closeView, "closeView");
            Intrinsics.checkNotNullParameter(closeAppearanceController, "closeAppearanceController");
            Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
            this.f9652a = closeAppearanceController;
            this.b = debugEventsReporter;
            this.c = new WeakReference<>(closeView);
        }

        @Override // com.yandex.mobile.ads.impl.kg1
        public final void a() {
            View view = this.c.get();
            if (view != null) {
                this.f9652a.b(view);
                this.b.a(zv.e);
            }
        }
    }

    private static final class a implements f52 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final wp f9651a;
        private final long b;
        private final WeakReference<ProgressBar> c;

        public a(ProgressBar progressView, wp closeProgressAppearanceController, long j) {
            Intrinsics.checkNotNullParameter(progressView, "progressView");
            Intrinsics.checkNotNullParameter(closeProgressAppearanceController, "closeProgressAppearanceController");
            this.f9651a = closeProgressAppearanceController;
            this.b = j;
            this.c = new WeakReference<>(progressView);
        }

        @Override // com.yandex.mobile.ads.impl.f52
        public final void a(long j, long j2) {
            ProgressBar progressBar = this.c.get();
            if (progressBar != null) {
                wp wpVar = this.f9651a;
                long j3 = this.b;
                wpVar.a(progressBar, j3, j3 - j);
            }
        }
    }
}
