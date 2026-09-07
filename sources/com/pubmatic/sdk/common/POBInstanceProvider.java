package com.pubmatic.sdk.common;

import android.app.Application;
import android.content.Context;
import com.pubmatic.sdk.common.cache.POBAdViewCacheService;
import com.pubmatic.sdk.common.cache.POBCacheManager;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.models.POBAppInfo;
import com.pubmatic.sdk.common.models.POBDeviceInfo;
import com.pubmatic.sdk.common.network.POBNetworkHandler;
import com.pubmatic.sdk.common.network.POBNetworkMonitor;
import com.pubmatic.sdk.common.network.POBTrackerHandler;
import com.pubmatic.sdk.common.session.POBAppSessionHandler;
import com.pubmatic.sdk.common.session.POBAppStateMonitor;
import com.pubmatic.sdk.common.session.POBImpDepthHandler;
import com.pubmatic.sdk.common.session.POBImpDepthHandling;
import com.pubmatic.sdk.common.utility.POBLocationDetector;

/* JADX INFO: loaded from: classes12.dex */
public class POBInstanceProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile POBDeviceInfo f7552a;
    private static volatile POBAppInfo b;
    private static volatile POBLocationDetector c;
    private static volatile POBNetworkHandler d;
    private static volatile POBSDKConfig e;
    private static volatile POBCacheManager f;
    private static volatile POBTrackerHandler g;
    private static volatile POBNetworkMonitor h;
    private static volatile POBAdViewCacheService i;
    private static volatile POBCrashAnalysing j;
    private static volatile POBAppSessionHandler k;
    private static volatile POBImpDepthHandling l;

    public static POBAdViewCacheService getAdViewCacheService() {
        if (i == null) {
            synchronized (POBAdViewCacheService.class) {
                if (i == null) {
                    i = new POBAdViewCacheService();
                }
            }
        }
        return i;
    }

    public static POBAppInfo getAppInfo(Context context) {
        if (b == null) {
            synchronized (POBAppInfo.class) {
                if (b == null) {
                    b = new POBAppInfo(context);
                }
            }
        }
        return b;
    }

    public static POBAppSessionHandler getApplicationSessionHandler(Application application) {
        if (k == null) {
            synchronized (POBAppSessionHandler.class) {
                if (k == null) {
                    k = new POBAppSessionHandler(POBAppStateMonitor.getInstance(application));
                }
            }
        }
        return k;
    }

    public static POBCacheManager getCacheManager(Context context) {
        if (f == null) {
            synchronized (POBCacheManager.class) {
                if (f == null) {
                    f = new POBCacheManager(context, getNetworkHandler(context));
                }
            }
        }
        return f;
    }

    public static synchronized POBCrashAnalysing getCrashAnalytics() {
        if (j == null) {
            try {
                j = (POBCrashAnalysing) Class.forName("com.pubmatic.sdk.crashanalytics.POBCrashAnalytics").newInstance();
            } catch (Exception e2) {
                POBLog.error("POBInstanceProvider", "Exception caught while initializing CrashAnalytics. Message -> " + e2.getMessage(), new Object[0]);
            }
        }
        return j;
    }

    public static POBDeviceInfo getDeviceInfo(Context context) {
        if (f7552a == null) {
            synchronized (POBDeviceInfo.class) {
                if (f7552a == null) {
                    f7552a = new POBDeviceInfo(context);
                }
            }
        }
        return f7552a;
    }

    public static POBImpDepthHandling getImpDepthHandler(POBAppSessionHandler pOBAppSessionHandler) {
        if (l == null) {
            synchronized (POBImpDepthHandler.class) {
                if (l == null) {
                    l = new POBImpDepthHandler(pOBAppSessionHandler);
                }
            }
        }
        return l;
    }

    public static POBLocationDetector getLocationDetector(Context context) {
        if (c == null) {
            synchronized (POBLocationDetector.class) {
                if (c == null) {
                    c = new POBLocationDetector(context);
                    c.setLocationUpdateIntervalInMs(getSdkConfig().getLocationDetectionDurationInMillis());
                }
            }
        }
        return c;
    }

    public static POBNetworkHandler getNetworkHandler(Context context) {
        if (d == null) {
            synchronized (POBNetworkHandler.class) {
                if (d == null) {
                    d = new POBNetworkHandler(context);
                }
            }
        }
        return d;
    }

    public static POBNetworkMonitor getNetworkMonitor(Context context) {
        if (h == null) {
            synchronized (POBNetworkMonitor.class) {
                if (h == null) {
                    h = new POBNetworkMonitor(context);
                }
            }
        }
        return h;
    }

    public static POBSDKConfig getSdkConfig() {
        if (e == null) {
            synchronized (POBNetworkHandler.class) {
                if (e == null) {
                    e = new POBSDKConfig();
                }
            }
        }
        return e;
    }

    public static POBTrackerHandler getTrackerHandler(POBNetworkHandler pOBNetworkHandler) {
        if (g == null) {
            synchronized (POBTrackerHandler.class) {
                if (g == null) {
                    g = new POBTrackerHandler(pOBNetworkHandler);
                }
            }
        }
        return g;
    }
}
