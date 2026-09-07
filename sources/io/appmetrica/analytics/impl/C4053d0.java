package io.appmetrica.analytics.impl;

import android.util.Pair;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C4053d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Lc f11504a;
    public long b;
    public boolean c;
    public final Tk d;

    public C4053d0(String str, long j, Tk tk) {
        this.b = j;
        try {
            this.f11504a = new Lc(str);
        } catch (Throwable unused) {
            this.f11504a = new Lc();
        }
        this.d = tk;
    }

    public final synchronized void a(Pair pair) {
        if (this.d.b(this.f11504a, (String) pair.first, (String) pair.second)) {
            this.c = true;
        }
    }

    public final synchronized String toString() {
        return "Map size " + this.f11504a.size() + ". Is changed " + this.c + ". Current revision " + this.b;
    }

    public final synchronized C4028c0 a() {
        if (this.c) {
            this.b++;
            this.c = false;
        }
        return new C4028c0(AbstractC4288mb.b(this.f11504a), this.b);
    }
}
