package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes10.dex */
public abstract class v81 {
    private final o62 A;
    private final nc1 B;
    private final l51 C;
    private final String D;
    private final a31 E;
    private final h62 F;
    private final i3 G;
    private final zo H;
    private final og I;
    private c71 J;
    private final ch1.b K;
    private final List<y20> L;
    private final j91 M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10458a;
    private final a51 b;
    private final zb1 c;
    private final ja1 d;
    private final bc1 e;
    private final o51 f;
    private final o3 g;
    private final o8<?> h;
    private final u61 i;
    private final rx1 j;
    private final p81 k;
    private final vt l;
    private final z32 m;
    private final mk0 n;
    private final am o;
    private final d71 p;
    private final kx0 q;
    private final ug r;
    private final qk0 s;
    private final oo1 t;
    private final ql u;
    private final h70 v;
    private final e41 w;
    private final yn1 x;
    private final i70 y;
    private final eh z;

    public abstract void loadImages();

    public /* synthetic */ v81(Context context, jl jlVar, a51 a51Var) {
        zb1 zb1VarH = jlVar.h();
        ja1 ja1VarG = jlVar.g();
        bc1 bc1VarI = jlVar.i();
        o41 o41VarD = jlVar.d();
        uu1 uu1VarJ = jlVar.j();
        o51 o51VarE = jlVar.e();
        n81 n81VarC = jlVar.c();
        sa saVarB = jlVar.b();
        c41 c41VarF = jlVar.f();
        s9 s9VarA = jlVar.a();
        o3 o3VarA = o41VarD.a();
        qs qsVarB = o3VarA.b();
        o8<?> o8VarB = o41VarD.b();
        u61 u61VarC = o41VarD.c();
        List<ig<?>> listB = bc1VarI.b();
        String strA = bc1VarI.a();
        rx1 rx1VarH = u61VarC.h();
        p81 p81Var = new p81();
        vt vtVar = new vt(p81Var);
        z32 z32Var = new z32();
        mk0 mk0Var = new mk0();
        pd1 pd1Var = new pd1();
        ch1 ch1VarA = ch1.h.a(context);
        qo1 qo1Var = new qo1();
        am amVar = new am();
        ok0 ok0Var = new ok0();
        y4 y4VarA = o51VarE.a();
        int i = d71.d;
        d71 d71VarA = d71.a.a();
        kx0 kx0Var = new kx0(context, o3VarA);
        l71 l71Var = new l71(ja1VarG);
        u7 u7Var = new u7(l71Var, saVarB);
        ug ugVar = new ug(listB);
        k91 k91Var = new k91(ugVar);
        qk0 qk0Var = new qk0(context, o8VarB, o3VarA, bc1VarI.c());
        oo1 oo1Var = new oo1(listB);
        ql qlVar = new ql(y4VarA, qsVarB, o8VarB, strA, o3VarA.q().c());
        h70 h70Var = new h70(context, o3VarA, y4VarA, qsVarB, o8VarB, strA);
        e41 e41Var = new e41(context, o3VarA, y4VarA, qsVarB, strA);
        yn1 yn1Var = new yn1(context, o3VarA, y4VarA, qsVarB, o8VarB, strA);
        i70 i70Var = new i70(listB);
        eh ehVar = new eh(listB);
        v51 v51Var = new v51(strA);
        this(context, jlVar, a51Var, zb1VarH, ja1VarG, bc1VarI, o41VarD, uu1VarJ, o51VarE, n81VarC, saVarB, c41VarF, s9VarA, o3VarA, qsVarB, o8VarB, u61VarC, listB, rx1VarH, p81Var, vtVar, z32Var, mk0Var, pd1Var, ch1VarA, qo1Var, amVar, ok0Var, y4VarA, d71VarA, kx0Var, l71Var, u7Var, ugVar, k91Var, qk0Var, oo1Var, qlVar, h70Var, e41Var, yn1Var, i70Var, ehVar, v51Var, new s4(v51Var), new o62(), new nc1(o3VarA, o8VarB, listB, c41VarF != null ? c41VarF.e() : null));
    }

    public final void a(View nativeAdView, pj0 imageProvider, n71 nativeAdWeakViewHolder, bp clickListenerFactory, to clickConnector) throws a61 {
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdWeakViewHolder, "nativeAdWeakViewHolder");
        Intrinsics.checkNotNullParameter(clickListenerFactory, "clickListenerFactory");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        int i = d71.d;
        d71 d71VarA = d71.a.a();
        v81 v81VarA = d71VarA.a(nativeAdView);
        if (Intrinsics.areEqual(this, v81VarA)) {
            return;
        }
        if (v81VarA != null) {
            v81VarA.h();
        }
        if (d71VarA.a(this)) {
            h();
        }
        d71VarA.a(nativeAdView, this);
        c71 c71Var = new c71(nativeAdWeakViewHolder, this.g, imageProvider, this.n, clickListenerFactory, this.f, this.r, this.M, this.k, this.h, this.e, this.b, this.q, this.j);
        c71Var.a();
        this.J = c71Var;
        this.z.a(c71Var);
        this.d.a(c71Var);
        this.c.a(c71Var);
        clickConnector.a(this.I.a(clickListenerFactory, c71Var));
        b(c71Var);
        this.A.a(nativeAdView, new w81(this));
    }

    public final ja1 f() {
        return this.d;
    }

    public v81(Context context, jl binderConfiguration, a51 nativeAdControllers, zb1 renderer, ja1 nativeAdValidator, bc1 nativeVisualBlock, o41 nativeAdBlock, uu1 sdkEnvironmentModule, o51 nativeAdFactoriesProvider, n81 forceImpressionConfigurator, sa adViewRenderingValidator, c41 c41Var, s9 adStructureType, o3 adConfiguration, qs adType, o8 adResponse, u61 nativeAdResponse, List assets, rx1 rx1Var, p81 nativeForcePauseObserver, vt nativeAdVideoController, z32 targetUrlHandlerProvider, mk0 impressionEventsObservable, pd1 noticeTrackingManagerProvider, ch1 phoneStateTracker, po1 renderedTimer, am boundAssetsProvider, ok0 impressionManagerCreator, y4 infoReportDataProviderFactory, d71 bindingManager, kx0 mediaViewRenderController, l71 nativeAdVisibilityValidator, u7 adRenderingValidator, ug assetValueProvider, k91 nativeMediaContentFactory, qk0 impressionReporter, oo1 renderedAssetsProvider, ql bindingFailureReporter, h70 expectedViewMissingReporter, e41 nativeAdAssetNamesReporter, yn1 rebindAdReporter, i70 expectedViewsAssetProvider, eh assetsRenderedReportParameterProvider, v51 adIdProvider, s4 adIdStorageManager, o62 trackingTrigger, nc1 needLoadChecker) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(binderConfiguration, "binderConfiguration");
        Intrinsics.checkNotNullParameter(nativeAdControllers, "nativeAdControllers");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(nativeAdValidator, "nativeAdValidator");
        Intrinsics.checkNotNullParameter(nativeVisualBlock, "nativeVisualBlock");
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(nativeAdFactoriesProvider, "nativeAdFactoriesProvider");
        Intrinsics.checkNotNullParameter(forceImpressionConfigurator, "forceImpressionConfigurator");
        Intrinsics.checkNotNullParameter(adViewRenderingValidator, "adViewRenderingValidator");
        Intrinsics.checkNotNullParameter(adStructureType, "adStructureType");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(nativeForcePauseObserver, "nativeForcePauseObserver");
        Intrinsics.checkNotNullParameter(nativeAdVideoController, "nativeAdVideoController");
        Intrinsics.checkNotNullParameter(targetUrlHandlerProvider, "targetUrlHandlerProvider");
        Intrinsics.checkNotNullParameter(impressionEventsObservable, "impressionEventsObservable");
        Intrinsics.checkNotNullParameter(noticeTrackingManagerProvider, "noticeTrackingManagerProvider");
        Intrinsics.checkNotNullParameter(phoneStateTracker, "phoneStateTracker");
        Intrinsics.checkNotNullParameter(renderedTimer, "renderedTimer");
        Intrinsics.checkNotNullParameter(boundAssetsProvider, "boundAssetsProvider");
        Intrinsics.checkNotNullParameter(impressionManagerCreator, "impressionManagerCreator");
        Intrinsics.checkNotNullParameter(infoReportDataProviderFactory, "infoReportDataProviderFactory");
        Intrinsics.checkNotNullParameter(bindingManager, "bindingManager");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        Intrinsics.checkNotNullParameter(nativeAdVisibilityValidator, "nativeAdVisibilityValidator");
        Intrinsics.checkNotNullParameter(adRenderingValidator, "adRenderingValidator");
        Intrinsics.checkNotNullParameter(assetValueProvider, "assetValueProvider");
        Intrinsics.checkNotNullParameter(nativeMediaContentFactory, "nativeMediaContentFactory");
        Intrinsics.checkNotNullParameter(impressionReporter, "impressionReporter");
        Intrinsics.checkNotNullParameter(renderedAssetsProvider, "renderedAssetsProvider");
        Intrinsics.checkNotNullParameter(bindingFailureReporter, "bindingFailureReporter");
        Intrinsics.checkNotNullParameter(expectedViewMissingReporter, "expectedViewMissingReporter");
        Intrinsics.checkNotNullParameter(nativeAdAssetNamesReporter, "nativeAdAssetNamesReporter");
        Intrinsics.checkNotNullParameter(rebindAdReporter, "rebindAdReporter");
        Intrinsics.checkNotNullParameter(expectedViewsAssetProvider, "expectedViewsAssetProvider");
        Intrinsics.checkNotNullParameter(assetsRenderedReportParameterProvider, "assetsRenderedReportParameterProvider");
        Intrinsics.checkNotNullParameter(adIdProvider, "adIdProvider");
        Intrinsics.checkNotNullParameter(adIdStorageManager, "adIdStorageManager");
        Intrinsics.checkNotNullParameter(trackingTrigger, "trackingTrigger");
        Intrinsics.checkNotNullParameter(needLoadChecker, "needLoadChecker");
        this.f10458a = context;
        this.b = nativeAdControllers;
        this.c = renderer;
        this.d = nativeAdValidator;
        this.e = nativeVisualBlock;
        this.f = nativeAdFactoriesProvider;
        this.g = adConfiguration;
        this.h = adResponse;
        this.i = nativeAdResponse;
        this.j = rx1Var;
        this.k = nativeForcePauseObserver;
        this.l = nativeAdVideoController;
        this.m = targetUrlHandlerProvider;
        this.n = impressionEventsObservable;
        this.o = boundAssetsProvider;
        this.p = bindingManager;
        this.q = mediaViewRenderController;
        this.r = assetValueProvider;
        this.s = impressionReporter;
        this.t = renderedAssetsProvider;
        this.u = bindingFailureReporter;
        this.v = expectedViewMissingReporter;
        this.w = nativeAdAssetNamesReporter;
        this.x = rebindAdReporter;
        this.y = expectedViewsAssetProvider;
        this.z = assetsRenderedReportParameterProvider;
        this.A = trackingTrigger;
        this.B = needLoadChecker;
        l51 l51VarA = nativeAdFactoriesProvider.b().a(context, adResponse, adConfiguration);
        this.C = l51VarA;
        String strA = oa.a(this);
        this.D = strA;
        this.K = new a();
        b bVar = new b();
        this.L = nativeAdResponse.c();
        this.M = nativeMediaContentFactory.a();
        impressionManagerCreator.getClass();
        nk0 nk0VarA = ok0.a(context, l51VarA, impressionReporter, adIdStorageManager, impressionEventsObservable);
        List<xx1> listE = nativeVisualBlock.e();
        nk0VarA.a(listE, nativeVisualBlock.c());
        i3 i3Var = new i3(context, sdkEnvironmentModule, adResponse, adConfiguration, l51VarA, targetUrlHandlerProvider);
        this.G = i3Var;
        this.H = new zo(i3Var, renderedTimer, impressionEventsObservable);
        a31 a31VarA = noticeTrackingManagerProvider.a(context, adConfiguration, impressionReporter, bVar, strA, adStructureType);
        this.E = a31VarA;
        forceImpressionConfigurator.a(impressionEventsObservable);
        impressionEventsObservable.a(new md1(a31VarA));
        h62 h62VarA = nativeAdFactoriesProvider.e().a(a31VarA, new mo1(context, adRenderingValidator, adResponse, adConfiguration, adStructureType, adIdStorageManager, impressionEventsObservable, renderedTimer, nativeVisualBlock.d()), new yk0(nativeAdValidator, listE), phoneStateTracker);
        this.F = h62VarA;
        h62VarA.a(impressionEventsObservable);
        h62VarA.a((o8<?>) adResponse, listE);
        this.I = new og(assets, i3Var, renderedTimer, impressionEventsObservable, c41Var != null ? c41Var.e() : null);
    }

    public final bc1 g() {
        return this.e;
    }

    protected final o8<?> e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public vt getNativeAdVideoController() {
        return this.l;
    }

    public final void a(View nativeAdView, pj0 imageProvider, n71 nativeAdWeakViewHolder, bp clickListenerFactory) throws a61 {
        Intrinsics.checkNotNullParameter(nativeAdView, "nativeAdView");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(nativeAdWeakViewHolder, "nativeAdWeakViewHolder");
        Intrinsics.checkNotNullParameter(clickListenerFactory, "clickListenerFactory");
        v81 v81VarA = this.p.a(nativeAdView);
        if (Intrinsics.areEqual(this, v81VarA)) {
            return;
        }
        if (v81VarA != null) {
            v81VarA.h();
        }
        if (this.p.a(this)) {
            h();
        }
        this.p.a(nativeAdView, this);
        a(new c71(nativeAdWeakViewHolder, this.g, imageProvider, this.n, clickListenerFactory, this.f, this.r, this.M, this.k, this.h, this.e, this.b, this.q, this.j));
        this.A.a(nativeAdView, new w81(this));
    }

    public final List<y20> c() {
        return this.L;
    }

    public final j91 b() {
        return this.M;
    }

    public final void destroy() {
        c71 c71Var = this.J;
        if (c71Var != null) {
            c71Var.b();
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    public final void i() {
        boolean z;
        View viewE;
        c71 c71Var = this.J;
        if (c71Var != null && (viewE = c71Var.e()) != null) {
            z = viewE.isAttachedToWindow();
        }
        String str = "registerTrackers(), attachedToWindow = " + z + " clazz = " + this.D;
        op0.d(new Object[0]);
        if (z) {
            this.F.a(this.f10458a, this.K, this.J);
        }
    }

    public final void j() {
        String str = "unregisterTrackers(), clazz = " + this.D;
        op0.d(new Object[0]);
        this.F.a(this.f10458a, this.K);
    }

    public final void h() {
        j();
        this.A.a(this.f10458a);
        c71 c71Var = this.J;
        if (c71Var != null) {
            this.c.a(c71Var);
            this.F.a(c71Var);
            this.z.a(null);
        }
    }

    private final class a implements ch1.b {
        @Override // com.yandex.mobile.ads.impl.ch1.b
        public final void a(zg1 phoneState) {
            Intrinsics.checkNotNullParameter(phoneState, "phoneState");
            boolean z = !v81.this.f().b();
            String str = "onPhoneStateChanged(), phoneState = " + phoneState + ", viewShown = " + z + ", clazz = " + a.class;
            op0.d(new Object[0]);
            v81.this.E.a(phoneState, z);
        }

        public a() {
        }
    }

    private final class b implements c62 {
        public b() {
        }

        @Override // com.yandex.mobile.ads.impl.c62
        public final f92 b(int i) {
            return v81.this.f().a(v81.this.f10458a, i);
        }

        @Override // com.yandex.mobile.ads.impl.c62
        public final f92 a(int i) {
            return v81.this.f().b(v81.this.f10458a, i);
        }
    }

    private final void a(c71 viewAdapter) throws a61 {
        viewAdapter.a();
        this.x.a();
        this.o.getClass();
        Intrinsics.checkNotNullParameter(viewAdapter, "viewAdapter");
        Map<String, jg<?>> mapC = viewAdapter.c();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, jg<?>> entry : mapC.entrySet()) {
            jg<?> value = entry.getValue();
            if (value != null && value.b()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        this.w.a(arrayList, hp1.b.H);
        ArrayList arrayListA = this.y.a(viewAdapter);
        if (!arrayListA.isEmpty()) {
            this.v.a(arrayListA);
        }
        this.J = viewAdapter;
        this.z.a(viewAdapter);
        this.d.a(viewAdapter);
        jq1 jq1VarA = this.d.a();
        if (jq1VarA.a()) {
            this.c.a(viewAdapter);
            b(viewAdapter);
        } else {
            String strB = jq1VarA.b();
            this.u.a(strB);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            throw new a61(z0.a(new Object[0], 0, "Resource for required view " + strB + " is not present", "format(...)"));
        }
    }

    private final void b(c71 c71Var) throws a61 {
        this.c.a(c71Var, this.H);
        boolean z = Intrinsics.areEqual(this.h.E(), y81.c.a()) || Intrinsics.areEqual(this.h.E(), y81.d.a());
        if (this.B.a() && !z) {
            loadImages();
        }
        this.w.a(this.t.a(c71Var), hp1.b.I);
        String str = "renderAdView(), BIND, clazz = " + this.D;
        op0.d(new Object[0]);
        i();
    }

    public final u61 a() {
        return this.i;
    }

    public final void a(com.yandex.mobile.ads.nativeads.c cVar) {
        this.m.a(cVar);
    }

    public void a(pt ptVar) {
        this.C.a(ptVar);
    }

    public final void a(t71 reportParameterManager) {
        Intrinsics.checkNotNullParameter(reportParameterManager, "reportParameterManager");
        this.G.a(reportParameterManager);
        this.s.a(reportParameterManager);
        this.C.a(reportParameterManager);
        this.F.a(new q91(reportParameterManager, this.z));
        this.u.a(reportParameterManager);
        this.v.a(reportParameterManager);
        this.w.a(reportParameterManager);
        this.x.a(reportParameterManager);
    }
}
