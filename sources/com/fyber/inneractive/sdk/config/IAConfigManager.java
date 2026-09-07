package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.network.C3130f;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.RunnableC3248l;
import com.fyber.inneractive.sdk.util.u0;
import com.fyber.inneractive.sdk.web.b0;
import com.fyber.inneractive.sdk.web.c0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes9.dex */
public class IAConfigManager {
    public static long P;
    public final com.fyber.inneractive.sdk.util.Z A;
    public com.fyber.inneractive.sdk.network.V B;
    public com.fyber.inneractive.sdk.network.V C;
    public C3077g D;
    public final com.fyber.inneractive.sdk.ignite.h E;
    public final com.fyber.inneractive.sdk.topics.b F;
    public final com.fyber.inneractive.sdk.dv.handler.a G;
    public final com.fyber.inneractive.sdk.cache.i H;
    public final C3130f I;
    public final HashMap J;
    public com.fyber.inneractive.sdk.measurement.e K;
    public WebView L;
    public final com.fyber.inneractive.sdk.config.global.r M;
    public com.fyber.inneractive.sdk.config.cellular.a N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f1673a = new HashMap();
    public HashMap b = new HashMap();
    public String c;
    public String d;
    public String e;
    public Context f;
    public final CopyOnWriteArrayList g;
    public boolean h;
    public final L i;
    public InneractiveUserConfig j;
    public boolean k;
    public String l;
    public InneractiveMediationName m;
    public String n;
    public String o;
    public ArrayList p;
    public boolean q;
    public String r;
    public final com.fyber.inneractive.sdk.network.L s;
    public String t;
    public C3088s u;
    public C3079i v;
    public C3089t w;
    public final Z x;
    public u0 y;
    public com.fyber.inneractive.sdk.config.global.a z;
    public static final IAConfigManager O = new IAConfigManager();
    public static final H Q = new H();

    public interface OnConfigurationReadyAndValidListener {
        void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc);
    }

    public IAConfigManager() {
        com.fyber.inneractive.sdk.dv.handler.a eVar;
        new HashSet();
        this.h = false;
        this.i = new L();
        this.k = false;
        this.q = false;
        this.s = new com.fyber.inneractive.sdk.network.L();
        this.t = "";
        this.x = new Z();
        this.A = new com.fyber.inneractive.sdk.util.Z();
        this.E = new com.fyber.inneractive.sdk.ignite.h();
        this.F = new com.fyber.inneractive.sdk.topics.b();
        String[] strArr = {"com.google.android.gms.ads.MobileAds", "com.google.android.gms.ads.query.QueryInfoGenerationCallback"};
        for (int i = 0; i < 2; i++) {
            try {
                Class.forName(strArr[i]);
            } catch (ClassNotFoundException unused) {
                eVar = new com.fyber.inneractive.sdk.dv.handler.f();
            }
        }
        eVar = new com.fyber.inneractive.sdk.dv.handler.e();
        this.G = eVar;
        this.H = new com.fyber.inneractive.sdk.cache.i();
        this.I = new C3130f();
        this.J = new HashMap();
        this.M = com.fyber.inneractive.sdk.config.global.r.a();
        this.g = new CopyOnWriteArrayList();
    }

    public static void addListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        O.g.add(onConfigurationReadyAndValidListener);
    }

    public static void b() {
        C3088s c3088s;
        C3085o c3085o;
        com.fyber.inneractive.sdk.topics.b bVar;
        IAConfigManager iAConfigManager = O;
        iAConfigManager.getClass();
        if (iAConfigManager.F.i.get() || (c3088s = iAConfigManager.u) == null || (c3085o = c3088s.b) == null) {
            return;
        }
        int iA = c3085o.a("topics_enabled", 0, 0);
        int iA2 = iAConfigManager.u.b.a("e_topics_enabled", 0, 0);
        if (iA == 0 && iA2 == 0) {
            IAlog.a("Topics API feature disabled - topics_enabled & e_topics_enabled flags are 0", new Object[0]);
            return;
        }
        boolean z = iA != 0;
        boolean z2 = iA2 != 0;
        try {
            if (!f() || (bVar = iAConfigManager.F) == null) {
                return;
            }
            bVar.a(z, z2);
            iAConfigManager.F.c();
        } catch (Throwable th) {
            IAlog.a("error while trying to init topics ", th, new Object[0]);
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(1000000) >= 11 && AbstractC3251o.a("android.permission.ACCESS_ADSERVICES_TOPICS");
    }

    public static boolean d() {
        C3077g c3077g = O.D;
        return c3077g != null && c3077g.e();
    }

    public static boolean e() {
        IAConfigManager iAConfigManager = O;
        boolean z = iAConfigManager.e != null;
        int i = AbstractC3081k.f1710a;
        boolean zBooleanValue = Boolean.valueOf(System.getProperty("ia.testEnvironmentConfiguration.forceConfigRefresh", Boolean.toString(false))).booleanValue();
        if ((z && System.currentTimeMillis() - P > 3600000) || zBooleanValue) {
            if (zBooleanValue) {
                C3088s c3088s = iAConfigManager.u;
                c3088s.d = false;
                com.fyber.inneractive.sdk.util.r.f2374a.execute(new RunnableC3248l(c3088s.e));
            }
            a();
            c0 c0Var = c0.c;
            c0Var.getClass();
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new b0(c0Var));
        }
        return z;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 31 && SdkExtensions.getExtensionVersion(1000000) >= 4 && AbstractC3251o.a("android.permission.ACCESS_ADSERVICES_TOPICS");
    }

    public static void g() {
        SharedPreferences sharedPreferences = AbstractC3251o.f2370a.getSharedPreferences("IAConfigurationPreferences", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("IAConfigFQE", true).apply();
        }
    }

    public static void removeListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        O.g.remove(onConfigurationReadyAndValidListener);
    }

    public final void a(Exception exc) {
        for (OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener : this.g) {
            if (onConfigurationReadyAndValidListener != null) {
                boolean z = O.e != null;
                IAlog.e("notifying listener configuration state has been resolved", new Object[0]);
                onConfigurationReadyAndValidListener.onConfigurationReadyAndValid(this, z, !z ? exc : null);
            }
        }
    }

    public static void a() {
        IAConfigManager iAConfigManager = O;
        com.fyber.inneractive.sdk.network.V v = iAConfigManager.B;
        if (v != null) {
            iAConfigManager.s.b(v);
        }
        C3088s c3088s = iAConfigManager.u;
        if (c3088s.d) {
            return;
        }
        iAConfigManager.s.b(new com.fyber.inneractive.sdk.network.V(new C3086p(c3088s), c3088s.f1725a, c3088s.e));
    }
}
