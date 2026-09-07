package com.five_corp.ad.internal;

import com.five_corp.ad.FiveAdInterface;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes10.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1593a;
    public final AtomicReference b = new AtomicReference(null);
    public final AtomicReference c = new AtomicReference(null);
    public final AtomicReference d = new AtomicReference(null);
    public final AtomicReference e = new AtomicReference(null);
    public final AtomicReference f = new AtomicReference(null);

    public y(FiveAdInterface fiveAdInterface) {
        this.f1593a = fiveAdInterface;
    }

    public final void a() {
        u uVar = (u) this.e.get();
        if (uVar != null) {
            uVar.c();
        }
    }

    public final void b() {
        u uVar = (u) this.e.get();
        if (uVar != null) {
            uVar.b();
        }
    }
}
