package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BannerFinder;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.InterstitialFinder;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.MintegralCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.models.Protocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes8.dex */
public class l {
    private static final String A = "ext_data";
    private static final String B = "par_dspid";
    private static final String C = "slot_id";
    private static final String D = "{";
    private static final String E = "}";
    private static final String F = "ad_type";
    private static final int G = -1;
    private static final String H = "mof_template_url";
    private static final String K = "choose_from_two";
    private static final String L = "multi_ad_mintegral_dsp";
    private static final String M = "rks";
    private static final String N = "a";
    private static final String O = "b";
    private static final String P = "c";
    private static final String Q = "aks";
    private static final String R = "k";
    private static final String S = "q";
    private static final String T = "r";
    private static final String U = "al";
    private static final String V = "csp";
    private static final String W = "mp";
    private static final String X = "drp";
    private static final String Y = "ap";
    private static final String Z = "srp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8072a = "status";
    private static final String aa = "sdkId";
    private static final String ab = "webviewAddress";
    private static final String ac = "direction";
    private static final String ad = "recommendation-images";
    private static final String ae = "recommendations";
    private static final String af = "url";
    private static final String ag = "responseText";
    private static final String ah = "image_url";
    private static final String ai = "title";
    private static final String aj = "icon_url";
    private static final String ak = "desc";
    private static final String al = "ctatext";
    public static final int b = 1;
    public static final String c = "data";
    public static final int d = 287;
    public static final int e = 94;
    public static final int f = 296;
    public static final int g = 42;
    public static final int h = 295;
    private static final String m = "MintegralDiscoveryHelper";
    private static final String n = "ads";
    private static final String o = "id";
    private static final String p = "video_url";
    private static final String q = "image_url";
    private static final String r = "end_screen_url";
    private static final String s = "unit_id";
    private static final String t = "package_name";
    private static final String u = "click_url";
    private static final String v = "cam_html";
    private static final String w = "ad_tracking";
    private static final String x = "impression";
    private static final String y = "impression_url";
    private static final String z = "adv_id";
    private static final String[] I = {"mbridge_same_choice_one_layout", "bigTplChoseFromTwo"};
    private static final String[] J = {"mbridge_order_layout_list", "big-template-501"};
    public static final String i = ".rayjump.com/openapi/moreoffer";
    public static final String j = "mtgglobals.com/openapi/moreoffer";
    public static final String k = ".rayjump.com//openapi/moreoffer";
    public static final List<String> l = Arrays.asList(i, j, k);
    private static final Map<String, String> am = new HashMap();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8074a;
        public HashSet<String> b = new HashSet<>();
    }

    static {
        am.put(Marker.ANY_NON_NULL_MARKER, "X");
        am.put(RemoteSettings.FORWARD_SLASH_STRING, ApsMetricsDataMap.APSMETRICS_FIELD_URL);
        am.put("0", "i");
        am.put("1", "6");
        am.put("2", "1");
        am.put("3", "k");
        am.put(Protocol.VAST_1_0_WRAPPER, "e");
        am.put("5", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        am.put("6", InneractiveMediationDefs.GENDER_FEMALE);
        am.put("7", "G");
        am.put("8", "r");
        am.put("9", Protocol.VAST_1_0_WRAPPER);
        am.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "z");
        am.put("B", VastAttributes.VERTICAL_POSITION);
        am.put("C", RemoteSettings.FORWARD_SLASH_STRING);
        am.put("D", "Y");
        am.put(ExifInterface.LONGITUDE_EAST, "o");
        am.put("F", "2");
        am.put("G", "O");
        am.put("H", "Z");
        am.put("I", "8");
        am.put("J", "d");
        am.put("K", "9");
        am.put("L", "a");
        am.put("M", "w");
        am.put("N", "Q");
        am.put("O", "7");
        am.put("P", "5");
        am.put("Q", "l");
        am.put("R", "I");
        am.put(ExifInterface.LATITUDE_SOUTH, "B");
        am.put("T", "0");
        am.put("U", "j");
        am.put(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "U");
        am.put(ExifInterface.LONGITUDE_WEST, "L");
        am.put("X", "v");
        am.put("Y", "b");
        am.put("Z", ExifInterface.LATITUDE_SOUTH);
        am.put("a", "D");
        am.put("b", "3");
        am.put("c", "F");
        am.put("d", "H");
        am.put("e", VastAttributes.HORIZONTAL_POSITION);
        am.put(InneractiveMediationDefs.GENDER_FEMALE, "N");
        am.put("g", "n");
        am.put("h", "c");
        am.put("i", "M");
        am.put("j", ExifInterface.LONGITUDE_EAST);
        am.put("k", ExifInterface.LONGITUDE_WEST);
        am.put("l", "g");
        am.put("m", Marker.ANY_NON_NULL_MARKER);
        am.put("n", "T");
        am.put("o", "C");
        am.put("p", "K");
        am.put("q", "q");
        am.put("r", "m");
        am.put("s", "s");
        am.put(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, "h");
        am.put(ApsMetricsDataMap.APSMETRICS_FIELD_URL, "p");
        am.put("v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        am.put("w", ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP);
        am.put(VastAttributes.HORIZONTAL_POSITION, "R");
        am.put(VastAttributes.VERTICAL_POSITION, "P");
        am.put("z", "J");
        am.put("=", "=");
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8073a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        public String toString() {
            return (this.f8073a != null ? this.f8073a + " " : "") + (this.b != null ? this.b + " " : "") + (this.c != null ? this.c + " " : "") + (this.d != null ? this.d + " " : "") + (this.e != null ? this.e + " " : "") + (this.f != null ? this.f + " " : "") + (this.g != null ? this.g + " " : "") + (this.h != null ? this.h + " " : "") + (this.i != null ? this.i + " " : "");
        }
    }

    public static void a(String str, String str2, String str3) {
        if (!str.equals(com.safedk.android.utils.h.o) && b(str3)) {
            Logger.d(m, "add multiple ads downstream struct started, sdkPackageName= " + str + ", webViewAddress= " + str2 + ", url= " + str3);
            BannerFinder bannerFinderA = SafeDK.getInstance().A();
            if (bannerFinderA != null) {
                List<CreativeInfo> listA = bannerFinderA.a(str, str2);
                if (listA != null && !listA.isEmpty()) {
                    Logger.d(m, "add multiple ads downstream struct - found CIs by webView= " + listA);
                    for (CreativeInfo creativeInfo : listA) {
                        synchronized (creativeInfo) {
                            if (creativeInfo.al()) {
                                Logger.d(m, "add multiple ads downstream struct - CI is already multi, not adding /multiple_ads to CI= " + creativeInfo.aa());
                            } else if (creativeInfo.h() != null && creativeInfo.h().contains(CreativeInfo.aJ)) {
                                Logger.d(m, "add multiple ads downstream struct - already added /multiple_ads to CI= " + creativeInfo.aa());
                            } else {
                                Logger.d(m, "add multiple ads downstream struct - adding /multiple_ads to CI= " + creativeInfo.aa());
                                creativeInfo.a(CreativeInfo.aJ, "");
                            }
                        }
                    }
                    return;
                }
                Logger.d(m, "add multiple ads downstream struct - CI list is null or empty. sdkPackageName = " + str + ", webViewAddress = " + str2);
            }
        }
    }

    public static boolean a(String str) {
        return str != null && str.contains(".rayjump.com") && str.contains("openapi/ad");
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = l.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void b(String str, String str2, String str3) {
        com.safedk.android.analytics.brandsafety.n nVarQ;
        CreativeInfo creativeInfoJ;
        if (a(str2)) {
            Logger.d(m, "handle DSP recommendations prefetch, URL:" + str2);
            InterstitialFinder interstitialFinderZ = SafeDK.getInstance().z();
            if (interstitialFinderZ != null && (nVarQ = interstitialFinderZ.q(str)) != null && (creativeInfoJ = nVarQ.j()) != null) {
                Logger.d(m, "handle DSP recommendations prefetch, CI: " + creativeInfoJ.aa());
                a(creativeInfoJ, str2, str3);
            }
        }
    }

    private static void a(CreativeInfo creativeInfo, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        Logger.d(m, "handle dsp recommendations prefetch - started, url= " + str);
        Logger.d(m, "handle dsp recommendations prefetch - bufferValue= " + str2);
        if (creativeInfo != null && str != null && str2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.getInt("status") == 1 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null && a(jSONObjectOptJSONObject)) {
                    Logger.d(m, "handle dsp recommendations prefetch - buffer is recommendations prefetch, calling handleRecommendationsPrefetch");
                    a(creativeInfo, jSONObjectOptJSONObject);
                }
            } catch (JSONException e2) {
                Logger.d(m, "handle dsp recommendations prefetch - not a valid JSON string, exception: ", e2);
            } catch (Throwable th) {
                Logger.d(m, "handle dsp recommendations prefetch - encountered exception: ", th);
            }
        }
    }

    public static CreativeInfo a(CreativeInfo creativeInfo, JSONObject jSONObject) {
        Logger.d(m, "handle recommendations prefetch - started");
        if (creativeInfo.S().equals(com.safedk.android.utils.h.o)) {
            creativeInfo = b(creativeInfo);
        }
        ArrayList<b> arrayListB = b(jSONObject);
        for (b bVar : arrayListB) {
            creativeInfo.a(bVar.f8074a, bVar.b);
            com.safedk.android.utils.n.b(m, "handle recommendations prefetch - added recommendation= " + bVar.f8074a + ", resource list= " + bVar.b);
        }
        creativeInfo.d();
        creativeInfo.t("added_recs (" + com.safedk.android.utils.n.e() + "):" + arrayListB.size());
        return creativeInfo;
    }

    public static CreativeInfo b(CreativeInfo creativeInfo, JSONObject jSONObject) {
        Logger.d(m, "handle inter second prefetch - started");
        if (creativeInfo.S().equals(com.safedk.android.utils.h.o)) {
            creativeInfo = b(creativeInfo);
        }
        for (b bVar : b(jSONObject)) {
            creativeInfo.a(bVar.f8074a, new HashSet());
            com.safedk.android.utils.n.b(m, "handle inter second prefetch - added recommendation= " + bVar.f8074a);
        }
        creativeInfo.d();
        String strH = creativeInfo.h() != null ? creativeInfo.h() : "";
        if (!strH.contains(CreativeInfo.aJ)) {
            creativeInfo.e(strH + CreativeInfo.aJ);
        }
        return creativeInfo;
    }

    public static void c(String str) {
        Logger.d(m, "handle dsp complementary prefetch - started. message= " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            Logger.d(m, "handle dsp complementary prefetch - jsonObject= " + jSONObject);
            String strOptString = jSONObject.optString("sdkId");
            Logger.d(m, "handle dsp complementary prefetch - sdk= " + strOptString);
            String strOptString2 = jSONObject.optString(ab);
            Logger.d(m, "handle dsp complementary prefetch - webViewAddress= " + strOptString2);
            if (!TextUtils.isEmpty(strOptString) && !strOptString.equals(com.safedk.android.utils.h.o) && !TextUtils.isEmpty(strOptString2)) {
                String string = jSONObject.getString(ac);
                Logger.d(m, "handle dsp complementary prefetch - direction= " + string);
                if (!TextUtils.isEmpty(string) && string.equals(ad)) {
                    Logger.d(m, "handle dsp complementary prefetch - full screen recommendations");
                    a(jSONObject, strOptString, strOptString2);
                } else {
                    Logger.d(m, "handle dsp complementary prefetch - banner complementary");
                    b(jSONObject, strOptString, strOptString2);
                }
            }
        } catch (JSONException e2) {
            Logger.d(m, "handle dsp complementary prefetch - message is not a valid JSON. exception= " + e2);
        } catch (Exception e3) {
            Logger.d(m, "handle dsp complementary prefetch - encountered exception= " + e3);
        }
    }

    public static void a(CreativeInfo creativeInfo) {
        String strH = creativeInfo.h();
        if (strH != null) {
            creativeInfo.e(strH.replace(CreativeInfo.aJ, ""));
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ae);
            Logger.d(m, "handle dsp fullScreen recommendations - jsonArray= " + jSONArrayOptJSONArray);
            if (jSONArrayOptJSONArray != null) {
                List<CreativeInfo> listA = a(str, str2);
                Logger.d(m, "handle dsp fullScreen recommendations - found CIs= " + listA);
                for (CreativeInfo creativeInfo : listA) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 < jSONArrayOptJSONArray.length()) {
                            String str3 = (String) jSONArrayOptJSONArray.get(i3);
                            Logger.d(m, "handle dsp fullScreen recommendations - removing image from webView resources: " + str3);
                            creativeInfo.F(str3);
                            i2 = i3 + 1;
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            Logger.d(m, "handle dsp fullScreen recommendations - exception= " + e2);
        }
    }

    private static void b(JSONObject jSONObject, String str, String str2) {
        try {
            String strOptString = jSONObject.optString("url");
            Logger.d(m, "handle dsp banner complementary prefetch - url is dsp complementary url= " + strOptString);
            if (b(strOptString)) {
                String strOptString2 = jSONObject.optString(ag);
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString2);
                    Logger.d(m, "handle dsp banner complementary prefetch - responsePrefetch= " + jSONObject2);
                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("data");
                    Logger.d(m, "handle dsp banner complementary prefetch - adsData= " + jSONObjectOptJSONObject);
                    if (jSONObjectOptJSONObject != null) {
                        for (CreativeInfo creativeInfoA : a(str, str2)) {
                            if (c(jSONObjectOptJSONObject)) {
                                Logger.d(m, "handle dsp banner complementary prefetch - ads data is recommendation, calling handleRecommendationsPrefetch");
                                creativeInfoA = a(creativeInfoA, jSONObjectOptJSONObject);
                            } else {
                                Logger.d(m, "handle dsp banner complementary prefetch - ads data is second (multi) ad, calling handleSecondMultiAd");
                                c(creativeInfoA, jSONObjectOptJSONObject);
                            }
                            a(creativeInfoA);
                        }
                        return;
                    }
                    return;
                }
                Logger.d(m, "handle dsp banner complementary prefetch - adsData field is null or empty, returning. adsDataString= " + strOptString2);
                return;
            }
            Logger.d(m, "handle dsp banner complementary prefetch - sdk field is empty or is Mintegral sdk, returning. sdk= " + str);
        } catch (JSONException e2) {
            Logger.d(m, "handle dsp banner complementary prefetch - message is not a valid JSON. exception= " + e2);
        } catch (Exception e3) {
            Logger.d(m, "handle dsp banner complementary prefetch - encountered exception= " + e3);
        }
    }

    public static void c(CreativeInfo creativeInfo, JSONObject jSONObject) {
        Logger.d(m, "handle second multi ad - started, firstCI= " + creativeInfo);
        List<CreativeInfo> listA = a(jSONObject, creativeInfo, creativeInfo.Q, (c.a) null);
        if (!listA.isEmpty()) {
            Logger.d(m, "handle second multi ad - CIs generated= " + listA);
            creativeInfo.a(com.safedk.android.analytics.brandsafety.l.b, new com.safedk.android.analytics.brandsafety.l.a[0]);
            creativeInfo.am();
            a(creativeInfo);
            String str = ((creativeInfo.h() != null ? creativeInfo.h() : "") + (creativeInfo.S().equals(com.safedk.android.utils.h.o) ? CreativeInfo.aK : L)) + CreativeInfo.aI + (listA.size() + 1);
            creativeInfo.e(str);
            Logger.d(m, "handle second multi ad - updating downstream struct of first CI to= " + str);
            SafeDK.getInstance().A().a(creativeInfo);
            for (CreativeInfo creativeInfo2 : listA) {
                creativeInfo2.h(creativeInfo.n());
                creativeInfo2.am();
                creativeInfo2.e(creativeInfo.h());
                creativeInfo2.j(creativeInfo.H());
                if (creativeInfo.Y() != null) {
                    creativeInfo2.c(creativeInfo.ai(), creativeInfo.ah());
                    com.safedk.android.utils.n.b(m, "handle second multi ad - finished updating second CI, calling setCreativeInAdFinder. second CI= " + creativeInfo2);
                    CreativeInfoManager.a(creativeInfo2, creativeInfo.Y(), creativeInfo.X());
                } else {
                    Logger.d(m, "handle second multi ad - not matched yet, adding CI to multi ad list");
                    AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(creativeInfo.S());
                    if (adNetworkDiscoveryI != null) {
                        adNetworkDiscoveryI.a(creativeInfo, creativeInfo.N());
                        adNetworkDiscoveryI.a(creativeInfo2, creativeInfo.N());
                    }
                }
            }
            return;
        }
        Logger.d(m, "handle second multi ad - could not generate second CI");
    }

    public static List<CreativeInfo> a(JSONObject jSONObject, CreativeInfo creativeInfo, String str, c.a aVar) {
        BrandSafetyEvent.AdFormatType adFormatTypeValueOf;
        BrandSafetyUtils.AdType adTypeM;
        Logger.d(m, "generate CI - started");
        ArrayList arrayList = new ArrayList();
        Map<String, String> mapG = g(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("ads");
            Logger.d(m, "generate CI - ads size= " + jSONArray.length());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Logger.d(m, "generate CI - Looping over ad index= " + i2);
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                Map<String, String> mapF = f(jSONObject2.optJSONObject("aks"));
                a aVarB = b(jSONObject2, mapG, mapF);
                String strA = a(aVarB);
                if (strA == null) {
                    Logger.d(m, "generate CI - adId is null, skipping this ad");
                } else {
                    Logger.d(m, "generate CI - adId= " + strA);
                    if (creativeInfo == null) {
                        Pair<BrandSafetyEvent.AdFormatType, BrandSafetyUtils.AdType> pairE = e(jSONObject);
                        BrandSafetyEvent.AdFormatType adFormatType = (BrandSafetyEvent.AdFormatType) pairE.first;
                        adTypeM = (BrandSafetyUtils.AdType) pairE.second;
                        adFormatTypeValueOf = adFormatType;
                    } else {
                        adFormatTypeValueOf = BrandSafetyEvent.AdFormatType.valueOf(creativeInfo.K());
                        adTypeM = creativeInfo.M();
                    }
                    Logger.d(m, "generate CI - adFormat= " + adFormatTypeValueOf + " BrandSafety adType= " + adTypeM);
                    String string = jSONObject2.getString("id");
                    String strA2 = a(jSONObject2, mapG, mapF);
                    String strF = f(jSONObject2.getString("video_url"));
                    String string2 = jSONObject2.getString("image_url");
                    MintegralCreativeInfo mintegralCreativeInfo = new MintegralCreativeInfo(strA, adTypeM, string, strA2, strF, string2, adFormatTypeValueOf, com.safedk.android.utils.k.d(jSONObject.getString("end_screen_url"), "unit_id"), str, a(jSONObject, jSONArray, adTypeM), false, jSONObject2.getString("package_name"));
                    Logger.d(m, "generate CI - creativeInfo created= " + mintegralCreativeInfo);
                    mintegralCreativeInfo.a(aVarB.f8073a);
                    Logger.d(m, "generate CI - setting creativeInfo k field= " + aVarB.f8073a);
                    if (adTypeM == BrandSafetyUtils.AdType.NATIVE && aVar != null) {
                        Logger.d(m, "generate CI - creativeInfo is native, updating its elements");
                        a(mintegralCreativeInfo, jSONObject2, aVar.b == BrandSafetyEvent.AdFormatType.NATIVE);
                    }
                    if (creativeInfo != null) {
                        Logger.d(m, "generate CI - Mintegral dsp, updating sdk to: " + creativeInfo.S());
                        mintegralCreativeInfo.s(creativeInfo.S());
                        mintegralCreativeInfo.n(com.safedk.android.utils.h.o);
                    }
                    a(mintegralCreativeInfo, jSONObject2, string2);
                    arrayList.add(mintegralCreativeInfo);
                    a(mintegralCreativeInfo, adTypeM, jSONObject, jSONArray);
                    a(mintegralCreativeInfo, jSONObject, i2);
                    d(mintegralCreativeInfo, jSONObject2);
                    e(mintegralCreativeInfo, jSONObject2);
                    if (jSONObject2.has("adv_id") && jSONObject2.getInt("adv_id") == 0) {
                        mintegralCreativeInfo.e(mintegralCreativeInfo.h() + "/adv_id_0");
                        Logger.d(m, "downstream struct added programmatic indicator");
                    }
                }
            }
        } catch (JSONException e2) {
            Logger.d(m, "generate CI - could not extract ads array, exception= " + e2);
        }
        return arrayList;
    }

    private static void d(CreativeInfo creativeInfo, JSONObject jSONObject) {
        try {
            if (jSONObject.has("ad_tracking")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("ad_tracking");
                if (jSONObject2.has("impression")) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("impression");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        creativeInfo.w(jSONArray.getString(i2));
                    }
                }
            }
        } catch (JSONException e2) {
            Logger.d(m, "add impression tracking URLs - could not extract impression urls, exception= " + e2);
        }
    }

    private static void e(CreativeInfo creativeInfo, JSONObject jSONObject) {
        try {
            String str = "";
            if (jSONObject.has("ext_data")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("ext_data");
                if (jSONObject2.has(B)) {
                    str = "|par_dspid=" + jSONObject2.getInt(B);
                }
                if (jSONObject2.has(C)) {
                    str = str + "|slot_id=" + jSONObject2.getInt(C);
                }
            }
            if (!TextUtils.isEmpty(str)) {
                creativeInfo.t(str);
            }
        } catch (JSONException e2) {
            Logger.d(m, "parsing exception= " + e2.getMessage());
        }
    }

    private static CreativeInfo b(CreativeInfo creativeInfo) {
        CreativeInfo creativeInfoJ;
        com.safedk.android.analytics.brandsafety.n nVarQ = SafeDK.getInstance().z().q(creativeInfo.S());
        if (nVarQ != null && (creativeInfoJ = nVarQ.j()) != null && creativeInfo != creativeInfoJ && creativeInfo.N().equals(creativeInfoJ.N())) {
            Logger.d(m, "get current displaying Ci - found currently displayed instance= " + creativeInfo.aa());
            return creativeInfoJ;
        }
        return creativeInfo;
    }

    public static boolean a(JSONObject jSONObject) {
        boolean z2 = d(jSONObject) == 295;
        Logger.d(m, "is complementary prefetch - returning= " + z2);
        return z2;
    }

    public static ArrayList<b> b(JSONObject jSONObject) {
        ArrayList<b> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("ads");
            Logger.d(m, "generate recommendations - number of recommendations= " + jSONArray.length());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                b bVar = new b();
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                bVar.f8074a = jSONObject2.getString("package_name");
                bVar.b.addAll(com.safedk.android.utils.n.f(jSONObject2.toString().replace("\\/", RemoteSettings.FORWARD_SLASH_STRING)));
                Logger.d(m, "generate recommendations - generating recommendation num " + i2 + ". packageName= " + bVar.f8074a + ", resources= " + bVar.b);
                arrayList.add(bVar);
            }
        } catch (JSONException e2) {
            Logger.d(m, "generate recommendations - exception while generating recommendations. exception= " + e2);
        }
        return arrayList;
    }

    public static boolean c(JSONObject jSONObject) {
        boolean z2 = false;
        if (jSONObject != null) {
            try {
                if (jSONObject.getJSONArray("ads").length() > 2) {
                    z2 = true;
                }
            } catch (JSONException e2) {
            }
        }
        Logger.d(m, "is recommendations prefetch - returning= " + z2);
        return z2;
    }

    private static List<CreativeInfo> a(String str, String str2) {
        List<CreativeInfo> listA;
        for (com.safedk.android.analytics.brandsafety.b bVar : SafeDK.getInstance().y().values()) {
            if (bVar != null && (listA = bVar.a(str, str2)) != null && !listA.isEmpty()) {
                return listA;
            }
        }
        return new ArrayList();
    }

    private static void a(MintegralCreativeInfo mintegralCreativeInfo, JSONObject jSONObject, int i2) {
        ArrayList<b> arrayListB;
        if (e(jSONObject.optString("mof_template_url", null)) && (arrayListB = b(jSONObject)) != null && arrayListB.size() == 2) {
            b bVar = arrayListB.get(1 - i2);
            mintegralCreativeInfo.b(bVar.f8074a, bVar.b);
            Logger.d(m, "add choose ad recommendations - updating creative info recommendations: " + bVar);
        }
    }

    private static void a(CreativeInfo creativeInfo, BrandSafetyUtils.AdType adType, JSONObject jSONObject, JSONArray jSONArray) {
        if (adType.equals(BrandSafetyUtils.AdType.INTERSTITIAL) && jSONArray.length() > 1) {
            String strOptString = jSONObject.optString("mof_template_url");
            if (!TextUtils.isEmpty(strOptString)) {
                Logger.d(m, "set mof template url - adding mofTemplateYrl to debug info= " + strOptString);
                creativeInfo.t("mofTemplateUrl:" + strOptString);
            }
        }
    }

    private static void a(CreativeInfo creativeInfo, JSONObject jSONObject, String str) {
        Logger.d(m, "extract and classify urls - started");
        ArrayList<String> arrayListF = com.safedk.android.utils.n.f(jSONObject.toString().replace("\\/", RemoteSettings.FORWARD_SLASH_STRING));
        arrayListF.remove(d.H(str));
        Logger.d(m, "extract and classify urls - prefetchResourcesList= " + arrayListF);
        creativeInfo.b((List<String>) arrayListF);
    }

    private static String a(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2) {
        Logger.d(m, "get click url - started");
        String strA = null;
        try {
            String string = jSONObject.getString("click_url");
            Logger.d(m, "get click url - click url from ad object= " + string);
            if (string.isEmpty() && jSONObject.has("cam_html")) {
                String strE = d.E(jSONObject.getString("cam_html"));
                if (strE != null) {
                    string = strE;
                }
                Logger.d(m, "get click url - click url from dsp ad= " + string);
            }
            if (string.contains(D) && string.contains(E)) {
                strA = a(map2, a(map, string));
                Logger.d(m, "get click url - click url after replacing place holders= " + strA);
                return strA;
            }
            return string;
        } catch (JSONException e2) {
            Logger.d(m, "get click url - exception while extracting click url. exception= " + e2);
            return strA;
        }
    }

    private static String a(JSONObject jSONObject, JSONArray jSONArray, BrandSafetyUtils.AdType adType) {
        Logger.d(m, "generate downstream struct - started");
        String str = "";
        String strOptString = jSONObject.optString("mof_template_url", null);
        if (e(strOptString)) {
            str = "" + K;
            Logger.d(m, "generate downstream struct - downstream struct added: choose_from_two");
        }
        if (a(strOptString, jSONArray, adType)) {
            str = str + CreativeInfo.aJ;
            Logger.d(m, "generate downstream struct - downstream struct added: /multiple_ads");
        }
        Logger.d(m, "generate downstream struct - final downstream struct: " + str);
        return str;
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : I) {
            if (str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str, JSONArray jSONArray, BrandSafetyUtils.AdType adType) {
        if (adType != null && adType.equals(BrandSafetyUtils.AdType.INTERSTITIAL) && jSONArray.length() > 1 && !TextUtils.isEmpty(str)) {
            for (String str2 : J) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Pair<BrandSafetyEvent.AdFormatType, BrandSafetyUtils.AdType> e(JSONObject jSONObject) {
        BrandSafetyUtils.AdType adType;
        BrandSafetyEvent.AdFormatType adFormatType;
        Logger.d(m, "generate brandSafety ad type and format - started");
        int iD = d(jSONObject);
        if (iD == 287) {
            adFormatType = BrandSafetyEvent.AdFormatType.INTER;
            adType = BrandSafetyUtils.AdType.INTERSTITIAL;
        } else {
            adType = null;
            adFormatType = null;
        }
        if (iD == 94) {
            adFormatType = BrandSafetyEvent.AdFormatType.REWARD;
            adType = BrandSafetyUtils.AdType.INTERSTITIAL;
        }
        if (iD == 296) {
            adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
            adType = BrandSafetyUtils.AdType.BANNER;
        }
        if (iD == 42) {
            adFormatType = BrandSafetyEvent.AdFormatType.NATIVE;
            adType = BrandSafetyUtils.AdType.NATIVE;
        }
        return new Pair<>(adFormatType, adType);
    }

    private static String f(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            stringBuffer.append(am.get(str.substring(i2, i2 + 1)));
        }
        return new String(Base64.decode(stringBuffer.toString(), 0));
    }

    public static String a(a aVar) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (!TextUtils.isEmpty(aVar.f8073a)) {
            sb.append(aVar.f8073a);
            i2 = 1;
        }
        sb.append(com.safedk.android.analytics.brandsafety.l.ad);
        if (!TextUtils.isEmpty(aVar.c)) {
            sb.append(aVar.c);
            i2++;
        }
        sb.append(com.safedk.android.analytics.brandsafety.l.ad);
        if (!TextUtils.isEmpty(aVar.b)) {
            sb.append(aVar.b);
            i2++;
        }
        sb.append(com.safedk.android.analytics.brandsafety.l.ad);
        if (!TextUtils.isEmpty(aVar.d)) {
            sb.append(aVar.d);
            i2++;
        }
        sb.append(com.safedk.android.analytics.brandsafety.l.ad);
        if (!TextUtils.isEmpty(aVar.e)) {
            sb.append(aVar.e);
            i2++;
        }
        sb.append(com.safedk.android.analytics.brandsafety.l.ad);
        if (!TextUtils.isEmpty(aVar.f)) {
            sb.append(aVar.f);
            i2++;
        }
        sb.append(com.safedk.android.analytics.brandsafety.l.ad);
        if (!TextUtils.isEmpty(aVar.g)) {
            sb.append(aVar.g);
            i2++;
        }
        sb.append(com.safedk.android.analytics.brandsafety.l.ad);
        if (!TextUtils.isEmpty(aVar.h)) {
            sb.append(aVar.h);
            i2++;
        }
        sb.append(com.safedk.android.analytics.brandsafety.l.ad);
        if (!TextUtils.isEmpty(aVar.i)) {
            sb.append(aVar.i);
            i2++;
        }
        if (i2 < 2) {
            Logger.d(m, "generate ad id AKS - not enough params to generate a valid ID: " + ((Object) sb));
            return null;
        }
        Logger.d(m, "generate ad id AKS - generated ad id = " + ((Object) sb));
        return sb.toString();
    }

    private static a b(JSONObject jSONObject, Map<String, String> map, Map<String, String> map2) {
        a aVar = null;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("aks");
            String string = jSONObject.has("impression_url") ? jSONObject.getString("impression_url") : null;
            Logger.d(m, "generate AKS from ad prefetch - impression url template: " + string);
            if (jSONObjectOptJSONObject != null) {
                a aVar2 = new a();
                try {
                    aVar2.f8073a = jSONObjectOptJSONObject.optString("k");
                    aVar2.c = jSONObjectOptJSONObject.optString("q");
                    aVar2.b = jSONObjectOptJSONObject.optString("r");
                    aVar2.d = jSONObjectOptJSONObject.optString("al");
                    aVar2.e = jSONObjectOptJSONObject.optString("csp");
                    aVar2.f = jSONObjectOptJSONObject.optString("mp");
                    aVar2.g = jSONObjectOptJSONObject.optString(X);
                    aVar2.h = jSONObjectOptJSONObject.optString("ap");
                    aVar2.i = jSONObjectOptJSONObject.optString(Z);
                    aVar = aVar2;
                } catch (JSONException e2) {
                    e = e2;
                    aVar = aVar2;
                }
            }
            if (aVar == null || a(aVar) == null) {
                if (string.contains(D) && string.contains(E)) {
                    string = a(map2, a(map, string));
                }
                return d(string);
            }
            return aVar;
        } catch (JSONException e3) {
            e = e3;
        }
        Logger.d(m, "generate AKS from ad prefetch - exception while generating AKS from ad data. exception= " + e);
        return aVar;
    }

    private static Map<String, String> f(JSONObject jSONObject) {
        HashMap map = new HashMap();
        if (jSONObject != null) {
            try {
                if (jSONObject.has("k")) {
                    map.put("k", jSONObject.getString("k"));
                }
                if (jSONObject.has("q")) {
                    map.put("q", jSONObject.getString("q"));
                }
                if (jSONObject.has("r")) {
                    map.put("r", jSONObject.getString("r"));
                }
                if (jSONObject.has("al")) {
                    map.put("al", jSONObject.getString("al"));
                }
                if (jSONObject.has("csp")) {
                    map.put("csp", jSONObject.getString("csp"));
                }
                if (jSONObject.has("mp")) {
                    map.put("mp", jSONObject.getString("mp"));
                }
                if (jSONObject.has(X)) {
                    map.put(X, jSONObject.getString(X));
                }
                if (jSONObject.has("ap")) {
                    map.put("ap", jSONObject.getString("ap"));
                }
                if (jSONObject.has(Z)) {
                    map.put(Z, jSONObject.getString(Z));
                }
            } catch (JSONException e2) {
                Logger.d(m, "generate ad level place holders map - exception while generating adLevelPlaceHoldersMap. exception= " + e2);
            }
        }
        return map;
    }

    private static Map<String, String> g(JSONObject jSONObject) {
        Map<String, String> map = new HashMap<>();
        try {
            if (jSONObject.has("rks")) {
                map = com.safedk.android.utils.d.a(jSONObject.getJSONObject("rks"));
                if (jSONObject.has("a")) {
                    map.put("a", jSONObject.getString("a"));
                }
                if (jSONObject.has("b")) {
                    map.put("b", jSONObject.getString("b"));
                }
                if (jSONObject.has("c")) {
                    map.put("c", jSONObject.getString("c"));
                }
            }
        } catch (JSONException e2) {
            Logger.d(m, "generate prefetch level place holders map - exception while generating prefetchLevelPlaceHoldersMap. exception= " + e2);
        }
        return map;
    }

    public static a d(String str) {
        try {
            a aVar = new a();
            Map<String, String> mapA = com.safedk.android.utils.k.a(str, false);
            aVar.f8073a = mapA.get("k");
            aVar.c = mapA.get("q");
            aVar.b = mapA.get("r");
            aVar.d = mapA.get("al");
            aVar.e = mapA.get("csp");
            aVar.f = mapA.get("mp");
            aVar.g = mapA.get(X);
            aVar.h = mapA.get("ap");
            aVar.i = mapA.get(Z);
            Logger.d(m, "generate AKS from impression url - generated AKS data= " + aVar);
            return aVar;
        } catch (Throwable th) {
            Logger.d(m, "generate AKS from impression url - exception while generating AKS from url " + str + ",  exception= " + th.getMessage());
            return null;
        }
    }

    public static int d(JSONObject jSONObject) {
        return jSONObject.optInt("ad_type", -1);
    }

    private static String a(Map<String, String> map, String str) {
        for (String str2 : map.keySet()) {
            str = str.replace(D + str2 + E, map.get(str2));
        }
        return str;
    }

    private static void a(CreativeInfo creativeInfo, JSONObject jSONObject, boolean z2) {
        String strOptString = jSONObject.optString("image_url");
        if (z2) {
            creativeInfo.r().remove(strOptString);
            creativeInfo.z(CreativeInfo.aN + strOptString);
        } else {
            creativeInfo.x(strOptString);
        }
        Logger.d(m, "update native prefetch elements - adding main image element= " + strOptString);
        String strOptString2 = jSONObject.optString("title");
        if (z2) {
            creativeInfo.z(CreativeInfo.aM + strOptString2);
        } else {
            creativeInfo.y(strOptString2);
        }
        Logger.d(m, "update native prefetch elements - adding title element= " + strOptString2);
        String strOptString3 = jSONObject.optString("icon_url");
        if (z2) {
            creativeInfo.z(CreativeInfo.aO + strOptString3);
        } else {
            creativeInfo.x(strOptString3);
        }
        Logger.d(m, "update native prefetch elements - adding icon url element= " + strOptString3);
        String strOptString4 = jSONObject.optString("desc");
        if (z2) {
            creativeInfo.z(CreativeInfo.aP + strOptString4);
        } else {
            creativeInfo.y(strOptString4);
        }
        Logger.d(m, "update native prefetch elements - adding body element= " + strOptString4);
        String strOptString5 = jSONObject.optString("ctatext");
        if (z2) {
            creativeInfo.z(CreativeInfo.aQ + strOptString5);
        } else {
            creativeInfo.y(strOptString5);
        }
        Logger.d(m, "update native prefetch elements - adding cta element= " + strOptString5);
        if (!z2) {
            creativeInfo.f("/native");
        }
    }
}
