package com.yandex.mobile.ads.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
final class kr implements jr {
    private static final a e = new a(0);
    private static final Object f = new Object();
    private final ls0 b;
    private final d60 c;
    private final u6 d;

    private static final class a {
        public static final Boolean a(a aVar, ls0 ls0Var, String str) {
            if (!ls0Var.c(str)) {
                ls0Var = null;
            }
            if (ls0Var != null) {
                return Boolean.valueOf(ls0Var.a(str, false));
            }
            return null;
        }

        public static final Integer b(a aVar, ls0 ls0Var, String str) {
            if (!ls0Var.c(str)) {
                ls0Var = null;
            }
            if (ls0Var != null) {
                return Integer.valueOf(ls0Var.b(0, str));
            }
            return null;
        }

        public static final Long c(a aVar, ls0 ls0Var, String str) {
            if (!ls0Var.c(str)) {
                ls0Var = null;
            }
            if (ls0Var != null) {
                return Long.valueOf(ls0Var.b(str));
            }
            return null;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v71 com.yandex.mobile.ads.impl.kr$b[], still in use, count: 1, list:
  (r0v71 com.yandex.mobile.ads.impl.kr$b[]) from 0x04bb: INVOKE (r0v71 com.yandex.mobile.ads.impl.kr$b[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    private static final class b {
        c("SdkConfigurationExpiredDate"),
        d("SdkConfigurationMraidUrl"),
        e("SdkConfigurationOmSdkControllerUrl"),
        f("CustomClickHandlingEnabled"),
        g("AdIdsStorageSize"),
        h("SdkConfigurationAdBlockerStatusValidityDuration"),
        i("SdkConfigurationAntiAdBlockerDisabled"),
        j("SdkConfigurationVisibilityErrorIndicatorEnabled"),
        k("SdkConfigurationLibraryVersion"),
        l("SdkConfigurationMediationSensitiveModeDisabled"),
        m("SdkConfigurationSensitiveModeDisabled"),
        n("SdkConfigurationFusedLocationProviderDisabled"),
        o("SdkConfigurationLockScreenEnabled"),
        p("SdkConfigurationAutograbEnabled"),
        q("SdkConfigurationUserConsent"),
        r("SdkConfigurationLegacyVisibilityLogicEnabled"),
        s("SdkConfigurationLegacyVastTrackingEnabled"),
        t("SdkConfigurationOverlappingVisibilityTrackingEnabled"),
        u("SdkConfigurationOverlappingWindowTrackingEnabled"),
        v("SdkConfigurationAdRequestMaxRetries"),
        w("SdkConfigurationPingRequestMaxRetries"),
        x("SdkConfigurationImpressionValidationOnClickEnabled"),
        y("SdkConfigurationLegacySliderImpressionEnabled"),
        z("SdkConfigurationShowVersionValidationErrorLog"),
        A("SdkConfigurationShowVersionValidationErrorIndicator"),
        B("SdkConfigurationInstreamDesign"),
        C("SdkConfigurationFullScreenBackButtonEnabled"),
        D("SdkConfigurationOpenMeasurementSdkDisabled"),
        E("SdkConfigurationMultibannerArrowControlsDisabled"),
        F("SdkConfigurationNativeWebViewPoolSize"),
        G("SdkConfigurationMaxDiskCacheSizeBytesForVideo"),
        H("SdkConfigurationMaxDiskCacheSizeBytesForRequestQueue"),
        I("SdkConfigurationPublicEncryptionKey"),
        J("SdkConfigurationPublicEncryptionVersion"),
        K("SdkConfigurationEcpmImpressionCallbackDisabled"),
        L("SdkConfigurationCloseFullscreenWithAdtuneDisabled"),
        M("SdkConfigurationDivkitisabled"),
        N("SdkConfigurationUseOkHttpNetworkStack"),
        O("SdkConfigurationLocationConsent"),
        P("SdkConfigurationLibSSLEnabled"),
        Q("SdkConfigurationEncryptedRequestsEnabled"),
        R("SdkConfigurationRenderAssetValidationEnabled"),
        S("SdkConfigurationClickHandlerType"),
        T("SdkConfigurationHardSensitiveModeEnabled"),
        U("SdkConfigurationAgeRestrictedUser"),
        V("SdkConfigurationHost"),
        W("DivkitFont"),
        X("SdkConfigurationAutomaticSdkInitializationDelayEnabled"),
        Y("NativeBannerEnabled"),
        /* JADX INFO: Fake field, exist only in values array */
        EF0("UseNewBindingApiForDivkit"),
        Z("UseDivkitCloseActionInsteadSystemClick"),
        a0("BannerSizeCalculationType"),
        b0("StartupVersion"),
        c0("AppOpenAdPreloadingEnabled"),
        d0("InterstitialPreloadingEnabled"),
        e0("RewardedPreloadingEnabled"),
        f0("NewFalseClickTrackingEnabled"),
        g0("VarioqubEnabled"),
        h0("AabHttpCheckDisabled"),
        i0("AabHttpCheckFailedRequestsCount"),
        j0("CrashTrackerEnabled"),
        k0("ErrorTrackerEnabled"),
        l0("AnrTrackerEnabled"),
        m0("AnrTrackerInterval"),
        n0("AnrTrackerThreshold"),
        o0("CrashIgnoreEnabled"),
        p0("CrashStackTraceExclusionRules"),
        q0("TimeStampingTrackingUrlsEnabled"),
        r0("AppAdAnalyticsReportingEnabled"),
        s0("AppMetricaEasyIntegrationAutoActivationDisabled"),
        t0("SdkConfigurationNetworkThreadPoolSize"),
        u0("SdkConfigurationImageLoadingThreadPoolSize"),
        v0("SdkConfigurationTimeoutIntervalForRequest"),
        w0("SdkConfigurationTimeoutIntervalForPingRequest"),
        x0("QualityAdVerificationConfiguration"),
        y0("SdkTrackingReporterEnabled"),
        z0("SdkConfigurationFallbackHosts"),
        A0("ShouldPrefetchDns"),
        B0("ShouldUseAdRenderedWebViewCallback"),
        C0("VpnCheckingEnabled"),
        D0("OutstreamWrapperVideoSupported");

        private final String b;

        static {
            EnumEntriesKt.enumEntries(bVarArr);
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) E0.clone();
        }

        private b(String str) {
            super(str, i);
            this.b = str;
        }

        public final String a() {
            return this.b;
        }
    }

    public kr(ls0 localStorage, d60 exclusionRulesJsonConverter, u6 adVerificationConfigurationJsonConverter) {
        Intrinsics.checkNotNullParameter(localStorage, "localStorage");
        Intrinsics.checkNotNullParameter(exclusionRulesJsonConverter, "exclusionRulesJsonConverter");
        Intrinsics.checkNotNullParameter(adVerificationConfigurationJsonConverter, "adVerificationConfigurationJsonConverter");
        this.b = localStorage;
        this.c = exclusionRulesJsonConverter;
        this.d = adVerificationConfigurationJsonConverter;
    }

    @Override // com.yandex.mobile.ads.impl.jr
    public final cu1 a() {
        cu1 cu1VarA;
        Set<b60> setA;
        b7 b7VarA;
        List<String> listSplit$default;
        synchronized (f) {
            long jB = this.b.b(b.c.a());
            a aVar = e;
            Boolean boolA = a.a(aVar, this.b, b.j.a());
            if (jB != 0) {
                Integer numB = a.b(aVar, this.b, b.v.a());
                Integer numB2 = a.b(aVar, this.b, b.w.a());
                Long lC = a.c(aVar, this.b, b.h.a());
                boolean zA = this.b.a(b.i.a(), false);
                int iB = this.b.b(0, b.g.a());
                int iB2 = this.b.b(0, b.F.a());
                long jB2 = this.b.b(b.G.a());
                long jB3 = this.b.b(b.H.a());
                Boolean boolA2 = a.a(aVar, this.b, b.l.a());
                boolean zA2 = this.b.a(b.n.a(), false);
                boolean zA3 = this.b.a(b.o.a(), false);
                boolean zA4 = this.b.a(b.p.a(), false);
                Boolean boolA3 = a.a(aVar, this.b, b.q.a());
                String strD = this.b.d(b.k.a());
                String strD2 = this.b.d(b.V.a());
                String strD3 = this.b.d(b.W.a());
                String strD4 = this.b.d(b.S.a());
                String strD5 = this.b.d(b.d.a());
                String strD6 = this.b.d(b.e.a());
                boolean zA5 = this.b.a(b.f.a(), false);
                boolean zA6 = this.b.a(b.m.a(), false);
                boolean zA7 = this.b.a(b.T.a(), false);
                boolean zA8 = this.b.a(b.s.a(), false);
                boolean zA9 = this.b.a(b.r.a(), false);
                boolean zA10 = this.b.a(b.t.a(), false);
                boolean zA11 = this.b.a(b.u.a(), false);
                boolean zA12 = this.b.a(b.z.a(), false);
                boolean zA13 = this.b.a(b.A.a(), false);
                boolean zA14 = this.b.a(b.x.a(), false);
                boolean zA15 = this.b.a(b.y.a(), false);
                boolean zA16 = this.b.a(b.C.a(), false);
                boolean zA17 = this.b.a(b.D.a(), false);
                boolean zA18 = this.b.a(b.O.a(), false);
                boolean zA19 = this.b.a(b.E.a(), false);
                int i = gl.b;
                el elVarA = gl.a(this.b);
                String strD7 = this.b.d(b.I.a());
                String strD8 = this.b.d(b.B.a());
                Integer numB3 = a.b(aVar, this.b, b.J.a());
                boolean zA20 = this.b.a(b.K.a(), false);
                boolean zA21 = this.b.a(b.M.a(), false);
                boolean zA22 = this.b.a(b.N.a(), false);
                boolean zA23 = this.b.a(b.P.a(), false);
                boolean zA24 = this.b.a(b.L.a(), false);
                boolean zA25 = this.b.a(b.Q.a(), false);
                boolean zA26 = this.b.a(b.R.a(), false);
                boolean zA27 = this.b.a(b.X.a(), false);
                Boolean boolA4 = a.a(aVar, this.b, b.U.a());
                boolean zA28 = this.b.a(b.Y.a(), false);
                boolean zA29 = this.b.a(b.Z.a(), false);
                String strD9 = this.b.d(b.a0.a());
                String strD10 = this.b.d(b.b0.a());
                boolean zA30 = this.b.a(b.c0.a(), false);
                boolean zA31 = this.b.a(b.d0.a(), false);
                boolean zA32 = this.b.a(b.e0.a(), false);
                boolean zA33 = this.b.a(b.f0.a(), false);
                boolean zA34 = this.b.a(b.g0.a(), false);
                boolean zA35 = this.b.a(b.h0.a(), false);
                Integer numB4 = a.b(aVar, this.b, b.i0.a());
                boolean zA36 = this.b.a(b.j0.a(), false);
                boolean zA37 = this.b.a(b.k0.a(), false);
                boolean zA38 = this.b.a(b.l0.a(), false);
                Long lC2 = a.c(aVar, this.b, b.m0.a());
                Long lC3 = a.c(aVar, this.b, b.n0.a());
                boolean zA39 = this.b.a(b.o0.a(), false);
                String strD11 = this.b.d(b.p0.a());
                if (strD11 != null) {
                    this.c.getClass();
                    setA = d60.a(strD11);
                } else {
                    setA = null;
                }
                Set<b60> set = setA;
                boolean zA40 = this.b.a(b.q0.a(), false);
                boolean zA41 = this.b.a(b.r0.a(), true);
                boolean zA42 = this.b.a(b.s0.a(), false);
                Integer numB5 = a.b(aVar, this.b, b.t0.a());
                Integer numB6 = a.b(aVar, this.b, b.u0.a());
                Integer numB7 = a.b(aVar, this.b, b.v0.a());
                Integer numB8 = a.b(aVar, this.b, b.w0.a());
                String strD12 = this.b.d(b.x0.a());
                if (strD12 != null) {
                    this.d.getClass();
                    b7VarA = u6.a(strD12);
                } else {
                    b7VarA = null;
                }
                b7 b7Var = b7VarA;
                boolean zA43 = this.b.a(b.y0.a(), false);
                ls0 ls0Var = this.b;
                String key = b.z0.a();
                Intrinsics.checkNotNullParameter(ls0Var, "<this>");
                Intrinsics.checkNotNullParameter(key, "key");
                String strD13 = ls0Var.d(key);
                List<String> listEmptyList = (strD13 == null || (listSplit$default = StringsKt.split$default((CharSequence) strD13, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null)) == null) ? null : listSplit$default;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                cu1.a aVarF = new cu1.a().h(strD).c(boolA3).a(jB).b(numB).e(numB2).a(lC).c(zA).a(iB).b(iB2).c(jB2).b(jB3).b(boolA2).r(zA2).A(zA3).g(zA4).L(zA6).s(zA7).f(strD5).g(strD6).l(zA5).d(boolA).w(zA8).x(zA9).G(zA10).H(zA11).O(zA12).N(zA13).t(zA14).i(zA24).v(zA15).e(strD8).q(zA16).a(elVarA).n(zA20).m(zA21).B(zA19).S(zA22).E(zA17).z(zA18).a(boolA4).y(zA23).o(zA25).a(strD2).d(strD3).I(zA26).c(strD4).h(zA27).C(zA28).R(zA29).b(strD9).i(strD10).f(zA30).u(zA31).J(zA32).D(zA33).T(zA34).a(zA35).a(numB4).k(zA36).p(zA37).b(zA38).b(lC2).c(lC3).j(zA39).a(set).Q(zA40).d(zA41).e(zA42).d(numB5).c(numB6).g(numB7).f(numB8).a(b7Var).K(zA43).a(listEmptyList).M(this.b.a(b.A0.a(), false)).P(this.b.a(b.B0.a(), false)).U(this.b.a(b.C0.a(), false)).F(this.b.a(b.D0.a(), false));
                if (strD7 != null && numB3 != null) {
                    aVarF.a(new i50(numB3.intValue(), strD7));
                }
                cu1VarA = aVarF.a();
            } else {
                cu1VarA = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        return cu1VarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v2, types: [com.yandex.mobile.ads.impl.kr$b] */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.jr
    public final void a(cu1 sdkConfiguration) throws Throwable {
        Intrinsics.checkNotNullParameter(sdkConfiguration, "sdkConfiguration");
        ?? r3 = f;
        synchronized (r3) {
            try {
                this.b.a(b.k.a(), sdkConfiguration.J());
                this.b.a(b.S.a(), sdkConfiguration.o());
                this.b.b(b.m.a(), sdkConfiguration.w0());
                this.b.b(b.T.a(), sdkConfiguration.e0());
                this.b.a(b.c.a(), sdkConfiguration.w());
                this.b.a(b.d.a(), sdkConfiguration.C());
                this.b.a(b.e.a(), sdkConfiguration.F());
                this.b.a(b.B.a(), sdkConfiguration.z());
                this.b.b(b.f.a(), sdkConfiguration.s());
                this.b.b(b.z.a(), sdkConfiguration.M());
                this.b.b(b.A.a(), sdkConfiguration.L());
                this.b.a(sdkConfiguration.e(), b.g.a());
                this.b.b(b.x.a(), sdkConfiguration.f0());
                this.b.b(b.y.a(), sdkConfiguration.h0());
                this.b.b(b.K.a(), sdkConfiguration.a0());
                this.b.b(b.M.a(), sdkConfiguration.Z());
                ls0 ls0Var = this.b;
                b bVar = b.L;
                ls0Var.b(bVar.a(), sdkConfiguration.Y());
                this.b.b(b.N.a(), sdkConfiguration.y0());
                this.b.b(b.O.a(), sdkConfiguration.l0());
                this.b.b(b.P.a(), sdkConfiguration.k0());
                this.b.b(b.Q.a(), sdkConfiguration.b0());
                ls0 ls0Var2 = this.b;
                b bVar2 = b.R;
                ls0Var2.b(bVar2.a(), sdkConfiguration.u0());
                this.b.a(sdkConfiguration.D(), b.F.a());
                this.b.a(b.G.a(), sdkConfiguration.B());
                this.b.a(b.H.a(), sdkConfiguration.A());
                this.b.a(b.V.a(), sdkConfiguration.d());
                this.b.a(b.W.a(), sdkConfiguration.t());
                this.b.a(b.a0.a(), sdkConfiguration.m());
                Long lC = sdkConfiguration.c();
                boolean zU = sdkConfiguration.U();
                Boolean boolB0 = sdkConfiguration.B0();
                Boolean boolN0 = sdkConfiguration.n0();
                boolean zD0 = sdkConfiguration.d0();
                boolean zM0 = sdkConfiguration.m0();
                boolean zW = sdkConfiguration.W();
                Boolean boolZ0 = sdkConfiguration.z0();
                boolean zI0 = sdkConfiguration.i0();
                boolean zJ0 = sdkConfiguration.j0();
                boolean zS0 = sdkConfiguration.s0();
                boolean zT0 = sdkConfiguration.t0();
                boolean zC0 = sdkConfiguration.c0();
                boolean zR0 = sdkConfiguration.r0();
                boolean zO0 = sdkConfiguration.o0();
                Integer numG = sdkConfiguration.g();
                Integer numH = sdkConfiguration.H();
                el elVarN = sdkConfiguration.n();
                boolean zY = sdkConfiguration.Y();
                boolean zU0 = sdkConfiguration.u0();
                Boolean boolT = sdkConfiguration.T();
                boolean zX = sdkConfiguration.X();
                boolean zP0 = sdkConfiguration.p0();
                boolean zX0 = sdkConfiguration.x0();
                ls0 ls0Var3 = this.b;
                r3 = b.h;
                String strA = r3.a();
                try {
                    if (lC != null) {
                        ls0Var3.a(strA, lC.longValue());
                    } else {
                        ls0Var3.a(strA);
                    }
                    this.b.b(b.i.a(), zU);
                    ls0 ls0Var4 = this.b;
                    String strA2 = b.j.a();
                    if (boolB0 != null) {
                        ls0Var4.b(strA2, boolB0.booleanValue());
                    } else {
                        ls0Var4.a(strA2);
                    }
                    ls0 ls0Var5 = this.b;
                    String strA3 = b.l.a();
                    if (boolN0 != null) {
                        ls0Var5.b(strA3, boolN0.booleanValue());
                    } else {
                        ls0Var5.a(strA3);
                    }
                    this.b.b(b.n.a(), zD0);
                    this.b.b(b.o.a(), zM0);
                    this.b.b(b.p.a(), zW);
                    ls0 ls0Var6 = this.b;
                    String strA4 = b.q.a();
                    if (boolZ0 != null) {
                        ls0Var6.b(strA4, boolZ0.booleanValue());
                    } else {
                        ls0Var6.a(strA4);
                    }
                    this.b.b(b.s.a(), zI0);
                    this.b.b(b.r.a(), zJ0);
                    this.b.b(b.t.a(), zS0);
                    this.b.b(b.u.a(), zT0);
                    this.b.b(bVar.a(), zY);
                    this.b.b(b.C.a(), zC0);
                    this.b.b(b.D.a(), zR0);
                    this.b.b(b.E.a(), zO0);
                    ls0 ls0Var7 = this.b;
                    String strA5 = b.U.a();
                    if (boolT != null) {
                        ls0Var7.b(strA5, boolT.booleanValue());
                    } else {
                        ls0Var7.a(strA5);
                    }
                    this.b.b(b.X.a(), zX);
                    ls0 ls0Var8 = this.b;
                    String strA6 = b.v.a();
                    if (numG != null) {
                        ls0Var8.a(numG.intValue(), strA6);
                    } else {
                        ls0Var8.a(strA6);
                    }
                    ls0 ls0Var9 = this.b;
                    String strA7 = b.w.a();
                    if (numH != null) {
                        ls0Var9.a(numH.intValue(), strA7);
                    } else {
                        ls0Var9.a(strA7);
                    }
                    if (elVarN != null) {
                        int i = gl.b;
                        gl.a(this.b, elVarN);
                    } else {
                        int i2 = gl.b;
                        gl.b(this.b);
                    }
                    i50 i50VarU = sdkConfiguration.u();
                    if (i50VarU != null) {
                        this.b.a(b.I.a(), i50VarU.d());
                        this.b.a(i50VarU.e(), b.J.a());
                    }
                    this.b.b(bVar2.a(), zU0);
                    this.b.b(b.Y.a(), zP0);
                    this.b.b(b.Z.a(), zX0);
                    this.b.a(b.b0.a(), sdkConfiguration.O());
                    this.b.b(b.c0.a(), sdkConfiguration.V());
                    this.b.b(b.d0.a(), sdkConfiguration.g0());
                    this.b.b(b.e0.a(), sdkConfiguration.v0());
                    this.b.b(b.f0.a(), sdkConfiguration.q0());
                    this.b.b(b.g0.a(), sdkConfiguration.A0());
                    this.b.b(b.h0.a(), sdkConfiguration.a());
                    ls0 ls0Var10 = this.b;
                    String strA8 = b.i0.a();
                    Integer numB = sdkConfiguration.b();
                    if (numB != null) {
                        ls0Var10.a(numB.intValue(), strA8);
                    } else {
                        ls0Var10.a(strA8);
                    }
                    this.b.b(b.j0.a(), sdkConfiguration.r());
                    this.b.b(b.k0.a(), sdkConfiguration.v());
                    this.b.b(b.l0.a(), sdkConfiguration.h());
                    ls0 ls0Var11 = this.b;
                    String strA9 = b.m0.a();
                    Long lI = sdkConfiguration.i();
                    if (lI != null) {
                        ls0Var11.a(strA9, lI.longValue());
                    } else {
                        ls0Var11.a(strA9);
                    }
                    ls0 ls0Var12 = this.b;
                    String strA10 = b.n0.a();
                    Long lJ = sdkConfiguration.j();
                    if (lJ != null) {
                        ls0Var12.a(strA10, lJ.longValue());
                    } else {
                        ls0Var12.a(strA10);
                    }
                    this.b.b(b.o0.a(), sdkConfiguration.p());
                    ls0 ls0Var13 = this.b;
                    String strA11 = b.p0.a();
                    d60 d60Var = this.c;
                    Set<b60> setQ = sdkConfiguration.q();
                    d60Var.getClass();
                    ls0Var13.a(strA11, d60.a(setQ));
                    this.b.b(b.q0.a(), sdkConfiguration.P());
                    this.b.b(b.r0.a(), sdkConfiguration.k());
                    this.b.b(b.s0.a(), sdkConfiguration.l());
                    ls0 ls0Var14 = this.b;
                    String strA12 = b.t0.a();
                    Integer numE = sdkConfiguration.E();
                    if (numE != null) {
                        ls0Var14.a(numE.intValue(), strA12);
                    } else {
                        ls0Var14.a(strA12);
                    }
                    ls0 ls0Var15 = this.b;
                    String strA13 = b.u0.a();
                    Integer numY = sdkConfiguration.y();
                    if (numY != null) {
                        ls0Var15.a(numY.intValue(), strA13);
                    } else {
                        ls0Var15.a(strA13);
                    }
                    ls0 ls0Var16 = this.b;
                    String strA14 = b.v0.a();
                    Integer numR = sdkConfiguration.R();
                    if (numR != null) {
                        ls0Var16.a(numR.intValue(), strA14);
                    } else {
                        ls0Var16.a(strA14);
                    }
                    ls0 ls0Var17 = this.b;
                    String strA15 = b.w0.a();
                    Integer numQ = sdkConfiguration.Q();
                    if (numQ != null) {
                        ls0Var17.a(numQ.intValue(), strA15);
                    } else {
                        ls0Var17.a(strA15);
                    }
                    ls0 ls0Var18 = this.b;
                    String strA16 = b.x0.a();
                    u6 u6Var = this.d;
                    b7 b7VarF = sdkConfiguration.f();
                    u6Var.getClass();
                    ls0Var18.a(strA16, u6.a(b7VarF));
                    this.b.b(b.y0.a(), sdkConfiguration.I());
                    os0.a(this.b, b.z0.a(), sdkConfiguration.x());
                    this.b.b(b.A0.a(), sdkConfiguration.K());
                    this.b.b(b.B0.a(), sdkConfiguration.N());
                    this.b.b(b.C0.a(), sdkConfiguration.S());
                    this.b.b(b.D0.a(), sdkConfiguration.G());
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r3 = r3;
            }
        }
    }
}
