package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.b9;
import com.json.cc;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BannerFinder;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.IronSourceCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import com.smaato.sdk.core.dns.DnsName;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h extends d {
    public static final String R = "data";
    public static final String S = "eventname";
    public static final String T = "requestid";
    public static final String U = "bannerid";
    public static final String V = "auctionid";
    public static final String W = "producttype";
    public static final String X = "adsizelabel";
    public static final String Y = "campaigntype";
    public static final String Z = "adId";
    private static final String aA = "clickURL";
    private static final String aB = "videoData";
    private static final String aC = "videoSource";
    private static final String aD = "videoformat_mp4";
    private static final String aE = "html";
    private static final String aF = "htmlURL";
    private static final String aG = "vast";
    private static final String aH = "mraid";
    private static final String aI = "customEndCard";
    private static final String aJ = "rv-gateway";
    private static final String aK = "gw-rv";
    private static final String aL = "_SupersonicAds";
    private static final String aM = "_IronSource_";
    private static final String aP = "external_url";
    private static final String aQ = "IRONSOURCE_NETWORK";
    private static final String aR = "adMarkup";
    private static final String aS = "sid";
    private static final String aT = "adViewId";
    private static final int aU = 20;
    private static final int aW = 10;
    public static final String aa = "adLoaded";
    public static final String ab = "loadAdSuccess";
    public static final String ac = "showAd";
    public static final String ad = "showAdSuccess";
    public static final String ae = "videoCompleted";
    public static final String af = "videoStarted";
    public static final String ag = "bannerID";
    public static final int ah = 200;
    private static final String ai = "IronSourceDiscovery";
    private static final String aj = "crid";
    private static final String ak = "type";
    private static final String al = "appData";
    private static final String am = "appId";
    private static final String an = "bid";
    private static final String ao = "id";
    private static final String ap = "auction";
    private static final String aq = "seatbid";
    private static final String ar = "cid";
    private static final String as = "ext";
    private static final String at = "dspName";
    private static final String au = "requestID";
    private static final String av = "callbacks";
    private static final String aw = "layoutData";
    private static final String ax = "impressions";
    private static final String ay = "url";
    private static final String az = "clickTags";
    public static final String b = "Interstitial";
    private static final int ba = 20;
    private static final String bl = "jQuery";
    public static final String c = "Banner";
    public static final String d = "MEDIUM_RECTANGLE";
    public static final String e = "instanceID";
    public static final String f = "iid";
    public static final String g = "gateway.supersonicads.com/gateway/sdk/request";
    public static final String h = "iads.unity3d.com/gateway/sdk/request";
    public static final String i = "gw-ext.mediation.unity3d.com/auction";
    public static final String j = "init.supersonicads.com";
    public static final String k = "logs.supersonic.com";
    public static final String l = "logs.ironsrc.mobi";
    public static final String m = "unity3d.com/logs";
    public static final String n = "unity3d.com/d";
    public static final String o = "iads.unity3d.com";
    public static final String p = "isprog.com/d";
    public static final String q = "data=";
    private static final List<String> aN = Collections.synchronizedList(new ArrayList());
    private static final Set<String> aO = new HashSet();
    private static final LimitedConcurrentHashMap<String, String> aV = new LimitedConcurrentHashMap<>(20);
    private static final LimitedConcurrentHashMap<String, Long> aX = new LimitedConcurrentHashMap<>(10);
    private static final LimitedConcurrentHashMap<String, Long> aY = new LimitedConcurrentHashMap<>(10);
    private static final LimitedConcurrentHashMap<String, List<String>> aZ = new LimitedConcurrentHashMap<>(10);
    private static final LimitedConcurrentHashMap<String, WeakReference<WebView>> bb = new LimitedConcurrentHashMap<>(20);
    private static final LimitedConcurrentHashMap<String, String> bc = new LimitedConcurrentHashMap<>(20);
    private static final LimitedConcurrentHashMap<String, CreativeInfo> bd = new LimitedConcurrentHashMap<>(20);
    private static final Map<String, c.a> be = new LimitedConcurrentHashMap(20);
    private static final Map<String, BrandSafetyUtils.AdType> bf = new LimitedConcurrentHashMap(20);
    private static final LimitedConcurrentHashMap<String, BrandSafetyUtils.AdType> bg = new LimitedConcurrentHashMap<>(20);
    private static final LimitedConcurrentHashMap<String, String> bh = new LimitedConcurrentHashMap<>(20);
    private static final Map<Integer, Long> bi = new LimitedConcurrentHashMap(20);
    private static final LimitedConcurrentHashMap<WeakReference<WebView>, WeakReference<WebView>> bj = new LimitedConcurrentHashMap<>(20);
    private static final LimitedConcurrentHashMap<String, WeakReference<WebView>> bk = new LimitedConcurrentHashMap<>(20);

    public h() {
        super(com.safedk.android.utils.h.f, ai);
        this.C.b(AdNetworkConfiguration.SUPPORTS_GZIP_CONTENT, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.DONT_USE_PLACEMENT_ID_IN_BANNER_AD_INFO_KEY, aQ);
        this.C.b(AdNetworkConfiguration.MATCH_ON_BANNER_WEBVIEW_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SHOULD_GET_HTML_TEXT_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_DIFFERENT_ADS_IN_CROSS_ORIGIN_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.VAST_URL_QUERY_PARAMS_TO_IGNORE, "_vast,blkntf");
    }

    private String a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            return str + RemoteSettings.FORWARD_SLASH_STRING + str3;
        }
        StringBuilder sb = new StringBuilder();
        if (str2 == null) {
            str2 = "";
        }
        return sb.append(str2).append(RemoteSettings.FORWARD_SLASH_STRING).append(str3).toString();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        return str.contains(g) || str.contains(h);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        return aN.remove(str) || str.contains(k) || str.contains(l) || str.contains(aL) || str.contains(aM) || str.contains(n) || str.contains(o) || str.contains(p) || str.contains("&adViewId=") || str.contains(m);
    }

    public static boolean b(int i2) {
        Long l2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (bi.get(Integer.valueOf(i2)) != null && (l2 = bi.get(Integer.valueOf(i2))) != null && jCurrentTimeMillis - l2.longValue() < 200) {
            Logger.d(ai, "check if prefetch should be parsed - same prefetch that was seen earlier");
            return false;
        }
        bi.put(Integer.valueOf(i2), Long.valueOf(jCurrentTimeMillis));
        return true;
    }

    public static String B(String str) {
        if (!com.safedk.android.utils.n.l(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("adMarkup")) {
                return null;
            }
            return URLDecoder.decode(jSONObject.getString("adMarkup"), "UTF-8");
        } catch (Throwable th) {
            Logger.d(ai, "Exception decoding prefetch: \n" + th.getMessage() + " encoded prefetch is: \n" + str);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:129:0x044e  */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        String string;
        String string2;
        String str3;
        BrandSafetyEvent.AdFormatType adFormatType;
        String str4;
        String strF;
        String strE;
        String strAq;
        JSONObject jSONObjectOptJSONObject;
        String str5;
        if (aVar != null) {
            be.put(aVar.f8068a, aVar);
            Logger.d(ai, "generate info received bidding prefetch with max params: " + aVar);
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            Logger.d(ai, "generate info buffer value is empty, skipping. url = " + str + ", headers = " + map);
            return null;
        }
        com.safedk.android.utils.n.b(ai, "generate info started, url = " + str + " , content size=" + str2.length() + ", content : " + str2);
        ArrayList arrayList = new ArrayList();
        if (str2.startsWith(bl)) {
            int iIndexOf = str2.indexOf(Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE);
            if (iIndexOf > -1) {
                str2 = str2.substring(iIndexOf, str2.length() - 1);
            }
            com.safedk.android.utils.n.b(ai, "after removal, json response: " + str2);
        }
        if (!com.safedk.android.utils.n.n(str2)) {
            Logger.d(ai, "Not a valid JSON string, skipping");
            return null;
        }
        JSONObject jSONObject = new JSONObject(str2);
        if (!jSONObject.has(aq)) {
            Logger.d(ai, "generate info - no seat bid, exiting!");
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(aq);
        JSONObject jSONObject3 = jSONObject2.getJSONObject("ext");
        if (!jSONObject3.has("requestID")) {
            string = null;
        } else {
            string = jSONObject3.getString("requestID");
        }
        if (!jSONObject3.has("auction")) {
            string2 = null;
        } else {
            JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("auction");
            if (!jSONObjectOptJSONObject2.has("id")) {
                string2 = null;
            } else {
                string2 = jSONObjectOptJSONObject2.getString("id");
            }
        }
        if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string)) {
            Logger.d(ai, "generate info - no request id or auction id");
            return null;
        }
        String strA = a(jSONObject3);
        BrandSafetyEvent.AdFormatType adFormatType2 = null;
        String str6 = null;
        if (string2 != null && be.containsKey(string2)) {
            c.a aVar2 = be.get(string2);
            if (aVar2 != null) {
                adFormatType2 = aVar2.b;
                Logger.d(ai, "generate info, ad format: " + adFormatType2);
                String str7 = aVar2.c;
                str5 = aVar2.f8068a;
                str6 = str7;
            } else {
                Logger.d(ai, "generate info could not get the ad format and placement id!");
                str5 = null;
            }
            str3 = str5;
            adFormatType = adFormatType2;
        } else {
            str3 = null;
            adFormatType = (str.contains(aJ) || str.contains(aK)) ? BrandSafetyEvent.AdFormatType.REWARD : BrandSafetyEvent.AdFormatType.INTER;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("bid");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            String str8 = str6;
            if (i3 >= jSONArray.length()) {
                return arrayList;
            }
            JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
            try {
                ArrayList arrayList2 = new ArrayList();
                String string3 = jSONObject4.getString("cid");
                String string4 = jSONObject4.getString(aj);
                JSONObject jSONObject5 = jSONObject4.getJSONObject("ext");
                JSONObject jSONObject6 = jSONObject5.getJSONObject(aB).getJSONObject(aC);
                String string5 = jSONObject5.getString("type");
                String strOptString = jSONObject6.optString("vast");
                String strOptString2 = jSONObject6.optString("mraid");
                String strOptString3 = TextUtils.isEmpty(strOptString2) ? jSONObject6.optString("html") : strOptString2;
                String strOptString4 = jSONObject6.optString(aD);
                String strD = d(jSONObject5);
                String strB = (TextUtils.isEmpty(str8) && jSONObject5.has(av)) ? b(jSONObject5.getJSONObject(av)) : str8;
                String strOptString5 = null;
                try {
                    if (string5.equals(aI) && (jSONObjectOptJSONObject = jSONObject5.optJSONObject(aw)) != null) {
                        strOptString5 = jSONObjectOptJSONObject.optString("html");
                    }
                    String strA2 = a(string, string2, string4);
                    Logger.d(ai, "generate info - ad id is: " + strA2 + " request id is: " + string + " auction id is: " + string2 + " and crid is: " + string4 + " event id is: " + str3);
                    String strOptString6 = jSONObject6.optString(aF);
                    if (TextUtils.isEmpty(strOptString6)) {
                        String strOptString7 = jSONObject6.optString("html");
                        if (!TextUtils.isEmpty(strOptString7)) {
                            Logger.d(ai, "htmlSource: " + strOptString7);
                            Matcher matcher = com.safedk.android.utils.g.aH().matcher(strOptString7);
                            if (matcher.find()) {
                                strOptString6 = matcher.group(1);
                                Logger.d(ai, "content playable, playable url: " + strOptString6);
                            }
                        }
                        str4 = strOptString6;
                    } else {
                        Logger.d(ai, "content playable html, playable url: " + strOptString6);
                        str4 = strOptString6;
                    }
                    IronSourceCreativeInfo ironSourceCreativeInfo = new IronSourceCreativeInfo(strA2, string3, strD, strOptString4, string5, str4, adFormatType, strB, strOptString5, this.G, strA);
                    ironSourceCreativeInfo.h(str3);
                    arrayList.add(ironSourceCreativeInfo);
                    if ("BANNER".equals(adFormatType) || BrandSafetyUtils.o.equals(adFormatType)) {
                        ironSourceCreativeInfo.a(BrandSafetyUtils.a(adFormatType));
                    }
                    aO.add(strA2);
                    if (strOptString4 != null) {
                        arrayList2.add(strOptString4);
                    }
                    if (str4 != null) {
                        arrayList2.add(str4);
                    }
                    if (!TextUtils.isEmpty(strOptString3)) {
                        Logger.d(ai, "content mraid html");
                        if (com.safedk.android.analytics.brandsafety.creatives.h.a(strOptString3)) {
                            a((CreativeInfo) ironSourceCreativeInfo, str, strOptString3, true);
                            if (ironSourceCreativeInfo.g() && (strAq = ironSourceCreativeInfo.aq()) != null) {
                                arrayList2.add(strAq);
                            }
                            ironSourceCreativeInfo.a("vast", RemoteSettings.FORWARD_SLASH_STRING);
                        } else {
                            if (ironSourceCreativeInfo.O() == null && (strE = E(strOptString3)) != null) {
                                ironSourceCreativeInfo.a(strE, true);
                            }
                            if (ironSourceCreativeInfo.p() == null && (strF = F(strOptString3)) != null) {
                                ironSourceCreativeInfo.q(strF);
                            }
                        }
                    } else if (!TextUtils.isEmpty(strOptString)) {
                        synchronized (this.D) {
                            try {
                                this.D.put(new com.safedk.android.analytics.brandsafety.creatives.f(strOptString), ironSourceCreativeInfo);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    ironSourceCreativeInfo.b((List<String>) com.safedk.android.utils.n.f(jSONObject4.toString().replace("\\/", RemoteSettings.FORWARD_SLASH_STRING)));
                    ironSourceCreativeInfo.c(arrayList2);
                    Logger.d(ai, "generate info CI: " + ironSourceCreativeInfo);
                    str6 = strB;
                } catch (Throwable th2) {
                    th = th2;
                    str6 = strB;
                    Logger.d(ai, "generate info error parsing " + th.getMessage(), th);
                }
            } catch (Throwable th3) {
                th = th3;
                str6 = str8;
            }
            i2 = i3 + 1;
        }
    }

    private static String a(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(at)) {
            return jSONObject.getString(at);
        }
        if (!jSONObject.has(al) || !jSONObject.getJSONObject(al).has(at)) {
            return null;
        }
        return jSONObject.getString(at);
    }

    private String b(JSONObject jSONObject) {
        String strI = null;
        if (!jSONObject.has("impressions")) {
            Logger.d(ai, "extract placement Id - no impressions, can't parse");
        } else {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("impressions");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2.has("url")) {
                        String string = jSONObject2.getString("url");
                        strI = i(e, string);
                        if (strI == null) {
                            strI = i(f, string);
                        }
                        Logger.d(ai, "instance ID: " + strI);
                        break;
                    }
                }
            } catch (JSONException e2) {
                Logger.d(ai, "exception occurred while extracting placement id:\n" + e2);
            }
        }
        return strI;
    }

    private String i(String str, String str2) {
        int iIndexOf = str2.indexOf(str + cc.T);
        if (iIndexOf == -1) {
            return null;
        }
        int iIndexOf2 = str2.indexOf(b9.i.c, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str2.length();
        }
        return str2.substring(iIndexOf + str.length() + 1, iIndexOf2);
    }

    private String c(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(al);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject.optString("appId");
        }
        return null;
    }

    private String d(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(az);
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(aA)) {
            return jSONObjectOptJSONObject.getString(aA);
        }
        return null;
    }

    private i a(String str, WeakReference<WebView> weakReference) {
        if (str.contains(k) || str.contains(l) || str.contains(m)) {
            String[] strArrSplit = str.split(q);
            if (strArrSplit.length == 2) {
                String str2 = new String(Base64.decode(strArrSplit[1], 0));
                Logger.v(ai, "message is " + str2);
                try {
                    JSONObject jSONObject = new JSONObject(str2).getJSONObject("data");
                    String string = jSONObject.getString(S);
                    String strA = com.safedk.android.utils.n.a((Reference<?>) weakReference) ? BrandSafetyUtils.a((Object) weakReference.get()) : null;
                    String strA2 = a(jSONObject.optString(T), jSONObject.optString(V), jSONObject.optString(U));
                    Logger.d(ai, "event: " + string + " and webview is: " + strA + " ad id: " + strA2);
                    String strOptString = jSONObject.optString(X);
                    String strOptString2 = jSONObject.optString("producttype");
                    if (this.H.get(strA2) != null) {
                        Logger.d(ai, "get ad id from resource - ad type: " + strOptString2 + ", ad size: " + strOptString);
                        a(this.H.get(strA2), strOptString2, strOptString);
                    }
                    i iVar = new i(string, strA2);
                    String strOptString3 = jSONObject.optString(Y);
                    if (!strOptString3.isEmpty()) {
                        iVar.a(Y, strOptString3);
                        return iVar;
                    }
                    return iVar;
                } catch (JSONException e2) {
                    Logger.d(ai, "error in json parse: " + e2);
                }
            }
        }
        return null;
    }

    private void b(String str, String str2, WeakReference<WebView> weakReference) {
        if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
            String strA = BrandSafetyUtils.a((Object) weakReference.get());
            aV.put(str2, strA);
            Logger.d(ai, str + "adding ad id: " + str2 + " with webview address: " + strA);
            return;
        }
        Logger.d(ai, str + "webView's ref not alive, not adding ad id: " + str2 + " to adIdToWebviewAddressMap");
    }

    private void a(LimitedConcurrentHashMap<String, String> limitedConcurrentHashMap, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : limitedConcurrentHashMap.keySet()) {
            if (str.equals(limitedConcurrentHashMap.get(str2))) {
                sb.append(str2).append(", ");
                limitedConcurrentHashMap.remove(str2);
            }
        }
        if (sb.length() > 0) {
            com.safedk.android.utils.n.b(ai, "a cwv occurred with webview address: " + str + " and adIds: [" + ((Object) sb) + b9.i.e);
        } else {
            Logger.d(ai, "possibly cwv but with no ad ids");
        }
    }

    private void a(i iVar, WeakReference<WebView> weakReference) {
        if (Arrays.asList(ab, aa).contains(iVar.a())) {
            b("extract adId from IronSource log message - ", iVar.b(), weakReference);
        }
        if (ad.equals(iVar.a()) || ac.equals(iVar.a())) {
            aV.remove(iVar.b());
            Logger.d(ai, "extract adId from IronSource log message - received show ad message for ad id - " + iVar.b());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (String str : aX.keySet()) {
            if (aX.get(str) != null) {
                long jLongValue = aX.get(str).longValue();
                Logger.d(ai, "extract adId from IronSource log message - handling webview address: " + str + " and unseen period: " + (jCurrentTimeMillis - jLongValue));
                if (jCurrentTimeMillis - jLongValue > TimeUnit.SECONDS.toMillis(60L) || aY.containsKey(str)) {
                    aY.put(str, 0L);
                    String str2 = "cwv_issue=" + str;
                    a(aV, str);
                    if (CreativeInfoManager.k(str)) {
                        Logger.d(ai, "extract adId from IronSource log message - inter info exists for webview " + str);
                    } else {
                        Logger.d(ai, "extract adId from IronSource log message - inter info does NOT exist for webview " + str);
                    }
                }
            }
        }
        if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
            String strA = BrandSafetyUtils.a((Object) weakReference.get());
            aX.put(strA, Long.valueOf(System.currentTimeMillis()));
            Logger.d(ai, "extract adId from IronSource log message - adding webview: " + strA + " to map");
        } else {
            Logger.d(ai, "extract adId from IronSource log message - webview is not alive, not adding");
        }
        for (String str3 : aZ.keySet()) {
            if (str3 != null && CreativeInfoManager.k(str3)) {
                Logger.d(ai, "extract adId from IronSource log message - iterating addressToMessages: inter info exists for webview " + str3);
                Iterator<String> it = aZ.get(str3).iterator();
                while (it.hasNext()) {
                    CreativeInfoManager.a(str3, it.next(), BrandSafetyUtils.AdType.INTERSTITIAL, com.safedk.android.analytics.brandsafety.b.y);
                }
                aZ.remove(str3);
            } else {
                Logger.d(ai, "extract adId from IronSource log message - iterating addressToMessages: inter info does NOT exist for webview " + str3);
            }
        }
    }

    private static String C(String str) {
        if (str != null && str.contains(".")) {
            try {
                String[] strArrSplit = str.split(DnsName.ESCAPED_DOT);
                if (strArrSplit.length > 2) {
                    String str2 = strArrSplit[2];
                    if (str2.endsWith("_0")) {
                        return str2.substring(0, str2.length() - 2);
                    }
                    return str2;
                }
                return str;
            } catch (Throwable th) {
                Logger.d(ai, "exception when trying to extract ad id from adViewId: " + th.getMessage());
                return null;
            }
        }
        return str;
    }

    private String K(String str) {
        String strB = com.safedk.android.utils.n.B(str);
        if (strB != null && !strB.contains("unity3d")) {
            Logger.d(ai, "extract Ad Id From IronSource Resource - received url with different domain, not extracting the ad id from it");
            return null;
        }
        Map<String, String> mapA = com.safedk.android.utils.k.a(str, false);
        if (mapA == null) {
            return null;
        }
        String strC = mapA.get("sid");
        if (strC == null && mapA.containsKey("adViewId")) {
            strC = C(mapA.get("adViewId"));
        }
        if (strC == null && mapA.containsKey(ag)) {
            strC = mapA.get(ag);
            Logger.d(ai, "extract Ad Id From IronSource Resource - found value in banner id! value: " + strC);
        }
        String str2 = strC;
        if (str2 != null) {
            Logger.d(ai, "extract Ad Id From IronSource Resource - value: " + str2);
            String strL = L(str2);
            if (strL == null) {
                Logger.d(ai, "extract Ad Id From IronSource Resource - did not find ad id, storing value: /" + str2 + " ad ids are: " + bi);
            } else {
                return strL;
            }
        }
        Logger.d(ai, "extract Ad Id From IronSource Resource - did not find ad id");
        return null;
    }

    private String L(String str) {
        Iterator<String> it = aO.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.endsWith(RemoteSettings.FORWARD_SLASH_STRING + str) || next.startsWith(str + RemoteSettings.FORWARD_SLASH_STRING)) {
                return next;
            }
        }
        return null;
    }

    private String a(String str, List<String> list, WeakReference<WebView> weakReference) {
        i iVarA = a(str, weakReference);
        if (iVarA == null) {
            return null;
        }
        if (iVarA.b() != null) {
            try {
                a(iVarA, weakReference);
            } catch (Throwable th) {
                Logger.e(ai, "IS log message - error occurred while calling handle webview change: " + th.getMessage());
            }
            if (list.contains(iVarA.a())) {
                return iVarA.b();
            }
        }
        String strA = iVarA.a(Y);
        if (strA != null && (strA.equals("PL") || strA.equals("MR"))) {
            Logger.d(ai, "IS log message - skipping message of campaignType = " + strA);
            return null;
        }
        String strA2 = BrandSafetyUtils.a((Object) weakReference.get());
        String strA3 = iVarA.a();
        if (strA3 != null && strA3.equals(ae)) {
            Logger.d(ai, "IS log message - video completed");
            CreativeInfoManager.a(com.safedk.android.utils.h.f, strA2, true, "log-event");
        }
        if (strA3 == null || !strA3.equals(af)) {
            return null;
        }
        Logger.d(ai, "IS log message - video started");
        CreativeInfoManager.a(com.safedk.android.utils.h.f, strA2, false, "log-event");
        return null;
    }

    private boolean j(String str, String str2) {
        if (str.contains("data=eyJ")) {
            return false;
        }
        if (bf.containsKey(str2)) {
            BrandSafetyUtils.AdType adType = bf.get(str2);
            return adType == BrandSafetyUtils.AdType.BANNER || adType == BrandSafetyUtils.AdType.MREC;
        }
        Map<String, String> mapA = com.safedk.android.utils.k.a(str, false);
        Logger.d(ai, "is banner message, url: " + str + " map: " + mapA);
        if (mapA == null) {
            return false;
        }
        for (String str3 : mapA.values()) {
            if (str3 != null && str3.equalsIgnoreCase("Banner")) {
                Logger.d(ai, "is banner message, added webview address: " + str2 + " to map");
                bf.put(str2, BrandSafetyUtils.AdType.BANNER);
                return true;
            }
        }
        return false;
    }

    private void a(CreativeInfo creativeInfo, String str, String str2) {
        Logger.d(ai, "update CI Ad Format - product type: " + str + ", ad size: " + str2);
        if (creativeInfo == null) {
            Logger.d(ai, "update CI Ad Format - ci is null, cannot update ad format");
            return;
        }
        if ("Banner".equals(str)) {
            boolean zEquals = "MEDIUM_RECTANGLE".equals(str2);
            creativeInfo.a(zEquals ? BrandSafetyEvent.AdFormatType.MREC : BrandSafetyEvent.AdFormatType.BANNER);
            creativeInfo.a(zEquals ? BrandSafetyUtils.AdType.MREC : BrandSafetyUtils.AdType.BANNER);
            Logger.d(ai, "update CI Ad Format - setting to banner format, now ci ad format is: " + creativeInfo.K() + " and type: " + creativeInfo.M());
            return;
        }
        creativeInfo.a("Interstitial".equals(str) ? BrandSafetyEvent.AdFormatType.INTER : BrandSafetyEvent.AdFormatType.REWARD);
        creativeInfo.a(BrandSafetyUtils.AdType.INTERSTITIAL);
        Logger.d(ai, "update CI Ad Format - setting to fullscreen format, now ci ad format is: " + creativeInfo.K() + " and type: " + creativeInfo.M());
    }

    private void b(String str, WeakReference<WebView> weakReference) {
        if (com.safedk.android.utils.n.a((Reference<?>) weakReference) && !TextUtils.isEmpty(str) && str.contains("?")) {
            String strB = com.safedk.android.utils.n.B(str);
            Map<String, String> mapA = com.safedk.android.utils.k.a(str, false);
            Logger.d(ai, "extract auction id started with domain: " + strB + " map is: " + mapA);
            if (mapA != null) {
                String str2 = mapA.containsKey("sid") ? mapA.get("sid") : mapA.get("s");
                if (str2 != null) {
                    Logger.d(ai, "extract auction id - found auction id: " + str2);
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        String strK;
        CreativeInfo creativeInfo;
        String strA = com.safedk.android.utils.n.a((Reference<?>) weakReference) ? BrandSafetyUtils.a((Object) weakReference.get()) : null;
        boolean zJ = j(str, strA);
        BrandSafetyUtils.AdType adTypeA = weakReference.get().getWidth() > 0 ? com.safedk.android.analytics.brandsafety.b.a(com.safedk.android.utils.h.f, weakReference.get()) : null;
        if (adTypeA != null) {
            bf.put(strA, adTypeA);
        }
        if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
            Logger.d(ai, "get ad id from resource - is banner: " + zJ + " width: " + weakReference.get().getWidth() + " height: " + weakReference.get().getHeight() + " ad type: " + adTypeA + " webview address: " + strA);
            if (adTypeA == BrandSafetyUtils.AdType.BANNER || adTypeA == BrandSafetyUtils.AdType.MREC) {
                b(str, weakReference);
            }
            BannerFinder bannerFinder = SafeDK.getInstance() != null ? (BannerFinder) SafeDK.getInstance().a(adTypeA) : null;
            if ((adTypeA == BrandSafetyUtils.AdType.BANNER || adTypeA == BrandSafetyUtils.AdType.MREC) && (zJ || (bannerFinder != null && bannerFinder.l(strA)))) {
                strK = K(str);
            } else {
                strK = a(str, Arrays.asList(ac, ad), weakReference);
                if (strK != null) {
                    Logger.d(ai, "get ad id from resource - found ad id by interstitial log message - ad id: " + strK);
                } else if (adTypeA == BrandSafetyUtils.AdType.INTERSTITIAL && (strK = K(str)) != null) {
                    Logger.d(ai, "get ad id from resource - found ad id by interstitial URL resource - ad id: " + strK);
                }
            }
        } else {
            strK = null;
        }
        if (strK != null) {
            if (aO.contains(strK) && this.H.get(strK) != null && ((adTypeA == BrandSafetyUtils.AdType.BANNER || adTypeA == BrandSafetyUtils.AdType.MREC) && (creativeInfo = this.H.get(strK)) != null)) {
                if (creativeInfo.h() != null && creativeInfo.h().contains("mraid")) {
                    creativeInfo.V();
                }
                creativeInfo.a(adTypeA);
                creativeInfo.a(BrandSafetyUtils.a(adTypeA));
                Logger.d(ai, "get ad id from resource - updated ad format: " + creativeInfo.K() + " and type: " + creativeInfo.M());
            }
            if (adTypeA != null) {
                bg.put(strK, adTypeA);
            }
            if (str2 != null) {
                bc.put(strK, str2);
            }
            Logger.d(ai, "get ad id from resource - added ad id: " + strK + " to adIdToSource map");
        } else {
            Logger.d(ai, "get ad id from resource - ad id is null");
        }
        if (str2 != null && com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
            bb.put(str2, weakReference);
            Logger.d(ai, "get ad id from resource - webview is alive, adding source: " + str2);
        } else {
            Logger.d(ai, "get ad id from resource - webview is not alive or source is null, not adding to map, source=" + str2);
        }
        if (strK != null && aO.remove(strK)) {
            Logger.d(ai, "get ad id from resource - found ad id - " + strK);
            return strK;
        }
        Logger.d(ai, "get ad id from resource - match not found for " + strK);
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.DIRECT_CREATIVE_INFO;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(String str, String str2) {
        if (str == null || !str.equals(str2)) {
            return true;
        }
        Logger.d(ai, "screenshot validity failed for hash: " + str);
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        return new HashSet();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<String> e() {
        List<String> listE = super.e();
        listE.add(aP);
        return listE;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean m(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith(RemoteSettings.FORWARD_SLASH_STRING) || str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            for (String str2 : bc.keySet()) {
                if (str2.startsWith(str) || str2.endsWith(str)) {
                    Logger.d(ai, "tryReverseMatching - extended ad id from: " + str + " to: " + str2);
                    str = str2;
                    break;
                }
            }
        }
        if (!bc.containsKey(str)) {
            Logger.d(ai, "tryReverseMatching with ad id - ad id " + str + " is not in the adIdToSource keys: " + bc.keySet());
            return false;
        }
        if (!this.H.containsKey(str)) {
            Logger.d(ai, "tryReverseMatching with ad id - ad id " + str + " is not in the adIdToCI keys: " + this.H.keySet());
            return false;
        }
        CreativeInfo creativeInfo = this.H.get(str);
        BrandSafetyUtils.AdType adType = bg.get(str);
        if (creativeInfo != null && (adType == BrandSafetyUtils.AdType.BANNER || adType == BrandSafetyUtils.AdType.MREC)) {
            creativeInfo.a(bg.get(str));
        }
        String str3 = bc.get(str);
        synchronized (bd) {
            bd.put(str3, creativeInfo);
        }
        return a(str3, com.safedk.android.utils.h.f, bb, bd, d.t);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void n(String str) {
        String strRemove = bc.remove(str);
        Logger.d(ai, "clean resources started with ad id: " + str + ", and source is: " + strRemove);
        if (strRemove != null) {
            bb.remove(strRemove);
            synchronized (bd) {
                bd.remove(strRemove);
            }
        }
        bg.remove(str);
        synchronized (this.H) {
            this.H.remove(str);
        }
        aO.remove(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        Logger.d(ai, "match ci started for ironsource banner: with object: " + obj);
        try {
            if (obj instanceof HashSet) {
                for (Object obj2 : (HashSet) obj) {
                    if (obj2 instanceof String) {
                        Logger.d(ai, "match ci resource is: " + obj2);
                        String strK = K((String) obj2);
                        if (strK != null && this.H.containsKey(strK)) {
                            if (bb.containsKey(obj2)) {
                                WeakReference<WebView> weakReference = bb.get(obj2);
                                if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                                    Logger.d(ai, "match ci - added webview address: " + BrandSafetyUtils.a((Object) weakReference.get()) + " to webview to ad id map with ad id: " + strK);
                                }
                            }
                            return this.H.get(strK);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d(ai, "error while matching info: " + th.getMessage());
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
        com.safedk.android.utils.e.a(bd, "IronSourceDiscovery:sourceToCI");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(WebView webView, Object obj) {
        String strA = BrandSafetyUtils.a((Object) webView);
        bk.put(BrandSafetyUtils.a(obj), new WeakReference<>(webView));
        Logger.d(ai, "add webview to object on interface: " + strA + " object " + obj);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(Object obj, String str) {
        if (str != null && str.startsWith("{\"id\":") && str.contains("openUrl")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("arguments")) {
                    Logger.d(ai, "find webview from open url message - there is no arguments key for json: " + str);
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("arguments");
                if (!jSONObject2.has("url")) {
                    Logger.d(ai, "find webview from open url message - there is no url key for json: " + str);
                    return;
                }
                Logger.d(ai, "find webview from open url message started with json: " + jSONObject);
                if (!jSONObject2.has("type") || !jSONObject2.getString("type").equals("openUrl")) {
                    Logger.d(ai, "find webview from open url message - there is no type or it's not equal to openUrl: " + (jSONObject2.has("type") ? jSONObject2.getString("type") : null));
                    return;
                }
                String strF = com.safedk.android.utils.k.f(jSONObject2.getString("url"));
                Logger.d(ai, "find webview from open url message - redirect message is: " + str);
                Logger.d(ai, "find webview from open url message - url: " + strF);
                if (obj == null || !bk.containsKey(BrandSafetyUtils.a(obj))) {
                    Logger.d(ai, "find webview from open url message - did not find object: " + obj + " in set: " + bk.keySet());
                    return;
                }
                WeakReference<WebView> weakReference = bk.get(BrandSafetyUtils.a(obj));
                if (!com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                    Logger.d(ai, "find webview from open url message - webview is not alive, exiting");
                    return;
                }
                WebView webView = weakReference.get();
                BrandSafetyUtils.AdType adTypeA = com.safedk.android.analytics.brandsafety.b.a(com.safedk.android.utils.h.f, webView);
                String strOptString = jSONObject.optString("adViewId");
                if (adTypeA == BrandSafetyUtils.AdType.INTERSTITIAL || (!TextUtils.isEmpty(strOptString) && (strOptString.startsWith("Inter") || strOptString.startsWith("Reward")))) {
                    Logger.d(ai, "find webview from open url message - not following fullscreen");
                } else {
                    Logger.d(ai, "find webview from open url message - webview address: " + BrandSafetyUtils.a((Object) webView) + " object: " + obj + " ad type is: " + adTypeA + " ad view id: " + strOptString);
                    BrandSafetyUtils.onMraidOpen(com.safedk.android.utils.h.f, null, strF, webView, "mraid.open");
                }
            } catch (Throwable th) {
                Logger.d(ai, "find webview from open url message - exception occurred: " + th);
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void e(String str) {
        try {
            if (str.startsWith("{\"adMarkup\"") && b(str.hashCode())) {
                CreativeInfoManager.a(this.Q, "@!1:ad_fetch@!", B(str), (Map<String, List<String>>) null);
            }
        } catch (Throwable th) {
            Logger.e(ai, "Exception in json object detected", th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String v(String str) {
        try {
            if (str.contains("loadInterstitial?parameters=")) {
                String strA = com.safedk.android.utils.k.a(str, "\"instanceId\":\"", "\"");
                String strA2 = com.safedk.android.utils.k.a(str, "%22crid%22%3A%22", "%22");
                String strA3 = com.safedk.android.utils.k.a(str, "auction%22%3A%7B%22id%22%3A%22", "%22%7D%2C%22");
                String strA4 = com.safedk.android.utils.k.a(str, "requestID%22%3A%22", "%22");
                String strA5 = a(strA4, strA3, strA2);
                Logger.d(ai, "evaluate JS - load interstitial - instance id: " + strA + ", creative id: " + strA2 + ", auction id: " + strA3 + ", request id: " + strA4 + ", ad id: " + strA5);
                if (strA != null && strA2 != null && (strA3 != null || strA4 != null)) {
                    if (bh.containsKey(strA)) {
                        Logger.d(ai, "evaluate JS - load interstitial - found instance Id that already exists in map: " + strA);
                    }
                    bh.put(strA, strA5);
                }
                return null;
            }
            if (str.contains("showInterstitial?parameters=")) {
                String strA6 = com.safedk.android.utils.k.a(str, "\"instanceId\":\"", "\"");
                if (strA6 != null && bh.containsKey(strA6)) {
                    String strRemove = bh.remove(strA6);
                    Logger.d(ai, "evaluate JS - show interstitial - found ad id: " + strRemove);
                    return strRemove;
                }
                Logger.d(ai, "evaluate JS - show interstitial - did not find ad id, for instance: " + strA6 + " keys are: " + bh.keySet());
            }
            return null;
        } catch (Throwable th) {
            Logger.d(ai, "Exception occurred - " + th.getMessage(), th);
        }
    }
}
