package com.five_corp.ad.internal.movie;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes5.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f1512a;

    public v(x xVar) {
        this.f1512a = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f1512a;
        if (xVar.q != null) {
            if (SystemClock.uptimeMillis() > xVar.p) {
                xVar.a(new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.B0, null, null, null));
            } else {
                xVar.n.postAtTime(new v(xVar), xVar.q, SystemClock.uptimeMillis() + 500);
            }
        }
    }
}
