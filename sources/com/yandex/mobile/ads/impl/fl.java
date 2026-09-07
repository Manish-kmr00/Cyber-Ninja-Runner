package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qz0 f8906a;
    private final Json b;

    public final ba a(JSONObject adUnitIdBiddingSettingsJson) {
        String strA;
        Intrinsics.checkNotNullParameter(adUnitIdBiddingSettingsJson, "adUnitIdBiddingSettingsJson");
        try {
            try {
                rq0.f10131a.getClass();
                strA = rq0.a("ad_unit_id", adUnitIdBiddingSettingsJson);
            } catch (JSONException unused) {
                rq0.f10131a.getClass();
                strA = rq0.a("block_id", adUnitIdBiddingSettingsJson);
            }
            JSONArray jSONArrayOptJSONArray = adUnitIdBiddingSettingsJson.optJSONArray("networks");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                    qz0 qz0Var = this.f8906a;
                    Intrinsics.checkNotNull(jSONObject);
                    hz0 hz0VarA = qz0Var.a(jSONObject);
                    if (hz0VarA != null) {
                        arrayList.add(hz0VarA);
                    }
                }
                if (!arrayList.isEmpty()) {
                    String string = adUnitIdBiddingSettingsJson.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    return new ba(strA, string, arrayList);
                }
            }
        } catch (JSONException unused2) {
            op0.b(new Object[0]);
        }
        return null;
    }

    public final el b(JSONObject jsonBiddingSettings) {
        JSONObject jSONObject;
        d01 d01Var;
        String string;
        Intrinsics.checkNotNullParameter(jsonBiddingSettings, "jsonBiddingSettings");
        try {
            jSONObject = jsonBiddingSettings.getJSONObject("mediation_prefetch_settings");
        } catch (Exception unused) {
            jSONObject = null;
        }
        try {
            JSONArray jSONArrayOptJSONArray = jsonBiddingSettings.optJSONArray("ad_unit_id_settings");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = jsonBiddingSettings.optJSONArray("block_id_settings");
            }
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNull(jSONObject2);
                    ba baVarA = a(jSONObject2);
                    if (baVarA != null) {
                        arrayList.add(baVarA);
                    }
                }
            }
            if (jSONObject == null || (string = jSONObject.toString()) == null) {
                d01Var = null;
            } else {
                Json json = this.b;
                json.getSerializersModule();
                d01Var = (d01) json.decodeFromString(BuiltinSerializersKt.getNullable(d01.Companion.serializer()), string);
            }
            if (arrayList.isEmpty() && d01Var == null) {
                return null;
            }
            return new el(arrayList, d01Var);
        } catch (JSONException unused2) {
            op0.b(new Object[0]);
            return null;
        }
    }

    public /* synthetic */ fl() {
        qz0 qz0Var = new qz0();
        rq0.f10131a.getClass();
        this(qz0Var, rq0.a());
    }

    public fl(qz0 mediationNetworkParser, Json jsonParser) {
        Intrinsics.checkNotNullParameter(mediationNetworkParser, "mediationNetworkParser");
        Intrinsics.checkNotNullParameter(jsonParser, "jsonParser");
        this.f8906a = mediationNetworkParser;
        this.b = jsonParser;
    }
}
