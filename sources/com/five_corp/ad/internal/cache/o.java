package com.five_corp.ad.internal.cache;

import android.os.Handler;
import com.five_corp.ad.internal.movie.partialcache.C3000e;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class o {
    public final Handler b;
    public final com.five_corp.ad.internal.storage.a c;
    public final com.five_corp.ad.internal.storage.a d;
    public boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1347a = new Object();
    public boolean f = false;
    public ArrayList g = new ArrayList();
    public i h = null;
    public WeakReference i = null;

    public o(Handler handler, com.five_corp.ad.internal.storage.a aVar, com.five_corp.ad.internal.storage.a aVar2, boolean z) {
        this.b = handler;
        this.c = aVar;
        this.d = aVar2;
        this.e = z;
    }

    public final void a() {
        synchronized (this.f1347a) {
            if (this.f) {
                return;
            }
            this.f = true;
            this.b.post(new l(this));
        }
    }

    public final com.five_corp.ad.internal.util.f b() {
        synchronized (this.f1347a) {
            if (this.f) {
                return new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.X5, null, null, null), null);
            }
            com.five_corp.ad.internal.storage.a aVar = this.c;
            com.five_corp.ad.internal.util.f fVarB = aVar.f1525a.b(aVar.b);
            if (fVarB.f1560a) {
                return ((Boolean) fVarB.c).booleanValue() ? aVar.f1525a.c(aVar.b) : new com.five_corp.ad.internal.util.f(true, null, 0);
            }
            return new com.five_corp.ad.internal.util.f(false, fVarB.b, null);
        }
    }

    public final String c() {
        com.five_corp.ad.internal.storage.a aVar = this.c;
        com.five_corp.ad.internal.storage.b bVar = aVar.f1525a;
        String str = aVar.b;
        bVar.getClass();
        return new File(bVar.f1526a, str).getAbsolutePath();
    }

    public final boolean d() {
        boolean z;
        synchronized (this.f1347a) {
            z = !this.f && this.e;
        }
        return z;
    }

    public final com.five_corp.ad.internal.util.g e() {
        synchronized (this.f1347a) {
            if (this.f) {
                return new com.five_corp.ad.internal.util.g(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.Y5, null, null, null));
            }
            com.five_corp.ad.internal.storage.a aVar = this.c;
            return aVar.f1525a.d(aVar.b);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        return ((o) obj).c.b.equals(this.c.b);
    }

    public final int hashCode() {
        return this.c.b.hashCode();
    }

    public final com.five_corp.ad.internal.util.f a(int i, C3000e c3000e) {
        synchronized (this.f1347a) {
            if (this.f) {
                return new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.R5, null, null, null), null);
            }
            WeakReference weakReference = this.i;
            com.five_corp.ad.internal.storage.o oVar = weakReference != null ? (com.five_corp.ad.internal.storage.o) weakReference.get() : null;
            if (oVar != null) {
                oVar.d.post(new com.five_corp.ad.internal.storage.l(oVar));
            }
            com.five_corp.ad.internal.storage.a aVar = this.c;
            return new com.five_corp.ad.internal.util.f(true, null, new com.five_corp.ad.internal.storage.i(i, aVar.b, aVar.f1525a, this.b, c3000e));
        }
    }

    public final com.five_corp.ad.internal.util.f a(int i, com.five_corp.ad.internal.storage.n nVar) {
        com.five_corp.ad.internal.storage.a aVar = this.c;
        com.five_corp.ad.internal.storage.o oVar = new com.five_corp.ad.internal.storage.o(i, aVar.b, aVar.f1525a, this.b, nVar, aVar.c);
        synchronized (this.f1347a) {
            if (this.f) {
                return new com.five_corp.ad.internal.util.f(false, new com.five_corp.ad.internal.o(com.five_corp.ad.internal.p.S5, null, null, null), null);
            }
            this.i = new WeakReference(oVar);
            return new com.five_corp.ad.internal.util.f(true, null, oVar);
        }
    }

    public final void a(m mVar) {
        synchronized (this.f1347a) {
            this.g.add(mVar);
            if (this.e || this.f) {
                this.b.post(new k(this));
            }
        }
    }
}
