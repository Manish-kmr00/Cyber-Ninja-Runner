package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.controller.B;
import com.fyber.inneractive.sdk.player.controller.C3155f;
import java.io.IOException;

/* JADX INFO: loaded from: classes14.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOException f2130a;
    public final /* synthetic */ p b;

    public l(p pVar, IOException iOException) {
        this.b = pVar;
        this.f2130a = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B b = this.b.e;
        IOException iOException = this.f2130a;
        if (((C3155f) b.f1949a.get()) != null) {
            iOException.getCause();
        }
    }
}
