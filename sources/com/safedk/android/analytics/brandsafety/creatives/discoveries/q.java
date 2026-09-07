package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.RedirectDetails;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.SmaatoCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
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
public class q extends d {
    private static final String R = "adtype";
    private static final String S = "adSourceId";
    private static final String T = "track.smaato.net";
    private static final String U = "clicktrackers";
    private static final String V = "t";
    private static final String W = "KEY_CTA_URL";
    private static final String X = "smaato_sdk_video_companion_view_id";
    public static final String b = "smaato://open";
    public static final String c = "smaato://expand";
    public static final String d = "url";
    private static final String f = "SmaatoDiscovery";
    private static final String g = "seatbid";
    private static final String h = "bid";
    private static final String i = "adm";
    private static final String j = "richmedia";
    private static final String k = "mediadata";
    private static final String l = "content";
    private static final String m = "id";
    private static final String n = "adomain";
    private static final String o = "iurl";
    private static final String p = "ext";
    private static final String q = "smt";
    private final ConcurrentHashMap<String, CreativeInfo> Z;
    public static final String[] e = {"smaato://addEventListener", "smaato://close"};
    private static final Map<String, ArrayList<String>> Y = new HashMap();
    private static final Map<String, Set<CreativeInfo>> aa = new HashMap();
    private static final Map<Integer, Set<CreativeInfo>> ab = new HashMap();

    public q() {
        super(com.safedk.android.utils.h.v, f);
        this.Z = new ConcurrentHashMap<>();
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, true);
        this.C.b(AdNetworkConfiguration.USE_INPUT_STREAM_EVENT_AS_RESOURCE_LOADED_INDICATION, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_TO_IGNORE, "SMAATO_NETWORK");
        this.C.b(AdNetworkConfiguration.SHOULD_ALLOW_CI_MATCHING_WITH_INCOMPATIBLE_EVENT_IDS, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_CAPTURE_SURFACE_VIEW_WHEN_USING_PIXELCOPY, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        com.safedk.android.utils.n.b(f, "generate info started, url: " + str + ", max params: " + aVar + ", bufferValue: " + str2);
        ArrayList arrayList = new ArrayList();
        if (com.safedk.android.utils.n.n(str2)) {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has(g)) {
                JSONArray jSONArray = jSONObject.getJSONArray(g);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2.has("bid")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("bid");
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            arrayList.add(a(jSONArray2.getJSONObject(i3), aVar));
                        }
                    }
                }
            }
        } else {
            Logger.d(f, "generate info - not a valid JSON string");
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0090  */
    /* JADX WARN: Code duplicated, block: B:30:0x0094  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:51:0x0178 A[Catch: JSONException -> 0x01cb, TRY_LEAVE, TryCatch #1 {JSONException -> 0x01cb, blocks: (B:48:0x0169, B:49:0x0170, B:51:0x0178), top: B:75:0x0169 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0186 A[Catch: JSONException -> 0x01ce, TryCatch #2 {JSONException -> 0x01ce, blocks: (B:53:0x0180, B:55:0x0186, B:57:0x0192), top: B:77:0x0180 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0192 A[Catch: JSONException -> 0x01ce, TRY_LEAVE, TryCatch #2 {JSONException -> 0x01ce, blocks: (B:53:0x0180, B:55:0x0186, B:57:0x0192), top: B:77:0x0180 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:81:0x01b0 A[SYNTHETIC] */
    private CreativeInfo a(JSONObject jSONObject, c.a aVar) throws JSONException {
        String str;
        String str2;
        String str3;
        BrandSafetyUtils.AdType adType;
        String str4;
        CreativeInfo smaatoCreativeInfo;
        String strE;
        JSONArray jSONArray;
        int i2;
        String strD;
        String string;
        String str5;
        String str6 = null;
        String string2 = null;
        if (jSONObject.has("id")) {
            string2 = jSONObject.getString("id");
        }
        String string3 = null;
        if (jSONObject.has(o)) {
            string3 = jSONObject.getString(o);
        }
        String strOptString = null;
        if (jSONObject.has("ext")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("ext");
            if (jSONObject2.has(q)) {
                strOptString = jSONObject2.getJSONObject(q).optString(R, null);
            }
        }
        String string4 = null;
        if (jSONObject.has(n)) {
            string4 = jSONObject.getJSONArray(n).getString(0);
        }
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("adm")) {
            str = null;
            str2 = null;
            str3 = strOptString;
        } else {
            String string5 = jSONObject.getString("adm");
            arrayList.addAll(com.safedk.android.utils.n.f(string5));
            if (com.safedk.android.analytics.brandsafety.creatives.h.a(string5)) {
                if (TextUtils.isEmpty(strOptString)) {
                    str5 = "vast";
                } else {
                    str5 = strOptString + "/vast";
                }
                str = null;
                str2 = string5;
                str3 = str5;
            } else {
                try {
                    JSONObject jSONObject3 = new JSONObject(string5);
                    if (!jSONObject3.has(j)) {
                        strE = null;
                    } else {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(j);
                        if (!jSONObject4.has(k)) {
                            strE = null;
                            if (jSONObject4.has("clicktrackers")) {
                                jSONArray = jSONObject4.getJSONArray("clicktrackers");
                                strD = null;
                                for (i2 = 0; i2 < jSONArray.length(); i2++) {
                                    string = jSONArray.getString(i2);
                                    if (com.safedk.android.utils.k.d(string, "t") != null) {
                                        strD = com.safedk.android.utils.k.d(string, "t");
                                        Logger.d(f, "generate info - adId is " + strD);
                                    }
                                }
                                str6 = strD;
                            }
                        } else {
                            JSONObject jSONObject5 = jSONObject4.getJSONObject(k);
                            if (!jSONObject5.has("content")) {
                                strE = null;
                            } else {
                                String strB = B(jSONObject5.getString("content"));
                                strE = E(strB);
                                try {
                                    arrayList.addAll(com.safedk.android.utils.n.f(strB));
                                } catch (JSONException e2) {
                                    str = strE;
                                    Logger.d(f, "generate info - not a json string");
                                    str2 = null;
                                    str3 = strOptString;
                                    if (aVar.b != BrandSafetyEvent.AdFormatType.INTER) {
                                        adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                                    } else {
                                        adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                                    }
                                    if (str6 == null) {
                                        str4 = string2;
                                    } else {
                                        str4 = str6;
                                    }
                                    Logger.d(f, "generate info - id: " + str4 + ", max params: " + aVar);
                                    smaatoCreativeInfo = new SmaatoCreativeInfo(str4, aVar.d, adType, aVar.b, aVar.c, string4, string3, str3, this.G, str);
                                    smaatoCreativeInfo.h(aVar.f8068a);
                                    this.Z.put(str4, smaatoCreativeInfo);
                                    if (str2 != null) {
                                        a(smaatoCreativeInfo, (String) null, str2, false);
                                        if (smaatoCreativeInfo.J() != null) {
                                            Logger.d(f, "generate info - no entry for video url, calling handleVastMediaFile for " + smaatoCreativeInfo.J());
                                            a(smaatoCreativeInfo.J(), smaatoCreativeInfo);
                                        }
                                    }
                                    ArrayList<String> arrayListF = com.safedk.android.utils.n.f(jSONObject.toString());
                                    arrayListF.addAll(arrayList);
                                    smaatoCreativeInfo.b((List<String>) arrayListF);
                                    return smaatoCreativeInfo;
                                }
                            }
                            if (jSONObject4.has("clicktrackers")) {
                                jSONArray = jSONObject4.getJSONArray("clicktrackers");
                                strD = null;
                                while (i2 < jSONArray.length()) {
                                    try {
                                        string = jSONArray.getString(i2);
                                        if (com.safedk.android.utils.k.d(string, "t") != null) {
                                            strD = com.safedk.android.utils.k.d(string, "t");
                                            Logger.d(f, "generate info - adId is " + strD);
                                        }
                                    } catch (JSONException e3) {
                                        str = strE;
                                        str6 = strD;
                                        Logger.d(f, "generate info - not a json string");
                                        str2 = null;
                                        str3 = strOptString;
                                    }
                                }
                                str6 = strD;
                            }
                        }
                    }
                    str = strE;
                    str2 = null;
                    str3 = strOptString;
                } catch (JSONException e4) {
                    str = null;
                }
            }
        }
        if (aVar.b != BrandSafetyEvent.AdFormatType.INTER || aVar.b == BrandSafetyEvent.AdFormatType.REWARD) {
            adType = BrandSafetyUtils.AdType.INTERSTITIAL;
        } else {
            adType = BrandSafetyUtils.AdType.BANNER;
        }
        if (str6 == null) {
            str4 = string2;
        } else {
            str4 = str6;
        }
        Logger.d(f, "generate info - id: " + str4 + ", max params: " + aVar);
        smaatoCreativeInfo = new SmaatoCreativeInfo(str4, aVar.d, adType, aVar.b, aVar.c, string4, string3, str3, this.G, str);
        smaatoCreativeInfo.h(aVar.f8068a);
        this.Z.put(str4, smaatoCreativeInfo);
        if (str2 != null) {
            a(smaatoCreativeInfo, (String) null, str2, false);
            if (smaatoCreativeInfo.J() != null && !aa.containsKey(com.safedk.android.utils.k.p(smaatoCreativeInfo.J()))) {
                Logger.d(f, "generate info - no entry for video url, calling handleVastMediaFile for " + smaatoCreativeInfo.J());
                a(smaatoCreativeInfo.J(), smaatoCreativeInfo);
            }
        }
        ArrayList<String> arrayListF2 = com.safedk.android.utils.n.f(jSONObject.toString());
        arrayListF2.addAll(arrayList);
        smaatoCreativeInfo.b((List<String>) arrayListF2);
        return smaatoCreativeInfo;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        Logger.d(f, "handleVastMediaFile started, mediaUrl = " + str);
        c(creativeInfo, com.safedk.android.utils.k.p(str));
        Logger.d(f, "handleVastMediaFile mediaUrl = " + str + ", url hash = " + com.safedk.android.utils.k.p(str) + " , ci id = " + creativeInfo.N() + ", videoUrlHashSetToCiMap keys: " + aa.keySet());
        return null;
    }

    private static void c(CreativeInfo creativeInfo, String str) {
        Set<CreativeInfo> hashSet = aa.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            aa.put(str, hashSet);
        }
        hashSet.add(creativeInfo);
        Logger.d(f, "save vast video identifier to ci - saving to videoIdToCiMap.  videoUrl= " + str + ",    ci= " + creativeInfo.aa());
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void b(Object obj, Object obj2) {
        try {
            String strA = a(Uri.parse((String) obj2));
            Logger.d(f, "handle media player set data source call - hash = " + strA + ", videoUrlHashSetToCiMap keys = " + aa.keySet());
            if (!TextUtils.isEmpty(strA) && aa.containsKey(strA)) {
                Set<CreativeInfo> setC = C(strA);
                Logger.d(f, "handle media player set data source call - found? ci set= " + setC);
                if (setC != null) {
                    int iIdentityHashCode = System.identityHashCode(obj);
                    Logger.d(f, "handle media player set data source call - putting mediaPlayerHashToCiSetMap playerId= " + iIdentityHashCode);
                    ab.put(Integer.valueOf(iIdentityHashCode), setC);
                }
            }
        } catch (Exception e2) {
            Logger.e(f, "exception when trying to add mediaPlayer id and SmaatoCreativeInfo " + e2.getMessage());
        }
    }

    private static Set<CreativeInfo> C(String str) {
        Logger.d(f, "find ci by video url - videoUrlToCiSetMap size= " + aa.size() + ",   keys= " + aa.keySet());
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : aa.keySet()) {
                if (str2.contains(str)) {
                    Set<CreativeInfo> set = aa.get(str2);
                    Logger.d(f, "find ci by video url - creative info set found= " + set);
                    return set;
                }
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String b(Object obj) {
        int iIdentityHashCode = System.identityHashCode(obj);
        Logger.d(f, "get creative info after media player start call - mediaPlayer= " + obj + ", player id= " + iIdentityHashCode);
        Set<CreativeInfo> set = ab.get(Integer.valueOf(iIdentityHashCode));
        if (set != null) {
            Logger.d(f, "get creative info after media player start call - found ? ci set (" + set.size() + ")= " + set);
            if (set.size() == 1) {
                CreativeInfo next = set.iterator().next();
                if (next != null) {
                    Logger.d(f, "get creative info after media player start call - found ci Id = " + next.N());
                    e(next);
                    return next.N();
                }
            } else if (set.size() > 1) {
                try {
                    CreativeInfo next2 = set.iterator().next();
                    set.remove(next2);
                    Logger.d(f, "get creative info after media player start call - found ci id = " + next2.N());
                    return next2.N();
                } catch (Throwable th) {
                    Logger.d(f, "get creative info after media player start call exception : " + th, th);
                }
            } else {
                Logger.d(f, "get creative info after media player start call - = could not find ci. ci set= " + set);
            }
        }
        return null;
    }

    private static void e(CreativeInfo creativeInfo) {
        if (creativeInfo != null) {
            Logger.d(f, "remove matched ci from all collections - removing ci from collection mediaPlayerHashToCiSetMap");
            c(f, creativeInfo, ab);
            Logger.d(f, "remove matched ci from all collections - removing ci from collection videoUrlToCiListMap");
            c(f, creativeInfo, aa);
        }
    }

    public static String a(Uri uri) {
        String path = uri.getPath();
        if (path == null || path.isEmpty()) {
            return "";
        }
        int iLastIndexOf = path.lastIndexOf(47);
        if (iLastIndexOf != -1) {
            path = path.substring(iLastIndexOf + 1);
        }
        int iIndexOf = path.indexOf(46);
        return iIndexOf != -1 ? path.substring(0, iIndexOf) : path;
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
    public List<String> e() {
        List<String> listE = super.e();
        listE.add(W);
        return listE;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        Logger.d(f, "generate info adInstance: " + obj.getClass().getName() + ": " + obj + ", hashes: " + this.Z.keySet().toString());
        if (obj instanceof String) {
            String str = (String) obj;
            CreativeInfo creativeInfoRemove = this.Z.remove(str);
            if (creativeInfoRemove != null) {
                com.safedk.android.utils.n.b(f, "generate info adInstance - MATCH FOUND, CI: " + creativeInfoRemove);
                return creativeInfoRemove;
            }
            Logger.d(f, "generate info adInstance - no match cannot match with ad ID: " + str + ", creativeInfosById keyset : " + this.Z);
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        return super.e(view) || com.safedk.android.utils.n.c(view, "AdContentView");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String j() {
        return com.safedk.android.utils.h.v;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(BrandSafetyUtils.AdType adType, Object obj, String str) {
        if (obj instanceof Collection) {
            com.safedk.android.utils.n.b(f, "extract ad info, found field class: " + obj.getClass().getName() + ", type: " + obj.getClass().getName() + ", name: " + str + ", value: " + obj);
            return a((Collection<?>) obj);
        }
        if (obj instanceof Map) {
            com.safedk.android.utils.n.b(f, "extract ad info, found field class: " + obj.getClass().getName() + ", type: " + obj.getClass().getName() + ", name: " + str + ", value: " + obj);
            return a(((Map) obj).values());
        }
        return null;
    }

    private String a(Collection<?> collection) {
        return a(collection, 0);
    }

    private String a(Collection<?> collection, int i2) {
        String str = null;
        if (i2 >= 3) {
            Logger.d(f, "extract ad id from url list - tried to extract 3 times and encountered ConcurrentModificationException, exiting with null");
            return null;
        }
        if (i2 > 0) {
            Logger.d(f, "extract ad id from url list - retrying for the " + i2 + " time after getting Concurrent Modification Exception");
        }
        try {
            for (Object obj : collection) {
                Logger.d(f, "extract ad info - list: " + collection);
                if (obj.toString().contains(T)) {
                    String strD = com.safedk.android.utils.k.d(obj.toString(), "t");
                    if (strD != null) {
                        Logger.d(f, "extract ad info - ad source ID: " + strD);
                        str = strD;
                        break;
                    }
                    String strD2 = com.safedk.android.utils.k.d(obj.toString(), S);
                    if (strD2 != null) {
                        Logger.d(f, "extract ad info - ad source ID: " + strD2);
                        str = strD2;
                        break;
                    }
                }
            }
            return str;
        } catch (ConcurrentModificationException e2) {
            return a(collection, i2 + 1);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public WeakReference<WebView> a(List<WeakReference<WebView>> list, String str) {
        if (list.isEmpty()) {
            return null;
        }
        for (WeakReference<WebView> weakReference : list) {
            if (weakReference.get() != null) {
                try {
                    f(str, BrandSafetyUtils.a(weakReference));
                    Logger.d(f, "select WebView: " + weakReference.get() + " context: " + weakReference.get().getContext());
                    if (weakReference.get().getResources().getResourceEntryName(weakReference.get().getId()).equals(X)) {
                        return weakReference;
                    }
                } catch (NullPointerException e2) {
                    Logger.d(f, "select WebView failed to get resource entry name. selecting default webview.");
                }
            }
        }
        return list.get(0);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public RedirectDetails.RedirectType k(String str) {
        if (str != null) {
            if (str.startsWith(b)) {
                return RedirectDetails.RedirectType.REDIRECT;
            }
            if (str.startsWith(c)) {
                return RedirectDetails.RedirectType.EXPAND;
            }
            for (String str2 : e) {
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
            if (str.startsWith(b) || str.startsWith(c)) {
                return com.safedk.android.utils.k.d(str, "url");
            }
            return str;
        }
        return str;
    }

    public static String B(String str) {
        Matcher matcher = Pattern.compile("<div\\s+[^>]*id=[\"']adm[\"'][^>]*>(.*?)</div>", 32).matcher(str);
        if (matcher.find()) {
            try {
                String str2 = new String(Base64.decode(matcher.group(1), 0));
                StringBuffer stringBuffer = new StringBuffer();
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement("<div id=\"adm\">" + str2 + "</div>"));
                matcher.appendTail(stringBuffer);
                return stringBuffer.toString();
            } catch (Throwable th) {
                Logger.d(f, "Exception decoding html : " + th.getMessage(), th);
                return str;
            }
        }
        return str;
    }
}
