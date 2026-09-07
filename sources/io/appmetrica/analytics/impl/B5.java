package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ArgumentsMerger;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* JADX INFO: loaded from: classes13.dex */
public abstract class B5 implements Ti {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseRequestConfig f11071a;
    public final BaseRequestConfig.RequestConfigLoader b;
    public W5 c;

    public B5(BaseRequestConfig.RequestConfigLoader<Object, W5> requestConfigLoader, Hl hl, ArgumentsMerger<Object, Object> argumentsMerger) {
        this.b = requestConfigLoader;
        C4486ua.j().u().a(this);
        a(new W5(hl, C4486ua.j().u(), C4486ua.j().r(), argumentsMerger));
    }

    public final synchronized void a(W5 w5) {
        this.c = w5;
    }

    public final synchronized ArgumentsMerger<Object, Object> b() {
        return (ArgumentsMerger) this.c.componentArguments;
    }

    public final synchronized Hl c() {
        return this.c.f11402a;
    }

    public final void d() {
        synchronized (this) {
            this.f11071a = null;
        }
    }

    public final synchronized void e() {
        this.f11071a = null;
    }

    public synchronized void a(Object obj) {
        if (!((ArgumentsMerger) this.c.componentArguments).compareWithOtherArguments(obj)) {
            a(new W5(c(), C4486ua.E.u(), C4486ua.E.r(), (ArgumentsMerger) ((ArgumentsMerger) this.c.componentArguments).mergeFrom(obj)));
            e();
        }
    }

    public final synchronized void a(Hl hl) {
        a(new W5(hl, C4486ua.E.u(), C4486ua.E.r(), b()));
        e();
    }

    public final synchronized BaseRequestConfig a() {
        if (this.f11071a == null) {
            this.f11071a = this.b.load(this.c);
        }
        return this.f11071a;
    }
}
