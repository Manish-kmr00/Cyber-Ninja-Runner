package com.monetization.ads.mediation.appopenad;

import com.monetization.ads.mediation.base.MediatedAdRequestError;
import com.yandex.mobile.ads.impl.gd0;
import com.yandex.mobile.ads.impl.lk0;
import com.yandex.mobile.ads.impl.nx0;
import com.yandex.mobile.ads.impl.w3;
import com.yandex.mobile.ads.impl.wd0;
import java.lang.ref.WeakReference;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T extends wd0<T>> implements MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nx0<MediatedAppOpenAdAdapter, MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener> f7217a;
    private final WeakReference<gd0<T>> b;
    private WeakReference<wd0<T>> c;
    private final lk0 d;

    public a(gd0<T> loadController, nx0<MediatedAppOpenAdAdapter, MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener> mediatedAdController) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        this.f7217a = mediatedAdController;
        this.b = new WeakReference<>(loadController);
        this.c = new WeakReference<>(null);
        this.d = new lk0(mediatedAdController);
    }

    public final void a(wd0<T> controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.c = new WeakReference<>(controller);
    }

    @Override // com.monetization.ads.mediation.appopenad.MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener
    public final void onAdImpression() {
        wd0<T> wd0Var;
        if (this.f7217a.b() || (wd0Var = this.c.get()) == null) {
            return;
        }
        this.f7217a.b(wd0Var.e(), MapsKt.emptyMap());
        wd0Var.a(this.d.a());
    }

    @Override // com.monetization.ads.mediation.appopenad.MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener
    public final void onAppOpenAdClicked() {
        wd0<T> wd0Var = this.c.get();
        if (wd0Var != null) {
            this.f7217a.a(wd0Var.e(), MapsKt.emptyMap());
        }
    }

    @Override // com.monetization.ads.mediation.appopenad.MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener
    public final void onAppOpenAdDismissed() {
        wd0<T> wd0Var = this.c.get();
        if (wd0Var != null) {
            wd0Var.p();
        }
    }

    @Override // com.monetization.ads.mediation.appopenad.MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener
    public final void onAppOpenAdFailedToLoad(MediatedAdRequestError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        gd0<T> gd0Var = this.b.get();
        if (gd0Var != null) {
            this.f7217a.b(gd0Var.l(), new w3(error.getCode(), error.getDescription(), error.getDescription(), null), this);
        }
    }

    @Override // com.monetization.ads.mediation.appopenad.MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener
    public final void onAppOpenAdLeftApplication() {
        wd0<T> wd0Var = this.c.get();
        if (wd0Var != null) {
            wd0Var.onLeftApplication();
        }
    }

    @Override // com.monetization.ads.mediation.appopenad.MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener
    public final void onAppOpenAdLoaded() {
        gd0<T> gd0Var = this.b.get();
        if (gd0Var != null) {
            this.f7217a.c(gd0Var.l(), MapsKt.emptyMap());
            gd0Var.u();
        }
    }

    @Override // com.monetization.ads.mediation.appopenad.MediatedAppOpenAdAdapter.MediatedAppOpenAdAdapterListener
    public final void onAppOpenAdShown() {
        wd0<T> wd0Var;
        wd0<T> wd0Var2 = this.c.get();
        if (wd0Var2 != null) {
            wd0Var2.q();
            this.f7217a.c(wd0Var2.e());
        }
        if (!this.f7217a.b() || (wd0Var = this.c.get()) == null) {
            return;
        }
        this.f7217a.b(wd0Var.e(), MapsKt.emptyMap());
        wd0Var.a(this.d.a());
    }
}
