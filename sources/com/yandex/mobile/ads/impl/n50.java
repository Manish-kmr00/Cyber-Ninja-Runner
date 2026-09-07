package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
public final class n50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pw1 f9698a;
    private final dx1 b;
    private final g10 c;
    private final ts0 d;
    private final kc e;
    private final o50 f;
    private final jc g;
    private final l50 h;

    public final void a(Context context, Uri.Builder builder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        a(context, new a(builder));
    }

    public /* synthetic */ n50(Context context, o3 o3Var) {
        pw1 pw1Var = new pw1();
        dx1 dx1Var = new dx1();
        g10 g10Var = new g10(0);
        int i = ts0.h;
        this(context, o3Var, pw1Var, dx1Var, g10Var, ts0.a.a(context), new kc(), new p50());
    }

    public n50(Context context, o3 adConfiguration, pw1 sdkVersionFormatter, dx1 sensitiveModeChecker, g10 deviceInfoProvider, ts0 locationManager, kc advertisingIdValidator, o50 environmentParametersProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(sdkVersionFormatter, "sdkVersionFormatter");
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        Intrinsics.checkNotNullParameter(deviceInfoProvider, "deviceInfoProvider");
        Intrinsics.checkNotNullParameter(locationManager, "locationManager");
        Intrinsics.checkNotNullParameter(advertisingIdValidator, "advertisingIdValidator");
        Intrinsics.checkNotNullParameter(environmentParametersProvider, "environmentParametersProvider");
        this.f9698a = sdkVersionFormatter;
        this.b = sensitiveModeChecker;
        this.c = deviceInfoProvider;
        this.d = locationManager;
        this.e = advertisingIdValidator;
        this.f = environmentParametersProvider;
        this.g = adConfiguration.e();
        this.h = adConfiguration.k();
    }

    static final class a extends Lambda implements Function2<String, String, Unit> {
        final /* synthetic */ Uri.Builder c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Uri.Builder builder) {
            super(2);
            this.c = builder;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(String str, String str2) {
            String key = str;
            String str3 = str2;
            Intrinsics.checkNotNullParameter(key, "key");
            n50 n50Var = n50.this;
            Uri.Builder builder = this.c;
            n50Var.getClass();
            if (str3 != null && str3.length() != 0) {
                builder.appendQueryParameter(key, str3);
            }
            return Unit.INSTANCE;
        }
    }

    public final void a(Context context, bn1 queryParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(queryParams, "queryParams");
        a(context, new b(queryParams));
    }

    static final class b extends Lambda implements Function2<String, String, Unit> {
        final /* synthetic */ bn1 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(bn1 bn1Var) {
            super(2);
            this.b = bn1Var;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(String str, String str2) {
            String key = str;
            Intrinsics.checkNotNullParameter(key, "key");
            this.b.a(key, str2);
            return Unit.INSTANCE;
        }
    }

    private final void a(Context context, Function2<? super String, ? super String, Unit> function2) {
        Location locationC;
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        function2.invoke("app_id", packageName);
        function2.invoke("app_version_code", te.a(context));
        function2.invoke(CommonUrlParts.APP_VERSION, te.b(context));
        function2.invoke("sdk_version", this.f9698a.a());
        function2.invoke("sdk_version_name", this.f9698a.b());
        function2.invoke("sdk_vendor", "yandex");
        function2.invoke(this.f.f(), this.c.a(context));
        function2.invoke(CommonUrlParts.LOCALE, this.c.b(context));
        String strB = this.f.b();
        this.c.getClass();
        function2.invoke(strB, g10.a());
        String strC = this.f.c();
        this.c.getClass();
        function2.invoke(strC, Build.MODEL);
        String strA = this.f.a();
        this.c.getClass();
        function2.invoke(strA, "android");
        String strD = this.f.d();
        this.c.getClass();
        function2.invoke(strD, Build.VERSION.RELEASE);
        Boolean boolC = eh1.c(context);
        if (boolC != null) {
            function2.invoke("vpn_enabled", boolC.booleanValue() ? "1" : "0");
        }
        dx1 dx1Var = this.b;
        dx1Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (!dx1Var.b(context) && (locationC = this.d.c()) != null) {
            function2.invoke("location_timestamp", String.valueOf(locationC.getTime()));
            function2.invoke("lat", String.valueOf(locationC.getLatitude()));
            function2.invoke(POBConstants.KEY_LONGITUDE, String.valueOf(locationC.getLongitude()));
            function2.invoke("precision", String.valueOf(Math.round(locationC.getAccuracy())));
        }
        dx1 dx1Var2 = this.b;
        dx1Var2.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (dx1Var2.b(context)) {
            return;
        }
        function2.invoke(this.f.e(), this.h.b());
        lc lcVarA = this.g.a();
        if (lcVarA != null) {
            boolean zB = lcVarA.b();
            String strA2 = lcVarA.a();
            this.e.getClass();
            boolean z = (strA2 == null || strA2.length() == 0 || Intrinsics.areEqual("00000000-0000-0000-0000-000000000000", strA2)) ? false : true;
            if (!zB && z) {
                function2.invoke("google_aid", strA2);
            }
        }
        lc lcVarC = this.g.c();
        if (lcVarC != null) {
            boolean zB2 = lcVarC.b();
            String strA3 = lcVarC.a();
            this.e.getClass();
            boolean z2 = (strA3 == null || strA3.length() == 0 || Intrinsics.areEqual("00000000-0000-0000-0000-000000000000", strA3)) ? false : true;
            if (zB2 || !z2) {
                return;
            }
            function2.invoke("huawei_oaid", strA3);
        }
    }
}
