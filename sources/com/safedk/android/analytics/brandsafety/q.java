package com.safedk.android.analytics.brandsafety;

import android.app.Activity;
import android.os.Bundle;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class q extends BannerFinder {
    public q(int i) {
        super(BrandSafetyUtils.AdType.MREC, Arrays.asList(BrandSafetyUtils.o), "MrecFinder", i);
    }

    @Override // com.safedk.android.analytics.brandsafety.BannerFinder, com.safedk.android.analytics.brandsafety.b
    protected c a(String str, String str2, String str3, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, String str4, String str5) {
        return new r(str, str2, str3, screenShotOrientation, str4, str5);
    }

    @Override // com.safedk.android.analytics.brandsafety.BannerFinder
    protected e a(Activity activity, String str, int i, String str2, Bundle bundle, String str3) {
        r rVar = new r(a(com.safedk.android.internal.b.getInstance().getForegroundActivity()), str, i, str2, bundle, str3);
        rVar.af = new WeakReference<>(activity);
        return rVar;
    }

    @Override // com.safedk.android.analytics.brandsafety.BannerFinder
    protected boolean f(String str, String str2) {
        boolean zA = CreativeInfoManager.a(str2, AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, false);
        String strA = CreativeInfoManager.a(str2, AdNetworkConfiguration.AD_NETWORK_TO_IGNORE, (String) null);
        Logger.d(this.f8026a, "sdk " + str2 + ": config item SUPPORTS_MREC_IMPRESSION_TRACKING is " + zA + ", config item AD_NETWORK_TO_IGNORE is " + strA + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (zA && !str.equals(strA)) {
            return true;
        }
        Logger.d(this.f8026a, "MREC tracking is not supported for this ad network (" + str + ")");
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.BannerFinder
    protected boolean a(e eVar, long j) {
        if (eVar == null || com.safedk.android.utils.e.a((c) eVar)) {
            Logger.d(this.f8026a, "_MEMORY_LOAD_ don't take screenshot, ad info: " + eVar + ", low memory");
            return false;
        }
        int iA = ((int) CreativeInfoManager.a(eVar.c(), AdNetworkConfiguration.MREC_SCREENSHOT_TAKING_DELAY, 0L)) / SafeDK.getInstance().aa();
        Logger.d(this.f8026a, "should take screenshot started for " + eVar.c() + ", iterationDelay = " + iA + ",  timerIterationCounter = " + j);
        if (iA > 0 && j <= iA) {
            Logger.d(this.f8026a, "_AD_CAPTURE_ don't take screenshot, delay interval for sdk " + eVar.c() + " not reached, current iteration : " + j + ", skipping");
            eVar.am.c--;
            return false;
        }
        if (!SafeDK.getInstance().I()) {
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(eVar.c());
            if (!eVar.i().l && adNetworkDiscoveryI != null && adNetworkDiscoveryI.a((c) eVar)) {
                eVar.i().l = true;
                Logger.d(this.f8026a, "_AD_CAPTURE_ don't take screenshot - found a media player");
            }
            CreativeInfo creativeInfoJ = eVar.j();
            if (creativeInfoJ == null) {
                Logger.d(this.f8026a, "_AD_CAPTURE_ don't take screenshot, no creative info yet");
                return false;
            }
            if (BrandSafetyUtils.o.equals(creativeInfoJ.K())) {
                boolean zA = CreativeInfoManager.a(eVar.v, AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false);
                if (creativeInfoJ.al() && !zA) {
                    Logger.d(this.f8026a, "_AD_CAPTURE_ don't take screenshot, multi ad, sdk: " + eVar.v);
                    return false;
                }
                if (m(eVar.c())) {
                    if (!eVar.i().l) {
                        Logger.d(this.f8026a, "_AD_CAPTURE_ take screenshot, MREC ad is not a video ad");
                        return true;
                    }
                    if (eVar.i().k) {
                        Logger.d(this.f8026a, "_AD_CAPTURE_ take screenshot, MREC video ad finished playing or sdk configured to take screenshots throughout the impression. ");
                        return true;
                    }
                    Logger.d(this.f8026a, "_AD_CAPTURE_ don't take screenshot, MREC video hasn't finished playing yet, waiting for video completed event");
                    return false;
                }
                Logger.d(this.f8026a, "_AD_CAPTURE_ take screenshot, sdk " + eVar.c() + " Mrec EoV is not supported");
                return true;
            }
            Logger.d(this.f8026a, "_AD_CAPTURE_ take screenshot, MREC ad");
            return true;
        }
        Logger.d(this.f8026a, "_AD_CAPTURE_ take screenshot, SafeDK Config item 'AlwaysTakeScreenshot' is true");
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.BannerFinder
    protected boolean m(String str) {
        boolean zA = CreativeInfoManager.a(str, AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, false);
        if (!zA) {
            Logger.d(this.f8026a, "_AD_CAPTURE_ take screenshot, MREC EoV is not supported for this SDK: " + str);
        }
        return zA;
    }

    @Override // com.safedk.android.analytics.brandsafety.BannerFinder, com.safedk.android.analytics.brandsafety.a
    public boolean a(String str, String str2, boolean z, String str3) {
        synchronized (J) {
            Logger.d(this.f8026a, "_AD_CAPTURE_ on video " + (z ? "completed" : "start") + ", keys : " + J.keySet() + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        }
        c cVarB = str2 != null ? b(str2) : null;
        if (cVarB == null) {
            List<c> listQ = q(str);
            if (z) {
                cVarB = d(listQ);
            } else {
                cVarB = listQ.size() == 1 ? listQ.get(0) : null;
            }
        }
        Logger.d(this.f8026a, "set on video - ad info is: " + cVarB);
        if (cVarB == null || cVarB.p != BrandSafetyUtils.AdType.MREC) {
            return false;
        }
        Logger.d(this.f8026a, "set on video info is with event id: " + cVarB.L + " is eov triggered: " + cVarB.i().k + " is video: " + cVarB.i().l);
        r rVar = (r) cVarB;
        if (z && !rVar.i().k) {
            rVar.b(l.p, new l.a(l.P, str3));
        } else if (!z && (!rVar.i().l || rVar.i().k)) {
            rVar.b(l.o, new l.a(l.P, str3));
        }
        CreativeInfo creativeInfoJ = rVar.j();
        Logger.d(this.f8026a, "_AD_CAPTURE_ on video " + (z ? "completed" : "start") + ", view address: " + str2 + ", ad format: " + (creativeInfoJ != null ? creativeInfoJ.K() : null) + ", current value: " + rVar.i().k);
        if (creativeInfoJ != null) {
            Logger.d(this.f8026a, "on mrec video event triggered, setting ci ad as video ad.");
            creativeInfoJ.f(true);
            if (creativeInfoJ.K() == null) {
                Logger.d(this.f8026a, "on video " + (z ? "completed" : "start") + ", setting CI ad format, based on view address match");
                creativeInfoJ.a(BrandSafetyEvent.AdFormatType.MREC);
            }
            if (!rVar.i().k && z) {
                a((c) rVar);
                if (!creativeInfoJ.v()) {
                    Logger.d(this.f8026a, "on video completed, setting CI as video ad");
                    creativeInfoJ.f(true);
                }
                Logger.d(this.f8026a, "on video completed, setting to: " + z);
                rVar.i().k = true;
                if (m(rVar.c())) {
                    if (rVar.am != null) {
                        Logger.d(this.f8026a, "on video completed, impressionHandlerTask = " + rVar.am + ", taskFuture = " + rVar.am.d);
                        if (rVar.am.d != null) {
                            Logger.d(this.f8026a, "_AD_CAPTURE_ on video completed, cancelling existing taskFuture " + rVar.am.d);
                            rVar.am.d.cancel(false);
                            rVar.am.d = null;
                        }
                        int iAa = SafeDK.getInstance().aa() * 1000;
                        Logger.d(this.f8026a, "on video completed, start taking screenshots for view: " + ((rVar.am.b == null || rVar.am.b.get() == null) ? "null" : rVar.am.b.get()) + ", samplingInterval = " + iAa);
                        rVar.am = new BannerFinder.a(rVar, rVar.am.b, this.e, rVar.av);
                        rVar.am.d = this.E.scheduleWithFixedDelay(rVar.am, 500L, iAa, TimeUnit.MILLISECONDS);
                    }
                } else {
                    Logger.d(this.f8026a, "on video completed, Info impressionHandlerTask is null : " + rVar);
                }
            } else if (!z) {
                a((c) rVar);
                rVar.i().k = false;
            }
        }
        return true;
    }

    private List<c> q(String str) {
        Logger.d(this.f8026a, "get items by sdk package started, sdk: " + str);
        ArrayList arrayList = new ArrayList();
        synchronized (J) {
            for (e eVar : J.values()) {
                Logger.d(this.f8026a, "get MREC infos By sdk package, mrec info: " + eVar);
                if ((eVar instanceof r) && !eVar.U && eVar.aa && eVar.c() != null && eVar.c().equals(str)) {
                    Logger.d(this.f8026a, "get MREC infos By sdk package, adding " + eVar);
                    arrayList.add(eVar);
                }
            }
        }
        return arrayList;
    }

    private c d(List<c> list) {
        c cVar = null;
        for (c cVar2 : list) {
            if (cVar2 == null || cVar2.i() == null || !cVar2.i().l) {
                cVar2 = cVar;
            } else if (cVar != null) {
                Logger.d(this.f8026a, "found more than one video mrec info - not returning");
                return null;
            }
            cVar = cVar2;
        }
        return cVar;
    }
}
