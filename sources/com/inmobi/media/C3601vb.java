package com.inmobi.media;

import android.location.LocationManager;
import com.google.android.gms.common.api.GoogleApiClient;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.SignalsConfig;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.vb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3601vb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C3601vb f3460a = new C3601vb();
    public static C3452l4 b;
    public static boolean c;

    public static SignalsConfig.IceConfig a(String str) {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        Config configA = C3549s2.a("signals", str, null);
        Intrinsics.checkNotNull(configA, "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig");
        return ((SignalsConfig) configA).getIce();
    }

    public final synchronized void b() {
        Intrinsics.checkNotNullExpressionValue("vb", "TAG");
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        C3549s2.a("signals", C3517pb.b(), null);
        C3587ub c3587ub = C3587ub.f3446a;
        boolean sessionEnabled = a().getSessionEnabled();
        c3587ub.getClass();
        C3587ub.e = sessionEnabled;
        if (!sessionEnabled) {
            C3587ub.d = null;
        }
        C3587ub.c();
        C3517pb c3517pb = C3517pb.f3400a;
        String strH = c3517pb.h();
        if (strH == null || a(strH).isVisibleWifiEnabled()) {
            c();
        }
        String strH2 = c3517pb.h();
        if (strH2 == null || a(strH2).getLocationEnabled()) {
            C3354e6.f3300a.d();
        }
    }

    public final synchronized void c() {
        if (c) {
            Intrinsics.checkNotNullExpressionValue("vb", "TAG");
            return;
        }
        c = true;
        if (b == null) {
            b = new C3452l4();
        }
        C3452l4 c3452l4 = b;
        if (c3452l4 != null) {
            c3452l4.a();
        }
    }

    public final synchronized void d() {
        Intrinsics.checkNotNullExpressionValue("vb", "TAG");
        if (c) {
            c = false;
            C3452l4 c3452l4 = b;
            if (c3452l4 != null) {
                HandlerC3436k4 handlerC3436k4 = c3452l4.f3366a;
                handlerC3436k4.f3356a = true;
                handlerC3436k4.sendEmptyMessageDelayed(2, a().getStopRequestTimeout() * 1000);
            }
        }
        C3354e6 c3354e6 = C3354e6.f3300a;
        if (C3354e6.c()) {
            LocationManager locationManager = C3354e6.b;
            if (locationManager != null) {
                locationManager.removeUpdates(c3354e6);
            }
            GoogleApiClient googleApiClient = C3354e6.d;
            if (googleApiClient != null) {
                googleApiClient.disconnect();
            }
        }
        C3354e6.d = null;
    }

    public static SignalsConfig.IceConfig a() {
        LinkedHashMap linkedHashMap = C3578u2.f3440a;
        return ((SignalsConfig) B4.a("signals", "null cannot be cast to non-null type com.inmobi.commons.core.configs.SignalsConfig", null)).getIce();
    }
}
