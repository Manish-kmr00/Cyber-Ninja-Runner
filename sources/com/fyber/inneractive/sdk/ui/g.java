package com.fyber.inneractive.sdk.ui;

import com.fyber.inneractive.sdk.web.C3274m;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAmraidWebViewController f2339a;

    public g(IAmraidWebViewController iAmraidWebViewController) {
        this.f2339a = iAmraidWebViewController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3274m c3274m = this.f2339a.b;
        if (c3274m != null) {
            try {
                c3274m.invalidate();
            } catch (Throwable unused) {
            }
        }
    }
}
