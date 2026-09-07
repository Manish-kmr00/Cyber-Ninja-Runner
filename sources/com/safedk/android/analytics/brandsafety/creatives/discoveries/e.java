package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.RedirectDetails;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.ProtobufMessageParser;
import com.safedk.android.analytics.brandsafety.creatives.infos.BidMachineCreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class e extends d {
    private static final String R = "events";
    private static final String S = "html";
    private static final String T = "image";
    private static final String U = "internalProtobuf";
    private static final String V = "name";
    private static final String W = "native";
    private static final String X = "phases";
    private static final String Y = "ads";
    private static final String Z = "source";
    private static final String aa = "tasks";
    private static final String ab = "text";
    private static final String ac = "title";
    private static final String ad = "type";
    private static final String ae = "value";
    private static final String af = "vast";
    private static final String ag = "version";
    private static final String ah = "response_cache_url";
    private static final String ai = "text";
    private static final String aj = "xml";
    private static final String ak = "html";
    private static final String al = "fragmented_video_template/";
    private static final String am = "mraid2";
    private static final String an = "[\\n\\s'\"\\/]";
    private static final String ao = ".mp4";
    private static final String ap = "mraid://open";
    private static final String aq = "url";
    private static final String ar = "mraid://expand";
    private static final String as = "bidmachine.io/bid-context/";
    public static final String b = "{\"1\":[\"version\",\"string\"],\"5\":{\"6\":{\"1\":[\"buyerId\",\"string\"],\"3\":{\"1\":[\"adId\",\"string\"],\"13\":{\"2\":{\"1\":[\"creativeId\",\"string\"],\"2\":[\"adDomain\",\"string\"],\"3\":[\"advertisedContent\",\"string\"],\"13\":{\"8\":[\"html\",\"string\"],\"11\":{\"1\":{\"1\":[\"clickUrl\",\"string\"],\"3\":[\"dspDomains\",\"array\",\"string\"]},\"2\":[\"native\",\"array\",{\"1\":[\"type\",\"i32\"],\"3\":{\"1\":[\"title\",\"string\"]},\"4\":{\"1\":[\"image\",\"string\"]},\"6\":{\"1\":[\"text\",\"string\"]}}]}},\"14\":{\"4\":[\"vast\",\"string\"]},\"17\":{\"2\":{\"29\":{\"2\":[\"internalProtobuf\",\"string\"]},\"33\":{\"3\":[\"phases\",\"array\",{\"3\":[\"ads\",\"array\",{\"1\":[\"name\",\"string\"],\"2\":[\"type\",\"i32\"],\"3\":[\"source\",\"string\"]}],\"6\":[\"events\",\"array\",{\"3\":[\"tasks\",\"array\",{\"1\":[\"name\",\"i32\"],\"3\":[\"value\",\"string\"]}]}]}]}}}}}}}}}";
    private static final String c = "BidMachineDiscovery";
    private static final String h = "{\"2\":[\"response_cache_url\",\"string\"]}";
    private static final String i = "{\"3\":{\"1\":[\"version\",\"string\"],\"5\":{\"6\":{\"1\":[\"buyerId\",\"string\"],\"3\":{\"1\":[\"adId\",\"string\"],\"13\":{\"2\":{\"1\":[\"creativeId\",\"string\"],\"2\":[\"adDomain\",\"string\"],\"3\":[\"advertisedContent\",\"string\"],\"13\":{\"8\":[\"html\",\"string\"],\"11\":{\"1\":{\"1\":[\"clickUrl\",\"string\"],\"3\":[\"dspDomains\",\"array\",\"string\"]},\"2\":[\"native\",\"array\",{\"1\":[\"type\",\"i32\"],\"3\":{\"1\":[\"title\",\"string\"]},\"4\":{\"1\":[\"image\",\"string\"]},\"6\":{\"1\":[\"text\",\"string\"]}}]}},\"14\":{\"4\":[\"vast\",\"string\"]},\"17\":{\"2\":{\"29\":{\"2\":[\"internalProtobuf\",\"string\"]},\"33\":{\"3\":[\"phases\",\"array\",{\"3\":[\"ads\",\"array\",{\"1\":[\"name\",\"string\"],\"2\":[\"type\",\"i32\"],\"3\":[\"source\",\"string\"]}],\"6\":[\"events\",\"array\",{\"3\":[\"tasks\",\"array\",{\"1\":[\"name\",\"i32\"],\"3\":[\"value\",\"string\"]}]}]}]}}}}}}}}}}";
    private static final String j = "{\"2\":{\"6\":{\"9\":{\"8\":{\"3\":[\"trackingURLs3\",\"array\",\"string\"],\"5\":[\"trackingURLs5\",\"array\",\"string\"],\"6\":[\"trackingURLs6\",\"array\",\"string\"]}}}}}";
    private static final String k = "adDomain";
    private static final String l = "advertisedContent";
    private static final String m = "adId";
    private static final String n = "buyerId";
    private static final String o = "clickUrl";
    private static final String p = "creativeId";
    private static final String q = "dspDomains";
    private static final String d = "bidmachine.io";
    private static final String e = "lazybumblebee.com";
    private static final String f = "bm-ads.io";
    private static final List<String> g = Arrays.asList(d, e, f);
    private static final Map<String, Set<CreativeInfo>> at = new HashMap();
    private static final Map<Integer, Set<CreativeInfo>> au = new HashMap();
    private static final Map<String, CreativeInfo> av = new HashMap();
    private static final Map<String, CreativeInfo> aw = new HashMap();
    private static final Map<String, c.a> ax = new HashMap();
    private static final Map<String, CreativeInfo> ay = new HashMap();

    public e() {
        super("io.bidmachine", c);
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MEDIA_PLAYER_RELEASE_EOV, true);
        this.C.b(AdNetworkConfiguration.USE_INPUT_STREAM_EVENT_AS_RESOURCE_LOADED_INDICATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_ADD_BYTE_ARRAY_AS_PARAM_ON_AD_FETCHED, true);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException {
        com.safedk.android.utils.n.b(c, "generate info impl - started. url: " + str + ", maxParams: " + aVar);
        if (aVar != null) {
            JSONObject jSONObjectA = ProtobufMessageParser.a(Base64.decode(str2, 0), h);
            com.safedk.android.utils.n.b(c, "generate info impl - response cache url json extracted: \n" + jSONObjectA.toString(4));
            if (jSONObjectA.has(ah)) {
                String string = jSONObjectA.getString(ah);
                Logger.d(c, "generate info impl - saving max params= " + aVar + ",        response cache url= " + string);
                ax.put(string, aVar);
                return null;
            }
            Logger.d(c, "generate info impl - old protobuf message, use old protobuf message template");
            return a(str, Base64.decode(str2, 0), i, aVar);
        }
        Logger.d(c, "generate info impl - new protobuf message, use new protobuf message template");
        return a(str, bArr, b, ax.remove(str));
    }

    /* JADX WARN: Code duplicated, block: B:77:0x037f  */
    private List<CreativeInfo> a(String str, byte[] bArr, String str2, c.a aVar) {
        String str3;
        JSONObject jSONObjectA;
        Logger.d(c, "generate ci impl - max params= " + aVar);
        if (bArr == null || aVar == null) {
            Logger.d(c, "generate ci impl - max params or byte array are null, skipping");
            return null;
        }
        try {
            JSONObject jSONObjectA2 = ProtobufMessageParser.a(bArr, str2);
            JSONObject jSONObject = new JSONObject();
            if (jSONObjectA2.has(U)) {
                String string = jSONObjectA2.getString(U);
                byte[] bArrDecode = Base64.decode(string, 0);
                if (!TextUtils.isEmpty(string) && !com.safedk.android.utils.n.n(new String(bArrDecode))) {
                    str3 = null;
                    jSONObjectA = ProtobufMessageParser.a(bArrDecode, j);
                } else if (TextUtils.isEmpty(string)) {
                    str3 = null;
                    jSONObjectA = jSONObject;
                } else {
                    str3 = string;
                    jSONObjectA = jSONObject;
                }
            } else {
                str3 = null;
                jSONObjectA = jSONObject;
            }
            com.safedk.android.utils.n.b(c, "generate ci impl - outer json extracted: \n" + jSONObjectA2.toString(4));
            com.safedk.android.utils.n.b(c, "generate ci impl - inner json extracted: \n" + jSONObjectA.toString(4));
            String strOptString = jSONObjectA2.optString("adId");
            if (!TextUtils.isEmpty(strOptString)) {
                BidMachineCreativeInfo bidMachineCreativeInfo = new BidMachineCreativeInfo(BrandSafetyUtils.b(aVar.b.name()), "io.bidmachine", strOptString, this.G, aVar.c, aVar.f8068a);
                synchronized (this.H) {
                    this.H.put(strOptString, bidMachineCreativeInfo);
                }
                Logger.d(c, "generate info impl - ci saved early by ad id= " + strOptString);
                if (str3 != null) {
                    Logger.d(c, "generate ci impl - saving ci by context id= " + str3);
                    av.put(str3, bidMachineCreativeInfo);
                }
                bidMachineCreativeInfo.a(aVar.b);
                String str4 = "";
                if (jSONObjectA2.has("html")) {
                    str4 = "mraid";
                    Logger.d(c, "generate ci impl - media value is mraid!");
                    e(bidMachineCreativeInfo, jSONObjectA2.optString("html"));
                }
                if (jSONObjectA2.has("vast")) {
                    str4 = str4 + "vast";
                    Logger.d(c, "generate ci impl - media value is vast!");
                    a((CreativeInfo) bidMachineCreativeInfo, (String) null, jSONObjectA2.getString("vast"), true);
                    d((CreativeInfo) bidMachineCreativeInfo, bidMachineCreativeInfo.J());
                }
                if (jSONObjectA2.has("native")) {
                    str4 = str4 + "native";
                    Logger.d(c, "generate ci impl - media value is native!");
                    a((CreativeInfo) bidMachineCreativeInfo, jSONObjectA2.getJSONArray("native"));
                    if (jSONObjectA2.has("clickUrl")) {
                        bidMachineCreativeInfo.a(jSONObjectA2.getString("clickUrl"), true);
                    }
                    if (str.contains(as)) {
                        Logger.d(c, "generate ci impl - saving native ci by url= " + str);
                        ay.put(str, bidMachineCreativeInfo);
                    }
                }
                if (a(jSONObjectA2)) {
                    Logger.d(c, "generate ci impl - media value is spread vast!");
                    str4 = str4 + al;
                    b((CreativeInfo) bidMachineCreativeInfo, jSONObjectA2);
                    d((CreativeInfo) bidMachineCreativeInfo, bidMachineCreativeInfo.J());
                } else if (jSONObjectA2.has(X)) {
                    Logger.d(c, "generate ci impl - media value is spread mraid!");
                    str4 = str4 + am;
                    a((CreativeInfo) bidMachineCreativeInfo, jSONObjectA2);
                }
                bidMachineCreativeInfo.e(str4);
                Logger.d(c, "generate ci impl - setting downstream struct to= " + str4);
                if (jSONObjectA2.has(n)) {
                    bidMachineCreativeInfo.m(jSONObjectA2.getString(n));
                    Logger.d(c, "generate ci impl - setting buyer id to= " + bidMachineCreativeInfo.R());
                }
                if (jSONObjectA2.has("creativeId")) {
                    bidMachineCreativeInfo.k(jSONObjectA2.getString("creativeId"));
                    Logger.d(c, "generate ci impl - setting creative id to= " + bidMachineCreativeInfo.P());
                }
                if (jSONObjectA2.has(k)) {
                    bidMachineCreativeInfo.i(jSONObjectA2.getString(k));
                    Logger.d(c, "generate ci impl - setting ad domain to= " + bidMachineCreativeInfo.o());
                }
                if (jSONObjectA2.has("advertisedContent")) {
                    bidMachineCreativeInfo.a(jSONObjectA2.getString("advertisedContent"));
                    Logger.d(c, "generate ci impl - setting advertised content to= " + bidMachineCreativeInfo.R());
                }
                if (jSONObjectA2.has(q)) {
                    e(bidMachineCreativeInfo, jSONObjectA2.getJSONArray(q).toString());
                }
                Iterator<String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    e(bidMachineCreativeInfo, jSONObjectA.getJSONArray(itKeys.next()).toString());
                }
                String strE = E(jSONObjectA2.toString().replaceAll("\\\\\"", "\""));
                Logger.d(c, "generate ci impl - found dsp click url?= " + strE);
                if (!TextUtils.isEmpty(strE)) {
                    bidMachineCreativeInfo.a(strE.replaceAll("\\\\/", RemoteSettings.FORWARD_SLASH_STRING), true);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(bidMachineCreativeInfo);
                return arrayList;
            }
        } catch (JSONException e2) {
            Logger.d(c, "generate ci impl - json exception: " + e2);
        }
        return null;
    }

    private static boolean a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(X);
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ads")) != null) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i3);
                        if (jSONObjectOptJSONObject2 != null) {
                            String strOptString = jSONObjectOptJSONObject2.optString("name");
                            boolean z = !TextUtils.isEmpty(strOptString) && strOptString.equals("vast");
                            boolean z2 = jSONObjectOptJSONObject2.optInt("type") == 1;
                            boolean z3 = !TextUtils.isEmpty(jSONObjectOptJSONObject2.optString("source"));
                            if (z && z2 && z3) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private void a(CreativeInfo creativeInfo, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(X);
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ads")) != null) {
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i3);
                        if (jSONObjectOptJSONObject2 != null) {
                            int iOptInt = jSONObjectOptJSONObject2.optInt("type");
                            String strOptString = jSONObjectOptJSONObject2.optString("source");
                            if (iOptInt == 2) {
                                e(creativeInfo, strOptString);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void b(CreativeInfo creativeInfo, JSONObject jSONObject) {
        boolean z;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(X);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null) {
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("ads");
                    if (jSONArrayOptJSONArray3 != null) {
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray3.optJSONObject(i3);
                            if (jSONObjectOptJSONObject2 != null) {
                                int iOptInt = jSONObjectOptJSONObject2.optInt("type");
                                String strOptString = jSONObjectOptJSONObject2.optString("source");
                                if (iOptInt == 1) {
                                    arrayList.add(strOptString);
                                } else if (iOptInt == 2) {
                                    arrayList2.add(strOptString);
                                }
                            }
                        }
                    }
                    JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray("events");
                    if (jSONArrayOptJSONArray4 != null) {
                        boolean z3 = z2;
                        for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray4.optJSONObject(i4);
                            if (jSONObjectOptJSONObject3 != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray(aa)) != null) {
                                for (int i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i5);
                                    if (jSONObjectOptJSONObject4 != null) {
                                        int iOptInt2 = jSONObjectOptJSONObject4.optInt("name");
                                        String strOptString2 = jSONObjectOptJSONObject4.optString("value");
                                        if (iOptInt2 == 4) {
                                            Logger.d(c, "update spread vast dsp domains - adding dsp domain= " + strOptString2);
                                            creativeInfo.v(strOptString2);
                                        } else if (iOptInt2 == 16 && !z3) {
                                            creativeInfo.a(strOptString2, true);
                                            z3 = true;
                                            com.safedk.android.utils.n.b(c, "update spread vast dsp domains - adding click url= " + strOptString2);
                                        }
                                    }
                                }
                            }
                        }
                        z2 = z3;
                    }
                }
            }
        }
        boolean z4 = false;
        Iterator it = arrayList.iterator();
        while (true) {
            z = z4;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (str.endsWith(ao)) {
                com.safedk.android.utils.n.b(c, "handle spread vast video url - adding video url with mp4 extension= " + str);
                creativeInfo.p(str);
                z4 = true;
            } else {
                z4 = z;
            }
        }
        if (!z && !arrayList.isEmpty()) {
            com.safedk.android.utils.n.b(c, "handle spread vast video url - adding first video url (without extension)= " + ((String) arrayList.get(0)));
            creativeInfo.p((String) arrayList.get(0));
        }
        b(creativeInfo, (List<String>) arrayList);
        c(creativeInfo, (List<String>) arrayList2);
    }

    private static void a(CreativeInfo creativeInfo, JSONObject jSONObject, String str) {
        if (creativeInfo != null && jSONObject != null) {
            String strOptString = jSONObject.optString("text");
            if (!TextUtils.isEmpty(strOptString)) {
                Logger.d(c, "update native element from dataAsset - adding as " + str + " prefix. data= " + strOptString);
                creativeInfo.z(str + strOptString);
            }
        }
    }

    private static void b(CreativeInfo creativeInfo, JSONObject jSONObject, String str) {
        if (creativeInfo != null && jSONObject != null) {
            String strOptString = jSONObject.optString("title");
            if (!TextUtils.isEmpty(strOptString)) {
                Logger.d(c, "update native element from TitleAsset - adding as " + str + " prefix. title= " + strOptString);
                creativeInfo.z(str + strOptString);
            }
        }
    }

    private static void c(CreativeInfo creativeInfo, JSONObject jSONObject, String str) {
        if (creativeInfo != null && jSONObject != null) {
            String strOptString = jSONObject.optString("image");
            if (!TextUtils.isEmpty(strOptString)) {
                Logger.d(c, "update native element from ImageAsset - adding as " + str + " prefix. image= " + strOptString);
                creativeInfo.z(str + strOptString);
            }
        }
    }

    private static void a(CreativeInfo creativeInfo, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                switch (jSONObjectOptJSONObject.optInt("type")) {
                    case 8:
                        arrayList.add(jSONObjectOptJSONObject);
                        break;
                    case INVALID_RI_ENDPOINT_VALUE:
                        b(creativeInfo, jSONObjectOptJSONObject, CreativeInfo.aM);
                        break;
                    case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                        c(creativeInfo, jSONObjectOptJSONObject, CreativeInfo.aO);
                        break;
                    case 127:
                        a(creativeInfo, jSONObjectOptJSONObject, CreativeInfo.aP);
                        break;
                    case 128:
                        c(creativeInfo, jSONObjectOptJSONObject, CreativeInfo.aN);
                        break;
                    default:
                        Logger.d(c, "update native elements - discarded asset= " + jSONObjectOptJSONObject);
                        break;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            a(creativeInfo, (JSONObject) arrayList.get(arrayList.size() - 1), CreativeInfo.aQ);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        Logger.d(c, "match info - started. adInstance class= " + obj.getClass() + ",    adInstance= " + obj);
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str)) {
                String strOptString = ProtobufMessageParser.a(Base64.decode(str, 0), i).optString("adId");
                Logger.d(c, "match info - found? ad id= " + strOptString);
                if (!TextUtils.isEmpty(strOptString)) {
                    CreativeInfo creativeInfo = this.H.get(strOptString);
                    if (creativeInfo != null) {
                        e(creativeInfo);
                        Logger.d(c, "match info - found? ci by ad id= " + creativeInfo.aa());
                        return creativeInfo;
                    }
                    return creativeInfo;
                }
                String strOptString2 = ProtobufMessageParser.a(Base64.decode(str, 0), h).optString(ah);
                Logger.d(c, "match info - found? response cache url= " + strOptString2);
                if (!TextUtils.isEmpty(strOptString2)) {
                    CreativeInfo creativeInfo2 = ay.get(strOptString2);
                    if (creativeInfo2 != null) {
                        Logger.d(c, "match info - found? ci by response cache url= " + creativeInfo2.aa());
                        return creativeInfo2;
                    }
                    return creativeInfo2;
                }
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        CreativeInfo creativeInfo;
        Logger.d(c, "get ad id from resource - value= " + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        boolean z = false;
        String strA = a(com.safedk.android.utils.g.aW(), str);
        Logger.d(c, "get ad id from resource - extracted contextId= " + strA);
        if (TextUtils.isEmpty(strA)) {
            strA = a(com.safedk.android.utils.g.aX(), str);
            Logger.d(c, "get ad id from resource - extracted contextId (second pattern)= " + strA);
        }
        if (!TextUtils.isEmpty(strA)) {
            creativeInfo = av.get(strA);
            z = true;
        } else {
            String strReplaceAll = str.replaceAll(an, "");
            CreativeInfo creativeInfo2 = null;
            for (String str3 : aw.keySet()) {
                creativeInfo2 = strReplaceAll.contains(str3) ? aw.get(str3) : creativeInfo2;
            }
            creativeInfo = creativeInfo2;
        }
        if (creativeInfo == null) {
            return null;
        }
        Logger.d(c, "get ad id from resource - found? ci= " + creativeInfo.aa());
        if (creativeInfo.B() && !a(c, creativeInfo, au) && z) {
            Logger.d(c, "get ad id from resource - ci found is vast, but not matched by media player previously, discarding.: " + creativeInfo.aa());
            return null;
        }
        e(creativeInfo);
        return creativeInfo.N();
    }

    private static String B(String str) {
        try {
            return new BigInteger(MessageDigest.getInstance(SameMD5.TAG).digest(str.getBytes())).abs().toString(36);
        } catch (Exception e2) {
            Logger.d(c, "get fragmented vast video identifier - exception: " + e2);
            return str;
        }
    }

    public static void b(CreativeInfo creativeInfo, List<String> list) {
        for (String str : list) {
            String strB = B(str);
            Logger.d(c, "save fragmented vast video identifier to ci - video url= " + str + ",    video identifier= " + strB + ",    ci= " + creativeInfo.aa());
            c(creativeInfo, strB);
        }
    }

    public static void c(CreativeInfo creativeInfo, List<String> list) {
        Logger.d(c, "save vast html resources to ci - ci= " + creativeInfo.aa());
        com.safedk.android.utils.n.b(c, "save vast html resources to ci - htmlResourceList= " + list);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            Iterator<String> it2 = com.safedk.android.analytics.brandsafety.creatives.h.a(com.safedk.android.utils.g.x(), it.next(), 1, false).iterator();
            while (it2.hasNext()) {
                List<String> listA = com.safedk.android.analytics.brandsafety.creatives.h.a(com.safedk.android.utils.g.E(), it2.next(), 1, false);
                if (!listA.isEmpty()) {
                    String str = listA.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        aw.put(str.replaceAll(an, ""), creativeInfo);
                    }
                }
            }
        }
    }

    private static void c(CreativeInfo creativeInfo, String str) {
        Set<CreativeInfo> hashSet = at.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            at.put(str, hashSet);
        }
        hashSet.add(creativeInfo);
        Logger.d(c, "save vast video identifier to ci - saving to videoIdToCiMap.  videoUrl= " + str + ",    ci= " + creativeInfo.aa());
    }

    private static void d(CreativeInfo creativeInfo, String str) {
        if (!TextUtils.isEmpty(str)) {
            String strReplaceAll = str.replaceAll(RemoteSettings.FORWARD_SLASH_STRING, "").replaceAll(":", "");
            Logger.d(c, "save vast video url to ci - videoUrl= " + strReplaceAll);
            if (!TextUtils.isEmpty(strReplaceAll)) {
                c(creativeInfo, strReplaceAll);
            }
        }
    }

    private void e(CreativeInfo creativeInfo, String str) {
        ArrayList<String> arrayListF = com.safedk.android.utils.n.f(str);
        creativeInfo.b((List<String>) arrayListF);
        Iterator<String> it = arrayListF.iterator();
        while (it.hasNext()) {
            String strA = a(com.safedk.android.utils.g.aW(), it.next());
            if (!TextUtils.isEmpty(strA) && !av.containsKey(strA)) {
                Logger.d(c, "classify resources and save ci by context id - saving to contextIdToCiMap by url, contextId= " + strA + ",     ci= " + creativeInfo.aa());
                av.put(strA, creativeInfo);
                break;
            }
        }
        String strA2 = a(com.safedk.android.utils.g.aY(), str);
        if (!TextUtils.isEmpty(strA2) && !av.containsKey(strA2)) {
            Logger.d(c, "classify resources and save ci by context id - saving to contextIdToCiMap by html, contextId= " + strA2 + ",     ci= " + creativeInfo.aa());
            av.put(strA2, creativeInfo);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String b(Object obj) {
        int iIdentityHashCode = System.identityHashCode(obj);
        Logger.d(c, "get creative info after media player start call - mediaPlayer= " + obj + ",    player id= " + iIdentityHashCode);
        Set<CreativeInfo> set = au.get(Integer.valueOf(iIdentityHashCode));
        Logger.d(c, "get creative info after media player start call - found? ci set= " + set);
        if (set != null) {
            if (set.size() == 1) {
                CreativeInfo next = set.iterator().next();
                if (next != null) {
                    Logger.d(c, "get creative info after media player start call - found ci= " + next.aa());
                    e(next);
                    return next.N();
                }
            } else {
                Logger.d(c, "get creative info after media player start call - = could not find ci. ci set= " + set);
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        Logger.d(c, "handle vast media file - ci id= " + creativeInfo.N() + ",    video url= " + str);
        d(creativeInfo, str);
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected void a(CreativeInfo creativeInfo, List<String> list) {
        c(creativeInfo, list);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = g.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00a9  */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        boolean z;
        if (ax.containsKey(str)) {
            Logger.d(c, "should follow input stream impl - this is a response cache url, return true");
            return true;
        }
        boolean z2 = G(str) || G(com.safedk.android.utils.k.b(str));
        ArrayList<String> stringArrayList = bundle.getStringArrayList("Content-Type");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            z = false;
        } else {
            String str2 = stringArrayList.get(0);
            if (TextUtils.isEmpty(str2)) {
                z = false;
            } else {
                z = str2.contains("text") || str2.contains(aj) || str2.contains("html");
            }
        }
        if (!z2 && z) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            com.safedk.android.utils.n.b(c, "should follow input stream impl - thread stack trace= " + Arrays.toString(stackTrace));
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement.getMethodName() != null && stackTraceElement.getMethodName().equals("loadVideoWithDataSync")) {
                    Logger.d(c, "should follow input stream impl - this is inner VastAdTagUri. returning true");
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    private static Set<CreativeInfo> C(String str) {
        Logger.d(c, "find ci by video url - videoUrlToCiSetMap size= " + at.size() + ",   keys= " + at.keySet());
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : at.keySet()) {
                if (str2.contains(str)) {
                    Set<CreativeInfo> set = at.get(str2);
                    Logger.d(c, "find ci by video url - creative info set found= " + set);
                    return set;
                }
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void b(Object obj, Object obj2) {
        Logger.d(c, "handle media player set data source call - mediaPlayer= " + obj + ",    videoFile= " + obj2);
        try {
            if (obj2 instanceof Uri) {
                String path = ((Uri) obj2).getPath();
                Logger.d(c, "handle media player set data source call - uri.getPath= " + path);
                if (!TextUtils.isEmpty(path)) {
                    String[] strArrSplit = path.split(RemoteSettings.FORWARD_SLASH_STRING);
                    if (strArrSplit.length > 0) {
                        String str = strArrSplit[strArrSplit.length - 1];
                        Logger.d(c, "handle media player set data source call - videoUrl= " + str);
                        Set<CreativeInfo> setC = C(str);
                        Logger.d(c, "handle media player set data source call - found? ci set= " + setC);
                        if (setC != null) {
                            int iIdentityHashCode = System.identityHashCode(obj);
                            Logger.d(c, "handle media player set data source call - PUTTING mediaPlayerHashToCiSetMap playerId= " + iIdentityHashCode);
                            au.put(Integer.valueOf(iIdentityHashCode), setC);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Logger.e(c, "exception when trying to add mediaPlayer id and VungleCreativeInfo " + e2.getMessage());
        }
    }

    private static void e(CreativeInfo creativeInfo) {
        if (creativeInfo != null) {
            Logger.d(c, "remove matched ci from all collections - removing ci from collection contextIdToCiMap");
            b(c, creativeInfo, av);
            Logger.d(c, "remove matched ci from all collections - removing ci from collection htmlResourceToCiMap");
            b(c, creativeInfo, aw);
            Logger.d(c, "remove matched ci from all collections - removing ci from collection mediaPlayerHashToCiSetMap");
            c(c, creativeInfo, au);
            Logger.d(c, "remove matched ci from all collections - removing ci from collection videoUrlToCiListMap");
            c(c, creativeInfo, at);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String l(String str) {
        Logger.d(c, "extract mraid redirect target url - url= " + str);
        if (str == null) {
            return str;
        }
        if (str.contains(ap) || str.contains(ar)) {
            return com.safedk.android.utils.k.d(str, "url");
        }
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public RedirectDetails.RedirectType k(String str) {
        Logger.d(c, "extract mraid redirect type - url= " + str);
        if (str != null) {
            if (str.contains(ap)) {
                return RedirectDetails.RedirectType.REDIRECT;
            }
            if (str.contains(ar)) {
                return RedirectDetails.RedirectType.EXPAND;
            }
        }
        return RedirectDetails.RedirectType.REDIRECT;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
    }
}
