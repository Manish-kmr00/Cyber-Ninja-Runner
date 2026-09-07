package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.h;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* JADX INFO: compiled from: StreamAllocation.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    static final /* synthetic */ boolean o = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.mbridge.msdk.thrid.okhttp.a f5522a;
    private f.a b;
    private a0 c;
    private final h d;
    public final com.mbridge.msdk.thrid.okhttp.d e;
    public final n f;
    private final Object g;
    private final f h;
    private int i;
    private c j;
    private boolean k;
    private boolean l;
    private boolean m;
    private com.mbridge.msdk.thrid.okhttp.internal.http.c n;

    /* JADX INFO: compiled from: StreamAllocation.java */
    public static final class a extends WeakReference<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f5523a;

        a(g gVar, Object obj) {
            super(gVar);
            this.f5523a = obj;
        }
    }

    public g(h hVar, com.mbridge.msdk.thrid.okhttp.a aVar, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar, Object obj) {
        this.d = hVar;
        this.f5522a = aVar;
        this.e = dVar;
        this.f = nVar;
        this.h = new f(aVar, i(), dVar, nVar);
        this.g = obj;
    }

    private Socket g() {
        if (!o && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        }
        c cVar = this.j;
        if (cVar == null || !cVar.k) {
            return null;
        }
        return a(false, false, true);
    }

    private d i() {
        return com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.d);
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http.c a(t tVar, r.a aVar, boolean z) {
        try {
            com.mbridge.msdk.thrid.okhttp.internal.http.c cVarA = a(aVar.a(), aVar.b(), aVar.c(), tVar.t(), tVar.z(), z).a(tVar, aVar, this);
            synchronized (this.d) {
                this.n = cVarA;
            }
            return cVarA;
        } catch (IOException e) {
            throw new e(e);
        }
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http.c b() {
        com.mbridge.msdk.thrid.okhttp.internal.http.c cVar;
        synchronized (this.d) {
            cVar = this.n;
        }
        return cVar;
    }

    public synchronized c c() {
        return this.j;
    }

    public boolean d() {
        f.a aVar;
        return this.c != null || ((aVar = this.b) != null && aVar.b()) || this.h.a();
    }

    public void e() {
        c cVar;
        Socket socketA;
        synchronized (this.d) {
            cVar = this.j;
            socketA = a(true, false, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(socketA);
        if (cVar != null) {
            this.f.connectionReleased(this.e, cVar);
        }
    }

    public void f() {
        c cVar;
        Socket socketA;
        synchronized (this.d) {
            cVar = this.j;
            socketA = a(false, true, false);
            if (this.j != null) {
                cVar = null;
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(socketA);
        if (cVar != null) {
            com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.e, (IOException) null);
            this.f.connectionReleased(this.e, cVar);
            this.f.callEnd(this.e);
        }
    }

    public a0 h() {
        return this.c;
    }

    public String toString() {
        c cVarC = c();
        return cVarC != null ? cVarC.toString() : this.f5522a.toString();
    }

    public Socket b(c cVar) {
        if (!o && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        }
        if (this.n == null && this.j.n.size() == 1) {
            Reference<g> reference = this.j.n.get(0);
            Socket socketA = a(true, false, false);
            this.j = cVar;
            cVar.n.add(reference);
            return socketA;
        }
        throw new IllegalStateException();
    }

    private c a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            c cVarA = a(i, i2, i3, i4, z);
            synchronized (this.d) {
                if (cVarA.l == 0 && !cVarA.f()) {
                    return cVarA;
                }
                if (cVarA.a(z2)) {
                    return cVarA;
                }
                e();
            }
        }
    }

    private c a(int i, int i2, int i3, int i4, boolean z) throws Throwable {
        c cVar;
        Socket socketG;
        c cVar2;
        Socket socketA;
        a0 a0VarC;
        boolean z2;
        boolean z3;
        f.a aVar;
        synchronized (this.d) {
            if (!this.l) {
                if (this.n == null) {
                    if (!this.m) {
                        cVar = this.j;
                        socketG = g();
                        cVar2 = this.j;
                        socketA = null;
                        if (cVar2 != null) {
                            cVar = null;
                        } else {
                            cVar2 = null;
                        }
                        if (!this.k) {
                            cVar = null;
                        }
                        if (cVar2 == null) {
                            com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.d, this.f5522a, this, null);
                            c cVar3 = this.j;
                            if (cVar3 != null) {
                                z2 = true;
                                cVar2 = cVar3;
                                a0VarC = null;
                            } else {
                                a0VarC = this.c;
                            }
                        } else {
                            a0VarC = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(socketG);
        if (cVar != null) {
            this.f.connectionReleased(this.e, cVar);
        }
        if (z2) {
            this.f.connectionAcquired(this.e, cVar2);
        }
        if (cVar2 != null) {
            this.c = this.j.c();
            return cVar2;
        }
        if (a0VarC != null || ((aVar = this.b) != null && aVar.b())) {
            z3 = false;
        } else {
            this.b = this.h.c();
            z3 = true;
        }
        synchronized (this.d) {
            if (this.m) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<a0> listA = this.b.a();
                int size = listA.size();
                for (int i5 = 0; i5 < size; i5++) {
                    a0 a0Var = listA.get(i5);
                    com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.d, this.f5522a, this, a0Var);
                    c cVar4 = this.j;
                    if (cVar4 != null) {
                        this.c = a0Var;
                        z2 = true;
                        cVar2 = cVar4;
                        break;
                    }
                }
            }
            if (!z2) {
                if (a0VarC == null) {
                    a0VarC = this.b.c();
                }
                this.c = a0VarC;
                this.i = 0;
                cVar2 = new c(this.d, a0VarC);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.f.connectionAcquired(this.e, cVar2);
            return cVar2;
        }
        cVar2.a(i, i2, i3, i4, z, this.e, this.f);
        i().a(cVar2.c());
        synchronized (this.d) {
            this.k = true;
            com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.b(this.d, cVar2);
            if (cVar2.f()) {
                socketA = com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.d, this.f5522a, this);
                cVar2 = this.j;
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(socketA);
        this.f.connectionAcquired(this.e, cVar2);
        return cVar2;
    }

    public void a(boolean z, com.mbridge.msdk.thrid.okhttp.internal.http.c cVar, long j, IOException iOException) {
        c cVar2;
        Socket socketA;
        boolean z2;
        this.f.responseBodyEnd(this.e, j);
        synchronized (this.d) {
            if (cVar != null) {
                if (cVar == this.n) {
                    if (!z) {
                        this.j.l++;
                    }
                    cVar2 = this.j;
                    socketA = a(z, false, true);
                    if (this.j != null) {
                        cVar2 = null;
                    }
                    z2 = this.l;
                }
            }
            throw new IllegalStateException("expected " + this.n + " but was " + cVar);
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(socketA);
        if (cVar2 != null) {
            this.f.connectionReleased(this.e, cVar2);
        }
        if (iOException != null) {
            this.f.callFailed(this.e, com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.e, iOException));
        } else if (z2) {
            com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.e, (IOException) null);
            this.f.callEnd(this.e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0059  */
    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socketG;
        if (!o && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        }
        if (z3) {
            this.n = null;
        }
        if (z2) {
            this.l = true;
        }
        c cVar = this.j;
        if (cVar == null) {
            return null;
        }
        if (z) {
            cVar.k = true;
        }
        if (this.n != null) {
            return null;
        }
        if (!this.l && !cVar.k) {
            return null;
        }
        a(cVar);
        if (this.j.n.isEmpty()) {
            this.j.o = System.nanoTime();
            if (com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.d, this.j)) {
                socketG = this.j.g();
            } else {
                socketG = null;
            }
        } else {
            socketG = null;
        }
        this.j = null;
        return socketG;
    }

    public void a() {
        com.mbridge.msdk.thrid.okhttp.internal.http.c cVar;
        c cVar2;
        synchronized (this.d) {
            this.m = true;
            cVar = this.n;
            cVar2 = this.j;
        }
        if (cVar != null) {
            cVar.cancel();
        } else if (cVar2 != null) {
            cVar2.d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0046  */
    public void a(IOException iOException) {
        c cVar;
        boolean z;
        Socket socketA;
        synchronized (this.d) {
            cVar = null;
            if (iOException instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.n) {
                com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar = ((com.mbridge.msdk.thrid.okhttp.internal.http2.n) iOException).f5556a;
                if (bVar == com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM) {
                    int i = this.i + 1;
                    this.i = i;
                    if (i > 1) {
                        this.c = null;
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (bVar != com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL) {
                    this.c = null;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                c cVar2 = this.j;
                if (cVar2 == null || (cVar2.f() && !(iOException instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.a))) {
                    z = false;
                } else {
                    if (this.j.l == 0) {
                        a0 a0Var = this.c;
                        if (a0Var != null && iOException != null) {
                            this.h.a(a0Var, iOException);
                        }
                        this.c = null;
                    }
                    z = true;
                }
            }
            c cVar3 = this.j;
            socketA = a(z, false, true);
            if (this.j == null && this.k) {
                cVar = cVar3;
            }
        }
        com.mbridge.msdk.thrid.okhttp.internal.c.a(socketA);
        if (cVar != null) {
            this.f.connectionReleased(this.e, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!o && !Thread.holdsLock(this.d)) {
            throw new AssertionError();
        }
        if (this.j == null) {
            this.j = cVar;
            this.k = z;
            cVar.n.add(new a(this, this.g));
            return;
        }
        throw new IllegalStateException();
    }

    private void a(c cVar) {
        int size = cVar.n.size();
        for (int i = 0; i < size; i++) {
            if (cVar.n.get(i).get() == this) {
                cVar.n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
