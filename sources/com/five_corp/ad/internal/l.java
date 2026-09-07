package com.five_corp.ad.internal;

/* JADX INFO: loaded from: classes10.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1413a = new Object();
    public o b = null;

    public final boolean a() {
        boolean z;
        synchronized (this.f1413a) {
            z = this.b == null;
        }
        return z;
    }

    public final void a(o oVar) {
        oVar.b();
        synchronized (this.f1413a) {
            this.b = oVar;
        }
    }
}
