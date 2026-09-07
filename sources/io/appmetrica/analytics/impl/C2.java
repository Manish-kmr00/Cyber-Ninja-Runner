package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes13.dex */
public final class C2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f11081a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ D2 c;

    public C2(D2 d2, Context context, Intent intent) {
        this.c = d2;
        this.f11081a = context;
        this.b = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f11098a.consume(this.f11081a, this.b);
    }
}
