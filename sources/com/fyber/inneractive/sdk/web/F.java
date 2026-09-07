package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.mraid.AbstractC3122e;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;

/* JADX INFO: loaded from: classes13.dex */
public final class F implements InterfaceC3267f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC3122e f2386a;
    public final /* synthetic */ I b;

    public F(I i, AbstractC3122e abstractC3122e) {
        this.b = i;
        this.f2386a = abstractC3122e;
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3267f
    public final String a() {
        return this.f2386a.c();
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3267f
    public final void b() {
        AbstractC3122e abstractC3122e = this.f2386a;
        if (abstractC3122e != null) {
            abstractC3122e.d();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3267f
    public final String c() {
        return this.f2386a.f1899a;
    }

    @Override // com.fyber.inneractive.sdk.web.InterfaceC3267f
    public final void d() {
        IAmraidWebViewController iAmraidWebViewController = (IAmraidWebViewController) this.b;
        if (iAmraidWebViewController.I != null) {
            iAmraidWebViewController.I.a();
        }
        this.f2386a.a();
    }

    public final String toString() {
        return "action = " + this.f2386a.f1899a + " url = " + this.f2386a.c();
    }
}
