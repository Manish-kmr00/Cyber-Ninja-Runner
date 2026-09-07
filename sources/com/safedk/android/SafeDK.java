package com.safedk.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.json.b9;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.safedk.android.analytics.AppLovinBridge;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.StatsReporter;
import com.safedk.android.analytics.brandsafety.BannerFinder;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.safedk.android.analytics.brandsafety.InterstitialFinder;
import com.safedk.android.analytics.brandsafety.NativeFinder;
import com.safedk.android.analytics.brandsafety.b;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.g;
import com.safedk.android.analytics.brandsafety.i;
import com.safedk.android.analytics.brandsafety.q;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.internal.DeviceData;
import com.safedk.android.internal.d;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.annotations.Api;
import com.safedk.android.utils.j;
import com.safedk.android.utils.l;
import com.safedk.android.utils.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SafeDK {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f7941a = "com.safedk";
    private static final String c = "SafeDKMain";
    private static final String d = "SafeDK";
    private static final String e = "https://config.safedk.com/";
    private static final String f = "com.safedk.AppID";
    private static final String g = "com.safedk.ConfigPrefix";
    private static final String h = "com.safedk.APIPrefix";
    private static final String i = "com.safedk.DebugMode";
    private static final String j = "com.safedk.MaximumStatsSetSize";
    private static final String k = "com.safedk.AggregationThreshold";
    private static final boolean m = false;
    private static int n;
    private static boolean o;
    private static boolean q;
    private boolean p;
    private final Context s;
    private String v;
    private DeviceData w;
    private final Map<BrandSafetyUtils.AdType, b> x;
    private j y;
    private final AtomicBoolean z;
    private static final List<String> l = Arrays.asList("com.android.vending", "com.amazon.venezia", "com.sec.android.app.samsungapps");
    private static SafeDK r = null;
    private static final d t = new d();
    private static final AtomicBoolean u = new AtomicBoolean(false);
    private static final AtomicBoolean A = new AtomicBoolean(false);
    private static final AtomicBoolean B = new AtomicBoolean(false);
    private static Boolean C = false;
    private static Boolean D = false;
    static final ExecutorService b = Executors.newFixedThreadPool(2);

    public static String getSdkKey() {
        return "OzmgNDOixywgp2s07tNQN8D73W5dEleD4HLsLffuHHBzsNcIf_FfZygWRRPgaaSbGkbDO8cGw6F7LLT9THzHOy";
    }

    public static boolean a() {
        return q;
    }

    public static boolean b() {
        return u.get();
    }

    private SafeDK(Context context) {
        this.v = null;
        this.x = new HashMap();
        this.z = new AtomicBoolean(false);
        Logger.d(c, "SafeDK ctor started");
        this.s = context;
        AppLovinBridge.init(context);
        if (c()) {
            Logger.d(c, "Before reading shared prefs");
            this.w = new DeviceData(context, this.y);
        }
    }

    public boolean c() {
        try {
            synchronized (D) {
                if (!D.booleanValue() && A != null && !A.get()) {
                    Logger.d(c, "loading config from prefs");
                    this.y = new j(this.s.getSharedPreferences("SafeDKToggles", 0), false);
                }
                D = true;
            }
        } catch (IllegalStateException e2) {
            Logger.d(c, "IllegalStateException caught during loading of configuration from prefs, device may be locked", e2);
        } catch (Throwable th) {
            Logger.d(c, "Exception during loading of configuration from prefs : " + th.getMessage(), th);
        }
        return D.booleanValue();
    }

    private void ai() {
        try {
            ApplicationInfo applicationInfo = this.s.getPackageManager().getApplicationInfo(this.s.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                a(applicationInfo);
                b(applicationInfo);
                c(applicationInfo);
                d(applicationInfo);
            } else {
                Logger.e(c, "SafeDK meta data is missing from manifest file");
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.d(c, "Couldn't get application's meta data");
        }
    }

    private void a(ApplicationInfo applicationInfo) {
        try {
            try {
                PackageInfo packageInfo = this.s.getPackageManager().getPackageInfo(this.s.getPackageName(), 0);
                Logger.d(c, "package is: " + packageInfo.packageName + ", Installer Package Name is " + this.s.getPackageManager().getInstallerPackageName(packageInfo.packageName));
                q = l.contains(this.s.getPackageManager().getInstallerPackageName(packageInfo.packageName));
                o = (applicationInfo.flags & 2) != 0;
                Uri.Builder builderAppendQueryParameter = new Uri.Builder().appendPath("apps").appendPath("cfg").appendPath(extractAppIdentifier(applicationInfo.metaData)).appendPath(String.valueOf(packageInfo.versionCode)).appendQueryParameter(b9.h.U, String.valueOf(q));
                if (q) {
                    builderAppendQueryParameter = builderAppendQueryParameter.appendQueryParameter("versionName", packageInfo.versionName);
                }
                String string = builderAppendQueryParameter.build().toString();
                String strExtractUrlPrefix = extractUrlPrefix(applicationInfo.metaData);
                if (strExtractUrlPrefix != null && !strExtractUrlPrefix.isEmpty()) {
                    Logger.d(c, "apiURL Value from manifest is " + strExtractUrlPrefix + ". Setting new edge urls");
                    AppLovinBridge.receiveEdgeUrls(strExtractUrlPrefix, strExtractUrlPrefix);
                } else {
                    Logger.d(c, "no apiURL Value in manifest");
                }
                n = packageInfo.versionCode;
                String string2 = applicationInfo.metaData.getString(g);
                if (string2 == null) {
                    String str = getDefaultConfig() + string;
                    return;
                }
                if (!string2.endsWith(File.separator)) {
                    string2 = string2 + File.separator;
                }
                if (string.startsWith(File.separator)) {
                    string = string.substring(1);
                }
                Logger.d(c, "basePrefix != null, configUrl:" + (string2 + string));
            } catch (PackageManager.NameNotFoundException e2) {
                Logger.d(c, "Bad URL; won't update toggles");
            }
        } catch (Throwable th) {
            Logger.e(c, "Caught exception", th);
            new CrashReporter().caughtException(th);
        }
    }

    private static String extractAppIdentifier(Bundle metaData) {
        return metaData.getString(f);
    }

    private static String extractUrlPrefix(Bundle metaData) {
        return metaData.getString(h, "https://edge.safedk.com");
    }

    private static String getDefaultConfig() {
        return e;
    }

    public static String getProguardMD5() {
        return "";
    }

    private void b(ApplicationInfo applicationInfo) {
        boolean z = false;
        if (t.G() && (applicationInfo.metaData.getBoolean(i, false) || an())) {
            z = true;
        }
        Logger.setDebugMode(z);
    }

    public boolean d() {
        try {
            ApplicationInfo applicationInfo = SafeDKApplication.getAppContext().getPackageManager().getApplicationInfo(this.s.getPackageName(), 128);
            if (t.G()) {
                return applicationInfo.metaData.getBoolean(i, false) || an();
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    private void c(ApplicationInfo applicationInfo) {
        t.a(applicationInfo.metaData.getInt(j, 5000));
    }

    private void d(ApplicationInfo applicationInfo) {
        t.b(applicationInfo.metaData.getInt(k, 500));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        if (this.y != null) {
            this.v = UUID.randomUUID().toString();
            this.y.a(this.v);
        }
    }

    public static void a(final Context context, final Application application) {
        Logger.d(c, "start started");
        l.a(b, new Runnable() { // from class: com.safedk.android.SafeDK.1
            @Override // java.lang.Runnable
            public void run() {
                if (SafeDK.r == null) {
                    SafeDK unused = SafeDK.r = new SafeDK(context);
                    SafeDK.r.ao();
                    SafeDK.r.a(false);
                    SafeDK.r.b(true);
                } else {
                    Logger.d(SafeDK.c, "SafeDK already started");
                }
                SafeDK.a(application);
            }
        });
    }

    public static void a(Application application) {
        if (getInstance() != null && getInstance().p() && Build.VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(com.safedk.android.internal.b.getInstance());
        }
    }

    private void ak() {
        try {
            if (!B.get() && this.y != null) {
                String strP = this.y.p();
                Logger.d(c, "setIsFirstSession Current safedk version : 5.10.0 , stored version is " + strP);
                if (strP == null || !a.f7945a.equals(strP)) {
                    Logger.d(c, "setIsFirstSession setting is_first_session to true");
                    this.p = true;
                    this.y.c(a.f7945a);
                }
                B.set(true);
                return;
            }
            Logger.d(c, "setIsFirstSession already executed, value is " + this.p);
        } catch (Throwable th) {
            Logger.d(c, "setIsFirstSession Exception : " + th.getMessage(), th);
        }
    }

    public boolean e() {
        return this.p;
    }

    public static SafeDK getInstance() {
        return r;
    }

    public int f() {
        return t.a();
    }

    public void a(int i2) {
        t.K = i2;
    }

    public int g() {
        return t.b();
    }

    public int h() {
        return t.c();
    }

    public boolean i() {
        return t.d();
    }

    private void al() {
        synchronized (this.x) {
            if (!this.x.containsKey(BrandSafetyUtils.AdType.INTERSTITIAL)) {
                this.x.put(BrandSafetyUtils.AdType.INTERSTITIAL, new InterstitialFinder());
            }
            if (!this.x.containsKey(BrandSafetyUtils.AdType.BANNER) && q()) {
                this.x.put(BrandSafetyUtils.AdType.BANNER, new BannerFinder(getInstance().Z()));
                if (Logger.getDebugMode()) {
                    try {
                        Class.forName("com.safedk.android.analytics.brandsafety.shakemenu.ShakeMenuManager");
                    } catch (ClassNotFoundException e2) {
                    } catch (Exception e3) {
                    }
                }
            }
            if (!this.x.containsKey(BrandSafetyUtils.AdType.MREC) && q()) {
                this.x.put(BrandSafetyUtils.AdType.MREC, new q(getInstance().Z()));
            }
            if (!this.x.containsKey(BrandSafetyUtils.AdType.NATIVE)) {
                this.x.put(BrandSafetyUtils.AdType.NATIVE, new NativeFinder(getInstance().Z()));
            }
        }
    }

    public void j() {
        A.set(true);
        CreativeInfoManager.d();
        am();
        ak();
        Logger.d(c, "Loading singletons");
        g.a();
        FileUploadManager.a();
        i.a();
        al();
        this.z.set(true);
    }

    public void k() {
        if (StatsCollector.b()) {
            synchronized (this.x) {
                for (b bVar : this.x.values()) {
                    if (bVar.d() > 0) {
                        bVar.e();
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        try {
            if (t.G()) {
                Logger.i("SafeDK", "SafeDK Device ID: " + r.v + ", SafeDK version: " + getVersion() + ", isOnUiThread = " + n.c());
            }
            if (r == null) {
                Logger.d(c, "instance is null, existing");
                return;
            }
            r.b(false);
            if (!t.G()) {
                Logger.d(c, "SafeDK is disabled.");
                Logger.setDebugMode(false);
                com.safedk.android.internal.b.getInstance().clearBackgroundForegroundListeners();
                return;
            }
            ai();
            if (an()) {
                Logger.setDebugMode(true);
            }
            Logger.d(c, "Configuration download completed, configurationDownloadedSuccessfully=" + z + ", isMaxProcess " + z2 + ", isActive " + t.G() + ", packageId = " + getInstance().m().getPackageName());
            if (t.G() && z2 && !A.get()) {
                A.set(true);
                CreativeInfoManager.d();
                CreativeInfoManager.b();
                am();
                if (z) {
                    Logger.d(c, "Will attempt to load events from storage");
                    if (StatsCollector.c() != null) {
                        StatsCollector.c().d();
                    }
                } else {
                    ak();
                }
                ak();
                Logger.d(c, "Loading singletons");
                g.a();
                FileUploadManager.a();
                i.a();
                al();
            }
            this.z.set(true);
        } catch (Throwable th) {
            Logger.e(c, "Exception handling configuration event", th);
        }
    }

    private static void am() {
        if (!u.get()) {
            Logger.d(c, "Starting reporter thread");
            StatsCollector.a(true);
            int I = t.I();
            int iL = t.L();
            StatsReporter.a();
            StatsCollector.c().a(I, com.safedk.android.internal.b.getInstance().isInBackground(), iL, StatsReporter.b());
            StatsCollector.a(false);
            StatsCollector.b(getInstance().s());
            u.set(true);
            Logger.d(c, "Reporter thread started");
            return;
        }
        Logger.d(c, "Reporter thread already initialized, skipping");
    }

    public void a(Bundle bundle, boolean z) {
        Logger.d(c, "Updating configuration");
        boolean zA = t.a(bundle, true);
        if (zA) {
            a(bundle);
        }
        a(zA, z);
    }

    private void a(Bundle bundle) {
        if (this.y != null) {
            Logger.d(c, "Writing to shared preferences: " + bundle.toString());
            this.y.a(bundle);
        }
    }

    public static int l() {
        return n;
    }

    public Context m() {
        return this.s;
    }

    public boolean n() {
        return t.H() || an();
    }

    public boolean o() {
        return o;
    }

    public boolean p() {
        return t.G();
    }

    public boolean q() {
        return t.w();
    }

    public boolean r() {
        return t.x();
    }

    public boolean s() {
        return !t() && t.G();
    }

    public boolean t() {
        if (this.y == null) {
            return true;
        }
        return this.y.b();
    }

    private boolean an() {
        try {
            Set<String> setP = t.P();
            return setP.contains("*") || setP.contains(this.v);
        } catch (Throwable th) {
            Logger.e(c, "Caught exception", th);
            new CrashReporter().caughtException(th);
            return false;
        }
    }

    public static boolean u() {
        return t.K();
    }

    public List<String> v() {
        return t.y();
    }

    public List<String> w() {
        return t.z();
    }

    public DeviceData x() {
        return this.w;
    }

    public Map<BrandSafetyUtils.AdType, b> y() {
        return this.x;
    }

    public com.safedk.android.analytics.brandsafety.a a(BrandSafetyUtils.AdType adType) {
        return this.x.get(adType);
    }

    public InterstitialFinder z() {
        return (InterstitialFinder) a(BrandSafetyUtils.AdType.INTERSTITIAL);
    }

    public BannerFinder A() {
        return (BannerFinder) a(BrandSafetyUtils.AdType.BANNER);
    }

    public q B() {
        return (q) a(BrandSafetyUtils.AdType.MREC);
    }

    public NativeFinder C() {
        return (NativeFinder) a(BrandSafetyUtils.AdType.NATIVE);
    }

    public int D() {
        return t.e();
    }

    public int E() {
        return t.f();
    }

    public float F() {
        return t.g();
    }

    public float G() {
        return t.h();
    }

    public float H() {
        return t.i();
    }

    public boolean I() {
        return t.j();
    }

    public int J() {
        return t.k();
    }

    public long K() {
        return t.l();
    }

    public int L() {
        return t.m();
    }

    public int M() {
        return t.n();
    }

    public int N() {
        return t.p();
    }

    public boolean O() {
        return t.q();
    }

    public boolean P() {
        return t.o();
    }

    public int Q() {
        return t.T();
    }

    public int R() {
        return t.S();
    }

    public void a(final boolean z) {
        try {
            l.a(b, new Runnable() { // from class: com.safedk.android.SafeDK.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Logger.d(SafeDK.c, "Reading configuration from shared preferences, isMaxProcess = " + z);
                        if (SafeDK.this.y != null) {
                            SafeDK.this.v = SafeDK.this.y.a();
                            if (SafeDK.this.v == null) {
                                SafeDK.this.aj();
                            }
                            Bundle bundleE = SafeDK.this.y.e();
                            Logger.d(SafeDK.c, "configurationBundle loaded : " + bundleE.toString());
                            if (bundleE != null && !bundleE.isEmpty()) {
                                Logger.d(SafeDK.c, "Parsing configuration from shared preferences");
                                SafeDK.t.a(bundleE, false);
                            } else {
                                Logger.d(SafeDK.c, "Configuration bundle from storage is empty");
                            }
                            SafeDK.this.a(false, z);
                        }
                    } catch (Throwable th) {
                        Logger.e(SafeDK.c, th.getMessage(), th);
                        new CrashReporter().caughtException(th);
                    }
                }
            });
        } catch (Throwable th) {
            Logger.e(c, "Caught exception", th);
            new CrashReporter().caughtException(th);
        }
    }

    public void a(Activity activity) {
        Logger.d(c, "Starting interstitial finder in activity " + activity.getClass().getName());
        for (b bVar : this.x.values()) {
            if (bVar != null) {
                switch (bVar.a()) {
                    case INTERSTITIAL:
                        ((InterstitialFinder) bVar).c(activity);
                        break;
                    case BANNER:
                    case NATIVE:
                        bVar.b();
                        break;
                }
            }
        }
    }

    public void b(Activity activity) {
        Logger.d(c, "Stopping interstitial finder in activity " + activity.getClass().getName());
        for (b bVar : this.x.values()) {
            if (bVar != null) {
                if (bVar.a() == BrandSafetyUtils.AdType.INTERSTITIAL) {
                    ((InterstitialFinder) bVar).e(activity);
                } else {
                    bVar.c();
                }
            }
        }
    }

    public void c(Activity activity) {
        Logger.d(c, "Starting redirect monitoring in activity " + activity.getClass().getName());
        BannerFinder bannerFinder = (BannerFinder) a(BrandSafetyUtils.AdType.BANNER);
        if (bannerFinder != null) {
            bannerFinder.c(activity);
        }
    }

    public void a(String str) {
        synchronized (this.x) {
            for (b bVar : this.x.values()) {
                if (bVar != null) {
                    bVar.d(str);
                }
            }
        }
    }

    public void d(Activity activity) {
        if (p()) {
            Logger.d(c, "onForegroundActivity " + activity.getClass().getName());
            if (getInstance().c() && this.w == null) {
                Logger.d(c, "Before reading shared prefs");
                this.w = new DeviceData(this.s, this.y);
            }
        }
    }

    public void e(Activity activity) {
        if (p()) {
            Logger.d(c, "onBackgroundActivity " + activity.getClass().getName());
        }
    }

    public String b(String str) {
        String string = null;
        if (this.y != null) {
            Logger.d(c, "getSdkVersion getSdkVersion: " + str);
            JSONObject jSONObjectJ = this.y.j();
            if (jSONObjectJ != null) {
                Logger.d(c, "getSdkVersion sdkVersionsJson=" + jSONObjectJ.toString());
            }
            try {
                JSONObject jSONObject = jSONObjectJ.getJSONObject(str);
                if (jSONObject == null) {
                    Logger.d(c, "getSdkVersion sdkData is null");
                } else {
                    Logger.d(c, "getSdkVersion sdkData : " + jSONObject.toString());
                    string = jSONObject.getString("sdk_version");
                    Logger.d(c, "getSdkVersion version : " + string);
                    Logger.d(c, "return sdk version: " + string);
                }
            } catch (Throwable th) {
            }
        }
        return string;
    }

    public JSONObject S() {
        if (this.y == null) {
            return null;
        }
        return this.y.j();
    }

    @Api
    public String getUserId() {
        return this.v;
    }

    public static String getVersion() {
        return a.f7945a;
    }

    public static boolean T() {
        return a.f7945a.contains(DownloadCommon.DOWNLOAD_REPORT_RETRY_COUNT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        boolean zS = s();
        Logger.d(c, "notifyMonitorUserActivityUpdate shouldMonitorUser is " + zS);
        CreativeInfoManager.a(zS);
        com.safedk.android.internal.b.setActiveMode(zS);
        i.a(zS);
        if (z && !s()) {
            synchronized (this.x) {
                for (b bVar : this.x.values()) {
                    if (bVar != null) {
                        bVar.a((String) null);
                    }
                }
                this.x.clear();
            }
        }
    }

    public long U() {
        return t.U();
    }

    public int V() {
        return t.V();
    }

    public ArrayList<String> W() {
        return t.W();
    }

    public float X() {
        return t.r();
    }

    public float Y() {
        return t.s();
    }

    public int Z() {
        return t.t();
    }

    public int aa() {
        return t.u();
    }

    public int ab() {
        return t.v();
    }

    public static boolean ac() {
        return C.booleanValue();
    }

    public static void ad() {
        Logger.d(c, "setMaxInitialized started");
        C = true;
        if (!b()) {
            am();
        }
    }

    public static boolean ae() {
        boolean z = r != null && t != null && t.G() && C.booleanValue();
        if (!z) {
            Logger.d(c, "isSafeDKFullyInitialized returned false , instance = " + r + ",config = " + t + ", config.isActive() = " + t.G() + ", SafeDK.isMaxInitialized = " + C);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        for (BrandSafetyUtils.AdType adType : BrandSafetyUtils.AdType.values()) {
            c(adType.toString());
        }
        c("Files");
    }

    private void c(String str) {
        File dir = m().getDir("SafeDK_" + str, 0);
        if (dir.exists() && dir.isDirectory()) {
            File file = new File(af() + str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] fileArrListFiles = dir.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    file2.renameTo(new File(file, file2.getName()));
                }
            }
            dir.delete();
        }
    }

    public String af() {
        return m().getFilesDir() + File.separator + "safedk" + File.separator;
    }
}
