package com.json;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.json.environment.ContextProvider;
import com.json.environment.IronSourceSharedPreferencesUtilities;
import com.json.mediationsdk.logger.IronLog;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: loaded from: classes11.dex */
public class ab implements nf, nf.a {
    private static final String A = "browser_user_agent";
    private static final String B = "browser_user_agent_time";
    private static final String C = "IABTCF_gdprApplies";
    private static final String D = "IABTCF_TCString";
    private static final String E = "IABTCF_AddtlConsent";
    private static final String j = "android";
    private static final String k = "com.google.android.gms.permission.AD_ID";
    private static final String l = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static final String m = "com.google.android.gms.appset.AppSet";
    private static final String n = "com.google.android.gms.tasks.OnSuccessListener";
    private static final String o = "getAdvertisingIdInfo";
    private static final String p = "getClient";
    private static final String q = "getAppSetIdInfo";
    private static final String r = "addOnSuccessListener";
    private static final String s = "getId";
    private static final String t = "isLimitAdTrackingEnabled";
    private static final String u = "Mediation_Shared_Preferences";
    private static final String v = "supersonic_shared_preferen";
    private static final String w = "cachedUUID";
    private static final String x = "auid";
    private static final String y = "unityads-installinfo";
    private static final String z = "unityads-idfi";
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = "";
    private boolean f = false;
    private String g = "";
    private volatile String h;
    private volatile String i;

    class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            if (objArr == null) {
                return null;
            }
            try {
                if (objArr.length <= 0 || (obj2 = objArr[0]) == null) {
                    return null;
                }
                String string = obj2.getClass().getMethod(ab.s, new Class[0]).invoke(objArr[0], new Object[0]).toString();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                ab.this.g = string;
                return null;
            } catch (Exception e) {
                o9.d().a(e);
                return null;
            }
        }
    }

    private String O(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objQ = Q(context);
        return objQ.getClass().getMethod(s, new Class[0]).invoke(objQ, new Object[0]).toString();
    }

    private void P(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName(m);
        Object objInvoke = cls.getMethod(p, Context.class).invoke(cls, context);
        Object objInvoke2 = objInvoke.getClass().getMethod(q, new Class[0]).invoke(objInvoke, new Object[0]);
        Class<?> cls2 = Class.forName(n);
        objInvoke2.getClass().getMethod(r, cls2).invoke(objInvoke2, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls2}, new a()));
    }

    private Object Q(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName(l);
        return cls.getMethod(o, Context.class).invoke(cls, context);
    }

    private String R(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objQ = Q(context);
        return String.valueOf(((Boolean) objQ.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(objQ, new Object[0])).booleanValue());
    }

    private String S(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, u, A, "");
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    private long T(Context context) {
        try {
            return Long.parseLong(IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, u, B, String.valueOf(-1L)));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1L;
        }
    }

    private long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    private void a(Context context, String str) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, u, A, str);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void b(Context context, long j2) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, u, B, String.valueOf(j2));
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private boolean b(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i = 0; i < 8; i++) {
                if (new File(strArr[i] + str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            o9.d().a(e);
            return false;
        }
    }

    @Override // com.json.nf
    public int A(Context context) {
        int iL = L(context);
        int iH = H(context);
        return (((iL == 0 || iL == 2) && iH == 2) || ((iL == 1 || iL == 3) && iH == 1)) ? 2 : 1;
    }

    @Override // com.json.nf
    public int B(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getIntFromDefaultSharedPrefs(context, "IABTCF_gdprApplies", -1);
        } catch (Exception e) {
            o9.d().a(e);
            return -1;
        }
    }

    @Override // com.json.nf
    public int C(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    @Override // com.json.nf
    public String D(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, "IABTCF_TCString", null);
        } catch (Exception e) {
            o9.d().a(e);
            return null;
        }
    }

    @Override // com.json.nf
    public boolean E(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    @Override // com.json.nf
    public String F(Context context) {
        return Locale.getDefault().toString();
    }

    @Override // com.json.nf
    public String G(Context context) {
        if (xa.f4585a.c()) {
            try {
                P(context);
                if (!TextUtils.isEmpty(this.g)) {
                    return this.g;
                }
            } catch (Exception e) {
                o9.d().a(e);
            }
        }
        return "";
    }

    @Override // com.json.nf
    public int H(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    @Override // com.json.nf
    public String I(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    @Override // com.json.nf
    public boolean J(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        return intExtra == 2 || intExtra == 5;
    }

    @Override // com.json.nf
    public String K(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, E, null);
        } catch (Exception e) {
            o9.d().a(e);
            return null;
        }
    }

    @Override // com.json.nf
    public int L(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    @Override // com.json.nf
    public synchronized String M(Context context) {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        if (IronSourceSharedPreferencesUtilities.getBooleanFromSharedPrefs(context, u, nf.f4088a, true)) {
            String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, u, w, "");
            if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                String string = UUID.randomUUID().toString();
                this.b = string;
                IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, u, w, string);
            } else {
                this.b = stringFromSharedPrefs;
            }
        }
        return this.b;
    }

    @Override // com.json.nf
    public int N(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    @Override // com.json.nf
    public int a() {
        return k();
    }

    @Override // com.json.nf
    public long a(String str) {
        return a(new File(str));
    }

    @Override // com.json.nf
    public Long a(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Long.valueOf(memoryInfo.threshold);
    }

    @Override // com.json.nf
    public String a(Context context) {
        String strR;
        try {
            if (!xa.f4585a.a()) {
                strR = R(context);
            } else {
                if (this.h == null) {
                    String strR2 = R(context);
                    if (TextUtils.isEmpty(strR2)) {
                        return strR2;
                    }
                    this.h = strR2;
                    return strR2;
                }
                strR = this.h;
            }
            return strR;
        } catch (Exception e) {
            o9.d().a(e);
            return null;
        }
    }

    @Override // com.ironsource.nf.a
    public void a(Context context, long j2) {
        if (context != null) {
            if (!new hv(new q9.a()).a(T(context), j2)) {
                String strS = S(context);
                this.e = strS;
                this.f = !strS.isEmpty();
            }
            if (this.e.isEmpty()) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    this.e = defaultUserAgent;
                    a(context, defaultUserAgent);
                    if (j2 > 0) {
                        b(context, System.currentTimeMillis());
                    }
                } catch (Exception e) {
                    o9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }
    }

    @Override // com.json.nf
    public boolean a(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }

    @Override // com.json.nf
    public Boolean b(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Boolean.valueOf(memoryInfo.lowMemory);
    }

    @Override // com.json.nf
    public String b() {
        String id = TimeZone.getDefault().getID();
        return id != null ? id : "";
    }

    @Override // com.json.nf
    public String b(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    @Override // com.json.nf
    public Long c(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Long.valueOf(memoryInfo.availMem);
    }

    @Override // com.json.nf
    public boolean c() {
        try {
            return "mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable();
        } catch (Exception e) {
            o9.d().a(e);
            return false;
        }
    }

    @Override // com.json.nf
    public boolean c(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.json.nf
    public int d() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    @Override // com.json.nf
    public boolean d(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.json.nf
    public File e(Context context) {
        return context.getExternalCacheDir();
    }

    @Override // com.json.nf
    public String e() {
        return Build.MODEL;
    }

    @Override // com.json.nf
    public String f(Context context) {
        if (context == null) {
            return "";
        }
        int iN = N(context);
        if (iN != 0) {
            if (iN != 1) {
                if (iN != 11) {
                    if (iN != 12) {
                        switch (iN) {
                            case 6:
                            case 8:
                                break;
                            case 7:
                            case 9:
                                break;
                            default:
                                return "none";
                        }
                    }
                }
            }
            return "portrait";
        }
        return "landscape";
    }

    @Override // com.json.nf
    public boolean f() {
        return b("su");
    }

    @Override // com.json.nf
    public String g() {
        return Build.MANUFACTURER;
    }

    @Override // com.json.nf
    public boolean g(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @Override // com.json.nf
    public float h() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    @Override // com.json.nf
    public long h(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    @Override // com.json.nf
    public String i() {
        try {
            return System.getProperty("os.arch");
        } catch (SecurityException e) {
            IronLog.INTERNAL.error(e.getMessage());
            return null;
        }
    }

    @Override // com.json.nf
    public String i(Context context) {
        return s(context) ? "Tablet" : "Phone";
    }

    @Override // com.json.nf
    public long j() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    @Override // com.json.nf
    public String j(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : telephonyManager.getNetworkOperatorName();
    }

    @Override // com.json.nf
    public int k() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    @Override // com.json.nf
    public File k(Context context) {
        return context.getCacheDir();
    }

    @Override // com.json.nf
    public int l() {
        return Build.VERSION.SDK_INT;
    }

    @Override // com.json.nf
    public int l(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return intentRegisterReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    @Override // com.json.nf
    public float m(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        try {
            return audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1.0f;
        }
    }

    @Override // com.json.nf
    public String m() {
        return "android";
    }

    @Override // com.json.nf
    public long n() {
        if (c()) {
            return a(Environment.getExternalStorageDirectory());
        }
        return 0L;
    }

    @Override // com.json.nf
    public String n(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : telephonyManager.getNetworkCountryIso();
    }

    @Override // com.json.nf
    public long o() {
        return a(Environment.getDataDirectory());
    }

    @Override // com.json.nf
    public List<ApplicationInfo> o(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    @Override // com.json.nf
    public String p() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.json.nf
    public String p(Context context) {
        String strO;
        xa xaVar = xa.f4585a;
        if (!xaVar.b()) {
            return null;
        }
        try {
            if (!xaVar.a()) {
                strO = O(context);
            } else {
                if (this.i == null) {
                    String strO2 = O(context);
                    if (TextUtils.isEmpty(strO2)) {
                        return strO2;
                    }
                    this.i = strO2;
                    return strO2;
                }
                strO = this.i;
            }
            return strO;
        } catch (Exception e) {
            o9.d().a(e);
            return null;
        }
    }

    @Override // com.json.nf
    public int q() {
        return -(TimeZone.getDefault().getOffset(j()) / 60000);
    }

    @Override // com.json.nf
    public boolean q(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.json.nf
    public String r(Context context) {
        try {
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME"), 65536);
            if (resolveInfoResolveActivity != null) {
                return resolveInfoResolveActivity.activityInfo.packageName;
            }
            return null;
        } catch (Throwable th) {
            o9.d().a(th);
            return null;
        }
    }

    @Override // com.json.nf
    public boolean r() {
        return this.f;
    }

    @Override // com.json.nf
    public int s() {
        return d();
    }

    @Override // com.json.nf
    public boolean s(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }

    @Override // com.json.nf
    public String t() {
        try {
            return this.e.isEmpty() ? S(ContextProvider.getInstance().getApplicationContext()) : this.e;
        } catch (Exception e) {
            o9.d().a(e);
            return "";
        }
    }

    @Override // com.json.nf
    public synchronized String t(Context context) {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        if (context == null) {
            return "";
        }
        String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "supersonic_shared_preferen", "auid", "");
        this.c = stringFromSharedPrefs;
        if (TextUtils.isEmpty(stringFromSharedPrefs)) {
            String string = UUID.randomUUID().toString();
            this.c = string;
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "supersonic_shared_preferen", "auid", string);
        }
        return this.c;
    }

    @Override // com.json.nf
    public File u(Context context) {
        return context.getExternalFilesDir(null);
    }

    @Override // com.json.nf
    public boolean v(Context context) {
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (str.equalsIgnoreCase(k)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            o9.d().a(e);
            return false;
        }
    }

    @Override // com.json.nf
    public String w(Context context) {
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        if (context == null) {
            return null;
        }
        String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "unityads-installinfo", "unityads-idfi", null);
        this.d = stringFromSharedPrefs;
        return stringFromSharedPrefs;
    }

    @Override // com.json.nf
    public File x(Context context) {
        return context.getFilesDir();
    }

    @Override // com.json.nf
    public int y(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("level", -1) : 0;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra == -1 || intExtra2 == -1) {
                return -1;
            }
            return (int) ((intExtra / intExtra2) * 100.0f);
        } catch (Exception e) {
            o9.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1;
        }
    }

    @Override // com.json.nf
    public ActivityManager.MemoryInfo z(Context context) {
        if (context == null || !mm.S().d().a()) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return null;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }
}
