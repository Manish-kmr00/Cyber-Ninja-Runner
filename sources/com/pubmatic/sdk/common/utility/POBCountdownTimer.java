package com.pubmatic.sdk.common.utility;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public abstract class POBCountdownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7630a;
    private final long b;
    private long c;
    private long d;
    private final Handler e;
    private b f = b.DEFAULT;

    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (POBCountdownTimer.this) {
                if (POBCountdownTimer.this.f != b.PAUSE) {
                    long j = POBCountdownTimer.this.c;
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    long seconds = j - timeUnit.toSeconds(SystemClock.elapsedRealtime());
                    if (seconds <= 0) {
                        b bVar = POBCountdownTimer.this.f;
                        b bVar2 = b.FINISH;
                        if (bVar != bVar2) {
                            POBCountdownTimer.this.onFinish();
                            POBCountdownTimer.this.f = bVar2;
                        }
                    } else if (seconds < POBCountdownTimer.this.b) {
                        sendMessageDelayed(obtainMessage(1), TimeUnit.SECONDS.toMillis(seconds));
                    } else {
                        long seconds2 = timeUnit.toSeconds(SystemClock.elapsedRealtime());
                        POBCountdownTimer.this.onTick(seconds);
                        long seconds3 = (seconds2 + POBCountdownTimer.this.b) - timeUnit.toSeconds(SystemClock.elapsedRealtime());
                        while (seconds3 < 0) {
                            seconds3 += POBCountdownTimer.this.b;
                        }
                        if (POBCountdownTimer.this.f != b.CANCEL && POBCountdownTimer.this.f != b.FINISH) {
                            sendMessageDelayed(obtainMessage(1), TimeUnit.SECONDS.toMillis(seconds3));
                        }
                    }
                }
            }
        }
    }

    private enum b {
        DEFAULT,
        START,
        PAUSE,
        CANCEL,
        FINISH
    }

    public POBCountdownTimer(long j, long j2, Looper looper) {
        this.f7630a = j;
        this.b = j2;
        this.e = new a(looper);
    }

    public final void cancel() {
        this.e.removeMessages(1);
        this.f = b.CANCEL;
    }

    public abstract void onFinish();

    public abstract void onTick(long j);

    public long pause() {
        if (this.f == b.START) {
            this.d = this.c - TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime());
            this.f = b.PAUSE;
        }
        return this.d;
    }

    public long resume() {
        if (this.f == b.PAUSE) {
            this.c = this.d + TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime());
            this.f = b.START;
            Handler handler = this.e;
            handler.sendMessage(handler.obtainMessage(1));
        }
        return this.d;
    }

    public final synchronized POBCountdownTimer start() {
        if (this.f7630a <= 0) {
            onFinish();
            this.f = b.FINISH;
            return this;
        }
        this.c = TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime()) + this.f7630a;
        this.d = 0L;
        Handler handler = this.e;
        handler.sendMessage(handler.obtainMessage(1));
        this.f = b.START;
        return this;
    }
}
