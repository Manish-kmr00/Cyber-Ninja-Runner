package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.WindowManager;
import com.bytedance.sdk.component.embedapplog.PangleEncryptConstant;
import com.bytedance.sdk.component.embedapplog.PangleEncryptManager;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.qmB;
import com.json.b9;
import com.json.cc;
import com.json.yk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.playon.bridge.Ad;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.internal.partials.PangleNetworkBridge;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import net.pubnative.lite.sdk.models.Protocol;
import net.pubnative.lite.sdk.models.RemoteConfigFeature;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class vZF implements yFO<com.bytedance.sdk.openadsdk.ZZv.pA> {
    private final Context pA;

    vZF(Context context) {
        this.pA = context;
    }

    @DungeonFlag
    private JSONObject pA(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.TX tx, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String strZZv = (tx == null || TextUtils.isEmpty(tx.pA)) ? gbA.ZZv() : tx.pA;
            if (i == 7) {
                if (tx != null && tx.Og > 0) {
                    jSONObject2.put("req_type", tx.Og);
                }
            } else if (i == 8) {
                if (tx != null && tx.KZx > 0) {
                    jSONObject2.put("req_type", tx.KZx);
                }
            } else if (i == 3 && tx != null && tx.ZZv > 0) {
                jSONObject2.put("req_type", tx.ZZv);
            }
            try {
                String strSGo = aBv.ZZv().SGo();
                String strVZF = aBv.ZZv().vZF();
                if (strSGo != null && strVZF != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("version", strSGo);
                    jSONObject3.put(Ad.VERIFICATIONPARAM, strVZF);
                    jSONObject2.put("abtest", jSONObject3);
                }
            } catch (Throwable unused) {
            }
            if (adSlot != null && adSlot.getBiddingTokens() != null) {
                jSONObject2.put("bidding_param", adSlot.getBiddingTokens());
                com.bytedance.sdk.openadsdk.core.settings.Og ogEG = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().eG(adSlot.getCodeId());
                jSONObject2.put("waterfall_id", ogEG.FQ);
                jSONObject2.put("waterfall_version", ogEG.Gx);
                jSONObject2.put("link_id", adSlot.getLinkId());
            }
            jSONObject2.put("request_id", strZZv);
            gbA.pA(jSONObject2);
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put("rewardedfull_link", com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Lm() ? 1 : 0);
            jSONObject2.put("js_render_ver", com.bytedance.sdk.openadsdk.core.omh.WV.Og());
            jSONObject2.put("js_render_v3_ver", com.bytedance.sdk.openadsdk.core.omh.WV.KZx());
            jSONObject2.put("source_type", "app");
            jSONObject2.put("app", KZx());
            Object objPA = DeviceUtils.pA(this.pA, true);
            new Object[]{"device info:", objPA};
            jSONObject2.put("device", objPA);
            jSONObject2.put(POBConstants.KEY_USER, pA(adSlot));
            jSONObject2.put("ua", gbA.KZx());
            jSONObject2.put("channel", b9.h.Z);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(pA(adSlot, i, tx));
            jSONObject2.put("adslots", jSONArray);
            pA(jSONObject2, tx);
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            jSONObject2.put("ts", jCurrentTimeMillis);
            String strConcat = "";
            if (adSlot.getCodeId() != null && strZZv != null) {
                strConcat = String.valueOf(jCurrentTimeMillis).concat(adSlot.getCodeId()).concat(strZZv);
            }
            jSONObject2.put("req_sign", com.bytedance.sdk.component.utils.ML.pA(strConcat));
            if (com.bytedance.sdk.openadsdk.core.Bzk.KZx.ML() != 0) {
                jSONObject2.put("pglx", String.valueOf(com.bytedance.sdk.openadsdk.core.Bzk.KZx.ML()));
            }
            com.bytedance.sdk.openadsdk.JG.Og.pA().pA(jSONObject2);
            jSONObject = pA(PangleEncryptConstant.CryptDataScene.GET_ADS, jSONObject2);
            if (jSONObject != null) {
                jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
                jSONObject.put("oversea_version_type", 1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.TX.Og("body data exception", th);
        }
        return jSONObject;
    }

    private void pA(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.TX tx) {
        if (tx == null || tx.ML == null) {
            return;
        }
        try {
            jSONObject.put("source_temai_product_ids", tx.ML);
        } catch (Exception unused) {
        }
    }

    private boolean ZZv(String str) {
        if (com.bytedance.sdk.openadsdk.core.SD.Og.pA()) {
            return true;
        }
        if (!com.bytedance.sdk.openadsdk.core.SD.Og.pA(str)) {
            return false;
        }
        String strOg = com.bytedance.sdk.openadsdk.core.SD.Og.Og();
        if (!TextUtils.isEmpty(strOg)) {
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(strOg, System.currentTimeMillis());
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    public void pA(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.TX tx, final int i, yFO.pA pAVar) {
        final com.bytedance.sdk.openadsdk.core.pA.pA pAVar2 = new com.bytedance.sdk.openadsdk.core.pA.pA(pAVar, adSlot);
        if (tx != null && (tx.Og == 2 || tx.KZx == 2 || tx.ZZv == 2)) {
            adSlot.setPreload(true);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Sn.Og().post(new com.bytedance.sdk.component.omh.omh("getAd") { // from class: com.bytedance.sdk.openadsdk.core.vZF.1
                @Override // java.lang.Runnable
                public void run() {
                    vZF.this.Og(adSlot, tx, i, pAVar2);
                }
            });
        } else {
            Og(adSlot, tx, i, pAVar2);
        }
        if (com.bytedance.sdk.openadsdk.vZF.pA.KZx()) {
            Sn.SD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.bytedance.sdk.openadsdk.core.vZF] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.Map] */
    public void Og(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.TX tx, final int i, final yFO.pA pAVar) {
        String str;
        Object og;
        com.bytedance.sdk.openadsdk.Sn.pA.ML ml;
        if (!aBv.ZZv().qQU()) {
            pAVar.pA(40060, omh.pA(40060));
            return;
        }
        boolean zKZx = com.bytedance.sdk.openadsdk.vZF.pA.KZx();
        if (!zKZx) {
            Sn.JG();
        }
        final com.bytedance.sdk.openadsdk.core.model.Og og2 = new com.bytedance.sdk.openadsdk.core.model.Og();
        og2.pA(adSlot);
        if (!com.bytedance.sdk.openadsdk.core.settings.WV.pA()) {
            if (pAVar != null) {
                pAVar.pA(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
                og2.pA(1000);
                com.bytedance.sdk.openadsdk.core.model.Og.pA(og2);
                return;
            }
            return;
        }
        if (!aBv.ZZv().Gx()) {
            if (pAVar != null) {
                pAVar.pA(-16, omh.pA(-16));
                og2.pA(1001);
                com.bytedance.sdk.openadsdk.core.model.Og.pA(og2);
                return;
            }
            return;
        }
        if (pAVar == null) {
            return;
        }
        if (ZZv(adSlot.getCodeId())) {
            pAVar.pA(-8, omh.pA(-8));
            return;
        }
        if (!TextUtils.isEmpty(adSlot.getBidAdm()) && !tx.JG) {
            og2.Og(2);
            og2.pA(adSlot.getBidAdm());
            if (com.bytedance.sdk.component.utils.WV.ZZv()) {
                com.bykv.vk.openvk.pA.pA.pA.SD.Og.pA(adSlot.getBidAdm());
            }
            if (aBv.ZZv().fN() && roi.pA().SD() == 1) {
                gbA.pA("Pangle_Debug_Mode", adSlot.getBidAdm(), this.pA);
            }
            try {
                JSONObject jSONObjectPA = pA(PangleNetworkBridge.jsonObjectInit(adSlot.getBidAdm()));
                if (jSONObjectPA == null) {
                    pA(pAVar, og2);
                    return;
                }
                pA pAVarPA = pA.pA(jSONObjectPA, adSlot, tx, og2);
                og2.pA(pAVarPA.SGo);
                WV.pA(this.pA, pAVarPA.Bzk);
                if (pAVarPA.ZZv != 20000) {
                    pAVar.pA(pAVarPA.ZZv, pAVarPA.ML);
                    og2.pA(pAVarPA.ZZv);
                    com.bytedance.sdk.openadsdk.core.model.Og.pA(og2);
                    return;
                } else {
                    if (pAVarPA.omh == null) {
                        pA(pAVar, og2);
                        return;
                    }
                    if (pAVarPA.omh.ZZv() != null && pAVarPA.omh.ZZv().size() > 0) {
                        com.bytedance.sdk.openadsdk.Sn.KZx.pA(pAVarPA.omh.ZZv().get(0));
                    }
                    pAVarPA.omh.KZx(jSONObjectPA.toString());
                    pAVar.pA(pAVarPA.omh, og2);
                    Map<String, com.bytedance.sdk.openadsdk.core.model.yFO> mapPA = com.bytedance.sdk.openadsdk.core.model.pA.pA(pAVarPA.omh);
                    if (mapPA != null) {
                        com.bytedance.sdk.openadsdk.SD.Og.pA().pA(mapPA);
                    }
                    pA(pAVarPA.omh);
                    com.bytedance.sdk.openadsdk.core.ZZv.pA.pA().pA(pAVarPA.omh);
                    return;
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "get ad error: ", th);
                pA(pAVar, og2);
                return;
            }
        }
        JSONObject jSONObjectPA2 = pA(adSlot, tx, i);
        if (jSONObjectPA2 == null) {
            pAVar.pA(-9, omh.pA(-9));
            og2.pA(-9);
            com.bytedance.sdk.openadsdk.core.model.Og.pA(og2);
            return;
        }
        if (aBv.ZZv().fN() && roi.pA().SD() == 1) {
            gbA.pA("Pangle_Debug_Mode", jSONObjectPA2.toString(), this.pA);
        }
        if (adSlot.getBiddingTokens() == null) {
            str = "/api/ad/union/sdk/get_ads/";
        } else {
            str = "/api/ad/union/mediation/get_ads/";
        }
        String strPA = gbA.pA(str, true);
        com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
        final com.bytedance.sdk.openadsdk.Sn.pA.ML ml2 = new com.bytedance.sdk.openadsdk.Sn.pA.ML(2);
        try {
            String strPA2 = com.bytedance.sdk.openadsdk.omh.ZZv.pA(zZvOg, strPA);
            zZvOg.Og(strPA2);
            ml2.pA(strPA2);
        } catch (Exception unused) {
        }
        zZvOg.pA(jSONObjectPA2.toString(), aBv.ZZv().aBv());
        ml2.pA(zZvOg.ZZv()).pA();
        Map<String, String> mapPA2 = com.bytedance.sdk.openadsdk.core.Bzk.KZx.pA(strPA, jSONObjectPA2.toString());
        if (mapPA2 != null && mapPA2.size() > 0) {
            for (String str2 : mapPA2.keySet()) {
                try {
                    zZvOg.Og(str2, mapPA2.get(str2));
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e.getMessage());
                }
            }
        }
        try {
            zZvOg.Og("User-Agent", gbA.KZx());
            pA(zZvOg, jSONObjectPA2);
        } catch (Exception unused2) {
        }
        final qmB qmbOg = qmB.Og();
        final Map<String, Object> requestExtraMap = adSlot.getRequestExtraMap();
        boolean z = Bzk.Og().aBv() && requestExtraMap != null;
        if (z) {
            requestExtraMap.put("pgad_start", qmbOg);
        }
        if (adSlot.getBiddingTokens() != null) {
            pA(adSlot, tx, zZvOg, requestExtraMap, z, qmbOg, pAVar);
            return;
        }
        zZvOg.pA(10);
        zZvOg.pA("get_ad");
        com.bytedance.sdk.openadsdk.oX.KZx.pA(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.8
            @Override // com.bytedance.sdk.openadsdk.oX.ZZv
            public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                com.bytedance.sdk.openadsdk.oX.Og.pA pAVar2 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                pAVar2.Og("get_ad");
                pAVar2.KZx(adSlot.getCodeId());
                pAVar2.ZZv(gbA.KZx(adSlot.getDurationSlotType()));
                return pAVar2;
            }
        });
        if (com.bytedance.sdk.component.utils.WV.ZZv()) {
            Thread.currentThread().getName();
        }
        if (!zKZx) {
            final boolean z2 = z;
            zZvOg.pA(new com.bytedance.sdk.component.SD.pA.Og() { // from class: com.bytedance.sdk.openadsdk.core.vZF.9
                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og3) {
                    vZF.this.pA(og3, ml2, z2, requestExtraMap, qmbOg, adSlot, og2, pAVar, tx, i);
                }

                @Override // com.bytedance.sdk.component.SD.pA.Og
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException, com.bytedance.sdk.component.SD.Og og3) {
                    vZF.this.pA(iOException, og3, adSlot, ml2, z2, requestExtraMap, pAVar, og2);
                }
            });
            return;
        }
        try {
            com.bytedance.sdk.component.SD.Og ogPA = zZvOg.pA();
            if (ogPA == null) {
                ml = null;
                og = new com.bytedance.sdk.component.SD.Og(false, 5001, "RequestBody is null, content type is not support!!", null, "REQUEST_BODY_NULL", 1L, 1L);
            }
            com.bytedance.sdk.component.SD.Og og3 = ogPA;
            try {
                if (og3.JG()) {
                    pA(og3, ml2, z, requestExtraMap, qmbOg, adSlot, og2, pAVar, tx, i);
                } else {
                    pA(new IOException(og3.Og()), og3, adSlot, ml2, z, requestExtraMap, pAVar, og2);
                }
            } catch (Throwable th2) {
                th = th2;
                pA(new IOException(th.getMessage()), new com.bytedance.sdk.component.SD.Og(false, 5002, "execute method throw exception", null, "REQUEST_BODY_EXCEPTION", 1L, 1L), adSlot, ml, z, og, pAVar, og2);
            }
        } catch (Throwable th3) {
            th = th3;
            og = requestExtraMap;
            ml = ml2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(IOException iOException, com.bytedance.sdk.component.SD.Og og, final AdSlot adSlot, com.bytedance.sdk.openadsdk.Sn.pA.ML ml, boolean z, Map<String, Object> map, yFO.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og2) {
        String message;
        int iPA;
        com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.10
            @Override // com.bytedance.sdk.openadsdk.oX.ZZv
            public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                com.bytedance.sdk.openadsdk.oX.Og.pA pAVar2 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                pAVar2.Og("get_ad");
                pAVar2.KZx(adSlot.getCodeId());
                pAVar2.ZZv(gbA.KZx(adSlot.getDurationSlotType()));
                pAVar2.pA(BuildConfig.VERSION_NAME);
                return pAVar2;
            }
        });
        ml.Og();
        if (og != null) {
            message = og.Og();
        } else if (iOException == null) {
            message = "";
        } else {
            message = iOException.getMessage();
        }
        qmB qmbOg = qmB.Og();
        if (z) {
            map.put("pgad_end", Long.valueOf(qmbOg.pA));
        }
        if (aBv.ZZv().fN() && roi.pA().SD() == 1) {
            gbA.pA("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, this.pA);
        }
        if (og != null) {
            iPA = og.pA();
        } else {
            iPA = (iOException == null || !(iOException instanceof SocketTimeoutException)) ? 601 : 602;
        }
        if (pAVar != null) {
            pAVar.pA(iPA, message);
        }
        new Object[]{"onFailure: ", Integer.valueOf(iPA)};
        og2.pA(iPA);
        com.bytedance.sdk.openadsdk.core.model.Og.pA(og2);
        com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx.incrementAndGet();
        com.bytedance.sdk.openadsdk.ZZv.pA.JG.pA.incrementAndGet();
        com.bytedance.sdk.openadsdk.ZZv.pA.JG.SD.incrementAndGet();
        com.bytedance.sdk.openadsdk.ZZv.pA.JG.ML();
        com.bytedance.sdk.openadsdk.ZZv.pA.JG.pA(iPA, message);
        com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx();
        ml.ZZv(message).pA(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void pA(com.bytedance.sdk.component.SD.Og og, com.bytedance.sdk.openadsdk.Sn.pA.ML ml, boolean z, Map<String, Object> map, qmB qmb, final AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.Og og2, yFO.pA pAVar, com.bytedance.sdk.openadsdk.core.model.TX tx, int i) {
        com.bytedance.sdk.openadsdk.core.model.Og og3;
        qmB qmb2;
        boolean z2;
        System.currentTimeMillis();
        ml.Og();
        if (z) {
            map.put("pgad_end", qmb);
        }
        if (og == null) {
            return;
        }
        if (og.JG()) {
            com.bytedance.sdk.openadsdk.oX.KZx.Og(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.11
                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar2 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                    pAVar2.Og("get_ad");
                    pAVar2.KZx(adSlot.getCodeId());
                    pAVar2.ZZv(gbA.KZx(adSlot.getDurationSlotType()));
                    pAVar2.pA(BuildConfig.VERSION_NAME);
                    return pAVar2;
                }
            });
            com.bytedance.sdk.openadsdk.ZZv.pA.JG.Og.incrementAndGet();
            com.bytedance.sdk.openadsdk.ZZv.pA.JG.pA.incrementAndGet();
            try {
                qmB qmbOg = qmB.Og();
                String strZZv = og.ZZv();
                JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strZZv);
                if (aBv.ZZv().fN() && roi.pA().SD() == 1) {
                    gbA.pA("Pangle_Debug_Mode", jSONObjectJsonObjectInit.toString(), this.pA);
                }
                og2.pA(strZZv);
                JSONObject jSONObjectPA = pA(jSONObjectJsonObjectInit);
                if (jSONObjectPA == null) {
                    pA(pAVar, og2);
                    com.bytedance.sdk.openadsdk.ZZv.pA.JG.JG.incrementAndGet();
                    com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx();
                    ml.pA(true).pA(og.pA()).KZx(strZZv);
                    return;
                }
                pA pAVarPA = pA.pA(jSONObjectPA, adSlot, tx, og2);
                og2.pA(pAVarPA.SGo);
                WV.pA(this.pA, pAVarPA.Bzk);
                if (pAVarPA.ZZv != 20000) {
                    og2.pA(pAVarPA.ZZv);
                    if (!aBv.ZZv().IG() && pAVarPA.ZZv == 40029) {
                        pAVar.pA(-100, omh.pA(-100));
                    } else {
                        pAVar.pA(pAVarPA.ZZv, pAVarPA.ML);
                    }
                    com.bytedance.sdk.openadsdk.core.model.Og.pA(og2);
                    com.bytedance.sdk.openadsdk.ZZv.pA.JG.JG.incrementAndGet();
                    com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx();
                    ml.pA(true).pA(og.pA()).KZx(strZZv);
                    return;
                }
                if (pAVarPA.omh == null) {
                    pA(pAVar, og2);
                    com.bytedance.sdk.openadsdk.ZZv.pA.JG.ML.incrementAndGet();
                    com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx();
                    ml.pA(true).pA(og.pA()).KZx(strZZv);
                    return;
                }
                pAVarPA.omh.KZx(jSONObjectPA.toString());
                pAVarPA.omh.ZZv(strZZv);
                qmB qmbOg2 = qmB.Og();
                if (tx != null && tx.SGo != null) {
                    tx.SGo.pA(qmb, qmbOg, pAVarPA.pA, qmbOg2);
                }
                byte b = com.bytedance.sdk.openadsdk.vZF.pA.ZZv() && i == 1;
                if (!b == true || pAVarPA.omh.ZZv() == null || pAVarPA.omh.ZZv().isEmpty()) {
                    qmb2 = qmbOg;
                } else {
                    com.bytedance.sdk.openadsdk.core.model.yFO yfo = pAVarPA.omh.ZZv().get(0);
                    String strKZx = gbA.KZx(i);
                    boolean zOmh = pAVarPA.omh.omh();
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    long jPA = 0;
                    if (tx != null) {
                        try {
                            qmb2 = qmbOg;
                            try {
                                if (tx.Bzk.pA > 0) {
                                    jPA = qmbOg2.pA(tx.Bzk);
                                }
                            } catch (Exception unused) {
                            }
                        } catch (Exception unused2) {
                            qmb2 = qmbOg;
                        }
                    } else {
                        qmb2 = qmbOg;
                    }
                    long j = jPA;
                    if (yfo != null) {
                        boolean zSzT = yfo.SzT();
                        jSONObject2.put("is_new_engine", zSzT ? 1 : 0);
                        jSONObject2.put("webview_cache_size", zSzT ? com.bytedance.sdk.component.adexpress.ML.ML.pA().ZZv() : com.bytedance.sdk.component.adexpress.ML.ML.pA().KZx());
                    }
                    pA(og.SD(), tx, qmb, qmb2, pAVarPA.pA, qmbOg2, yfo, strKZx, zOmh, jSONObject2, true);
                    jSONObject.put("duration", j);
                    jSONObject.put("extra_data", jSONObject2);
                    jSONObject.put("tag", strKZx);
                    jSONObject.put("callback_start", qmbOg2.pA());
                    pAVarPA.omh.pA(jSONObject);
                }
                pAVar.pA(pAVarPA.omh, og2);
                pA(pAVarPA.omh);
                com.bytedance.sdk.openadsdk.core.ZZv.pA.pA().pA(pAVarPA.omh);
                Map<String, com.bytedance.sdk.openadsdk.core.model.yFO> mapPA = com.bytedance.sdk.openadsdk.core.model.pA.pA(pAVarPA.omh);
                if (mapPA != null) {
                    com.bytedance.sdk.openadsdk.SD.Og.pA().pA(mapPA);
                }
                if (pAVarPA.omh.ZZv() == null || pAVarPA.omh.ZZv().isEmpty()) {
                    strZZv = strZZv;
                    og3 = og2;
                    z2 = true;
                } else {
                    if (b == true) {
                        og3 = og2;
                        z2 = true;
                    } else {
                        z2 = true;
                        og3 = og2;
                        try {
                            pA(og.SD(), tx, qmb, qmb2, pAVarPA.pA, qmbOg2, pAVarPA.omh.ZZv().get(0), gbA.KZx(i), pAVarPA.omh.omh());
                        } catch (Throwable th) {
                            th = th;
                            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "get ad error: ", th);
                            pA(pAVar, og3);
                            com.bytedance.sdk.openadsdk.ZZv.pA.JG.ML.incrementAndGet();
                            com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx();
                            ml.pA(og.JG()).pA(og.pA()).KZx(og.ZZv()).ZZv(th.getMessage());
                            return;
                        }
                    }
                    com.bytedance.sdk.openadsdk.ZZv.pA.JG.ZZv.incrementAndGet();
                }
                com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx();
                ml.pA(z2).pA(og.pA()).KZx(strZZv);
            } catch (Throwable th2) {
                th = th2;
                og3 = og2;
            }
        } else {
            com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.12
                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar2 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                    pAVar2.Og("get_ad");
                    pAVar2.KZx(adSlot.getCodeId());
                    pAVar2.ZZv(gbA.KZx(adSlot.getDurationSlotType()));
                    pAVar2.pA(BuildConfig.VERSION_NAME);
                    return pAVar2;
                }
            });
            int iPA = og.pA();
            String strOg = og.Og();
            pAVar.pA(iPA, strOg);
            og2.pA(iPA);
            com.bytedance.sdk.openadsdk.core.model.Og.pA(og2);
            com.bytedance.sdk.openadsdk.ZZv.pA.JG.omh.incrementAndGet();
            com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx.incrementAndGet();
            com.bytedance.sdk.openadsdk.ZZv.pA.JG.pA.incrementAndGet();
            com.bytedance.sdk.openadsdk.ZZv.pA.JG.ML();
            com.bytedance.sdk.openadsdk.ZZv.pA.JG.pA(iPA, strOg);
            com.bytedance.sdk.openadsdk.ZZv.pA.JG.KZx();
            ml.pA(false).pA(iPA).ZZv(strOg).KZx(og.ZZv());
        }
    }

    private void pA(final AdSlot adSlot, final com.bytedance.sdk.openadsdk.core.model.TX tx, com.bytedance.sdk.component.SD.Og.ZZv zZv, final Map<String, Object> map, final boolean z, final qmB qmb, final yFO.pA pAVar) {
        zZv.pA(new com.bytedance.sdk.component.SD.pA.Og() { // from class: com.bytedance.sdk.openadsdk.core.vZF.13
            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                if (z) {
                    map.put("pgad_end", qmb);
                }
                if (og == null || !og.JG()) {
                    return;
                }
                try {
                    JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(og.ZZv());
                    if (aBv.ZZv().fN() && roi.pA().SD() == 1) {
                        gbA.pA("Pangle_Debug_Mode", jSONObjectJsonObjectInit.toString(), vZF.this.pA);
                    }
                    JSONObject jSONObjectPA = vZF.this.pA(jSONObjectJsonObjectInit);
                    if (jSONObjectPA == null) {
                        pAVar.pA(-1, omh.pA(-1));
                        return;
                    }
                    pA pAVarPA = pA.pA(jSONObjectPA, adSlot, tx);
                    if (pAVarPA.ZZv != 20000) {
                        if (!aBv.ZZv().IG() && pAVarPA.ZZv == 40029) {
                            pAVar.pA(-100, omh.pA(-100));
                            return;
                        } else {
                            pAVar.pA(pAVarPA.ZZv, pAVarPA.ML);
                            return;
                        }
                    }
                    if (pAVarPA.omh == null) {
                        pAVar.pA(-1, omh.pA(-1));
                        return;
                    }
                    pAVarPA.omh.KZx(jSONObjectPA.toString());
                    pAVar.pA(pAVarPA.omh, new com.bytedance.sdk.openadsdk.core.model.Og());
                    vZF.this.pA(pAVarPA.omh);
                    com.bytedance.sdk.openadsdk.core.ZZv.pA.pA().pA(pAVarPA.omh);
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "get ad error: ", th);
                    pAVar.pA(-1, omh.pA(-1));
                }
            }

            @Override // com.bytedance.sdk.component.SD.pA.Og
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException, com.bytedance.sdk.component.SD.Og og) {
                String message;
                qmB qmbOg = qmB.Og();
                if (z) {
                    map.put("pgad_end", Long.valueOf(qmbOg.pA));
                }
                if (aBv.ZZv().fN() && roi.pA().SD() == 1) {
                    gbA.pA("Pangle_Debug_Mode", iOException != null ? iOException.getMessage() : null, vZF.this.pA);
                }
                if (og != null) {
                    pAVar.pA(og.pA(), og.Og());
                    return;
                }
                if (iOException == null) {
                    message = "";
                } else {
                    message = iOException.getMessage();
                }
                pAVar.pA(601, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
        List<com.bytedance.sdk.openadsdk.core.model.yFO> listZZv = pAVar.ZZv();
        if (listZZv == null || listZZv.size() == 0) {
            return;
        }
        for (int i = 0; i < listZZv.size(); i++) {
            com.bytedance.sdk.openadsdk.core.model.yFO yfo = listZZv.get(i);
            if (yfo != null && yfo.WV() == null) {
                pA("", 0, 0, yfo.fJy(), yfo);
                pA("", 0, 0, yfo.YkC(), yfo);
                List<com.bytedance.sdk.openadsdk.core.model.DX> listIIF = yfo.IIF();
                if (listIIF != null && listIIF.size() > 0) {
                    for (int i2 = 0; i2 < listIIF.size(); i2++) {
                        pA(yfo, listIIF.get(i2));
                    }
                }
                if (yfo.Bf() != null) {
                    pA(yfo.Bf().SGo(), yfo.Bf().KZx(), yfo.Bf().Og(), (com.bytedance.sdk.openadsdk.core.model.DX) null, yfo);
                }
            }
        }
    }

    private void pA(String str, int i, int i2, com.bytedance.sdk.openadsdk.core.model.DX dx, com.bytedance.sdk.openadsdk.core.model.yFO yfo) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(str).pA(i).Og(i2).ML(Vgu.ZZv(aBv.pA())).ZZv(Vgu.KZx(aBv.pA())).KZx(2).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, str, null), 4);
        } else {
            if (dx == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(dx).KZx(2).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, dx.pA(), null), 4);
        }
    }

    private void pA(com.bytedance.sdk.openadsdk.core.model.yFO yfo, com.bytedance.sdk.openadsdk.core.model.DX dx) {
        if (dx == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Bzk.ZZv.pA(dx).KZx(2).pA(new com.bytedance.sdk.openadsdk.Bzk.Og(yfo, dx.pA(), new com.bytedance.sdk.component.ML.oX() { // from class: com.bytedance.sdk.openadsdk.core.vZF.14
            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ML.oX
            public void pA(com.bytedance.sdk.component.ML.BSW bsw) {
            }
        }), 4);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0027  */
    private void pA(com.bytedance.sdk.component.Og.pA.SGo sGo, com.bytedance.sdk.openadsdk.core.model.TX tx, qmB qmb, qmB qmb2, int i, qmB qmb3, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, boolean z) {
        if (aBv.ZZv().fJy()) {
            JSONObject jSONObject = new JSONObject();
            long jPA = 0;
            if (tx != null) {
                try {
                    if (tx.Bzk.pA > 0) {
                        jPA = qmb3.pA(tx.Bzk);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            pA(sGo, tx, qmb, qmb2, i, qmb3, yfo, str, z, jSONObject, false);
            com.bytedance.sdk.openadsdk.ZZv.KZx.pA(yfo, str, "load_ad_time", jPA, jSONObject);
        }
    }

    private static void pA(com.bytedance.sdk.component.Og.pA.SGo sGo, com.bytedance.sdk.openadsdk.core.model.TX tx, qmB qmb, qmB qmb2, int i, qmB qmb3, com.bytedance.sdk.openadsdk.core.model.yFO yfo, String str, boolean z, JSONObject jSONObject, boolean z2) throws JSONException {
        if (tx != null && tx.Bzk.pA > 0) {
            jSONObject.put("client_start_time", qmb.pA(tx.Bzk));
        }
        jSONObject.put("network_time", qmb2.pA(qmb));
        jSONObject.put("sever_time", i);
        jSONObject.put("client_end_time", qmb3.pA(qmb2));
        if (z) {
            jSONObject.put("is_choose_ad", true);
        }
        if (str.equals("open_ad")) {
            jSONObject.put("is_icon_only", yfo.zi() ? 1 : 0);
        }
        if (yfo != null) {
            jSONObject.put("render_control_type", yfo.BF());
        }
        jSONObject.put("webview_cache_size", com.bytedance.sdk.component.adexpress.ML.ML.pA().KZx());
        jSONObject.put("sync_barrier_open", z2 ? 1 : 0);
        if (sGo.Og > 0) {
            jSONObject.put("enqueue_2_run_ts", sGo.KZx - sGo.Og);
            jSONObject.put("run_2_connect_end_ts", sGo.ML - sGo.Og);
            jSONObject.put("connect_end_2_response_end_ts", sGo.JG - sGo.ML);
            jSONObject.put("response_end_2_callback_end_ts", SystemClock.elapsedRealtime() - sGo.JG);
        }
    }

    private boolean KZx(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    @DungeonFlag
    public com.bytedance.sdk.openadsdk.ZZv.ML pA(JSONObject jSONObject, String str, boolean z) {
        byte[] bArrEncryptV3;
        boolean z2;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strOg = null;
            if (!com.bytedance.sdk.openadsdk.core.settings.WV.pA()) {
                return null;
            }
            com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
            zZvOg.Og(str);
            if (com.bytedance.sdk.openadsdk.core.settings.oX.vkV().Itl()) {
                zZvOg.Og("_disable_retry", "1");
            }
            boolean z3 = true;
            if (z) {
                boolean zPA = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(PangleEncryptConstant.CryptDataScene.APP_LOG);
                byte[] bArrML = ML(jSONObject.toString());
                if (zPA) {
                    Pair<Integer, byte[]> pairEncryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(bArrML);
                    if (pairEncryptType4WithoutBase64 != null && pairEncryptType4WithoutBase64.second != null && ((byte[]) pairEncryptType4WithoutBase64.second).length > 0) {
                        bArrEncryptV3 = (byte[]) pairEncryptType4WithoutBase64.second;
                        BF.Og(true);
                    } else {
                        int iIntValue = pairEncryptType4WithoutBase64 != null ? ((Integer) pairEncryptType4WithoutBase64.first).intValue() : 0;
                        BF.Og(false);
                        BF.pA(1, PangleEncryptConstant.CryptDataScene.APP_LOG, iIntValue);
                        bArrEncryptV3 = null;
                    }
                } else {
                    bArrEncryptV3 = null;
                }
                if (bArrEncryptV3 != null) {
                    zZvOg.Og("Content-Encoding", "union_sdk_encode");
                    zZvOg.Og("x-pgli18n", Protocol.VAST_1_0_WRAPPER);
                    zZvOg.pA("application/octet-stream;tt-data=a", bArrEncryptV3);
                } else {
                    bArrEncryptV3 = PangleEncryptManager.encryptV3(bArrML);
                    if (bArrEncryptV3 == null) {
                        com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "V3 encrypt failed");
                    } else {
                        pA(Og(), zZvOg);
                        zZvOg.pA("application/octet-stream;tt-data=a", bArrEncryptV3);
                    }
                }
            } else {
                bArrEncryptV3 = null;
            }
            if (bArrEncryptV3 == null) {
                try {
                    JSONObject jSONObjectPA = com.bytedance.sdk.component.utils.pA.pA(jSONObject);
                    if (!KZx(jSONObjectPA)) {
                        jSONObjectPA = jSONObject;
                    }
                    pA(ZZv(jSONObjectPA), zZvOg);
                    zZvOg.pA(jSONObjectPA.toString(), aBv.ZZv().aBv());
                } catch (OutOfMemoryError e) {
                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e.toString());
                    return new com.bytedance.sdk.openadsdk.ZZv.ML(false, -2, "encrypt_error", false);
                }
            }
            com.bytedance.sdk.openadsdk.Sn.pA.ML ml = new com.bytedance.sdk.openadsdk.Sn.pA.ML(3);
            ml.pA(str).pA(zZvOg.ZZv()).pA();
            com.bytedance.sdk.component.SD.Og ogPA = zZvOg.pA();
            boolean zML = (ogPA == null || !ogPA.JG() || TextUtils.isEmpty(ogPA.ZZv())) ? false : ML(PangleNetworkBridge.jsonObjectInit(ogPA.ZZv()));
            String strOg2 = "error unknown";
            int iPA = ogPA != null ? ogPA.pA() : 0;
            if (!zML && iPA == 200) {
                strOg2 = "server say not success";
                z2 = true;
            } else {
                if (ogPA != null && ogPA.Og() != null) {
                    strOg2 = ogPA.Og();
                }
                z2 = false;
            }
            boolean z4 = ogPA == null;
            if (z4 || !ogPA.JG()) {
                z3 = false;
            }
            com.bytedance.sdk.openadsdk.Sn.pA.ML mlPA = ml.pA(z3).KZx(z4 ? null : ogPA.ZZv()).pA(z4 ? com.bytedance.sdk.openadsdk.Sn.pA.ML.pA : iPA);
            if (!z4) {
                strOg = ogPA.Og();
            }
            mlPA.ZZv(strOg);
            pA(jSONObject, z);
            com.bytedance.sdk.openadsdk.ZZv.pA.pA.pA(com.bytedance.sdk.openadsdk.ZZv.pA.pA.pA, zML, iPA, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.ZZv.ML(zML, iPA, strOg2, z2);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "uploadEvent error", th);
            return new com.bytedance.sdk.openadsdk.ZZv.ML(false, 509, "service_busy", false);
        }
    }

    private void pA(Map<String, String> map, com.bytedance.sdk.component.SD.Og.ZZv zZv) {
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                try {
                    zZv.Og(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "ADD header exceptopn", e.getMessage());
                }
            }
        }
        try {
            zZv.Og("User-Agent", gbA.KZx());
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "ADD header exceptopn", e2.getMessage());
        }
    }

    private void pA(JSONObject jSONObject, boolean z) throws Throwable {
        if (Bzk.Og().aBv()) {
            try {
                jSONObject.getJSONObject("header").put(yk.SESSION_HISTORY_KEY_AD_ID, "4562");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "reportETEvent error", e.getMessage());
            }
            com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
            zZvOg.Og(gbA.Wx());
            byte[] bArrEncryptV3 = null;
            if (z) {
                boolean zPA = com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(PangleEncryptConstant.CryptDataScene.APP_LOG);
                byte[] bArrML = ML(jSONObject.toString());
                if (zPA) {
                    Pair<Integer, byte[]> pairEncryptType4WithoutBase64 = PangleEncryptManager.encryptType4WithoutBase64(bArrML);
                    if (pairEncryptType4WithoutBase64 != null && pairEncryptType4WithoutBase64.second != null && ((byte[]) pairEncryptType4WithoutBase64.second).length > 0) {
                        byte[] bArr = (byte[]) pairEncryptType4WithoutBase64.second;
                        BF.Og(true);
                        bArrEncryptV3 = bArr;
                    } else {
                        int iIntValue = pairEncryptType4WithoutBase64 != null ? ((Integer) pairEncryptType4WithoutBase64.first).intValue() : 0;
                        BF.Og(false);
                        BF.pA(1, PangleEncryptConstant.CryptDataScene.APP_LOG, iIntValue);
                    }
                }
                if (bArrEncryptV3 != null) {
                    zZvOg.Og("Content-Encoding", "union_sdk_encode");
                    zZvOg.Og("x-pgli18n", Protocol.VAST_1_0_WRAPPER);
                    zZvOg.pA("application/octet-stream;tt-data=a", bArrEncryptV3);
                } else {
                    bArrEncryptV3 = PangleEncryptManager.encryptV3(bArrML);
                    if (bArrEncryptV3 == null) {
                        com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "V3 encrypt failed");
                    } else {
                        pA(Og(), zZvOg);
                        zZvOg.pA("application/octet-stream;tt-data=a", bArrEncryptV3);
                    }
                }
            }
            if (bArrEncryptV3 == null) {
                JSONObject jSONObjectPA = com.bytedance.sdk.component.utils.pA.pA(jSONObject);
                if (KZx(jSONObjectPA)) {
                    jSONObject = jSONObjectPA;
                }
                pA(ZZv(jSONObject), zZvOg);
                zZvOg.pA(jSONObject.toString(), aBv.ZZv().aBv());
            }
            zZvOg.pA(7);
            zZvOg.pA("et_applog");
            zZvOg.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.vZF.15
                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                    if (og == null || !og.JG()) {
                        return;
                    }
                    new Object[]{"onResponse: ", og.ZZv()};
                }

                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                    new Object[]{"onFailure: ", iOException.getMessage()};
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    public void pA(String str, List<FilterWord> list, String str2, String str3, String str4) {
        JSONObject jSONObjectOg;
        if (com.bytedance.sdk.openadsdk.core.settings.WV.pA() && (jSONObjectOg = Og(str, list, str2, str3, str4)) != null) {
            com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
            String strZZv = gbA.ZZv("/api/ad/union/dislike_event/");
            JSONObject jSONObjectPA = pA(PangleEncryptConstant.CryptDataScene.DISLIKE, jSONObjectOg);
            String string = jSONObjectPA != null ? jSONObjectPA.toString() : null;
            pA(zZvOg, jSONObjectPA);
            zZvOg.Og(strZZv);
            zZvOg.ZZv(string);
            final com.bytedance.sdk.openadsdk.Sn.pA.ML ml = new com.bytedance.sdk.openadsdk.Sn.pA.ML(6);
            ml.pA(strZZv).Og(string).pA();
            zZvOg.pA(7);
            zZvOg.pA("dislike");
            com.bytedance.sdk.openadsdk.oX.KZx.pA(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.2
                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                    pAVar.Og("dislike");
                    return pAVar;
                }
            });
            zZvOg.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.vZF.3
                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                    if (og != null) {
                        boolean zJG = og.JG();
                        ml.pA(zJG).pA(og.pA()).ZZv(og.Og()).KZx(og.ZZv());
                        if (zJG) {
                            com.bytedance.sdk.openadsdk.oX.KZx.Og(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.3.1
                                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                    pAVar.Og("dislike");
                                    return pAVar;
                                }
                            });
                            return;
                        } else {
                            com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.3.2
                                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                    pAVar.Og("dislike");
                                    return pAVar;
                                }
                            });
                            return;
                        }
                    }
                    ml.pA(false).pA(com.bytedance.sdk.openadsdk.Sn.pA.ML.pA);
                    com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.3.3
                        @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                        public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                            com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                            pAVar.Og("dislike");
                            return pAVar;
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.SD.pA.pA
                public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                    ml.pA(false).ZZv(iOException != null ? iOException.getMessage() : null);
                    com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.3.4
                        @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                        public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                            com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                            pAVar.Og("dislike");
                            return pAVar;
                        }
                    });
                }
            });
            try {
                String strOptString = PangleNetworkBridge.jsonObjectInit(str).optString("cid", "");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.JG.Og.pA().pA("dislike", strOptString, (String) null, (String) null);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.WV.Og(e.getMessage());
            }
        }
    }

    private static JSONObject pA(PangleEncryptConstant.CryptDataScene cryptDataScene, JSONObject jSONObject) {
        if (com.bytedance.sdk.openadsdk.core.settings.oX.vkV().pA(cryptDataScene)) {
            JSONObject jSONObjectEncryptType4 = PangleEncryptManager.encryptType4(jSONObject, new TX(cryptDataScene));
            BF.pA(jSONObjectEncryptType4);
            return jSONObjectEncryptType4;
        }
        return com.bytedance.sdk.component.utils.pA.pA(jSONObject);
    }

    @DungeonFlag
    private JSONObject Og(String str, List<FilterWord> list, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject2.put("extra", str);
            jSONObject2.put("filter_words", pA(list));
            jSONObject2.put("dislike_source", str4);
            if (com.bytedance.sdk.openadsdk.core.settings.oX.vkV().agB() && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                jSONObject2.put("creative_info", com.bytedance.sdk.component.utils.pA.pA(PangleNetworkBridge.jsonObjectInit(str2)).toString());
                jSONObject2.put("feedback_type", 1);
                jSONObject2.put("user_description", str3);
            }
            new Object[]{"dislike_source is：", str4};
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("actions", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONArray pA(List<FilterWord> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FilterWord> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getId());
        }
        return jSONArray;
    }

    private Map<String, String> ZZv(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json; charset=utf-8");
        if (KZx(jSONObject)) {
            map.put("Content-Encoding", "union_sdk_encode");
        }
        return map;
    }

    private Map<String, String> Og() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/octet-stream;tt-data=a");
        return map;
    }

    private boolean ML(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    private void pA(yFO.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og) {
        pAVar.pA(-1, omh.pA(-1));
        og.pA(-1);
        com.bytedance.sdk.openadsdk.core.model.Og.pA(og);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(yFO.Og og) {
        og.pA(-1, omh.pA(-1));
    }

    /* JADX WARN: Code duplicated, block: B:11:0x008c A[Catch: JSONException -> 0x00bc, TryCatch #0 {JSONException -> 0x00bc, blocks: (B:3:0x0005, B:9:0x0048, B:11:0x008c, B:23:0x00ae, B:8:0x0030, B:5:0x002a), top: B:26:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x009e  */
    /* JADX WARN: Code duplicated, block: B:15:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:17:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:19:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:20:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:21:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:22:0x00ad  */
    @DungeonFlag
    private JSONObject KZx() {
        int i;
        int rotation;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", Bzk.Og().ZZv());
            jSONObject.put("name", Bzk.Og().JG());
            JG(jSONObject);
            Context contextPA = aBv.pA();
            String packageResourcePath = "";
            if (contextPA != null) {
                try {
                    packageResourcePath = contextPA.getPackageResourcePath();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "failed to get the application installation package path. error: " + th.getMessage());
                }
                jSONObject.put("package_install_path", packageResourcePath);
                jSONObject.put("is_paid_app", Bzk.Og().BSW());
                jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.common.Og.SD());
                jSONObject.put("app_running_time", (System.currentTimeMillis() - Sn.pA()) / 1000);
                jSONObject.put("fmwname", DeviceUtils.Bzk(this.pA));
                i = 0;
                jSONObject.put("is_init", Sn.ML() ? 1 : 0);
                if (contextPA != null) {
                    rotation = ((WindowManager) contextPA.getSystemService("window")).getDefaultDisplay().getRotation();
                    if (rotation != 0) {
                        i = 1;
                    } else if (rotation != 1) {
                        i = 3;
                    } else if (rotation != 2) {
                        i = 2;
                    } else if (rotation != 3) {
                        i = 4;
                    }
                    jSONObject.put("orientation_support", new JSONArray().put(i));
                }
            } else {
                jSONObject.put("package_install_path", packageResourcePath);
                jSONObject.put("is_paid_app", Bzk.Og().BSW());
                jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.common.Og.SD());
                jSONObject.put("app_running_time", (System.currentTimeMillis() - Sn.pA()) / 1000);
                jSONObject.put("fmwname", DeviceUtils.Bzk(this.pA));
                i = 0;
                jSONObject.put("is_init", Sn.ML() ? 1 : 0);
                if (contextPA != null) {
                    rotation = ((WindowManager) contextPA.getSystemService("window")).getDefaultDisplay().getRotation();
                    if (rotation != 0) {
                        i = 1;
                    } else if (rotation != 1) {
                        i = 3;
                    } else if (rotation != 2) {
                        i = 2;
                    } else if (rotation != 3) {
                        i = 4;
                    }
                    jSONObject.put("orientation_support", new JSONArray().put(i));
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject pA(AdSlot adSlot) {
        WQf wQf;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("personalized_ad", aBv.ZZv().Bf());
            jSONObject.put("lmt", DeviceUtils.KZx());
            jSONObject.put("coppa", Bzk.Og().SGo());
            jSONObject.put("gdpr", Bzk.Og().Bzk());
            jSONObject.put("is_gdpr_user", aBv.ZZv().SzT());
            jSONObject.put(RemoteConfigFeature.UserConsent.CCPA, Bzk.Og().vZF());
            if (adSlot != null && WQf.pA.containsKey(Integer.valueOf(adSlot.getCodeId())) && (wQf = WQf.pA.get(Integer.valueOf(adSlot.getCodeId()))) != null) {
                jSONObject.put("lastadomain", wQf.Og());
                jSONObject.put("lastbundle", wQf.KZx());
                jSONObject.put("lastclick", wQf.ZZv());
                jSONObject.put("lastskip", wQf.ML());
            }
            pA(jSONObject, "keywords", Bzk.Og().WV());
            pA(jSONObject, "data", Og(adSlot));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static String Og(AdSlot adSlot) {
        String strWx = Bzk.Og().Wx();
        if (adSlot == null) {
            return TextUtils.isEmpty(strWx) ? "" : strWx;
        }
        String userData = adSlot.getUserData();
        if (TextUtils.isEmpty(strWx)) {
            return userData;
        }
        if (TextUtils.isEmpty(userData)) {
            return strWx;
        }
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(userData);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    hashSet.add(jSONObject.optString("name", null));
                }
            }
            try {
                JSONArray jSONArray2 = new JSONArray(strWx);
                int length2 = jSONArray2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null && !hashSet.contains(jSONObject2.optString("name", null))) {
                        jSONArray.put(jSONObject2);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable unused) {
                return userData;
            }
        } catch (Throwable unused2) {
            return strWx;
        }
    }

    private static void pA(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    @DungeonFlag
    private void JG(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", gbA.ML());
            jSONObject.put("version_code", gbA.JG());
            jSONObject.put("version", gbA.SD());
        } catch (Exception unused) {
        }
    }

    private JSONObject pA(AdSlot adSlot, int i, com.bytedance.sdk.openadsdk.core.model.TX tx) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", adSlot.getCodeId());
            jSONObject.put("adtype", i);
            if (!TextUtils.isEmpty(adSlot.getAdId()) || !TextUtils.isEmpty(adSlot.getCreativeId()) || !TextUtils.isEmpty(adSlot.getExt())) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(adSlot.getAdId())) {
                    jSONObject2.put(CreativeInfo.c, adSlot.getAdId());
                }
                if (!TextUtils.isEmpty(adSlot.getCreativeId())) {
                    jSONObject2.put("creative_id", adSlot.getCreativeId());
                }
                if (adSlot.getExt() != null) {
                    jSONObject2.put("ext", adSlot.getExt());
                }
                jSONObject.put("preview_ads", jSONObject2);
            }
            if (tx != null) {
                jSONObject.put("render_method", tx.omh);
                if (tx.omh == 1) {
                    pA(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
                } else if (tx.omh == 2) {
                    pA(jSONObject, "accepted_size", adSlot.getExpressViewAcceptedWidth(), adSlot.getExpressViewAcceptedHeight());
                }
            } else {
                jSONObject.put("render_method", 1);
                pA(jSONObject, "accepted_size", adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            }
            jSONObject.put("ptpl_ids", Og(adSlot.getCodeId()));
            jSONObject.put("ugen_ptpl_ids", KZx(adSlot.getCodeId()));
            jSONObject.put("ptpl_ids_v3", KZx(adSlot.getCodeId() + "_v3"));
            jSONObject.put(POBConstants.KEY_POSITION, AdSlot.getPosition(i));
            jSONObject.put("is_support_dpl", adSlot.isSupportDeepLink());
            if (adSlot.getNativeAdType() > 0 || i == 5) {
                jSONObject.put("is_origin_ad", true);
            }
            if (tx != null && tx.SD != null) {
                jSONObject.put("session_params", tx.SD);
            }
            int adCount = adSlot.getAdCount();
            if (adCount <= 0) {
                adCount = 1;
            }
            if (adCount > 3) {
                adCount = 3;
            }
            if (i == 7 || i == 8) {
                adCount = 1;
            }
            if (tx != null && tx.ML != null) {
                adCount = adSlot.getAdCount();
            }
            jSONObject.put("ad_count", adCount);
            if (i == 1) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("is_rotate_banner", adSlot.getIsRotateBanner());
                jSONObject3.put("rotate_time", adSlot.getRotateTime());
                jSONObject3.put("rotate_order", adSlot.getRotateOrder());
                jSONObject.put("banner", jSONObject3);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void pA(JSONObject jSONObject, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", i);
            jSONObject2.put("height", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    private void pA(JSONObject jSONObject, String str, float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject2.put("width", (int) f);
            jSONObject2.put("height", (int) f2);
            jSONArray.put(jSONObject2);
            jSONObject.put(str, jSONArray);
        } catch (Exception unused) {
        }
    }

    public static class pA {
        final String Bzk;
        final int JG;
        final long KZx;
        final String ML;
        final long Og;
        final String SD;
        final ArrayList<Integer> SGo;
        final int ZZv;
        public final com.bytedance.sdk.openadsdk.core.model.pA omh;
        final int pA;

        private pA(String str, int i, int i2, String str2, int i3, String str3, com.bytedance.sdk.openadsdk.core.model.pA pAVar, long j, long j2, ArrayList<Integer> arrayList) {
            this.pA = i;
            this.ZZv = i2;
            this.ML = str2;
            this.SD = str3;
            this.omh = pAVar;
            this.Bzk = str;
            this.JG = i3;
            this.Og = j;
            this.KZx = j2;
            this.SGo = arrayList;
        }

        public static pA pA(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.TX tx, com.bytedance.sdk.openadsdk.core.model.Og og) {
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_DESC);
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt("reason");
            Pair<com.bytedance.sdk.openadsdk.core.model.pA, ArrayList<Integer>> pairPA = com.bytedance.sdk.openadsdk.core.Og.pA(jSONObject, adSlot, tx, og);
            if (pairPA != null && pairPA.first != null) {
                ((com.bytedance.sdk.openadsdk.core.model.pA) pairPA.first).pA(jSONObject.optLong("request_after"));
            }
            if (pairPA == null) {
                return new pA(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
            }
            return new pA(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, (com.bytedance.sdk.openadsdk.core.model.pA) pairPA.first, jOptLong, jOptLong2, (ArrayList) pairPA.second);
        }

        public static pA pA(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.TX tx) {
            String strOptString = jSONObject.optString("did");
            int iOptInt = jSONObject.optInt("processing_time_ms");
            long jOptLong = jSONObject.optLong("s_receive_ts");
            long jOptLong2 = jSONObject.optLong("s_send_ts");
            int iOptInt2 = jSONObject.optInt("status_code");
            String strOptString2 = jSONObject.optString(CampaignEx.JSON_KEY_DESC);
            String strOptString3 = jSONObject.optString("request_id");
            int iOptInt3 = jSONObject.optInt("reason");
            if (adSlot != null && adSlot.getBiddingTokens() != null) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adn_bid_result");
                com.bytedance.sdk.openadsdk.core.model.pA pAVar = new com.bytedance.sdk.openadsdk.core.model.pA();
                if (jSONArrayOptJSONArray != null) {
                    int i = 0;
                    while (i < jSONArrayOptJSONArray.length()) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null) {
                            String strOptString4 = jSONObjectOptJSONObject.optString("name");
                            String strOptString5 = jSONObjectOptJSONObject.optString("render_data");
                            String strOptString6 = jSONObjectOptJSONObject.optString("price");
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("win_notice");
                            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("loss_notice");
                            String strOptString7 = jSONObjectOptJSONObject.optString("cid");
                            String strOptString8 = jSONObjectOptJSONObject.optString("crid");
                            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("adomain");
                            String strOptString9 = jSONObjectOptJSONObject.optString("adn_response_id");
                            com.bytedance.sdk.openadsdk.core.model.omh omhVar = new com.bytedance.sdk.openadsdk.core.model.omh();
                            omhVar.pA(strOptString4);
                            omhVar.Og(strOptString5);
                            omhVar.KZx(strOptString6);
                            omhVar.ZZv(strOptString7);
                            omhVar.ML(strOptString8);
                            omhVar.JG(strOptString9);
                            if (jSONArrayOptJSONArray4 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i2 = 0; i2 < jSONArrayOptJSONArray4.length(); i2++) {
                                    arrayList.add(jSONArrayOptJSONArray4.optString(i2));
                                }
                                omhVar.KZx(arrayList);
                            }
                            if (jSONArrayOptJSONArray2 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                    arrayList2.add(jSONArrayOptJSONArray2.optString(i3));
                                }
                                omhVar.pA(arrayList2);
                            }
                            if (jSONArrayOptJSONArray3 != null) {
                                ArrayList arrayList3 = new ArrayList();
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                                    arrayList3.add(jSONArrayOptJSONArray3.optString(i4));
                                }
                                omhVar.Og(arrayList3);
                            }
                            pAVar.pA(omhVar);
                        }
                        i++;
                        jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                        strOptString3 = strOptString3;
                        jOptLong2 = jOptLong2;
                        jOptLong = jOptLong;
                        iOptInt3 = iOptInt3;
                    }
                }
                return new pA(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, pAVar, jOptLong, jOptLong2, null);
            }
            return new pA(strOptString, iOptInt, iOptInt2, strOptString2, iOptInt3, strOptString3, null, jOptLong, jOptLong2, null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    public void pA(JSONObject jSONObject, final yFO.Og og) {
        if (!com.bytedance.sdk.openadsdk.core.settings.WV.pA()) {
            if (og != null) {
                og.pA(1000, "Ad request is temporarily paused, Please contact your Pangle AM");
                return;
            }
            return;
        }
        if (jSONObject == null || og == null) {
            return;
        }
        JSONObject jSONObjectPA = pA(PangleEncryptConstant.CryptDataScene.REWARD_VERIFY, jSONObject);
        final com.bytedance.sdk.openadsdk.Sn.pA.ML ml = new com.bytedance.sdk.openadsdk.Sn.pA.ML(5);
        com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
        try {
            String strPA = com.bytedance.sdk.openadsdk.omh.ZZv.pA(zZvOg, gbA.ZZv("/api/ad/union/sdk/reward_video/reward/"));
            zZvOg.Og(strPA);
            ml.pA(strPA);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e.getMessage());
        }
        pA(zZvOg, jSONObjectPA);
        zZvOg.ZZv(jSONObjectPA != null ? jSONObjectPA.toString() : "");
        ml.pA(zZvOg.ZZv()).pA();
        zZvOg.pA(10);
        zZvOg.pA("reward");
        com.bytedance.sdk.openadsdk.oX.KZx.pA(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.4
            @Override // com.bytedance.sdk.openadsdk.oX.ZZv
            public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                pAVar.Og("reward");
                return pAVar;
            }
        });
        zZvOg.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.vZF.5
            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og2) throws JSONException {
                if (og2 != null) {
                    if (og2.JG() && !TextUtils.isEmpty(og2.ZZv())) {
                        ml.pA(true).pA(og2.pA()).KZx(og2.ZZv());
                        try {
                            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(og2.ZZv());
                            String strOg = vZF.Og(jSONObjectJsonObjectInit.optInt("cypher", -1), jSONObjectJsonObjectInit.optString("message"));
                            if (!TextUtils.isEmpty(strOg)) {
                                try {
                                    jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strOg);
                                } catch (Throwable unused) {
                                }
                            }
                            Og ogPA = Og.pA(jSONObjectJsonObjectInit);
                            if (ogPA.pA != 20000) {
                                og.pA(ogPA.pA, omh.pA(ogPA.pA));
                            } else if (ogPA.KZx == null) {
                                vZF.this.pA(og);
                            } else {
                                og.pA(ogPA);
                                com.bytedance.sdk.openadsdk.oX.KZx.Og(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.5.1
                                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                        pAVar.Og("reward");
                                        return pAVar;
                                    }
                                });
                            }
                        } catch (JSONException e2) {
                            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e2.getMessage());
                            vZF.this.pA(og);
                        }
                    } else {
                        ml.pA(og2.JG()).KZx(og2.ZZv()).pA(og2.pA()).ZZv(og2.Og());
                        String strPA2 = omh.pA(-2);
                        int iPA = og2.pA();
                        if (!og2.JG() && !TextUtils.isEmpty(og2.Og())) {
                            strPA2 = og2.Og();
                        }
                        og.pA(iPA, strPA2);
                        com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.5.2
                            @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                            public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                                com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                                pAVar.Og("reward");
                                return pAVar;
                            }
                        });
                    }
                } else {
                    com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.5.3
                        @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                        public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                            com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                            pAVar.Og("reward");
                            return pAVar;
                        }
                    });
                    ml.pA(false).pA(com.bytedance.sdk.openadsdk.Sn.pA.ML.pA);
                    vZF.this.pA(og);
                }
            }

            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
                String message;
                if (iOException == null) {
                    message = "";
                } else {
                    message = iOException.getMessage();
                }
                ml.pA(false).ZZv(message);
                og.pA(-2, message);
                com.bytedance.sdk.openadsdk.oX.KZx.KZx(new com.bytedance.sdk.openadsdk.oX.ZZv() { // from class: com.bytedance.sdk.openadsdk.core.vZF.5.4
                    @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                    public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                        com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                        pAVar.Og("reward");
                        return pAVar;
                    }
                });
            }
        });
    }

    public static class Og {
        public final com.bytedance.sdk.openadsdk.core.model.roi KZx;
        public final boolean Og;
        public final int pA;

        private Og(int i, boolean z, com.bytedance.sdk.openadsdk.core.model.roi roiVar) {
            this.pA = i;
            this.Og = z;
            this.KZx = roiVar;
        }

        public static Og pA(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            int iOptInt = jSONObject.optInt("code");
            boolean zOptBoolean = jSONObject.optBoolean("verify");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            com.bytedance.sdk.openadsdk.core.model.roi roiVar = new com.bytedance.sdk.openadsdk.core.model.roi();
            if (jSONObjectOptJSONObject != null) {
                try {
                    roiVar.pA(jSONObjectOptJSONObject.optInt("reason"));
                    roiVar.Og(jSONObjectOptJSONObject.optInt("corp_type"));
                    roiVar.KZx(jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_REWARD_AMOUNT));
                    roiVar.pA(jSONObjectOptJSONObject.optString(CampaignEx.JSON_KEY_REWARD_NAME));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", th.getMessage());
                }
            }
            return new Og(iOptInt, zOptBoolean, roiVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    public JSONObject pA(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return jSONObject;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            String strOptString2 = jSONObject.optString("auction_price", "");
            String strOg = Og(iOptInt, strOptString);
            if (TextUtils.isEmpty(strOg)) {
                return jSONObject;
            }
            JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(strOg);
            try {
                jSONObjectJsonObjectInit.put("auction_price", strOptString2);
            } catch (Throwable unused) {
            }
            return jSONObjectJsonObjectInit;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Og(int i, String str) {
        if (i == 3) {
            return com.bytedance.sdk.component.utils.pA.KZx(str);
        }
        if (i == 4) {
            Pair<Integer, String> pairDecryptType4 = PangleEncryptManager.decryptType4(str);
            if (pairDecryptType4 != null && pairDecryptType4.second != null) {
                String str2 = (String) pairDecryptType4.second;
                BF.pA(true);
                return str2;
            }
            BF.pA(false);
            BF.pA(2, PangleEncryptConstant.CryptDataScene.GET_ADS, pairDecryptType4 != null ? ((Integer) pairDecryptType4.first).intValue() : 0);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    public com.bytedance.sdk.openadsdk.ZZv.ML Og(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        int iPA;
        String strOg = "error unknown";
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!com.bytedance.sdk.openadsdk.core.settings.WV.pA() || !aBv.ZZv().qQU() || jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        com.bytedance.sdk.openadsdk.Sn.pA.ML ml = new com.bytedance.sdk.openadsdk.Sn.pA.ML(4);
        com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
        boolean z3 = false;
        try {
            JSONObject jSONObjectPA = pA(PangleEncryptConstant.CryptDataScene.STATS_LOG, jSONObject);
            zZvOg.pA(jSONObjectPA.toString(), aBv.ZZv().aBv());
            String strZZv = gbA.ZZv("/api/ad/union/sdk/stats/batch/");
            ml.pA(strZZv).pA(zZvOg.ZZv()).pA();
            zZvOg.Og(strZZv);
            pA(zZvOg, jSONObjectPA);
            zZvOg.Og("User-Agent", gbA.KZx());
            if (com.bytedance.sdk.openadsdk.core.settings.oX.vkV().tM()) {
                zZvOg.Og("_disable_retry", "1");
            }
            com.bytedance.sdk.component.SD.Og ogPA = zZvOg.pA();
            try {
                if (ogPA == null) {
                    return new com.bytedance.sdk.openadsdk.ZZv.ML(false, 0, "error unknown", false);
                }
                if (!ogPA.JG() || TextUtils.isEmpty(ogPA.ZZv())) {
                    z = false;
                    z2 = false;
                } else {
                    JSONObject jSONObjectJsonObjectInit = PangleNetworkBridge.jsonObjectInit(ogPA.ZZv());
                    int iOptInt = jSONObjectJsonObjectInit.optInt("code", -1);
                    strOg = jSONObjectJsonObjectInit.optString("data", "");
                    z = iOptInt == 20000;
                    z2 = iOptInt == 60005;
                }
                try {
                    iPA = ogPA.pA();
                    try {
                        if (!ogPA.JG()) {
                            strOg = ogPA.Og();
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    iPA = 0;
                }
                boolean z4 = ogPA == null;
                if (!z4 && ogPA.JG()) {
                    z3 = true;
                }
                ml.pA(z3).KZx(z4 ? null : ogPA.ZZv()).pA(z4 ? com.bytedance.sdk.openadsdk.Sn.pA.ML.pA : iPA).ZZv(z4 ? null : ogPA.Og());
                com.bytedance.sdk.openadsdk.ZZv.pA.pA.pA(com.bytedance.sdk.openadsdk.ZZv.pA.pA.Og, z, iPA, System.currentTimeMillis() - jCurrentTimeMillis);
                return new com.bytedance.sdk.openadsdk.ZZv.ML(z, iPA, strOg, z2);
            } catch (Throwable unused3) {
                z = false;
                z2 = false;
                iPA = 0;
            }
        } catch (Throwable unused4) {
            com.bytedance.sdk.openadsdk.ZZv.pA.pA.pA(com.bytedance.sdk.openadsdk.ZZv.pA.pA.Og, false, 0, System.currentTimeMillis() - jCurrentTimeMillis);
            return new com.bytedance.sdk.openadsdk.ZZv.ML(false, 0, "error unknown", false);
        }
    }

    private void pA(com.bytedance.sdk.component.SD.Og.ZZv zZv, JSONObject jSONObject) {
        try {
            if (KZx(jSONObject) && jSONObject.optInt("cypher") == 4) {
                zZv.Og("x-pgli18n", Protocol.VAST_1_0_WRAPPER);
                zZv.Og("Content-Type", "application/json; charset=utf-8");
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    public com.bytedance.sdk.component.adexpress.pA.KZx.pA pA() {
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarZZv = null;
        if (!com.bytedance.sdk.openadsdk.core.settings.WV.pA()) {
            return null;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tpl_fetch_model", "date", 0L);
        String strVgu = aBv.ZZv().Vgu();
        String strOg = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("tpl_fetch_model", "last_url", "");
        if (jCurrentTimeMillis <= aBv.ZZv().roi() && jCurrentTimeMillis >= 0 && TextUtils.equals(strVgu, strOg)) {
            String strOg2 = com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.Og("tpl_fetch_model", "model", "");
            try {
                if (!TextUtils.isEmpty(strOg2)) {
                    return com.bytedance.sdk.component.adexpress.pA.KZx.pA.ZZv(strOg2);
                }
            } catch (Exception unused) {
            }
        }
        com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
        try {
            ogKZx.Og(com.bytedance.sdk.openadsdk.omh.ZZv.pA(ogKZx, strVgu));
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e.getMessage());
        }
        com.bytedance.sdk.component.SD.Og ogPA = ogKZx.pA();
        if (ogPA == null) {
            return null;
        }
        try {
            if (!ogPA.JG()) {
                return null;
            }
            String strZZv = ogPA.ZZv();
            pAVarZZv = com.bytedance.sdk.component.adexpress.pA.KZx.pA.ZZv(strZZv);
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tpl_fetch_model", "date", Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tpl_fetch_model", "model", strZZv);
            com.bytedance.sdk.openadsdk.multipro.ZZv.ZZv.pA("tpl_fetch_model", "last_url", strVgu);
            return pAVarZZv;
        } catch (Exception unused2) {
            return pAVarZZv;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    public void pA(String str) {
        com.bytedance.sdk.component.SD.Og.Og ogKZx = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().KZx();
        ogKZx.Og(str);
        ogKZx.pA("upload_bidding");
        ogKZx.pA(7);
        ogKZx.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.vZF.6
            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                og.ZZv();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO
    public void pA(JSONObject jSONObject, String str) {
        com.bytedance.sdk.component.SD.Og.ZZv zZvOg = com.bytedance.sdk.openadsdk.aBv.KZx.pA().Og().Og();
        zZvOg.Og(str);
        zZvOg.pA(jSONObject);
        zZvOg.pA(5);
        zZvOg.pA("apm_pv");
        zZvOg.pA(new com.bytedance.sdk.component.SD.pA.pA() { // from class: com.bytedance.sdk.openadsdk.core.vZF.7
            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, IOException iOException) {
            }

            @Override // com.bytedance.sdk.component.SD.pA.pA
            public void pA(com.bytedance.sdk.component.SD.Og.KZx kZx, com.bytedance.sdk.component.SD.Og og) {
                og.ZZv();
            }
        });
    }

    public static JSONArray Og(String str) {
        try {
            Set<String> setOg = com.bytedance.sdk.component.adexpress.pA.Og.Og.Og(str);
            if (setOg != null && setOg.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = setOg.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.adexpress.pA.KZx.Og ogPA = com.bytedance.sdk.component.adexpress.pA.Og.Og.pA(it.next());
                    if (ogPA != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", ogPA.Og());
                        jSONObject.put("md5", ogPA.KZx());
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "getParentTplIds: ", e);
            return null;
        }
    }

    public static JSONArray KZx(String str) {
        try {
            Set<com.bytedance.sdk.openadsdk.core.BSW.pA.pA> setPA = com.bytedance.sdk.openadsdk.core.BSW.pA.Og.pA().pA(str);
            if (setPA != null && setPA.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.BSW.pA.pA pAVar : setPA) {
                    if (pAVar != null && !TextUtils.isEmpty(pAVar.ML())) {
                        JSONObject jSONObject = new JSONObject();
                        String[] strArrSplit = pAVar.pA().split("_");
                        if (strArrSplit.length == 2) {
                            jSONObject.put("id", strArrSplit[1]);
                            jSONObject.put("md5", pAVar.Og());
                            jSONArray.put(jSONObject);
                        } else {
                            continue;
                        }
                    }
                }
                return jSONArray;
            }
            return null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", "getUgenParentTplIds: ", e);
            return null;
        }
    }

    private byte[] ML(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] byteArray = new byte[0];
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    try {
                        GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream2.write(str.getBytes(cc.N));
                            try {
                                gZIPOutputStream2.close();
                            } catch (IOException e) {
                                com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e.toString());
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            gZIPOutputStream = gZIPOutputStream2;
                            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e.toString());
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e3) {
                                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e3.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                            }
                            return byteArray;
                        } catch (Throwable th) {
                            th = th;
                            gZIPOutputStream = gZIPOutputStream2;
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e4) {
                                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e4.toString());
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.toByteArray();
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException e5) {
                                    com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e5.toString());
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e = e7;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (IOException e8) {
            com.bytedance.sdk.component.utils.WV.pA("NetApiImpl", e8.toString());
        }
        return byteArray;
    }
}
