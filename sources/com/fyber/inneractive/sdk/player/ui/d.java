package com.fyber.inneractive.sdk.player.ui;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2234a;
    public final /* synthetic */ e b;

    public d(e eVar, boolean z) {
        this.b = eVar;
        this.f2234a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2234a == this.b.hasWindowFocus()) {
            this.b.d();
        }
    }
}
