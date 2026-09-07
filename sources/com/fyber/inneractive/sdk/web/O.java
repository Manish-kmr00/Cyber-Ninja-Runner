package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class O implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2391a;
    public final /* synthetic */ W b;

    public O(W w, String str) {
        this.b = w;
        this.f2391a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("injecting JS: %s", this.f2391a);
        try {
            String str = this.f2391a;
            if (str != null) {
                com.fyber.inneractive.sdk.util.Q.a(this.b.f2397a, str);
            }
        } catch (Exception unused) {
            IAlog.a("Failed to inject JS", new Object[0]);
        }
    }
}
