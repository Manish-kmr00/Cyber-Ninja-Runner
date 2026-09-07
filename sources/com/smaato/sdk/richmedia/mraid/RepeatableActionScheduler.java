package com.smaato.sdk.richmedia.mraid;

import com.smaato.sdk.core.appbgdetection.AppBackgroundAwareHandler;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class RepeatableActionScheduler {
    private final Runnable actionDecorator = new AnonymousClass1();
    private final AtomicReference actionRef = new AtomicReference();
    private final AppBackgroundAwareHandler appBackgroundAwareHandler;
    private final long delayMillis;
    private final Logger logger;

    /* JADX INFO: renamed from: com.smaato.sdk.richmedia.mraid.RepeatableActionScheduler$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Objects.onNotNull((Runnable) RepeatableActionScheduler.this.actionRef.get(), new Consumer() { // from class: com.smaato.sdk.richmedia.mraid.RepeatableActionScheduler$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5650x3d1cd28d((Runnable) obj);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$run$0$com-smaato-sdk-richmedia-mraid-RepeatableActionScheduler$1, reason: not valid java name */
        /* synthetic */ void m5650x3d1cd28d(Runnable runnable) {
            runnable.run();
            RepeatableActionScheduler.this.schedule();
        }
    }

    RepeatableActionScheduler(Logger logger, AppBackgroundAwareHandler appBackgroundAwareHandler, long j) {
        this.logger = (Logger) Objects.requireNonNull(logger);
        this.appBackgroundAwareHandler = (AppBackgroundAwareHandler) Objects.requireNonNull(appBackgroundAwareHandler);
        if (j <= 0) {
            throw new IllegalArgumentException("delay must be positive for RepeatableActionScheduler::new");
        }
        this.delayMillis = j;
    }

    public void start(Runnable runnable) {
        if (isScheduled()) {
            return;
        }
        if (runnable == null) {
            this.logger.info(LogDomain.MRAID, "No action to schedule", new Object[0]);
        } else {
            this.actionRef.set(runnable);
            schedule();
        }
    }

    private boolean isScheduled() {
        return this.actionRef.get() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedule() {
        this.appBackgroundAwareHandler.postDelayed("Repeatable action timer", this.actionDecorator, this.delayMillis, null);
    }

    public void stop() {
        this.appBackgroundAwareHandler.stop();
        this.actionRef.set(null);
    }
}
