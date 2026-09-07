package com.mbridge.msdk.foundation.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.lang.reflect.Constructor;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import net.pubnative.lite.sdk.models.Protocol;
import org.json.JSONObject;

/* JADX INFO: compiled from: SameDiTool.java */
/* JADX INFO: loaded from: classes.dex */
public class k0 extends t {
    private static int A = 0;
    private static String B = "";
    private static Object C = null;
    private static int D = 0;
    private static int E = 0;
    private static long F = -1;
    private static long G = -1;
    private static String H = "";
    private static String I = "";
    private static String j = "";
    private static String k = "";
    private static int l = -1;
    private static String m = "";
    private static int n = -1;
    private static int o = 0;
    private static String p = "";
    private static int q = -1;
    private static String r = "";
    private static String s = "";
    private static volatile int t = -1;
    private static String u = "";
    private static String v = "";
    private static int w = 0;
    private static String x = "";
    private static String y = "";
    private static int z = -1;

    /* JADX INFO: compiled from: SameDiTool.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5062a;

        a(Context context) {
            this.f5062a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.tools.f.c(this.f5062a);
        }
    }

    /* JADX INFO: compiled from: SameDiTool.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5063a;

        b(Context context) {
            this.f5063a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            String defaultUserAgent;
            try {
                defaultUserAgent = WebSettings.getDefaultUserAgent(this.f5063a);
            } catch (Throwable unused) {
                defaultUserAgent = null;
            }
            try {
                if (TextUtils.isEmpty(defaultUserAgent) || defaultUserAgent.equals(k0.y)) {
                    return;
                }
                String unused2 = k0.y = defaultUserAgent;
                k0.G(this.f5063a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SameDiTool.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5064a;

        c(Context context) {
            this.f5064a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f5064a.getSystemService("connectivity");
                if (connectivityManager != null && com.mbridge.msdk.foundation.same.a.z) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        int unused = k0.t = 0;
                        return;
                    }
                    if (activeNetworkInfo.getType() == 1) {
                        int unused2 = k0.t = 9;
                        return;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) this.f5064a.getSystemService("phone");
                    if (telephonyManager == null) {
                        int unused3 = k0.t = 0;
                    } else {
                        int unused4 = k0.t = k0.c(telephonyManager.getNetworkType());
                    }
                }
            } catch (Exception unused5) {
                int unused6 = k0.t = 0;
            }
        }
    }

    /* JADX INFO: compiled from: SameDiTool.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = k0.x = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SameDiTool.java */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.util.c.a();
            } catch (Exception e) {
                o0.b("SameDiTool", e.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: SameDiTool.java */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
            if (contextD != null) {
                ActivityManager activityManager = (ActivityManager) contextD.getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long unused = k0.G = memoryInfo.totalMem;
                long unused2 = k0.F = memoryInfo.availMem;
            }
        }
    }

    public static int A() {
        return z;
    }

    public static int B() {
        if (D == 0) {
            D = t0.e();
        }
        return D;
    }

    public static void C(Context context) {
        try {
            t.e(context);
            o();
            q();
            t(context);
            B(context);
            A(context);
            F(context);
            n();
            s();
            p(context);
            w();
            com.mbridge.msdk.foundation.same.a.B = false;
            com.mbridge.msdk.foundation.same.a.z = t0.b("android.permission.ACCESS_NETWORK_STATE", context);
            w(context);
            l();
            com.mbridge.msdk.foundation.tools.f.b();
            g();
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage());
        }
    }

    public static int D(Context context) {
        if (l == -1) {
            l = t0.c(context, "com.tencent.mm") ? 1 : 0;
        }
        return l;
    }

    private static void E() {
        String str = Build.VERSION.RELEASE;
        String strN = n();
        String str2 = Build.DISPLAY;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strN)) {
            y = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        StringBuilder sbAppend = new StringBuilder("Mozilla/5.0 (Linux; Android ").append(str).append("; ").append(strN).append(" Build/");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        y = sbAppend.append(str2).append(") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19").toString();
    }

    public static int F(Context context) {
        Configuration configuration;
        return (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(Context context) {
        try {
            w0.b(context, "mbridge_ua", y);
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage(), th);
        }
    }

    public static int c(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    public static Object d(String str) {
        if (C == null) {
            C = t0.g(str);
        }
        return C;
    }

    public static int e(String str) {
        if (E == 0) {
            E = t0.f(str);
        }
        return E;
    }

    public static void g(Context context) {
        try {
            c cVar = new c(context);
            if (com.mbridge.msdk.foundation.same.threadpool.a.d().getActiveCount() < 1) {
                com.mbridge.msdk.foundation.same.threadpool.a.d().execute(cVar);
            }
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage());
        }
    }

    public static void h(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                com.mbridge.msdk.foundation.tools.f.c(context);
            } else {
                new Handler(context.getMainLooper()).post(new a(context));
            }
        } catch (Exception e2) {
            o0.b("SameDiTool", "", e2);
        }
    }

    public static String i() {
        if (TextUtils.isEmpty(y)) {
            l(com.mbridge.msdk.foundation.controller.c.m().d());
        }
        return y;
    }

    public static String j() {
        com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA);
        return "";
    }

    public static void k() {
        try {
            Object objA = w0.a(com.mbridge.msdk.foundation.controller.c.m().d(), MBridgeConstans.SP_GA_ID, "");
            Object objA2 = w0.a(com.mbridge.msdk.foundation.controller.c.m().d(), MBridgeConstans.SP_GA_ID_LIMIT, 0);
            if (objA instanceof String) {
                String str = (String) objA;
                if (!TextUtils.isEmpty(str)) {
                    com.mbridge.msdk.foundation.tools.f.a(str);
                }
                if (objA2 instanceof Integer) {
                    com.mbridge.msdk.foundation.tools.f.a(((Integer) objA2).intValue());
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                o0.b("SameDiTool", e2.getMessage());
            }
        }
    }

    public static String l(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return null;
        }
        i(context);
        try {
            if (Looper.myLooper() != Looper.getMainLooper() || MBridgeConstans.DNT_GUA_ON_UI) {
                if (TextUtils.isEmpty(y)) {
                    E();
                }
                z(context);
            } else if (TextUtils.isEmpty(y)) {
                try {
                    y = WebSettings.getDefaultUserAgent(context);
                } catch (Throwable unused) {
                }
                if (TextUtils.isEmpty(y)) {
                    try {
                        Constructor declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
                        declaredConstructor.setAccessible(true);
                        y = ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                        declaredConstructor.setAccessible(false);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (TextUtils.isEmpty(y)) {
                        try {
                            y = new WebView(context).getSettings().getUserAgentString();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(y)) {
                        E();
                    }
                }
            } else {
                z(context);
            }
        } catch (Throwable th3) {
            o0.b("SameDiTool", th3.getMessage(), th3);
        }
        G(context);
        return y;
    }

    public static int m(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap mapV = v(context);
            return mapV.get("height") == null ? displayMetrics.heightPixels : ((Integer) mapV.get("height")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String n() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MODEL;
    }

    private static void o() {
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new f());
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage());
        }
    }

    public static String p() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MANUFACTURER;
    }

    public static String q(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                r = "";
            } else if (TextUtils.isEmpty(r)) {
                if (context == null) {
                    r = "";
                    return "";
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (t0.j(simOperator)) {
                    r = simOperator.substring(0, Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            r = "";
        }
        return r;
    }

    public static String r(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                s = "";
            } else if (TextUtils.isEmpty(s)) {
                if (context == null) {
                    s = "";
                    return r;
                }
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (t0.j(simOperator)) {
                    s = simOperator.substring(Math.min(3, simOperator.length()));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            s = "";
        }
        return s;
    }

    public static int s(Context context) {
        try {
            Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return t;
            }
            if (contextD == null) {
                return t;
            }
            if (t != -1) {
                g(contextD);
                return t;
            }
            t = 0;
            return t;
        } catch (Exception e2) {
            o0.b("SameDiTool", e2.getMessage(), e2);
            t = 0;
            return t;
        }
    }

    public static String t(Context context) {
        if (context == null) {
            return v;
        }
        try {
            if (!TextUtils.isEmpty(v)) {
                return v;
            }
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            v = str;
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String u() {
        try {
            if (TextUtils.isEmpty(I)) {
                Context contextD = com.mbridge.msdk.foundation.controller.c.m().d();
                long jA = j0.a();
                String strJ = j(contextD);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("1", strJ);
                    jSONObject.put("2", String.valueOf(G));
                    jSONObject.put("3", String.valueOf(jA));
                    jSONObject.put(Protocol.VAST_1_0_WRAPPER, "");
                    jSONObject.put("5", "");
                } catch (Exception e2) {
                    o0.b("SameDiTool", e2.getMessage());
                }
                String strB = com.mbridge.msdk.foundation.tools.a.b(jSONObject.toString());
                I = strB;
                if (strB == null) {
                    I = "";
                }
            }
        } catch (Exception e3) {
            o0.b("SameDiTool", e3.getMessage());
        }
        return I;
    }

    public static HashMap v(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            map.put("height", Integer.valueOf(displayMetrics.heightPixels));
            map.put("width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e2) {
            o0.b("SameDiTool", e2.getMessage(), e2);
        }
        return map;
    }

    public static String w() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER)) {
                return "";
            }
            if (TextUtils.isEmpty(x)) {
                new Thread(new d()).start();
                return x;
            }
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage(), th);
        }
        return x;
    }

    public static String x(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return "";
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "time_12_24");
        } catch (Exception e2) {
            o0.b("SameDiTool", e2.getMessage(), e2);
            return "";
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static String y(Context context) {
        return (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) ? String.valueOf(G) : "";
    }

    private static void z(Context context) {
        try {
            new Thread(new b(context)).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int A(Context context) {
        if (context == null) {
            return A;
        }
        int i = A;
        if (i != 0) {
            return i;
        }
        try {
            int i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            A = i2;
            return i2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String a(Context context, int i) {
        TelephonyManager telephonyManager;
        if (i == 0 || i == 9) {
            return "";
        }
        try {
            return (!com.mbridge.msdk.foundation.same.a.z || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static String j(Context context) {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                if (TextUtils.isEmpty(k)) {
                    k = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
                }
            } else {
                k = "";
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            k = "";
        }
        return k;
    }

    public static String B(Context context) {
        if (context == null) {
            return B;
        }
        try {
            if (TextUtils.isEmpty(B)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                B = str;
                return str;
            }
            return B;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int D() {
        if (n == -1) {
            n = t0.g() ? 1 : 0;
        }
        return n;
    }

    public static void d(int i) {
        q = i;
    }

    private static void i(Context context) {
        if (TextUtils.isEmpty(y)) {
            try {
                y = w0.a(context, "mbridge_ua", "").toString();
            } catch (Throwable th) {
                o0.b("SameDiTool", th.getMessage(), th);
            }
        }
    }

    public static int n(Context context) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA) || context == null) {
            return 0;
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            HashMap mapV = v(context);
            return mapV.get("width") == null ? displayMetrics.widthPixels : ((Integer) mapV.get("width")).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String p(Context context) {
        Locale locale;
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(p)) {
            if (context == null) {
                return "en-US";
            }
            try {
                if (context.getResources() == null || context.getResources().getConfiguration() == null || (locale = context.getResources().getConfiguration().locale) == null) {
                    return "en-US";
                }
                String languageTag = locale.toLanguageTag();
                p = languageTag;
                return languageTag;
            } catch (Throwable th) {
                o0.a("SameDiTool", th.getMessage());
                p = "en-US";
            }
        }
        return p;
    }

    public static boolean E(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int y() {
        try {
            if (!q0.a().a("v_a_d_p", false)) {
                return 0;
            }
            if (t0.i()) {
                o = 1;
            } else if (t0.j()) {
                o = 2;
            } else {
                o = 0;
            }
        } catch (Exception e2) {
            o = 0;
            o0.b("SameDiTool", e2.getMessage());
        }
        return o;
    }

    public static int m() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.VERSION.SDK_INT;
        }
        return -1;
    }

    public static int h() {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                return 0;
            }
            long j2 = F;
            if (j2 > 0) {
                return Long.valueOf((j2 / 1000) / 1000).intValue();
            }
            return -1;
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage(), th);
            return -1;
        }
    }

    public static float o(Context context) {
        Resources resources;
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER) && context != null && (resources = context.getResources()) != null) {
                return resources.getConfiguration().fontScale;
            }
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage());
        }
        return -1.0f;
    }

    public static String t() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.MANUFACTURER + " " + Build.MODEL;
    }

    public static String a(String str, Context context) {
        try {
            if (!TextUtils.isEmpty(j)) {
                return j;
            }
            if (!TextUtils.isEmpty(str) && context != null) {
                j = context.getPackageManager().getInstallerPackageName(str);
                o0.a("SameDiTool", "PKGSource:" + j);
            }
            return j;
        } catch (Exception e2) {
            o0.b("SameDiTool", e2.getMessage(), e2);
        }
    }

    public static String k(Context context) {
        try {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER) || context == null) {
                return "-1";
            }
            AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
            String str = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME).format((audioManager != null ? audioManager.getStreamVolume(3) : -1) / (audioManager != null ? audioManager.getStreamMaxVolume(3) : -1));
            return TextUtils.isEmpty(str) ? "-1" : str;
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage());
            return "-1";
        }
    }

    public static int C() {
        return q;
    }

    public static String x() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(H)) {
            long j2 = G;
            if (j2 > 0) {
                H = Math.ceil(Float.valueOf(j2 / 1.0737418E9f).doubleValue()) + "GB";
            }
        }
        return H;
    }

    public static String q() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        if (TextUtils.isEmpty(u)) {
            u = r() + "";
        }
        return u;
    }

    public static int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int v() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return 0;
        }
        long j2 = G;
        if (j2 > 0) {
            return Long.valueOf((j2 / 1000) / 1000).intValue();
        }
        return -1;
    }

    public static String s() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return "";
        }
        return Build.BRAND;
    }

    public static int w(Context context) {
        if (context == null) {
            return w;
        }
        if (w == 0) {
            try {
                w = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e2) {
                o0.b("SameDiTool", e2.getMessage());
            }
        }
        return w;
    }

    public static int z() {
        try {
            if (t0.i()) {
                return 1;
            }
            return t0.j() ? 2 : 0;
        } catch (Exception e2) {
            o0.b("SameDiTool", e2.getMessage());
            return 0;
        }
    }

    public static int u(Context context) {
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_OTHER) && context != null) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode() ? 1 : 0;
            }
            return -1;
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage());
            return -1;
        }
    }

    public static void g() {
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new e());
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage());
        }
    }

    public static String l() {
        String str;
        if (!TextUtils.isEmpty(m)) {
            return m;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th) {
            o0.b("SameDiTool", th.getMessage());
            str = null;
        }
        try {
            if (!TextUtils.isEmpty(str) && str.equals("harmony")) {
                jSONObject.put("osType", str);
                try {
                    Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
                    jSONObject.put("version", (String) cls2.getMethod(MobileAdsBridge.versionMethodName, new Class[0]).invoke(cls2, new Object[0]));
                } catch (Throwable th2) {
                    o0.b("SameDiTool", th2.getMessage());
                }
                try {
                    jSONObject.put("pure_state", Settings.Secure.getInt(com.mbridge.msdk.foundation.controller.c.m().d().getContentResolver(), "pure_mode_state", -1));
                } catch (Throwable th3) {
                    o0.b("SameDiTool", th3.getMessage());
                }
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    string = i0.b(string);
                }
                m = string;
            } else {
                m = "android";
            }
        } catch (Throwable th4) {
            o0.b("SameDiTool", th4.getMessage());
        }
        return m;
    }
}
