package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.AmazonCreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends d {
    private static final String R = "kvp";
    private static final String S = "crid";
    private static final String T = "https://c.amazon-adsystem.com/";
    private static final String U = "x";
    private static final String V = "<head>";
    private static final String W = "<script>";
    private static final String X = "</script>";
    private static final String Y = "responseText";
    private static final String Z = "direction";
    private static final String aa = "webviewAddress";
    private static final String ab = "webviewType";
    private static final String ac = "{{SDK_ID}}";
    private static final String ad = "url";
    private static final String ae = "amazon_vast_prefetch_response";
    private static final String af = "amazon_mraid_prefetch_response";
    public static final String b = "(function(){var isMraidAttached=false;var log=function(message){try{if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(message)}}catch(error){}};var printError=function(error){try{if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(\"ERROR: \"+fileName+\" \"+error.message+\"\\n\"+error.stack)}}catch(error){}};function injectIntoIframe(win){const code=`\n      (function(){\n        var hookXMLHTTPRequest = function()\n        {\n            if (window.safedkXHRMonitoring) {\n                return;\n            }\n\n            var webviewAddress = \"{{webviewAddress}}\";\n            var sdkId = \"{{SDK_ID}}\";\n            var webviewType = \"{{webviewType}}\"\n            var origOpen = window.XMLHttpRequest.prototype.open;\n            function open(method, url, async, user, password) {\n                origOpen.apply(this, arguments);\n                try {\n                    this.safedkURL = url.toString();\n                    this.addEventListener('load', function() {\n                        try {\n                            var message = {direction: \"amazon_vast_prefetch_response\", sdkId: sdkId, webviewAddress: webviewAddress, webviewType: webviewType};\n                            if (typeof(this.safedkURL) != 'undefined' && this.safedkURL) message.url = this.safedkURL;\n                            if (typeof(this.safedkRequestText) != 'undefined' && this.safedkRequestText) message.safedkRequestText = this.safedkRequestText;\n                            if (typeof(this.responseText) != 'undefined' && this.responseText) message.responseText = this.responseText;\n                            if ( typeof(window.webkit.messageHandlers.safedkDebug.interceptXmlHttpRequest) === 'function'){\n                                window.webkit.messageHandlers.safedkDebug.interceptXmlHttpRequest(JSON.stringify(message));\n                            }else{\n                                console.log('SafeDKWebAppInterface safedkDebug object missing')\n                            }\n                        }\n                        catch (error) {\n                            printError(error);\n                        }\n                    });\n                }\n                catch (error) {\n                    printError(error);\n                }\n            }\n            window.XMLHttpRequest.prototype.open = open;\n\n            var origSend = window.XMLHttpRequest.prototype.send;\n            function send(body) {\n                try {\n                    var message = {direction: \"request\", sdkId: sdkId, webviewAddress: webviewAddress};\n                    if (typeof(this.safedkURL) != 'undefined' && this.safedkURL) message.url = this.safedkURL;\n                    if (typeof(body) != 'undefined' && body) {\n                        if (typeof(body) === 'string') {\n                            this.safedkRequestText = body;\n                            message.requestText = this.safedkRequestText;\n                        }\n                    }\n                }\n                catch (error) {\n                    printError(error);\n                }\n                origSend.apply(this, arguments);\n            }\n            window.XMLHttpRequest.prototype.send = send;\n            window.safedkXHRMonitoring = true\n        }\n        hookXMLHTTPRequest();\n      })();\n    `;try{const s=win.document.createElement(\"script\");s.textContent=code;(win.document.head||win.document.documentElement).appendChild(s);s.remove()}catch(e){}}function isTargetAdIframe(node){try{if(!node)return false;if(node.tagName===\"IFRAME\"){if(node.id===\"apsAdIframe\")return true}}catch(_){}return false}function tryHookIframe(ifr){if(!ifr||ifr.safedkIFrameAnalyzed!=null)return;var injectIfReady=function(){try{if(ifr.contentWindow&&ifr.contentDocument){const rs=ifr.contentDocument.readyState;if(!rs||rs===\"interactive\"||rs===\"complete\"){injectIntoIframe(ifr.contentWindow);ifr.safedkIFrameAnalyzed=true;log(\"iframe found\");return true}}}catch(e){}return false};if(injectIfReady())return;log(\"adding load listener to iframe\");try{ifr.addEventListener(\"load\",function onload(){try{ifr.removeEventListener(\"load\",onload)}catch(_){}injectIfReady()})}catch(_){}}try{var ifr=document.getElementById(\"apsAdIframe\");if(isTargetAdIframe(ifr)){tryHookIframe(ifr)}}catch(_){}var mo=new MutationObserver(function(mutations){for(var i=0;i<mutations.length;i++){var m=mutations[i];for(var j=0;j<m.addedNodes.length;j++){var node=m.addedNodes[j];if(node.nodeType!==1)continue;if(isTargetAdIframe(node)){tryHookIframe(node)}else{var ifr=node.querySelector(\"#apsAdIframe\");if(isTargetAdIframe(ifr)){tryHookIframe(node)}}}}});try{mo.observe(document.documentElement||document,{childList:true,subtree:true})}catch(_){}function attachMraid(){if(isMraidAttached){return}var webviewAddress=\"{{webviewAddress}}\";var sdkId=\"{{SDK_ID}}\";var webviewType=\"{{webviewType}}\";var originalAAXRenderAd=window.aax_render_ad;if(typeof originalAAXRenderAd===\"function\"){window.aax_render_ad=function(...args){log(\"render ad found\");try{if(args.length>0){var message={direction:\"amazon_mraid_prefetch_response\",sdkId:sdkId,webviewAddress:webviewAddress,webviewType:webviewType};message.responseText=JSON.stringify(args[0]);if(typeof window.webkit.messageHandlers.safedkDebug.interceptXmlHttpRequest===\"function\"){window.webkit.messageHandlers.safedkDebug.interceptXmlHttpRequest(JSON.stringify(message))}else{console.log(\"SafeDKWebAppInterface safedkDebug object missing\")}}}catch(error){}return originalAAXRenderAd.apply(this,args)};isMraidAttached=true}}setTimeout(attachMraid,0)})();\n";
    private static final String c = "AmazonDiscovery";
    private static final String d = "/dtb";
    private static final String e = "/adm";
    private static final String f = "/sponsored";
    private static final String g = "adLink";
    private static final String h = "clickThroughInfo";
    private static final String i = "creativeInformation";
    private static final String j = "productImg";
    private static final String k = "staticCustomImages";
    private static final String l = "url";
    private static final String m = "AdaptiveRenderer.default(";
    private static final String n = "Creative.default($ad";
    private static final String o = "adsize";
    private static final String p = "html";
    private static final String q = "sz";

    public b() {
        super(com.safedk.android.utils.h.A, c);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_REPORT_VAST_ID_AS_CREATIVE_ID, true);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void y(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(Z);
            if (ae.equals(strOptString) || af.equals(strOptString)) {
                a(jSONObject.optString("url", "@!1:ad_fetch@!"), str, (byte[]) null, (Map<String, List<String>>) null, (c.a) null);
            } else {
                super.y(str);
            }
        } catch (JSONException e2) {
            Logger.d(c, "handle xml http request - exception: " + e2);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        ArrayList<String> arrayListF;
        AmazonCreativeInfo amazonCreativeInfoB;
        if (!com.safedk.android.utils.n.n(str2)) {
            Logger.d(c, "generate info imp - buffer value is not json, returning.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(str2);
        String strOptString = jSONObject.optString(Y);
        String strOptString2 = jSONObject.optString(ab);
        String strOptString3 = jSONObject.optString(aa);
        String strOptString4 = jSONObject.optString(Z);
        com.safedk.android.utils.n.b(c, "generate info imp - started. response value= " + strOptString);
        Logger.d(c, "generate info imp - webview type= " + strOptString2 + ",     webview address= " + strOptString3);
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
            return null;
        }
        String str3 = "";
        if (com.safedk.android.analytics.brandsafety.creatives.h.a(strOptString)) {
            Logger.d(c, "generate info imp - prefetch is vast");
            amazonCreativeInfoB = B(strOptString);
            str3 = "vast";
            arrayListF = null;
        } else if (ae.equals(strOptString4)) {
            arrayListF = null;
            amazonCreativeInfoB = null;
        } else {
            Logger.d(c, "generate info imp - prefetch is mraid");
            AmazonCreativeInfo amazonCreativeInfoC = C(strOptString);
            arrayListF = com.safedk.android.utils.n.f(strOptString);
            str3 = "mraid";
            if (!TextUtils.isEmpty(a(com.safedk.android.utils.g.bp(), strOptString))) {
                str3 = str3 + d;
            }
            if (!TextUtils.isEmpty(a(com.safedk.android.utils.g.bq(), strOptString))) {
                str3 = str3 + e;
            }
            String strA = a(com.safedk.android.utils.g.br(), strOptString);
            String strA2 = a(com.safedk.android.utils.g.bs(), strOptString);
            if (TextUtils.isEmpty(strA) || TextUtils.isEmpty(strA2)) {
                amazonCreativeInfoB = amazonCreativeInfoC;
            } else {
                str3 = str3 + f;
                amazonCreativeInfoB = amazonCreativeInfoC;
            }
        }
        Logger.d(c, "generate info imp - creative info generated?= " + (amazonCreativeInfoB == null ? amazonCreativeInfoB : amazonCreativeInfoB.aa()));
        if (amazonCreativeInfoB != null) {
            arrayList.add(amazonCreativeInfoB);
            amazonCreativeInfoB.b((List<String>) arrayListF);
            amazonCreativeInfoB.e(str3);
            Logger.d(c, "generate info imp - setting downstream struct to= " + str3);
            amazonCreativeInfoB.c(strOptString3, strOptString2);
            CreativeInfoManager.a(amazonCreativeInfoB, CreativeInfo.O, amazonCreativeInfoB.X());
        }
        return arrayList;
    }

    private AmazonCreativeInfo B(String str) {
        AmazonCreativeInfo amazonCreativeInfo = new AmazonCreativeInfo(BrandSafetyUtils.AdType.INTERSTITIAL, com.safedk.android.utils.h.A, null, this.G);
        a((CreativeInfo) amazonCreativeInfo, (String) null, str, true);
        return amazonCreativeInfo;
    }

    private AmazonCreativeInfo C(String str) {
        String str2;
        AmazonCreativeInfo amazonCreativeInfo;
        String strA = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.safedk.android.utils.n.b(c, "handle mraid prefetch - ad json=\n" + jSONObject.toString(4));
            BrandSafetyUtils.AdType adTypeB = b(jSONObject);
            Logger.d(c, "handle mraid prefetch - ad type= " + adTypeB);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(R);
            String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(S, null) : null;
            Logger.d(c, "handle mraid prefetch - creative id found?= " + strOptString);
            amazonCreativeInfo = new AmazonCreativeInfo(adTypeB, com.safedk.android.utils.h.A, strOptString, this.G);
            try {
                String strOptString2 = jSONObject.optString("html");
                if (!TextUtils.isEmpty(strOptString2)) {
                    String strK = K(strOptString2);
                    Logger.d(c, "handle mraid prefetch - inner json= " + strK);
                    if (!TextUtils.isEmpty(strK)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(strK);
                            com.safedk.android.utils.n.b(c, "handle mraid prefetch - found inner html json:\n" + jSONObject2.toString(4));
                            strA = a(jSONObject2, strOptString2);
                            Logger.d(c, "handle mraid prefetch - click url found?= " + strA);
                            arrayList.addAll(a(jSONObject2));
                        } catch (JSONException e2) {
                            try {
                                Logger.d(c, "handle mraid prefetch - exception on inner json: " + e2);
                            } catch (JSONException e3) {
                                e = e3;
                                str2 = strA;
                                Logger.d(c, "handle mraid prefetch - exception: " + e);
                            }
                        }
                    }
                }
                str2 = strA;
            } catch (JSONException e4) {
                e = e4;
                str2 = null;
            }
        } catch (JSONException e5) {
            e = e5;
            str2 = null;
            amazonCreativeInfo = null;
        }
        Iterator<String> it = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.bo(), str, 1, false).iterator();
        while (it.hasNext()) {
            String strA2 = a(com.safedk.android.utils.g.ad(), it.next().replace("\\\"", "\""));
            Logger.d(c, "handle mraid prefetch - img url found?= " + strA2);
            if (!TextUtils.isEmpty(strA2)) {
                arrayList.add(strA2);
            }
        }
        Logger.d(c, "handle mraid prefetch - extracted prefetch resources= " + arrayList);
        if (amazonCreativeInfo != null) {
            amazonCreativeInfo.b(arrayList);
            amazonCreativeInfo.a(str2, true);
        }
        return amazonCreativeInfo;
    }

    private static String K(String str) {
        String strI = i(str, m);
        if (TextUtils.isEmpty(strI)) {
            return i(str, n);
        }
        return strI;
    }

    private static String i(String str, String str2) {
        String strSubstring;
        Logger.d(c, "extract inner html json - html contains inner json marker?= " + str2);
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf == -1) {
            return null;
        }
        int i2 = 0;
        int i3 = -1;
        for (int length = iIndexOf + str2.length(); length < str.length(); length++) {
            char cCharAt = str.charAt(length);
            if (cCharAt == '{') {
                if (i2 == 0) {
                    i3 = length;
                }
                i2++;
            } else if (cCharAt == '}' && (i2 = i2 - 1) == 0 && i3 != -1) {
                strSubstring = str.substring(i3, length + 1);
                com.safedk.android.utils.n.b(c, "extract inner html json - json string found?= " + strSubstring);
                return strSubstring;
            }
        }
        strSubstring = null;
        com.safedk.android.utils.n.b(c, "extract inner html json - json string found?= " + strSubstring);
        return strSubstring;
    }

    private static List<String> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(i);
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(j);
            if (jSONObjectOptJSONObject2 != null) {
                arrayList.add(jSONObjectOptJSONObject2.optString("url"));
            }
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(k);
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject(itKeys.next());
                    if (jSONObjectOptJSONObject4 != null) {
                        arrayList.add(jSONObjectOptJSONObject4.optString("url"));
                    }
                }
            }
        } else {
            JSONObject jSONObjectOptJSONObject5 = jSONObject.optJSONObject("backgroundImage");
            if (jSONObjectOptJSONObject5 != null) {
                arrayList.add(jSONObjectOptJSONObject5.optString("url"));
            }
        }
        Logger.d(c, "get prefetch resources from inner html json - prefetch resource list found?= " + arrayList);
        return arrayList;
    }

    private static String a(JSONObject jSONObject, String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(i);
        if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject(h)) != null) {
            jSONObject = jSONObjectOptJSONObject;
        }
        String strOptString = jSONObject.optString(g);
        if (TextUtils.isEmpty(strOptString)) {
            Logger.d(c, "get click url from inner html json - click url was not found in inner json");
            List<String> listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.aC(), str, 1, false);
            strOptString = b(listA, "id=\"adLink\"");
            Logger.d(c, "get click url from inner html json - click url found by ad link anchor element?= " + strOptString);
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = b(listA, "class=\"clickthrough\"");
                Logger.d(c, "get click url from inner html json - click url found by click through anchor element?= " + strOptString);
            }
        }
        Logger.d(c, "get click url from inner html json - click url found?= " + strOptString);
        return strOptString;
    }

    private static String b(List<String> list, String str) {
        for (String str2 : list) {
            if (str2.contains(str)) {
                return a(com.safedk.android.utils.g.ap(), str2);
            }
        }
        return null;
    }

    private static BrandSafetyUtils.AdType b(JSONObject jSONObject) {
        BrandSafetyUtils.AdType adTypeA;
        BrandSafetyUtils.AdType adType = BrandSafetyUtils.AdType.BANNER;
        String strOptString = jSONObject.optString(o);
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = jSONObject.optString(q);
        }
        Logger.d(c, "get mraid ad type - size= " + strOptString);
        if (!TextUtils.isEmpty(strOptString) && strOptString.contains("x")) {
            try {
                String[] strArrSplit = strOptString.split("x");
                if (strArrSplit.length == 2) {
                    adTypeA = BrandSafetyUtils.a(Integer.parseInt(strArrSplit[0].trim()), Integer.parseInt(strArrSplit[1].trim()));
                } else {
                    adTypeA = adType;
                }
                adType = adTypeA;
            } catch (NumberFormatException e2) {
                Logger.d(c, "get mraid ad type - NumberFormatException: " + e2);
            }
        }
        Logger.d(c, "get mraid ad type - ad type found: " + adType);
        return adType;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(WebView webView, String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(T)) {
            Logger.d(c, "update data loaded to webView - adding prefetch interception js for webView= " + webView);
            return str2.replaceFirst(Pattern.quote(V), Matcher.quoteReplacement(V + (W + b.replace("{{webviewAddress}}", BrandSafetyUtils.a((Object) webView)).replace("{{webviewType}}", webView.getClass().getCanonicalName()).replace(ac, com.safedk.android.utils.h.A).replace("window.webkit.", "parent.").replace("messageHandlers.safedkDebug.postMessage", "SafeDKWebAppInterface.logMessage").replace("messageHandlers.safedkDebug.interceptXmlHttpRequest", "SafeDKWebAppInterface.interceptXmlHttpRequest") + X)));
        }
        return str2;
    }
}
