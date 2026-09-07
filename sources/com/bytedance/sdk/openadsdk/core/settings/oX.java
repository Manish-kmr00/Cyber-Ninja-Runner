package com.bytedance.sdk.openadsdk.core.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.json.m5;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import com.smaato.sdk.core.gdpr.CmpApiConstants;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class oX implements JG, Sn.pA {
    private Bzk BF;
    private final Wx DX;
    private ML.Og<JSONObject> IG;
    private final ML.Og<Set<String>> Mc;
    final ML.Og<ConcurrentHashMap<String, Integer>> SD;
    private Set<String> SGo;
    private boolean Sd;
    private final com.bytedance.sdk.openadsdk.core.settings.pA Sn;
    private final BroadcastReceiver TV;
    private final SGo Wx;
    private boolean XT;
    private volatile boolean aBv;
    private final Runnable du;
    private final ML.Og<Map<String, Integer>> eG;
    private final AtomicBoolean oX;
    ML.Og<com.bytedance.sdk.openadsdk.ZZv.pA.Sn> omh;
    private final Set<String> roi;
    private int vZF;
    private int yFO;
    public static final String pA = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{"bus_con_collect", gbA.Sd()});
    public static final String Og = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{"bus_con", gbA.Sd(), gbA.vZF(), "timeout"});
    public static final String KZx = UByte$$ExternalSyntheticBackport0.m("_", new CharSequence[]{"bus_con", gbA.Sd(), gbA.vZF(), "alpha"});
    private static final String Bzk = gbA.Sn();
    private static final com.bytedance.sdk.component.omh.omh BSW = new com.bytedance.sdk.component.omh.omh("TemplateReInitTask") { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.1
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.adexpress.pA.Og.ML.Og().Bzk();
            com.bytedance.sdk.component.adexpress.pA.Og.ML.Og().Og(false);
            com.bytedance.sdk.component.adexpress.pA.Og.Og.Og();
            com.bytedance.sdk.component.adexpress.pA.Og.ML.Og().KZx();
        }
    };
    public static String ZZv = "";
    public static String ML = "IABTCF_TCString";
    private static boolean WV = false;
    private static final ConcurrentLinkedQueue<DX.pA> TX = new ConcurrentLinkedQueue<>();
    private static final BSW WQf = new BSW();
    static final ConcurrentHashMap<String, Integer> JG = new ConcurrentHashMap<>();

    private static final class pA {
        static final oX pA = new oX();
    }

    private static int KZx(boolean z) {
        return z ? 20 : 5;
    }

    private oX() {
        this.SGo = Collections.synchronizedSet(new HashSet());
        this.Wx = new SGo();
        this.Sn = new com.bytedance.sdk.openadsdk.core.settings.pA();
        this.DX = new Wx(new DX.pA() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.6
            @Override // com.bytedance.sdk.openadsdk.core.settings.DX.pA
            public void pA() {
                DX.pA[] pAVarArr;
                boolean unused = oX.WV = true;
                if (oX.TX == null || oX.TX.size() == 0 || (pAVarArr = (DX.pA[]) oX.TX.toArray()) == null) {
                    return;
                }
                for (DX.pA pAVar : pAVarArr) {
                    pAVar.pA();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.DX.pA
            public void Og() {
                if (oX.TX == null || oX.TX.isEmpty()) {
                    return;
                }
                Iterator it = oX.TX.iterator();
                while (it.hasNext()) {
                    ((DX.pA) it.next()).Og();
                }
            }
        });
        this.oX = new AtomicBoolean(false);
        this.aBv = false;
        this.XT = false;
        this.yFO = 5000;
        this.vZF = 10;
        AnonymousClass11 anonymousClass11 = new AnonymousClass11();
        this.TV = anonymousClass11;
        this.du = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.12
            @Override // java.lang.Runnable
            public void run() {
                oX.this.ZZv(2);
                oX.this.PU();
            }
        };
        this.SD = new ML.Og<ConcurrentHashMap<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.13
            @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public ConcurrentHashMap<String, Integer> Og(String str) {
                if (TextUtils.isEmpty(str)) {
                    return oX.JG;
                }
                ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
                    Iterator<String> itKeys = jSONObjectJsonObjectInit.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        int iOptInt = jSONObjectJsonObjectInit.optInt(next, 100);
                        if (!TextUtils.isEmpty(next) && iOptInt >= 0 && iOptInt <= 100) {
                            concurrentHashMap.put(next, Integer.valueOf(iOptInt));
                        }
                    }
                } catch (JSONException e) {
                    Log.i("TTAD.SdkSettings", e.getMessage());
                }
                return concurrentHashMap;
            }
        };
        this.eG = new ML.Og<Map<String, Integer>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.2
            @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public Map<String, Integer> Og(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
                    HashMap map = new HashMap(jSONObjectJsonObjectInit.length());
                    Iterator<String> itKeys = jSONObjectJsonObjectInit.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.isEmpty(next)) {
                            int iOptInt = jSONObjectJsonObjectInit.optInt(next, 100);
                            if (iOptInt >= 0 && iOptInt <= 100) {
                                map.put(next, Integer.valueOf(iOptInt));
                            } else {
                                map.put(next, 100);
                            }
                        }
                    }
                    return map;
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.Og("get applog rate from sp failed:" + e.getMessage());
                    return null;
                }
            }
        };
        this.roi = new HashSet();
        this.Mc = new ML.Og<Set<String>>() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.3
            @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public Set<String> Og(String str) {
                HashSet hashSet = new HashSet();
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
                        int iOptInt = jSONObjectJsonObjectInit.optInt("applog_count");
                        if (iOptInt >= 2 && iOptInt <= 100) {
                            oX.this.vZF = iOptInt;
                        }
                        int iOptInt2 = jSONObjectJsonObjectInit.optInt("applog_interval");
                        if (iOptInt2 >= 100 && iOptInt2 <= 30000) {
                            oX.this.yFO = iOptInt2;
                        }
                        JSONArray jSONArray = jSONObjectJsonObjectInit.getJSONArray("core_label_arr");
                        if (jSONArray != null) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                String string = jSONArray.getString(i);
                                if (!TextUtils.isEmpty(string)) {
                                    hashSet.add(string);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        Log.i("TTAD.SdkSettings", e.getMessage());
                    }
                }
                return hashSet.size() == 0 ? new HashSet(Arrays.asList("click", m5.v, "insight_log", "mrc_show")) : hashSet;
            }
        };
        this.IG = new ML.Og<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.4
            @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public JSONObject Og(String str) {
                JSONObject jSONObjectJsonObjectInit;
                try {
                    jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("TTAD.SdkSettings", th.getMessage());
                    jSONObjectJsonObjectInit = null;
                }
                return jSONObjectJsonObjectInit == null ? new JSONObject() : jSONObjectJsonObjectInit;
            }
        };
        this.omh = new ML.Og<com.bytedance.sdk.openadsdk.ZZv.pA.Sn>() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.5
            @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.openadsdk.ZZv.pA.Sn Og(String str) {
                com.bytedance.sdk.openadsdk.ZZv.pA.Sn sn = new com.bytedance.sdk.openadsdk.ZZv.pA.Sn();
                try {
                    JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(str);
                    sn.pA(jSONObjectJsonObjectInit.optInt("enable_strategy", 0) == 1);
                    sn.pA(pA(jSONObjectJsonObjectInit.optJSONObject("default")));
                    JSONObject jSONObjectOptJSONObject = jSONObjectJsonObjectInit.optJSONObject("adid_configs");
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            sn.pA(next, pA(jSONObjectOptJSONObject.getJSONObject(next)));
                        }
                    }
                } catch (Exception unused) {
                }
                return sn;
            }

            private com.bytedance.sdk.openadsdk.ZZv.pA.Sn.pA pA(JSONObject jSONObject) {
                if (jSONObject != null) {
                    return new com.bytedance.sdk.openadsdk.ZZv.pA.Sn.pA(jSONObject.optInt("retry_times", -1), jSONObject.optInt(SDKConstants.PARAM_A2U_TIME_INTERVAL, -1));
                }
                return null;
            }
        };
        try {
            Context contextPA = aBv.pA();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("_dataChanged");
            if (Build.VERSION.SDK_INT >= 33) {
                contextPA.registerReceiver(anonymousClass11, intentFilter, 4);
            } else {
                contextPA.registerReceiver(anonymousClass11, intentFilter);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.SdkSettings", "", e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void pA() {
        try {
            KZx.pA();
            this.DX.KZx();
            this.Wx.KZx();
            this.Sn.KZx();
            Context contextPA = aBv.pA();
            File file = new File(new File(contextPA.getDataDir(), "shared_prefs"), "tt_sdk_settings.xml");
            if (file.exists() && file.isFile()) {
                contextPA.deleteSharedPreferences(file.getName().replace(".xml", ""));
            }
        } catch (Throwable unused) {
        }
    }

    private static void Og(int i, boolean z) {
        Context contextPA = aBv.pA();
        if (contextPA != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextPA.getPackageName());
                intent.setAction("_tryFetRemoDat");
                intent.putExtra("_force", z);
                intent.putExtra("_source", i);
                contextPA.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    public static void Xj() {
        Context contextPA;
        if (com.bytedance.sdk.openadsdk.multipro.Og.KZx() && (contextPA = aBv.pA()) != null) {
            try {
                Intent intent = new Intent();
                intent.setPackage(contextPA.getPackageName());
                intent.setAction("_dataChanged");
                contextPA.sendBroadcast(intent);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("TTAD.SdkSettings", "", th);
            }
        }
    }

    public static int Og(Context context) {
        SharedPreferences sharedPreferencesZZv;
        if (context == null || (sharedPreferencesZZv = ZZv(context)) == null) {
            return -2;
        }
        int i = sharedPreferencesZZv.getInt(CmpApiConstants.IABTCF_CMP_SDK_ID, Integer.MIN_VALUE);
        int i2 = sharedPreferencesZZv.getInt(CmpApiConstants.IABTCF_CMP_SDK_VERSION, Integer.MIN_VALUE);
        if (i == Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
            return -2;
        }
        return sharedPreferencesZZv.getInt("IABTCF_gdprApplies", -1);
    }

    public static String KZx(Context context) {
        SharedPreferences sharedPreferencesZZv;
        return (context == null || (sharedPreferencesZZv = ZZv(context)) == null) ? "" : sharedPreferencesZZv.getString(ML, "");
    }

    private static SharedPreferences ZZv(Context context) {
        try {
            return PreferenceManager.getDefaultSharedPreferences(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public static JG vkV() {
        if (aBv.pA() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("context is null");
            Log.e("Pangle", "context is null", illegalStateException);
            ApmHelper.reportCustomError("context is null", "context is null", illegalStateException);
            return WQf;
        }
        return pA.pA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public synchronized void Og() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = this.aBv;
        this.Wx.pA(this.aBv);
        this.Sn.pA(this.aBv);
        this.DX.pA(this.aBv);
        KZx.pA(!z);
        com.bytedance.sdk.openadsdk.core.Bzk.Og().ZZv(GbR());
        this.aBv = true;
        new Object[]{"loadLocalData: finished, used", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime), "ms"};
        if (!z) {
            com.bytedance.sdk.openadsdk.core.Sn.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.7
                @Override // java.lang.Runnable
                public void run() {
                    if (Sn.pA()) {
                        oX.this.ZZv(1);
                        oX.this.PU();
                    } else {
                        com.bytedance.sdk.openadsdk.multipro.aidl.pA.pA().Og();
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String KZx() {
        return this.DX.pA("aes_key", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int ZZv() {
        return this.DX.pA("max_tpl_cnts", 100);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public JSONObject ML() {
        return (JSONObject) this.DX.pA("digest", null, ML.pA);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public long JG() {
        return this.DX.pA("data_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void SD() {
        this.DX.pA().pA("tt_sdk_settings").pA("ab_test_param").pA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void pA(JSONObject jSONObject, ML.pA pAVar) {
        if (jSONObject == null || !jSONObject.has("dyn_draw_engine_url")) {
            return;
        }
        Wx wx = this.DX;
        String str = Bzk;
        String strPA = wx.pA("dyn_draw_engine_url", str);
        final String strOptString = jSONObject.optString("dyn_draw_engine_url", str);
        if (!TextUtils.isEmpty(strPA) && !TextUtils.isEmpty(strOptString) && !strOptString.equals(strPA)) {
            com.bytedance.sdk.openadsdk.core.Sn.Og().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.8
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.equals(oX.this.DX.pA("dyn_draw_engine_url", oX.Bzk), strOptString)) {
                        com.bytedance.sdk.component.adexpress.pA.Og.ML.Og().KZx();
                    }
                }
            }, 5000L);
        }
        pAVar.pA("dyn_draw_engine_url", strOptString);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int pA(String str) {
        if (str == null) {
            return 0;
        }
        return aBv.ZZv().eG(str).yFO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void Og(JSONObject jSONObject, ML.pA pAVar) {
        if (jSONObject.has("is_gdpr_user")) {
            int iOptInt = jSONObject.optInt("is_gdpr_user", -1);
            pAVar.pA("isGdprUser", (iOptInt == -1 || iOptInt == 1 || iOptInt == 0) ? iOptInt : -1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean omh() {
        return this.DX.pA("if_both_open", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean Bzk() {
        return this.DX.pA("support_tnc", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String SGo() {
        return this.DX.pA("ab_test_version", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int BSW() {
        return this.DX.pA("load_callback_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int WV() {
        return this.DX.pA("splash_video_load_strategy", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Og(String str) {
        Integer num;
        Map map = (Map) this.DX.pA("perf_con_stats_rate", JG, this.SD);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Mc(String str) {
        Integer num;
        Map map = (Map) this.DX.pA("perf_con_applog_rate", null, this.eG);
        if (map == null || (num = (Integer) map.get(str)) == null || num.intValue() < 0 || num.intValue() > 100) {
            return 100;
        }
        return num.intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int slz() {
        return this.DX.pA("perf_con_drawable_code", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public Set<String> Wx() {
        return BDQ();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Sn() {
        BDQ();
        return this.vZF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int DX() {
        BDQ();
        return this.yFO;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean oX() {
        return this.DX.pA("allow_blind_mode_request_ad", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean aBv() {
        return this.DX.pA("support_gzip", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean XT() {
        return this.DX.pA("ad_revenue_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean bU() {
        return this.DX.pA("bus_con_adshow_check_enable", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public long RS() {
        long jPA = this.DX.pA("bus_con_tnc_interval", 600000L);
        if (jPA < 10000) {
            return 10000L;
        }
        return jPA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int QI() {
        int iPA = this.DX.pA("bus_con_token_thread_count", 4);
        if (iPA <= 0 || iPA > 30) {
            return 4;
        }
        return iPA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String Gag() {
        return this.DX.pA("bus_con_express_host", "https://sf16-static.i18n-pglstatp.com/obj/ad-pattern-sg/");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Qj() {
        return this.DX.pA("bus_con_behavior_count", 300);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String xkn() {
        return this.DX.pA("bus_con_check_clz", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean mK() {
        return this.DX.pA("bus_con_url_check", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean uQ() {
        return this.DX.pA(pA, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int jO() {
        return this.DX.pA(Og, 10000);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public float FGT() {
        return this.DX.pA(KZx, 1.0f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int yFO() {
        return this.DX.pA("loadedCallbackOpportunity", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String vZF() {
        return this.DX.pA("ab_test_param", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public Bzk Sd() {
        Bzk bzk = this.BF;
        if (bzk != null) {
            return bzk;
        }
        Bzk bzk2 = (Bzk) this.Wx.pA("mediation_init_conf", Bzk.pA, new ML.Og<Bzk>() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.9
            @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public Bzk Og(String str) {
                return new Bzk(str);
            }
        });
        this.BF = bzk2;
        return bzk2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean TX() {
        return this.DX.pA("landingpage_new_style", -1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public long BF() {
        return this.DX.pA("duration", 10000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int WQf() {
        return this.DX.pA("max", 50);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public SD TV() {
        return (SD) this.DX.pA("insert_js_config", SD.pA, new ML.Og<SD>() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.10
            @Override // com.bytedance.sdk.openadsdk.core.settings.ML.Og
            /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
            public SD Og(String str) {
                return new SD(str);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String du() {
        return this.DX.pA("playableLoadH5Url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int eG() {
        int iPA = this.DX.pA("fetch_tpl_timeout_ctrl", 3000);
        if (iPA <= 0) {
            return 3000;
        }
        return iPA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int roi() {
        int iPA = this.DX.pA("fetch_tpl_second", 0);
        if (iPA <= 0) {
            return 0;
        }
        return iPA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void Mc() {
        String strLgT = lgT();
        if (TextUtils.isEmpty(strLgT)) {
            return;
        }
        if (strLgT.equals("zh-Hant")) {
            com.bytedance.sdk.component.utils.Bzk.pA(aBv.pA(), "zh", "tw");
        } else {
            com.bytedance.sdk.component.utils.Bzk.pA(aBv.pA(), strLgT, null);
        }
        try {
            TTAdDislikeToast.onResourceUpdated();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.SdkSettings", th.getMessage());
        }
    }

    private String lgT() {
        return this.DX.pA("force_language", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean KZx(String str) {
        return eG(str).KZx == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean ZZv(String str) {
        return eG(str).Mc;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean ML(String str) {
        int i = eG(str).ML;
        if (i != 1) {
            return i == 2 && com.bytedance.sdk.component.utils.DX.KZx(aBv.pA()) != 0;
        }
        return com.bytedance.sdk.component.utils.DX.ZZv(aBv.pA());
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean JG(String str) {
        return eG(str).SD == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int SD(String str) {
        return eG(str).XT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean omh(String str) {
        return str == null || eG(str).Sn == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Bzk(String str) {
        if (str == null) {
            return 1500;
        }
        return eG(str).oX;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int SGo(String str) {
        return eG(str).BSW;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int BSW(String str) {
        return eG(str).WV;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean WV(String str) {
        try {
            return eG(str).BF != null;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean IG() {
        return this.DX.Og();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Wx(String str) {
        return eG(String.valueOf(str)).omh;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean Sn(String str) {
        return Wx(str) != 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int DX(String str) {
        return eG(str).SGo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int pA(String str, boolean z) {
        if (str == null) {
            return KZx(z);
        }
        Og ogEG = eG(str);
        return ogEG.TV != -1 ? ogEG.TV : KZx(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean oX(String str) {
        return eG(str).TX == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean aBv(String str) {
        return str == null || DeviceUtils.omh(aBv.pA()) == 0 || eG(str).Wx == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String lT() {
        return this.DX.pA("ads_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String rB() {
        return this.DX.pA("app_log_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String xy() {
        return this.Sn.pA("apm_url", "pangolin16.sgsnssdk.com");
    }

    private int GbR() {
        return this.DX.pA("coppa", -99);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String qmB() {
        return this.DX.pA("policy_url", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int gbA() {
        return this.DX.pA("ivrv_downward", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String Vgu() {
        return this.DX.pA("dyn_draw_engine_url", Bzk);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String CIG() {
        return this.DX.pA("dc", "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int SzT() {
        return this.DX.pA("isGdprUser", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int pA(int i) {
        return eG(String.valueOf(i)).xy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Og(int i) {
        return eG(String.valueOf(i)).Og;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int KZx(int i) {
        return eG(String.valueOf(i)).Bzk;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int FQ() {
        return this.DX.pA("vbtt", 5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public JSONObject XT(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(this.DX.pA("core_settings", ""));
            try {
                jSONObjectJsonObjectInit.put("ad_slot_setting", eG(str).agB);
                return jSONObjectJsonObjectInit;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObjectJsonObjectInit;
                com.bytedance.sdk.component.utils.WV.pA("TTAD.SdkSettings", "getCoreSettingJsonObj", e.getMessage());
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int yFO(String str) {
        return eG(str).vZF;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean vZF(String str) {
        return eG(str).Sd;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Sd(String str) {
        return eG(str).du;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int TX(String str) {
        return eG(str).eG;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int BF(String str) {
        return eG(str).roi;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean WQf(String str) {
        return eG(str).lT;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int TV(String str) {
        return eG(str).rB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean du(String str) {
        return aBv.ZZv().eG(str).DX == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public Og eG(String str) {
        return KZx.pA(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean Gx() {
        int iPA = this.DX.pA("privacy_ad_enable", Integer.MAX_VALUE);
        if (iPA == 1) {
            return true;
        }
        if (iPA == 0) {
            return false;
        }
        int iOX = gbA.oX();
        return iOX == 1 || iOX == 2 || iOX == 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Bf() {
        int iPA = this.DX.pA("privacy_personalized_ad", Integer.MAX_VALUE);
        if (iPA != Integer.MAX_VALUE) {
            return iPA;
        }
        int iOX = gbA.oX();
        if (iOX == 1 || iOX == 2) {
            return 2;
        }
        return iOX != 3 ? 0 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean gy() {
        return this.DX.pA("perf_con_apm_native", Integer.MAX_VALUE) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean JBA() {
        boolean z = this.DX.pA("bus_con_sec_type", Integer.MAX_VALUE) != 0;
        new Object[]{"secSdk type: ", Boolean.valueOf(z)};
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean agB() {
        return this.DX.pA("bus_con_dislike_report_raw", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean fN() {
        return this.DX.pA("privacy_debug_unlock", 1) != 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean roi(String str) {
        Set set = (Set) this.DX.pA("privacy_fields_allowed", Collections.emptySet(), ML.Og);
        if (set.isEmpty()) {
            int iOX = gbA.oX();
            if (iOX != 1) {
                if (iOX != 2 && iOX != 3) {
                    return false;
                }
                if (!"mcc".equals(str) && !"mnc".equals(str)) {
                    return false;
                }
            }
            return true;
        }
        return set.contains(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean qQU() {
        return this.DX.pA("privacy_app_reg", true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean dmv() {
        return this.aBv;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean fJy() {
        return this.DX.pA("global_rate", 1.0f) == 1.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean YkC() {
        return this.DX.pA("read_video_from_cache", 1) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int dC() {
        int iPA = this.DX.pA("perf_con_webview_cache_count", 0);
        if (iPA < 0) {
            return 0;
        }
        return iPA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int IIF() {
        int iPA = this.DX.pA("perf_con_webview_cache_count_v3", 0);
        if (iPA < 0) {
            return 0;
        }
        return iPA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String[] vA() {
        try {
            Set<String> set = this.SGo;
            if (set == null || set.size() == 0) {
                JSONArray jSONArray = new JSONArray(this.DX.pA("gecko_hosts", (String) null));
                if (jSONArray.length() != 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.SGo.add(jSONArray.getString(i));
                    }
                }
                Set<String> setPA = Wx.pA(this.SGo);
                this.SGo = setPA;
                if (setPA != null) {
                    if (setPA.size() == 0) {
                    }
                }
                return null;
            }
            return (String[]) this.SGo.toArray(new String[0]);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int PV() {
        return this.DX.pA("blank_detect_rate", 30);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public JSONObject cFQ() {
        return (JSONObject) this.DX.pA("video_cache_config", null, ML.pA);
    }

    private long aj() {
        long jPA = this.DX.pA("req_inter_min", 600000L);
        if (jPA < 0 || jPA > 86400000) {
            return 600000L;
        }
        return jPA;
    }

    private long sPI() {
        return this.DX.pA("last_req_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void pA(long j) {
        this.DX.pA().pA("last_req_time", j).pA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void lx() {
        this.XT = true;
    }

    void PU() {
        if (Sn.pA()) {
            com.bytedance.sdk.openadsdk.core.Sn.Og().removeCallbacks(this.du);
            com.bytedance.sdk.openadsdk.core.Sn.Og().postDelayed(this.du, aj());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void ZZv(int i) {
        pA(i, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void pA(int i, boolean z) {
        if (!com.bytedance.sdk.openadsdk.core.Sn.ML() && i != 1 && i != 2) {
            if (z) {
                this.Sd = true;
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.Bzk.Og().ZZv())) {
                return;
            }
            if (this.Sd) {
                this.Sd = false;
                if (!z) {
                    z = true;
                }
            }
            long jSPI = sPI();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jAj = aj();
            long j = jCurrentTimeMillis - jSPI;
            if (!z && j < jAj) {
                com.bytedance.sdk.openadsdk.core.SGo.pA.pA();
                return;
            }
            if (!Sn.pA()) {
                Og(i, z);
            } else if (this.oX.compareAndSet(false, true)) {
                xy.Og((com.bytedance.sdk.component.omh.omh) new Sn(this, this.DX, this.Wx, this.Sn));
                com.bytedance.sdk.openadsdk.core.Sn.Og().removeCallbacks(this.du);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.Sn.pA
    public void pA(boolean z) {
        this.oX.set(false);
        PU();
        if (z) {
            Xj();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public void pA(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("_tryFetRemoDat");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.TV, intentFilter, 4);
            } else {
                context.registerReceiver(this.TV, intentFilter);
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("TTAD.SdkSettings", "", e);
        }
        if (dmv()) {
            ZZv(1);
            PU();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.settings.oX$11, reason: invalid class name */
    class AnonymousClass11 extends BroadcastReceiver {
        private final Runnable Og = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.11.1
            @Override // java.lang.Runnable
            public void run() {
                xy.Og(new com.bytedance.sdk.component.omh.omh("LoadLocalData") { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.11.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            oX.this.Og();
                        } catch (Exception unused) {
                        }
                    }
                });
            }
        };

        AnonymousClass11() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            xy.Og(new com.bytedance.sdk.component.omh.omh("setting_receiver") { // from class: com.bytedance.sdk.openadsdk.core.settings.oX.11.2
                @Override // java.lang.Runnable
                public void run() {
                    String action = intent.getAction();
                    if ("_tryFetRemoDat".equals(action)) {
                        oX.this.pA(intent.getIntExtra("_source", 0), intent.getBooleanExtra("_force", false));
                    } else if ("_dataChanged".equals(action)) {
                        com.bytedance.sdk.component.utils.SD.pA().removeCallbacks(AnonymousClass11.this.Og);
                        com.bytedance.sdk.component.utils.SD.pA().postDelayed(AnonymousClass11.this.Og, 10000L);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean SXO() {
        if (com.bytedance.sdk.component.adexpress.ZZv.Og.pA(aBv.pA())) {
            return this.DX.pA("support_rtl", false);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int fw() {
        return this.DX.pA("bus_con_send_log_type", 1);
    }

    private Set<String> BDQ() {
        return (Set) this.DX.pA("perf_con_applog_send", this.roi, this.Mc);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int nCO() {
        return this.DX.pA("perf_con_thread_stack_size", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean HSv() {
        int iPA = this.Sn.pA("perf_con_apm", 100);
        if (iPA == 0) {
            return false;
        }
        return iPA < 0 || iPA >= 100 || iPA > ((int) (Math.random() * 100.0d));
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public long Wo() {
        return this.DX.pA("perf_con_adlog_expire_time", 0L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean sk() {
        return this.DX.pA("perf_con_use_new_thread_pool", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean npn() {
        return this.DX.pA("perf_con_is_new_net_thread", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean pA(PangleEncryptConstant.CryptDataScene cryptDataScene) {
        if (cryptDataScene == PangleEncryptConstant.CryptDataScene.GET_ADS || cryptDataScene == PangleEncryptConstant.CryptDataScene.BIDDING_TOKEN) {
            return this.DX.pA("perf_con_crypt_V4_get_ad", false);
        }
        if (cryptDataScene == PangleEncryptConstant.CryptDataScene.APP_LOG) {
            return this.DX.pA("perf_con_crypt_V4_applog", false);
        }
        return this.DX.pA("perf_con_crypt_V4", false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public JSONObject Uz() {
        return (JSONObject) this.DX.pA("perf_con_thread_pool_config", new JSONObject(), this.IG);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean Itl() {
        return this.DX.pA("perf_con_adlog_turn_off_retry_ad", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean tM() {
        return this.DX.pA("perf_con_adlog_turn_off_retry_stats", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public String tZW() {
        return this.DX.pA("dual_event_url", (String) null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int Ld() {
        int iPA = this.DX.pA("bus_con_auto_click_delay", 3000);
        if (iPA <= 0) {
            return 3000;
        }
        return iPA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public com.bytedance.sdk.openadsdk.ZZv.pA.Sn rtW() {
        return (com.bytedance.sdk.openadsdk.ZZv.pA.Sn) this.DX.pA("perf_con_track_url_strategy", com.bytedance.sdk.openadsdk.ZZv.pA.Sn.pA, this.omh);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public int guZ() {
        return this.DX.pA("perf_con_close_button_delay_check_time", -1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public Set<String> dGZ() {
        return (Set) this.DX.pA("perf_con_drop2rt_skip_label_list", Collections.emptySet(), ML.Og);
    }

    public static boolean ka() {
        return WV;
    }

    public static void pA(DX.pA pAVar) {
        ConcurrentLinkedQueue<DX.pA> concurrentLinkedQueue = TX;
        if (concurrentLinkedQueue.contains(pAVar)) {
            return;
        }
        concurrentLinkedQueue.add(pAVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean Lm() {
        return this.DX.pA("bus_con_rewardedfull_link", 0) == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.JG
    public boolean rjD() {
        return this.DX.pA("bus_con_video_keep_screen_on", 1) == 1;
    }
}
