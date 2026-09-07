package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.playon.bridge.Ad;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.unified.UnifiedMediationParams;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020 ¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u0005\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0005\u0010\u0011J+\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00130\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010&R\u0016\u0010(\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010#R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010#¨\u0006/"}, d2 = {"Lcom/chartboost/sdk/impl/e0;", "", "Lorg/json/JSONObject;", "response", "Lcom/chartboost/sdk/impl/v;", "a", "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/v;", "Lorg/json/JSONArray;", "elements", "", "", "Lcom/chartboost/sdk/impl/c1;", POBNativeConstants.NATIVE_ASSETS, "parameters", "", "(Lorg/json/JSONArray;Ljava/util/Map;Ljava/util/Map;)V", "value", "(Ljava/lang/String;)V", "eventsJson", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Lorg/json/JSONObject;)Ljava/util/Map;", "infoIconJsonObject", "Lcom/chartboost/sdk/impl/s6;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/s6;", "scriptsJsonArray", "(Lorg/json/JSONArray;)Ljava/util/List;", "sizeJsonObject", "Lcom/chartboost/sdk/impl/s6$a;", "d", "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/s6$a;", "Lcom/chartboost/sdk/impl/n1;", "Lcom/chartboost/sdk/impl/n1;", "base64Wrapper", "Ljava/lang/String;", UnifiedMediationParams.KEY_VIDEO_URL, "", "I", IronSourceConstants.EVENTS_REWARD_AMOUNT, "rewardCurrency", "e", "impressionId", InneractiveMediationDefs.GENDER_FEMALE, "decodedAdm", "<init>", "(Lcom/chartboost/sdk/impl/n1;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final n1 base64Wrapper;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public String videoUrl;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public int rewardAmount;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public String rewardCurrency;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public String impressionId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public String decodedAdm;

    public e0(n1 base64Wrapper) {
        Intrinsics.checkNotNullParameter(base64Wrapper, "base64Wrapper");
        this.base64Wrapper = base64Wrapper;
        this.videoUrl = "";
        this.rewardCurrency = "";
        this.impressionId = "";
        this.decodedAdm = "";
    }

    public final v a(JSONObject response) throws JSONException {
        if (response != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            JSONObject jSONObject = response.getJSONObject(com.ironsource.b9.h.K);
            JSONArray jSONArray = jSONObject.getJSONArray("elements");
            Intrinsics.checkNotNullExpressionValue(jSONArray, "it.getJSONArray(ELEMENTS_JSON_FIELD)");
            a(jSONArray, linkedHashMap, linkedHashMap2);
            String string = jSONObject.getString("template");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(TEMPLATE_ELEMENT)");
            String strOptString = response.optString("name");
            String string2 = response.getString(CreativeInfo.c);
            String str = this.impressionId;
            String strOptString2 = response.optString("baseurl");
            s6 s6VarC = c(response.optJSONObject("infoicon"));
            String string3 = response.getString("cgn");
            String string4 = response.getString(Reporting.Key.CREATIVE);
            String strOptString3 = response.optString("media-type");
            String str2 = this.videoUrl;
            String strA = f0.a(str2);
            String string5 = response.getString("link");
            String strOptString4 = response.optString("deep-link");
            String string6 = response.getString("to");
            int i = this.rewardAmount;
            String str3 = this.rewardCurrency;
            c1 c1Var = linkedHashMap.get("body");
            if (c1Var != null) {
                b9 b9VarA = b9.INSTANCE.a(response.optString("renderingengine"));
                List<String> listA = a(response.optJSONArray("scripts"));
                Map<String, List<String>> mapB = b(response.optJSONObject("events"));
                d7 d7VarA = f0.a(response.optInt("mtype"));
                b3 b3VarA = b3.INSTANCE.a(response.optInt("clkp"));
                String str4 = this.decodedAdm;
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(NAME_JSON_FIELD)");
                Intrinsics.checkNotNullExpressionValue(string2, "getString(ADID_JSON_FIELD)");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(BASE_URL_JSON_FIELD)");
                Intrinsics.checkNotNullExpressionValue(string3, "getString(CGN_JSON_FIELD)");
                Intrinsics.checkNotNullExpressionValue(string4, "getString(CREATIVE_JSON_FIELD)");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(MEDIA_TYPE_JSON_FIELD)");
                Intrinsics.checkNotNullExpressionValue(string5, "getString(LINK_JSON_FIELD)");
                Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(DEEP_LINK_JSON_FIELD)");
                Intrinsics.checkNotNullExpressionValue(string6, "getString(TO_JSON_FIELD)");
                return new v(strOptString, string2, strOptString2, str, s6VarC, string3, string4, strOptString3, linkedHashMap, str2, strA, string5, strOptString4, string6, i, str3, string, c1Var, linkedHashMap2, b9VarA, listA, mapB, null, null, d7VarA, b3VarA, str4, 12582912, null);
            }
            throw new IllegalStateException("WebView AdUnit does not have a template html body asset".toString());
        }
        throw new JSONException("Missing response");
    }

    public final Map<String, List<String>> b(JSONObject eventsJson) throws JSONException {
        Iterator<String> itKeys;
        HashMap map = new HashMap();
        if (eventsJson != null && (itKeys = eventsJson.keys()) != null) {
            while (itKeys.hasNext()) {
                String it = itKeys.next();
                JSONArray jSONArray = eventsJson.getJSONArray(it);
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string = jSONArray.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "urlArray.getString(i)");
                    arrayList.add(string);
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                map.put(it, arrayList);
            }
        }
        return map;
    }

    public final s6 c(JSONObject infoIconJsonObject) {
        if (infoIconJsonObject != null) {
            String strOptString = infoIconJsonObject.optString("imageurl");
            Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObject.optString(INF…CON_IMAGE_URL_JSON_FIELD)");
            String strOptString2 = infoIconJsonObject.optString("clickthroughUrl");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "jsonObject.optString(INF…CKTHROUGH_URL_JSON_FIELD)");
            return new s6(strOptString, strOptString2, s6.b.INSTANCE.a(infoIconJsonObject.optInt(com.ironsource.b9.h.L)), d(infoIconJsonObject.optJSONObject(VastAttributes.MARGIN)), d(infoIconJsonObject.optJSONObject(VastAttributes.PADDING)), d(infoIconJsonObject.optJSONObject(ContentDisposition.Parameters.Size)));
        }
        return new s6(null, null, null, null, null, null, 63, null);
    }

    public final s6.a d(JSONObject sizeJsonObject) {
        if (sizeJsonObject != null) {
            return new s6.a(sizeJsonObject.optDouble("w"), sizeJsonObject.optDouble("h"));
        }
        return new s6.a(0.0d, 0.0d, 3, null);
    }

    public final void a(JSONArray elements, Map<String, c1> assets, Map<String, String> parameters) throws JSONException {
        for (JSONObject jSONObject : b5.asList(elements)) {
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString("type");
            String value = jSONObject.getString("value");
            String param = jSONObject.optString(Ad.VERIFICATIONPARAM);
            if (string2 != null) {
                int iHashCode = string2.hashCode();
                if (iHashCode != -1333900842) {
                    if (iHashCode != 3213227) {
                        if (iHashCode == 106436749 && string2.equals(Ad.VERIFICATIONPARAM)) {
                            Intrinsics.checkNotNullExpressionValue(param, "param");
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            parameters.put(param, value);
                            if (string != null) {
                                int iHashCode2 = string.hashCode();
                                if (iHashCode2 != -1422292723) {
                                    if (iHashCode2 != -1389119727) {
                                        if (iHashCode2 != -878282975) {
                                            if (iHashCode2 == -315925656 && string.equals(CampaignEx.JSON_KEY_REWARD_AMOUNT)) {
                                                a(value);
                                            }
                                        } else if (string.equals("reward_currency")) {
                                            this.rewardCurrency = value;
                                        }
                                    } else if (string.equals("impression_id")) {
                                        this.impressionId = value;
                                    }
                                } else if (string.equals("adm.js")) {
                                    this.decodedAdm = this.base64Wrapper.b(value);
                                }
                            }
                        }
                    } else {
                        if (string2.equals("html")) {
                            Intrinsics.checkNotNullExpressionValue(param, "param");
                            if (param.length() == 0) {
                                param = "body";
                            }
                        }
                        Intrinsics.checkNotNullExpressionValue(param, "param");
                        assets.put(param, new c1(string2, string, value));
                    }
                } else if (string2.equals("preCachedVideo")) {
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    this.videoUrl = value;
                }
            }
            Intrinsics.checkNotNullExpressionValue(param, "param");
            if (param.length() == 0) {
                param = string;
            }
            Intrinsics.checkNotNullExpressionValue(param, "param");
            assets.put(param, new c1(string2, string, value));
        }
    }

    public final void a(String value) {
        int i;
        try {
            i = Integer.parseInt(value);
        } catch (NumberFormatException unused) {
            i = 0;
        }
        this.rewardAmount = i;
    }

    public final List<String> a(JSONArray scriptsJsonArray) {
        List<String> listAsList;
        return (scriptsJsonArray == null || (listAsList = b5.asList(scriptsJsonArray)) == null) ? CollectionsKt.emptyList() : listAsList;
    }
}
