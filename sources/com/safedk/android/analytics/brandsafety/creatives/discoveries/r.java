package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.webkit.WebView;
import com.google.android.gms.common.internal.Objects;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.b9;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.InterstitialFinder;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.ProtobufMessageParser;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.UnityAdsCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SimpleConcurrentHashSet;
import java.io.UnsupportedEncodingException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class r extends d {
    private static final String R = "campaign";
    private static final String S = "scar-admob";
    private static final String T = "programmatic/mraid";
    private static final String U = "programmatic/mraid-url";
    private static final String V = "programmatic/vast";
    private static final String W = "programmatic/vast-vpaid";
    private static final String X = "programmatic/banner-html";
    private static final String Y = "protobuf";
    private static final String Z = "placements";
    private static final String aA = "pbCampaignData";
    private static final String aB = "pbHbMeta";
    private static final String aC = "trailerPortraitStreaming";
    private static final String aD = "trailerStreaming";
    private static final String aE = "width";
    private static final String aF = "height";
    private static final String aG = "exact_resource_pb_comet";
    private static final String aJ = "/events/v2/";
    private static final String aK = "/v1/events/";
    private static final String aL = "unity3d.com/brands";
    private static final String aM = "unity3d.com/operative";
    private static final String aN = "unity3d.com/impression";
    private static final String aO = "com.unity3d.ads";
    private static final String aP = "{\"1\":[\"adData\",\"string\"]}";
    private static final String aQ = "{\"1\":{\"4\":{\"1\":[\"adData\",\"string\"]}}}";
    private static final String aR = "{\"1\":[\"contentId\",\"string\"]}";
    private static final String aS = "JS";
    private static final String aT = "IC";
    private static final String aU = "(function(){var sdkId=\"{{SDK_ID}}\";var address=\"{{ADDRESS}}\";var log=function(message){try{if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(message)}else{console.log(\"SafeDKWebApInterface safedkDebug object missing\")}}catch(error){}};var printError=function(error){try{if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}catch(error){}};var addPrivacyWindowObserver=function(){try{var privacyElement=document.getElementById(\"privacy\");var protobufPrivacyElement=null;if(!privacyElement){privacyElement=document.getElementById(\"privacy-settings\");if(!privacyElement){var protobufPrivacyScreens=document.querySelectorAll(\"[aria-label='privacy:screen']\");if(protobufPrivacyScreens&&protobufPrivacyScreens.length>0){log(\"requestNoSampling protobufPrivacyScreens found\");protobufPrivacyElement=protobufPrivacyScreens[0]}else{privacyElement=document.querySelector('button[aria-label=\"Privacy\"]')}}}if(privacyElement){if(privacyElement.style&&privacyElement.style.visibility){var element_style_visibility=privacyElement.style.visibility;if(element_style_visibility==\"visible\"){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){log(\"requestNoSampling addPrivacyWindowObserver\");window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}else{if(privacyElement.safedkPrivacyDialogObserver!=true){privacyElement.safedkPrivacyDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){try{mutations.forEach(function(mutation){try{switch(mutation.type){case\"attributes\":if(getComputedStyle(mutation.target).visibility==\"visible\"){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){log(\"requestNoSampling addPrivacyWindowObserver MutationObserver\");window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}break}}catch(error){printError(error)}})}catch(error){printError(error)}});var config={attributes:true,attributeOldValue:true,attributeFilter:[\"style\"]};observer.observe(privacyElement,config)}catch(error){printError(error)}}}}}else if(protobufPrivacyElement){if(protobufPrivacyElement.hasAttribute(\"open\")){log(\"requestNoSampling protobufPrivacyElement opened\");if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){log(\"requestNoSampling addPrivacyWindowObserver protobuf\");window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}else{log(\"requestNoSampling protobufPrivacyElement hidden\");if(protobufPrivacyElement.safedkPrivacyDialogObserver!=true){protobufPrivacyElement.safedkPrivacyDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){try{mutations.forEach(function(mutation){try{switch(mutation.type){case\"attributes\":if(mutation.target.hasAttribute(\"open\")){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){log(\"requestNoSampling addPrivacyWindowObserver MutationObserver protobuf\");window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}break}}catch(error){printError(error)}})}catch(error){printError(error)}});var config={attributes:true,attributeOldValue:true,attributeFilter:[\"open\"]};observer.observe(protobufPrivacyElement,config)}catch(error){printError(error)}}}}}catch(error){printError(error)}};var processVideoButtons=function(){try{var buttons=document.getElementsByTagName(\"BUTTON\");var closeVideoButton=null;var resumeVideoButton=null;if(buttons&&buttons.length>0){for(let i=0;i<buttons.length;i++){let buttonText=buttons[i].textContent;if(buttonText===\"CLOSE VIDEO\"){closeVideoButton=buttons[i]}else if(buttonText===\"RESUME VIDEO\"){resumeVideoButton=buttons[i]}if(closeVideoButton&&resumeVideoButton)break}}if(closeVideoButton&&resumeVideoButton&&closeVideoButton.parentElement===resumeVideoButton.parentElement){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){log(\"requestNoSampling processVideoButtons\");window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}}catch(error){printError(error)}};var addCloseThisAdObserver=function(){try{var closeAdDialogElement=null;var rewardedDefaultViewElement=document.getElementById(\"rewarded-default-view\");if(rewardedDefaultViewElement){var rewardedSpeedBumpCollection=rewardedDefaultViewElement.getElementsByClassName(\"rewarded-speed-bump\");if(rewardedSpeedBumpCollection&&rewardedSpeedBumpCollection.length==1){closeAdDialogElement=rewardedSpeedBumpCollection[0]}}else{closeAdDialogElement=document.getElementById(\"dialog_wrapper\")}if(closeAdDialogElement){var closeAdDialogElementStyle=getComputedStyle(closeAdDialogElement);if(closeAdDialogElementStyle&&closeAdDialogElementStyle.visibility==\"visible\"&&closeAdDialogElementStyle.opacity>0){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){log(\"requestNoSampling addCloseThisAdObserver\");window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}else{if(closeAdDialogElement.safedkCloseThisAdDialogObserver!=true){closeAdDialogElement.safedkCloseThisAdDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){switch(mutation.type){case\"attributes\":if(mutation.target.className==\"visible\"){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){log(\"requestNoSampling addCloseThisAdObserver MutationObserver\");window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}break}})});var config={attributes:true,attributeOldValue:true,attributeFilter:[\"class\"]};observer.observe(closeAdDialogElement,config)}catch(error){printError(error)}}}}}catch(error){printError(error)}};var detectAgeVerificationPage=function(){try{if(document.getElementById(\"age-gate\")){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}else{}}catch(error){printError(error)}};addPrivacyWindowObserver();addCloseThisAdObserver();detectAgeVerificationPage();processVideoButtons();try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){for(var i=0;i<mutation.addedNodes.length;i++){var node=mutation.addedNodes[i];if(node&&node.nodeName!=\"#text\"){addPrivacyWindowObserver();detectAgeVerificationPage();processVideoButtons()}}if(mutation.type===\"attributes\"){addPrivacyWindowObserver();detectAgeVerificationPage();processVideoButtons()}addCloseThisAdObserver()})});var config={childList:true,subtree:true,attributes:true};observer.observe(document,config)}catch(error){printError(error)}})();\n";
    private static final int aW = 30;
    private static final String aa = "placementsV2";
    private static final String ab = "mediaId";
    private static final String ac = "placementMeta";
    private static final String ad = "rs";
    private static final String ae = "id";
    private static final String af = "allowSkip";
    private static final String ag = "auctionId";
    private static final String ah = "creativeId";
    private static final String ai = "bundleId";
    private static final String aj = "placementId";
    private static final String ak = "unityCreativeId";
    private static final String al = "endScreenUrl";
    private static final String am = "mraidUrl";
    private static final String an = "data";
    private static final String ao = "tracking";
    private static final String ap = "trackingTemplates";
    private static final String aq = "buyerID";
    private static final String ar = "dspId";
    private static final String as = "advertiserDomain";
    private static final String at = "events";
    private static final String av = "urlIndices";
    private static final String aw = "params";
    private static final String ax = "datapts";
    private static final String ay = "hbMeta";
    private static final String az = "pbDiagnosticEvent";
    public static final String b = "admob-video";
    private static String bg = null;
    private static WeakReference<WebView> bh = null;
    public static final String c = "admob-display";
    public static final String d = "admob-banner";
    public static final String e = "com.unity3d.services.core.webview.bridge.WebViewBridgeInterface";
    public static final String f = "com.unity3d.ads.adplayer.model.WebViewBridgeInterface";
    private static final String g = "UnityAdsDiscovery";
    private static final String h = "media";
    private static final String i = "content";
    private static final String j = "appStoreId";
    private static final String k = "clickUrl";
    private static final String l = "appDownloadUrl";
    private static final String m = "contentType";
    private static final String n = "portraitCreativeId";
    private static final String o = "trailerDownloadable";
    private static final String p = "trailerPortraitDownloadable";
    private static final String q = "mraidUrl";
    private final ConcurrentHashMap<String, Boolean> aV;
    private static final String[] au = {"start", "impression"};
    private static final String aH = "gateway.unityads.unity3d.com/v";
    private static final Set<String> aI = new HashSet(Arrays.asList("auction.unityads.unity3d.com/v", "auction.unityads.unity.cn/v", "auction-load.unityads.unity3d.com/v", "auction-load.unityads.unity.cn/v", "auction-banner.unityads.unity3d.com/v", "auction-load-tpsc.unityads.unity3d.com/v", aH));
    private static final ConcurrentHashMap<String, CreativeInfo> aX = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CreativeInfo> aY = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CreativeInfo> aZ = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CreativeInfo> ba = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, CreativeInfo> bb = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, a> bc = new LimitedConcurrentHashMap(30);
    private static final ConcurrentHashMap<String, String> bd = new LimitedConcurrentHashMap(30);
    private static final ConcurrentHashMap<String, WeakReference<WebView>> be = new LimitedConcurrentHashMap(30);
    private static final ConcurrentHashMap<String, WeakReference<WebView>> bf = new LimitedConcurrentHashMap(30);
    private static String bi = null;
    private static final Set<String> bj = new HashSet();

    public r() {
        super("com.unity3d.ads", g);
        this.aV = new ConcurrentHashMap<>();
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_FULLSCREEN_ADS, true);
        this.C.b(AdNetworkConfiguration.JS_PRIVACY_BUTTON_CLICK_DETECTION_SCRIPT, aU);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BIDDING_INTERSTITIAL_IMPRESSION_MATCHING_BY_MAX, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, false);
        this.C.b(AdNetworkConfiguration.SHOULD_INJECT_JS_TO_WEBVIEWS_NOT_YET_ATTACHED_TO_ACTIVITY, true);
        this.C.b(AdNetworkConfiguration.DONT_REPORT_WEBVIEW_RESOURCE_LIST_IF_NO_CI, true);
        this.C.b(AdNetworkConfiguration.SHOULD_DECODE_AD_TAG_TWICE, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_MRECS, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE, true);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_DIFFERENT_ADS_IN_CROSS_ORIGIN_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.CLEAR_FULLSCREEN_PENDING_CANDIDATES_ON_DID_FAIL_DISPLAY, true);
        this.C.b(AdNetworkConfiguration.STORE_DECODED_QUESTION_MARK_IN_VIV_URL_LIST, true);
        this.C.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, true);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        String strZ;
        String string;
        String str3;
        boolean z;
        com.safedk.android.utils.n.b(g, "generate info started, url: " + str + ", content size: " + str2.length() + ", headers: " + map);
        if (com.safedk.android.utils.n.u(str)) {
            Logger.d(g, "generate info - bufferValue is binary for url " + str + ", skipping");
            return null;
        }
        boolean z2 = false;
        if (com.safedk.android.utils.n.n(str2)) {
            z = false;
        } else {
            try {
                strZ = new String(Base64.decode(str2, 0));
            } catch (IllegalArgumentException e2) {
                Logger.d(g, "generate info - failed to decode Base64 buffer: " + e2.getMessage());
                strZ = str2;
            }
            if (strZ == null || !com.safedk.android.utils.n.n(strZ)) {
                strZ = com.safedk.android.utils.n.z(strZ);
            }
            if (strZ == null || com.safedk.android.utils.n.n(strZ)) {
                string = strZ;
            } else {
                try {
                    string = new String(Base64.decode(strZ, 0));
                } catch (IllegalArgumentException e3) {
                    Logger.d(g, "generate info - failed to decode Base64 buffer (decoded): " + e3.getMessage());
                    string = strZ;
                }
            }
            if (string == null || !com.safedk.android.utils.n.n(string)) {
                try {
                    if (str.contains(aH)) {
                        str3 = aQ;
                    } else {
                        str3 = aP;
                        bArr = Base64.decode(str2, 0);
                    }
                    JSONObject jSONObjectA = ProtobufMessageParser.a(bArr, str3);
                    if (jSONObjectA.has("adData")) {
                        com.safedk.android.utils.n.b(g, "generate info - protobuf: " + jSONObjectA);
                        z2 = true;
                        string = jSONObjectA.getString("adData");
                    }
                    str2 = string;
                    z = z2;
                } catch (IllegalArgumentException e4) {
                    Logger.d(g, "generate info - failed to decode protobuf buffer: " + e4.getMessage());
                    str2 = string;
                    z = z2;
                }
            } else {
                str2 = string;
                z = z2;
            }
            if (str2 == null || !com.safedk.android.utils.n.n(str2)) {
                Logger.d(g, "generate info - not a valid JSON string, skipping");
                return null;
            }
            com.safedk.android.utils.n.b(g, "generate info - Base64 decoded json : " + str2);
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(str2);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("media");
        if (jSONObjectOptJSONObject == null) {
            Logger.d(g, "generate info - can't find media block");
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("placements");
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2 == null ? jSONObject.optJSONObject(aa) : jSONObjectOptJSONObject2;
        if (jSONObjectOptJSONObject3 == null) {
            Logger.d(g, "generate info - can't find placements block");
            return null;
        }
        ArrayList<String> arrayListA = a(jSONObject);
        Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
        Logger.d(g, "generate info - placements: " + jSONObjectOptJSONObject3);
        while (itKeys.hasNext()) {
            try {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObjectOptJSONObject3.getJSONObject(next);
                String strOptString = jSONObject2.optString(ay, null);
                String strOptString2 = jSONObject2.optString(ad, null);
                Logger.d(g, "generate info - rs: " + strOptString2);
                String strB = null;
                JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(ao);
                JSONObject jSONObjectOptJSONObject4 = null;
                if (jSONArrayOptJSONArray != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i2);
                        strB = b(jSONObjectOptJSONObject4);
                    }
                } else {
                    jSONObjectOptJSONObject4 = jSONObject2.optJSONObject(ao);
                    strB = b(jSONObjectOptJSONObject4);
                }
                Logger.d(g, "generate info - processing start/import tracking events, datapts: " + strB);
                if (jSONObject2.has(ab)) {
                    BrandSafetyEvent.AdFormatType adFormatType = aVar != null ? aVar.b : null;
                    if (jSONObject2.get(ab).getClass().getName().equals(String.class.getName())) {
                        String string2 = jSONObject2.getString(ab);
                        Logger.d(g, "generate info - media ID (single value): " + string2);
                        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(strOptString2)) {
                            a(arrayList, jSONObjectOptJSONObject, next, string2, strOptString2, strB, strOptString, adFormatType, jSONObjectOptJSONObject4, arrayListA, z);
                        }
                    } else {
                        JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(ab);
                        Logger.d(g, "generate info - media ID (array): " + jSONArrayOptJSONArray2);
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                String string3 = jSONArrayOptJSONArray2.getString(i3);
                                Logger.d(g, "generate info - processing media ID: " + string3);
                                if (!TextUtils.isEmpty(string3)) {
                                    a(arrayList, jSONObjectOptJSONObject, next, string3, strOptString2, strB, strOptString, adFormatType, jSONObjectOptJSONObject4, arrayListA, z);
                                }
                            }
                        }
                    }
                }
            } catch (IllegalArgumentException e5) {
                Logger.d(g, "generate info - error decoding url: " + str2 + ", error: " + e5.getMessage(), e5);
            } catch (Throwable th) {
                Logger.d(g, "generate info - error parsing " + th.getMessage(), th);
            }
        }
        return arrayList;
    }

    private ArrayList<String> a(JSONObject jSONObject) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            Logger.d(g, "unity - extract tracking templates - json root is null");
        } else {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ap);
            if (jSONArrayOptJSONArray == null) {
                Logger.d(g, "unity - extract tracking templates - tracking templates are null");
            } else {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    try {
                        arrayList.add(jSONArrayOptJSONArray.getString(i2));
                    } catch (JSONException e2) {
                        Logger.d(g, "unity - extract tracking templates - exception occurred: with message\n" + e2);
                    }
                }
            }
        }
        return arrayList;
    }

    private String b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
        if (jSONObject == null) {
            Logger.d(g, "unity - extractDataPts - tracking is null");
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("events");
        if (jSONObjectOptJSONObject2 == null) {
            Logger.d(g, "unity - extractDataPts - events is null");
            return null;
        }
        for (String str : au) {
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(str);
            if (jSONObjectOptJSONObject3 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("params")) != null && (strOptString = jSONObjectOptJSONObject.optString(ax, null)) != null) {
                return strOptString;
            }
        }
        Logger.d(g, "unity - extractDataPts - did not find datapts");
        return null;
    }

    private ArrayList<Integer> a(JSONObject jSONObject, String str) {
        HashSet hashSet = new HashSet();
        if (jSONObject == null) {
            Logger.d(g, "unity - extract tracking template indices - tracking is null for media id: " + str);
            return new ArrayList<>();
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("events");
        if (jSONObjectOptJSONObject == null) {
            Logger.d(g, "unity - extract tracking template indices - events are null for media id: " + str);
            return new ArrayList<>();
        }
        try {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (jSONObjectOptJSONObject.get(next) instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject) jSONObjectOptJSONObject.get(next);
                    if (jSONObject2.has(av)) {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(av);
                        for (int i2 = 0; jSONArrayOptJSONArray != null && i2 < jSONArrayOptJSONArray.length(); i2++) {
                            hashSet.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i2)));
                        }
                    } else {
                        continue;
                    }
                }
            }
            return new ArrayList<>(hashSet);
        } catch (JSONException e2) {
            Logger.d(g, "unity - extract tracking template indices - exception occurred for media: " + str + " with message\n" + e2);
            return new ArrayList<>(hashSet);
        }
    }

    private ArrayList<String> a(ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
        ArrayList<String> arrayList3 = new ArrayList<>();
        Iterator<Integer> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(arrayList.get(it.next().intValue()));
        }
        return arrayList3;
    }

    private void a(List<CreativeInfo> list, JSONObject jSONObject, String str, String str2, String str3, String str4, String str5, BrandSafetyEvent.AdFormatType adFormatType, JSONObject jSONObject2, ArrayList<String> arrayList, boolean z) throws JSONException {
        BrandSafetyEvent.AdFormatType adFormatType2;
        String str6;
        JSONObject jSONObject3 = jSONObject.getJSONObject(str2);
        String string = jSONObject3.getString(m);
        if (string.equals(X) || string.equals(d)) {
            adFormatType2 = com.safedk.android.utils.n.b((float) jSONObject3.optInt("width"), (float) jSONObject3.optInt("height")) ? BrandSafetyEvent.AdFormatType.MREC : BrandSafetyEvent.AdFormatType.BANNER;
        } else if (this.aV.containsKey(str)) {
            adFormatType2 = this.aV.remove(str).booleanValue() ? BrandSafetyEvent.AdFormatType.INTER : BrandSafetyEvent.AdFormatType.REWARD;
        } else {
            if (adFormatType == null) {
                adFormatType = BrandSafetyEvent.AdFormatType.INTER;
            }
            adFormatType2 = adFormatType;
        }
        String string2 = jSONObject3.getString("content");
        String strOptString = jSONObject3.optString("creativeId");
        Logger.d(g, "generate info - ad format: " + adFormatType2 + ", media ID: " + str2 + ", ad ID: " + str3);
        String string3 = null;
        if (jSONObject3.has("bundleId")) {
            string3 = jSONObject3.getString("bundleId");
        }
        String string4 = jSONObject3.has(CreativeInfo.L) ? jSONObject3.getString(CreativeInfo.L) : null;
        int size = list.size();
        Logger.d(g, "generate info - content type is " + string);
        if (string.endsWith("campaign")) {
            if (z) {
                string = string + RemoteSettings.FORWARD_SLASH_STRING + Y;
            }
            a(list, str, str3, adFormatType2, string, string2, string3, string4, str4);
            str6 = string;
        } else if (string.endsWith(b) || string.endsWith(c) || string.endsWith(d)) {
            str6 = z ? string + RemoteSettings.FORWARD_SLASH_STRING + Y : string;
            b(list, str, strOptString, str3, adFormatType2, str6, string2, string4);
        } else if (string.equals(V) || string.equals(W)) {
            str6 = z ? string + RemoteSettings.FORWARD_SLASH_STRING + Y : string;
            a(list, str, strOptString, str3, adFormatType2, str6, string2, string4);
        } else if (string.equals(T)) {
            com.safedk.android.utils.n.b(g, "generate info - content type is programmatic mraid: " + jSONObject3);
            if (z) {
                string = string + RemoteSettings.FORWARD_SLASH_STRING + Y;
            }
            list.add(a(new com.safedk.android.analytics.brandsafety.creatives.c(jSONObject3), str, str3, adFormatType2, string, string4));
            str6 = string;
        } else if (string.equals(U)) {
            if (z) {
                string = string + RemoteSettings.FORWARD_SLASH_STRING + Y;
            }
            list.add(a(new com.safedk.android.analytics.brandsafety.creatives.d(jSONObject3), str, str3, adFormatType2, string, string4));
            str6 = string;
        } else if (string.equals(X)) {
            str6 = z ? string + RemoteSettings.FORWARD_SLASH_STRING + Y : string;
            UnityAdsCreativeInfo unityAdsCreativeInfoA = a(str, strOptString, str3, adFormatType2, str6, string2, string4);
            list.add(unityAdsCreativeInfoA);
            Logger.d(g, "generate info - add ci to adId map for banners, ad id: " + str3 + " datapts: " + str4 + ", ci: " + unityAdsCreativeInfoA.aa());
            if (z && str5 != null) {
                Logger.d(g, "generate info - add ci to hbMeta map, hbMeta: " + str5 + ", ci: " + unityAdsCreativeInfoA.aa());
                aZ.put(str5, unityAdsCreativeInfoA);
            }
        } else {
            str6 = string;
        }
        if (!str6.equals(X) && !str6.contains(b) && !str6.contains(c)) {
            for (int i2 = size; i2 < list.size(); i2++) {
                CreativeInfo creativeInfo = list.get(i2);
                if (str4 != null) {
                    Logger.d(g, "generate info - add ci to datapts map, datapts: " + str4 + ", ci: " + creativeInfo.aa());
                    synchronized (aY) {
                        aY.put(str4, creativeInfo);
                    }
                }
                if (str5 != null) {
                    Logger.d(g, "generate info - add ci to hbMeta map, hbMeta: " + str5 + ", ci: " + creativeInfo.aa());
                    aZ.put(str5, creativeInfo);
                }
                if (string3 != null) {
                    ((UnityAdsCreativeInfo) creativeInfo).I(string3);
                }
            }
            if (list.size() - size > 1) {
                Logger.d(g, "generate info - found more than one CI - there are " + (list.size() - size) + " cis");
            }
        }
        a(list, str2, size, jSONObject2, arrayList);
    }

    private void a(List<CreativeInfo> list, String str, int i2, JSONObject jSONObject, ArrayList<String> arrayList) {
        String str2;
        String str3;
        String str4;
        if (list.size() != 0) {
            ArrayList<Integer> arrayListA = a(jSONObject, str);
            Logger.d(g, "generate info - for media id: " + str + " url indices are: " + arrayListA);
            ArrayList<String> arrayListA2 = a(arrayList, arrayListA);
            int i3 = i2;
            String strO = null;
            String strR = null;
            while (i3 < list.size()) {
                CreativeInfo creativeInfo = list.get(i3);
                creativeInfo.b((List<String>) arrayListA2);
                if (strR == null) {
                    strR = creativeInfo.R();
                }
                i3++;
                strO = strO == null ? creativeInfo.o() : strO;
            }
            if (strR == null || strO == null) {
                Iterator<String> it = arrayListA2.iterator();
                String str5 = null;
                while (true) {
                    if (!it.hasNext()) {
                        str2 = str5;
                        str3 = strO;
                        break;
                    }
                    Map<String, String> mapA = com.safedk.android.utils.k.a(com.safedk.android.utils.k.f(it.next()), false);
                    if (mapA != null) {
                        Iterator<String> it2 = mapA.keySet().iterator();
                        while (true) {
                            str4 = strO;
                            if (!it2.hasNext()) {
                                break;
                            }
                            String next = it2.next();
                            if (strR != null && str4 != null) {
                                break;
                            }
                            if (next.equals(ar) && strR == null) {
                                strR = mapA.get(next);
                            }
                            strO = (next.equals(as) && str4 == null) ? mapA.get(next) : str4;
                            str5 = (next.equals(aq) && str5 == null) ? mapA.get(next) : str5;
                        }
                        if (strR != null && str4 != null) {
                            str2 = str5;
                            str3 = str4;
                            break;
                        }
                        strO = str4;
                    }
                }
            } else {
                str2 = null;
                str3 = strO;
            }
            String str6 = strR == null ? str2 : strR;
            while (i2 < list.size()) {
                CreativeInfo creativeInfo2 = list.get(i2);
                if (str6 != null) {
                    creativeInfo2.m(str6);
                }
                if (str3 != null) {
                    creativeInfo2.i(str3);
                }
                i2++;
            }
            Logger.d(g, "generate info - for media id: " + str + " dsps are: " + list.get(list.size() - 1).q());
        }
    }

    private UnityAdsCreativeInfo a(String str, String str2, String str3, BrandSafetyEvent.AdFormatType adFormatType, String str4, String str5, String str6) {
        String strE;
        UnityAdsCreativeInfo unityAdsCreativeInfo = new UnityAdsCreativeInfo(str3, str2, null, null, null, str4, null, adFormatType, str, this.G, null, str6, null);
        String strF = com.safedk.android.utils.k.f(str5);
        Matcher matcher = com.safedk.android.utils.g.D().matcher(strF);
        boolean zFind = matcher.find();
        if (zFind) {
            strF = strF.substring(matcher.start(), matcher.end());
        }
        Logger.d(g, "generate info - get html and is matched? " + zFind);
        Logger.d(g, "generate info - ad content added for ad id: " + str3);
        bd.put(str3, strF.replaceAll("\\s+", ""));
        synchronized (bb) {
            bb.put(str3, unityAdsCreativeInfo);
        }
        unityAdsCreativeInfo.b((List<String>) com.safedk.android.utils.n.f(strF));
        if (unityAdsCreativeInfo.O() == null && (strE = E(strF)) != null) {
            unityAdsCreativeInfo.a(strE, true);
        }
        return unityAdsCreativeInfo;
    }

    private void a(List<CreativeInfo> list, String str, String str2, String str3, BrandSafetyEvent.AdFormatType adFormatType, String str4, String str5, String str6) {
        UnityAdsCreativeInfo unityAdsCreativeInfo = new UnityAdsCreativeInfo(str3, str2, null, null, null, str4, null, adFormatType, str, this.G, null, str6, null);
        if (a((CreativeInfo) unityAdsCreativeInfo, (String) null, str5, true) != null) {
            list.add(unityAdsCreativeInfo);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return null;
    }

    private void a(List<CreativeInfo> list, String str, String str2, BrandSafetyEvent.AdFormatType adFormatType, String str3, String str4, String str5, String str6, String str7) throws JSONException {
        String strOptString;
        CreativeInfo creativeInfo;
        String str8;
        JSONObject jSONObject = new JSONObject(str4);
        Logger.d(g, "parse comet campaign prefetch - ad info: " + jSONObject);
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.optString(j);
        String strOptString4 = jSONObject.has(l) ? jSONObject.optString(l) : jSONObject.getString("clickUrl");
        String string = null;
        if (jSONObject.has("creativeId")) {
            string = jSONObject.getString("creativeId");
        } else {
            Logger.d(g, "parse comet campaign prefetch - cannot find value for key 'creativeId'");
        }
        String strOptString5 = jSONObject.optString("mraidUrl", "");
        String strOptString6 = jSONObject.optString(al, "");
        if (TextUtils.isEmpty(strOptString6)) {
            strOptString6 = jSONObject.optString("mraidUrl", "");
        }
        if (!TextUtils.isEmpty(strOptString5)) {
            Logger.d(g, "parse comet campaign prefetch - playable ad creative ID: " + string + ", playable url: " + strOptString5 + ", click url: " + strOptString4);
            CreativeInfo unityAdsCreativeInfo = new UnityAdsCreativeInfo(str2, string, strOptString4, null, strOptString5, str3, null, adFormatType, str, this.G, str5, str6, strOptString6);
            unityAdsCreativeInfo.b(Arrays.asList(strOptString5));
            creativeInfo = unityAdsCreativeInfo;
            str8 = null;
            strOptString = null;
        } else {
            String strOptString7 = jSONObject.optString(p, "");
            strOptString = jSONObject.optString(o, "");
            String strOptString8 = jSONObject.optString(aC, "");
            Logger.d(g, "parse comet campaign prefetch - streaming portrait video url: " + strOptString8);
            Logger.d(g, "parse comet campaign prefetch - streaming video url: " + jSONObject.optString(aD, null));
            Logger.d(g, "parse comet campaign prefetch - generate info video url: " + strOptString + ", portrait video url:" + strOptString7);
            String strOptString9 = jSONObject.optString(n, null);
            Logger.d(g, "parse comet campaign prefetch - creative ID: " + string + " click URL: " + strOptString4 + " video URL: " + strOptString);
            UnityAdsCreativeInfo unityAdsCreativeInfo2 = new UnityAdsCreativeInfo(str2, string, strOptString4, strOptString, null, str3, null, adFormatType, str, this.G, str5, str6, strOptString6);
            unityAdsCreativeInfo2.d(strOptString9, strOptString7);
            if (!TextUtils.isEmpty(strOptString7)) {
                unityAdsCreativeInfo2.b(Arrays.asList(strOptString7));
            }
            unityAdsCreativeInfo2.a(strOptString8);
            creativeInfo = unityAdsCreativeInfo2;
            str8 = strOptString7;
        }
        if (strOptString3 != null) {
            creativeInfo.q(strOptString3);
        }
        if (!TextUtils.isEmpty(strOptString2)) {
            Logger.d(g, "parse comet campaign prefetch - add mapping for content ID: " + strOptString2);
            ba.put(strOptString2, creativeInfo);
        }
        if (!TextUtils.isEmpty(strOptString)) {
            Logger.d(g, "parse comet campaign prefetch - add mapping for video URL: " + strOptString);
        }
        if (!TextUtils.isEmpty(str8)) {
            Logger.d(g, "parse comet campaign prefetch - add mapping for portrait video URL: " + str8);
        }
        if (!TextUtils.isEmpty(strOptString6)) {
            Logger.d(g, "parse comet campaign prefetch - add mapping for end-card URL: " + strOptString6);
        }
        creativeInfo.b(com.safedk.android.utils.n.f(str4.replace("\\/", RemoteSettings.FORWARD_SLASH_STRING)));
        if (creativeInfo.r() != null) {
            for (String str9 : creativeInfo.r()) {
                if (str9 != null && str9.length() > 0) {
                    creativeInfo.A(com.safedk.android.utils.k.o(str9));
                }
            }
        }
        list.add(creativeInfo);
        if (str7 == null) {
            Logger.d(g, "parse comet campaign prefetch - no datapts found in prefetch, ad id is: " + str2);
        }
    }

    private UnityAdsCreativeInfo a(com.safedk.android.analytics.brandsafety.creatives.c cVar, String str, String str2, BrandSafetyEvent.AdFormatType adFormatType, String str3, String str4) {
        String strF;
        String strE;
        com.safedk.android.analytics.brandsafety.creatives.c.a aVarA = cVar.a();
        UnityAdsCreativeInfo unityAdsCreativeInfo = new UnityAdsCreativeInfo(str2, aVarA.f8063a, aVarA.b, null, null, str3, aVarA.c, adFormatType, str, this.G, null, str4, null);
        if (!TextUtils.isEmpty(aVarA.d)) {
            unityAdsCreativeInfo.a(aVarA.d.hashCode());
        }
        ArrayList<String> arrayListF = com.safedk.android.utils.n.f(aVarA.d);
        Logger.d(g, "parse mraid prefetch - prefetch resources list: " + arrayListF);
        unityAdsCreativeInfo.b((List<String>) arrayListF);
        for (String str5 : arrayListF) {
            if (com.safedk.android.utils.n.s(str5) && unityAdsCreativeInfo.J() == null) {
                unityAdsCreativeInfo.p(str5);
                Logger.d(g, "parse mraid prefetch - video url set to " + str5);
                break;
            }
        }
        if (unityAdsCreativeInfo.J() == null && aVarA.e != null && aVarA.e.length() > 0) {
            unityAdsCreativeInfo.p(aVarA.e);
            Logger.d(g, "parse mraid prefetch - video url set to " + aVarA.e);
        }
        if (unityAdsCreativeInfo.O() == null && (strE = E(aVarA.d)) != null) {
            unityAdsCreativeInfo.a(strE, true);
        }
        if (unityAdsCreativeInfo.p() == null && (strF = F(aVarA.d)) != null) {
            unityAdsCreativeInfo.q(strF);
        }
        Logger.d(g, "parse mraid prefetch - CI: " + unityAdsCreativeInfo);
        return unityAdsCreativeInfo;
    }

    private void b(List<CreativeInfo> list, String str, String str2, String str3, BrandSafetyEvent.AdFormatType adFormatType, String str4, String str5, String str6) {
        boolean z;
        ArrayList<String> arrayListF;
        String str7;
        Logger.d(g, "parsing admob video prefetch - ad ID: " + str3);
        String strF = com.safedk.android.utils.k.f(str5);
        List<String> listB = com.safedk.android.utils.n.b(com.safedk.android.utils.g.J(), strF, 1);
        int size = (listB == null || listB.size() <= 0) ? 1 : listB.size();
        if (listB.size() <= 1) {
            z = false;
        } else {
            Logger.d(g, "parsing admob video prefetch - identified multi ad, ad count: " + listB.size());
            z = true;
        }
        List<String> listI = i(strF, str5);
        if (listI.isEmpty() && !TextUtils.isEmpty(str2)) {
            listI.add(str2);
        }
        List<String> listC = com.safedk.android.analytics.brandsafety.creatives.discoveries.a.C(str5);
        ArrayList arrayList = null;
        String strE = com.safedk.android.utils.n.e(com.safedk.android.utils.g.H(), str5);
        if (!TextUtils.isEmpty(strE)) {
            arrayList.add("element:ytId:" + strE);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        com.safedk.android.analytics.brandsafety.creatives.discoveries.a.a(strF, arrayList2, arrayList3);
        if (z) {
            arrayListF = null;
        } else {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                str5 = str5.replace((String) it.next(), "");
            }
            arrayListF = com.safedk.android.utils.n.f(str5);
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        if (z) {
            str7 = str4 + com.safedk.android.analytics.brandsafety.creatives.discoveries.a.a(size, strF, arrayList4, arrayList5, arrayList6, arrayList7, arrayList8) + CreativeInfo.aI + size + CreativeInfo.aK;
        } else {
            str7 = str4;
        }
        Logger.d(g, "parsing admob video prefetch - admob creative ID: " + listI + ", click URLs: " + listB + ", video id: " + strE + ", ad Id: " + str3);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < size) {
                UnityAdsCreativeInfo unityAdsCreativeInfo = new UnityAdsCreativeInfo(str3, listI.size() > i3 ? listI.get(i3) : null, listB.size() == 0 ? null : listB.get(i3), null, null, str7, null, adFormatType, str, this.G, null, str6, null);
                if (listB.size() > 1) {
                    Logger.d(g, "parsing admob video prefetch - add click urls to debugInfo: " + listB);
                    unityAdsCreativeInfo.t("clickUrls=" + listB);
                }
                if (i3 < listC.size()) {
                    unityAdsCreativeInfo.H(listC.get(i3));
                    synchronized (aX) {
                        aX.put(listC.get(i3), unityAdsCreativeInfo);
                    }
                    Logger.d(g, "parsing admob video prefetch - admob click string: " + listC.get(i3));
                } else {
                    Logger.d(g, "parsing admob video prefetch - click string is empty");
                }
                if (i3 < arrayList2.size()) {
                    String str8 = (String) arrayList2.get(i3);
                    if (str8 != null) {
                        Logger.d(g, "parsing admob video prefetch - calling vast ad parser on ad content: " + str8);
                        a((CreativeInfo) unityAdsCreativeInfo, (String) null, str8, true);
                        unityAdsCreativeInfo.b(false);
                        unityAdsCreativeInfo.f(false);
                        if (TextUtils.isEmpty(unityAdsCreativeInfo.P())) {
                            unityAdsCreativeInfo.k(unityAdsCreativeInfo.Q());
                        }
                    } else {
                        Logger.d(g, "parsing admob video prefetch - ad content is not vast ");
                    }
                }
                if (z) {
                    unityAdsCreativeInfo.am();
                    if (i3 < arrayList4.size() && arrayList4.get(i3) != null) {
                        unityAdsCreativeInfo.z(com.safedk.android.analytics.brandsafety.creatives.discoveries.a.b + ((String) arrayList4.get(i3)));
                    }
                    if (i3 < arrayList5.size() && arrayList5.get(i3) != null) {
                        unityAdsCreativeInfo.z(com.safedk.android.analytics.brandsafety.creatives.discoveries.a.c + ((String) arrayList5.get(i3)));
                    }
                    if (i3 < arrayList6.size() && arrayList6.get(i3) != null) {
                        unityAdsCreativeInfo.z(com.safedk.android.analytics.brandsafety.creatives.discoveries.a.d + ((String) arrayList6.get(i3)));
                    }
                    if (i3 < arrayList7.size() && arrayList7.get(i3) != null) {
                        unityAdsCreativeInfo.z(com.safedk.android.analytics.brandsafety.creatives.discoveries.a.e + ((String) arrayList7.get(i3)));
                    }
                    if (i3 < arrayList8.size() && arrayList8.get(i3) != null) {
                        unityAdsCreativeInfo.z(com.safedk.android.analytics.brandsafety.creatives.discoveries.a.f + ((String) arrayList8.get(i3)));
                    }
                }
                if (i3 < arrayList3.size() && arrayList3.get(i3) != null) {
                    unityAdsCreativeInfo.z(com.safedk.android.analytics.brandsafety.creatives.discoveries.a.g + ((String) arrayList3.get(i3)));
                }
                unityAdsCreativeInfo.b((List<String>) arrayListF);
                list.add(unityAdsCreativeInfo);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private List<String> i(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        String strE = com.safedk.android.utils.n.e(com.safedk.android.utils.g.I(), str);
        if (!TextUtils.isEmpty(strE)) {
            arrayList.add(strE);
            return arrayList;
        }
        return com.safedk.android.analytics.brandsafety.creatives.discoveries.a.a(str2, true);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        CreativeInfo creativeInfoRemove;
        if (!(obj instanceof String)) {
            Logger.d(g, "match info, adInstance is not a String");
            return null;
        }
        String str = (String) obj;
        Logger.d(g, "match info, string: " + str);
        synchronized (aX) {
            creativeInfoRemove = aX.remove(str);
        }
        if (creativeInfoRemove != null) {
            Logger.d(g, "match info, click url is: " + creativeInfoRemove.O());
            return creativeInfoRemove;
        }
        return creativeInfoRemove;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        boolean zB = B(str);
        if (zB) {
            Logger.d(g, "should follow input stream started, url: " + str);
        }
        return zB;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean g(String str) {
        return B(str) || C(str);
    }

    private boolean B(String str) {
        Iterator<String> it = aI.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean C(String str) {
        return str.toLowerCase().contains(aJ) || str.toLowerCase().contains(aK) || str.toLowerCase().contains(aL) || str.toLowerCase().contains(aM) || str.toLowerCase().contains(aN);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        Logger.d(g, "should follow get url started, url: " + str);
        return com.safedk.android.utils.n.i(str) && this.E.contains(com.safedk.android.utils.n.j(str));
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        return new HashSet();
    }

    private String K(String str) {
        for (String str2 : bd.keySet()) {
            String str3 = bd.get(str2);
            if (str3 != null && str != null) {
                com.safedk.android.utils.n.b(g, "find inner ad content, prefetch content: " + str3);
                com.safedk.android.utils.n.b(g, "find inner ad content, webview resource value: " + str);
                if (str.contains(str3)) {
                    bd.get(str2);
                    return str2;
                }
            }
        }
        Logger.d(g, "find inner ad content, did not find any adId for the webview - ad id to prefetch map keys: " + bd.keySet());
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        if (str == null) {
            return null;
        }
        Logger.d(g, "get ad id from resource started, webview: " + weakReference + ", value size: " + str.length());
        String strK = K(com.safedk.android.utils.k.f(str).replaceAll("\\s+", ""));
        if (strK == null) {
            return null;
        }
        Logger.d(g, "get ad id from resource, matching found via inner prefetch, adId=" + strK);
        if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
            be.put(strK, weakReference);
        } else {
            Logger.d(g, "get ad id from resource - webview is null, not storing ad ID in adIdToWebviewRef");
        }
        return strK;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public long a(CreativeInfo creativeInfo) {
        AdNetworkDiscovery adNetworkDiscoveryI;
        return (creativeInfo == null || creativeInfo.h() == null || !(creativeInfo.h().contains(b) || creativeInfo.h().contains(c) || creativeInfo.h().contains(d) || creativeInfo.h().contains(S)) || (adNetworkDiscoveryI = CreativeInfoManager.i(com.safedk.android.utils.h.h)) == null) ? super.a(creativeInfo) : adNetworkDiscoveryI.a(creativeInfo);
    }

    private WebView L(String str) {
        WeakReference<WebView> weakReference = bf.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public HashSet<String> a(String str, String str2, String str3, int i2, int i3, HashMap<String, String> map) {
        HashSet<String> hashSet = new HashSet<>();
        try {
            Matcher matcher = Pattern.compile(str3).matcher(str);
            while (matcher.find()) {
                if (matcher.groupCount() >= i2 && !TextUtils.isEmpty(matcher.group(i2))) {
                    String strGroup = matcher.group(i2);
                    hashSet.add(strGroup);
                    if (matcher.groupCount() > i3 && !TextUtils.isEmpty(matcher.group(i3))) {
                        map.put(strGroup, matcher.group(i3));
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d(g, "getPatternFromData: exception occurred with message: " + th.getMessage());
        }
        return hashSet;
    }

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8076a;
        String b;
        String c;
        CreativeInfo d;
        String e;

        private a(String str, String str2, String str3, CreativeInfo creativeInfo, String str4) {
            this.f8076a = str;
            this.b = str2;
            this.c = str3;
            this.d = creativeInfo;
            this.e = str4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:80:0x0335  */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(String str, Object obj) throws UnsupportedEncodingException {
        WebView webView;
        String str2;
        String strDecode;
        String str3;
        if (!str.startsWith("[[\"com.unity3d.services.core.api.") && !str.startsWith("[[\"com.unity3d.services.ads.api.")) {
            Logger.d(g, "handle invocation, data starts with " + str.substring(0, 25));
            return false;
        }
        String strA = BrandSafetyUtils.a(obj);
        WebView webViewL = L(strA);
        if (webViewL == null) {
            WebView webViewM = M(strA);
            if (webViewM == null) {
                webView = webViewM;
                str2 = "NA";
            } else {
                Logger.d(g, "handle invocation, found webview using interface construction");
                webView = webViewM;
                str2 = aT;
            }
        } else {
            webView = webViewL;
            str2 = aS;
        }
        String strA2 = BrandSafetyUtils.a((Object) webView);
        boolean zD = d(obj);
        Logger.d(g, "handle invocation, interface type: " + (zD ? Y : "legacy") + ", interface: " + strA + ", webview: " + strA2);
        HashMap map = new HashMap();
        if (zD) {
            map.put(az, new Pair("sendDiagnosticEvent\"\\,\\[\"(.*?)\"", 1));
            map.put(aA, new Pair("updateCampaignState.*\"data\":\"(.*?)\"", 1));
            map.put(aB, new Pair("\"get\".*[\\?&\"]hbMeta=(.*?)[\"&\\s]", 1));
        } else {
            map.put(ax, new Pair("sending (.*?) (start|impression) event to (.*?)[\\?&\"]data=(.*?)[\"&\\s]", 4));
            map.put(ay, new Pair("sending (.*?) (start|impression|resume) event to (.*?)[\\?&\"]hbMeta=(.*?)[\"&\\s]", 4));
        }
        for (String str4 : map.keySet()) {
            Pair pair = (Pair) map.get(str4);
            HashMap<String, String> map2 = new HashMap<>();
            CreativeInfo creativeInfo = null;
            for (String str5 : a(str, str4, (String) pair.first, ((Integer) pair.second).intValue(), 2, map2)) {
                String str6 = map2.get(str5);
                if (!TextUtils.isEmpty(str5)) {
                    if (str4.equals(ax)) {
                        str3 = str5;
                        creativeInfo = aY.get(str5);
                    } else if (str4.equals(ay) || str4.equals(aB)) {
                        try {
                            strDecode = URLDecoder.decode(str5, "UTF-8");
                        } catch (Throwable th) {
                            Logger.d(g, "handle invocation, decoding exception, " + th.getMessage());
                            strDecode = str5;
                        }
                        str3 = strDecode;
                        creativeInfo = aZ.get(strDecode);
                    } else if (str4.equals(az)) {
                        if ("ad_viewer_campaign_start".equals(str5)) {
                            Logger.d(g, "handle invocation, protobuf campaign started: " + strA2);
                            synchronized (bj) {
                                bj.add(strA2);
                            }
                        }
                        if ("ad_viewer_campaign_finish".equals(str5)) {
                            Logger.d(g, "handle invocation, protobuf campaign finished: " + strA2);
                            synchronized (bj) {
                                bj.remove(strA2);
                            }
                            str3 = str5;
                        } else {
                            str3 = str5;
                        }
                    } else if (str4.equals(aA) && bj.contains(strA2)) {
                        String strOptString = ProtobufMessageParser.a(Base64.decode(str5, 0), aR).optString("contentId");
                        if (TextUtils.isEmpty(strOptString)) {
                            str3 = str5;
                        } else {
                            Logger.d(g, "handle invocation, try to match with content ID: " + strOptString);
                            str3 = str5;
                            creativeInfo = ba.get(strOptString);
                        }
                    } else {
                        str3 = str5;
                    }
                    if (creativeInfo != null) {
                        a aVar = new a(str4, str3, str6, creativeInfo, str);
                        Logger.d(g, "handle invocation, interface address: " + strA + ", webview: " + webView);
                        if (webView != null) {
                            Logger.d(g, "handle invocation, match found by " + str4 + ", webview: " + strA2 + ", ad id: " + creativeInfo.N() + " with event: " + str6);
                            if (!com.safedk.android.internal.b.getInstance().isInBackground()) {
                                a(webView, aVar, zD, str2);
                                return true;
                            }
                            Logger.d(g, "handle invocation, application is in background, no match will be made");
                            return false;
                        }
                        Logger.d(g, "handle invocation, no webview mapping found, adding to pending ");
                        bc.put(strA, aVar);
                        return false;
                    }
                    com.safedk.android.utils.n.b(g, "handle invocation, no CI found in map, patternName: " + str4 + ", data: " + str3);
                }
            }
        }
        Logger.d(g, "handle invocation, did not find relevant data, interface: " + strA + ", webview: " + strA2);
        return false;
    }

    private void a(WebView webView, a aVar, boolean z, String str) {
        List<CreativeInfo> list;
        CreativeInfo creativeInfo;
        List<CreativeInfo> listU = null;
        if (aVar.d.al()) {
            listU = u(aVar.d.N());
        }
        if (listU == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar.d);
            list = arrayList;
        } else {
            list = listU;
        }
        BrandSafetyUtils.AdType adTypeM = list.isEmpty() ? null : list.get(0).M();
        if (adTypeM == BrandSafetyUtils.AdType.INTERSTITIAL) {
            InterstitialFinder interstitialFinderZ = SafeDK.getInstance().z();
            if (interstitialFinderZ == null) {
                Logger.d(g, "handle invocation - interstitial finder is null, cannot match interstitial info");
                return;
            }
            com.safedk.android.analytics.brandsafety.n nVarQ = interstitialFinderZ.q("com.unity3d.ads");
            if (!z && nVarQ == null) {
                Logger.d(g, "handle invocation - found a message that has an ad associated to it which isn't active");
                bi = "NAIIDM,pattern=" + aVar.f8076a + ",type=" + aVar.c;
                return;
            }
            if (!z && aVar.f8076a.equals(ay)) {
                String strA = com.safedk.android.utils.k.a(aVar.e, "bidBundle=", b9.i.c);
                String str2 = aVar.b;
                Iterator<CreativeInfo> it = list.iterator();
                while (it.hasNext()) {
                    String strAv = ((UnityAdsCreativeInfo) it.next()).av();
                    boolean z2 = Objects.equal(strAv, strA) || (TextUtils.isEmpty(strAv) && TextUtils.isEmpty(strA));
                    String str3 = "PMBHB,type=" + aVar.c + ",ISE=" + (z2 ? "T" : "F");
                    if (nVarQ.B() == null || !nVarQ.B().contains(str3)) {
                        Logger.d(g, "handle invocation - ci bundle id: " + strAv + " data bundle id: " + strA + " is equal: " + z2);
                        nVarQ.d(str3);
                    }
                }
                CreativeInfo creativeInfo2 = str2 != null ? aZ.get(str2) : null;
                Logger.d(g, "handle invocation - not matching, just debug for ad id: " + (creativeInfo2 != null ? creativeInfo2.N() : null) + ", meta: " + str2);
                return;
            }
        }
        for (CreativeInfo creativeInfo3 : list) {
            if (adTypeM == BrandSafetyUtils.AdType.INTERSTITIAL && bi != null) {
                if (creativeInfo3.X() == null || !creativeInfo3.X().contains(bi)) {
                    creativeInfo3.t(bi);
                }
                bi = null;
            }
            if (creativeInfo3.X() == null || !creativeInfo3.X().contains("IO=" + str)) {
                creativeInfo3.t("IO=" + str);
            }
            String strA2 = com.safedk.android.utils.k.a(aVar.e, "hbMeta=", b9.i.c);
            if (strA2 != null && aZ.get(strA2) != null && (creativeInfo = aZ.get(strA2)) != null && creativeInfo.N() != null && !creativeInfo.N().equals(creativeInfo3.N())) {
                Logger.d(g, "handle invocation - found hbMeta different ci with id: " + creativeInfo.N() + " vs current: " + creativeInfo3.N());
                if (creativeInfo3.X() == null || !creativeInfo3.X().contains("BHBDF,type=" + aVar.c)) {
                    creativeInfo3.t("BHBDF,type=" + aVar.c);
                }
            }
            creativeInfo3.a((Object) webView);
            CreativeInfoManager.a(creativeInfo3, "exact_markup_" + aVar.f8076a.toLowerCase(), "type=" + aVar.c + ",data=" + aVar.b.substring(0, 50));
        }
    }

    private boolean d(Object obj) {
        return !obj.getClass().getName().equals(e);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(WebView webView, Object obj) {
        String strA = BrandSafetyUtils.a(obj);
        boolean zD = d(obj);
        bf.put(strA, new WeakReference<>(webView));
        Logger.d(g, "map webview: " + webView + " to interface: " + obj);
        a aVarRemove = bc.remove(strA);
        if (aVarRemove != null) {
            Logger.d(g, "handle invocation, match found by " + aVarRemove.f8076a + ", webview: " + BrandSafetyUtils.a((Object) webView) + ", ad id: " + aVarRemove.d.N() + " with event: " + aVarRemove.c);
            if (!com.safedk.android.internal.b.getInstance().isInBackground()) {
                a(webView, aVarRemove, zD, aS);
            } else {
                Logger.d(g, "handle invocation, application is in background, no match will be made");
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        Logger.d(g, "clear old CIs started");
        super.i();
        com.safedk.android.utils.e.a(aY, "UnityAdsDiscovery:dataptsToCreativeInfo");
        com.safedk.android.utils.e.a(aZ, "UnityAdsDiscovery:hbMetaToCreativeInfo");
        com.safedk.android.utils.e.a(ba, "UnityAdsDiscovery:contentIdToCreativeInfo");
        com.safedk.android.utils.e.a(aX, "UnityAdsDiscovery:scarAdmobKeyToCreativeInfo");
        com.safedk.android.utils.e.a(bb, "UnityAdsDiscovery:contentToCreativeInfo");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public boolean b(com.safedk.android.analytics.brandsafety.creatives.i iVar) {
        if (super.b(iVar)) {
            return true;
        }
        com.safedk.android.analytics.brandsafety.creatives.i iVar2 = new com.safedk.android.analytics.brandsafety.creatives.i(com.safedk.android.utils.n.A(iVar.toString()));
        if (super.b(iVar2)) {
            Logger.d(g, "VastAdTagUri - is vast in vast is true after decoding the url received from network call: " + iVar2);
            return true;
        }
        if (iVar.toString().contains("%3A")) {
            iVar = new com.safedk.android.analytics.brandsafety.creatives.i(iVar.toString().replace("%3A", ":"));
        }
        return super.b(iVar);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean m(String str) {
        return a(str, "com.unity3d.ads", be, bb, d.s);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void n(String str) {
        String strRemove = bd.remove(str);
        Logger.d(g, "clean resources started with ad id: " + str + ", and source is: " + strRemove);
        if (strRemove != null) {
            be.remove(strRemove);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void w(String str) {
        Logger.d(g, "handle webview interface invoke, interface address: " + str);
        if (str != null) {
            bg = str;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(WebView webView) {
        if (webView instanceof com.unity3d.services.core.webview.WebView) {
            bh = new WeakReference<>(webView);
            Logger.d(g, "store webview on data loaded, adding webview: " + webView);
        } else {
            Logger.d(g, "store webview on data loaded, skipping non inter webView: " + webView);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:44:0x000a A[SYNTHETIC] */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(SimpleConcurrentHashSet<String> simpleConcurrentHashSet) {
        CreativeInfo creativeInfo;
        ArrayList arrayList;
        if (simpleConcurrentHashSet == null || simpleConcurrentHashSet.isEmpty()) {
            return null;
        }
        CreativeInfo creativeInfo2 = null;
        for (String str : simpleConcurrentHashSet.keySet()) {
            if (str.startsWith(CreativeInfo.aq)) {
                String strSubstring = str.substring(str.lastIndexOf(47) + 1);
                int iLastIndexOf = strSubstring.lastIndexOf(46);
                if (iLastIndexOf != -1) {
                    strSubstring = strSubstring.substring(0, iLastIndexOf);
                }
                if (strSubstring.length() >= 64) {
                    String strSubstring2 = strSubstring.substring(strSubstring.length() - 64);
                    synchronized (this.H) {
                        arrayList = new ArrayList(this.H.values());
                    }
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            CreativeInfo creativeInfo3 = (CreativeInfo) it.next();
                            HashSet<String> hashSetS = creativeInfo3.s();
                            if (hashSetS != null && !hashSetS.isEmpty() && hashSetS.contains(strSubstring2)) {
                                creativeInfo3.b(aG, (String) null);
                                Logger.d(g, "ci matched with webpage url: " + str);
                                creativeInfo = creativeInfo3;
                                break;
                            }
                        }
                    }
                    if (creativeInfo == null) {
                        return creativeInfo;
                    }
                    creativeInfo2 = creativeInfo;
                } else {
                    continue;
                }
            }
            creativeInfo = creativeInfo2;
            if (creativeInfo == null) {
                return creativeInfo;
            }
            creativeInfo2 = creativeInfo;
        }
        return creativeInfo2;
    }

    private WebView M(String str) {
        if (str == null || !str.equals(bg)) {
            Logger.d(g, "get webview, mismatch with last bridge address: " + bg + " vs " + str);
            return null;
        }
        if (com.safedk.android.utils.n.a((Reference<?>) bh)) {
            return bh.get();
        }
        return null;
    }
}
