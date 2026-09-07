package com.fyber.inneractive.sdk.player.mediaplayer;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f2220a;

    public g(p pVar) {
        this.f2220a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.b(this.f2220a);
        Handler handler = this.f2220a.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f2220a.o = null;
        }
        this.f2220a.n = null;
        Looper.myLooper().quit();
    }
}
