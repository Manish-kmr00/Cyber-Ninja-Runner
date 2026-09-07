package com.five_corp.ad.internal.time;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes10.dex */
public final class c {
    public final a b;
    public final long c;
    public b f;
    public final Object e = new Object();
    public boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f1551a = new Handler(Looper.getMainLooper());
    public final long d = 1000;

    public c(a aVar, long j, b bVar) {
        this.b = aVar;
        this.c = System.currentTimeMillis() + j;
        this.f = bVar;
    }

    public final void a() {
        long j = this.c;
        this.b.getClass();
        if (j >= System.currentTimeMillis()) {
            synchronized (this.e) {
                if (this.f == null) {
                    return;
                }
                c();
                return;
            }
        }
        synchronized (this.e) {
            b bVar = this.f;
            if (bVar == null) {
                return;
            }
            this.f = null;
            this.g = true;
            bVar.a();
        }
    }

    public final boolean b() {
        synchronized (this.e) {
            if (this.g) {
                return false;
            }
            this.f = null;
            return true;
        }
    }

    public final void c() {
        this.f1551a.postDelayed(new Runnable() { // from class: com.five_corp.ad.internal.time.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        }, this.d);
    }
}
