package com.safedk.android.analytics.brandsafety;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import com.adjust.sdk.Constants;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.json.b9;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.AppLovinBridge;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.StatsReporter;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.ScreenshotHelper;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.analytics.events.RedirectEvent;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.utils.LinkedHashSetWithItemLimit;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.PersistentConcurrentHashMap;
import com.safedk.android.utils.SdksMapping;
import com.yandex.div.core.timer.TimerController;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class BannerFinder extends com.safedk.android.analytics.brandsafety.b {
    protected static final int G = 5;
    protected static final long H = 1000;
    protected static final long I = 500;
    protected static final long L = 10;
    protected final LinkedHashSetWithItemLimit<String> M;
    private final List<u> R;
    private final HashSet<d> T;
    private final Set<String> U;
    protected static final Map<d, e> J = new ConcurrentHashMap();
    protected static final Map<String, List<o>> K = new ConcurrentHashMap();
    private static h O = null;
    private static final Map<String, List<WeakReference<MaxAdView>>> P = new ConcurrentHashMap();
    private static final Map<String, BrandSafetyUtils.AdType> Q = new ConcurrentHashMap();
    private static final Map<String, d> S = new ConcurrentHashMap();
    protected static Map<String, RedirectData> N = null;

    public static Map<String, BrandSafetyUtils.AdType> f() {
        return Q;
    }

    public Set<String> i() {
        return this.U;
    }

    public BannerFinder(int maxAttemptsToCaptureImage) {
        super(BrandSafetyUtils.AdType.BANNER, Arrays.asList("BANNER", BrandSafetyUtils.n), "BannerFinder", maxAttemptsToCaptureImage);
        this.R = new ArrayList();
        this.T = new HashSet<>();
        this.U = new HashSet();
        this.M = new LinkedHashSetWithItemLimit<>(10L);
        l();
    }

    protected BannerFinder(BrandSafetyUtils.AdType adType, List<String> supportedAdFormats, String logTag, int maxAttemptsToCaptureImage) {
        super(adType, supportedAdFormats, logTag, maxAttemptsToCaptureImage);
        this.R = new ArrayList();
        this.T = new HashSet<>();
        this.U = new HashSet();
        this.M = new LinkedHashSetWithItemLimit<>(10L);
    }

    private static void l() {
        e eVar;
        N = new PersistentConcurrentHashMap("SafeDKRedirects." + com.safedk.android.utils.n.a(SafeDK.getInstance().m()));
        Logger.d("BannerFinder", "handle saved redirects from previous session, found " + N.size() + " redirects, isOnUiThread = " + com.safedk.android.utils.n.c());
        ArrayList arrayList = new ArrayList();
        for (String str : N.keySet()) {
            RedirectData redirectData = N.get(str);
            if (redirectData != null && (redirectData.i || redirectData.j)) {
                redirectData.a("UnmatchedRedirectWebview=" + str);
                if (redirectData.t == BrandSafetyEvent.AdFormatType.MREC) {
                    eVar = new r(redirectData.r, redirectData.s);
                } else {
                    if (redirectData.t == null) {
                        redirectData.t = BrandSafetyEvent.AdFormatType.BANNER;
                        redirectData.a("UnmatchedRedirectFallback=BANNER");
                    }
                    eVar = new e(redirectData.r, redirectData.s);
                }
                eVar.a(F.get(str));
                BrandSafetyEvent brandSafetyEventA = a(eVar, new k(redirectData), true, false, Long.MAX_VALUE, (String) null);
                brandSafetyEventA.c(true);
                brandSafetyEventA.a(SafeDK.getInstance().e());
                arrayList.add(brandSafetyEventA);
            }
        }
        if (StatsCollector.c() != null) {
            StatsCollector.c().a(arrayList);
            N.clear();
        } else {
            Logger.w("BannerFinder", "handle saved redirects from previous session, cannot report brand safety event");
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b
    protected c a(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5) {
        return new e(str, str2, str3, screenShotOrientation, str4, str5);
    }

    protected e a(Activity activity, String str, int i, String str2, Bundle bundle, String str3) {
        e eVar = new e(a(com.safedk.android.internal.b.getInstance().getForegroundActivity()), str, i, str2, bundle, str3);
        eVar.af = new WeakReference<>(activity);
        return eVar;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage message) {
        String string;
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p() && SafeDK.getInstance() != null && SafeDK.getInstance().q()) {
            Bundle messageData = message.getMessageData();
            if (messageData.containsKey("revenue_event") && messageData.containsKey("ad_format") && this.b.contains(messageData.getString("ad_format"))) {
                Logger.d(this.f8026a, "Revenue event detected : " + messageData);
                string = "revenue_event";
            } else {
                string = messageData.getString("type");
            }
            String string2 = messageData.getString("ad_format");
            String string3 = messageData.getString(BrandSafetyEvent.k);
            String string4 = messageData.getString(BrandSafetyEvent.l);
            String string5 = messageData.getString("id", null);
            if (string5 == null) {
                Logger.d(this.f8026a, "No eventId in data bundle, cannot match");
            }
            String string6 = messageData.getString(BrandSafetyEvent.ad);
            String strB = CreativeInfoManager.b(string6);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jB = com.safedk.android.utils.n.b(jCurrentTimeMillis);
            String string7 = null;
            if (messageData.containsKey("creative_id")) {
                string7 = messageData.getString("creative_id");
            }
            if (this.b.contains(string2)) {
                Logger.d(this.f8026a, "Max message received, package: " + strB + ", ts (seconds): " + jB + ", message received: " + message.getMessageData() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                d dVar = new d(string4, string3, string5, strB, string6, BrandSafetyUtils.b(string2));
                if ("WILL_DISPLAY".equals(string)) {
                    if (strB != null && f(string6, strB)) {
                        Logger.d(this.f8026a, "WILL_DISPLAY event for package=" + strB + " banner key=" + dVar + ", slot count=" + this.d);
                        CreativeInfoManager.a(strB, string3, string7, string5, string2);
                        a(string5, l.f, new l.a(l.L, BrandSafetyUtils.n(messageData.getString("ad_view"))));
                    }
                    a(string6, strB, string7, dVar, messageData, jCurrentTimeMillis);
                    return;
                }
                if ("revenue_event".equals(string)) {
                    if (strB != null && f(string6, strB)) {
                        Logger.d(this.f8026a, "REVENUE_EVENT event for package=" + strB + " banner key=" + dVar + ", slot count=" + this.d);
                        a(string5, l.k, new l.a("typ", messageData.getString("revenue_event")));
                    }
                    a(string6, strB, string7, dVar, messageData);
                    return;
                }
                if ("DID_CLICKED".equals(string)) {
                    if (f(string6, strB)) {
                        e eVar = J.get(dVar);
                        Logger.d(this.f8026a, "DID_CLICKED event currentActivityBanner = " + eVar);
                        a(string5, l.h, new l.a[0]);
                        if (eVar != null) {
                            String str = this.f8026a;
                            StringBuilder sbAppend = new StringBuilder().append("DID_CLICKED event for package=");
                            if (strB != null) {
                                string6 = strB;
                            }
                            Logger.d(str, sbAppend.append(string6).append(", slot count=").append(this.d).toString());
                            d(dVar);
                            return;
                        }
                        Logger.d(this.f8026a, "DID_CLICKED event cannot find banner key " + dVar);
                        return;
                    }
                    return;
                }
                if ("WILL_LOAD".equals(string)) {
                    if (strB != null && f(string6, strB)) {
                        Logger.d(this.f8026a, "WILL_LOAD event for package=" + strB + " banner key=" + dVar + ", slot count=" + this.d);
                        a(string5, l.d, new l.a(l.N, string6));
                        return;
                    }
                    return;
                }
                if ("DID_HIDE".equals(string)) {
                    if (strB != null && f(string6, strB)) {
                        Logger.d(this.f8026a, "DID_HIDE event for package=" + strB + " banner key=" + dVar + ", slot count=" + this.d);
                        a(string5, l.i, new l.a[0]);
                        c(dVar);
                        return;
                    }
                    return;
                }
                if ("DID_LOAD".equals(string)) {
                    if (strB != null && f(string6, strB)) {
                        Logger.d(this.f8026a, "DID_LOAD event for package=" + strB + " banner key=" + dVar + ", slot count=" + this.d);
                        a(string5, l.e, new l.a(l.N, string6));
                        return;
                    }
                    return;
                }
                if ("DID_DISPLAY".equals(string)) {
                    if (strB != null && f(string6, strB)) {
                        Logger.d(this.f8026a, "DID_DISPLAY event for package=" + strB + " banner key=" + dVar + ", slot count=" + this.d);
                        a(string5, l.g, new l.a[0]);
                        a(strB, dVar, string7, messageData, jCurrentTimeMillis);
                        return;
                    }
                    return;
                }
                if ("DID_FAIL_DISPLAY".equals(string) && strB != null && f(string6, strB)) {
                    Logger.d(this.f8026a, "DID_FAIL_DISPLAY event for package=" + strB + " banner key=" + dVar + ", slot count=" + this.d);
                    a(string5, l.j, new l.a[0]);
                    a(dVar);
                }
            }
        }
    }

    private void a(d dVar) {
        e eVar = J.get(dVar);
        if (eVar != null) {
            eVar.N = true;
        }
    }

    public boolean l(String str) {
        Set<d> setKeySet;
        if (str != null) {
            synchronized (J) {
                setKeySet = J.keySet();
            }
            if (!setKeySet.isEmpty()) {
                Iterator<d> it = setKeySet.iterator();
                while (it.hasNext()) {
                    e eVar = J.get(it.next());
                    Logger.d(this.f8026a, "is banner web view address: banner view: " + eVar.K + " given address: " + str + " view hierarchy: " + eVar.m);
                    if ((eVar.K != null && str.equals(eVar.K)) || (eVar.m != null && eVar.m.contains(str))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7971a;
        String b;
        String c;
        d d;
        Bundle e;
        int f = 0;
        int g = 0;
        ScheduledFuture<?> h;

        public b(String str, String str2, d dVar, Bundle bundle) {
            this.f7971a = dVar.e;
            this.b = str;
            this.c = str2;
            this.d = dVar;
            this.e = bundle;
            Logger.d(BannerFinder.this.f8026a, "web view scanner created, networkName = " + this.f7971a + ", packageName = " + str + ", maxCreativeId = " + str2 + ", adInfoKey = " + dVar + ", applovinData = " + bundle + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            int i;
            c cVar = null;
            try {
                boolean zA = CreativeInfoManager.a(this.b, AdNetworkConfiguration.SHOULD_DELAY_BANNER_VIEWS_SCANNER, false);
                boolean z2 = (SafeDK.getInstance() == null || SafeDK.getInstance().z() == null || !SafeDK.getInstance().z().f()) ? false : true;
                if (zA && z2) {
                    Logger.d(BannerFinder.this.f8026a, "web view scanner - fullscreen ad is displaying, postpone scanning. sdk= " + this.b);
                    return;
                }
                String string = this.e.getString("ad_view");
                e eVar = BannerFinder.J.get(this.d);
                if (eVar != null) {
                    if (eVar.aa) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        if (!BannerFinder.this.a(this.b, this.c, this.d, string, arrayList, arrayList2, arrayList3).booleanValue()) {
                            Logger.d(BannerFinder.this.f8026a, "web view scanner - wvscanner - cancel task, eventId:" + this.d.c + ", scanCounter: " + this.f + ", banner impression not found for adNetworkView: " + string);
                            BannerFinder.this.a(this.d, this.h);
                            return;
                        }
                        for (String str : arrayList2) {
                            if (CreativeInfoManager.d.remove(str)) {
                                Logger.d(BannerFinder.this.f8026a, "web view scanner - video start received for " + str);
                                eVar.i().l = true;
                                break;
                            }
                        }
                        boolean z3 = false;
                        if (arrayList.isEmpty() && eVar.K == null) {
                            this.f++;
                            Logger.d(BannerFinder.this.f8026a, "web view scanner - failed to find view, scan counter: " + this.f + " view address:" + eVar.K);
                            z = false;
                        } else if (arrayList.isEmpty()) {
                            z = false;
                        } else {
                            this.f++;
                            Logger.d(BannerFinder.this.f8026a, "web view scanner - found view, scan counter: " + this.f + " view address:" + eVar.K);
                            BannerFinder.this.a(this.d, arrayList);
                            WeakReference weakReferenceD = BannerFinder.this.d(arrayList);
                            String strA = com.safedk.android.utils.n.a((Reference<?>) weakReferenceD) ? BrandSafetyUtils.a(weakReferenceD.get()) : null;
                            Logger.d(BannerFinder.this.f8026a, "web view scanner - adInfoKey.webviewAddress: " + this.d.g + ", adInfoKey.isWebviewReplaced: " + this.d.i);
                            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(eVar.v);
                            com.safedk.android.analytics.brandsafety.creatives.b bVarJ = CreativeInfoManager.j(this.b);
                            boolean z4 = weakReferenceD.get() instanceof WebView;
                            if ((this.d.g == null || this.d.i) && com.safedk.android.utils.n.a((Reference<?>) weakReferenceD)) {
                                this.d.g = BrandSafetyUtils.a(weakReferenceD.get());
                                Logger.d(BannerFinder.this.f8026a, "web view scanner - info: " + eVar);
                                if (eVar.K == null) {
                                    com.safedk.android.analytics.brandsafety.b.a(this.d.g, l.l, new l.a(l.L, strA));
                                    eVar.K = strA;
                                }
                                if (z4 && adNetworkDiscoveryI != null && bVarJ != null && bVarJ.b(AdNetworkConfiguration.MATCH_ON_BANNER_WEBVIEW_DETECTION)) {
                                    BrandSafetyUtils.AdType adTypeA = com.safedk.android.analytics.brandsafety.b.a(this.b, (WebView) weakReferenceD.get());
                                    CreativeInfo creativeInfoA = adNetworkDiscoveryI.a((Object) eVar.i().o);
                                    if (creativeInfoA != null && adTypeA == BrandSafetyUtils.AdType.BANNER) {
                                        creativeInfoA.a(BrandSafetyEvent.AdFormatType.BANNER);
                                        creativeInfoA.a(BrandSafetyUtils.AdType.BANNER);
                                        if (creativeInfoA.h() != null && creativeInfoA.h().contains("mraid")) {
                                            creativeInfoA.V();
                                        }
                                    }
                                }
                            }
                            boolean zF = BannerFinder.this.f(this.f7971a, this.b);
                            if (this.b != null && zF) {
                                if (adNetworkDiscoveryI != null) {
                                    adNetworkDiscoveryI.a(eVar, arrayList2, string);
                                }
                                eVar.a(arrayList2);
                                List<WeakReference<WebView>> listB = BannerFinder.this.b(arrayList);
                                if (BannerFinder.this.R != null && BannerFinder.this.R.size() > 0 && listB != null && listB.size() > 0) {
                                    Iterator it = BannerFinder.this.R.iterator();
                                    while (it.hasNext()) {
                                        ((u) it.next()).a(listB.get(0));
                                    }
                                }
                                eVar.b(listB);
                                if (com.safedk.android.utils.n.a((Reference<?>) weakReferenceD)) {
                                    boolean zA2 = CreativeInfoManager.a(this.b, AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false);
                                    boolean zH = eVar.H();
                                    Logger.d(BannerFinder.this.f8026a, "web view scanner - should detect multiple ads by web view change? " + zA2 + ", isNativeAd = " + zH);
                                    String strA2 = BrandSafetyUtils.a(weakReferenceD.get());
                                    if (!zH && zA2 && eVar.K != null && !eVar.K.equals(strA2)) {
                                        Logger.d(BannerFinder.this.f8026a, "web view scanner - webview change starts for maxCreativeId: " + this.c);
                                        com.safedk.android.analytics.brandsafety.b.a(strA2, l.l, new l.a(l.L, strA));
                                        z3 = true;
                                        BannerFinder.this.a(eVar, strA2);
                                    }
                                }
                                z = z3;
                                Logger.d(BannerFinder.this.f8026a, "web view scanner - setting taskFuture for adInfoKey: " + this.d);
                                eVar.ae = this.h;
                                if (com.safedk.android.utils.n.a((Reference<?>) weakReferenceD)) {
                                    BannerFinder.this.a(eVar, (WeakReference<View>) weakReferenceD);
                                    BannerFinder.this.a(this.b, this.c, this.d, (WeakReference<View>) weakReferenceD);
                                    if (CreativeInfoManager.a(this.b, AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, false) && eVar.j() == null) {
                                        Logger.d(BannerFinder.this.f8026a, "web view scanner - keep scanning until we have a match. scan counter: " + this.f + ", activity banner key: " + this.d);
                                    }
                                }
                            } else {
                                if (this.h != null) {
                                    Logger.d(BannerFinder.this.f8026a, "web view scanner - cancel task, packageName: " + this.b + ", shouldHandleMaxMsg: " + zF);
                                    BannerFinder.this.a(this.d, this.h);
                                }
                                z = false;
                            }
                        }
                        if (!z) {
                            Logger.d(BannerFinder.this.f8026a, "web view scanner - calling reportCompletedBanners");
                            BannerFinder.this.a(arrayList, arrayList3, this.d, eVar.ai);
                        } else {
                            Logger.d(BannerFinder.this.f8026a, "web view scanner - not calling reportCompletedBanners");
                        }
                        if (BannerFinder.this.a(eVar, arrayList2, this.d).booleanValue()) {
                            List list = (List) BannerFinder.P.get(this.d.f8095a);
                            String strN = BrandSafetyUtils.n(string);
                            if (list != null && list.size() == 1 && !TextUtils.isEmpty(strN)) {
                                com.safedk.android.analytics.brandsafety.creatives.g.a(arrayList3, eVar);
                            } else {
                                Logger.d(BannerFinder.this.f8026a, "web view scanner - shouldn't be here, adding debug info...");
                                if (list == null) {
                                    i = 1;
                                } else if (list.size() == 1) {
                                    i = 0;
                                } else {
                                    i = 2;
                                }
                                if (TextUtils.isEmpty(strN)) {
                                    i += 4;
                                }
                                if (i > 0) {
                                    eVar.d("rpr" + i);
                                }
                            }
                        } else {
                            Logger.d(BannerFinder.this.f8026a, "web view scanner - matching webview not in current hierarchy - skipping resources propagation");
                        }
                        if (arrayList3 != null && arrayList3.size() > 0) {
                            BannerFinder.this.a(eVar, (WeakReference<WebView>) arrayList3.get(0), this.g);
                        }
                    }
                    boolean z5 = this.f >= 5 && a() && b();
                    if ((!eVar.aa || z5) && this.h != null) {
                        Logger.d(BannerFinder.this.f8026a, "web view scanner - cancel task, is active: " + eVar.aa + ", scan counter: " + this.f + ", event ID: " + eVar.w());
                        BannerFinder.this.a(eVar, false, "WebviewScannerTask");
                        BannerFinder.this.a(this.d, this.h);
                    }
                    this.g++;
                }
            } catch (Exception e) {
                Logger.e(BannerFinder.this.f8026a, "web view scanner - exception", e);
                if (0 != 0) {
                    cVar.d("wvste=" + e.getMessage());
                }
            }
        }

        private boolean a() {
            List<Integer> listC = com.safedk.android.internal.d.C();
            return listC == null || listC.isEmpty() || this.g >= listC.get(listC.size() + (-1)).intValue();
        }

        private boolean b() {
            List<Integer> listE = com.safedk.android.internal.d.E();
            return listE == null || listE.isEmpty() || this.g >= listE.get(listE.size() + (-1)).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, WeakReference<WebView> weakReference, int i) {
        String strB;
        boolean zContains = com.safedk.android.internal.d.C().contains(Integer.valueOf(i));
        boolean zContains2 = com.safedk.android.internal.d.E().contains(Integer.valueOf(i));
        if (zContains || zContains2) {
            Logger.d(this.f8026a, "inject periodic script, cycle: " + i);
            String str = eVar.v;
            if (CreativeInfoManager.i(str) != null && com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                com.safedk.android.analytics.brandsafety.creatives.b bVarJ = CreativeInfoManager.j(str);
                String strA = BrandSafetyUtils.a((Object) weakReference.get());
                if (!(weakReference.get().getVisibility() == 0)) {
                    Logger.d(this.f8026a, "webView: " + (weakReference != null ? weakReference.get() : "null") + " is not visible - will not collect resources in this cycle");
                    return;
                }
                if (zContains && bVarJ != null && bVarJ.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_BANNERS)) {
                    List<String> listX = eVar.x();
                    if (strA != null && listX != null && !listX.contains(strA)) {
                        listX.add(strA);
                        eVar.a(listX);
                    }
                    SafeDKWebAppInterface.a(str, weakReference.get(), SafeDKWebAppInterface.b(str, strA, eVar.w()));
                }
                if (zContains2 && bVarJ != null && bVarJ.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES) && (strB = SafeDKWebAppInterface.b(str, strA)) != null) {
                    SafeDKWebAppInterface.a(str, weakReference.get(), strB);
                }
            }
        }
    }

    public void a(CreativeInfo creativeInfo) {
        Set<d> setKeySet;
        synchronized (J) {
            setKeySet = J.keySet();
        }
        if (!setKeySet.isEmpty()) {
            for (d dVar : setKeySet) {
                e eVar = J.get(new d(dVar.f8095a, creativeInfo.H(), creativeInfo.n(), creativeInfo.S(), dVar.e, creativeInfo.M()));
                if (eVar != null) {
                    if (eVar.m() != null && eVar.m().b != null) {
                        BrandSafetyUtils.d(eVar.m().b);
                        eVar.i().k();
                    }
                    if (eVar.D == null) {
                        eVar.D = UUID.randomUUID().toString();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, WeakReference<View> weakReference) {
        String strA = BrandSafetyUtils.a(weakReference.get());
        RedirectData redirectData = N.get(strA);
        Logger.d(this.f8026a, "web view scanner - check for pending redirect: " + redirectData + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (redirectData != null) {
            redirectData.a("LateMatchedRedirectWebview=" + strA);
            if (redirectData.t == null) {
                redirectData.t = BrandSafetyUtils.a(this.c);
            }
            if (redirectData.j) {
                eVar.an = true;
            }
            k kVarI = eVar.i();
            if (kVarI != null) {
                kVarI.a(redirectData);
                N.remove(strA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, String str) {
        Logger.d(this.f8026a, "handle web view change - web view change detected from: " + eVar.K + ", to: " + str + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        k kVarI = eVar.i();
        if (kVarI != null && kVarI.i() != null && !kVarI.i().al()) {
            kVarI.i().am();
            String strH = kVarI.i().h();
            if (strH != null) {
                kVarI.i().e(strH + CreativeInfo.aK);
            }
        }
        eVar.K = str;
        eVar.g().add(new k(UUID.randomUUID().toString()));
        if (eVar.D == null) {
            eVar.D = UUID.randomUUID().toString();
        }
        eVar.ac = false;
    }

    private void a(String str, String str2, d dVar, Bundle bundle) {
        if (this.T.contains(dVar)) {
            Logger.d(this.f8026a, "webview scanner already created for: " + dVar.c);
            return;
        }
        Logger.d(this.f8026a, "creating webview scanner task for: " + dVar);
        synchronized (this.T) {
            this.T.add(dVar);
        }
        b bVar = new b(str, str2, dVar, bundle);
        bVar.h = this.E.scheduleWithFixedDelay(bVar, 0L, 1000L, TimeUnit.MILLISECONDS);
        Logger.d(this.f8026a, "wvscanner - create task, eventId:" + dVar.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, ScheduledFuture<?> scheduledFuture) {
        synchronized (this.T) {
            this.T.remove(dVar);
        }
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        Logger.d(this.f8026a, "wvscanner - cancel task, eventId:" + dVar.c + ", taskFuture: " + scheduledFuture);
    }

    private void a(String str, String str2, String str3, d dVar, Bundle bundle, long j) {
        S.put(dVar.f8095a, dVar);
        this.U.add(dVar.c);
        Logger.d(this.f8026a, "handle WILL_DISPLAY - eventIds added " + dVar.c);
        if (this.M.contains(dVar.c)) {
            Logger.d(this.f8026a, "handle WILL_DISPLAY - impression with id " + dVar.c + " has already been reported, ignoring. ");
            return;
        }
        Activity activityA = a(bundle);
        Logger.d(this.f8026a, "handle WILL_DISPLAY - adActivity = " + activityA);
        Logger.d(this.f8026a, "handle WILL_DISPLAY - image count for " + this.c.name() + " is " + BrandSafetyUtils.b(this.c) + ", # impressions to report: " + this.C.keySet().size());
        if (f(str, str2)) {
            e eVarA = J.get(dVar);
            if (eVarA == null) {
                eVarA = a(activityA, str2, dVar.c, bundle);
                synchronized (J) {
                    J.put(dVar, eVarA);
                }
                Logger.d(this.f8026a, "handle WILL_DISPLAY New activity banner created for " + str2 + ", banner key is " + dVar + ", current activity banners size is " + J.size());
            } else {
                if (eVarA.A == null) {
                    eVarA.A = bundle;
                }
                if (eVarA.B == null || eVarA.C == null) {
                    eVarA.a(a(activityA));
                }
            }
            eVarA.aa = true;
            eVarA.ag = true;
            eVarA.ai = j;
            a(eVarA, false, "handleWillDisplay");
        } else {
            this.d++;
        }
        a(str2, str3, dVar, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, List<WeakReference<View>> list) {
        Logger.d(this.f8026a, "save screenshot view for " + dVar.d);
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(dVar.d);
        if (adNetworkDiscoveryI != null) {
            adNetworkDiscoveryI.a(dVar, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WeakReference<View> d(List<WeakReference<View>> list) {
        WeakReference<View> weakReference = null;
        for (WeakReference<View> weakReference2 : list) {
            Logger.d(this.f8026a, "select monitor view: iterating view is " + weakReference2.get());
            if (weakReference == null) {
                Logger.d(this.f8026a, "select monitor view: setting view " + weakReference2.get());
            } else if (weakReference2.get() instanceof WebView) {
                Logger.d(this.f8026a, "select monitor view: re-setting view " + weakReference2.get());
                weakReference.clear();
            } else {
                Logger.d(this.f8026a, "select monitor view: clearing view " + weakReference2.get());
                weakReference2.clear();
                weakReference2 = weakReference;
            }
            weakReference = weakReference2;
        }
        return weakReference;
    }

    private void a(String str, d dVar, String str2, Bundle bundle, long j) {
        e eVarA;
        this.U.add(dVar.c);
        Logger.d(this.f8026a, "handle DID_DISPLAY - eventIds added " + dVar.c);
        if (this.M.contains(dVar.c)) {
            Logger.d(this.f8026a, "handle DID_DISPLAY - impression with id " + dVar.c + " has already been reported, ignoring. ");
            return;
        }
        Logger.d(this.f8026a, "handle DID_DISPLAY package=" + str + " banner key=" + dVar);
        Activity activityA = a(bundle);
        synchronized (J) {
            eVarA = J.get(dVar);
            if (eVarA != null) {
                Logger.d(this.f8026a, "Banner info already exists, package=" + str + " activity banner=" + eVarA);
                eVarA.z = this.d;
                if (eVarA.B == null || eVarA.C == null) {
                    eVarA.a(a(activityA));
                }
            } else {
                b(dVar);
                eVarA = a(activityA, str, dVar.c, bundle);
                J.put(dVar, eVarA);
                Logger.d(this.f8026a, "New activity banner created for " + str + ", banner key is " + dVar + ", current activity banners size is " + J.size());
            }
        }
        eVarA.M = str2;
        eVarA.aj = j;
        a(eVarA, false, "handleDidDisplay");
        a(str, str2, dVar, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, d dVar, WeakReference<View> weakReference) {
        Logger.d(this.f8026a, "monitor impression started for " + str + ", adInfoKey = " + dVar + ", creativeId = " + str2 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
            e eVar = J.get(dVar);
            if (eVar != null) {
                a(str, dVar);
                eVar.M = str2;
                eVar.ah = true;
                eVar.ak = 0.0f;
                if (weakReference.get().getWidth() > 0 && weakReference.get().getHeight() > 0) {
                    eVar.ak = weakReference.get().getWidth() / weakReference.get().getHeight();
                }
                a(weakReference, eVar, dVar);
                return;
            }
            Logger.d(this.f8026a, "monitor impression, banner info is null for " + str + ", adInfoKey = " + dVar);
            return;
        }
        Logger.d(this.f8026a, "monitor impression, view is null for " + str + ", adInfoKey = " + dVar);
    }

    private void a(WeakReference<View> weakReference, e eVar, d dVar) {
        if (eVar.am != null) {
            Logger.d(this.f8026a, "set impression handler task if needed - already exist for event id: " + dVar.c + ", exiting");
            return;
        }
        eVar.am = new a(eVar, weakReference, this.e, dVar);
        eVar.av = dVar;
        CreativeInfo creativeInfoJ = eVar.j();
        if (creativeInfoJ != null && creativeInfoJ.v() && m(eVar.c())) {
            Logger.d(this.f8026a, "_AD_CAPTURE_ set impression handler task if needed : task set but not started since the ad is a video ad and the video hasn't finished yet. " + eVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            return;
        }
        int iAa = SafeDK.getInstance().aa() * 1000;
        Logger.d(this.f8026a, "start taking screenshots for view: " + weakReference.get().toString() + ", sampling interval = " + iAa + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        eVar.am.d = this.E.scheduleWithFixedDelay(eVar.am, 500L, iAa, TimeUnit.MILLISECONDS);
        Logger.d(this.f8026a, "set impression handler task if needed : task created and started : " + eVar);
    }

    protected boolean m(String str) {
        return false;
    }

    private boolean q(String str) {
        Set<d> setKeySet;
        synchronized (J) {
            setKeySet = J.keySet();
        }
        if (!setKeySet.isEmpty()) {
            Iterator<d> it = setKeySet.iterator();
            while (it.hasNext()) {
                e eVar = J.get(it.next());
                if (eVar != null && eVar.m != null && eVar.m.contains(str) && eVar.j() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void n(String str) {
        Set<d> setKeySet;
        synchronized (J) {
            setKeySet = J.keySet();
        }
        if (!setKeySet.isEmpty()) {
            Iterator<d> it = setKeySet.iterator();
            while (it.hasNext()) {
                e eVar = J.get(it.next());
                if (eVar != null && eVar.K != null && eVar.K.equals(str) && eVar.j() == null) {
                    Logger.d(this.f8026a, "handle multiple impressions - reset webview data in: " + eVar);
                    eVar.K = null;
                    eVar.ah = false;
                }
            }
        }
    }

    private void b(d dVar) {
        synchronized (J) {
            Iterator<Map.Entry<d, e>> it = J.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<d, e> next = it.next();
                d key = next.getKey();
                e value = next.getValue();
                if (key.f8095a.equals(dVar.f8095a) && key.b.equals(dVar.b) && !key.c.equals(dVar.c) && !value.ag) {
                    Logger.d(this.f8026a, "report undetected banner started for AdInfoKey=" + key);
                    a(value, true, "reportUndetectedBannerIfNeeded");
                    it.remove();
                    a(value);
                }
            }
        }
    }

    protected boolean f(String str, String str2) {
        boolean zA = CreativeInfoManager.a(str2, AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, false);
        String strA = CreativeInfoManager.a(str2, AdNetworkConfiguration.AD_NETWORK_TO_IGNORE, (String) null);
        Logger.d(this.f8026a, "sdk " + str2 + ": config item SUPPORTS_BANNER_IMPRESSION_TRACKING is " + zA + ", config item AD_NETWORK_TO_IGNORE is " + strA);
        if (zA && !str.equals(strA)) {
            return true;
        }
        Logger.d(this.f8026a, "Banners tracking is not supported for this ad network (" + str + ")");
        return false;
    }

    private e a(Activity activity, String str, String str2, Bundle bundle) {
        String lowerCase = BrandSafetyUtils.c().name().toLowerCase();
        this.d++;
        Logger.d(this.f8026a, "slot number incremented to " + this.d + ", eventId is " + str2 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        return a(activity, str, this.d, lowerCase, bundle, str2);
    }

    private void a(String str, d dVar) {
        ArrayList<o> arrayList;
        List<CreativeInfo> arrayList2;
        CreativeInfo creativeInfoA;
        Logger.d(this.f8026a, "pending ci check started, sdkPackageName = " + str + ", adInfoKey = " + dVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (dVar == null) {
            Logger.d(this.f8026a, "pending ci check - no activity key");
            return;
        }
        e eVar = J.get(dVar);
        if (eVar == null) {
            Logger.d(this.f8026a, "pending ci check - no banner info");
            return;
        }
        CreativeInfo creativeInfoJ = eVar.j();
        if (creativeInfoJ != null && !creativeInfoJ.al()) {
            Logger.d(this.f8026a, "pending ci check - CI already exist");
            return;
        }
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
        if (adNetworkDiscoveryI == null) {
            Logger.d(this.f8026a, "pending ci check - no ad discovery found, exit. activity key : " + dVar);
            return;
        }
        if (dVar.c != null) {
            Logger.d(this.f8026a, "pending ci check - activity key : " + dVar);
            if (!CreativeInfoManager.a(str, AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, false) && (creativeInfoA = adNetworkDiscoveryI.a((Object) (dVar.b + "_" + dVar.c + "_" + str))) != null) {
                Logger.d(this.f8026a, "pending ci check - discovery class returned a ci: " + creativeInfoA.aa());
                if (creativeInfoA.K() == null) {
                    BrandSafetyEvent.AdFormatType adFormatTypeA = BrandSafetyUtils.a(eVar.A);
                    Logger.d(this.f8026a, "pending ci check - set ad format: " + adFormatTypeA);
                    creativeInfoA.a(adFormatTypeA);
                }
                if (creativeInfoA.n() == null) {
                    creativeInfoA.h(dVar.c);
                }
                Logger.d(this.f8026a, "pending ci check - CI event ID set");
            }
        }
        List<o> list = K.get(str);
        if (list != null) {
            Logger.d(this.f8026a, "pending ci check - sdk: " + str + ", no. of pending candidates: " + list.size());
            synchronized (list) {
                arrayList = new ArrayList(list);
            }
            for (o oVar : arrayList) {
                Logger.d(this.f8026a, "pending ci check - pending candidate: " + oVar);
                CreativeInfo creativeInfo = oVar.f8114a;
                if (a(creativeInfo, eVar)) {
                    Logger.d(this.f8026a, "pending ci check - creative info found by WebView/eventID, CI: " + creativeInfo);
                    List<CreativeInfo> listU = adNetworkDiscoveryI.u(creativeInfo.N());
                    Logger.d(this.f8026a, "pending ci check - number of multi ad creative infos: " + (listU != null ? listU.size() : 0));
                    if (listU == null) {
                        arrayList2 = new ArrayList<>();
                        arrayList2.add(creativeInfo);
                    } else {
                        arrayList2 = listU;
                    }
                    boolean zA = false;
                    for (CreativeInfo creativeInfo2 : arrayList2) {
                        b(creativeInfo2, eVar);
                        if (creativeInfo2.n() == null) {
                            creativeInfo2.h(dVar.c);
                            creativeInfo2.h(true);
                        }
                        zA = a(dVar.f8095a, dVar.e, new o(creativeInfo2, oVar.b, oVar.c));
                        if (!zA) {
                            break;
                        }
                    }
                    if (zA) {
                        synchronized (list) {
                            list.remove(oVar);
                        }
                        eVar.d("pcim|ts=" + System.currentTimeMillis() + "|ls=" + list.size() + ";" + oVar.b + "|o=" + oVar.f8114a.ah() + ";" + oVar.f8114a.ai());
                        return;
                    } else {
                        if (creativeInfo.D()) {
                            Logger.d(this.f8026a, "pending ci check - unreal match and event id set happened, setting ci event id back to null");
                            creativeInfo.h((String) null);
                            creativeInfo.h(false);
                            return;
                        }
                        return;
                    }
                }
            }
            return;
        }
        Logger.d(this.f8026a, "pending ci check - there are no pending candidates");
    }

    private void c(d dVar) {
        e eVar = J.get(dVar);
        if (eVar != null) {
            Logger.d(this.f8026a, "handle DID_HIDE, placementId=" + dVar.b);
            eVar.ac = true;
        }
    }

    private void d(d dVar) {
        e eVar = J.get(dVar);
        if (eVar == null) {
            Logger.d(this.f8026a, "handle DID_CLICKED current activity banner is null");
            return;
        }
        if (eVar.D != null && CreativeInfoManager.a(eVar.c(), AdNetworkConfiguration.SHOULD_IGNORE_BANNER_MULTI_AD_DID_CLICK_EVENT, false)) {
            Logger.d(this.f8026a, "handle DID_CLICKED current activity banner multi ad");
            return;
        }
        eVar.a(true);
        if (eVar.e() != null) {
            Logger.d(this.f8026a, "handle DID_CLICKED current activity banner already have click url");
        } else if (O == null) {
            Logger.d(this.f8026a, "handle DID_CLICKED current click url candidate is null");
        } else if (O.f8101a == 0) {
            Logger.d(this.f8026a, "handle DID_CLICKED current click url candidate has zero timestamp");
        } else if (!a(eVar, O.b, O.c)) {
            Logger.d(this.f8026a, "handle DID_CLICKED ad click url is not valid");
        } else if (System.currentTimeMillis() - O.f8101a < 5000) {
            Logger.d(this.f8026a, "handle DID_CLICKED setting click URL to " + O.b);
            eVar.c(O.b);
            O = null;
        } else {
            Logger.d(this.f8026a, "handle DID_CLICKED click url candidate's timestamp is not within the time range");
        }
        a(eVar, false, "handleDidClicked");
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return AppLovinBridge.f7952a;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void a(String str) {
        synchronized (J) {
            Iterator<e> it = J.values().iterator();
            while (it.hasNext()) {
                it.next().ac = true;
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e a(String str, RedirectDetails redirectDetails, m mVar, boolean z, boolean z2) {
        Logger.d(this.f8026a, "handle " + redirectDetails.e.name().toLowerCase() + " for " + str + " " + this.c.name() + ", view address: " + redirectDetails.f + ", requested URL: " + redirectDetails.g + ", redirect URL: " + mVar.d + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        RedirectData redirectData = new RedirectData(str, BrandSafetyUtils.a(redirectDetails.d));
        if (redirectDetails.e == RedirectDetails.RedirectType.REDIRECT) {
            String str2 = mVar.f;
            if (TextUtils.isEmpty(str2)) {
                str2 = z ? "external" : RedirectEvent.i;
            }
            redirectData.a(redirectDetails.g, mVar.d, str2);
        } else if (redirectDetails.e == RedirectDetails.RedirectType.EXPAND) {
            redirectData.b(redirectDetails.g, mVar.d, mVar.e);
            redirectData.a("expandedWebviewAddress=" + mVar.e);
        }
        if (redirectData.i || redirectData.j) {
            if (redirectDetails.i != null) {
                redirectData.a("prev " + redirectDetails.i);
            }
            if (mVar.g != null) {
                redirectData.a("prev " + mVar.g);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int iF = SafeDK.getInstance().f();
            e eVar = (e) b(redirectDetails.f);
            if (eVar != null && str.equals(eVar.v)) {
                boolean z3 = false;
                for (int size = eVar.m.size() - 1; size >= 0; size--) {
                    String str3 = eVar.m.get(size);
                    v vVarA = DetectTouchUtils.a(str, str3);
                    long jLongValue = vVarA == null ? 0L : vVarA.f8117a.longValue();
                    Logger.d(this.f8026a, "handle " + redirectDetails.e.name().toLowerCase() + ", view: " + str3 + ", last touch event time: " + jLongValue + ", diff: " + (jElapsedRealtime - jLongValue) + ", threshold: " + iF);
                    z3 = (iF == 0 || jLongValue == 0 || jElapsedRealtime - jLongValue > ((long) iF)) ? false : true;
                    if (z3) {
                        break;
                    }
                }
                redirectData.l = !z3;
                Logger.d(this.f8026a, "handle " + (redirectData.l ? "auto " : "") + redirectDetails.e.name().toLowerCase() + " for " + str + " " + this.c.name() + ", view address: " + redirectDetails.f + ", requested URL: " + redirectDetails.g + ", redirect URL: " + mVar.d);
                if (z2) {
                    if (redirectData.j || (redirectData.i && redirectData.l)) {
                        if (redirectData.t == null) {
                            redirectData.t = BrandSafetyUtils.a(this.c);
                        }
                        if (redirectData.j) {
                            eVar.an = true;
                        }
                        k kVarI = eVar.i();
                        if (kVarI != null) {
                            if (redirectData.j) {
                                l.a[] aVarArr = new l.a[1];
                                aVarArr[0] = new l.a("typ", redirectData.l ? "auto" : "regular");
                                eVar.a("exp", aVarArr);
                            } else {
                                l.a[] aVarArr2 = new l.a[1];
                                aVarArr2[0] = new l.a(l.M, z ? "external" : RedirectEvent.i);
                                eVar.a(l.x, aVarArr2);
                            }
                            kVarI.a(redirectData);
                            a(eVar, false, "handleRedirect");
                            return eVar;
                        }
                    } else {
                        Logger.d(this.f8026a, "skip reporting " + redirectDetails.e.name().toLowerCase() + " for " + str + " " + this.c.name() + ", view address: " + redirectDetails.f + ", requested URL: " + redirectDetails.g + ", redirect URL: " + mVar.d);
                        return null;
                    }
                } else {
                    a(redirectDetails, mVar, eVar);
                    return eVar;
                }
            } else if (z2) {
                v vVarA2 = DetectTouchUtils.a(str, redirectDetails.f);
                if (vVarA2 == null) {
                    Logger.d(this.f8026a, "handle " + redirectDetails.e.name().toLowerCase() + " for " + str + " " + this.c.name() + ", try to get last touch event from by package name only");
                    vVarA2 = DetectTouchUtils.a(str);
                }
                long jLongValue2 = vVarA2 == null ? 0L : vVarA2.f8117a.longValue();
                Logger.d(this.f8026a, "handle " + redirectDetails.e.name().toLowerCase() + ", last touch event time: " + jLongValue2 + ", diff: " + (jElapsedRealtime - jLongValue2) + ", threshold: " + iF);
                redirectData.l = iF == 0 || jLongValue2 == 0 || jElapsedRealtime - jLongValue2 > ((long) iF);
                if (redirectData.j || (redirectData.i && redirectData.l)) {
                    Logger.d(this.f8026a, "handle " + (redirectData.l ? "auto " : "") + redirectDetails.e.name().toLowerCase() + " for " + str + " " + this.c.name() + ", no banner info found, add to pending, webview: " + redirectDetails.f);
                    N.put(redirectDetails.f, redirectData);
                } else {
                    Logger.d(this.f8026a, "handle " + (redirectData.l ? "auto " : "") + redirectDetails.e.name().toLowerCase() + " for " + str + " " + this.c.name() + ", no banner info found, don't add to pending, webview: " + redirectDetails.f);
                }
            } else {
                a(redirectDetails, mVar, (e) null);
            }
        }
        return null;
    }

    private void a(RedirectDetails redirectDetails, m mVar, e eVar) {
        if (eVar != null) {
            Logger.d(this.f8026a, "add redirect log events to ad info, " + redirectDetails + ", " + mVar);
            if (redirectDetails.h.equals("shouldOverrideUrlLoading")) {
                eVar.a(redirectDetails.f8024a, redirectDetails.b, l.v, new l.a("api", "so"), new l.a("url", redirectDetails.g), new l.a(l.Q, TimerController.CANCEL_COMMAND));
            } else {
                Long l = redirectDetails.f8024a;
                Long l2 = redirectDetails.b;
                l.a[] aVarArr = new l.a[2];
                aVarArr[0] = new l.a("typ", redirectDetails.e == RedirectDetails.RedirectType.REDIRECT ? RedirectEvent.b : "expand");
                aVarArr[1] = new l.a("url", redirectDetails.g);
                eVar.a(l, l2, l.u, aVarArr);
            }
            Long l3 = mVar.f8113a;
            Long l4 = mVar.b;
            l.a[] aVarArr2 = new l.a[2];
            aVarArr2[0] = new l.a("typ", mVar.f != null ? mVar.f : Constants.NORMAL);
            aVarArr2[1] = new l.a("url", mVar.d);
            eVar.a(l3, l4, l.w, aVarArr2);
            return;
        }
        Logger.d(this.f8026a, "add redirect log events to view address, " + redirectDetails + ", " + mVar);
        if (redirectDetails.h.equals("shouldOverrideUrlLoading")) {
            a(redirectDetails.f, redirectDetails.f8024a, redirectDetails.b, l.v, new l.a("api", "so"), new l.a("url", redirectDetails.g), new l.a(l.Q, TimerController.CANCEL_COMMAND));
        } else {
            String str = redirectDetails.f;
            Long l5 = redirectDetails.f8024a;
            Long l6 = redirectDetails.b;
            l.a[] aVarArr3 = new l.a[2];
            aVarArr3[0] = new l.a("typ", redirectDetails.e == RedirectDetails.RedirectType.REDIRECT ? RedirectEvent.b : "expand");
            aVarArr3[1] = new l.a("url", redirectDetails.g);
            a(str, l5, l6, l.u, aVarArr3);
        }
        String str2 = redirectDetails.f;
        Long l7 = mVar.f8113a;
        Long l8 = mVar.b;
        l.a[] aVarArr4 = new l.a[2];
        aVarArr4[0] = new l.a("typ", mVar.f != null ? mVar.f : Constants.NORMAL);
        aVarArr4[1] = new l.a("url", mVar.d);
        a(str2, l7, l8, l.w, aVarArr4);
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, x xVar) {
        c cVarB = b(str, xVar);
        if (!(cVarB instanceof e)) {
            return false;
        }
        a((e) cVarB, false, "handleWebsiteOpened");
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public List<CreativeInfo> a(String str, String str2) {
        synchronized (J) {
            try {
                for (e eVar : J.values()) {
                    if (eVar.K != null && eVar.K.equals(str2) && eVar.v != null && eVar.v.equals(str) && eVar.aa && !eVar.U) {
                        return eVar.l();
                    }
                }
                List<o> list = K.get(str);
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    synchronized (list) {
                        for (o oVar : list) {
                            if (oVar.f8114a != null && oVar.f8114a.ai() != null && oVar.f8114a.ai().equals(str2)) {
                                arrayList.add(oVar.f8114a);
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    Logger.d(this.f8026a, "get current CIs for webview address: " + str2 + ", found " + arrayList.size() + " pending CIs");
                }
                return arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public List<CreativeInfo> b(String str, String str2) {
        List<CreativeInfo> listK;
        synchronized (J) {
            for (e eVar : J.values()) {
                if (eVar != null && (listK = eVar.k()) != null && !listK.isEmpty() && listK.get(0) != null && listK.get(0).N().equals(str2)) {
                    return listK;
                }
            }
            List<o> list = K.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                synchronized (list) {
                    for (o oVar : list) {
                        if (oVar.f8114a != null && oVar.f8114a.N().equals(str2)) {
                            arrayList.add(oVar.f8114a);
                        }
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b
    public c k(String str) {
        Set<d> setKeySet;
        synchronized (J) {
            setKeySet = J.keySet();
        }
        if (!setKeySet.isEmpty()) {
            Iterator<d> it = setKeySet.iterator();
            while (it.hasNext()) {
                e eVar = J.get(it.next());
                if (eVar != null && eVar.L != null && eVar.L.equals(str)) {
                    return eVar;
                }
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public c b(String str) {
        synchronized (J) {
            for (e eVar : J.values()) {
                if (eVar.m != null && eVar.m.contains(str) && eVar.aa && !eVar.U) {
                    return eVar;
                }
            }
            return null;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public c c(String str) {
        synchronized (J) {
            for (e eVar : J.values()) {
                if (eVar.ao != null && eVar.ao.equals(str) && eVar.aa && !eVar.U) {
                    return eVar;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        try {
            Logger.d(this.f8026a, "clean started, currentActivityBanners size is " + J.size() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            if (eVar != null) {
                Logger.d(this.f8026a, "clean, adding to reported impressions map. id =  " + eVar.L);
                synchronized (this.M) {
                    this.M.add(eVar.L);
                }
                eVar.ac = true;
                if (eVar.ae != null) {
                    Logger.d(this.f8026a, "clean, cancel WebView scanner task. id =  " + eVar.L);
                    if (eVar.ae != null) {
                        eVar.ae.cancel(false);
                    }
                }
                for (k kVar : eVar.g()) {
                    if (kVar.c != null && kVar.c.b != null) {
                        kVar.d = kVar.c.b;
                        Logger.d(this.f8026a, "clean, set last impression screenshot filename to " + kVar.c.b);
                    }
                    String strA = kVar.a();
                    com.safedk.android.analytics.brandsafety.creatives.g.a(eVar.v, strA, kVar);
                    SafeDKWebAppInterface.a(strA);
                }
                if (eVar.k().isEmpty()) {
                    com.safedk.android.analytics.brandsafety.creatives.g.b(eVar.n);
                    SafeDKWebAppInterface.a(eVar.K);
                } else {
                    for (CreativeInfo creativeInfo : eVar.k()) {
                        if (creativeInfo != null) {
                            com.safedk.android.analytics.brandsafety.creatives.g.b(eVar.n);
                            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(creativeInfo.S());
                            if (adNetworkDiscoveryI != null) {
                                adNetworkDiscoveryI.o(creativeInfo.N());
                            }
                            if (creativeInfo.Y() != null) {
                                Logger.d(this.f8026a, "clean and report - resetting CI matching method for ci " + creativeInfo);
                                creativeInfo.b((String) null, (String) null);
                            }
                        }
                    }
                }
                b(eVar);
            }
        } catch (Throwable th) {
            Logger.e(this.f8026a, "Error in clean " + th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, boolean z, String str) {
        if (eVar == null) {
            Logger.d(this.f8026a, "reporting event - info is null, cannot report brand safety event");
            return;
        }
        boolean z2 = !eVar.E;
        Logger.d(this.f8026a, "reporting event started, root=" + str + ", info.isClickReported=" + eVar.F + ", info.isClicked()=" + eVar.d() + ", shouldReportImpression=" + z2 + ", eventId=" + eVar.L + ", isMature=" + z + ", isOnUiThread=" + com.safedk.android.utils.n.c());
        boolean z3 = !eVar.F && eVar.d();
        long j = Long.MAX_VALUE;
        if (eVar.ai > 0 && eVar.aj > 0) {
            j = eVar.ai - eVar.aj;
        }
        ArrayList arrayList = new ArrayList();
        if (eVar != null && eVar.k().isEmpty() && eVar.i() != null) {
            Logger.d(this.f8026a, "reporting event, root=" + str + ", isMature=" + z + ", info=" + eVar);
            arrayList.add(a(eVar, eVar.i(), z, eVar.F || z3, j, (String) null));
        } else {
            for (k kVar : eVar.g()) {
                if (kVar.i() != null && !kVar.i().al() && kVar.i().Y() == null) {
                    Logger.d(this.f8026a, "reporting event - don't report CI as it was matched only by eventId and not by webview resources");
                    kVar.a((CreativeInfo) null);
                }
                String str2 = null;
                if (z && kVar.c != null && kVar.c.f8109a != null) {
                    str2 = kVar.c.f8109a + "_" + kVar.f8110a;
                    Logger.d(this.f8026a, "reporting event - imageFileIsValid filename = " + BrandSafetyUtils.a(eVar.p, kVar.c.f8109a, eVar.c(), kVar.f8110a, kVar.c.f));
                }
                Logger.d(this.f8026a, "reporting event, root=" + str + ", isMature=" + z + ", info=" + eVar + ", uniformity=" + (kVar.c != null ? kVar.c.a(500) : 0.0f));
                if (z) {
                    com.safedk.android.analytics.brandsafety.creatives.g.a(eVar.v, eVar.j().ai(), eVar.i());
                }
                arrayList.add(a(eVar, kVar, z, eVar.F || z3, j, str2));
                if (z && kVar.i() != null && kVar.c != null) {
                    if (this.C.size() <= SafeDK.getInstance().J()) {
                        Logger.d(this.f8026a, "reporting event waiting to report file " + kVar.c.b);
                        a(eVar, kVar);
                    } else {
                        Logger.d(this.f8026a, "reporting event no open slot for " + this.c + ", " + kVar.c.f8109a);
                        BrandSafetyUtils.d(kVar.c.b);
                    }
                    kVar.h();
                }
            }
        }
        if (StatsCollector.c() != null) {
            StatsCollector.c().a(arrayList);
        } else {
            Logger.d(this.f8026a, "reporting event - stats collector instance is null, cannot report brand safety event");
        }
        if (z2) {
            eVar.c(true);
        }
        if (z3) {
            eVar.d(true);
            Logger.d(this.f8026a, "reporting event - setIsClickReported set to true");
        }
    }

    private static BrandSafetyEvent a(e eVar, k kVar, boolean z, boolean z2, long j, String str) {
        return new BrandSafetyEvent(eVar.c(), eVar.q(), str, z2, eVar.d() ? eVar.e() : null, kVar.i(), eVar.a(), eVar.p(), kVar.f8110a != null ? kVar.f8110a : "", eVar.D, z, eVar.r(), kVar.c != null ? kVar.c.f : null, kVar.c != null ? kVar.c.c : 0L, kVar.c != null ? kVar.c.a(500) : 0.0f, kVar.c != null ? kVar.c.e : 0, eVar.ag, eVar.ah, j, eVar.ak, eVar.al, eVar.T, SafeDK.getInstance().e(), eVar.w(), eVar.M, eVar.N, eVar.P, eVar.Q, b(eVar, kVar).toString(), kVar.e, kVar.f, kVar.g, kVar.m, kVar.n, kVar.o, kVar.p, kVar.q, kVar.x, kVar.r);
    }

    protected void a(CreativeInfo creativeInfo, o oVar) {
        List<o> list;
        String strS = creativeInfo.S();
        Logger.d(this.f8026a, "set CI details - adding as pending, sdk: " + strS + " matching info: " + oVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        List<o> list2 = K.get(strS);
        if (list2 == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (K) {
                K.put(strS, arrayList);
            }
            list = arrayList;
        } else {
            list = list2;
        }
        if (!CreativeInfoManager.a(strS, AdNetworkConfiguration.DO_NOT_ADD_CI_TO_FINDER_PENDING_CI_LIST, false)) {
            for (o oVar2 : list) {
                if (oVar2.f8114a != null && oVar2.f8114a.equals(creativeInfo)) {
                    Logger.d(this.f8026a, "set CI details - CI already exists in pending list, sdk: " + strS + " matching info: " + oVar);
                    return;
                }
            }
            list.add(oVar);
            creativeInfo.t("apci|ts=" + System.currentTimeMillis() + ";" + oVar.b + "|o=" + oVar.f8114a.ah() + ";" + oVar.f8114a.ai());
            return;
        }
        Logger.d(this.f8026a, "set CI details - NOT adding as pending (config based), sdk: " + strS + " matching info: " + oVar);
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(o oVar) {
        Set<d> setKeySet;
        try {
            com.safedk.android.utils.n.b(this.f8026a, "set CI details started. matchingInfo = " + oVar.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            CreativeInfo creativeInfo = oVar.f8114a;
            if (creativeInfo != null) {
                Logger.d(this.f8026a, "set CI details - CI exists in matchingInfo, sdk = " + creativeInfo.S());
                creativeInfo.i(BrandSafetyUtils.ScreenShotOrientation.PORTRAIT.equals(BrandSafetyUtils.c()));
                synchronized (J) {
                    setKeySet = J.keySet();
                    Logger.d(this.f8026a, "set CI details - starting to iterate over current activity banners: " + J.keySet());
                }
                if (!setKeySet.isEmpty()) {
                    for (d dVar : setKeySet) {
                        e eVar = J.get(dVar);
                        if (a(creativeInfo, eVar)) {
                            Logger.d(this.f8026a, "set CI details - matched by webView/eventID, CI: " + creativeInfo);
                            if (creativeInfo.n() == null) {
                                Logger.d(this.f8026a, "set CI details - updated creative info eventId to " + dVar.c + ", banner key = " + dVar);
                                creativeInfo.h(dVar.c);
                                creativeInfo.h(true);
                            }
                            if (creativeInfo.K() == null) {
                                BrandSafetyEvent.AdFormatType adFormatTypeA = BrandSafetyUtils.a(eVar.A);
                                Logger.d(this.f8026a, "set CI details - set ad format: " + adFormatTypeA);
                                creativeInfo.a(adFormatTypeA);
                            }
                            if (CreativeInfoManager.a(creativeInfo.S(), AdNetworkConfiguration.SDK_USES_PLACEMENT_ID_ARRAY, false)) {
                                Logger.d(this.f8026a, "set CI details - SDK_USES_PLACEMENT_ID_ARRAY config item is true");
                                if (!creativeInfo.H().equals(dVar.b)) {
                                    Logger.d(this.f8026a, "set CI details - updated creative info placementId to " + dVar.b + ", banner key = " + dVar);
                                    creativeInfo.j(dVar.b);
                                }
                            }
                            if (a(dVar.f8095a, dVar.e, oVar)) {
                                return true;
                            }
                            if (creativeInfo.D()) {
                                Logger.d(this.f8026a, "set CI details - unreal match and event id set happened, setting ci event id back to null");
                                creativeInfo.h(false);
                                creativeInfo.h((String) null);
                            }
                        }
                    }
                }
                a(creativeInfo, oVar);
                return true;
            }
        } catch (Throwable th) {
            Logger.e(this.f8026a, "set CI details exception: " + th.getMessage(), th);
        }
        return false;
    }

    public void a(o oVar, d dVar) {
        try {
            com.safedk.android.utils.n.b(this.f8026a, "set CI details started. matchingInfo = " + oVar.toString() + ", bannerKey = " + dVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            CreativeInfo creativeInfo = oVar.f8114a;
            if (creativeInfo != null) {
                Logger.d(this.f8026a, "set CI details - CI exists in matchingInfo, sdk = " + creativeInfo.S());
                creativeInfo.i(BrandSafetyUtils.ScreenShotOrientation.PORTRAIT.equals(BrandSafetyUtils.c()));
                e eVar = J.get(dVar);
                if (a(creativeInfo, eVar)) {
                    Logger.d(this.f8026a, "set CI details - matched by webView/eventID, CI: " + creativeInfo);
                    if (creativeInfo.n() == null) {
                        Logger.d(this.f8026a, "set CI details - updated creative info eventId to " + dVar.c + ", banner key = " + dVar);
                        creativeInfo.h(dVar.c);
                        creativeInfo.h(true);
                    }
                    if (creativeInfo.K() == null) {
                        BrandSafetyEvent.AdFormatType adFormatTypeA = BrandSafetyUtils.a(eVar.A);
                        Logger.d(this.f8026a, "set CI details - set ad format: " + adFormatTypeA);
                        creativeInfo.a(adFormatTypeA);
                    }
                    if (CreativeInfoManager.a(creativeInfo.S(), AdNetworkConfiguration.SDK_USES_PLACEMENT_ID_ARRAY, false)) {
                        Logger.d(this.f8026a, "set CI details - SDK_USES_PLACEMENT_ID_ARRAY config item is true");
                        if (!creativeInfo.H().equals(dVar.b)) {
                            Logger.d(this.f8026a, "set CI details - updated creative info placementId to " + dVar.b + ", banner key = " + dVar);
                            creativeInfo.j(dVar.b);
                        }
                    }
                    if (!a(dVar.f8095a, dVar.e, oVar)) {
                        if (creativeInfo.D()) {
                            Logger.d(this.f8026a, "set CI details - unreal match and event id set happened, setting ci event id back to null");
                            creativeInfo.h(false);
                            creativeInfo.h((String) null);
                        }
                    } else {
                        return;
                    }
                }
                a(creativeInfo, oVar);
            }
        } catch (Throwable th) {
            Logger.e(this.f8026a, "set CI details exception: " + th.getMessage(), th);
        }
    }

    private boolean a(CreativeInfo creativeInfo, e eVar) {
        if (eVar == null) {
            Logger.d(this.f8026a, "verify matching - banner info is null");
            return false;
        }
        if (eVar.v == null) {
            Logger.d(this.f8026a, "verify matching - banner info maxSdk is null");
            return false;
        }
        if (creativeInfo == null) {
            Logger.d(this.f8026a, "verify matching - creative info is null");
            return false;
        }
        String strS = creativeInfo.S();
        if (!eVar.v.equals(strS)) {
            Logger.d(this.f8026a, "verify matching  - sdks does not match, ci sdk is: " + strS + " and banner sdk is: " + eVar.v);
            return false;
        }
        Logger.d(this.f8026a, "verify matching - ci sdk is: " + strS + ", banner info: " + eVar);
        if (eVar.L != null && creativeInfo.n() != null && !eVar.L.equals(creativeInfo.n())) {
            Logger.d(this.f8026a, "verify matching - incompatible event ID, ci: " + creativeInfo.n() + ", info: " + eVar.L);
            if (!CreativeInfoManager.a(eVar.v, AdNetworkConfiguration.SHOULD_ALLOW_CI_MATCHING_WITH_INCOMPATIBLE_EVENT_IDS, false)) {
                return false;
            }
            creativeInfo.t("CiMatchingWithIncompatibleEventId=" + creativeInfo.n());
        }
        return a(creativeInfo.ah(), creativeInfo.ai(), eVar);
    }

    private boolean a(String str, String str2, e eVar) {
        if (str2 == null || MediaPlayer.class.getCanonicalName().equals(str)) {
            Logger.d(this.f8026a, "verify matching object skipped, event ID: " + eVar.L + ", object address: " + str2 + ", object type: " + str);
            return true;
        }
        if (eVar.x() != null && eVar.x().contains(str2)) {
            Logger.d(this.f8026a, "verify matching object done, event ID: " + eVar.L + ", object address: " + str2 + ", views hierarchy: " + eVar.x());
            return true;
        }
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(eVar.v);
        if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.a(str2, eVar)) {
            Logger.d(this.f8026a, "verify matching object done, multiple webviews detected for banner. event ID: " + eVar.L + ", object address: " + str2 + ", views hierarchy: " + eVar.x());
            return true;
        }
        Logger.d(this.f8026a, "verify matching object failed, event ID: " + eVar.L + ", object address: " + str2 + ", views hierarchy: " + eVar.x());
        return false;
    }

    private boolean a(String str, String str2, o oVar) {
        e eVar;
        com.safedk.android.utils.n.b(this.f8026a, "set CI started, adUnitId=" + str + " matchingInfo=" + oVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (oVar == null) {
            Logger.d(this.f8026a, "set CI - no matching info");
            return false;
        }
        CreativeInfo creativeInfo = oVar.f8114a;
        if (creativeInfo != null) {
            d dVar = new d(creativeInfo.j() != null ? creativeInfo.j() : str, creativeInfo.H(), creativeInfo.n(), creativeInfo.S(), str2, creativeInfo.M());
            Logger.d(this.f8026a, "set CI - activity key: " + dVar);
            synchronized (J) {
                Iterator<d> it = J.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        eVar = null;
                        break;
                    }
                    d next = it.next();
                    if (dVar.a(next, creativeInfo)) {
                        eVar = J.get(next);
                        break;
                    }
                }
                com.safedk.android.utils.n.b(this.f8026a, "set CI - current activity banner: " + eVar);
            }
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(creativeInfo.S());
            if (adNetworkDiscoveryI == null) {
                Logger.d(this.f8026a, "set CI - no ad network discovery for sdk: " + creativeInfo.S());
                return false;
            }
            if (eVar != null) {
                if (!eVar.ad && StatsReporter.b().a(creativeInfo, eVar)) {
                    eVar.ad = true;
                }
                CreativeInfo creativeInfoJ = eVar.j();
                if (creativeInfoJ != null) {
                    Logger.d(this.f8026a, "set CI - previous CI id: " + creativeInfoJ.N());
                    if (creativeInfoJ.N() != null && creativeInfoJ.N().equals(creativeInfo.N())) {
                        adNetworkDiscoveryI.d(creativeInfoJ);
                        com.safedk.android.utils.n.b(this.f8026a, "set CI - already matched, same ad ID. current match: " + creativeInfo.aa() + ", previous match: " + creativeInfoJ.aa());
                    }
                }
                boolean z = creativeInfo.Y() != null;
                creativeInfo.b(oVar.b, oVar.c);
                Logger.d(this.f8026a, "set CI - current banner webview address: " + eVar.K + " is CI set earlier: " + z);
                Logger.d(this.f8026a, "set CI - current banner: " + eVar);
                Logger.d(this.f8026a, "set CI - current debug info: " + creativeInfo.X());
                eVar.a(creativeInfo);
                adNetworkDiscoveryI.r(creativeInfo.N());
                if (!z) {
                    a(eVar.i());
                    eVar.i().k();
                }
                Logger.d(this.f8026a, "set CI - CI is set for activity banner " + dVar + ". CI : " + creativeInfo);
                if (m(eVar.c()) && creativeInfo.v() && eVar.am != null && !eVar.i().k && eVar.am.d != null) {
                    eVar.am.d.cancel(false);
                    eVar.am = null;
                    Logger.d(this.f8026a, "_AD_CAPTURE_ set CI - canceling running impression handler task (ad is a video ad) " + eVar);
                }
                n(creativeInfo.ai());
                if (eVar.K != null && (eVar.J == AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP || eVar.J == AdNetworkDiscovery.WebViewResourceMatchingMethod.DIRECT_CREATIVE_INFO)) {
                    com.safedk.android.utils.n.b(this.f8026a, "set CI - attach resources to CI, webview address: " + eVar.K + " , ci: " + creativeInfo);
                    com.safedk.android.analytics.brandsafety.creatives.g.a(eVar.v, eVar.K, eVar.i());
                }
                b(eVar, creativeInfo);
                a(eVar, false, "setCreativeInfo");
                return true;
            }
            adNetworkDiscoveryI.d(creativeInfo);
            return false;
        }
        Logger.d(this.f8026a, "set CI - no CI");
        return false;
    }

    private boolean a(c cVar, String str, String str2) {
        if (cVar != null) {
            String strD = com.safedk.android.utils.k.d(str, "clcode");
            Logger.d(this.f8026a, "check ad click URL validity - clcode: " + strD + ", view address: " + str2 + ", views hierarchy: " + cVar.x());
            CreativeInfo creativeInfoJ = cVar.j();
            if ((strD != null && creativeInfoJ != null && !creativeInfoJ.N().equals(strD)) || cVar.x() == null || str2 == null || !cVar.x().contains(str2)) {
                Logger.d(this.f8026a, "check ad click URL validity - ad ID or view address does not match. clcode: " + strD + ", view address: " + str2 + ", views hierarchy: " + cVar.x());
                return false;
            }
        }
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, String str2, String str3, boolean z) {
        boolean z2;
        Set<d> setKeySet;
        boolean z3;
        Logger.d(this.f8026a, "set ad click URL started, sdkPackageName: " + str2 + ", url: " + str + ", view address: " + str3 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        List<CreativeInfo> listA = a(str2, str3);
        if (listA != null) {
            boolean z4 = false;
            for (CreativeInfo creativeInfo : listA) {
                if (creativeInfo.ai().equals(str3) && !creativeInfo.al() && (z || TextUtils.isEmpty(creativeInfo.O()) || creativeInfo.an())) {
                    Logger.d(this.f8026a, "check ad click URL validity - view address: " + str3 + ", updating click_url in pending CIs list. url = " + str + ", adId = " + creativeInfo.N());
                    creativeInfo.a(str, false);
                    z3 = true;
                } else {
                    z3 = z4;
                }
                z4 = z3;
            }
            z2 = z4;
        } else {
            z2 = false;
        }
        if (str != null) {
            synchronized (J) {
                setKeySet = J.keySet();
            }
            if (!setKeySet.isEmpty()) {
                Iterator<d> it = setKeySet.iterator();
                while (true) {
                    boolean z5 = z2;
                    if (!it.hasNext()) {
                        return z5;
                    }
                    e eVar = J.get(it.next());
                    if (eVar == null || eVar.c() == null || !SdksMapping.isSameSdkByPackages(eVar.c(), str2) || !a(eVar, str, str3)) {
                        z2 = z5;
                    } else {
                        if (!eVar.d() && (z || O == null)) {
                            Logger.d(this.f8026a, "set ad click URL - current activity banner is not marked as clicked, setting candidate: " + str);
                            h(str, str3);
                        } else if (eVar.e() == null) {
                            com.safedk.android.utils.n.b(this.f8026a, "set ad click URL - no click URL yet, setting click URL: " + str + ", CI: " + eVar.j());
                            if (eVar.c(str)) {
                                a(eVar, false, "setCurrentAdClickURL");
                            }
                        } else {
                            com.safedk.android.utils.n.b(this.f8026a, "set ad click URL - click URL already set: " + eVar.e() + ", CI: " + eVar.j());
                        }
                        z2 = true;
                    }
                }
            } else {
                return z2;
            }
        } else {
            return z2;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void a(String str, String str2, String str3) {
    }

    public void o(String str) {
        Set<d> setKeySet;
        Logger.d(this.f8026a, "stop taking screenshots started, address = " + str + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        synchronized (J) {
            setKeySet = J.keySet();
        }
        if (!setKeySet.isEmpty()) {
            Iterator<d> it = setKeySet.iterator();
            while (it.hasNext()) {
                e eVar = J.get(it.next());
                Logger.d(this.f8026a, "stop taking screenshots - checking banner info address = " + eVar.K);
                if (eVar.K != null && eVar.K.equals(str)) {
                    Logger.d(this.f8026a, "_AD_CAPTURE_ stop taking screenshots - address found. setting requestNoSamplingReceived. banner info address = " + eVar.K);
                    eVar.O = true;
                    for (k kVar : eVar.g()) {
                        if (kVar.i() != null && str != null && str.equals(kVar.i().ai())) {
                            a(kVar);
                            if (kVar.c != null && kVar.c.b != null) {
                                Logger.d(this.f8026a, "stop taking screenshots - removing hash and file " + kVar.c.b);
                                BrandSafetyUtils.d(kVar.c.b);
                                kVar.c.f8109a = null;
                            }
                        }
                    }
                    a(eVar, false, "stopTakingScreenshotsForImpression");
                }
            }
        }
    }

    private boolean a(int i) {
        boolean zB = BrandSafetyUtils.b(i);
        Logger.d(this.f8026a, "should stop sampling, max uniformed pixels count=" + i + ", return value=" + zB);
        return zB;
    }

    @Override // com.safedk.android.internal.a
    public void g() {
        Set<d> setKeySet;
        Logger.d(this.f8026a, "on background started");
        synchronized (J) {
            setKeySet = J.keySet();
        }
        Iterator<d> it = setKeySet.iterator();
        while (it.hasNext()) {
            e eVar = J.get(it.next());
            if (eVar != null && eVar.aa && eVar.p == this.c) {
                eVar.a(l.z, new l.a[0]);
                a(eVar, false, "onBackground");
            }
        }
    }

    @Override // com.safedk.android.internal.a
    public void h() {
        Set<d> setKeySet;
        Logger.d(this.f8026a, "on foreground started");
        synchronized (J) {
            setKeySet = J.keySet();
        }
        Iterator<d> it = setKeySet.iterator();
        while (it.hasNext()) {
            e eVar = J.get(it.next());
            if (eVar != null && eVar.aa && eVar.p == this.c) {
                eVar.a(l.A, new l.a[0]);
                a(eVar, false, "onForeground");
            }
        }
    }

    private void h(String str, String str2) {
        O = new h(System.currentTimeMillis(), str, str2);
    }

    public static void a(String str, MaxAdView maxAdView, BrandSafetyUtils.AdType adType) {
        if (str != null && maxAdView != null) {
            String strA = BrandSafetyUtils.a(maxAdView);
            synchronized (Q) {
                Q.put(strA, adType);
            }
            List<WeakReference<MaxAdView>> arrayList = P.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                synchronized (P) {
                    P.put(str, arrayList);
                }
                Logger.d("BannerFinder", "add Max ad view: added adUnitId: " + str + " to maxAdViews map, isOnUiThread = " + com.safedk.android.utils.n.c());
            } else if (arrayList.get(0).get() == maxAdView) {
                return;
            }
            arrayList.add(0, new WeakReference<>(maxAdView));
            Logger.d("BannerFinder", "add Max ad view: " + maxAdView + ", address: " + BrandSafetyUtils.a(maxAdView) + ", list size: " + arrayList.size());
        }
    }

    public static void a(MaxAdView maxAdView) {
        String strA = BrandSafetyUtils.a(maxAdView);
        synchronized (Q) {
            Q.remove(strA);
        }
        synchronized (P) {
            Iterator<String> it = P.keySet().iterator();
            while (it.hasNext()) {
                if (a(it.next(), maxAdView)) {
                    return;
                }
            }
        }
    }

    public static boolean a(String str, MaxAdView maxAdView) {
        List<WeakReference<MaxAdView>> list = P.get(str);
        if (maxAdView != null && list != null) {
            for (WeakReference<MaxAdView> weakReference : list) {
                if (weakReference != null && maxAdView == weakReference.get()) {
                    weakReference.clear();
                    list.remove(weakReference);
                    Logger.d("BannerFinder", "remove Max ad view: " + maxAdView + ", address: " + BrandSafetyUtils.a(maxAdView) + ", list size: " + list.size() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                    if (list.isEmpty()) {
                        synchronized (P) {
                            P.remove(str);
                        }
                        Logger.d("BannerFinder", "remove Max ad view: removing adUnitId: " + str + " from maxAdViews");
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.f
    public void b(k kVar) {
        a(kVar);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e f7968a;
        WeakReference<View> b;
        ScheduledFuture<?> d;
        int e;
        int f;
        int c = 0;
        int g = 0;
        boolean h = false;

        public a(e eVar, WeakReference<View> weakReference, int i, d dVar) {
            WeakReference<View> weakReferenceA;
            this.f = 0;
            this.f = 0;
            this.b = weakReference;
            this.f7968a = eVar;
            this.e = i;
            String strA = BrandSafetyUtils.a(weakReference.get());
            if (eVar != null) {
                eVar.av = dVar;
                eVar.K = strA;
                k kVarI = eVar.i();
                Logger.d(BannerFinder.this.f8026a, "impression handler task, webviewAddress: " + strA + ", impression is: " + kVarI + " CI is: " + (kVarI != null ? kVarI.i() : null) + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                if (kVarI != null && kVarI.i() != null) {
                    com.safedk.android.analytics.brandsafety.creatives.g.a(eVar.v, strA, kVarI);
                }
            } else {
                Logger.d(BannerFinder.this.f8026a, "impression handler task, currentActivityBanner is null with webview address: " + strA);
            }
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(eVar.c());
            if (adNetworkDiscoveryI != null && (weakReferenceA = adNetworkDiscoveryI.a(dVar)) != null && weakReferenceA.get() != null) {
                this.b = weakReferenceA;
                Logger.d(BannerFinder.this.f8026a, "Impression handler task, view to take screenshot updated to: " + this.b.get());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f++;
                Logger.d(BannerFinder.this.f8026a, "impression handler task start, timerIterationCounter: " + this.f + ", impression is: " + this.f7968a);
                if (this.f7968a != null) {
                    this.c++;
                    if (com.safedk.android.utils.n.a((Reference<?>) this.f7968a.af)) {
                        if (this.c > this.e || this.f7968a.ac) {
                            Logger.d(BannerFinder.this.f8026a, "Impression handler task - Going to report banner, eventId=" + this.f7968a.L + ", stopTimerAndReport=" + this.f7968a.ac + ", image counter=" + this.c + ", max attempts=" + this.e + ", isImpressionReported=" + this.f7968a.E);
                            if (!this.f7968a.E) {
                                BannerFinder.this.a(this.f7968a, false, "ImpressionHandlerTask");
                            }
                            BannerFinder.this.a(this.f7968a.av, this.d);
                            return;
                        }
                        int iE = this.f7968a.E();
                        if (iE > 0 && (this.b.get() instanceof ViewGroup)) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(this.b);
                            com.safedk.android.analytics.brandsafety.b.c((ViewGroup) this.b.get(), arrayList);
                            Logger.d(BannerFinder.this.f8026a, "take screenshot (for screenshots) - views hierarchy : " + arrayList);
                            if (iE < arrayList.size()) {
                                this.b = (WeakReference) arrayList.get(iE);
                                Logger.d(BannerFinder.this.f8026a, "take screenshot - get screenshot view, index: " + iE + ", view: " + this.b.get());
                            } else {
                                this.f7968a.G();
                                Logger.d(BannerFinder.this.f8026a, "take screenshot - reset screenshot view: " + this.b.get());
                            }
                        }
                        if (!this.f7968a.O) {
                            if (BannerFinder.this.a(this.f7968a, this.f)) {
                                if (com.safedk.android.utils.n.a((Reference<?>) this.b)) {
                                    a(this.f7968a, this.b.get());
                                    if ((this.b.get() instanceof ViewGroup) && CreativeInfoManager.a(this.f7968a.c(), AdNetworkConfiguration.SHOULD_EXTRACT_TEXT_FROM_NATIVE_BANNERS, false)) {
                                        BannerFinder.this.a((ViewGroup) this.b.get(), this.f7968a);
                                        return;
                                    }
                                    return;
                                }
                                Logger.d(BannerFinder.this.f8026a, "Impression handler task - view is not alive, can't taking screenshot");
                                return;
                            }
                            return;
                        }
                        Logger.d(BannerFinder.this.f8026a, "no creative info yet or request no sampling received, current activity banner = " + this.f7968a);
                        return;
                    }
                    Logger.d(BannerFinder.this.f8026a, "Impression handler task - timer task cannot be started: banner activity=" + (!com.safedk.android.utils.n.a((Reference<?>) this.f7968a.af) ? "" : this.f7968a.af.get().getClass().getName()) + ", current activity banner=" + this.f7968a);
                }
            } catch (Throwable th) {
                Logger.e(BannerFinder.this.f8026a, "Impression handler task - exception: ", th);
            }
        }

        private void a(final e eVar, final View view) {
            try {
                if (eVar == null || view == null) {
                    Logger.d(BannerFinder.this.f8026a, "taking screenshot, view=" + view + ", currentActivityBanner=" + eVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                } else {
                    Logger.d(BannerFinder.this.f8026a, "taking screenshot, view=" + view + ", event id=" + eVar.L + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                    eVar.c();
                    WeakReference<Activity> weakReference = eVar.af;
                    if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                        weakReference.get().runOnUiThread(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BannerFinder.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Logger.d(BannerFinder.this.f8026a, "taking screenshot, using old method");
                                final Bitmap bitmapA = ScreenshotHelper.a(view, SafeDK.getInstance().ab(), eVar);
                                if (bitmapA == null) {
                                    eVar.F();
                                    Logger.d(BannerFinder.this.f8026a, "taking screenshot, black screenshot detected index = " + eVar.E());
                                }
                                BannerFinder.this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BannerFinder.a.1.1
                                    @Override // java.lang.Runnable
                                    public void run() throws Throwable {
                                        BannerFinder.this.a(eVar, bitmapA, a.this.c);
                                    }
                                });
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                Logger.e(BannerFinder.this.f8026a, "error while taking screenshot", th);
                Logger.printStackTrace();
                new CrashReporter().caughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, Bitmap bitmap, int i) throws Throwable {
        if (bitmap != null) {
            String strC = eVar.c();
            BrandSafetyUtils.a aVarB = BrandSafetyUtils.b(strC, bitmap);
            int iA = aVarB.a();
            BrandSafetyUtils.ScreenshotValidity screenshotValidityB = BrandSafetyUtils.b(strC, aVarB);
            if (screenshotValidityB == BrandSafetyUtils.ScreenshotValidity.VALID) {
                String strA = BrandSafetyUtils.a(bitmap);
                BrandSafetyUtils.ScreenShotOrientation screenShotOrientationB = BrandSafetyUtils.b(bitmap);
                k kVarI = eVar.i();
                String strA2 = BrandSafetyUtils.a(bitmap, this.c, strA, strC, kVarI.f8110a, screenShotOrientationB);
                if (!d(strA2, strC, strA)) {
                    Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - image is not valid : " + strA2);
                }
                Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - screenshot file created, counter = " + i + " filename = " + strA2 + ", hash = " + strA);
                long jC = BrandSafetyUtils.c(strA2);
                Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - hash " + strA + ", stored file size is " + jC + " bytes, counter is " + i + ", uniform pixel count is " + iA + " (" + ((iA / 500.0f) * 100.0f) + "%)");
                int size = this.C.size();
                if (!d(strA, kVarI.f8110a)) {
                    if (size <= SafeDK.getInstance().J()) {
                        if (kVarI.c != null && kVarI.c.f8109a != null && !kVarI.c.f8109a.equals(strA)) {
                            Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - removing ad file " + kVarI.c.b);
                            BrandSafetyUtils.d(kVarI.c.b);
                        }
                        kVarI.b("img", new l.a("typ", l.X));
                        Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - setting data hash = " + strA + ", file name = " + strA2 + ", file size = " + jC + ", max uniformed pixel count = " + iA + ", image counter = " + i);
                        kVarI.c = new j(strA, strA2, jC, iA, i, screenShotOrientationB, false);
                        a(eVar, false, "processScreenshot");
                    } else if (!c(strA, kVarI.f8110a)) {
                        Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - No open slot for " + strA + "_" + kVarI.f8110a);
                        BrandSafetyUtils.d(strA2);
                    } else {
                        Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - Image " + strA + "_" + kVarI.f8110a + " is already scheduled for upload");
                    }
                } else {
                    Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - Not saving file for " + strA + "_" + kVarI.f8110a);
                    BrandSafetyUtils.d(strA2);
                }
                if (a(iA)) {
                    if (!TextUtils.isEmpty(strA)) {
                        eVar.e(true);
                        eVar.ac = true;
                    }
                    kVarI.a("img", new l.a("typ", l.Y));
                    return;
                }
                return;
            }
            if (screenshotValidityB == BrandSafetyUtils.ScreenshotValidity.UNIFORMITY_BLACK || screenshotValidityB == BrandSafetyUtils.ScreenshotValidity.UNIFORMITY_VERY_HIGH) {
                eVar.F();
                Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot, black/uniform screenshot detected, index = " + eVar.E());
            } else {
                Logger.d(this.f8026a, "_AD_CAPTURE_ process screenshot - screenshot is not valid: " + screenshotValidityB.name() + ", pixel count: " + iA + ", counter = " + i + ", try again...");
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public void a(final Bitmap bitmap, final c cVar) {
        this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BannerFinder.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                e eVar = (e) cVar;
                BannerFinder.this.a(eVar, bitmap, eVar.am.c);
            }
        });
    }

    protected boolean a(e eVar, long j) {
        if (eVar == null || com.safedk.android.utils.e.a((c) eVar)) {
            Logger.d(this.f8026a, "_MEMORY_LOAD_ don't take screenshot, ad info: " + eVar + ", low memory");
            return false;
        }
        if (!SafeDK.getInstance().I()) {
            CreativeInfo creativeInfoJ = eVar.j();
            if (creativeInfoJ == null) {
                Logger.d(this.f8026a, "_AD_CAPTURE_ don't take screenshot, no creative info yet");
            } else {
                boolean zA = CreativeInfoManager.a(eVar.v, AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false);
                if (creativeInfoJ.al() && !zA) {
                    Logger.d(this.f8026a, "_AD_CAPTURE_ don't take screenshot, multi ad, sdk: " + eVar.v);
                } else {
                    Logger.d(this.f8026a, "_AD_CAPTURE_ take screenshot, banner ad");
                    return true;
                }
            }
            return false;
        }
        Logger.d(this.f8026a, "_AD_CAPTURE_ take screenshot, SafeDK Config item 'AlwaysTakeScreenshot' is true");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(d dVar, Bundle bundle, String str) {
        e eVar = J.get(dVar);
        if (eVar == null || dVar.g == null) {
            return false;
        }
        d dVar2 = S.get(dVar.f8095a);
        if (dVar2 != null && !dVar2.equals(dVar)) {
            Logger.d(this.f8026a, "clear CI from banner info - a new banner has loaded instead, not deleting it");
            return false;
        }
        Logger.d(this.f8026a, "clear CI from banner info started with maxCreativeId: " + str + " and webview address: " + dVar.g + " and adInfoKey: " + dVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        Logger.d(this.f8026a, "clear CI from banner info started with impressions size: " + eVar.g().size() + " banner info: " + eVar);
        List<k> listG = eVar.g();
        for (k kVar : listG) {
            a(kVar);
            if (StatsCollector.c() != null) {
                StatsCollector.c().a(kVar.f8110a);
            }
        }
        listG.clear();
        long j = eVar.ai;
        long j2 = eVar.aj;
        e eVarA = a(eVar.af.get(), eVar.v, dVar.c, bundle);
        eVarA.aa = true;
        eVarA.ag = true;
        eVarA.ai = j;
        eVarA.aj = j2;
        eVarA.ah = true;
        synchronized (J) {
            J.put(dVar, eVarA);
        }
        Logger.d(this.f8026a, "handle WILL_DISPLAY New activity banner created for " + eVarA.v + ", banner key is " + dVar + ", current activity banners size is " + J.size());
        dVar.h = null;
        return true;
    }

    private boolean a(String str, WeakReference<MaxAdView> weakReference, d dVar) {
        if (!CreativeInfoManager.a(str, AdNetworkConfiguration.WEBVIEW_REPLACE_ON_AD_DISPLAY_FAIL, false) || dVar.g == null) {
            return false;
        }
        List<WeakReference<View>> listA = a((ViewGroup) weakReference.get());
        List<String> listC = c(listA);
        List<WeakReference<WebView>> listB = b(listA);
        Logger.d(this.f8026a, "find banner impression - webview is: " + dVar.g + " there are " + listB.size() + " webViews and the views addresses list is: " + listC + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (listC.contains(dVar.g) || listB.size() <= 0) {
            return false;
        }
        Logger.d(this.f8026a, "find banner impression - did not find webview address " + dVar.g + " inside the views list, first webview address is: " + BrandSafetyUtils.a((Object) listB.get(0).get()));
        return true;
    }

    protected Boolean a(String str, String str2, d dVar, String str3, List<WeakReference<View>> list, List<String> list2, List<WeakReference<WebView>> list3) {
        try {
            List<WeakReference<MaxAdView>> list4 = P.get(dVar.f8095a);
            if (list4 != null) {
                synchronized (list4) {
                    for (WeakReference<MaxAdView> weakReference : list4) {
                        if (weakReference.get() != null) {
                            Logger.d(this.f8026a, "find banner impression - sdk: " + str + ", ad unit id: " + dVar.f8095a + ", max ad view: " + weakReference.get().toString() + ", address: " + BrandSafetyUtils.a(weakReference.get()) + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                            b(weakReference.get(), list3);
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            list2.add(BrandSafetyUtils.a(weakReference.get()));
                            arrayList2.add("h1c1:" + weakReference.get().toString());
                            String strN = BrandSafetyUtils.n(str3);
                            dVar.i = a(str, weakReference, dVar);
                            a(weakReference.get(), str, strN, str2, dVar, list, arrayList, list2, arrayList2, 1, false, false);
                            com.safedk.android.utils.n.b(this.f8026a, "find banner impression - views hierarchy: " + arrayList2);
                            if (!list.isEmpty()) {
                                Logger.d(this.f8026a, "find banner impression - found views: " + arrayList);
                                return true;
                            }
                            if (TextUtils.isEmpty(strN) || list2.contains(strN)) {
                                Logger.d(this.f8026a, "find banner impression - no new views found for top view: " + weakReference.get().toString());
                                return true;
                            }
                            list2.clear();
                            list.clear();
                            return false;
                        }
                        Logger.d(this.f8026a, "find banner impression - sdk: " + str + ", ad unit id: " + dVar.f8095a + ", max ad view not valid");
                    }
                }
            }
        } catch (Throwable th) {
            Logger.e(this.f8026a, "Failed while scanning the screen for banners", th);
            new CrashReporter().caughtException(th);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x01af A[EDGE_INSN: B:41:0x01af->B:32:0x015a BREAK  A[LOOP:1: B:27:0x0125->B:65:?]] */
    public void a(List<WeakReference<View>> list, final List<WeakReference<WebView>> list2, d dVar, long j) {
        boolean z;
        Logger.d(this.f8026a, "report completed banners started, views = " + list + ", adInfoKey = " + dVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        final ArrayList arrayList = new ArrayList();
        synchronized (BannerFinder.class) {
            for (Map.Entry<d, e> entry : J.entrySet()) {
                d key = entry.getKey();
                if (key.equals(dVar)) {
                    Logger.d(this.f8026a, "report completed banners, skipping banner info of new impression, key=" + key);
                } else if (!key.f8095a.equals(dVar.f8095a)) {
                    Logger.d(this.f8026a, "report completed banners, skipping banner info of another adUnitId, key=" + key);
                } else if (j <= entry.getValue().ai) {
                    Logger.d(this.f8026a, "report completed banners, skipping banner info of later impression, key=" + key);
                } else if (!entry.getValue().ag) {
                    Logger.d(this.f8026a, "report completed banners, skipping banner info still not displayed impression, key=" + key);
                } else {
                    Logger.d(this.f8026a, "report completed banners, check to report banner info, adInfoKey=" + key);
                    e value = entry.getValue();
                    if (value.K == null) {
                        z = false;
                        break;
                    }
                    Logger.d(this.f8026a, "report completed banners, looking for completed banners to report, WebView=" + value.K);
                    if (list == null) {
                        z = false;
                        break;
                    }
                    Iterator<WeakReference<View>> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        String strA = BrandSafetyUtils.a(it.next().get());
                        if (value.K.equals(strA)) {
                            Logger.d(this.f8026a, "report completed banners, WebView address still active, WebView=" + strA);
                            z = true;
                            break;
                        }
                    }
                    if (!z && value.aa) {
                        Logger.d(this.f8026a, "report completed banners, executing postponed banner reporting for eventId " + value.L);
                        value.a(l.C, new l.a[0]);
                        a(entry.getValue(), false, "reportCompletedBanners");
                        value.aa = false;
                        value.U = true;
                        arrayList.add(entry);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.E.schedule(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BannerFinder.2
                @Override // java.lang.Runnable
                public void run() {
                    for (Map.Entry entry2 : arrayList) {
                        Logger.d(BannerFinder.this.f8026a, "report completed banners starting reporting for eventId " + ((e) entry2.getValue()).L);
                        if (!BannerFinder.this.M.contains(((d) entry2.getKey()).c)) {
                            BannerFinder.this.a((e) entry2.getValue(), true, "reportCompletedBannersTask");
                            synchronized (BannerFinder.class) {
                                BannerFinder.J.remove(entry2.getKey());
                            }
                            BannerFinder.this.a((e) entry2.getValue());
                            com.safedk.android.analytics.brandsafety.creatives.g.a((List<WeakReference<WebView>>) list2);
                        }
                    }
                }
            }, 3L, TimeUnit.SECONDS);
        }
    }

    protected void a(ViewGroup viewGroup, String str, String str2, String str3, d dVar, List<WeakReference<View>> list, List<w> list2, List<String> list3, List<String> list4, int i, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        if (viewGroup != null) {
            int i2 = i + 1;
            int i3 = 0;
            while (i3 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i3);
                String strA = BrandSafetyUtils.a(childAt);
                list3.add(strA);
                list4.add("h" + i2 + ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM + (i3 + 1) + ":" + childAt);
                if (TextUtils.isEmpty(str2)) {
                    z3 = true;
                } else if (str2.equals(strA)) {
                    Logger.d(this.f8026a, "scan for banner views - verified by ad network view address received from Max: " + str2 + ", view: " + childAt + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                    z3 = true;
                } else {
                    z3 = z;
                }
                e eVar = J.get(dVar);
                if (z3) {
                    boolean zA = a(viewGroup, str, dVar);
                    if ((eVar != null && eVar.j() == null && eVar.m != null && !eVar.m.isEmpty()) || !CreativeInfoManager.a(str, AdNetworkConfiguration.AVOID_MATCHING_CI_FROM_BANNER_WEB_VIEW_BEFORE_SCANNING, false)) {
                        boolean zA2 = CreativeInfoManager.a(str, AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, false);
                        boolean zA3 = CreativeInfoManager.a(str, AdNetworkConfiguration.SHOULD_SCAN_OBJECT_USING_REFLECTION, false);
                        boolean zA4 = CreativeInfoManager.a(str, AdNetworkConfiguration.SUPPORTS_NATIVE_BANNERS_USING_BANNER_KEY, false);
                        if (zA2) {
                            if (a(childAt, str, str3, dVar)) {
                                return;
                            }
                        } else if (zA3) {
                            b(childAt, str, str3, dVar);
                        } else if (zA) {
                            String strB = BrandSafetyUtils.b(childAt.getClass());
                            if (CreativeInfoManager.a(strB, AdNetworkConfiguration.SHOULD_SCAN_OBJECT_USING_REFLECTION, false)) {
                                b(childAt, strB, str3, dVar);
                            }
                        } else if (zA4) {
                            a(childAt, str, dVar);
                        }
                    }
                }
                if (z3 && (childAt instanceof WebView)) {
                    a(childAt, str, list, list2, dVar);
                    return;
                }
                if (z3 && a(str, childAt)) {
                    a(childAt, str, list, list2, dVar);
                    z4 = true;
                } else {
                    z4 = z2;
                }
                if ((childAt instanceof TextView) && z4) {
                    if (eVar != null && eVar.j() != null && !eVar.H()) {
                        TextView textView = (TextView) childAt;
                        eVar.i().b("text:" + textView.getText().toString());
                        Logger.d(this.f8026a, "scan for banner views - added text " + textView.getText().toString());
                    }
                } else if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, str, str2, str3, dVar, list, list2, list3, list4, i2, z3, z4);
                }
                i3++;
                z2 = z4;
                z = z3;
            }
        }
    }

    protected void b(ViewGroup viewGroup, List<w> list, List<String> list2, int i) {
        if (viewGroup != null) {
            int i2 = i + 1;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i4);
                    list2.add("h" + i2 + ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM + (i4 + 1) + ":" + childAt);
                    if (childAt instanceof WebView) {
                        list.add(new w(BrandSafetyUtils.a(childAt), childAt.getClass().getName(), childAt.getWidth(), childAt.getHeight()));
                        Logger.d(this.f8026a, "found expanded view: " + childAt + ": width: " + childAt.getWidth() + " height: " + childAt.getHeight() + " sdk: " + childAt.getClass().getName());
                    } else if (childAt instanceof ViewGroup) {
                        b((ViewGroup) childAt, list, list2, i2);
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    protected void a(ViewGroup viewGroup, e eVar) {
        Logger.d(this.f8026a, "collect banner text started. view : " + viewGroup + ", bannerInfo : " + eVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (viewGroup != null) {
            if (eVar.H()) {
                Logger.d(this.f8026a, "collect banner text - ad is a native ad: " + viewGroup + ", child count is: " + viewGroup.getChildCount());
                return;
            }
            Logger.d(this.f8026a, "collect banner text - view is: " + viewGroup + ", child count is: " + viewGroup.getChildCount());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i2);
                    Logger.d(this.f8026a, "collect banner text - child view " + i2 + " is: " + childAt);
                    if (childAt instanceof TextView) {
                        Logger.d(this.f8026a, "collect banner text - text box found. view " + childAt);
                        if (eVar != null && eVar.j() != null) {
                            TextView textView = (TextView) childAt;
                            eVar.i().b("text:" + textView.getText().toString());
                            Logger.d(this.f8026a, "collect banner text - added text " + textView.getText().toString());
                        }
                    } else if (childAt instanceof ViewGroup) {
                        a((ViewGroup) childAt, eVar);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    protected void a(View view, String str, List<WeakReference<View>> list, List<w> list2, d dVar) {
        String strA = BrandSafetyUtils.a(view);
        Logger.d(this.f8026a, "handle ad view - view is an instance of " + view.getClass().getName() + " : " + strA + ", class : " + view.getClass().getCanonicalName() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        String sdkPackageByClass = SdksMapping.getSdkPackageByClass(view.getClass().getName());
        e eVar = J.get(dVar);
        Logger.d(this.f8026a, "handle ad view - sdk of view: " + sdkPackageByClass + ", sdk: " + str + " and event id: " + dVar.c);
        boolean z = eVar != null && eVar.T;
        if ((c(view) || z || sdkPackageByClass == null || sdkPackageByClass.equals(str)) && !q(strA)) {
            list2.add(new w(strA, view.getClass().getName(), view.getWidth(), view.getHeight()));
            list.add(new WeakReference<>(view));
            Logger.d(this.f8026a, "found view: " + view + ": width: " + view.getWidth() + " height: " + view.getHeight() + " sdk: " + view.getClass().getName());
        }
        Logger.d(this.f8026a, "view is not a valid instance of web view, or web view already matched, view: " + view);
    }

    public static boolean c(View view) {
        return view != null && view.getClass().getName().equals(com.safedk.android.analytics.brandsafety.creatives.discoveries.d.r);
    }

    private boolean a(View view, String str, String str2, d dVar) {
        e eVar;
        String strA;
        List<CreativeInfo> listT;
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
        if (adNetworkDiscoveryI != null && (eVar = J.get(dVar)) != null && eVar.j() == null && eVar.m != null && (strA = adNetworkDiscoveryI.a(view, dVar.f)) != null) {
            Logger.d(this.f8026a, "extract ad ID from view - ad ID extracted from view: " + strA + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            if (CreativeInfoManager.a(str, AdNetworkConfiguration.AD_ID_EXTRACTED_FROM_BANNER_WEB_VIEW_IS_MAX_CREATIVE_ID, false) && str2 != null && !str2.equals(strA)) {
                Logger.d(this.f8026a, "extract ad ID from view - value extracted (" + strA + ") from widget is not equal to creative ID (" + str2 + ")");
                return true;
            }
            Logger.d(this.f8026a, "extract ad ID from view - attempting to locate ci by ad ID value " + strA + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            CreativeInfo creativeInfoA = adNetworkDiscoveryI.a((Object) strA);
            if (creativeInfoA != null) {
                Logger.d(this.f8026a, "extract ad ID from view - CI found, ad ID = " + strA + ", view : " + view.toString() + ", ci : " + creativeInfoA.aa());
                creativeInfoA.a((Object) view);
                creativeInfoA.h(dVar.c);
                creativeInfoA.j(dVar.b);
                b(creativeInfoA, eVar);
                Logger.d(this.f8026a, "extract ad ID from view - ci placementId set to " + dVar.b + ", event ID : " + dVar.c + " , ad type  = " + creativeInfoA.M());
                a(new o(creativeInfoA, CreativeInfo.n));
                adNetworkDiscoveryI.r(strA);
                if (creativeInfoA.al() && (listT = adNetworkDiscoveryI.t(creativeInfoA.N())) != null && !listT.isEmpty() && creativeInfoA.Y() != null) {
                    for (CreativeInfo creativeInfo : listT) {
                        creativeInfo.c(creativeInfoA.ai(), creativeInfoA.ah());
                        com.safedk.android.utils.n.b(this.f8026a, "handle multi ad ci matching. ci: " + creativeInfo.aa());
                        CreativeInfoManager.a(creativeInfo, creativeInfoA.Y(), creativeInfoA.X());
                    }
                }
            } else {
                Logger.d(this.f8026a, "extract ad ID from view - CI not found, adId = " + strA);
            }
        }
        return false;
    }

    private void b(final View view, final String str, final String str2, final d dVar) {
        final boolean z = false;
        final e eVar = J.get(dVar);
        final boolean zA = CreativeInfoManager.a(str, AdNetworkConfiguration.WEBVIEW_REPLACE_ON_AD_DISPLAY_FAIL, false);
        final String strA = BrandSafetyUtils.a(view);
        d dVar2 = S.get(dVar.f8095a);
        if (dVar.i && !dVar.g.equals(strA) && (dVar2 == null || dVar2.equals(dVar))) {
            z = true;
        }
        Logger.d(this.f8026a, "try to match using reflection, sdk:" + str + ", view: " + view + ", isWebviewChange: " + z + ", info: " + eVar);
        if (eVar != null) {
            if (eVar.k().isEmpty() || z) {
                this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BannerFinder.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (zA && !eVar.k().isEmpty() && (!z || !(view instanceof WebView))) {
                                Logger.d(BannerFinder.this.f8026a, "try to match using reflection, exit");
                                return;
                            }
                            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
                            if (adNetworkDiscoveryI != null) {
                                List<CreativeInfo> listA = adNetworkDiscoveryI.a(new WeakReference<>(view), str2, dVar.f);
                                if (listA == null || listA.isEmpty()) {
                                    Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - reflect CI not found for max creative Id: " + str2 + " and creative info size is: " + eVar.k().size());
                                    return;
                                }
                                Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - ad info's webview is: " + dVar.g + " and view address is: " + strA + " and max creative id: " + str2 + " and banner info CI list size is: " + eVar.k().size() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                                Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - is the view webView? " + (view instanceof WebView) + " and event id is: " + dVar.c);
                                for (CreativeInfo creativeInfo : listA) {
                                    creativeInfo.a((Object) view);
                                    creativeInfo.a(BannerFinder.this.c);
                                    creativeInfo.h(dVar.c);
                                    String strH = creativeInfo.H();
                                    creativeInfo.j(dVar.b);
                                    if (creativeInfo.N() == null) {
                                        creativeInfo.r(creativeInfo.P());
                                    }
                                    Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - reflect CI found, view : " + view + " did webview replaced? " + z + ", ci : " + creativeInfo.aa());
                                    Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - current adInfoKey's MatchedCIId is: " + dVar.h);
                                    String strB = creativeInfo.O() != null ? com.safedk.android.utils.k.b(creativeInfo.O()) : null;
                                    Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - click url is: " + strB);
                                    if (dVar.h != null && creativeInfo.N() != null) {
                                        boolean zA2 = false;
                                        if (dVar.i && !dVar.h.contains(creativeInfo.N() + "##") && ((strH == null || !dVar.h.contains("##" + strH)) && (strB == null || !dVar.h.contains("**" + strB)))) {
                                            zA2 = BannerFinder.this.a(dVar, eVar.A, str2);
                                        }
                                        if (!zA2 && dVar.h != null && (dVar.h.contains(creativeInfo.N() + "##") || dVar.h.contains("##" + strH) || dVar.h.contains("**" + strB))) {
                                            Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - redundant CI, exiting with event id - " + dVar.c);
                                            return;
                                        }
                                    }
                                    dVar.g = strA;
                                    String str3 = creativeInfo.N() + "##" + strH + "**" + strB;
                                    if (dVar.h == null || !dVar.h.contains(str3)) {
                                        d dVar3 = dVar;
                                        if (dVar.h != null) {
                                            str3 = dVar.h + l.ac + str3;
                                        }
                                        dVar3.h = str3;
                                    }
                                    BannerFinder.this.a(new o(creativeInfo, CreativeInfo.n), dVar);
                                }
                            }
                        } catch (Throwable th) {
                            Logger.e(BannerFinder.this.f8026a, "extract ad ID from view - exception occurred: " + th.getMessage(), th);
                        }
                    }
                });
            }
        }
    }

    private void a(final View view, final String str, final d dVar) {
        e eVar = J.get(dVar);
        if (eVar != null && eVar.k().isEmpty() && a(str, view) && eVar.H()) {
            com.safedk.android.utils.n.b(this.f8026a, "extract ad ID from view - info :" + eVar + ", ci : " + eVar.k());
            Logger.d(this.f8026a, "extract ad ID from view - attempting to find CI by adInfoKey " + dVar);
            this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BannerFinder.4
                @Override // java.lang.Runnable
                public void run() {
                    AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
                    if (adNetworkDiscoveryI != null) {
                        CreativeInfo creativeInfoA = adNetworkDiscoveryI.a((Object) (dVar.b + "_" + dVar.c + "_" + dVar.d));
                        if (creativeInfoA != null) {
                            Logger.d(BannerFinder.this.f8026a, "extract ad ID from view -  find CI by key found, adInfoKey : " + dVar + ", creativeInfo : " + creativeInfoA + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                            creativeInfoA.a((Object) view);
                            creativeInfoA.a(BannerFinder.this.c);
                            creativeInfoA.h(dVar.c);
                            creativeInfoA.j(dVar.b);
                            if (creativeInfoA.N() == null) {
                                creativeInfoA.r(creativeInfoA.P());
                            }
                            Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - reflect ci placement ID set to " + dVar.b + ", event ID : " + dVar.c);
                            BannerFinder.this.a(new o(creativeInfoA, CreativeInfo.n));
                            return;
                        }
                        Logger.d(BannerFinder.this.f8026a, "extract ad ID from view - reflect CI not found");
                    }
                }
            });
        }
    }

    private void b(CreativeInfo creativeInfo, e eVar) {
        BrandSafetyEvent.AdFormatType adFormatType;
        Logger.d(this.f8026a, "update ad format : started, sdk = " + creativeInfo.S() + ", initial ad type = " + creativeInfo.K() + " , bannerInfo = " + eVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (CreativeInfoManager.a(creativeInfo.S(), AdNetworkConfiguration.SET_AD_FORMAT_FROM_APPLOVIN_BUNDLE, false)) {
            if (eVar.I()) {
                adFormatType = BrandSafetyEvent.AdFormatType.MREC;
            } else {
                adFormatType = BrandSafetyEvent.AdFormatType.BANNER;
            }
            creativeInfo.a(adFormatType);
            Logger.d(this.f8026a, "update ad type. ad type set to " + adFormatType);
        }
    }

    private boolean a(ViewGroup viewGroup, String str, d dVar) {
        e eVar;
        String strA = BrandSafetyUtils.a((Class) viewGroup.getClass());
        if (TextUtils.isEmpty(strA) || strA.equals(str) || !strA.equals(com.safedk.android.utils.h.h) || (eVar = J.get(dVar)) == null) {
            return false;
        }
        eVar.T = true;
        return true;
    }

    private String a(View view, String str) {
        String strA = BrandSafetyUtils.a((Class) view.getClass());
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        if (TextUtils.isEmpty(str)) {
            return view.getClass().getName();
        }
        return str;
    }

    public void c(final Activity activity) {
        if (com.safedk.android.utils.n.c()) {
            this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.BannerFinder.5
                @Override // java.lang.Runnable
                public void run() {
                    BannerFinder.this.d(activity);
                }
            });
        } else {
            d(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity) {
        Logger.d(this.f8026a, "start monitoring of redirect/expand, activity: " + activity + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        e eVarA = BrandSafetyUtils.a(activity);
        if (eVarA != null) {
            eVarA.ap = activity.toString();
            k kVarI = eVarA.i();
            if (kVarI != null && kVarI.e != null) {
                kVarI.e.a("redirectActivityName=" + eVarA.ap);
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void d(String str) {
        synchronized (J) {
            for (e eVar : J.values()) {
                if (eVar.an && eVar.ap != null && eVar.ap.equals(str)) {
                    a(eVar, false, "onActivityDestroyed");
                    return;
                }
            }
        }
    }

    public void a(String str, String str2, String str3, d dVar, Bundle bundle) {
        e eVarA;
        Activity activityA = a(bundle);
        if (this.M.contains(dVar.c)) {
            Logger.d(this.f8026a, "handle REVENUE_EVENT - impression with id " + dVar.c + " has already been reported, ignoring. ");
            return;
        }
        if (f(str, str2)) {
            synchronized (J) {
                eVarA = J.get(dVar);
                if (eVarA == null) {
                    eVarA = a(activityA, str2, dVar.c, bundle);
                    J.put(dVar, eVarA);
                    Logger.d(this.f8026a, "New activity banner created for " + str2 + ", banner key is " + dVar + ", current activity banners size is " + J.size() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                } else {
                    if (eVarA.A == null) {
                        eVarA.A = bundle;
                    }
                    if (eVarA.B == null || eVarA.C == null) {
                        eVarA.a(a(activityA));
                    }
                }
            }
            if (eVarA != null) {
                if (bundle.getString("revenue_event") != null) {
                    eVarA.P = bundle.getString("revenue_event");
                } else {
                    eVarA.P = "unknown";
                }
                eVarA.M = str3;
                a(eVarA, false, "handleRevenueEvent");
                Logger.d(this.f8026a, "Revenue event set to " + bundle.getString("revenue_event") + " for eventId " + dVar.c);
                eVarA.aa = true;
            }
        } else {
            this.d++;
        }
        a(str2, str3, dVar, bundle);
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean b(String str, String str2, String str3) {
        Set<d> setKeySet;
        k kVarI;
        String strD = BrandSafetyUtils.d();
        synchronized (J) {
            setKeySet = J.keySet();
        }
        Iterator<d> it = setKeySet.iterator();
        while (it.hasNext()) {
            e eVar = J.get(it.next());
            if (eVar != null && str2 != null && str2.equals(eVar.K) && (kVarI = eVar.i()) != null && kVarI.e != null && str3 != null && (str3.equals(kVarI.e.m) || str3.equals(strD))) {
                Logger.d(this.f8026a, "redirect url was loaded to the ad web view: " + str2 + " url: " + str3 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                kVarI.i().a(true);
                return true;
            }
        }
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, String str2, boolean z, String str3) {
        return false;
    }

    public static String a(MaxNativeAdView maxNativeAdView) {
        String strA = BrandSafetyUtils.a(maxNativeAdView);
        synchronized (J) {
            for (e eVar : J.values()) {
                if (eVar.m != null && eVar.m.contains(strA)) {
                    return eVar.v;
                }
            }
            return null;
        }
    }

    public void g(String str, String str2) {
        Set<d> setKeySet;
        CreativeInfo creativeInfoJ;
        AdNetworkDiscovery adNetworkDiscoveryI;
        WeakReference<View> weakReferenceA;
        Logger.d(this.f8026a, "set on video completed event has been triggered - started for sdk= " + str + ",   adId= " + str2);
        synchronized (J) {
            setKeySet = J.keySet();
        }
        for (d dVar : setKeySet) {
            e eVar = J.get(dVar);
            if (eVar != null && (creativeInfoJ = eVar.j()) != null && !TextUtils.isEmpty(creativeInfoJ.N()) && creativeInfoJ.N().equals(str2)) {
                Logger.d(this.f8026a, "set on video completed event has been triggered - found ci= " + creativeInfoJ.aa());
                eVar.i().k = true;
                eVar.A();
                a aVar = eVar.am;
                if (aVar == null && (adNetworkDiscoveryI = CreativeInfoManager.i(str)) != null && (weakReferenceA = adNetworkDiscoveryI.a(dVar)) != null && weakReferenceA.get() != null) {
                    a aVar2 = new a(eVar, weakReferenceA, this.e, dVar);
                    eVar.am = aVar2;
                    Logger.d(this.f8026a, "set on video completed event has been triggered - new task created= " + aVar2);
                    aVar = aVar2;
                }
                if (aVar != null) {
                    if (eVar.am.d != null) {
                        Logger.d(this.f8026a, "_AD_CAPTURE_ on video completed - cancelling existing taskFuture " + eVar.am.d);
                        eVar.am.d.cancel(false);
                        eVar.am.d = null;
                    }
                    eVar.am.d = this.E.scheduleWithFixedDelay(aVar, 500L, SafeDK.getInstance().aa() * 1000, TimeUnit.MILLISECONDS);
                } else {
                    Logger.d(this.f8026a, "set on video completed event has been triggered - impression handler is null, could not start future task.");
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public void b() {
        synchronized (J) {
            for (e eVar : J.values()) {
                if (eVar.aa) {
                    Logger.d(this.f8026a, "report fullscreen ad detected, stop taking screenshots, event ID: " + eVar.w() + ", type: " + eVar.p.name());
                    eVar.O = true;
                    eVar.a(l.D, new l.a[0]);
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public void c() {
        synchronized (J) {
            for (e eVar : J.values()) {
                if (eVar.aa) {
                    eVar.a(l.E, new l.a[0]);
                }
            }
        }
    }

    public int j() {
        int i = 0;
        synchronized (J) {
            Iterator<e> it = J.values().iterator();
            while (it.hasNext()) {
                i = it.next().aa ? i + 1 : i;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean a(e eVar, List<String> list, d dVar) {
        boolean z;
        String strAh;
        boolean z2 = true;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    if (eVar.K == null || list.contains(eVar.K)) {
                        z = true;
                    } else {
                        Logger.d(this.f8026a, "web view scanner - ad info view address not found in views hierarchy: " + eVar.K + " adUnitId: " + dVar.f8095a + " no res propagation");
                        z = false;
                    }
                    String strAi = null;
                    CreativeInfo creativeInfoJ = eVar.j();
                    if (creativeInfoJ != null && (strAh = creativeInfoJ.ah()) != null && WebView.class.isAssignableFrom(Class.forName(strAh)) && (strAi = creativeInfoJ.ai()) != null && !list.contains(strAi)) {
                        Logger.d(this.f8026a, "web view scanner - matching object address not found in views hierarchy: " + strAi + " adUnitId: " + dVar.f8095a + " no res propagation");
                        z2 = false;
                    }
                    if (!z || !z2) {
                        Logger.d(this.f8026a, "web view scanner - not all ad views are found in hierarchy - no propagation, adUnitId: " + dVar.f8095a + "viewAddress: " + eVar.K + " matchingObjectAddress: " + strAi);
                        return false;
                    }
                    Logger.d(this.f8026a, "web view scanner - found adInfo view in hierarchy. adUnitId: " + dVar.f8095a + " viewAddress: " + eVar.K + " matchingObjectAddress: " + strAi);
                    return true;
                }
            } catch (Exception e) {
                Logger.e(this.f8026a, "caught exception" + e.getMessage());
                return false;
            }
        }
        Logger.d(this.f8026a, "web view scanner - no views in hierarchy for info view: " + eVar.K + " adUnitId: " + dVar.f8095a + " no res propagation");
        return false;
    }

    public void a(u uVar) {
        this.R.add(uVar);
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean e(String str) {
        synchronized (J) {
            for (e eVar : J.values()) {
                if (eVar != null && eVar.aa && eVar.c() != null && eVar.c().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean p(String str) {
        Set<d> setKeySet;
        e eVar;
        if (str == null) {
            return false;
        }
        Logger.d(this.f8026a, "bannerInfoExists started, creativeId = " + str);
        synchronized (J) {
            setKeySet = J.keySet();
        }
        if (!setKeySet.isEmpty()) {
            for (d dVar : setKeySet) {
                if (dVar != null && (eVar = J.get(dVar)) != null && eVar.z() != null && eVar.z().equals(str)) {
                    Logger.d(this.f8026a, "bannerInfoExists banner info exists : " + eVar);
                    return true;
                }
            }
        }
        return false;
    }

    public void a(m mVar) {
        for (e eVar : J.values()) {
            if (eVar != null && eVar.aa && eVar.c() != null && eVar.c().equals(com.safedk.android.utils.h.o)) {
                Logger.d(this.f8026a, "handleIntentReport, stack trace elements : " + Arrays.toString(mVar.h));
                int iQ = SafeDK.getInstance().Q();
                if (iQ == 0) {
                    iQ = mVar.h.length;
                }
                StringBuilder sb = new StringBuilder(b9.i.d);
                for (int iR = SafeDK.getInstance().R(); iR < iQ; iR++) {
                    sb.append(mVar.h[iR]).append(StringUtils.COMMA);
                }
                sb.append(b9.i.e);
                eVar.d("MUR:" + mVar + "|stack:" + ((Object) sb));
            }
        }
    }
}
