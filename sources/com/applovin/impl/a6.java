package com.applovin.impl;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.facebook.internal.AnalyticsEvents;
import com.json.b9;
import com.json.mediationsdk.utils.IronSourceConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
public class a6 extends g5 {
    private final com.applovin.impl.sdk.k g;

    public a6(com.applovin.impl.sdk.k kVar) {
        super("TaskInitializeSdk", kVar, true);
        this.g = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.g.S().a(this.g.e().b());
    }

    private void f() {
        if (this.g.S().c()) {
            return;
        }
        Activity activityV0 = this.g.v0();
        if (activityV0 != null) {
            this.g.S().a(activityV0);
        } else {
            this.g.E().a(c2.p0, this.b + ":maybeInitializeAdapters()");
            this.g.r0().a(new p6(this.g, true, "initializeAdapters", new Runnable() { // from class: com.applovin.impl.a6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.e();
                }
            }), b6.b.CORE, TimeUnit.SECONDS.toMillis(1L));
        }
    }

    private void g() {
        String str;
        boolean zC = this.g.p0().c();
        Map mapO = this.g.B().o();
        Map mapK = this.g.B().K();
        String strA = zC ? this.g.B().f().a() : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        String str2 = zC ? mapO.get("idfv") + " (use this for test devices)" : "<Enable verbose logging to see the App Set ID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        s2 s2Var = new s2();
        s2Var.a().a("=====AppLovin SDK=====");
        s2Var.a("===SDK Versions===").a("Version", AppLovinSdk.VERSION).a("Plugin Version", this.g.a(v4.I3)).a("Ad Review Version", j.b()).a("OM SDK Version", this.g.e0().c());
        s2Var.a("===Device Info===").a(com.moloco.sdk.acm.b.d, k7.d()).a(IronSourceConstants.TYPE_GAID, strA).a("App Set ID", str2).a(ExifInterface.TAG_MODEL, mapO.get("model")).a("Locale", mapO.get(CommonUrlParts.LOCALE)).a("Emulator", mapO.get("sim")).a("Tablet", mapO.get("is_tablet"));
        s2Var.a("===App Info===").a("Application ID", mapK.get("package_name")).a("Target SDK", mapK.get("target_sdk"));
        s2Var.a("===SDK Settings===").a("SDK Key", this.g.j0()).a("Mediation Provider", this.g.V()).a("TG", j7.a(this.g)).a("MD", this.g.a(v4.t)).a("Test Mode On", Boolean.valueOf(this.g.t0().c())).a("Verbose Logging On", Boolean.valueOf(zC));
        s2Var.a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").a(p0.a(a()));
        s2Var.a("===MAX Terms and Privcay Policy Flow===");
        t0 t0VarY = this.g.y();
        boolean zJ = t0VarY.j();
        s2Var.a("Enabled", Boolean.valueOf(zJ));
        if (zJ) {
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.g.w().getConsentFlowUserGeography();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyD = t0VarY.d();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography2 = AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
            String str3 = "Other";
            if (consentFlowUserGeography == consentFlowUserGeography2) {
                str = "GDPR";
            } else {
                str = consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            s2Var.a("Consent Flow Geography", str);
            if (k7.c(this.g)) {
                if (consentFlowUserGeographyD == consentFlowUserGeography2) {
                    str3 = "GDPR";
                } else if (consentFlowUserGeography != AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER) {
                    str3 = "None";
                }
                s2Var.a("Debug User Geography", str3);
            }
        }
        s2Var.a("Privacy Policy URI", t0VarY.f()).a("Terms of Service URI", t0VarY.h());
        s2Var.a("===CMP (CONSENT MANAGEMENT PLATFORM)===").a(this.g.s0().i());
        s2Var.a();
        com.applovin.impl.sdk.o.g("AppLovinSdk", s2Var.toString());
    }

    @Override // java.lang.Runnable
    public void run() {
        com.applovin.impl.sdk.o oVar;
        String str;
        StringBuilder sbAppend;
        String str2 = AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Initializing AppLovin SDK v" + AppLovinSdk.VERSION + APSSharedUtil.TRUNCATE_SEPARATOR);
        }
        try {
            this.g.H().b(a());
            this.g.H().e(a());
            this.g.r0().a((g5) new h5(this.g), b6.b.OTHER);
            this.g.B().U();
            this.g.m0().c();
            this.g.z().l();
            if (k7.c(this.g)) {
                this.g.a();
            }
            this.g.Z0();
            this.g.p().collectAppHubData();
            g();
            f();
            this.g.a(true);
            this.g.f0().b();
            this.g.k().maybeFireAppKilledWhilePlayingAdPostback();
            if (((Boolean) this.g.a(v4.A2)).booleanValue()) {
                this.g.X().maybeFireAppKilledWhilePlayingMediatedAdPostback();
            }
            this.g.G().maybeTrackAppOpenEvent();
            this.g.A().a();
            if (((Boolean) this.g.a(v4.N2)).booleanValue()) {
                this.g.y0().b();
            }
            if (((Boolean) this.g.a(v4.W0)).booleanValue()) {
                this.g.h().b();
            } else {
                this.g.h().g();
            }
            if (this.g.U().g() || (((Boolean) this.g.a(o3.l7)).booleanValue() && k7.c(this.g) && this.g.H0())) {
                this.g.U().e();
            }
            if (this.g.h0() != null) {
                this.g.h0().b((String) this.g.a(v4.u));
            }
            this.g.e0().i();
            if (com.applovin.impl.sdk.o.a()) {
                oVar = this.c;
                str = this.b;
                sbAppend = new StringBuilder().append("AppLovin SDK ").append(AppLovinSdk.VERSION).append(" initialization ");
                if (!this.g.C0()) {
                    str2 = b9.h.t;
                }
                oVar.a(str, sbAppend.append(str2).append(" in ").append(System.currentTimeMillis() - jCurrentTimeMillis).append("ms").toString());
            }
        } catch (Throwable th) {
            try {
                com.applovin.impl.sdk.o.c("AppLovinSdk", "Failed to initialize SDK!", th);
                this.g.a(false);
                a(th);
                if (((Boolean) this.g.a(v4.i)).booleanValue()) {
                    this.g.f0().a();
                }
                if (((Boolean) this.g.a(v4.h)).booleanValue()) {
                    this.g.V0();
                }
                if (this.g.h0() != null) {
                    this.g.h0().b((String) this.g.a(v4.u));
                }
                this.g.e0().i();
                if (!com.applovin.impl.sdk.o.a()) {
                    return;
                }
                oVar = this.c;
                str = this.b;
                sbAppend = new StringBuilder().append("AppLovin SDK ").append(AppLovinSdk.VERSION).append(" initialization ");
                if (!this.g.C0()) {
                }
            } catch (Throwable th2) {
                if (this.g.h0() != null) {
                    this.g.h0().b((String) this.g.a(v4.u));
                }
                this.g.e0().i();
                if (com.applovin.impl.sdk.o.a()) {
                    com.applovin.impl.sdk.o oVar2 = this.c;
                    String str3 = this.b;
                    StringBuilder sbAppend2 = new StringBuilder("AppLovin SDK ").append(AppLovinSdk.VERSION).append(" initialization ");
                    if (!this.g.C0()) {
                        str2 = b9.h.t;
                    }
                    oVar2.a(str3, sbAppend2.append(str2).append(" in ").append(System.currentTimeMillis() - jCurrentTimeMillis).append("ms").toString());
                }
                throw th2;
            }
        }
    }
}
