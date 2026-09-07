package com.ogury.ad.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.ogury.core.internal.IntegrationLogger;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import java.util.Arrays;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j2 extends v0 {
    public final Context c;
    public final n4 d;
    public final c5 e;
    public final s2 f;
    public final v4 g;
    public final u7 h;
    public final b0 i;
    public final z j;
    public Function0<Unit> k;

    /* JADX WARN: Illegal instructions before constructor call */
    public j2(Context context, n4 mraidCommandExecutor, c5 mraidViewCommands, u7 profigHandler, b0 app, z androidDevice) {
        v4 mraidEventBus = v4.f7421a;
        s2 intentHandler = s2.f7398a;
        d4.a aVar = d4.e;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        d4 monitoringEventLogger = aVar.a(applicationContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidCommandExecutor, "mraidCommandExecutor");
        Intrinsics.checkNotNullParameter(mraidViewCommands, "mraidViewCommands");
        Intrinsics.checkNotNullParameter(intentHandler, "intentHandler");
        Intrinsics.checkNotNullParameter(mraidEventBus, "mraidEventBus");
        Intrinsics.checkNotNullParameter(profigHandler, "profigHandler");
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(androidDevice, "androidDevice");
        Intrinsics.checkNotNullParameter(monitoringEventLogger, "monitoringEventLogger");
        super(mraidCommandExecutor, monitoringEventLogger);
        this.c = context;
        this.d = mraidCommandExecutor;
        this.e = mraidViewCommands;
        this.f = intentHandler;
        this.g = mraidEventBus;
        this.h = profigHandler;
        this.i = app;
        this.j = androidDevice;
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, "io.presage");
        p0.startActivity(p1);
    }

    @Override // com.ogury.ad.internal.v0
    public final void a(c ad) {
        String str;
        Intrinsics.checkNotNullParameter(ad, "ad");
        d4 d4Var = this.b;
        o7 o7Var = o7.SI_008_SDK_EVENT_AD_CLICKED;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
        r3 r3Var = ad.A.f7388a;
        Intrinsics.checkNotNullParameter(r3Var, "<this>");
        int iOrdinal = r3Var.ordinal();
        if (iOrdinal == 0) {
            str = "format";
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            str = "sdk";
        }
        Pair pair2 = TuplesKt.to("loaded_source", str);
        Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
        int i = ad.K;
        d4Var.a(o7Var, ad, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
        v4 v4Var = this.g;
        i4 i4Var = new i4(ad.n.b);
        v4Var.getClass();
        v4.a(i4Var);
    }

    @Override // com.ogury.ad.internal.v0
    public final void b(c ad) {
        String str;
        Intrinsics.checkNotNullParameter(ad, "ad");
        d4 d4Var = this.b;
        o7 o7Var = o7.SI_015_SDK_EVENT_FOREGROUND_UNLOAD;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
        r3 r3Var = ad.A.f7388a;
        Intrinsics.checkNotNullParameter(r3Var, "<this>");
        int iOrdinal = r3Var.ordinal();
        if (iOrdinal == 0) {
            str = "format";
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            str = "sdk";
        }
        Pair pair2 = TuplesKt.to("loaded_source", str);
        Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
        int i = ad.K;
        d4Var.a(o7Var, ad, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
        this.e.a(false);
    }

    @Override // com.ogury.ad.internal.v0
    public final void c(boolean z) {
        if (z) {
            this.e.a();
        } else {
            this.e.d();
        }
    }

    @Override // com.ogury.ad.internal.v0
    public final void c() {
        this.e.c();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005f  */
    @Override // com.ogury.ad.internal.v0
    public final void b(String str, String callbackId) {
        boolean z;
        boolean z2;
        int i;
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        s2 s2Var = this.f;
        Context context = this.c;
        s2Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intentA = s2.a(str);
            if (intentA == null) {
                z = false;
            } else {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intentA, 65536);
                Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
                z = !listQueryIntentActivities.isEmpty();
            }
        } catch (Exception unused) {
            u3.f7411a.getClass();
        }
        this.j.getClass();
        if (Build.VERSION.SDK_INT >= 30) {
            b0 b0Var = this.i;
            b0Var.getClass();
            try {
                i = b0Var.f7264a.getPackageManager().getApplicationInfo(b0Var.f7264a.getPackageName(), 128).targetSdkVersion;
            } catch (Exception unused2) {
                i = 21;
            }
            z2 = i >= 30;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String result = String.format("{isResolved: %s, hasLimitedPackageVisibility: %s}", Arrays.copyOf(new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}, 2));
        Intrinsics.checkNotNullExpressionValue(result, "format(...)");
        n4 n4Var = this.d;
        n4Var.getClass();
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(result, "result");
        h5.a(n4Var.f7364a, o4.b(callbackId, result));
    }

    @Override // com.ogury.ad.internal.v0
    public final void a(String str, String callbackId, c ad) {
        String str2;
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter(ad, "ad");
        d4 d4Var = this.b;
        o7 o7Var = o7.SI_014_SDK_EVENT_LAUNCH_BROWSER;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
        r3 r3Var = ad.A.f7388a;
        Intrinsics.checkNotNullParameter(r3Var, "<this>");
        int iOrdinal = r3Var.ordinal();
        if (iOrdinal == 0) {
            str2 = "format";
        } else if (iOrdinal == 1) {
            str2 = "sdk";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Pair pair2 = TuplesKt.to("loaded_source", str2);
        Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
        int i = ad.K;
        d4Var.a(o7Var, ad, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
        s2 s2Var = this.f;
        Context context = this.c;
        s2Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intentA = s2.a(str);
            if (intentA != null) {
                intentA.addFlags(268435456);
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intentA);
                n4 n4Var = this.d;
                n4Var.getClass();
                Intrinsics.checkNotNullParameter(callbackId, "callbackId");
                Intrinsics.checkNotNullParameter("{isStarted: true}", "result");
                h5.a(n4Var.f7364a, o4.b(callbackId, "{isStarted: true}"));
                Function0<Unit> function0 = this.k;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
        } catch (Exception unused) {
            u3.f7411a.getClass();
        }
        n4 n4Var2 = this.d;
        n4Var2.getClass();
        Intrinsics.checkNotNullParameter(callbackId, "callbackId");
        Intrinsics.checkNotNullParameter("{isStarted: false}", "result");
        h5.a(n4Var2.f7364a, o4.b(callbackId, "{isStarted: false}"));
    }

    @Override // com.ogury.ad.internal.v0
    public final void b() {
        Function0 callable = new Function0() { // from class: com.ogury.ad.internal.j2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return j2.a(this.f$0);
            }
        };
        Intrinsics.checkNotNullParameter(callable, "callable");
        new v8(callable, 0).b(new Function1() { // from class: com.ogury.ad.internal.j2$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return j2.a((z7) obj);
            }
        });
    }

    @Override // com.ogury.ad.internal.v0
    public final void b(String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        this.e.a(adId);
    }

    @Override // com.ogury.ad.internal.v0
    public final void b(boolean z) {
        this.e.a(z);
    }

    @Override // com.ogury.ad.internal.v0
    public final void a(boolean z) {
        this.e.b(z);
    }

    @Override // com.ogury.ad.internal.v0
    public final void a(String str, String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        s2 s2Var = this.f;
        Context context = this.c;
        s2Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            Uri uri = Uri.parse(str);
            Intrinsics.checkNotNull(uri);
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.addFlags(268435456);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, intent);
        } catch (Exception unused) {
            u3.f7411a.getClass();
        }
    }

    @Override // com.ogury.ad.internal.v0
    public final void a(p adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        v4 v4Var = this.g;
        a5 a5Var = new a5(adUnit.b, adUnit.e);
        v4Var.getClass();
        v4.a(a5Var);
    }

    public static final z7 a(j2 j2Var) {
        IntegrationLogger.d("[Ads][setup] New synchronisation of the configuration has just been required");
        j2Var.h.c();
        return j2Var.h.a(false);
    }

    public static final Unit a(z7 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @Override // com.ogury.ad.internal.v0
    public final void a(e8 e8Var) {
        this.e.a(e8Var);
    }

    @Override // com.ogury.ad.internal.v0
    public final void a() {
        this.e.b();
    }

    @Override // com.ogury.ad.internal.v0
    public final void a(String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        v4 v4Var = this.g;
        u4 u4Var = new u4(adId, "adImpression");
        v4Var.getClass();
        v4.a(u4Var);
    }
}
