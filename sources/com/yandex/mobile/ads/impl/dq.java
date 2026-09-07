package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class dq<V extends ViewGroup> implements y00<V>, f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f8721a;
    private final e1 b;
    private final mp c;
    private final wr d;
    private final x41 e;
    private final aw f;
    private final y42 g;
    private pp h;
    private final tl1 i;
    private final ip j;

    public dq(o8<?> adResponse, e1 adActivityEventController, mp closeAppearanceController, wr contentCloseListener, x41 nativeAdControlViewProvider, aw debugEventsReporter, y42 timeProviderContainer) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(closeAppearanceController, "closeAppearanceController");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdControlViewProvider, "nativeAdControlViewProvider");
        Intrinsics.checkNotNullParameter(debugEventsReporter, "debugEventsReporter");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        this.f8721a = adResponse;
        this.b = adActivityEventController;
        this.c = closeAppearanceController;
        this.d = contentCloseListener;
        this.e = nativeAdControlViewProvider;
        this.f = debugEventsReporter;
        this.g = timeProviderContainer;
        this.i = timeProviderContainer.e();
        this.j = timeProviderContainer.b();
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        View viewC = this.e.c(container);
        ProgressBar progressBarA = this.e.a(container);
        if (viewC != null) {
            this.b.a(this);
            Context context = viewC.getContext();
            int i = iw1.l;
            iw1 iw1VarA = iw1.a.a();
            Intrinsics.checkNotNull(context);
            cu1 cu1VarA = iw1VarA.a(context);
            if (!(Intrinsics.areEqual(d10.DIV_KIT.a(), this.f8721a.w()) && (cu1VarA != null && cu1VarA.x0()))) {
                viewC.setOnClickListener(new a(this.d, this.f));
            }
            a(viewC, progressBarA);
            if (viewC.getTag() == null) {
                viewC.setTag("close");
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.f1
    public final void b() {
        pp ppVar = this.h;
        if (ppVar != null) {
            ppVar.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        this.b.b(this);
        pp ppVar = this.h;
        if (ppVar != null) {
            ppVar.invalidate();
        }
    }

    private final void a(View view, ProgressBar progressBar) {
        pp izVar;
        Long lU = this.f8721a.u();
        long jLongValue = lU != null ? lU.longValue() : 0L;
        if (progressBar != null) {
            izVar = new ml1(view, progressBar, new e50(), new wp(new yd()), this.f, this.i, jLongValue);
        } else if (this.j.a()) {
            izVar = new iz(view, this.c, this.f, jLongValue, this.g.c());
        } else {
            izVar = null;
        }
        this.h = izVar;
        if (izVar != null) {
            izVar.c();
        }
    }

    private static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final wr f8722a;
        private final aw b;

        public a(wr mContentCloseListener, aw mDebugEventsReporter) {
            Intrinsics.checkNotNullParameter(mContentCloseListener, "mContentCloseListener");
            Intrinsics.checkNotNullParameter(mDebugEventsReporter, "mDebugEventsReporter");
            this.f8722a = mContentCloseListener;
            this.b = mDebugEventsReporter;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f8722a.f();
            this.b.a(zv.c);
        }
    }

    @Override // com.yandex.mobile.ads.impl.f1
    public final void a() {
        pp ppVar = this.h;
        if (ppVar != null) {
            ppVar.a();
        }
    }
}
