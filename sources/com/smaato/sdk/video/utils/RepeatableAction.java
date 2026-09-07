package com.smaato.sdk.video.utils;

import android.os.Handler;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;

/* JADX INFO: loaded from: classes8.dex */
public class RepeatableAction implements Runnable {
    private final Handler handler;
    private final Listener listener;
    private boolean scheduled;
    private final long throttleMillis;

    @FunctionalInterface
    public interface Listener {
        void doAction();
    }

    private RepeatableAction(Handler handler, long j, Listener listener) {
        this.handler = (Handler) Objects.requireNonNull(handler);
        this.throttleMillis = j;
        this.listener = (Listener) Objects.requireNonNull(listener);
    }

    public RepeatableAction(Handler handler, Listener listener) {
        this(handler, 50L, listener);
    }

    public void start() {
        Threads.ensureHandlerThread(this.handler);
        if (this.scheduled) {
            return;
        }
        this.handler.postDelayed(this, this.throttleMillis);
        this.scheduled = true;
    }

    public void stop() {
        Threads.ensureHandlerThread(this.handler);
        if (this.scheduled) {
            this.handler.removeCallbacks(this);
            this.scheduled = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Threads.ensureHandlerThread(this.handler);
        this.scheduled = false;
        start();
        this.listener.doAction();
    }
}
