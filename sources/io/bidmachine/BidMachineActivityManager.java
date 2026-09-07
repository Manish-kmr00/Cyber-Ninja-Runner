package io.bidmachine;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
class BidMachineActivityManager {
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static WeakReference<Activity> weakTopActivity;

    BidMachineActivityManager() {
    }

    static void initialize(Context context) {
        if (isInitialized.compareAndSet(false, true)) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof Application) {
                    ((Application) applicationContext).registerActivityLifecycleCallbacks(new LifecycleCallbacks());
                }
            } catch (Throwable th) {
                Logger.w(th);
            }
        }
    }

    static Activity getTopActivity() {
        WeakReference<Activity> weakReference = weakTopActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    static void setTopActivity(Activity activity) {
        weakTopActivity = new WeakReference<>(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        private LifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            try {
                BidMachineActivityManager.setTopActivity(activity);
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            try {
                BidMachineActivityManager.setTopActivity(activity);
                Utils.onBackgroundThread(new Runnable() { // from class: io.bidmachine.BidMachineActivityManager$LifecycleCallbacks$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SessionManager.get().resume();
                    }
                });
            } catch (Throwable unused) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            try {
                Utils.onBackgroundThread(new Runnable() { // from class: io.bidmachine.BidMachineActivityManager$LifecycleCallbacks$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SessionManager.get().pause();
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }
}
