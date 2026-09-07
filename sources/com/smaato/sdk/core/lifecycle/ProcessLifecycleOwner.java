package com.smaato.sdk.core.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class ProcessLifecycleOwner {
    private static final ProcessLifecycleOwner instance = new ProcessLifecycleOwner();
    private Handler handler;
    private Listener listener;
    private boolean shouldTriggerFirstActivityStarted;
    private final Runnable delayedPauseRunnable = new Runnable() { // from class: com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner$$ExternalSyntheticLambda4
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.m5546lambda$new$0$comsmaatosdkcorelifecycleProcessLifecycleOwner();
        }
    };
    private int startedCounter = 0;
    private int resumedCounter = 0;
    private boolean pauseSent = true;
    private boolean stopSent = true;

    public interface Listener {
        void onFirstActivityStarted();

        void onLastActivityStopped();
    }

    /* JADX INFO: renamed from: lambda$new$0$com-smaato-sdk-core-lifecycle-ProcessLifecycleOwner, reason: not valid java name */
    /* synthetic */ void m5546lambda$new$0$comsmaatosdkcorelifecycleProcessLifecycleOwner() {
        dispatchPauseIfNeeded();
        dispatchStopIfNeeded();
    }

    private ProcessLifecycleOwner() {
    }

    public static ProcessLifecycleOwner get() {
        return instance;
    }

    static void init(Context context, Handler handler) {
        instance.attach(context, handler);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
        if (this.shouldTriggerFirstActivityStarted) {
            listener.onFirstActivityStarted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void activityStarted() {
        int i = this.startedCounter + 1;
        this.startedCounter = i;
        if (i == 1 && this.stopSent) {
            Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner$$ExternalSyntheticLambda3
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((ProcessLifecycleOwner.Listener) obj).onFirstActivityStarted();
                }
            });
            this.shouldTriggerFirstActivityStarted = true;
            this.stopSent = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void activityResumed() {
        int i = this.resumedCounter + 1;
        this.resumedCounter = i;
        if (i == 1) {
            if (this.pauseSent) {
                this.pauseSent = false;
            } else {
                Objects.onNotNull(this.handler, new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner$$ExternalSyntheticLambda2
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m5545x52b6d9a((Handler) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: lambda$activityResumed$1$com-smaato-sdk-core-lifecycle-ProcessLifecycleOwner, reason: not valid java name */
    /* synthetic */ void m5545x52b6d9a(Handler handler) {
        handler.removeCallbacks(this.delayedPauseRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void activityPaused() {
        int i = this.resumedCounter - 1;
        this.resumedCounter = i;
        if (i == 0) {
            Objects.onNotNull(this.handler, new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner$$ExternalSyntheticLambda1
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5544x64ba108a((Handler) obj);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$activityPaused$2$com-smaato-sdk-core-lifecycle-ProcessLifecycleOwner, reason: not valid java name */
    /* synthetic */ void m5544x64ba108a(Handler handler) {
        handler.postDelayed(this.delayedPauseRunnable, 700L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void activityStopped() {
        this.startedCounter--;
        dispatchStopIfNeeded();
    }

    private void dispatchPauseIfNeeded() {
        if (this.resumedCounter == 0) {
            this.pauseSent = true;
        }
    }

    private void dispatchStopIfNeeded() {
        if (this.startedCounter == 0 && this.pauseSent) {
            Objects.onNotNull(this.listener, new Consumer() { // from class: com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    ((ProcessLifecycleOwner.Listener) obj).onLastActivityStopped();
                }
            });
            this.stopSent = true;
        }
    }

    private void attach(Context context, Handler handler) {
        this.handler = handler;
        if (context.getApplicationContext() instanceof Application) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksAdapter() { // from class: com.smaato.sdk.core.lifecycle.ProcessLifecycleOwner.1
                @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    ProcessLifecycleOwner.this.activityStarted();
                }

                @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    ProcessLifecycleOwner.this.activityResumed();
                }

                @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    ProcessLifecycleOwner.this.activityPaused();
                }

                @Override // com.smaato.sdk.core.util.ActivityLifecycleCallbacksAdapter, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    ProcessLifecycleOwner.this.activityStopped();
                }
            });
        }
    }
}
