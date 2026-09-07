package com.five_corp.ad.internal.movie.partialcache.video;

import com.five_corp.ad.internal.movie.partialcache.v1;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f1503a = new ArrayDeque();
    public final ArrayDeque b = new ArrayDeque();
    public long c = 0;
    public long d = 0;
    public boolean e = false;
    public long f = 0;

    public final void a(v1 v1Var) {
        this.f1503a.addLast(v1Var);
        this.f = v1Var.d;
        if (v1Var.f) {
            this.e = true;
        }
    }

    public final v1 b() {
        v1 v1Var = (v1) this.f1503a.pollFirst();
        if (v1Var == null) {
            return null;
        }
        if (v1Var.e == 1) {
            this.d = v1Var.d;
        }
        this.b.addLast(v1Var);
        return v1Var;
    }

    public final void c() {
        while (!this.b.isEmpty()) {
            this.f1503a.addFirst((v1) this.b.pollLast());
        }
    }

    public final void a() {
        this.f1503a.clear();
        this.b.clear();
        this.c = 0L;
        this.d = 0L;
        this.e = false;
        this.f = 0L;
    }

    public final void a(long j) {
        long j2 = this.d;
        if (j2 == this.c || j2 > j) {
            return;
        }
        while (!this.b.isEmpty() && ((v1) this.b.peekFirst()).d < this.d) {
            this.b.pollFirst();
        }
        this.c = this.d;
    }
}
