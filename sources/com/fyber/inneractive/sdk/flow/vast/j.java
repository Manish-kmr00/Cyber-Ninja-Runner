package com.fyber.inneractive.sdk.flow.vast;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.model.vast.l;
import com.fyber.inneractive.sdk.network.C3146w;
import com.fyber.inneractive.sdk.network.C3147x;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import com.fyber.inneractive.sdk.network.EnumC3144u;
import com.fyber.inneractive.sdk.util.IAlog;
import com.json.fe;
import com.playon.bridge.Ad;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class j {
    /* JADX WARN: Code duplicated, block: B:7:0x0028 A[PHI: r0 r3
  0x0028: PHI (r0v8 com.fyber.inneractive.sdk.external.InneractiveErrorCode) = 
  (r0v3 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
  (r0v4 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
  (r0v5 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
  (r0v7 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
  (r0v7 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
  (r0v7 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
  (r0v7 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
  (r0v40 com.fyber.inneractive.sdk.external.InneractiveErrorCode)
 binds: [B:44:0x0106, B:41:0x00f8, B:38:0x00ea, B:12:0x003e, B:14:0x0044, B:16:0x004a, B:31:0x00ae, B:5:0x0018] A[DONT_GENERATE, DONT_INLINE]
  0x0028: PHI (r3v17 com.fyber.inneractive.sdk.network.t) = 
  (r3v12 com.fyber.inneractive.sdk.network.t)
  (r3v13 com.fyber.inneractive.sdk.network.t)
  (r3v14 com.fyber.inneractive.sdk.network.t)
  (r3v16 com.fyber.inneractive.sdk.network.t)
  (r3v16 com.fyber.inneractive.sdk.network.t)
  (r3v16 com.fyber.inneractive.sdk.network.t)
  (r3v16 com.fyber.inneractive.sdk.network.t)
  (r3v21 com.fyber.inneractive.sdk.network.t)
 binds: [B:44:0x0106, B:41:0x00f8, B:38:0x00ea, B:12:0x003e, B:14:0x0044, B:16:0x004a, B:31:0x00ae, B:5:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
    public static InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.response.g gVar, r rVar) {
        EnumC3143t enumC3143t;
        InneractiveErrorCode inneractiveErrorCode;
        C3147x c3147xA;
        InneractiveErrorCode inneractiveErrorCode2;
        EnumC3143t enumC3143t2;
        Set<com.fyber.inneractive.sdk.model.vast.r> setKeySet;
        String str;
        String str2 = gVar.i;
        if ("VastErrorInvalidFile".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            enumC3143t2 = EnumC3143t.VAST_ERROR_INVALID_RESPONSE;
            if (gVar.j != null) {
                c3147xA = new C3147x().a(gVar.j, "exception");
            } else {
                c3147xA = null;
            }
            EnumC3143t enumC3143t3 = enumC3143t2;
            inneractiveErrorCode = inneractiveErrorCode2;
            enumC3143t = enumC3143t3;
        } else if ("ErrorNoCompatibleMediaFile".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            enumC3143t2 = EnumC3143t.VAST_ERROR_NO_COMPATIBLE_MEDIA_FILE;
            LinkedHashMap linkedHashMap = gVar.O;
            if (linkedHashMap == null || (setKeySet = linkedHashMap.keySet()) == null || setKeySet.size() <= 0) {
                c3147xA = null;
            } else {
                C3147x c3147x = new C3147x();
                JSONArray jSONArray = new JSONArray();
                for (com.fyber.inneractive.sdk.model.vast.r rVar2 : setKeySet) {
                    try {
                        f fVar = (f) linkedHashMap.get(rVar2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", rVar2.g);
                        jSONObject.put("bitrate", rVar2.e);
                        jSONObject.put("mime", TextUtils.isEmpty(rVar2.d) ? "na" : rVar2.d);
                        jSONObject.put("delivery", rVar2.f1886a);
                        e eVar = fVar.f1838a;
                        jSONObject.put("reason", eVar != null ? eVar.value : 0);
                        jSONObject.put("required_value", fVar.b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                        IAlog.a("VastResponseValidator: Failed converting media file data to Extra data json!", new Object[0]);
                    }
                }
                c3147x.a(jSONArray, "media_files");
                c3147xA = c3147x;
            }
            EnumC3143t enumC3143t4 = enumC3143t2;
            inneractiveErrorCode = inneractiveErrorCode2;
            enumC3143t = enumC3143t4;
        } else if ("VastErrorTooManyWrappers".equals(str2)) {
            inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
            enumC3143t2 = EnumC3143t.VAST_ERROR_TOO_MANY_WRAPPERS;
            c3147xA = new C3147x().a(Integer.valueOf(IAConfigManager.O.i.b), "max");
            EnumC3143t enumC3143t5 = enumC3143t2;
            inneractiveErrorCode = inneractiveErrorCode2;
            enumC3143t = enumC3143t5;
        } else {
            if ("ErrorNoMediaFiles".equals(str2)) {
                inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                enumC3143t2 = EnumC3143t.VAST_ERROR_NO_MEDIA_FILES;
            } else if ("ErrorConfigurationMismatch".equals(str2)) {
                inneractiveErrorCode2 = InneractiveErrorCode.ERROR_CONFIGURATION_MISMATCH;
                enumC3143t2 = EnumC3143t.INTERNAL_CONFIG_MISMATCH;
            } else if ("VastErrorUnsecure".equals(str2)) {
                inneractiveErrorCode2 = InneractiveErrorCode.SERVER_INVALID_RESPONSE;
                enumC3143t2 = EnumC3143t.VAST_ERROR_UNSECURE_URL;
            } else {
                enumC3143t = null;
                inneractiveErrorCode = null;
                c3147xA = null;
            }
            c3147xA = null;
            EnumC3143t enumC3143t6 = enumC3143t2;
            inneractiveErrorCode = inneractiveErrorCode2;
            enumC3143t = enumC3143t6;
        }
        if (enumC3143t != null) {
            JSONArray jSONArrayB = rVar == null ? null : rVar.b();
            C3146w c3146w = new C3146w(gVar);
            c3146w.b = enumC3143t;
            c3146w.f1934a = inneractiveAdRequest;
            c3146w.d = jSONArrayB;
            if (c3147xA != null) {
                c3146w.f.put(c3147xA.f1935a);
            }
            c3146w.a((String) null);
        }
        ArrayList<com.fyber.inneractive.sdk.model.vast.h> arrayList = gVar.P;
        if (arrayList != null && arrayList.size() > 0) {
            EnumC3144u enumC3144u = EnumC3144u.VAST_EVENT_COMPANION_FILTERED;
            JSONArray jSONArrayB2 = rVar == null ? null : rVar.b();
            C3146w c3146w2 = new C3146w(gVar);
            c3146w2.c = enumC3144u;
            c3146w2.f1934a = inneractiveAdRequest;
            c3146w2.d = jSONArrayB2;
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (com.fyber.inneractive.sdk.model.vast.h hVar : arrayList) {
                hVar.getClass();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("w", hVar.f1879a);
                    jSONObject3.put("h", hVar.b);
                    jSONObject3.put(fe.E0, hVar.g);
                    jSONObject3.put("clt", hVar.h);
                    String str3 = hVar.f;
                    if (str3 != null) {
                        jSONObject3.put("content", str3);
                        str = "HTMLResource";
                    } else {
                        str = null;
                    }
                    l lVar = hVar.d;
                    if (lVar != null) {
                        jSONObject3.put("content", lVar.b);
                        jSONObject3.put("creativeType", hVar.d.f1881a);
                        str = "StaticResource";
                    }
                    if (!TextUtils.isEmpty(hVar.e)) {
                        jSONObject3.put("content", hVar.e);
                        str = "iFrameResource";
                    }
                    if (str != null) {
                        jSONObject3.put("type", str);
                    }
                    b bVar = hVar.i;
                    if (bVar != null) {
                        jSONObject3.put("reason", bVar.f1835a);
                    }
                } catch (JSONException e) {
                    IAlog.a("Failed creating Companion json object: %s", e.getMessage());
                    jSONObject3 = null;
                }
                jSONArray2.put(jSONObject3);
            }
            try {
                jSONObject2.put("companion_data", jSONArray2);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "companion_data", jSONArray2);
            }
            c3146w2.f.put(jSONObject2);
            c3146w2.a((String) null);
        }
        com.fyber.inneractive.sdk.model.vast.b bVar2 = gVar.N;
        int size = bVar2 != null ? bVar2.g.size() : 0;
        ArrayList arrayList2 = gVar.P;
        int size2 = arrayList2 != null ? arrayList2.size() : 0;
        EnumC3144u enumC3144u2 = EnumC3144u.NUMBER_OF_COMPANIONS;
        JSONArray jSONArrayB3 = rVar == null ? null : rVar.b();
        C3146w c3146w3 = new C3146w(gVar);
        c3146w3.c = enumC3144u2;
        c3146w3.f1934a = inneractiveAdRequest;
        c3146w3.d = jSONArrayB3;
        JSONObject jSONObject4 = new JSONObject();
        Integer numValueOf = Integer.valueOf(size + size2);
        try {
            jSONObject4.put("number_of_endcards", numValueOf);
        } catch (Exception unused3) {
            IAlog.f("Got exception adding param to json object: %s, %s", "number_of_endcards", numValueOf);
        }
        c3146w3.f.put(jSONObject4);
        c3146w3.a((String) null);
        if (gVar.N != null) {
            i<com.fyber.inneractive.sdk.measurement.i> iVar = new i(gVar);
            if (iVar.size() > 0) {
                JSONObject jSONObject5 = new JSONObject();
                JSONArray jSONArray3 = new JSONArray();
                EnumC3144u enumC3144u3 = EnumC3144u.OMID_VAST_DETECTION;
                JSONArray jSONArrayB4 = rVar == null ? null : rVar.b();
                C3146w c3146w4 = new C3146w(gVar);
                c3146w4.c = enumC3144u3;
                c3146w4.f1934a = inneractiveAdRequest;
                c3146w4.d = jSONArrayB4;
                for (com.fyber.inneractive.sdk.measurement.i iVar2 : iVar) {
                    iVar2.getClass();
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.put("success", String.valueOf(iVar2.b()));
                        if (!iVar2.b()) {
                            jSONObject6.put("error_reason", iVar2.a());
                        }
                    } catch (JSONException unused4) {
                        jSONObject6 = null;
                    }
                    if (jSONObject6 != null) {
                        jSONArray3.put(jSONObject6);
                    }
                }
                try {
                    jSONObject5.put(Ad.ADVERIFICATIONS, jSONArray3);
                } catch (Exception unused5) {
                    IAlog.f("Got exception adding param to json object: %s, %s", Ad.ADVERIFICATIONS, jSONArray3);
                }
                c3146w4.f.put(jSONObject5);
                c3146w4.a((String) null);
            }
        }
        return inneractiveErrorCode;
    }
}
