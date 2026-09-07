package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* JADX INFO: loaded from: classes7.dex */
public abstract class X4 extends B5 {
    public X4(BaseRequestConfig.ComponentLoader<Object, Object, W5> componentLoader, Hl hl, BaseRequestConfig.BaseRequestArguments<F4, Object> baseRequestArguments) {
        super(componentLoader, hl, baseRequestArguments);
    }

    @Override // io.appmetrica.analytics.impl.B5
    public final void a(Object obj) {
        F4 f4 = (F4) obj;
        synchronized (this) {
            super.a((Object) f4);
        }
    }

    public final synchronized void a(F4 f4) {
        super.a((Object) f4);
    }
}
