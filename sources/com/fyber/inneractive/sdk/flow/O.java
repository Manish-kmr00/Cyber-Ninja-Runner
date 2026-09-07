package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.web.W;

/* JADX INFO: loaded from: classes10.dex */
public final class O extends w {
    public IAmraidWebViewController i;

    public O(com.fyber.inneractive.sdk.config.U u, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(u, rVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void a() {
        if (this.g != null && d()) {
            W w = this.g;
            w.y = true;
            w.D = false;
            w.b.h.remove(w);
            w.i = null;
            IAlog.a("destroy internalStoreWebpageController", new Object[0]);
            this.g = null;
        }
        IAmraidWebViewController iAmraidWebViewController = this.i;
        if (iAmraidWebViewController != null) {
            com.fyber.inneractive.sdk.measurement.tracker.f fVar = iAmraidWebViewController.I;
            if (fVar != null) {
                fVar.a(false);
            }
            this.i.e();
            this.i = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean d() {
        com.fyber.inneractive.sdk.config.U u = this.d;
        if (u == null) {
            return false;
        }
        com.fyber.inneractive.sdk.config.T t = (com.fyber.inneractive.sdk.config.T) u;
        if (t.c == null || t.c.b == null) {
            return false;
        }
        return t.c.b.isFullscreenUnit();
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean f() {
        IAmraidWebViewController iAmraidWebViewController = this.i;
        return (iAmraidWebViewController == null || iAmraidWebViewController.b == null) ? false : true;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public boolean isVideoAd() {
        return false;
    }
}
