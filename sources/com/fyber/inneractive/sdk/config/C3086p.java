package com.fyber.inneractive.sdk.config;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.config.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3086p implements com.fyber.inneractive.sdk.network.E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3088s f1714a;

    public C3086p(C3088s c3088s) {
        this.f1714a = c3088s;
    }

    @Override // com.fyber.inneractive.sdk.network.E
    public final void a(Object obj, Exception exc, boolean z) {
        C3085o c3085o = (C3085o) obj;
        if (c3085o != null) {
            C3088s c3088s = this.f1714a;
            if (c3085o.equals(c3088s.b)) {
                return;
            }
            c3088s.d = true;
            c3088s.b = c3085o;
            com.fyber.inneractive.sdk.util.r.f2374a.execute(new RunnableC3087q(c3088s));
        }
    }
}
