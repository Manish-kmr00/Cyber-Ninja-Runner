package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class do1 extends mg0 implements ph2 {
    private boolean A;
    private final a B;
    private final jp0 y;
    private final ua z;

    @Override // com.yandex.mobile.ads.impl.bk, com.yandex.mobile.ads.impl.ch1.b
    public final void a(zg1 phoneState) {
        Intrinsics.checkNotNullParameter(phoneState, "phoneState");
        super.a(phoneState);
        y();
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public final void b(w3 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        super.b(error);
        if (5 == error.b() || 2 == error.b()) {
            return;
        }
        y();
    }

    public /* synthetic */ do1(Context context, jp0 jp0Var, g5 g5Var) {
        this(context, jp0Var, g5Var, new ua(jp0Var));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public do1(Context context, jp0 adView, g5 adLoadingPhasesManager, ua adViewVisibilityValidator) {
        super(context, adView.getAdConfiguration$mobileads_externalRelease(), adLoadingPhasesManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(adLoadingPhasesManager, "adLoadingPhasesManager");
        Intrinsics.checkNotNullParameter(adViewVisibilityValidator, "adViewVisibilityValidator");
        this.y = adView;
        this.z = adViewVisibilityValidator;
        this.A = true;
        this.B = new a();
        adView.addVisibilityChangeListener(this);
    }

    @Override // com.yandex.mobile.ads.impl.ph2
    public final void a(int i) {
        y();
    }

    @Override // com.yandex.mobile.ads.impl.bk
    public void d() {
        super.d();
        this.y.removeVisibilityChangeListener(this);
        op0.d(new Object[0]);
        this.A = false;
        m().removeCallbacks(this.B);
        op0.d(new Object[0]);
    }

    @Override // com.yandex.mobile.ads.impl.bk
    protected final void s() {
        super.s();
        y();
    }

    private final void y() {
        op0.d(new Object[0]);
        m().removeCallbacks(this.B);
        op0.d(new Object[0]);
        o8<String> o8VarK = k();
        if (o8VarK != null && o8VarK.T() && this.A && !o() && this.z.b()) {
            m().postDelayed(this.B, o8VarK.g());
            op0.d(Integer.valueOf(o8VarK.h()));
        }
    }

    private final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            op0.d(new Object[0]);
            do1.this.b(do1.this.f().a());
        }
    }
}
