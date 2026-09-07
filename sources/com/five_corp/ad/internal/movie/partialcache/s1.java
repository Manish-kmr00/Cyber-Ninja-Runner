package com.five_corp.ad.internal.movie.partialcache;

import android.os.Handler;
import android.os.Looper;
import com.five_corp.ad.internal.movie.C2986h;
import com.five_corp.ad.internal.movie.C2987i;
import com.five_corp.ad.internal.movie.RunnableC2990l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public final class s1 implements InterfaceC2998d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.logger.a f1497a;
    public final com.five_corp.ad.internal.cache.o b;
    public final com.five_corp.ad.internal.context.l c;
    public final com.five_corp.ad.internal.http.movcache.h d;
    public final com.five_corp.ad.internal.movie.x e;
    public final Looper f;
    public Handler g;
    public t1 h;

    public s1(com.five_corp.ad.internal.logger.a aVar, com.five_corp.ad.internal.cache.o oVar, com.five_corp.ad.internal.context.l lVar, com.five_corp.ad.internal.http.movcache.h hVar, com.five_corp.ad.internal.movie.x xVar, Looper looper) {
        this.f1497a = aVar;
        this.b = oVar;
        this.c = lVar;
        this.d = hVar;
        this.e = xVar;
        this.f = looper;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003a  */
    public static void a(s1 s1Var, t1 t1Var) {
        int iB;
        com.five_corp.ad.internal.util.f fVar;
        boolean z;
        boolean zA;
        s1Var.getClass();
        k1 k1Var = t1Var.c;
        com.five_corp.ad.internal.util.c cVar = t1Var.b;
        k1Var.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            int i = k1Var.d;
            i1 i1Var = k1Var.i;
            int iB2 = i < i1Var.i ? i1Var.b(i) : Integer.MAX_VALUE;
            if (k1Var.h != null) {
                int i2 = k1Var.e;
                i1 i1Var2 = k1Var.j;
                if (i2 < i1Var2.i) {
                    iB = i1Var2.b(i2);
                } else {
                    iB = Integer.MAX_VALUE;
                }
            } else {
                iB = Integer.MAX_VALUE;
            }
            if (iB2 >= Math.min(iB, Integer.MAX_VALUE)) {
                if (iB >= Math.min(iB2, Integer.MAX_VALUE)) {
                    fVar = new com.five_corp.ad.internal.util.f(true, null, new C2996c(arrayList, arrayList2));
                    break;
                }
                int iB3 = k1Var.j.b(k1Var.e);
                int iC = k1Var.j.c(k1Var.e);
                i1 i1Var3 = k1Var.j;
                int i3 = k1Var.e;
                long[] jArr = i1Var3.f;
                long j = jArr.length <= i3 ? -1L : jArr[i3];
                int iA = i1Var3.a(i3);
                boolean z2 = k1Var.e + 1 >= k1Var.j.i;
                if (iB3 + iC > cVar.g) {
                    fVar = new com.five_corp.ad.internal.util.f(true, null, new C2996c(arrayList, arrayList2));
                    break;
                }
                com.five_corp.ad.internal.util.g gVarB = cVar.b(iB3);
                if (!gVarB.f1560a) {
                    fVar = new com.five_corp.ad.internal.util.f(false, gVarB.b, null);
                    break;
                }
                com.five_corp.ad.internal.util.f fVarA = cVar.a(iC);
                if (!fVarA.f1560a) {
                    fVar = new com.five_corp.ad.internal.util.f(false, fVarA.b, null);
                    break;
                } else {
                    com.five_corp.ad.internal.util.b bVar = (com.five_corp.ad.internal.util.b) fVarA.c;
                    k1Var.e++;
                    arrayList2.add(new v1(bVar.f1556a, bVar.b, iC, j, iA, z2));
                }
            } else {
                int iB4 = k1Var.i.b(k1Var.d);
                int iC2 = k1Var.i.c(k1Var.d);
                i1 i1Var4 = k1Var.i;
                int i4 = k1Var.d;
                long[] jArr2 = i1Var4.f;
                long j2 = jArr2.length <= i4 ? -1L : jArr2[i4];
                int iA2 = i1Var4.a(i4);
                boolean z3 = k1Var.d + 1 >= k1Var.i.i;
                if (iB4 + iC2 > cVar.g) {
                    fVar = new com.five_corp.ad.internal.util.f(true, null, new C2996c(arrayList, arrayList2));
                    break;
                }
                com.five_corp.ad.internal.util.g gVarB2 = cVar.b(iB4);
                if (!gVarB2.f1560a) {
                    fVar = new com.five_corp.ad.internal.util.f(false, gVarB2.b, null);
                    break;
                }
                com.five_corp.ad.internal.util.f fVarA2 = cVar.a(iC2);
                if (!fVarA2.f1560a) {
                    fVar = new com.five_corp.ad.internal.util.f(false, fVarA2.b, null);
                    break;
                } else {
                    com.five_corp.ad.internal.util.b bVar2 = (com.five_corp.ad.internal.util.b) fVarA2.c;
                    k1Var.d++;
                    arrayList.add(new v1(bVar2.f1556a, bVar2.b, iC2, j2, iA2, z3));
                }
            }
        }
        if (!fVar.f1560a) {
            com.five_corp.ad.internal.o oVar = fVar.b;
            if (t1Var.d == 3) {
                return;
            }
            t1Var.d = 3;
            s1Var.e.a(oVar);
            return;
        }
        ArrayList arrayList3 = ((C2996c) fVar.c).f1476a;
        t1 t1Var2 = s1Var.h;
        synchronized (t1Var2.h) {
            int size = t1Var2.i.size();
            int size2 = arrayList3.size() + size;
            z = size < 1 && size2 >= 1;
            zA = size2 > 50;
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                t1Var2.i.addLast((v1) it.next());
            }
            if (!t1Var2.i.isEmpty()) {
                boolean z4 = ((v1) t1Var2.i.peekLast()).f;
            }
        }
        if (z) {
            com.five_corp.ad.internal.movie.x xVar = s1Var.e;
            xVar.getClass();
            xVar.n.post(new RunnableC2990l(xVar, new C2987i(xVar)));
        }
        if (t1Var.e) {
            zA &= s1Var.a(((C2996c) fVar.c).b);
        }
        if (zA) {
            t1Var.f1498a.d();
        }
    }

    public final void b(u1 u1Var) {
        Handler handler = this.g;
        if (handler == null) {
            return;
        }
        try {
            handler.postAtFrontOfQueue(new m1(this, u1Var));
        } catch (IllegalStateException unused) {
        }
    }

    public final v1 b() {
        v1 v1Var;
        boolean z;
        t1 t1Var = this.h;
        if (t1Var.d != 2) {
            return null;
        }
        synchronized (t1Var.h) {
            ArrayDeque arrayDeque = t1Var.i;
            v1Var = arrayDeque.isEmpty() ? null : (v1) arrayDeque.pollFirst();
            z = arrayDeque.size() < 3;
        }
        if (z) {
            t1Var.f1498a.c();
        }
        return v1Var;
    }

    public final boolean a(ArrayList arrayList) {
        boolean z;
        boolean z2;
        t1 t1Var = this.h;
        synchronized (t1Var.f) {
            int size = t1Var.g.size();
            int size2 = arrayList.size() + size;
            z = size < 1 && size2 >= 1;
            z2 = size2 > 50;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                t1Var.g.addLast((v1) it.next());
            }
            if (!t1Var.g.isEmpty()) {
                boolean z3 = ((v1) t1Var.g.peekLast()).f;
            }
        }
        if (z) {
            com.five_corp.ad.internal.movie.x xVar = this.e;
            xVar.getClass();
            xVar.n.post(new RunnableC2990l(xVar, new C2986h(xVar)));
        }
        return z2;
    }

    public final void a(t1 t1Var, com.five_corp.ad.internal.o oVar) {
        if (t1Var.d == 3) {
            return;
        }
        t1Var.d = 3;
        this.e.a(oVar);
    }

    public final void a(u1 u1Var) {
        Handler handler = this.g;
        if (handler == null) {
            return;
        }
        try {
            handler.post(new l1(this, u1Var));
        } catch (IllegalStateException unused) {
        }
    }

    public final v1 a() {
        v1 v1Var;
        boolean z;
        t1 t1Var = this.h;
        if (t1Var.d != 2) {
            return null;
        }
        synchronized (t1Var.f) {
            ArrayDeque arrayDeque = t1Var.g;
            v1Var = arrayDeque.isEmpty() ? null : (v1) arrayDeque.pollFirst();
            z = arrayDeque.size() < 3;
        }
        if (z) {
            t1Var.f1498a.c();
        }
        return v1Var;
    }
}
