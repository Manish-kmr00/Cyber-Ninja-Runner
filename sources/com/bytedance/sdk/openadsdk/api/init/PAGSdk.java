package com.bytedance.sdk.openadsdk.api.init;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;
import com.bytedance.sdk.component.Bzk.KZx;
import com.bytedance.sdk.component.Bzk.ZZv;
import com.bytedance.sdk.component.Og;
import com.bytedance.sdk.component.omh.JG;
import com.bytedance.sdk.component.omh.SGo;
import com.bytedance.sdk.component.omh.omh;
import com.bytedance.sdk.component.utils.SD;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.yFO;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.ML.pA;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory;
import com.bytedance.sdk.openadsdk.api.factory.SDKTypeConfig;
import com.bytedance.sdk.openadsdk.common.ML;
import com.bytedance.sdk.openadsdk.core.Bzk;
import com.bytedance.sdk.openadsdk.core.DX;
import com.bytedance.sdk.openadsdk.core.Sn;
import com.bytedance.sdk.openadsdk.core.Wx;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.roi;
import com.bytedance.sdk.openadsdk.core.settings.oX;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.XT;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PAGSdk {
    public static final int INIT_LOCAL_FAIL_CODE = 4000;
    private static long pA;

    public interface PAGInitCallback {
        void fail(int i, String str);

        void success();
    }

    static {
        try {
            Og.pA(new Og.pA() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.1
                @Override // com.bytedance.sdk.component.Og.pA
                public ExecutorService getExecutorService() {
                    return xy.ZZv();
                }
            });
            xy.pA(new omh("tt_init_memory_data") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.2
                @Override // java.lang.Runnable
                public void run() {
                    PAGInitHelper.initAPM();
                    PAGInitHelper.initMemoryData();
                }
            });
            Sn.pA(System.currentTimeMillis());
            Sn.Og();
            ZZv.setWebViewProvider(new ZZv.KZx() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.3
                @Override // com.bytedance.sdk.component.Bzk.ZZv.KZx
                public WebView createWebView(Context context, AttributeSet attributeSet, int i) {
                    if (!(context instanceof MutableContextWrapper)) {
                        context = context.getApplicationContext();
                    }
                    try {
                        return i == 0 ? new KZx(context, attributeSet) : new KZx(context, attributeSet, i);
                    } catch (Exception unused) {
                        return i == 0 ? new KZx(context, attributeSet) : new KZx(context, attributeSet, i);
                    }
                }
            });
        } catch (Throwable th) {
            Log.i("TTAD.PAGSdk", th.getMessage());
        }
        pA = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(final Context context, final InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        Context applicationContext;
        pA = SystemClock.elapsedRealtime();
        aBv.Og(context);
        if (pAGInitCallback != null) {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                if (!PAGInitHelper.CALLBACK_LIST.contains(pAGInitCallback)) {
                    PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
                    if (Sn.ZZv() == 3) {
                        return;
                    }
                }
            }
        }
        if (ML.pA()) {
            Og(-1, "DisableSDK is called, interrupt initialization");
            return;
        }
        if (isInitSuccess()) {
            ZZv();
            return;
        }
        Sn.pA(3);
        if (context == null) {
            Og(4000, "Context is null, please check. ");
            return;
        }
        if (!(context instanceof Application) && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        if (initConfig == null) {
            Og(4000, "PAGConfig is null, please check.");
            return;
        }
        ZZv(context, initConfig);
        ApmHelper.initApm(context, initConfig);
        try {
            Bzk.pA(new Wx() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.4
                public void success() {
                    PAGSdk.ZZv();
                }

                @Override // com.bytedance.sdk.openadsdk.core.Wx
                public void fail(int i, String str) {
                    PAGSdk.Og(i, str);
                }
            });
            try {
                yFO.pA(aBv.pA(), "tt_ad_logo_txt");
                if (yFO.ZZv(context, "tt_ad_logo") == 0) {
                    pA(initConfig, pAGInitCallback);
                    return;
                }
                if (isInitSuccess()) {
                    if (pAGInitCallback != null) {
                        ZZv();
                        return;
                    }
                    return;
                }
                final pA pAVar = new pA();
                SDKTypeConfig.setSdkTypeFactory(new ISDKTypeFactory() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.5
                    @Override // com.bytedance.sdk.openadsdk.api.factory.ISDKTypeFactory
                    public IADTypeLoaderFactory createADTypeLoaderFactory(String str) {
                        return pAVar;
                    }
                });
                if (!initConfig.isSupportMultiProcess()) {
                    Og(context, initConfig);
                } else {
                    com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().pA(new com.bytedance.sdk.openadsdk.multipro.aidl.Og() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6
                        @Override // com.bytedance.sdk.openadsdk.multipro.aidl.Og
                        public void onServiceConnected() {
                            Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    PAGSdk.Og(context, initConfig);
                                }
                            });
                        }
                    });
                    com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().KZx();
                }
            } catch (Throwable unused) {
                pA(initConfig, pAGInitCallback);
            }
        } catch (Throwable unused2) {
            Og(4000, "Internal Error, setting exception. ");
        }
    }

    private static void pA(InitConfig initConfig, PAGInitCallback pAGInitCallback) {
        Sn.pA(2);
        if (pAGInitCallback != null) {
            if (initConfig instanceof PAGConfig) {
                Og(4000, "resources not found, if you use aab please call PAGConfig.setPackageName");
            } else {
                Og(4000, "resources not found, if you use aab please call TTAdConfig.setPackageName");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(Context context, InitConfig initConfig) {
        long jElapsedRealtime;
        try {
            if (isInitSuccess()) {
                ZZv();
                return;
            }
            ML(context, initConfig);
            oX.vkV().Sd();
            jElapsedRealtime = SystemClock.elapsedRealtime() - pA;
            ZZv();
            JG(context, initConfig);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - pA;
            pA(context, isInitSuccess(), initConfig, jElapsedRealtime2, jElapsedRealtime);
            new Object[]{"init Pangle exec init sdk sdkInitTime=", Long.valueOf(jElapsedRealtime), " duration=", Long.valueOf(jElapsedRealtime2)};
        } catch (Throwable th) {
            th.getMessage();
            WV.pA("TTAD.PAGSdk", th.getMessage());
            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - pA;
            Og(4000, th.getMessage());
            jElapsedRealtime = jElapsedRealtime3;
        }
    }

    private static void KZx(Context context, InitConfig initConfig) {
        Sn.pA = true;
        roi.pA().pA(initConfig.getAppId()).Og(initConfig.getCoppa()).KZx(initConfig.getGdpr()).ZZv(initConfig.getCcpa()).JG(initConfig.getAppIconId()).pA(initConfig.getTitleBarTheme());
        Bzk.BF();
        if (initConfig instanceof PAGConfig) {
            roi.pA().ML(((PAGConfig) initConfig).getDebugLog() ? 1 : 0);
        }
        try {
            if (Og(initConfig)) {
                roi.pA().pA();
                com.bytedance.sdk.openadsdk.utils.oX.pA();
            }
        } catch (Throwable unused) {
        }
        SD.pA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Og(InitConfig initConfig) {
        return ((PAGConfig) initConfig).getDebugLog();
    }

    private static void ZZv(Context context, InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getPackageName())) {
            yFO.pA(initConfig.getPackageName());
            com.bytedance.adsdk.ugeno.SD.ZZv.pA(initConfig.getPackageName());
        } else {
            yFO.pA((String) null);
            com.bytedance.adsdk.ugeno.SD.ZZv.pA((String) null);
        }
        aBv.Og(context);
        if (initConfig.isSupportMultiProcess()) {
            com.bytedance.sdk.openadsdk.multipro.Og.pA();
        } else {
            com.bytedance.sdk.openadsdk.multipro.Og.Og();
        }
        com.bytedance.sdk.openadsdk.core.omh.WV.pA();
        com.bytedance.sdk.openadsdk.core.BSW.Og.pA(context);
    }

    private static void ML(Context context, InitConfig initConfig) {
        if (com.bytedance.sdk.openadsdk.core.settings.WV.pA()) {
            JG.KZx(-1);
            JG.pA(new SGo() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7
                @Override // com.bytedance.sdk.component.omh.SGo
                public com.bytedance.sdk.component.omh.Bzk createThreadFactory(int i, String str) {
                    return new com.bytedance.sdk.component.omh.Bzk(i, str) { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.7.1
                        @Override // com.bytedance.sdk.component.omh.Bzk, java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            int iNCO = oX.vkV().nCO();
                            if (iNCO >= -524288 && iNCO < 0) {
                                Thread thread = new Thread(this.pA, runnable, this.Og, iNCO);
                                if (thread.isDaemon()) {
                                    thread.setDaemon(false);
                                }
                                if (this.KZx > 10 || this.KZx <= 0) {
                                    this.KZx = 5;
                                }
                                thread.setPriority(this.KZx);
                                return thread;
                            }
                            return super.newThread(runnable);
                        }
                    };
                }
            });
            com.bytedance.sdk.openadsdk.multipro.KZx.pA(context);
            com.bytedance.sdk.component.SD.KZx.pA.pA(new com.bytedance.sdk.component.SD.KZx.KZx() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.8
                @Override // com.bytedance.sdk.component.SD.KZx.KZx
                public ExecutorService getThreadPool() {
                    return xy.ZZv();
                }
            });
            com.bytedance.sdk.openadsdk.SD.Og.KZx();
            Sn.Og.set(true);
            try {
                com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().pA(new com.bytedance.sdk.openadsdk.Bzk.pA());
            } catch (Exception e) {
                WV.pA("TTAD.PAGSdk", e.getMessage());
            }
            KZx(initConfig);
            KZx(context, initConfig);
            com.bykv.vk.openvk.pA.pA.pA.KZx.pA(context, null);
            com.bykv.vk.openvk.pA.pA.pA.KZx.pA(2);
            com.bykv.vk.openvk.pA.pA.pA.KZx.pA(initConfig.isSupportMultiProcess());
            com.bykv.vk.openvk.pA.pA.pA.KZx.pA(com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().ML());
        }
    }

    private static void JG(final Context context, final InitConfig initConfig) {
        SystemClock.elapsedRealtime();
        xy.pA(new omh("init_sync") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9
            @Override // java.lang.Runnable
            public void run() {
                Sn.pA(initConfig.getData());
                com.bytedance.sdk.openadsdk.vZF.pA.pA(context, initConfig.getAppId());
                com.bytedance.sdk.openadsdk.vZF.pA.pA();
                com.bytedance.sdk.openadsdk.oX.KZx.pA();
                com.bytedance.sdk.openadsdk.oX.KZx.Og();
                new com.bytedance.sdk.openadsdk.utils.Sn();
                com.bytedance.sdk.component.adexpress.pA.Og.JG.pA(XT.pA() * 10);
                com.bytedance.sdk.openadsdk.ZZv.pA.ZZv.pA(context, initConfig.isSupportMultiProcess());
                DX.pA().Og();
                com.bytedance.sdk.openadsdk.core.Bzk.KZx.pA();
                com.bytedance.sdk.openadsdk.TX.pA.pA(new com.bytedance.sdk.openadsdk.TX.pA.InterfaceC0214pA() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9.1
                    public void onGdprChanged(int i) {
                        PAGConfig.setGDPRConsent(i);
                    }
                });
                oX.ZZv = oX.KZx(context);
                com.bytedance.sdk.openadsdk.BF.Og.SD.Og();
                com.bykv.vk.openvk.pA.pA.Og.pA.pA(aBv.ZZv().cFQ());
                com.bykv.vk.openvk.pA.pA.Og.pA.pA(CacheDirFactory.getICacheDir(0));
                com.bytedance.sdk.openadsdk.core.settings.JG jgZZv = aBv.ZZv();
                if (!jgZZv.dmv()) {
                    synchronized (jgZZv) {
                        if (!jgZZv.dmv()) {
                            jgZZv.Og();
                            jgZZv.Mc();
                        }
                    }
                }
                DeviceUtils.SGo();
                PAGInitHelper.maybeAsyncInitTask(context);
                PAGSdk.getBiddingToken();
                JG.pA(true);
                JG.pA(new com.bytedance.sdk.openadsdk.Sn.Og.pA());
                DeviceUtils.pA(context);
                DeviceUtils.SGo(context);
                DeviceUtils.BSW(context);
                com.bytedance.sdk.openadsdk.Sn.pA.pA();
                com.bytedance.sdk.openadsdk.core.settings.ZZv.pA();
                com.bytedance.sdk.openadsdk.Sn.KZx.ZZv();
                gbA.Wx(context);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA();
                PAGSdk.KZx();
                com.bytedance.sdk.openadsdk.core.Bzk.KZx.Og();
                com.bytedance.sdk.openadsdk.core.ZZv.pA.pA().Og();
                com.bytedance.sdk.component.omh.KZx.KZx.pA(Sn.Og());
                com.bytedance.sdk.component.utils.Og.pA(new com.bytedance.sdk.component.utils.Og.pA() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.9.2
                    @Override // com.bytedance.sdk.component.utils.Og.pA
                    public boolean isEnableAsyncStartActivity() {
                        return com.bytedance.sdk.openadsdk.vZF.pA.pA("start_activity_async", 0) == 1;
                    }

                    @Override // com.bytedance.sdk.component.utils.Og.pA
                    public ExecutorService getAsyncStartActivityThreadPool() {
                        return xy.omh();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void KZx() {
        ShortcutManager shortcutManager;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                Context contextPA = aBv.pA();
                if (contextPA == null || (shortcutManager = (ShortcutManager) contextPA.getSystemService(ShortcutManager.class)) == null) {
                    return;
                }
                Bzk.Og().pA(shortcutManager.isRequestPinShortcutSupported());
            } catch (Throwable unused) {
            }
        }
    }

    private static void KZx(InitConfig initConfig) {
        if (!TextUtils.isEmpty(initConfig.getData())) {
            Bzk.Og().KZx(initConfig.getData());
        }
        Bzk.Og().KZx(Og(initConfig));
    }

    private static void pA(final Context context, final boolean z, final InitConfig initConfig, final long j, final long j2) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA();
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("pangle_sdk_init", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.10
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                try {
                    boolean zKZx = Bzk.Og().KZx();
                    jSONObject.put("duration", j);
                    jSONObject.put("sdk_init_time", j2);
                    jSONObject.put("is_async", true);
                    jSONObject.put("is_multi_process", initConfig.isSupportMultiProcess());
                    jSONObject.put("is_debug", PAGSdk.Og(initConfig));
                    jSONObject.put("is_use_texture_view", initConfig.isUseTextureView());
                    jSONObject.put("is_activate_init", zKZx);
                    jSONObject.put("minSdkVersion", gbA.BSW(context));
                    jSONObject.put("targetSdkVersion", gbA.SGo(context));
                    jSONObject.put("apm_is_init", ApmHelper.isIsInit());
                    jSONObject.put("is_success", z);
                    Bzk.Og().Og(false);
                } catch (Exception e) {
                    WV.pA("TTAD.PAGSdk", "run: ", e);
                }
                return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("pangle_sdk_init").Og(jSONObject.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ZZv() {
        Sn.pA(1);
        try {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                Iterator<PAGInitCallback> it = PAGInitHelper.CALLBACK_LIST.iterator();
                while (it.hasNext()) {
                    PAGInitCallback next = it.next();
                    if (next != null) {
                        it.remove();
                        next.success();
                    }
                }
            }
            com.bytedance.sdk.openadsdk.oX.KZx.Og(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.11
                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                    pAVar.Og("init");
                    return pAVar;
                }
            });
        } catch (Throwable th) {
            WV.Og(th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(int i, String str) {
        Sn.pA(2);
        try {
            synchronized (PAGInitHelper.CALLBACK_LIST) {
                Iterator<PAGInitCallback> it = PAGInitHelper.CALLBACK_LIST.iterator();
                while (it.hasNext()) {
                    PAGInitCallback next = it.next();
                    if (next != null) {
                        it.remove();
                        next.fail(i, str);
                    }
                }
                com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.12
                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                        pAVar.Og("init");
                        return pAVar;
                    }
                });
            }
        } catch (Throwable th) {
            WV.Og(th.getMessage());
        }
    }

    public static void init(final Context context, final PAGConfig pAGConfig, final PAGInitCallback pAGInitCallback) {
        Sn.Og().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.13
            @Override // java.lang.Runnable
            public void run() {
                PAGSdk.Og(context, pAGConfig, pAGInitCallback);
            }
        });
        Sn.omh();
    }

    public static boolean isInitSuccess() {
        return Sn.ZZv() == 1;
    }

    public static String getSDKVersion() {
        if (roi.pA() != null) {
            return roi.pA().ZZv();
        }
        return "";
    }

    public static String getBiddingToken(Context context, String str) {
        if (ML.pA()) {
            return null;
        }
        aBv.Og(context);
        return getBiddingToken(str);
    }

    public static void getBiddingToken(final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (ML.pA()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            xy.ML(new omh("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.14
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken());
                }
            });
        }
    }

    public static void getBiddingToken(final String str, final BiddingTokenCallback biddingTokenCallback) {
        if (biddingTokenCallback == null) {
            return;
        }
        if (ML.pA()) {
            biddingTokenCallback.onBiddingTokenCollected(null);
        } else {
            xy.ML(new omh("getBiddingToken") { // from class: com.bytedance.sdk.openadsdk.api.init.PAGSdk.15
                @Override // java.lang.Runnable
                public void run() {
                    biddingTokenCallback.onBiddingTokenCollected(PAGSdk.getBiddingToken(str));
                }
            });
        }
    }

    public static String getBiddingToken(String str) {
        if (ML.pA()) {
            return null;
        }
        return (aBv.pA() == null || roi.pA() == null) ? "" : roi.pA().KZx(str);
    }

    public static String getBiddingToken(Context context) {
        if (ML.pA()) {
            return null;
        }
        aBv.Og(context);
        return getBiddingToken();
    }

    public static String getBiddingToken() {
        if (ML.pA()) {
            return null;
        }
        return (aBv.pA() == null || roi.pA() == null) ? "" : roi.pA().ML();
    }

    public static boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (roi.pA() != null) {
            return roi.pA().pA(str, i, str2, str3, str4);
        }
        return false;
    }

    public static String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128));
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static void closeMultiWebViewFileLock() {
        com.bytedance.sdk.openadsdk.multipro.KZx.pA();
    }

    public static void addPAGInitCallback(PAGInitCallback pAGInitCallback) {
        if (pAGInitCallback != null && Sn.ZZv() == 0) {
            PAGInitHelper.CALLBACK_LIST.add(pAGInitCallback);
        }
    }

    public static void setAabPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        yFO.pA(str);
        com.bytedance.adsdk.ugeno.SD.ZZv.pA(str);
    }

    public static void setAdRevenue(JSONObject jSONObject) {
        if (jSONObject != null && aBv.ZZv().XT() && isInitSuccess()) {
            com.bytedance.sdk.openadsdk.Sn.KZx.pA().pA(jSONObject);
        }
    }

    private static void setSdkDisable(boolean z) {
        ML.pA(z);
    }
}
