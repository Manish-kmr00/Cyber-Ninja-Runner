package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class yk0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zk0 f10746a;
    private final Handler b;
    private final xh2 c;
    private final fp0 d;

    public /* synthetic */ yk0(ja1 ja1Var, List list) {
        this(ja1Var, list, new zk0(), new Handler(Looper.getMainLooper()), new xh2(), gp0.a(ja1Var, list));
    }

    public yk0(ja1 nativeValidator, List<xx1> showNotices, zk0 indicatorPresenter, Handler handler, xh2 availabilityChecker, fp0 integrationValidator) {
        Intrinsics.checkNotNullParameter(nativeValidator, "nativeValidator");
        Intrinsics.checkNotNullParameter(showNotices, "showNotices");
        Intrinsics.checkNotNullParameter(indicatorPresenter, "indicatorPresenter");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(availabilityChecker, "availabilityChecker");
        Intrinsics.checkNotNullParameter(integrationValidator, "integrationValidator");
        this.f10746a = indicatorPresenter;
        this.b = handler;
        this.c = availabilityChecker;
        this.d = integrationValidator;
    }

    public final void a(c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        this.b.removeCallbacksAndMessages(null);
        View viewE = nativeAdViewAdapter.e();
        if (viewE instanceof FrameLayout) {
            this.f10746a.a((FrameLayout) viewE);
        }
    }

    public final void a(Context context, c71 nativeAdViewAdapter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        this.c.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int i = iw1.l;
        iw1 iw1VarA = iw1.a.a();
        cu1 cu1VarA = iw1VarA.a(context);
        Boolean boolB0 = cu1VarA != null ? cu1VarA.B0() : null;
        boolean zH = iw1VarA.h();
        boolean zI = iw1VarA.i();
        if (boolB0 != null) {
            if (!boolB0.booleanValue()) {
                return;
            }
        } else if ((!zH || !pa.a(context)) && !zI) {
            return;
        }
        this.b.post(new a(this, nativeAdViewAdapter));
    }

    private final class a implements Runnable {
        private final c71 b;
        final /* synthetic */ yk0 c;

        public a(yk0 yk0Var, c71 nativeAdViewAdapter) {
            Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
            this.c = yk0Var;
            this.b = nativeAdViewAdapter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View viewE = this.b.e();
            if (viewE instanceof FrameLayout) {
                fp0 fp0Var = this.c.d;
                FrameLayout frameLayout = (FrameLayout) viewE;
                Context context = frameLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                this.c.f10746a.a(fp0Var.a(context), frameLayout);
                this.c.b.postDelayed(new a(this.c, this.b), 300L);
            }
        }
    }

    public final void a() {
        this.b.removeCallbacksAndMessages(null);
    }
}
