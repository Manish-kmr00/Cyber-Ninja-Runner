package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.json.yk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class gbA {
    private static final HashSet<String> BSW;
    private static String DX;
    private static String Sn;
    private static final byte[] WV;
    private static final byte[] Wx;
    public static Integer pA;
    private static final ExecutorService Og = Executors.newSingleThreadExecutor();
    private static volatile boolean KZx = false;
    private static final AtomicInteger ZZv = new AtomicInteger(0);
    private static volatile String ML = "";
    private static final ReentrantLock JG = new ReentrantLock();
    private static String SD = null;
    private static String omh = null;
    private static String Bzk = null;
    private static final HashSet<String> SGo = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));

    public static boolean JG(int i) {
        return i == 6;
    }

    public static boolean ML(int i) {
        return i == 5;
    }

    public static int SD(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 5) {
            return 4;
        }
        if (i != 6) {
            return i;
        }
        return 5;
    }

    public static boolean ZZv(int i) {
        return i == 4;
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, View view) {
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        BSW = hashSet;
        hashSet.addAll(Arrays.asList("America/Eirunepe", "America/Rio_Branco", "America/Boa_Vista", "America/Campo_Grande", "America/Cuiaba", "America/Manaus", "America/Porto_Velho", "America/Araguaina", "America/Bahia", "America/Belem", "America/Fortaleza", "America/Maceio", "America/Recife", "America/Santarem", "America/Sao_Paulo", "America/Noronha"));
        pA = null;
        WV = new byte[]{108, 111, 97, 100, 105, 110, 103};
        Wx = new byte[]{97, 114, 98, 105, 116, 114, 97, 103, 101};
    }

    public static Intent pA(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean Og(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean pA(Context context, Intent intent) {
        return KZx(context, intent) > 0;
    }

    public static Og Og(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty()) {
            return new Og(null, 0);
        }
        ActivityInfo activityInfo = listQueryIntentActivities.get(0).activityInfo;
        if (activityInfo != null && !TextUtils.isEmpty(activityInfo.packageName) && !TextUtils.isEmpty(activityInfo.name)) {
            return new Og(new ComponentName(activityInfo.packageName, activityInfo.name), listQueryIntentActivities.size());
        }
        return new Og(null, listQueryIntentActivities.size());
    }

    public static class Og {
        public final int Og;
        public final ComponentName pA;

        public Og(ComponentName componentName, int i) {
            this.pA = componentName;
            this.Og = i;
        }
    }

    public static int KZx(Context context, Intent intent) {
        if (intent == null) {
            return 0;
        }
        try {
            return context.getPackageManager().queryIntentActivities(intent, 65536).size();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean pA() {
        return (com.bytedance.sdk.openadsdk.core.DX.pA() == null || com.bytedance.sdk.openadsdk.core.DX.pA().ZZv()) ? false : true;
    }

    public static boolean KZx(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                com.bytedance.sdk.component.utils.Og.pA(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String pA(int i) {
        if (i == 1) {
            return "embeded_ad";
        }
        if (i == 2) {
            return "banner_ad";
        }
        if (i == 3) {
            return "interaction";
        }
        if (i == 4) {
            return "open_ad";
        }
        if (i == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i != 7) {
            return null;
        }
        return "rewarded_video";
    }

    public static String Og(int i) {
        if (i == 1) {
            return "embeded_ad_landingpage";
        }
        if (i == 2) {
            return "banner_ad_landingpage";
        }
        if (i == 3) {
            return "interaction_landingpage";
        }
        if (i == 4) {
            return "splash_ad_landingpage";
        }
        if (i == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i == 7) {
            return "rewarded_video_landingpage";
        }
        return "unknow";
    }

    public static String pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo == null) {
            return null;
        }
        try {
            return KZx(yfo.PKZ());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int Og(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo == null) {
            return -1;
        }
        int iPKZ = yfo.PKZ();
        int i = 1;
        if (iPKZ == 1) {
            return 2;
        }
        if (iPKZ == 3) {
            return 4;
        }
        if (iPKZ != 5) {
            i = 7;
            if (iPKZ != 7) {
                return iPKZ != 8 ? -1 : 5;
            }
        }
        return i;
    }

    public static int pA(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "open_ad":
            case "cache_splash_ad":
                return 4;
            case "fullscreen_interstitial_ad":
                return 5;
            case "interaction":
                return 3;
            default:
                return 1;
        }
    }

    public static String KZx(int i) {
        if (i == 1) {
            return "banner_ad";
        }
        if (i == 2) {
            return "interaction";
        }
        if (i == 3 || i == 4) {
            return "open_ad";
        }
        if (i == 7) {
            return "rewarded_video";
        }
        if (i == 8) {
            return "fullscreen_interstitial_ad";
        }
        return "embeded_ad";
    }

    public static String Og() {
        String str = "unKnow";
        com.bytedance.sdk.openadsdk.multipro.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA());
        try {
            String strOg = com.bytedance.sdk.openadsdk.multipro.Og.KZx() ? com.bytedance.sdk.openadsdk.multipro.ZZv.pA.Og("sp_multi_ua_data", "android_system_ua", "unKnow") : com.bytedance.sdk.openadsdk.core.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()).Og("android_system_ua", "unKnow");
            if (strOg != null && !"unKnow".equals(strOg)) {
                return strOg;
            }
            FutureTask futureTask = new FutureTask(new pA(2));
            Og.execute(futureTask);
            str = (String) futureTask.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.WV.pA("getUA", " getAndroidSystemUA userAgent".concat(String.valueOf(str)));
        return str;
    }

    public static String KZx() {
        if (!TextUtils.isEmpty(ML)) {
            return ML;
        }
        com.bytedance.sdk.openadsdk.multipro.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA());
        String strPA = com.bytedance.sdk.openadsdk.core.Bzk.pA("sdk_local_web_ua", 86400000L);
        ML = strPA;
        if (TextUtils.isEmpty(strPA)) {
            ReentrantLock reentrantLock = JG;
            try {
                if (reentrantLock.tryLock()) {
                    try {
                        if (TextUtils.isEmpty(ML)) {
                            ML = WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.aBv.pA());
                        }
                        com.bytedance.sdk.openadsdk.core.Bzk.pA("sdk_local_web_ua", ML);
                        reentrantLock.unlock();
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "", e);
                        JG.unlock();
                    } catch (NoClassDefFoundError e2) {
                        com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "", e2);
                        JG.unlock();
                    }
                }
            } catch (Throwable th) {
                JG.unlock();
                throw th;
            }
        }
        return ML;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.gbA$1, reason: invalid class name */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(gbA.ML)) {
                    com.bytedance.sdk.component.Bzk.ZZv zZv = new com.bytedance.sdk.component.Bzk.ZZv(com.bytedance.sdk.openadsdk.core.aBv.pA());
                    zZv.setWebViewClient(new com.bytedance.sdk.component.Bzk.ZZv.pA());
                    String unused = gbA.ML = zZv.getUserAgentString();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "", e);
            } catch (NoClassDefFoundError e2) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String du() {
        try {
            WebView webView = new WebView(com.bytedance.sdk.openadsdk.core.aBv.pA());
            webView.setWebViewClient(new com.bytedance.sdk.component.Bzk.ZZv.pA());
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                    com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_ua_data", "webview_ua", userAgentString);
                } else {
                    com.bytedance.sdk.openadsdk.core.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()).pA("webview_ua", userAgentString);
                }
            }
            return userAgentString;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    public static class pA implements Callable<String> {
        private final int pA;

        pA(int i) {
            this.pA = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public synchronized String call() throws Exception {
            String strOg;
            strOg = "unKnow";
            int i = this.pA;
            if (i == 1) {
                strOg = KZx();
            } else if (i == 2) {
                strOg = Og();
            }
            return strOg;
        }

        private String Og() {
            String property;
            Throwable th;
            try {
                property = System.getProperty("http.agent");
                if (property != null) {
                    try {
                        if (!"unKnow".equals(property)) {
                            if (com.bytedance.sdk.openadsdk.multipro.Og.KZx()) {
                                com.bytedance.sdk.openadsdk.multipro.ZZv.pA.pA("sp_multi_ua_data", "android_system_ua", property);
                            } else {
                                com.bytedance.sdk.openadsdk.core.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()).pA("android_system_ua", property);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.bytedance.sdk.component.utils.WV.pA("getUA", "e:" + th.getMessage());
                    }
                }
                gbA.TX();
            } catch (Throwable th3) {
                property = "unKnow";
                th = th3;
            }
            return property;
        }

        private synchronized String KZx() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.gbA.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    strArr[0] = gbA.du();
                    String str = strArr[0];
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", e.getMessage());
            }
            return strArr[0];
        }
    }

    public static String ZZv() {
        return WQf.pA();
    }

    public static synchronized String ML() {
        Context contextPA;
        if (TextUtils.isEmpty(SD) && (contextPA = com.bytedance.sdk.openadsdk.core.aBv.pA()) != null) {
            try {
                SD = contextPA.getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return SD;
    }

    public static synchronized String JG() {
        if (TextUtils.isEmpty(omh) && com.bytedance.sdk.openadsdk.core.aBv.pA() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.aBv.pA().getPackageManager().getPackageInfo(ML(), 0);
                omh = String.valueOf(packageInfo.versionCode);
                Bzk = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return omh;
    }

    public static synchronized String SD() {
        if (TextUtils.isEmpty(Bzk) && com.bytedance.sdk.openadsdk.core.aBv.pA() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.aBv.pA().getPackageManager().getPackageInfo(ML(), 0);
                omh = String.valueOf(packageInfo.versionCode);
                Bzk = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return Bzk;
    }

    public static String pA(Context context) {
        String strOg = com.bytedance.sdk.openadsdk.core.KZx.pA(context).Og("total_memory", (String) null);
        if (strOg == null || Og(strOg) <= 0) {
            strOg = KZx("MemTotal");
            if (Og(strOg) <= 0) {
                strOg = omh();
            }
            com.bytedance.sdk.openadsdk.core.KZx.pA(context).pA("total_memory", strOg);
        }
        return strOg;
    }

    public static long Og(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String omh() {
        try {
            ActivityManager activityManager = (ActivityManager) com.bytedance.sdk.openadsdk.core.aBv.pA().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.totalMem > 0) {
                return String.valueOf(memoryInfo.totalMem / 1024);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String Og(Context context) {
        return com.bytedance.sdk.openadsdk.core.KZx.pA(context).Og("total_memory", "0");
    }

    public static String Bzk() {
        return KZx("MemTotal");
    }

    public static String KZx(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MEM_INFO);
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", th.getMessage());
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                        }
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = line.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static long KZx(Context context) {
        return com.bytedance.sdk.openadsdk.core.KZx.pA(context).Og("total_internal_storage", 0L).longValue();
    }

    public static long SGo() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long ZZv(Context context) {
        return com.bytedance.sdk.openadsdk.core.KZx.pA(context).Og("free_internal_storage", 0L).longValue();
    }

    public static long ML(Context context) {
        return com.bytedance.sdk.openadsdk.core.KZx.pA(context).Og("total_sdcard_storage", 0L).longValue();
    }

    public static long BSW() {
        try {
            if (!eG()) {
                return 0L;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", th.getMessage());
            return 0L;
        }
    }

    private static boolean eG() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int JG(Context context) {
        return com.bytedance.sdk.openadsdk.core.KZx.pA(context).Og("is_root", -1);
    }

    public static boolean WV() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String ZZv(String str) {
        return pA(str, false);
    }

    public static String pA(String str, boolean z) {
        String str2;
        String strLT = com.bytedance.sdk.openadsdk.core.aBv.ZZv().lT();
        if (TextUtils.isEmpty(strLT)) {
            int iOX = oX();
            if (iOX == 1 || iOX == 2) {
                str2 = "https://pangolin16.sgsnssdk.com" + str;
            } else {
                str2 = "https://pangolin16.isnssdk.com" + str;
            }
            if (!z) {
                return rB.pA(str2);
            }
            return Wx(str2);
        }
        String strPA = "https://" + strLT + str;
        if (rB.pA() && !z) {
            strPA = rB.pA(strPA);
        }
        return z ? Wx(strPA) : strPA;
    }

    private static String Wx(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter(yk.SESSION_HISTORY_KEY_AD_ID, "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", JG()).toString();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", e.getMessage());
            return str;
        }
    }

    public static String ML(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.aBv.ZZv().rB();
        }
        if (!TextUtils.isEmpty(str)) {
            return !str.startsWith("http") ? "https://".concat(String.valueOf(str)) : str;
        }
        if (oX() == 2) {
            return "https://log.sgsnssdk.com/service/2/app_log/";
        }
        return "https://log-mva.isnssdk.com/service/2/app_log/";
    }

    public static String Wx() {
        return String.format(Constants.BASE_URL_NO_SUB_DOMAIN_FORMAT, "log.byteoversea.com/service/2/app_log_test/");
    }

    public static String Sn() {
        int iOX = oX();
        if (iOX == 1 || iOX == 2) {
            return "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/renderer/package_sg.json";
        }
        return "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-va/renderer/package_va.json";
    }

    public static String DX() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", e.toString());
            return "";
        }
    }

    public static int oX() {
        try {
            String id = TimeZone.getDefault().getID();
            if (SGo.contains(id)) {
                return 2;
            }
            if (id != null && id.startsWith("Asia/")) {
                return 2;
            }
            if (id == null || !id.startsWith("Europe/")) {
                return (id == null || !id.startsWith("America/") || BSW.contains(id)) ? 3 : 5;
            }
            return 4;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", th.toString());
            return 0;
        }
    }

    public static String SD(Context context) {
        try {
            return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", e.toString());
            return "";
        }
    }

    public static int aBv() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String XT() {
        int i = -aBv();
        if (i >= 0) {
            return "Etc/GMT+".concat(String.valueOf(i));
        }
        return "Etc/GMT".concat(String.valueOf(i));
    }

    public static JSONObject pA(boolean z, com.bytedance.sdk.openadsdk.core.model.yFO yfo, long j, long j2, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("creative_id", yfo.nCO());
            jSONObject.put("load_time", j);
            com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = yfo.Bf();
            if (ogBf != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, ogBf.ML());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, ogBf.Bzk());
            }
            if (!z) {
                jSONObject.put("error_code", j2);
                if (TextUtils.isEmpty(str)) {
                    str = "unknown";
                }
                jSONObject.put("error_message", str);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "getVideoDownload json error", e);
        }
        return jSONObject;
    }

    public static JSONObject pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, long j, com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
        if (yfo == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("creative_id", yfo.nCO());
            jSONObject.put("buffers_time", j);
            com.bykv.vk.openvk.pA.pA.pA.KZx.Og ogBf = yfo.Bf();
            if (ogBf != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, ogBf.ML());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, ogBf.Bzk());
            }
            pA(jSONObject, pAVar);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", "getVideoAction json error", e);
        }
        return jSONObject;
    }

    private static void pA(JSONObject jSONObject, com.bykv.vk.openvk.pA.pA.pA.pA pAVar) {
        if (jSONObject.has(CampaignEx.JSON_KEY_VIDEO_RESOLUTION) || pAVar == null) {
            return;
        }
        try {
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(pAVar.ZZv()), Integer.valueOf(pAVar.ML())));
        } catch (Throwable unused) {
        }
    }

    public static boolean JG(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str) {
        if (yfo != null) {
            try {
                String strDC = yfo.dC();
                if (TextUtils.isEmpty(strDC) && yfo.Itl() != null && yfo.Itl().KZx() == 1 && !TextUtils.isEmpty(yfo.Itl().Og())) {
                    strDC = yfo.Itl().Og();
                }
                String str2 = strDC;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.rB.pA(com.bytedance.sdk.openadsdk.core.aBv.pA(), str2, yfo, pA(str), str, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean KZx(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (yfo == null) {
            return true;
        }
        int iOg = com.bytedance.sdk.openadsdk.core.aBv.ZZv().Og(yfo.Wf());
        int iKZx = com.bytedance.sdk.component.utils.DX.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA());
        if (iOg == 1) {
            return ZZv(iKZx);
        }
        if (iOg == 2) {
            return ML(iKZx) || ZZv(iKZx) || JG(iKZx);
        }
        if (iOg != 3) {
            return iOg != 5 || ZZv(iKZx) || JG(iKZx);
        }
        return false;
    }

    public static boolean omh(Context context) {
        if (context != null) {
            return !(context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30);
        }
        throw new IllegalArgumentException("params context is null");
    }

    public static String SD(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static void pA(String str, String str2, Context context) {
        int i;
        if (TextUtils.isEmpty(str2) || !Bzk(context)) {
            return;
        }
        int length = str2.length();
        int i2 = 1;
        if (length % 3572 == 0) {
            i = length / 3572;
        } else {
            i = (length / 3572) + 1;
        }
        int i3 = 3572;
        int i4 = 0;
        while (i2 <= i) {
            if (i3 < length) {
                Log.d(str, i + "-" + i2 + ":" + str2.substring(i4, i3));
                i2++;
                i4 = i3;
                i3 += 3572;
            } else {
                Log.d(str, i + "-" + i2 + ":" + str2.substring(i4));
                return;
            }
        }
    }

    public static boolean Bzk(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    public static int SGo(Context context) {
        int i = -1;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
            new Object[]{"targetSdkVersion = ", Integer.valueOf(i)};
            return i;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", th.getMessage());
            return i;
        }
    }

    public static long BSW(Context context) {
        int i = -1;
        try {
            i = context.getApplicationInfo().minSdkVersion;
            new Object[]{"minSdkVersion = ", Integer.valueOf(i)};
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", th.getMessage());
        }
        return i;
    }

    public static void omh(final String str) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA();
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("reportMultiLog", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.utils.gbA.2
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                if (gbA.KZx || !com.bytedance.sdk.openadsdk.core.aBv.ZZv().fJy()) {
                    return null;
                }
                boolean unused = gbA.KZx = true;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", str);
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("reportMultiLog").Og(jSONObject.toString());
            }
        });
    }

    public static boolean Bzk(String str) {
        if (com.bytedance.sdk.openadsdk.core.Sn.ML()) {
            return true;
        }
        com.bytedance.sdk.component.utils.WV.Og("You must use method '" + str + "' after initialization, please check.");
        return false;
    }

    public static void SGo(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        com.bytedance.sdk.component.utils.WV.Og("You should use method '" + str + "' on the asynchronous thread,it may cause anr, please check.");
    }

    public static int WV(Context context) {
        return SD(com.bytedance.sdk.component.utils.BF.pA(context, 0L));
    }

    public static boolean yFO() {
        return ZZv.get() == 1;
    }

    public static void Wx(Context context) {
        try {
            AtomicInteger atomicInteger = ZZv;
            if (atomicInteger.get() != 0) {
                return;
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            boolean zIsEnabled = accessibilityManager.isEnabled();
            boolean zIsTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (zIsEnabled && zIsTouchExplorationEnabled) {
                atomicInteger.set(1);
                com.bytedance.sdk.openadsdk.Sn.KZx.pA().KZx();
            } else {
                atomicInteger.set(2);
            }
        } catch (Exception unused) {
            ZZv.set(2);
        }
    }

    public static boolean omh(int i) {
        if (i <= 0) {
            return false;
        }
        return i >= 100 || new Random(System.currentTimeMillis()).nextInt(100) + 1 <= i;
    }

    public static void pA(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb == null || TextUtils.isEmpty(str) || (iIndexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(iIndexOf, str.length() + iIndexOf, str2);
    }

    public static int Sn(Context context) {
        List<ResolveInfo> listQueryIntentActivities;
        Integer num = pA;
        if (num != null) {
            return num.intValue();
        }
        if (context == null || (listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com")), 0)) == null) {
            return 0;
        }
        Integer numValueOf = Integer.valueOf(listQueryIntentActivities.size());
        pA = numValueOf;
        return numValueOf.intValue();
    }

    public static com.bytedance.sdk.openadsdk.common.ZZv pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, com.bytedance.sdk.component.Bzk.ZZv zZv, Context context, String str) {
        int iDmv = yfo.dmv();
        if (yfo == null || !yfo.fN() || (iDmv != 1 && iDmv != 3)) {
            return null;
        }
        zZv.pA(true, (View) new com.bytedance.sdk.openadsdk.common.KZx(context));
        return new com.bytedance.sdk.openadsdk.common.ZZv(yfo, zZv, str, false);
    }

    public static void pA(JSONObject jSONObject) {
        int iIntValue;
        try {
            Pair<String, Long> pairZZv = com.bytedance.sdk.openadsdk.core.Bzk.ZZv("oem_store");
            int i = -1;
            if (pairZZv != null && ((iIntValue = Integer.valueOf((String) pairZZv.first).intValue()) != -2 || System.currentTimeMillis() - ((Long) pairZZv.second).longValue() < com.bytedance.sdk.openadsdk.vZF.pA.pA("oem_store_state_time", 259200000))) {
                i = iIntValue;
            }
            jSONObject.put("oem_store", i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", th.getMessage());
        }
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, com.bytedance.sdk.component.Bzk.ZZv zZv) {
        pA(yfo, zZv, false);
    }

    public static void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, com.bytedance.sdk.component.Bzk.ZZv zZv, boolean z) {
        com.bytedance.sdk.openadsdk.core.model.ML mlBSW;
        List<Integer> list;
        if (yfo == null || zZv == null) {
            return;
        }
        int iDmv = yfo.dmv();
        if (yfo.fN()) {
            if ((iDmv == 2 || iDmv == 3 || iDmv == 5) && (mlBSW = yfo.BSW()) != null) {
                List<Integer> listJG = mlBSW.JG();
                ArrayList arrayList = new ArrayList();
                if (z) {
                    for (int i = 0; i < listJG.size(); i++) {
                        arrayList.add(Integer.valueOf(listJG.get(i).intValue() - 1));
                    }
                    list = arrayList;
                } else {
                    list = listJG;
                }
                zZv.pA(true, mlBSW.ZZv(), mlBSW.ML(), list, mlBSW.SD(), mlBSW.KZx());
            }
        }
    }

    public static boolean ZZv(com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        return yfo != null && yfo.JBA() == 3 && yfo.fN() && (yfo.dmv() == 4 || yfo.dmv() == 5);
    }

    public static String vZF() {
        String str = Sn;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(WV);
        Sn = str2;
        return str2;
    }

    public static String Sd() {
        String str = DX;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(Wx);
        DX = str2;
        return str2;
    }

    public static int pA(WebView webView) {
        if (webView == null) {
            return -1;
        }
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            int size = webBackForwardListCopyBackForwardList.getSize();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(i);
                if (itemAtIndex != null) {
                    String url = itemAtIndex.getUrl();
                    if (!arrayList.contains(url)) {
                        arrayList.add(url);
                    }
                }
            }
            return arrayList.indexOf(webView.getUrl()) + 1;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.ToolUtils", th.toString());
            return -1;
        }
    }

    public static JSONObject pA(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        if (adSlot != null) {
            try {
                jSONObject.put("is_sb", !TextUtils.isEmpty(adSlot.getBidAdm()));
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }

    public static boolean BSW(String str) {
        try {
            return Class.forName(str) != null;
        } catch (Exception unused) {
        }
    }

    public static void TX() {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("check_class_exist", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.utils.gbA.3
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                boolean zBSW = gbA.BSW("androidx.recyclerview.widget.RecyclerView");
                boolean zBSW2 = gbA.BSW("android.support.v7.widget.RecyclerView");
                jSONObject.put("androidX_class_exist", zBSW);
                jSONObject.put("support_class_exist", zBSW2);
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("check_class_exist").Og(jSONObject.toString());
            }
        });
    }
}
