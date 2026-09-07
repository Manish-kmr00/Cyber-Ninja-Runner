package com.safedk.android.analytics.brandsafety;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.applovin.mediation.ads.MaxAdView;
import com.json.b9;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.AppLovinBridge;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.LimitedConcurrentHashMap;
import com.safedk.android.utils.Logger;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b implements a {
    protected static final float A = 80.0f;
    protected static final List<String> B = Arrays.asList("com.unity3d.ads");
    protected static final Map<String, l> F = new LimitedConcurrentHashMap(90);
    public static final String f = "ad_format";
    protected static final String g = "type";
    protected static final String h = "WILL_DISPLAY";
    protected static final String i = "WILL_LOAD";
    protected static final String j = "DID_HIDE";
    protected static final String k = "DID_CLICKED";
    protected static final String l = "DID_LOAD";
    protected static final String m = "DID_DISPLAY";
    protected static final String n = "DID_FAIL_DISPLAY";
    protected static final String o = "id";
    protected static final String p = "network_name";
    protected static final String q = "third_party_ad_placement_id";
    protected static final String r = "creative_id";
    protected static final String s = "max_ad_unit_id";
    protected static final String t = "ad_view";
    protected static final String u = "dsp_name";
    public static final int v = 120;
    public static final String w = "revenue_event";
    public static final String x = "unknown";
    public static final String y = "no_CI_report";
    protected static final String z = "_BIDDING";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f8026a;
    protected List<String> b;
    protected BrandSafetyUtils.AdType c;
    int e;
    protected int d = 0;
    protected final Map<String, c> C = new ConcurrentHashMap();
    protected final Set<String> D = new HashSet();
    protected final ScheduledExecutorService E = Executors.newScheduledThreadPool(1);

    protected abstract c a(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5);

    protected b(BrandSafetyUtils.AdType adType, List<String> list, String str, int i2) {
        this.e = 0;
        this.f8026a = str;
        this.c = adType;
        this.b = list;
        this.e = i2;
        Logger.d(this.f8026a, "ctor started, type: " + this.c + ", supported formats: " + this.b + ", maxAttemptsToCaptureImage = " + i2 + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        f();
        com.safedk.android.internal.b.getInstance().registerBackgroundForegroundListener(this);
        AppLovinBridge.registerToReceiveMaxEvents(this);
        AppLovinBridge.registerToReceiveMaxRevenueEvents(this);
        if (Build.VERSION.SDK_INT >= 21) {
            ((ScheduledThreadPoolExecutor) this.E).setRemoveOnCancelPolicy(true);
            Logger.d(this.f8026a, "ctor thread pool removal policy set");
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public c c(String str) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public BrandSafetyUtils.AdType a() {
        return this.c;
    }

    public int d() {
        return this.C.size();
    }

    private void f() {
        List<BrandSafetyUtils.d> listC = BrandSafetyUtils.c(this.c);
        for (int i2 = 0; i2 < listC.size(); i2++) {
            BrandSafetyUtils.d dVar = listC.get(i2);
            String str = dVar.a() + "_" + dVar.c();
            synchronized (this.C) {
                this.C.put(str, a(dVar.a(), dVar.b(), dVar.c(), dVar.d(), dVar.e(), dVar.f()));
            }
        }
        Logger.d(this.f8026a, "restore impressions for upload - number of loaded impressions to report " + this.C.size() + " " + this.C.keySet());
        if (this.C.size() > 0 && StatsCollector.b()) {
            e();
        }
    }

    protected boolean a(String str, View view) {
        AdNetworkDiscovery adNetworkDiscoveryI;
        if (str == null || (adNetworkDiscoveryI = CreativeInfoManager.i(str)) == null) {
            return false;
        }
        return adNetworkDiscoveryI.e(view);
    }

    @Override // com.safedk.android.analytics.brandsafety.f
    public void a(FileUploadManager.b bVar, FileUploadManager.a aVar, String str, String str2) {
        Logger.d(this.f8026a, "handle upload request started, imageToUpload=" + str + ", adInfoCollectionForUpload=" + this.C);
        if (this.C.get(str) != null) {
            a(str, bVar, aVar, str2);
        } else {
            Logger.d(this.f8026a, "handle upload request - adInfoCollectionForUpload doesn't contain imageToUpload " + str);
        }
        Logger.d(this.f8026a, "handle upload request - adInfoCollectionForUpload remove key " + str);
    }

    @Override // com.safedk.android.analytics.brandsafety.f
    public void f(String str) {
        Logger.d(this.f8026a, "handle discard request started, imageToDiscard=" + str + ", adInfoCollectionForUpload=" + this.C + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        g(str);
        c cVar = this.C.get(str);
        if (cVar != null) {
            for (k kVar : cVar.g()) {
                if (str.contains(kVar.f8110a)) {
                    b(kVar);
                }
            }
        }
        Logger.d(this.f8026a, "handle discard request - adInfoCollectionForUpload remove key " + str);
        synchronized (this.C) {
            this.C.remove(str);
            Logger.d(this.f8026a, "handle discard request - number of loaded impressions to report " + this.C.size() + " " + this.C.keySet());
        }
    }

    public void g(String str) {
        Logger.d(this.f8026a, "Cleaning stored impressions: " + str);
        BrandSafetyUtils.a(this.c, str);
        h(str);
    }

    protected void h(String str) {
        Logger.d(this.f8026a, "removal all impression images started, reportedImage = " + str + ", adInfoCollectionForUpload keys = " + this.C.keySet() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (str.contains("_")) {
            String str2 = str.split("_")[1];
            Logger.d(this.f8026a, "removal all impression images impressionId = " + str2);
            synchronized (this.C) {
                Iterator<Map.Entry<String, c>> it = this.C.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, c> next = it.next();
                    if (next.getKey().endsWith(str2)) {
                        Logger.d(this.f8026a, "removal all impression images removing " + next.getKey() + " ");
                        it.remove();
                    }
                }
                Logger.d(this.f8026a, "removal all impression images - number of loaded impressions to report " + this.C.size() + " " + this.C.keySet());
            }
        }
        File file = new File(SafeDK.getInstance().af() + this.c);
        Logger.d(this.f8026a, "removal all impression images getting files for dir" + file.getPath());
        Logger.d(this.f8026a, "removal all impression images files for dir" + file.getPath() + " : " + com.safedk.android.utils.b.a(file.getPath()));
    }

    protected String i(String str) {
        String[] strArrSplit;
        if (str == null || (strArrSplit = new File(str).getName().replace(".jpg", "").split("_")) == null || strArrSplit.length < 4) {
            return null;
        }
        return strArrSplit[0] + "_" + strArrSplit[2];
    }

    private void a(final String str, final FileUploadManager.b bVar, final FileUploadManager.a aVar, final String str2) {
        synchronized (this.C) {
            Logger.d(this.f8026a, "Uploading impression " + str + " to server, timeout=" + SafeDK.getInstance().L() + "ms, adInfoCollectionForUpload = " + this.C + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        }
        this.E.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.a(str, bVar, aVar, str2, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x0110  */
    /* JADX WARN: Code duplicated, block: B:27:0x011a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0124  */
    /* JADX WARN: Code duplicated, block: B:32:0x012b  */
    /* JADX WARN: Code duplicated, block: B:58:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:63:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void a(final String str, final FileUploadManager.b bVar, final FileUploadManager.a aVar, final String str2, final int i2) {
        String strK;
        BrandSafetyUtils.ScreenShotOrientation screenShotOrientation;
        String str3;
        com.safedk.android.a.g.a aVarA;
        String strA;
        String strC;
        String strName;
        c cVar = this.C.get(str);
        if (cVar != null) {
            Iterator<k> it = cVar.g().iterator();
            while (true) {
                if (!it.hasNext()) {
                    strK = null;
                    screenShotOrientation = null;
                    str3 = null;
                    break;
                }
                k next = it.next();
                if (next.c != null && str.equals(next.c.f8109a + "_" + next.f8110a)) {
                    str3 = next.c.b;
                    screenShotOrientation = next.c.f;
                    if (next.i() == null) {
                        strK = null;
                        break;
                    } else {
                        strK = next.i().K();
                        break;
                    }
                }
            }
            if (str3 != null && new File(str3).exists()) {
                String strR = BrandSafetyUtils.r(str3);
                Logger.d(this.f8026a, "Uploading impression - ad type " + cVar.p + ", file hash is " + strR + ", imageToUpload = " + str + ", match ? " + str.startsWith(strR) + ", fingerprint = " + str2);
                if (!str.startsWith(strR)) {
                    Logger.d(this.f8026a, "Uploading impression - fileHash " + strR + ", imageToUpload = " + str + " does not match, not uploading");
                    return;
                }
                try {
                    if (bVar != null) {
                        aVarA = new com.safedk.android.a.c(str3, str, SafeDK.getInstance().L(), bVar).a();
                    } else {
                        if (aVar != null) {
                            aVarA = new com.safedk.android.a.a(str3, str, SafeDK.getInstance().L(), aVar).a();
                        } else {
                            aVarA = null;
                        }
                        if (aVarA != null) {
                            strA = aVarA.a();
                            strC = aVarA.c();
                            if (strK == null) {
                                BrandSafetyEvent.AdFormatType adFormatTypeA = BrandSafetyUtils.a(cVar.r());
                                strName = adFormatTypeA != null ? adFormatTypeA.name() : null;
                            } else {
                                strName = strK;
                            }
                            if (strName == null) {
                                strName = BrandSafetyUtils.a(this.c).name();
                                Logger.d(this.f8026a, "adFormat set to " + strName);
                            }
                            Logger.d(this.f8026a, "Upload impression image succeeded: " + strA + ", return code =" + aVarA.b());
                            if (strA != null && !strA.isEmpty()) {
                                Bundle bundle = new Bundle();
                                try {
                                    bundle.putString(FileUploadManager.c, str2);
                                    bundle.putString("ad_format_type", strName);
                                    bundle.putString("image_url", strA);
                                    bundle.putString("image_orientation", screenShotOrientation.name().toLowerCase());
                                    bundle.putString("platform", "android");
                                    bundle.putString("image_id", strC);
                                    bundle.putString("package", SafeDK.getInstance().m().getPackageName());
                                } catch (Throwable th) {
                                    Logger.e(this.f8026a, th.getMessage(), th);
                                    new CrashReporter().caughtException(th);
                                }
                                g.a(bundle);
                                Logger.d(this.f8026a, "Upload impression image - attempting to remove the file " + bundle.getString("image_url"));
                                g(str);
                            }
                        } else {
                            Logger.d(this.f8026a, "upload response is null, imageToUpload = " + str);
                            h(str);
                        }
                        synchronized (this.C) {
                            this.C.remove(str);
                        }
                        Logger.d(this.f8026a, "Upload impression image - number of loaded impressions to report " + this.C.size() + " " + this.C.keySet());
                        return;
                    }
                } catch (IOException e) {
                    if (i2 < 2) {
                        int i3 = com.safedk.android.a.g.h[i2];
                        Logger.d(this.f8026a, "IOException when uploading file, next retry in " + i3 + " ms, file: " + str3);
                        this.E.schedule(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                b.this.a(str, bVar, aVar, str2, i2 + 1);
                            }
                        }, i3, TimeUnit.MILLISECONDS);
                        return;
                    }
                    Logger.d(this.f8026a, "IOException when uploading file " + str3 + " : " + e.getMessage(), e);
                    return;
                } catch (Throwable th2) {
                    Logger.e(this.f8026a, "Failed to upload file " + str3 + " : " + th2.getMessage(), th2);
                }
                if (aVarA != null) {
                    strA = aVarA.a();
                    strC = aVarA.c();
                    if (strK == null) {
                        BrandSafetyEvent.AdFormatType adFormatTypeA2 = BrandSafetyUtils.a(cVar.r());
                        strName = adFormatTypeA2 != null ? adFormatTypeA2.name() : null;
                    } else {
                        strName = strK;
                    }
                    if (strName == null) {
                        strName = BrandSafetyUtils.a(this.c).name();
                        Logger.d(this.f8026a, "adFormat set to " + strName);
                    }
                    Logger.d(this.f8026a, "Upload impression image succeeded: " + strA + ", return code =" + aVarA.b());
                    if (strA != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString(FileUploadManager.c, str2);
                        bundle2.putString("ad_format_type", strName);
                        bundle2.putString("image_url", strA);
                        bundle2.putString("image_orientation", screenShotOrientation.name().toLowerCase());
                        bundle2.putString("platform", "android");
                        bundle2.putString("image_id", strC);
                        bundle2.putString("package", SafeDK.getInstance().m().getPackageName());
                        g.a(bundle2);
                        Logger.d(this.f8026a, "Upload impression image - attempting to remove the file " + bundle2.getString("image_url"));
                        g(str);
                    }
                } else {
                    Logger.d(this.f8026a, "upload response is null, imageToUpload = " + str);
                    h(str);
                }
                synchronized (this.C) {
                    this.C.remove(str);
                    Logger.d(this.f8026a, "Upload impression image - number of loaded impressions to report " + this.C.size() + " " + this.C.keySet());
                    return;
                }
            }
            Logger.d(this.f8026a, "Uploading impression - not found, not uploading, filename " + str3);
            return;
        }
        Logger.d(this.f8026a, "impressionInfoToUpload is null");
    }

    public synchronized void e() {
        Logger.d(this.f8026a, "synchronize impressions and events - impression size is: " + this.C.size() + " and keys: " + this.C.keySet() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        Logger.d(this.f8026a, "synchronize impressions and events - BrandSafetyEvents keys " + StatsCollector.c().a(StatsCollector.EventType.BrandSafety).keySet());
        ConcurrentHashMap<String, StatsEvent> concurrentHashMapA = StatsCollector.c().a(StatsCollector.EventType.BrandSafety);
        Iterator<Map.Entry<String, c>> it = this.C.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            c value = next.getValue();
            String key = next.getKey();
            k kVarI = value.i();
            if (kVarI != null) {
                if (kVarI.c != null && kVarI.c.b != null) {
                    Logger.d(this.f8026a, "synchronize impressions and events - deleting file: " + kVarI.c.b);
                    BrandSafetyUtils.d(kVarI.c.b);
                }
                BrandSafetyEvent brandSafetyEvent = (BrandSafetyEvent) concurrentHashMapA.get(kVarI.f8110a);
                if (brandSafetyEvent == null || key == null || !key.equals(brandSafetyEvent.h())) {
                    Logger.d(this.f8026a, "synchronize impressions and events - remove impressionId: " + kVarI.f8110a + ", impression hash: " + key + ", event hash: " + (brandSafetyEvent != null ? brandSafetyEvent.h() : "null"));
                    it.remove();
                } else if (brandSafetyEvent.h() != null) {
                    Logger.d(this.f8026a, "synchronize impressions and events - clearing image hash value: " + brandSafetyEvent.h());
                    brandSafetyEvent.c();
                }
            }
        }
        Logger.d(this.f8026a, "synchronize impressions and events - number of loaded impressions to report " + this.C.size() + " " + this.C.keySet());
    }

    public static c j(String str) {
        if (str != null) {
            for (b bVar : SafeDK.getInstance().y().values()) {
                synchronized (bVar.C) {
                    Logger.d("AdFinderBase", "get impression ad info by image ID: " + str + ", type: " + bVar.a() + ", keys: " + bVar.C.keySet() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                }
                c cVar = bVar.C.get(str);
                if (cVar != null) {
                    return cVar;
                }
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public c b(String str) {
        return null;
    }

    public c k(String str) {
        return null;
    }

    public void a(c cVar, k kVar) {
        if (cVar != null && kVar.c != null && kVar.c.f8109a != null && kVar.f8110a != null) {
            Logger.d(this.f8026a, "add info collection for upload " + kVar.c.f8109a + "_" + kVar.f8110a + ", file = " + kVar.c.b);
            synchronized (this.C) {
                this.C.put(kVar.c.f8109a + "_" + kVar.f8110a, cVar);
                Logger.d(this.f8026a, "add info collection for upload - number of loaded impressions to report " + this.C.size() + " " + this.C.keySet());
            }
        }
    }

    public boolean c(String str, String str2) {
        return this.C.containsKey(str + "_" + str2);
    }

    public boolean d(String str, String str2) {
        return this.D.contains(str + "_" + str2);
    }

    protected boolean d(String str, String str2, String str3) {
        BrandSafetyUtils.a aVar;
        boolean z2 = true;
        try {
            if (new File(str).exists()) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
                if (com.safedk.android.utils.n.a(bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight()) || com.safedk.android.utils.n.b(bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight())) {
                    BrandSafetyUtils.a aVarB = BrandSafetyUtils.b(str2, bitmapDecodeFile);
                    z2 = BrandSafetyUtils.b(str2, aVarB) == BrandSafetyUtils.ScreenshotValidity.VALID;
                    aVar = aVarB;
                } else {
                    BrandSafetyUtils.a aVarA = BrandSafetyUtils.a(str2, bitmapDecodeFile);
                    z2 = BrandSafetyUtils.a(str2, aVarA) == BrandSafetyUtils.ScreenshotValidity.VALID;
                    aVar = aVarA;
                }
                Logger.d(this.f8026a, "Image file validation check hashValue = " + str3 + ", dimen h,w: " + bitmapDecodeFile.getHeight() + StringUtils.COMMA + bitmapDecodeFile.getWidth() + ", bitmapScanResult result = " + aVar + ", isValid = " + z2 + ", filename = " + str);
            } else {
                Logger.d(this.f8026a, "Image file validation check file does not exist = " + str);
            }
        } catch (Throwable th) {
            Logger.d(this.f8026a, "Image file validation check exception : " + th.getMessage(), th);
        }
        return z2;
    }

    protected String a(List<o> list) {
        if (list == null || list.size() == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(b9.i.d);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size() - 1) {
                sb.append(list.get(i3).f8114a.ai()).append(", ");
                i2 = i3 + 1;
            } else {
                sb.append(list.get(list.size() - 1).f8114a.ai()).append(b9.i.e);
                return sb.toString();
            }
        }
    }

    protected static String[] a(Activity activity) {
        String strA;
        String str;
        if (activity != null) {
            String string = activity.toString();
            String strA2 = BrandSafetyUtils.a(string, true);
            strA = BrandSafetyUtils.a(string, false);
            str = strA2;
        } else {
            strA = null;
            str = null;
        }
        return new String[]{strA, str};
    }

    protected void a(c cVar) {
        if (cVar != null && !cVar.I) {
            Logger.d(this.f8026a, "_AD_CAPTURE_ clearing any images taken previously");
            k kVarI = cVar.i();
            if (kVarI != null) {
                a(kVarI);
            }
            cVar.I = true;
            return;
        }
        Logger.d(this.f8026a, "avoid clearing any images taken previously");
    }

    public void a(k kVar) {
        Logger.d(this.f8026a, "remove impression screenshots started with impression: " + kVar + ", report impression size is: " + (this.D != null ? Integer.valueOf(this.D.size()) : "null"));
        if (kVar != null) {
            String str = kVar.d;
            if (str == null && kVar.c != null) {
                str = kVar.c.b;
            }
            if (str != null) {
                Logger.d(this.f8026a, "Calling remove ad files, filename = " + str);
                BrandSafetyUtils.d(str);
                kVar.d = null;
            } else {
                Logger.d(this.f8026a, "lastActivityImpressionScreenshotFilename is null and image is: " + kVar.c);
            }
        }
        this.D.clear();
    }

    public static boolean a(c cVar, CreativeInfo creativeInfo) {
        if (!CreativeInfoManager.a(creativeInfo.T() == null ? creativeInfo.S() : creativeInfo.T(), AdNetworkConfiguration.REPLACE_PREFETCH_CREATIVE_ID_WITH_MAX_CREATIVE_ID, false)) {
            return false;
        }
        String strA = CreativeInfoManager.a(creativeInfo.S(), AdNetworkConfiguration.REPLACE_PREFETCH_CREATIVE_ID_WITH_MAX_CREATIVE_ID_MAX_NETWORK_NAMES, (String) null);
        return (strA == null || !strA.contains(cVar.A()) || cVar.z() == null) ? false : true;
    }

    protected void b(c cVar, CreativeInfo creativeInfo) {
        Logger.d(this.f8026a, "should replace prefetch creativeId with max value, ad info sdk : " + cVar.c() + ", ci sdk : " + creativeInfo.S() + ", actual sdk : " + creativeInfo.T());
        if (a(cVar, creativeInfo)) {
            Logger.d(this.f8026a, "updating creativeId from " + cVar.j().P() + " to " + cVar.z());
            cVar.j().k(cVar.z());
        }
    }

    static void a(ViewGroup viewGroup, List<WeakReference<View>> list) {
        if (viewGroup != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i3);
                    list.add(new WeakReference<>(childAt));
                    if (childAt instanceof ViewGroup) {
                        a((ViewGroup) childAt, list);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    static List<WeakReference<View>> a(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WeakReference(viewGroup));
        a(viewGroup, arrayList);
        return arrayList;
    }

    protected List<WeakReference<WebView>> b(List<WeakReference<View>> list) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<View> weakReference : list) {
            if (com.safedk.android.utils.n.a((Reference<?>) weakReference) && (weakReference.get() instanceof WebView)) {
                WebView webView = (WebView) weakReference.get();
                arrayList.add(new WeakReference(webView));
                Logger.d(this.f8026a, "getWebViews added WebView address " + webView);
            }
        }
        return arrayList;
    }

    static List<String> c(List<WeakReference<View>> list) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<View> weakReference : list) {
            if (com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                arrayList.add(BrandSafetyUtils.a(weakReference.get()));
            } else {
                arrayList.add("");
            }
        }
        return arrayList;
    }

    public Activity a(Context context) {
        Context baseContext = context;
        while (baseContext instanceof ContextWrapper) {
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
            baseContext = ((ContextWrapper) baseContext).getBaseContext();
            Logger.d(this.f8026a, "getActivity: now context type is: " + baseContext.getClass().getName());
        }
        return null;
    }

    static Activity a(Bundle bundle) {
        Logger.d("AdFinderBase", "getMaxAdViewActivity: started, isOnUiThread = " + com.safedk.android.utils.n.c());
        String strN = BrandSafetyUtils.n(bundle.getString(t, null));
        Activity foregroundActivity = com.safedk.android.internal.b.getInstance().getForegroundActivity();
        try {
            for (WeakReference<Activity> weakReference : com.safedk.android.internal.b.getInstance().getAppActivities()) {
                if (weakReference != null && weakReference.get() != null) {
                    Activity activity = weakReference.get();
                    View viewFindViewById = activity.findViewById(R.id.content);
                    if ((viewFindViewById instanceof ViewGroup) && c(a((ViewGroup) viewFindViewById)).contains(strN)) {
                        Logger.d("AdFinderBase", "getMaxAdViewActivity: found activity with name " + activity.getClass().getName());
                        return activity;
                    }
                }
            }
        } catch (Exception e) {
            Logger.d("AdFinderBase", "getMaxAdViewActivity: exception occurred " + e.getMessage());
        }
        return foregroundActivity;
    }

    void b(Activity activity) {
        String strA = BrandSafetyUtils.a(com.safedk.android.internal.b.getInstance().getForegroundActivity().getClass().getName(), true);
        String strA2 = BrandSafetyUtils.a(activity.getClass().getName(), true);
        if (strA2 != null && !strA2.equals(strA)) {
            Logger.d(this.f8026a, "compare ad activity to foreground found ad activity different than foreground, foreground address is: " + strA + ", and activity address is: " + strA2);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void c(String str, String str2, String str3) {
    }

    public static boolean e(String str, String str2) {
        l lVar;
        if (str == null || (lVar = F.get(str)) == null) {
            return false;
        }
        return lVar.a(str2);
    }

    public static void a(String str, Long l2, Long l3, String str2, l.a... aVarArr) {
        if (str != null) {
            synchronized (F) {
                l lVar = F.get(str);
                if (lVar == null) {
                    lVar = new l();
                    F.put(str, lVar);
                    Logger.d("AdFinderBase", "add impression log event - key: " + str + ", impression log map size: " + F.size());
                }
                lVar.a(l2, l3, str2, aVarArr);
            }
            return;
        }
        Logger.d("AdFinderBase", "add impression log event - event id is null, not adding impression log event");
    }

    public static void a(String str, String str2, l.a... aVarArr) {
        if (str != null) {
            synchronized (F) {
                l lVar = F.get(str);
                if (lVar == null) {
                    lVar = new l();
                    F.put(str, lVar);
                    Logger.d("AdFinderBase", "add impression log event - key: " + str + ", impression log map size: " + F.size());
                }
                lVar.a(str2, aVarArr);
            }
            return;
        }
        Logger.d("AdFinderBase", "add impression log event - event id is null, not adding impression log event");
    }

    public static void a(c cVar, String str, l.a... aVarArr) {
        if (cVar != null) {
            if (cVar.K != null) {
                a(cVar.K, str, aVarArr);
                return;
            } else {
                cVar.a(str, aVarArr);
                return;
            }
        }
        Logger.d("AdFinderBase", "add impression log event - event id is null, not adding impression log event");
    }

    public static void b(String str, String str2, l.a... aVarArr) {
        if (str != null) {
            synchronized (F) {
                l lVar = F.get(str);
                if (lVar == null) {
                    lVar = new l();
                    F.put(str, lVar);
                    Logger.d("AdFinderBase", "add cumulative impression log event - key: " + str + ", impression log map size: " + F.size());
                }
                lVar.b(str2, aVarArr);
            }
            return;
        }
        Logger.d("AdFinderBase", "add cumulative impression log event - event id is null, not adding impression log event");
    }

    protected static void b(c cVar) {
        if (cVar != null) {
            synchronized (F) {
                if (cVar.L != null && F.remove(cVar.L) != null) {
                    Logger.d("AdFinderBase", "clear impression log, eventId: " + cVar.L + ", impression log map size: " + F.size());
                }
                if (cVar.x() != null) {
                    for (String str : cVar.x()) {
                        if (F.remove(str) != null) {
                            Logger.d("AdFinderBase", "clear impression log, viewAddress: " + str + ", impression log map size: " + F.size());
                        }
                    }
                } else if (cVar.K != null && F.remove(cVar.K) != null) {
                    Logger.d("AdFinderBase", "clear impression log, viewAddress: " + cVar.K + ", impression log map size: " + F.size());
                }
            }
        }
    }

    protected static l b(c cVar, k kVar) {
        l lVarRemove;
        l lVarRemove2;
        if (cVar == null || kVar == null) {
            return null;
        }
        synchronized (F) {
            if (cVar.L != null && (lVarRemove2 = F.remove(cVar.L)) != null) {
                cVar.R.a(lVarRemove2);
                Logger.d("AdFinderBase", "collect impression logs - key: " + cVar.L + ", events: " + lVarRemove2.a() + ", impression log map size: " + F.size());
            }
            if (!cVar.U) {
                if (cVar.x() != null) {
                    for (String str : cVar.x()) {
                        l lVarRemove3 = F.remove(str);
                        if (lVarRemove3 != null) {
                            kVar.h.a(lVarRemove3);
                            Logger.d("AdFinderBase", "collect impression logs - key: " + str + ", events: " + lVarRemove3.a() + ", impression log map size: " + F.size());
                        }
                    }
                } else if (cVar.K != null && (lVarRemove = F.remove(cVar.K)) != null) {
                    kVar.h.a(lVarRemove);
                    Logger.d("AdFinderBase", "collect impression logs - key: " + cVar.K + ", events: " + lVarRemove.a() + ", impression log map size: " + F.size());
                }
            }
        }
        l lVar = new l(cVar.R);
        lVar.a(kVar.h);
        StringBuilder sbAppend = new StringBuilder("collect impression logs, ad info: ").append(cVar.R.a()).append(", impression: ").append(kVar.h.a());
        if (kVar.i() != null) {
            l lVarG = kVar.i().G();
            lVar.a(lVarG);
            sbAppend.append(", ci: ").append(lVarG.a());
        }
        Logger.d("AdFinderBase", sbAppend.append(", total: ").append(lVar.a()).toString());
        return lVar;
    }

    public static List<String> a(View view) {
        if (view == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            arrayList.add(parent.toString());
        }
        return arrayList;
    }

    public static List<ViewParent> b(View view) {
        ArrayList arrayList = new ArrayList();
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            arrayList.add(parent);
        }
        return arrayList;
    }

    public static void a(ViewGroup viewGroup, List<String> list, List<String> list2, int i2) {
        if (viewGroup != null) {
            int i3 = i2 + 1;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i5);
                    list.add(BrandSafetyUtils.a(childAt));
                    list2.add("h" + i3 + ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM + (i5 + 1) + ":" + childAt);
                    if (childAt instanceof ViewGroup) {
                        a((ViewGroup) childAt, list, list2, i3);
                    }
                    i4 = i5 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static BrandSafetyUtils.AdType a(String str, WebView webView) {
        if (webView != null) {
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(str);
            ViewParent parent = webView;
            do {
                if (parent instanceof View) {
                    View view = (View) parent;
                    if (com.safedk.android.utils.n.a(view.getWidth(), view.getHeight())) {
                        Logger.d("AdFinderBase", "extract ad type from view: " + view + ", BANNER ratio, isOnUiThread = " + com.safedk.android.utils.n.c());
                        return BrandSafetyUtils.AdType.BANNER;
                    }
                    if (com.safedk.android.utils.n.b(view.getWidth(), view.getHeight())) {
                        Logger.d("AdFinderBase", "extract ad type from view: " + view + ", MREC ratio, isOnUiThread = " + com.safedk.android.utils.n.c());
                        return BrandSafetyUtils.AdType.MREC;
                    }
                    if (parent instanceof MaxAdView) {
                        BrandSafetyUtils.AdType adType = BannerFinder.f().get(BrandSafetyUtils.a(parent));
                        if (adType != null) {
                            Logger.d("AdFinderBase", "extract ad type from view: " + view + ", MaxAdView type: " + adType.name() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                            return adType;
                        }
                    } else if (adNetworkDiscoveryI != null) {
                        BrandSafetyUtils.AdType adTypeF = adNetworkDiscoveryI.f(view);
                        if (adTypeF != null) {
                            Logger.d("AdFinderBase", "extract ad type from view: " + view + ", discovery detected type: " + adTypeF);
                            return adTypeF;
                        }
                    } else if (com.safedk.android.internal.b.getInstance().isInterstitialActivity(view.getContext()) && SafeDK.getInstance().A().b(BrandSafetyUtils.a(view)) == null) {
                        Logger.d("AdFinderBase", "extract ad type from view: " + view + ", INTERSTITIAL activity: " + view.getContext() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                        return BrandSafetyUtils.AdType.INTERSTITIAL;
                    }
                }
                Logger.d("AdFinderBase", "extract ad type from view: " + parent + ", not detected");
                parent = parent.getParent();
            } while (parent != null);
        }
        Logger.d("AdFinderBase", "extract ad type from view: failed to extract");
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void a(Bitmap bitmap, c cVar) {
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void b() {
    }

    @Override // com.safedk.android.analytics.brandsafety.a
    public void c() {
    }

    protected void b(ViewGroup viewGroup, List<WeakReference<WebView>> list) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            try {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt instanceof WebView) {
                    list.add(new WeakReference<>((WebView) childAt));
                    Logger.d(this.f8026a, "find WebViews in view group - found view: " + childAt + " , parent: " + (childAt.getParent() != null ? childAt.getParent().toString() : "null"));
                } else if (childAt instanceof ViewGroup) {
                    b((ViewGroup) childAt, list);
                }
            } catch (Throwable th) {
                Logger.d(this.f8026a, "caught exception: ", th);
                return;
            }
        }
    }

    static void c(ViewGroup viewGroup, List<WeakReference<View>> list) {
        if (viewGroup != null) {
            View view = list.get(0).get();
            long height = view.getHeight() * view.getWidth();
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                long width = childAt.getWidth() * childAt.getHeight();
                if (height > 0 && width > 0 && (width / height) * 100.0f >= A) {
                    list.add(new WeakReference<>(childAt));
                }
                if (childAt instanceof ViewGroup) {
                    c((ViewGroup) childAt, list);
                }
            }
        }
    }

    public c b(String str, x xVar) {
        String strC = xVar.c();
        c cVarB = b(strC);
        if (cVarB != null && cVarB.c().equals(str)) {
            Logger.d(this.f8026a, "handle website opened for " + str + " " + cVarB.p.name() + ", view address: " + xVar.c() + ", requested URL: " + xVar.a() + ", target URL: " + xVar.b());
            RedirectData redirectData = new RedirectData(str, BrandSafetyUtils.a(cVarB.p));
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int iH = SafeDK.getInstance().h();
            boolean z2 = false;
            v vVar = null;
            int size = cVarB.x().size() - 1;
            while (size >= 0) {
                v vVarA = DetectTouchUtils.a(str, cVarB.x().get(size));
                long jLongValue = vVarA == null ? 0L : vVarA.f8117a.longValue();
                Logger.d(this.f8026a, "handle website opened, view: " + strC + ", last touch event time: " + jLongValue + ", diff: " + (jElapsedRealtime - jLongValue) + ", threshold: " + iH);
                z2 = (iH == 0 || jLongValue == 0 || jElapsedRealtime - jLongValue > ((long) iH)) ? false : true;
                if (z2) {
                    vVar = vVarA;
                    break;
                }
                size--;
                vVar = vVarA;
            }
            xVar.a(cVarB);
            xVar.a(vVar);
            xVar.e();
            k kVarI = cVarB.i();
            if (kVarI != null) {
                redirectData.a(xVar.a(), xVar.b());
                redirectData.l = !z2;
                Logger.d(this.f8026a, "handle " + (redirectData.l ? "auto " : "") + "website opened for " + str + " " + cVarB.p.name() + ", view address: " + strC + ", requested URL: " + xVar.a() + ", redirect URL: " + xVar.b());
                kVarI.a(redirectData);
                return cVarB;
            }
        }
        return null;
    }
}
