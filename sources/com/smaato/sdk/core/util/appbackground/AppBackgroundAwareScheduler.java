package com.smaato.sdk.core.util.appbackground;

import android.os.Handler;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.diinjection.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class AppBackgroundAwareScheduler implements AppBackgroundDetector.Listener {

    @Inject
    private static AppBackgroundDetector appBackgroundDetector;
    private boolean appInBackgroundAtLastCheck;
    private final Handler handler = Threads.newUiHandler();
    private long lastCheckTimeMs;
    private long remainingDelayTimeMs;
    private Runnable scheduledHandlerTask;
    private final Runnable scheduledTask;

    public AppBackgroundAwareScheduler(Runnable runnable) {
        this.scheduledTask = runnable;
        AndroidsInjector.injectStatic(AppBackgroundAwareScheduler.class);
    }

    @Override // com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.Listener
    public void onAppEnteredInBackground() {
        checkpoint();
    }

    @Override // com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.Listener
    public void onAppEnteredInForeground() {
        checkpoint();
    }

    public void schedule(long j) {
        this.lastCheckTimeMs = System.currentTimeMillis();
        this.remainingDelayTimeMs = j;
        this.appInBackgroundAtLastCheck = appBackgroundDetector.isAppInBackground();
        postScheduledTaskWithRemainingDelay();
        appBackgroundDetector.addListener(this, false);
    }

    public synchronized void cancel() {
        cancelTaskScheduling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void checkpoint() {
        boolean zIsAppInBackground = appBackgroundDetector.isAppInBackground();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zIsAppInBackground) {
            cancelPost();
        }
        if (!this.appInBackgroundAtLastCheck) {
            long j = this.remainingDelayTimeMs - (jCurrentTimeMillis - this.lastCheckTimeMs);
            this.remainingDelayTimeMs = j;
            if (j <= 0) {
                runScheduledTask();
                return;
            }
        }
        this.lastCheckTimeMs = jCurrentTimeMillis;
        if (!zIsAppInBackground && this.scheduledHandlerTask == null) {
            postScheduledTaskWithRemainingDelay();
        }
    }

    private void postScheduledTaskWithRemainingDelay() {
        Runnable runnable = new Runnable() { // from class: com.smaato.sdk.core.util.appbackground.AppBackgroundAwareScheduler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.checkpoint();
            }
        };
        this.scheduledHandlerTask = runnable;
        this.handler.postDelayed(runnable, this.remainingDelayTimeMs);
    }

    private void runScheduledTask() {
        cancelTaskScheduling();
        this.scheduledTask.run();
    }

    private void cancelTaskScheduling() {
        appBackgroundDetector.deleteListener(this);
        cancelPost();
    }

    private void cancelPost() {
        Runnable runnable = this.scheduledHandlerTask;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
            this.scheduledHandlerTask = null;
        }
    }
}
