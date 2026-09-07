package com.safedk.android.analytics.brandsafety;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.StatsReporter;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.ScreenshotHelper;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.LinkedHashSetWithItemLimit;
import com.safedk.android.utils.Logger;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
public class NativeFinder extends b {
    public static final int G = 5;
    protected static final long H = 1000;
    protected static final long I = 500;
    private static final String J = "NativeFinder";
    private static final long K = 10;
    private static final Map<String, WeakReference<MaxNativeAdView>> O = new HashMap();
    private static final Map<String, WeakReference<MaxNativeAdView>> P = new HashMap();
    private static final Map<String, String> Q = new HashMap();
    private final LinkedHashSetWithItemLimit<String> L;
    private final Map<d, s> M;
    private final Map<String, o> N;

    public NativeFinder(int maxAttemptsToCaptureImage) {
        super(BrandSafetyUtils.AdType.NATIVE, Collections.singletonList("NATIVE"), J, maxAttemptsToCaptureImage);
        this.L = new LinkedHashSetWithItemLimit<>(10L);
        this.M = new HashMap();
        this.N = new HashMap();
    }

    @Override // com.safedk.android.analytics.brandsafety.b
    protected c a(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5) {
        return new s(str, str2, str3, screenShotOrientation, str4, str5);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage message) {
        String string;
        if (SafeDK.getInstance() != null && SafeDK.getInstance().p() && SafeDK.getInstance() != null && SafeDK.getInstance().r()) {
            try {
                Bundle messageData = message.getMessageData();
                if (messageData.containsKey("revenue_event") && messageData.containsKey("ad_format") && this.b.contains(messageData.getString("ad_format"))) {
                    Logger.d(J, "Revenue event detected : " + messageData);
                    string = "revenue_event";
                } else {
                    string = messageData.getString("type");
                }
                String string2 = messageData.getString("ad_format");
                String string3 = messageData.getString(BrandSafetyEvent.k);
                String string4 = messageData.getString(BrandSafetyEvent.l);
                String strN = BrandSafetyUtils.n(messageData.getString("ad_view"));
                String string5 = messageData.getString("id", null);
                if (string5 == null) {
                    Logger.d(J, "No eventId in data bundle, cannot match");
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
                    Logger.d(J, "Max message received, package: " + strB + ", ts (seconds): " + jB + ", message received: " + message.getMessageData() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                    d dVar = new d(string4, string3, string5, strB, string6, BrandSafetyUtils.AdType.NATIVE);
                    if ("WILL_DISPLAY".equals(string)) {
                        if (strB != null && f(string6, strB)) {
                            Logger.d(J, "WILL_DISPLAY event for package=" + strB + ", key=" + dVar + ", view address=" + strN + ", slot count=" + this.d);
                            CreativeInfoManager.a(strB, string3, string7, string5, string2);
                            a(string5, l.f, new l.a(l.L, BrandSafetyUtils.n(messageData.getString("ad_view"))));
                        }
                        a(string6, strB, string7, dVar, strN, messageData, jCurrentTimeMillis);
                        return;
                    }
                    if ("revenue_event".equals(string)) {
                        if (strB != null && f(string6, strB)) {
                            Logger.d(J, "REVENUE_EVENT event for package=" + strB + ", key=" + dVar + ", view address=" + strN + ", slot count=" + this.d);
                            a(string5, l.k, new l.a("typ", messageData.getString("revenue_event")));
                        }
                        a(string6, strB, string7, dVar, strN, messageData);
                        return;
                    }
                    if ("DID_CLICKED".equals(string)) {
                        if (f(string6, strB)) {
                            a(string5, l.h, new l.a[0]);
                            if (this.M.get(dVar) != null) {
                                StringBuilder sbAppend = new StringBuilder().append("DID_CLICKED event for package=");
                                if (strB != null) {
                                    string6 = strB;
                                }
                                Logger.d(J, sbAppend.append(string6).append(", slot count=").append(this.d).toString());
                                c(dVar);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if ("WILL_LOAD".equals(string)) {
                        if (strB != null && f(string6, strB)) {
                            Logger.d(J, "WILL_LOAD event for package=" + strB + ", key=" + dVar + ", slot count=" + this.d);
                            a(string5, l.d, new l.a(l.N, string6));
                            return;
                        }
                        return;
                    }
                    if ("DID_HIDE".equals(string)) {
                        if (strB != null && f(string6, strB)) {
                            Logger.d(J, "DID_HIDE event for package=" + strB + ", key=" + dVar + ", slot count=" + this.d);
                            a(string5, l.i, new l.a[0]);
                            a(dVar);
                            return;
                        }
                        return;
                    }
                    if ("DID_LOAD".equals(string)) {
                        if (strB != null && f(string6, strB)) {
                            Logger.d(J, "DID_LOAD event for package=" + strB + ", key=" + dVar + ", slot count=" + this.d);
                            a(string5, l.e, new l.a(l.N, string6));
                            return;
                        }
                        return;
                    }
                    if ("DID_DISPLAY".equals(string)) {
                        if (strB != null && f(string6, strB)) {
                            Logger.d(J, "DID_DISPLAY event for package=" + strB + ", key=" + dVar + ", slot count=" + this.d);
                            a(string5, l.g, new l.a[0]);
                            a(strB, dVar, string7, messageData, jCurrentTimeMillis);
                            return;
                        }
                        return;
                    }
                    if ("DID_FAIL_DISPLAY".equals(string) && strB != null && f(string6, strB)) {
                        Logger.d(J, "DID_FAIL_DISPLAY event for package=" + strB + ", key=" + dVar + ", slot count=" + this.d);
                        a(string5, l.j, new l.a[0]);
                        b(dVar);
                    }
                }
            } catch (Throwable th) {
                Logger.e(J, "on message received exception", th);
            }
        }
    }

    private void a(String str, String str2, String str3, d dVar, String str4, Bundle bundle, long j) {
        s sVar;
        if (this.L.contains(dVar.c)) {
            Logger.d(J, "handle WILL_DISPLAY - impression with id " + dVar.c + " has already been reported, ignoring.");
            return;
        }
        Activity foregroundActivity = com.safedk.android.internal.b.getInstance().getForegroundActivity();
        int iB = BrandSafetyUtils.b(this.c);
        synchronized (this.C) {
            Logger.d(J, "handle WILL_DISPLAY - image count for " + this.c.name() + " is " + iB + ", impressions to report(" + this.C.keySet().size() + ") = " + this.C.keySet());
        }
        if (f(str, str2)) {
            s sVar2 = this.M.get(dVar);
            if (sVar2 == null) {
                s sVarA = a(foregroundActivity, str2, dVar.c, bundle);
                synchronized (this.M) {
                    this.M.put(dVar, sVarA);
                }
                Logger.d(J, "New activity native created for " + str2 + ", native key is " + dVar + ", current activity native size is " + this.M.size());
                sVar = sVarA;
            } else {
                if (sVar2.A == null) {
                    sVar2.A = bundle;
                }
                if (sVar2.B == null || sVar2.C == null) {
                    sVar2.a(a(foregroundActivity));
                }
                sVar = sVar2;
            }
            sVar.K = TextUtils.isEmpty(str4) ? null : str4;
            sVar.V = true;
            sVar.ac = true;
            sVar.ad = j;
            a(sVar, false, "handleWillDisplay");
            a aVar = new a(sVar, dVar, this.e);
            sVar.Z = this.E.scheduleWithFixedDelay(aVar, 500L, SafeDK.getInstance().aa() * 1000, TimeUnit.MILLISECONDS);
            sVar.ab = aVar;
            a(sVar, dVar);
            a(sVar, dVar, (WeakReference<MaxNativeAdView>) a(dVar, str4, false).first);
            return;
        }
        this.d++;
    }

    private o a(s sVar, d dVar, WeakReference<MaxNativeAdView> weakReference) {
        o oVarRemove = null;
        if (weakReference != null && weakReference.get() != null) {
            sVar.ah = true;
            synchronized (this.N) {
                oVarRemove = this.N.remove(sVar.K);
                if (oVarRemove != null) {
                    Logger.d(J, "try setting pending info - found pending CI by view address: " + sVar.K + " matching info: " + oVarRemove);
                    a(dVar.f8095a, dVar.e, oVarRemove);
                }
            }
        }
        return oVarRemove;
    }

    private Pair<WeakReference<MaxNativeAdView>, String> a(d dVar, String str, boolean z) {
        WeakReference<MaxNativeAdView> weakReference;
        synchronized (NativeFinder.class) {
            weakReference = O.get(dVar.c);
            if (TextUtils.isEmpty(str) && weakReference != null && weakReference.get() != null) {
                str = BrandSafetyUtils.a(weakReference.get());
            }
            if (!TextUtils.isEmpty(str) && (weakReference == null || weakReference.get() == null)) {
                WeakReference<MaxNativeAdView> weakReferenceRemove = z ? P.remove(str) : P.get(str);
                if (weakReferenceRemove == null || weakReferenceRemove.get() == null) {
                    weakReference = weakReferenceRemove;
                } else {
                    Logger.d(J, "get ad view ref - native ad view found: " + weakReferenceRemove.get() + " for event ID: " + dVar.c);
                    a(dVar.c, dVar.d, weakReferenceRemove.get());
                    weakReference = weakReferenceRemove;
                }
            } else if (z) {
                P.remove(str);
            }
        }
        return new Pair<>(weakReference, str);
    }

    private void a(String str, String str2, String str3, d dVar, String str4, Bundle bundle) {
        AdNetworkDiscovery adNetworkDiscoveryI;
        CreativeInfo creativeInfoA;
        Activity foregroundActivity = com.safedk.android.internal.b.getInstance().getForegroundActivity();
        if (this.L.contains(dVar.c)) {
            Logger.d(J, "handle REVENUE_EVENT - impression with id " + dVar.c + " has already been reported, ignoring.");
            return;
        }
        Pair<WeakReference<MaxNativeAdView>, String> pairA = a(dVar, str4, true);
        WeakReference<MaxNativeAdView> weakReference = (WeakReference) pairA.first;
        String str5 = (String) pairA.second;
        a(str5, dVar);
        if (f(str, str2)) {
            s sVarA = this.M.get(dVar);
            if (sVarA == null) {
                sVarA = a(foregroundActivity, str2, dVar.c, bundle);
                synchronized (this.M) {
                    this.M.put(dVar, sVarA);
                }
                Logger.d(J, "New activity native created for " + str2 + ", native key is " + dVar + ", current activity natives size is " + this.M.size());
            } else {
                if (sVarA.A == null) {
                    sVarA.A = bundle;
                }
                if (sVarA.B == null || sVarA.C == null) {
                    sVarA.a(a(foregroundActivity));
                }
            }
            if (bundle.getString("revenue_event") != null) {
                sVarA.P = bundle.getString("revenue_event");
            } else {
                sVarA.P = "unknown";
            }
            if (sVarA.K == null) {
                sVarA.K = TextUtils.isEmpty(str5) ? null : str5;
                synchronized (NativeFinder.class) {
                    Q.put(str5, str2);
                }
            }
            sVarA.M = str3;
            o oVarA = a(sVarA, dVar, weakReference);
            if (oVarA == null && (adNetworkDiscoveryI = CreativeInfoManager.i(dVar.d)) != null && (creativeInfoA = adNetworkDiscoveryI.a((Object) dVar.c)) != null) {
                oVarA = new o(creativeInfoA, CreativeInfo.y);
                Logger.d(J, "set CI details - try to match by event ID: " + dVar.c + " matching info: " + oVarA);
                a(dVar.f8095a, dVar.e, oVarA);
            }
            if (oVarA == null) {
                a(sVarA, false, "handleRevenueEvent");
            }
            Logger.d(J, "Revenue event set to " + bundle.getString("revenue_event") + " for eventId " + dVar.c);
            sVarA.V = true;
            return;
        }
        this.d++;
    }

    private void a(String str, d dVar, String str2, Bundle bundle, long j) {
        if (this.L.contains(dVar.c)) {
            Logger.d(J, "handle DID_DISPLAY - impression with id " + dVar.c + " has already been reported, ignoring. ");
            return;
        }
        Logger.d(J, "handle DID_DISPLAY package=" + str + " key=" + dVar);
        Activity foregroundActivity = com.safedk.android.internal.b.getInstance().getForegroundActivity();
        s sVarA = this.M.get(dVar);
        if (sVarA != null) {
            Logger.d(J, "Native info already exists, package=" + str + " activity native=" + sVarA);
            sVarA.z = this.d;
            if (sVarA.B == null || sVarA.C == null) {
                sVarA.a(a(foregroundActivity));
            }
        } else {
            sVarA = a(foregroundActivity, str, dVar.c, bundle);
            synchronized (this.M) {
                this.M.put(dVar, sVarA);
            }
            Logger.d(J, "New activity native created for " + str + ", key=" + dVar + ", current activity ads size=" + this.M.size());
        }
        sVarA.M = str2;
        sVarA.ae = j;
        a(sVarA, false, "handleDidDisplay");
    }

    private void a(d dVar) {
        synchronized (this.M) {
            s sVarRemove = this.M.remove(dVar);
            if (sVarRemove != null) {
                Logger.d(J, "handle DID_HIDE, placementId=" + dVar.b);
                sVarRemove.X = true;
            }
        }
    }

    private void b(d dVar) {
        s sVar = this.M.get(dVar);
        if (sVar != null) {
            sVar.N = true;
        }
    }

    private void c(d dVar) {
        Logger.d(J, "handle DID_CLICKED started");
        s sVar = this.M.get(dVar);
        if (sVar != null) {
            sVar.a(true);
            a(sVar, false, "handleDidClicked");
        }
    }

    private s a(Activity activity, String str, String str2, Bundle bundle) {
        String lowerCase = BrandSafetyUtils.c().name().toLowerCase();
        this.d++;
        Logger.d(J, "slot number incremented to " + this.d + ", eventId is " + str2 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        s sVar = new s(a(activity), str, this.d, lowerCase, bundle, str2);
        sVar.aa = new WeakReference<>(activity);
        return sVar;
    }

    protected boolean f(String str, String str2) {
        boolean zA = CreativeInfoManager.a(str2, AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, false);
        String strA = CreativeInfoManager.a(str2, AdNetworkConfiguration.AD_NETWORK_TO_IGNORE, (String) null);
        Logger.d(J, "sdk " + str2 + ": config item SUPPORTS_NATIVE_IMPRESSION_TRACKING is " + zA + ", config item AD_NETWORK_TO_IGNORE is " + strA + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (zA && !str.equals(strA)) {
            return true;
        }
        Logger.d(J, "Native ads tracking is not supported for this ad network (" + str + ")");
        return false;
    }

    public void a(final String str, final String str2, final MaxNativeAdView maxNativeAdView) {
        if (com.safedk.android.utils.n.c()) {
            this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.NativeFinder.1
                @Override // java.lang.Runnable
                public void run() {
                    NativeFinder.this.b(str, str2, maxNativeAdView);
                }
            });
        } else {
            b(str, str2, maxNativeAdView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, MaxNativeAdView maxNativeAdView) {
        if (str != null && str2 != null && maxNativeAdView != null) {
            String strA = BrandSafetyUtils.a(maxNativeAdView);
            synchronized (NativeFinder.class) {
                if (!O.containsKey(str)) {
                    a(str, l.l, new l.a(l.L, strA));
                }
                O.put(str, new WeakReference<>(maxNativeAdView));
                Q.put(strA, str2);
            }
            Logger.d(J, "add native ad view: " + maxNativeAdView + ", eventId: " + str + ", adViewAddress: " + strA + ", sdk: " + str2 + ", list size: " + O.size() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        }
    }

    public void a(final MaxNativeAdView maxNativeAdView) {
        if (com.safedk.android.utils.n.c()) {
            this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.NativeFinder.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeFinder.this.c(maxNativeAdView);
                }
            });
        } else {
            c(maxNativeAdView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MaxNativeAdView maxNativeAdView) {
        String strA = BrandSafetyUtils.a(maxNativeAdView);
        synchronized (NativeFinder.class) {
            P.put(strA, new WeakReference<>(maxNativeAdView));
        }
        Logger.d(J, "add native ad view: " + maxNativeAdView + ", list size: " + P.size());
    }

    private void a(String str, d dVar) {
        ArrayList<d> arrayList;
        s sVar;
        boolean z;
        Logger.d(J, "report completed event started, view address: " + str + ", key: " + dVar);
        synchronized (this.M) {
            arrayList = new ArrayList(this.M.keySet());
        }
        for (d dVar2 : arrayList) {
            if (dVar2.f8095a.equals(dVar.f8095a) && !dVar2.c.equals(dVar.c) && (sVar = this.M.get(dVar2)) != null) {
                if (sVar.K != null && sVar.K.equals(str)) {
                    Logger.d(J, "report completed event, same view address: " + sVar.K + ", event id: " + dVar2.c);
                    z = true;
                } else {
                    synchronized (NativeFinder.class) {
                        WeakReference<MaxNativeAdView> weakReference = O.get(dVar2.c);
                        if (weakReference == null || weakReference.get() == null || weakReference.get().getParent() == null) {
                            Logger.d(J, "report completed event, closed view address: " + sVar.K + ", event id: " + dVar2.c);
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                }
                if (z) {
                    sVar.a(l.C, new l.a[0]);
                    a(sVar, true, "reportCompletedEvents");
                    sVar.U = true;
                    a(sVar);
                    synchronized (this.M) {
                        this.M.remove(dVar2);
                    }
                } else {
                    Logger.d(J, "report completed event skipped, view address: " + sVar.K + ", event id: " + dVar2.c);
                }
            }
        }
    }

    private void a(final s sVar, final d dVar) {
        sVar.Y = this.E.schedule(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.NativeFinder.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (NativeFinder.this.M) {
                    NativeFinder.this.a(sVar, true, "handleWillDisplay:reportTimeout");
                    NativeFinder.this.M.remove(dVar);
                    NativeFinder.this.a(sVar);
                }
            }
        }, 5L, TimeUnit.MINUTES);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar) {
        try {
            Logger.d(J, "clean started, currentActivityAds size is " + this.M.size() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            if (sVar != null) {
                Logger.d(J, "clean, adding to reported impressions map. id =  " + sVar.L);
                this.L.add(sVar.L);
                sVar.X = true;
                if (sVar.Y != null) {
                    sVar.Y.cancel(false);
                }
                if (sVar.Z != null) {
                    sVar.Z.cancel(false);
                }
                for (k kVar : sVar.g()) {
                    if (kVar.c != null && kVar.c.b != null) {
                        kVar.d = kVar.c.b;
                        Logger.d(J, "clean, set last impression screenshot filename to " + kVar.c.b);
                    }
                }
                synchronized (NativeFinder.class) {
                    O.remove(sVar.L);
                }
                b(sVar);
            }
        } catch (Throwable th) {
            Logger.e(J, "Error in clean " + th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, boolean z, String str) {
        boolean z2 = !sVar.E;
        boolean z3 = !sVar.F && sVar.d();
        long j = 0;
        if (sVar.ad > 0 && sVar.ae > 0) {
            j = sVar.ad - sVar.ae;
        }
        ArrayList arrayList = new ArrayList();
        if (sVar.k().isEmpty()) {
            Logger.d(J, "reporting event started, root=" + str + ", isMature=" + z + ", adInfo=" + sVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            arrayList.add(a(sVar, sVar.i(), z, z3, j, (String) null));
        } else {
            for (k kVar : sVar.g()) {
                if (kVar.i() != null && kVar.i().Y() == null) {
                    Logger.d(J, "reporting event - don't report CI as it was matched only by eventId and not by webview resources");
                    kVar.a((CreativeInfo) null);
                }
                String str2 = null;
                if (z && kVar.c != null && kVar.c.f8109a != null) {
                    str2 = kVar.c.f8109a + "_" + kVar.f8110a;
                    Logger.d(J, "reporting event - imageFileIsValid filename = " + BrandSafetyUtils.a(sVar.p, kVar.c.f8109a, sVar.c(), kVar.f8110a, kVar.c.f));
                }
                Logger.d(J, "reporting event started, root=" + str + ", isMature=" + z + ", info=" + sVar + ", uniformity=" + (kVar.c != null ? kVar.c.a(500) : 0.0f));
                arrayList.add(a(sVar, kVar, z, z3, j, str2));
                if (z && kVar.i() != null && kVar.c != null) {
                    if (this.C.size() <= SafeDK.getInstance().J()) {
                        Logger.d(J, "reporting event waiting to report file " + kVar.c.b);
                        a(sVar, kVar);
                    } else {
                        Logger.d(J, "reporting event no open slot for " + this.c + ", " + kVar.c.f8109a);
                        BrandSafetyUtils.d(kVar.c.b);
                    }
                }
            }
        }
        if (!z && sVar.U) {
            Logger.w(J, "reporting event - ad finished, should discard brand safety event: " + arrayList);
        } else if (StatsCollector.c() != null) {
            StatsCollector.c().a(arrayList);
        } else {
            Logger.w(J, "reporting event - stats collector instance is null, cannot report brand safety event");
        }
        if (z2) {
            sVar.c(true);
        }
        if (z3) {
            sVar.d(true);
        }
    }

    private static BrandSafetyEvent a(s sVar, k kVar, boolean z, boolean z2, long j, String str) {
        return new BrandSafetyEvent(sVar.c(), sVar.q(), str, z2, sVar.d() ? sVar.e() : null, kVar.i(), sVar.a(), sVar.p(), kVar.f8110a != null ? kVar.f8110a : "", sVar.D, z, sVar.r(), kVar.c != null ? kVar.c.f : null, kVar.c != null ? kVar.c.c : 0L, kVar.c != null ? kVar.c.a(500) : 0.0f, kVar.c != null ? kVar.c.e : 0, sVar.ac, sVar.ah, j, sVar.af, sVar.ag, SafeDK.getInstance().e(), sVar.w(), sVar.M, sVar.N, sVar.P, sVar.Q, b(sVar, kVar).toString());
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void a(String str) {
        Iterator<s> it = this.M.values().iterator();
        while (it.hasNext()) {
            it.next().X = true;
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public List<CreativeInfo> a(String str, String str2) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public List<CreativeInfo> b(String str, String str2) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public c b(String str) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(o oVar) {
        try {
            com.safedk.android.utils.n.b(J, "set CI details started. matchingInfo = " + oVar.toString());
            CreativeInfo creativeInfo = oVar.f8114a;
            if (creativeInfo != null) {
                Logger.d(J, "set CI details - CI exists in matchingInfo, sdk = " + creativeInfo.S());
                creativeInfo.i(BrandSafetyUtils.ScreenShotOrientation.PORTRAIT.equals(BrandSafetyUtils.c()));
                Logger.d(J, "set CI details - starting to iterate over current activity ads");
                ArrayList<d> arrayList = new ArrayList();
                synchronized (this.M) {
                    arrayList.addAll(this.M.keySet());
                }
                for (d dVar : arrayList) {
                    if (a(creativeInfo, this.M.get(dVar))) {
                        Logger.d(J, "set CI details - matched by webView/eventID, CI: " + creativeInfo);
                        if (a(dVar.f8095a, dVar.e, oVar)) {
                            return true;
                        }
                    }
                }
                Logger.d(J, "set CI details - adding as pending, view address: " + creativeInfo.ai() + " matching info: " + oVar);
                synchronized (this.N) {
                    this.N.put(creativeInfo.ai(), oVar);
                }
                return true;
            }
        } catch (Throwable th) {
            Logger.e(J, "set CI details exception: " + th.getMessage(), th);
        }
        return false;
    }

    private boolean a(CreativeInfo creativeInfo, s sVar) {
        if (sVar == null || creativeInfo == null) {
            Logger.d(J, "verify matching - object is null, nativeInfo: " + sVar + ", creativeInfo: " + creativeInfo);
            return false;
        }
        String strS = creativeInfo.S();
        if (sVar.v == null || !sVar.v.equals(strS)) {
            Logger.d(J, "verify matching - sdks does not match, ci sdk is: " + strS + " and native sdk is: " + sVar.v);
            return false;
        }
        Logger.d(J, "verify matching - ci sdk is: " + strS + ", native info: " + sVar);
        if (sVar.L != null && creativeInfo.n() != null && !sVar.L.equals(creativeInfo.n())) {
            Logger.d(J, "verify matching - incompatible event ID, ci: " + creativeInfo.n() + ", info: " + sVar.L);
            return false;
        }
        String strAi = creativeInfo.ai();
        if (sVar.K != null && sVar.K.equals(strAi)) {
            Logger.d(J, "verify matching object done, event ID: " + sVar.L + ", object address: " + strAi + ", view address: " + sVar.K);
            return true;
        }
        Logger.d(J, "verify matching object failed, event ID: " + sVar.L + ", object address: " + strAi + ", view address: " + sVar.K);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, o oVar) {
        com.safedk.android.utils.n.b(J, "set CI started, adUnitId=" + str + " matchingInfo=" + (oVar == null ? "null" : oVar.toString()));
        if (oVar == null) {
            Logger.d(J, "set CI - no matching info");
            return false;
        }
        CreativeInfo creativeInfo = oVar.f8114a;
        if (creativeInfo != null) {
            d dVar = new d(str, creativeInfo.H(), creativeInfo.n(), creativeInfo.S(), str2, BrandSafetyUtils.AdType.NATIVE);
            Logger.d(J, "set CI - activity key: " + dVar);
            s sVar = this.M.get(dVar);
            com.safedk.android.utils.n.b(J, "set CI - current activity ad: " + (sVar == null ? "null" : sVar) + ", current activity ad keys: " + this.M.keySet());
            if (sVar != null) {
                if (!sVar.W && StatsReporter.b().a(creativeInfo, sVar)) {
                    sVar.W = true;
                }
                CreativeInfo creativeInfoJ = sVar.j();
                if (creativeInfoJ != null) {
                    Logger.d(J, "set CI - previous CI id: " + creativeInfoJ.N());
                    if (creativeInfoJ.N().equals(creativeInfo.N())) {
                        AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(creativeInfo.S());
                        if (adNetworkDiscoveryI != null) {
                            adNetworkDiscoveryI.d(creativeInfoJ);
                        }
                        com.safedk.android.utils.n.b(J, "set CI - already matched, same ad ID. current match: " + creativeInfo.aa() + ", previous match: " + creativeInfoJ.aa());
                    }
                }
                creativeInfo.b(oVar.b, oVar.c);
                sVar.a(creativeInfo);
                Logger.d(J, "set CI - CI is set for activity native " + dVar + ". CI : " + creativeInfo);
                b(sVar, creativeInfo);
                a(sVar, false, "setCreativeInfo");
                return true;
            }
            com.safedk.android.utils.n.b(J, "set CI - no activity ad, cannot set CI. current activity ads: " + this.M);
        } else {
            Logger.d(J, "set CI - no CI");
        }
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, String str2, String str3, boolean z) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void a(String str, String str2, String str3) {
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void d(String str) {
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public c a(String str, RedirectDetails redirectDetails, m mVar, boolean z, boolean z2) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, x xVar) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean b(String str, String str2, String str3) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, String str2, boolean z, String str3) {
        return false;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.f
    public void b(k kVar) {
    }

    private boolean a(int i) {
        boolean zC = BrandSafetyUtils.c(i);
        Logger.d(J, "should stop sampling, max uniformed pixels count=" + i + ", return value=" + zC);
        return zC;
    }

    @Override // com.safedk.android.internal.a
    public void g() {
        if (this.M != null) {
            for (s sVar : this.M.values()) {
                if (sVar.V) {
                    sVar.a(l.z, new l.a[0]);
                    a(sVar, false, "onBackground");
                }
            }
        }
    }

    @Override // com.safedk.android.internal.a
    public void h() {
        if (this.M != null) {
            for (s sVar : this.M.values()) {
                if (sVar.V) {
                    sVar.a(l.A, new l.a[0]);
                    a(sVar, false, "onForeground");
                }
            }
        }
    }

    protected class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        s f8020a;
        d b;
        int d;
        int c = 0;
        boolean e = false;

        public a(s sVar, d dVar, int i) {
            this.b = dVar;
            this.f8020a = sVar;
            this.d = i;
        }

        private void a(View view) {
            if (view != null) {
                Logger.d(NativeFinder.J, "handle native ad reflection - root= " + view + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(this.b.d);
                if (adNetworkDiscoveryI != null) {
                    View viewG = adNetworkDiscoveryI.g(view);
                    Logger.d(NativeFinder.J, "handle native ad reflection - native view= " + viewG);
                    if (viewG != null) {
                        List<CreativeInfo> listA = adNetworkDiscoveryI.a(new WeakReference<>(viewG), this.f8020a.M, BrandSafetyUtils.AdType.NATIVE);
                        Logger.d(NativeFinder.J, "handle native ad reflection - CIs generated: " + listA);
                        if (listA != null) {
                            for (CreativeInfo creativeInfo : listA) {
                                creativeInfo.a((Object) view);
                                creativeInfo.a(NativeFinder.this.c);
                                creativeInfo.h(this.b.c);
                                creativeInfo.j(this.b.b);
                                Logger.d(NativeFinder.J, "handle native ad reflection - setting ci: " + creativeInfo.aa());
                                NativeFinder.this.a(this.b.f8095a, this.b.e, new o(creativeInfo, CreativeInfo.y));
                            }
                        }
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference weakReference;
            try {
                this.c++;
                if (this.f8020a != null) {
                    synchronized (NativeFinder.class) {
                        weakReference = (WeakReference) NativeFinder.O.get(this.b.c);
                    }
                    if (weakReference != null && weakReference.get() != null) {
                        MaxNativeAdView maxNativeAdView = (MaxNativeAdView) weakReference.get();
                        if (CreativeInfoManager.a(this.b.d, AdNetworkConfiguration.SHOULD_SCAN_OBJECT_USING_REFLECTION, false) && !this.e) {
                            a(maxNativeAdView);
                            this.e = true;
                        }
                        if (maxNativeAdView.getWidth() > 0 && maxNativeAdView.getHeight() > 0) {
                            this.f8020a.af = maxNativeAdView.getWidth() / maxNativeAdView.getHeight();
                            Logger.d(NativeFinder.J, "native impression task - view size: " + maxNativeAdView.getWidth() + VastAttributes.HORIZONTAL_POSITION + maxNativeAdView.getHeight() + ", proportion: " + this.f8020a.af);
                        }
                        if (this.c >= this.d || this.f8020a.X) {
                            Logger.d(NativeFinder.J, "Going to report native ad, eventId=" + this.f8020a.L + ", stop timer? " + this.f8020a.X + ", image counter=" + this.c + ", max attempts=" + this.d + ", isImpressionReported=" + this.f8020a.E + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                            if (!this.f8020a.E) {
                                NativeFinder.this.a(this.f8020a, false, "NativeImpressionTask");
                            }
                            this.f8020a.Z.cancel(false);
                            return;
                        }
                        if (this.f8020a.aa != null && this.f8020a.aa.get() != null) {
                            a(this.f8020a, (View) weakReference.get());
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.e(NativeFinder.J, "Error in NativeImpressionTask: ", th);
            }
        }

        /* JADX WARN: Code duplicated, block: B:6:0x000a A[Catch: Throwable -> 0x0060, TryCatch #0 {Throwable -> 0x0060, blocks: (B:4:0x0004, B:8:0x0029, B:6:0x000a), top: B:13:0x0004 }] */
        private void a(final s sVar, final View view) {
            if (sVar == null || view == null) {
                Logger.d(NativeFinder.J, "_MEMORY_LOAD_ don't take screenshot, ad info: " + sVar + ", low memory");
            } else {
                try {
                    if (com.safedk.android.utils.e.a((c) sVar)) {
                        Logger.d(NativeFinder.J, "_MEMORY_LOAD_ don't take screenshot, ad info: " + sVar + ", low memory");
                    } else {
                        Logger.d(NativeFinder.J, "Taking screenshot, view=" + view + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                        sVar.aa.get().runOnUiThread(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.NativeFinder.a.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Logger.d(NativeFinder.J, "Taking screenshot - using old method");
                                final Bitmap bitmapA = ScreenshotHelper.a(view, SafeDK.getInstance().ab(), sVar);
                                NativeFinder.this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.NativeFinder.a.1.1
                                    @Override // java.lang.Runnable
                                    public void run() throws Throwable {
                                        NativeFinder.this.a(sVar, bitmapA, a.this.c);
                                    }
                                });
                            }
                        });
                    }
                } catch (Throwable th) {
                    Logger.e(NativeFinder.J, "Error while taking screenshot", th);
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public void a(final Bitmap bitmap, final c cVar) {
        this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.NativeFinder.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    s sVar = (s) cVar;
                    NativeFinder.this.a(sVar, bitmap, sVar.ab.c);
                } catch (Throwable th) {
                    Logger.d(NativeFinder.J, "handleScreenshotCompleted exception : " + th.getMessage(), th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(s sVar, Bitmap bitmap, int i) throws Throwable {
        if (bitmap != null) {
            Logger.d(J, "process screenshot - currentActivityAd  = " + sVar);
            String strC = sVar.c();
            BrandSafetyUtils.a aVarB = BrandSafetyUtils.b(strC, bitmap);
            int iA = aVarB.a();
            BrandSafetyUtils.ScreenshotValidity screenshotValidityC = BrandSafetyUtils.c(strC, aVarB);
            if (screenshotValidityC == BrandSafetyUtils.ScreenshotValidity.VALID) {
                Logger.d(J, "process screenshot - VALID ");
                String strA = BrandSafetyUtils.a(bitmap);
                BrandSafetyUtils.ScreenShotOrientation screenShotOrientationB = BrandSafetyUtils.b(bitmap);
                k kVarI = sVar.i();
                String strA2 = BrandSafetyUtils.a(bitmap, this.c, strA, strC, kVarI.f8110a, screenShotOrientationB);
                Logger.d(J, "process screenshot - screenshot file created, filename = " + strA2 + ", hash = " + strA);
                long jC = BrandSafetyUtils.c(strA2);
                Logger.d(J, "process screenshot - hash " + strA + ", stored file size is " + jC + " bytes, counter is " + i + ", uniform pixel count is " + iA + " (" + ((iA / 500.0f) * 100.0f) + "%)");
                int size = this.C.size();
                if (!d(strA, kVarI.f8110a)) {
                    if (size <= SafeDK.getInstance().J()) {
                        if (kVarI.c != null && kVarI.c.f8109a != null && !kVarI.c.f8109a.equals(strA)) {
                            Logger.d(J, "process screenshot - removing ad file " + kVarI.c.b);
                            BrandSafetyUtils.d(kVarI.c.b);
                        }
                        kVarI.b("img", new l.a("typ", l.X));
                        Logger.d(J, "process screenshot - setting data hash = " + strA + ", file name = " + strA2 + ", file size = " + jC);
                        kVarI.c = new j(strA, strA2, jC, iA, i, screenShotOrientationB, false);
                        a(sVar, false, "processScreenshot");
                    } else if (!c(strA, kVarI.f8110a)) {
                        Logger.d(J, "process screenshot - No open slot for " + strA + "_" + kVarI.f8110a + ", # : " + this.C.size());
                        BrandSafetyUtils.d(strA2);
                    } else {
                        Logger.d(J, "process screenshot - Image " + strA + "_" + kVarI.f8110a + " is already scheduled for upload");
                    }
                } else {
                    Logger.d(J, "process screenshot - not saving file for " + strA + "_" + kVarI.f8110a);
                    BrandSafetyUtils.d(strA2);
                }
                if (a(iA)) {
                    if (!TextUtils.isEmpty(strA)) {
                        sVar.e(true);
                        sVar.X = true;
                    }
                    kVarI.a("img", new l.a("typ", l.Y));
                    a(sVar, false, "processScreenshot");
                    return;
                }
                return;
            }
            Logger.d(J, "process screenshot - screenshot is not valid: " + screenshotValidityC.name() + ", pixel count: " + iA + ", counter = " + i + ", try again...");
        }
    }

    public static String b(MaxNativeAdView maxNativeAdView) {
        String str;
        String strA = BrandSafetyUtils.a(maxNativeAdView);
        synchronized (NativeFinder.class) {
            str = Q.get(strA);
        }
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public void b() {
        for (s sVar : this.M.values()) {
            if (sVar.V) {
                sVar.a(l.D, new l.a[0]);
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.b, com.safedk.android.analytics.brandsafety.a
    public void c() {
        for (s sVar : this.M.values()) {
            if (sVar.V) {
                sVar.a(l.E, new l.a[0]);
            }
        }
    }

    public int f() {
        int i = 0;
        Iterator<s> it = this.M.values().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = it.next().V ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public boolean e(String str) {
        synchronized (this.M) {
            for (s sVar : this.M.values()) {
                if (sVar != null && sVar.V && sVar.c() != null && sVar.c().equals(str)) {
                    return true;
                }
            }
            return false;
        }
    }
}
