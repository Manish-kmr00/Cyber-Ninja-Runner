package net.pubnative.lite.sdk.vpaid.helpers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes7.dex */
public abstract class TimerWithPause {
    private static final int MSG = 1;
    private final long mCountdownInterval;
    private long mMillisInFuture;
    private long mPauseTimeRemaining;
    private long mStopTimeInFuture;
    private final long mTotalCountdown;
    private final Handler mHandler = new Handler(Looper.myLooper()) { // from class: net.pubnative.lite.sdk.vpaid.helpers.TimerWithPause.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            TimerWithPause.this.handleTimerMessage();
        }
    };
    private final boolean mRunAtStart = true;

    public abstract void onFinish();

    public abstract void onTick(long j);

    protected TimerWithPause(long j, long j2) {
        this.mMillisInFuture = j;
        this.mTotalCountdown = j;
        this.mCountdownInterval = j2;
    }

    public final void cancel() {
        this.mHandler.removeMessages(1);
    }

    public final synchronized TimerWithPause create() {
        long j = this.mMillisInFuture;
        if (j <= 0) {
            onFinish();
        } else {
            this.mPauseTimeRemaining = j;
        }
        if (this.mRunAtStart) {
            resume();
        }
        return this;
    }

    public void pause() {
        if (isRunning()) {
            this.mPauseTimeRemaining = timeLeft();
            cancel();
        }
    }

    public void resume() {
        if (isPaused()) {
            this.mMillisInFuture = this.mPauseTimeRemaining;
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1));
            this.mPauseTimeRemaining = 0L;
        }
    }

    public boolean isPaused() {
        return this.mPauseTimeRemaining > 0;
    }

    public boolean isRunning() {
        return !isPaused();
    }

    public long timeLeft() {
        if (isPaused()) {
            return this.mPauseTimeRemaining;
        }
        long jElapsedRealtime = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
        if (jElapsedRealtime < 0) {
            return 0L;
        }
        return jElapsedRealtime;
    }

    public long totalCountdown() {
        return this.mTotalCountdown;
    }

    public long timePassed() {
        return this.mTotalCountdown - timeLeft();
    }

    public boolean hasBeenStarted() {
        return this.mPauseTimeRemaining <= this.mMillisInFuture;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void handleTimerMessage() {
        long jTimeLeft = timeLeft();
        if (jTimeLeft <= 0) {
            cancel();
            onFinish();
        } else if (jTimeLeft < this.mCountdownInterval) {
            Handler handler = this.mHandler;
            handler.sendMessageDelayed(handler.obtainMessage(1), jTimeLeft);
        } else {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            onTick(jTimeLeft);
            long jElapsedRealtime2 = this.mCountdownInterval - (SystemClock.elapsedRealtime() - jElapsedRealtime);
            while (jElapsedRealtime2 < 0) {
                jElapsedRealtime2 += this.mCountdownInterval;
            }
            Handler handler2 = this.mHandler;
            handler2.sendMessageDelayed(handler2.obtainMessage(1), jElapsedRealtime2);
        }
    }
}
