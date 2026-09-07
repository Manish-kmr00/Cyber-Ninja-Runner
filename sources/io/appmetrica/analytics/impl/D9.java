package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes13.dex */
public final class D9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantLock f11102a;
    public final C4113fa b;

    public D9(Context context, String str) {
        this(new ReentrantLock(), new C4113fa(context, str));
    }

    public final void a() {
        this.f11102a.lock();
        this.b.a();
    }

    public final void b() {
        this.b.b();
        this.f11102a.unlock();
    }

    public final void c() {
        C4113fa c4113fa = this.b;
        synchronized (c4113fa) {
            c4113fa.b();
            c4113fa.f11548a.delete();
        }
        this.f11102a.unlock();
    }

    public D9(ReentrantLock reentrantLock, C4113fa c4113fa) {
        this.f11102a = reentrantLock;
        this.b = c4113fa;
    }
}
