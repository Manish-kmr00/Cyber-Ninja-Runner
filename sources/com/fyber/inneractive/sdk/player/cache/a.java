package com.fyber.inneractive.sdk.player.cache;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f1939a;

    public a(f fVar) {
        this.f1939a = fVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f1939a) {
            f fVar = this.f1939a;
            if (fVar.i == null) {
                return null;
            }
            fVar.d();
            f fVar2 = this.f1939a;
            int i = fVar2.k;
            if (i >= 2000 && i >= fVar2.j.size()) {
                this.f1939a.c();
                this.f1939a.k = 0;
            }
            return null;
        }
    }
}
