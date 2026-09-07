package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.cl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4049cl implements V2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11499a;

    public C4049cl(Context context) {
        this.f11499a = context;
    }

    @Override // io.appmetrica.analytics.impl.V2, io.appmetrica.analytics.impl.Ml
    public final void a(Hl hl) {
    }

    public final Context b() {
        return this.f11499a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
