package com.five_corp.ad.internal.http.auxcache;

import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.cache.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.storage.m;
import com.five_corp.ad.internal.storage.n;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements com.five_corp.ad.internal.http.client.b, n, com.five_corp.ad.internal.cache.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f1389a;
    public final o b;
    public final ArrayList c;
    public final com.five_corp.ad.internal.http.connection.b d;
    public final i e;
    public final Object f;
    public com.five_corp.ad.internal.http.client.a g;
    public com.five_corp.ad.internal.storage.o h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    public j(s sVar, o oVar, k kVar, com.five_corp.ad.internal.http.connection.b bVar, i iVar) {
        this.f1389a = sVar;
        this.b = oVar;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.add(kVar);
        this.d = bVar;
        this.e = iVar;
        this.f = new Object();
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = false;
        this.k = false;
        this.l = false;
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void a() {
        com.five_corp.ad.internal.storage.o oVar;
        synchronized (this.f) {
            this.g = null;
            oVar = this.h;
            this.h = null;
        }
        if (oVar != null) {
            oVar.d.post(new m(oVar));
        }
        e();
    }

    @Override // com.five_corp.ad.internal.storage.n
    public final void b(com.five_corp.ad.internal.o oVar) {
        d(oVar);
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void c(com.five_corp.ad.internal.o oVar) {
        com.five_corp.ad.internal.storage.o oVar2;
        synchronized (this.f) {
            this.g = null;
            oVar2 = this.h;
            this.h = null;
        }
        if (oVar2 != null) {
            oVar2.d.post(new m(oVar2));
        }
        e(oVar);
    }

    public final void d(com.five_corp.ad.internal.o oVar) {
        com.five_corp.ad.internal.http.client.a aVar;
        synchronized (this.f) {
            aVar = this.g;
        }
        e(oVar);
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void e(com.five_corp.ad.internal.o oVar) {
        synchronized (this.f) {
            if (this.l) {
                return;
            }
            this.l = true;
            i iVar = this.e;
            iVar.f1388a.post(new g(iVar, this, oVar));
        }
    }

    @Override // com.five_corp.ad.internal.cache.n
    public final void b() {
        synchronized (this.f) {
            if (this.l) {
                return;
            }
            i iVar = this.e;
            iVar.f1388a.post(new e(iVar, this));
        }
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void d() {
        com.five_corp.ad.internal.util.f fVarA = this.b.a(0, this);
        if (!fVarA.f1560a) {
            e(fVarA.b);
            return;
        }
        synchronized (this.f) {
            this.h = (com.five_corp.ad.internal.storage.o) fVarA.c;
            this.j = true;
        }
    }

    @Override // com.five_corp.ad.internal.cache.n
    public final void a(com.five_corp.ad.internal.o oVar) {
        d(oVar);
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void c() {
        com.five_corp.ad.internal.storage.o oVar;
        boolean z;
        synchronized (this.f) {
            this.g = null;
            oVar = this.h;
            this.h = null;
            z = this.j;
        }
        if (oVar != null) {
            oVar.d.post(new m(oVar));
        }
        if (z) {
            o oVar2 = this.b;
            oVar2.b.post(new com.five_corp.ad.internal.cache.j(oVar2, this));
        } else {
            e();
        }
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void a(int i) {
        synchronized (this.f) {
            if (this.i == i) {
                this.j = true;
            } else {
                e(new com.five_corp.ad.internal.o(p.M2, null, null, null));
            }
        }
    }

    public final void e() {
        synchronized (this.f) {
            if (this.l) {
                return;
            }
            i iVar = this.e;
            iVar.f1388a.post(new f(iVar, this));
        }
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void a(int i, byte[] bArr) {
        com.five_corp.ad.internal.storage.o oVar;
        synchronized (this.f) {
            oVar = this.h;
        }
        if (oVar == null) {
            d(new com.five_corp.ad.internal.o(p.L2, null, null, null));
        } else {
            oVar.d.post(new com.five_corp.ad.internal.storage.k(oVar, bArr, 0, i));
        }
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void a(int i, int i2, int i3) {
        com.five_corp.ad.internal.o oVar;
        synchronized (this.f) {
            oVar = this.i < i ? new com.five_corp.ad.internal.o(p.K2, null, null, null) : null;
        }
        if (oVar != null) {
            d(oVar);
            return;
        }
        com.five_corp.ad.internal.util.f fVarA = this.b.a(i, this);
        if (!fVarA.f1560a) {
            e(fVarA.b);
            return;
        }
        synchronized (this.f) {
            this.h = (com.five_corp.ad.internal.storage.o) fVarA.c;
            boolean z = true;
            if (i2 + 1 != i3) {
                z = false;
            }
            this.j = z;
        }
    }
}
