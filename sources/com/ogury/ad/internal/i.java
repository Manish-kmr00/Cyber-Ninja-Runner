package com.ogury.ad.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.ogury.ad.common.OguryMediation;
import com.ogury.core.internal.IntegrationLogger;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f7316a = new i();

    public static void a(String message) throws d9 {
        Intrinsics.checkNotNullParameter(message, "message");
        IntegrationLogger.e(message);
        throw new d9(new y5(message, 3), b9.PARSING_ERROR);
    }

    public static l a(String adStringResponse, o adType, String str, n6 n6Var, String sessionId, boolean z, boolean z2, OguryMediation oguryMediation) throws JSONException, d9 {
        String strOptString;
        String strOptString2;
        String strOptString3;
        String string;
        boolean z3;
        String strOptString4;
        JSONObject jSONObjectOptJSONObject;
        String strOptString5;
        String strOptString6;
        String strOptString7;
        boolean z4;
        o2 o2Var;
        r3 r3Var;
        a1 a1Var;
        int iOptInt;
        int i;
        String adUnitId = str;
        Intrinsics.checkNotNullParameter(adStringResponse, "adStringResponse");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (!StringsKt.isBlank(adStringResponse)) {
            a0.a(adStringResponse);
            JSONArray jSONArrayOptJSONArray = new JSONObject(adStringResponse).optJSONArray(Reporting.Key.CLICK_SOURCE_TYPE_AD);
            if (jSONArrayOptJSONArray != null) {
                if (jSONArrayOptJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArrayOptJSONArray.length();
                    int i2 = 0;
                    while (i2 < length) {
                        c cVar = new c();
                        JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("format");
                        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("ad_track_urls");
                        cVar.k(jSONObject.optString("ad_content"));
                        cVar.m(jSONObject.optString(CampaignEx.JSON_KEY_IMPRESSION_URL));
                        cVar.l(jSONObject.optString("id"));
                        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(com.ironsource.b9.h.F0);
                        if (jSONObjectOptJSONObject4 == null || (strOptString = jSONObjectOptJSONObject4.optString("id")) == null) {
                            strOptString = "";
                        }
                        cVar.e(strOptString);
                        cVar.g(jSONObject.optString("campaign_id"));
                        cVar.i(jSONObject.optString("creative_id"));
                        if (jSONObjectOptJSONObject2 == null || (strOptString2 = jSONObjectOptJSONObject2.optString("webview_base_url")) == null) {
                            strOptString2 = "";
                        }
                        cVar.t(strOptString2);
                        if (jSONObjectOptJSONObject2 == null || (strOptString3 = jSONObjectOptJSONObject2.optString("mraid_download_url")) == null) {
                            strOptString3 = "";
                        }
                        cVar.p(strOptString3);
                        cVar.a(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optInt("max_attempts_reload", cVar.i()) : cVar.i());
                        cVar.f(jSONObject.optBoolean(CampaignEx.KEY_OMID, false));
                        cVar.h(jSONObject.optBoolean("is_video", false));
                        JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("overlay");
                        int i3 = length;
                        r6 r6Var = new r6();
                        ArrayList arrayList2 = arrayList;
                        int i4 = i2;
                        if (n6Var != 0) {
                            r6Var.f7395a = !((jSONObjectOptJSONObject5 == null || jSONObjectOptJSONObject5.optBoolean("draggable", true)) ? false : true);
                            JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5 != null ? jSONObjectOptJSONObject5.optJSONObject("initial_size") : null;
                            if (jSONObjectOptJSONObject6 != null) {
                                iOptInt = jSONObjectOptJSONObject6.optInt("width");
                            } else {
                                iOptInt = n6Var.f7366a;
                            }
                            r6Var.b = j7.a(iOptInt);
                            if (jSONObjectOptJSONObject6 != null) {
                                i = jSONObjectOptJSONObject6.getInt("height");
                            } else {
                                i = n6Var.b;
                            }
                            r6Var.c = j7.a(i);
                        }
                        cVar.a(r6Var);
                        JSONObject jSONObjectOptJSONObject7 = jSONObject.optJSONObject("ad_unit");
                        String strOptString8 = jSONObject.optString("id");
                        p pVar = new p();
                        if (jSONObjectOptJSONObject7 != null) {
                            Intrinsics.checkNotNullParameter(adUnitId, "<set-?>");
                            pVar.f7379a = adUnitId;
                            if (strOptString8 == null) {
                                strOptString8 = "";
                            }
                            Intrinsics.checkNotNullParameter(strOptString8, "<set-?>");
                            pVar.b = strOptString8;
                            String strOptString9 = jSONObjectOptJSONObject7.optString("type");
                            if (strOptString9 == null) {
                                strOptString9 = "";
                            }
                            Intrinsics.checkNotNullParameter(strOptString9, "<set-?>");
                            pVar.c = strOptString9;
                            if (Intrinsics.areEqual(strOptString9, "optin_video")) {
                                String strOptString10 = jSONObjectOptJSONObject7.optString("app_user_id");
                                if (strOptString10 == null) {
                                    strOptString10 = "";
                                }
                                Intrinsics.checkNotNullParameter(strOptString10, "<set-?>");
                                String strOptString11 = jSONObjectOptJSONObject7.optString("reward_launch");
                                if (strOptString11 == null) {
                                    strOptString11 = "";
                                }
                                Intrinsics.checkNotNullParameter(strOptString11, "<set-?>");
                                pVar.d = strOptString11;
                                g8 g8Var = pVar.e;
                                String strOptString12 = jSONObjectOptJSONObject7.optString(CampaignEx.JSON_KEY_REWARD_NAME);
                                if (strOptString12 == null) {
                                    strOptString12 = "";
                                }
                                g8Var.getClass();
                                Intrinsics.checkNotNullParameter(strOptString12, "<set-?>");
                                g8Var.f7308a = strOptString12;
                                g8 g8Var2 = pVar.e;
                                String strOptString13 = jSONObjectOptJSONObject7.optString("reward_value");
                                if (strOptString13 == null) {
                                    strOptString13 = "";
                                }
                                g8Var2.getClass();
                                Intrinsics.checkNotNullParameter(strOptString13, "<set-?>");
                                g8Var2.b = strOptString13;
                            }
                        }
                        cVar.a(pVar);
                        Intrinsics.checkNotNull(jSONObject);
                        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("params");
                        if (jSONArrayOptJSONArray2 != null) {
                            int length2 = jSONArrayOptJSONArray2.length();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= length2) {
                                    string = "";
                                    break;
                                }
                                JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i5);
                                JSONArray jSONArray = jSONArrayOptJSONArray2;
                                int i6 = length2;
                                if (Intrinsics.areEqual(jSONObject2.getString("name"), "orientation")) {
                                    string = jSONObject2.getString("value");
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                    break;
                                }
                                i5++;
                                jSONArrayOptJSONArray2 = jSONArray;
                                length2 = i6;
                            }
                        } else {
                            string = "";
                            break;
                        }
                        cVar.q(string);
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optJSONArray("params") : null;
                        if (jSONArrayOptJSONArray3 != null) {
                            z3 = true;
                            int length3 = jSONArrayOptJSONArray3.length() - 1;
                            while (true) {
                                if (-1 < length3) {
                                    JSONObject jSONObject3 = jSONArrayOptJSONArray3.getJSONObject(length3);
                                    if (Intrinsics.areEqual(jSONObject3.getString("name"), "zones")) {
                                        JSONArray jSONArrayOptJSONArray4 = jSONObject3.optJSONArray("value");
                                        if (jSONArrayOptJSONArray4 != null && (jSONObjectOptJSONObject = jSONArrayOptJSONArray4.optJSONObject(0)) != null && (strOptString4 = jSONObjectOptJSONObject.optString("name")) != null) {
                                            break;
                                        }
                                        break;
                                    }
                                    length3--;
                                }
                                strOptString4 = "";
                                break;
                            }
                        }
                        strOptString4 = "";
                        z3 = true;
                        cVar.d(strOptString4);
                        String strOptString14 = jSONObject.optString("client_tracker_pattern", "");
                        if (Intrinsics.areEqual(strOptString14, "null")) {
                            strOptString14 = "";
                        }
                        Intrinsics.checkNotNull(strOptString14);
                        cVar.h(strOptString14);
                        cVar.d(jSONObject.optBoolean("has_transparency", false));
                        cVar.r(jSONObject.optString("sdk_close_button_url", ""));
                        cVar.n(jSONObject.optString("landing_page_prefetch_url", ""));
                        cVar.a(jSONObject.optBoolean("landing_page_disable_javascript", false));
                        cVar.o(jSONObject.optString("landing_page_prefetch_whitelist", ""));
                        cVar.e(jSONObject.optBoolean("ad_keep_alive", false));
                        cVar.f(UUID.randomUUID() + cVar.e());
                        cVar.b((jSONObject.has("overlay") || jSONObject.has("banner")) ? false : z3);
                        cVar.a(adType);
                        if (cVar.b().d().length() != 0) {
                            if (Intrinsics.areEqual(cVar.b().d(), adType.a())) {
                                if (jSONObjectOptJSONObject3 == null || (strOptString5 = jSONObjectOptJSONObject3.optString("ad_track_url")) == null) {
                                    strOptString5 = "";
                                }
                                cVar.c(strOptString5);
                                if (jSONObjectOptJSONObject3 == null || (strOptString6 = jSONObjectOptJSONObject3.optString("ad_precache_url")) == null) {
                                    strOptString6 = "";
                                }
                                cVar.b(strOptString6);
                                if (jSONObjectOptJSONObject3 == null || (strOptString7 = jSONObjectOptJSONObject3.optString("ad_history_url")) == null) {
                                    strOptString7 = "";
                                }
                                cVar.a(strOptString7);
                                JSONObject jSONObjectOptJSONObject8 = jSONObject.optJSONObject("banner");
                                i0 i0Var = new i0();
                                if (jSONObjectOptJSONObject8 == null) {
                                    i0Var = new i0();
                                    z4 = false;
                                } else {
                                    z4 = false;
                                    i0Var.f7317a = jSONObjectOptJSONObject8.optBoolean("full_width", false);
                                    jSONObjectOptJSONObject8.optBoolean("auto_refresh", false);
                                    jSONObjectOptJSONObject8.optInt("auto_refresh_rate", 0);
                                }
                                cVar.a(i0Var);
                                boolean zOptBoolean = jSONObject.optBoolean("is_impression", z4);
                                String impressionSourceString = jSONObject.optString("impression_source", "");
                                Intrinsics.checkNotNull(impressionSourceString);
                                Intrinsics.checkNotNullParameter(impressionSourceString, "impressionSourceString");
                                if (Intrinsics.areEqual(impressionSourceString, "sdk")) {
                                    o2Var = o2.IMPRESSION_SOURCE_SDK;
                                } else {
                                    o2Var = Intrinsics.areEqual(impressionSourceString, "format") ? o2.IMPRESSION_SOURCE_FORMAT : o2.IMPRESSION_SOURCE_FORMAT;
                                }
                                cVar.a(new n2(zOptBoolean, o2Var));
                                String loadedSourceString = jSONObject.optString("loaded_source", "");
                                Intrinsics.checkNotNull(loadedSourceString);
                                Intrinsics.checkNotNullParameter(loadedSourceString, "loadedSourceString");
                                if (Intrinsics.areEqual(loadedSourceString, "sdk")) {
                                    r3Var = r3.LOADED_SOURCE_SDK;
                                } else {
                                    r3Var = Intrinsics.areEqual(loadedSourceString, "format") ? r3.LOADED_SOURCE_FORMAT : r3.LOADED_SOURCE_FORMAT;
                                }
                                cVar.a(new q3(r3Var));
                                JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("extras");
                                cVar.j(jSONArrayOptJSONArray5 != null ? jSONArrayOptJSONArray5.toString() : null);
                                cVar.s(sessionId);
                                i2 = i4 + 1;
                                if (jSONObject.has(Reporting.EventType.CACHE)) {
                                    JSONObject jSONObjectOptJSONObject9 = jSONObject.optJSONObject(Reporting.EventType.CACHE);
                                    a1Var = new a1(jSONObjectOptJSONObject9 != null ? Long.valueOf(jSONObjectOptJSONObject9.optLong("ad_expiration")) : null);
                                } else {
                                    a1Var = null;
                                }
                                cVar.a(a1Var);
                                cVar.c(z);
                                cVar.g(z2);
                                cVar.a(oguryMediation);
                                arrayList2.add(cVar);
                                adUnitId = str;
                                arrayList = arrayList2;
                                jSONArrayOptJSONArray = jSONArrayOptJSONArray;
                                length = i3;
                            } else {
                                String strB = adType.b();
                                String strA = cVar.b().a();
                                String strB2 = adType.b();
                                o.a aVar = o.c;
                                String strD = cVar.b().d();
                                aVar.getClass();
                                String message = "[Ads][" + strB + "][load][" + strA + "]Wrong ad unit id type. Expected ad unit id of type " + strB2 + ", but received ad unit id of type " + o.a.a(strD) + ".";
                                Intrinsics.checkNotNullParameter(message, "message");
                                IntegrationLogger.e(message);
                                a("Ad unit type mismatch error");
                                throw null;
                            }
                        } else {
                            a("Ad unit type not found");
                            throw null;
                        }
                    }
                    ArrayList arrayList3 = arrayList;
                    if (!arrayList3.isEmpty()) {
                        return new l(arrayList3);
                    }
                    a("No ads could be parsed");
                    throw null;
                }
                a("The ad object is empty");
                throw null;
            }
            a("No ad object found");
            throw null;
        }
        a("Ad response is empty");
        throw null;
    }
}
