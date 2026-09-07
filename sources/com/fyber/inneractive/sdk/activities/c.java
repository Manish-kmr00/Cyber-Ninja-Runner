package com.fyber.inneractive.sdk.activities;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveFullscreenAdActivity f1606a;

    public c(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f1606a = inneractiveFullscreenAdActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1606a.isFinishing()) {
            return;
        }
        this.f1606a.hideNavigationBar();
    }
}
