package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.web.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class RunnableC3283w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3284x f2425a;

    public RunnableC3283w(C3284x c3284x) {
        this.f2425a = c3284x;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2425a.f2426a.getClass();
        com.fyber.inneractive.sdk.util.r.b.post(new RunnableC3282v("Image failed to download."));
        this.f2425a.f2426a.a(com.fyber.inneractive.sdk.mraid.k.STORE_PICTURE, "Error downloading and saving image file.");
        IAlog.a("failed to download and save the image file.", new Object[0]);
    }
}
