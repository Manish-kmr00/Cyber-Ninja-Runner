package com.monetization.ads.mediation.interstitial;

import android.content.Context;
import com.monetization.ads.mediation.base.MediatedAdRequestError;
import com.monetization.ads.mediation.base.model.MediatedAdObject;
import com.yandex.mobile.ads.impl.ao1;
import com.yandex.mobile.ads.impl.gd0;
import com.yandex.mobile.ads.impl.l7;
import com.yandex.mobile.ads.impl.lk0;
import com.yandex.mobile.ads.impl.mx0;
import com.yandex.mobile.ads.impl.nx0;
import com.yandex.mobile.ads.impl.op0;
import com.yandex.mobile.ads.impl.px0;
import com.yandex.mobile.ads.impl.ta;
import com.yandex.mobile.ads.impl.w3;
import com.yandex.mobile.ads.impl.wd0;
import com.yandex.mobile.ads.impl.zn1;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T extends wd0<T>> implements MediatedInterstitialAdapter.MediatedInterstitialAdapterListener {
    static final /* synthetic */ KProperty<Object>[] e = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "contentController", "getContentController()Lcom/monetization/ads/fullscreen/FullscreenContentController;", 0)), ta.a(a.class, "loadController", "getLoadController()Lcom/monetization/ads/fullscreen/FullScreenLoadController;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nx0<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> f7231a;
    private final lk0 b;
    private final zn1 c;
    private final zn1 d;

    /* JADX INFO: renamed from: com.monetization.ads.mediation.interstitial.a$a, reason: collision with other inner class name */
    static final class C0709a extends Lambda implements Function0<Unit> {
        final /* synthetic */ a<T> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0709a(a<T> aVar) {
            super(0);
            this.b = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            a.a(this.b);
            return Unit.INSTANCE;
        }
    }

    static final class b extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ a<T> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a<T> aVar) {
            super(1);
            this.b = aVar;
        }

        public final void a(String errorDescription) {
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            this.b.onInterstitialFailedToLoad(new MediatedAdRequestError(1, "Ad is blocked by quality verification with reasons:  " + errorDescription));
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    @Override // com.monetization.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onAdImpression() {
        wd0 wd0Var;
        if (this.f7231a.b() || (wd0Var = (wd0) this.c.getValue(this, e[0])) == null) {
            return;
        }
        this.f7231a.b(wd0Var.e(), MapsKt.emptyMap());
        wd0Var.a(this.b.a());
    }

    @Override // com.monetization.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialClicked() {
        l7 l7VarJ;
        zn1 zn1Var = this.c;
        KProperty<?>[] kPropertyArr = e;
        wd0 wd0Var = (wd0) zn1Var.getValue(this, kPropertyArr[0]);
        if (wd0Var != null) {
            Context contextE = wd0Var.e();
            gd0 gd0Var = (gd0) this.d.getValue(this, kPropertyArr[1]);
            if (gd0Var != null && (l7VarJ = gd0Var.j()) != null) {
                l7VarJ.a();
            }
            this.f7231a.a(contextE, MapsKt.emptyMap());
        }
    }

    @Override // com.monetization.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialDismissed() {
        l7 l7VarJ;
        zn1 zn1Var = this.c;
        KProperty<?>[] kPropertyArr = e;
        wd0 wd0Var = (wd0) zn1Var.getValue(this, kPropertyArr[0]);
        if (wd0Var != null) {
            wd0Var.p();
        }
        gd0 gd0Var = (gd0) this.d.getValue(this, kPropertyArr[1]);
        if (gd0Var == null || (l7VarJ = gd0Var.j()) == null) {
            return;
        }
        l7VarJ.b();
    }

    @Override // com.monetization.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialFailedToLoad(MediatedAdRequestError adRequestError) {
        Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
        gd0 gd0Var = (gd0) this.d.getValue(this, e[1]);
        if (gd0Var != null) {
            this.f7231a.b(gd0Var.l(), new w3(adRequestError.getCode(), adRequestError.getDescription(), adRequestError.getDescription(), null), this);
        }
    }

    @Override // com.monetization.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialLeftApplication() {
        wd0 wd0Var = (wd0) this.c.getValue(this, e[0]);
        if (wd0Var != null) {
            wd0Var.onLeftApplication();
        }
    }

    @Override // com.monetization.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialLoaded() {
        px0 px0VarA;
        zn1 zn1Var = this.d;
        KProperty<?>[] kPropertyArr = e;
        gd0 gd0Var = (gd0) zn1Var.getValue(this, kPropertyArr[1]);
        if (gd0Var != null) {
            mx0<T> mx0VarA = this.f7231a.a();
            MediatedAdObject mediatedAdObjectA = (mx0VarA == 0 || (px0VarA = mx0VarA.a()) == null) ? null : px0VarA.a();
            if (mediatedAdObjectA != null) {
                gd0Var.a(mediatedAdObjectA.getAd(), mediatedAdObjectA.getInfo(), new C0709a(this), new b(this));
                return;
            }
            op0.a(new Object[0]);
            gd0 gd0Var2 = (gd0) this.d.getValue(this, kPropertyArr[1]);
            if (gd0Var2 != null) {
                this.f7231a.c(gd0Var2.l(), MapsKt.emptyMap());
                gd0Var2.u();
            }
        }
    }

    @Override // com.monetization.ads.mediation.interstitial.MediatedInterstitialAdapter.MediatedInterstitialAdapterListener
    public final void onInterstitialShown() {
        wd0 wd0Var;
        zn1 zn1Var = this.c;
        KProperty<?>[] kPropertyArr = e;
        wd0 wd0Var2 = (wd0) zn1Var.getValue(this, kPropertyArr[0]);
        if (wd0Var2 != null) {
            wd0Var2.q();
            this.f7231a.c(wd0Var2.e());
        }
        if (!this.f7231a.b() || (wd0Var = (wd0) this.c.getValue(this, kPropertyArr[0])) == null) {
            return;
        }
        this.f7231a.b(wd0Var.e(), MapsKt.emptyMap());
        wd0Var.a(this.b.a());
    }

    public /* synthetic */ a(gd0 gd0Var, nx0 nx0Var) {
        this(gd0Var, nx0Var, new lk0(nx0Var));
    }

    public a(gd0<T> loadController, nx0<MediatedInterstitialAdapter, MediatedInterstitialAdapter.MediatedInterstitialAdapterListener> mediatedAdController, lk0 impressionDataProvider) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        Intrinsics.checkNotNullParameter(impressionDataProvider, "impressionDataProvider");
        this.f7231a = mediatedAdController;
        this.b = impressionDataProvider;
        this.c = ao1.a(null);
        this.d = ao1.a(loadController);
    }

    public final void a(wd0<T> wd0Var) {
        this.c.setValue(this, e[0], wd0Var);
    }

    public static final void a(a aVar) {
        gd0 gd0Var = (gd0) aVar.d.getValue(aVar, e[1]);
        if (gd0Var != null) {
            aVar.f7231a.c(gd0Var.l(), MapsKt.emptyMap());
            gd0Var.u();
        }
    }
}
