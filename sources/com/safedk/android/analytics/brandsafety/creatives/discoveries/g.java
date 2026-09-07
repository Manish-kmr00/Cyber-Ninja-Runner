package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.InMobiCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g extends d {
    private static final String R = "markupType";
    private static final String S = "inmobiJson";
    private static final String T = "requestId";
    private static final String U = ".w.inmobi.com/c.asm/";
    private static final String V = "banner";
    private static final String W = "mrec";
    private static final String X = "ads.inmobi.com/sdk";
    private static final String Y = "client-request-id";
    private static final String Z = "mk-ad-slot";
    private static final int aE = 50;
    private static final String aH = "(function(){var sdkId=\"{{SDK_ID}}\";var address=\"{{ADDRESS}}\";var log=function(message){try{if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(message)}else{console.log(\"SafeDKWebApInterface safedkDebug object missing\")}}catch(error){}};var lookForPrivacyPolicy=function(){try{var isPrivacyPolicy=document.querySelectorAll('[class^=\"overlay svelte-\"]').length>0;isPrivacyPolicy=isPrivacyPolicy||document.querySelectorAll('[class^=\"rate-ad svelte-\"]').length>0;isPrivacyPolicy=isPrivacyPolicy||document.querySelectorAll('[class*=\"reporting-container\"]').length>0;isPrivacyPolicy=isPrivacyPolicy||document.querySelectorAll('main.overlay.full-screen-ad-report[class*=\"svelte-\"]').length>0;if(isPrivacyPolicy&&!isPrivacyPolicyReported){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0);isPrivacyPolicyReported=true}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}};var isPrivacyPolicyReported=false;lookForPrivacyPolicy();try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){for(var i=0;i<mutation.addedNodes.length;i++){var node=mutation.addedNodes[i];if(node&&node.nodeName!=\"#text\"){lookForPrivacyPolicy()}}})});var config={childList:true,subtree:true};observer.observe(document,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}})();\n";
    private static final String aa = "im-plid";
    private static final String ab = "adtype";
    private static final String ac = "creativeType";
    private static final String ad = "metaInfo";
    private static final String ae = "omsdkInfo";
    private static final String af = "macros";
    private static final String ag = "$PLACEMENT_DIMENSION";
    private static final String ah = "content";
    private static final String ai = "trackers";
    private static final String aj = "title";
    private static final String ak = "screenshots";
    private static final String al = "url";
    private static final String am = "icon";
    private static final String an = "iconUrl";
    private static final String ao = "description";
    private static final String ap = "cta";
    private static final String aq = "ctaText";
    private static final String ar = "rating";
    private static final String as = "star";
    private static final String at = "impressionTrackers";
    private static final String au = "com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL";
    private static final String av = "com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX";
    private static final float aw = 0.3f;
    public static final String b = "contextData";
    public static final String c = "advertisedContent";
    private static final String d = "InMobiDiscovery";
    private static final String e = "rootContainer";
    private static final String f = "assetValue";
    private static final String g = "placementId";
    private static final String h = "ads";
    private static final String i = "adSets";
    private static final String j = "creativeId";
    private static final String k = "impressionId";
    private static final String l = "bidBundle";
    private static final String m = "pubContent";
    private static final String n = "passThroughJson";
    private static final String o = "adContent";
    private static final String p = "landingUrl";
    private static final String q = "landingPageUrl";
    private static final Map<String, com.safedk.android.analytics.brandsafety.creatives.i> ax = new HashMap();
    private static final Map<String, CreativeInfo> ay = new ConcurrentHashMap();
    private static final Map<String, CreativeInfo> az = new ConcurrentHashMap();
    private static final Map<String, CreativeInfo> aA = new ConcurrentHashMap();
    private static final Map<String, CreativeInfo> aB = new ConcurrentHashMap();
    private static final Map<String, String> aC = new ConcurrentHashMap();
    private static final Map<String, String> aD = new ConcurrentHashMap();
    private static final Map<String, String> aF = new LimitedConcurrentHashMap(50);
    private static final Map<String, WeakReference<WebView>> aG = new LimitedConcurrentHashMap(50);

    public g() {
        super(com.safedk.android.utils.h.i, d);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SHOULD_UPDATE_CREATIVE_INFO_FROM_VAST, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_GZIP_CONTENT, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE, true);
        this.C.a(AdNetworkConfiguration.BITMAP_SCAN_BOTTOM_MARGIN_PERCENT, aw);
        this.C.b(AdNetworkConfiguration.BITMAP_SCAN_SHOULD_CHECK_FOR_GREYSCALE, true);
        this.C.b(AdNetworkConfiguration.ENFORCE_CLOSE_INPUT_STREAM_VAST_IN_VAST, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.AVOID_CLEANING_PENDING_CI_LIST_ON_AD_END, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_INTERNAL_BROWSER_OPENS_IN_SAME_ACTIVITY, true);
        this.C.b(AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, true);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_EARLY_VAST_AD_TAG_URI_PARSING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_BANNERS_USING_BANNER_KEY, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.DOWNLOAD_INNER_VAST_URL_IF_NOT_LOADED, true);
        this.C.b(AdNetworkConfiguration.SHOULD_CALL_RESOURCE_LOADED_FROM_SHOULD_INTERCEPT_REQUEST, true);
        this.C.b(AdNetworkConfiguration.INJECT_SCRIPTS_IF_URL_IS_NULL, true);
        this.C.b(AdNetworkConfiguration.JS_PRIVACY_BUTTON_CLICK_DETECTION_SCRIPT, aH);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) {
        InMobiCreativeInfo inMobiCreativeInfo;
        com.safedk.android.utils.n.b(d, "generate info started, url: " + str + ", event id: " + (aVar == null ? "" : aVar.f8068a) + ", buffer size: " + (str2 == null ? "0" : Integer.valueOf(str2.length())));
        if (com.safedk.android.utils.n.n(str2)) {
            if (K(str2)) {
                Logger.d(d, "generate info - InMobi prefetch");
                return a(str, str2, map, aVar);
            }
            return i(str, str2);
        }
        Logger.d(d, "generate info - InMobi pubContent, url: " + str);
        synchronized (ay) {
            inMobiCreativeInfo = (InMobiCreativeInfo) ay.remove(str);
        }
        if (inMobiCreativeInfo != null) {
            return a(str, str2, inMobiCreativeInfo, "");
        }
        Logger.d(d, "generate info - not a valid JSON string");
        return new ArrayList();
    }

    private List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar) {
        String str3;
        JSONArray jSONArray;
        BrandSafetyUtils.AdType adTypeC;
        BrandSafetyUtils.AdType adTypeC2;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("requestId") || (!jSONObject.has(i) && !jSONObject.has("ads"))) {
                Logger.d(d, "generate info - not a JSON prefetch");
                return arrayList;
            }
            if (jSONObject.getJSONArray(i).length() == 0) {
                Logger.d(d, "generate info - ad sets array is empty, skipping");
                return arrayList;
            }
            if (!jSONObject.has("requestId")) {
                str3 = null;
            } else {
                String string = jSONObject.getString("requestId");
                Logger.d(d, "generate info - request id: " + string);
                str3 = string;
            }
            String string2 = null;
            if (jSONObject.has("placementId")) {
                string2 = jSONObject.getString("placementId");
                Logger.d(d, "generate info - placement id: " + string2);
            }
            com.safedk.android.utils.n.b(d, "generate info - url: " + str + " , Headers: " + (map != null ? map.toString() : "null") + ", buffer size: " + (str2 == null ? "0" : Integer.valueOf(str2.length())) + " , buffer: " + str2);
            JSONObject jSONObject2 = null;
            if (jSONObject.has(i)) {
                JSONArray jSONArray2 = jSONObject.getJSONArray(i);
                Logger.d(d, "generate info - ad sets : " + jSONArray2.length() + " items");
                if (jSONArray2.length() > 0) {
                    jSONObject2 = jSONArray2.getJSONObject(0);
                } else {
                    Logger.d(d, "generate info - ad sets element has no items");
                    return arrayList;
                }
            }
            if (jSONObject2 != null) {
                jSONArray = jSONObject2.getJSONArray("ads");
            } else if (jSONObject.has("ads") && (jSONObject.get("ads") instanceof JSONArray)) {
                jSONArray = jSONObject.getJSONArray("ads");
            } else {
                Logger.d(d, "generate info - ads element has no items or is not an array");
                return arrayList;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                String string3 = jSONObject3.getString("creativeId");
                String string4 = jSONObject3.getString(k);
                Logger.d(d, "generate info - impression id: " + string4 + ", creative id: " + string3);
                String strOptString = null;
                JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject(b);
                if (jSONObjectOptJSONObject != null) {
                    strOptString = jSONObjectOptJSONObject.optString(c);
                }
                if (str3 != null && aD.containsKey(string2)) {
                    String str4 = aD.get(string2);
                    Logger.d(d, "generate info - placement id to ad type list contains ad type " + str4 + " for placement id " + string2);
                    if (str4.equals("banner")) {
                        adTypeC2 = c(jSONObject3);
                        if (adTypeC2 == null) {
                            adTypeC2 = BrandSafetyUtils.AdType.BANNER;
                        }
                    } else if (str4.equals("mrec")) {
                        adTypeC2 = BrandSafetyUtils.AdType.MREC;
                    } else {
                        adTypeC2 = BrandSafetyUtils.AdType.INTERSTITIAL;
                    }
                    adTypeC = adTypeC2;
                } else if (aVar != null && (aVar.b == BrandSafetyEvent.AdFormatType.BANNER || aVar.b == BrandSafetyEvent.AdFormatType.LEADER)) {
                    adTypeC = BrandSafetyUtils.AdType.BANNER;
                } else if (aVar != null && aVar.b == BrandSafetyEvent.AdFormatType.MREC) {
                    adTypeC = BrandSafetyUtils.AdType.MREC;
                } else if (aVar != null && aVar.b == BrandSafetyEvent.AdFormatType.NATIVE) {
                    adTypeC = BrandSafetyUtils.AdType.NATIVE;
                } else if ((aVar != null && (aVar.b == BrandSafetyEvent.AdFormatType.INTER || aVar.b == BrandSafetyEvent.AdFormatType.REWARD)) || (adTypeC = c(jSONObject3)) == null) {
                    adTypeC = BrandSafetyUtils.AdType.INTERSTITIAL;
                }
                Logger.d(d, "generate info - ad type: " + (adTypeC != null ? adTypeC.name() : "null"));
                InMobiCreativeInfo inMobiCreativeInfo = new InMobiCreativeInfo(string4, string3, string2, this.G, adTypeC, jSONArray.length(), aVar == null ? null : aVar.b, aVar == null ? null : aVar.f8068a, strOptString);
                boolean zA = a(jSONObject3);
                String string5 = jSONObject3.getString(m);
                String strB = B(string5);
                List<CreativeInfo> arrayList2 = new ArrayList<>();
                if (com.safedk.android.utils.n.a((Object) string5)) {
                    inMobiCreativeInfo.t("pubContentUrl=" + string5);
                    Logger.d(d, "generate info - adding pubContent URL to follow: " + string5);
                    synchronized (ay) {
                        ay.put(string5, inMobiCreativeInfo);
                    }
                    aF.put(string5, inMobiCreativeInfo.N());
                    arrayList2.add(inMobiCreativeInfo);
                } else if (adTypeC == BrandSafetyUtils.AdType.NATIVE) {
                    String strA = a(inMobiCreativeInfo, jSONObject3, true);
                    if (strB != null) {
                        arrayList2 = a(str, strB, inMobiCreativeInfo, strA);
                    } else {
                        inMobiCreativeInfo.a(b(jSONObject3), true);
                    }
                    a(inMobiCreativeInfo, jSONObject3);
                    a(new JSONObject(string5), (CreativeInfo) inMobiCreativeInfo);
                    String str5 = string3 + "_" + string4;
                    Logger.d(d, "generate info - adding native ci with creative id as key: " + str5);
                    synchronized (az) {
                        az.put(str5, inMobiCreativeInfo);
                    }
                } else if (zA && strB != null) {
                    com.safedk.android.utils.n.b(d, "generate info - found native vast inside pubContent");
                    arrayList2 = a(str, strB, inMobiCreativeInfo, a(inMobiCreativeInfo, jSONObject3, false));
                } else if (zA) {
                    arrayList2 = a(str, string5, inMobiCreativeInfo, a(inMobiCreativeInfo, jSONObject3, false));
                    inMobiCreativeInfo.a(b(jSONObject3), true);
                    b(inMobiCreativeInfo, jSONObject3);
                    c(inMobiCreativeInfo, jSONObject3);
                } else if (strB != null) {
                    arrayList2 = a(str, strB, inMobiCreativeInfo, "");
                } else {
                    arrayList2 = a(str, string5, inMobiCreativeInfo, "");
                }
                if (adTypeC == BrandSafetyUtils.AdType.INTERSTITIAL) {
                    String strA2 = BrandSafetyUtils.a(string5.replace("\\/", RemoteSettings.FORWARD_SLASH_STRING).getBytes());
                    Logger.d(d, "generate info - added interstitial CI. # of cis is " + aC.size() + ", content hash: " + strA2);
                    aC.put(strA2, inMobiCreativeInfo.N());
                    synchronized (az) {
                        az.put(inMobiCreativeInfo.N(), inMobiCreativeInfo);
                    }
                    if (aVar == null) {
                        Logger.d(d, "generate info - adding interstitial ci with creative id as key (" + string3 + ")");
                        synchronized (az) {
                            az.put(string3, inMobiCreativeInfo);
                        }
                        com.safedk.android.utils.n.b(d, "generate info - added interstitial CI. # of cis is " + az.size() + ", impression id: " + string4 + ", creative id: " + string3 + ", CI: " + inMobiCreativeInfo);
                    }
                } else if ((adTypeC == BrandSafetyUtils.AdType.BANNER || adTypeC == BrandSafetyUtils.AdType.MREC) && string2 != null && aVar != null && aVar.f8068a != null && inMobiCreativeInfo.ar() == 1) {
                    String strReplaceAll = string5.replaceAll("\\s+|\\\\n", "");
                    Logger.d(d, "adding ci with pubContent key: " + strReplaceAll);
                    aF.put(strReplaceAll, inMobiCreativeInfo.N());
                    String str6 = string2 + "_" + aVar.f8068a + "_" + com.safedk.android.utils.h.i;
                    Logger.d(d, "adding banner ci with complex key (" + str6 + ")");
                    synchronized (aA) {
                        aA.put(str6, inMobiCreativeInfo);
                    }
                    com.safedk.android.utils.n.b(d, "added banner CI. # of cis is " + aA.size() + ", impression id: " + string4 + ", adType = " + adTypeC + ", complex key: " + str6 + ", CI: " + inMobiCreativeInfo.aa());
                }
                Logger.d(d, "recent creative IDs array item added. Key = " + string3);
                if (arrayList2 != null && arrayList2.size() > 0) {
                    arrayList.addAll(arrayList2);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            Logger.e(d, "error: " + th.getMessage(), th);
        }
    }

    private static void a(JSONObject jSONObject, CreativeInfo creativeInfo) {
        String strOptString;
        String strOptString2;
        String str;
        String str2;
        String strOptString3;
        String strOptString4;
        String strOptString5;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(n);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(o);
        if (jSONObjectOptJSONObject != null) {
            strOptString3 = jSONObjectOptJSONObject.optString("title");
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(ak);
            String strOptString6 = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optString("url") : null;
            String strOptString7 = jSONObjectOptJSONObject.optJSONObject("icon") != null ? jSONObjectOptJSONObject.optString("url") : null;
            strOptString2 = jSONObjectOptJSONObject.optString("description");
            strOptString = jSONObjectOptJSONObject.optString("cta");
            str = strOptString7;
            str2 = strOptString6;
        } else {
            strOptString = null;
            strOptString2 = null;
            str = null;
            str2 = null;
            strOptString3 = null;
        }
        if (jSONObjectOptJSONObject2 != null) {
            strOptString5 = TextUtils.isEmpty(strOptString3) ? jSONObjectOptJSONObject2.optString("title") : strOptString3;
            strOptString4 = TextUtils.isEmpty(str) ? jSONObjectOptJSONObject2.optString("iconUrl") : str;
            String strOptString8 = TextUtils.isEmpty(strOptString2) ? jSONObjectOptJSONObject2.optString("description") : strOptString2;
            strOptString = TextUtils.isEmpty(strOptString) ? jSONObjectOptJSONObject2.optString(aq) : strOptString;
            strOptString2 = strOptString8;
        } else {
            strOptString4 = str;
            strOptString5 = strOptString3;
        }
        if (!TextUtils.isEmpty(strOptString5)) {
            creativeInfo.z(CreativeInfo.aM + strOptString5);
        }
        if (!TextUtils.isEmpty(str2)) {
            creativeInfo.z(CreativeInfo.aN + str2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            creativeInfo.z(CreativeInfo.aO + strOptString4);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            creativeInfo.z(CreativeInfo.aP + strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString)) {
            creativeInfo.z(CreativeInfo.aQ + strOptString);
        }
    }

    private String B(String str) {
        String string = null;
        try {
            if (!com.safedk.android.utils.n.n(str)) {
                Logger.d(d, "check vast format prefetch - pubContent is not a JSON");
            } else {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(e)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(e);
                    if (jSONObject2.has(f)) {
                        JSONArray jSONArray = jSONObject2.getJSONArray(f);
                        loop0: for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            if (jSONObject3.has(f)) {
                                JSONArray jSONArray2 = jSONObject3.getJSONArray(f);
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    if ((jSONArray2.get(i3) instanceof String) && com.safedk.android.analytics.brandsafety.creatives.h.a(jSONArray2.getString(i3))) {
                                        Logger.d(d, "check vast format prefetch - found vast value inside");
                                        string = jSONArray2.getString(i3);
                                        break loop0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            Logger.d(d, "check vast format prefetch - exception occurred: " + e2.getMessage());
        }
        return string;
    }

    private void a(List<String> list, JSONArray jSONArray, boolean z) {
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (z) {
                    try {
                        list.add(jSONArray.getJSONObject(i2).optString("url"));
                    } catch (JSONException e2) {
                    }
                } else {
                    list.add(jSONArray.getString(i2));
                }
            }
        }
    }

    private void a(InMobiCreativeInfo inMobiCreativeInfo, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(m);
        if (jSONObjectOptJSONObject != null) {
            a((List<String>) arrayList, jSONObjectOptJSONObject.optJSONArray("trackers"), true);
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(n);
            if (jSONObjectOptJSONObject2 != null) {
                a((List<String>) arrayList, jSONObjectOptJSONObject2.optJSONArray(at), false);
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(e);
            if (jSONObjectOptJSONObject3 != null) {
                a((List<String>) arrayList, jSONObjectOptJSONObject3.optJSONArray("trackers"), true);
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject(f);
                if (jSONObjectOptJSONObject4 != null) {
                    a((List<String>) arrayList, jSONObjectOptJSONObject4.optJSONArray("trackers"), true);
                }
            }
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            inMobiCreativeInfo.v(it.next());
        }
    }

    private void b(InMobiCreativeInfo inMobiCreativeInfo, JSONObject jSONObject) {
        if (!jSONObject.has(m)) {
            Logger.d(d, "addDSPDomainURLs did not find pub_content");
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(m);
            if (!jSONObject2.has("trackers")) {
                Logger.d(d, "addDSPDomainURLs did not find trackers array");
                return;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject2.getJSONArray("trackers");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.getJSONObject(i2).has("url")) {
                    arrayList.add(jSONArray.getJSONObject(i2).getString("url"));
                }
            }
            inMobiCreativeInfo.b((List<String>) arrayList);
        } catch (JSONException e2) {
            Logger.d(d, "addDSPDomainURLs not a native ad (" + e2.getMessage() + ")");
        }
    }

    private String a(InMobiCreativeInfo inMobiCreativeInfo, JSONObject jSONObject, boolean z) {
        String str = z ? "" : CreativeInfo.aH;
        try {
            String str2 = str + RemoteSettings.FORWARD_SLASH_STRING + jSONObject.getString(R);
            if (!jSONObject.has(ad)) {
                Logger.d(d, "set downstreamStruct failed because there is no metaInfo in ad object");
                return str2;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(ad);
            if (!jSONObject2.has("creativeType")) {
                Logger.d(d, "set downstreamStruct failed because there is no creativeType in metaInfo");
                return str2;
            }
            String str3 = str2 + RemoteSettings.FORWARD_SLASH_STRING + jSONObject2.getString("creativeType");
            inMobiCreativeInfo.e(str3);
            return str3;
        } catch (JSONException e2) {
            Logger.d(d, "set downstreamStruct - failed because of jsonException " + e2.getMessage());
            return str;
        }
    }

    private boolean a(JSONObject jSONObject, String str, CreativeInfo creativeInfo, String str2, boolean z, boolean z2) {
        try {
            if (jSONObject.has(str2)) {
                if (z2) {
                    creativeInfo.y(jSONObject.getString(str2));
                } else {
                    creativeInfo.x(jSONObject.getString(str2));
                }
                return true;
            }
        } catch (JSONException e2) {
            Logger.d(d, "findInJSONAndAddText - exception happened during trying to retrieve key " + str2 + " form json element " + str);
        }
        if (z) {
            Logger.d(d, "findInJSONAndAddText - did not find the key: " + str2 + " inside the json element: " + str);
        }
        return false;
    }

    private void c(InMobiCreativeInfo inMobiCreativeInfo, JSONObject jSONObject) {
        boolean zA;
        boolean zA2;
        boolean zA3;
        boolean z = false;
        boolean zA4 = false;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(m);
            if (!jSONObject2.has(n)) {
                zA = false;
                zA2 = false;
                zA3 = false;
            } else {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(n);
                if (jSONObject3.has(ak)) {
                    a(jSONObject3.getJSONObject(ak), ak, inMobiCreativeInfo, "url", true, false);
                }
                zA4 = jSONObject3.has("icon") ? a(jSONObject3.getJSONObject("icon"), "icons", inMobiCreativeInfo, "url", false, false) : false;
                boolean zA5 = a(jSONObject3, n, inMobiCreativeInfo, "title", false, true);
                zA3 = a(jSONObject3, n, inMobiCreativeInfo, "description", false, true);
                zA2 = a(jSONObject3, n, inMobiCreativeInfo, "cta", false, true);
                zA = a(jSONObject3, n, inMobiCreativeInfo, "rating", false, true);
                z = zA5;
            }
            if (jSONObject2.has(o)) {
                JSONObject jSONObject4 = jSONObject2.getJSONObject(o);
                a(jSONObject4, o, inMobiCreativeInfo, "title", !z, true);
                a(jSONObject4, o, inMobiCreativeInfo, "iconUrl", !zA4, false);
                a(jSONObject4, o, inMobiCreativeInfo, "description", !zA3, true);
                a(jSONObject4, o, inMobiCreativeInfo, aq, !zA2, true);
                a(jSONObject4, o, inMobiCreativeInfo, "rating", !zA, true);
            }
        } catch (JSONException e2) {
            Logger.d(d, "extract native ad content - failed because of jsonException " + e2.getMessage());
        }
    }

    private boolean a(JSONObject jSONObject) {
        try {
            boolean z = jSONObject.has(R) && jSONObject.getString(R).equals(S);
            boolean z2 = jSONObject.has(m) && com.safedk.android.utils.n.n(jSONObject.getString(m));
            boolean z3 = jSONObject.getJSONObject(m).has(o) && jSONObject.getJSONObject(m).getJSONObject(o).length() > 0;
            if (z && z2 && z3) {
                Logger.d(d, "is native ad - adObj is indeed an inmobi native ad");
                return true;
            }
        } catch (JSONException e2) {
            Logger.d(d, "not a native ad");
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x004d A[Catch: JSONException -> 0x0073, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0073, blocks: (B:6:0x0011, B:8:0x001f, B:10:0x002d, B:11:0x004d), top: B:16:0x0011 }] */
    private String b(JSONObject jSONObject) {
        String str = null;
        if (!jSONObject.has(m)) {
            Logger.d(d, "getNativeAdClickUrl did not find pub_content");
        } else {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(m);
                if (jSONObject2.has(n)) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(n);
                    if (jSONObject3.has(p)) {
                        String string = jSONObject3.getString(p);
                        Logger.d(d, "getNativeAdClickUrl returned " + string);
                        str = string;
                    } else {
                        String string2 = jSONObject2.getJSONObject(o).getString(q);
                        Logger.d(d, "getNativeAdClickUrl returned " + string2);
                        str = string2;
                    }
                } else {
                    String string3 = jSONObject2.getJSONObject(o).getString(q);
                    Logger.d(d, "getNativeAdClickUrl returned " + string3);
                    str = string3;
                }
            } catch (JSONException e2) {
                Logger.d(d, "getNativeAdClickUrl not a native ad (" + e2.getMessage() + ")");
            }
        }
        return str;
    }

    private BrandSafetyUtils.AdType c(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has(ad) || !jSONObject.getJSONObject(ad).has(ae)) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(ad).getJSONObject(ae);
        if (!jSONObject2.has(af)) {
            return null;
        }
        JSONObject jSONObject3 = jSONObject2.getJSONObject(af);
        if (!jSONObject3.has(ag)) {
            return null;
        }
        String string = jSONObject3.getString(ag);
        Logger.d(d, "generate info - placementDimension = " + string);
        if (!string.contains("X")) {
            return null;
        }
        String[] strArrSplit = string.split("X");
        int i2 = Integer.parseInt(strArrSplit[0]);
        int i3 = Integer.parseInt(strArrSplit[1]);
        if (i2 != 0 && i3 != 0 && com.safedk.android.utils.n.a(i2, i3)) {
            BrandSafetyUtils.AdType adType = BrandSafetyUtils.AdType.BANNER;
            Logger.d(d, "generate info - adtype set to BANNER : placementDimension is " + string);
            return adType;
        }
        if (i2 == 0 || i3 == 0 || !com.safedk.android.utils.n.b(i2, i3)) {
            return null;
        }
        BrandSafetyUtils.AdType adType2 = BrandSafetyUtils.AdType.MREC;
        Logger.d(d, "generate info - adtype set to MREC : placementDimension is " + string);
        return adType2;
    }

    private List<CreativeInfo> a(String str, String str2, InMobiCreativeInfo inMobiCreativeInfo, String str3) {
        ArrayList<com.safedk.android.analytics.brandsafety.creatives.h.a> arrayListA;
        String strF;
        String strE;
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            arrayList.add(inMobiCreativeInfo);
            return arrayList;
        }
        BrandSafetyUtils.AdType adTypeM = inMobiCreativeInfo.M();
        String strF2 = com.safedk.android.utils.k.f(str2);
        if (!com.safedk.android.analytics.brandsafety.creatives.h.a(strF2)) {
            arrayListA = null;
        } else {
            arrayListA = com.safedk.android.analytics.brandsafety.creatives.h.a(strF2, true, com.safedk.android.utils.h.i);
            com.safedk.android.utils.n.b(d, "vast ad infos: " + (arrayListA != null ? arrayListA.toString() : "null"));
        }
        if (arrayListA != null && arrayListA.size() > 0 && !str3.startsWith("vast")) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "vast";
            } else {
                str3 = "vast/" + str3;
            }
        }
        Logger.d(d, "is prefetch multi ad? " + (inMobiCreativeInfo.ar() > 1 || M(strF2)));
        if (arrayListA == null || arrayListA.size() == 0) {
            Logger.d(d, "no vast info detected in prefetch");
            if (TextUtils.isEmpty(str3)) {
                str3 = "mraid";
                if (inMobiCreativeInfo.ar() > 1) {
                    str3 = "mraid" + CreativeInfo.aI + inMobiCreativeInfo.ar();
                }
            }
            if (inMobiCreativeInfo.O() == null && (strE = E(strF2)) != null) {
                inMobiCreativeInfo.a(strE, true);
            }
            if (inMobiCreativeInfo.p() == null && (strF = F(strF2)) != null) {
                inMobiCreativeInfo.q(strF);
            }
            arrayList.add(inMobiCreativeInfo);
        } else if (arrayListA.size() == 1) {
            Logger.d(d, "prefetch has vast info");
            a(inMobiCreativeInfo, arrayListA.get(0), str);
            if (inMobiCreativeInfo.ar() > 1) {
                str3 = str3 + CreativeInfo.aI + inMobiCreativeInfo.ar();
            }
            Logger.d(d, "downstream struct set to " + str3);
            inMobiCreativeInfo.c(true);
            arrayList.add(inMobiCreativeInfo);
        } else {
            Logger.d(d, "prefetch has multiple vast infos");
            str3 = str3 + CreativeInfo.aI + arrayListA.size() + CreativeInfo.aJ;
            for (com.safedk.android.analytics.brandsafety.creatives.h.a aVar : arrayListA) {
                InMobiCreativeInfo inMobiCreativeInfoAs = inMobiCreativeInfo.as();
                inMobiCreativeInfoAs.am();
                a(inMobiCreativeInfoAs, aVar, str);
                inMobiCreativeInfo.c(true);
                arrayList.add(inMobiCreativeInfoAs);
            }
        }
        if (str3.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str3 = str3.substring(0, str3.length() - 1);
        }
        Logger.d(d, "downstream struct set to " + str3);
        if (inMobiCreativeInfo.h() == null || str3.contains(inMobiCreativeInfo.h())) {
            inMobiCreativeInfo.e(str3);
        }
        ArrayList<String> arrayListF = com.safedk.android.utils.n.f(strF2);
        try {
            arrayListF.addAll(com.safedk.android.utils.n.f(str2));
        } catch (Exception e2) {
            Logger.d(d, "handlePubContent - could not extract urls from encoded pubContent: " + e2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((CreativeInfo) it.next()).b((List<String>) arrayListF);
        }
        if (inMobiCreativeInfo.M() != BrandSafetyUtils.AdType.NATIVE && arrayListF.size() > 0) {
            for (String str4 : arrayListF) {
                if (str4.contains(U)) {
                    Logger.d(d, "adding " + adTypeM.name().toLowerCase() + " ci with url as key (" + str4 + ")");
                    synchronized (aB) {
                        aB.put(str4, inMobiCreativeInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    private static List<String> c(CreativeInfo creativeInfo, String str) {
        Logger.d(d, "extracting urls");
        new ArrayList();
        ArrayList<String> arrayListF = com.safedk.android.utils.n.f(str);
        Logger.d(d, "prefetch resources list after impression beacons urls removal : " + arrayListF);
        creativeInfo.b((List<String>) arrayListF);
        return arrayListF;
    }

    private List<CreativeInfo> i(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str2)) {
                Logger.d(d, "generate info - InMobi vast proxy prefetch. vast ad tag proxy urls to follow: " + ax.toString());
                CreativeInfo creativeInfoRemove = null;
                if (ax.containsKey(str)) {
                    Logger.d(d, "vasts proxy redirect url found: " + str);
                    creativeInfoRemove = this.D.remove(ax.remove(str));
                }
                String strI = I(str);
                Logger.d(d, "decodedUrl : " + strI);
                if (creativeInfoRemove == null && ax.containsKey(strI)) {
                    Logger.d(d, "vasts proxy redirect url found: " + str);
                    com.safedk.android.analytics.brandsafety.creatives.i iVarRemove = ax.remove(strI);
                    synchronized (this.D) {
                        creativeInfoRemove = this.D.remove(iVarRemove);
                    }
                }
                if (creativeInfoRemove != null) {
                    com.safedk.android.utils.n.b(d, "found vast proxy url: " + str + ", ci: " + creativeInfoRemove + ", content: " + str2);
                    a(creativeInfoRemove, str, str2, true);
                    Logger.d(d, "vast processing was done in BaseDiscovery.");
                    arrayList.add(creativeInfoRemove);
                    return arrayList;
                }
            } else {
                Logger.d(d, "generate info - buffer value cannot be empty, skipping.");
            }
        } catch (Throwable th) {
            Logger.e(d, "generate info exception: " + th.getMessage(), th);
        }
        return arrayList;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected void a(String str, com.safedk.android.analytics.brandsafety.creatives.i iVar) {
        if (str != null) {
            String[] strArrSplit = str.split("://");
            if (strArrSplit.length == 2) {
                ax.put("http://vastproxy.brand.inmobi.com/g/" + strArrSplit[1], iVar);
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected synchronized void a(com.safedk.android.analytics.brandsafety.creatives.i iVar) {
        if (iVar != null) {
            Iterator<Map.Entry<String, com.safedk.android.analytics.brandsafety.creatives.i>> it = ax.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, com.safedk.android.analytics.brandsafety.creatives.i> next = it.next();
                if (next.getValue().equals(iVar)) {
                    Logger.d(d, "remove vast ad tag proxy uri from url to follow list: " + next.getValue());
                    it.remove();
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        Set<String> setC = super.c();
        setC.add("$TS");
        return setC;
    }

    private static String C(String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONArray jSONArrayOptJSONArray2 = new JSONObject(str).optJSONArray(i);
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0 && (jSONArrayOptJSONArray = jSONArrayOptJSONArray2.getJSONObject(0).optJSONArray("ads")) != null && jSONArrayOptJSONArray.length() > 0) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(0);
                String strOptString = jSONObject.optString("creativeId");
                String strOptString2 = jSONObject.optString(k);
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    String str2 = strOptString + "_" + strOptString2;
                    Logger.d(d, "get creative id json - found creative id= " + str2);
                    return str2;
                }
            }
        } catch (JSONException e2) {
            Logger.d(d, "get creative id json - exception: " + e2);
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        try {
            Logger.d(d, "match info ad instance: " + obj);
            if (obj == null) {
                Logger.d(d, "match info ad instance is null");
                return null;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if (com.safedk.android.utils.n.n(str)) {
                    String strC = C(str);
                    if (!TextUtils.isEmpty(strC)) {
                        Logger.d(d, "match info ad instance - updated ad instance key to= " + strC);
                        str = strC;
                    }
                }
                com.safedk.android.utils.n.b(d, "match info ad instance " + str + ", interstitial CIs map keys: " + az.keySet());
                if (az.containsKey(str)) {
                    CreativeInfo creativeInfo = az.get(str);
                    Logger.d(d, "match info ad instance - CI found by key " + str + ", ci = " + creativeInfo);
                    return creativeInfo;
                }
                com.safedk.android.utils.n.b(d, "match info ad instance " + str + ", banner CIs map keys: " + aA.keySet());
                if (aA.containsKey(str)) {
                    CreativeInfo creativeInfo2 = aA.get(str);
                    Logger.d(d, "match info ad instance - CI found by key: " + str + ", CI: " + creativeInfo2);
                    return creativeInfo2;
                }
                Logger.d(d, "match info ad instance - cannot find CI");
            }
            return null;
        } catch (Throwable th) {
            Logger.d(d, "exception in match info ad instance", th);
        }
    }

    private boolean K(String str) {
        return str.contains("requestId") && str.contains("placementId") && str.contains(i) && str.contains("creativeId");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public boolean b(String str, Bundle bundle) {
        String strZ = com.safedk.android.utils.n.z(str);
        boolean zContainsKey = ay.containsKey(strZ);
        if (zContainsKey && bundle != null) {
            bundle.putString(CreativeInfoManager.f8033a, POBCommonConstants.CONTENT_TYPE_HTML);
            bundle.putString(CreativeInfoManager.b, "UTF-8");
        }
        com.safedk.android.analytics.brandsafety.creatives.i iVar = new com.safedk.android.analytics.brandsafety.creatives.i(strZ);
        boolean z = this.D.containsKey(iVar) || com.safedk.android.analytics.brandsafety.creatives.h.c.contains(iVar) || ax.containsKey(strZ);
        if (strZ.contains("action=skip-btn-clicked")) {
            Logger.d(d, "video skipped event identified: " + strZ);
            CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.i, "view-click");
        }
        if (!strZ.contains(X) && !zContainsKey && !z) {
            return false;
        }
        Logger.d(d, "should follow input stream returned true for: " + strZ);
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        CreativeInfo creativeInfo;
        String strB = com.safedk.android.utils.k.b(str2);
        Logger.d(d, "get ad id from resource started, resource: " + str2 + ", resource key: " + strB + ", content size: " + str.length());
        CreativeInfo creativeInfo2 = aB.get(strB);
        if (creativeInfo2 != null) {
            com.safedk.android.utils.n.b(d, "get ad id from resource - CI identified, # of CIs: " + aB.size() + ", CI: " + creativeInfo2);
            return creativeInfo2.N();
        }
        String strRemove = aF.remove(str2);
        String str3 = "URL";
        if (strRemove == null) {
            String strReplaceAll = str.replaceAll("\\s+|\\\\n", "");
            Logger.d(d, "get ad id from resource started, content: " + strReplaceAll);
            strRemove = aF.remove(strReplaceAll);
            str3 = "CONTENT";
            if (strRemove == null && com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                aG.put(strReplaceAll, weakReference);
            }
        }
        String str4 = strRemove;
        if (str4 != null && (creativeInfo = this.H.get(str4)) != null) {
            Logger.d(d, "get ad id from resource - match found ad id using pubContent, ad id: " + str4);
            creativeInfo.t("MBPC:" + str3);
            return str4;
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean j(String str) {
        if (!str.contains(U)) {
            return false;
        }
        Logger.d(d, "should ignore redirect url - tracking url detected");
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        String strB = com.safedk.android.utils.k.b(str);
        if (!(str.contains(X) || aB.containsKey(strB))) {
            return false;
        }
        Logger.d(d, "should follow get url key: " + strB);
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    private String L(String str) {
        Map<String, String> mapA;
        String next = null;
        if (str != null && (mapA = com.safedk.android.utils.k.a(str, false)) != null && mapA.size() > 0) {
            Iterator<String> it = mapA.values().iterator();
            while (it.hasNext()) {
                next = it.next();
            }
        }
        return next;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(String str, String str2, String str3, String str4) {
        BrandSafetyEvent.AdFormatType adFormatType;
        CreativeInfo creativeInfo;
        if (str4.equals(BrandSafetyEvent.AdFormatType.APPOPEN.name())) {
            Logger.d(d, "ignoring creative info details from Max, adFormat = " + str4 + ", creativeId = " + str2 + ", placementId = " + str);
            return;
        }
        if (str2 != null && str3 != null) {
            if (str4.equals(BrandSafetyUtils.j)) {
                CreativeInfo creativeInfo2 = az.get(str2);
                adFormatType = BrandSafetyEvent.AdFormatType.INTER;
                creativeInfo = creativeInfo2;
            } else if (str4.equals(BrandSafetyUtils.k)) {
                CreativeInfo creativeInfo3 = az.get(str2);
                adFormatType = BrandSafetyEvent.AdFormatType.REWARD;
                creativeInfo = creativeInfo3;
            } else if (str4.equals("BANNER") || str4.equals(BrandSafetyUtils.n)) {
                CreativeInfo creativeInfo4 = aA.get(str + "_" + str3 + "_" + com.safedk.android.utils.h.i);
                adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
                creativeInfo = creativeInfo4;
            } else if (str4.equals(BrandSafetyUtils.o)) {
                CreativeInfo creativeInfo5 = aA.get(str + "_" + str3 + "_" + com.safedk.android.utils.h.i);
                adFormatType = BrandSafetyEvent.AdFormatType.MREC;
                creativeInfo = creativeInfo5;
            } else {
                adFormatType = null;
                creativeInfo = null;
            }
            if (adFormatType != null && creativeInfo != null) {
                creativeInfo.a(adFormatType);
                Logger.d(d, "update CI details from Max, creative id: " + str2 + ", ID: " + creativeInfo.N() + ", placement id: " + creativeInfo.H() + ", ad format type: " + adFormatType);
            } else {
                Logger.d(d, "failed to update CI details from Max, creative id: " + str2 + ", ad format: " + str4 + ", ad format type: " + adFormatType + ", CI: " + creativeInfo);
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean g(String str) {
        if (!str.contains(X)) {
            return false;
        }
        Logger.d(d, "should follow output stream returned true for url " + str);
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String e(String str, String str2) {
        String strD;
        String strD2;
        Logger.d(d, "handle on request sent url: " + str + ", content: " + str2);
        String strD3 = com.safedk.android.utils.k.d(str + "?" + str2, aa);
        if (strD3 != null && (strD = com.safedk.android.utils.k.d(str + "?" + str2, ab)) != null) {
            if (strD.equals("banner") && (strD2 = com.safedk.android.utils.k.d(str + "?" + str2, Z)) != null && strD2.contains(VastAttributes.HORIZONTAL_POSITION)) {
                String[] strArrSplit = strD2.split(VastAttributes.HORIZONTAL_POSITION);
                int i2 = Integer.parseInt(strArrSplit[0]);
                int i3 = Integer.parseInt(strArrSplit[1]);
                if (i2 != 0 && i3 != 0 && com.safedk.android.utils.n.b(i2, i3)) {
                    strD = "mrec";
                    Logger.d(d, "handle on request sent - adtype is MREC : mkAdSlot is " + strD2);
                }
            }
            Logger.d(d, "adding to placement id to ad type list - size: " + aD.size() + ", placement id: " + strD3 + ", ad type: " + strD);
            aD.put(strD3, strD);
            return null;
        }
        return null;
    }

    private boolean M(String str) {
        List<String> listA = com.safedk.android.utils.n.a(com.safedk.android.utils.g.M(), str);
        List<String> listA2 = com.safedk.android.utils.n.a(com.safedk.android.utils.g.L(), str);
        if (listA == null || listA.size() <= 1) {
            return listA2 != null && listA2.size() > 1;
        }
        return true;
    }

    private void d(CreativeInfo creativeInfo, String str) {
        List<String> listA = com.safedk.android.utils.n.a(com.safedk.android.utils.g.K(), str);
        if (listA != null && listA.size() > 1) {
            for (String str2 : listA) {
                Logger.d(d, "adding vast clause " + str2 + " to ci debug info");
                creativeInfo.t(str2);
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<String> e() {
        List<String> listE = super.e();
        listE.add(au);
        return listE;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(Bundle bundle) {
        int i2;
        if (bundle == null || (i2 = bundle.getInt(av)) <= 0) {
            return null;
        }
        String hexString = Integer.toHexString(i2);
        Logger.d(d, "found expanded ad webview address in intent extra: " + hexString);
        return hexString;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void c(View view) {
        a(view, "onClick");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void d(View view) {
        a(view, "onSource");
    }

    public static void a(View view, String str) {
        List<CreativeInfo> listA;
        Logger.d(d, "redirect potential source: " + view);
        com.safedk.android.analytics.brandsafety.a aVarA = null;
        if (com.safedk.android.utils.n.a(view.getWidth(), view.getHeight())) {
            aVarA = SafeDK.getInstance().a(BrandSafetyUtils.AdType.BANNER);
        } else if (com.safedk.android.utils.n.b(view.getWidth(), view.getHeight())) {
            aVarA = SafeDK.getInstance().a(BrandSafetyUtils.AdType.MREC);
        }
        if (aVarA != null && (listA = aVarA.a(com.safedk.android.utils.h.i, BrandSafetyUtils.a(view))) != null) {
            Iterator<CreativeInfo> it = listA.iterator();
            while (it.hasNext()) {
                it.next().t("redirectPotentialSource=" + str + ",view=" + view);
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        if (!super.e(view) && !view.getClass().getName().startsWith("com.inmobi.media")) {
            return false;
        }
        Logger.d(d, "is ad view: " + view.getClass().getName());
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String j() {
        return com.safedk.android.utils.h.i;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(BrandSafetyUtils.AdType adType, Object obj, String str) {
        if (obj instanceof JSONObject) {
            String strOptString = ((JSONObject) obj).optString(m);
            if (!strOptString.isEmpty()) {
                String strA = BrandSafetyUtils.a(strOptString.replace("\\/", RemoteSettings.FORWARD_SLASH_STRING).getBytes());
                String strRemove = aC.remove(strA);
                if (strRemove != null) {
                    Logger.d(d, "extract ad info impl - get interstitial CI. # of cis is " + aC.size() + ", content hash: " + strA + ", id: " + strRemove);
                    return strRemove;
                }
                Logger.d(d, "extract ad info impl - failed to get interstitial CI. # of cis is " + aC.size() + ", content hash: " + strA);
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean m(String str) {
        String str2 = null;
        synchronized (aF) {
            for (String str3 : aF.keySet()) {
                String str4 = aF.get(str3);
                if (str4 == null || !str4.equals(str) || com.safedk.android.utils.n.a((Object) str2)) {
                    str3 = str2;
                } else {
                    Logger.d(d, "try reverse matching: found content for ad id: " + str + ", content: " + str3);
                }
                str2 = str3;
            }
        }
        if (str2 != null) {
            WeakReference<WebView> weakReference = aG.get(str2);
            if (!com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                Logger.d(d, "try reverse matching: webViewRef is null or points to null - webviewRef: " + weakReference);
                return false;
            }
            List<CreativeInfo> listA = a(weakReference.get(), str);
            if (!listA.isEmpty()) {
                Logger.d(d, "try reverse matching: found a match using reverse! adId=" + str);
                Iterator<CreativeInfo> it = listA.iterator();
                while (it.hasNext()) {
                    it.next().t("MBPC:CONTENT");
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void n(String str) {
        String strRemove = aF.remove(str);
        Logger.d(d, "clean resources started with ad id: " + str + ", and source is: " + strRemove);
        if (strRemove != null) {
            aG.remove(strRemove);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
        com.safedk.android.utils.e.a(az, "InMobiDiscovery:creativeToIdMap");
        com.safedk.android.utils.e.a(aA, "InMobiDiscovery:bannerCreativeToIdMap");
        com.safedk.android.utils.e.a(aB, "InMobiDiscovery:creativeToUrlMap");
        com.safedk.android.utils.e.a(ay, "InMobiDiscovery:pubContentUrlsToFollow");
    }
}
