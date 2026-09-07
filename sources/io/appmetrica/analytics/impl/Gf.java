package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public final class Gf implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f11163a;
    public final Function b;
    public final Consumer c;
    public final Consumer d;

    public Gf(File file, Function function, Consumer consumer, Consumer consumer2) {
        this.f11163a = file;
        this.b = function;
        this.c = consumer;
        this.d = consumer2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11163a.exists()) {
            try {
                Object objApply = this.b.apply(this.f11163a);
                if (objApply != null) {
                    this.d.consume(objApply);
                }
            } catch (Throwable unused) {
            }
            this.c.consume(this.f11163a);
        }
    }
}
