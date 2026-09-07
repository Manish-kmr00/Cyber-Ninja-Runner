package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.out.MBConfiguration;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.MintegralCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.PersistentConcurrentHashMap;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class k extends d {
    private static final String c = "MintegralDiscovery";
    private static final String i = "http";
    private static final String j = "mof_data";
    private static final String k = "crt_rid";
    private static final String l = "impressionURL";
    private static final String m = "(function(){var sdkId=\"{{SDK_ID}}\";var address=\"{{ADDRESS}}\";var log=function(message){try{if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(message)}else{console.log(\"SafeDKWebApInterface safedkDebug object missing\")}}catch(error){}};var lookForPrivacyPolicy=function(){try{var isPrivacyPolicy=document.getElementsByClassName(\"g-dialog-contianer\").length>0;if(isPrivacyPolicy){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}};lookForPrivacyPolicy();try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){for(var i=0;i<mutation.addedNodes.length;i++){var node=mutation.addedNodes[i];if(node&&node.nodeName!=\"#text\"){lookForPrivacyPolicy()}}})});var config={childList:true,subtree:true};observer.observe(document,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}})();\n";
    private static Map<String, CreativeInfo> n;
    private static final String d = ".rayjump.com/openapi/ad";
    private static final String e = ".rayjump.com/load";
    private static final String f = "mtgglobals.com/load";
    private static final String g = "mtgglobals.com/openapi/ad/v3";
    private static final List<String> h = Arrays.asList(d, e, f, g, l.i, l.j, l.k);
    private static final Set<String> o = new HashSet();
    public static final Map<String, c.a> b = new HashMap();

    private void h() {
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BIDDING_INTERSTITIAL_IMPRESSION_MATCHING_BY_MAX, true);
        this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, true);
        this.C.b(AdNetworkConfiguration.SHOULD_REPORT_AD_ID_ON_CI_CREATION, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_IGNORE_BANNER_MULTI_AD_DID_CLICK_EVENT, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.SET_AD_FORMAT_FROM_APPLOVIN_BUNDLE, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_FULLSCREEN_ADS, true);
        this.C.b(AdNetworkConfiguration.JS_PRIVACY_BUTTON_CLICK_DETECTION_SCRIPT, m);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, true);
    }

    private void k() {
        try {
            if (CreativeInfoManager.l) {
                n = new ConcurrentHashMap();
            } else {
                n = new PersistentConcurrentHashMap("MintegralDiscovery_kToCInfo");
                Logger.d(c, "generate collections - k to Ci info loaded, keyset=" + n.keySet());
            }
        } catch (InvalidParameterException e2) {
            Logger.e(c, "generate collections - error initializing caching will not be available", e2);
        }
    }

    public k() {
        super(com.safedk.android.utils.h.o, c);
        h();
        k();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        JSONObject jSONObject;
        com.safedk.android.utils.n.b(c, "generate info - started, url: " + str + ", maxParams = " + aVar + ", buffer size: " + (str2 == null ? "0" : Integer.valueOf(str2.length())));
        try {
            jSONObject = new JSONObject(str2);
        } catch (JSONException e2) {
            Logger.d(c, "generate info - not a valid JSON string: " + e2.getMessage());
            jSONObject = null;
        } catch (Throwable th) {
            Logger.d(c, "generate info - not a valid JSON string: " + th.getMessage(), th);
            jSONObject = null;
        }
        if (jSONObject == null) {
            if (aVar != null) {
                Logger.d(c, "generate info - saving max params of native ad. token id= " + str2 + ",     max params= " + aVar);
                b.put(str2, aVar);
            }
            Logger.d(c, "generate info - obj is null, skipping.");
            return null;
        }
        int i2 = jSONObject.getInt("status");
        if (i2 != 1) {
            Logger.d(c, "generate info - status is not okay, skipping. status= " + i2);
            return null;
        }
        if (!jSONObject.has("data")) {
            Logger.d(c, "generate info - JSON object does not contain a 'data' key. this is not s prefetch");
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (!a(jSONObject2) && !b(str, jSONObject2)) {
            Logger.d(c, "generate info - invalid ad type= " + l.d(jSONObject2));
            return null;
        }
        if (l.a(jSONObject2)) {
            Logger.d(c, "generate info - data object is complementary prefetch");
            a(str, jSONObject2);
            return null;
        }
        List<CreativeInfo> listA = l.a(jSONObject2, (CreativeInfo) null, this.G, b.get(str));
        a(listA);
        a(str, listA);
        return listA;
    }

    private void a(List<CreativeInfo> list) {
        for (CreativeInfo creativeInfo : list) {
            if (creativeInfo instanceof MintegralCreativeInfo) {
                MintegralCreativeInfo mintegralCreativeInfo = (MintegralCreativeInfo) creativeInfo;
                synchronized (n) {
                    n.put(mintegralCreativeInfo.aq(), creativeInfo);
                }
                Logger.d(c, "save creative info - adding CI to k map, key: " + mintegralCreativeInfo.aq() + ", new map size: " + n.size());
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0116 -> B:28:0x0117). Please report as a decompilation issue!!! */
    private void a(String str, JSONObject jSONObject) {
        Throwable th;
        Throwable th2;
        if (o.contains(str)) {
            Logger.d(c, "handle complementary prefetch - url already handled= " + str);
            return;
        }
        Logger.d(c, "handle complementary prefetch - started, url= " + str);
        CreativeInfo creativeInfo = null;
        try {
            String strD = com.safedk.android.utils.k.d(str, j);
            Logger.d(c, "handle complementary prefetch - " + strD);
            if (strD != null) {
                String string = new JSONObject(strD).getString(k);
                Logger.d(c, "handle complementary prefetch - recommendation request ID= " + string);
                if (!TextUtils.isEmpty(string)) {
                    synchronized (n) {
                        try {
                            CreativeInfo creativeInfoRemove = n.remove(string);
                            try {
                                if (creativeInfoRemove != null) {
                                    try {
                                        Logger.d(c, "handle complementary prefetch - ci found by request ID= " + creativeInfoRemove.aa());
                                        if (l.c(jSONObject)) {
                                            Logger.d(c, "handle complementary prefetch - ads data is recommendation, calling handleRecommendationsPrefetch");
                                            l.a(creativeInfoRemove, jSONObject);
                                        } else if (creativeInfoRemove.M() == BrandSafetyUtils.AdType.INTERSTITIAL) {
                                            Logger.d(c, "handle complementary prefetch - ads data is two or less, ad type is fullscreen, calling handleRecommendationsPrefetch");
                                            l.b(creativeInfoRemove, jSONObject);
                                        } else {
                                            Logger.d(c, "handle complementary prefetch - ads data is second (multi) ad, calling handleSecondMultiAd");
                                            l.c(creativeInfoRemove, jSONObject);
                                        }
                                        o.add(str);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        creativeInfo = creativeInfoRemove;
                                        Logger.d(c, "handle complementary prefetch - exception= " + th.getMessage(), th);
                                        if (creativeInfo != null) {
                                            creativeInfo.t("rec_ex(" + com.safedk.android.utils.n.e() + "):" + th.getMessage() + com.safedk.android.analytics.brandsafety.l.ad);
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                throw th2;
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                        }
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static boolean a(JSONObject jSONObject) {
        int iD = l.d(jSONObject);
        boolean z = iD == 287 || iD == 94 || iD == 296 || iD == 295;
        Logger.d(c, "is supported ad type - returning= " + z);
        return z;
    }

    private static boolean b(String str, JSONObject jSONObject) {
        return l.d(jSONObject) == 42 && b.containsKey(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        CreativeInfo creativeInfo;
        Logger.d(c, "match info - started. ad instance= " + obj);
        if (obj == null) {
            Logger.d(c, "match info - ad instance is null, returning.");
            return null;
        }
        String str = (String) obj;
        synchronized (this.H) {
            creativeInfo = this.H.get(str);
        }
        return creativeInfo;
    }

    public static String B(String str) {
        l.a aVarD = l.d(str);
        if (aVarD == null) {
            return null;
        }
        return l.a(aVarD);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String b(Object obj) {
        int iIdentityHashCode = System.identityHashCode(obj);
        Logger.d(c, "get creative info after media player start call - player id= " + iIdentityHashCode);
        return c((String) null, String.valueOf(iIdentityHashCode));
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String c(String str, String str2) {
        Logger.d(c, "get ad id from resource - started, value: " + str + ", ad ID:" + str2);
        if (str2 == null || str2.startsWith("http")) {
            return null;
        }
        return str2;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        if (!super.e(view) && !view.getClass().getName().startsWith(MBConfiguration.LOG_TAG)) {
            return false;
        }
        Logger.d(c, "is ad view: " + view.getClass().getName() + " is a Mintegral ad content view");
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String j() {
        return MBConfiguration.LOG_TAG;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(BrandSafetyUtils.AdType adType, Object obj, String str) {
        if ((obj instanceof String) && str.equals(l)) {
            String string = obj.toString();
            Logger.d(c, "extract ad info - impression url: " + string);
            String strB = B(string);
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return null;
    }

    private static boolean C(String str) {
        boolean z;
        Iterator<String> it = h.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                z = true;
                Logger.d(c, "should follow url - returning= " + z + ", url= " + str);
                return z;
            }
        }
        z = false;
        Logger.d(c, "should follow url - returning= " + z + ", url= " + str);
        return z;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        boolean zC = C(str);
        Logger.d(c, "should follow get url impl - returning= " + zC + ", url= " + str);
        return zC;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        boolean zC = C(str);
        Logger.d(c, "should follow input stream impl - returning= " + zC + ", url= " + str);
        return zC;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        return new HashSet();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        Logger.d(c, "get webView resource matching method - returning= " + AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP);
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean j(String str) {
        Logger.d(c, "should ignore redirect url - ignoring redirect url: " + str);
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
        com.safedk.android.utils.e.a(n, "MintegralDiscovery:kToCInfo");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void e(String str) {
        if (str.contains("\"status\"") && str.contains("\"ad_type\"")) {
            CreativeInfoManager.a(this.Q, "@!1:ad_fetch@!", str, (Map<String, List<String>>) null);
        }
    }

    public static void a(Object obj, JSONObject jSONObject) {
        String strD = d(obj);
        Logger.d(c, "on mintegral native controller - token id found= " + strD);
        if (!TextUtils.isEmpty(strD)) {
            CreativeInfoManager.a(com.safedk.android.utils.h.o, strD, jSONObject.toString(), (Map<String, List<String>>) null);
        }
    }

    private static String d(Object obj) {
        if (obj != null && obj.getClass().getSuperclass() != null) {
            for (Field field : obj.getClass().getSuperclass().getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    Object obj2 = field.get(obj);
                    if (obj2 instanceof String) {
                        return (String) obj2;
                    }
                    continue;
                } catch (Exception e2) {
                    Logger.d(c, "get token id from controller - exception= " + e2);
                }
            }
        }
        return null;
    }

    private static void a(String str, List<CreativeInfo> list) {
        c.a aVarRemove = b.remove(str);
        Logger.d(c, "handle native ci - max param found= " + aVarRemove);
        if (aVarRemove != null) {
            for (CreativeInfo creativeInfo : list) {
                creativeInfo.h(aVarRemove.f8068a);
                creativeInfo.j(aVarRemove.c);
                if (aVarRemove.b == BrandSafetyEvent.AdFormatType.NATIVE) {
                    creativeInfo.r(str);
                }
            }
        }
    }
}
