package com.fyber.inneractive.sdk.config;

/* JADX INFO: loaded from: classes13.dex */
public final class E implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f1669a;

    public E(IAConfigManager iAConfigManager) {
        this.f1669a = iAConfigManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAConfigManager iAConfigManager = this.f1669a;
        if (iAConfigManager.p == null) {
            iAConfigManager.p = AbstractC3080j.a(iAConfigManager.f);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new D(this));
    }
}
