package com.ogury.ad.internal;

import android.content.Context;
import android.os.Build;
import com.ogury.core.internal.InternalCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f7454a;
    public final z b;
    public final m1 c;
    public final d8 d;

    public y7(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        b0 b0Var = new b0(context);
        z zVar = new z(context);
        m1 m1Var = new m1(context);
        d8 d8Var = new d8(context, i7.NONE);
        this.f7454a = b0Var;
        this.b = zVar;
        this.c = m1Var;
        this.d = d8Var;
    }

    public final c8 a() {
        String str;
        b0 app = this.f7454a;
        d8 permissionsHandler = this.d;
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
        d0 app2 = new d0(strB, packageName, str, null);
        m8 sdk = new m8("5.0.1");
        z androidDevice = this.b;
        d8 permissionsHandler2 = this.d;
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        Intrinsics.checkNotNullParameter(permissionsHandler2, "permissionsHandler");
        androidDevice.getClass();
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        o1 device = new o1("android", RELEASE, null, null, null, null, null, null, null);
        m1 coreWrapper = this.c;
        Intrinsics.checkNotNullParameter(coreWrapper, "coreWrapper");
        q7 privacyCompliance = new q7(InternalCore.retrieveTcfConsentString(coreWrapper.f7352a), InternalCore.retrieveGppConsentString(coreWrapper.f7352a), InternalCore.retrieveGppSectionIdsString(coreWrapper.f7352a), InternalCore.getAllPublisherData(coreWrapper.f7352a), null, null);
        Intrinsics.checkNotNullParameter(this.b, "androidDevice");
        Intrinsics.checkNotNullParameter(app2, "app");
        Intrinsics.checkNotNullParameter(sdk, "sdk");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(privacyCompliance, "privacyCompliance");
        return new c8(null, null, app2, sdk, device, privacyCompliance, null, null, null);
    }
}
