package com.ogury.ad.internal;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.ogury.core.internal.InternalCore;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i7 f7283a;
    public final t7 b;
    public final z c;
    public final m1 d;
    public final b0 e;
    public final e2 f;

    public d8(Context context, i7 permissionType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissionType, "permissionType");
        t7 t7Var = t7.f7405a;
        z zVar = new z(context);
        m1 m1Var = new m1(context);
        b0 b0Var = new b0(context);
        e2 e2Var = e2.f7288a;
        this.f7283a = permissionType;
        this.b = t7Var;
        this.c = zVar;
        this.d = m1Var;
        this.e = b0Var;
        this.f = e2Var;
    }

    public final <T> T a(k1 k1Var, Function0<? extends T> function0) {
        int i;
        int iOrdinal = this.f7283a.ordinal();
        if (iOrdinal == 0) {
            i = Integer.MAX_VALUE;
        } else if (iOrdinal == 1) {
            this.b.getClass();
            i = t7.b.d.b;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.b.getClass();
            i = t7.b.e.f7469a;
        }
        int i2 = (i >> k1Var.f7335a) & 1;
        this.f.getClass();
        Boolean boolA = e2.a("IS_CHILD_UNDER_COPPA");
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(boolA, bool) || Intrinsics.areEqual(e2.a("IS_UNDER_AGE_OF_GDPR_CONSENT"), bool)) {
            this.b.getClass();
            i2 &= (t7.b.b.b >> k1Var.f7335a) & 1;
        }
        if (i2 == 1) {
            return function0.invoke();
        }
        return null;
    }

    public final String b() {
        return (String) a(k1.ARCHITECTURE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.b(this.f$0);
            }
        });
    }

    public final String c() {
        return (String) a(k1.CONNECTIVITY, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.c(this.f$0);
            }
        });
    }

    public final String d() {
        return (String) a(k1.DEVICE_ID, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.d(this.f$0);
            }
        });
    }

    public final String e() {
        return (String) a(k1.DEVICE_NAME, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.e(this.f$0);
            }
        });
    }

    public final String f() {
        return (String) a(k1.DEVICE_NAME, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.f(this.f$0);
            }
        });
    }

    public final String g() {
        return (String) a(k1.DEVICE_ORIENTATION, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.g(this.f$0);
            }
        });
    }

    public final Boolean h() {
        return (Boolean) a(k1.HPE_EXPERIENCE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(d8.h(this.f$0));
            }
        });
    }

    public final String i() {
        return (String) a(k1.INSTANCE_TOKEN, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.i(this.f$0);
            }
        });
    }

    public final String j() {
        return (String) a(k1.LAYOUT_SIZE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.j(this.f$0);
            }
        });
    }

    public final String k() {
        return (String) a(k1.LOCALE_COUNTRY, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.k(this.f$0);
            }
        });
    }

    public final String l() {
        return (String) a(k1.LOCALE_LANGUAGE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.l(this.f$0);
            }
        });
    }

    public final String m() {
        return (String) a(k1.MOBILE_COUNTRY, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.m(this.f$0);
            }
        });
    }

    public final Float n() {
        return (Float) a(k1.DEVICE_SIZE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(d8.n(this.f$0));
            }
        });
    }

    public final Integer o() {
        return (Integer) a(k1.DEVICE_SIZE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(d8.o(this.f$0));
            }
        });
    }

    public final Integer p() {
        return (Integer) a(k1.DEVICE_SIZE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(d8.p(this.f$0));
            }
        });
    }

    public final String q() {
        return (String) a(k1.TIMEZONE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.q(this.f$0);
            }
        });
    }

    public final String r() {
        return (String) a(k1.UI_MODE, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.r(this.f$0);
            }
        });
    }

    public final String s() {
        return (String) a(k1.WEBVIEW_USER_AGENT, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return d8.s(this.f$0);
            }
        });
    }

    public static final String b(d8 d8Var) {
        d8Var.c.getClass();
        return System.getProperty("os.arch");
    }

    public static final String c(d8 d8Var) {
        return d8Var.c.a();
    }

    public static final String d(d8 d8Var) {
        return InternalCore.getAdvertisingInfo(d8Var.d.f7352a).getId();
    }

    public static final String e(d8 d8Var) {
        return d8Var.c.d;
    }

    public static final String f(d8 d8Var) {
        return d8Var.c.e;
    }

    public static final String g(d8 d8Var) {
        return d8Var.c.f7457a.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
    }

    public static final boolean h(d8 d8Var) {
        return d8Var.e.c();
    }

    public static final String i(d8 d8Var) {
        return InternalCore.getToken(d8Var.d.f7352a, "instance_token");
    }

    public static final String j(d8 d8Var) {
        return d8Var.c.b();
    }

    public static final String k(d8 d8Var) {
        return d8Var.e.b();
    }

    public static final String l(d8 d8Var) {
        return d8Var.e.d();
    }

    public static final String m(d8 d8Var) {
        Object systemService = d8Var.c.f7457a.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String networkCountryIso = ((TelephonyManager) systemService).getNetworkCountryIso();
        Intrinsics.checkNotNullExpressionValue(networkCountryIso, "getNetworkCountryIso(...)");
        return networkCountryIso;
    }

    public static final float n(d8 d8Var) {
        return d8Var.c.c.density;
    }

    public static final int o(d8 d8Var) {
        return d8Var.c.c.heightPixels;
    }

    public static final int p(d8 d8Var) {
        return d8Var.c.c.widthPixels;
    }

    public static final String q(d8 d8Var) {
        d8Var.c.b.getClass();
        return e9.b();
    }

    public static final String r(d8 d8Var) {
        return d8Var.c.d();
    }

    public static final String s(d8 d8Var) {
        return d8Var.e.f();
    }

    public final Boolean a() {
        return (Boolean) a(k1.AD_TRACKING_SETTING, new Function0() { // from class: com.ogury.ad.internal.d8$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(d8.a(this.f$0));
            }
        });
    }

    public static final boolean a(d8 d8Var) {
        return InternalCore.getAdvertisingInfo(d8Var.d.f7352a).getIsAdTrackingEnabled();
    }
}
