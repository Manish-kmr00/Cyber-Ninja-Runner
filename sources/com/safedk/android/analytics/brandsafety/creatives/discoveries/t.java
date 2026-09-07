package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.FileUploadManager;
import com.safedk.android.analytics.brandsafety.RedirectDetails;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.VungleCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.PersistentConcurrentHashMap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t extends d {
    private static final String R = "creative_id";
    private static final String S = "callToActionDest";
    private static final String T = "callToActionUrl";
    private static final String U = "info";
    private static final String V = "impression auctioned but unsold";
    private static final String W = "request is rejected by filter";
    private static final String X = "url";
    private static final String Y = "ORIGINAL_VIDEO_URL";
    private static final String Z = "showCloseIncentivized";
    private static final String aA = "https://privacy.vungle.com/";
    private static final String aB = "vungle.com";
    private static final String aC = "adunit";
    private static final String aD = "AD_SOURCE";
    private static final String aE = "ADVERTISER_DOMAIN";
    private static final String aF = "ads";
    private static final String aG = "APP_NAME";
    private static final String aH = "APP_DESCRIPTION";
    private static final String aI = "CTA_BUTTON_TEXT";
    private static final String aJ = "MAIN_IMAGE";
    private static final String aK = "APP_ICON";
    private static final String aL = "vungle_playable";
    private static final String aM = "MAIN_STREAM";
    private static final String aN = "STREAM_CHUNK_0";
    private static final String aO = "STREAM_CHUNK_1";
    private static PersistentConcurrentHashMap<String, VungleCreativeInfo> aP = null;
    private static PersistentConcurrentHashMap<Integer, VungleCreativeInfo> aQ = null;
    private static PersistentConcurrentHashMap<String, VungleCreativeInfo> aR = null;
    private static PersistentConcurrentHashMap<String, Boolean> aS = null;
    private static final Map<String, WeakReference<Object>> aT = new HashMap();
    private static final long aU = 259200000;
    private static final int aa = 9999;
    private static final String ab = "placement_reference_id";
    private static final String ac = "cacheable_replacements";
    private static final String ad = "MAIN_VIDEO";
    private static final String ae = "postBundle";
    private static final String af = "templateURL";
    private static final String ag = "template_type";
    private static final String ah = "expiry";
    private static final String ai = "adType";
    private static final String aj = "ad_type";
    private static final String ak = "banner";
    private static final String al = "mrec";
    private static final String am = "native";
    private static final String an = "fullscreen";
    private static final String ao = "placements";
    private static final String ap = "reference_id";
    private static final String aq = "is_incentivized";
    private static final String ar = "tpat";
    private static final String as = "templateSettings";
    private static final String at = "template_settings";
    private static final String au = "normal_replacements";
    private static final String av = "clickUrl";
    private static final String aw = "ad_market_id";
    private static final String ax = "APP_STORE_ID";
    private static final String ay = "CTA_BUTTON_URL";
    private static final String az = "EC_CTA_URL";
    public static final String b = "MAIN_VIDEO.mp4";
    public static final String c = "ad_markup";
    public static final String d = "com.vungle.warren.BuildConfig";
    public static final String e = "VERSION_NAME";
    public static final String f = "ADM_HTML";
    public static final String g = "EC_HTML";
    public static final String h = "adx.ads.vungle.com/api/v";
    public static final String i = "api.vungle.com/api/v";
    public static final String j = "adx-stage.ads.vungle.com/api/v";
    public static final String k = "api.vungle.com/config";
    public static final String l = "(function(){var sdkId=\"{{SDK_ID}}\";var address=\"{{ADDRESS}}\";var log=function(message){try{console.log(\"log Vungle privacy policy sdkId : \"+sdkId+\",address = \"+address+\", msg : \"+message);if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(\"Vungle-Liftoff detect privacy ,address \"+address+\", message : \"+message)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkDebug object missing\")}}catch(error){console.log(\"log : \"+error)}};log(\"script started sdkId = \"+sdkId+\", address = \"+address);var dialogboxElement=null;var addPrivacyObservers=function(){try{log(\"addPrivacyObservers started, trying with DIALOGBOX\");dialogboxElement=document.getElementById(\"DIALOGBOX\");if(!dialogboxElement){log(\"addPrivacyObservers trying again with privacy-dialog\");dialogboxElement=document.getElementById(\"privacy-dialog\")}if(!dialogboxElement){log(\"addPrivacyObservers trying again with privacy-popup\");dialogboxElement=document.getElementById(\"privacy-popup\")}log(\"addPrivacyObservers privacy-popup : \"+dialogboxElement);if(!dialogboxElement){log(\"addPrivacyObservers trying again with privacy-page\");dialogboxElement=document.getElementById(\"privacy-page\")}log(\"privacy-popup : \"+dialogboxElement);if(!dialogboxElement){log(\"addPrivacyObservers trying again with privacy-popup by class \");var elements=document.querySelectorAll(\"div#privacy-popup\");if(elements&&elements.length>0){log(\"found by class : \"+JSON.stringify(elements[0]));dialogboxElement=elements[0]}}log(\"dialogboxElement = \"+dialogboxElement);try{log(\"dialogboxElement (json) = \"+JSON.stringify(dialogboxElement))}catch(error){log(\"dialogboxElement error \"+error)}if(dialogboxElement&&dialogboxElement.hasAttribute(\"id\")){log(\"dialogboxElement.id ? \"+dialogboxElement.id)}if(dialogboxElement&&dialogboxElement.hasAttribute(\"aria-hidden\")){log(\"dialogboxElement.aria-hidden ? \"+dialogboxElement.getAttribute(\"aria-hidden\"))}if(dialogboxElement&&(dialogboxElement.style&&dialogboxElement.style.visibility||dialogboxElement.hasAttribute(\"id\")&&dialogboxElement.id==\"privacy-popup\")){log(\"addPrivacyObservers found element \"+JSON.stringify(dialogboxElement));var element_style_visibility=dialogboxElement.style&&dialogboxElement.style.visibility||dialogboxElement&&dialogboxElement.hasAttribute(\"id\")&&dialogboxElement.id==\"privacy-popup\"&&dialogboxElement.classList.contains(\"ytoTpW_show\");if(element_style_visibility){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}log(\"addPrivacyObservers element is visible\")}else{log(\"addPrivacyObservers element is not visible\");{dialogboxElement.safedkPrivacyDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){switch(mutation.type){case\"attributes\":log(\"addPrivacyObservers Attribute name \"+mutation.attributeName+\" changed to \"+getComputedStyle(mutation.target).visibility+\" (was \"+mutation.oldValue+\")\");if(getComputedStyle(mutation.target).visibility==\"visible\"||mutation.target.classList.contains(\"ytoTpW_show\")){log(\"privacy dialog is visible \");if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}break}})});var config={attributes:true,attributeOldValue:true};observer.observe(dialogboxElement,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSamplingExc object missing\")}}}}}else{var privacyPageElement=document.getElementById(\"privacy-page\");if(privacyPageElement){var privacyPageParentElement=privacyPageElement.parentElement;if(privacyPageParentElement){var computedStyle=getComputedStyle(privacyPageParentElement);if(computedStyle){var displayState=computedStyle.display;if(displayState!=\"none\"){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}else{{privacyPageParentElement.safedkPrivacyDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){switch(mutation.type){case\"attributes\":if(mutation.target.style.display!=\"none\"){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}break}})});var config={attributes:true,attributeOldValue:true,childList:true,subtree:true};observer.observe(privacyPageParentElement,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface Vungle pp object missing\")}}}}}}}}}catch(error){log(\"caught exception with error = \"+error+\", stack : \"+error.stack);if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSamplingExc object missing\")}}return dialogboxElement};var addAdClosureObservers=function(){try{log(\"addAdClosureObservers trying with incentivized-dialog\");var dialogboxElement=document.getElementById(\"incentivized-dialog\");if(dialogboxElement&&dialogboxElement.style&&dialogboxElement.style.visibility){log(\"addAdClosureObservers found element : \"+dialogboxElement);var element_style_visibility=dialogboxElement.style.visibility;if(element_style_visibility==\"visible\"){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface Vungle pp object missing\")}log(\"addAdClosureObservers element is visible\")}else{log(\"addAdClosureObservers element is not visible\");if(dialogboxElement.safedkPrivacyDialogObserver!=true){dialogboxElement.safedkPrivacyDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){switch(mutation.type){case\"attributes\":if(getComputedStyle(mutation.target).visibility==\"visible\"){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}log(\"addAdClosureObservers Attribute name \"+mutation.attributeName+\" changed to \"+getComputedStyle(mutation.target).visibility+\" (was \"+mutation.oldValue+\")\");break}})});var config={attributes:true,attributeOldValue:true,attributeFilter:[\"style\"]};observer.observe(dialogboxElement,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSamplingExc object missing\")}log(\"addAdClosureObservers Error : \"+\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}}}}}catch(error){log(\"caught exception with error = \"+error);if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSamplingExc object missing\")}}};var monitorNotifications=function(){try{var divIds=[\"ad-notification-modal\",\"gdpr-notification-view\"];for(var divId of divIds){var element=document.getElementById(divId);if(element){var className=element.className;if(element.className.endsWith(\"show\")){log(\"element.className = \"+element.className);if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}else{if(element.safedkVisibilityObserver!=true){element.safedkVisibilityObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){if(mutation.type==\"attributes\"){if(mutation.target.className.endsWith(\"show\")){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}}})});var config={attributes:true,attributeOldValue:true,attributeFilter:[\"class\"]};observer.observe(element,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}}}}}}catch(error){log(\"caught exception with error = \"+error);if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}};var counter=0;setTimeout(()=>{if(!dialogboxElement&&counter<4){counter++;log(\"calling addPrivacyObservers() \"+counter);addPrivacyObservers()}},500);try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){for(const mutation of mutations){if(mutation.type===\"childList\"){}else if(mutation.type===\"attributes\"){log(mutation.attributeName+\" attribute was modified to \"+mutation.target.getAttribute(mutation.attributeName))}}mutations.forEach(function(mutation){for(var i=0;i<mutation.addedNodes.length;i++){var node=mutation.addedNodes[i];log(\"node iteration \"+i+\" : \"+JSON.stringify(node));if(node&&node.nodeName!=\"#text\"){addPrivacyObservers();addAdClosureObservers();monitorNotifications()}}})});var config={attributes:true,childList:true,subtree:true};observer.observe(document,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(\"address = \"+address+\" \"+error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface Vungle pp safedkNoSampling object missing\")}}})();\n";
    public static final String m = "mraid://";
    public static final String n = "url";
    private static final String o = "VungleDiscovery";
    private static final String p = "id";
    private static final String q = "campaign";

    public t() {
        super(com.safedk.android.utils.h.d, o);
        try {
            aP = new PersistentConcurrentHashMap<>("VungleDiscoverycreativeToIdMap");
            Logger.d(o, "CI to ID map loaded, key set: " + aP.keySet());
            aQ = new PersistentConcurrentHashMap<>("VungleDiscoverymediaPlayerIdToCreativeInfo");
            Logger.d(o, "media player to CI loaded, key set: " + aQ.keySet());
            aR = new PersistentConcurrentHashMap<>("VungleDiscoveryadToIdMap");
            Logger.d(o, "ad to ID map loaded, key set: " + aR.keySet());
            aS = new PersistentConcurrentHashMap<>("VungleDiscoveryplacementData");
            Logger.d(o, "placement data loaded, key set: " + aS.keySet());
        } catch (InvalidParameterException e2) {
            Logger.e(o, "Error initializing VungleDiscovery, caching will not be available", e2);
        }
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_FULLSCREEN_ADS, true);
        this.C.b(AdNetworkConfiguration.JS_PRIVACY_BUTTON_CLICK_DETECTION_SCRIPT, l);
        this.C.a(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_MAX_AGE, aU);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_DELAY_BANNER_VIEWS_SCANNER, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_BANNERS_USING_BANNER_KEY, true);
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0220  */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        JSONObject jSONObject;
        CreativeInfo creativeInfoA;
        com.safedk.android.utils.n.b(o, "generate info started, url: " + str + ", buffer size: " + (str2 == null ? "0" : Integer.valueOf(str2.length())) + ", maxParams: " + aVar);
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (str.contains(k)) {
                B(str2);
                return null;
            }
            if (CreativeInfoManager.h(str) || str.equals("@!1:ad_fetch@!")) {
                Logger.d(o, "Url is a mediation url");
                if (jSONObject2.has(aC)) {
                    Logger.d(o, "content contains an AdUnit field");
                    String strA = com.safedk.android.utils.c.a(Base64.decode(jSONObject2.getString(aC), 0));
                    com.safedk.android.utils.n.b(o, "decodedAdUnitContent = " + strA);
                    if (com.safedk.android.utils.n.n(strA)) {
                        JSONObject jSONObject3 = new JSONObject(strA);
                        Logger.d(o, "decodedAdUnitContent new JSONObject created");
                        jSONObject = jSONObject3;
                    } else {
                        jSONObject = jSONObject2;
                    }
                } else {
                    jSONObject = jSONObject2;
                }
            } else {
                jSONObject = jSONObject2;
            }
            boolean z = aVar != null && aVar.b == BrandSafetyEvent.AdFormatType.NATIVE;
            if (jSONObject.has("id")) {
                CreativeInfo creativeInfoA2 = a(jSONObject, (String) null, z, aVar);
                if (creativeInfoA2 != null) {
                    if (!creativeInfoA2.M().equals(BrandSafetyUtils.AdType.NATIVE)) {
                        arrayList.add(creativeInfoA2);
                        synchronized (aP) {
                            aP.put(creativeInfoA2.P(), (VungleCreativeInfo) creativeInfoA2);
                            Logger.d(o, "ci to ID map key added " + creativeInfoA2.P() + ", key set: " + aP.keySet());
                        }
                        creativeInfoA2.h(aVar.f8068a);
                    } else {
                        Logger.d(o, "ci is a native ad, skipping: " + creativeInfoA2.aa());
                    }
                    arrayList.add(creativeInfoA2);
                    synchronized (aP) {
                        aP.put(creativeInfoA2.P(), (VungleCreativeInfo) creativeInfoA2);
                        Logger.d(o, "ci to ID map key added " + creativeInfoA2.P() + ", key set: " + aP.keySet());
                    }
                }
            } else if (jSONObject.has("ads")) {
                JSONArray jSONArray = jSONObject.getJSONArray("ads");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(c);
                    String string = jSONObject4.getString(ab);
                    if (b(jSONObject4) && (creativeInfoA = a(jSONObject5, string, z, aVar)) != null) {
                        arrayList.add(creativeInfoA);
                        synchronized (aP) {
                            aP.put(creativeInfoA.P(), (VungleCreativeInfo) creativeInfoA);
                            Logger.d(o, "ci to ID map key added " + creativeInfoA.P() + ", key set: " + aP.keySet());
                        }
                        if (z) {
                            creativeInfoA.h(aVar.f8068a);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            Logger.d(o, "Exception parsing prefetch : " + th.getMessage(), th);
        }
        return arrayList;
    }

    private void B(String str) throws JSONException {
        com.safedk.android.utils.n.b(o, "process placements started, buffer = " + str);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("placements")) {
            JSONArray jSONArray = jSONObject.getJSONArray("placements");
            for (int i2 = 0; i2 < jSONArray.length() - 1; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2.has(ap) && jSONObject2.has(aq)) {
                    aS.put(jSONObject2.getString(ap), Boolean.valueOf(jSONObject2.getBoolean(aq)));
                    Logger.d(o, "process placements added " + jSONObject2.getString(ap) + " : " + jSONObject2.getBoolean(aq));
                } else {
                    Logger.d(o, "process placements placement does not contains ref_id/is_incentivized data : " + jSONObject2);
                }
            }
            return;
        }
        Logger.d(o, "process placements no placements array");
    }

    private void c(CreativeInfo creativeInfo, String str) {
        try {
            Matcher matcher = com.safedk.android.utils.g.bf().matcher(str);
            if (matcher.find() && matcher.groupCount() > 0) {
                String strTrim = matcher.group(1).trim();
                Logger.d(o, "found vungle endcard url: " + strTrim);
                creativeInfo.G(strTrim);
            }
        } catch (Throwable th) {
            Logger.d(o, "extract vungle endcard url - exception occurred: ", th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        Logger.d(o, "match info - started. ad instance= " + obj);
        Logger.d(o, "match info - creative id to ci keys: " + aP.keySet());
        if (obj instanceof String) {
            String strA = (String) obj;
            if (com.safedk.android.utils.n.n(strA)) {
                try {
                    strA = a(new JSONObject(strA));
                } catch (JSONException e2) {
                    Logger.d(o, "match info - exception: " + e2);
                }
            }
            Logger.d(o, "match info - started. ad id found= " + strA);
            if (!TextUtils.isEmpty(strA)) {
                VungleCreativeInfo vungleCreativeInfo = aR.get(strA);
                Logger.d(o, "match info - FOUND by ad id= " + obj + ",    ci= " + vungleCreativeInfo);
                return vungleCreativeInfo;
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean m(String str) {
        VungleCreativeInfo vungleCreativeInfo = aR.get(str);
        WeakReference<Object> weakReferenceRemove = aT.remove(str);
        if (vungleCreativeInfo != null && vungleCreativeInfo.M() == BrandSafetyUtils.AdType.NATIVE && weakReferenceRemove != null) {
            Logger.d(o, "try reverse matching - value= " + str + ",   matching ref= " + weakReferenceRemove + ",    ci= " + vungleCreativeInfo.aa());
            CreativeInfoManager.b(com.safedk.android.utils.h.d, str, weakReferenceRemove.get());
            return false;
        }
        return false;
    }

    private String a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        try {
            if (jSONObject.has(aC)) {
                String strA = com.safedk.android.utils.c.a(Base64.decode(jSONObject.getString(aC), 0));
                if (com.safedk.android.utils.n.n(strA) && (jSONArrayOptJSONArray = new JSONObject(strA).optJSONArray("ads")) != null && jSONArrayOptJSONArray.length() > 0 && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.getJSONObject(0).optJSONObject(c)) != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("id");
                    Logger.d(o, "get ad id from prefetch - ad id found= " + strOptString);
                    return strOptString;
                }
            }
        } catch (JSONException e2) {
            Logger.d(o, "get ad id from prefetch - exception: " + e2);
        }
        Logger.d(o, "get ad id from prefetch - could not find ad id");
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(Object obj, Object obj2) {
        Logger.d(o, "save matching object for reverse matching - matching object= " + obj2);
        if (obj instanceof String) {
            String str = (String) obj;
            if (com.safedk.android.utils.n.n(str)) {
                try {
                    String strA = a(new JSONObject(str));
                    if (!TextUtils.isEmpty(strA) && obj2 != null) {
                        aT.put(strA, new WeakReference<>(obj2));
                        Logger.d(o, "save matching object for reverse matching - saving ad id= " + strA + ",     matching object= " + obj2);
                    }
                } catch (JSONException e2) {
                    Logger.d(o, "match info - exception: " + e2);
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String c(String str, String str2) {
        String strC = C(str2);
        if (strC == null) {
            strC = C(str);
        }
        if (strC == null) {
            return null;
        }
        Logger.d(o, "get ad ID from resource returned ad ID: " + strC);
        return strC;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public int h(String str) {
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void b(Object obj, Object obj2) {
        try {
            Logger.d(o, "handle media player set data source call, media player: " + obj + ", video file: " + obj2);
            Uri uri = (Uri) obj2;
            Logger.d(o, "handle media player set data source call, uri: " + uri.toString());
            VungleCreativeInfo vungleCreativeInfoA = a(new File(uri.getPath()));
            if (vungleCreativeInfoA != null && !aQ.containsKey(Integer.valueOf(System.identityHashCode(obj)))) {
                Logger.d(o, "handle media player set data source call, adding CI to map");
                synchronized (aQ) {
                    aQ.put(Integer.valueOf(System.identityHashCode(obj)), vungleCreativeInfoA);
                }
            }
        } catch (Exception e2) {
            Logger.e(o, "exception when trying to add mediaPlayer id and VungleCreativeInfo " + e2.getMessage());
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String b(Object obj) {
        VungleCreativeInfo vungleCreativeInfoRemove;
        VungleCreativeInfo vungleCreativeInfoRemove2;
        try {
            Logger.d(o, "get CI after media player start call, media player: " + obj);
            synchronized (aQ) {
                vungleCreativeInfoRemove = aQ.remove(Integer.valueOf(System.identityHashCode(obj)));
            }
            if (vungleCreativeInfoRemove != null) {
                synchronized (aP) {
                    vungleCreativeInfoRemove2 = aP.remove(vungleCreativeInfoRemove.P());
                }
                if (vungleCreativeInfoRemove2 == null) {
                    Logger.d(o, "Cannot find " + vungleCreativeInfoRemove.P() + " in creative to ID map");
                } else {
                    Logger.d(o, "creative to ID map key '" + vungleCreativeInfoRemove.P() + "'removed, key set: " + aP.keySet());
                }
                Logger.d(o, "get CI after media player start call - returning " + vungleCreativeInfoRemove.N() + " as ad ID");
                return vungleCreativeInfoRemove.N();
            }
            Logger.d(o, "get CI after media player start call - cannot find creative in media player ID to CI map");
            return null;
        } catch (Exception e2) {
            Logger.e(o, "exception when trying to remove from media player ID to CI map" + e2.getMessage());
            return null;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        Logger.d(o, "should follow get url: " + str);
        if (str.toLowerCase().endsWith(b.toLowerCase())) {
            Logger.d(o, "should follow get url - returning true for url: " + str);
            return true;
        }
        if (str.equals(aA)) {
            Logger.d(o, "Vungle privacy policy url invoked");
            CreativeInfoManager.b(com.safedk.android.utils.h.d, (String) null);
        }
        String strC = C(str);
        if (strC != null && strC.length() > 0) {
            if (aR.containsKey(strC)) {
                Logger.d(o, "ad to ID map contains creative ID: " + strC + ", returning true");
                return true;
            }
            Logger.d(o, "ad to ID map does not contain creative ID: " + strC + " , key set : " + aR.keySet());
        }
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        boolean z = str.contains(h) || str.contains(i) || str.contains(j) || str.contains(k);
        if (z) {
            Logger.d(o, "should follow input stream, url: " + str);
        }
        return z;
    }

    private CreativeInfo a(JSONObject jSONObject, String str, boolean z, c.a aVar) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        List<String> list;
        boolean z2;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        try {
            com.safedk.android.utils.n.b(o, "get CI from Json object started : " + jSONObject);
            String string = jSONObject.getString("id");
            Logger.d(o, "get CI from Json ad ID: " + string);
            if (string.equals("") && jSONObject.has(U) && (jSONObject.getString(U).equals(V) || jSONObject.getString(U).equals(W))) {
                Logger.d(o, "get CI from Json No fill, exiting");
                return null;
            }
            String strOptString = null;
            String str5 = null;
            boolean z3 = false;
            List<String> arrayList = new ArrayList<>();
            if (jSONObject.has(as)) {
                jSONObject2 = jSONObject.getJSONObject(as);
            } else if (!jSONObject.has(at)) {
                jSONObject2 = null;
            } else {
                jSONObject2 = jSONObject.getJSONObject(at);
            }
            if (jSONObject2 == null || !jSONObject2.has(au)) {
                jSONObject3 = null;
                list = arrayList;
                z2 = false;
                str2 = null;
                str3 = null;
                str4 = null;
            } else {
                JSONObject jSONObject6 = jSONObject2.getJSONObject(au);
                String string2 = jSONObject6.has(aD) ? jSONObject6.getString(aD) : null;
                String string3 = jSONObject6.has(aE) ? jSONObject6.getString(aE) : null;
                if (jSONObject6.has(g)) {
                    String strOptString2 = jSONObject6.optString(g);
                    byte[] bArrDecode = !TextUtils.isEmpty(strOptString2) ? Base64.decode(strOptString2, 0) : null;
                    str5 = bArrDecode != null ? com.safedk.android.utils.c.a(bArrDecode) : null;
                    if (str5 != null) {
                        Logger.d(o, "found EC_HTML content");
                        z3 = true;
                    }
                } else if (jSONObject6.has(f)) {
                    String string4 = jSONObject6.getString(f);
                    str5 = !TextUtils.isEmpty(string4) ? new String(Base64.decode(string4, 0)) : string4;
                }
                Logger.d(o, "get CI from Json HTML is: " + str5);
                if (TextUtils.isEmpty(str5)) {
                    jSONObject3 = jSONObject6;
                    list = arrayList;
                    z2 = z3;
                    str2 = str5;
                    str3 = string3;
                    str4 = string2;
                } else {
                    List<String> listF = com.safedk.android.utils.n.f(str5);
                    strOptString = E(str5);
                    Logger.d(o, "get CI from Json HTML clickUrl : " + strOptString);
                    jSONObject3 = jSONObject6;
                    list = listF;
                    z2 = z3;
                    str2 = str5;
                    str3 = string3;
                    str4 = string2;
                }
            }
            if (!jSONObject.has("tpat")) {
                jSONObject4 = null;
            } else {
                jSONObject4 = jSONObject.getJSONObject("tpat");
            }
            if (strOptString == null && jSONObject3 != null && jSONObject3.has("CTA_BUTTON_URL")) {
                strOptString = jSONObject3.optString("CTA_BUTTON_URL", null);
            }
            if (strOptString == null && jSONObject3 != null && jSONObject3.has(az)) {
                strOptString = jSONObject3.optString(az, null);
            }
            if (strOptString == null && jSONObject.has(T)) {
                strOptString = jSONObject.getString(T);
            }
            if (strOptString == null && jSONObject4 != null && jSONObject4.has("clickUrl")) {
                strOptString = jSONObject4.optString("clickUrl", null);
            }
            Logger.d(o, "get CI from Json clickUrl processing " + strOptString);
            if (com.safedk.android.utils.n.a((Object) strOptString)) {
                Logger.d(o, "handle app package name debug url = " + strOptString + ", packageId = " + com.safedk.android.utils.n.o(strOptString));
            }
            if (!TextUtils.isEmpty(strOptString) && com.safedk.android.utils.n.n(strOptString)) {
                try {
                    JSONArray jSONArray = new JSONArray(strOptString);
                    strOptString = jSONArray.length() > 0 ? (String) jSONArray.get(0) : strOptString;
                } catch (Throwable th) {
                    Logger.d(o, "get CI from Json clickUrl processing exception :" + th.getMessage(), th);
                }
                Logger.d(o, "get CI from Json clickUrl processing unescaped = " + strOptString);
            }
            String str6 = strOptString;
            HashMap<String, String> mapA = a(jSONObject, string);
            if (str6 == null && mapA.containsKey("clickUrl_0")) {
                String str7 = mapA.get("clickUrl_0");
                mapA.remove("clickUrl_0");
                str6 = str7;
            }
            String string5 = null;
            if (jSONObject.has("campaign")) {
                String string6 = jSONObject.getString("campaign");
                if (string6 == null || string6.equals("null")) {
                    Logger.d(o, "get CI from Json Campaign is null, exiting");
                    return null;
                }
                string5 = string6.split("\\|")[1];
            } else if (jSONObject.has("creative_id")) {
                string5 = jSONObject.getString("creative_id");
            }
            Logger.d(o, "get CI from Json creativeId is " + string5);
            String string7 = null;
            String string8 = null;
            if (jSONObject.has("url")) {
                string7 = jSONObject.getString("url");
            } else if (jSONObject3 != null && jSONObject3.has(Y)) {
                string7 = jSONObject3.getString(Y);
            }
            if (jSONObject.has(ae)) {
                string8 = jSONObject.getString(ae);
                Logger.d(o, "get CI from Json zip files bundle identified " + string8 + " in " + ae);
            } else if (jSONObject.has(af)) {
                string8 = jSONObject.getString(af);
                Logger.d(o, "get CI from Json zip files bundle identified " + string8 + " in " + af);
            } else {
                Logger.d(o, "get CI from Json zip files bundle not present in prefetch data.");
            }
            if (TextUtils.isEmpty(string7)) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(as);
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = jSONObject.optJSONObject(at);
                }
                if (jSONObjectOptJSONObject != null) {
                    JSONObject jSONObject7 = jSONObjectOptJSONObject.getJSONObject(ac);
                    if (jSONObject7.has("MAIN_VIDEO")) {
                        string7 = jSONObject7.getJSONObject("MAIN_VIDEO").getString("url");
                    }
                }
            }
            if (TextUtils.isEmpty(string7) && jSONObject3 != null && jSONObject3.has(aM)) {
                string7 = jSONObject3.optString(aM);
            }
            JSONObject jSONObjectOptJSONObject2 = null;
            if (!TextUtils.isEmpty(string7)) {
                jSONObject5 = null;
            } else {
                JSONObject jSONObjectOptJSONObject3 = null;
                if (jSONObject2 != null && jSONObject2.has(ac)) {
                    jSONObjectOptJSONObject2 = jSONObject2.optJSONObject(ac);
                }
                if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.has(aN)) {
                    jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(aN);
                }
                if (jSONObjectOptJSONObject3 == null || !jSONObjectOptJSONObject3.has("url")) {
                    jSONObject5 = jSONObjectOptJSONObject2;
                } else {
                    string7 = jSONObjectOptJSONObject3.optString("url");
                    jSONObject5 = jSONObjectOptJSONObject2;
                }
            }
            if (string7 == null) {
                JSONObject jSONObjectOptJSONObject4 = null;
                if (jSONObject5 != null && jSONObject5.has(aO)) {
                    jSONObjectOptJSONObject4 = jSONObject5.optJSONObject(aO);
                }
                if (jSONObjectOptJSONObject4 != null && jSONObjectOptJSONObject4.has("url")) {
                    string7 = jSONObjectOptJSONObject4.optString("url");
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis() + this.C.e(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_MAX_AGE);
            Logger.d(o, "get CI from Json expiration initial value (now + 1 week) =  " + jCurrentTimeMillis);
            if (jSONObject.has(ah)) {
                jCurrentTimeMillis = jSONObject.getLong(ah) * 1000;
                Logger.d(o, "get CI from Json expiration override ,  new values is " + jCurrentTimeMillis);
            }
            BrandSafetyUtils.AdType adType = BrandSafetyUtils.AdType.INTERSTITIAL;
            String strOptString3 = jSONObject.optString(ag, null);
            Logger.d(o, "get CI from Json templateType is " + strOptString3);
            if (strOptString3 != null && strOptString3.equals("banner")) {
                adType = BrandSafetyUtils.AdType.BANNER;
            } else if (strOptString3 != null && strOptString3.equals("mrec")) {
                adType = BrandSafetyUtils.AdType.MREC;
            } else if (strOptString3 != null && strOptString3.equals("native")) {
                adType = BrandSafetyUtils.AdType.NATIVE;
            } else if (strOptString3 != null && strOptString3.equals("fullscreen")) {
                adType = BrandSafetyUtils.AdType.INTERSTITIAL;
            }
            BrandSafetyEvent.AdFormatType adFormatType = null;
            if (adType == BrandSafetyUtils.AdType.INTERSTITIAL) {
                if (str != null && aS.containsKey(str)) {
                    if (aS.get(str).booleanValue()) {
                        adFormatType = BrandSafetyEvent.AdFormatType.REWARD;
                    } else {
                        adFormatType = BrandSafetyEvent.AdFormatType.INTER;
                    }
                    Logger.d(o, "get CI from Json process placements placement " + str + " is " + adFormatType);
                } else {
                    Logger.d(o, "get CI from Json process placements data does not contain the placement " + str + ", will try to determine based on REWARDED_VALUE");
                    adFormatType = jSONObject.optInt(Z) == aa ? BrandSafetyEvent.AdFormatType.REWARD : BrandSafetyEvent.AdFormatType.INTER;
                }
            } else if (adType.equals(BrandSafetyUtils.AdType.BANNER)) {
                adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
            } else if (adType.equals(BrandSafetyUtils.AdType.MREC)) {
                adFormatType = BrandSafetyEvent.AdFormatType.MREC;
            }
            List<String> listF2 = com.safedk.android.utils.n.f(jSONObject.toString());
            if (!TextUtils.isEmpty(str6) && !str6.contains(aB)) {
                com.safedk.android.utils.n.b(o, "get CI from Json clickUrl : " + str6);
            } else {
                str6 = null;
                com.safedk.android.utils.n.b(o, "get CI from Json clickUrl discarded : " + ((String) null));
            }
            String string9 = null;
            if (jSONObject.has("adType")) {
                string9 = jSONObject.getString("adType");
            } else if (jSONObject.has("ad_type")) {
                string9 = jSONObject.getString("ad_type");
            }
            if (string9 != null && "native".equals(strOptString3)) {
                string9 = string9 + RemoteSettings.FORWARD_SLASH_STRING + strOptString3;
            }
            Logger.d(o, "get CI from Json struct : " + string9);
            Logger.d(o, "get CI from Json adtype = " + (adType != null ? adType.name() : "null") + ", id: " + string + ", click url: " + str6 + ", creative id: " + string5 + ", video url: " + string7 + "postBundle = " + (string8 != null ? string8 : ""));
            VungleCreativeInfo vungleCreativeInfo = new VungleCreativeInfo(adType, string, string5, str6, string7, adFormatType, str, this.G, jCurrentTimeMillis, string9);
            if (!"native".equals(strOptString3)) {
                vungleCreativeInfo.b(listF2);
                vungleCreativeInfo.b(list);
            } else {
                a(vungleCreativeInfo, jSONObject, z);
            }
            if (str4 != null) {
                vungleCreativeInfo.m(str4);
            }
            if (str3 != null) {
                vungleCreativeInfo.i(str3);
            }
            if (z2) {
                c((CreativeInfo) vungleCreativeInfo, str2);
                FileUploadManager.a().a(new FileUploadManager.FileUploadData(aL, str2, vungleCreativeInfo.N()));
            }
            Logger.d(o, "get CI from Json - buyer id is: " + str4 + " and ad domain is: " + str3);
            synchronized (aR) {
                aR.put(string, vungleCreativeInfo);
            }
            if ("native".equals(strOptString3) && !z && aVar != null) {
                String str8 = aVar.c + "_" + aVar.f8068a + "_" + com.safedk.android.utils.h.d;
                Logger.d(o, "get CI from Json - saving native banner ad with id= " + str8);
                synchronized (aR) {
                    aR.put(str8, vungleCreativeInfo);
                }
            }
            if (string7 != null && !z) {
                vungleCreativeInfo.b(Arrays.asList(string7));
            }
            if (string8 != null && !z) {
                Logger.d(o, "get CI from Json adding zip files bundle " + string8 + " to prefetch resources");
                vungleCreativeInfo.c(Arrays.asList(string8));
            }
            if (mapA.size() > 0) {
                for (String str9 : mapA.values()) {
                    if (vungleCreativeInfo.u(str9)) {
                        Logger.d(o, "get CI from Json adding url to CI dsp domains: " + str9);
                        vungleCreativeInfo.w(str9);
                    }
                }
            }
            if (vungleCreativeInfo.p() == null && jSONObject.has(S)) {
                a(jSONObject.getString(S), vungleCreativeInfo, S);
            }
            if (vungleCreativeInfo.p() == null && jSONObject.has(T)) {
                a(jSONObject.getString(T), vungleCreativeInfo, T);
            }
            if (vungleCreativeInfo.p() == null && jSONObject.has(aw)) {
                vungleCreativeInfo.q(jSONObject.getString(aw));
                Logger.d(o, "app package name will be updated from ad_market_id to " + jSONObject.getString(aw));
            }
            if (vungleCreativeInfo.p() == null && jSONObject3 != null && jSONObject3.has(ax)) {
                a(jSONObject3.getString(ax), vungleCreativeInfo, ax);
            }
            if (vungleCreativeInfo.p() == null && jSONObject3 != null && jSONObject3.has("CTA_BUTTON_URL")) {
                a(jSONObject3.getString("CTA_BUTTON_URL"), vungleCreativeInfo, "CTA_BUTTON_URL");
            }
            if (vungleCreativeInfo.p() == null && jSONObject3 != null && jSONObject3.has(az)) {
                a(jSONObject3.getString(az), vungleCreativeInfo, az);
            }
            if (vungleCreativeInfo.p() == null && jSONObject4 != null && jSONObject4.has("clickUrl")) {
                Object obj = jSONObject4.get("clickUrl");
                if (obj instanceof String) {
                    a(jSONObject4.getString("clickUrl"), vungleCreativeInfo, "clickUrl");
                    return vungleCreativeInfo;
                }
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray2 = jSONObject4.getJSONArray("clickUrl");
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        if (vungleCreativeInfo.p() == null) {
                            a(jSONArray2.getString(i2), vungleCreativeInfo, "clickUrl_" + i2);
                        }
                    }
                    return vungleCreativeInfo;
                }
                return vungleCreativeInfo;
            }
            return vungleCreativeInfo;
        } catch (Throwable th2) {
            Logger.e(o, "get CI from Json object exception: " + th2.getMessage(), th2);
            return null;
        }
    }

    private static void a(CreativeInfo creativeInfo, JSONObject jSONObject, boolean z) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(as);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = jSONObject.optJSONObject(at);
        }
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(au);
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString = jSONObjectOptJSONObject2.optString("APP_NAME");
                if (!TextUtils.isEmpty(strOptString)) {
                    if (z) {
                        creativeInfo.z(CreativeInfo.aM + strOptString);
                    } else {
                        creativeInfo.y(strOptString);
                    }
                }
                String strOptString2 = jSONObjectOptJSONObject2.optString("APP_DESCRIPTION");
                if (!TextUtils.isEmpty(strOptString2)) {
                    if (z) {
                        creativeInfo.z(CreativeInfo.aP + strOptString2);
                    } else {
                        creativeInfo.y(strOptString2);
                    }
                }
                String strOptString3 = jSONObjectOptJSONObject2.optString("CTA_BUTTON_TEXT");
                if (!TextUtils.isEmpty(strOptString3)) {
                    if (z) {
                        creativeInfo.z(CreativeInfo.aQ + strOptString3);
                    } else {
                        creativeInfo.y(strOptString3);
                    }
                }
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(ac);
            if (jSONObjectOptJSONObject3 != null) {
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject("MAIN_IMAGE");
                if (jSONObjectOptJSONObject4 != null) {
                    String strOptString4 = jSONObjectOptJSONObject4.optString("url");
                    if (!TextUtils.isEmpty(strOptString4)) {
                        if (z) {
                            creativeInfo.z(CreativeInfo.aN + strOptString4);
                        } else {
                            creativeInfo.x(strOptString4);
                        }
                    }
                }
                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject3.optJSONObject("APP_ICON");
                if (jSONObjectOptJSONObject5 != null) {
                    String strOptString5 = jSONObjectOptJSONObject5.optString("url");
                    if (!TextUtils.isEmpty(strOptString5)) {
                        if (!z) {
                            creativeInfo.x(strOptString5);
                        } else {
                            creativeInfo.z(CreativeInfo.aO + strOptString5);
                        }
                    }
                }
            }
        }
    }

    private void a(String str, VungleCreativeInfo vungleCreativeInfo, String str2) {
        Logger.d(o, "handle app package name started, appPackageName = " + str);
        if (str != null) {
            str = com.safedk.android.utils.n.o(str);
        }
        if (str != null) {
            vungleCreativeInfo.q(str);
            Logger.d(o, "app package name will be updated from " + str2 + " to " + str);
        } else {
            Logger.d(o, "app package name from " + str2 + " not valid, skipping value " + str);
        }
    }

    private HashMap<String, String> a(JSONObject jSONObject, String str) {
        HashMap<String, String> map = new HashMap<>();
        try {
            if (jSONObject.has("tpat")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("tpat");
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String string = itKeys.next().toString();
                    if (jSONObject2.get(string) instanceof JSONArray) {
                        JSONArray jSONArray = jSONObject2.getJSONArray(string);
                        Logger.d(o, "iterating over key '" + string + "' , content: " + jSONArray.toString());
                        if (jSONArray.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                if (!map.values().contains(jSONArray.getString(i2))) {
                                    map.put(string + "_" + i2, jSONArray.getString(i2));
                                    Logger.d(o, "collecting additional url: " + jSONArray.getString(i2));
                                } else {
                                    Logger.d(o, "url already in map. skipping: " + jSONArray.getString(i2));
                                }
                            }
                        }
                    } else {
                        Logger.d(o, "key '" + string + "' is not a JSONArray, skipping");
                    }
                }
            } else {
                Logger.d(o, "tpat key does not exist, exiting");
            }
        } catch (JSONException e2) {
            Logger.e(o, "Error collecting urls under tpat key", e2);
        }
        return map;
    }

    private VungleCreativeInfo a(File file) {
        if (file == null) {
            Logger.d(o, "get ad ID by video file - file is null");
            return null;
        }
        String strC = C(file.getAbsolutePath());
        Logger.d(o, "get ad ID by video file - creative to ID map iteration, looking for '" + strC + "', key set: " + aP.keySet().toString());
        if (aP != null && strC != null) {
            synchronized (aP) {
                VungleCreativeInfo vungleCreativeInfoRemove = aP.remove(strC);
                if (vungleCreativeInfoRemove != null) {
                    Logger.d(o, "get ad ID by video file - CI MATCH! creative found: " + strC);
                    return vungleCreativeInfoRemove;
                }
                Iterator<String> it = aP.keySet().iterator();
                while (it.hasNext()) {
                    VungleCreativeInfo vungleCreativeInfo = aP.get(it.next());
                    if (vungleCreativeInfo.P().equals(strC)) {
                        Logger.d(o, "get ad ID by video file - CI MATCH! creative found: " + strC);
                        return vungleCreativeInfo;
                    }
                }
            }
        }
        Logger.d(o, "get ad ID by video file - creative not found");
        return null;
    }

    private String C(String str) {
        if (str != null && str.split(RemoteSettings.FORWARD_SLASH_STRING).length > 1) {
            String str2 = str.split(RemoteSettings.FORWARD_SLASH_STRING)[str.split(RemoteSettings.FORWARD_SLASH_STRING).length - 2];
            Logger.d(o, "ad ID to be searched: " + str2);
            return str2;
        }
        Logger.d(o, "file path is not according to the expected pattern: " + str + ", cannot extract CreativeId");
        return null;
    }

    private boolean b(JSONObject jSONObject) throws JSONException {
        if (!((JSONObject) jSONObject.get(c)).has(ag)) {
        }
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        return new HashSet();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
        com.safedk.android.utils.e.a(aP, "VungleDiscovery:creativeToIdMap");
        com.safedk.android.utils.e.a(aQ, "VungleDiscovery:mediaPlayerIdToCreativeInfo");
        com.safedk.android.utils.e.a(aR, "VungleDiscovery:adToIdMap");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public RedirectDetails.RedirectType k(String str) {
        if (str != null && str.startsWith("mraid://")) {
            if (str.contains("open")) {
                return RedirectDetails.RedirectType.REDIRECT;
            }
            return null;
        }
        return RedirectDetails.RedirectType.REDIRECT;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String l(String str) {
        if (str != null && str.contains("mraid://")) {
            return com.safedk.android.utils.k.d(str, "url");
        }
        return str;
    }
}
