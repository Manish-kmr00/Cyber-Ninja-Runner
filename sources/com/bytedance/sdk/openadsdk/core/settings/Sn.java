package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.BF;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.roi;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.json.b9;
import com.json.fe;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.pubnative.lite.sdk.models.RemoteConfigFeature;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class Sn extends com.bytedance.sdk.component.omh.omh {
    private final Set<ML> KZx;
    private final Wx Og;
    private final pA pA;

    public interface pA {
        void pA(boolean z);
    }

    public Sn(pA pAVar, Wx wx, ML... mlArr) {
        super("SetF");
        HashSet hashSet = new HashSet();
        this.KZx = hashSet;
        this.pA = pAVar;
        this.Og = wx;
        hashSet.addAll(Arrays.asList(mlArr));
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d("TTAD.SdkSettingsFetch", "Start Try");
        int iPA = BF.pA(aBv.pA(), 0L);
        if (iPA == 0) {
            Log.d("TTAD.SdkSettingsFetch", "No net");
            this.pA.pA(false);
            return;
        }
        final com.bytedance.sdk.openadsdk.Sn.pA.ML ml = new com.bytedance.sdk.openadsdk.Sn.pA.ML(1);
        JSONObject jSONObjectPA = pA(iPA);
        com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
        try {
            String strPA = com.bytedance.sdk.openadsdk.omh.ZZv.pA(zZvOg, gbA.ZZv("/api/ad/union/sdk/settings/"));
            zZvOg.Og(strPA);
            zZvOg.Og("User-Agent", gbA.KZx());
            ml.pA(strPA);
        } catch (Exception unused) {
        }
        String string = Og(jSONObjectPA).toString();
        if (aBv.ZZv().fN() && roi.pA().SD() == 1) {
            gbA.pA("Pangle_Debug_Mode", string, aBv.pA());
        }
        zZvOg.pA(string, aBv.ZZv().aBv());
        ml.pA(zZvOg.ZZv()).pA();
        zZvOg.pA(6);
        zZvOg.pA("setting");
        com.bytedance.sdk.openadsdk.oX.KZx.pA(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.settings.Sn.1
            @Override // com.bytedance.sdk.openadsdk.oX.ZZv
            public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                pAVar.Og("settings_fetch");
                return pAVar;
            }
        });
        zZvOg.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.settings.Sn.2
            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) throws JSONException {
                JSONObject jSONObjectJsonObjectInit;
                int iOptInt;
                int iPA2 = og.pA();
                String strZZv = og.ZZv();
                if (aBv.ZZv().fN() && roi.pA().SD() == 1) {
                    gbA.pA("Pangle_Debug_Mode", strZZv, aBv.pA());
                }
                if (og.JG() && !TextUtils.isEmpty(strZZv)) {
                    ml.KZx(strZZv).pA(iPA2).pA(true);
                    String strKZx = null;
                    try {
                        jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strZZv);
                    } catch (JSONException unused2) {
                        jSONObjectJsonObjectInit = null;
                    }
                    if (jSONObjectJsonObjectInit != null && (iOptInt = jSONObjectJsonObjectInit.optInt("cypher", -1)) != -1) {
                        if (iOptInt == 3) {
                            strKZx = com.bytedance.sdk.component.utils.pA.KZx(jSONObjectJsonObjectInit.optString("message"));
                            if (!TextUtils.isEmpty(strKZx)) {
                                try {
                                    jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strKZx);
                                } catch (Throwable unused3) {
                                }
                            }
                        }
                        try {
                            Sn.this.pA(strKZx, og.KZx());
                        } catch (Throwable unused4) {
                        }
                        try {
                            Sn.this.pA(jSONObjectJsonObjectInit);
                            aBv.ZZv().pA(System.currentTimeMillis());
                            com.bytedance.sdk.openadsdk.oX.KZx.Og(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.settings.Sn.2.1
                                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                    pAVar.Og("settings_fetch");
                                    return pAVar;
                                }
                            });
                        } catch (Throwable unused5) {
                        }
                        Sn.this.pA.pA(true);
                        com.bytedance.sdk.openadsdk.core.SGo.pA.pA();
                        return;
                    }
                } else {
                    com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.settings.Sn.2.2
                        @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                        public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                            com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                            pAVar.Og("settings_fetch");
                            return pAVar;
                        }
                    });
                }
                ml.KZx(strZZv).pA(iPA2).ZZv(og.Og()).pA(og.JG());
                Sn.this.pA.pA(false);
            }

            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                ml.ZZv(iOException != null ? iOException.getMessage() : null).pA(false);
                Sn.this.pA.pA(false);
                com.bytedance.sdk.openadsdk.core.SGo.pA.pA();
                com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.settings.Sn.2.3
                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                        pAVar.Og("settings_fetch");
                        return pAVar;
                    }
                });
            }
        });
        DeviceUtils.BSW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(String str, Map<String, String> map) {
        int i = 1;
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                HashMap map2 = new HashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        map2.put(key.toLowerCase(Locale.US), entry.getValue());
                    }
                }
                int i2 = Integer.parseInt((String) map2.get("active-control"));
                long j = Long.parseLong((String) map2.get("ts"));
                String str2 = (String) map2.get("pst");
                String strPA = com.bykv.vk.openvk.pA.pA.pA.SD.Og.pA(str + i2 + j);
                if (strPA != null && strPA.equalsIgnoreCase(str2)) {
                    i = i2;
                }
            }
        } catch (Throwable unused) {
        }
        WV.pA(i);
    }

    public static JSONObject pA(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JG jgZZv = aBv.ZZv();
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("device_city", gbA.DX());
            if (jgZZv.roi(fe.Q0)) {
                jSONObject.put(fe.Q0, com.bytedance.sdk.openadsdk.XT.pA.Og.pA.pA().Og());
            }
            jSONObject.put("gdpr", com.bytedance.sdk.openadsdk.core.Bzk.Og().Bzk());
            jSONObject.put("coppa", com.bytedance.sdk.openadsdk.core.Bzk.Og().omh());
            jSONObject.put(RemoteConfigFeature.UserConsent.CCPA, com.bytedance.sdk.openadsdk.core.Bzk.Og().vZF());
            if (jgZZv.roi("mcc")) {
                jSONObject.put("mcc", com.bytedance.sdk.openadsdk.utils.roi.Og());
            }
            Context contextPA = aBv.pA();
            jSONObject.put("conn_type", gbA.SD(i));
            jSONObject.put("os", 1);
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(CommonUrlParts.OS_VERSION, Build.VERSION.RELEASE);
            jSONObject.put("aos_api_level", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put(POBConstants.KEY_LANGUAGE, com.bytedance.sdk.openadsdk.core.WV.Og());
            jSONObject.put("time_zone", gbA.XT());
            jSONObject.put("package_name", gbA.ML());
            jSONObject.put(b9.h.L, gbA.pA() ? 1 : 2);
            jSONObject.put("app_version", gbA.SD());
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(CommonUrlParts.UUID, com.bytedance.sdk.openadsdk.core.WV.KZx(contextPA));
            String strZZv = com.bytedance.sdk.openadsdk.core.Bzk.Og().ZZv();
            if (strZZv != null) {
                jSONObject.put("app_id", strZZv);
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (strZZv != null) {
                strConcat = strZZv.concat(String.valueOf(jCurrentTimeMillis)).concat(BuildConfig.VERSION_NAME);
            }
            jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ML.pA(strConcat));
            jSONObject.put("tcstring", oX.KZx(contextPA));
            jSONObject.put("tcf_gdpr", oX.Og(contextPA));
            jSONObject.put("lmt", DeviceUtils.KZx());
            jSONObject.put("locale_language", DeviceUtils.ZZv());
            jSONObject.put("channel", b9.h.Z);
            JSONObject jSONObjectML = jgZZv.ML();
            if (jSONObjectML != null) {
                jSONObject.put("digest", jSONObjectML);
            }
            jSONObject.put("data_time", jgZZv.JG());
            jSONObject.put(CommonUrlParts.APP_SET_ID_SCOPE, ZZv.Og());
            jSONObject.put(CommonUrlParts.APP_SET_ID, ZZv.KZx());
            jSONObject.put("installed_source", ZZv.ZZv());
            if (jgZZv.roi(fe.Q0)) {
                jSONObject.put("did", com.bytedance.sdk.openadsdk.core.WV.pA(aBv.pA()));
            }
            String strML = com.bytedance.sdk.openadsdk.core.Bzk.Og().ML();
            if (!TextUtils.isEmpty(strML)) {
                jSONObject.put("mediation", strML);
            }
            jSONObject.put("device", DeviceUtils.pA(contextPA, true));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject Og(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.pA.pA(jSONObject);
    }

    public boolean pA(JSONObject jSONObject) {
        this.Og.pA(jSONObject);
        for (ML ml : this.KZx) {
            if (ml != null) {
                ml.pA(jSONObject);
            }
        }
        return this.Og.KZx;
    }

    public static boolean pA() {
        return BinderPoolService.pA;
    }
}
