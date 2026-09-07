package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.b9;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.PangleCreativeInfo;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class o extends d {
    private static final String R = "endcard";
    private static final String S = "video_url";
    private static final String T = "cover_url";
    private static final String U = "media_ext";
    private static final String V = "request_id";
    private static final String W = "playable";
    private static final String X = "playable_url";
    private static final String Y = "icon";
    private static final String Z = "image";
    private static final String aA = "show_endcard";
    private static final String aB = "show_origin_endcard";
    private static final String aC = "endcard_style";
    private static final String aa = "dsp_vast";
    private static final String ab = "url";
    private static final String ac = "title";
    private static final String ad = "description";
    private static final String ae = "null";
    private static final String af = "tpl_info";
    private static final String ag = "data";
    private static final String ah = "app";
    private static final String ai = "/playable";
    private static final String aj = "url";
    private static final String ak = "multi_ad_config";
    private static final String al = "auto_switch";
    private static final String am = "can_loop";
    private static final String an = "ceiling_type";
    private static final String ao = "has_more";
    private static final String ap = "load_more_strategy";
    private static final String ar = "(function(){var sdkId=\"{{SDK_ID}}\";var address=\"{{ADDRESS}}\";var log=function(message){try{if(typeof window.webkit.messageHandlers.safedkDebug.postMessage===\"function\"){window.webkit.messageHandlers.safedkDebug.postMessage(message)}else{console.log(\"SafeDKWebApInterface safedkDebug object missing\")}}catch(error){}};var lookForPrivacyPolicy=function(){try{var isPrivacyPolicy=document.getElementsByClassName(\"renderer-policy-dialog__container\").length>0;if(isPrivacyPolicy){if(typeof window.webkit.messageHandlers.safedkNoSampling.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSampling.postMessage(sdkId,address,0,0)}else{console.log(\"SafeDKWebApInterface safedkNoSampling object missing\")}}}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}};lookForPrivacyPolicy();try{var MutationObserver=window.WebKitMutationObserver||window.MutationObserver;var observer=new MutationObserver(function(mutations){mutations.forEach(function(mutation){for(var i=0;i<mutation.addedNodes.length;i++){var node=mutation.addedNodes[i];if(node&&node.nodeName!=\"#text\"){lookForPrivacyPolicy()}}})});var config={childList:true,subtree:true};observer.observe(document,config)}catch(error){if(typeof window.webkit.messageHandlers.safedkNoSamplingExc.postMessage===\"function\"){window.webkit.messageHandlers.safedkNoSamplingExc.postMessage(error.message+\"\\n\"+error.stack)}else{console.log(\"SafeDKWebApInterface safedkNoSamplingExc object missing\")}}})();\n";
    private static final String au = "com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog";
    private static final String av = "com.bytedance.sdk.openadsdk.common.no";
    private static final String aw = "dynamic_creative";
    private static final String ax = "ivrv";
    private static final String ay = "render_type";
    private static final String az = "max_aggregation_endcard_count";
    public static final String b = "non-app";
    private static final String d = "PangleDiscovery";
    private static final String e = "creatives";
    private static final String f = "is_playable";
    private static final String g = "ext";
    private static final String h = "ad_id";
    private static final String i = "ad_slot_type";
    private static final String j = "rit";
    private static final String k = "creative_id";
    private static final String l = "is_dsp_ad";
    private static final String m = "app";
    private static final String n = "package_name";
    private static final String o = "download_url";
    private static final String p = "target_url";
    private static final String q = "video";
    private final Map<String, CreativeInfo> aD;
    private final Map<String, CreativeInfo> aE;
    private final Map<String, CreativeInfo> aF;
    private final Map<String, CreativeInfo> aG;
    final ScheduledExecutorService c;
    private static final String[] aq = {"pglstatp.com", "ipstatp.com", "pglstatp-toutiao.com", "pstatp.com"};
    private static final String[] as = {"device", "thumbnail"};
    private static final String[] at = {"app_version", NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, "developer_name", "orientation", "height", "width", "aspect_ratio", "lp", "is_pre_render"};

    public o() {
        super(com.safedk.android.utils.h.u, d);
        this.aD = new ConcurrentHashMap();
        this.aE = new ConcurrentHashMap();
        this.aF = new ConcurrentHashMap();
        this.aG = new LimitedConcurrentHashMap(50);
        this.c = Executors.newScheduledThreadPool(1);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_FULLSCREEN_ADS, true);
        this.C.b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE, true);
        this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, true);
        this.C.b(AdNetworkConfiguration.AD_ID_EXTRACTED_FROM_BANNER_WEB_VIEW_IS_MAX_CREATIVE_ID, true);
        this.C.b(AdNetworkConfiguration.JS_PRIVACY_BUTTON_CLICK_DETECTION_SCRIPT, ar);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.a(AdNetworkConfiguration.MREC_SCREENSHOT_TAKING_DELAY, 2L);
        Logger.d(d, "PangleDiscovery ctor created");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        com.safedk.android.utils.n.b(d, "generate info url: " + str + " , headers: " + (map != null ? map.toString() : "null") + ", buffer: " + str2);
        if (str.equals("@!1:ad_fetch@!")) {
            return a(str2, aVar);
        }
        return null;
    }

    private List<CreativeInfo> a(String str, c.a aVar) throws JSONException {
        String str2;
        ArrayList<CreativeInfo> arrayList = new ArrayList();
        if (com.safedk.android.utils.n.n(str)) {
            JSONObject jSONObject = new JSONObject(str);
            ArrayList arrayList2 = new ArrayList();
            if (jSONObject.has(e)) {
                JSONArray jSONArray = jSONObject.getJSONArray(e);
                Logger.d(d, "generate info creatives contains " + jSONArray.length() + " items");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    PangleCreativeInfo pangleCreativeInfoA = a(jSONArray.getJSONObject(i2), i2, arrayList2);
                    if (pangleCreativeInfoA != null) {
                        arrayList.add(pangleCreativeInfoA);
                        if (!arrayList2.isEmpty()) {
                            arrayList.addAll(arrayList2);
                        }
                    }
                }
            } else {
                PangleCreativeInfo pangleCreativeInfoA2 = a(jSONObject, 0, arrayList2);
                if (pangleCreativeInfoA2 != null) {
                    arrayList.add(pangleCreativeInfoA2);
                    if (!arrayList2.isEmpty()) {
                        arrayList.addAll(arrayList2);
                    }
                }
            }
            Logger.d(d, "generate info - total creatives: " + arrayList.size());
            try {
                if (arrayList.isEmpty() || !jSONObject.has(ak)) {
                    str2 = "fe0";
                } else {
                    String string = jSONObject.getString(ak);
                    if (!TextUtils.isEmpty(string)) {
                        String str3 = "fe=1|len=" + string.length();
                        JSONObject jSONObject2 = new JSONObject(string);
                        if (jSONObject2.has(al)) {
                            str3 = str3 + "|as=" + jSONObject2.getInt(al);
                        }
                        if (jSONObject2.has(am)) {
                            str3 = str3 + "|cl=" + jSONObject2.getInt(am);
                        }
                        if (jSONObject2.has(an)) {
                            str3 = str3 + "|ct=" + jSONObject2.getInt(an);
                        }
                        if (jSONObject2.has(ao)) {
                            str3 = str3 + "|hm=" + jSONObject2.getBoolean(ao);
                        }
                        if (jSONObject2.has(ap)) {
                            str3 = str3 + "|lms=" + jSONObject2.getInt(ap);
                        }
                        str2 = str3;
                    } else {
                        str2 = "fe=1|len=0";
                    }
                }
                String string2 = UUID.randomUUID().toString();
                String str4 = "/multi_ad/ad_count_" + arrayList.size();
                for (CreativeInfo creativeInfo : arrayList) {
                    creativeInfo.t(str2);
                    if (aVar != null) {
                        creativeInfo.h(aVar.f8068a);
                    }
                    if (arrayList.size() > 1) {
                        PangleCreativeInfo pangleCreativeInfo = (PangleCreativeInfo) creativeInfo;
                        pangleCreativeInfo.a(string2);
                        pangleCreativeInfo.am();
                        pangleCreativeInfo.e(pangleCreativeInfo.h() + str4 + PangleCreativeInfo.f8089a + pangleCreativeInfo.ar());
                        Logger.d(d, "generate info - multi ci downstream struct set to " + pangleCreativeInfo.h() + " for id " + pangleCreativeInfo.N());
                    }
                }
            } catch (Exception e2) {
                Logger.d(d, "parsing exc: " + e2.getMessage());
            }
        } else {
            Logger.d(d, "generate info - not a valid JSON string");
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00eb  */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> t(String str) {
        ArrayList<CreativeInfo> arrayList;
        String strAq;
        try {
            List<CreativeInfo> list = this.I.get(str);
            if (list == null || list.size() == 0) {
                return null;
            }
            if (list.size() != 1) {
                Logger.d(d, "multi: multiCiList size: " + list.size());
                synchronized (list) {
                    arrayList = new ArrayList(list);
                }
                String str2 = null;
                for (CreativeInfo creativeInfo : arrayList) {
                    if (creativeInfo instanceof PangleCreativeInfo) {
                        strAq = ((PangleCreativeInfo) creativeInfo).aq();
                        Logger.d(d, "multi: current commonUuid: " + (str2 == null ? "null" : strAq));
                        if (TextUtils.isEmpty(strAq)) {
                            strAq = str2;
                        }
                    } else {
                        strAq = str2;
                    }
                    str2 = strAq;
                }
                if (!TextUtils.isEmpty(str2)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (CreativeInfo creativeInfo2 : arrayList) {
                        if (creativeInfo2 instanceof PangleCreativeInfo) {
                            PangleCreativeInfo pangleCreativeInfo = (PangleCreativeInfo) creativeInfo2;
                            if (str2.equals(pangleCreativeInfo.aq())) {
                                arrayList2.add(pangleCreativeInfo);
                            }
                        }
                    }
                    return arrayList2;
                }
            } else {
                return list;
            }
        } catch (Exception e2) {
            Logger.d(d, "multi: exc: " + e2.getMessage());
        }
        Logger.d(d, "multi: no commonUuid found in cis, adId: " + str);
        return null;
    }

    private PangleCreativeInfo a(JSONObject jSONObject, int i2, List<PangleCreativeInfo> list) throws JSONException {
        String str;
        if (jSONObject.has("ext")) {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("ext"));
            String strOptString = jSONObject2.optString(j, null);
            String strOptString2 = jSONObject2.optString("creative_id", null);
            BrandSafetyUtils.AdType adType = jSONObject2.optInt(i, 0) == 1 ? BrandSafetyUtils.AdType.BANNER : BrandSafetyUtils.AdType.INTERSTITIAL;
            String strOptString3 = null;
            if (jSONObject.has(U)) {
                strOptString3 = jSONObject.getJSONObject(U).optString("request_id", null);
            }
            String strOptString4 = null;
            String strDecode = null;
            String str2 = b;
            if (jSONObject.has("app")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("app");
                strOptString4 = jSONObject3.optString("package_name", null);
                strDecode = jSONObject3.optString("download_url", null);
                str2 = "app";
            }
            String strOptString5 = jSONObject.optString(p, null);
            if (strDecode == null) {
                strDecode = strOptString5;
            }
            boolean zOptBoolean = jSONObject.optBoolean(f, false);
            String str3 = zOptBoolean ? str2 + ai : str2;
            String strOptString6 = null;
            if (!jSONObject.has("video")) {
                str = null;
            } else {
                JSONObject jSONObject4 = jSONObject.getJSONObject("video");
                String strOptString7 = jSONObject4.optString("endcard", null);
                strOptString6 = jSONObject4.optString("video_url", null);
                str = strOptString7;
            }
            String strOptString8 = jSONObject.optString(X, null);
            if (strOptString8 == null && jSONObject.has("playable")) {
                strOptString8 = jSONObject.getJSONObject("playable").optString(X, null);
            }
            if (strOptString8 == null) {
                strOptString8 = jSONObject2.optString(X, null);
            }
            String str4 = "null".equals(strOptString8) ? null : strOptString8;
            PangleCreativeInfo pangleCreativeInfo = new PangleCreativeInfo(adType, strOptString3, strOptString2, strDecode, strOptString6, str4, zOptBoolean, strOptString, this.G, strOptString4, str3);
            Logger.d(d, "generate info - CI created: " + pangleCreativeInfo);
            List<String> listF = com.safedk.android.utils.n.f(a(jSONObject).toString());
            if (jSONObject.has(aa)) {
                a((CreativeInfo) pangleCreativeInfo, (String) null, jSONObject.getString(aa), true);
                pangleCreativeInfo.e("vast");
            } else {
                if (strOptString6 != null) {
                    listF.remove(strOptString6);
                }
                pangleCreativeInfo.b(listF);
            }
            List<String> arrayList = new ArrayList<>();
            for (String str5 : listF) {
                for (CharSequence charSequence : aq) {
                    if (str5.contains(charSequence)) {
                        arrayList.add(str5);
                        break;
                    }
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            pangleCreativeInfo.c(arrayList);
            if (adType == BrandSafetyUtils.AdType.INTERSTITIAL) {
                if (str != null) {
                    String strA = com.safedk.android.utils.k.a(com.safedk.android.utils.k.a(com.safedk.android.utils.n.z(str), at), as);
                    Logger.d(d, "generate info - keep interstitial CI by end-card: " + strA);
                    synchronized (this.aE) {
                        this.aE.put(strA, pangleCreativeInfo);
                    }
                    this.aG.put(strA, pangleCreativeInfo);
                }
                if (!TextUtils.isEmpty(strOptString5)) {
                    String strReplace = com.safedk.android.utils.n.z(strOptString5).replace("/?", "?");
                    Logger.d(d, "generate info - keep interstitial CI by target url: " + strReplace);
                    synchronized (this.aE) {
                        this.aE.put(strReplace, pangleCreativeInfo);
                    }
                    this.aG.put(strReplace, pangleCreativeInfo);
                }
                if (!TextUtils.isEmpty(str4)) {
                    String strReplace2 = com.safedk.android.utils.n.z(str4).replace("/?", "?");
                    Logger.d(d, "generate info - clean playable url : " + strReplace2);
                    this.aG.put(strReplace2, pangleCreativeInfo);
                }
                if (strDecode != null) {
                    try {
                        strDecode = URLDecoder.decode(strDecode, "UTF-8");
                    } catch (Throwable th) {
                    }
                    String strA2 = com.safedk.android.utils.k.a(strDecode, as);
                    Logger.d(d, "generate info - keep interstitial CI by click url: " + strA2);
                    synchronized (this.aD) {
                        this.aD.put(strA2, pangleCreativeInfo);
                    }
                }
            } else {
                a(jSONObject, (CreativeInfo) pangleCreativeInfo);
                synchronized (this.aF) {
                    this.aF.put(strOptString3, pangleCreativeInfo);
                }
            }
            Logger.d(d, "generate info - keep interstitial CI with adId: " + strOptString3);
            synchronized (this.aF) {
                this.aF.put(strOptString3, pangleCreativeInfo);
            }
            a(jSONObject, pangleCreativeInfo, i2, list);
            return pangleCreativeInfo;
        }
        Logger.d(d, "generate info 'ext' element is missing");
        return null;
    }

    private JSONObject a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(aw);
            if (jSONObjectOptJSONObject != null) {
                jSONObjectOptJSONObject.remove(e);
            }
            return jSONObject2;
        } catch (JSONException e2) {
            return jSONObject;
        }
    }

    private void a(JSONObject jSONObject, PangleCreativeInfo pangleCreativeInfo, int i2, List<PangleCreativeInfo> list) {
        PangleCreativeInfo pangleCreativeInfoA;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(aw);
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(ax);
                StringBuilder sb = new StringBuilder();
                if (jSONObjectOptJSONObject2 != null) {
                    if (jSONObjectOptJSONObject2.has(ay)) {
                        sb.append("|ivrv_rt=").append(jSONObjectOptJSONObject2.getString(ay));
                    }
                    if (jSONObjectOptJSONObject2.has(az)) {
                        sb.append("|ivrv_maec=").append(jSONObjectOptJSONObject2.getInt(az));
                    }
                    if (jSONObjectOptJSONObject2.has(aA)) {
                        sb.append("|ivrv_se=").append(jSONObjectOptJSONObject2.getString(aA));
                    }
                    if (jSONObjectOptJSONObject2.has(aB)) {
                        sb.append("|ivrv_soe=").append(jSONObjectOptJSONObject2.getString(aB));
                    }
                    if (jSONObjectOptJSONObject2.has(aC)) {
                        sb.append("|ivrv_es=").append(jSONObjectOptJSONObject2.getInt(aC));
                    }
                }
                Object objOpt = jSONObjectOptJSONObject.opt(e);
                String str = objOpt instanceof String ? (String) objOpt : null;
                if (str != null) {
                    pangleCreativeInfo.t("creative=" + (i2 + 1) + ((Object) sb));
                    Logger.d(d, "generate info - creatives contains DYNAMIC_CREATIVE creatives: " + pangleCreativeInfo.X());
                    if (str.trim().startsWith(b9.i.d) && str.trim().endsWith(b9.i.e)) {
                        try {
                            JSONArray jSONArray = new JSONArray(str);
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= jSONArray.length()) {
                                    break;
                                }
                                try {
                                    JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                                    JSONObject jSONObject3 = jSONObject2.getJSONObject("app");
                                    String string = jSONObject3.getString("download_url");
                                    String string2 = jSONObject3.getString("package_name");
                                    if (string != null && string.length() > 0 && string2 != null && string2.length() > 0) {
                                        HashSet hashSet = new HashSet();
                                        hashSet.add(string);
                                        pangleCreativeInfo.a(string2, hashSet);
                                        pangleCreativeInfo.d();
                                    }
                                    if (list != null && (pangleCreativeInfoA = a(jSONObject2, i4, (List<PangleCreativeInfo>) null)) != null) {
                                        list.add(pangleCreativeInfoA);
                                        pangleCreativeInfoA.t("creative=" + (i2 + 1) + "|dynamic=" + (i4 + 1));
                                        Logger.d(d, "generate info - set dynamic creative debug info: " + pangleCreativeInfoA.X());
                                    }
                                } catch (Exception e2) {
                                    Logger.d(d, "generate info - dynamic creatives malformed / unidentified creatives json exc: ", e2);
                                }
                                i3 = i4 + 1;
                            }
                            if (list != null) {
                                pangleCreativeInfo.b(list.size());
                                Iterator<PangleCreativeInfo> it = list.iterator();
                                while (it.hasNext()) {
                                    it.next().b(list.size());
                                }
                                return;
                            }
                            return;
                        } catch (Exception e3) {
                            Logger.d(d, "generate info - dynamic creatives malformed / unidentified json exc: " + e3.getMessage());
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            Logger.d(d, "generate info - dynamic creatives not found");
        } catch (Exception e4) {
            Logger.d(d, "generate info - dynamic creatives json analysis exc: " + e4.getMessage());
        }
    }

    private void a(JSONObject jSONObject, CreativeInfo creativeInfo) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(af);
        Logger.d(d, "check if not video ad - tpl info obj= " + jSONObjectOptJSONObject);
        if (jSONObjectOptJSONObject != null) {
            String strOptString = jSONObjectOptJSONObject.optString("data");
            Logger.d(d, "check if not video ad - tpl info string= " + strOptString);
            if (!TextUtils.isEmpty(strOptString)) {
                if (strOptString.contains("\\\"type\\\":\\\"video-") || strOptString.contains("\"type\":\"video-")) {
                    Logger.d(d, "check if not video ad - ad is video. adding to downstream struct");
                    creativeInfo.a("video", RemoteSettings.FORWARD_SLASH_STRING);
                } else {
                    Logger.d(d, "check if not video ad - setting ad not a video ad!");
                    creativeInfo.f(false);
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        String strA = com.safedk.android.utils.k.a(str, as);
        if (this.aD.containsKey(strA)) {
            return true;
        }
        return this.aE.containsKey(com.safedk.android.utils.k.a(strA, at).replace("/?", "?"));
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
    public String c(String str, String str2) {
        Logger.d(d, "get ad ID from resource started, bufferValue = " + str + ", url =" + str2);
        if (str2 == null) {
            return null;
        }
        String strReplace = com.safedk.android.utils.k.a(com.safedk.android.utils.k.a(str2, as), at).replace("/?", "?");
        PangleCreativeInfo pangleCreativeInfo = (PangleCreativeInfo) this.aE.get(strReplace);
        if (pangleCreativeInfo != null) {
            Logger.d(d, "get ad ID from resource - ci found for url : " + str2);
            if (pangleCreativeInfo.h() != null && pangleCreativeInfo.h().contains(b)) {
                Logger.d(d, "get ad ID from resource - identified website end card for url : " + str2);
                pangleCreativeInfo.a(true);
                pangleCreativeInfo.ap();
            }
            Logger.d(d, "get ad ID from resource - found interstitial CI by end card: " + strReplace);
            return pangleCreativeInfo.N();
        }
        try {
            str2 = URLDecoder.decode(str2, "UTF-8");
        } catch (Throwable th) {
        }
        String strA = com.safedk.android.utils.k.a(str2, as);
        PangleCreativeInfo pangleCreativeInfo2 = (PangleCreativeInfo) this.aD.get(strA);
        if (pangleCreativeInfo2 == null) {
            return null;
        }
        Logger.d(d, "get ad ID from resource - found interstitial CI by click url: " + strA);
        return pangleCreativeInfo2.N();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        if (view == null) {
            Logger.d(d, "Ad View view is null");
            return false;
        }
        if (super.e(view) || view.getClass().getName().equals("com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView") || view.getClass().getName().equals("com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout") || view.getClass().getName().equals("com.bytedance.sdk.openadsdk.component.view.OpenScreenAdVideoExpressView") || view.getClass().getName().equals("com.bytedance.sdk.openadsdk.component.view.OpenScreenAdExpressView") || view.getClass().getName().startsWith("com.bytedance.sdk.openadsdk.core.video.nativevideo") || (view.getClass().getName().startsWith("com.bytedance.sdk.openadsdk.core") && (view instanceof FrameLayout))) {
            return true;
        }
        return (view.getClass().getName().startsWith("com.bytedance.sdk.openadsdk.core") || view.getClass().getName().startsWith("com.bytedance.sdk.component")) && (view instanceof FrameLayout);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String j() {
        return com.safedk.android.utils.h.u;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(BrandSafetyUtils.AdType adType, Object obj, String str) {
        Object obj2;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.containsKey("request_id") && (obj2 = map.get("request_id")) != null) {
                Logger.d(d, "extract ad info - request ID: " + obj2);
                return obj2.toString();
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        if (obj instanceof String) {
            com.safedk.android.utils.n.b(d, "match info find ci started, creative infos by id: " + this.aF.toString() + ", creative infos by endcard: " + this.aE.toString());
            String str = (String) obj;
            CreativeInfo creativeInfo = this.aF.get(str);
            if (creativeInfo != null) {
                com.safedk.android.utils.n.b(d, "match info adInstance - MATCH FOUND, CI: " + creativeInfo);
                return creativeInfo;
            }
            synchronized (this.aE) {
                for (CreativeInfo creativeInfo2 : this.aE.values()) {
                    com.safedk.android.utils.n.b(d, "match info find ci checking ci: " + creativeInfo2);
                    if (creativeInfo2.N().equals(str)) {
                        com.safedk.android.utils.n.b(d, "match info find ci MATCH FOUND, ci: " + creativeInfo2);
                        return creativeInfo2;
                    }
                }
                Logger.d(d, "match info find ci no match cannot match with creative id: " + str);
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void c(View view) {
        k(view);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void d(View view) {
        k(view);
    }

    private boolean j(View view) {
        int iIntValue;
        int identifier = SafeDK.getInstance().m().getResources().getIdentifier("tt_reward_full_feedback", "drawable", SafeDK.getInstance().m().getPackageName());
        if (!o(view)) {
            iIntValue = -1;
        } else {
            try {
                Field declaredField = ImageView.class.getDeclaredField("mResource");
                declaredField.setAccessible(true);
                iIntValue = ((Integer) declaredField.get(view)).intValue();
            } catch (Exception e2) {
                Logger.d(d, "on view clicked - could not get mResource from ShadowImageView");
                iIntValue = -1;
            }
        }
        return iIntValue == identifier;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x01c2  */
    private void k(View view) {
        boolean z;
        Drawable drawable;
        int identifier = SafeDK.getInstance().m().getResources().getIdentifier("tt_top_dislike", "id", SafeDK.getInstance().m().getPackageName());
        int identifier2 = SafeDK.getInstance().m().getResources().getIdentifier("tt_ad_endcard_logo", "id", SafeDK.getInstance().m().getPackageName());
        int identifier3 = SafeDK.getInstance().m().getResources().getIdentifier("tt_reward_full_feedback", "drawable", SafeDK.getInstance().m().getPackageName());
        if (identifier3 <= 0 || (drawable = SafeDK.getInstance().m().getResources().getDrawable(identifier3)) == null || !(view instanceof ImageView)) {
            z = false;
        } else {
            ImageView imageView = (ImageView) view;
            Logger.d(d, "on view clicked ttRewardFullFeedBack " + identifier3 + ", drawable sha256 = " + a(drawable) + ", view bg hash : " + a(imageView.getDrawable()));
            if (a(drawable).equals(a(imageView.getDrawable()))) {
                z = true;
                Logger.d(d, "on view clicked tt Reward Full FeedBack match");
            } else {
                z = false;
            }
        }
        boolean zL = l(view);
        boolean zM = m(view);
        Logger.d(d, "on view clicked - view id = " + view.getId() + ", ttTopDislikeResId : " + identifier + ", ttAdEndcardLogoResId : " + identifier2 + ", isDynamicDislikeFeedBack =  " + zL + ", isTopLayoutDislike2 = " + zM);
        if (view.getId() == identifier || zL || zM || z) {
            Logger.d(d, "on view clicked - view type is: " + view.getClass().getName());
            if (n(view) || j(view) || zL || z) {
                String strA = BrandSafetyUtils.a(view);
                Logger.d(d, "_AD_CAPTURE_ on view clicked - clicked the 'top dislike' ShadowTextView. Stop taking screenshot for current impression, address=" + strA);
                com.safedk.android.analytics.brandsafety.b.a(strA, com.safedk.android.analytics.brandsafety.l.q, new com.safedk.android.analytics.brandsafety.l.a[0]);
                CreativeInfoManager.b(com.safedk.android.utils.h.u, strA);
                return;
            }
            return;
        }
        if (view.getId() == identifier2) {
            Logger.d(d, "on view clicked - view type is =" + view.getClass().getName());
            if (view instanceof TextView) {
                Logger.d(d, "on view clicked - clicked the 'ad endcard logo' TextView. Stop taking screenshot for current impression");
                CreativeInfoManager.b(com.safedk.android.utils.h.u, BrandSafetyUtils.a(view));
                return;
            }
            return;
        }
        Logger.d(d, "on view clicked - clicked view is not the 'top dislike' nor 'ad end-card logo' view.");
    }

    private boolean l(View view) {
        boolean z = view.getParent().getClass().getName().equals("com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicDislikeFeedBack") || (view.getParent().getClass().getName().startsWith("com.bytedance.sdk.component") && (view instanceof FrameLayout));
        if (z) {
            Logger.d(d, "isViewDynamicDislikeFeedBack identified " + view);
        }
        return z;
    }

    private boolean m(View view) {
        boolean z = view.getParent().getClass().getName().equals("com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2") || (view.getParent() instanceof FrameLayout);
        if (z) {
            Logger.d(d, "isViewTopLayoutDislike2 identified " + view);
        }
        return z;
    }

    private boolean n(View view) {
        boolean z = view.getClass().getName().equals("com.bytedance.sdk.openadsdk.core.widget.ShadowTextView") || (view.getClass().getName().startsWith(com.safedk.android.utils.h.u) && (view instanceof TextView));
        if (z) {
            Logger.d(d, "isViewShadowTextView identified " + view);
        }
        return z;
    }

    private boolean o(View view) {
        boolean z = view.getClass().getName().equals("com.bytedance.sdk.openadsdk.core.widget.ShadowImageView") || (view.getClass().getName().startsWith(com.safedk.android.utils.h.u) && (view instanceof ImageView));
        if (z) {
            Logger.d(d, "isViewShadowImageView identified " + view);
        }
        return z;
    }

    private boolean a(WeakReference<View> weakReference) {
        boolean z = weakReference.get().getClass().getName().contains("NativeExpressVideoView") || (weakReference.get().getClass().getName().startsWith("com.bytedance.sdk.openadsdk.core") && (weakReference.get() instanceof FrameLayout));
        if (z) {
            Logger.d(d, "isViewNativeExpressVideoView identified " + weakReference.get());
        }
        return z;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(com.safedk.android.analytics.brandsafety.d dVar, List<WeakReference<View>> list) {
        for (WeakReference<View> weakReference : list) {
            if (weakReference != null && weakReference.get() != null && a(weakReference)) {
                Logger.d(d, "save screenshot view - saving view= " + weakReference.get() + ", with key= " + dVar);
                this.O.put(dVar, new WeakReference<>(weakReference.get()));
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
        com.safedk.android.utils.e.a(this.aF, "PangleDiscovery:creativeInfosById");
        com.safedk.android.utils.e.a(this.aE, "PangleDiscovery:creativeInfosByEndcard");
        com.safedk.android.utils.e.a(this.aD, "PangleDiscovery:creativeInfosByClickUrl");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(View view, int i2, int i3) {
        boolean z = (View.MeasureSpec.getSize(i2) == 0 && View.MeasureSpec.getSize(i3) == 0) ? false : true;
        Logger.d(d, "view on measure - view= " + view + ",   size is not zero= " + z);
        String name = view.getClass().getName();
        if (TextUtils.isEmpty(name)) {
            return;
        }
        if ((name.equals(au) || name.equals(av)) && z) {
            String strA = BrandSafetyUtils.a(view);
            Logger.d(d, "_AD_CAPTURE_ view on measure - view is pp/dislike, Stop taking screenshot for current impression, address=" + strA);
            com.safedk.android.analytics.brandsafety.b.a(strA, com.safedk.android.analytics.brandsafety.l.q, new com.safedk.android.analytics.brandsafety.l.a[0]);
            CreativeInfoManager.b(com.safedk.android.utils.h.u, strA);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean p(String str) {
        boolean z;
        if (str == null) {
            return false;
        }
        String strReplace = str.replace("/?", "?");
        synchronized (this.aG) {
            for (String str2 : this.aG.keySet()) {
                if (strReplace.toLowerCase().startsWith(str2.toLowerCase())) {
                    Logger.d(d, "should stop collecting resources, url: " + strReplace);
                    PangleCreativeInfo pangleCreativeInfo = (PangleCreativeInfo) this.aG.get(str2);
                    if (pangleCreativeInfo != null) {
                        Logger.d(d, "should stop collecting resources, ci found for url : " + strReplace);
                        if (pangleCreativeInfo.h() != null && pangleCreativeInfo.h().contains(b)) {
                            Logger.d(d, "should stop collecting resources, identified website end card for url : " + strReplace);
                            pangleCreativeInfo.a(true);
                            pangleCreativeInfo.ap();
                            z = true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            z = false;
        }
        return z;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean z(String str) {
        return str.contains("\"did\"") && str.contains("\"s_send_ts\"");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void e(String str) {
        JSONObject jSONObjectOptJSONObject;
        boolean z = false;
        try {
            if (str.startsWith("{\"creatives\"") || str.startsWith("{\"interaction_type\"")) {
                CreativeInfoManager.a(this.Q, "@!1:ad_fetch@!", str, (Map<String, List<String>>) null);
                return;
            }
            if (str.contains("{\"app_log_url\"")) {
                com.safedk.android.utils.n.b(d, "message is: " + str);
                final SafeDK safeDK = SafeDK.getInstance();
                if (str.contains("\"tag\":\"fullscreen_interstitial_ad\"") || str.contains("\"tag\":\"rewarded_video\"")) {
                    if (str.contains("\"label\":\"feed_over\"") || str.contains("\"label\":\"skip\"") || (str.contains("\"label\":\"endcard_page_info\"") && str.contains("\"track_name\\\":\\\"endcard_pageview\\\""))) {
                        CreativeInfoManager.a(this.Q, (String) null, true, "event");
                        z = true;
                    } else if (str.contains("\"event\":\"feed_play\"")) {
                        Logger.d(d, "video start event detected");
                        CreativeInfoManager.a(this.Q, (String) null, false, "event");
                    }
                } else if (str.contains("\"tag\":\"landingpage_direct\",\"label\":\"load_finish\"") || (str.contains("\"tag\":\"landingpage_direct\"") && str.contains("\"event\":\"progress_load_finish\""))) {
                    CreativeInfoManager.a(this.Q, (String) null, true, "event");
                    if (safeDK == null || safeDK.z() == null) {
                        z = true;
                    } else {
                        Logger.d(d, "landingpage_direct added to downstream struct");
                        safeDK.z().g(com.safedk.android.utils.h.u, "landingpage_direct");
                        z = true;
                    }
                } else if (str.contains("\"tag\":\"banner_ad\"") && ((str.contains("\"event\":\"feed_over\"") || str.contains("\"event\":\"play_error\"")) && com.safedk.android.utils.n.n(str) && (jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("params")) != null)) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("log_extra");
                    String strOptString = jSONObjectOptJSONObject.optString("log_extra");
                    if (!TextUtils.isEmpty(strOptString) && com.safedk.android.utils.n.n(strOptString) && jSONObjectOptJSONObject2 == null) {
                        jSONObjectOptJSONObject2 = new JSONObject(strOptString);
                    }
                    if (jSONObjectOptJSONObject2 != null) {
                        final String string = jSONObjectOptJSONObject2.getString("req_id");
                        if (!TextUtils.isEmpty(string) && safeDK != null && safeDK.A() != null) {
                            this.c.schedule(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.creatives.discoveries.o.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    safeDK.A().g(o.this.Q, string);
                                }
                            }, 1L, TimeUnit.SECONDS);
                        }
                    }
                }
                if (z && safeDK != null && safeDK.z() != null) {
                    safeDK.z().r(this.Q);
                    return;
                }
                return;
            }
            if (com.safedk.android.utils.n.n(str)) {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString2 = jSONObject.optString("track_name");
                if (!TextUtils.isEmpty(strOptString2) && strOptString2.equals("endcard_pageview")) {
                    Logger.d(d, "json object init - found endcard");
                    CreativeInfoManager.e(this.Q);
                } else if (!TextUtils.isEmpty(jSONObject.optString("video_url")) && !TextUtils.isEmpty(jSONObject.optString("total_duration"))) {
                    Logger.d(d, "json object init - video ended");
                    CreativeInfoManager.a(this.Q, (String) null, true, "event");
                }
                if (jSONObject.has("clickAreaType") && jSONObject.get("clickAreaType").equals("View-DISLIKE")) {
                    Logger.d(d, "json object init - dislike view clicked");
                    List<com.safedk.android.analytics.brandsafety.n> listA = SafeDK.getInstance().z().G.a(com.safedk.android.utils.h.u);
                    if (listA != null && listA.size() == 1) {
                        String strA = BrandSafetyUtils.a(listA.get(0).K());
                        Logger.d(d, "_AD_CAPTURE_ json object init - clicked the 'top dislike' ShadowTextView. Stop taking screenshot for current impression, address=" + strA);
                        com.safedk.android.analytics.brandsafety.b.a(strA, com.safedk.android.analytics.brandsafety.l.q, new com.safedk.android.analytics.brandsafety.l.a[0]);
                        CreativeInfoManager.b(com.safedk.android.utils.h.u, strA);
                    }
                }
            }
        } catch (Throwable th) {
            Logger.e(d, "Exception in json object detected", th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<String> e() {
        List<String> listE = super.e();
        listE.add("url");
        return listE;
    }

    public static String a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap() != null) {
                    byte[] ninePatchChunk = bitmapDrawable.getBitmap().getNinePatchChunk();
                    if (ninePatchChunk != null) {
                        messageDigest.update(ninePatchChunk);
                    } else {
                        messageDigest.update(bitmapDrawable.getBitmap().getConfig().toString().getBytes("UTF-8"));
                        messageDigest.update(String.valueOf(bitmapDrawable.getBitmap().getWidth()).getBytes("UTF-8"));
                        messageDigest.update(String.valueOf(bitmapDrawable.getBitmap().getHeight()).getBytes("UTF-8"));
                    }
                }
            } else if (drawable instanceof ColorDrawable) {
                messageDigest.update(String.valueOf(((ColorDrawable) drawable).getColor()).getBytes("UTF-8"));
            } else {
                messageDigest.update(drawable.getClass().getName().getBytes("UTF-8"));
                messageDigest.update(String.valueOf(drawable.getIntrinsicWidth()).getBytes("UTF-8"));
                messageDigest.update(String.valueOf(drawable.getIntrinsicHeight()).getBytes("UTF-8"));
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Exception e2) {
            Logger.d(d, "Exception : " + e2.getMessage(), e2);
            return null;
        }
    }
}
