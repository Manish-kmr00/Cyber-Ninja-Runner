package com.safedk.android.analytics.brandsafety.creatives;

import android.text.TextUtils;
import android.webkit.WebView;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.infos.AdMobCreativeInfo;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SdksMapping;
import com.safedk.android.utils.SimpleConcurrentHashSet;
import com.safedk.android.utils.k;
import com.safedk.android.utils.n;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8078a = "ResourceUrlFilter";
    public static final String b = "attribution.urls";
    public static final String c = "general_exclusion_list";
    public static final String d = "general_inclusion_list";
    public static final String e = "http";
    private static final float i = 1.1f;
    private static final float j = 1.3f;
    private static final String k = "BannerView";
    private static final float l = 6.0f;
    private static final float m = 8.0f;
    private static final int o = 10;
    private static final ConcurrentHashMap<String, String[]> h = b();
    private static final LinkedHashSet<String> n = new LinkedHashSet<>();
    public static int f = 691155085;
    public static int g = 2105362402;
    private static final ConcurrentHashMap<String, a> p = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, String[]> a() {
        return h;
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SimpleConcurrentHashSet<String> f8079a = new SimpleConcurrentHashSet<>();
        SimpleConcurrentHashSet<String> b = new SimpleConcurrentHashSet<>();

        a() {
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            synchronized (this.b) {
                sb.append("networkResources=").append(this.b != null ? this.b.toString() : "null");
            }
            synchronized (this.f8079a) {
                sb.append(", webpageResources=").append(this.f8079a != null ? this.f8079a.toString() : "null");
            }
            return sb.toString();
        }
    }

    private static ConcurrentHashMap<String, String[]> b() {
        ConcurrentHashMap<String, String[]> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(com.safedk.android.utils.h.f8160a, new String[]{".applovin.com", ".applvn.com", ".appl.vn", ".axon.ai"});
        concurrentHashMap.put(com.safedk.android.utils.h.f, new String[]{".supersonicads.com", ".supersonic.com", "streamrail.com", "streamrail.net", "simharif.com", "atom-data.io", "supersonicads-a.akamaihd.net", ".ssacdn.com", ".isprog.com", "unity3d.com", "ironsrc.mobi"});
        concurrentHashMap.put(com.safedk.android.utils.h.d, new String[]{".vungle.com", ".liftoff.com", ".liftoff.io", ".chinaliftoff.io", "liftoff-creatives.io"});
        concurrentHashMap.put("com.unity3d.ads", new String[]{".unity3d.com"});
        concurrentHashMap.put("com.facebook.ads", new String[]{".facebook.com"});
        concurrentHashMap.put(com.safedk.android.utils.h.h, new String[]{".doubleclick.net", ".google.com", ".googlesyndication.com", ".googleadservices.com", ".googleapis.com", ".youtube.com", ".googleusercontent.com", ".gstatic.com", ".googlevideo.com"});
        concurrentHashMap.put(com.safedk.android.utils.h.o, new String[]{"rayjump.com", "mobvista.com", "mintegral.com", "mindworks-creative.com", "mtgglobals.com"});
        concurrentHashMap.put(com.safedk.android.utils.h.b, new String[]{"adcolony.com", "adccache.cn", "adtilt.com", "admarvel.com"});
        concurrentHashMap.put(b, new String[]{POBCommonConstants.PLAY_STORE_DOMAIN, ".appsflyer.com", ".adjust.com", ".singular.net", ".tenjin.io", ".kochava.com", ".tune.com", ".partytrack.it", ".tapstream.com", ".apsalar.com", ".adj.st", ".singular.com", ".sng.link", ".tenjin.com", ".doubleverify.com", ".onelink.me", ".moatads.com", ".moatpixel.com", ".adsafeprotected.com"});
        concurrentHashMap.put(com.safedk.android.utils.h.p, new String[]{".inner-active.mobi", ".inner-active.com", "w3.org"});
        concurrentHashMap.put(com.safedk.android.utils.h.i, new String[]{"inmobicdn.net", "inmobi.com"});
        concurrentHashMap.put(com.safedk.android.utils.h.u, new String[]{"pangle.io", "byteoversea.com", "tiktokcdn.com", "ipstatp.com", "pglstatp.com", "snssdk.com", "pangolin-sdk-toutiao.com", "toutiao.com", "ibytedtos.com"});
        concurrentHashMap.put("com.five_corp.ad", new String[]{"fivecdm.io", "fivecdm.com", "line.me"});
        concurrentHashMap.put(com.safedk.android.utils.h.v, new String[]{"smaato.net"});
        concurrentHashMap.put(com.safedk.android.utils.h.D, new String[]{"moloco.com"});
        concurrentHashMap.put("io.bidmachine", new String[]{"bidmachine.io", "bm-ads.io", "lazybumblebee.com"});
        concurrentHashMap.put(com.safedk.android.utils.h.C, new String[]{"pubnative.net"});
        concurrentHashMap.put(com.safedk.android.utils.h.E, new String[]{"mobilefuse.com"});
        concurrentHashMap.put(com.safedk.android.utils.h.c, new String[]{"chartboost.com"});
        concurrentHashMap.put(com.safedk.android.utils.h.F, new String[]{POBCommonConstants.PUBMATIC_IDENTIFIER_FOR_ERROR_TRACKER_URL});
        concurrentHashMap.put(com.safedk.android.utils.h.A, new String[]{"amazon-adsystem.com"});
        concurrentHashMap.put(c, new String[]{"outcome-cdn.supersonicads.com/", "click-haproxy.supersonicads.com/", "supersonicads.com/pixel", "supersonicads.com/endcardclick", "supersonicads.com/videoimpression", "supersonicads.com/isendcardclick", "supersonicads.com/isvideoimpression", "k.isprog.com", "events.isprog.com", ".simharif.com", "csi.gstatic.com/csi", "googleads.g.doubleclick.net/pagead/conversion", ".applovin.com/imp", ".applovin.com/click", ".applovin.com/interact", com.safedk.android.analytics.brandsafety.creatives.discoveries.c.i, ".applvn.com/imp", ".applvn.com/click", ".applvn.com/interact", ".applvn.com/redirect", "event.inner-active.mobi", "events.inner-active.mobi"});
        concurrentHashMap.put(d, new String[]{"gstatic.com", "googleusercontent.com", "tpc.googlesyndication.com", "/simgad/", "pglstatp.com", "ipstatp.com", "pglstatp-toutiao.com", "pstatp.com", "googleadsserving.cn", "ggpht.com", "ibyteimg.com"});
        return concurrentHashMap;
    }

    public static boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (!a(SdksMapping.getMainSdkPackage(str2), str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        boolean z;
        String[] strArr;
        if (!str2.startsWith("http")) {
            return false;
        }
        String strB = k.b(str2);
        String mainSdkPackage = SdksMapping.getMainSdkPackage(str);
        if (!TextUtils.isEmpty(mainSdkPackage) && (strArr = h.get(mainSdkPackage)) != null) {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                if (!strB.contains(strArr[i2])) {
                    i2++;
                } else {
                    Logger.d(f8078a, "isDspUrlTracking filtering out " + str2);
                    z = true;
                    break;
                }
            }
        } else {
            z = false;
            break;
        }
        String[] strArr2 = h.get(b);
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (strB.contains(str3)) {
                    z = true;
                    break;
                }
            }
        }
        return z ? false : true;
    }

    private static void a(String str, String str2, String str3, Map<String, String> map, List<com.safedk.android.analytics.brandsafety.k> list, boolean z) {
        if (z || a(str, str3, map)) {
            String strY = n.y(str3);
            for (com.safedk.android.analytics.brandsafety.k kVar : list) {
                if (kVar != null) {
                    if (kVar.i() != null && kVar.i().m()) {
                        Logger.d(f8078a, "_NW_ _RESOURCES_ add resource to impression if needed, skip resource for " + str2 + ", type: " + kVar.j + ", package: " + str + ", impression id: " + kVar.j() + ", resource: " + strY);
                    } else {
                        kVar.b(strY);
                        Logger.d(f8078a, "_NW_ _RESOURCES_ add resource to impression if needed, added resource for " + str2 + ", type: " + kVar.j + ", package: " + str + ", impression id: " + kVar.j() + ", resource: " + strY);
                    }
                }
            }
            return;
        }
        if (a(str, str3)) {
            Logger.d(f8078a, "add resource to impression if needed, WebView resource discarded (should not be added to dsp domains). resource = " + str3);
        }
    }

    private static a a(String str) {
        a aVar;
        synchronized (p) {
            aVar = p.get(str);
            if (aVar == null) {
                aVar = new a();
                p.put(str, aVar);
            }
        }
        return aVar;
    }

    private static boolean b(String str, String str2) {
        for (com.safedk.android.analytics.brandsafety.b bVar : SafeDK.getInstance().y().values()) {
            if (bVar != null) {
                List<CreativeInfo> listA = bVar.a(str, str2);
                if (n.a((Collection<?>) listA)) {
                    continue;
                } else {
                    Iterator<CreativeInfo> it = listA.iterator();
                    while (it.hasNext()) {
                        if (it.next().m()) {
                            Logger.d(f8078a, "_RESOURCES_ should stop collecting resource for CI returned true with webViewAddress " + str2 + " is set to not collect resources");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void a(String str, String str2, String str3, Map<String, String> map, boolean z) {
        if (z || a(str, str3, map)) {
            a aVarA = a(str2);
            String strY = n.y(str3);
            if (!b(str, str2)) {
                Logger.d(f8078a, "_NW_ _RESOURCES_ add resource to collection, added resource for " + str2 + ", package: " + str + ", resource: " + strY);
                synchronized (aVarA.b) {
                    aVarA.b.a(strY);
                }
                return;
            }
            Logger.d(f8078a, "_NW_ _RESOURCES_ did not add resource to collection, webViewAddress = " + str2 + ", ci stopCollectingResources is true  for at least one CI , resource = " + strY);
            return;
        }
        if (a(str, str3)) {
            Logger.d(f8078a, "add resource to collection, WebView resource discarded (should not be added to dsp domains). resource = " + str3);
        }
    }

    private static void a(String str, com.safedk.android.analytics.brandsafety.k kVar, WeakReference<WebView> weakReference, List<String> list, boolean z) {
        WebView webView;
        String strA;
        try {
            ArrayList arrayList = new ArrayList();
            for (String str2 : list) {
                if (z || a(str, str2, (Map<String, String>) null)) {
                    arrayList.add(n.y(str2));
                }
            }
            if (!arrayList.isEmpty()) {
                if (kVar != null) {
                    if (kVar.v) {
                        synchronized (kVar.p) {
                            kVar.p.a(arrayList);
                            Logger.d(f8078a, "_JS_ _RESOURCES_ adding " + arrayList.size() + " expanded webpage resources, type: " + kVar.j + ", package: " + str + ", impression id: " + kVar.j());
                        }
                        return;
                    } else {
                        synchronized (kVar.n) {
                            kVar.n.a(arrayList);
                            Logger.d(f8078a, "_JS_ _RESOURCES_ adding " + arrayList.size() + " webpage resources, type: " + kVar.j + ", package: " + str + ", impression id: " + kVar.j());
                        }
                        return;
                    }
                }
                if (weakReference != null && weakReference.get() != null && (webView = weakReference.get()) != null && (strA = BrandSafetyUtils.a((Object) webView)) != null) {
                    a aVarA = a(strA);
                    synchronized (aVarA.f8079a) {
                        aVarA.f8079a.a(arrayList);
                    }
                    return;
                }
                return;
                Logger.e(f8078a, "Exception: " + th.getMessage(), th);
            }
        } catch (Throwable th) {
            Logger.e(f8078a, "Exception: " + th.getMessage(), th);
        }
    }

    private static void a(String str, WebView webView, String str2, Map<String, String> map, com.safedk.android.analytics.brandsafety.a aVar) {
        try {
            boolean zA = a(str, str2, map);
            if (zA && zA) {
                String strA = BrandSafetyUtils.a((Object) webView);
                Logger.d(f8078a, "_NW_ _RESOURCES_ add resource to collection started, current resource: " + str2 + " for " + strA + " is resource: " + zA);
                String strY = n.y(str2);
                if (!b(str, strA)) {
                    com.safedk.android.analytics.brandsafety.c cVarB = null;
                    if (aVar != null) {
                        cVarB = aVar.b(strA);
                    }
                    if (cVarB != null) {
                        com.safedk.android.analytics.brandsafety.k kVarI = cVarB.i();
                        if (kVarI != null) {
                            if (kVarI.v) {
                                Logger.d(f8078a, "_NW_ _RESOURCES_ add expanded resource to collection, added resource " + strY + " into " + strA);
                                synchronized (kVarI.q) {
                                    kVarI.q.a(strY);
                                }
                                return;
                            }
                            synchronized (kVarI.o) {
                                kVarI.o.a(strY);
                            }
                            return;
                        }
                        return;
                    }
                    a aVarA = a(strA);
                    synchronized (aVarA.b) {
                        aVarA.b.a(strY);
                    }
                    return;
                    Logger.e(f8078a, "Exception: " + th.getMessage(), th);
                }
            }
        } catch (Throwable th) {
            Logger.e(f8078a, "Exception: " + th.getMessage(), th);
        }
    }

    private static void a(String str, com.safedk.android.analytics.brandsafety.k kVar, WeakReference<WebView> weakReference, List<String> list) {
        if (kVar != null) {
            try {
                synchronized (kVar.r) {
                    kVar.r.a(list);
                    Logger.d(f8078a, "_JS_ _RESOURCES_ adding " + list.size() + " hidden webpage resources, type: " + kVar.j + ", package: " + str + ", impression id: " + kVar.j());
                }
            } catch (Throwable th) {
                Logger.e(f8078a, "Exception: " + th.getMessage(), th);
            }
        }
    }

    public static void a(List<WeakReference<WebView>> list, com.safedk.android.analytics.brandsafety.c cVar) {
        String strA;
        a aVarA;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (WeakReference<WebView> weakReference : list) {
                        if (n.a((Reference<?>) weakReference) && (strA = BrandSafetyUtils.a((Object) weakReference.get())) != null && (aVarA = a(strA)) != null) {
                            com.safedk.android.analytics.brandsafety.k kVarI = cVar.i();
                            p.remove(strA);
                            SimpleConcurrentHashSet<String> simpleConcurrentHashSet = aVarA.b;
                            if (simpleConcurrentHashSet != null && !simpleConcurrentHashSet.isEmpty()) {
                                Logger.d(f8078a, "_NW_ _RESOURCES_ propagate network resources, shouldStopCollectingResources=" + (kVarI.i() != null ? Boolean.valueOf(kVarI.i().m()) : null));
                                if (kVarI.i() != null && kVarI.i().m()) {
                                    Logger.d(f8078a, "_NW_ _RESOURCES_ propagate network resources, skip " + simpleConcurrentHashSet.size() + " resources for " + strA + ", type: " + kVarI.j + ", package: " + cVar.c() + ", impression id: " + kVarI.j());
                                } else {
                                    Logger.d(f8078a, "_NW_ _RESOURCES_ propagate network resources, adding " + simpleConcurrentHashSet.size() + " resources to collection for " + strA + ", type: " + kVarI.j + ", package: " + cVar.c() + ", impression id: " + kVarI.j());
                                    synchronized (kVarI.o) {
                                        kVarI.o.putAll(simpleConcurrentHashSet);
                                    }
                                }
                            }
                            SimpleConcurrentHashSet<String> simpleConcurrentHashSet2 = aVarA.f8079a;
                            if (simpleConcurrentHashSet2 != null && !simpleConcurrentHashSet2.isEmpty()) {
                                if (kVarI.i() != null && kVarI.i().m()) {
                                    Logger.d(f8078a, "_JS_ _RESOURCES_ propagate webpage resources, skip " + simpleConcurrentHashSet2.size() + " resources for " + strA + ", type: " + kVarI.j + ", package: " + cVar.c() + ", impression id: " + kVarI.j());
                                } else {
                                    Logger.d(f8078a, "_JS_ _RESOURCES_ propagate webpage resources, adding " + simpleConcurrentHashSet2.size() + " resources to collection for " + strA + ", type: " + kVarI.j + ", package: " + cVar.c() + ", impression id: " + kVarI.j());
                                    synchronized (kVarI.n) {
                                        kVarI.n.putAll(simpleConcurrentHashSet2);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.d(f8078a, "caught exception: ", th);
            }
        }
    }

    public static void a(List<WeakReference<WebView>> list) {
        String strA;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (WeakReference<WebView> weakReference : list) {
                        if (weakReference.get() != null && (strA = BrandSafetyUtils.a((Object) weakReference.get())) != null) {
                            p.remove(strA);
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.d(f8078a, "caught exception: ", th);
            }
        }
    }

    public static void a(String str, String str2, WeakReference<WebView> weakReference, String str3, List<String> list, boolean z, Boolean bool, Boolean bool2, List<String> list2) {
        String mainSdkPackage;
        boolean z2;
        boolean zBooleanValue;
        boolean zBooleanValue2 = false;
        if (SafeDK.getInstance() != null && SafeDK.ac() && (mainSdkPackage = SdksMapping.getMainSdkPackage(str)) != null) {
            com.safedk.android.analytics.brandsafety.c cVarK = null;
            if (!TextUtils.isEmpty(str3)) {
                cVarK = BrandSafetyUtils.j(str3);
            }
            if (cVarK == null) {
                Logger.d(f8078a, "no info object found by event id: " + str3);
                cVarK = BrandSafetyUtils.k(str2);
                z2 = true;
            } else {
                z2 = false;
            }
            if (cVarK != null) {
                String strW = cVarK.w();
                com.safedk.android.analytics.brandsafety.k kVarI = cVarK.i();
                if (kVarI != null) {
                    if (z2) {
                        kVarI.w = 1;
                    }
                    if (strW != null && strW.equals(str3)) {
                        if (bool != null) {
                            if (kVarI.m == null) {
                                zBooleanValue = bool.booleanValue();
                            } else {
                                zBooleanValue = kVarI.m.booleanValue() || bool.booleanValue();
                            }
                            kVarI.m = Boolean.valueOf(zBooleanValue);
                        }
                        if (bool2 != null) {
                            if (kVarI.x == null) {
                                zBooleanValue2 = bool2.booleanValue();
                            } else if (kVarI.x.booleanValue() || bool2.booleanValue()) {
                                zBooleanValue2 = true;
                            }
                            kVarI.x = Boolean.valueOf(zBooleanValue2);
                        }
                        if (kVarI.i() != null && kVarI.i().m()) {
                            n.b(f8078a, "_NW_ _RESOURCES_ handle resources collected, skip resource for " + str2 + ", type: " + kVarI.j + ", package: " + mainSdkPackage + ", impression id: " + kVarI.j() + ", resources: " + z);
                            return;
                        }
                        if (list != null) {
                            a(mainSdkPackage, kVarI, weakReference, list, z);
                        }
                        if (list2 != null) {
                            a(mainSdkPackage, kVarI, weakReference, list2);
                            return;
                        }
                        return;
                    }
                    Logger.d(f8078a, "event ids don't match. current = " + strW + " js: " + str3);
                    kVarI.w += 2;
                }
            }
        }
    }

    public static void a(String str, WebView webView, String str2, Map<String, String> map) {
        List<com.safedk.android.analytics.brandsafety.k> list;
        if (webView != null && SafeDK.ac()) {
            String strA = BrandSafetyUtils.a((Object) webView);
            String mainSdkPackage = SdksMapping.getMainSdkPackage(str);
            boolean zA = CreativeInfoManager.a(mainSdkPackage, AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, false);
            Logger.d(f8078a, "handle resource url " + mainSdkPackage + " on webview " + strA + ", resource " + str2 + ", headers = " + map + ", supportsMrecMonitoring = " + zA + ", webview = " + webView + ", getMaxAdViewFromChildView : " + n.c(webView) + ", isMrecWebView = " + n.a(webView));
            if (!zA && (n.b(webView.getWidth(), webView.getHeight()) || n.a(webView))) {
                Logger.d(f8078a, "handle resource url - ignoring url " + str2 + ",  supportsMrecMonitoring = " + zA + ", webview = " + webView + ", isMrecWebView =  " + n.a(webView) + " , isMrecRatio = " + n.b(webView.getWidth(), webView.getHeight()));
                b(Arrays.asList(strA));
                return;
            }
            Iterator<com.safedk.android.analytics.brandsafety.b> it = SafeDK.getInstance().y().values().iterator();
            BrandSafetyUtils.AdType adType = null;
            BrandSafetyUtils.AdType adType2 = null;
            List<com.safedk.android.analytics.brandsafety.k> listH = null;
            while (true) {
                if (!it.hasNext()) {
                    list = listH;
                    break;
                }
                com.safedk.android.analytics.brandsafety.b next = it.next();
                if (next != null) {
                    com.safedk.android.analytics.brandsafety.c cVarB = next.b(strA);
                    if (adType == null && cVarB != null) {
                        adType = cVarB.p;
                    }
                    if (next.b(mainSdkPackage, strA, str2)) {
                        Logger.d(f8078a, "handle resource url - skip redirect URL and stop collecting resources: " + str2 + " for " + strA + ", type=" + next.a());
                        return;
                    }
                    com.safedk.android.analytics.brandsafety.c cVarC = cVarB == null ? next.c(strA) : cVarB;
                    if (cVarC != null) {
                        listH = cVarC.h();
                        adType2 = cVarC.p;
                    }
                    if (listH != null && !listH.isEmpty()) {
                        Logger.d(f8078a, "handle resource url found " + listH.size() + " " + adType2 + " impressions for webview " + strA);
                        list = listH;
                        break;
                    }
                }
                adType = adType;
                adType2 = adType2;
            }
            if (str2.startsWith("text:") && !com.safedk.android.utils.a.a(mainSdkPackage)) {
                Logger.d(f8078a, "handle resource url, sdk " + mainSdkPackage + " does not support banner monitoring, skipping text resources");
                return;
            }
            BrandSafetyUtils.AdType adTypeA = com.safedk.android.analytics.brandsafety.b.a(mainSdkPackage, webView);
            if (list != null && !list.isEmpty()) {
                boolean zIsInterstitialActivity = com.safedk.android.internal.b.getInstance().isInterstitialActivity(webView.getContext());
                if (str2.startsWith("text:") && (adType2 == BrandSafetyUtils.AdType.INTERSTITIAL || adTypeA == BrandSafetyUtils.AdType.INTERSTITIAL)) {
                    Logger.d(f8078a, "handle resource url, skipping text resource for interstitial " + mainSdkPackage + " on webview " + strA + ", resource " + str2 + ", interstitial activity = " + zIsInterstitialActivity);
                    return;
                } else {
                    a(mainSdkPackage, strA, str2, map, list, false);
                    return;
                }
            }
            a(mainSdkPackage, strA, str2, map, false);
        }
    }

    public static void b(List<String> list) {
        a aVarRemove;
        if (list != null) {
            synchronized (list) {
                for (String str : list) {
                    if (str != null && (aVarRemove = p.remove(str)) != null) {
                        Logger.d(f8078a, "clearing for " + str + " succeeded, " + aVarRemove.f8079a.size() + " webpageResources removed, " + aVarRemove.b.size() + " networkResourcess removed");
                    }
                }
            }
        }
    }

    public static void a(String str, String str2, com.safedk.android.analytics.brandsafety.k kVar) {
        AdNetworkDiscovery adNetworkDiscoveryI;
        if (str2 != null && kVar != null && (adNetworkDiscoveryI = CreativeInfoManager.i(str)) != null) {
            adNetworkDiscoveryI.q(str2).add(str2);
        }
    }

    public static void a(String str, WebView webView, String str2, String str3, Map<String, String> map) {
        if (webView != null) {
            String strA = BrandSafetyUtils.a((Object) webView);
            String mainSdkPackage = SdksMapping.getMainSdkPackage(str);
            boolean zA = CreativeInfoManager.a(mainSdkPackage, AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, false);
            Logger.d(f8078a, "handle resource url " + mainSdkPackage + " on webview " + strA + ", context: " + webView.getContext() + " resource: " + str2 + " size: " + webView.getWidth() + StringUtils.COMMA + webView.getHeight() + ", webView id: " + Integer.toHexString(webView.getId()) + ", headers: " + map + ", supportsMrecMonitoring = " + zA + ", webview = " + webView + ", getMaxAdViewFromChildView : " + n.c(webView) + ", isMrecWebView = " + n.a(webView));
            if (!zA && (n.b(webView.getWidth(), webView.getHeight()) || n.a(webView))) {
                Logger.d(f8078a, "handle resource url - ignoring url " + str2 + ",  supportsMrecMonitoring = " + zA + ", webview = " + webView + ", isMrecWebView =  " + n.a(webView) + " , isMrecRatio = " + n.b(webView.getWidth(), webView.getHeight()));
                b(Arrays.asList(strA));
                return;
            }
            if (map != null) {
                Logger.d(f8078a, "handle resource url - headers: " + map);
            }
            boolean zIsInterstitialActivity = com.safedk.android.internal.b.getInstance().isInterstitialActivity(webView.getContext());
            BrandSafetyUtils.AdType adTypeA = com.safedk.android.analytics.brandsafety.b.a(mainSdkPackage, webView);
            Logger.d(f8078a, "handle resource url - interstitial activity: " + zIsInterstitialActivity + " adType: " + adTypeA);
            if (!zIsInterstitialActivity && (adTypeA == BrandSafetyUtils.AdType.MREC || adTypeA == BrandSafetyUtils.AdType.BANNER)) {
                if (!com.safedk.android.utils.a.a(mainSdkPackage)) {
                    Logger.d(f8078a, "Sdk " + mainSdkPackage + " does not support banner monitoring, skipping");
                    return;
                }
                if (!"com.unity3d.ads".equals(mainSdkPackage) || !webView.getContext().toString().contains("UnityPlayerActivity")) {
                    if (com.safedk.android.utils.h.p.equals(mainSdkPackage)) {
                        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(mainSdkPackage);
                        if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.g().containsKey(Integer.valueOf(webView.getId()))) {
                            return;
                        }
                    } else {
                        Logger.d(f8078a, strA + " will be added to Webview address list");
                        n.add(strA);
                    }
                    boolean zA2 = a(webView);
                    Logger.d(f8078a, "webview context: " + webView.getContext() + " size: " + webView.getWidth() + StringUtils.COMMA + webView.getHeight() + ", interstitial: " + zA2);
                    if (!zA2) {
                        Logger.d(f8078a, "handle resource url - no interstitial, skipping");
                        return;
                    }
                } else {
                    return;
                }
            }
            if (a(mainSdkPackage, str2, map)) {
                com.safedk.android.analytics.brandsafety.a aVarA = null;
                if (adTypeA != null) {
                    aVarA = SafeDK.getInstance().a(adTypeA);
                }
                a(mainSdkPackage, webView, str2, map, aVarA);
            }
        }
    }

    public static boolean a(String str, String str2, Map<String, String> map) {
        return n.a(str2, map) || c(str, str2);
    }

    private static boolean c(String str, String str2) {
        if (!SdksMapping.getMainSdkPackage(str).equals("com.unity3d.ads")) {
            return false;
        }
        boolean zA = AdMobCreativeInfo.a(str2);
        if (zA) {
            Logger.d(f8078a, "admob known domain url = " + str2);
            return zA;
        }
        return zA;
    }

    public static boolean a(WebView webView) {
        try {
            float width = webView.getWidth();
            float height = webView.getHeight();
            if (height <= 0.0f) {
                return true;
            }
            float f2 = width / height;
            Logger.d(f8078a, "interstitial webView proportions : " + f2);
            return (((f2 > i ? 1 : (f2 == i ? 0 : -1)) >= 0 && (f2 > j ? 1 : (f2 == j ? 0 : -1)) <= 0) || ((f2 > l ? 1 : (f2 == l ? 0 : -1)) >= 0 && (f2 > 8.0f ? 1 : (f2 == 8.0f ? 0 : -1)) <= 0)) ? false : true;
        } catch (Throwable th) {
            Logger.d(f8078a, "Exception in interstitial webView proportions : " + th.getMessage(), th);
            return true;
        }
    }
}
