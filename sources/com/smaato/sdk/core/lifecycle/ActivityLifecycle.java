package com.smaato.sdk.core.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.Consumer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public class ActivityLifecycle extends Lifecycle implements Application.ActivityLifecycleCallbacks {

    @Inject
    public static Application application;
    WeakReference<Activity> activity;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public ActivityLifecycle(Activity activity) {
        this.activity = new WeakReference<>(activity);
        AndroidsInjector.injectStatic(ActivityLifecycle.class);
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity == this.activity.get()) {
            notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ActivityLifecycle$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5526xf06793ee((Lifecycle.Observer) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onActivityCreated$0$com-smaato-sdk-core-lifecycle-ActivityLifecycle, reason: not valid java name */
    /* synthetic */ void m5526xf06793ee(Lifecycle.Observer observer) {
        observer.onCreate(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity == this.activity.get()) {
            notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ActivityLifecycle$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5530x62207748((Lifecycle.Observer) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onActivityStarted$1$com-smaato-sdk-core-lifecycle-ActivityLifecycle, reason: not valid java name */
    /* synthetic */ void m5530x62207748(Lifecycle.Observer observer) {
        observer.onStart(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == this.activity.get()) {
            notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ActivityLifecycle$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5529x838ccd1f((Lifecycle.Observer) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onActivityResumed$2$com-smaato-sdk-core-lifecycle-ActivityLifecycle, reason: not valid java name */
    /* synthetic */ void m5529x838ccd1f(Lifecycle.Observer observer) {
        observer.onResume(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity == this.activity.get()) {
            notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ActivityLifecycle$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5528xba780dad((Lifecycle.Observer) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onActivityPaused$3$com-smaato-sdk-core-lifecycle-ActivityLifecycle, reason: not valid java name */
    /* synthetic */ void m5528xba780dad(Lifecycle.Observer observer) {
        observer.onPause(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity == this.activity.get()) {
            notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ActivityLifecycle$$ExternalSyntheticLambda2
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5531x3a382b97((Lifecycle.Observer) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onActivityStopped$4$com-smaato-sdk-core-lifecycle-ActivityLifecycle, reason: not valid java name */
    /* synthetic */ void m5531x3a382b97(Lifecycle.Observer observer) {
        observer.onStop(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity == this.activity.get()) {
            notifyObservers(new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ActivityLifecycle$$ExternalSyntheticLambda5
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5527x6c43a5a4((Lifecycle.Observer) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onActivityDestroyed$5$com-smaato-sdk-core-lifecycle-ActivityLifecycle, reason: not valid java name */
    /* synthetic */ void m5527x6c43a5a4(Lifecycle.Observer observer) {
        observer.onDestroy(this);
    }
}
