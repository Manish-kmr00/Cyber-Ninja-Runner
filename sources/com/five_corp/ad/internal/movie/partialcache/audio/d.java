package com.five_corp.ad.internal.movie.partialcache.audio;

import com.five_corp.ad.internal.movie.partialcache.v1;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f1468a = new ArrayDeque();
    public final ArrayDeque b = new ArrayDeque();
    public boolean d = false;
    public long e = 0;
    public boolean c = true;

    public final void a(v1 v1Var) {
        this.f1468a.addLast(v1Var);
        this.e = v1Var.d;
        if (v1Var.f) {
            this.d = true;
        }
    }

    public final v1 b() {
        v1 v1Var = (v1) this.f1468a.pollFirst();
        if (v1Var != null) {
            this.b.addLast(v1Var);
        }
        return v1Var;
    }

    public final void a() {
        this.f1468a.clear();
        this.b.clear();
        this.d = false;
        this.e = 0L;
    }

    public final long b(long j) {
        while (!this.b.isEmpty() && j <= ((v1) this.b.peekLast()).d) {
            this.f1468a.addFirst((v1) this.b.pollLast());
        }
        this.b.clear();
        return !this.f1468a.isEmpty() ? ((v1) this.f1468a.peekFirst()).d : j;
    }

    public final void a(long j) {
        Iterator it = this.b.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext() && ((v1) it.next()).d < j) {
            i2++;
        }
        if (i2 != this.b.size()) {
            while (true) {
                i2--;
                if (i2 <= 0) {
                    return;
                } else {
                    this.b.pollFirst();
                }
            }
        } else {
            Iterator it2 = this.f1468a.iterator();
            while (it2.hasNext() && ((v1) it2.next()).d < j) {
                i++;
            }
            if (i == this.f1468a.size()) {
                this.b.clear();
                this.f1468a.clear();
            } else if (i == 0) {
                while (this.b.size() > 1) {
                    this.b.pollFirst();
                }
            } else {
                this.b.clear();
                while (true) {
                    i--;
                    if (i <= 0) {
                        return;
                    } else {
                        this.f1468a.pollFirst();
                    }
                }
            }
        }
    }
}
