package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.EnumC3243g;
import com.fyber.inneractive.sdk.web.W;

/* JADX INFO: loaded from: classes10.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdRequest f1840a;
    public com.fyber.inneractive.sdk.response.e b;
    public final com.fyber.inneractive.sdk.config.global.r c;
    public final com.fyber.inneractive.sdk.config.U d;
    public boolean e = false;
    public boolean f = false;

    public x(com.fyber.inneractive.sdk.config.U u, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.d = u;
        this.c = rVar;
    }

    public abstract void a();

    public void a(String str) {
    }

    public boolean a(boolean z, EnumC3243g enumC3243g) {
        return false;
    }

    public W b() {
        return null;
    }

    public com.fyber.inneractive.sdk.response.e c() {
        return this.b;
    }

    public abstract boolean d();

    public boolean e() {
        return false;
    }

    public abstract boolean f();

    public void g() {
    }

    public abstract boolean isVideoAd();
}
