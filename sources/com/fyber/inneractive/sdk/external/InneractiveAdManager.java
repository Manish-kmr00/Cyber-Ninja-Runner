package com.fyber.inneractive.sdk.external;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.fyber.inneractive.sdk.bidder.C3054b;
import com.fyber.inneractive.sdk.bidder.C3058f;
import com.fyber.inneractive.sdk.config.AbstractC3081k;
import com.fyber.inneractive.sdk.config.AbstractC3090u;
import com.fyber.inneractive.sdk.config.C;
import com.fyber.inneractive.sdk.config.C3075e;
import com.fyber.inneractive.sdk.config.C3076f;
import com.fyber.inneractive.sdk.config.C3077g;
import com.fyber.inneractive.sdk.config.C3079i;
import com.fyber.inneractive.sdk.config.C3085o;
import com.fyber.inneractive.sdk.config.C3086p;
import com.fyber.inneractive.sdk.config.C3088s;
import com.fyber.inneractive.sdk.config.C3089t;
import com.fyber.inneractive.sdk.config.C3092w;
import com.fyber.inneractive.sdk.config.C3093x;
import com.fyber.inneractive.sdk.config.C3094y;
import com.fyber.inneractive.sdk.config.E;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.N;
import com.fyber.inneractive.sdk.config.Z;
import com.fyber.inneractive.sdk.config.cellular.h;
import com.fyber.inneractive.sdk.config.r;
import com.fyber.inneractive.sdk.ignite.l;
import com.fyber.inneractive.sdk.logger.FMPLogger;
import com.fyber.inneractive.sdk.mraid.IAMraidKit;
import com.fyber.inneractive.sdk.network.AbstractC3149z;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.network.V;
import com.fyber.inneractive.sdk.util.AbstractC3250n;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.AbstractC3255t;
import com.fyber.inneractive.sdk.util.AbstractC3261z;
import com.fyber.inneractive.sdk.util.B;
import com.fyber.inneractive.sdk.util.C3260y;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.L;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.u0;
import com.fyber.inneractive.sdk.video.IAVideoKit;
import com.fyber.inneractive.sdk.web.c0;
import com.google.android.gms.appset.AppSet;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class InneractiveAdManager implements r {
    public static final String GLOBAL_CONFIG_PARAM_FIRST_INIT_EVENT = "sdk_first_init";
    public static IAConfigManager.OnConfigurationReadyAndValidListener e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Context f1752a;
    public String b;
    public boolean c = false;
    public boolean d;

    public enum GdprConsentSource {
        Internal,
        External
    }

    public static void a(OnFyberMarketplaceInitializedListener onFyberMarketplaceInitializedListener, OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus, String str) {
        if (onFyberMarketplaceInitializedListener != null) {
            onFyberMarketplaceInitializedListener.onFyberMarketplaceInitialized(fyberInitStatus);
        }
        if (d.f1762a.f1752a == null || fyberInitStatus == OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY) {
            return;
        }
        C3146w c3146w = new C3146w(EnumC3143t.FMP_SDK_INIT_FAILED, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null);
        if (!TextUtils.isEmpty(str)) {
            c3146w.a("message", str);
        }
        c3146w.a("init_status", fyberInitStatus.name());
        c3146w.a((String) null);
    }

    @Deprecated
    public static boolean areNativeAdsSupportedForOS() {
        return true;
    }

    public static void clearGdprConsentData() {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g != null) {
            c3077g.a();
        } else {
            IAlog.f("clearGdprConsentData() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
        }
    }

    public static void clearImpressionDataListener() {
        IAConfigManager.O.A.f2355a = null;
    }

    public static void clearLgpdConsentData() {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g != null) {
            c3077g.b();
        } else {
            IAlog.f("clearLgpdConsentData was invoked, but Fyber SDK was not properly initialized", new Object[0]);
        }
    }

    public static void clearUSPrivacyString() {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g != null) {
            c3077g.c();
        }
    }

    public static void currentAudienceAppliesToCoppa() {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g == null) {
            IAlog.f("currentAudienceAppliesToCoppa was invoked, but Fyber SDK was not properly initialized", new Object[0]);
        } else if (AbstractC3251o.f2370a != null) {
            c3077g.j = Boolean.TRUE;
        } else {
            c3077g.getClass();
            IAlog.f("setCurrentAudienceAppliesToCoppa was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
        }
    }

    public static void currentAudienceIsAChild() {
        d.f1762a.c = true;
    }

    public static void destroy() {
        l lVar;
        IAlog.a("InneractiveAdManager:destroy called", new Object[0]);
        if (d.f1762a.f1752a == null) {
            IAlog.a("InneractiveAdManager:destroy called, but manager is not initialized", new Object[0]);
            return;
        }
        d.f1762a.f1752a = null;
        IAConfigManager.removeListener(e);
        e = null;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        iAConfigManager.A.f2355a = null;
        iAConfigManager.h = false;
        try {
            com.fyber.inneractive.sdk.config.cellular.a aVar = iAConfigManager.N;
            if (aVar != null && aVar.f1687a != null) {
                aVar.c.clear();
                aVar.f1687a.a((h) aVar);
                aVar.f1687a.a();
            }
        } catch (Throwable th) {
            IAlog.a("failed to destroy network watchdog", th, new Object[0]);
        }
        com.fyber.inneractive.sdk.ignite.h hVar = iAConfigManager.E;
        if (!TextUtils.isEmpty(hVar.l) && (lVar = hVar.p) != null) {
            lVar.destroy();
            hVar.p = null;
        }
        L.f2347a.a();
        B b = AbstractC3261z.f2383a;
        synchronized (b) {
            if (b.c != null) {
                IAlog.a("%sremoving screen state receiver and destroying singleton", IAlog.a(b));
                try {
                    b.c.unregisterReceiver(b.d);
                } catch (Exception unused) {
                }
                b.c = null;
                b.d = null;
                b.f2343a.clear();
            }
        }
        com.fyber.inneractive.sdk.factories.d.f1768a.f1769a.clear();
        com.fyber.inneractive.sdk.factories.b.f1766a.f1767a.clear();
        com.fyber.inneractive.sdk.factories.h.f1770a.f1771a.clear();
        InneractiveAdSpotManager.destroy();
        AbstractC3250n.f2369a.clear();
        C3054b c3054b = C3054b.h;
        C3058f c3058f = c3054b.d;
        if (c3058f != null) {
            try {
                AbstractC3251o.f2370a.unregisterReceiver(c3058f);
            } catch (Exception unused2) {
            }
        }
        c3054b.d = null;
        com.fyber.inneractive.sdk.config.cellular.a aVar2 = IAConfigManager.O.N;
        if (aVar2 != null) {
            try {
                aVar2.c.remove(c3054b);
            } catch (Throwable th2) {
                IAlog.a("failed to remove network observer", th2, new Object[0]);
            }
        }
    }

    public static String getAppId() {
        return IAConfigManager.O.c;
    }

    @Deprecated
    public static String getDevPlatform() {
        return d.f1762a.b;
    }

    public static Boolean getGdprConsent() {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g != null) {
            return c3077g.d();
        }
        return null;
    }

    public static GdprConsentSource getGdprStatusSource() {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g != null) {
            return c3077g.f;
        }
        IAlog.f("getGdprStatusSource() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
        return null;
    }

    public static boolean getMuteVideo() {
        return IAConfigManager.O.k;
    }

    public static String getUserId() {
        return IAConfigManager.O.D.g;
    }

    public static InneractiveUserConfig getUserParams() {
        return IAConfigManager.O.j;
    }

    public static String getVersion() {
        return "8.3.6";
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @Deprecated
    public static boolean isCurrentDeviceSupportsVideo() {
        return true;
    }

    public static boolean isCurrentUserAChild() {
        return d.f1762a.c;
    }

    @Deprecated
    public static void setDevPlatform(String str) {
        d.f1762a.b = str;
    }

    public static void setGdprConsent(boolean z) {
        setGdprConsent(z, GdprConsentSource.Internal);
    }

    public static void setGdprConsentString(String str) {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g == null) {
            IAlog.f("setGdprConsentString() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
            return;
        }
        if (AbstractC3251o.f2370a == null) {
            c3077g.getClass();
            IAlog.f("SetGdprConsentString() was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
        } else {
            c3077g.d = str;
            if (c3077g.a("IAGdprConsentData", str)) {
                return;
            }
            IAlog.f("SetGdprConsentString() was invoked, but the Inneractive SDK was not properly initialized, destroyed, or data is empty.", new Object[0]);
        }
    }

    public static void setImpressionDataListener(OnGlobalImpressionDataListener onGlobalImpressionDataListener) {
        IAConfigManager.O.A.f2355a = onGlobalImpressionDataListener;
    }

    public static void setLgpdConsent(boolean z) {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g == null) {
            IAlog.f("setLgpdConsent was invoked, but Fyber SDK was not properly initialized", new Object[0]);
            return;
        }
        if (AbstractC3251o.f2370a == null) {
            c3077g.getClass();
            IAlog.f("setLgpdConsentStatus was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
        } else {
            c3077g.i = Boolean.valueOf(z);
            if (c3077g.a(z, "IALgpdConsentStatus")) {
                return;
            }
            IAlog.f("setLgpdConsentStatus was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
        }
    }

    public static void setLogLevel(int i) {
        IAlog.f2345a = i;
    }

    public static void setMediationName(String str) {
        IAConfigManager.O.l = str;
    }

    public static void setMediationVersion(String str) {
        if (str != null) {
            IAConfigManager.O.n = str;
        }
    }

    public static void setMuteVideo(boolean z) {
        IAConfigManager.O.k = z;
    }

    public static void setUSPrivacyString(String str) {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g == null) {
            IAlog.f("setUSPrivacyString() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
            return;
        }
        if (AbstractC3251o.f2370a == null) {
            c3077g.getClass();
            IAlog.f("setUSPrivacyString() was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
        } else {
            c3077g.h = str;
            if (c3077g.a("IACCPAConsentData", str)) {
                return;
            }
            IAlog.f("setUSPrivacyString() was invoked, but the Inneractive SDK was not properly initialized, destroyed, or data is empty.", new Object[0]);
        }
    }

    public static void setUseLocation(boolean z) {
        IAConfigManager.O.getClass();
    }

    public static void setUserId(String str) {
        if (AbstractC3251o.f2370a != null) {
            IAConfigManager.O.D.a(str);
        } else {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            IAlog.f("setUsedId() was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
        }
    }

    public static void setUserParams(InneractiveUserConfig inneractiveUserConfig) {
        IAConfigManager.O.j = inneractiveUserConfig;
        IAlog.a("config manager: setUserParams called with: age:" + inneractiveUserConfig.getAge() + " gender: " + inneractiveUserConfig.getGender() + " zip: " + inneractiveUserConfig.getZipCode(), new Object[0]);
    }

    public static void useSecureConnections(boolean z) {
        IAConfigManager.O.q = z;
        IAlog.a("config manager: useSecureConnections called with: isSecured: + %s", Boolean.valueOf(z));
        if (AbstractC3255t.a() || z) {
            return;
        }
        IAlog.f("************************************************************************************************************************", new Object[0]);
        IAlog.f("*** useSecureConnections was set to false while secure traffic is enabled in the network security config", new Object[0]);
        IAlog.f("***  The traffic will be Secured  ", new Object[0]);
        IAlog.f("************************************************************************************************************************", new Object[0]);
    }

    public static boolean wasInitialized() {
        return d.f1762a.f1752a != null;
    }

    public Context getAppContext() {
        return this.f1752a;
    }

    @Override // com.fyber.inneractive.sdk.config.r
    public void onGlobalConfigChanged(C3088s c3088s, C3085o c3085o) {
        if (c3085o == null || !c3085o.a(false, GLOBAL_CONFIG_PARAM_FIRST_INIT_EVENT)) {
            return;
        }
        com.fyber.inneractive.sdk.util.r.b.post(new c());
    }

    public static void initialize(Context context, String str, OnFyberMarketplaceInitializedListener onFyberMarketplaceInitializedListener) {
        String language;
        List<ResolveInfo> listQueryIntentServices;
        if (context == null || str == null) {
            IAlog.b("InneractiveAdManager:initialize. No context or App Id given", new Object[0]);
            a(onFyberMarketplaceInitializedListener, (str == null || TextUtils.isEmpty(str.trim())) ? OnFyberMarketplaceInitializedListener.FyberInitStatus.INVALID_APP_ID : OnFyberMarketplaceInitializedListener.FyberInitStatus.FAILED, (str == null ? "appid" : "context").concat(" is null"));
            return;
        }
        String str2 = IAConfigManager.O.c;
        boolean z = (str2 == null || str2.equalsIgnoreCase(str)) ? false : true;
        String str3 = null;
        if (d.f1762a.f1752a != null && !z) {
            IAlog.a("InneractiveAdManager:initialize called, but manager is already initialized. ignoring", new Object[0]);
            a(onFyberMarketplaceInitializedListener, OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY, null);
            return;
        }
        IAlog.c.retainAll(Collections.singleton(IAlog.b));
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.logger");
        if (property != null) {
            for (String str4 : property.split(StringUtils.COMMA)) {
                try {
                    FMPLogger fMPLogger = (FMPLogger) Class.forName(str4).newInstance();
                    fMPLogger.initialize(context);
                    IAlog.c.add(fMPLogger);
                } catch (Throwable unused) {
                }
            }
        }
        AbstractC3251o.f2370a = (Application) context.getApplicationContext();
        B b = AbstractC3261z.f2383a;
        Context applicationContext = context.getApplicationContext();
        b.getClass();
        IAlog.a("%sinit called", IAlog.a(b));
        b.c = applicationContext;
        b.d = new C3260y(b);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        b.c.registerReceiver(b.d, intentFilter);
        Intent intent = new Intent();
        intent.setAction("com.fyber.inneractive.sdk.intent.action.REGISTER_KIT");
        intent.setPackage(AbstractC3251o.f2370a.getPackageName());
        Context applicationContext2 = context.getApplicationContext();
        if (applicationContext2 == null) {
            throw new IllegalArgumentException("Context can't be null");
        }
        List<BroadcastReceiver> listAsList = Arrays.asList(new IAMraidKit(), new IAVideoKit(), new com.fyber.inneractive.sdk.dv.g());
        for (BroadcastReceiver broadcastReceiver : listAsList) {
            try {
                broadcastReceiver.onReceive(applicationContext2, intent);
            } catch (Throwable unused2) {
                IAlog.f("%sCould not trigger receiver for %s", IAlog.a(com.fyber.inneractive.sdk.b.class), broadcastReceiver);
            }
        }
        if (com.fyber.inneractive.sdk.factories.d.f1768a.f1769a.size() == 0) {
            Log.e("Inneractive_error", "Critical error raised while initializing SDK - please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project");
        }
        if (listAsList.size() == 0) {
            IAlog.b("InneractiveAdManager:initialize. please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project", new Object[0]);
            a(onFyberMarketplaceInitializedListener, OnFyberMarketplaceInitializedListener.FyberInitStatus.FAILED_NO_KITS_DETECTED, null);
            return;
        }
        a aVar = new a(context, onFyberMarketplaceInitializedListener);
        e = aVar;
        IAConfigManager.addListener(aVar);
        if (z) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            iAConfigManager.c = str;
            HashMap map = iAConfigManager.f1673a;
            if (map != null) {
                map.clear();
            }
            HashMap map2 = iAConfigManager.b;
            if (map2 != null) {
                map2.clear();
            }
            iAConfigManager.e = null;
            iAConfigManager.d = "";
            IAConfigManager.a();
        } else {
            Context applicationContext3 = context.getApplicationContext();
            IAConfigManager iAConfigManager2 = IAConfigManager.O;
            if (!iAConfigManager2.h) {
                iAConfigManager2.v = new C3079i(context, applicationContext3);
                u0 u0Var = new u0();
                iAConfigManager2.y = u0Var;
                u0Var.c = applicationContext3.getApplicationContext();
                com.fyber.inneractive.sdk.util.r.f2374a.execute(new p0(u0Var));
                com.fyber.inneractive.sdk.network.L l = iAConfigManager2.s;
                if (!l.b) {
                    l.b = true;
                    for (int i2 = 0; i2 < 6; i2++) {
                        l.d.submit(l.e);
                    }
                }
                c0.c.getClass();
                iAConfigManager2.D = new C3077g();
                C3088s c3088s = new C3088s(applicationContext3);
                iAConfigManager2.u = c3088s;
                iAConfigManager2.w = new C3089t(c3088s);
                IAConfigManager.O.s.b(new V(new C3086p(c3088s), c3088s.f1725a, c3088s.e));
                iAConfigManager2.I.a((Application) applicationContext3.getApplicationContext());
                iAConfigManager2.u.c.add(new C3093x(iAConfigManager2));
                iAConfigManager2.z = new com.fyber.inneractive.sdk.config.global.a();
                IAlog.a("Initializing config manager", new Object[0]);
                IAlog.a("Config manager: lib name = %s", "Android");
                IAlog.a("Config manager: app version = %s", "8.3.6");
                C3092w c3092w = AbstractC3090u.f1727a;
                if (c3092w.f1729a == null) {
                    c3092w.f1729a = applicationContext3;
                    new Thread(new N(applicationContext3, c3092w)).start();
                }
                if (!str.matches("[0-9]+")) {
                    IAlog.b("************************************************************************************************************************", new Object[0]);
                    IAlog.b("*************************************** APP ID Must contain only numbers ***********************************************", new Object[0]);
                    IAlog.b("*************************************** Are you sure that you are using the correct APP ID *****************************", new Object[0]);
                    IAlog.b("************************************************************************************************************************", new Object[0]);
                }
                try {
                    Class.forName("com.google.android.gms.appset.AppSet");
                    try {
                        AppSet.getClient(applicationContext3).getAppSetIdInfo().addOnSuccessListener(new C3094y());
                    } catch (Throwable th) {
                        IAlog.f("%sFailed to resolve AppSetId: %s", IAlog.a(IAConfigManager.class), th.getMessage());
                        AbstractC3149z.a("Failed to resolve AppSetId", th.getMessage(), null, null);
                    }
                } catch (ClassNotFoundException unused3) {
                }
                iAConfigManager2.f = applicationContext3;
                iAConfigManager2.c = str;
                iAConfigManager2.j = new InneractiveUserConfig();
                iAConfigManager2.h = true;
                Z z2 = iAConfigManager2.x;
                z2.getClass();
                new C3075e(z2).a();
                z2.c.put("SESSION_STAMP", Long.toString(SystemClock.elapsedRealtime()));
                com.fyber.inneractive.sdk.cache.session.e eVar = new com.fyber.inneractive.sdk.cache.session.e();
                z2.f1684a = eVar;
                com.fyber.inneractive.sdk.cache.session.c cVar = new com.fyber.inneractive.sdk.cache.session.c(eVar);
                ThreadPoolExecutor threadPoolExecutor = com.fyber.inneractive.sdk.util.r.f2374a;
                threadPoolExecutor.execute(cVar);
                iAConfigManager2.B = new V(new C(iAConfigManager2), iAConfigManager2.f, new C3076f());
                threadPoolExecutor.execute(new E(iAConfigManager2));
                try {
                    language = Locale.getDefault().getLanguage();
                    try {
                        IAlog.a("Available device language: %s", language);
                    } catch (Exception unused4) {
                    }
                } catch (Exception unused5) {
                    language = null;
                }
                iAConfigManager2.o = language;
                com.fyber.inneractive.sdk.ignite.h hVar = iAConfigManager2.E;
                hVar.f1850a = applicationContext3;
                Intent intent2 = new Intent("com.digitalturbine.ignite.cl.IgniteRemoteService");
                Context context2 = hVar.f1850a;
                if (context2 != null && (listQueryIntentServices = context2.getPackageManager().queryIntentServices(intent2, 0)) != null && listQueryIntentServices.size() > 0) {
                    str3 = listQueryIntentServices.get(0).serviceInfo.packageName;
                }
                hVar.l = str3;
                com.fyber.inneractive.sdk.config.cellular.a aVar2 = new com.fyber.inneractive.sdk.config.cellular.a(iAConfigManager2.f);
                iAConfigManager2.N = aVar2;
                com.fyber.inneractive.sdk.config.cellular.d dVar = aVar2.f1687a;
                if (dVar != null) {
                    try {
                        dVar.a(aVar2);
                    } catch (Throwable th2) {
                        IAlog.a("failed to register network detector", th2, new Object[0]);
                    }
                }
            }
        }
        d.f1762a.f1752a = context.getApplicationContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences("Fyber_Shared_File", 0);
        String string = sharedPreferences.getString("FyberExceptionKey", "empty");
        String string2 = sharedPreferences.getString("FyberDescriptionKey", "empty");
        String string3 = sharedPreferences.getString("FyberNameKey", "empty");
        String string4 = sharedPreferences.getString("FyberVersionKey", getVersion());
        IAlog.a(" name- %s   description - %s exception - %s", string3, string2, string);
        if (!string.contains("OutOfMemoryError") && !string.equals("empty") && !string2.equals("empty") && !string3.equals("empty")) {
            IAlog.a("Firing Event 999 for %s", string);
            C3146w c3146w = new C3146w(EnumC3144u.IA_UNCAUGHT_EXCEPTION);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exception_name", string3);
            } catch (Exception unused6) {
                IAlog.f("Got exception adding param to json object: %s, %s", "exception_name", string3);
            }
            try {
                jSONObject.put("description", string2);
            } catch (Exception unused7) {
                IAlog.f("Got exception adding param to json object: %s, %s", "description", string2);
            }
            try {
                jSONObject.put("stack_trace", string);
            } catch (Exception unused8) {
                IAlog.f("Got exception adding param to json object: %s, %s", "stack_trace", string);
            }
            c3146w.f.put(jSONObject);
            c3146w.a(string4);
            sharedPreferences.edit().remove("FyberExceptionKey").remove("FyberVersionKey").remove("FyberDescriptionKey").remove("FyberNameKey").apply();
        }
        Thread.setDefaultUncaughtExceptionHandler(new b(sharedPreferences, Thread.getDefaultUncaughtExceptionHandler()));
        IAConfigManager iAConfigManager3 = IAConfigManager.O;
        iAConfigManager3.u.c.remove(d.f1762a);
        iAConfigManager3.u.c.add(d.f1762a);
    }

    public static void setGdprConsent(boolean z, GdprConsentSource gdprConsentSource) {
        C3077g c3077g = IAConfigManager.O.D;
        if (c3077g == null) {
            IAlog.f("setGdprConsent() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
            return;
        }
        if (AbstractC3251o.f2370a == null) {
            c3077g.getClass();
            IAlog.f("SetGdprConsent(boolean) was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
            return;
        }
        c3077g.f1694a = Boolean.valueOf(z);
        if (!c3077g.a(z, "IAGDPRBool")) {
            IAlog.f("SetGdprConsent(boolean) was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
        }
        c3077g.f = gdprConsentSource;
        if (c3077g.a("IAGdprSource", gdprConsentSource.name())) {
            return;
        }
        IAlog.f("SetGdprConsent(boolean) was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
    }

    public static void setMediationName(InneractiveMediationName inneractiveMediationName) {
        if (inneractiveMediationName != null) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            iAConfigManager.m = inneractiveMediationName;
            iAConfigManager.l = inneractiveMediationName.getKey();
        }
    }
}
