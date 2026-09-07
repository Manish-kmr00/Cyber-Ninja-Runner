package com.smaato.sdk.core.appbgdetection;

import android.os.Handler;
import android.os.SystemClock;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;

/* JADX INFO: loaded from: classes13.dex */
public class PausableAction implements Runnable {
    private final Handler handler;
    public final String name;
    private final PauseUnpauseListener pauseUnpauseListener;
    private long pausedAt = 0;
    private long remainingDelay;
    private final Runnable runnable;
    private long startedAt;

    PausableAction(String str, Handler handler, Runnable runnable, long j, PauseUnpauseListener pauseUnpauseListener) {
        this.name = (String) Objects.requireNonNull(str);
        this.handler = (Handler) Objects.requireNonNull(handler);
        this.runnable = (Runnable) Objects.requireNonNull(runnable);
        if (j <= 0) {
            throw new IllegalArgumentException("delay must be positive for " + getClass().getSimpleName() + "::new");
        }
        this.remainingDelay = j;
        this.pauseUnpauseListener = pauseUnpauseListener;
        this.startedAt = SystemClock.uptimeMillis();
    }

    @Override // java.lang.Runnable
    public void run() {
        Threads.ensureHandlerThread(this.handler);
        this.runnable.run();
    }

    boolean isPaused() {
        Threads.ensureHandlerThread(this.handler);
        return this.pausedAt > 0;
    }

    void pause() {
        Threads.ensureHandlerThread(this.handler);
        if (isPaused()) {
            throw new RuntimeException("unexpected pause call - action has been already paused");
        }
        this.handler.removeCallbacks(this);
        long jUptimeMillis = SystemClock.uptimeMillis();
        this.pausedAt = jUptimeMillis;
        this.remainingDelay -= jUptimeMillis - this.startedAt;
        PauseUnpauseListener pauseUnpauseListener = this.pauseUnpauseListener;
        if (pauseUnpauseListener != null) {
            pauseUnpauseListener.onActionPaused();
        }
    }

    void unpause() {
        Threads.ensureHandlerThread(this.handler);
        if (!isPaused()) {
            throw new RuntimeException("unexpected unpause call - action has not been paused");
        }
        this.pausedAt = 0L;
        this.startedAt = SystemClock.uptimeMillis();
        PauseUnpauseListener pauseUnpauseListener = this.pauseUnpauseListener;
        if (pauseUnpauseListener != null) {
            pauseUnpauseListener.onBeforeActionUnpaused();
        }
        this.handler.postDelayed(this, this.remainingDelay);
    }
}
