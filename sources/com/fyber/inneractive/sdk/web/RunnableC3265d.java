package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3265d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC3270i f2404a;

    public RunnableC3265d(j0 j0Var) {
        this.f2404a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC3270i abstractC3270i = this.f2404a;
        if (abstractC3270i.k) {
            IAlog.a("No user web action detected for : %s blocking.", abstractC3270i.l);
            AbstractC3270i abstractC3270i2 = this.f2404a;
            String strC = abstractC3270i2.l.c();
            String strA = this.f2404a.l.a();
            k0 k0Var = abstractC3270i2.g;
            if (k0Var != null) {
                k0Var.a(strC, strA);
            }
            IAlog.d("AD_AUTO_CLICK_DETECTED", new Object[0]);
            this.f2404a.l.b();
            this.f2404a.i();
        } else {
            IAlog.a("User web action detected for: %s", abstractC3270i.l);
            this.f2404a.l.d();
        }
        this.f2404a.l = null;
    }
}
