package com.smaato.sdk.core.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public final class ActivityProvider {
    private static final ActivityProvider instance = new ActivityProvider();
    private WeakReference activityWeakReference = new WeakReference(null);

    private ActivityProvider() {
    }

    public static ActivityProvider get() {
        return instance;
    }

    public static void init(Context context) {
        instance.attach(context);
    }

    public Activity getCurrentActivity() {
        return (Activity) this.activityWeakReference.get();
    }

    private void attach(Context context) {
        if (context == null || !(context.getApplicationContext() instanceof Application)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksAdapter() { // from class: com.smaato.sdk.core.lifecycle.ActivityProvider.1
            @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ActivityProvider.this.activityWeakReference = new WeakReference(activity);
            }

            @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ActivityProvider.this.activityWeakReference = new WeakReference(activity);
            }

            @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ActivityProvider.this.activityWeakReference = new WeakReference(activity);
            }

            @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (ActivityProvider.this.activityWeakReference.get() == activity) {
                    ActivityProvider.this.activityWeakReference.clear();
                }
            }

            @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (ActivityProvider.this.activityWeakReference.get() == activity) {
                    ActivityProvider.this.activityWeakReference.clear();
                }
            }
        });
    }
}
