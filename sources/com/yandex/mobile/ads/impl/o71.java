package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.MediatedAdRequestError;
import com.monetization.ads.mediation.base.model.MediatedAdObject;
import com.monetization.ads.mediation.nativeads.MediatedNativeAd;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdAssets;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdImage;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdapter;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class o71 implements MediatedNativeAdapterListener {
    static final /* synthetic */ KProperty<Object>[] o = {ta.a(o71.class, "nativeAdLoadManager", "getNativeAdLoadManager()Lcom/monetization/ads/nativeads/NativeAdLoadManager;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<u61> f9787a;
    private final nx0<MediatedNativeAdapter, MediatedNativeAdapterListener> b;
    private final sx0 c;
    private final ky0 d;
    private final lk0 e;
    private final Context f;
    private final zn1 g;
    private final LinkedHashMap h;
    private final LinkedHashMap i;
    private final hj0 j;
    private final jy0 k;
    private final wx0 l;
    private final ty0 m;
    private boolean n;

    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ MediatedNativeAd c;
        final /* synthetic */ zq1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(MediatedNativeAd mediatedNativeAd, zq1 zq1Var) {
            super(0);
            this.c = mediatedNativeAd;
            this.d = zq1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            o71.this.a(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdFailedToLoad(MediatedAdRequestError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        c61 c61Var = (c61) this.g.getValue(this, o[0]);
        if (c61Var != null) {
            this.b.b(c61Var.l(), new w3(error.getCode(), error.getDescription(), error.getDescription(), null), this);
        }
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAppInstallAdLoaded(MediatedNativeAd mediatedNativeAd) {
        Intrinsics.checkNotNullParameter(mediatedNativeAd, "mediatedNativeAd");
        b(mediatedNativeAd, zq1.d);
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onContentAdLoaded(MediatedNativeAd mediatedNativeAd) {
        Intrinsics.checkNotNullParameter(mediatedNativeAd, "mediatedNativeAd");
        b(mediatedNativeAd, zq1.c);
    }

    public /* synthetic */ o71(o8 o8Var, c61 c61Var, nx0 nx0Var) {
        this(o8Var, c61Var, nx0Var, new sx0(), new ky0(), new lk0(nx0Var));
    }

    private final void b(MediatedNativeAd mediatedNativeAd, zq1 zq1Var) {
        px0 px0VarA;
        c61 c61Var = (c61) this.g.getValue(this, o[0]);
        if (c61Var != null) {
            mx0<T> mx0VarA = this.b.a();
            MediatedAdObject mediatedAdObjectA = (mx0VarA == 0 || (px0VarA = mx0VarA.a()) == null) ? null : px0VarA.a();
            if (mediatedAdObjectA != null) {
                c61Var.a(mediatedAdObjectA.getAd(), mediatedAdObjectA.getInfo(), new a(mediatedNativeAd, zq1Var), new b());
            } else {
                op0.a(new Object[0]);
                a(mediatedNativeAd, zq1Var);
            }
        }
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdClicked() {
        l7 l7VarJ;
        c61 c61Var = (c61) this.g.getValue(this, o[0]);
        if (c61Var != null && (l7VarJ = c61Var.j()) != null) {
            l7VarJ.a();
        }
        nx0<MediatedNativeAdapter, MediatedNativeAdapterListener> nx0Var = this.b;
        Context applicationContext = this.f;
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        nx0Var.a(applicationContext, this.h);
        Context applicationContext2 = this.f;
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
        hp1.b bVar = hp1.b.C;
        ip1 ip1Var = new ip1(this.h, 2);
        ip1Var.b(bVar.a(), "event_type");
        ip1Var.b(this.i, "ad_info");
        ip1Var.a(this.f9787a.b());
        Map<String, Object> mapS = this.f9787a.s();
        if (mapS != null) {
            ip1Var.a((Map<String, ? extends Object>) mapS);
        }
        this.b.d(applicationContext2, ip1Var.b());
        this.c.a();
    }

    public o71(o8<u61> adResponse, c61 nativeAdLoadManager, nx0<MediatedNativeAdapter, MediatedNativeAdapterListener> mediatedAdController, sx0 nativeAdEventObservable, ky0 mediatedImagesExtractor, lk0 impressionDataProvider) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdLoadManager, "nativeAdLoadManager");
        Intrinsics.checkNotNullParameter(mediatedAdController, "mediatedAdController");
        Intrinsics.checkNotNullParameter(nativeAdEventObservable, "nativeAdEventObservable");
        Intrinsics.checkNotNullParameter(mediatedImagesExtractor, "mediatedImagesExtractor");
        Intrinsics.checkNotNullParameter(impressionDataProvider, "impressionDataProvider");
        this.f9787a = adResponse;
        this.b = mediatedAdController;
        this.c = nativeAdEventObservable;
        this.d = mediatedImagesExtractor;
        this.e = impressionDataProvider;
        Context applicationContext = nativeAdLoadManager.l().getApplicationContext();
        this.f = applicationContext;
        this.g = ao1.a(nativeAdLoadManager);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.h = linkedHashMap;
        this.i = new LinkedHashMap();
        hj0 hj0Var = new hj0(nativeAdLoadManager.l());
        this.j = hj0Var;
        jy0 jy0Var = new jy0(nativeAdLoadManager.l());
        this.k = jy0Var;
        this.l = new wx0(nativeAdLoadManager.l(), hj0Var, jy0Var);
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        this.m = new ty0(applicationContext, mediatedAdController, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final MediatedNativeAd mediatedNativeAd, zq1 zq1Var) {
        final c61 c61Var = (c61) this.g.getValue(this, o[0]);
        if (c61Var != null) {
            this.h.put("native_ad_type", zq1Var.a());
            this.b.c(c61Var.l(), this.h);
            this.i.putAll(MapsKt.mapOf(TuplesKt.to("title", mediatedNativeAd.getMediatedNativeAdAssets().getTitle())));
            this.d.getClass();
            Intrinsics.checkNotNullParameter(mediatedNativeAd, "mediatedNativeAd");
            MediatedNativeAdAssets mediatedNativeAdAssets = mediatedNativeAd.getMediatedNativeAdAssets();
            List<MediatedNativeAdImage> listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new MediatedNativeAdImage[]{mediatedNativeAdAssets.getFavicon(), mediatedNativeAdAssets.getIcon(), mediatedNativeAdAssets.getImage()});
            this.j.a(this.k.b(listListOfNotNull));
            this.l.a(mediatedNativeAd, zq1Var, listListOfNotNull, new wx0.a() { // from class: com.yandex.mobile.ads.impl.o71$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.wx0.a
                public final void a(o8 o8Var) {
                    o71.a(mediatedNativeAd, this, c61Var, o8Var);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MediatedNativeAd mediatedNativeAd, final o71 this$0, c61 c61Var, o8 convertedAdResponse) {
        Intrinsics.checkNotNullParameter(mediatedNativeAd, "$mediatedNativeAd");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(convertedAdResponse, "convertedAdResponse");
        az0 az0Var = new az0(mediatedNativeAd, this$0.m, c61Var.j(), new uw1());
        c61Var.a((o8<u61>) convertedAdResponse, new o51(new tx0(this$0.f9787a, this$0.b.a()), new rx0(new rx0.a() { // from class: com.yandex.mobile.ads.impl.o71$$ExternalSyntheticLambda1
            @Override // com.yandex.mobile.ads.impl.rx0.a
            public final void a(l51 l51Var) {
                o71.a(this.f$0, l51Var);
            }
        }), az0Var, new ny0(), new zy0()));
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdClosed() {
        l7 l7VarJ;
        this.c.b();
        c61 c61Var = (c61) this.g.getValue(this, o[0]);
        if (c61Var == null || (l7VarJ = c61Var.j()) == null) {
            return;
        }
        l7VarJ.b();
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdImpression() {
        if (this.n) {
            return;
        }
        this.n = true;
        nx0<MediatedNativeAdapter, MediatedNativeAdapterListener> nx0Var = this.b;
        Context applicationContext = this.f;
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        nx0Var.b(applicationContext, this.h);
        Context applicationContext2 = this.f;
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
        hp1.b bVar = hp1.b.y;
        ip1 ip1Var = new ip1(this.h, 2);
        ip1Var.b(bVar.a(), "event_type");
        ip1Var.b(this.i, "ad_info");
        ip1Var.a(this.f9787a.b());
        Map<String, Object> mapS = this.f9787a.s();
        if (mapS != null) {
            ip1Var.a((Map<String, ? extends Object>) mapS);
        }
        this.b.d(applicationContext2, ip1Var.b());
        this.c.a(this.e.a());
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdLeftApplication() {
        this.c.c();
    }

    @Override // com.monetization.ads.mediation.nativeads.MediatedNativeAdapterListener
    public final void onAdOpened() {
        this.c.d();
    }

    static final class b extends Lambda implements Function1<String, Unit> {
        b() {
            super(1);
        }

        public final void a(String errorDescription) {
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
            o71.this.onAdFailedToLoad(new MediatedAdRequestError(1, "Ad is blocked by quality verification with reasons:  " + errorDescription));
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(o71 this$0, l51 controller) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(controller, "controller");
        this$0.c.a(controller);
    }
}
