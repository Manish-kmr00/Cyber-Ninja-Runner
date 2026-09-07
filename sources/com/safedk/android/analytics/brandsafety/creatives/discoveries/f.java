package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.ProtobufMessageParser;
import com.safedk.android.analytics.brandsafety.creatives.infos.ChartboostCreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.utils.Logger;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f extends d {
    private static final String R = "renderables";
    private static final String S = "impID";
    private static final String T = "config";
    private static final String U = "/renderable_count_";
    private static final String V = "adm.js";
    private static final String W = "ad_domain";
    private static final String X = "app_name";
    private static final String Y = "elements";
    private static final String Z = "name";
    private static final String aa = "type";
    private static final String ab = "value";
    private static final String ac = "events";
    private static final String ad = "images";
    private static final String ae = "impression_id";
    private static final String af = "media-type";
    private static final String ag = "preCachedVideo";
    private static final String ah = "webview";
    private static final String ai = "chartboost.com";
    private static final String aj = "cb_val";
    private static final String ak = "url";
    private static final String al = "buyerId6";
    private static final String am = "buyerId8";
    private static final String an = "{\"1\":[\"url\",\"string\"],\"6\":[\"buyerId6\",\"string\"],\"8\":[\"buyerId8\",\"string\"]}";
    private static final String ao = "bics=";
    private static final String ap = "null";
    private static final String aq = "CHARTBOOST_NETWORK";
    private static final String ar = "KEY_INTENT_URL";
    private static final Map<String, String> as = new HashMap();
    public static final String b = "(function(){var sdkId=\"{{SDK_ID}}\";var address=\"{{ADDRESS}}\";var ppDetectReported=false;var ppElementFound=false;var log=function(message){try{if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(message)}else{console.log(\"SafeDKWebApInterface safedkDebug object missing\")}}catch(error){}};function observeClassChanges(element){const classObserver=new MutationObserver((mutationsList,classObserver)=>{for(const mutation of mutationsList){if(mutation.type===\"attributes\"&&mutation.attributeName===\"class\"){var elementClassName=element.className;if(elementClassName&&elementClassName.includes(\"privacy_overlay\")){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0);classObserver.disconnect()}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}}}});classObserver.observe(element,{attributes:true,attributeFilter:[\"class\"]})}function observeClassChangesBanner(element){const classObserver=new MutationObserver((mutationsList,classObserver)=>{for(const mutation of mutationsList){if(mutation.type===\"attributes\"&&mutation.attributeName===\"class\"){var elementClassName=element.className;if(elementClassName&&!elementClassName.includes(\"hidden\")&&!ppDetectReported){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){ppDetectReported=true;window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0);classObserver.disconnect()}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}}}});classObserver.observe(element,{attributes:true,attributeFilter:[\"class\"]})}function findPrivacyPolicyElement(){const privacyPolicyElement=document.getElementById(\"privacy-policy\");if(privacyPolicyElement){ppElementFound=true;observeClassChanges(privacyPolicyElement)}const privacyPolicyBannerElement=document.getElementById(\"privacy-policy-banner\");if(privacyPolicyBannerElement){ppElementFound=true;observeClassChangesBanner(privacyPolicyBannerElement)}}function observeElementAddition(){const observer=new MutationObserver((mutationsList,observer)=>{findPrivacyPolicyElement()});observer.observe(document,{childList:true,subtree:true})}var counter=0;setTimeout(()=>{if(!ppElementFound&&counter<4){counter++;log(\"calling findPrivacyPolicyElement \"+counter);findPrivacyPolicyElement()}},500);observeElementAddition()})();\n";
    private static final String c = "ChartboostDiscovery";
    private static final String d = "/auction/sdk/banner";
    private static final String e = "crid";
    private static final String f = "imptrackers";
    private static final String g = "adm";
    private static final String h = "adomain";
    private static final String i = "bid";
    private static final String j = "bundle";
    private static final String k = "crtype";
    private static final String l = "ext";
    private static final String m = "impressionid";
    private static final String n = "seatbid";
    private static final String o = "seat";
    private static final String p = "nurl";
    private static final String q = "lurl";

    public f() {
        super(com.safedk.android.utils.h.c, c);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SHOULD_GET_HTML_TEXT_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.JS_PRIVACY_BUTTON_CLICK_DETECTION_SCRIPT, b);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_FULLSCREEN_ADS, true);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true);
        this.C.b(AdNetworkConfiguration.DONT_USE_PLACEMENT_ID_IN_BANNER_AD_INFO_KEY, aq);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        boolean z = true;
        Logger.d(c, "generate info impl - started. max params= " + aVar + ",   url= " + str);
        BrandSafetyUtils.AdType adTypeB = BrandSafetyUtils.AdType.INTERSTITIAL;
        if (aVar != null) {
            adTypeB = BrandSafetyUtils.b(aVar.b.name());
        } else if (str.contains(d)) {
            adTypeB = BrandSafetyUtils.AdType.BANNER;
        } else {
            z = false;
        }
        Logger.d(c, "generate info impl - ad type set to= " + adTypeB);
        ChartboostCreativeInfo chartboostCreativeInfo = new ChartboostCreativeInfo(adTypeB, com.safedk.android.utils.h.c, this.G);
        ArrayList arrayList = new ArrayList();
        arrayList.add(chartboostCreativeInfo);
        if (aVar != null) {
            chartboostCreativeInfo.h(aVar.f8068a);
            chartboostCreativeInfo.j(aVar.c);
        }
        if (z) {
            try {
                str2 = new String(Base64.decode(str2, 0));
            } catch (Exception e2) {
                Logger.d(c, "generate info impl - exception: " + e2);
            }
        }
        if (com.safedk.android.utils.n.n(str2)) {
            JSONObject jSONObject = new JSONObject(str2);
            if (z) {
                Logger.d(c, "generate info impl - updating ci bidding info");
                a(arrayList, jSONObject, aVar);
            } else {
                Logger.d(c, "generate info impl - updating ci network info");
                a(chartboostCreativeInfo, jSONObject);
            }
        }
        Logger.d(c, "generate info impl - creative info list= " + arrayList);
        return arrayList;
    }

    private void a(List<CreativeInfo> list, JSONObject jSONObject, c.a aVar) throws JSONException {
        if (list != null && !list.isEmpty()) {
            com.safedk.android.utils.n.b(c, "update bidding ci - prefetch json obj= \n" + jSONObject.toString(4));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(n);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(R);
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                Logger.d(c, "update bidding ci - prefetch is seat bid");
                a((ChartboostCreativeInfo) list.get(0), jSONArrayOptJSONArray);
            } else if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                Logger.d(c, "update bidding ci - prefetch is renderables");
                b(list, jSONObject, aVar);
            }
        }
    }

    private void b(List<CreativeInfo> list, JSONObject jSONObject, c.a aVar) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        if (list != null && !list.isEmpty() && aVar != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(R)) != null && jSONArrayOptJSONArray.length() != 0) {
            BrandSafetyUtils.AdType adTypeM = list.get(0).M();
            list.remove(0);
            int length = jSONArrayOptJSONArray.length();
            String str = U + length;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                ChartboostCreativeInfo chartboostCreativeInfo = new ChartboostCreativeInfo(adTypeM, com.safedk.android.utils.h.c, this.G);
                list.add(chartboostCreativeInfo);
                String strOptString = aVar.d;
                String strOptString2 = aVar.f8068a + "_" + i2;
                String str2 = "";
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString3 = jSONObjectOptJSONObject2.optString("adm");
                    if (!TextUtils.isEmpty(strOptString3)) {
                        com.safedk.android.utils.n.b(c, "update renderables bidding ci - adm found= " + strOptString3);
                        String strA = a(com.safedk.android.utils.g.bm(), strOptString3);
                        if (!TextUtils.isEmpty(strA)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(strA, 0)));
                                strOptString = jSONObject2.optString(e, strOptString);
                                strOptString2 = jSONObject2.optString(S, strOptString2);
                            } catch (JSONException e2) {
                                Logger.d(c, "update renderables bidding ci - exception: " + e2);
                            }
                        }
                        chartboostCreativeInfo.b((List<String>) com.safedk.android.utils.n.f(strOptString3));
                    }
                    str2 = strOptString3;
                }
                if (length == 1 && (jSONObjectOptJSONObject = jSONObject.optJSONObject("config")) != null) {
                    chartboostCreativeInfo.b((List<String>) com.safedk.android.utils.n.f(jSONObjectOptJSONObject.toString()));
                }
                chartboostCreativeInfo.h(aVar.f8068a);
                chartboostCreativeInfo.j(aVar.c);
                Logger.d(c, "update renderables bidding ci - setting creative id= " + strOptString);
                chartboostCreativeInfo.k(strOptString);
                Logger.d(c, "update renderables bidding ci - setting ad id= " + strOptString2);
                chartboostCreativeInfo.r(strOptString2);
                as.put(str2, strOptString2);
                chartboostCreativeInfo.e(str);
                Logger.d(c, "update renderables bidding ci - index= " + i2 + ",       creative info= " + chartboostCreativeInfo);
            }
        }
    }

    private void a(ChartboostCreativeInfo chartboostCreativeInfo, JSONArray jSONArray) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject;
        String str;
        JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject2 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("bid")) != null && jSONArrayOptJSONArray.length() > 0 && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) != null) {
            ArrayList arrayList = new ArrayList();
            String strOptString = jSONObjectOptJSONObject.optString("adm");
            String strOptString2 = jSONObjectOptJSONObject.optString(e);
            Logger.d(c, "update seat bid bidding ci - setting creative id= " + strOptString2);
            if (!"null".equals(strOptString2)) {
                chartboostCreativeInfo.k(strOptString2);
            }
            String strOptString3 = jSONObjectOptJSONObject.optString("bundle");
            Logger.d(c, "update seat bid bidding ci - setting bundle= " + strOptString3);
            if (!"null".equals(strOptString3)) {
                chartboostCreativeInfo.a(strOptString3);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(h);
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                String strOptString4 = jSONArrayOptJSONArray2.optString(0);
                Logger.d(c, "update seat bid bidding ci - setting ad domain= " + strOptString4);
                if (!"null".equals(strOptString4)) {
                    chartboostCreativeInfo.i(strOptString4);
                }
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("ext");
            if (jSONObjectOptJSONObject3 == null) {
                str = "";
            } else {
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject3.optJSONArray("imptrackers");
                Logger.d(c, "update seat bid bidding ci - adding dsp url list= " + jSONArrayOptJSONArray3);
                if (jSONArrayOptJSONArray3 != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray3.length(); i2++) {
                        String strOptString5 = jSONArrayOptJSONArray3.optString(i2);
                        if (!"null".equals(strOptString5)) {
                            arrayList.add(strOptString5);
                        }
                    }
                }
                String strOptString6 = jSONObjectOptJSONObject3.optString(k);
                str = (TextUtils.isEmpty(strOptString6) || "null".equals(strOptString6)) ? "" : "" + strOptString6 + RemoteSettings.FORWARD_SLASH_STRING;
                String strOptString7 = jSONObjectOptJSONObject3.optString(m);
                Logger.d(c, "update seat bid bidding ci - setting ad id= " + strOptString7);
                if (!"null".equals(strOptString7)) {
                    chartboostCreativeInfo.r(strOptString7);
                }
            }
            String strOptString8 = jSONObjectOptJSONObject.optString("nurl");
            Logger.d(c, "update seat bid bidding ci - nurl= " + strOptString8);
            if (!"null".equals(strOptString8)) {
                arrayList.add(strOptString8);
            }
            String strOptString9 = jSONObjectOptJSONObject.optString("lurl");
            Logger.d(c, "update seat bid bidding ci - lurl= " + strOptString9);
            if (!"null".equals(strOptString9)) {
                arrayList.add(strOptString9);
            }
            String strA = a(chartboostCreativeInfo, strOptString, str, arrayList);
            Logger.d(c, "update seat bid bidding ci - setting downstream struct= " + strA);
            if (!TextUtils.isEmpty(strA)) {
                chartboostCreativeInfo.e(strA);
            }
        }
    }

    private void a(ChartboostCreativeInfo chartboostCreativeInfo, JSONObject jSONObject) throws JSONException {
        com.safedk.android.utils.n.b(c, "update network ci - prefetch json obj= \n" + jSONObject.toString(4));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        String str = "";
        String strOptString = jSONObject.optString(af);
        if (!TextUtils.isEmpty(strOptString) && !"null".equals(strOptString)) {
            str = "" + strOptString + RemoteSettings.FORWARD_SLASH_STRING;
        }
        a(jSONObject, (List<String>) arrayList);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("webview");
        if (jSONObjectOptJSONObject != null) {
            a(jSONObjectOptJSONObject, (List<String>) arrayList);
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(Y);
            if (jSONArrayOptJSONArray != null) {
                String str2 = null;
                String str3 = null;
                String str4 = null;
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                    if (jSONObjectOptJSONObject2 != null) {
                        String strOptString2 = jSONObjectOptJSONObject2.optString("name");
                        String strOptString3 = jSONObjectOptJSONObject2.optString("type");
                        String strOptString4 = jSONObjectOptJSONObject2.optString("value");
                        if ("null".equals(strOptString4)) {
                            Logger.d(c, "update network ci - element value is null, skipping.");
                        } else if (strOptString2.equals(e)) {
                            Logger.d(c, "update network ci - setting creative id= " + strOptString4);
                            chartboostCreativeInfo.k(strOptString4);
                        } else if (strOptString3.equals(ag)) {
                            Logger.d(c, "update network ci - setting candidate video url= " + strOptString4);
                            str4 = strOptString4;
                        } else if (strOptString2.equals("imptrackers")) {
                            arrayList.add(strOptString4);
                        } else if (strOptString3.equals(ad)) {
                            hashSet.add(strOptString4);
                        } else if (strOptString2.equals("ad_domain")) {
                            Logger.d(c, "update network ci - setting ad domain= " + strOptString4);
                            chartboostCreativeInfo.i(strOptString4);
                        } else if (strOptString2.equals("app_name")) {
                            Logger.d(c, "update network ci - setting buyer id= " + strOptString4);
                            str2 = strOptString4;
                        } else if (strOptString2.equals(V)) {
                            str3 = strOptString4;
                        } else if (strOptString2.equals("impression_id")) {
                            Logger.d(c, "update network ci - setting ad id= " + strOptString4);
                            chartboostCreativeInfo.r(strOptString4);
                        }
                    }
                }
                String strA = a(chartboostCreativeInfo, str3, str, arrayList);
                if (TextUtils.isEmpty(chartboostCreativeInfo.R()) && !TextUtils.isEmpty(str2)) {
                    chartboostCreativeInfo.m(str2);
                }
                if (TextUtils.isEmpty(chartboostCreativeInfo.J()) && !TextUtils.isEmpty(str4)) {
                    Logger.d(c, "update network ci - setting choosing candidate video url= " + str4);
                    chartboostCreativeInfo.p(str4);
                }
                Logger.d(c, "update network ci - setting downstream struct= " + strA);
                if (!TextUtils.isEmpty(strA)) {
                    chartboostCreativeInfo.e(strA);
                }
                Logger.d(c, "update network ci - adding prefetch resource list= " + hashSet);
                chartboostCreativeInfo.b(new ArrayList<>(hashSet));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x018c  */
    private String a(CreativeInfo creativeInfo, String str, String str2, List<String> list) {
        boolean z;
        boolean z2;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            String str4 = "";
            try {
                str = new String(Base64.decode(str, 0));
            } catch (Exception e2) {
                Logger.d(c, "update ci adm - exception while decoding adm: " + e2);
            }
            if (list != null) {
                z = true;
                for (String str5 : list) {
                    if (str5.contains(ai)) {
                        String strD = com.safedk.android.utils.k.d(str5, aj);
                        if (!TextUtils.isEmpty(strD)) {
                            try {
                                JSONObject jSONObjectA = ProtobufMessageParser.a(Base64.decode(strD, 8), an);
                                Logger.d(c, "update ci adm - cb val url json obj= " + jSONObjectA);
                                if (jSONObjectA != null) {
                                    String strOptString = jSONObjectA.optString("url");
                                    Logger.d(c, "update ci adm - cb val url= " + strOptString);
                                    if (!TextUtils.isEmpty(strOptString)) {
                                        creativeInfo.w(strOptString);
                                    }
                                    String strOptString2 = jSONObjectA.optString(am);
                                    Logger.d(c, "update ci adm - buyer id= " + strOptString2);
                                    if (!TextUtils.isEmpty(strOptString2) && TextUtils.isEmpty(creativeInfo.R())) {
                                        creativeInfo.m(strOptString2);
                                    }
                                    if (TextUtils.isEmpty(strOptString2)) {
                                        str3 = str4;
                                    } else {
                                        str3 = str4 + strOptString2 + StringUtils.COMMA;
                                    }
                                } else {
                                    str3 = str4;
                                }
                                str4 = str3;
                            } catch (Exception e3) {
                                Logger.d(c, "update ci adm - exception= " + e3);
                            }
                        }
                        z2 = z;
                    } else {
                        creativeInfo.w(str5);
                        z2 = false;
                    }
                    z = z2;
                }
            } else {
                z = true;
            }
            if (!TextUtils.isEmpty(str4)) {
                creativeInfo.t(ao + str4);
            }
            if (com.safedk.android.analytics.brandsafety.creatives.h.a(str)) {
                String str6 = str2 + "vast";
                creativeInfo.e(true);
                Logger.d(c, "update ci adm - seat is vast!");
                a(creativeInfo, (String) null, str, true);
                return str6;
            }
            if (com.safedk.android.utils.k.j(str)) {
                String str7 = str2 + "mraid";
                Logger.d(c, "update ci adm - seat is mraid!");
                if (z) {
                    Logger.d(c, "update ci adm - dsp url list is empty, extract from html");
                    creativeInfo.b((List<String>) com.safedk.android.utils.n.f(str));
                    return str7;
                }
                return str7;
            }
            return str2;
        }
        return str2;
    }

    private void a(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject("events")) != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("imptrackers")) != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                String strOptString = jSONArrayOptJSONArray.optString(i2);
                if (!TextUtils.isEmpty(strOptString)) {
                    list.add(strOptString);
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        Logger.d(c, "get ad id from resource - value= " + str);
        String strA = a(com.safedk.android.utils.g.bk(), str);
        Logger.d(c, "get ad id from resource - impression id for bidding found= " + strA);
        if (TextUtils.isEmpty(strA)) {
            strA = a(com.safedk.android.utils.g.bl(), str);
            Logger.d(c, "get ad id from resource - impression id for network found= " + strA);
        }
        String str3 = strA;
        if (TextUtils.isEmpty(str3)) {
            for (String str4 : as.keySet()) {
                if (str.contains(str4)) {
                    String str5 = as.get(str4);
                    Logger.d(c, "get ad id from resource - impression id for renderables bidding found= " + str5);
                    str3 = str5;
                    break;
                }
            }
        }
        CreativeInfo creativeInfo = !TextUtils.isEmpty(str3) ? this.H.get(str3) : null;
        Logger.d(c, "get ad id from resource - ci found?= " + creativeInfo);
        if (creativeInfo == null) {
            return null;
        }
        Logger.d(c, "get ad id from resource - returning ad id= " + creativeInfo.N());
        return creativeInfo.N();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        Logger.d(c, "handle vast media file - ci id= " + creativeInfo.N() + ",    video url= " + str);
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zFind = com.safedk.android.utils.g.bn().matcher(str).find();
        Logger.d(c, "should follow input stream impl url = " + str + ", shouldFollow = " + zFind);
        return zFind;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<String> e() {
        List<String> listE = super.e();
        listE.add(ar);
        return listE;
    }
}
