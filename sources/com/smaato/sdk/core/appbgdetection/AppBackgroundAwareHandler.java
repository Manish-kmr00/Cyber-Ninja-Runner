package com.smaato.sdk.core.appbgdetection;

import android.os.Handler;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.appbackground.AppBackgroundDetector;

/* JADX INFO: loaded from: classes7.dex */
public class AppBackgroundAwareHandler {
    private PausableAction action;
    private final AppBackgroundDetector appBackgroundDetector;
    private final AppBackgroundDetector.Listener appBackgroundDetectorListener = new AnonymousClass1();
    private final Handler handler;
    private Logger logger;

    /* JADX INFO: renamed from: com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler$1, reason: invalid class name */
    class AnonymousClass1 implements AppBackgroundDetector.Listener {
        AnonymousClass1() {
        }

        /* JADX INFO: renamed from: lambda$onAppEnteredInBackground$0$com-smaato-sdk-core-appbgdetection-AppBackgroundAwareHandler$1, reason: not valid java name */
        /* synthetic */ void m5512x9235997c() {
            AppBackgroundAwareHandler.this.pauseAction();
        }

        @Override // com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.Listener
        public void onAppEnteredInBackground() {
            Threads.ensureInvokedOnHandlerThread(AppBackgroundAwareHandler.this.handler, new Runnable() { // from class: com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5512x9235997c();
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAppEnteredInForeground$1$com-smaato-sdk-core-appbgdetection-AppBackgroundAwareHandler$1, reason: not valid java name */
        /* synthetic */ void m5513xed6f33e6() {
            AppBackgroundAwareHandler.this.unpauseAction();
        }

        @Override // com.smaato.sdk.core.util.appbackground.AppBackgroundDetector.Listener
        public void onAppEnteredInForeground() {
            Threads.ensureInvokedOnHandlerThread(AppBackgroundAwareHandler.this.handler, new Runnable() { // from class: com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5513xed6f33e6();
                }
            });
        }
    }

    public AppBackgroundAwareHandler(Logger logger, Handler handler, AppBackgroundDetector appBackgroundDetector) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.handler = (Handler) Objects.requireNonNull(handler);
        this.appBackgroundDetector = (AppBackgroundDetector) Objects.requireNonNull(appBackgroundDetector);
    }

    public void postDelayed(final String str, final Runnable runnable, final long j, final PauseUnpauseListener pauseUnpauseListener) {
        Objects.requireNonNull(str);
        if (j <= 0) {
            throw new IllegalArgumentException("delay must be positive for " + getClass().getSimpleName() + "::postDelayed");
        }
        Objects.requireNonNull(runnable);
        Threads.ensureInvokedOnHandlerThread(this.handler, new Runnable() { // from class: com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5510x11115bcf(str, runnable, j, pauseUnpauseListener);
            }
        });
    }

    public void stop() {
        Threads.ensureInvokedOnHandlerThread(this.handler, new Runnable() { // from class: com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.stopAction();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startAction, reason: merged with bridge method [inline-methods] */
    public void m5510x11115bcf(String str, final Runnable runnable, long j, PauseUnpauseListener pauseUnpauseListener) {
        Threads.ensureHandlerThread(this.handler);
        PausableAction pausableAction = this.action;
        if (pausableAction != null) {
            this.handler.removeCallbacks(pausableAction);
            this.appBackgroundDetector.deleteListener(this.appBackgroundDetectorListener);
            this.action = null;
        }
        PausableAction pausableAction2 = new PausableAction(str, this.handler, new Runnable() { // from class: com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5511xc8aab018(runnable);
            }
        }, j, pauseUnpauseListener);
        this.action = pausableAction2;
        this.handler.postDelayed(pausableAction2, j);
        this.appBackgroundDetector.addListener(this.appBackgroundDetectorListener, true);
    }

    /* JADX INFO: renamed from: lambda$startAction$1$com-smaato-sdk-core-appbgdetection-AppBackgroundAwareHandler, reason: not valid java name */
    /* synthetic */ void m5511xc8aab018(Runnable runnable) {
        this.action = null;
        this.appBackgroundDetector.deleteListener(this.appBackgroundDetectorListener);
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseAction() {
        Threads.ensureHandlerThread(this.handler);
        PausableAction pausableAction = this.action;
        if (pausableAction == null || pausableAction.isPaused()) {
            return;
        }
        this.action.pause();
        this.logger.info(LogDomain.CORE, "paused %s", this.action.name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unpauseAction() {
        Threads.ensureHandlerThread(this.handler);
        PausableAction pausableAction = this.action;
        if (pausableAction == null || !pausableAction.isPaused()) {
            return;
        }
        this.action.unpause();
        this.logger.info(LogDomain.CORE, "resumed %s", this.action.name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopAction() {
        Threads.ensureHandlerThread(this.handler);
        if (this.action != null) {
            this.appBackgroundDetector.deleteListener(this.appBackgroundDetectorListener);
            this.handler.removeCallbacks(this.action);
            this.action = null;
        }
    }
}
