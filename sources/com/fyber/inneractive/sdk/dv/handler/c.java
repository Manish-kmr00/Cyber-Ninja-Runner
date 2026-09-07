package com.fyber.inneractive.sdk.dv.handler;

import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdFormat f1736a;
    public final /* synthetic */ e b;

    public c(e eVar, AdFormat adFormat) {
        this.b = eVar;
        this.f1736a = adFormat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            QueryInfo.generate(AbstractC3251o.f2370a, this.f1736a, e.a(this.b), new b(this));
        } catch (Throwable th) {
            IAlog.a("Error in resolveDVTokens", th, new Object[0]);
        }
    }
}
