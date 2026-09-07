package com.ogury.ad.internal;

import android.content.Context;
import com.ogury.core.internal.InternalCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t7 f7425a;
    public final m1 b;
    public final b0 c;
    public final z d;
    public final e2 e;
    public final d8 f;
    public final g6 g;

    public w0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        t7 t7Var = t7.f7405a;
        m1 m1Var = new m1(context);
        b0 b0Var = new b0(context);
        z zVar = new z(context);
        e2 e2Var = e2.f7288a;
        d8 d8Var = new d8(context, i7.AD_SYNC);
        this.f7425a = t7Var;
        this.b = m1Var;
        this.c = b0Var;
        this.d = zVar;
        this.e = e2Var;
        this.f = d8Var;
        this.g = g6.f7306a;
    }

    public final c8 a(String campaignId, String creativeId, String dspCreativeId, String dspAwsRegion) {
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(campaignId, "campaignId");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        Intrinsics.checkNotNullParameter(dspCreativeId, "dspCreativeId");
        Intrinsics.checkNotNullParameter(dspAwsRegion, "dspAwsRegion");
        b0 app = this.c;
        d8 permissionsHandler = this.f;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(permissionsHandler, "permissionsHandler");
        String strB = app.b.b();
        String packageName = app.f7264a.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        Context context = app.f7264a;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = "";
        }
        d0 app2 = new d0(strB, packageName, str, permissionsHandler.i());
        m8 sdk = new m8("5.0.1");
        d8 permissionsHandler2 = this.f;
        Intrinsics.checkNotNullParameter(permissionsHandler2, "permissionsHandler");
        j8 screen = new j8(null, null, null, permissionsHandler2.g(), permissionsHandler2.j(), permissionsHandler2.r());
        d8 permissionsHandler3 = this.f;
        Intrinsics.checkNotNullParameter(permissionsHandler3, "permissionsHandler");
        o8 settings = new o8(permissionsHandler3.q(), null, permissionsHandler3.d(), null);
        d8 permissionsHandler4 = this.f;
        Intrinsics.checkNotNullParameter(permissionsHandler4, "permissionsHandler");
        z8 system = new z8(permissionsHandler4.b(), permissionsHandler4.h());
        z androidDevice = this.d;
        d8 permissionsHandler5 = this.f;
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        Intrinsics.checkNotNullParameter(permissionsHandler5, "permissionsHandler");
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(settings, "settings");
        Intrinsics.checkNotNullParameter(system, "system");
        o1 device = new o1(null, null, permissionsHandler5.e(), permissionsHandler5.f(), screen, settings, null, null, system);
        a9 targeting = new a9(this.e != null ? e2.a() : null);
        k adRequest = new k(null, campaignId, creativeId, null, new u1(dspCreativeId, dspAwsRegion));
        t7 profigGateway = this.f7425a;
        g6 omidSdkChecker = this.g;
        Intrinsics.checkNotNullParameter(profigGateway, "profigGateway");
        Intrinsics.checkNotNullParameter(omidSdkChecker, "omidSdkChecker");
        profigGateway.getClass();
        if (t7.b.f.f7470a) {
            omidSdkChecker.getClass();
            try {
                Class.forName("com.iab.omid.library.ogury.Omid");
                z = true;
            } catch (Exception unused2) {
                z = false;
            }
        } else {
            z = false;
        }
        e6 omidRequest = new e6(Boolean.valueOf(z));
        n.a aVar = new n.a();
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        aVar.c = adRequest;
        Intrinsics.checkNotNullParameter(omidRequest, "omidRequest");
        n adSync = new n(aVar.f7360a, aVar.b, aVar.c, aVar.d, omidRequest);
        m1 coreWrapper = this.b;
        e2 e2Var = this.e;
        Intrinsics.checkNotNullParameter(coreWrapper, "coreWrapper");
        q7 privacyCompliance = new q7(InternalCore.retrieveTcfConsentString(coreWrapper.f7352a), InternalCore.retrieveGppConsentString(coreWrapper.f7352a), InternalCore.retrieveGppSectionIdsString(coreWrapper.f7352a), InternalCore.getAllPublisherData(coreWrapper.f7352a), e2Var != null ? e2.a("IS_CHILD_UNDER_COPPA") : null, e2Var != null ? e2.a("IS_UNDER_AGE_OF_GDPR_CONSENT") : null);
        z androidDevice2 = this.d;
        Intrinsics.checkNotNullParameter(androidDevice2, "androidDevice");
        Intrinsics.checkNotNullParameter(app2, "app");
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(privacyCompliance, "privacyCompliance");
        Intrinsics.checkNotNullParameter(targeting, "targeting");
        Intrinsics.checkNotNullParameter(adSync, "adSync");
        return new c8(null, null, app2, sdk, device, privacyCompliance, targeting, adSync, null);
    }
}
