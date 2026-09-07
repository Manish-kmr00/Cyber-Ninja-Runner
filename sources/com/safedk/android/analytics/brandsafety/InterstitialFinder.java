package com.safedk.android.analytics.brandsafety;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.entity.CampaignEx;
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
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SdksMapping;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes9.dex */
public class InterstitialFinder extends com.safedk.android.analytics.brandsafety.b {
    private static final String K = "InterstitialFinder";
    private static final long L = 500;
    private static final long M = 1000;
    private static final int N = 2;
    private static final int O = 3;
    public final InterstitialInfoCollection G;
    FullScreenActivitiesCollection H;
    boolean I;
    protected String J;
    private long P;
    private final Map<String, List<o>> Q;
    private String R;
    private final Object S;
    private final Set<String> T;

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean e(String str) {
        List<n> listA = this.G.a(str);
        return listA != null && listA.size() > 0;
    }

    public InterstitialFinder() {
        super(BrandSafetyUtils.AdType.INTERSTITIAL, Arrays.asList(BrandSafetyUtils.j, BrandSafetyUtils.k, BrandSafetyUtils.l), K, 120);
        this.G = new InterstitialInfoCollection();
        this.P = 0L;
        this.Q = new HashMap();
        this.H = new FullScreenActivitiesCollection();
        this.I = false;
        this.J = "";
        this.S = new Object();
        this.T = new HashSet(Arrays.asList(CreativeInfo.j, CreativeInfo.i));
    }

    @Override // com.safedk.android.analytics.brandsafety.b
    protected c a(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5) {
        return new n(str, str2, str3, screenShotOrientation, str4, str5);
    }

    public void l(String str) {
        for (n nVar : this.G.a(str)) {
            CreativeInfo creativeInfoJ = nVar.j();
            if (creativeInfoJ != null && creativeInfoJ.y()) {
                Logger.d(K, "set on endcard displayed - setting ci endcard detected. ci= " + creativeInfoJ.aa());
                nVar.i().s = true;
                nVar.as = true;
            } else if (creativeInfoJ != null && creativeInfoJ.v()) {
                Logger.d(K, "set on endcard displayed - ci is video ad, setting video complete. ci= " + creativeInfoJ.aa());
                a(nVar, true, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD);
            }
        }
    }

    public void m(String str) {
        for (n nVar : this.G.a(str)) {
            if (nVar.i() != null && nVar.i().b()) {
                nVar.i().t = true;
            }
        }
    }

    public void n(String str) {
        for (n nVar : this.G.a(str)) {
            if (nVar.i() != null && nVar.i().c()) {
                nVar.i().u = true;
                a((c) nVar);
            }
        }
    }

    public void f(String str, String str2) {
        List<n> listA;
        Logger.d(K, "on video completed - sdk = " + str + ", originatedBy = " + str2);
        if (str != null && (listA = this.G.a(str)) != null && !listA.isEmpty()) {
            Iterator<n> it = listA.iterator();
            if (it.hasNext()) {
                n next = it.next();
                Logger.d(K, "on video completed - sdk = " + str + ", found interstitialInfo by sdkPackage : " + next);
                a(next, true, str2);
                return;
            }
        }
        ArrayList<n> arrayList = new ArrayList();
        synchronized (this.G) {
            for (n nVar : this.G.values()) {
                if (nVar != null && nVar.v.equals(str)) {
                    arrayList.add(nVar);
                }
            }
        }
        for (n nVar2 : arrayList) {
            Logger.d(K, "on video completed - sdk = " + str + ", found interstitialInfo by eventId : " + nVar2);
            a(nVar2, true, str2);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, String str2, boolean z, String str3) {
        Logger.d(K, "on video completed triggered started - for view address  : " + str2 + ", sdkPackageName : " + str + ", completed: " + z);
        if (str2 != null) {
            n nVarA = this.G.a(str2, !z);
            if (nVarA != null) {
                a(nVarA, z, str3);
                CreativeInfo creativeInfoJ = nVarA.j();
                if (creativeInfoJ == null) {
                    return true;
                }
                Logger.d(K, "on interstitial video event triggered - setting ci ad as video ad.");
                creativeInfoJ.f(true);
                return true;
            }
        }
        List<n> listA = this.G.a(str);
        for (n nVar : listA) {
            Logger.d(K, "on video completed triggered - sdkPackageName : " + str + ", view address: " + str2 + ", completed: " + z);
            a(nVar, z, str3);
        }
        return !listA.isEmpty();
    }

    private void a(n nVar, boolean z, String str) {
        Logger.d(K, "_AD_CAPTURE_ set on video completed started, eventId: " + nVar.L + ", completed = " + z);
        synchronized (nVar.at) {
            if (!nVar.i().k && z) {
                CreativeInfo creativeInfoJ = nVar.j();
                if (creativeInfoJ != null) {
                    if (creativeInfoJ.v()) {
                        a((c) nVar);
                    } else {
                        creativeInfoJ.f(true);
                    }
                }
                Logger.d(K, "set on video completed started, onVideoCompletedEventHasBeenTriggered set to true ");
                nVar.e(str);
            } else if (!z) {
                a((c) nVar);
                if (!nVar.i().l || nVar.i().k) {
                    nVar.b(l.o, new l.a(l.P, str));
                }
                if (!nVar.i().l) {
                    nVar.i().l = true;
                    Logger.d(K, "set on video completed - impression is set to be a video impression");
                }
                nVar.i().k = false;
                nVar.aa = false;
                nVar.am = false;
            }
        }
    }

    public void a(String str, String str2, boolean z) {
        if (str2 != null && this.G.a(str2, false) != null) {
            a(this.G.a(str2, false), z);
            return;
        }
        List<n> listA = this.G.a(str);
        if (listA != null) {
            Iterator<n> it = listA.iterator();
            while (it.hasNext()) {
                a(it.next(), z);
            }
        }
    }

    public void a(n nVar, boolean z) {
        if (nVar == null || nVar.ae) {
            Logger.d(K, "stop taking screenshots for impression. info is null or already handled");
            return;
        }
        Logger.d(K, "_AD_CAPTURE_ stop taking screenshots for impression. starting. address = " + nVar.K);
        if (z || this.I) {
            nVar.ae = true;
            a(nVar.i());
            Logger.d(K, "stop taking screenshots for impression. attempting to clear image hash and files");
            j jVarM = nVar.m();
            if (jVarM != null && jVarM.b != null) {
                a(nVar, jVarM);
            } else {
                Logger.d(K, "stop taking screenshots for impression. no active ci or no image taken.");
            }
            d(nVar, "stopTakingScreenshotsForImpression");
            return;
        }
        Logger.d(K, "stop taking screenshots for impression. no max ad is active. ignoring");
    }

    private void a(n nVar, j jVar) {
        Logger.d(K, "remove file and report event, file: " + jVar.b);
        BrandSafetyUtils.d(jVar.b);
        jVar.f8109a = null;
        jVar.b = null;
        BrandSafetyUtils.d(nVar.b());
        jVar.c = 0L;
        nVar.s = null;
        jVar.d = 0;
        d(nVar, "removeFileAndReportEvent");
    }

    private void a(n nVar, String str, ViewGroup viewGroup, List<WeakReference<WebView>> list, List<String> list2, List<String> list3, int i) {
        String strA;
        int i2 = i + 1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i4);
                list2.add(BrandSafetyUtils.a(childAt));
                list3.add("h" + i2 + ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM + (i4 + 1) + ":" + childAt);
                if (childAt instanceof WebView) {
                    list.add(new WeakReference<>((WebView) childAt));
                    Logger.d(K, "find WebViews in view group - found view: " + childAt + " , parent: " + (childAt.getParent() != null ? childAt.getParent().toString() : "null"));
                } else if (childAt instanceof ViewGroup) {
                    a(nVar, str, (ViewGroup) childAt, list, list2, list3, i2);
                }
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
                if (adNetworkDiscoveryI != null) {
                    if (a(str, childAt) && nVar.m != null && nVar.j() == null && (strA = adNetworkDiscoveryI.a(childAt, BrandSafetyUtils.AdType.INTERSTITIAL)) != null) {
                        Logger.d(K, "find WebViews in view group - found adId: " + strA);
                        CreativeInfo creativeInfoA = adNetworkDiscoveryI.a((Object) strA);
                        if (creativeInfoA != null) {
                            List<CreativeInfo> listS = adNetworkDiscoveryI.s(creativeInfoA.N());
                            Logger.d(K, "find WebViews in view group - found CI for adId " + strA + ", size : " + listS.size() + " : " + listS);
                            for (CreativeInfo creativeInfo : listS) {
                                creativeInfo.a((Object) childAt);
                                if (nVar.A != null) {
                                    BrandSafetyEvent.AdFormatType adFormatTypeA = BrandSafetyUtils.a(nVar.A);
                                    Logger.d(K, "find WebViews in view group - setting ad format type to " + adFormatTypeA);
                                    creativeInfoA.a(adFormatTypeA);
                                    nVar.d("ad_type_upd(fndWVUndrVGroup):" + adFormatTypeA);
                                }
                                a(new o(creativeInfo, CreativeInfo.n, BrandSafetyUtils.a(childAt)));
                            }
                        }
                    }
                    if (!nVar.V && adNetworkDiscoveryI.a(childAt)) {
                        Logger.d(K, "_AD_CAPTURE_ find WebViews in view group - native player identified : " + childAt);
                        nVar.i().l = true;
                        nVar.b(l.o, new l.a(l.P, "native"));
                    }
                    nVar.V = nVar.V || adNetworkDiscoveryI.a(childAt);
                }
                i3 = i4 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage message) {
        String string;
        n nVarD;
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p()) {
            Bundle messageData = message.getMessageData();
            if (messageData.containsKey("revenue_event") && messageData.containsKey("ad_format") && this.b.contains(messageData.getString("ad_format"))) {
                Logger.d(K, "Revenue event detected : " + messageData);
                string = "revenue_event";
            } else {
                string = messageData.getString("type");
            }
            String string2 = messageData.getString("ad_format");
            String string3 = messageData.getString(BrandSafetyEvent.k);
            String string4 = messageData.getString(BrandSafetyEvent.ad);
            String string5 = messageData.getString("dsp_name");
            String strB = CreativeInfoManager.b(string4);
            long jB = com.safedk.android.utils.n.b(System.currentTimeMillis());
            String string6 = null;
            if (messageData.containsKey("creative_id")) {
                string6 = messageData.getString("creative_id");
            }
            com.safedk.android.analytics.events.a aVar = new com.safedk.android.analytics.events.a(string, jB, string2, string4, string6, string5);
            p.a().a(aVar);
            boolean zContains = this.b.contains(string2);
            String strA = CreativeInfoManager.a(strB, AdNetworkConfiguration.AD_NETWORK_TO_IGNORE, (String) null);
            if (zContains && string4 != null && string4.equals(strA)) {
                Logger.d(K, "full screen type but ad network not supported (" + strA + ")");
                return;
            }
            String string7 = messageData.getString("id", null);
            if (string7 == null) {
                Logger.d(K, "No eventId in data bundle.");
            }
            if (zContains) {
                Logger.d(K, "Max message received, package: " + strB + ", ts (seconds): " + jB + ", message received: " + message.getMessageData() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                if ("WILL_DISPLAY".equals(string)) {
                    Logger.d(K, "Number of InterstitialInfo objects : " + this.G.size());
                    Logger.d(K, "adInfoCollectionForUpload count: " + this.C.size());
                    i();
                    this.d++;
                    if (strB != null) {
                        p.a().b(aVar);
                        this.I = true;
                        a(string7, l.f, new l.a[0]);
                        BrandSafetyUtils.o(strB);
                        a(strB, new AtomicReference<>(messageData));
                        CreativeInfoManager.a(strB, string3, string6, (String) null, string2);
                        a aVar2 = new a(string3, string7);
                        Logger.d(K, "WILL_DISPLAY event for package: " + strB + " placement: " + string3 + " ad type: " + string2 + ", event id: " + string7);
                        a(strB, aVar2);
                        return;
                    }
                    return;
                }
                if ("revenue_event".equals(string)) {
                    Logger.d(K, "REVENUE_EVENT event for package: " + strB + " placement: " + string3 + " ad type: " + string2 + ", event id: " + string7);
                    a(string7, l.k, new l.a("typ", messageData.getString("revenue_event")));
                    a(string7, messageData);
                    return;
                }
                if ("DID_CLICKED".equals(string)) {
                    n nVarD2 = this.G.d(string7);
                    if (nVarD2 != null) {
                        StringBuilder sbAppend = new StringBuilder().append("DID_CLICKED event for package: ");
                        if (strB != null) {
                            string4 = strB;
                        }
                        Logger.d(K, sbAppend.append(string4).toString());
                        a(string7, l.h, new l.a[0]);
                        b(nVarD2);
                        if (!TextUtils.isEmpty(nVarD2.e())) {
                            d(nVarD2, "onMessageReceived");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ("WILL_LOAD".equals(string)) {
                    if (strB != null) {
                        Logger.d(K, "WILL_LOAD event for package: " + strB + " placement: " + string3);
                        a(string7, l.d, new l.a(l.N, string4));
                        CreativeInfoManager.a(strB, string3, string6, (String) null, string2);
                        return;
                    }
                    return;
                }
                if ("DID_HIDE".equals(string)) {
                    if (strB != null) {
                        BrandSafetyUtils.p(strB);
                        Logger.d(K, "DID_HIDE event for package: " + strB + " placement: " + string3 + ", event id: " + string7);
                        n nVarD3 = this.G.d(string7);
                        if (nVarD3 != null) {
                            a(string7, l.i, new l.a[0]);
                            a(nVarD3, (String) null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ("DID_LOAD".equals(string)) {
                    if (strB != null) {
                        Logger.d(K, "DID_LOAD event for package: " + strB + " placement: " + string3);
                        a(string7, l.e, new l.a(l.N, string4));
                        return;
                    }
                    return;
                }
                if ("DID_DISPLAY".equals(string)) {
                    if (strB != null) {
                        Logger.d(K, "DID_DISPLAY event for package: " + strB + " placement: " + string3);
                        a(string7, l.g, new l.a[0]);
                        if (string6 != null && (nVarD = this.G.d(string7)) != null) {
                            if (nVarD.A != null && nVarD.A.containsKey("id") && nVarD.A.getString("id") != null && nVarD.A.getString("id").equals(string7)) {
                                Logger.d(K, "setting Max creative id to: " + string6 + " for event id: " + string7);
                                nVarD.M = string6;
                                return;
                            } else {
                                Logger.d(K, "cannot update Max creative id. event id check failed.");
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if ("DID_FAIL_DISPLAY".equals(string)) {
                    Logger.d(K, "DID_FAIL_DISPLAY event for package: " + strB + " placement: " + string3);
                    a(string7, l.j, new l.a[0]);
                    h(strB, string7);
                }
            }
        }
    }

    private void h(String str, String str2) {
        List<o> listRemove;
        n nVarD = this.G.d(str2);
        if (nVarD != null) {
            nVarD.N = true;
            if (nVarD.B == null && StatsCollector.c() != null) {
                Logger.d(K, "DID_FAIL_DISPLAY received for an impression that was not displayed, removing event from repository. impression id: " + nVarD.i().f8110a);
                StatsCollector.c().a(nVarD.n());
                if (CreativeInfoManager.a(str, AdNetworkConfiguration.CLEAR_FULLSCREEN_PENDING_CANDIDATES_ON_DID_FAIL_DISPLAY, false) && (listRemove = this.Q.remove(str)) != null) {
                    synchronized (listRemove) {
                        Iterator<o> it = listRemove.iterator();
                        while (it.hasNext()) {
                            Logger.d(K, "DID_FAIL_DISPLAY event, removed pending CI: " + it.next().f8114a);
                        }
                    }
                }
            }
        }
    }

    private void i() {
        ArrayList<n> arrayList = new ArrayList();
        synchronized (this.G) {
            for (n nVar : this.G.values()) {
                if (nVar.N && nVar.B == null) {
                    arrayList.add(nVar);
                }
            }
        }
        for (n nVar2 : arrayList) {
            Logger.d(K, "report previous failed impression, event ID: " + nVar2.L);
            d(nVar2, "reportPreviousFailedImpressions");
            b((c) nVar2);
            a(nVar2.L);
            v(nVar2.L);
        }
    }

    private void a(String str, a aVar) {
        Logger.d(K, "match CI started, sdk = " + str + ", interstitial key = " + aVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (aVar.b != null) {
            Logger.d(K, "match CI - interstitial key: " + aVar);
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
            if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.d() != null && adNetworkDiscoveryI.d().a(AdNetworkConfiguration.SUPPORTS_BIDDING_INTERSTITIAL_IMPRESSION_MATCHING_BY_MAX, false)) {
                Logger.d(K, "match CI - discovery configuration: " + adNetworkDiscoveryI.d());
                String str2 = aVar.f8013a + "_" + aVar.b + "_" + str;
                CreativeInfo creativeInfoA = adNetworkDiscoveryI.a((Object) str2);
                if (creativeInfoA != null) {
                    Logger.d(K, "match CI - discovery class returned a ci: " + creativeInfoA.aa());
                    if (creativeInfoA.n() == null) {
                        creativeInfoA.h(aVar.b);
                    }
                    creativeInfoA.a(BrandSafetyEvent.AdFormatType.INTER);
                    creativeInfoA.t("ad_type_upd(matchCI):" + BrandSafetyEvent.AdFormatType.INTER);
                    a(new o(creativeInfoA, CreativeInfo.n, str2));
                    return;
                }
                Logger.d(K, "match CI - ci not found");
                return;
            }
            Logger.d(K, "match CI - sdk not configured to allow max events based matching");
        }
    }

    public void a(String str, AtomicReference<Bundle> atomicReference) {
        if (atomicReference != null && atomicReference.get() != null) {
            Logger.d(K, "start ad monitoring - slot = " + this.d + ", max package name = " + str + ", AppLovin data bundle is " + atomicReference.get() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            if (CreativeInfoManager.i(str) != null) {
                n nVar = new n(str, this.d, atomicReference.get());
                nVar.L = atomicReference.get().getString("id");
                synchronized (this.G) {
                    this.G.put(nVar.L, nVar);
                }
                Logger.d(K, "start ad monitoring - new interstitial info created : " + nVar);
                f((Activity) null);
                return;
            }
            Logger.d(K, "start ad monitoring - slot = " + this.d + ", max package name = " + str + ", ad network is not supported");
        }
    }

    public void c(final Activity activity) {
        this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.d(InterstitialFinder.K, "start ad monitoring - activity : " + activity + ", current interstitial infos :" + InterstitialFinder.this.G.toString());
                if (activity != null) {
                    if (!InterstitialFinder.this.G.c(activity.toString())) {
                        synchronized (InterstitialFinder.this.H) {
                            InterstitialFinder.this.H.put(activity.toString(), new WeakReference<>(activity));
                        }
                        if (!InterstitialFinder.this.I) {
                            InterstitialFinder.this.I = true;
                        }
                        Logger.d(InterstitialFinder.K, "start ad monitoring - activity added : " + activity.toString());
                    } else {
                        Logger.d(InterstitialFinder.K, "start ad monitoring - activity null or already registered.");
                    }
                    if (InterstitialFinder.this.s(activity.toString())) {
                        Logger.d(InterstitialFinder.K, "start ad monitoring - sdk: " + InterstitialFinder.this.G.b() + ", activity " + activity + " started but this is not the start of impression. not starting ad monitoring");
                    } else {
                        Logger.d(InterstitialFinder.K, "start ad monitoring calling 'start', activity is " + activity);
                        InterstitialFinder.this.f(activity);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(String str) {
        n nVarB = this.G.b(str);
        if (str == null || nVarB == null || nVarB.c() == null) {
            return false;
        }
        Logger.d(K, "instances of same activity - current activity class name = " + nVarB.p() + ",  current activity address = " + nVarB.o());
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(nVarB.c());
        if (adNetworkDiscoveryI == null || adNetworkDiscoveryI.d() == null || !adNetworkDiscoveryI.d().a(AdNetworkConfiguration.AD_NETWORK_INTERNAL_BROWSER_OPENS_IN_SAME_ACTIVITY, false)) {
            return false;
        }
        Logger.d(K, "instances of same activity - discovery configuration = " + adNetworkDiscoveryI.d());
        String str2 = nVarB.p() + "@" + nVarB.o();
        Logger.d(K, "instances of same activity - current activity = " + str2);
        if (str.equals(str2)) {
            return false;
        }
        Logger.d(K, "instances of same activity - activityClass " + str2 + " is a different instance of the same activity");
        return true;
    }

    private void b(n nVar) {
        Logger.d(K, "handle DID_CLICKED started , isOnUiThread = " + com.safedk.android.utils.n.c());
        if (nVar == null) {
            Logger.d(K, "current activity interstitial is null");
            return;
        }
        nVar.a(true);
        if (nVar.e() != null) {
            Logger.d(K, "current activity interstitial already have click url");
            return;
        }
        if (nVar.ai == null) {
            Logger.d(K, "current activity interstitial doesn't have click url candidate");
            return;
        }
        if (nVar.ai.f8101a == 0) {
            Logger.d(K, "current click url candidate has zero timestamp");
            return;
        }
        Logger.d(K, "handle DID_CLICKED checking click url candidate");
        if (System.currentTimeMillis() - nVar.ai.f8101a < 20000) {
            Logger.d(K, "handle DID_CLICKED setting click url");
            nVar.c(nVar.ai.b);
        } else {
            Logger.d(K, "click url candidate's timestamp is not within the time range");
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return AppLovinBridge.f7952a;
    }

    public n d(Activity activity) {
        if (activity != null) {
            return this.G.b(activity.toString());
        }
        Logger.d(K, "get activity interstitial by activity, activity is null");
        return null;
    }

    public n o(String str) {
        return this.G.d(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.b
    public c k(String str) {
        return o(str);
    }

    public n p(String str) {
        return this.G.a(str, true);
    }

    public n q(String str) {
        if (str == null) {
            Logger.d(K, "get activity interstitial by package, package is null");
            return null;
        }
        List<n> listA = this.G.a(str);
        if (listA.size() == 1) {
            Logger.d(K, "get activity interstitial by package, ci found : " + listA.get(0));
            return listA.get(0);
        }
        Logger.d(K, "there are " + listA.size() + " interstitial infos, exiting");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:122:0x048a  */
    public void f(Activity activity) {
        String strB;
        String strA;
        String strA2;
        n nVarB;
        Set<String> set;
        Object[] array;
        n nVar;
        List<o> listA;
        n nVar2;
        WeakReference<Activity> weakReferenceB;
        if (activity != null) {
            strA2 = BrandSafetyUtils.a(activity.toString(), true);
            strA = BrandSafetyUtils.a(activity.toString(), false);
            strB = BrandSafetyUtils.b(activity.getClass());
        } else {
            strB = null;
            strA = null;
            strA2 = null;
        }
        Logger.d(K, "interstitial finder start - activity name = " + activity + ", sdk = " + strB + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (activity != null) {
            nVarB = this.G.b(BrandSafetyUtils.a((Object) activity));
            Logger.d(K, "interstitial finder start - attempt to find by activity address, currentActivityInterstitial = " + nVarB);
        } else {
            nVarB = this.G.a(true) == 1 ? this.G.get(this.G.keySet().toArray()[0]) : null;
        }
        if (nVarB != null && strA2 != null && strA2.equals(nVarB.B)) {
            boolean zA = CreativeInfoManager.a(strB, AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false);
            j jVarM = nVarB.m();
            if (!zA && jVarM != null && !TextUtils.isEmpty(jVarM.f8109a) && a(jVarM.d, jVarM.c)) {
                Logger.d(K, "interstitial finder start - Not starting timer on activity " + nVarB.ac + " -- impression already logged");
                return;
            } else {
                Logger.d(K, "interstitial finder start - Starting counter from previous value " + nVarB.s());
                nVarB.I();
                nVar = nVarB;
            }
        } else {
            Logger.d(K, "interstitial finder start - current activity interstitial = " + nVarB);
            if (nVarB == null) {
                set = null;
            } else if (strA != null && nVarB.C.equals(strA)) {
                Logger.d(K, "interstitial finder start - current activity interstitial class name = " + nVarB.C + ", activity class name = " + strA);
                set = null;
            } else {
                Set<String> set2 = nVarB.W;
                if (set2.contains(strA2)) {
                    Logger.d(K, "interstitial finder start - Ignoring restart of suspected mediation " + nVarB.ac);
                    return;
                } else {
                    if (nVarB.B != null) {
                        set2.add(nVarB.B);
                    }
                    set = set2;
                }
            }
            ArrayList arrayList = new ArrayList();
            Logger.d(K, "interstitial finder start - current activity interstitial is " + nVarB);
            if (nVarB != null && !nVarB.E && !nVarB.k().isEmpty()) {
                Logger.d(K, "interstitial finder start - current activity interstitial != null : " + nVarB);
                List<CreativeInfo> listK = nVarB.k();
                if (!listK.isEmpty()) {
                    for (CreativeInfo creativeInfo : listK) {
                        if (creativeInfo != null) {
                            Logger.d(K, "interstitial finder start - setting current activity interstitials CI: " + creativeInfo);
                            arrayList.add(new o(creativeInfo, creativeInfo.Y(), creativeInfo.X()));
                        } else {
                            Logger.d(K, "interstitial finder start - current CI matching method not equal, current CI: " + creativeInfo);
                        }
                    }
                } else {
                    Logger.d(K, "interstitial finder start - current CI is null");
                }
                Logger.d(K, "interstitial finder start - current activity interstitial impression reported? " + nVarB.E);
                a(nVarB, true);
            }
            Logger.d(K, "interstitial finder start - activity : " + activity + ", activities : " + this.H.a());
            if (this.G.a(true) > 0 && this.H.size() > 0) {
                n nVar3 = nVarB;
                for (n nVar4 : this.G.c()) {
                    if (activity == null && (weakReferenceB = this.H.b(nVar4.v)) != null && weakReferenceB.get() != null) {
                        Activity activity2 = weakReferenceB.get();
                        Logger.d(K, "interstitial finder start - activity set to " + activity2);
                        activity = activity2;
                    }
                    if (activity != null) {
                        String strB2 = BrandSafetyUtils.b(activity.getClass());
                        Logger.d(K, "interstitial finder start - activity : " + activity + ", activitySdk : " + strB2 + ", InterstitialInfo sdk : " + nVar4.v);
                        nVar4.ad = SystemClock.elapsedRealtime();
                        if (nVar4.v != null && strB2 != null && strB2.equals(nVar4.v)) {
                            a(activity, nVar4);
                            nVar2 = nVar4;
                        } else if (com.safedk.android.utils.h.h.equals(strB2) && B.contains(nVar4.v)) {
                            Logger.d(K, "interstitial finder start - maybe scar-admob");
                            nVar2 = nVar3;
                        } else {
                            Logger.d(K, "interstitial finder start - activity SDK is not compatible with interstitial SDK");
                        }
                    } else {
                        nVar2 = nVar3;
                    }
                    a(nVar4, activity);
                    nVar3 = nVar2;
                }
                nVarB = nVar3;
            }
            synchronized (this.G) {
                array = this.G.keySet().toArray();
            }
            Logger.d(K, "interstitial finder start - scanning " + this.G.a(false) + " inter infos");
            int length = array.length;
            int i = 0;
            List<o> list = arrayList;
            while (i < length) {
                n nVar5 = this.G.get(array[i].toString());
                if (nVar5 == null || nVar5.U) {
                    nVar5 = nVarB;
                } else {
                    Logger.d(K, "interstitial finder start - setting the current activity interstitial to: " + nVar5);
                    if (nVar5.v != null) {
                        Logger.d(K, "interstitial finder start - current Max package name: " + nVar5.v);
                        boolean zA2 = CreativeInfoManager.a(nVar5.v, AdNetworkConfiguration.SDK_INTERSTITIALS_RUN_ON_APP_ACTIVITY, false);
                        if (activity != null && !BrandSafetyUtils.d(activity.getClass()) && !zA2) {
                            Logger.d(K, "interstitial finder start - current foreground activity is not a supported ad activity");
                            return;
                        }
                        if (zA2 || activity == null) {
                            listA = list;
                        } else {
                            Logger.d(K, "interstitial finder start - checking pending ci for no activity sdk " + nVar5.v);
                            List<o> listA2 = a(nVar5.v, nVar5);
                            for (o oVar : listA2) {
                                Logger.d(K, "interstitial finder start - found pending ci(s) for no activity sdk, mi : " + oVar);
                                b(oVar, nVar5);
                            }
                            listA = listA2;
                        }
                    } else {
                        listA = list;
                    }
                    if (!TextUtils.isEmpty(this.J)) {
                        nVar5.d(this.J);
                        Logger.d(K, "interstitial finder start - ci_debug_info set to " + this.J);
                    } else {
                        nVar5.L();
                        Logger.d(K, "interstitial finder start - no CI so adding the noCIDebug to CIDebugInfo");
                    }
                    if (nVar5.ap != null && nVar5.ap.get() != null) {
                        f(nVar5);
                        if (listA.isEmpty()) {
                            listA = a(strB, nVar5);
                        }
                        nVar5.Z = 0L;
                    }
                    if (CreativeInfoManager.a(nVar5.c(), AdNetworkConfiguration.SDK_INTERSTITIALS_RUN_ON_APP_ACTIVITY, false)) {
                        nVar5.ad = SystemClock.elapsedRealtime();
                        Logger.d(K, "interstitial finder inter runs on app activity, checking for pending CIs. sdk = " + nVar5.c());
                        List<o> listA3 = a(nVar5.c(), nVar5);
                        Logger.d(K, "interstitial finder inter runs on app activity, checking for pending CIs. found " + listA3.size() + " items");
                        list = listA3;
                    } else {
                        list = listA;
                    }
                    for (o oVar2 : list) {
                        if (oVar2 != null && oVar2.f8114a != null) {
                            b(oVar2, nVar5);
                        }
                    }
                    if (set != null) {
                        nVar5.W = set;
                    }
                }
                i++;
                nVarB = nVar5;
            }
            nVar = nVarB;
        }
        if (nVar != null) {
            Logger.d(K, "interstitial finder start - before timer, time interstitial info event id is: " + nVar.L);
            synchronized (nVar.au) {
                if (c(nVar)) {
                    Logger.d(K, "interstitial finder start - starting timer for interstitial info with eventId " + nVar.w());
                    nVar.ak = this.E.scheduleWithFixedDelay(new b(nVar.L, nVar.v), 500L, 1000L, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    private boolean c(n nVar) {
        ScheduledFuture<?> scheduledFuture = nVar != null ? nVar.ak : null;
        Logger.d(K, "should start timer started, task future = " + scheduledFuture + ", is cancelled = " + (scheduledFuture != null ? Boolean.valueOf(scheduledFuture.isCancelled()) : null));
        if (nVar != null && nVar.ap != null) {
            Logger.d(K, "should start timer - inter activity is: " + nVar.ap.get());
            Logger.d(K, "should start timer - inter activity CI is: " + nVar.j());
        }
        boolean z = nVar != null && (scheduledFuture == null || scheduledFuture.isCancelled()) && !((nVar.ap == null || nVar.ap.get() == null) && (nVar.j() == null || nVar.j().f() == null));
        Logger.d(K, "should start timer returned: " + z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, n nVar) {
        if (activity != null) {
            String[] strArr = {BrandSafetyUtils.a(activity.toString(), false), BrandSafetyUtils.a(activity.toString(), true)};
            String string = activity.toString();
            nVar.ac = string;
            nVar.ap = new WeakReference<>(activity);
            nVar.a(strArr);
            synchronized (this.H) {
                this.H.remove((Object) activity.toString());
            }
            Logger.d(K, "interstitial info activity details set : " + activity.getClass() + ", sdk = " + nVar.v + ", activity name = " + string + ", activities = " + this.H.a() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            return;
        }
        Logger.d(K, "cannot set interstitial info activity details, activity is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<o> a(String str, n nVar) {
        ArrayList arrayList = new ArrayList();
        List<o> list = this.Q.get(str);
        com.safedk.android.utils.n.b(K, "pending ci check, number of pending CIs: " + (list != null ? list.size() : 0) + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        Logger.d(K, "pending ci check, pending object addresses are: " + a(list));
        if (list != null) {
            synchronized (list) {
                Iterator<o> it = list.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    Logger.d(K, "pending ci check, matching method: " + next.b + ", ci: " + next.f8114a.aa());
                    if (a(next.f8114a, nVar) && next.f8114a != null) {
                        nVar.d("pcim|ts=" + System.currentTimeMillis() + "|ls=" + list.size() + ";" + next.b + "|o=" + next.f8114a.ah() + ";" + next.f8114a.ai());
                        it.remove();
                        Logger.d(K, "pending ci check, creative info is the pending creative info: " + next);
                        arrayList.add(next);
                    }
                }
            }
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
            if (adNetworkDiscoveryI != null && adNetworkDiscoveryI.b() == AdNetworkDiscovery.WebViewResourceMatchingMethod.DIRECT_CREATIVE_INFO) {
                list.clear();
            }
        }
        return arrayList;
    }

    private boolean a(CreativeInfo creativeInfo, n nVar) {
        if (creativeInfo == null || nVar == null) {
            return false;
        }
        Logger.d(K, "verify matching - current activity interstitial: " + nVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (nVar.L != null && !TextUtils.isEmpty(creativeInfo.n()) && !nVar.L.equals(creativeInfo.n())) {
            Logger.d(K, "verify matching - incompatible event ID, ci: " + creativeInfo.n() + ", info: " + nVar.L);
            if (!CreativeInfoManager.a(nVar.v, AdNetworkConfiguration.SHOULD_ALLOW_CI_MATCHING_WITH_INCOMPATIBLE_EVENT_IDS, false)) {
                return false;
            }
            creativeInfo.t("cim-iei=" + creativeInfo.n());
        }
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(creativeInfo.T() == null ? creativeInfo.S() : creativeInfo.T());
        if (adNetworkDiscoveryI != null) {
            if (adNetworkDiscoveryI.b() == AdNetworkDiscovery.WebViewResourceMatchingMethod.DIRECT_CREATIVE_INFO) {
                if (nVar.r() != null) {
                    String string = nVar.r().getString(BrandSafetyEvent.k);
                    String string2 = nVar.r().getString("ad_format");
                    if (creativeInfo.H() == null || (string != null && string.equals(creativeInfo.H()))) {
                        Logger.d(K, "verify matching DIRECT_CREATIVE_INFO, CI placement: " + creativeInfo.H() + ", CI format: " + creativeInfo.K());
                        return true;
                    }
                    Logger.d(K, "verify matching DIRECT_CREATIVE_INFO, verification failed for CI placement: " + creativeInfo.H() + ", CI format: " + creativeInfo.K());
                    nVar.d("verifyMatchingFailed|placement=(" + string + StringUtils.COMMA + creativeInfo.H() + ")|format=(" + string2 + StringUtils.COMMA + creativeInfo.H() + ")");
                    return false;
                }
            } else {
                return a(creativeInfo.ah(), creativeInfo.ai(), nVar);
            }
        }
        Logger.d(K, "verify matching, no InterstitialInfo or no discovery for " + creativeInfo.S());
        return false;
    }

    private boolean a(String str, String str2, n nVar) {
        if (nVar == null) {
            return false;
        }
        Logger.d(K, "verify matching object started, event ID: " + nVar.L + ", object address: " + str2 + ", webview address: " + nVar.K + ", object type: " + str + ", currentActivityInterstitial = " + nVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        boolean zA = CreativeInfoManager.a(nVar.v, AdNetworkConfiguration.SDK_INTERSTITIALS_RUN_ON_APP_ACTIVITY, false);
        if (str2 == null || MediaPlayer.class.getCanonicalName().equals(str) || zA) {
            Logger.d(K, "verify matching object skipped, event ID: " + nVar.L + ", object address: " + str2 + ", object type: " + str + ", sdkInterstitialsRunOnAppActivity: " + zA);
            return true;
        }
        if (nVar.x() != null && nVar.x().contains(str2)) {
            Logger.d(K, "verify matching object done, event ID: " + nVar.L + ", object address: " + str2 + ", views hierarchy: " + nVar.x());
            return true;
        }
        Logger.d(K, "verify matching object failed, event ID: " + nVar.L + ", object address: " + str2 + ", views hierarchy: " + nVar.x());
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void a(final String str) {
        if (com.safedk.android.utils.n.c()) {
            this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.3
                @Override // java.lang.Runnable
                public void run() {
                    InterstitialFinder.this.t(str);
                }
            });
        } else {
            t(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        Logger.d(K, "stop timers - canceling timer for interstitials, eventId = " + str + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        n nVarD = this.G.d(str);
        if (nVarD != null) {
            if (nVarD.s() == 0) {
                nVarD.ab = null;
            }
            if (this.G.a()) {
                this.P = 0L;
            }
            if (nVarD.ak != null) {
                Logger.d(K, "stop timers - calling timer cancel.");
                if (!nVarD.ak.cancel(true)) {
                    Logger.d(K, "stop timers - failed to call timer cancel.");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    @Override // com.safedk.android.analytics.brandsafety.a
    public List<CreativeInfo> a(String str, String str2) {
        List<CreativeInfo> listL;
        List<CreativeInfo> list = null;
        for (n nVar : this.G.values()) {
            if (nVar == null || nVar.U) {
                listL = list;
            } else {
                boolean z = nVar.K != null && nVar.K.equals(str2);
                boolean z2 = nVar.m != null && nVar.m.contains(str2);
                if (z || z2) {
                    listL = nVar.l();
                } else {
                    listL = list;
                }
            }
            list = listL;
        }
        return list;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public List<CreativeInfo> b(String str, String str2) {
        ArrayList arrayList;
        List<CreativeInfo> listK;
        synchronized (this.G) {
            for (n nVar : this.G.values()) {
                if (nVar != null && (listK = nVar.k()) != null && !listK.isEmpty() && listK.get(0) != null && listK.get(0).N() != null && listK.get(0).N().equals(str2)) {
                    return listK;
                }
            }
            List<o> list = this.Q.get(str);
            if (list != null) {
                synchronized (list) {
                    arrayList = new ArrayList();
                    for (o oVar : list) {
                        if (oVar.f8114a != null && oVar.f8114a.N() != null && oVar.f8114a.N().equals(str2)) {
                            arrayList.add(oVar.f8114a);
                        }
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public c b(String str) {
        synchronized (this.G) {
            for (n nVar : this.G.values()) {
                if (nVar != null && nVar.m != null && nVar.m.contains(str)) {
                    return nVar;
                }
            }
            return null;
        }
    }

    public void e(final Activity activity) {
        if (com.safedk.android.utils.n.c()) {
            this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.4
                @Override // java.lang.Runnable
                public void run() {
                    InterstitialFinder.this.g(activity);
                }
            });
        } else {
            g(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Activity activity) {
        try {
            Logger.d(K, "interstitial finder stop, activity = " + activity.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            n nVarB = this.G.b(activity.toString());
            if (nVarB != null) {
                if (nVarB.ac == null || activity.toString().equals(nVarB.ac)) {
                    Logger.d(K, "Stopping interstitial finder for activity " + nVarB.ac);
                    a(nVarB.L);
                    Logger.d(K, "interstitial finder, viewing time (ms) = " + nVarB.Z);
                }
            }
        } catch (Throwable th) {
            Logger.e(K, th.getMessage(), th);
            new CrashReporter().caughtException(th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void d(final String str) {
        if (com.safedk.android.utils.n.c()) {
            this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.5
                @Override // java.lang.Runnable
                public void run() {
                    InterstitialFinder.this.u(str);
                }
            });
        } else {
            u(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        if (str != null) {
            synchronized (this.H) {
                Logger.d(K, "Activity destroyed activity class: " + str + ", activities: " + this.H.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                this.H.remove((Object) str);
            }
            String sdkPackageByClass = SdksMapping.getSdkPackageByClass(str);
            n nVarB = this.G.b(str);
            if (nVarB != null) {
                if (sdkPackageByClass != null && nVarB.v != null && !sdkPackageByClass.equals(nVarB.v)) {
                    Logger.d(K, "Activity destroyed, activity SDK does not fit the WILL_DISPLAY msg: " + sdkPackageByClass);
                    return;
                }
                if (nVarB.ac != null && !nVarB.ac.equals(str)) {
                    Logger.d(K, "Activity destroyed, activity address (" + str + " ) does not match the address of the ad's activity (" + nVarB.ac + ")");
                    return;
                }
                Logger.d(K, "Activity destroyed, calling onAdHidden");
                nVarB.a(l.C, new l.a[0]);
                a(nVarB, str);
            }
        }
    }

    public void a(String str, Bundle bundle) {
        n nVar;
        if (this.G.containsKey(str) && (nVar = this.G.get(str)) != null) {
            if (bundle.getString("revenue_event") != null) {
                nVar.P = bundle.getString("revenue_event");
            } else {
                nVar.P = "unknown";
            }
            d(nVar, "handleRevenueEvent");
            Logger.d(K, "Revenue event set to " + bundle.getString("revenue_event") + " for eventId: " + str);
            return;
        }
        Logger.d(K, "Revenue event - no interstitial info found for event " + str + ", isOnUiThread = " + com.safedk.android.utils.n.c());
    }

    public void a(final n nVar, final String str) {
        Logger.d(K, "Ad hidden started, activityClass=" + (str == null ? "null" : str) + ", interstitial infos=" + this.G.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (nVar != null) {
            if (s(str)) {
                Logger.d(K, "Ad hidden " + nVar.c() + " activity " + str + " unloaded but this is not the end of impression. not calling cleanAndReport");
                return;
            }
            d(nVar, "onAdHidden");
            nVar.U = true;
            this.E.schedule(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.6
                @Override // java.lang.Runnable
                public void run() {
                    InterstitialFinder.this.c(nVar, str);
                }
            }, 3L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar, String str) {
        if (nVar == null) {
            Logger.d(K, "clean and report - current interstitial info is NULL, SKIPPING");
            return;
        }
        if (nVar.H()) {
            Logger.d(K, "clean and report - already run, SKIPPING");
            return;
        }
        nVar.g(true);
        try {
            try {
                Logger.d(K, "clean and report started, activity class=" + str + ", eventId = " + nVar.L + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                if (str == null) {
                    str = nVar.ac;
                    Logger.d(K, "clean and report - activity class set to (curr intractname) " + nVar.ac);
                }
                String sdkPackageByClass = SdksMapping.getSdkPackageByClass(str);
                for (k kVar : nVar.g()) {
                    if (kVar.i() != null) {
                        Logger.d(K, "clean and report - activity SDK = " + sdkPackageByClass + ", CI SDK = " + kVar.i().S() + ", interstitial activity name=" + nVar.ac);
                        Logger.d(K, "clean and report - currentMaxPackageName = " + nVar.v + ", activitySdk = " + sdkPackageByClass);
                        if (nVar.v != null && !nVar.v.equals(sdkPackageByClass) && !nVar.v.equals(kVar.i().S()) && !nVar.aj) {
                            Logger.d(K, "clean and report - skip reporting as no related WILL_DISPLAY message received, current Max package name: " + nVar.v + ", activity SDK: " + sdkPackageByClass + ", CI SDK: " + kVar.i().S());
                            kVar.a((CreativeInfo) null);
                        }
                    }
                    if (kVar.c != null && kVar.c.b != null) {
                        kVar.d = kVar.c.b;
                    } else if (nVar.b() != null) {
                        kVar.d = nVar.b();
                    }
                    Logger.d(K, "clean and report - last impression screenshot filename set to " + kVar.d);
                }
                com.safedk.android.analytics.brandsafety.creatives.g.a(e(nVar));
                if ((nVar.B == null || !nVar.B.equals(BrandSafetyUtils.a(str, true))) && !CreativeInfoManager.a(nVar.c(), AdNetworkConfiguration.SDK_INTERSTITIALS_RUN_ON_APP_ACTIVITY, false)) {
                    Logger.d(K, "clean and report - DID NOT enter unload logic, current interstitial info=" + nVar);
                } else {
                    for (k kVar2 : nVar.g()) {
                        if (kVar2 != null) {
                            if (kVar2.c != null && kVar2.c.b != null && nVar.b() != null) {
                                if (this.C.size() < SafeDK.getInstance().J()) {
                                    Logger.d(K, "clean and report - image files: " + kVar2.c.b + ", " + nVar.t + ", impression ID: " + kVar2.f8110a + ", count = " + this.C.size());
                                    a(nVar, kVar2);
                                } else if (!c(nVar.s, kVar2.f8110a)) {
                                    BrandSafetyUtils.d(nVar.t);
                                    nVar.ab = null;
                                    nVar.t = null;
                                }
                                Logger.d(K, "clean and report - hash value: " + kVar2.c.f8109a + " orientation: " + kVar2.c.f);
                                if (kVar2.c.f8109a == null && !nVar.ae) {
                                    Logger.d(K, "clean and report - assigning last captured hash to interstitial: " + nVar.ab);
                                    kVar2.c.f8109a = nVar.ab;
                                    kVar2.c.f = nVar.u;
                                }
                                this.R = kVar2.c.f8109a;
                            }
                            if (!kVar2.d().isEmpty()) {
                                for (String str2 : kVar2.d()) {
                                    Logger.d(K, "clean and report - attach resources to CI for webview/adId: " + str2);
                                    com.safedk.android.analytics.brandsafety.creatives.g.a(nVar.c(), str2, kVar2);
                                    if (CreativeInfoManager.a(nVar.c(), AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true)) {
                                        try {
                                            if (kVar2.w > 0) {
                                                nVar.d("aiw" + kVar2.w);
                                            }
                                        } catch (Exception e) {
                                            Logger.e(K, "caught exception: ", e);
                                        }
                                    }
                                }
                                com.safedk.android.analytics.brandsafety.creatives.g.b(kVar2.d());
                            }
                        }
                    }
                    nVar.af = SystemClock.elapsedRealtime();
                    nVar.Z += nVar.af - nVar.ad;
                    Logger.d(K, "clean and report - Viewing time (ms) = " + nVar.Z);
                    if (CreativeInfoManager.i(nVar.v) == null) {
                        a(nVar.L);
                        v(nVar.L);
                        return;
                    }
                    Logger.d(K, "clean and report - number of CIs to report: " + nVar.k().size());
                    d(nVar, "onAdHiddenTask");
                    for (k kVar3 : nVar.g()) {
                        if (kVar3 != null && kVar3.i() != null && kVar3.i().Y() != null) {
                            Logger.d(K, "clean and report - resetting CI matching method for ci " + kVar3.i());
                            kVar3.i().b((String) null, (String) null);
                        }
                    }
                }
                if (str != null) {
                    Logger.d(K, "clean and report - removing from activities : " + str);
                    synchronized (this.H) {
                        this.H.remove((Object) str);
                    }
                }
                b((c) nVar);
                a(nVar.L);
                v(nVar.L);
            } catch (Throwable th) {
                Logger.e(K, "Exception in clean and report : " + th.getMessage(), th);
                a(nVar.L);
                v(nVar.L);
            }
        } catch (Throwable th2) {
            a(nVar.L);
            v(nVar.L);
            throw th2;
        }
    }

    private void v(String str) {
        Logger.d(K, "clearing AppLovin bundle, eventId = " + str);
        this.I = this.G.size() != 0;
        Logger.d(K, "clear variables, maxAdIsActive set to " + this.I);
        if (str != null) {
            synchronized (this.G) {
                this.G.remove(str);
            }
            Logger.d(K, "clear variables, removing " + str + " from currentInterstitialInfos");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar, String str) {
        if (nVar == null || !nVar.Y) {
            Logger.d(K, "reporting event - info is not interstitial, don't report info");
            return;
        }
        com.safedk.android.utils.n.b(K, "reporting event started, root=" + str + ", info event id =" + nVar.L + " , isOnUiThread = " + com.safedk.android.utils.n.c());
        boolean z = !nVar.E;
        boolean z2 = !nVar.F && nVar.d();
        String string = null;
        if (nVar.A != null && nVar.A.containsKey("id")) {
            string = nVar.A.getString("id");
            Logger.d(K, "reporting event - event ID: " + string);
        } else {
            Logger.d(K, "reporting event - no event ID");
        }
        ArrayList arrayList = new ArrayList();
        if (nVar.k().isEmpty()) {
            arrayList.add(a(nVar, nVar.i(), z2, string, (String) null));
        } else {
            Logger.d(K, "reporting event - number of CIs: " + nVar.k().size());
            for (k kVar : new ArrayList(nVar.g())) {
                if (kVar.i() != null && !nVar.c().equals(kVar.i().S())) {
                    Logger.d(K, "reporting event without CI - sdk: " + nVar.c() + ", CI sdk: " + kVar.i().S() + ", CI actual sdk: " + kVar.i().T());
                    kVar.a((CreativeInfo) null);
                }
                Logger.d(K, "reporting event (Check) root = " + str + ", debug info = " + nVar.B());
                List listAsList = Arrays.asList(com.safedk.android.utils.h.i, com.safedk.android.utils.h.b, "com.unity3d.ads");
                if (!TextUtils.isEmpty(nVar.B()) && str.equals("onAdHidden") && kVar.i() != null && listAsList.contains(kVar.i().S()) && nVar.A != null && nVar.A.containsKey("ad_format") && nVar.A.getString("ad_format") != null && nVar.A.getString("ad_format").equals(BrandSafetyUtils.l)) {
                    kVar.i().t(nVar.B());
                    String string2 = p.a().c().toString();
                    com.safedk.android.utils.n.b(K, "reporting event Invalid AppOpen impression detected ciDebugInfo = " + nVar.B() + " , lastMaxEvents = " + string2);
                    kVar.i().t(string2);
                }
                String str2 = null;
                if (kVar.c != null) {
                    Logger.d(K, "reporting event - image uniformity: " + kVar.c.a(1000));
                    if (kVar.c.f8109a != null && !nVar.ae) {
                        str2 = kVar.c.f8109a + "_" + kVar.f8110a;
                    }
                    e(nVar, str2);
                }
                arrayList.add(a(nVar, kVar, z2, string, str2));
            }
        }
        Logger.d(K, "reporting event " + string + ", viewingTime = " + nVar.Z);
        if (StatsCollector.c() != null) {
            StatsCollector.c().a(arrayList);
        } else {
            Logger.w(K, "reporting event - stats collector instance is null, cannot report brand safety event");
        }
        if (z) {
            nVar.c(true);
        }
        if (z2) {
            nVar.d(true);
        }
    }

    private BrandSafetyEvent a(n nVar, k kVar, boolean z, String str, String str2) {
        return new BrandSafetyEvent(nVar.c(), nVar.z, str2, z, nVar.d() ? nVar.e() : null, kVar.i(), nVar.a(), nVar.C, kVar.f8110a != null ? kVar.f8110a : "", nVar.D, nVar.Z, nVar.Z > 0, nVar.A, kVar.c != null ? kVar.c.f : null, kVar.c != null ? kVar.c.g : false, kVar.c != null ? kVar.c.c : 0L, kVar.c != null ? kVar.c.a(1000) : 0.0f, nVar.y, nVar.T, SafeDK.getInstance().e(), str, nVar.M, nVar.N, nVar.P, nVar.Q, b(nVar, kVar).toString(), kVar.e, kVar.f, kVar.g, kVar.m, kVar.n, kVar.o, kVar.p, kVar.q, kVar.x, kVar.r);
    }

    private void e(n nVar, String str) {
        Logger.d(K, "add CI debug info started, hashValue " + str + ", info=" + nVar.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        for (k kVar : nVar.g()) {
            if (kVar.i() != null && kVar.c != null && str != null && kVar.c.f8109a != null && kVar.c.f != null && nVar.n() != null) {
                String strA = BrandSafetyUtils.a(BrandSafetyUtils.AdType.INTERSTITIAL, kVar.c.f8109a, nVar.c(), nVar.n(), kVar.c.f);
                if (new File(strA).exists()) {
                    if (kVar.i().X() == null || !kVar.i().X().contains("screenshot_datetime")) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        kVar.i().t("screenshot_datetime=" + jCurrentTimeMillis);
                        Logger.d(K, "add CI debug info: " + jCurrentTimeMillis);
                    } else {
                        Logger.d(K, "add CI debug info - stats repo is null or already contains this event");
                    }
                } else {
                    Logger.d(K, "add CI debug info - screenshot file path doesn't exist: " + strA);
                }
            } else {
                Logger.d(K, "add CI debug info - no creative info or hash is null");
            }
        }
    }

    public void a(n nVar) {
        if (nVar == null || com.safedk.android.utils.e.a((c) nVar)) {
            Logger.d(K, "_MEMORY_LOAD_ don't take screenshot, ad info: " + nVar + ", low memory");
            return;
        }
        Logger.d(K, "take screenshot - currentActivityInterstitial = " + nVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (nVar.ap == null || nVar.ap.get() == null) {
            Logger.d(K, "take screenshot - activity instance is null");
            return;
        }
        Activity activity = nVar.ap.get();
        if (nVar.J()) {
            Logger.d(K, "take screenshot - sdk Interstitials Run On App Activity = " + nVar.aj);
            if (nVar.ap != null && nVar.ap.get() != null && !BrandSafetyUtils.d(activity.getClass()) && !nVar.aj) {
                Logger.d(K, "_AD_CAPTURE_ take screenshot - The activity is not supported : " + activity.getClass());
                return;
            }
            String str = nVar.v;
            Activity activityD = d(nVar);
            Logger.d(K, "take screenshot - activity = " + activityD);
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(nVar.v);
            try {
                Logger.d(K, "take screenshot - Run on UI thread in " + nVar.ac);
                View viewK = nVar.K();
                Logger.d(K, "_AD_CAPTURE_ take screenshot - screenshot view: " + viewK);
                if (!ScreenshotHelper.a()) {
                    Logger.d(K, "_AD_CAPTURE_ take screenshot - OS version is not compatible with PC");
                    int iE = nVar.E();
                    if (iE > 0 && (viewK instanceof ViewGroup)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(new WeakReference(viewK));
                        c((ViewGroup) viewK, arrayList);
                        Logger.d(K, "take screenshot (for screenshots) - views hierarchy : " + arrayList);
                        if (iE < arrayList.size()) {
                            View view = (View) ((WeakReference) arrayList.get(iE)).get();
                            Logger.d(K, "take screenshot - get screenshot view, index: " + iE + ", view: " + view);
                            viewK = view;
                        } else {
                            nVar.G();
                            Logger.d(K, "take screenshot - reset screenshot view: " + viewK);
                        }
                    }
                }
                CreativeInfo creativeInfoJ = nVar.j();
                boolean zEquals = com.safedk.android.utils.h.h.equals((creativeInfoJ == null || creativeInfoJ.T() == null) ? nVar.c() : creativeInfoJ.T());
                if (creativeInfoJ != null) {
                    Logger.d(K, "_AD_CAPTURE_ take screenshot - is video ad ? " + nVar.i().l + ", is multi ad ? " + creativeInfoJ.al());
                }
                boolean zA = CreativeInfoManager.a(str, AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false);
                if (!SafeDK.getInstance().I() && !zEquals) {
                    if (!nVar.i().l && adNetworkDiscoveryI != null && adNetworkDiscoveryI.a((c) nVar)) {
                        nVar.i().l = true;
                        Logger.d(K, "_AD_CAPTURE_ don't take screenshot - found a media player");
                    }
                    if (creativeInfoJ == null) {
                        Logger.d(K, "_AD_CAPTURE_ don't take screenshot - no creative info yet");
                        return;
                    }
                    if (creativeInfoJ.al() && !zA) {
                        Logger.d(K, "_AD_CAPTURE_ don't take screenshot - multi ad, sdk: " + str);
                        return;
                    }
                    if (nVar.i().l) {
                        if (nVar.i().b()) {
                            if (nVar.i().t) {
                                Logger.d(K, "_AD_CAPTURE_ take screenshot - ecommerce collage end card is displayed");
                                a(nVar, viewK, activityD);
                                return;
                            } else {
                                Logger.d(K, "_AD_CAPTURE_ take screenshot - ecommerce collage end card is not displayed yet, don't take screenshot");
                                return;
                            }
                        }
                        if (a(nVar, viewK) || nVar.i().k) {
                            Logger.d(K, "_AD_CAPTURE_ take screenshot - video finished playing");
                            a(nVar, viewK, activityD);
                            return;
                        } else {
                            Logger.d(K, "_AD_CAPTURE_ don't take screenshot - video is currently playing ");
                            return;
                        }
                    }
                    if (nVar.i().c() && !nVar.i().u) {
                        Logger.d(K, "_AD_CAPTURE_ take screenshot - ad has video loading screen being displayed now, don't take screenshot");
                        return;
                    } else {
                        Logger.d(K, "_AD_CAPTURE_ take screenshot - this is not a video ad - take screenshot");
                        a(nVar, viewK, activityD);
                        return;
                    }
                }
                if (SafeDK.getInstance().I()) {
                    Logger.d(K, "_AD_CAPTURE_ take screenshot - SafeDK Config item 'AlwaysTakeScreenshot' is true");
                    a(nVar, viewK, activityD);
                } else if (creativeInfoJ == null) {
                    Logger.d(K, "_AD_CAPTURE_ don't take screenshot - Admob SDK but no ci yet");
                } else if (creativeInfoJ.al() && !zA) {
                    Logger.d(K, "_AD_CAPTURE_ don't take screenshot - multi ad, sdk: " + str);
                } else {
                    Logger.d(K, "_AD_CAPTURE_ take screenshot - Admob SDK");
                    a(nVar, viewK, activityD);
                }
            } catch (Throwable th) {
                Logger.e(K, "_AD_CAPTURE_ Failed while taking screenshot", th);
                new CrashReporter().caughtException(th);
            }
        }
    }

    private boolean a(n nVar, View view) {
        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(nVar.c());
        if (adNetworkDiscoveryI == null || !nVar.V || !adNetworkDiscoveryI.b(view)) {
            return false;
        }
        if (!nVar.i().k) {
            Logger.d(K, "_AD_CAPTURE_ is native video player completed - native video end, info:" + nVar);
            nVar.e("native");
        }
        return true;
    }

    private Activity d(n nVar) {
        if (nVar.aj) {
            return com.safedk.android.internal.b.getInstance().getForegroundActivity();
        }
        if (nVar.ap == null || nVar.ap.get() == null) {
            return null;
        }
        return nVar.ap.get();
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(o oVar) {
        Logger.d(K, "set CI details started, matchingInfo = " + oVar.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        CreativeInfo creativeInfo = oVar.f8114a;
        if (creativeInfo == null) {
            return false;
        }
        creativeInfo.i(BrandSafetyUtils.ScreenShotOrientation.PORTRAIT.equals(BrandSafetyUtils.c()));
        n nVar = null;
        if (creativeInfo.n() != null) {
            n nVarD = this.G.d(creativeInfo.n());
            Logger.d(K, "set CI details, attempt to locate interstitial info by eventId " + creativeInfo.n() + ", success? " + (nVarD != null));
            nVar = nVarD;
        }
        if (nVar == null && creativeInfo.ai() != null) {
            n nVarA = this.G.a(creativeInfo.ai(), true);
            Logger.d(K, "set CI details, attempt to locate interstitial info by matching object address " + creativeInfo.ai() + ", success ? " + (nVarA != null));
            nVar = nVarA;
        }
        if (nVar != null) {
            return a(oVar, nVar);
        }
        List<n> listA = this.G.a(creativeInfo.S());
        if (listA.size() > 0) {
            Logger.d(K, "set CI details, attempt to locate interstitial info, list size: " + listA.size());
            Iterator<n> it = this.G.a(creativeInfo.S()).iterator();
            while (it.hasNext()) {
                if (a(oVar, it.next())) {
                    List<o> list = this.Q.get(creativeInfo.S());
                    if (list != null) {
                        synchronized (this.Q) {
                            list.remove(oVar);
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        Logger.d(K, "set CI details, failed to locate interstitial info");
        a(oVar, creativeInfo.S());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(o oVar, n nVar) {
        BrandSafetyEvent.AdFormatType adFormatTypeA;
        if (nVar == null) {
            return false;
        }
        CreativeInfo creativeInfo = oVar.f8114a;
        Logger.d(K, "set CI details - ad info sdk: " + nVar.c() + ", CI sdk: " + creativeInfo.S() + " ad info webview address: " + nVar.K + ", ci matching object address: " + creativeInfo.ai());
        if (nVar.A != null) {
            Logger.d(K, "set CI details - CI ad format: " + creativeInfo.K() + ", max ad type: " + nVar.A.getString("ad_format"));
            BrandSafetyEvent.AdFormatType adFormatTypeA2 = BrandSafetyUtils.a(nVar.A);
            if ((creativeInfo.K() == null || !creativeInfo.K().equals(adFormatTypeA2.name())) && adFormatTypeA2 != null) {
                Logger.d(K, "set CI details - updating ad format value to " + adFormatTypeA2);
                creativeInfo.a(adFormatTypeA2);
                nVar.d("ad_type_upd(sCrInfoDtls):" + adFormatTypeA2);
            }
        }
        if (nVar.v != null && (nVar.v.equals(creativeInfo.S()) || nVar.v.equals(creativeInfo.T()))) {
            if (nVar.U) {
                Logger.d(K, "set CI details - ad is already finished, cannot set creative info");
                return false;
            }
            Logger.d(K, "set CI details - currentMaxPackageName: " + nVar.v);
            if (a(creativeInfo, nVar)) {
                Logger.d(K, "set CI details - setting as current CI for SDK: " + creativeInfo.S());
                if (creativeInfo.K() == null && (adFormatTypeA = BrandSafetyUtils.a(nVar.A)) != null) {
                    Logger.d(K, "set CI details - Start monitoring ad check, updating ad format value to " + adFormatTypeA.name());
                    creativeInfo.a(adFormatTypeA);
                    nVar.d("ad_type_upd(shldStrtMntrngAd):" + adFormatTypeA);
                }
                b(creativeInfo, nVar);
                if (CreativeInfoManager.a(creativeInfo.S(), AdNetworkConfiguration.SDK_USES_PLACEMENT_ID_ARRAY, false) && creativeInfo.H() != null && nVar.y() != null && creativeInfo.H().contains(nVar.y())) {
                    Logger.d(K, "set CI details - replacing ci placement " + creativeInfo.H() + " with Max placement " + nVar.y());
                    creativeInfo.j(nVar.y());
                }
                try {
                    boolean zA = CreativeInfoManager.a(nVar.c(), AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false);
                    com.safedk.android.utils.n.b(K, "set CI details - Multi ad detectMultipleAdsByWebview =  " + zA + ", currentActivityInterstitial.isMultiAd() = " + nVar.f() + ", currentActivityInterstitial.getImpression() != null ?" + (nVar.i() != null) + ", currentActivityInterstitial.getImpression().getCreativeInfo() != null ? " + (nVar.i().i() != null) + ", getImpressionList = " + nVar.g());
                    if (zA && nVar.f() && nVar.i() != null && nVar.i().i() != null) {
                        Logger.d(K, "set CI details - Multi ad, current impression already has a CI. not calling setCreativeInfo.");
                        return false;
                    }
                } catch (Throwable th) {
                    Logger.d(K, "Exception in set CI details - Multi ad : " + th.getMessage(), th);
                }
                return b(oVar, nVar);
            }
        }
        a(oVar, creativeInfo.S());
        creativeInfo.t("apci|ts=" + System.currentTimeMillis() + ";" + oVar.b + "|o=" + oVar.f8114a.ah() + ";" + oVar.f8114a.ai());
        b(creativeInfo, nVar);
        return false;
    }

    private void b(CreativeInfo creativeInfo, n nVar) {
        if (nVar != null) {
            synchronized (nVar.au) {
                if (nVar.ak == null || nVar.ak.isCancelled()) {
                    Logger.d(K, "start late scanning - task future is: " + nVar.ak + ", is scanning? " + nVar.al + " is ad finished? " + nVar.U);
                    if (!nVar.al) {
                        Logger.d(K, "start late scanning - starting timer for InterstitialInfo with event id: " + nVar.w());
                        f(nVar);
                        nVar.Z = 0L;
                        nVar.ak = this.E.scheduleWithFixedDelay(new b(nVar.L, nVar.v), 500L, 1000L, TimeUnit.MILLISECONDS);
                    } else {
                        Logger.d(K, "start late scanning - avoid recursive call to web view scanning");
                        creativeInfo.t("avoidRecWebScan");
                    }
                }
            }
        }
    }

    private void a(o oVar, String str) {
        if (oVar != null && oVar.f8114a != null) {
            List<o> arrayList = this.Q.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                synchronized (this.Q) {
                    this.Q.put(str, arrayList);
                }
            } else {
                synchronized (arrayList) {
                    for (o oVar2 : arrayList) {
                        if (oVar2.f8114a != null && oVar2.f8114a.equals(oVar.f8114a)) {
                            Logger.d(K, "add CI as pending match - already in pending list: " + oVar);
                            return;
                        }
                    }
                    Logger.d(K, "add CI as pending match - number of pending candidates: " + arrayList.size());
                }
            }
            if (!CreativeInfoManager.a(str, AdNetworkConfiguration.DO_NOT_ADD_CI_TO_FINDER_PENDING_CI_LIST, false)) {
                Logger.d(K, "adding as pending for SDK: " + oVar.f8114a.S() + " matching info: " + oVar);
                synchronized (arrayList) {
                    arrayList.add(oVar);
                }
                return;
            }
            Logger.d(K, "NOT adding as pending (config based), sdk: " + str + " matching info: " + oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(o oVar, n nVar) {
        com.safedk.android.utils.n.b(K, "set CI started, matching info=" + (oVar == null ? "null" : oVar.toString()) + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (oVar == null) {
            Logger.d(K, "set CI, matching info is null");
            return false;
        }
        synchronized (this.S) {
            CreativeInfo creativeInfo = oVar.f8114a;
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(creativeInfo.S());
            if (adNetworkDiscoveryI != null) {
                Logger.d(K, "set CI, matching info is " + oVar);
                if (nVar != null) {
                    if (nVar.j() != null && !nVar.j().al()) {
                        adNetworkDiscoveryI.d(creativeInfo);
                        com.safedk.android.utils.n.b(K, "set CI, already matched! ignore matching attempt CI: " + creativeInfo);
                        return false;
                    }
                    creativeInfo.b(oVar.b, oVar.c);
                    Logger.d(K, "set CI: " + creativeInfo);
                    nVar.a(creativeInfo);
                    a(creativeInfo);
                    adNetworkDiscoveryI.r(creativeInfo.N());
                    if (CreativeInfoManager.a(creativeInfo.S(), AdNetworkConfiguration.NOTIFY_DISCOVERY_CLASS_ABOUT_FULL_SCREEN_MATCHING, false)) {
                        adNetworkDiscoveryI.b(creativeInfo);
                    }
                    if (nVar.K != null) {
                        com.safedk.android.analytics.brandsafety.creatives.g.a(nVar.c(), nVar.i().a(), nVar.i());
                    }
                    if (oVar.b.startsWith(CreativeInfo.h)) {
                        nVar.u();
                    }
                    b(nVar, creativeInfo);
                    d(nVar, "setCreativeInfo");
                    if (creativeInfo.v()) {
                        nVar.i().k = false;
                    }
                    if (!nVar.ah && StatsReporter.b().a(creativeInfo, nVar)) {
                        nVar.ah = true;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private void a(CreativeInfo creativeInfo) {
        if (creativeInfo != null) {
            List<o> list = this.Q.get(creativeInfo.S());
            if (list != null) {
                synchronized (list) {
                    Iterator<o> it = list.iterator();
                    while (it.hasNext()) {
                        o next = it.next();
                        if (next.f8114a != null && next.f8114a.n() != null && next.f8114a.n().equals(creativeInfo.n())) {
                            Logger.d(K, "remove pending creative info - removing creative info from pending list: " + creativeInfo);
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, String str2, String str3, boolean z) {
        Logger.d(K, "set ad click URL started, sdk: " + str2 + ", url: " + str + ", view address: " + str3 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        String mainSdkPackage = SdksMapping.getMainSdkPackage(str2);
        n nVarA = this.G.a(str3, false);
        if (nVarA == null && this.G.a(mainSdkPackage).size() == 1) {
            Logger.d(K, "InterstitialInfo not found by address, trying by SdkPackageName " + mainSdkPackage);
            nVarA = this.G.a(mainSdkPackage).get(0);
        }
        if (nVarA != null && nVarA.c() != null && SdksMapping.isSameSdkByPackages(nVarA.c(), mainSdkPackage)) {
            if (z) {
                nVarA.an = true;
            }
            Logger.d(K, "set ad click URL - applying clickUrl candidate logic. url: " + str);
            if (!nVarA.d() && (z || nVarA.ai == null)) {
                Logger.d(K, "set ad click URL - current Activity Interstitial is not marked as clicked, setting click URL: " + str);
                b(nVarA, str);
                return true;
            }
            if (nVarA.e() == null) {
                Logger.d(K, "set ad click URL - no click URL yet, setting clickUrl: " + str);
                nVarA.c(str);
                return true;
            }
            Logger.d(K, "set ad click URL - click URL already set: " + nVarA.e());
            return false;
        }
        Logger.d(K, "set ad click URL skipped, SDK: " + (nVarA != null ? nVarA.c() : "null"));
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void a(String str, String str2, String str3) {
        n nVarA = this.G.a(str3, false);
        if (nVarA != null && nVarA.d() && str2 != null && str2.equals(nVarA.c()) && nVarA.ap != null && nVarA.ap.get() != null) {
            String string = nVarA.ap.get().toString();
            Logger.d(K, "set previous activity click url, click activity: " + string + ", ad activity: " + nVarA.ac);
            String strA = BrandSafetyUtils.a(string, true);
            if (strA != null && !strA.equals(nVarA.B)) {
                Logger.d(K, "set previous activity click url - detected URL for click in previous activity (not yet destroyed), url: " + str);
                if (nVarA.c(str)) {
                    d(nVarA, "setPreviousActivityClickUrl");
                }
            }
        }
    }

    private void a(final n nVar, final View view, final Activity activity) {
        try {
            if (nVar == null || activity == null) {
                Logger.d(K, "taking screenshot, currentActivityInterstitial or activity are null");
            } else {
                CreativeInfo creativeInfoJ = nVar.j();
                if (creativeInfoJ != null && creativeInfoJ.ao()) {
                    Logger.d(K, "_AD_CAPTURE_ taking screenshot, skip website endcard");
                } else {
                    nVar.y++;
                    Logger.d(K, "taking screenshot on UIThread, view=" + view + ", isOnUiThread : " + com.safedk.android.utils.n.c());
                    if (ScreenshotHelper.a()) {
                        Runnable runnable = new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.7
                            @Override // java.lang.Runnable
                            public void run() {
                                ScreenshotHelper.a(activity, nVar, view, SafeDK.getInstance().F());
                            }
                        };
                        Logger.d(K, "Taking screenshot - network supports copying bitmap using PC");
                        com.safedk.android.utils.l.a(this.E, runnable);
                    } else {
                        activity.runOnUiThread(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.8
                            @Override // java.lang.Runnable
                            public void run() {
                                Logger.d(InterstitialFinder.K, "taking screenshot - using old method");
                                Bitmap bitmapA = ScreenshotHelper.a(view, SafeDK.getInstance().E(), nVar);
                                if (bitmapA == null) {
                                    nVar.F();
                                    Logger.d(InterstitialFinder.K, "taking screenshot, black screenshot detected index = " + nVar.E());
                                } else {
                                    InterstitialFinder.this.a(bitmapA, nVar);
                                }
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            Logger.e(K, "taking screenshot taking screenshot exception:", th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public void a(final Bitmap bitmap, final c cVar) {
        this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.9
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                InterstitialFinder.this.a((n) cVar, cVar.c(), bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, String str, Bitmap bitmap) throws Throwable {
        if (bitmap != null) {
            BrandSafetyUtils.a aVarA = BrandSafetyUtils.a(str, bitmap);
            int iA = aVarA.a();
            BrandSafetyUtils.ScreenshotValidity screenshotValidityA = BrandSafetyUtils.a(str, aVarA);
            Logger.d(K, "process screenshot, screenshot validity = " + screenshotValidityA.name());
            if (screenshotValidityA == BrandSafetyUtils.ScreenshotValidity.UNIFORMITY_BLACK || screenshotValidityA == BrandSafetyUtils.ScreenshotValidity.UNIFORMITY_VERY_HIGH) {
                nVar.F();
                Logger.d(K, "process screenshot, black/uniform screenshot detected, index = " + nVar.E());
                return;
            }
            if (screenshotValidityA == BrandSafetyUtils.ScreenshotValidity.VALID) {
                String strA = BrandSafetyUtils.a(bitmap);
                Logger.d(K, "process screenshot found interstitial, hash = " + strA);
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
                if (adNetworkDiscoveryI != null && !adNetworkDiscoveryI.a(strA, this.R)) {
                    Logger.d(K, "process screenshot skipping file, not valid for " + str);
                    nVar.d("SkippedImageHash=" + strA);
                    return;
                }
                nVar.ag = BrandSafetyUtils.b(bitmap);
                String strN = nVar.n();
                Logger.d(K, "process screenshot impressionId is " + strN);
                String strA2 = BrandSafetyUtils.a(bitmap, BrandSafetyUtils.AdType.INTERSTITIAL, strA, str, strN, nVar.ag);
                Logger.d(K, "_AD_CAPTURE_ process screenshot screenshot file created, filename = " + strA2);
                long jC = BrandSafetyUtils.c(strA2);
                float f = (iA / 1000.0f) * 100.0f;
                if (adNetworkDiscoveryI != null && jC < adNetworkDiscoveryI.a(nVar.j())) {
                    Logger.d(K, "_AD_CAPTURE_ process screenshot file size too small " + jC + " (bytes). This image will not be used");
                    BrandSafetyUtils.d(strA2);
                    return;
                }
                Logger.d(K, "_AD_CAPTURE_ process screenshot stored file size is " + jC + " bytes, counter is " + nVar.y + ", uniform pixel count is " + iA + " (" + f + "%)");
                int size = this.C.size();
                if (!d(strA, strN)) {
                    boolean z = false;
                    if (size < SafeDK.getInstance().J()) {
                        Logger.d(K, "process screenshot impressions to report size=" + size + ", max images to store=" + SafeDK.getInstance().J());
                        if (nVar.ab == null) {
                            z = true;
                        } else if (!nVar.ab.equals(strA)) {
                            Logger.d(K, "process screenshot removing previous file : " + nVar.t);
                            BrandSafetyUtils.d(nVar.t);
                            z = true;
                        }
                        if (z) {
                            Logger.d(K, "process screenshot keeping file of interstitial " + strA + ". file size is " + jC + " (bytes), orientation: " + nVar.ag);
                            BrandSafetyUtils.a(nVar.t(), BrandSafetyUtils.AdType.INTERSTITIAL, strA, str, strN, nVar.ag);
                        }
                    } else if (!c(strA, strN)) {
                        Logger.d(K, "process screenshot no open slot for interstitial " + strA);
                        BrandSafetyUtils.d(strA2);
                        strA = null;
                    } else {
                        Logger.d(K, "process screenshot image " + strA + "_" + strN + " is already scheduled for upload");
                    }
                } else {
                    Logger.d(K, "process screenshot not saving file for interstitial " + strA + "_" + strN);
                    BrandSafetyUtils.d(strA2);
                    if (d(strA, strN)) {
                        Logger.d(K, "process screenshot interstitial " + strA + "_" + strN + " was already reported");
                    } else {
                        Logger.d(K, "process screenshot waiting to report stored interstitial " + nVar.ab);
                    }
                    if (nVar.ab != null) {
                        if (c(nVar.ab, nVar.n())) {
                            BrandSafetyUtils.d(nVar.t);
                        } else {
                            Logger.d(K, "process screenshot not deleting not best image " + nVar.t);
                        }
                    }
                }
                boolean z2 = false;
                if (strA != null) {
                    Logger.d(K, "process screenshot setting interstitial info data (previous hash = " + nVar.ab + ", current hash = " + strA + ")");
                    z2 = (nVar.ab == null || strA.equals(nVar.ab)) ? false : true;
                }
                if (nVar.ag.equals(BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED)) {
                    nVar.ag = BrandSafetyUtils.b(bitmap);
                }
                k kVarI = nVar.i();
                if (kVarI != null) {
                    kVarI.b("img", new l.a("typ", l.X));
                    Logger.d(K, "process screenshot setting image details: " + kVarI.c);
                    kVarI.c = new j(strA, strA2, jC, iA, nVar.y, nVar.ag, z2);
                    d(nVar, "processScreenshot");
                }
                if (nVar.ao) {
                    nVar.as = true;
                    nVar.ao = false;
                    Logger.d(K, "first candidate image sample, resetting resources collection cycle");
                }
                if (nVar.ab == null) {
                    Logger.d(K, "process screenshot no previous hash to detect animation, keep sampling");
                    nVar.ab = strA;
                    nVar.t = strA2;
                    nVar.u = nVar.ag;
                    return;
                }
                boolean z3 = true;
                CreativeInfo creativeInfoJ = nVar.j();
                if (creativeInfoJ != null && creativeInfoJ.F()) {
                    if (z2) {
                        Logger.d(K, "process screenshot, shopping collage didn't finished loading");
                        z3 = false;
                    } else {
                        Logger.d(K, "process screenshot, shopping collage finished loading");
                    }
                }
                if (a(iA, jC) && z3) {
                    if (kVarI != null) {
                        kVarI.a("img", new l.a("typ", l.Y));
                    }
                    j jVarM = nVar.m();
                    if (jVarM != null) {
                        jVarM.g = z2;
                        Logger.d(K, "process screenshot setting interstitial is_animated field to " + z2);
                    }
                    if (!TextUtils.isEmpty(strA)) {
                        if (nVar.ag.equals(BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED) && jVarM != null) {
                            jVarM.f = BrandSafetyUtils.b(bitmap);
                        }
                        Logger.d(K, "process screenshot - before reporting, debug info is: " + nVar.B());
                        d(nVar, "processScreenshot");
                        nVar.e(true);
                    }
                    nVar.am = true;
                    Logger.d(K, "final image sampled twice, not forcing resources collection");
                    return;
                }
                nVar.ab = strA;
                nVar.t = strA2;
                nVar.u = nVar.ag;
                return;
            }
            Logger.d(K, "_AD_CAPTURE_ process screenshot is not valid: " + screenshotValidityA.name() + ", pixel count: " + iA + ", try again...");
            if (nVar.aa && nVar.i().k) {
                Logger.d(K, "process screenshot back from background - reset video completed indication to false");
                nVar.aa = false;
                nVar.i().k = false;
            }
        }
    }

    private boolean a(int i, int i2) {
        return i == BrandSafetyUtils.a() && i2 == BrandSafetyUtils.b();
    }

    private boolean a(int i, long j) {
        Logger.d(K, "should stop sampling started, maxUniformedPixelsCount=" + i + ", fileSize=" + j + " (bytes), stopSamplingFileSize=" + SafeDK.getInstance().K());
        boolean z = BrandSafetyUtils.a(i) && j > SafeDK.getInstance().K();
        Logger.d(K, "should stop sampling returned " + z);
        return z;
    }

    @Override // com.safedk.android.internal.a
    public void g() {
        if (this.G != null) {
            for (n nVar : this.G.values()) {
                if (nVar != null && nVar.Y) {
                    nVar.a(l.z, new l.a[0]);
                    d(nVar, "onBackground");
                }
            }
        }
    }

    @Override // com.safedk.android.internal.a
    public void h() {
        ArrayList<n> arrayList;
        if (this.G != null) {
            synchronized (this.G) {
                arrayList = new ArrayList(this.G.values());
            }
            for (n nVar : arrayList) {
                if (nVar != null) {
                    nVar.a(l.A, new l.a[0]);
                    d(nVar, "onForeground");
                    if (!nVar.i().k) {
                        nVar.aa = true;
                    }
                }
            }
        }
    }

    private void a(List<WeakReference<WebView>> list, n nVar) {
        Iterator<WeakReference<WebView>> it = list.iterator();
        while (it.hasNext()) {
            WebView webView = it.next().get();
            if (webView != null) {
                String strA = BrandSafetyUtils.a((Class) webView.getClass());
                if (!TextUtils.isEmpty(strA) && !strA.equals(nVar.c()) && strA.equals(com.safedk.android.utils.h.h)) {
                    Logger.d(K, "identify scar-admob - webView is Admob: " + webView + ", current interstitial info: " + nVar);
                    nVar.T = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WeakReference<WebView>> e(n nVar) {
        if (nVar == null || nVar.ap == null || nVar.ap.get() == null || nVar.al) {
            Logger.d(K, "scan for webViews activity is null, skipping");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Activity activity = nVar.ap.get();
        if (activity != null && BrandSafetyUtils.h(activity.getClass().getName())) {
            try {
                nVar.al = true;
                View viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
                if (viewFindViewById != null) {
                    b((ViewGroup) viewFindViewById, arrayList);
                }
                nVar.al = false;
            } catch (Throwable th) {
                Logger.d(K, "caught exception: ", th);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final n nVar) {
        if (nVar == null || nVar.ap == null || nVar.ap.get() == null || nVar.al) {
            Logger.d(K, "scan for webViews activity is null, skipping");
            return;
        }
        Activity activity = nVar.ap.get();
        Logger.d(K, "scan for webViews started, activity: " + (activity == null ? "null" : activity.toString()) + ", currentActivityInterstitial.resourceMatching: " + nVar.J + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (activity == null || !BrandSafetyUtils.h(activity.getClass().getName())) {
            try {
                if (nVar.J == AdNetworkDiscovery.WebViewResourceMatchingMethod.DEFAULT) {
                    Logger.d(K, "scan for webViews : resourceMatching DEFAULT");
                    if (nVar.j() != null) {
                        View viewF = nVar.j().f();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        arrayList2.add(BrandSafetyUtils.a(viewF));
                        arrayList3.add("h1c1:" + viewF);
                        String strC = nVar.c() != null ? nVar.c() : "";
                        a(nVar, strC, (ViewGroup) viewF, arrayList, arrayList2, arrayList3, 1);
                        Logger.d(K, "scan for webViews resourceMatching DEFAULT found viewHierarchy " + arrayList3);
                        if (nVar.x() != null) {
                            Logger.d(K, "scan for webViews resourceMatching DEFAULT previous ViewsHierarchy size :  " + nVar.x().size() + " , current : " + arrayList2.size());
                            long jA = CreativeInfoManager.a(strC, AdNetworkConfiguration.NUMBER_OF_VIEWS_REMOVED_IN_FULL_SCREEN_AD_THAT_INDICATES_EOV, 0L);
                            if (jA > 0 && nVar.x().size() >= jA + ((long) arrayList2.size())) {
                                Logger.d(K, "scan for webViews resourceMatching DEFAULT End of video detected");
                                a(strC, BrandSafetyUtils.a(viewF), true, "native");
                            }
                        } else {
                            nVar.a(l.l, new l.a(l.L, "none"));
                        }
                        nVar.a(arrayList2);
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                Logger.e(K, "scan for webViews resourceMatching DEFAULT exception : ", th);
                return;
            } finally {
                Logger.d(K, "scan for webViews resourceMatching DEFAULT exit scanning");
                nVar.al = false;
            }
        }
        try {
            try {
                nVar.al = true;
                View viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
                final AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(nVar.c());
                String strC2 = nVar.c() != null ? nVar.c() : "";
                if (adNetworkDiscoveryI == null) {
                    Logger.d(K, "scan for webViews - exit scanning");
                    nVar.al = false;
                    return;
                }
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                if (viewFindViewById != null) {
                    arrayList5.add(BrandSafetyUtils.a(viewFindViewById));
                    arrayList6.add("h1c1:" + viewFindViewById);
                    a(nVar, strC2, (ViewGroup) viewFindViewById, arrayList4, arrayList5, arrayList6, 1);
                    a(arrayList4, nVar);
                    com.safedk.android.utils.n.b(K, "scan for webViews found views hierarchy : " + arrayList6);
                }
                if (nVar.J == AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP) {
                    String strN = nVar.j() != null ? nVar.j().N() : null;
                    for (String str : arrayList5) {
                        if (CreativeInfoManager.d.remove(str)) {
                            Logger.d(K, "scan for webViews - video start received for " + str);
                            nVar.i().l = true;
                            break;
                        }
                    }
                    final WeakReference<WebView> weakReferenceA = adNetworkDiscoveryI.a((List<WeakReference<WebView>>) arrayList4, strN);
                    if (weakReferenceA == null || weakReferenceA.get() == null) {
                        Logger.d(K, "scan for webViews - WebView not found");
                        if (nVar.m == null) {
                            nVar.a(l.l, new l.a(l.L, "none"));
                        }
                        nVar.a(arrayList5);
                    } else {
                        nVar.a(arrayList5);
                        nVar.b(arrayList4);
                        final String strA = BrandSafetyUtils.a((Object) weakReferenceA.get());
                        if (nVar.K == null) {
                            a(strA, l.l, new l.a(l.L, strA));
                        }
                        SafeDKWebAppInterface.a(strA);
                        if (nVar.K != null && nVar.K.equals(strA)) {
                            Logger.d(K, "scan for webViews - exit scanning");
                            nVar.al = false;
                            return;
                        }
                        Logger.d(K, "scan for webViews found " + weakReferenceA.get());
                        boolean zA = CreativeInfoManager.a(nVar.c(), AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false);
                        Logger.d(K, "scan for webViews, should detect multiple ads by web view change? " + zA);
                        if (zA && nVar.K != null && !nVar.K.equals(strA)) {
                            f(nVar, strA);
                        }
                        nVar.K = strA;
                        nVar.i().a(strA);
                        Logger.d(K, "scan for webViews address set to " + strA);
                        for (k kVar : nVar.g()) {
                            CreativeInfo creativeInfoI = kVar.i();
                            if (creativeInfoI != null) {
                                Logger.d(K, "scan for webViews - current ci is: " + creativeInfoI.aa());
                            }
                            if (arrayList5.contains(kVar.a())) {
                                Logger.d(K, "scan for webViews attempting to collect resources for " + strA);
                                com.safedk.android.analytics.brandsafety.creatives.g.a(nVar.c(), strA, kVar);
                            } else if (creativeInfoI != null) {
                                Logger.d(K, "scan for webViews skip resources collection for address: " + strA + ", CI: " + creativeInfoI.aa());
                            }
                            if (creativeInfoI == null) {
                                Logger.d(K, "scan for webViews will check for pending CIs for package " + nVar.c());
                                Iterator<o> it = a(nVar.c(), nVar).iterator();
                                while (it.hasNext()) {
                                    b(it.next(), nVar);
                                }
                            }
                        }
                        if (adNetworkDiscoveryI.d() != null && adNetworkDiscoveryI.d().a(AdNetworkConfiguration.APP_OPEN_IMPRESSION_TRACKING_ENABLED, false) && nVar.A != null && nVar.A.containsKey("ad_format") && nVar.A.getString("ad_format").equals(BrandSafetyUtils.l)) {
                            this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.10
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (weakReferenceA != null && weakReferenceA.get() != null) {
                                        List<CreativeInfo> listA = adNetworkDiscoveryI.a(new WeakReference<>((View) weakReferenceA.get()), (String) null, BrandSafetyUtils.AdType.INTERSTITIAL);
                                        if (listA != null) {
                                            for (CreativeInfo creativeInfo : listA) {
                                                com.safedk.android.utils.n.b(InterstitialFinder.K, "scan for webViews ci returned : " + creativeInfo.aa());
                                                if (creativeInfo.n() == null) {
                                                    creativeInfo.h(nVar.L);
                                                }
                                                if (nVar.A != null && nVar.A.containsKey("ad_format")) {
                                                    BrandSafetyEvent.AdFormatType adFormatTypeA = BrandSafetyUtils.a(nVar.A);
                                                    creativeInfo.a(adFormatTypeA);
                                                    nVar.d("ad_type_upd(scnFrWVs):" + adFormatTypeA);
                                                    Logger.d(InterstitialFinder.K, "scan for webViews ad_format set to  : " + adFormatTypeA);
                                                }
                                                InterstitialFinder.this.a(new o(creativeInfo, CreativeInfo.n, strA));
                                            }
                                            return;
                                        }
                                        Logger.d(InterstitialFinder.K, "scan for webViews ci not found by View");
                                    }
                                }
                            });
                        }
                    }
                } else if (viewFindViewById != null && nVar.J == AdNetworkDiscovery.WebViewResourceMatchingMethod.DIRECT_CREATIVE_INFO) {
                    WeakReference<WebView> weakReferenceA2 = adNetworkDiscoveryI.a((List<WeakReference<WebView>>) arrayList4, (String) null);
                    if (weakReferenceA2 == null || weakReferenceA2.get() == null) {
                        Logger.d(K, "scan for webViews (DIRECT_CREATIVE_INFO) - WebView not found");
                    } else {
                        String strA2 = BrandSafetyUtils.a((Object) weakReferenceA2.get());
                        if (nVar.K == null) {
                            a(strA2, l.l, new l.a(l.L, strA2));
                        }
                        Logger.d(K, "scan for webViews found (DIRECT_CREATIVE_INFO) " + strA2);
                        nVar.K = strA2;
                        nVar.i().a(strA2);
                        k kVarI = nVar.i();
                        if (kVarI != null) {
                            Logger.d(K, "scan for webViews (DIRECT_CREATIVE_INFO) attempting to collect resources for " + strA2);
                            com.safedk.android.analytics.brandsafety.creatives.g.a(nVar.c(), strA2, kVarI);
                        }
                        nVar.a(arrayList5);
                    }
                } else if (nVar.J == AdNetworkDiscovery.WebViewResourceMatchingMethod.DEFAULT) {
                    if (nVar.m == null) {
                        nVar.a(l.l, new l.a(l.L, "none"));
                    }
                    nVar.a(arrayList5);
                }
                Logger.d(K, "scan for webViews - exit scanning");
                nVar.al = false;
            } catch (Throwable th2) {
                Logger.e(K, "scan for webViews execution: ", th2);
                Logger.d(K, "scan for webViews - exit scanning");
                nVar.al = false;
            }
        } catch (Throwable th3) {
            Logger.d(K, "scan for webViews - exit scanning");
            nVar.al = false;
            throw th3;
        }
    }

    private void f(n nVar, String str) {
        Logger.d(K, "handle web view change, web view change detected from: " + nVar.K + ", to: " + str + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        k kVarI = nVar.i();
        if (kVarI != null && kVarI.i() != null && !kVarI.i().al()) {
            kVarI.i().am();
            String strH = kVarI.i().h();
            if (strH != null) {
                kVarI.i().e(strH + CreativeInfo.aK);
            }
        }
        nVar.g().add(new k(UUID.randomUUID().toString()));
        Logger.d(K, "handle WebView Change - new Impression info object created. number of impressions in ad : " + nVar.g().size());
        if (nVar.D == null) {
            nVar.D = UUID.randomUUID().toString();
        }
        nVar.ae = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final n nVar, final Activity activity) {
        this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.InterstitialFinder.2
            @Override // java.lang.Runnable
            public void run() {
                BrandSafetyUtils.AdType adTypeB;
                BrandSafetyUtils.AdType adTypeA;
                ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
                String strB = BrandSafetyUtils.b(activity.getClass());
                try {
                    if (nVar != null && nVar.k().isEmpty() && CreativeInfoManager.a(strB) == AdNetworkDiscovery.WebViewResourceMatchingMethod.WEBVIEW_LOOKUP && nVar.A != null && nVar.A.containsKey("ad_format") && nVar.A.get("ad_format") != null && CreativeInfoManager.a(strB, AdNetworkConfiguration.SHOULD_SCAN_INTERSTITIAL_VIEW_HIERARCHY_FOR_CI, false)) {
                        String strY = nVar.y();
                        BrandSafetyEvent.AdFormatType adFormatTypeA = BrandSafetyUtils.a(nVar.A);
                        Logger.d(InterstitialFinder.K, "try to find CI, ad format = " + adFormatTypeA + ", placement = " + strY + ", activity sdk = " + strB);
                        List<CreativeInfo> listB = InterstitialFinder.this.b(viewGroup, strB);
                        if (listB != null) {
                            Logger.d(InterstitialFinder.K, "try to find CI, updating ad format value to " + adFormatTypeA);
                            InterstitialFinder.this.a(activity, nVar);
                            for (CreativeInfo creativeInfo : listB) {
                                if (creativeInfo.K() != null && adFormatTypeA != null && (adTypeB = BrandSafetyUtils.b(creativeInfo.K())) != (adTypeA = BrandSafetyUtils.a(adFormatTypeA))) {
                                    Logger.d(InterstitialFinder.K, "try to find CI, skipping CI due to incompatible ad type - CI:" + adTypeB + ", max: " + adTypeA);
                                } else {
                                    creativeInfo.a(adFormatTypeA);
                                    nVar.d("ad_type_upd(tryTFndCI):" + adFormatTypeA);
                                    creativeInfo.h(nVar.A.getString("id"));
                                    creativeInfo.j(nVar.A.getString(BrandSafetyEvent.k));
                                    Logger.d(InterstitialFinder.K, "try to find CI - ci event id : " + creativeInfo.n() + ", placement id : " + creativeInfo.H());
                                    InterstitialFinder.this.a(new o(creativeInfo, CreativeInfo.n));
                                }
                            }
                            return;
                        }
                        Logger.d(InterstitialFinder.K, "try to find CI - did not find CIs for event id: " + nVar.L);
                    }
                } catch (Throwable th) {
                    Logger.d(InterstitialFinder.K, "Exception while attempting to find CI : " + th.getMessage(), th);
                }
            }
        });
    }

    public void b(n nVar, String str) {
        nVar.ai = new h(System.currentTimeMillis(), str);
    }

    public void g(String str, String str2) {
        Logger.d(K, "setCurrentInterstitialDownstreamStruct started");
        List<n> listA = this.G.a(str);
        if (listA.size() == 1) {
            n nVar = listA.get(0);
            if (nVar != null) {
                List<CreativeInfo> listK = nVar.k();
                if (!listK.isEmpty() && str2 != null) {
                    for (CreativeInfo creativeInfo : listK) {
                        String strH = creativeInfo.h();
                        if (strH != null && !strH.endsWith(str2)) {
                            creativeInfo.e(strH + RemoteSettings.FORWARD_SLASH_STRING + str2);
                        }
                    }
                    return;
                }
                return;
            }
            return;
        }
        Logger.d(K, "setCurrentInterstitialDownstreamStruct number of Infos for " + str + " is " + listA.size() + ", cannot set downstream struct");
    }

    public void r(String str) {
        List<CreativeInfo> listK;
        Logger.d(K, "setStopCollectingResources started");
        List<n> listA = this.G.a(str);
        if (listA.size() == 1) {
            n nVar = listA.get(0);
            if (nVar != null && (listK = nVar.k()) != null && !listK.isEmpty()) {
                for (CreativeInfo creativeInfo : listK) {
                    String strH = creativeInfo.h();
                    if (strH != null && strH.contains(com.safedk.android.analytics.brandsafety.creatives.discoveries.o.b)) {
                        creativeInfo.a(true);
                    }
                }
                return;
            }
            return;
        }
        Logger.d(K, "setStopCollectingResources number of Infos for " + str + " is " + listA.size() + ", cannot stop collecting resources");
    }

    private class b implements Runnable {
        private final String b;
        private boolean c;
        private boolean d = true;
        private int e = 0;

        public b(String str, String str2) {
            this.b = str;
            this.c = CreativeInfoManager.a(str2, AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, false) || CreativeInfoManager.a(str2, AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, false);
        }

        private void a(n nVar, long j) {
            Logger.d(InterstitialFinder.K, "scan for screenshots, info " + nVar.L + ", isCancelled = " + (nVar.ak != null ? Boolean.valueOf(nVar.ak.isCancelled()) : "?") + ", isDone = " + (nVar.ak != null ? Boolean.valueOf(nVar.ak.isDone()) : "?") + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            if (nVar.j() == null && nVar.ap != null && nVar.ap.get() != null && CreativeInfoManager.a(BrandSafetyUtils.b(nVar.ap.get().getClass()), AdNetworkConfiguration.SHOULD_SCAN_INTERSTITIAL_VIEW_HIERARCHY_FOR_CI, false)) {
                Logger.d(InterstitialFinder.K, "scan for screenshots, info " + nVar.L + " calling tryToFindCI");
                InterstitialFinder.this.a(nVar, nVar.ap.get());
            }
            if (nVar.ap != null && nVar.ap.get() != null) {
                Logger.d(InterstitialFinder.K, "scan for screenshots, activity sdk is " + BrandSafetyUtils.b(nVar.ap.get().getClass()));
            }
            if (!nVar.E && nVar.y == 2) {
                InterstitialFinder.this.d(nVar, "scanForScreenshots");
            }
            if (InterstitialFinder.this.P == 0 || j - InterstitialFinder.this.P >= 900.0d) {
                InterstitialFinder.this.P = j;
                if (!nVar.ae) {
                    InterstitialFinder.this.a(nVar);
                } else {
                    Logger.d(InterstitialFinder.K, "scan for screenshots, request to stop taking screenshots has been received, skipping.");
                }
                CreativeInfo creativeInfoJ = nVar.j();
                if (nVar.y != 120 && (creativeInfoJ == null || !creativeInfoJ.ao())) {
                    InterstitialFinder.this.f(nVar);
                    if (nVar.k().isEmpty()) {
                        Logger.d(InterstitialFinder.K, "scan for screenshots, checking for pending CIs");
                        for (o oVar : InterstitialFinder.this.a(nVar.v, nVar)) {
                            if (oVar != null && oVar.f8114a != null) {
                                Logger.d(InterstitialFinder.K, "scan for screenshots, calling set CI");
                                InterstitialFinder.this.b(oVar, nVar);
                            }
                        }
                        return;
                    }
                    return;
                }
                if (creativeInfoJ != null && creativeInfoJ.ao()) {
                    Logger.d(InterstitialFinder.K, "scan for screenshots, website end card detected, stop taking screenshots for event id " + this.b);
                } else {
                    Logger.d(InterstitialFinder.K, "scan for screenshots, max number of screenshots threshold reached, stop taking screenshots for event id " + this.b);
                }
                this.d = false;
            }
        }

        private void a(n nVar, boolean z, boolean z2) {
            String strB;
            try {
                List<Integer> listB = com.safedk.android.internal.d.B();
                List<Integer> listD = com.safedk.android.internal.d.D();
                boolean z3 = z || listB.contains(Integer.valueOf(this.e));
                boolean z4 = z2 || listD.contains(Integer.valueOf(this.e));
                if ((z3 || z4) && com.safedk.android.utils.n.a((Reference<?>) nVar.ap)) {
                    Logger.d(InterstitialFinder.K, "inject periodic script, cycle: " + this.e);
                    String str = nVar.v;
                    List<WeakReference<WebView>> listB2 = InterstitialFinder.this.b(com.safedk.android.analytics.brandsafety.b.a((ViewGroup) nVar.ap.get().getWindow().getDecorView().findViewById(R.id.content)));
                    AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
                    if (adNetworkDiscoveryI != null) {
                        WeakReference<WebView> weakReferenceA = adNetworkDiscoveryI.a(listB2, (String) null);
                        Logger.d(InterstitialFinder.K, "inject periodic script, webView: " + (weakReferenceA != null ? weakReferenceA.get() : "null"));
                        if (com.safedk.android.utils.n.a((Reference<?>) weakReferenceA)) {
                            com.safedk.android.analytics.brandsafety.creatives.b bVarJ = CreativeInfoManager.j(str);
                            String strA = BrandSafetyUtils.a((Object) weakReferenceA.get());
                            boolean z5 = weakReferenceA.get().getVisibility() == 0;
                            if (!z5) {
                                Logger.d(InterstitialFinder.K, "webView: " + weakReferenceA.get() + " is not visible - will not collect resources in this cycle");
                            }
                            if (z3 && bVarJ.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN) && z5) {
                                List<String> listX = nVar.x();
                                if (strA != null && listX != null && !listX.contains(strA)) {
                                    listX.add(strA);
                                    nVar.a(listX);
                                }
                                SafeDKWebAppInterface.a(str, weakReferenceA.get(), SafeDKWebAppInterface.b(str, strA, nVar.w()));
                            }
                            if (z4 && bVarJ.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES) && (strB = SafeDKWebAppInterface.b(str, strA)) != null) {
                                SafeDKWebAppInterface.a(str, weakReferenceA.get(), strB);
                            }
                        }
                    }
                    if (this.e >= listB.get(listB.size() - 1).intValue() && this.e >= listD.get(listD.size() - 1).intValue()) {
                        Logger.d(InterstitialFinder.K, "inject periodic script, reached or surpassed last interval: " + this.e + " for wither eresources collection intervals or video observer intervals");
                        this.c = false;
                    }
                }
                this.e++;
            } catch (Throwable th) {
                Logger.e(InterstitialFinder.K, "interstitial finder task execution: ", th);
            }
        }

        private CreativeInfo a(n nVar) {
            AdNetworkDiscovery adNetworkDiscoveryI;
            k kVarI;
            try {
                String str = nVar.v;
                if (str == null || (adNetworkDiscoveryI = CreativeInfoManager.i(str)) == null || (kVarI = nVar.i()) == null || kVarI.n == null || kVarI.n.isEmpty()) {
                    return null;
                }
                return adNetworkDiscoveryI.a(kVarI.n);
            } catch (Throwable th) {
                Logger.e(InterstitialFinder.K, "interstitial finder task execution: ", th);
                return null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            CreativeInfo creativeInfoA;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.b == null) {
                    Logger.d(InterstitialFinder.K, "interstitial finder task, event id is null, skipping.");
                    return;
                }
                n nVar = InterstitialFinder.this.G.get(this.b);
                if (nVar == null) {
                    Logger.d(InterstitialFinder.K, "interstitial finder task, did not find interstitial info for event id: " + this.b);
                    return;
                }
                if (nVar.as) {
                    Logger.d(InterstitialFinder.K, "interstitial finder task, restart periodic script injection");
                    this.e = 0;
                    this.c = CreativeInfoManager.a(nVar.v, AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true) || CreativeInfoManager.a(nVar.v, AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, false);
                    nVar.as = false;
                }
                if (this.d && !nVar.am) {
                    a(nVar, jCurrentTimeMillis);
                }
                if (this.c) {
                    a(nVar, false, false);
                }
                com.safedk.android.analytics.brandsafety.creatives.g.a((List<WeakReference<WebView>>) InterstitialFinder.this.e(nVar), nVar);
                if (nVar.j() == null && (creativeInfoA = a(nVar)) != null) {
                    creativeInfoA.i(BrandSafetyUtils.ScreenShotOrientation.PORTRAIT.equals(BrandSafetyUtils.c()));
                    InterstitialFinder.this.a(new o(creativeInfoA, creativeInfoA.Y()), nVar);
                }
            } catch (Throwable th) {
                Logger.e(InterstitialFinder.K, "interstitial finder task execution: ", th);
            }
        }
    }

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8013a;
        String b;

        public a(String str, String str2) {
            this.f8013a = str;
            this.b = str2;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            a aVar = (a) o;
            boolean zEquals = this.f8013a.equals(aVar.f8013a);
            if (this.b != null) {
                return zEquals && this.b.equals(aVar.b);
            }
            return zEquals;
        }

        public int hashCode() {
            return this.b != null ? this.f8013a.hashCode() * this.b.hashCode() : this.f8013a.hashCode();
        }

        public String toString() {
            return "{placementId=" + this.f8013a + ", eventId=" + this.b + "}";
        }

        public String a() {
            return (this.f8013a != null ? this.f8013a : "") + "_" + (this.b != null ? this.b : "");
        }
    }

    private static View a(ViewGroup viewGroup, String str) {
        Logger.d(K, "find views " + viewGroup.toString());
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Logger.d(K, "find views child " + childAt.toString());
            if (str != null && childAt.getClass().getName().equals(str)) {
                Logger.d(K, "find views found " + str + " : " + childAt.toString());
                return childAt;
            }
            if (childAt instanceof ViewGroup) {
                return a((ViewGroup) childAt, str);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<CreativeInfo> b(ViewGroup viewGroup, String str) {
        List<CreativeInfo> listA;
        Logger.d(K, "get creative info from ad view started : " + viewGroup.toString() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            Logger.d(K, "get creative info from ad view - child " + childAt.toString());
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
            if (adNetworkDiscoveryI != null && (listA = adNetworkDiscoveryI.a(new WeakReference<>(childAt), (String) null, BrandSafetyUtils.AdType.INTERSTITIAL)) != null) {
                for (CreativeInfo creativeInfo : listA) {
                    creativeInfo.a((Object) childAt);
                    creativeInfo.t("ci_source_sdk_class=" + childAt.getClass().getName());
                    Logger.d(K, "get creative info from ad view - ci found, object : " + childAt.toString());
                }
                return listA;
            }
            if (childAt instanceof ViewGroup) {
                return b((ViewGroup) childAt, str);
            }
        }
        return null;
    }

    public static void a(View view, int i) {
        Logger.d(K, "find views view : " + new String(new char[i * 2]).replace("\u0000", "-") + view.getClass().toString() + new StringBuilder().toString());
    }

    @Override // com.safedk.android.analytics.brandsafety.f
    public void b(k kVar) {
        a(kVar);
        synchronized (this.C) {
            com.safedk.android.utils.n.b(K, "adInfoCollectionForUpload count = " + this.C.size() + " : " + this.C);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n a(String str, RedirectDetails redirectDetails, m mVar, boolean z, boolean z2) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, x xVar) {
        c cVarB = b(str, xVar);
        if (!(cVarB instanceof n)) {
            return false;
        }
        d((n) cVarB, "handleWebsiteOpened");
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean b(String str, String str2, String str3) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public void c(String str, String str2, String str3) {
        n nVarA = this.G.a(str, false);
        if (nVarA != null) {
            if (com.safedk.android.analytics.brandsafety.b.y.equals(str3)) {
                nVarA.a(str2, true);
            } else {
                nVarA.d(str2);
            }
            Logger.d(K, "pass message to ad info - message: " + str2 + " has passed to info: " + nVarA);
            return;
        }
        Logger.d(K, "pass message to ad info - info is null");
    }

    public boolean f() {
        synchronized (this.G) {
            Iterator<n> it = this.G.values().iterator();
            while (it.hasNext()) {
                if (!it.next().U) {
                    return true;
                }
            }
            return false;
        }
    }
}
