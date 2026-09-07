package com.five_corp.ad.internal.http.movcache;

import com.five_corp.ad.internal.ad.s;
import com.five_corp.ad.internal.cache.o;
import com.five_corp.ad.internal.p;
import com.five_corp.ad.internal.storage.n;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements com.five_corp.ad.internal.http.client.b, n, com.five_corp.ad.internal.cache.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f1408a;
    public final o b;
    public final com.five_corp.ad.internal.http.connection.b c;
    public final h d;
    public final int e;
    public final l f;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public final Object g = new Object();
    public com.five_corp.ad.internal.http.client.a h = null;
    public com.five_corp.ad.internal.storage.o i = null;
    public ArrayList j = new ArrayList();
    public boolean o = false;
    public int q = 0;
    public boolean p = false;

    public m(s sVar, o oVar, int i, com.five_corp.ad.internal.http.connection.b bVar, h hVar, int i2) {
        this.f1408a = sVar;
        this.b = oVar;
        this.c = bVar;
        this.d = hVar;
        this.e = i2;
        this.k = i;
        boolean zD = oVar.d();
        this.n = zD;
        this.m = zD ? 4 : 1;
        this.f = new l(this);
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void a() {
        com.five_corp.ad.internal.storage.o oVar;
        synchronized (this.g) {
            this.h = null;
            oVar = this.i;
            this.i = null;
            if (this.m == 2) {
                this.m = 1;
            }
        }
        if (oVar != null) {
            oVar.d.post(new com.five_corp.ad.internal.storage.m(oVar));
        }
        h hVar = this.d;
        hVar.f1404a.post(new f(hVar, this));
    }

    @Override // com.five_corp.ad.internal.storage.n
    public final void b(com.five_corp.ad.internal.o oVar) {
        g();
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void c(com.five_corp.ad.internal.o oVar) {
        com.five_corp.ad.internal.storage.o oVar2;
        synchronized (this.g) {
            this.h = null;
            oVar2 = this.i;
            this.i = null;
        }
        if (oVar2 != null) {
            oVar2.d.post(new com.five_corp.ad.internal.storage.m(oVar2));
        }
        j();
        h hVar = this.d;
        hVar.f1404a.post(new f(hVar, this));
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void d() {
        synchronized (this.g) {
            this.o = true;
            this.l = 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    public final long e() {
        ArrayList<i> arrayList;
        int i;
        long j;
        synchronized (this.g) {
            arrayList = this.j;
            i = this.q;
        }
        int iA = 1;
        for (i iVar : arrayList) {
            if (iVar.e()) {
                if (com.five_corp.ad.internal.http.b.a(iA) - com.five_corp.ad.internal.http.b.a(iVar.a()) < 0) {
                    iA = iVar.a();
                }
            }
        }
        int iA2 = com.five_corp.ad.e.a(iA);
        if (iA2 == 0) {
            j = 15000;
        } else if (iA2 == 1) {
            j = 1000;
        } else if (iA2 != 2) {
            j = 15000;
        } else {
            j = 200;
        }
        return j << Math.min(i, 10);
    }

    public final int f() {
        ArrayList<i> arrayList;
        synchronized (this.g) {
            arrayList = this.j;
        }
        int iA = 1;
        for (i iVar : arrayList) {
            if (iVar.e()) {
                if (com.five_corp.ad.internal.http.b.a(iA) - com.five_corp.ad.internal.http.b.a(iVar.a()) < 0) {
                    iA = iVar.a();
                }
            }
        }
        return iA;
    }

    public final void g() {
        com.five_corp.ad.internal.http.client.a aVar;
        j();
        synchronized (this.g) {
            aVar = this.h;
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    public final boolean h() {
        synchronized (this.g) {
            if (this.m == 4) {
                return false;
            }
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).e()) {
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean i() {
        boolean z;
        synchronized (this.g) {
            z = true;
            if (this.m != 1) {
                z = false;
            }
        }
        return z;
    }

    public final void j() {
        synchronized (this.g) {
            this.m = 5;
        }
    }

    public final void k() {
        synchronized (this.g) {
            if (this.m == 3) {
                this.m = 1;
                h hVar = this.d;
                hVar.f1404a.post(new e(hVar));
            }
        }
    }

    @Override // com.five_corp.ad.internal.cache.n
    public final void b() {
        h hVar = this.d;
        hVar.f1404a.post(new f(hVar, this));
    }

    @Override // com.five_corp.ad.internal.cache.n
    public final void a(com.five_corp.ad.internal.o oVar) {
        j();
        h hVar = this.d;
        hVar.f1404a.post(new f(hVar, this));
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void c() {
        synchronized (this.g) {
            if (this.m != 2) {
                return;
            }
            com.five_corp.ad.internal.storage.o oVar = this.i;
            int i = this.k;
            boolean z = this.o;
            boolean z2 = this.p;
            ArrayList<i> arrayList = this.j;
            if (z) {
                this.m = 4;
                this.n = true;
                this.h = null;
                this.i = null;
            }
            if (z) {
                if (oVar != null) {
                    oVar.d.post(new com.five_corp.ad.internal.storage.m(oVar));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((i) it.next()).b();
                }
                o oVar2 = this.b;
                oVar2.b.post(new com.five_corp.ad.internal.cache.j(oVar2, this));
                return;
            }
            for (i iVar : arrayList) {
                if (iVar.e() && iVar.a(i)) {
                    com.five_corp.ad.internal.http.client.a aVar = new com.five_corp.ad.internal.http.client.a(this.f1408a, this, this.c);
                    synchronized (this.g) {
                        this.h = aVar;
                    }
                    aVar.b(i, z2 ? 0 : this.e);
                    return;
                }
            }
            synchronized (this.g) {
                this.m = 3;
                this.h = null;
                this.i = null;
            }
            if (oVar != null) {
                oVar.d.post(new com.five_corp.ad.internal.storage.m(oVar));
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).c();
            }
            h hVar = this.d;
            hVar.f1404a.post(new f(hVar, this));
        }
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void a(int i) {
        synchronized (this.g) {
            if (this.k >= i) {
                this.o = true;
            } else {
                p pVar = p.d;
                g();
            }
        }
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void a(int i, byte[] bArr) {
        synchronized (this.g) {
            int i2 = this.l;
            int i3 = this.k;
            int i4 = i2 + i;
            this.l = i4;
            if (i4 <= i3) {
                return;
            }
            com.five_corp.ad.internal.storage.o oVar = this.i;
            this.k = i4;
            ArrayList arrayList = this.j;
            if (oVar == null) {
                com.five_corp.ad.internal.util.f fVarA = this.b.a(i3, this);
                if (!fVarA.f1560a) {
                    c(fVarA.b);
                    return;
                }
                oVar = (com.five_corp.ad.internal.storage.o) fVarA.c;
                synchronized (this.g) {
                    this.i = oVar;
                }
            }
            int i5 = i3 - i2;
            int i6 = i - i5;
            oVar.d.post(new com.five_corp.ad.internal.storage.k(oVar, bArr, i5, i6));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((i) it.next()).a(bArr, i5, i6, i3);
            }
        }
    }

    @Override // com.five_corp.ad.internal.http.client.b
    public final void a(int i, int i2, int i3) {
        com.five_corp.ad.internal.o oVar;
        synchronized (this.g) {
            oVar = this.k < i ? new com.five_corp.ad.internal.o(p.N2, null, null, null) : null;
            boolean z = true;
            if (i2 + 1 != i3) {
                z = false;
            }
            this.o = z;
            this.l = i;
        }
        if (oVar != null) {
            g();
        }
    }
}
