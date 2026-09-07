package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.JProtect;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.json.fe;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class DeviceUtils {
    private static int BSW = 0;
    private static int Bzk = 0;
    private static int SGo = 0;
    private static int WV = 0;
    private static int Wx = 0;
    private static int omh = 0;
    public static String pA = "";
    private static volatile long Og = System.currentTimeMillis();
    private static volatile boolean KZx = false;
    private static volatile boolean ZZv = false;
    private static volatile boolean ML = false;
    private static volatile boolean JG = true;
    private static long SD = 0;
    private static AtomicBoolean Sn = new AtomicBoolean(false);

    public static void pA(Context context) {
        if (KZx) {
            return;
        }
        try {
            Og og = new Og();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.getApplicationContext().registerReceiver(og, intentFilter);
            KZx = true;
        } catch (Throwable unused) {
        }
    }

    public static long pA() {
        return Og;
    }

    @JProtect
    public static boolean Og() {
        if (SystemClock.elapsedRealtime() - SD >= 20000) {
            SD = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.aBv.pA().getSystemService("power");
                if (powerManager != null) {
                    JG = powerManager.isInteractive();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.DeviceUtils", th.getMessage());
            }
        }
        return JG;
    }

    public static boolean Og(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean KZx(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int ZZv(Context context) {
        if (KZx(context)) {
            return 3;
        }
        return Og(context) ? 2 : 1;
    }

    private static void pA(JSONObject jSONObject) throws JSONException {
        Og(jSONObject);
    }

    private static void Og(JSONObject jSONObject) throws JSONException {
        jSONObject.put("model", Build.MODEL);
        if (com.bytedance.sdk.openadsdk.core.aBv.ZZv().roi(fe.Q0)) {
            jSONObject.put(fe.Q0, com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().Og());
        }
    }

    @JProtect
    public static JSONObject pA(Context context, boolean z) {
        String strOg;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sys_adb_status", JG(context));
            pA(jSONObject);
            jSONObject.put("type", ZZv(context));
            jSONObject.put("os", 1);
            jSONObject.put(CommonUrlParts.OS_VERSION, Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put("conn_type", gbA.WV(context));
            jSONObject.put(CommonUrlParts.APP_SET_ID, com.bytedance.sdk.openadsdk.core.settings.ZZv.KZx());
            jSONObject.put(CommonUrlParts.APP_SET_ID_SCOPE, com.bytedance.sdk.openadsdk.core.settings.ZZv.Og());
            jSONObject.put("installed_source", com.bytedance.sdk.openadsdk.core.settings.ZZv.ZZv());
            jSONObject.put(CommonUrlParts.SCREEN_WIDTH, Vgu.KZx(context));
            jSONObject.put(CommonUrlParts.SCREEN_HEIGHT, Vgu.ZZv(context));
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.Bzk.KZx.JG());
            com.bytedance.sdk.openadsdk.core.settings.JG jgZZv = com.bytedance.sdk.openadsdk.core.aBv.ZZv();
            if (jgZZv.roi("boot")) {
                jSONObject.put("boot", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                jSONObject.put("power_on_time", String.valueOf(SystemClock.elapsedRealtime()));
            }
            jSONObject.put(CommonUrlParts.UUID, com.bytedance.sdk.openadsdk.core.WV.KZx(context));
            jSONObject.put("rom_version", du.pA());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.WV.Og(context));
            jSONObject.put("timezone", gbA.XT());
            jSONObject.put(POBConstants.KEY_LANGUAGE, com.bytedance.sdk.openadsdk.core.WV.Og());
            jSONObject.put("carrier_name", roi.pA());
            if (z) {
                strOg = gbA.pA(context);
            } else {
                strOg = gbA.Og(context);
            }
            jSONObject.put("total_mem", String.valueOf(Long.parseLong(strOg) * 1024));
            jSONObject.put("locale_language", ZZv());
            jSONObject.put("screen_bright", Math.ceil(ML() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", 1 ^ (Og() ? 1 : 0));
            jSONObject.put("cpu_num", omh.pA(context));
            jSONObject.put("cpu_max_freq", omh.Og(context));
            jSONObject.put("cpu_min_freq", omh.KZx(context));
            ML.pA pAVarPA = ML.pA();
            jSONObject.put("battery_remaining_pct", (int) pAVarPA.Og);
            jSONObject.put("is_charging", pAVarPA.pA);
            jSONObject.put("total_space", String.valueOf(gbA.KZx(context)));
            jSONObject.put("free_space_in", String.valueOf(gbA.ZZv(context)));
            jSONObject.put("sdcard_size", String.valueOf(gbA.ML(context)));
            jSONObject.put("rooted", gbA.JG(context));
            jSONObject.put("enable_assisted_clicking", JG());
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.yFO.pA(context, "tt_choose_language"));
            jSONObject.put("airplane", SD(context));
            jSONObject.put("darkmode", Sn(context));
            jSONObject.put("headset", DX(context));
            jSONObject.put("ringmute", omh(context));
            jSONObject.put("screenscale", oX(context));
            jSONObject.put("volume", omh());
            jSONObject.put("low_power_mode", aBv(context));
            if (z) {
                JG.pA(jSONObject, context);
            }
            if (jgZZv.roi("mnc")) {
                jSONObject.put("mnc", roi.KZx());
            }
            if (jgZZv.roi("mcc")) {
                jSONObject.put("mcc", roi.Og());
            }
            jSONObject.put("act", com.bytedance.sdk.openadsdk.core.act.pA.Og(context));
            jSONObject.put("act_event", com.bytedance.sdk.openadsdk.core.act.pA.pA());
            String strKZx = com.bytedance.sdk.openadsdk.core.Bzk.KZx.KZx();
            new Object[]{"getEnvcodeForBidding:", Long.valueOf(com.bytedance.sdk.openadsdk.core.Bzk.KZx.ZZv())};
            if (!TextUtils.isEmpty(strKZx)) {
                jSONObject.put("sof_chara", strKZx);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject ML(Context context) {
        return pA(context, false);
    }

    public static int KZx() {
        return com.bytedance.sdk.openadsdk.core.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()).Og("limit_ad_track", -1);
    }

    public static String ZZv() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static float ML() {
        int i = -1;
        try {
            Context contextPA = com.bytedance.sdk.openadsdk.core.aBv.pA();
            if (contextPA != null) {
                i = Settings.System.getInt(contextPA.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.DeviceUtils", th.getMessage());
        }
        if (i < 0) {
            return -1.0f;
        }
        return Math.round((i / 255.0f) * 10.0f) / 10.0f;
    }

    public static int JG() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.aBv.pA().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        return accessibilityManager.isEnabled() ? 1 : 0;
    }

    public static int JG(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", -1);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.DeviceUtils", th.getMessage());
            return -1;
        }
    }

    public static int SD(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static int Sn(Context context) {
        try {
            int i = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
            if (i == 32) {
                return 1;
            }
            return i == 16 ? 0 : -1;
        } catch (Throwable unused) {
        }
    }

    private static int DX(Context context) {
        return WV;
    }

    public static int omh(Context context) {
        return omh;
    }

    private static float oX(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int SD() {
        return SGo;
    }

    public static int omh() {
        return BSW;
    }

    public static int Bzk() {
        return Bzk;
    }

    private static int aBv(Context context) {
        return Wx;
    }

    public static String Bzk(Context context) {
        if (TextUtils.isEmpty(pA)) {
            pA = com.bytedance.sdk.openadsdk.core.KZx.pA(context).Og("framework_name", "");
        }
        return pA;
    }

    @JProtect
    public static void SGo() {
        xy.pA((com.bytedance.sdk.component.omh.omh) new KZx());
        com.bytedance.sdk.openadsdk.core.settings.oX.pA(new com.bytedance.sdk.openadsdk.core.settings.DX.pA() { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.DX.pA
            public void pA() {
                xy.pA((com.bytedance.sdk.component.omh.omh) new KZx());
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.DX.pA
            public void Og() {
                xy.pA((com.bytedance.sdk.component.omh.omh) new KZx());
            }
        });
        Context contextPA = com.bytedance.sdk.openadsdk.core.aBv.pA();
        if (contextPA != null) {
            com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("cpu_count", omh.pA());
            com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("cpu_max_frequency", omh.pA(omh.pA()));
            com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("cpu_min_frequency", omh.Og(omh.pA()));
            String strBzk = gbA.Bzk();
            if (strBzk != null) {
                com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("total_memory", strBzk);
            }
            com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("total_internal_storage", gbA.SGo());
            com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("free_internal_storage", com.bytedance.sdk.component.utils.Wx.pA());
            com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("total_sdcard_storage", gbA.BSW());
            com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("is_root", gbA.WV() ? 1 : 0);
            if (TextUtils.isEmpty(Bzk(contextPA))) {
                try {
                    Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
                    pA = "unity";
                } catch (ClassNotFoundException unused) {
                    pA = "native";
                }
                com.bytedance.sdk.openadsdk.core.KZx.pA(contextPA).pA("framework_name", pA);
            }
            BSW();
            XT(contextPA);
            Wx = vZF(contextPA);
            JG.pA(contextPA);
        }
    }

    public static void BSW() {
        try {
            int ringerMode = ((AudioManager) com.bytedance.sdk.openadsdk.core.aBv.pA().getSystemService("audio")).getRingerMode();
            if (ringerMode == 2) {
                omh = 1;
            } else if (ringerMode == 1) {
                omh = 2;
            } else {
                omh = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private static void XT(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            Bzk = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            SGo = streamVolume;
            BSW = (int) ((((double) streamVolume) / ((double) Bzk)) * 100.0d);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void yFO(Context context) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        xy.Og(new com.bytedance.sdk.component.omh.omh("DeviceUtils_get_low_power_mode") { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.2
            @Override // java.lang.Runnable
            public void run() {
                int unused = DeviceUtils.Wx = DeviceUtils.vZF(applicationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int vZF(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") && !Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode() ? 1 : 0;
            }
            return Sd(context);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    private static int Sd(Context context) {
        try {
            int i = 1;
            if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                if (Settings.System.getInt(context.getContentResolver(), "POWER_SAVE_MODE_OPEN") != 1) {
                    i = 0;
                }
            } else {
                if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                    return 0;
                }
                if (Settings.System.getInt(context.getContentResolver(), "SmartModeStatus") != 4) {
                    i = 0;
                }
            }
            return i;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void SGo(Context context) {
        AudioInfoReceiver.Og(context);
    }

    public static void BSW(Context context) {
        Context applicationContext;
        if (ML || context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                TX(applicationContext);
            } else {
                pA.Og(applicationContext);
            }
            ML = true;
        } catch (Throwable unused) {
        }
    }

    private static void TX(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        context.getContentResolver().registerContentObserver(Uri.parse("content://settings/system/POWER_SAVE_MODE_OPEN"), false, new ContentObserver(null) { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                DeviceUtils.yFO(applicationContext);
            }
        });
    }

    static class Og extends BroadcastReceiver {
        Og() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = DeviceUtils.JG = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = DeviceUtils.JG = false;
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                long unused3 = DeviceUtils.Og = System.currentTimeMillis();
            }
        }
    }

    public static class KZx extends com.bytedance.sdk.component.omh.omh {
        public KZx() {
            super("gaid_task");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v6, types: [com.bytedance.sdk.openadsdk.core.KZx] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v3 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r3;
            boolean zIsLimitAdTrackingEnabled;
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.sdk.openadsdk.core.aBv.pA());
                if (advertisingIdInfo != null) {
                    zIsLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                    DeviceUtils.Og(advertisingIdInfo, zIsLimitAdTrackingEnabled);
                } else {
                    r3 = -1;
                }
                if (r3 == -1) {
                    r3 = zIsLimitAdTrackingEnabled;
                    return;
                } else {
                    r3 = zIsLimitAdTrackingEnabled;
                    com.bytedance.sdk.openadsdk.core.KZx.pA(com.bytedance.sdk.openadsdk.core.aBv.pA()).pA("limit_ad_track", r3);
                }
            } catch (IOException e) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.DeviceUtils", "getLmtTask error : signaling connection to Google Play Services failed.", e);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.DeviceUtils", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Og(AdvertisingIdClient.Info info, boolean z) {
        if (z || !com.bytedance.sdk.openadsdk.core.aBv.ZZv().roi(fe.Q0)) {
            return;
        }
        String id = info.getId();
        String strOg = com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().Og();
        if (!TextUtils.isEmpty(id)) {
            com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().pA(id);
            com.bytedance.sdk.openadsdk.core.Bzk.KZx.pA(id);
        }
        if (strOg.equals(id)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.WV.pA();
    }

    public static class AudioInfoReceiver extends BroadcastReceiver {
        static final CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.WV.SD> pA = new CopyOnWriteArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public static void Og(Context context) {
            if (DeviceUtils.ZZv || context == null) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                context.registerReceiver(new AudioInfoReceiver(), intentFilter, null, com.bytedance.sdk.component.utils.SD.pA());
                boolean unused = DeviceUtils.ZZv = true;
            } catch (Throwable unused2) {
            }
        }

        public static void pA(com.bytedance.sdk.openadsdk.WV.SD sd) {
            if (sd != null) {
                CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.WV.SD> copyOnWriteArrayList = pA;
                if (copyOnWriteArrayList.contains(sd)) {
                    return;
                }
                copyOnWriteArrayList.add(sd);
            }
        }

        public static void Og(com.bytedance.sdk.openadsdk.WV.SD sd) {
            if (sd == null) {
                return;
            }
            pA.remove(sd);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                    if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        int unused = DeviceUtils.SGo = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                        if (!pA.isEmpty()) {
                            xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.AudioInfoReceiver.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Iterator<com.bytedance.sdk.openadsdk.WV.SD> it = AudioInfoReceiver.pA.iterator();
                                    while (it.hasNext()) {
                                        it.next().pA(DeviceUtils.SGo);
                                    }
                                }
                            });
                        }
                        if (DeviceUtils.Bzk != 0) {
                            int unused2 = DeviceUtils.BSW = (int) ((((double) DeviceUtils.SGo) / ((double) DeviceUtils.Bzk)) * 100.0d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    int unused3 = DeviceUtils.WV = intent.getIntExtra("state", 0);
                }
            } catch (Exception unused4) {
            }
        }
    }

    private static class pA extends BroadcastReceiver {
        private pA() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void Og(Context context) {
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                intentFilter.addAction("huawei.intent.action.POWER_MODE_CHANGED_ACTION");
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(new pA(), intentFilter, 2);
                } else {
                    context.registerReceiver(new pA(), intentFilter);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(intent.getAction())) {
                DeviceUtils.yFO(context);
            } else if ("huawei.intent.action.POWER_MODE_CHANGED_ACTION".equals(intent.getAction())) {
                int unused = DeviceUtils.Wx = intent.getIntExtra("state", 0) == 1 ? 1 : 0;
            }
        }
    }
}
