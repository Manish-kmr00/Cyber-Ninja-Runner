package com.safedk.android.analytics.brandsafety;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.safedk.android.SafeDK;
import com.safedk.android.utils.Logger;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public class DetectTouchUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7991a = "DetectTouchUtils";
    private static final HashMap<String, v> b = new HashMap<>();
    private static final HashMap<String, v> c = new HashMap<>();
    private static String d = null;
    private static boolean e = false;
    private static final Timer f = new Timer("RedirectSimulationTimer");
    private static TimerTask g = null;
    private static final ExecutorService h = Executors.newSingleThreadExecutor();

    public static v a(String str) {
        Logger.d(f7991a, "getLastTouchEvent is latestTouchEventBySdkMap contains " + str + "? " + b.containsKey(str) + ", map = " + b);
        if (!b.containsKey(str) || b.get(str) == null) {
            return null;
        }
        Logger.d(f7991a, "getLastTouchEvent returns " + b.get(str));
        return b.get(str);
    }

    public static v a(String str, String str2) {
        return c.get(str + "_" + str2);
    }

    public static void activityOnTouch(String sdkPackageName, MotionEvent me) {
        try {
            if (me.getAction() == 0) {
                Logger.d(f7991a, "activity on touch started, sdk: " + sdkPackageName + ", motion event: " + me + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                if ((0 != me.getEventTime()) && me.getActionMasked() != 2) {
                    b(null, sdkPackageName);
                }
            }
        } catch (Throwable th) {
            Logger.d(f7991a, "error in activity on touch", th);
        }
    }

    public static void viewOnTouch(String sdkPackage, View view, MotionEvent me) {
        try {
            if (me.getAction() == 0) {
                Logger.d(f7991a, "view on touch, started, sdkPackage = " + sdkPackage + ", View = " + view + ", MotionEvent = " + me);
                if (sdkPackage.equals(com.safedk.android.utils.h.f8160a) && (view instanceof MaxNativeAdView)) {
                    String sdkPackage2 = NativeFinder.b((MaxNativeAdView) view);
                    if (sdkPackage2 == null) {
                        sdkPackage2 = BannerFinder.a((MaxNativeAdView) view);
                    }
                    if (sdkPackage2 != null) {
                        try {
                            Logger.d(f7991a, "view on touch, translate Max native ad view to sdk: " + sdkPackage2 + ", view: " + view + ", isOnUiThread = " + com.safedk.android.utils.n.c());
                            sdkPackage = sdkPackage2;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } else {
                        Logger.d(f7991a, "view on touch, failed to translate Max native ad view to sdk, view: " + view);
                    }
                } else if (view instanceof WebView) {
                    Logger.d(f7991a, "web view on touch, sdk: " + sdkPackage + ", view: " + view + ", motion event: " + me);
                } else if (view instanceof ViewGroup) {
                    Logger.d(f7991a, "view group on touch, sdk: " + sdkPackage + ", view: " + view + ", motion event: " + me);
                } else {
                    Logger.d(f7991a, "view on touch, sdk: " + sdkPackage + ", view: " + view + ", motion event: " + me);
                }
                b(view != null ? BrandSafetyUtils.a(view) : null, sdkPackage);
                return;
            }
            return;
        } catch (Throwable th2) {
            th = th2;
        }
        Logger.d(f7991a, "error in view on touch", th);
    }

    public static void b(final String str, final String str2) {
        if (com.safedk.android.utils.n.c()) {
            h.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.DetectTouchUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    DetectTouchUtils.d(str, str2);
                }
            });
        } else {
            d(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str, String str2) {
        if (SafeDK.T() && (e || (d != null && str != null && d.contains(str)))) {
            Logger.d(f7991a, "ignore touch event, sdk: " + str2 + ", view address: " + str + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            return;
        }
        v vVar = new v(Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(System.currentTimeMillis()), str);
        b.put(str2, vVar);
        Logger.d(f7991a, "Set latest touch event, setting sdk: " + str2 + ", details: " + vVar + ", isOnUiThread = " + com.safedk.android.utils.n.c());
        if (str != null) {
            String str3 = str2 + "_" + str;
            c.put(str3, vVar);
            Logger.d(f7991a, "Set latest touch event, setting key: " + str3 + ", details: " + vVar);
        }
    }

    public static void b(final String str) {
        if (com.safedk.android.utils.n.c()) {
            h.execute(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.DetectTouchUtils.2
                @Override // java.lang.Runnable
                public void run() {
                    DetectTouchUtils.e(str);
                }
            });
        } else {
            e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        if (SafeDK.T()) {
            if (g != null) {
                g.cancel();
            }
            d = str;
            Logger.d(f7991a, "set ignore next touch event: " + d + ", isOnUiThread = " + com.safedk.android.utils.n.c());
            long jF = SafeDK.getInstance().f();
            g = new TimerTask() { // from class: com.safedk.android.analytics.brandsafety.DetectTouchUtils.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    String unused = DetectTouchUtils.d = null;
                    Logger.d(DetectTouchUtils.f7991a, "timeout ignore next touch event");
                }
            };
            f.schedule(g, jF);
        }
    }

    public static void a() {
        d = null;
        Logger.d(f7991a, "reset ignore next touch event");
    }

    public static boolean b() {
        e = !e;
        Logger.d(f7991a, "toggle ignore touch events: " + e);
        return e;
    }

    public static void viewChangedByExternalLib(ViewGroup viewGroup, View view) {
        try {
            Logger.d(f7991a, "view on view group add view, started, viewGroup = " + viewGroup + ", view = " + view.getClass().getCanonicalName());
            Activity activityA = com.safedk.android.utils.o.a(viewGroup);
            if (activityA != null) {
                Logger.d(f7991a, "view on view group add view, started, activity = " + activityA);
                if (BrandSafetyUtils.d(activityA.getClass()) && view.getClass().getCanonicalName().toLowerCase().contains("com.braze.ui.inappmessage")) {
                    if (SafeDK.getInstance() != null && SafeDK.getInstance().z() != null) {
                        String strA = BrandSafetyUtils.a((Class) activityA.getClass());
                        Logger.d(f7991a, "view on view group add view, activity = " + activityA + " is an ad inter activity and the newly added view is of an external lib. requestNoSampling will be invoked for sdk " + strA);
                        SafeDK.getInstance().z().a(strA, (String) null, false);
                    }
                } else {
                    Logger.d(f7991a, "view on view group add view, activity = " + activityA + " is not an ad inter activity, skipping");
                }
            }
        } catch (Throwable th) {
            Logger.d(f7991a, "error in on view group add view", th);
        }
    }
}
