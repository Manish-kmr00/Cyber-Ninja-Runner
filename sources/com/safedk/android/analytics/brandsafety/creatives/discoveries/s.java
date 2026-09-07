package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.RedirectDetails;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.VerveCreativeInfo;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class s extends d {
    private static final String R = "(function(){var sdkId=\"{{SDK_ID}}\";var address=\"{{ADDRESS}}\";var log=function(message){try{console.log(\"message from verve privacy policy detector: \"+message);if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(message)}else{console.log(\"SafeDKWebApInterface safedkDebug object missing\")}}catch(error){}};var addObservers=function(){try{var dialogBoxElement=document.getElementById(\"survey_menu\");log(dialogBoxElement);if(dialogBoxElement){var allTextElements=dialogBoxElement.getElementsByTagName(\"text\");for(var textElement of allTextElements){var textContent=textElement.textContent;log(\"text content: \"+textContent);if(textContent){if(textContent.includes(\"Data Privacy Notice\")){var privacyTextParentElement=textElement.parentElement;if(privacyTextParentElement){var computedStyle=getComputedStyle(privacyTextParentElement);if(computedStyle){var displayState=computedStyle.display;if(displayState!=\"none\"){log(\"requesting no sampling\");if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}else{if(privacyTextParentElement.safedkPrivacyDialogObserver!=true){privacyTextParentElement.safedkPrivacyDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){switch(mutation.type){case\"attributes\":if(mutation.target.style.display!=\"none\"){log(\"requesting no sampling\");if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}log(\"verve privacy : Attribute name \"+mutation.attributeName+\" changed to \"+getComputedStyle(mutation.target).visibility+\" (was \"+mutation.oldValue+\")\");break}})});var config={attributes:true,attributeOldValue:true,attributeFilter:[\"style\"]};observer.observe(privacyTextParentElement,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}}}}}break}}}}else{log(\"verve privacy : no element to wrap\")}}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}};addObservers();try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){for(var i=0;i<mutation.addedNodes.length;i++){var node=mutation.addedNodes[i];if(node&&node.nodeName!=\"#text\"){addObservers()}}})});var config={childList:true,subtree:true};observer.observe(document,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}})();\n";
    private static final int S = 20;
    private static final int V = 80;
    private static final int Z = 5;
    private static final String b = "VerveDiscovery";
    private static final String c = "admurl";
    private static final String d = "ads";
    private static final String e = "assets";
    private static final String f = "type";
    private static final String g = "beacons";
    private static final String h = "data";
    private static final String i = "vast";
    private static final String j = "html";
    private static final String k = "crid";
    private static final String l = "impID";
    private static final String m = "dspName";
    private static final String n = "net.pubnative.lite.sdk.mraid";
    private static final String o = "mraid://open";
    private static final String p = "url";
    private static final String q = "mraid://expand";
    private static final ConcurrentHashMap<String, String> T = new LimitedConcurrentHashMap(20);
    private static final ConcurrentHashMap<String, String> U = new LimitedConcurrentHashMap(20);
    private static final ConcurrentHashMap<String, String> W = new LimitedConcurrentHashMap(80);
    private static final ConcurrentHashMap<String, String> X = new LimitedConcurrentHashMap(80);
    private static final ConcurrentHashMap<String, String> Y = new LimitedConcurrentHashMap(80);
    private static final ConcurrentHashMap<String, WeakReference<WebView>> aa = new LimitedConcurrentHashMap(5);
    private static final ConcurrentHashMap<String, WeakReference<Object>> ab = new LimitedConcurrentHashMap(5);

    public s() {
        super(com.safedk.android.utils.h.C, b);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE, true);
        this.C.b(AdNetworkConfiguration.SHOULD_GET_HTML_TEXT_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true);
    }

    private void a(String str, c.a aVar) {
        JSONObject jSONObject;
        String strOptString;
        String str2 = null;
        try {
            jSONObject = new JSONObject(str);
            try {
                strOptString = jSONObject.optString(c);
                try {
                    if (strOptString.isEmpty()) {
                        Logger.d(b, "generate info - does not contain ad url param, exiting");
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    str2 = strOptString;
                    Logger.d(b, "generate info - not a valid JSON string: " + th.getMessage(), th);
                    strOptString = str2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            jSONObject = null;
        }
        if (jSONObject == null || TextUtils.isEmpty(strOptString)) {
            Logger.d(b, "generate info - obj is null or ad url is empty, ad url: " + strOptString + " skipping.");
            return;
        }
        Logger.d(b, "generate info - obj= " + jSONObject);
        VerveCreativeInfo verveCreativeInfo = new VerveCreativeInfo(BrandSafetyUtils.a(aVar.b), strOptString, aVar.d, null, null, aVar.b, aVar.c, this.G, null, "", aVar.f8068a, null, false, false);
        synchronized (this.H) {
            this.H.put(strOptString, verveCreativeInfo);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected com.safedk.android.analytics.brandsafety.creatives.h.a a(CreativeInfo creativeInfo, String str, String str2, boolean z) {
        com.safedk.android.analytics.brandsafety.creatives.h.a aVarA = super.a(creativeInfo, str, str2, z);
        if (aVarA != null && creativeInfo.B()) {
            String strC = aVarA.c();
            Logger.d(b, "found inner vast ad id: " + strC + " setting in CI if not null");
            if (strC != null) {
                ((VerveCreativeInfo) creativeInfo).a(strC);
            }
            List<String> listI = aVarA.i();
            if (!com.safedk.android.utils.n.a((Collection<?>) listI)) {
                com.safedk.android.utils.n.b(b, "vast impression url to add: " + listI.get(listI.size() - 1));
                ((VerveCreativeInfo) creativeInfo).H(listI.get(listI.size() - 1));
            } else {
                Logger.d(b, "vast impression url - empty");
            }
        }
        return aVarA;
    }

    private void c(CreativeInfo creativeInfo, String str) {
        if (a(creativeInfo, (String) null, str, true) != null) {
            Logger.d(b, "handle vast in prefetch: before - " + creativeInfo.h());
            if (creativeInfo.h() == null || !creativeInfo.h().contains("vast")) {
                creativeInfo.a("vast", RemoteSettings.FORWARD_SLASH_STRING);
            }
            Logger.d(b, "handle vast in prefetch: after - " + creativeInfo.h());
            if (!TextUtils.isEmpty(creativeInfo.Q())) {
                Logger.d(b, "generate info - adding vast id: " + creativeInfo.Q() + " with ad id: " + creativeInfo.N());
                X.put(creativeInfo.Q(), creativeInfo.N());
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        String strReplaceAll;
        Logger.d(b, "generate info - started, url= " + (com.safedk.android.utils.n.a((Object) str) ? str : "content"));
        if (aVar != null) {
            Logger.d(b, "max params are: " + aVar);
            a(str2, aVar);
            return new ArrayList();
        }
        CreativeInfo creativeInfo = this.H.get(str);
        if (creativeInfo == null) {
            Logger.d(b, "generate info - no mediate prefetch received for the following url");
            return new ArrayList();
        }
        com.safedk.android.utils.n.b(b, "generate info - buffer size: " + (str2 == null ? "0" : Integer.valueOf(str2.length())) + "requestHeaders: " + map);
        Logger.d(b, "generate info - filling parameters for ci with id: " + creativeInfo.N() + " ad type: " + creativeInfo.M() + " ad format: " + creativeInfo.K());
        Logger.d(b, "generate info - ci placement id: " + creativeInfo.H() + " creative id: " + creativeInfo.P() + " event id: " + creativeInfo.n());
        ArrayList arrayList = new ArrayList();
        arrayList.add(creativeInfo);
        try {
            JSONArray jSONArray = new JSONObject(str2).getJSONArray("ads");
            Logger.d(b, "generate info - started iterating " + jSONArray.length() + " ads");
            String str3 = null;
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                JSONArray jSONArray2 = jSONObjectOptJSONObject.getJSONArray("assets");
                JSONObject jSONObject = jSONArray2.getJSONObject(0);
                String string = jSONObject.getString("type");
                Logger.d(b, "generate info - first asset is: " + jSONObject + " and content type is: " + string);
                JSONObject jSONObject2 = jSONObject.has("data") ? jSONObject.getJSONObject("data") : null;
                if (string.startsWith("vast")) {
                    Logger.d(b, "generate info - found vast prefetch: data - " + jSONObject2);
                    if (jSONObject2 == null || !jSONObject2.has(string)) {
                        strReplaceAll = str3;
                    } else {
                        String string2 = jSONObject2.getString(string);
                        creativeInfo.e(string);
                        c(creativeInfo, string2);
                        strReplaceAll = str3;
                    }
                } else {
                    if (string.startsWith("html")) {
                        creativeInfo.e(string + RemoteSettings.FORWARD_SLASH_STRING + "mraid");
                        Logger.d(b, "generate info - found html prefetch: data - " + jSONObject2);
                        if (jSONObject2 != null && jSONObject2.has("html")) {
                            String string3 = jSONObject2.getString("html");
                            if (com.safedk.android.analytics.brandsafety.creatives.h.a(string3)) {
                                c(creativeInfo, string3);
                            }
                            String strF = com.safedk.android.utils.k.f(string3);
                            com.safedk.android.utils.n.b(b, "generate info - found html content: " + strF);
                            String strReplace = string3.replace("\\\"", "\"");
                            String strB = b(strReplace, creativeInfo, "generateInfoImp");
                            String strSubstring = strB != null ? strB.substring(strB.indexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1) : null;
                            if (strB != null) {
                                if (strSubstring.equals(creativeInfo.P())) {
                                    synchronized (W) {
                                        if (W.containsKey(strB)) {
                                            Logger.d(b, "generate info - impIdToAdId map already contains: " + strB);
                                        }
                                        W.put(strB, creativeInfo.N());
                                        ((VerveCreativeInfo) creativeInfo).I(strB);
                                    }
                                } else {
                                    Logger.d(b, "generate info - found creative id: " + strSubstring + " different than CI's creative id: " + creativeInfo.P());
                                }
                            } else {
                                Logger.d(b, "generate info - did not find impId with crid");
                            }
                            b(strReplace, creativeInfo);
                            d(creativeInfo, strF);
                            creativeInfo.b((List<String>) com.safedk.android.utils.n.f(strF));
                            strReplaceAll = strF.replaceAll("\\s+|\\r|\\\\n", "");
                        }
                    } else {
                        Logger.d(b, "generate info - found unrecognized prefetch with content type: " + string);
                    }
                    strReplaceAll = str3;
                }
                int length = jSONObjectOptJSONObject.getJSONArray("assets").length();
                Logger.d(b, "generate info - found assets count: " + length);
                for (int i3 = 1; i3 < length; i3++) {
                    JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                    if (jSONObject3.has("type")) {
                        creativeInfo.a(jSONObject3.getString("type"), RemoteSettings.FORWARD_SLASH_STRING);
                    }
                }
                int length2 = jSONObjectOptJSONObject.has(g) ? jSONObjectOptJSONObject.getJSONArray(g).length() : 0;
                Logger.d(b, "generate info - found " + length2 + " beacons");
                JSONArray jSONArray3 = length2 > 0 ? jSONObjectOptJSONObject.getJSONArray(g) : null;
                for (int i4 = 0; i4 < length2; i4++) {
                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i4);
                    if (jSONObject4.has("data")) {
                        Iterator<String> it = com.safedk.android.utils.n.f(com.safedk.android.utils.k.f(jSONObject4.getString("data"))).iterator();
                        while (it.hasNext()) {
                            creativeInfo.v(it.next());
                        }
                    }
                }
                synchronized (aa) {
                    if (string.startsWith("html") && strReplaceAll != null) {
                        Logger.d(b, "generate info - adding ad id: " + creativeInfo.N() + " to ad id to prefetch content map");
                        T.put(creativeInfo.N(), strReplaceAll);
                        List<String> listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.F(), strReplaceAll, 1, false);
                        if (!listA.isEmpty()) {
                            String str4 = listA.get(0);
                            Logger.d(b, "generate info - adding ad id: " + creativeInfo.N() + " to html body to id. body resource= " + str4);
                            U.put(str4, creativeInfo.N());
                        }
                    }
                    String strJ = creativeInfo.J();
                    if (strJ != null) {
                        Logger.d(b, "generate info - video url is: " + strJ);
                        creativeInfo.f(true);
                        synchronized (Y) {
                            try {
                                if (Y.containsKey(strJ)) {
                                    Logger.d(b, "generate info - found video url that appeared more than once, not entering");
                                    Y.remove(strJ);
                                } else {
                                    Y.put(strJ, creativeInfo.N());
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                }
                i2++;
                str3 = strReplaceAll;
            }
        } catch (Throwable th2) {
            Logger.d(b, "generate info - not a valid JSON string: " + th2.getMessage(), th2);
        }
        return arrayList;
    }

    private String a(String str, CreativeInfo creativeInfo, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            if (creativeInfo != null && jSONObject.has(m)) {
                String strOptString = jSONObject.optString(m);
                if (!TextUtils.isEmpty(strOptString)) {
                    Logger.d(b, "extract json data - found buyer id - " + strOptString + " for ad id: " + creativeInfo.N());
                    creativeInfo.m(strOptString);
                }
            }
            if (jSONObject.has(k) && jSONObject.has(l)) {
                String string = jSONObject.getString(k);
                String string2 = jSONObject.getString(l);
                Logger.d(b, "extract json data - found json with creative id: " + string + " and impId: " + string2 + " origin method: " + str2);
                return string2 + RemoteSettings.FORWARD_SLASH_STRING + string;
            }
        } catch (Throwable th) {
            Logger.d(b, "extract json data - exception: ", th);
        }
        Logger.d(b, "extract json data - did not find creative id or impId origin method: " + str2);
        return null;
    }

    private String b(String str, CreativeInfo creativeInfo, String str2) {
        Matcher matcher = com.safedk.android.utils.g.ba().matcher(str);
        if (matcher.find() && matcher.groupCount() >= 1) {
            String strL = com.safedk.android.utils.k.l(matcher.group(1));
            com.safedk.android.utils.n.b(b, "extract base64 json - found content: " + strL);
            return a(strL, creativeInfo, str2);
        }
        Matcher matcher2 = com.safedk.android.utils.g.bb().matcher(str);
        if (matcher2.find() && matcher2.groupCount() >= 1) {
            String strGroup = matcher2.group(1);
            com.safedk.android.utils.n.b(b, "extract regular json - found content: " + strGroup);
            return a(strGroup, creativeInfo, str2);
        }
        return null;
    }

    private void d(CreativeInfo creativeInfo, String str) {
        String strE;
        if (creativeInfo.O() == null && (strE = E(str)) != null) {
            Logger.d(b, "set Click Url From Dsp - found " + strE);
            creativeInfo.a(strE, true);
        }
    }

    private void b(String str, CreativeInfo creativeInfo) {
        try {
            Matcher matcher = com.safedk.android.utils.g.aZ().matcher(str);
            if (matcher.find() && matcher.groupCount() >= 1) {
                String strL = com.safedk.android.utils.k.l(matcher.group(1));
                com.safedk.android.utils.n.b(b, "find encoded html in prefetch data - found content: " + strL);
                String strF = com.safedk.android.utils.k.f(strL);
                creativeInfo.b((List<String>) com.safedk.android.utils.n.f(strF));
                d(creativeInfo, strF);
                if (com.safedk.android.analytics.brandsafety.creatives.h.a(strF)) {
                    c(creativeInfo, strF);
                }
            }
        } catch (Throwable th) {
            Logger.d(b, "exception occurred while trying to encode html section: ", th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        boolean z = str != null && this.H.containsKey(str);
        Logger.d(b, "should follow input stream for url: " + str + " result is: " + z);
        return z;
    }

    private String B(String str) {
        Logger.d(b, "find inner ad content, webview resource prefix value: " + str.substring(0, Math.min(500, str.length())));
        synchronized (T) {
            for (String str2 : T.keySet()) {
                String str3 = T.get(str2);
                if (str3 != null) {
                    Logger.d(b, "find inner ad content, prefetch content prefix is:    " + str3.substring(0, Math.min(500, str3.length())));
                    if (str.contains(str3)) {
                        Logger.d(b, "found inner ad content where the data loaded contains the prefetch html, is equal? " + str.equals(str3));
                        return str2;
                    }
                    if (str3.contains(str)) {
                        Logger.d(b, "found inner ad content where the prefetch html contains the data loaded");
                        return str2;
                    }
                }
            }
            Logger.d(b, "find inner ad content, did not find any adId for the webview - ad id to prefetch map keys: " + T.keySet());
            List<String> listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.F(), str, 1, false);
            if (!listA.isEmpty()) {
                String str4 = U.get(listA.get(listA.size() - 1));
                if (!TextUtils.isEmpty(str4)) {
                    Logger.d(b, "find inner ad content, found the data loaded html body equals to the prefetch html body. ad id= " + str4);
                    return str4;
                }
            }
            return null;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        if (str == null) {
            return null;
        }
        synchronized (aa) {
            Logger.d(b, "get ad id from resource started - webview: " + (weakReference != null ? weakReference.get() : null));
            String strReplaceAll = com.safedk.android.utils.k.f(str).replaceAll("\\s+|\\r|\\\\n", "");
            String strB = B(strReplaceAll);
            if (strB != null && this.H.containsKey(strB)) {
                Logger.d(b, "get ad id from resource - matching found via inner prefetch, adId=" + strB);
                return strB;
            }
            String strB2 = b(strReplaceAll, (CreativeInfo) null, "getAdIdFromResource");
            Logger.d(b, "get ad id from resource - impId and crid values are: " + strB2);
            synchronized (W) {
                String str3 = strB2 != null ? W.get(strB2) : null;
                if (str3 != null) {
                    if (T.containsKey(str3)) {
                        String str4 = W.get(strB2);
                        Logger.d(b, "get ad id from resource - matching found via Imp Id, adId=" + str4);
                        return str4;
                    }
                    Logger.d(b, "get ad id from resource - impIdCrid exists but ad id - " + str3 + " was not found in adId to prefetch: " + T.keySet());
                }
                if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                    aa.put(strReplaceAll, weakReference);
                    Logger.d(b, "get ad id from resource - storing the webview address: " + BrandSafetyUtils.a((Object) weakReference.get()));
                } else {
                    Logger.d(b, "get ad id from resource - webview is null, not storing the decoded value");
                }
                return null;
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x01a5 A[Catch: all -> 0x016c, TryCatch #3 {, blocks: (B:29:0x009a, B:30:0x00e9, B:32:0x00ef, B:34:0x00f7, B:36:0x0124, B:37:0x0140, B:41:0x015e, B:43:0x0164, B:47:0x016f, B:49:0x017f, B:51:0x0197, B:53:0x019d, B:54:0x01a5, B:55:0x01c6, B:65:0x01f4, B:57:0x01c9, B:58:0x01d1, B:60:0x01d7, B:61:0x01ef, B:67:0x01f7), top: B:85:0x009a, outer: #4, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x01d7 A[SYNTHETIC] */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean m(String str) {
        String str2;
        Object obj;
        String strB;
        String str3;
        synchronized (T) {
            if (!T.containsKey(str)) {
                Logger.d(b, "try reverse matching: with ad id - ad id " + str + " is not in the adIdToPrefetchContent keys: " + T.keySet());
                return false;
            }
            try {
                synchronized (T) {
                    str2 = T.get(str);
                }
                if (str2 == null) {
                    Logger.d(b, "try reverse matching: prefetchContent is null");
                    return false;
                }
                com.safedk.android.utils.n.b(b, "try reverse matching: prefetchContent: " + str2);
                com.safedk.android.utils.n.b(b, "try reverse matching: adUrlToCI keys: " + this.H.keySet());
                synchronized (aa) {
                    com.safedk.android.utils.n.b(b, "try reverse matching: webViewContentToWebviewRef keys: " + aa.keySet());
                    Logger.d(b, "try reverse matching: prefetch content prefix is: " + str2.substring(0, Math.min(500, str2.length())));
                    Iterator<String> it = aa.keySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        String next = it.next();
                        if (next != null) {
                            Logger.d(b, "try reverse matching: webview resource prefix value: " + next.substring(0, Math.min(500, next.length())));
                            if (next.contains(str2)) {
                                Logger.d(b, "try reverse matching: matching found via inner prefetch where the data loaded contains the prefetch html, is equal? " + next.equals(str2));
                                obj = next;
                                break;
                            }
                            if (str2.contains(next)) {
                                Logger.d(b, "try reverse matching: matching found via inner prefetch where the prefetch html contains the data loaded");
                                obj = next;
                                break;
                            }
                            List<String> listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.F(), next, 1, false);
                            if (!listA.isEmpty()) {
                                String str4 = U.get(listA.get(listA.size() - 1));
                                if (!TextUtils.isEmpty(str4) && str4.equals(str)) {
                                    Logger.d(b, "try reverse matching: matching found via inner prefetch where the html body loaded contains equals to prefetch html body");
                                    obj = next;
                                    break;
                                }
                                strB = b(next, (CreativeInfo) null, "tryReverseMatching");
                                Logger.d(b, "try reverse matching: impId and crid values are: " + strB);
                                synchronized (W) {
                                    if (strB != null) {
                                        str3 = W.get(strB);
                                    } else {
                                        str3 = null;
                                    }
                                    if (str.equals(str3)) {
                                        Logger.d(b, "try reverse matching: matching found via Imp Id, adId=" + str);
                                    }
                                }
                                obj = next;
                                break;
                            }
                            strB = b(next, (CreativeInfo) null, "tryReverseMatching");
                            Logger.d(b, "try reverse matching: impId and crid values are: " + strB);
                            synchronized (W) {
                                if (strB != null) {
                                    str3 = W.get(strB);
                                } else {
                                    str3 = null;
                                }
                                if (str.equals(str3)) {
                                    Logger.d(b, "try reverse matching: matching found via Imp Id, adId=" + str);
                                    obj = next;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (obj == null) {
                    Logger.d(b, "try reverse matching: did not find any webview resources for the given prefetch with ad id: " + str);
                    return false;
                }
                WeakReference<WebView> weakReference = aa.get(obj);
                if (!com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                    Logger.d(b, "try reverse matching: webViewRef is null or points to null - webviewRef: " + weakReference);
                    return false;
                }
                WebView webView = weakReference.get();
                if (this.H.get(str) != null) {
                    if (c(webView, str)) {
                        Logger.d(b, "try reverse matching: found a match using reverse! adId=" + str);
                        aa.remove(obj);
                        return true;
                    }
                } else {
                    Logger.d(b, "try reverse matching: adIdToCI does not contain adId");
                }
            } catch (Throwable th) {
                Logger.d(b, "try reverse matching encountered exception: ", th);
            }
            return false;
        }
    }

    private void C(String str) {
        String strRemove;
        VerveCreativeInfo verveCreativeInfo;
        synchronized (T) {
            strRemove = T.remove(str);
        }
        Logger.d(b, "clean resources started with ad id: " + str + ", and source is: " + strRemove);
        synchronized (this.H) {
            verveCreativeInfo = (VerveCreativeInfo) this.H.remove(str);
        }
        if (verveCreativeInfo != null && verveCreativeInfo.as() != null) {
            W.remove(verveCreativeInfo.as());
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void n(String str) {
        CreativeInfo creativeInfo = this.H.get(str);
        if (creativeInfo != null && creativeInfo.M() != BrandSafetyUtils.AdType.BANNER && creativeInfo.M() != BrandSafetyUtils.AdType.MREC) {
            C(str);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void o(String str) {
        C(str);
    }

    private String a(List<String> list) {
        String str = null;
        synchronized (Y) {
            for (String str2 : list) {
                if (Y.containsKey(str2)) {
                    str = str2;
                    break;
                }
            }
        }
        if (str != null) {
            Logger.d(b, "link ad params to video url: found video url - " + str + " with CI id - " + Y.get(str));
        }
        return str;
    }

    public Object d(Object obj) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.getType().getSimpleName().endsWith("AdParams")) {
                    Object obj2 = field.get(obj);
                    Logger.d(b, "Field name: " + field.getName() + ", Field class: " + field.getType().getName() + ", adParams: " + obj2);
                    return obj2;
                }
                continue;
            } catch (Throwable th) {
                Logger.d(b, "get ad params from controller - exception occurred!", th);
            }
        }
        Logger.d(b, "get ad params from controller - did not find ad params object");
        return null;
    }

    private HashSet<String> e(Object obj) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod("getImpressions", new Class[0]);
            declaredMethod.setAccessible(true);
            List list = (List) declaredMethod.invoke(obj, new Object[0]);
            Logger.d(b, "get inner impression url from ad params method - Returned class: " + (list != null ? list.getClass().getName() : null) + " value: " + list);
            if (list != null && !list.isEmpty() && (list.get(0) instanceof String)) {
                Logger.d(b, "find inner impression url list in ad params method - Returned list: " + list);
                return new HashSet<>(list);
            }
        } catch (Throwable th) {
            Logger.d(b, "exception while extracting inner impression url from the Ad Params using getter: ", th);
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("impressions");
            declaredField.setAccessible(true);
            List list2 = (List) declaredField.get(obj);
            Logger.d(b, "get inner impression url from ad params field - Returned class: " + (list2 != null ? list2.getClass().getName() : null) + " value: " + list2);
            if (list2 != null && !list2.isEmpty() && (list2.get(0) instanceof String)) {
                Logger.d(b, "find inner impression url list in ad params field - Returned list: " + list2);
                return new HashSet<>(list2);
            }
            Logger.d(b, "did not find proper inner impression url in field, instead: Field class: " + declaredField.getType().getName() + " Field value: " + declaredField);
            return null;
        } catch (Throwable th2) {
            Logger.d(b, "exception while extracting inner impression url from the Ad Params using field: ", th2);
        }
    }

    private String f(Object obj) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod("getId", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(obj, new Object[0]);
            Logger.d(b, "get vast id from ad params - Returned class: " + (objInvoke != null ? objInvoke.getClass().getName() : null) + " value: " + objInvoke);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable th) {
            Logger.d(b, "exception while extracting vast id from the Ad Params using getter: ", th);
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField("id");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 instanceof String) {
                return (String) obj2;
            }
            Logger.d(b, "did not find proper vast id, instead: Field class: " + declaredField.getType().getName() + "Field value: " + obj2);
            return null;
        } catch (Throwable th2) {
            Logger.d(b, "exception while extracting vast id from the Ad Params using field: ", th2);
        }
    }

    private String g(Object obj) {
        try {
            String strA = BrandSafetyUtils.a(obj);
            Method declaredMethod = obj.getClass().getDeclaredMethod("getVideoFileUrlsList", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(obj, new Object[0]);
            Logger.d(b, "find video url in ad params - with address: " + strA + " Returned class: " + (objInvoke != null ? objInvoke.getClass().getName() : null) + " value: " + objInvoke);
            if (objInvoke instanceof List) {
                List<String> list = (List) objInvoke;
                if (!list.isEmpty() && (list.get(0) instanceof String)) {
                    Logger.d(b, "find video url in ad params - Returned list: " + list);
                    return a(list);
                }
            }
        } catch (Throwable th) {
            Logger.d(b, "exception while handling finding video url from the Ad Params: ", th);
        }
        Logger.d(b, "find video url in ad params - did not find video url");
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo c(Object obj, Object obj2) {
        String str;
        CreativeInfo creativeInfoRemove;
        String key;
        try {
            ab.put(BrandSafetyUtils.a(obj2), new WeakReference<>(obj));
            Object objD = d(obj);
            if (objD == null) {
                return null;
            }
            Logger.d(b, "on video bind to controller - started with adParams address: " + BrandSafetyUtils.a(objD));
            String strF = f(objD);
            if (strF == null) {
                Logger.d(b, "on video bind to controller - could not find vast id");
            }
            String strG = g(objD);
            String str2 = strF != null ? X.get(strF) : null;
            if (str2 == null && strG != null) {
                String str3 = Y.get(strG);
                Logger.d(b, "on video bind to controller - retrieving ad id using the video url, adId: " + str3);
                str2 = str3;
            }
            if (str2 == null) {
                HashSet<String> hashSetE = e(objD);
                if (!com.safedk.android.utils.n.a((Collection<?>) hashSetE)) {
                    synchronized (this.H) {
                        for (Map.Entry<String, CreativeInfo> entry : this.H.entrySet()) {
                            VerveCreativeInfo verveCreativeInfo = (VerveCreativeInfo) entry.getValue();
                            Logger.d(b, "on video bind to controller - current inner impression is: " + verveCreativeInfo.ar());
                            if (hashSetE.contains(verveCreativeInfo.ar())) {
                                String key2 = entry.getKey();
                                Logger.d(b, "on video bind to controller - found ad id using inner impression url: " + verveCreativeInfo.ar() + " ad id: " + key2);
                                str2 = key2;
                                break;
                            }
                        }
                    }
                }
            }
            if (str2 != null || strF == null) {
                str = str2;
            } else {
                synchronized (this.H) {
                    Iterator<Map.Entry<String, CreativeInfo>> it = this.H.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            key = str2;
                            break;
                        }
                        Map.Entry<String, CreativeInfo> next = it.next();
                        if (strF.equals(((VerveCreativeInfo) next.getValue()).aq())) {
                            key = next.getKey();
                            Logger.d(b, "on video bind to controller - found ad id using inner vast ad id, vast id: " + strF + " ad id: " + key);
                            break;
                        }
                    }
                }
                str = key;
            }
            if (str == null) {
                Logger.d(b, "on video bind to controller - did not find ad id");
                return null;
            }
            if (strG != null && Y.get(strG) != null && !Y.get(strG).equals(str)) {
                Logger.d(b, "on video bind to controller - found a mismatch between video url stored - " + strG + " vs related ad id: " + str);
                return null;
            }
            if (strG != null) {
                Y.remove(strG);
            }
            if (strF != null) {
                X.remove(strF);
            }
            Logger.d(b, "on video bind to controller - found ad id - " + str);
            synchronized (this.H) {
                creativeInfoRemove = this.H.remove(str);
            }
            String str4 = strF != null ? "vast=" + strF : "videoUrl=" + strG;
            if (creativeInfoRemove != null) {
                creativeInfoRemove.t("MBT:" + str4);
                return creativeInfoRemove;
            }
            return creativeInfoRemove;
        } catch (Throwable th) {
            Logger.d(b, "exception while handling binding between video view and prefetch: ", th);
            Logger.d(b, "on video bind to controller - did not find ad id");
            return null;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String l(String str) {
        if (str == null) {
            return str;
        }
        if (str.contains(o) || str.contains(q)) {
            return com.safedk.android.utils.k.d(str, "url");
        }
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public RedirectDetails.RedirectType k(String str) {
        if (str != null) {
            if (str.contains(o)) {
                return RedirectDetails.RedirectType.REDIRECT;
            }
            if (str.contains(q)) {
                return RedirectDetails.RedirectType.EXPAND;
            }
        }
        return RedirectDetails.RedirectType.REDIRECT;
    }

    private MediaPlayer h(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("mMediaPlayer");
            declaredField.setAccessible(true);
            Logger.d(b, "get media player address - Field class: " + declaredField.getType().getName() + " value: " + declaredField);
            Object obj2 = declaredField.get(obj);
            if (obj2 instanceof MediaPlayer) {
                Logger.d(b, "get media player address - found a mediaPlayer object: " + obj2);
                return (MediaPlayer) obj2;
            }
            Logger.d(b, "get media player address - did not find a mediaPlayer object, instead found: " + (obj2 != null ? obj2.getClass() : null));
            return null;
        } catch (Throwable th) {
            Logger.d(b, "exception while extracting media player address from the controller using field: ", th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(com.safedk.android.analytics.brandsafety.c cVar) {
        List<String> listX = cVar.x();
        Logger.d(b, "is MediaPlayer Playing started: " + listX);
        for (String str : listX) {
            if (ab.get(str) != null) {
                WeakReference<Object> weakReference = ab.get(str);
                if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                    MediaPlayer mediaPlayerH = h(weakReference.get());
                    Logger.d(b, "found a media player: " + mediaPlayerH);
                    return com.safedk.android.utils.n.a(mediaPlayerH);
                }
            }
        }
        return false;
    }
}
