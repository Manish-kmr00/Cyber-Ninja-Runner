package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.OnGlobalImpressionDataListener;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.RedirectDetails;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.FyberCreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public class FyberDiscovery extends d {
    private static final String R = "rewarded";
    private static final String S = "interstitial";
    private static final String T = "banner";
    private static final String U = "mrec";
    private static final String V = "v";
    private static final String W = "vast-vpaid";
    private static final String X = "cached-ad";
    private static final String Y = ".fyber.com/ad";
    private static final String Z = ".inner-active.mobi/impression";
    private static final String aa = "s";
    private static final String ab = "crid";
    private static final String ac = "cid";
    private static final String ad = "network";
    private static final String ae = "sessionId";
    private static final String af = "mraid://open";
    private static final String ag = "url";
    private static final String ah = "mraid://expand";
    private static final String ak = "fyMraidVideoAd";
    private static final String al = "fyMraidVideoAdCompleted";
    private static final String am = "adm";
    private static final String an = "scar-admob";
    private static final int at = 15;
    public static final String b = "wv.inner-active.mobi/simpleM2M/clientRequestEnhancedXmlAd";
    public static final String c = "com.fyber.inneractive.sdk";
    public static final String d = "com.fyber.inneractive.sdk.player.ui";
    public static final String e = "<tns:Response";
    private static final String f = "FyberDiscovery";
    private static final String g = "X-IA-Ad-Unit-Display-Type";
    private static final String h = "X-IA-Creative-ID";
    private static final String i = "X-IA-Ad-Unit-ID";
    private static final String j = "X-IA-AdNetwork";
    private static final String k = "X-IA-Adomain";
    private static final String l = "X-IA-sdkClickUrl";
    private static final String m = "X-IA-Session";
    private static final String n = "X-IA-Campaign-ID";
    private static final String o = "X-IA-sdkImpressionUrl";
    private static final String p = "spotid";
    private static final String q = "vast";
    private ConcurrentHashMap<String, CreativeInfo> ao;
    private final ConcurrentHashMap<String, CreativeInfo> as;
    private OnGlobalImpressionDataListener ax;
    private static final String aj = "fymraidvideo://";
    private static final String[] ai = {"mraid://close", "mraid://usecustomclose", "mraid://setOrientationProperties", "iaadfinishedloading://", aj, "fmpendcard://"};
    private static final ConcurrentHashMap<String, String> ap = new ConcurrentHashMap<>();
    private static HashMap<Integer, String> aq = new HashMap<>();
    private static final String[] ar = {"adTime", "countingMethod"};
    private static final LimitedConcurrentHashMap<String, WeakReference<WebView>> au = new LimitedConcurrentHashMap<>(15);
    private static final LimitedConcurrentHashMap<String, String> av = new LimitedConcurrentHashMap<>(15);
    private static AtomicBoolean aw = new AtomicBoolean(false);

    public FyberDiscovery() {
        super(com.safedk.android.utils.h.p, f);
        this.ao = new ConcurrentHashMap<>();
        this.as = new ConcurrentHashMap<>();
        this.ax = new FyberOnGlobalImpressionDataListener();
        try {
            this.C.b(AdNetworkConfiguration.SHOULD_DECODE_EXTRACTED_EXPRESSIONS_FROM_VAST, false);
            this.C.b(AdNetworkConfiguration.SUPPORTS_GZIP_CONTENT, true);
            this.C.b(AdNetworkConfiguration.ENFORCE_CLOSE_INPUT_STREAM, true);
            this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, true);
            this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, true);
            this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, true);
            this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, true);
            this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, true);
            this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, true);
            this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION_BY_MAX_EVENT, true);
            this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_BANNER_MULTIPLE_WEBVIEWS, true);
            this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, true);
            this.C.b(AdNetworkConfiguration.USE_INPUT_STREAM_EVENT_AS_RESOURCE_LOADED_INDICATION, true);
            this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, true);
            this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true);
        } catch (Throwable th) {
            Logger.e(f, "exception in ctor", th);
        }
    }

    private static void h() {
        if (aq.isEmpty()) {
            aq.put(Integer.valueOf(SafeDK.getInstance().m().getResources().getIdentifier("inneractive_webview_vast_endcard", "id", SafeDK.getInstance().m().getPackageName())), "inneractive_webview_vast_endcard");
            aq.put(Integer.valueOf(SafeDK.getInstance().m().getResources().getIdentifier("inneractive_webview_vast_vpaid", "id", SafeDK.getInstance().m().getPackageName())), "inneractive_webview_vast_vpaid");
            aq.put(Integer.valueOf(SafeDK.getInstance().m().getResources().getIdentifier("inneractive_vast_endcard_html", "id", SafeDK.getInstance().m().getPackageName())), "inneractive_vast_endcard_html");
            aq.put(Integer.valueOf(SafeDK.getInstance().m().getResources().getIdentifier("inneractive_webview_mraid", "id", SafeDK.getInstance().m().getPackageName())), "inneractive_webview_mraid");
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public HashMap<Integer, String> g() {
        return aq;
    }

    public static void a(boolean z) {
        aw.set(z);
        Logger.d(f, "on global impression data listener is set to " + z);
        h();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) {
        com.safedk.android.utils.n.b(f, "generate info url = " + str + " , headers = " + (map != null ? map.toString() : "null") + ", buffer size = " + (str2 == null ? "0" : Integer.valueOf(str2.length())));
        if (TextUtils.isEmpty(str)) {
            Logger.d(f, "generate info url is empty, exiting");
            return null;
        }
        if (str.contains(b)) {
            return a(str, str2, map);
        }
        if (str.contains(X) && str.contains(Y)) {
            String strD = com.safedk.android.utils.k.d(str, "sessionId");
            if (TextUtils.isEmpty(strD)) {
                Logger.d(f, "generate info session id is empty, exiting");
                return null;
            }
            if (str2 != null) {
                String strA = BrandSafetyUtils.a(str2.replace("\n", "").getBytes());
                Logger.d(f, "generate info content hash: " + strA);
                ap.put(strA, strD);
                CreativeInfo creativeInfo = this.ao.get(strD);
                if (creativeInfo != null) {
                    a(str2, creativeInfo, true);
                } else {
                    Logger.d(f, "generate info no CI for ad content with session ID: " + strD);
                }
            }
        } else if (aVar != null) {
            return a(str2, aVar);
        }
        return null;
    }

    private List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map) {
        BrandSafetyEvent.AdFormatType adFormatType;
        BrandSafetyUtils.AdType adType;
        ArrayList arrayList = new ArrayList();
        String strD = null;
        try {
            k();
            Logger.d(f, "generate info handle prefetch start");
            String strA = a(map, g);
            if (strA != null) {
                Logger.d(f, "generate info ad type is " + strA);
                if (strA.equals("interstitial")) {
                    adFormatType = BrandSafetyEvent.AdFormatType.INTER;
                    adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                } else if (strA.equals("rewarded")) {
                    adFormatType = BrandSafetyEvent.AdFormatType.REWARD;
                    adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                } else if (strA.equals("banner")) {
                    adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
                    adType = BrandSafetyUtils.AdType.BANNER;
                } else if (strA.contains("mrec")) {
                    adFormatType = BrandSafetyEvent.AdFormatType.MREC;
                    adType = BrandSafetyUtils.AdType.MREC;
                } else {
                    Logger.d(f, "generate info ad type is " + strA + ", skipping");
                    return null;
                }
                if (str != null && str.contains(b) && ((strD = com.safedk.android.utils.k.d(str, p)) != null || this.G != null)) {
                    Logger.d(f, "generate info spot id: " + strD + " ,sdk version: " + this.G);
                }
                String strA2 = a(map, i);
                String strA3 = a(map, h);
                if (strA3 == null) {
                    Logger.d(f, "generate info creative id is null, using ad id for it's value");
                } else {
                    strA2 = strA3;
                }
                String strA4 = a(map, n);
                String strA5 = a(map, l);
                String strA6 = a(map, j);
                String strA7 = a(map, k);
                String strA8 = a(map, m);
                Logger.d(f, "generate info session id: " + strA8);
                String strA9 = a(map, o);
                Logger.d(f, "generate info sdk impression url: " + strA9);
                String strE = E(com.safedk.android.utils.k.k(str2));
                if (str2 != null) {
                    String strA10 = BrandSafetyUtils.a(str2.replace("\n", "").getBytes());
                    Logger.d(f, "generate info content hash: " + strA10);
                    ap.put(strA10, strA8);
                }
                FyberCreativeInfo fyberCreativeInfo = new FyberCreativeInfo(strA8, strA2, strA4, strE, null, adFormatType, adType, strD, this.G, strA6, strA7, strA5, null);
                arrayList.add(fyberCreativeInfo);
                if (adType == BrandSafetyUtils.AdType.INTERSTITIAL) {
                    synchronized (this.ao) {
                        this.ao.put(strA8, fyberCreativeInfo);
                    }
                    Logger.d(f, "generate info added CI to list by session id: " + strA8 + ",  CI list: " + this.ao);
                }
                String strK = K(strA9);
                synchronized (this.as) {
                    this.as.put(strK, fyberCreativeInfo);
                }
                Logger.d(f, "generate info added CI to list by sdk impression url: " + strK + ",  CI list: " + this.as);
                a(str2, (CreativeInfo) fyberCreativeInfo, false);
            } else {
                Logger.d(f, "generate info ad type is null, skipping");
                return null;
            }
        } catch (Throwable th) {
            Logger.d(f, "Error in generate info : " + th.getMessage(), th);
        }
        return arrayList;
    }

    private List<CreativeInfo> a(String str, c.a aVar) {
        BrandSafetyEvent.AdFormatType adFormatType;
        BrandSafetyUtils.AdType adType;
        Logger.d(f, "generate info handle bidding start");
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            ArrayList<String> arrayListF = com.safedk.android.utils.n.f(new String(Base64.decode(str, 0)));
            for (String str2 : arrayListF) {
                if (str2.contains(Z)) {
                    String strD = com.safedk.android.utils.k.d(str2, "s");
                    String str3 = aVar != null ? aVar.d : null;
                    String strD2 = com.safedk.android.utils.k.d(str2, "network");
                    Logger.d(f, "sessionId=" + strD + " creativeId=" + str3 + " adNetwork=" + strD2);
                    BrandSafetyEvent.AdFormatType adFormatType2 = null;
                    BrandSafetyUtils.AdType adType2 = null;
                    String str4 = null;
                    String str5 = null;
                    if (aVar != null) {
                        if (aVar.b == BrandSafetyEvent.AdFormatType.INTER) {
                            adFormatType = BrandSafetyEvent.AdFormatType.INTER;
                            adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                        } else if (aVar.b == BrandSafetyEvent.AdFormatType.REWARD) {
                            adFormatType = BrandSafetyEvent.AdFormatType.REWARD;
                            adType = BrandSafetyUtils.AdType.INTERSTITIAL;
                        } else if (aVar.b == BrandSafetyEvent.AdFormatType.BANNER || aVar.b == BrandSafetyEvent.AdFormatType.LEADER) {
                            adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
                            adType = BrandSafetyUtils.AdType.BANNER;
                        } else if (aVar.b == BrandSafetyEvent.AdFormatType.MREC) {
                            adFormatType = BrandSafetyEvent.AdFormatType.MREC;
                            adType = BrandSafetyUtils.AdType.MREC;
                        } else {
                            Logger.d(f, "generate info max params ad format is " + aVar.b + ", skipping");
                            return null;
                        }
                        str4 = aVar.f8068a;
                        str5 = aVar.c;
                        adType2 = adType;
                        adFormatType2 = adFormatType;
                    }
                    Logger.d(f, "ad format type=" + adFormatType2 + " ad type=" + adType2);
                    FyberCreativeInfo fyberCreativeInfo = new FyberCreativeInfo(strD, str3, null, null, null, adFormatType2, adType2, str5, this.G, strD2, null, null, str4);
                    fyberCreativeInfo.b((List<String>) arrayListF);
                    arrayList.add(fyberCreativeInfo);
                    synchronized (this.ao) {
                        this.ao.put(strD, fyberCreativeInfo);
                    }
                    Logger.d(f, "generate info added CI to list by session id: " + strD + ", CI list: " + this.ao);
                    String strK = K(str2);
                    synchronized (this.as) {
                        this.as.put(strK, fyberCreativeInfo);
                    }
                    Logger.d(f, "generate info added CI to list by sdk impression url: " + str2 + ", CI list: " + this.as);
                    return arrayList;
                }
            }
        }
        return null;
    }

    private void b(String str, CreativeInfo creativeInfo) {
        creativeInfo.a(an, RemoteSettings.FORWARD_SLASH_STRING);
        String strF = com.safedk.android.utils.k.f(str);
        com.safedk.android.utils.n.b(f, "decoded prefetch content is: " + strF);
        ArrayList<String> arrayListF = com.safedk.android.utils.n.f(strF);
        Iterator<String> it = arrayListF.iterator();
        while (it.hasNext()) {
            com.safedk.android.utils.n.b(f, "DV360 handle - found url: " + it.next());
        }
        creativeInfo.b((List<String>) arrayListF);
    }

    private void a(String str, CreativeInfo creativeInfo, boolean z) {
        Logger.d(f, "generate info ad content start");
        if (com.safedk.android.utils.n.n(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("adm")) {
                    b(jSONObject.getString("adm"), creativeInfo);
                    return;
                }
            } catch (JSONException e2) {
                Logger.d(f, "generate info ad content - exception when creating JSON object", e2);
            }
            Logger.d(f, "generate info unknown content type");
            return;
        }
        if (z) {
            String strA = com.safedk.android.utils.n.a(com.safedk.android.utils.g.ay(), str, 1);
            if (!TextUtils.isEmpty(strA)) {
                Logger.d(f, "generate info bidding - found buyer id: " + strA);
                creativeInfo.m(strA);
            } else {
                Logger.d(f, "generate info bidding - did NOT find buyer id, using the old version from prefetch: " + creativeInfo.R());
            }
        }
        String strA2 = com.safedk.android.utils.n.a(com.safedk.android.utils.g.ax(), str, 1);
        if (strA2 != null) {
            if (com.safedk.android.utils.n.a(com.safedk.android.utils.g.c(), strA2, 1) != null) {
                String strA3 = com.safedk.android.analytics.brandsafety.creatives.e.a(strA2, true);
                com.safedk.android.utils.n.b(f, "generate info vast ad content: " + strA3);
                c(creativeInfo, strA3);
                creativeInfo.e("vast");
                return;
            }
            com.safedk.android.utils.n.b(f, "generate info processing mraid ad: " + strA2);
            c(com.safedk.android.utils.n.a(com.safedk.android.utils.g.ax(), str, 1), creativeInfo);
            creativeInfo.e("mraid");
        }
    }

    private void k() {
        if (!aw.get()) {
            if (InneractiveAdManager.wasInitialized()) {
                InneractiveAdManager.setImpressionDataListener(this.ax);
                Logger.d(f, "on global impression data listener has been set by SafeDK");
                aw.set(true);
                return;
            }
            Logger.d(f, "initialize on global impression listener - Fyber Sdk is not initialized yet");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        com.safedk.android.utils.n.b(com.safedk.android.analytics.brandsafety.creatives.discoveries.FyberDiscovery.f, "match info ad instance - CI MATCH FOUND! by key: " + r6 + ", CI : " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        com.safedk.android.utils.Logger.d(com.safedk.android.analytics.brandsafety.creatives.discoveries.FyberDiscovery.f, "match info ad instance - cannot find key in: " + r5.ao.keySet());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008c, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
    
        r2 = r1;
     */
    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo a(java.lang.Object r6) {
        /*
            r5 = this;
            r1 = 0
            java.lang.String r0 = "FyberDiscovery"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r2.<init>()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r3 = "match info ad instance: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8f
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8f
            com.safedk.android.utils.Logger.d(r0, r2)     // Catch: java.lang.Throwable -> L8f
            boolean r0 = r6 instanceof com.fyber.inneractive.sdk.external.ImpressionData     // Catch: java.lang.Throwable -> L8f
            if (r0 == 0) goto L56
            com.fyber.inneractive.sdk.external.ImpressionData r6 = (com.fyber.inneractive.sdk.external.ImpressionData) r6     // Catch: java.lang.Throwable -> L8f
            java.lang.String r6 = r6.getImpressionId()     // Catch: java.lang.Throwable -> L8f
        L23:
            if (r6 == 0) goto L99
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo> r4 = r5.ao     // Catch: java.lang.Throwable -> L8f
            monitor-enter(r4)     // Catch: java.lang.Throwable -> L8f
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo> r0 = r5.ao     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r0 = r0.remove(r6)     // Catch: java.lang.Throwable -> L5d
            com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo r0 = (com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo) r0     // Catch: java.lang.Throwable -> L5d
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L92
            if (r0 == 0) goto L6d
            java.lang.String r1 = "FyberDiscovery"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r2.<init>()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "match info ad instance - CI MATCH FOUND! by key: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = ", CI : "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8c
            com.safedk.android.utils.n.b(r1, r2)     // Catch: java.lang.Throwable -> L8c
        L55:
            return r0
        L56:
            boolean r0 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> L8f
            if (r0 == 0) goto L9b
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> L8f
            goto L23
        L5d:
            r0 = move-exception
            r2 = r0
            r3 = r1
        L60:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L96
            throw r2     // Catch: java.lang.Throwable -> L62
        L62:
            r1 = move-exception
            r2 = r1
            r0 = r3
        L65:
            java.lang.String r1 = "FyberDiscovery"
            java.lang.String r3 = "Exception in match info ad instance: "
            com.safedk.android.utils.Logger.d(r1, r3, r2)
            goto L55
        L6d:
            java.lang.String r1 = "FyberDiscovery"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            r2.<init>()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = "match info ad instance - cannot find key in: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo> r3 = r5.ao     // Catch: java.lang.Throwable -> L8c
            java.util.Set r3 = r3.keySet()     // Catch: java.lang.Throwable -> L8c
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L8c
            com.safedk.android.utils.Logger.d(r1, r2)     // Catch: java.lang.Throwable -> L8c
            goto L55
        L8c:
            r1 = move-exception
            r2 = r1
            goto L65
        L8f:
            r2 = move-exception
            r0 = r1
            goto L65
        L92:
            r1 = move-exception
            r2 = r1
            r3 = r0
            goto L60
        L96:
            r0 = move-exception
            r2 = r0
            goto L60
        L99:
            r0 = r1
            goto L55
        L9b:
            r6 = r1
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.safedk.android.analytics.brandsafety.creatives.discoveries.FyberDiscovery.a(java.lang.Object):com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo");
    }

    private CreativeInfo c(String str, CreativeInfo creativeInfo) {
        Logger.d(f, "update Html CI started: " + creativeInfo.aa());
        ArrayList arrayList = new ArrayList();
        List<String> listB = com.safedk.android.utils.n.b(com.safedk.android.utils.g.aA(), str, 1);
        if (listB != null && listB.size() > 0) {
            Iterator<String> it = listB.iterator();
            while (it.hasNext()) {
                String strF = com.safedk.android.utils.k.f(it.next());
                Logger.d(f, "update Html CI - resource url: " + strF);
                arrayList.add(strF);
            }
        }
        Iterator<String> it2 = com.safedk.android.utils.n.f(str).iterator();
        while (it2.hasNext()) {
            String strF2 = com.safedk.android.utils.k.f(it2.next());
            Logger.d(f, "update Html CI - extract urls from source new url: " + strF2);
            arrayList.add(strF2);
        }
        creativeInfo.b((List<String>) arrayList);
        Logger.d(f, "update Html CI updated: " + creativeInfo.aa());
        return creativeInfo;
    }

    public CreativeInfo c(CreativeInfo creativeInfo, String str) {
        C("parse vast prefetch start");
        a(creativeInfo, (String) null, str, false);
        creativeInfo.b(true);
        if (creativeInfo.g()) {
            ((FyberCreativeInfo) creativeInfo).e(W);
        }
        Logger.d(f, "parse vast prefetch - CI updated : " + creativeInfo.aa());
        C("parse vast prefetch return");
        return creativeInfo;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String c(String str, String str2) {
        return a(str, str2, (WeakReference<WebView>) null);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        Logger.d(f, "get ad ID from resource: source is: " + str2 + ", and value is: " + str + ", webViewRef is: " + (weakReference == null ? "null" : weakReference.get()));
        if (str2 == null) {
            return null;
        }
        String strK = K(str2);
        Logger.d(f, "get ad ID from resource: cleanSource: " + strK + ", creativeInfosBySdkImpressionUrl keys are: " + this.as.keySet());
        if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
            au.put(strK, weakReference);
            Logger.d(f, "get ad ID from resource: webview is alive, adding clean source: " + strK);
        } else {
            Logger.d(f, "get ad ID from resource: webview is not alive, not adding to map");
        }
        CreativeInfo creativeInfo = this.as.get(strK);
        if (creativeInfo != null) {
            String strN = creativeInfo.N();
            Logger.d(f, "get ad ID from resource: found ci in map with ad id: " + strN);
            av.put(strN, strK);
            Logger.d(f, "get ad ID from resource: added ad id: " + strN + " to adIdToSource map");
            return strN;
        }
        Logger.d(f, "get ad ID from resource: could not find ci in map!");
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean m(String str) {
        if (av.containsKey(str)) {
            return a(av.get(str), com.safedk.android.utils.h.p, au, this.as, d.t);
        }
        Logger.d(f, "try reverse matching with ad id - ad id " + str + " is not in the adIdToSource keys: " + av.keySet());
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void n(String str) {
        String strRemove = av.remove(str);
        Logger.d(f, "clean resources started with ad id: " + str + ", and source is: " + strRemove);
        if (strRemove != null) {
            au.remove(strRemove);
        }
    }

    public String B(String str) {
        return com.safedk.android.utils.n.a(com.safedk.android.utils.g.az(), str, 1);
    }

    private String a(Map<String, List<String>> map, String str) {
        List<String> list;
        if (map != null && map.keySet().toString().toLowerCase().contains(str.toLowerCase())) {
            if (map.get(str) != null) {
                list = map.get(str);
            } else {
                list = map.get(str.toLowerCase()) != null ? map.get(str.toLowerCase()) : null;
            }
            if (list != null && list.size() > 0) {
                Logger.d(f, "get value from headers key '" + str + "', value '" + list.get(0) + "'");
                return list.get(0);
            }
            Logger.d(f, "header '" + str + "' not found");
        } else {
            Logger.d(f, "header '" + str + "' not found");
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(String str, CreativeInfo creativeInfo) {
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean A(String str) {
        return ((this.E.contains(str) || this.E.contains(I(str)) || this.E.contains(str.replace(Marker.ANY_NON_NULL_MARKER, " "))) && !G(str)) || this.as.containsKey(K(str));
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected boolean b(String str, Bundle bundle) {
        boolean z = str.contains(b) || (str.contains(X) && str.contains(Y)) || this.D.containsKey(new com.safedk.android.analytics.brandsafety.creatives.i(str)) || this.D.containsKey(new com.safedk.android.analytics.brandsafety.creatives.i(I(str))) || this.D.containsKey(new com.safedk.android.analytics.brandsafety.creatives.i(str.replace(Marker.ANY_NON_NULL_MARKER, " ")));
        if (z) {
            Logger.d(f, "should follow input stream started, url=" + str + ", result=" + z);
        }
        D(str);
        return z;
    }

    private void C(String str) {
        try {
            Logger.d(f, "print CI collection (" + str + ")==========   by session ID (" + this.ao.size() + " items) ==============");
            synchronized (this.ao) {
                for (String str2 : this.ao.keySet()) {
                    Logger.d(f, "print CI collection key=" + str2);
                    d(this.ao.get(str2), str);
                }
            }
        } catch (Throwable th) {
            Logger.e(f, "Exception in print CI collection", th);
            if (this.ao == null) {
                Logger.d(f, "print CI collection list was null, initializing");
                this.ao = new ConcurrentHashMap<>();
            }
        }
    }

    private void d(CreativeInfo creativeInfo, String str) {
        if (creativeInfo == null) {
            Logger.d(f, "print CI collection - CI is null");
            return;
        }
        StringBuilder sbAppend = new StringBuilder().append("print CI collection ");
        if (str == null) {
            str = "";
        }
        com.safedk.android.utils.n.b(f, sbAppend.append(str).append("\n, CI : ").append(creativeInfo.aa()).toString());
    }

    public class FyberOnGlobalImpressionDataListener implements OnGlobalImpressionDataListener {
        public FyberOnGlobalImpressionDataListener() {
        }

        @Override // com.fyber.inneractive.sdk.external.OnGlobalImpressionDataListener
        public void onImpression(String s, String s1, ImpressionData impressionData) {
            Logger.d(FyberDiscovery.f, "on impression started, string1: " + s + ", string2: " + s1 + ", impression data: " + impressionData.toString());
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        return new HashSet();
    }

    private String K(String str) {
        for (String str2 : ar) {
            str = com.safedk.android.utils.k.f(str, str2);
        }
        return H(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void c(View view) {
        j(view);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void d(View view) {
        j(view);
    }

    private void j(View view) {
        Context contextM = SafeDK.getInstance().m();
        int identifier = contextM.getResources().getIdentifier("ia_tv_skip", "id", contextM.getPackageName());
        int identifier2 = contextM.getResources().getIdentifier("ia_iv_close_button", "id", contextM.getPackageName());
        Logger.d(f, "handle on view click - ia_tv_skip resId=" + identifier + ", ia_iv_close_button resId=" + identifier2);
        if (view.getId() == identifier || view.getId() == identifier2) {
            Logger.d(f, "handle on view click - view type is =" + view.getClass().getName());
            if (view instanceof TextView) {
                Logger.d(f, "handle on view click - clicked the 'skip' TextView, calling CI manager on video completed");
                CreativeInfoManager.onVideoCompleted(com.safedk.android.utils.h.p, "view-click");
                return;
            } else {
                Logger.d(f, "handle on view click - clicked view is not of type 'TextView'. exiting function");
                return;
            }
        }
        Logger.d(f, "handle on view click - clicked view is not the 'skip' or 'close' TextView.");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        if (!super.e(view) && (!(view instanceof ViewGroup) || !view.getClass().getName().startsWith(d))) {
            return false;
        }
        Logger.d(f, "is ad view: " + view.getClass().getName() + " is a Fyber ViewGroup ");
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String j() {
        return c;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    protected String a(BrandSafetyUtils.AdType adType, Object obj, String str) {
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.startsWith(e)) {
                String strA = BrandSafetyUtils.a(str2.replace("\n", "").getBytes());
                String strRemove = ap.remove(strA);
                Logger.d(f, "extract ad info found, hash: " + strA + ", sessionId: " + strRemove);
                return strRemove;
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(String str) {
        return super.a(str) || str.startsWith(aj);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean b(String str) {
        return super.b(str) || str.endsWith(ak);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean c(String str) {
        return super.c(str) || str.endsWith(al);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean d(String str) {
        return super.d(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String l(String str) {
        if (str == null) {
            return str;
        }
        if (str.contains(af) || str.contains(ah)) {
            return com.safedk.android.utils.k.d(str, "url");
        }
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public RedirectDetails.RedirectType k(String str) {
        if (str != null) {
            if (str.contains(af)) {
                return RedirectDetails.RedirectType.REDIRECT;
            }
            if (str.contains(ah)) {
                return RedirectDetails.RedirectType.EXPAND;
            }
            for (String str2 : ai) {
                if (str.startsWith(str2)) {
                    return null;
                }
            }
        }
        return RedirectDetails.RedirectType.REDIRECT;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(View view) {
        if (!(view instanceof TextureView) || !view.getClass().getName().contains(d)) {
            return false;
        }
        Logger.d(f, "native video player identified, view: " + view);
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean b(View view) {
        boolean z;
        if ((view instanceof TextureView) && view.getClass().getName().contains(d) && view.isShown()) {
            return false;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            z = true;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                z = z && b(viewGroup.getChildAt(i2));
            }
        } else {
            z = true;
        }
        return z;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d
    public void i() {
        super.i();
        com.safedk.android.utils.e.a(this.as, "FyberDiscovery:creativeInfosBySdkImpressionUrl");
        com.safedk.android.utils.e.a(this.ao, "FyberDiscovery:creativeInfosBySessionId");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.discoveries.d, com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public long a(CreativeInfo creativeInfo) {
        AdNetworkDiscovery adNetworkDiscoveryI;
        return (creativeInfo == null || creativeInfo.h() == null || !creativeInfo.h().contains(an) || (adNetworkDiscoveryI = CreativeInfoManager.i(com.safedk.android.utils.h.h)) == null) ? super.a(creativeInfo) : adNetworkDiscoveryI.a(creativeInfo);
    }
}
