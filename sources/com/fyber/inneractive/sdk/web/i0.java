package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes12.dex */
public final class i0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f2413a;

    public i0(j0 j0Var) {
        this.f2413a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3274m c3274m = this.f2413a.b;
        if (c3274m != null) {
            c3274m.a("if (FyberMraidVideoController.getCurrentTime() < 0.2) { var ifr = document.createElement('iframe'); var container = document.body || document.documentElement; container.appendChild(ifr); ifr.setAttribute('sandbox', ''); ifr.setAttribute('style', 'position: fixed; bottom: -20px; border: none; visibility: hidden; height: 20px; z-index: -99999'); ifr.setAttribute('src','FyMraidVideo://fyMraidVideoAdPlaybackFailure'); console.log('dispatched closure event'); } else { console.log('video has progressed'); };");
        }
    }
}
