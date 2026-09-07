package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.MolocoCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class n extends d {
    private static final String R = "text";
    private static final String S = "data";
    private static final String T = "value";
    private static final String U = "img";
    private static final String V = "url";
    private static final String W = "video";
    private static final String X = "vasttag";
    private static final String Y = "info";
    private static final String Z = "moloco-mtid";
    private static final String aa = "mtid";
    private static final String ab = "molo_click_id";
    private static final String ac = "ctx";
    private static final String b = "MolocoDiscovery";
    private static final String c = "moloco.com";
    private static final String d = "adjust.com";
    private static final String e = "androidx.compose.ui.platform.ComposeView";
    private static final String f = "seatbid";
    private static final String g = "bid";
    private static final String h = "crid";
    private static final String i = "bundle";
    private static final String j = "iurl";
    private static final String k = "adomain";
    private static final String l = "adid";
    private static final String m = "adm";
    private static final String n = "native";
    private static final String o = "assets";
    private static final String p = "id";
    private static final String q = "title";

    public n() {
        super(com.safedk.android.utils.h.D, b);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SHOULD_ALLOW_REFLECTION_ON_OS_CLASSES, true);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_TO_IGNORE, "MOLOCO_NETWORK");
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_BANNERS_USING_BANNER_KEY, true);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObject3;
        ArrayList<String> arrayList;
        boolean z;
        boolean z2;
        Logger.d(b, "generate info - started, url= " + str);
        try {
            jSONObject = new JSONObject(com.safedk.android.utils.c.a(Base64.decode(str2, 0)));
        } catch (JSONException e2) {
            Logger.d(b, "generate info - not a valid JSON string: " + e2.getMessage());
            jSONObject = null;
        } catch (Throwable th) {
            Logger.d(b, "generate info - not a valid JSON string: " + th.getMessage(), th);
            jSONObject = null;
        }
        if (jSONObject == null) {
            Logger.d(b, "generate info - obj is null, skipping.");
            return null;
        }
        Logger.d(b, "generate info - obj= " + jSONObject);
        BrandSafetyUtils.AdType adType = BrandSafetyUtils.AdType.INTERSTITIAL;
        String str3 = null;
        String str4 = null;
        if (aVar != null) {
            str3 = aVar.c;
            str4 = aVar.f8068a;
            if (aVar.b.name().equals("BANNER") || aVar.b.name().equals(BrandSafetyUtils.n)) {
                adType = BrandSafetyUtils.AdType.BANNER;
            } else if (aVar.b.name().equals("NATIVE")) {
                adType = BrandSafetyUtils.AdType.NATIVE;
            }
        }
        try {
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(f);
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0 && (jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(0)) != null && (jSONArrayOptJSONArray = jSONObject2.optJSONArray("bid")) != null && jSONArrayOptJSONArray.length() > 0) {
                JSONObject jSONObject4 = jSONArrayOptJSONArray.getJSONObject(0);
                com.safedk.android.utils.n.b(b, "generate info - bid= " + jSONObject4);
                if (jSONObject4 != null) {
                    String strOptString = jSONObject4.optString(h);
                    Logger.d(b, "generate info - creativeId= " + strOptString);
                    String strOptString2 = jSONObject4.optString("bundle");
                    Logger.d(b, "generate info - bundle= " + strOptString2);
                    String strOptString3 = jSONObject4.optString(j);
                    Logger.d(b, "generate info - iurl= " + strOptString3);
                    JSONArray jSONArrayOptJSONArray3 = jSONObject4.optJSONArray(k);
                    Logger.d(b, "generate info - adomainArray= " + jSONArrayOptJSONArray3);
                    String strOptString4 = jSONObject4.optString(l);
                    Logger.d(b, "generate info - adId= " + strOptString4);
                    String strOptString5 = jSONObject4.optString("adm");
                    Logger.d(b, "generate info - adm= " + strOptString5);
                    String str5 = null;
                    ArrayList<String> arrayListF = com.safedk.android.utils.n.f(strOptString5);
                    com.safedk.android.utils.n.b(b, "generate info - adm resource list is : " + arrayListF);
                    try {
                        jSONObject3 = new JSONObject(strOptString5);
                    } catch (JSONException e3) {
                        Logger.d(b, "generate info - adm is not json obj. exception= " + e3);
                        jSONObject3 = null;
                    }
                    Logger.d(b, "generate info - adm obj= " + jSONObject3);
                    if (TextUtils.isEmpty(strOptString5) || jSONObject3 != null) {
                        arrayList = arrayListF;
                        z = false;
                    } else {
                        ArrayList<String> arrayListF2 = com.safedk.android.utils.n.f(strOptString5);
                        if (com.safedk.android.utils.n.a(com.safedk.android.utils.g.c(), strOptString5, 1) != null) {
                            str5 = "vast";
                            z2 = true;
                        } else {
                            str5 = "mraid";
                            z2 = false;
                        }
                        strOptString4 = a(arrayListF2);
                        Logger.d(b, "generate info - adId from getAdIdFromResourceList = " + strOptString4 + ", resourcesList : " + arrayListF2);
                        arrayList = arrayListF2;
                        z = z2;
                    }
                    Logger.d(b, "generate info - adId= " + strOptString4);
                    MolocoCreativeInfo molocoCreativeInfo = new MolocoCreativeInfo(adType, com.safedk.android.utils.h.D, strOptString4, strOptString, str5, this.G, str3, strOptString2, (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) ? null : jSONArrayOptJSONArray3.getString(0), str4);
                    if (z) {
                        a((CreativeInfo) molocoCreativeInfo, (String) null, strOptString5, true);
                    } else if (jSONObject3 == null) {
                        molocoCreativeInfo.b((List<String>) arrayList);
                    }
                    if (jSONObject3 != null && aVar != null) {
                        boolean z3 = aVar.b == BrandSafetyEvent.AdFormatType.NATIVE;
                        if (!a(molocoCreativeInfo, jSONObject3, z3) && !TextUtils.isEmpty(strOptString3)) {
                            c(molocoCreativeInfo, CreativeInfo.aN, strOptString3, z3);
                        }
                        if (z3) {
                            molocoCreativeInfo.r(com.safedk.android.utils.k.n(str2));
                        } else {
                            molocoCreativeInfo.r(aVar.c + "_" + aVar.f8068a + "_" + com.safedk.android.utils.h.D);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(molocoCreativeInfo);
                    Logger.d(b, "generate info - creativeInfo= " + molocoCreativeInfo);
                    Logger.d(b, "generate info - adIdToCreatives = " + this.H.keySet());
                    return arrayList2;
                }
            }
        } catch (Exception e4) {
            Logger.d(b, "generate info - exception while parsing prefetch: " + e4);
        }
        return null;
    }

    private boolean a(CreativeInfo creativeInfo, JSONObject jSONObject, boolean z) {
        String str;
        boolean z2;
        boolean z3;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("native");
        Logger.d(b, "handle native prefetch - native obj= " + jSONObjectOptJSONObject);
        if (jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("assets")) == null) {
            str = null;
            z2 = false;
            z3 = false;
        } else {
            str = null;
            z2 = false;
            z3 = false;
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                if (jSONObjectOptJSONObject2 != null) {
                    int iOptInt = jSONObjectOptJSONObject2.optInt("id", -1);
                    Logger.d(b, "handle native prefetch - asset id= " + iOptInt + ",    asset obj= " + jSONObjectOptJSONObject2);
                    switch (iOptInt) {
                        case 0:
                            c(creativeInfo, CreativeInfo.aO, c(jSONObjectOptJSONObject2), z);
                            break;
                        case 1:
                            String strC = c(jSONObjectOptJSONObject2);
                            c(creativeInfo, CreativeInfo.aN, strC, z);
                            if (!TextUtils.isEmpty(strC)) {
                                z3 = true;
                            }
                            break;
                        case 2:
                            String strD = d(jSONObjectOptJSONObject2);
                            if (!TextUtils.isEmpty(strD)) {
                                str = strD;
                                z2 = true;
                            }
                            break;
                        case 3:
                            b(creativeInfo, CreativeInfo.aM, a(jSONObjectOptJSONObject2), z);
                            break;
                        case 4:
                            if (z) {
                                b(creativeInfo, CreativeInfo.aS, b(jSONObjectOptJSONObject2), z);
                            }
                            break;
                        case 5:
                            b(creativeInfo, CreativeInfo.aP, b(jSONObjectOptJSONObject2), z);
                            break;
                        case 7:
                            if (z) {
                                b(creativeInfo, CreativeInfo.aQ, b(jSONObjectOptJSONObject2), z);
                            }
                            break;
                    }
                }
            }
        }
        if (z) {
            creativeInfo.a("native", RemoteSettings.FORWARD_SLASH_STRING);
        }
        if (z2) {
            a(creativeInfo, (String) null, str, true);
            creativeInfo.a("vast", RemoteSettings.FORWARD_SLASH_STRING);
        }
        return z3;
    }

    private void b(CreativeInfo creativeInfo, String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            if (!z) {
                creativeInfo.y(str2);
            } else {
                creativeInfo.z(str + str2);
            }
        }
    }

    private void c(CreativeInfo creativeInfo, String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str2)) {
            if (!z) {
                creativeInfo.x(str2);
            } else {
                creativeInfo.z(str + str2);
            }
        }
    }

    private String a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("title")) == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString("text");
        Logger.d(b, "get title text from native asset - text= " + strOptString);
        return strOptString;
    }

    private String b(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString("value");
        Logger.d(b, "get data value from native asset - value= " + strOptString);
        return strOptString;
    }

    private String c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("img")) == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString("url");
        Logger.d(b, "get image url from native asset - url= " + strOptString);
        return strOptString;
    }

    private String d(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("video")) == null) {
            return null;
        }
        String strOptString = jSONObjectOptJSONObject.optString(X);
        Logger.d(b, "get vast tag video from native asset - vast= " + strOptString);
        return strOptString;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        return str.contains(c) || str.contains(d);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        return B(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        CreativeInfo creativeInfo = this.H.get(obj.toString());
        if (creativeInfo == null) {
            return this.H.get(com.safedk.android.utils.k.n(obj.toString()));
        }
        return creativeInfo;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        return super.e(view) || e.equals(view.getClass().getName());
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String j() {
        return com.safedk.android.utils.h.D;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(BrandSafetyUtils.AdType adType, Object obj, String str) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!TextUtils.isEmpty(str2)) {
                return a(com.safedk.android.utils.n.f(str2));
            }
        }
        return null;
    }

    private static String a(ArrayList<String> arrayList) {
        String strB;
        String str = null;
        if (arrayList == null) {
            return null;
        }
        for (String str2 : arrayList) {
            if (str2.contains(c) || str2.contains(d)) {
                strB = B(str2);
                if (!TextUtils.isEmpty(strB)) {
                    return strB;
                }
            } else {
                strB = str;
            }
            str = strB;
        }
        return str;
    }

    private static String B(String str) {
        Logger.d(b, "getAdIdFromResource started, resource = " + str);
        ArrayList<String> arrayList = new ArrayList<>();
        if (com.safedk.android.utils.n.a((Object) str)) {
            arrayList.add(str);
        } else {
            arrayList = com.safedk.android.utils.n.f(str);
        }
        for (String str2 : arrayList) {
            String strD = com.safedk.android.utils.k.d(str2, Y);
            String strZ = com.safedk.android.utils.n.z(str2);
            String strD2 = TextUtils.isEmpty(strD) ? com.safedk.android.utils.k.d(strZ, Y) : strD;
            if (TextUtils.isEmpty(strD2)) {
                strD2 = com.safedk.android.utils.k.d(strZ, Z);
            }
            if (TextUtils.isEmpty(strD2)) {
                strD2 = com.safedk.android.utils.k.d(strZ, aa);
            }
            if (TextUtils.isEmpty(strD2)) {
                strD2 = com.safedk.android.utils.k.d(strZ, ab);
            }
            if (TextUtils.isEmpty(strD2)) {
                strD2 = com.safedk.android.utils.k.d(strZ, ac);
                Logger.d(b, "get ad id from resource - found adId ctx = " + strD2);
            }
            if (!TextUtils.isEmpty(strD2)) {
                Logger.d(b, "get ad id from resource - found adId= " + strD2);
                return strD2;
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(View view) {
        return h(view);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean b(View view) {
        return i(view);
    }
}
