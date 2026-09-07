package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.mediation.MaxAd;
import com.applovin.sdk.AppLovinAdSize;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.RedirectDetails;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.AppLovinCreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
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
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends d {
    private static final String R = "AppLovinDiscovery";
    private static final String S = "json_v3!";
    private static final String T = "ad_size";
    private static final String U = "ad_format";
    private static final String V = "REWARD";
    private static final String W = "ad_type";
    private static final String X = "REGULAR";
    private static final String Y = "VIDEOA";
    private static final String Z = "zone_id";
    private static final String aA = "server_parameters";
    private static final String aB = "ortb_response";
    private static final String aC = "version";
    private static final String aD = "value";
    private static final String aE = "native";
    private static final String aF = "link";
    private static final String aG = "assets";
    private static final String aH = "title";
    private static final String aI = "text";
    private static final String aJ = "img";
    private static final String aK = "id";
    private static final String aL = "type";
    private static final String aM = "url";
    private static final String aN = "w";
    private static final String aO = "h";
    private static final String aP = "video";
    private static final String aQ = "vasttag";
    private static final String aR = "data";
    private static final String aS = "fallback";
    private static final String aT = "clicktrackers";
    private static final String aU = "imptrackers";
    private static final String aV = "eventtrackers";
    private static final String aW = "click_tracking_urls";
    private static final String aX = "manual";
    private static final String aY = "ad_info";
    private static final String aZ = "ad_unit_id";
    private static final String aa = "event_id";
    private static final String ab = "clcodes";
    private static final String ac = "dsp_name";
    private static final String ad = "is_js_tag_ad";
    private static final String ae = "html";
    private static final String af = "html_template";
    private static final String ag = "status";
    private static final String ah = "ads";
    private static final String ai = "click_url";
    private static final String aj = "&listing=";
    private static final String ak = "video";
    private static final String al = "ad_id";
    private static final String am = "clcode";
    private static final String an = "bid_response";
    private static final String ao = "creative_id";
    private static final String ap = "adomain";
    private static final String aq = "third_party_ad_placement_id";
    private static final String ar = "xml";
    private static final String as = "stream_url";
    private static final String at = "network_name";
    private static final String au = "HOSTED_HTML_UNIVERSAL_VIDEO";
    private static final String av = "HOSTED_HTML_UNIVERSAL_REWARD";
    private static final String aw = "HOSTED_HTML_UNIVERSAL";
    private static final String ax = "res1.applovin.com";
    private static final String ay = "/collage";
    public static final String b = "video";
    private static MessageDigest bB = null;
    private static final String ba = "name";
    private static final int bb = 200;
    private static String bd = null;
    private static final int be = 15;
    private static final String bl = "&current_retry_attempt=";
    private static final String bm = "(function(){var sdkId=\"{{SDK_ID}}\";var address=\"{{ADDRESS}}\";var log=function(message){try{if(typeof window.SafeDKWebAppInterface.logMessage===\"function\"){window.SafeDKWebAppInterface.logMessage(message)}else{console.log(\"SafeDKWebApInterface log object missing\")}}catch(error){}};var isElementOnTop=function(element){var rect=element.getBoundingClientRect();var x=rect.left+rect.width/2;var y=rect.top+rect.height/2;var topElement=document.elementFromPoint(x,y);var result=element===topElement||element.contains(topElement);log(\"is element on top: \"+result);return result};var addObservers=function(){try{var isContainerExpanded=false;var privacyElements=[];var isContainerExpanded=false;var elementBigAd=document.getElementById(\"al_bigAdInfo\");if(elementBigAd){privacyElements.push(elementBigAd)}var elementOutput=document.getElementById(\"al_optout_container_expanded\");if(elementOutput){privacyElements.push(elementOutput);isContainerExpanded=true}var backgroundElements=document.querySelectorAll('div[class^=\"_background_\"]');if(backgroundElements.length>0){for(var i=0;i<backgroundElements.length;i++){privacyElements.push(backgroundElements[i])}}for(var j=0;j<privacyElements.length;j++){var privacyElement=privacyElements[j];if(privacyElement&&privacyElement.style){var displayState=privacyElement.style.display;var visibility=getComputedStyle(privacyElement).visibility;var isVisible=visibility==\"visible\";if(isContainerExpanded&&isVisible){isVisible=privacyElement.offsetWidth!=0&&privacyElement.offsetHeight!=0}var privacyElementText=privacyElement.textContent.trim();var isInstallText=privacyElementText!=null&&privacyElementText.toLowerCase().includes(\"install\");var isSingleWord=privacyElementText.trim().split(/\\s+/).length===1;if((!isSingleWord||!isInstallText)&&(displayState!=\"none\"&&displayState!=\"\"||isVisible)){if(typeof window.SafeDKWebAppInterface.requestNoSampling===\"function\"){window.SafeDKWebAppInterface.requestNoSampling(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}else{if(privacyElement.safedkPrivacyDialogObserver!=true){privacyElement.safedkPrivacyDialogObserver=true;try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){switch(mutation.type){case\"attributes\":var isVisible=getComputedStyle(mutation.target).visibility==\"visible\";if(mutation.target.id==\"al_optout_container_expanded\"){isVisible=mutation.target.offsetWidth!=0&&mutation.target.offsetHeight!=0}var composedStyle=getComputedStyle(mutation.target).display;var privacyElementText=privacyElement.textContent.trim();var isInstallText=privacyElementText!=null&&privacyElementText.toLowerCase().includes(\"install\");var isSingleWord=privacyElementText.trim().split(/\\s+/).length===1;if((!isSingleWord||!isInstallText)&&(isVisible||composedStyle==\"block\"||composedStyle!=\"none\"&&displayState!=\"\")){if(typeof window.SafeDKWebAppInterface.requestNoSampling===\"function\"){window.SafeDKWebAppInterface.requestNoSampling(sdkId,address,window.outerHeight,window.outerWidth)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}break}})});var config={attributes:true,attributeOldValue:true,attributeFilter:[\"style\",\"class\"]};observer.observe(privacyElement,config)}catch(error){if(typeof window.SafeDKWebAppInterface.postMessage===\"function\"){window.SafeDKWebAppInterface.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface SafeDKWebAppInterface object missing\")}}}}}}}catch(error){if(typeof window.SafeDKWebAppInterface.postMessage===\"function\"){window.SafeDKWebAppInterface.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface SafeDKWebAppInterface object missing\")}}};addObservers();try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){for(var i=0;i<mutation.addedNodes.length;i++){var node=mutation.addedNodes[i];if(node&&node.nodeName!=\"#text\"){addObservers()}}})});var config={childList:true,subtree:true};observer.observe(document,config)}catch(error){if(typeof window.SafeDKWebAppInterface.postMessage===\"function\"){window.SafeDKWebAppInterface.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface SafeDKWebAppInterface object missing\")}}})();\n";
    private static final String bn = "{PLACEMENT}";
    private static final String bo = "(\\/)([A-Za-z0-9]{8}_)([^'\"\\?]*?['\"\\?])";
    private static final String bp = "(ad[-_A-Za-z_\\/]+[0-9]*[_\\/])(index\\.js)";
    private static final String bq = "(?:file|http[s]?):\\/{2,3}.*?([^\\/'\\\"\\?]*)(['\\\"\\?])";
    private static final String br = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    private static final String bs = "(<head>\\s*)(<script.*?</script>)";
    private static final String bt = "open";
    private static final String bu = "redirectUrl";
    private static final String bv = "endcard";
    private static final String bw = "productCatalog";
    private static final String bx = "productCatalogBannerImageUrl";
    private static final String by = "imageUrl";
    public static final String c = "playable";
    public static final String d = "metaData";
    public static final String e = "creativeSetId";
    public static final String f = "ah_parameters";
    public static final String g = "ad.package_name";
    public static final String h = "template";
    public static final String i = ".applovin.com/redirect";
    public static final String j = "n";
    public static final String k = "applovin://com.applovin.sdk/adservice/expand_ad";
    public static final String l = "SSP_MRAID";
    public static final String n = "APPLOVIN_EXCHANGE";
    public static final String o = "APPLOVIN_NETWORK";
    public static final String p = "APPLOVIN_DIRECTSOLD";
    private final ConcurrentHashMap<String, CreativeInfo> bh;
    private final ConcurrentHashMap<String, CreativeInfo> bi;
    private final Map<String, a> bj;
    private final LimitedConcurrentHashMap<String, String> bk;
    private static final String[] az = {"jpeg", "jpg", "png", "gif", "raw"};
    public static final String[] m = {"applovin://com.applovin.sdk/webview_event"};
    private static final LimitedConcurrentHashMap<String, WeakReference<WebView>> bf = new LimitedConcurrentHashMap<>(15);
    private static final LimitedConcurrentHashMap<String, String> bg = new LimitedConcurrentHashMap<>(15);
    private static final List<String> bz = Arrays.asList("a.applovin.com/4.0/ad", "a.applvn.com/4.0/ad", "a4.applovin.com/4.0/ad", "a4.applvn.com/4.0/ad");
    private static boolean bA = false;
    private static final String bc = "BANNER_NATIVE";
    public static List<String> q = Arrays.asList("BANNER_GRAPHIC_BLANK_UNIFIED", "BANNER_STOREKIT", bc, "BANNER_STOREASSETS");

    static {
        try {
            bB = MessageDigest.getInstance("SHA-256");
        } catch (Throwable th) {
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f8069a = 1;
        private static final int b = 2;
        private static final int c = 3;
        private static final int d = 4;
        private static final int e = 5;
        private static final int f = 6;
        private static final int g = 7;
        private static final int h = 8;
        private static final int i = 1;
        private static final int j = 3;
        private static final int k = 1;
        private static final int l = 2;
        private static final int m = 12;
        private static final int n = -1;

        private b() {
        }
    }

    public static void h() {
        bA = true;
    }

    public c() {
        super(com.safedk.android.utils.h.f8160a, R);
        this.bh = new ConcurrentHashMap<>();
        this.bi = new ConcurrentHashMap<>();
        this.bj = new HashMap();
        this.bk = new LimitedConcurrentHashMap<>(15);
        bd = com.safedk.android.utils.n.a();
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_FULLSCREEN_ADS, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_MRECS, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_BANNERS, true);
        this.C.b(AdNetworkConfiguration.JS_PRIVACY_BUTTON_CLICK_DETECTION_SCRIPT, bm);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION_BY_MAX_EVENT, true);
        this.C.b(AdNetworkConfiguration.REPLACE_PREFETCH_CREATIVE_ID_WITH_MAX_CREATIVE_ID, true);
        this.C.b(AdNetworkConfiguration.REPLACE_PREFETCH_CREATIVE_ID_WITH_MAX_CREATIVE_ID_MAX_NETWORK_NAMES, "APPLOVIN_EXCHANGE");
        this.C.b(AdNetworkConfiguration.DONT_USE_PLACEMENT_ID_IN_BANNER_AD_INFO_KEY, "APPLOVIN_NETWORK_&_APPLOVIN_DIRECTSOLD");
        this.C.a(AdNetworkConfiguration.FULL_SCREEN_CI_MAX_AGE, 4800000L);
        this.C.a(AdNetworkConfiguration.BANNER_CI_MAX_AGE, 4800000L);
        AsyncTask.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.creatives.discoveries.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.safedk.android.analytics.brandsafety.creatives.h.b("<vast><ad id=\"stam\"></ad></vast>", false, "");
            }
        });
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> a(String str, String str2, byte[] bArr, Map<String, List<String>> map, a aVar) {
        int iIndexOf = str.indexOf(bl);
        return super.a(iIndexOf > -1 ? str.substring(0, iIndexOf) : str, str2, bArr, map, aVar);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, a aVar, byte[] bArr) throws JSONException {
        String string;
        String str3;
        a aVar2;
        Logger.d(R, "generate info, url: " + str);
        ArrayList arrayList = new ArrayList();
        try {
            if (!com.safedk.android.utils.n.l(str2)) {
                return new ArrayList();
            }
            JSONObject jSONObject = new JSONObject(str2);
            if (!jSONObject.has("ads")) {
                return new ArrayList();
            }
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("ads");
                if (jSONArray.length() != 0 && jSONObject.getInt("status") == 200) {
                    String strOptString = jSONObject.optString(am);
                    Logger.d(R, "adId = " + strOptString);
                    if (TextUtils.isEmpty(strOptString) && !bA) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(ab);
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            strOptString = jSONArrayOptJSONArray.getString(0);
                        } else {
                            String strOptString2 = jSONObject.optString("ad_format", null);
                            String strOptString3 = jSONObject.optString("event_id");
                            if (strOptString2 != null) {
                                try {
                                    aVar2 = new a(this, strOptString3, BrandSafetyEvent.AdFormatType.valueOf(strOptString2));
                                } catch (IllegalArgumentException e2) {
                                    Logger.d(R, "generate info, Max prefetch parameters: unsupported ad format=" + strOptString2);
                                    return null;
                                }
                            } else {
                                aVar2 = new a(strOptString3);
                            }
                            Logger.d(R, "generate info, Max prefetch parameters: eventId=" + aVar2.f8068a + ", adFormat=" + aVar2.b);
                            a(str, map, jSONArray, aVar2);
                            return null;
                        }
                    }
                    BrandSafetyUtils.AdType adType = null;
                    BrandSafetyEvent.AdFormatType adFormatType = null;
                    if (jSONObject.has("ad_size")) {
                        String string2 = jSONObject.getString("ad_size");
                        Logger.d(R, "generate info, json ad_size is " + string2);
                        if ("BANNER".equals(string2) || BrandSafetyUtils.n.equals(string2)) {
                            adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
                            adType = BrandSafetyUtils.AdType.BANNER;
                        } else if (BrandSafetyUtils.o.equals(string2)) {
                            adFormatType = BrandSafetyEvent.AdFormatType.MREC;
                            adType = BrandSafetyUtils.AdType.MREC;
                        } else if ("NATIVE".equals(string2)) {
                            adFormatType = BrandSafetyEvent.AdFormatType.NATIVE;
                            adType = BrandSafetyUtils.AdType.NATIVE;
                        } else {
                            adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                        }
                        Logger.d(R, "generate info, json ad_size : ad format = " + adFormatType + ", ad type = " + adType + ", ad_format = " + (jSONObject.has("ad_format") ? jSONObject.get("ad_format") : "NA"));
                    } else {
                        if (jSONObject.has("ad_format")) {
                            String string3 = jSONObject.getString("ad_format");
                            Logger.d(R, "generate info, json ad_format is " + string3);
                            if (string3.equals("BANNER") || string3.equals(BrandSafetyUtils.n)) {
                                adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
                                adType = BrandSafetyUtils.AdType.BANNER;
                            } else if (string3.equals(BrandSafetyUtils.o)) {
                                adFormatType = BrandSafetyEvent.AdFormatType.MREC;
                                adType = BrandSafetyUtils.AdType.MREC;
                            } else if (string3.equals("NATIVE")) {
                                adFormatType = BrandSafetyEvent.AdFormatType.NATIVE;
                                adType = BrandSafetyUtils.AdType.NATIVE;
                            } else if (string3.equals(BrandSafetyUtils.j)) {
                                adFormatType = BrandSafetyEvent.AdFormatType.INTER;
                                adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                            } else if (string3.equals(V)) {
                                adFormatType = BrandSafetyEvent.AdFormatType.REWARD;
                                adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                            } else if (string3.equals(BrandSafetyUtils.l)) {
                                adFormatType = BrandSafetyEvent.AdFormatType.APPOPEN;
                                adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                            }
                            Logger.d(R, "generate info, prefetch parameters adFormat: " + adFormatType);
                        } else {
                            Logger.d(R, "generate info, json ad_format has no value, setting ad type to default : INTERSTITIAL ");
                            adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                        }
                        Logger.d(R, "generate info, json ad_format result : ad format = " + adFormatType + " , ad type = " + adType.name());
                    }
                    if (!jSONObject.has("ad_type")) {
                        string = null;
                    } else {
                        string = jSONObject.getString("ad_type");
                    }
                    String strB = b(jSONObject);
                    Logger.d(R, "generate info, placementId = " + strB);
                    String strOptString4 = jSONObject.optString("event_id", null);
                    Logger.d(R, "generate info, eventId = " + strOptString4);
                    if (aVar != null) {
                        Logger.d(R, "generate info, got MAX prefetch parameters: " + aVar);
                        adFormatType = aVar.b;
                        str3 = aVar.f8068a;
                    } else {
                        a aVarRemove = this.bj.remove(strOptString);
                        if (aVarRemove != null) {
                            Logger.d(R, "generate info, find MAX prefetch parameters: " + aVarRemove);
                            str3 = aVarRemove.f8068a;
                            if (strB == null || strB.isEmpty()) {
                                strB = aVarRemove.c;
                            }
                            if (aVarRemove.b != null) {
                                if (aVarRemove.b.name().equals("BANNER") || aVarRemove.b.name().equals(BrandSafetyUtils.n)) {
                                    adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
                                    adType = BrandSafetyUtils.AdType.BANNER;
                                } else if (aVarRemove.b.name().equals(BrandSafetyUtils.o)) {
                                    adFormatType = BrandSafetyEvent.AdFormatType.MREC;
                                    adType = BrandSafetyUtils.AdType.MREC;
                                } else if (aVarRemove.b.name().equals("NATIVE")) {
                                    adFormatType = BrandSafetyEvent.AdFormatType.NATIVE;
                                    adType = BrandSafetyUtils.AdType.NATIVE;
                                } else if (aVarRemove.b.name().equals(BrandSafetyUtils.j)) {
                                    adFormatType = BrandSafetyEvent.AdFormatType.INTER;
                                    adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                                } else if (aVarRemove.b.name().equals(V)) {
                                    adFormatType = BrandSafetyEvent.AdFormatType.REWARD;
                                    adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                                } else if (aVarRemove.b.name().equals(BrandSafetyUtils.l)) {
                                    adFormatType = BrandSafetyEvent.AdFormatType.APPOPEN;
                                    adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                                }
                            }
                            Logger.d(R, "generate info, MAX prefetch parameters adFormat: " + adFormatType);
                        } else {
                            Logger.d(R, "generate info, no MAX prefetch parameters found for adId: " + strOptString + ", eventId: " + strOptString4);
                            return arrayList;
                        }
                    }
                    Logger.d(R, "generate info, adTypeJson = " + string);
                    if (adFormatType == null && string != null && string.equals(Y)) {
                        adFormatType = BrandSafetyEvent.AdFormatType.REWARD;
                    }
                    Logger.d(R, "generate info, ad format = " + adFormatType);
                    String strOptString5 = jSONObject.optString("dsp_name");
                    Logger.d(R, "generate info, dsp name = " + strOptString5);
                    Logger.d(R, "generate info, network name = " + jSONObject.optString("network_name"));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        com.safedk.android.utils.n.b(R, "generate info, json object is " + jSONObject2.toString());
                        CreativeInfo creativeInfoA = null;
                        if (jSONObject2.has("html") || jSONObject2.has(af)) {
                            creativeInfoA = a(strOptString, adType, adFormatType, strB, str3, strOptString5, jSONObject2, str);
                        } else if (jSONObject2.has(aB)) {
                            creativeInfoA = a(strOptString, adType, adFormatType, strB, strOptString5, str3, jSONObject2);
                        }
                        if (creativeInfoA != null) {
                            if (aVar != null) {
                                if (aVar.e != null) {
                                    creativeInfoA.i(aVar.e);
                                    Logger.d(R, "generate info, setting adDomain : " + aVar.e);
                                }
                                if (aVar.f != null && creativeInfoA.M() == BrandSafetyUtils.AdType.NATIVE) {
                                    String strH = creativeInfoA.h();
                                    if (TextUtils.isEmpty(strH)) {
                                        creativeInfoA.e(aVar.f);
                                    } else {
                                        creativeInfoA.e(strH + RemoteSettings.FORWARD_SLASH_STRING + aVar.f);
                                    }
                                    Logger.d(R, "generate info, setting native template: " + aVar.f);
                                }
                            }
                            e(creativeInfoA);
                            arrayList.add(creativeInfoA);
                            com.safedk.android.utils.n.b(R, "generate info, added CI: " + creativeInfoA);
                        }
                    }
                }
                return null;
            } catch (JSONException e3) {
                com.safedk.android.utils.n.b(R, "Cannot parse json, skipping.");
                return new ArrayList();
            }
        } catch (Throwable th) {
            Logger.d(R, "generate info, exception parsing prefetch: " + th.getMessage(), th);
        }
        return arrayList;
    }

    private void e(CreativeInfo creativeInfo) {
        int i2;
        HashSet<String> hashSetR = creativeInfo.r();
        if (hashSetR != null) {
            i2 = 0;
            for (String str : hashSetR) {
                if (str.contains(ax)) {
                    for (String str2 : az) {
                        if (str.endsWith(str2)) {
                            i2++;
                        }
                    }
                }
                i2 = i2;
            }
        } else {
            i2 = 0;
        }
        Logger.d(R, "set e-commerce collage ad - counter= " + i2);
        if (i2 >= 3) {
            creativeInfo.d(true);
            creativeInfo.f(ay);
        }
    }

    private String a(JSONObject jSONObject, String str, String str2, String str3) {
        String strReplace = null;
        if (str2 != null && str2.startsWith(l)) {
            Logger.d(R, "extract clickUrl - SSP Mraid - not extracting click url from prefetch");
        } else {
            String strOptString = jSONObject.optString("click_url", null);
            if (strOptString == null || !strOptString.startsWith(aj)) {
                strReplace = strOptString;
            } else {
                Logger.d(R, "extract clickUrl - clickUrl extraction from json is invalid, will be set to null. clickUrl= " + strOptString);
            }
            if (strReplace == null && !TextUtils.isEmpty(str)) {
                strReplace = E(str);
                if (strReplace == null) {
                    strReplace = a(com.safedk.android.utils.g.aw(), str);
                }
                if (strReplace == null) {
                    strReplace = a(com.safedk.android.utils.g.av(), str);
                }
                if (strReplace == null && (strReplace = a(com.safedk.android.utils.g.ao(), str)) != null && strReplace.startsWith("javascript:")) {
                    strReplace = i(strReplace, str);
                }
                if (strReplace == null && str3 != null && q.contains(str3.trim().split(" ")[0])) {
                    strReplace = a(com.safedk.android.utils.g.ap(), str);
                    Logger.d(R, "extract clickUrl - clickUrl ad, " + str3 + " = " + strReplace);
                }
            }
            if (strReplace == null && !TextUtils.isEmpty(str)) {
                Logger.d(R, "extract clickUrl - click_url attempting extracting Mraid click url on html " + str);
                Matcher matcher = com.safedk.android.utils.g.aP().matcher(str);
                if (matcher.find() && matcher.group(2) != null) {
                    try {
                        strReplace = matcher.group(2).replace("\\/", RemoteSettings.FORWARD_SLASH_STRING);
                        Logger.d(R, "extract clickUrl - click_url extracting via Mraid click url regex : " + strReplace);
                    } catch (Throwable th) {
                        Logger.d(R, "Exception extracting Mraid click url : " + th.getMessage(), th);
                    }
                }
            }
            Logger.d(R, "extract clickUrl - downstream struct: " + str2 + " click url is: " + strReplace);
        }
        return strReplace;
    }

    private String i(String str, String str2) {
        Logger.d(R, "resolve click url started with click url: " + str);
        String strSubstring = str.substring("javascript:".length());
        if (strSubstring.endsWith(";")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        if (strSubstring.endsWith("()")) {
            strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
        }
        Matcher matcher = com.safedk.android.utils.g.b(strSubstring).matcher(str2);
        if (matcher.find() && matcher.group(1) != null) {
            try {
                str = matcher.group(1);
                Logger.d(R, "resolve click url - click_url extracting via target url regex : " + str);
                return str;
            } catch (Throwable th) {
                Logger.d(R, "Exception extracting resolve click url: " + th.getMessage(), th);
                return str;
            }
        }
        return str;
    }

    private void b(String str, CreativeInfo creativeInfo) {
        try {
            Matcher matcher = com.safedk.android.utils.g.be().matcher(str);
            if (matcher.find() && matcher.groupCount() > 0) {
                String strTrim = matcher.group(1).trim();
                Logger.d(R, strTrim);
                JSONObject jSONObject = new JSONObject(strTrim);
                if (jSONObject.has("open")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("open");
                    if (jSONObject2.has(bu)) {
                        String string = jSONObject2.getString(bu);
                        Logger.d(R, "extract applovin catalog data - found redirect url: " + string);
                        if (TextUtils.isEmpty(creativeInfo.O())) {
                            creativeInfo.a(string, true);
                        }
                    }
                }
                if (jSONObject.has("endcard")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("endcard");
                    if (jSONObject3.has(bw)) {
                        JSONArray jSONArray = jSONObject3.getJSONArray(bw);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            String string2 = jSONArray.getJSONObject(i2).getString("imageUrl");
                            Logger.d(R, "extract applovin catalog data - found image url: " + string2);
                            creativeInfo.x(string2);
                        }
                    }
                    if (jSONObject3.has(bx)) {
                        String string3 = jSONObject3.getString(bx);
                        Logger.d(R, "extract applovin catalog data - found product catalog: " + string3);
                        creativeInfo.x(string3);
                    }
                }
            }
        } catch (Exception e2) {
            Logger.d(R, "extract applovin catalog data - exception occurred: ", e2);
        }
    }

    private CreativeInfo a(String str, BrandSafetyUtils.AdType adType, BrandSafetyEvent.AdFormatType adFormatType, String str2, String str3, String str4, JSONObject jSONObject, String str5) throws JSONException {
        String str6;
        String str7;
        String strOptString = jSONObject.optString("html");
        if (adType != BrandSafetyUtils.AdType.BANNER && adType != BrandSafetyUtils.AdType.MREC) {
            str6 = null;
            str7 = null;
        } else {
            String strB = B(strOptString);
            String strA = a(com.safedk.android.utils.g.au(), strOptString);
            com.safedk.android.utils.n.b(R, "parse ad, prefetch bannerType = " + strA + ", html hash = " + strB + ", content = " + strOptString);
            str6 = strA;
            str7 = strB;
        }
        String strOptString2 = TextUtils.isEmpty(strOptString) ? jSONObject.optString(af) : strOptString;
        String strOptString3 = jSONObject.optString(as);
        String strOptString4 = jSONObject.optString("video");
        if (strOptString4.isEmpty()) {
            strOptString4 = a(com.safedk.android.utils.g.aq(), strOptString2);
        }
        String string = null;
        boolean zHas = false;
        String strA2 = a(com.safedk.android.utils.g.ar(), strOptString2);
        if (strA2 != null && com.safedk.android.utils.k.m(strA2)) {
            JSONObject jSONObject2 = new JSONObject(strA2);
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("video");
            if (jSONObjectOptJSONObject != null && TextUtils.isEmpty(strOptString4)) {
                strOptString4 = jSONObjectOptJSONObject.optString("url");
            }
            zHas = jSONObject2.has("playable");
            if (jSONObject2.has(d) && jSONObject2.getJSONObject(d).has(e)) {
                string = jSONObject2.getJSONObject(d).getString(e);
            }
            Logger.d(R, "parse ad, new template, video: " + strOptString4 + ", is playable? " + zHas + ", creativeId: " + string);
        }
        String str8 = strOptString4;
        String strA3 = a(com.safedk.android.utils.g.au(), strOptString2);
        if (strA3 != null) {
            strA3 = strA3.trim() + RemoteSettings.FORWARD_SLASH_STRING;
        } else if (zHas) {
            strA3 = "playable/";
        }
        boolean z = (TextUtils.isEmpty(str8) && TextUtils.isEmpty(strOptString3)) ? false : true;
        String strA4 = a(jSONObject, strOptString2, strA3, str6);
        String strF = F(strOptString2);
        if (TextUtils.isEmpty(strF)) {
            strF = a(jSONObject);
        }
        String strOptString5 = string == null ? jSONObject.optString("ad_id") : string;
        boolean zOptBoolean = false;
        if (jSONObject.has("network_name") && jSONObject.getString("network_name").equals(CreativeInfoManager.h) && jSONObject.has(ad)) {
            zOptBoolean = jSONObject.optBoolean(ad);
            Logger.d(R, "parse ad, field is_js_tag_ad value is " + zOptBoolean);
        }
        AppLovinCreativeInfo appLovinCreativeInfo = new AppLovinCreativeInfo(adType, str, strOptString5, strA4, str8, adFormatType, str2, bd, strA3, str4, str3, strF, z, zHas, zOptBoolean);
        b(strOptString2, (CreativeInfo) appLovinCreativeInfo);
        if (this.bk.containsKey(str5)) {
            String strRemove = this.bk.remove(str5);
            Logger.d(R, "parse ad - found ad unit id: " + strRemove + ", urlToAdUnitId contains the key url: " + str5);
            appLovinCreativeInfo.g(strRemove);
        } else {
            com.safedk.android.utils.n.b(R, "parse ad - urlToAdUnitId contains the key url: " + str5 + " the keys are: " + this.bk.keySet());
        }
        Logger.d(R, "parse ad, adding CI id: " + str + ", CI: " + appLovinCreativeInfo);
        if (adType.equals(BrandSafetyUtils.AdType.BANNER) || adType.equals(BrandSafetyUtils.AdType.MREC)) {
            String str9 = str2 + "_" + str3 + "_" + com.safedk.android.utils.h.f8160a;
            synchronized (this.bh) {
                this.bh.put(str9, appLovinCreativeInfo);
                if (str7 != null) {
                    bg.put(str, str7);
                    this.bh.put(str7, appLovinCreativeInfo);
                }
            }
        }
        String strOptString6 = jSONObject.optString(ar);
        if (!TextUtils.isEmpty(strOptString6)) {
            a((CreativeInfo) appLovinCreativeInfo, str5, strOptString6, true);
        }
        appLovinCreativeInfo.b((List<String>) com.safedk.android.utils.n.f(strOptString2));
        if (!TextUtils.isEmpty(strOptString2)) {
            appLovinCreativeInfo.a(str.hashCode());
        }
        ArrayList<String> arrayListC = null;
        if (com.safedk.android.utils.n.a(str5, bz) || (str6 != null && str6.contains(bc))) {
            arrayListC = C(strOptString2);
        }
        if (arrayListC != null && arrayListC.size() > 0) {
            for (String str10 : arrayListC) {
                Logger.d(R, "parse ad, json object text " + str10);
                appLovinCreativeInfo.y(str10);
            }
        }
        return appLovinCreativeInfo;
    }

    private String b(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("zone_id")) {
            return "";
        }
        String string = jSONObject.getString("zone_id");
        Logger.d(R, "generate info - found placement id in zone id - " + string);
        return string;
    }

    private CreativeInfo a(String str, BrandSafetyUtils.AdType adType, BrandSafetyEvent.AdFormatType adFormatType, String str2, String str3, String str4, JSONObject jSONObject) throws JSONException {
        String strOptString;
        String strOptString2 = jSONObject.optString("ad_id");
        JSONObject jSONObject2 = jSONObject.getJSONObject(aB);
        String strOptString3 = jSONObject2.optString("version");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("value");
        Logger.d(R, "parse native ad, rendering native ad for oRTB version: " + strOptString3);
        JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("native");
        if (jSONObjectOptJSONObject == null) {
            Logger.d(R, "parse native ad, no native object, continue...");
        } else {
            jSONObject3 = jSONObjectOptJSONObject;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("link");
        JSONArray jSONArray = jSONObject3.getJSONArray("assets");
        ArrayList arrayList = new ArrayList();
        String str5 = null;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= jSONArray.length()) {
                break;
            }
            JSONObject jSONObject4 = jSONArray.getJSONObject(i3);
            if (jSONObject4.has("title")) {
                JSONObject jSONObjectOptJSONObject3 = jSONObject4.optJSONObject("title");
                if (jSONObjectOptJSONObject3 != null) {
                    String strOptString4 = jSONObjectOptJSONObject3.optString("text");
                    if (!strOptString4.isEmpty()) {
                        arrayList.add(CreativeInfo.aM + strOptString4);
                        Logger.d(R, "parse native ad, processed title: " + strOptString4);
                    }
                }
            } else if (jSONObject4.has("link")) {
                jSONObjectOptJSONObject2 = jSONObject4.optJSONObject("link");
            } else if (jSONObject4.has("img")) {
                int iOptInt = jSONObject4.optInt("id", -1);
                JSONObject jSONObjectOptJSONObject4 = jSONObject4.optJSONObject("img");
                if (jSONObjectOptJSONObject4 != null) {
                    int iOptInt2 = jSONObjectOptJSONObject4.optInt("type", -1);
                    String strOptString5 = jSONObjectOptJSONObject4.optString("url");
                    if (!strOptString5.isEmpty()) {
                        if (3 == iOptInt || iOptInt2 == 1) {
                            arrayList.add(CreativeInfo.aO + strOptString5);
                            Logger.d(R, "parse native ad, processed icon URL: " + strOptString5);
                        } else if (2 == iOptInt || iOptInt2 == 3) {
                            arrayList.add(CreativeInfo.aN + strOptString5);
                            Logger.d(R, "parse native ad, processed main image URL: " + strOptString5);
                        } else {
                            Logger.d(R, "parse native ad, unrecognized image: " + jSONObject4);
                            int iOptInt3 = jSONObjectOptJSONObject4.optInt("w", -1);
                            int iOptInt4 = jSONObjectOptJSONObject4.optInt("h", -1);
                            if (iOptInt3 <= 0 || iOptInt4 <= 0) {
                                Logger.d(R, "parse native ad, skipping...");
                            } else if (iOptInt3 / iOptInt4 > 1.0d) {
                                Logger.d(R, "parse native ad, inferring main image from " + iOptInt3 + VastAttributes.HORIZONTAL_POSITION + iOptInt4 + ", processed main image URL: " + strOptString5);
                                arrayList.add(CreativeInfo.aN + strOptString5);
                            } else {
                                Logger.d(R, "parse native ad, inferring icon image from " + iOptInt3 + VastAttributes.HORIZONTAL_POSITION + iOptInt4 + ", processed icon URL: " + strOptString5);
                                arrayList.add(CreativeInfo.aO + strOptString5);
                            }
                        }
                    }
                }
            } else if (jSONObject4.has("video")) {
                JSONObject jSONObjectOptJSONObject5 = jSONObject4.optJSONObject("video");
                if (jSONObjectOptJSONObject5 != null) {
                    strOptString = jSONObjectOptJSONObject5.optString(aQ);
                    Logger.d(R, "parse native ad, processed VAST video: " + strOptString);
                } else {
                    strOptString = str5;
                }
                str5 = strOptString;
            } else if (jSONObject4.has("data")) {
                int iOptInt5 = jSONObject4.optInt("id", -1);
                JSONObject jSONObjectOptJSONObject6 = jSONObject4.optJSONObject("data");
                if (jSONObjectOptJSONObject6 != null) {
                    int iOptInt6 = jSONObjectOptJSONObject6.optInt("type", -1);
                    String strOptString6 = jSONObjectOptJSONObject6.optString("value");
                    if (!strOptString6.isEmpty()) {
                        if (iOptInt5 == 8 || iOptInt6 == 1) {
                            arrayList.add(CreativeInfo.aS + strOptString6);
                            Logger.d(R, "parse native ad, processed advertiser: " + strOptString6);
                        } else if (iOptInt5 == 4 || iOptInt6 == 2) {
                            arrayList.add(CreativeInfo.aP + strOptString6);
                            Logger.d(R, "parse native ad, processed body: " + strOptString6);
                        } else if (iOptInt5 == 5 || iOptInt6 == 12) {
                            arrayList.add(CreativeInfo.aQ + strOptString6);
                            Logger.d(R, "parse native ad, processed cta: " + strOptString6);
                        } else if (iOptInt5 == 6 || iOptInt6 == -1) {
                            arrayList.add(CreativeInfo.aR + strOptString6);
                            Logger.d(R, "parse native ad, processed star rating: " + strOptString6);
                        } else {
                            Logger.d(R, "parse native ad, skipping unsupported data: " + jSONObject4);
                        }
                    }
                }
            } else {
                Logger.d(R, "parse native ad, unsupported asset object: " + jSONObject4);
            }
            i2 = i3 + 1;
        }
        String strOptString7 = null;
        ArrayList arrayList2 = new ArrayList();
        if (jSONObjectOptJSONObject2 != null) {
            strOptString7 = jSONObjectOptJSONObject2.optString("url");
            Logger.d(R, "parse native ad, processed click destination URL: " + strOptString7);
            Logger.d(R, "parse native ad, processed click destination backup URL: " + jSONObjectOptJSONObject2.optString("fallback"));
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("clicktrackers");
            if (jSONArrayOptJSONArray != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    arrayList2.add(jSONArrayOptJSONArray.optString(i4));
                }
                Logger.d(R, "parse native ad, processed click trackers: " + arrayList2);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject3.optJSONArray("imptrackers");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i5 = 0; i5 < jSONArrayOptJSONArray2.length(); i5++) {
                arrayList2.add(jSONArrayOptJSONArray2.optString(i5));
            }
            Logger.d(R, "parse native ad, processed imp trackers: " + arrayList2);
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject3.optJSONArray("eventtrackers");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i6 = 0; i6 < jSONArrayOptJSONArray3.length(); i6++) {
                if (jSONArrayOptJSONArray3.get(i6) instanceof JSONObject) {
                    JSONObject jSONObject5 = jSONArrayOptJSONArray3.getJSONObject(i6);
                    if (jSONObject5.has("url")) {
                        arrayList2.add(jSONObject5.getString("url"));
                    }
                } else {
                    arrayList2.add(jSONArrayOptJSONArray3.getString(i6));
                }
            }
            Logger.d(R, "parse native ad, processed event trackers: " + arrayList2);
        }
        if (jSONObject.has(aW)) {
            arrayList2.add(jSONObject.getString(aW));
            Logger.d(R, "parse native ad, processed click tracking URLs: " + arrayList2);
        }
        AppLovinCreativeInfo appLovinCreativeInfo = new AppLovinCreativeInfo(adType, str, strOptString2, strOptString7, null, adFormatType, str2, bd, null, str3, str4, null, false, false, false);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            appLovinCreativeInfo.z((String) it.next());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            appLovinCreativeInfo.w((String) it2.next());
        }
        if (!TextUtils.isEmpty(str5)) {
            a((CreativeInfo) appLovinCreativeInfo, (String) null, str5, false);
            appLovinCreativeInfo.e("vast");
        }
        Logger.d(R, "parse native ad, new CI detected, ad ID: " + appLovinCreativeInfo.N() + ", event ID: " + appLovinCreativeInfo.n() + ", CI: " + appLovinCreativeInfo);
        synchronized (this.bi) {
            this.bi.put(str, appLovinCreativeInfo);
        }
        return appLovinCreativeInfo;
    }

    private String B(String str) {
        return com.safedk.android.utils.n.a(bB.digest(com.safedk.android.utils.n.a(str, com.safedk.android.utils.g.an(), 2, "").replace(bn, "").replaceAll(bo, "$1$3").replaceAll(bp, "$2").replaceAll(bq, "$1$2").replaceAll(br, "").replaceAll(bs, "$1").getBytes(Charset.defaultCharset())));
    }

    private ArrayList<String> C(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        String strA = a(com.safedk.android.utils.g.at(), str);
        String strA2 = a(com.safedk.android.utils.g.as(), str);
        Logger.d(R, "found ad text: title=" + strA + ", description=" + strA2);
        arrayList.add(strA);
        arrayList.add(strA2);
        return arrayList;
    }

    private void a(String str, Map<String, List<String>> map, JSONArray jSONArray, a aVar) throws JSONException {
        String str2;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String strOptString = jSONObject.optString("name");
                String strOptString2 = jSONObject.optString(an, null);
                String strOptString3 = jSONObject.optString("creative_id", null);
                String strOptString4 = jSONObject.optString("third_party_ad_placement_id");
                String strOptString5 = jSONObject.optString(ap, null);
                String strOptString6 = aX;
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(aA);
                if (jSONObjectOptJSONObject != null) {
                    strOptString6 = jSONObjectOptJSONObject.optString("template");
                    if (TextUtils.isEmpty(strOptString6)) {
                        strOptString6 = aX;
                    }
                }
                Logger.d(R, "parse Max prefetch response started url=" + str + " ,max params = " + aVar.toString());
                a aVar2 = new a(aVar.f8068a, aVar.b, strOptString4, strOptString3, strOptString5, strOptString6);
                if (CreativeInfoManager.a().contains(strOptString)) {
                    String strK = K(strOptString2);
                    if (strK != null) {
                        Logger.d(R, "parse Max prefetch response " + strOptString + " " + aVar2.b + " base64 bid response is " + strOptString2);
                        CreativeInfoManager.a(strOptString, str, strK, map, aVar2);
                    } else {
                        Logger.d(R, "parse Max prefetch response " + strOptString + " bidder " + aVar2.b + ", bid response is clcode " + strOptString2);
                        this.bj.put(strOptString2, aVar2);
                    }
                } else if (strOptString2 != null) {
                    if (CreativeInfoManager.a(CreativeInfoManager.b(strOptString), AdNetworkConfiguration.SHOULD_DECODE_BASE64_PREFECT_RECEIVED_BY_APPLOVIN, false)) {
                        try {
                            str2 = new String(Base64.decode(strOptString2, 0));
                        } catch (Throwable th) {
                            Logger.d(R, "Exception decoding payload : " + th.getMessage(), th);
                            str2 = strOptString2;
                        }
                    } else {
                        str2 = strOptString2;
                    }
                    Logger.d(R, "parse Max prefetch response " + strOptString + " " + aVar2.b + " bid response is " + str2);
                    CreativeInfoManager.a(strOptString, str, str2, map, aVar2);
                } else {
                    Logger.d(R, "parse Max prefetch response " + strOptString + " " + aVar2.b + " bid response empty.");
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private static String K(String str) {
        if (str != null) {
            String[] strArrSplit = str.split("!");
            if (strArrSplit.length == 2) {
                return new String(Base64.decode(strArrSplit[1], 0));
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        Logger.d(R, "should follow get url: " + str);
        return str.contains("4.0/ad");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d A[PHI: r5
  0x004d: PHI (r5v1 java.lang.String) = (r5v0 java.lang.String), (r5v3 java.lang.String) binds: [B:3:0x0009, B:5:0x001e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        boolean z;
        int iIndexOf = str.indexOf(bl);
        if (iIndexOf > -1) {
            str = I(str.substring(0, iIndexOf));
            if (this.D.containsKey(new com.safedk.android.analytics.brandsafety.creatives.i(str))) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        boolean z2 = z || str.contains("4.0/ad") || CreativeInfoManager.h(str);
        if (z2) {
            Logger.d(R, "should follow input stream: " + str);
        }
        return z2;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String c(String str, String str2) {
        return a(str, str2, (WeakReference<WebView>) null);
    }

    private String L(String str) {
        Logger.d(R, "get ad ID from resource: url is an html doc");
        Matcher matcher = com.safedk.android.utils.g.bc().matcher(str);
        if (matcher.find() && matcher.groupCount() >= 1) {
            String strGroup = matcher.group(1);
            Logger.d(R, "get ad ID from resource: found ad id using applovin window clcode pattern in html, adId = " + strGroup);
            return strGroup;
        }
        Matcher matcher2 = com.safedk.android.utils.g.bd().matcher(str);
        if (!matcher2.find() || matcher2.groupCount() < 1) {
            return null;
        }
        String strGroup2 = matcher2.group(1);
        Logger.d(R, "get ad ID from resource: found ad id using applovin json clcode pattern in html, adId = " + strGroup2);
        return strGroup2;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        String strL;
        com.safedk.android.utils.n.b(R, "get ad ID from resource started, url: " + str2 + ", value: " + str);
        if (str2 != null) {
            try {
                if (com.safedk.android.utils.k.j(str2)) {
                    String strL2 = L(str2);
                    if (strL2 != null) {
                        return strL2;
                    }
                } else {
                    String[] strArrSplit = str2.split("clcode=");
                    if (strArrSplit.length > 1) {
                        String[] strArrSplit2 = strArrSplit[1].split("\"|\\&|&");
                        if (strArrSplit2.length > 0) {
                            String str3 = strArrSplit2[0];
                            Logger.d(R, "get ad ID from resource: CI MATCH, adId = " + str3);
                            return str3;
                        }
                    } else {
                        Logger.d(R, "get ad ID from resource: cant split string by clcode, url: " + str2);
                    }
                }
                if (str != null && !str.equals(str2) && com.safedk.android.utils.k.j(str) && (strL = L(str)) != null) {
                    return strL;
                }
            } catch (Exception e2) {
                Logger.d(R, "get ad ID from resource: cant extract ad id from: " + str2, e2);
            }
        } else if (str != null) {
            return strL;
        }
        if (com.safedk.android.utils.k.j(str)) {
            String strB = B(str);
            Logger.d(R, "get ad ID from resource: the banner hash is: " + strB);
            if (bf.containsKey(strB)) {
                Logger.d(R, "get ad ID from resource: bannerHtmlHash already in sourceToWebviewRef map - bannerHtmlHash=" + strB);
            }
            if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                bf.put(strB, weakReference);
            } else {
                Logger.d(R, "get ad id from resource - webview is null, not storing bannerHtmlHash in sourceToWebviewRef");
            }
            if (this.bh.containsKey(strB)) {
                CreativeInfo creativeInfo = this.bh.get(strB);
                if (creativeInfo != null) {
                    String strN = creativeInfo.N();
                    Logger.d(R, "get ad ID from resource: CI MATCH! : id = " + strN + ", ci : " + creativeInfo.aa());
                    if (bg.containsKey(strN)) {
                        Logger.d(R, "get ad ID from resource: ad id already in adIdToSource map - adId=" + strN);
                    }
                    bg.put(strN, strB);
                    return strN;
                }
                Logger.d(R, "get ad ID from resource: failed to mach by html hash. will try to extract ad id...");
                String strA = a(com.safedk.android.utils.g.aV(), str);
                if (strA == null) {
                    Logger.d(R, "get ad ID from resource: NO MATCH, can't extract clcode from html");
                } else {
                    return strA;
                }
            } else {
                Logger.d(R, "get ad ID from resource: NO MATCH, putting the banner hash into the sourceToWebviewRef");
            }
        } else {
            Logger.d(R, "get ad ID from resource: NO MATCH, putting the value into sourceToWebviewRef");
            if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                bf.put(str, weakReference);
            } else {
                Logger.d(R, "get ad id from resource - webview is null, not storing value in sourceToWebviewRef");
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public int h(String str) {
        String strC = c(str, str);
        if (strC == null) {
            return 0;
        }
        Logger.d(R, String.format("ad id %s, hash code: %s, from webview html: %s, ", strC, Integer.valueOf(strC.hashCode()), str));
        return strC.hashCode();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        return new HashSet();
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8068a;
        public BrandSafetyEvent.AdFormatType b;
        public String c;
        public String d;
        public String e;
        public String f;

        public a(String str, BrandSafetyEvent.AdFormatType adFormatType, String str2, String str3, String str4, String str5) {
            this.f8068a = str;
            this.b = adFormatType;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        public a(c cVar, String str, BrandSafetyEvent.AdFormatType adFormatType, String str2) {
            this(str, adFormatType, str2, null, null, null);
        }

        public a(c cVar, String str, BrandSafetyEvent.AdFormatType adFormatType) {
            this(str, adFormatType, null, null, null, null);
        }

        public a(String str) {
            this.f8068a = str;
        }

        public String toString() {
            return "{eventId=" + this.f8068a + ", adFormat=" + this.b + ", placementId=" + this.c + ", creativeId=" + this.d + ", adDomain=" + this.e + AbstractJsonLexerKt.END_OBJ;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        CreativeInfo value;
        CreativeInfo creativeInfo;
        if (obj instanceof String) {
            if (((String) obj).startsWith(S)) {
                String strK = K((String) obj);
                if (strK != null) {
                    try {
                        String strOptString = new JSONObject(strK).optString(am);
                        if (!TextUtils.isEmpty(strOptString)) {
                            creativeInfo = this.bi.get(strOptString);
                            if (creativeInfo != null) {
                                try {
                                    Logger.d(R, "match info found, native CI: " + creativeInfo.aa());
                                    return creativeInfo;
                                } catch (JSONException e2) {
                                    Logger.d(R, "match info: failed to parse bid response");
                                    return creativeInfo;
                                }
                            }
                            return creativeInfo;
                        }
                    } catch (JSONException e3) {
                        creativeInfo = null;
                    }
                } else {
                    Logger.d(R, "match info: failed to decode bid response");
                }
            } else {
                String str = (String) obj;
                if (this.bh.containsKey(str)) {
                    Logger.d(R, "match info started, complex key = " + str + " , banner CIs key set = " + this.bh.keySet());
                    CreativeInfo creativeInfo2 = this.bh.get(str);
                    if (creativeInfo2 != null) {
                        Logger.d(R, "match info found, banner CI: " + creativeInfo2.aa());
                        return creativeInfo2;
                    }
                    return creativeInfo2;
                }
                Iterator<Map.Entry<String, CreativeInfo>> it = this.bi.entrySet().iterator();
                CreativeInfo creativeInfo3 = null;
                while (it.hasNext()) {
                    Map.Entry<String, CreativeInfo> next = it.next();
                    if (str.equals(next.getValue().n())) {
                        value = next.getValue();
                        if (value != null) {
                            Logger.d(R, "match info found, native CI: " + value.aa());
                            it.remove();
                        }
                    } else {
                        value = creativeInfo3;
                    }
                    creativeInfo3 = value;
                }
                return creativeInfo3;
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
        com.safedk.android.utils.e.a(this.bh, "AppLovinDiscovery:bannerCreativeInfos");
        com.safedk.android.utils.e.a(this.bi, "AppLovinDiscovery:nativeCreativeInfos");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(View view) {
        return h(view);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean b(View view) {
        return i(view);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public RedirectDetails.RedirectType k(String str) {
        if (str != null) {
            if (str.contains(i)) {
                return RedirectDetails.RedirectType.REDIRECT;
            }
            if (str.contains(k)) {
                return RedirectDetails.RedirectType.EXPAND;
            }
            for (String str2 : m) {
                if (str.startsWith(str2)) {
                    return null;
                }
            }
        }
        return RedirectDetails.RedirectType.REDIRECT;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String l(String str) {
        if (str != null) {
            if (str.contains(i)) {
                return com.safedk.android.utils.k.d(str, "n");
            }
            if (str.contains(k)) {
                return null;
            }
            return str;
        }
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public BrandSafetyUtils.AdType f(View view) {
        if (view instanceof AppLovinAdView) {
            AppLovinAdSize size = ((AppLovinAdView) view).getSize();
            if (size.equals(AppLovinAdSize.BANNER) || size.equals(AppLovinAdSize.LEADER)) {
                return BrandSafetyUtils.AdType.BANNER;
            }
            if (size.equals(AppLovinAdSize.MREC)) {
                return BrandSafetyUtils.AdType.MREC;
            }
            if (size.equals(AppLovinAdSize.INTERSTITIAL)) {
                return BrandSafetyUtils.AdType.INTERSTITIAL;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x012b A[PHI: r2
  0x012b: PHI (r2v7 java.lang.String) = (r2v3 java.lang.String), (r2v9 java.lang.String), (r2v9 java.lang.String), (r2v9 java.lang.String) binds: [B:12:0x0044, B:27:0x00bd, B:29:0x00c9, B:31:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public static Bundle a(MaxAd maxAd) {
        String string;
        Class<?> superclass = maxAd.getClass();
        ArrayList<Field> arrayList = new ArrayList();
        do {
            arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                break;
            }
        } while (superclass.getName().startsWith(com.safedk.android.utils.h.f8160a));
        String str = null;
        String strB = null;
        String string2 = null;
        for (Field field : arrayList) {
            field.setAccessible(true);
            try {
                Object obj = field.get(maxAd);
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject.has("event_id")) {
                        string2 = jSONObject.getString("event_id");
                    }
                    if (jSONObject.has(an)) {
                        strB = CreativeInfoManager.b(jSONObject.getString("name"));
                        string = jSONObject.getString(an);
                    } else if (jSONObject.has("name")) {
                        String strOptString = jSONObject.optString("name");
                        if (TextUtils.isEmpty(strOptString)) {
                            string = str;
                        } else {
                            String strB2 = CreativeInfoManager.b(strOptString);
                            if (CreativeInfoManager.a(strB2, AdNetworkConfiguration.SHOULD_SCAN_OBJECT_USING_REFLECTION, false)) {
                                string = "";
                                strB = strB2;
                            } else {
                                string = str;
                            }
                        }
                    } else {
                        string = str;
                    }
                } else {
                    string = str;
                }
                if (string2 == null || strB == null || string == null) {
                    str = string;
                } else {
                    try {
                        Logger.d(R, "extract data from Max ad, event ID: " + string2 + ", sdk: " + strB + ", bid response: " + string);
                        Bundle bundle = new Bundle();
                        bundle.putString("eventId", string2);
                        bundle.putString("sdk", strB);
                        bundle.putString("bidResponse", string);
                        return bundle;
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        Logger.e(R, "extract data from Max ad exception: " + e.getMessage(), e);
                        str = string;
                    } catch (Throwable th) {
                        th = th;
                        Logger.e(R, "extract data from Max ad exception: " + th.getMessage(), th);
                        str = string;
                    }
                }
            } catch (IllegalAccessException e3) {
                e = e3;
                string = str;
            } catch (Throwable th2) {
                th = th2;
                string = str;
            }
        }
        return null;
    }

    protected String a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(f).getString(g);
        } catch (JSONException e2) {
            return null;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean g(String str) {
        Iterator<String> it = CreativeInfoManager.j.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String e(String str, String str2) {
        if (g(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (com.safedk.android.utils.k.m(str2)) {
                    JSONObject jSONObject = new JSONObject(str2);
                    com.safedk.android.utils.n.b(R, "handle on request sent - parsing json. url: " + str + ", content: " + str2);
                    if (jSONObject.has(aY)) {
                        Logger.d(R, "handle on request sent - applovin request json has ad info");
                        JSONObject jSONObject2 = jSONObject.getJSONObject(aY);
                        if (jSONObject2.has(aZ)) {
                            String string = jSONObject2.getString(aZ);
                            Logger.d(R, "handle on request sent - found ad unit id " + string + " inside the request");
                            this.bk.put(str, string);
                        }
                    }
                } else {
                    Logger.d(R, "handle on request sent - content is not json. content = " + str2);
                }
            } catch (Throwable th) {
                com.safedk.android.utils.n.b(R, "handle on request sent - exception occurred: " + th.getMessage());
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean m(String str) {
        if (bg.containsKey(str)) {
            return a(bg.get(str), com.safedk.android.utils.h.f8160a, bf, this.bh, d.s);
        }
        Logger.d(R, "try reverse matching with ad id - ad id " + str + " is not in the ad id to source keys: " + bg.keySet());
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void n(String str) {
        String strRemove = bg.remove(str);
        Logger.d(R, "clean resources started with ad id: " + str + ", and source is: " + strRemove);
        if (strRemove != null) {
            bf.remove(strRemove);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void e(String str) {
        try {
            Logger.d(R, "on json object detected started , isOnUiThread = " + com.safedk.android.utils.n.c());
            if (str.contains("\"ads\"")) {
                CreativeInfoManager.a(this.Q, "@!1:ad_fetch@!", str, (Map<String, List<String>>) null);
            }
        } catch (Throwable th) {
            Logger.e(R, "Exception in json object detected", th);
        }
    }
}
