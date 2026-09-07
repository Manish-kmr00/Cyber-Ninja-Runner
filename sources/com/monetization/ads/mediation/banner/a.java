package com.monetization.ads.mediation.banner;

import android.content.Context;
import android.view.View;
import com.monetization.ads.mediation.base.MediatedAdRequestError;
import com.monetization.ads.mediation.base.model.MediatedAdObject;
import com.yandex.mobile.ads.impl.ao1;
import com.yandex.mobile.ads.impl.lk0;
import com.yandex.mobile.ads.impl.mx0;
import com.yandex.mobile.ads.impl.nx0;
import com.yandex.mobile.ads.impl.op0;
import com.yandex.mobile.ads.impl.px0;
import com.yandex.mobile.ads.impl.ta;
import com.yandex.mobile.ads.impl.w3;
import com.yandex.mobile.ads.impl.zi;
import com.yandex.mobile.ads.impl.zn1;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements MediatedBannerAdapter.MediatedBannerAdapterListener {
    static final /* synthetic */ KProperty<Object>[] f = {ta.a(a.class, "loadController", "getLoadController()Lcom/monetization/ads/banner/BannerAdLoadController;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final nx0<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> f7220a;
    private final d b;
    private final lk0 c;
    private final zn1 d;
    private boolean e;

    /* JADX INFO: renamed from: com.monetization.ads.mediation.banner.a$a, reason: collision with other inner class name */
    private final class C0708a implements d.a {
        public C0708a() {
        }

        @Override // com.monetization.ads.mediation.banner.d.a
        public final void a() {
            zi ziVarA = a.this.a();
            if (ziVarA != null) {
                a.this.f7220a.c(ziVarA.l());
            }
            if (a.this.f7220a.b()) {
                a.c(a.this);
            }
        }
    }

    static final class b extends Lambda implements Function0<Unit> {
        final /* synthetic */ View c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(View view) {
            super(0);
            this.c = view;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            a.this.a(this.c);
            return Unit.INSTANCE;
        }
    }

    static final class c extends Lambda implements Function1<String, Unit> {
        c() {
            super(1);
        }

        public final void a(String errorDescription) {
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            a.this.onAdFailedToLoad(new MediatedAdRequestError(1, "Ad is blocked by quality verification with reasons:  " + errorDescription));
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    public static final void c(a aVar) {
        zi ziVarA = aVar.a();
        if (ziVarA != null) {
            aVar.f7220a.b(ziVarA.l(), MapsKt.emptyMap());
            ziVarA.a(aVar.c.a());
        }
    }

    @Override // com.monetization.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdClicked() {
        zi ziVarA = a();
        if (ziVarA != null) {
            ziVarA.j().a();
            this.f7220a.a(ziVarA.l(), MapsKt.emptyMap());
        }
    }

    @Override // com.monetization.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdFailedToLoad(MediatedAdRequestError adRequestError) {
        Intrinsics.checkNotNullParameter(adRequestError, "adRequestError");
        zi ziVarA = a();
        if (ziVarA != null) {
            Context contextL = ziVarA.l();
            w3 w3Var = new w3(adRequestError.getCode(), adRequestError.getDescription(), adRequestError.getDescription(), null);
            if (this.e) {
                this.f7220a.a(contextL, w3Var, this);
            } else {
                this.f7220a.b(contextL, w3Var, this);
            }
        }
    }

    @Override // com.monetization.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdImpression() {
        zi ziVarA;
        if (this.f7220a.b() || (ziVarA = a()) == null) {
            return;
        }
        this.f7220a.b(ziVarA.l(), MapsKt.emptyMap());
        ziVarA.a(this.c.a());
    }

    @Override // com.monetization.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdLeftApplication() {
        zi ziVarA = a();
        if (ziVarA != null) {
            ziVarA.onLeftApplication();
        }
    }

    @Override // com.monetization.ads.mediation.banner.MediatedBannerAdapter.MediatedBannerAdapterListener
    public final void onAdLoaded(View view) {
        px0 px0VarA;
        Intrinsics.checkNotNullParameter(view, "view");
        zi ziVarA = a();
        if (ziVarA != null) {
            mx0<T> mx0VarA = this.f7220a.a();
            MediatedAdObject mediatedAdObjectA = (mx0VarA == 0 || (px0VarA = mx0VarA.a()) == null) ? null : px0VarA.a();
            if (mediatedAdObjectA != null) {
                ziVarA.a(mediatedAdObjectA.getAd(), mediatedAdObjectA.getInfo(), new b(view), new c());
            } else {
                op0.a(new Object[0]);
                a(view);
            }
        }
    }

    public /* synthetic */ a(zi ziVar, nx0 nx0Var, d dVar) {
        this(ziVar, nx0Var, dVar, new lk0(nx0Var));
    }

    public a(zi loadController, nx0<MediatedBannerAdapter, MediatedBannerAdapter.MediatedBannerAdapterListener> mediatedAdController, d mediatedContentViewPublisher, lk0 impressionDataProvider) {
        Intrinsics.checkNotNullParameter(loadController, "loadController");
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        Intrinsics.checkNotNullParameter(mediatedContentViewPublisher, "mediatedContentViewPublisher");
        Intrinsics.checkNotNullParameter(impressionDataProvider, "impressionDataProvider");
        this.f7220a = mediatedAdController;
        this.b = mediatedContentViewPublisher;
        this.c = impressionDataProvider;
        this.d = ao1.a(loadController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zi a() {
        return (zi) this.d.getValue(this, f[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view) {
        zi ziVarA = a();
        if (ziVarA != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (!this.e) {
                this.e = true;
                this.f7220a.c(context, MapsKt.emptyMap());
            } else {
                this.f7220a.b(context);
            }
            C0708a c0708a = new C0708a();
            ziVarA.j().c();
            this.b.a(view, c0708a);
            ziVarA.u();
        }
    }
}
