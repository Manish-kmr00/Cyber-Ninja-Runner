package com.fyber.inneractive.sdk.player.exoplayer2.video;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements Choreographer.FrameCallback, Handler.Callback {
    public static final g e = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f2199a;
    public final Handler b;
    public Choreographer c;
    public int d;

    public g() {
        HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.b = handler;
        handler.sendEmptyMessage(0);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f2199a = j;
        this.c.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            this.c = Choreographer.getInstance();
            return true;
        }
        if (i == 1) {
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 == 1) {
                this.c.postFrameCallback(this);
            }
            return true;
        }
        if (i != 2) {
            return false;
        }
        int i3 = this.d - 1;
        this.d = i3;
        if (i3 == 0) {
            this.c.removeFrameCallback(this);
            this.f2199a = 0L;
        }
        return true;
    }
}
