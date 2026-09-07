package com.safedk.android.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.InterstitialFinder;
import com.safedk.android.analytics.reporters.CrashReporter;
import com.safedk.android.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8136a = "LifecycleManager";
    private static b b = null;
    private static final Object c = new Object();
    private static boolean h;
    private final LinkedHashSet<WeakReference<Activity>> d = new LinkedHashSet<>();
    private final ArrayList<WeakReference<Activity>> e = new ArrayList<>();
    private int f = 0;
    private boolean g = true;
    private Set<a> i = Collections.newSetFromMap(new ConcurrentHashMap());
    private final ScheduledExecutorService j = Executors.newScheduledThreadPool(1);

    private b() {
    }

    public ArrayList<WeakReference<Activity>> getAppActivities() {
        return this.e;
    }

    public static synchronized b getInstance() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public void AddActivity(Activity activity) {
        this.d.add(new WeakReference<>(activity));
        if (!BrandSafetyUtils.d(activity.getClass())) {
            this.e.add(new WeakReference<>(activity));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.app.Activity] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v17, types: [android.app.Activity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public Activity getForegroundActivity() {
        ?? r0;
        Throwable th;
        ?? r3;
        String str = null;
        try {
            if (this.d.size() > 0) {
                synchronized (this.d) {
                    try {
                        r0 = (Activity) ((WeakReference) this.d.toArray()[this.d.size() - 1]).get();
                        try {
                            if (r0 != 0) {
                                try {
                                    str = f8136a;
                                    Logger.d(f8136a, "getForegroundActivity Foreground activity is " + r0);
                                } catch (Throwable th2) {
                                    th = th2;
                                    r0 = r0;
                                    Logger.e(f8136a, "Exception in getForegroundActivity : " + th.getMessage(), th);
                                    new CrashReporter().caughtException(th);
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            r3 = r0;
                            while (true) {
                                try {
                                    try {
                                        throw th;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        r0 = r3;
                                        Logger.e(f8136a, "Exception in getForegroundActivity : " + th.getMessage(), th);
                                        new CrashReporter().caughtException(th);
                                        return r0;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        r3 = 0;
                    }
                }
            } else {
                Logger.d(f8136a, "No foreground activity found");
                r0 = 0;
            }
        } catch (Throwable th7) {
            th = th7;
            r0 = str;
        }
        return r0;
    }

    public boolean isInBackground() {
        return this.g;
    }

    public synchronized boolean isInterstitialActivity(Context activity) {
        boolean z = false;
        synchronized (this) {
            if (this.f != 0 && this.f == System.identityHashCode(activity)) {
                z = true;
            }
        }
        return z;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (h) {
            Logger.d(f8136a, "onActivityCreated " + activity.toString());
            if (!BrandSafetyUtils.d(activity.getClass())) {
                this.e.add(new WeakReference<>(activity));
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        try {
            if (h) {
                Logger.d(f8136a, "onActivityStarted " + activity.toString());
                synchronized (this.d) {
                    this.d.add(new WeakReference<>(activity));
                }
                if (this.d.size() == 1) {
                    c();
                }
            }
        } catch (Throwable th) {
            Logger.e(f8136a, "onActivityStarted failed", th);
            new CrashReporter().caughtException(th);
        }
    }

    private String a() {
        StringBuilder sb = new StringBuilder("{ ");
        synchronized (this.d) {
            Iterator<WeakReference<Activity>> it = this.d.iterator();
            while (it.hasNext()) {
                sb.append(it.next().get()).append(" ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        try {
            if (h) {
                Logger.d(f8136a, "onActivityResumed " + activity.toString() + ", isActive=" + h + ", foregroundActivities=" + a());
                boolean z = false;
                if (BrandSafetyUtils.d(activity.getClass())) {
                    this.f = System.identityHashCode(activity);
                    SafeDK.getInstance().a(activity);
                    z = true;
                } else {
                    SafeDK.getInstance().d(activity);
                }
                if (!z || BrandSafetyUtils.c(activity.getClass())) {
                    SafeDK.getInstance().c(activity);
                } else if (SafeDK.getInstance().z().d(activity) == null) {
                    this.j.schedule(new Runnable() { // from class: com.safedk.android.internal.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SafeDK.getInstance().z().d(activity) == null) {
                                SafeDK.getInstance().c(activity);
                            }
                        }
                    }, 3L, TimeUnit.SECONDS);
                }
                if (BrandSafetyUtils.c(activity.getClass())) {
                    BrandSafetyUtils.b(activity);
                }
            }
        } catch (Throwable th) {
            Logger.e(f8136a, "onActivityResumed failed", th);
            new CrashReporter().caughtException(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        try {
            if (h) {
                Logger.d(f8136a, "onActivityPaused " + activity.toString());
                if (BrandSafetyUtils.d(activity.getClass())) {
                    SafeDK.getInstance().b(activity);
                } else {
                    SafeDK.getInstance().e(activity);
                }
                if (BrandSafetyUtils.c(activity.getClass())) {
                    BrandSafetyUtils.c(activity);
                }
            }
        } catch (Throwable th) {
            Logger.e(f8136a, "onActivityPaused failed", th);
            new CrashReporter().caughtException(th);
        }
    }

    public synchronized void removeActivity(Activity activity, Collection<WeakReference<Activity>> collection) {
        for (WeakReference<Activity> weakReference : collection) {
            if (weakReference.get() == activity) {
                collection.remove(weakReference);
                weakReference.clear();
                break;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            if (h) {
                Logger.d(f8136a, "onActivityStopped " + activity.toString());
                synchronized (this.d) {
                    removeActivity(activity, this.d);
                }
                Logger.d(f8136a, "onActivityStopped foregroundActivities=" + a());
                if (this.d.isEmpty()) {
                    b();
                    InterstitialFinder interstitialFinderZ = SafeDK.getInstance().z();
                    if (!BrandSafetyUtils.d(activity.getClass()) && interstitialFinderZ != null && interstitialFinderZ.d(activity) == null) {
                        Logger.d(f8136a, "onActivityStopped, checking for redirect");
                        BrandSafetyUtils.g();
                    }
                }
            }
        } catch (Throwable th) {
            Logger.e(f8136a, "onActivityStopped failed", th);
            new CrashReporter().caughtException(th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (h) {
            Logger.d(f8136a, "onActivitySaveInstanceState " + activity.toString());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (h) {
            Logger.d(f8136a, "onActivityDestroyed " + activity.toString());
            if (BrandSafetyUtils.d(activity.getClass())) {
                SafeDK.getInstance().a(activity.toString());
            } else {
                removeActivity(activity, this.e);
            }
        }
    }

    private void a(boolean z) {
        this.g = z;
    }

    private void b() {
        Logger.d(f8136a, "Identified background");
        a(true);
        for (a aVar : this.i) {
            Logger.d(f8136a, "notifyBackground to " + aVar.getClass().getCanonicalName());
            aVar.g();
        }
    }

    private void c() {
        Logger.d(f8136a, "Identified foreground");
        a(false);
        Iterator<a> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    public synchronized void registerBackgroundForegroundListener(a listener) {
        try {
            if (h && !this.i.contains(listener) && !a(listener)) {
                Logger.d(f8136a, "Adding " + listener.getClass() + " to listen to BG FG events");
                this.i.add(listener);
                if (isInBackground()) {
                    listener.g();
                } else {
                    listener.h();
                }
            }
        } catch (Throwable th) {
            Logger.e(f8136a, "Failed to add listener to BG/FG events", th);
            new CrashReporter().caughtException(th);
        }
    }

    private boolean a(a aVar) {
        Logger.d(f8136a, "listenersContainsType started, listener is " + aVar.getClass());
        ArrayList arrayList = new ArrayList();
        if (this.i != null) {
            Logger.d(f8136a, "listenersContainsType iteration listener is " + aVar.getClass());
            Iterator<a> it = this.i.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getClass().getCanonicalName());
            }
        }
        return arrayList.contains(aVar.getClass().getCanonicalName());
    }

    public synchronized void clearBackgroundForegroundListeners() {
        Logger.d(f8136a, "Clearing Background Foreground listeners collection");
        this.i = Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static void setActiveMode(boolean enable) {
        h = enable;
        Logger.d(f8136a, "setting active mode to " + enable);
    }
}
