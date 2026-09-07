package com.digitalturbine.ignite.authenticator;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IgniteManager f1222a;

    public a(IgniteManager igniteManager) {
        this.f1222a = igniteManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1222a.f1221a.b();
    }
}
