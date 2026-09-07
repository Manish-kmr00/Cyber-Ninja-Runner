package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.b9;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.AdMobCreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.utils.Logger;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public class a extends d {
    private static final String R = "pubid";
    private static final String S = "http";
    private static final String T = "intent";
    private static final String U = "market";
    private static final String V = "AdGroup+Creative+ID+0";
    private static final String Y = "AppID";
    private static final String Z = "java.util.LinkedHashMap";
    private static final String aA = "video";
    private static final String aB = "vast_xml";
    private static final String aC = "title:";
    private static final String aD = "mainImg:";
    private static final String aE = "icon:";
    private static final String aF = "body:";
    private static final String aG = "cta:";
    private static final String aH = "star:";
    private static final String aI = "advertiser:";
    private static final String aJ = "tpc.googlesyndication.com/gpa_images/simgad/";
    private static final int aK = 3;
    private static final String aa = "ignore_this_destination";
    private static final String ab = "question";
    private static final String ac = "longform_questions";
    private static final String ad = "com.google.android.gms.ads.admanager.AdManagerAdView";
    private static final String ae = "com.google.android.gms.ads.internal.overlay.g";
    private static final String af = "com.google.android.gms.ads.nativead.NativeAdView";
    private static final String ag = "\\{background-image:url\\(([^)]+?)\\)";
    private static final String ah = "ad_json";
    private static final String ai = "ads";
    private static final String aj = "app_id";
    private static final String ak = "headline";
    private static final String al = "image";
    private static final String am = "images";
    private static final String an = "thumbnails";
    private static final String ao = "secondary_image";
    private static final String ap = "app_icon";
    private static final String aq = "tracking_urls_and_actions";
    private static final String ar = "click_actions";
    private static final String as = "impression_tracking_urls";
    private static final String at = "url";
    private static final String au = "u2_final_url";
    private static final String av = "body";
    private static final String aw = "call_to_action";
    private static final String ax = "rating";
    private static final String ay = "type";
    private static final String az = "advertiser";
    public static final String b = "appIcon:";
    public static final String c = "shortAppName:";
    public static final String d = "headline:";
    public static final String e = "description:";
    public static final String f = "image:";
    public static final String g = "ytId:";
    public static final String h = "/store";
    public static final String i = "/store/type2";
    public static final String j = "/brand";
    public static final String k = "destinationUrl";
    private static final String l = "AdMobDiscovery";
    private static final String m = "com.google.android.gms";
    private static final String n = "org.json.JSONObject";
    private static final String o = "ad_html";
    private static final String p = "clickUrl";
    private static final String q = "creativeId";
    private static final String W = "Backend+Query+ID";
    private static final String X = W.replace(Marker.ANY_NON_NULL_MARKER, "%2B");
    private static final HashSet<String> aL = new HashSet<>(Arrays.asList("titleClk", "bodyClk", "ochBody", "ochTitle", "ochUrl", "urlClk"));
    private static final HashSet<String> aM = new HashSet<>(Arrays.asList("btnClk", "ochButton"));
    private static final HashSet<String> aN = new HashSet<>(Arrays.asList("imageClk", "ochImage", "ochAppIcon"));
    private static final String[] aO = {"var url = 'https://googleads.g.doubleclick.net/dbm/ad?dbm_c=", "<div class=\"GoogleActiveViewInnerContainer\"", "src=\"https://googleads.g.doubleclick.net/xbbe/pixel?d", "googleInitIc(document.body"};

    /* JADX INFO: renamed from: com.safedk.android.analytics.brandsafety.creatives.discoveries.a$a, reason: collision with other inner class name */
    private class C0716a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8066a;
        public String b;
        public boolean c;
        public boolean d = true;

        C0716a(String str, String str2, boolean z) {
            this.f8066a = str;
            this.b = str2;
            this.c = z;
        }

        public String toString() {
            return "resource: " + this.b + ", element prefix: " + this.f8066a + ", should report as element= " + this.d;
        }
    }

    public a() {
        super(com.safedk.android.utils.h.h, l);
        this.C.b(AdNetworkConfiguration.SHOULD_SCAN_OBJECT_USING_REFLECTION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.APP_OPEN_IMPRESSION_TRACKING_ENABLED, true);
        this.C.b(AdNetworkConfiguration.SHOULD_SCAN_INTERSTITIAL_VIEW_HIERARCHY_FOR_CI, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SHOULD_INJECT_JS_TO_WEBVIEWS_FOR_TEXT_EXTRACTION, false);
        this.C.b(AdNetworkConfiguration.WEBVIEW_REPLACE_ON_AD_DISPLAY_FAIL, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.PRINT_WEB_VIEW_CONTENTS_ON_HTML_LOAD, false);
    }

    private long a(View view, List<Object> list, List<String> list2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a(view, new ArrayList(), list, new HashSet(), list2);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        com.safedk.android.utils.n.b(l, "generate info, travel time " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        return jCurrentTimeMillis2;
    }

    private int a(List<Object> list) {
        Iterator<Object> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Iterator<String> itKeys = ((JSONObject) it.next()).keys();
            while (itKeys.hasNext()) {
                if (itKeys.next().equals("clickUrl")) {
                    i2++;
                }
            }
        }
        Logger.d(l, "generate info - clickUrlsCounter=" + i2);
        return i2;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public View g(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                Logger.d(l, "handle native ad reflection - found admob native view: " + childAt);
                return childAt;
            }
        }
        return null;
    }

    private void a(List<List<C0716a>> list, List<List<String>> list2, List<String> list3, List<String> list4, List<com.safedk.android.analytics.brandsafety.creatives.h.a> list5, List<List<String>> list6, String str) {
        ArrayList arrayList;
        com.safedk.android.analytics.brandsafety.creatives.h.a aVarA;
        try {
            Logger.d(l, "handle ad json object - started");
            JSONArray jSONArray = new JSONObject(str).getJSONArray("ads");
            list3.clear();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                ArrayList arrayList2 = new ArrayList();
                list.add(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                list2.add(arrayList3);
                String strOptString = jSONObject.optString("app_id");
                if (!TextUtils.isEmpty(strOptString)) {
                    list4.add(strOptString);
                }
                String strOptString2 = jSONObject.optString(ak);
                if (!TextUtils.isEmpty(strOptString2)) {
                    arrayList2.add(new C0716a("title:", strOptString2, true));
                }
                Logger.d(l, "handle ad json object - title: " + strOptString2);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("image");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString3 = jSONObjectOptJSONObject.optString("url");
                    if (!TextUtils.isEmpty(strOptString3)) {
                        arrayList2.add(new C0716a("mainImg:", strOptString3, false));
                    }
                    Logger.d(l, "handle ad json object - mainImg: " + strOptString3);
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(am);
                if (jSONArrayOptJSONArray != null) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        String strOptString4 = jSONArrayOptJSONArray.getJSONObject(i3).optString("url");
                        if (!TextUtils.isEmpty(strOptString4)) {
                            C0716a c0716a = new C0716a("mainImg:", strOptString4, false);
                            c0716a.d = false;
                            arrayList2.add(c0716a);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(an);
                if (jSONArrayOptJSONArray2 != null) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                        String strOptString5 = jSONArrayOptJSONArray2.getJSONObject(i4).optString("url");
                        if (!TextUtils.isEmpty(strOptString5)) {
                            C0716a c0716a2 = new C0716a("mainImg:", strOptString5, false);
                            c0716a2.d = false;
                            arrayList2.add(c0716a2);
                        }
                    }
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(ao);
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = jSONObject.optJSONObject(ap);
                }
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString6 = jSONObjectOptJSONObject2.optString("url");
                    if (!TextUtils.isEmpty(strOptString6)) {
                        arrayList2.add(new C0716a("icon:", strOptString6, false));
                    }
                    Logger.d(l, "handle ad json object - icon: " + strOptString6);
                }
                JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(aq);
                if (jSONObjectOptJSONObject3 != null) {
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject3.optJSONArray(ar);
                    if (jSONArrayOptJSONArray3 != null) {
                        for (int i5 = 0; i5 < jSONArrayOptJSONArray3.length(); i5++) {
                            JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i5);
                            if (jSONObject2 != null) {
                                String strOptString7 = jSONObject2.optString(au);
                                if (TextUtils.isEmpty(strOptString7)) {
                                    strOptString7 = jSONObject2.optString("url");
                                }
                                if (jSONObject2.optInt("type") == 1) {
                                    list3.add(0, strOptString7);
                                } else {
                                    list3.add(strOptString7);
                                }
                            }
                        }
                        Logger.d(l, "handle ad json object - clickUrlList: " + list3);
                    }
                    JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject3.optJSONArray("impression_tracking_urls");
                    if (jSONArrayOptJSONArray4 != null) {
                        for (int i6 = 0; i6 < jSONArrayOptJSONArray4.length(); i6++) {
                            arrayList3.add(jSONArrayOptJSONArray4.getString(i6));
                        }
                    }
                }
                String strOptString8 = jSONObject.optString("body");
                if (!TextUtils.isEmpty(strOptString8)) {
                    arrayList2.add(new C0716a("body:", strOptString8, true));
                }
                Logger.d(l, "handle ad json object - body: " + strOptString8);
                String strOptString9 = jSONObject.optString(aw);
                if (!TextUtils.isEmpty(strOptString9)) {
                    arrayList2.add(new C0716a("cta:", strOptString9, true));
                }
                Logger.d(l, "handle ad json object - cta: " + strOptString9);
                String strOptString10 = jSONObject.optString("rating");
                if (!TextUtils.isEmpty(strOptString10)) {
                    arrayList2.add(new C0716a("star:", strOptString10, true));
                }
                Logger.d(l, "handle ad json object - star: " + strOptString10);
                String strOptString11 = jSONObject.optString("advertiser");
                if (!TextUtils.isEmpty(strOptString11)) {
                    arrayList2.add(new C0716a("advertiser:", strOptString11, true));
                }
                Logger.d(l, "handle ad json object - advertiser: " + strOptString11);
                JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("video");
                if (jSONObjectOptJSONObject4 != null) {
                    String strOptString12 = jSONObjectOptJSONObject4.optString(aB);
                    if (!TextUtils.isEmpty(strOptString12) && (aVarA = a(strOptString12, (List<String>) (arrayList = new ArrayList()))) != null) {
                        list5.add(aVarA);
                        list6.add(arrayList);
                    }
                }
            }
            Logger.d(l, "handle ad json object - appPackageNameList: " + list4);
            Logger.d(l, "handle ad json object - clickUrlList: " + list3);
            Logger.d(l, "handle ad json object - nativeAdElementsLists: " + list);
            Logger.d(l, "handle ad json object - nativeBannerDspResourcesLists: " + list2);
            Logger.d(l, "handle ad json object - vastAdInfoList: " + list5);
            Logger.d(l, "handle ad json object - vastAdUrisList: " + list6);
        } catch (Exception e2) {
            Logger.d(l, "handle ad json object - encountered exception: " + e2);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> a(WeakReference<View> weakReference, String str, BrandSafetyUtils.AdType adType) {
        List<String> list;
        String str2;
        String str3;
        String str4;
        List<String> list2;
        boolean z;
        String str5;
        String str6;
        String str7;
        String str8;
        int iMax;
        String strI;
        List<String> listO;
        List<String> list3;
        List<String> list4;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Logger.d(l, "generate info started, view: " + weakReference.get() + " with ad type: " + adType + ", maxCreativeId = " + str);
            Logger.d(l, "generate info View check. adInstance is a View, visibility = " + weakReference.get().getVisibility() + ", dimensions (height= " + weakReference.get().getMeasuredHeight() + ", width=" + weakReference.get().getMeasuredWidth() + ")");
            long jCurrentTimeMillis = System.currentTimeMillis();
            List<String> arrayList2 = new ArrayList<>();
            List<Object> arrayList3 = new ArrayList<>();
            long jA = a(weakReference.get(), arrayList3, arrayList2);
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            List<String> arrayList6 = new ArrayList<>();
            List<String> arrayList7 = new ArrayList<>();
            ArrayList arrayList8 = new ArrayList();
            ArrayList arrayList9 = new ArrayList();
            ArrayList arrayList10 = new ArrayList();
            ArrayList arrayList11 = new ArrayList();
            ArrayList arrayList12 = new ArrayList();
            String strSubstring = null;
            List<String> arrayList13 = new ArrayList<>();
            String str9 = null;
            List<String> arrayList14 = new ArrayList<>();
            List<String> arrayList15 = new ArrayList<>();
            List<List<String>> arrayList16 = new ArrayList<>();
            List<com.safedk.android.analytics.brandsafety.creatives.h.a> arrayList17 = new ArrayList<>();
            ArrayList arrayList18 = new ArrayList();
            String str10 = null;
            List<List<C0716a>> arrayList19 = new ArrayList<>();
            List<List<String>> arrayList20 = new ArrayList<>();
            StringBuilder sb = new StringBuilder("b|");
            sb.append(jCurrentTimeMillis).append(com.safedk.android.analytics.brandsafety.l.ad);
            sb.append(jA).append(com.safedk.android.analytics.brandsafety.l.ad);
            sb.append(arrayList2.size()).append(com.safedk.android.analytics.brandsafety.l.ad);
            sb.append(arrayList3.size()).append(com.safedk.android.analytics.brandsafety.l.ad);
            HashSet hashSet = new HashSet();
            sb.append(com.safedk.android.analytics.brandsafety.l.ad).append("CLC=").append(a(arrayList3)).append(com.safedk.android.analytics.brandsafety.l.ad);
            Iterator<Object> it = arrayList3.iterator();
            boolean z2 = false;
            String str11 = null;
            int i2 = 0;
            String str12 = null;
            boolean z3 = false;
            String str13 = null;
            List<String> listE = null;
            List<String> list5 = arrayList6;
            List<String> list6 = arrayList5;
            List<String> listC = arrayList4;
            boolean z4 = true;
            int i3 = -1;
            while (it.hasNext()) {
                JSONObject jSONObject = (JSONObject) it.next();
                Iterator<String> itKeys = jSONObject.keys();
                boolean z5 = z2;
                String str14 = str11;
                int i4 = i2;
                String str15 = str12;
                boolean z6 = z3;
                String str16 = str10;
                String str17 = str13;
                String str18 = str9;
                List<String> arrayList21 = list5;
                List<String> listB = list6;
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = jSONObject.getString(next);
                    int iMax2 = Math.max(i3, P(string));
                    z6 |= iMax2 > 1;
                    com.safedk.android.utils.n.b(l, "generate info, found ad part - key: " + next + ", is multi ad? " + z6 + ", ad count: " + iMax2 + ", value: " + string);
                    sb.append(com.safedk.android.analytics.brandsafety.l.ad);
                    sb.append(next);
                    sb.append("->");
                    if (listC == null || listC.isEmpty()) {
                        listC = C(string);
                        Logger.d(l, "generate info, click strings: " + listC);
                    }
                    boolean z7 = !hashSet.contains(next);
                    hashSet.add(next);
                    if (next.equals(ah)) {
                        a(arrayList19, arrayList20, arrayList21, arrayList13, arrayList17, arrayList16, string);
                        if (arrayList17.isEmpty()) {
                            str2 = str18;
                        } else {
                            str2 = str18 == null ? "vast" : str18 + "vast";
                        }
                        z5 = true;
                        str3 = str15;
                        str4 = str16;
                        list2 = arrayList21;
                    } else if (next.equals("ad_html")) {
                        Logger.d(l, "generate info, processing ad html");
                        z4 = false;
                        ArrayList<String> arrayList22 = new ArrayList();
                        a(string, arrayList22, arrayList18);
                        Logger.d(l, "generate info, vastAdBlocks contains " + arrayList22.size() + " items");
                        if (!arrayList22.isEmpty()) {
                            iMax = Math.max(iMax2, arrayList22.size());
                            Logger.d(l, "generate info, processing vast blocks ad count: " + iMax);
                            sb.append("vast");
                            sb.append(b9.i.c);
                            String strReplace = string;
                            for (String str19 : arrayList22) {
                                strReplace = strReplace.replace(str19, "");
                                List<String> arrayList23 = new ArrayList<>();
                                com.safedk.android.analytics.brandsafety.creatives.h.a aVarA = a(str19, arrayList23);
                                if (aVarA != null) {
                                    Logger.d(l, "generate info, vast info found, ad id: " + aVarA.c());
                                    arrayList17.add(aVarA);
                                    arrayList16.add(arrayList23);
                                    if (!z7) {
                                        sb.append("sk&");
                                        if (aVarA != null) {
                                            sb.append("vast");
                                            sb.append(b9.i.c);
                                            sb.append("c=" + aVarA.a());
                                            sb.append("&i=" + aVarA.c());
                                        }
                                    }
                                }
                            }
                            str5 = strReplace;
                            str6 = str15;
                            str7 = str16;
                            str8 = "vast";
                        } else {
                            String strF = com.safedk.android.utils.k.f(string);
                            String strM = M(strF);
                            String strI2 = i(i(strF, "app-open-publisher-tab-holder"), "advertisement-top");
                            String strA = a(string, arrayList14, a(strI2, arrayList14, str16, sb, adType), sb);
                            String strE = E(strI2);
                            if (strE != null) {
                                arrayList21 = new ArrayList<>();
                                arrayList21.add(strE);
                                sb.append("dd_c&");
                            } else {
                                String strR = R(strI2);
                                if (strR != null) {
                                    Logger.d(l, "generate info - found click url inside html, url: " + strR);
                                    Iterator<String> it2 = arrayList21.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            z = true;
                                            break;
                                        }
                                        String next2 = it2.next();
                                        if (next2 != null && !next2.contains(aa)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        arrayList21 = new ArrayList<>();
                                        arrayList21.add(strR);
                                        sb.append("dd_c&");
                                    }
                                } else {
                                    Logger.d(l, "generate info - did not find click url");
                                }
                            }
                            arrayList13.add(F(strI2));
                            String strK = K(string);
                            if (!TextUtils.isEmpty(strK)) {
                                arrayList2.add("element:ytId:" + strK);
                            }
                            str5 = string;
                            str6 = strM;
                            str7 = strA;
                            str8 = str18;
                            iMax = iMax2;
                        }
                        if (com.safedk.android.utils.g.ae().matcher(string).find()) {
                            str7 = "playable";
                            sb.append("playable");
                            sb.append(b9.i.c);
                        }
                        String str20 = str7;
                        Logger.d(l, "generate info - is multi? " + z6);
                        if (z6) {
                            String strA2 = a(iMax, string, arrayList8, arrayList9, arrayList10, arrayList11, arrayList12);
                            if (str8 == null) {
                                str8 = "";
                            }
                            str8 = str8 + strA2 + CreativeInfo.aI + iMax;
                            sb.append(str8);
                            sb.append(b9.i.c);
                        }
                        String str21 = str8;
                        listE = com.safedk.android.utils.n.e(str5);
                        if (str6 != null && listE.contains(str6)) {
                            listE.remove(str6);
                            com.safedk.android.utils.n.b(l, "generate info, removed app icon url: " + str6);
                        }
                        if (L(string)) {
                            Logger.d(l, "generate info, all mraid string found, marking this ad as mraid");
                            sb.append("mraidStringFound&");
                        }
                        for (int i5 = 0; i5 < listE.size(); i5++) {
                            String strF2 = com.safedk.android.utils.k.f(listE.get(i5));
                            listE.set(i5, strF2);
                            Logger.d(l, "htmlUrls url = " + strF2);
                        }
                        com.safedk.android.utils.n.b(l, "generate info, html: " + string);
                        if (com.safedk.android.utils.k.j(string)) {
                            Logger.d(l, "generate info, content is Html content");
                            String strM2 = M(string);
                            strI = i(i(string, "app-open-publisher-tab-holder"), "advertisement-top");
                            ArrayList<String> arrayListE = com.safedk.android.utils.n.e(strI);
                            com.safedk.android.utils.n.b(l, "generate info, urls extracted from source: " + arrayListE);
                            if (strM2 != null && arrayListE.contains(strM2)) {
                                arrayListE.remove(strM2);
                                com.safedk.android.utils.n.b(l, "generate info, removed app icon url: " + strM2);
                            }
                            if (arrayListE != null && arrayListE.size() > 0) {
                                ArrayList arrayList24 = new ArrayList();
                                Iterator<String> it3 = arrayListE.iterator();
                                while (it3.hasNext()) {
                                    String strReplaceAll = com.safedk.android.utils.k.f(it3.next()).replaceAll("&quot;", b9.i.c);
                                    if (strReplaceAll != null && com.safedk.android.utils.n.a((Object) strReplaceAll)) {
                                        arrayList24.add(strReplaceAll);
                                    } else {
                                        Logger.d(l, "generate info, sanitizedUrl is not a url: " + strReplaceAll);
                                    }
                                }
                                com.safedk.android.utils.n.b(l, "generate info, Html content sanitized urls: " + arrayList24);
                                listE.addAll(arrayList24);
                            }
                            b(strI, arrayList15);
                            if (com.safedk.android.utils.n.a((Collection<?>) arrayList21) && strI.contains(k)) {
                                listO = O(strI);
                                sb.append("dc2&");
                                sb.append(listO).append(b9.i.c);
                                Logger.d(l, "generate info, click urls (Destination Url): " + listO);
                            } else {
                                listO = arrayList21;
                            }
                            str3 = strM2;
                            arrayList21 = listO;
                        } else {
                            str3 = str6;
                            strI = str17;
                        }
                        str4 = str20;
                        str17 = strI;
                        str2 = str21;
                        list2 = arrayList21;
                        iMax2 = iMax;
                    } else if (next.equals("pubid")) {
                        if (!z7) {
                            sb.append("sk&");
                            sb.append(string.substring(0, string.lastIndexOf(47)));
                            i3 = iMax2;
                        } else {
                            strSubstring = string.substring(0, string.lastIndexOf(47));
                            Logger.d(l, "generate info, placement ID: " + strSubstring);
                            z4 = false;
                            sb.append(strSubstring);
                            sb.append(b9.i.c);
                            str3 = str15;
                            str4 = str16;
                            str2 = str18;
                            list2 = arrayList21;
                        }
                    } else if (next.equals("clickUrl")) {
                        i4++;
                        if (i4 == 1) {
                            Logger.d(l, "generate info, first click url: " + string);
                            str14 = string;
                        } else if (str14 != null) {
                            Logger.d(l, "generate info, new click url: " + string);
                            if (str14.equals(string)) {
                                Logger.d(l, "generate info, the click url with index: " + i4 + " has the same value as the first, so skipping!");
                                i3 = iMax2;
                            } else {
                                sb.append("||different_clickUrl_found||");
                                Logger.d(l, "generate info, click url index: " + i4 + " is NOT equal to the first one which is: " + str14);
                            }
                        }
                        Map<String, String> mapB = com.safedk.android.utils.k.b(string, false);
                        if (mapB.containsKey(W) || mapB.containsKey(X)) {
                            String str22 = mapB.containsKey(W) ? mapB.get(W) : mapB.get(X);
                            if (str != null && !str.equals(str22)) {
                                Logger.d(l, "generate info, for click index: " + i4 + " max creative id is: " + str + " vs backend query id: " + str22);
                            }
                        }
                        sb.append(string).append(b9.i.c);
                        if (!z7) {
                            Logger.d("generate info, should process key is false, skipping click url for now");
                            sb.append("sk&");
                            sb.append("c=").append(N(string));
                            sb.append("&i=").append(a(string, false));
                            i3 = iMax2;
                        } else {
                            Logger.d(l, "generate info, click url value: " + string + ", clickUrlList = " + arrayList21);
                            if (com.safedk.android.utils.n.a((Collection<?>) arrayList21)) {
                                List<String> listN = N(string);
                                sb.append("dc2&");
                                sb.append(listN).append(b9.i.c);
                                Logger.d(l, "generate info, click urls: " + listN);
                                list3 = listN;
                            } else {
                                list3 = arrayList21;
                            }
                            if (listB == null || listB.isEmpty()) {
                                List<String> listA = a(string, false);
                                Logger.d(l, "generate info, creative ID: " + listA);
                                list4 = listA;
                            } else {
                                list4 = listB;
                            }
                            z4 = false;
                            str3 = str15;
                            str4 = str16;
                            str2 = str18;
                            list2 = list3;
                            listB = list4;
                        }
                    } else if (!next.equals("creativeId")) {
                        str3 = str15;
                        str4 = str16;
                        str2 = str18;
                        list2 = arrayList21;
                    } else if (!z7) {
                        Logger.d("generate info, should process key is false, skipping creative for now");
                        sb.append("sk&");
                        sb.append("&i=").append(B(string));
                        i3 = iMax2;
                    } else {
                        if (listB == null || listB.isEmpty()) {
                            listB = B(string);
                            Logger.d(l, "generate info, creatives: " + listB);
                        }
                        z4 = false;
                        str3 = str15;
                        str4 = str16;
                        str2 = str18;
                        list2 = arrayList21;
                    }
                    if (z6 && str2 != null && !str2.contains(CreativeInfo.aK)) {
                        str2 = str2 + CreativeInfo.aK;
                        sb.append("&multiple_ads");
                    }
                    str15 = str3;
                    str16 = str4;
                    str18 = str2;
                    arrayList21 = list2;
                    i3 = iMax2;
                }
                z2 = z5;
                str11 = str14;
                i2 = i4;
                str12 = str15;
                z3 = z6;
                str10 = str16;
                str13 = str17;
                str9 = str18;
                list5 = arrayList21;
                list6 = listB;
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Logger.d(l, "generate info, json build time: " + (jCurrentTimeMillis2 - jA));
            if (z4) {
                Logger.d(l, "generate info, prefetch is NULL");
                return null;
            }
            if (!arrayList17.isEmpty()) {
                a(arrayList17, list5, arrayList7, sb);
            }
            for (int i6 = 0; i6 < list5.size(); i6++) {
                if (list5.get(i6) != null && list5.get(i6).contains(aa)) {
                    list5.set(i6, null);
                }
            }
            if (str9 == null) {
                str9 = str10;
            } else if (str10 != null) {
                str9 = str9 + RemoteSettings.FORWARD_SLASH_STRING + str10;
            }
            Logger.d(l, "generate info, downstream struct: " + str9 + ", adCount = " + i3);
            Logger.d(l, "generate info, click url list size is: " + list5.size());
            if (i3 > 0 && list5.size() != i3) {
                Logger.d(l, "generate info, mismatched between click url list size and ad count");
            }
            Logger.d(l, "generate info, app package name is: " + arrayList13 + " placement id is: " + strSubstring + " first creative id is: " + (list6.size() > 0 ? list6.get(0) : "null"));
            int i7 = 0;
            while (i7 < i3) {
                CreativeInfo adMobCreativeInfo = new AdMobCreativeInfo(null, adType, list6.size() > i7 ? list6.get(i7) : null, list5.size() > i7 ? list5.get(i7) : null, strSubstring, arrayList7.size() > i7 ? arrayList7.get(i7) : null, this.G, str9, arrayList13.size() > i7 ? arrayList13.get(i7) : null);
                Logger.d(l, "generate info - set click url of CI to - " + adMobCreativeInfo.O());
                if (str12 != null) {
                    adMobCreativeInfo.F(str12);
                    Logger.d(l, "generate info, application icon url added to ci WebView urls exclusion list : " + str12);
                }
                com.safedk.android.utils.n.b(l, "created ci : " + adMobCreativeInfo);
                sb.append(com.safedk.android.analytics.brandsafety.l.ad);
                sb.append(jCurrentTimeMillis2).append(com.safedk.android.analytics.brandsafety.l.ad);
                sb.append(arrayList2.size()).append(com.safedk.android.analytics.brandsafety.l.ad);
                sb.append(listE == null ? "e" : Integer.valueOf(listE.size())).append(com.safedk.android.analytics.brandsafety.l.ad);
                if (i7 < arrayList17.size()) {
                    com.safedk.android.analytics.brandsafety.creatives.h.a aVar = arrayList17.get(i7);
                    if (aVar != null) {
                        sb.append(aVar.j() == null ? "v" : Integer.valueOf(aVar.j().size()));
                    }
                    adMobCreativeInfo.b(arrayList2);
                    if (!z3) {
                        adMobCreativeInfo.b(listE);
                    }
                    a(adMobCreativeInfo, aVar, (String) null, "manual");
                } else {
                    com.safedk.android.utils.n.b(l, "generate info, adCount is 1");
                    if (i3 == 1) {
                        adMobCreativeInfo.b(arrayList2);
                        adMobCreativeInfo.b(listE);
                    } else {
                        Logger.d(l, "ad count is > 1 , not adding prefetch urls");
                    }
                }
                com.safedk.android.utils.n.b(l, "generate info, creative info urls = " + adMobCreativeInfo.r());
                if (i7 < arrayList16.size() && (list = arrayList16.get(i7)) != null) {
                    Iterator<String> it4 = list.iterator();
                    while (it4.hasNext()) {
                        adMobCreativeInfo.B(it4.next());
                    }
                }
                Logger.d(l, "generate info, downstreamSubtype: " + str10 + ", inter text collection: " + arrayList14);
                if (str10 != null && !str10.equals("vast") && arrayList14.size() > 3) {
                    for (String str23 : arrayList14) {
                        Logger.d(l, "generate info, inter ad text: " + str23);
                        adMobCreativeInfo.y(str23);
                    }
                }
                if ((adType.equals(BrandSafetyUtils.AdType.BANNER) || adType.equals(BrandSafetyUtils.AdType.MREC)) && arrayList15.size() > 0) {
                    for (String str24 : arrayList15) {
                        Logger.d(l, "generate info, banner/mrec ad text: " + str24);
                        adMobCreativeInfo.y(str24);
                    }
                }
                if (z3) {
                    adMobCreativeInfo.am();
                    if (i7 < arrayList8.size() && arrayList8.get(i7) != null) {
                        adMobCreativeInfo.z(b + ((String) arrayList8.get(i7)));
                    }
                    if (i7 < arrayList9.size() && arrayList9.get(i7) != null) {
                        adMobCreativeInfo.z(c + ((String) arrayList9.get(i7)));
                    }
                    if (i7 < arrayList10.size() && arrayList10.get(i7) != null) {
                        adMobCreativeInfo.z(d + ((String) arrayList10.get(i7)));
                    }
                    if (i7 < arrayList11.size() && arrayList11.get(i7) != null) {
                        adMobCreativeInfo.z(e + ((String) arrayList11.get(i7)));
                    }
                    if (i7 < arrayList12.size() && arrayList12.get(i7) != null) {
                        adMobCreativeInfo.z(f + ((String) arrayList12.get(i7)));
                    }
                }
                if (i7 < arrayList18.size() && arrayList18.get(i7) != null) {
                    adMobCreativeInfo.z(g + ((String) arrayList18.get(i7)));
                }
                if (i7 < arrayList19.size()) {
                    for (C0716a c0716a : arrayList19.get(i7)) {
                        Logger.d(l, "generate info - add prefetch element= " + c0716a);
                        if (adType == BrandSafetyUtils.AdType.NATIVE) {
                            if (!c0716a.d) {
                                adMobCreativeInfo.x(c0716a.b);
                            } else {
                                adMobCreativeInfo.z(c0716a.f8066a + c0716a.b);
                            }
                        } else if (c0716a.c) {
                            adMobCreativeInfo.y(c0716a.b);
                        } else {
                            adMobCreativeInfo.x(c0716a.b);
                        }
                    }
                }
                if (i7 < arrayList20.size()) {
                    Iterator<String> it5 = arrayList20.get(i7).iterator();
                    while (it5.hasNext()) {
                        adMobCreativeInfo.v(it5.next());
                    }
                }
                if (z2 && i7 < arrayList13.size()) {
                    adMobCreativeInfo.q(arrayList13.get(i7));
                }
                adMobCreativeInfo.t(sb.toString());
                if (i7 < listC.size()) {
                    adMobCreativeInfo = b(listC.get(i7), adMobCreativeInfo);
                } else {
                    Logger.d(l, "generate info, click string is empty, cannot check if scar CI exists");
                }
                e(adMobCreativeInfo);
                if (adType == BrandSafetyUtils.AdType.INTERSTITIAL && !z3) {
                    c(str13, adMobCreativeInfo);
                }
                Logger.d(l, "generate info, generated info is: " + adMobCreativeInfo);
                arrayList.add(adMobCreativeInfo);
                i7++;
            }
            return arrayList;
        } catch (Throwable th) {
            Logger.e(l, "Exception in generate info: " + th.getMessage(), th);
        }
    }

    private static void e(CreativeInfo creativeInfo) {
        int i2 = 0;
        Iterator<String> it = creativeInfo.r().iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                String next = it.next();
                if (com.safedk.android.utils.n.d(com.safedk.android.utils.g.aU(), next) || next.contains(aJ)) {
                    i2 = i3 + 1;
                    if (i2 >= 3) {
                        Logger.d(l, "generate info, shopping collage creative detected");
                        creativeInfo.E();
                        return;
                    }
                } else {
                    i2 = i3;
                }
            } else {
                return;
            }
        }
    }

    public static void a(String str, List<String> list, List<String> list2) {
        Matcher matcher = com.safedk.android.utils.g.aa().matcher(str);
        boolean z = false;
        while (matcher.find()) {
            a(matcher.group(1), list, list2, Integer.parseInt(matcher.group(2)));
            z = true;
        }
        if (!z) {
            a(str, list, list2, 0);
        }
    }

    private static void a(String str, List<String> list, List<String> list2, int i2) {
        String strE = com.safedk.android.utils.n.e(com.safedk.android.utils.g.c(), str);
        if (strE != null) {
            com.safedk.android.utils.n.b(l, "extractVastBlock adding vastBlock : " + strE);
            list.add(i2, strE);
        }
        String strE2 = com.safedk.android.utils.n.e(com.safedk.android.utils.g.Z(), str);
        if (strE2 == null) {
            strE2 = com.safedk.android.utils.n.e(com.safedk.android.utils.g.Y(), str);
        }
        if (strE2 != null) {
            com.safedk.android.utils.n.b(l, "extractVastBlock adding youtubeVideoId : " + strE2);
            list2.add(i2, strE2);
        }
    }

    public static String a(int i2, String str, List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
        String strA;
        String str2;
        int i3 = 0;
        List<Integer> listB = com.safedk.android.utils.n.b(com.safedk.android.utils.g.X(), str);
        if (!listB.isEmpty()) {
            str2 = h;
            strA = com.safedk.android.utils.k.a(str.substring(listB.get(0).intValue()), 0);
        } else {
            strA = str;
            str2 = i;
        }
        Logger.d(l, "end card div is null? " + (strA == null));
        if (strA != null) {
            List<Integer> listB2 = com.safedk.android.utils.n.b(com.safedk.android.utils.g.W(), strA);
            Logger.d(l, "poddingCardDivOffsetList: " + listB2);
            if (listB2.size() >= i2) {
                while (i3 < i2) {
                    String strA2 = com.safedk.android.utils.k.a(strA, listB2.get(i3).intValue());
                    list2.add(com.safedk.android.utils.n.a(com.safedk.android.utils.g.U(), strA2, 1));
                    list3.add(com.safedk.android.utils.n.a(com.safedk.android.utils.g.T(), strA2, 1));
                    list4.add(com.safedk.android.utils.n.a(com.safedk.android.utils.g.S(), strA2, 1));
                    list.add(com.safedk.android.utils.n.a(Pattern.compile(com.safedk.android.utils.n.a(com.safedk.android.utils.g.V(), strA2, 1) + ag), str, 1));
                    list5.add(com.safedk.android.utils.n.a(Pattern.compile(com.safedk.android.utils.n.a(com.safedk.android.utils.g.R(), strA2, 1) + ag), str, 1));
                    i3++;
                }
                return str2;
            }
        }
        List<String> listB3 = com.safedk.android.utils.n.b(com.safedk.android.utils.g.R(), str, 1);
        Logger.d(l, "imageUrlClassList: " + listB3);
        if (listB3.size() < i2) {
            return "";
        }
        while (i3 < i2) {
            list5.add(com.safedk.android.utils.n.a(Pattern.compile(listB3.get(i3) + ag), str, 1));
            i3++;
        }
        Logger.d(l, "extract Multi Ad Additional Elements - found brand downstream struct");
        return j;
    }

    private void a(List<com.safedk.android.analytics.brandsafety.creatives.h.a> list, List<String> list2, List<String> list3, StringBuilder sb) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                com.safedk.android.analytics.brandsafety.creatives.h.a aVar = list.get(i3);
                list3.add(i3, aVar.b());
                if (aVar.b() != null) {
                    sb.append("dv&");
                }
                if (aVar.a() != null) {
                    if (i3 >= list2.size()) {
                        list2.add(i3, aVar.a());
                    } else {
                        list2.set(i3, aVar.a());
                    }
                    sb.append("dc&");
                }
                sb.append("&c=" + aVar.a() + b9.i.c);
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private String K(String str) {
        String strGroup;
        Matcher matcher = com.safedk.android.utils.g.ab().matcher(str);
        if (!matcher.find() || (strGroup = matcher.group(2)) == null || strGroup.length() > 20) {
            return null;
        }
        return strGroup;
    }

    private String a(String str, List<String> list, String str2, StringBuilder sb, BrandSafetyUtils.AdType adType) {
        String strReplaceAll = str.replaceAll("<script\\b[^>]*>[\\s\\S]*?<\\/script\\b[^>]*>", "");
        com.safedk.android.utils.n.b(l, "generate info, sanitized html is: " + strReplaceAll);
        Matcher matcher = com.safedk.android.utils.g.ag().matcher(strReplaceAll);
        while (matcher.find()) {
            if (matcher.groupCount() > 1) {
                String strReplaceAll2 = matcher.group(2).replace("<br>", " ").replaceAll("<[^>]*>", "");
                if (!TextUtils.isEmpty(strReplaceAll2)) {
                    Logger.d(l, "generate info, found ad text: " + strReplaceAll2 + ", decoded: " + com.safedk.android.utils.k.f(strReplaceAll2));
                    list.add(com.safedk.android.utils.k.f(strReplaceAll2));
                }
            }
            if (adType != BrandSafetyUtils.AdType.INTERSTITIAL) {
                if (com.safedk.android.utils.n.d(com.safedk.android.utils.g.ad(), str)) {
                    str2 = "image";
                    sb.append("image");
                    sb.append(b9.i.c);
                } else {
                    str2 = "text";
                    sb.append("text");
                    sb.append(b9.i.c);
                }
            }
        }
        return str2;
    }

    private String a(String str, List<String> list, String str2, StringBuilder sb) {
        Matcher matcher = com.safedk.android.utils.g.af().matcher(str);
        if (matcher.find()) {
            try {
                JSONArray jSONArray = new JSONObject(com.safedk.android.utils.k.f(matcher.group(1))).getJSONArray(ac);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getJSONObject(i2).getString(ab);
                    Logger.d(l, "generate info, found ad survey text: " + string);
                    list.add(string);
                }
                return CreativeInfo.s;
            } catch (Throwable th) {
                Logger.d(l, "generate info, error parsing ad survey text: " + th.getMessage());
                return CreativeInfo.s;
            } finally {
                sb.append(CreativeInfo.s);
                sb.append(b9.i.c);
            }
        }
        return str2;
    }

    private void b(String str, List<String> list) {
        String strReplaceAll;
        Matcher matcher = com.safedk.android.utils.g.ag().matcher(str.replaceAll("<script\\b[^>]*>[\\s\\S]*?<\\/script\\b[^>]*>", ""));
        while (matcher.find()) {
            if (matcher.groupCount() > 1 && (strReplaceAll = matcher.group(2).replace("<br>", " ").replaceAll("<[^>]*>", "")) != null && strReplaceAll.length() > 0) {
                Logger.d(l, "generate info, found ad text: " + strReplaceAll + ", decoded: " + com.safedk.android.utils.k.f(strReplaceAll));
                list.add(com.safedk.android.utils.k.f(strReplaceAll));
            }
        }
    }

    private boolean L(String str) {
        Logger.d(l, "isMraidAd started");
        for (String str2 : aO) {
            if (!str.contains(str2)) {
                return false;
            }
            Logger.d(l, "isMraidAd ad html contains the string " + str2);
        }
        Logger.d(l, "isMraidAd ad is an mraid ad");
        return true;
    }

    private CreativeInfo b(String str, CreativeInfo creativeInfo) {
        if (BrandSafetyUtils.AdType.NATIVE != creativeInfo.M()) {
            Logger.d(l, "handle scar-admob-video/banner ad started, click string: " + str + ", CI: " + creativeInfo);
            com.safedk.android.analytics.brandsafety.a aVarA = SafeDK.getInstance().a(creativeInfo.M());
            if (aVarA.e("com.unity3d.ads")) {
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i("com.unity3d.ads");
                if (adNetworkDiscoveryI != null) {
                    CreativeInfo creativeInfoA = adNetworkDiscoveryI.a((Object) str);
                    if (creativeInfoA != null) {
                        com.safedk.android.utils.n.b(l, "handle scar-admob-video/banner ad, found origin SDK: " + creativeInfoA.S() + ", actual SDK: " + creativeInfo.S());
                        creativeInfoA.a(creativeInfo);
                        return creativeInfoA;
                    }
                    Logger.d(l, "handle scar-admob-video/banner ad - no CI matched, actual SDK: " + creativeInfo.S());
                    return creativeInfo;
                }
                Logger.d(l, "handle scar-admob-video/banner ad - no UnityAdsDiscovery found");
                return creativeInfo;
            }
            if (!aVarA.e(com.safedk.android.utils.h.h)) {
                Logger.d(l, "handle scar-admob-video/banner ad - no ad info found for package name: com.google.ads");
                return creativeInfo;
            }
            return creativeInfo;
        }
        return creativeInfo;
    }

    private String M(String str) {
        List<String> listB = com.safedk.android.utils.n.b(com.safedk.android.utils.g.Q(), str, 3);
        if (listB != null) {
            Iterator<String> it = listB.iterator();
            if (it.hasNext()) {
                String next = it.next();
                Logger.d(l, "findPublisherAppIconUrl match  : " + next);
                return next;
            }
        }
        return null;
    }

    public String i(String str, String str2) {
        MatchResult next;
        if (str.contains(str2)) {
            Iterator<MatchResult> it = com.safedk.android.utils.n.c(Pattern.compile("<div|class=(?:\\\"|')" + str2 + "(?:\\\"|')|</div>"), str).iterator();
            int i2 = 0;
            boolean z = false;
            MatchResult matchResult = null;
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (z) {
                    if (next.group().equals("<div")) {
                        i2++;
                    } else if (next.group().equals("</div>")) {
                        i2--;
                    }
                    if (i2 == 0) {
                        break;
                    }
                }
                if (next.group().contains(str2)) {
                    z = true;
                    i2++;
                } else {
                    next = matchResult;
                }
                matchResult = next;
            }
            if (matchResult != null && next != null) {
                String strSubstring = str.substring((matchResult.start() - "<div".length()) - 1, next.end());
                Logger.d(l, "find app icon url  remove element by className removing this matched string : " + strSubstring);
                return str.replace(strSubstring, "");
            }
            return str;
        }
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        com.safedk.android.utils.n.b(l, "generate info impl - started. url: " + str + ", maxParams: " + aVar + ", buffer: " + str2);
        return null;
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

    public com.safedk.android.analytics.brandsafety.creatives.h.a a(String str, List<String> list) {
        Logger.d(l, "getVastInfoRecursive started");
        com.safedk.android.analytics.brandsafety.creatives.h.a aVarB = com.safedk.android.analytics.brandsafety.creatives.h.b(str, true, com.safedk.android.utils.h.h);
        if (aVarB == null) {
            return null;
        }
        try {
            String strC = aVarB.c();
            String strD = aVarB.d();
            List<String> listI = aVarB.i();
            List<String> listP = aVarB.p();
            List<String> listO = aVarB.o();
            List<String> listQ = aVarB.q();
            List<String> listR = aVarB.r();
            Logger.d(l, "get vast info - saved ad ID: " + strC + ", ad system: " + strD + " and impression urls: " + listI);
            com.safedk.android.utils.n.b(l, "get vast info - " + aVarB);
            while (aVarB != null && aVarB.e() != null) {
                Logger.d(l, "get vast info - fetching vast ad uri: " + aVarB.e());
                list.add(aVarB.e());
                String strJ = J(aVarB.e());
                com.safedk.android.utils.n.b(l, "get vast info -  ad tag uri content=" + strJ);
                if (!TextUtils.isEmpty(strJ)) {
                    aVarB = com.safedk.android.analytics.brandsafety.creatives.h.b(strJ, true, com.safedk.android.utils.h.h);
                    com.safedk.android.utils.n.b(l, "get vast info recursive: " + aVarB);
                } else {
                    Logger.d(l, "get vast info -  ad tag uri content is empty");
                    break;
                }
            }
            if (aVarB != null) {
                if (aVarB.c().equals(strC)) {
                    aVarB.a(strC);
                    Logger.d(l, "get vast info - saved adId from outer vast: " + strC);
                }
                if (aVarB.d().equals(strD)) {
                    aVarB.b(strD);
                    Logger.d(l, "get vast info - saved adSystem from outer vast: " + strD);
                }
                if (listI != null) {
                    aVarB.a(listI);
                    Logger.d(l, "get vast info - saved impressionUrls from outer vast: " + listI);
                }
                if (listP != null) {
                    aVarB.c(listP);
                    Logger.d(l, "get vast info - saved videoTrackingEventUrls from outer vast: " + listP);
                }
                if (listO != null) {
                    aVarB.b(listO);
                    Logger.d(l, "get vast info - saved videoCompletedUrls from outer vast: " + listO);
                }
                if (listQ != null) {
                    aVarB.d(listQ);
                    Logger.d(l, "get vast info - saved clickTrackingUrls from outer vast: " + listQ);
                }
                if (listR != null) {
                    aVarB.e(listR);
                    Logger.d(l, "get vast info - saved companionClickTrackingUrls from outer vast: " + listR);
                    return aVarB;
                }
                return aVarB;
            }
            return aVarB;
        } catch (Throwable th) {
            Logger.d(l, "Exception in get vast info recursive : " + th.getMessage(), th);
            return aVarB;
        }
    }

    private String a(String str, int i2) {
        int iIndexOf = str.indexOf(61);
        if (iIndexOf == -1) {
            return null;
        }
        int iIndexOf2 = str.indexOf(38, iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = str.length();
        }
        String strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
        Logger.d(l, "extract click url index: " + i2 + ", landing page package id: " + strSubstring);
        if (!strSubstring.equals(strSubstring.toLowerCase())) {
            Logger.d(l, "extract click url - found package name which contains upper cases: " + strSubstring);
            return strSubstring;
        }
        return strSubstring;
    }

    private List<String> N(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<String> listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.aj(), str, 1, 2, false);
            Logger.d(l, "extractClickUrls values : " + listA + ", rawValue = " + str);
            for (int i2 = 0; i2 < listA.size(); i2 += 2) {
                int i3 = Integer.parseInt(listA.get(i2));
                String strDecode = URLDecoder.decode(listA.get(i2 + 1), "UTF-8");
                Logger.d(l, "extract click url index: " + i3 + ", landing page: " + strDecode);
                String lowerCase = strDecode.toLowerCase();
                if (lowerCase.startsWith("http") || lowerCase.startsWith("market")) {
                    arrayList.add(i3, strDecode);
                } else if (lowerCase.startsWith("intent")) {
                    arrayList.add(i3, strDecode);
                    Logger.d(l, "extractClickUrls: adding intent link with landing page: " + strDecode);
                    String strA = a(strDecode, i3);
                    if (strA != null) {
                        arrayList.add(i3, com.safedk.android.analytics.brandsafety.i.a(strA));
                    }
                }
            }
        } catch (UnsupportedEncodingException e2) {
            Logger.e(l, e2.getMessage());
        }
        return arrayList;
    }

    private List<String> O(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            com.safedk.android.utils.n.b(l, "extract destination click url started rawValue = " + str);
            List<String> listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.al(), str, 1, false);
            Logger.d(l, "extract destination click url values : " + listA + ", rawValue = " + str);
            Iterator<String> it = listA.iterator();
            while (it.hasNext()) {
                String strA = com.safedk.android.utils.k.a(it.next());
                Logger.d(l, "extract destination click url destination url : " + strA);
                if (strA.startsWith("http") || strA.startsWith("market") || strA.startsWith("intent")) {
                    arrayList.add(strA);
                    Logger.d(l, "extract destination click url : adding destination url : " + strA);
                }
            }
        } catch (Throwable th) {
            Logger.e(l, "Exception in extract destination click url : " + th.getMessage(), th);
        }
        return arrayList;
    }

    public static List<String> a(String str, boolean z) {
        List<String> listA;
        ArrayList arrayList = new ArrayList();
        if (z) {
            listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.ai(), str, 1, 2, false);
        } else {
            listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.ah(), str, 1, 2, false);
        }
        for (int i2 = 0; i2 < listA.size(); i2 += 2) {
            int i3 = Integer.parseInt(listA.get(i2));
            String str2 = listA.get(i2 + 1);
            if (!arrayList.contains(str2)) {
                arrayList.add(i3, str2);
            }
        }
        return arrayList;
    }

    public static List<String> B(String str) {
        return com.safedk.android.utils.n.b(com.safedk.android.utils.g.ak(), str, 1);
    }

    public static List<String> C(String str) {
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        List<String> listA = com.safedk.android.analytics.brandsafety.creatives.e.a(com.safedk.android.utils.g.ac(), str, 1, 2, false);
        while (true) {
            int i3 = i2;
            if (i3 < listA.size()) {
                int i4 = Integer.parseInt(listA.get(i3));
                String str2 = listA.get(i3 + 1);
                if (!arrayList.contains(str2)) {
                    arrayList.add(i4, str2);
                }
                i2 = i3 + 2;
            } else {
                return arrayList;
            }
        }
    }

    private int P(String str) {
        int iMax = -1;
        Matcher matcher = com.safedk.android.utils.g.am().matcher(str);
        while (matcher.find()) {
            iMax = Math.max(Integer.parseInt(matcher.group(1)), iMax);
        }
        return iMax >= 0 ? iMax + 1 : B(str).size();
    }

    private void a(Object obj, List<String> list, List<Object> list2, Set<Object> set, final List<String> list3) {
        if (obj != null && !set.contains(obj)) {
            set.add(obj);
            Class<?> superclass = obj.getClass();
            ArrayList<Field> arrayList = new ArrayList();
            do {
                arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
                superclass = superclass.getSuperclass();
            } while (superclass.getName().startsWith("com.google.android.gms"));
            for (Field field : arrayList) {
                field.setAccessible(true);
                try {
                    try {
                        final Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            if (field.getType().getName().equals("interface") || obj2.getClass().getName().startsWith("com.google.android.gms")) {
                                list.add(field.getName());
                                a(obj2, list, list2, set, list3);
                                list.remove(list.size() - 1);
                            } else if (field.getType().getName().equals(n)) {
                                list.add(field.getName());
                                list2.add(obj2);
                                list.remove(list.size() - 1);
                            } else if (obj2.getClass().getName().startsWith(com.safedk.android.utils.n.f)) {
                                String str = (String) obj2;
                                if (str.startsWith(V)) {
                                    list.add(field.getName());
                                    Logger.d(l, "found prefetch click url in path: " + list + ", object: " + obj2);
                                    try {
                                        list2.add(new JSONObject("{ \"clickUrl\" : \"" + str + "\" }"));
                                    } catch (JSONException e2) {
                                    }
                                    list.remove(list.size() - 1);
                                }
                                if (str.startsWith(Y)) {
                                    list.add(field.getName());
                                    Logger.d(l, "found prefetch creative id in path: " + list + ", object: " + obj2);
                                    try {
                                        list2.add(new JSONObject("{ \"creativeId\" : \"" + str + "\" }"));
                                    } catch (JSONException e3) {
                                    }
                                    list.remove(list.size() - 1);
                                }
                            } else if (field.getType().getName().equals(Z)) {
                                list.add(field.getName());
                                try {
                                    a(obj2, list3);
                                } catch (ConcurrentModificationException e4) {
                                    Logger.d(l, "Couldn't access LinkedHashMap field : " + e4.getMessage());
                                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.creatives.discoveries.a.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            try {
                                                a.this.a(obj2, (List<String>) list3);
                                            } catch (Throwable th) {
                                                Logger.d(a.l, "Couldn't access LinkedHashMap field (again!) : " + th.getMessage());
                                            }
                                        }
                                    }, 5L);
                                }
                                list.remove(list.size() - 1);
                            }
                        }
                    } catch (ConcurrentModificationException e5) {
                        Logger.e(l, "Error in extract ad info : " + e5.getMessage(), e5);
                    }
                } catch (IllegalAccessException e6) {
                    Logger.e(l, e6.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj, List<String> list) {
        String strQ;
        Logger.d(l, "extractHashMapFieldResourceURLs started");
        for (Map.Entry entry : ((LinkedHashMap) obj).entrySet()) {
            if (entry != null && entry.getValue() != null && (strQ = Q(entry.getValue().toString())) != null) {
                Logger.d(l, "extractHashMapFieldResourceURLs resource url: " + strQ);
                list.add(strQ);
            }
        }
    }

    private String Q(String str) {
        int iIndexOf;
        int iIndexOf2 = str.indexOf(34);
        if (iIndexOf2 <= -1 || (iIndexOf = str.indexOf(34, iIndexOf2 + 1)) <= -1) {
            return null;
        }
        return str.substring(iIndexOf2 + 1, iIndexOf);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        return new HashSet();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        if (!super.e(view) && !view.getClass().getName().equals(ae) && !view.getClass().getName().equals(af)) {
            return false;
        }
        Logger.d(l, "is ad view: " + view.getClass().getName() + " is an instance of " + view.getClass().getName());
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public long a(CreativeInfo creativeInfo) {
        return (creativeInfo == null || creativeInfo.M() != BrandSafetyUtils.AdType.INTERSTITIAL || creativeInfo.h() == null || !creativeInfo.h().contains(CreativeInfo.an)) ? super.a(creativeInfo) : ((long) SafeDK.getInstance().D()) / 2;
    }

    private String R(String str) {
        Matcher matcher = com.safedk.android.utils.g.aT().matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private List<String[]> S(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(<a[^>]*data-asoch-targets=['\"](ad[^'\"]+)['\"][^>]*>(.*?)</a>)", 32).matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup2 != null && strGroup2.contains(StringUtils.COMMA)) {
                strGroup2 = strGroup2.substring(strGroup2.indexOf(44) + 1);
            }
            arrayList.add(new String[]{strGroup2, matcher.group(3).replaceAll("<br\\s*/?>", " ").trim().replaceAll("<[^>]+>", "").trim(), strGroup});
        }
        return arrayList;
    }

    private boolean T(String str) {
        Matcher matcher = com.safedk.android.utils.g.bi().matcher(str);
        Pattern patternBj = com.safedk.android.utils.g.bj();
        while (matcher.find()) {
            if (patternBj.matcher(matcher.group()).find()) {
                return true;
            }
        }
        return false;
    }

    private boolean U(String str) {
        return com.safedk.android.utils.g.bg().matcher(str).find();
    }

    private boolean V(String str) {
        Matcher matcher = com.safedk.android.utils.g.bh().matcher(str);
        while (matcher.find()) {
            if (matcher.groupCount() >= 2) {
                try {
                    int i2 = Integer.parseInt(matcher.group(1));
                    if (i2 != Integer.parseInt(matcher.group(2)) || i2 < 400) {
                        Logger.d(l, "Non-square or small square <svg> found:");
                        Logger.d(l, matcher.group(0));
                        return true;
                    }
                } catch (Throwable th) {
                    Logger.d(l, "exception when parsing integers from svg: ", th);
                }
            }
        }
        return false;
    }

    private void c(String str, CreativeInfo creativeInfo) {
        boolean zT;
        boolean z;
        boolean z2;
        try {
            Logger.d(l, "handle text and survey ads started for ci with id: ");
            if (str.contains("loadPaidtasksSurvey")) {
                creativeInfo.a(CreativeInfo.s, RemoteSettings.FORWARD_SLASH_STRING);
            }
            List<String[]> listS = S(str);
            Logger.d(l, "found " + listS.size() + " data elements");
            boolean zU = U(str);
            boolean z3 = false;
            boolean z4 = false;
            for (String[] strArr : listS) {
                String str2 = strArr[0];
                String str3 = strArr[1];
                String str4 = strArr[2];
                if (aL.contains(str2)) {
                    Logger.d(l, "found text: " + str3);
                    creativeInfo.y(str3);
                    z2 = true;
                } else {
                    z2 = z4;
                }
                if (aN.contains(str2)) {
                    Logger.d(l, "found image based on: " + str2);
                    z3 = true;
                }
                Logger.d(l, "found full tag: " + str4 + " tag: " + str2 + " text: " + str3);
                z4 = z2;
            }
            if (z3) {
                zT = false;
                z = false;
            } else {
                zT = T(str);
                if (zT) {
                    boolean zV = V(str);
                    z = zV;
                    z3 = zV;
                } else {
                    z = false;
                }
            }
            Logger.d(l, "is background cover: " + zT + " is proper svg " + z + " is gradient: " + zU);
            if (z4) {
                creativeInfo.a(CreativeInfo.an, RemoteSettings.FORWARD_SLASH_STRING);
            }
            if (z3) {
                creativeInfo.a(CreativeInfo.aw, RemoteSettings.FORWARD_SLASH_STRING);
            }
            if (zU) {
                creativeInfo.a(CreativeInfo.aF, RemoteSettings.FORWARD_SLASH_STRING);
            }
            Logger.d(l, "result downstream is: " + creativeInfo.h());
        } catch (Throwable th) {
            Logger.d(l, "exception occurred when handling text ad!", th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(com.safedk.android.analytics.brandsafety.e eVar, List<String> list, String str) {
        List<String> listX = eVar.x();
        String strN = BrandSafetyUtils.n(str);
        if (listX == null || listX.isEmpty() || list == null || list.isEmpty()) {
            return false;
        }
        int iLastIndexOf = listX.lastIndexOf(strN);
        if (list.size() <= iLastIndexOf) {
            return false;
        }
        for (int i2 = 0; i2 <= iLastIndexOf; i2++) {
            if (!listX.get(i2).equals(list.get(i2))) {
                return false;
            }
        }
        int i3 = iLastIndexOf + 2;
        while (true) {
            int i4 = i3;
            if (i4 >= listX.size() || i4 >= list.size()) {
                break;
            }
            if (listX.get(i4).equals(list.get(i4))) {
                return false;
            }
            i3 = i4 + 1;
        }
        Logger.d(l, "detected view hierarchy change, stop taking screenshots and collecting resources");
        eVar.a(com.safedk.android.analytics.brandsafety.l.G, new com.safedk.android.analytics.brandsafety.l.a[0]);
        eVar.b(true);
        if (eVar.j() != null) {
            eVar.j().a(true);
        }
        return true;
    }
}
