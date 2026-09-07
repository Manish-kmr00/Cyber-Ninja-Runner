package com.yandex.mobile.ads.impl;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class iz implements pp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f9270a;
    private final mp b;
    private final aw c;
    private final long d;
    private final yp e;
    private final ig1 f;

    @Override // com.yandex.mobile.ads.impl.pp
    public final void a(boolean z) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ iz(View view, mp mpVar, aw awVar, long j, yp ypVar) {
        this(view, mpVar, awVar, j, ypVar, ig1.a.a(true));
        int i = ig1.f9217a;
    }

    public iz(View closeButton, mp closeAppearanceController, aw debugEventsReporter, long j, yp closeTimerProgressIncrementer, ig1 pausableTimer) {
        Intrinsics.checkNotNullParameter(closeButton, "closeButton");
        Intrinsics.checkNotNullParameter(closeAppearanceController, "closeAppearanceController");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        Intrinsics.checkNotNullParameter(closeTimerProgressIncrementer, "closeTimerProgressIncrementer");
        Intrinsics.checkNotNullParameter(pausableTimer, "pausableTimer");
        this.f9270a = closeButton;
        this.b = closeAppearanceController;
        this.c = debugEventsReporter;
        this.d = j;
        this.e = closeTimerProgressIncrementer;
        this.f = pausableTimer;
        closeAppearanceController.a(d());
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final View d() {
        return this.f9270a;
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void c() {
        a aVar = new a(this.f9270a, this.b, this.c);
        long jMax = (long) Math.max(0.0d, this.d - this.e.a());
        if (jMax == 0) {
            this.b.b(this.f9270a);
            return;
        }
        this.f.a(this.e);
        this.f.a(jMax, aVar);
        this.c.a(zv.d);
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void b() {
        this.f.pause();
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void a() {
        this.f.resume();
    }

    @Override // com.yandex.mobile.ads.impl.pp
    public final void invalidate() {
        this.f.invalidate();
    }

    private static final class a implements kg1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final mp f9271a;
        private final aw b;
        private final WeakReference<View> c;

        public a(View view, mp closeAppearanceController, aw debugEventsReporter) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(closeAppearanceController, "closeAppearanceController");
            Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
            this.f9271a = closeAppearanceController;
            this.b = debugEventsReporter;
            this.c = new WeakReference<>(view);
        }

        @Override // com.yandex.mobile.ads.impl.kg1
        public final void a() {
            View view = this.c.get();
            if (view != null) {
                this.f9271a.b(view);
                this.b.a(zv.e);
            }
        }
    }
}
