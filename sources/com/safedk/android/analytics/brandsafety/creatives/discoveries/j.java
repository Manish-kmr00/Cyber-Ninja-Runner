package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.json.b9;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.LineCreativeInfo;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.PersistentConcurrentHashMap;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class j extends d {
    private static final String R = "u";
    private static final String S = "bcns";
    private static final String T = "cfgs";
    private static final String U = "p";
    private static final String V = "tr";
    private static final String W = "k";
    private static final String X = "v";
    private static final String Y = "ots";
    private static final int Z = 8;
    private static MessageDigest ac = null;
    private static final String b = "LineDiscovery";
    private static final String g = "terms.line";
    private static final String h = "com.five_corp.ad.FiveAdCustomLayout";
    private static final String i = "ads";
    private static final String j = "lad";
    private static final String k = "ad";
    private static final String l = "cr";
    private static final String m = "au";
    private static final String n = "whitesi";
    private static final String o = "scfg";
    private static final String p = "m";
    private static final String q = "ic";
    private static final CharSequence c = "ad2.fivecdm.com/ad";
    private static final CharSequence d = "adchk.fivecdm.com/chk";
    private static final CharSequence e = "adchk.fivecdm.com/v1";
    private static final CharSequence f = "ad2.fivecdm.com/v";
    private static Map<String, LineCreativeInfo> aa = null;
    private static String ab = null;

    static {
        try {
            ac = MessageDigest.getInstance("SHA-256");
        } catch (Throwable th) {
        }
    }

    public j() {
        super("com.five_corp.ad", b);
        Logger.d(b, "ctor started");
        this.C.b(AdNetworkConfiguration.SUPPORTS_GZIP_CONTENT, true);
        this.C.b(AdNetworkConfiguration.SDK_INTERSTITIALS_RUN_ON_APP_ACTIVITY, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, true);
        this.C.b(AdNetworkConfiguration.SDK_USES_PLACEMENT_ID_ARRAY, true);
        this.C.b(AdNetworkConfiguration.SDK_CUSTOM_VIEW_TYPE_NAME, h);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BIDDING_INTERSTITIAL_IMPRESSION_MATCHING_BY_MAX, true);
        this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_TEXT_FROM_NATIVE_BANNERS, true);
        this.C.a(AdNetworkConfiguration.NUMBER_OF_VIEWS_REMOVED_IN_FULL_SCREEN_AD_THAT_INDICATES_EOV, 2L);
        this.C.b(AdNetworkConfiguration.DO_NOT_ADD_CI_TO_FINDER_PENDING_CI_LIST, true);
        this.C.b(AdNetworkConfiguration.NOTIFY_DISCOVERY_CLASS_ABOUT_FULL_SCREEN_MATCHING, true);
        this.C.b(AdNetworkConfiguration.SHOULD_DECODE_URLS_IN_CLICK_URL_RESOLUTION, false);
        this.C.b(AdNetworkConfiguration.AVOID_MATCHING_CI_FROM_BANNER_WEB_VIEW_BEFORE_SCANNING, true);
        this.C.a(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_THRESHOLD, 3 * ((long) SafeDK.getInstance().V()));
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SHOULD_DECODE_BASE64_PREFECT_RECEIVED_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SET_AD_FORMAT_FROM_APPLOVIN_BUNDLE, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        try {
            aa = new PersistentConcurrentHashMap("LineDiscovery_creativeIdToCI");
        } catch (InvalidParameterException e2) {
            Logger.e(b, "error initializing LineDiscovery, caching will not be available", e2);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        String str3;
        if (str2 == null) {
            return null;
        }
        try {
            if (str2.length() < 10) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str2);
            com.safedk.android.utils.n.b(b, "generate info started, url=" + str + ", buffer=" + str2);
            ArrayList arrayList = new ArrayList();
            if (!jSONObject.has("ads") && !jSONObject.has("lad") && !jSONObject.has("ad")) {
                Logger.d(b, "generate info - prefetch doesn't contains expected params. ");
                return null;
            }
            if (jSONObject.has("ads")) {
                str3 = "ads";
            } else if (jSONObject.has("lad")) {
                str3 = "lad";
            } else {
                str3 = jSONObject.has("ad") ? "ad" : null;
            }
            if (str3 != null) {
                if (!str3.equals("ad")) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str3);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (str3.equals("lad")) {
                            if (jSONObject2.has("ad")) {
                                arrayList.add(e(jSONObject2.getJSONObject("ad")));
                            }
                        } else if (jSONObject2.has(l)) {
                            arrayList.add(e(jSONObject2));
                        }
                    }
                } else {
                    arrayList.add(e(jSONObject.getJSONObject("ad")));
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            return null;
        } catch (Throwable th) {
            Logger.d(b, "Exception in generate info: " + th.getMessage(), th);
            return null;
        }
    }

    private String a(JSONObject jSONObject) {
        String strB = null;
        try {
            com.safedk.android.utils.n.b(b, "extract click url : bcns exists : " + jSONObject.has(S) + ", cfgs exists :" + jSONObject.has(T));
            if (jSONObject.has(m) && !TextUtils.isEmpty(jSONObject.optString(m))) {
                strB = jSONObject.optString(m);
            } else if (jSONObject.has(S) && (strB = b(jSONObject)) != null) {
                Logger.d(b, "extract click url bcns : " + strB);
            } else if (jSONObject.has(T)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(T);
                if (jSONObject2.has(S) && (strB = b(jSONObject2)) != null) {
                    Logger.d(b, "extract click url cfgs : " + strB);
                }
            }
        } catch (JSONException e2) {
            Logger.d(b, "Exception in extract click url : " + e2.getMessage(), e2);
        } catch (Throwable th) {
            Logger.d(b, "Exception in extract click url : " + th.getMessage(), th);
        }
        return strB;
    }

    private String b(JSONObject jSONObject) {
        try {
            if (jSONObject.has(S)) {
                JSONArray jSONArray = jSONObject.getJSONArray(S);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2.has("p")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("p");
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                            if (jSONObject3.has("k") && jSONObject3.has("v") && "to".equals(jSONObject3.optString("k"))) {
                                String strOptString = jSONObject3.optString("v");
                                Logger.d(b, "get ClickUrl url : " + strOptString);
                                return strOptString;
                            }
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            Logger.d(b, "Exception in get ClickUrl  : " + e2.getMessage(), e2);
        }
        return null;
    }

    private ArrayList<String> c(JSONObject jSONObject) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            if (jSONObject.has(S)) {
                JSONArray jSONArray = jSONObject.getJSONArray(S);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    if (jSONObject2.has("p")) {
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("p");
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            if (jSONArray2.getJSONObject(i3).has("v")) {
                                arrayList.add(jSONArray2.getJSONObject(i3).getString("v"));
                            }
                        }
                    }
                }
            }
            if (jSONObject.has(V)) {
                JSONArray jSONArray3 = jSONObject.getJSONArray(V);
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    JSONObject jSONObject3 = jSONArray3.getJSONObject(i4);
                    if (jSONObject3.has("u")) {
                        arrayList.add(jSONObject3.getString("u"));
                    }
                }
            }
        } catch (JSONException e2) {
            Logger.d(b, "extract dsp domain - exception when trying to extract! ", e2);
        }
        return arrayList;
    }

    private ArrayList<String> d(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONObject.has("m")) {
            arrayList.add(jSONObject.optString("m"));
        }
        if (jSONObject.has(q) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(q)) != null && !TextUtils.isEmpty(jSONObjectOptJSONObject.optString("u"))) {
            arrayList.add(jSONObjectOptJSONObject.optString("u"));
        }
        return arrayList;
    }

    private LineCreativeInfo e(JSONObject jSONObject) {
        String string;
        String strOptString = jSONObject.optString(l, null);
        String strA = a(jSONObject);
        com.safedk.android.utils.n.b(b, "generate info - clickUrl extracted: " + strA);
        String strOptString2 = jSONObject.optString(Y);
        String strOptString3 = jSONObject.optString(n);
        if (TextUtils.isEmpty(strOptString3)) {
            strOptString3 = strOptString3.replace("\"", "").replace(b9.i.d, "").replace(b9.i.e, "");
        }
        if (TextUtils.isEmpty(strOptString3) && jSONObject.has(o)) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(o);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    if (jSONObject2.has("s")) {
                        sb.append(jSONObject2.get("s"));
                    }
                } catch (JSONException e2) {
                    Logger.d(b, "Exception extracting placements : " + e2.getMessage(), e2);
                }
                if (i2 < jSONArrayOptJSONArray.length() - 1) {
                    sb.append(StringUtils.COMMA);
                }
            }
            Logger.d(b, "placement = " + sb.toString());
            string = sb.toString();
        } else {
            string = strOptString3;
        }
        Logger.d(b, "generate info - placement ID: " + string);
        LineCreativeInfo lineCreativeInfo = new LineCreativeInfo(null, strOptString2, strOptString, strA, string, this.G);
        Logger.d(b, "generate info - ci created. placement ID: " + string + ", ots = " + strOptString2);
        synchronized (aa) {
            aa.put(strOptString2, lineCreativeInfo);
        }
        Logger.d(b, "generate info - added CI by ID, key: " + strOptString2 + ", list size: " + aa.size());
        ArrayList<String> arrayListF = com.safedk.android.utils.n.f(jSONObject.toString());
        Logger.d(b, "urls extracted from json ad object contains " + arrayListF.size() + " urls");
        ArrayList<String> arrayListD = d(jSONObject);
        arrayListF.removeAll(arrayListD);
        lineCreativeInfo.b(arrayListD);
        ArrayList<String> arrayListC = c(jSONObject);
        arrayListF.removeAll(arrayListC);
        for (String str : arrayListC) {
            if (lineCreativeInfo.u(str)) {
                lineCreativeInfo.w(str);
            }
        }
        lineCreativeInfo.b((List<String>) arrayListF);
        com.safedk.android.utils.n.b(b, "generate info CI updated. key: " + lineCreativeInfo.P() + ", CI: " + lineCreativeInfo);
        Logger.d(b, "generate info - added CI, list key set: " + aa.keySet());
        return lineCreativeInfo;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String j() {
        return "com.five_corp.ad";
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(BrandSafetyUtils.AdType adType, Object obj, String str) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            com.safedk.android.utils.n.b(b, "extractAdInfoImpl started , stringInfo: " + str2);
            try {
                com.safedk.android.utils.n.b(b, "extractAdInfoImpl extract ad info, found string: " + str2);
                if (aa.containsKey(str2)) {
                    com.safedk.android.utils.n.b(b, "extractAdInfoImpl extract ad info, found key: " + str2);
                    return str2;
                }
            } catch (Throwable th) {
                Logger.d(b, "extractAdInfoImpl exception : " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    private synchronized boolean B(String str) {
        boolean z = true;
        synchronized (this) {
            if (CreativeInfoManager.l(str)) {
                Logger.d(b, "isInterstitialAdCreativeId " + str + " is an interstitial adId");
            } else if (ab != null && ab.equals(str)) {
                Logger.d(b, "isInterstitialAdCreativeId " + str + " is a previously matched interstitial adId");
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Logger.d(b, "match info adInstance: " + obj.getClass().getName() + " : " + obj + ", hashes: " + aa.keySet());
            if (obj instanceof WeakReference) {
                Dialog dialog = (Dialog) ((WeakReference) obj).get();
                if (dialog == null) {
                    Logger.d(b, "match info adInstance - dialog is null");
                    return null;
                }
                String strA = a(BrandSafetyUtils.AdType.INTERSTITIAL, dialog, new ArrayList<>(), new HashSet<>());
                Logger.d(b, "extractAdInfo returned " + strA);
                WeakReference weakReference = new WeakReference(dialog.getWindow().getDecorView().findViewById(R.id.content));
                if (strA != null) {
                    if (aa.containsKey(strA)) {
                        LineCreativeInfo lineCreativeInfo = aa.get(strA);
                        if (lineCreativeInfo != null) {
                            lineCreativeInfo.a(weakReference.get());
                            lineCreativeInfo.a((View) weakReference.get());
                            Logger.d(b, "match info adInstance - reset expiration time as network support prefetch reuse");
                            lineCreativeInfo.af();
                            com.safedk.android.utils.n.b(b, "match info adInstance - MATCH FOUND, CI: " + lineCreativeInfo);
                            if (lineCreativeInfo.n() != null) {
                                com.safedk.android.utils.n.b(b, "match info adInstance - clearing eventId");
                                lineCreativeInfo.h((String) null);
                                return lineCreativeInfo;
                            }
                            return lineCreativeInfo;
                        }
                        return lineCreativeInfo;
                    }
                    Logger.d(b, "match info adInstance - no match cannot match with creative ID: " + strA);
                } else {
                    com.safedk.android.utils.n.b(b, "match info adInstance - no match no creative ID or more than one candidate.");
                }
            } else if (obj instanceof String) {
                String str = (String) obj;
                if (aa.containsKey(str)) {
                    LineCreativeInfo lineCreativeInfo2 = aa.get(str);
                    com.safedk.android.utils.n.b(b, "match info adInstance - MATCH FOUND, CI: " + lineCreativeInfo2);
                    if (lineCreativeInfo2 != null && lineCreativeInfo2.n() != null) {
                        com.safedk.android.utils.n.b(b, "match info adInstance - clearing eventId");
                        lineCreativeInfo2.h((String) null);
                        return lineCreativeInfo2;
                    }
                    return lineCreativeInfo2;
                }
            }
        } catch (Throwable th) {
            Logger.d(b, "Exception in match info adInstance: " + th.getMessage(), th);
        }
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
        boolean z = false;
        if (!com.safedk.android.utils.n.c(str)) {
            z = str.contains(c) || str.contains(d) || str.contains(e) || str.contains(f);
            if (z) {
                Logger.d(b, "should follow input stream impl started, url: " + str);
            }
        }
        return z;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean j(String str) {
        Logger.d(b, "should ignore redirect url started. url: " + str);
        if (str.contains(g)) {
            Logger.d(b, "should ignore redirect url - terms url detected, requesting no sampling for the impression");
            CreativeInfoManager.b("com.five_corp.ad", (String) null);
            return true;
        }
        synchronized (aa) {
            Iterator<LineCreativeInfo> it = aa.values().iterator();
            if (it.hasNext()) {
                LineCreativeInfo next = it.next();
                Logger.d(b, "should ignore redirect url (creative to video url map) click url: " + next.O());
                if (str.equals(next.O())) {
                    Logger.d(b, "should ignore redirect url - clicked url: " + str);
                }
                return true;
            }
            return false;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        return super.e(view) || (view.getClass().getCanonicalName().contains("com.five_corp.ad") && (view instanceof ViewGroup));
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
        com.safedk.android.utils.e.a(aa, "LineDiscovery:creativeIdToCI");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public synchronized void b(CreativeInfo creativeInfo) {
        Logger.d(b, "onMatch started, adId = " + creativeInfo.N());
        ab = creativeInfo.N();
    }
}
