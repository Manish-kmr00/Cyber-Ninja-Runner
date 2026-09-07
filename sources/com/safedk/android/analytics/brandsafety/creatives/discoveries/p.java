package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.PubMaticCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p extends d {
    private static final String b = "PubMaticDiscovery";
    private static final String c = "seatbid";
    private static final String d = "bid";
    private static final String e = "crid";
    private static final String f = "adomain";
    private static final String g = "ext";
    private static final String h = "crtype";
    private static final String i = "adm";
    private static final String j = "PubMatic";
    private static final int k = 50;
    private static final ConcurrentHashMap<String, String> l = new LimitedConcurrentHashMap(50);
    private static final ConcurrentHashMap<String, String> m = new LimitedConcurrentHashMap(50);
    private static final ConcurrentHashMap<String, WeakReference<Object>> n = new LimitedConcurrentHashMap(50);
    private static final ConcurrentHashMap<String, WeakReference<Object>> o = new LimitedConcurrentHashMap(50);
    private static final ConcurrentHashMap<String, String> p = new LimitedConcurrentHashMap(50);

    public p() {
        super(com.safedk.android.utils.h.F, b);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_GET_HTML_TEXT_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SHOULD_INJECT_JS_TO_WEBVIEWS_FOR_TEXT_EXTRACTION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE, true);
    }

    private boolean a(com.safedk.android.analytics.brandsafety.creatives.h.a aVar) {
        return (aVar == null || TextUtils.isEmpty(aVar.e()) || aVar.d() == null || !aVar.d().equals(j)) ? false : true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected com.safedk.android.analytics.brandsafety.creatives.h.a a(CreativeInfo creativeInfo, String str, String str2, boolean z) {
        boolean zB = creativeInfo.B();
        com.safedk.android.analytics.brandsafety.creatives.h.a aVarA = super.a(creativeInfo, str, str2, z);
        if (aVarA == null) {
            return null;
        }
        Logger.d(b, "update vast CI - is inner vast: " + zB + " does contains vast ad tag: " + TextUtils.isEmpty(aVarA.e()) + ", isVastWrapper ? " + a(aVarA));
        if (!a(aVarA)) {
            PubMaticCreativeInfo pubMaticCreativeInfo = (PubMaticCreativeInfo) creativeInfo;
            pubMaticCreativeInfo.d(aVarA.h());
            Logger.d(b, "update vast CI - media urls are: " + aVarA.h());
            synchronized (m) {
                m.put(pubMaticCreativeInfo.aq(), creativeInfo.N());
            }
            Logger.d(b, "update vast CI - storing for ad id: " + creativeInfo.N() + " the value: " + pubMaticCreativeInfo.aq());
            List<String> listI = aVarA.i();
            if (!com.safedk.android.utils.n.a((Collection<?>) listI)) {
                com.safedk.android.utils.n.b(b, "vast impression url to add: " + listI.get(listI.size() - 1));
                ((PubMaticCreativeInfo) creativeInfo).a(listI.get(listI.size() - 1));
            } else {
                Logger.d(b, "vast impression url - empty");
            }
        }
        a(creativeInfo, aVarA);
        return aVarA;
    }

    private static void a(CreativeInfo creativeInfo, com.safedk.android.analytics.brandsafety.creatives.h.a aVar) {
        if (aVar.q() != null) {
            creativeInfo.b(aVar.q());
        }
        if (aVar.p() != null) {
            creativeInfo.b(aVar.p());
        }
        if (aVar.i() != null) {
            creativeInfo.b(aVar.i());
        }
        if (aVar.p() != null) {
            creativeInfo.b(aVar.p());
        }
        if (aVar.h() != null) {
            creativeInfo.b(aVar.h());
        }
        if (aVar.r() != null) {
            creativeInfo.b(aVar.r());
        }
        if (aVar.j() != null) {
            creativeInfo.b(aVar.j());
        }
    }

    private void c(CreativeInfo creativeInfo, String str) {
        if (a(creativeInfo, (String) null, str, true) != null) {
            Logger.d(b, "handle vast in prefetch: before - " + creativeInfo.h());
            if (creativeInfo.h() == null || !creativeInfo.h().contains("vast")) {
                creativeInfo.a("vast", RemoteSettings.FORWARD_SLASH_STRING);
            }
            Logger.d(b, "handle vast in prefetch: after - " + creativeInfo.h());
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        PubMaticCreativeInfo pubMaticCreativeInfo;
        String strReplace;
        Logger.d(b, "generate info - started, url= " + str + ", buffer size: " + (str2 == null ? "0" : Integer.valueOf(str2.length())) + "requestHeaders: " + map + ", max params: " + aVar);
        try {
            if (!com.safedk.android.utils.n.l(str2)) {
                return new ArrayList();
            }
            JSONObject jSONObject = new JSONObject(str2);
            String strOptString = jSONObject.optString("id");
            BrandSafetyUtils.AdType adTypeA = null;
            BrandSafetyEvent.AdFormatType adFormatType = null;
            if (aVar != null && aVar.b != null) {
                adTypeA = BrandSafetyUtils.a(aVar.b);
                adFormatType = aVar.b;
            }
            String str3 = null;
            String str4 = null;
            String str5 = null;
            if (aVar != null) {
                str3 = aVar.d;
                str4 = aVar.c;
                str5 = aVar.f8068a;
            }
            pubMaticCreativeInfo = new PubMaticCreativeInfo(adTypeA, strOptString, str3, null, null, adFormatType, str4, this.G, null, "", str5, null, false, false);
            try {
                this.H.put(strOptString, pubMaticCreativeInfo);
                Logger.d(b, "generate info - filling parameters for ci with id: " + pubMaticCreativeInfo.N() + " ad type: " + pubMaticCreativeInfo.M() + " ad format: " + pubMaticCreativeInfo.K());
                Logger.d(b, "generate info - ci placement id: " + pubMaticCreativeInfo.H() + " creative id: " + pubMaticCreativeInfo.P() + " event id: " + pubMaticCreativeInfo.n());
                JSONArray jSONArray = jSONObject.getJSONArray(c);
                Logger.d(b, "generate info - started iterating " + jSONArray.length() + " seatbids");
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONArray jSONArray2 = jSONArray.optJSONObject(i3).getJSONArray("bid");
                    Logger.d(b, "generate info - started iterating " + jSONArray2.length() + " bids");
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 < jSONArray2.length()) {
                            JSONObject jSONObjectOptJSONObject = jSONArray2.optJSONObject(i3);
                            String strOptString2 = jSONObjectOptJSONObject.optString(e);
                            if (!TextUtils.isEmpty(strOptString2)) {
                                pubMaticCreativeInfo.k(strOptString2);
                            }
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(f);
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                                pubMaticCreativeInfo.i((String) jSONArrayOptJSONArray.get(0));
                            }
                            String strOptString3 = jSONObjectOptJSONObject.getJSONObject("ext").optString(h);
                            if (!TextUtils.isEmpty(strOptString3)) {
                                pubMaticCreativeInfo.e(strOptString3);
                            }
                            String strOptString4 = jSONObjectOptJSONObject.optString("adm");
                            if (!TextUtils.isEmpty(strOptString4)) {
                                boolean z = false;
                                boolean z2 = false;
                                if (com.safedk.android.analytics.brandsafety.creatives.h.a(strOptString4)) {
                                    c((CreativeInfo) pubMaticCreativeInfo, strOptString4);
                                    z2 = true;
                                }
                                String strF = com.safedk.android.utils.k.f(strOptString4);
                                if (com.safedk.android.utils.k.j(strF)) {
                                    synchronized (l) {
                                        z = true;
                                        try {
                                            com.safedk.android.utils.n.b(b, "generate info - found html content: " + strF);
                                            strReplace = strF.replace("\\\"", "\"");
                                            l.put(strOptString, strReplace.replaceAll("\\s+|\\r|\\\\n", ""));
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                    Logger.d(b, "generate info - added ad id: " + strOptString + " to prefetch content");
                                    pubMaticCreativeInfo.b((List<String>) com.safedk.android.utils.n.f(strReplace));
                                    pubMaticCreativeInfo.a("mraid", RemoteSettings.FORWARD_SLASH_STRING);
                                }
                                if (z && z2) {
                                    Logger.d(b, "found a prefetch that is vast and mraid, ad id is: " + strOptString);
                                }
                            }
                            i4 = i5 + 1;
                        }
                    }
                    i2 = i3 + 1;
                }
            } catch (Throwable th2) {
                th = th2;
                Logger.d(b, "generate info - not a valid JSON string: " + th.getMessage(), th);
                ArrayList arrayList = new ArrayList();
                arrayList.add(pubMaticCreativeInfo);
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(pubMaticCreativeInfo);
            return arrayList2;
        } catch (Throwable th3) {
            th = th3;
            pubMaticCreativeInfo = null;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        Logger.d(b, "should follow get url impl - url is: " + str + ", results: " + (!str.startsWith("data:") && str.contains("?")));
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        return false;
    }

    private String B(String str) {
        int iMin = Math.min(500, str.length());
        synchronized (l) {
            Logger.d(b, "find inner ad content, webview resource prefix value: " + str.substring(0, iMin));
            for (String str2 : l.keySet()) {
                String str3 = l.get(str2);
                if (str3 != null) {
                    Logger.d(b, "find inner ad content, prefetch content prefix is: " + str3.substring(0, Math.min(500, str3.length())));
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
            Logger.d(b, "find inner ad content, did not find any adId for the webview - ad id to prefetch map keys: " + l.keySet());
            return null;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        if (str == null || str.startsWith("data:")) {
            return null;
        }
        Logger.d(b, "get ad id from resource started - webview: " + (weakReference != null ? weakReference.get() : null));
        String strB = B(com.safedk.android.utils.k.f(str).replaceAll("\\s+|\\r|\\\\n", ""));
        if (strB != null && this.H.containsKey(strB)) {
            Logger.d(b, "get ad id from resource - matching found via inner prefetch, adId=" + strB);
            return strB;
        }
        if (strB == null) {
            return null;
        }
        Logger.d(b, "get ad id from resource - ad id - " + strB + " is not in set: " + this.H.keySet());
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    public static Map<String, Object> d(Object obj) {
        Object objA;
        Object objA2 = null;
        HashMap map = new HashMap();
        if (obj == null) {
            map.put("error", "Null vast player object");
        } else {
            try {
                Class<?> cls = obj.getClass();
                try {
                    objA = a(obj, cls, Class.forName("com.pubmatic.sdk.video.vastmodels.POBMediaFile"));
                } catch (ClassNotFoundException e2) {
                    objA = null;
                }
                if (objA != null) {
                    a(objA, "getMediaFileURL", map, "mediaFileURL");
                }
                try {
                    objA2 = a(obj, cls, Class.forName("com.pubmatic.sdk.video.vastmodels.POBVastAd"));
                } catch (ClassNotFoundException e3) {
                }
                if (objA2 != null) {
                    a(objA2, "getImpressions", map, "impressionUrls");
                }
            } catch (Exception e4) {
                map.put("reflectionError", e4.getMessage());
            }
        }
        return map;
    }

    private static void a(Object obj, String str, Map<String, Object> map, String str2) {
        if (obj != null) {
            try {
                Object objInvoke = obj.getClass().getMethod(str, new Class[0]).invoke(obj, new Object[0]);
                map.put(str2, objInvoke);
                Logger.d(b, "extract by getter - added info key: " + str2 + " with value: " + objInvoke);
            } catch (Exception e2) {
            }
        }
    }

    private static Object a(Object obj, Class<?> cls, Class<?> cls2) {
        Object obj2 = null;
        Logger.d(b, "find object by type - object is: " + obj + " with class: " + cls.getName() + " and target: " + cls2.getName());
        if (obj == null) {
            return null;
        }
        try {
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj3 = field.get(obj);
                String name = field.getType().getName();
                String string = obj3 != null ? obj3.toString() : "null";
                if (string.length() > 100) {
                    string = string.substring(0, 97) + APSSharedUtil.TRUNCATE_SEPARATOR;
                }
                Logger.d(b, "Field: " + field.getName() + ", Type: " + name + ", Value: " + string);
                if (cls2.isAssignableFrom(field.getType()) && !cls.getName().contains("POBMediaPlayer")) {
                    Logger.d(b, "found correct field of type: " + field.getType());
                    obj2 = field.get(obj);
                    return obj2;
                }
            }
        } catch (Exception e2) {
        }
        try {
            Class<?> cls3 = obj.getClass();
            Logger.d(b, "Searching MediaPlayer in class: " + cls3.getName());
            Field[] declaredFields = cls3.getDeclaredFields();
            for (Field field2 : declaredFields) {
                field2.setAccessible(true);
                try {
                    Object obj4 = field2.get(obj);
                    Class<?> type = field2.getType();
                    if (obj4 != null && type.getName().equals(cls2.getName())) {
                        Logger.d(b, "Found target in field: " + field2.getName());
                        return obj4;
                    }
                } catch (Exception e3) {
                    Logger.d(b, "Error accessing field: " + field2.getName());
                }
            }
            Logger.d(b, "No fields of MediaPlayer type found, searching for related objects");
            return obj2;
        } catch (Exception e4) {
            Logger.d(b, "Error searching for MediaPlayer: " + e4.getMessage());
            return obj2;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo c(Object obj, Object obj2) {
        String strA = BrandSafetyUtils.a(obj);
        Logger.d(b, "store on ad ready to play - vast player address is: " + strA + " video player: " + obj2);
        synchronized (n) {
            n.put(strA, new WeakReference<>(obj2));
        }
        e(obj2);
        return null;
    }

    public void e(Object obj) {
        if (obj != null) {
            String strA = BrandSafetyUtils.a(obj);
            if (!o.containsKey(strA)) {
                try {
                    Class<?> cls = obj.getClass();
                    Class<?> cls2 = Class.forName("com.pubmatic.sdk.video.player.POBPlayer");
                    Object objA = a(obj, cls, cls2);
                    Logger.d(b, "get media player from video view - video player view is: " + obj + " pob media player is: " + objA);
                    Object objA2 = a(objA, cls2, Class.forName("android.media.MediaPlayer"));
                    Logger.d(b, "get media player from video view - pob media player is: " + objA + " and media player: " + objA2);
                    if (objA2 != null) {
                        o.put(strA, new WeakReference<>(objA2));
                        Logger.d(b, "get media player from video view - adding video player address: " + strA + " with media player: " + objA2);
                    }
                } catch (ClassNotFoundException e2) {
                    Logger.d(b, "error - POBPlayer class not found");
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(com.safedk.android.analytics.brandsafety.c cVar) {
        Object obj;
        List<String> listX = cVar.x();
        Logger.d(b, "is MediaPlayer Playing started: " + listX);
        for (String str : listX) {
            if (o.containsKey(str)) {
                WeakReference<Object> weakReference = o.get(str);
                if (!com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                    synchronized (n) {
                        Iterator<Map.Entry<String, WeakReference<Object>>> it = n.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            Map.Entry<String, WeakReference<Object>> next = it.next();
                            if (com.safedk.android.utils.n.a((Reference<?>) next.getValue())) {
                                if (o.get(BrandSafetyUtils.a(next.getValue().get())) != null) {
                                    obj = next.getValue().get();
                                    break;
                                }
                            }
                        }
                    }
                    Logger.d(b, "is MediaPlayer Playing - founded video player is: " + obj);
                    e(obj);
                }
                if (weakReference != null && (weakReference.get() instanceof MediaPlayer)) {
                    MediaPlayer mediaPlayer = (MediaPlayer) weakReference.get();
                    Logger.d(b, "found a media player: " + mediaPlayer);
                    return com.safedk.android.utils.n.a(mediaPlayer);
                }
            }
        }
        return false;
    }

    private Object C(String str) {
        WeakReference<Object> weakReference;
        Object obj;
        synchronized (n) {
            weakReference = n.get(str);
        }
        if (!com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
            obj = null;
        } else {
            obj = weakReference.get();
        }
        Logger.d(b, "get view from vast object - vast player address is: " + str + " returning: " + obj);
        return obj;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo c(Object obj) {
        String value;
        List list;
        Logger.d(b, "match on vast ad started with vast player: " + obj);
        List list2 = null;
        String str = null;
        for (Map.Entry<String, Object> entry : d(obj).entrySet()) {
            String key = entry.getKey();
            Object value2 = entry.getValue();
            Logger.d(b, "match on vast ad started - found key: " + key + " with value: " + value2);
            if (key.equals("mediaFileURL") && (value2 instanceof String)) {
                list = list2;
                str = (String) value2;
            } else {
                list = (key.equals("impressionUrls") && (value2 instanceof List)) ? (List) value2 : list2;
            }
            list2 = list;
        }
        Logger.d(b, "match on vast ad started - media url: " + str);
        if (str == null) {
            return null;
        }
        synchronized (m) {
            Iterator<Map.Entry<String, String>> it = m.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    value = null;
                    break;
                }
                Map.Entry<String, String> next = it.next();
                String key2 = next.getKey();
                value = next.getValue();
                Logger.d(b, "match on vast ad started - now iterating on key: " + key2 + " and value: " + value);
                if (key2.contains(str) && (this.H.get(value) instanceof PubMaticCreativeInfo)) {
                    String strAr = ((PubMaticCreativeInfo) this.H.get(value)).ar();
                    Logger.d(b, "match on vast ad started - inner impression: " + strAr + " and urls: " + list2);
                    if (list2 != null && list2.contains(strAr)) {
                        break;
                    }
                }
            }
        }
        if (value == null) {
            return null;
        }
        Logger.d(b, "match on vast ad started - found CI with ad id: " + value);
        CreativeInfo creativeInfo = this.H.get(value);
        if (creativeInfo != null) {
            creativeInfo.a(C(BrandSafetyUtils.a(obj)));
        }
        return creativeInfo;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void g(String str, String str2) {
        if (str2 != null) {
            Logger.d(b, "store url on string request - is contained in VIV set: " + this.E.contains(str2));
            p.put(str, str2);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String x(String str) {
        if (str != null) {
            return p.remove(str);
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        String name = view.getClass().getName();
        boolean z = super.e(view) || ((view instanceof FrameLayout) && name.contains("POBBannerView"));
        if (z) {
            Logger.d(b, "is ad view result is true for class name: " + name);
        }
        return z;
    }
}
