package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.MediatedAdRequestError;
import com.monetization.ads.mediation.base.model.MediatedAdObject;
import com.monetization.ads.mediation.rewarded.MediatedReward;
import com.monetization.ads.mediation.rewarded.MediatedRewardedAdapter;
import com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class cs1 implements MediatedRewardedAdapterListener {
    static final /* synthetic */ KProperty<Object>[] e = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(cs1.class, "contentController", "getContentController()Lcom/monetization/ads/rewarded/content/RewardedAdContentController;", 0)), ta.a(cs1.class, "loadController", "getLoadController()Lcom/monetization/ads/fullscreen/FullScreenLoadController;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nx0<MediatedRewardedAdapter, MediatedRewardedAdapterListener> f8636a;
    private final lk0 b;
    private final zn1 c;
    private final zn1 d;

    static final class a extends Lambda implements Function0<Unit> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            cs1.a(cs1.this);
            return Unit.INSTANCE;
        }
    }

    @Override // com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdFailedToLoad(MediatedAdRequestError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        gd0 gd0Var = (gd0) this.d.getValue(this, e[1]);
        if (gd0Var != null) {
            this.f8636a.b(gd0Var.l(), new w3(error.getCode(), error.getDescription(), error.getDescription(), null), this);
        }
    }

    public /* synthetic */ cs1(gd0 gd0Var, nx0 nx0Var) {
        this(gd0Var, nx0Var, new lk0(nx0Var));
    }

    public static final void a(cs1 cs1Var) {
        gd0 gd0Var = (gd0) cs1Var.d.getValue(cs1Var, e[1]);
        if (gd0Var != null) {
            cs1Var.f8636a.c(gd0Var.l(), MapsKt.emptyMap());
            gd0Var.u();
        }
    }

    @Override // com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdLoaded() {
        px0 px0VarA;
        zn1 zn1Var = this.d;
        KProperty<?>[] kPropertyArr = e;
        gd0 gd0Var = (gd0) zn1Var.getValue(this, kPropertyArr[1]);
        if (gd0Var != null) {
            mx0<T> mx0VarA = this.f8636a.a();
            MediatedAdObject mediatedAdObjectA = (mx0VarA == 0 || (px0VarA = mx0VarA.a()) == null) ? null : px0VarA.a();
            if (mediatedAdObjectA != null) {
                gd0Var.a(mediatedAdObjectA.getAd(), mediatedAdObjectA.getInfo(), new a(), new b());
                return;
            }
            op0.a(new Object[0]);
            gd0 gd0Var2 = (gd0) this.d.getValue(this, kPropertyArr[1]);
            if (gd0Var2 != null) {
                this.f8636a.c(gd0Var2.l(), MapsKt.emptyMap());
                gd0Var2.u();
            }
        }
    }

    public cs1(gd0<ur1> loadController, nx0<MediatedRewardedAdapter, MediatedRewardedAdapterListener> mediatedAdController, lk0 impressionDataProvider) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        Intrinsics.checkNotNullParameter(impressionDataProvider, "impressionDataProvider");
        this.f8636a = mediatedAdController;
        this.b = impressionDataProvider;
        this.c = ao1.a(null);
        this.d = ao1.a(loadController);
    }

    @Override // com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdClicked() {
        l7 l7VarJ;
        ur1 ur1VarA = a();
        if (ur1VarA != null) {
            Context contextE = ur1VarA.e();
            gd0 gd0Var = (gd0) this.d.getValue(this, e[1]);
            if (gd0Var != null && (l7VarJ = gd0Var.j()) != null) {
                l7VarJ.a();
            }
            this.f8636a.a(contextE, MapsKt.emptyMap());
        }
    }

    public final ur1 a() {
        return (ur1) this.c.getValue(this, e[0]);
    }

    @Override // com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdDismissed() {
        l7 l7VarJ;
        ur1 ur1VarA = a();
        if (ur1VarA != null) {
            ur1VarA.p();
        }
        gd0 gd0Var = (gd0) this.d.getValue(this, e[1]);
        if (gd0Var == null || (l7VarJ = gd0Var.j()) == null) {
            return;
        }
        l7VarJ.b();
    }

    @Override // com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdLeftApplication() {
        ur1 ur1VarA = a();
        if (ur1VarA != null) {
            ur1VarA.onLeftApplication();
        }
    }

    public final void a(ur1 ur1Var) {
        this.c.setValue(this, e[0], ur1Var);
    }

    static final class b extends Lambda implements Function1<String, Unit> {
        b() {
            super(1);
        }

        public final void a(String errorDescription) {
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            cs1.this.onRewardedAdFailedToLoad(new MediatedAdRequestError(1, "Ad is blocked by quality verification with reasons:  " + errorDescription));
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    @Override // com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewardedAdShown() {
        ur1 ur1VarA;
        ur1 ur1VarA2 = a();
        if (ur1VarA2 != null) {
            ur1VarA2.q();
            this.f8636a.c(ur1VarA2.e());
        }
        if (!this.f8636a.b() || (ur1VarA = a()) == null) {
            return;
        }
        this.f8636a.b(ur1VarA.e(), MapsKt.emptyMap());
        ur1VarA.a(this.b.a());
    }

    @Override // com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onRewarded(MediatedReward mediatedReward) {
        ur1 ur1VarA = a();
        if (ur1VarA != null) {
            this.f8636a.a(ur1VarA.e(), ur1VarA.d());
            ur1VarA.r();
        }
    }

    @Override // com.monetization.ads.mediation.rewarded.MediatedRewardedAdapterListener
    public final void onAdImpression() {
        ur1 ur1VarA;
        if (this.f8636a.b() || (ur1VarA = a()) == null) {
            return;
        }
        this.f8636a.b(ur1VarA.e(), MapsKt.emptyMap());
        ur1VarA.a(this.b.a());
    }
}
