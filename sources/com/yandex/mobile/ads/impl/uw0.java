package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
final class uw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ii1 f10428a;
    private final d e;
    private final sw0.a f;
    private final e40.a g;
    private final HashMap<c, b> h;
    private final HashSet i;
    private boolean k;
    private w62 l;
    private by1 j = new by1.a();
    private final IdentityHashMap<lw0, c> c = new IdentityHashMap<>();
    private final HashMap d = new HashMap();
    private final ArrayList b = new ArrayList();

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rw0 f10430a;
        public final rw0.c b;
        public final a c;

        public b(fu0 fu0Var, rw0.c cVar, a aVar) {
            this.f10430a = fu0Var;
            this.b = cVar;
            this.c = aVar;
        }
    }

    public interface d {
    }

    public final b52 d() {
        if (this.b.size() < 0) {
            throw new IllegalArgumentException();
        }
        this.j = null;
        return a();
    }

    public uw0(d dVar, ed edVar, Handler handler, ii1 ii1Var) {
        this.f10428a = ii1Var;
        this.e = dVar;
        sw0.a aVar = new sw0.a();
        this.f = aVar;
        e40.a aVar2 = new e40.a();
        this.g = aVar2;
        this.h = new HashMap<>();
        this.i = new HashSet();
        aVar.a(handler, edVar);
        aVar2.a(handler, edVar);
    }

    public final b52 a(int i, List<c> list, by1 by1Var) {
        if (!list.isEmpty()) {
            this.j = by1Var;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = (c) this.b.get(i2 - 1);
                    cVar.d = cVar2.f10431a.f().b() + cVar2.d;
                    cVar.e = false;
                    cVar.c.clear();
                } else {
                    cVar.d = 0;
                    cVar.e = false;
                    cVar.c.clear();
                }
                int iB = cVar.f10431a.f().b();
                for (int i3 = i2; i3 < this.b.size(); i3++) {
                    ((c) this.b.get(i3)).d += iB;
                }
                this.b.add(i2, cVar);
                this.d.put(cVar.b, cVar);
                if (this.k) {
                    a(cVar);
                    if (this.c.isEmpty()) {
                        this.i.add(cVar);
                    } else {
                        b bVar = this.h.get(cVar);
                        if (bVar != null) {
                            bVar.f10430a.b(bVar.b);
                        }
                    }
                }
            }
        }
        return a();
    }

    public final eu0 a(rw0.b bVar, cd cdVar, long j) {
        Object objD = h.d(bVar.f9759a);
        rw0.b bVar2 = new rw0.b(bVar.a(h.c(bVar.f9759a)));
        c cVar = (c) this.d.get(objD);
        cVar.getClass();
        this.i.add(cVar);
        b bVar3 = this.h.get(cVar);
        if (bVar3 != null) {
            bVar3.f10430a.c(bVar3.b);
        }
        cVar.c.add(bVar2);
        eu0 eu0VarB = cVar.f10431a.a(bVar2, cdVar, j);
        this.c.put(eu0VarB, cVar);
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            c cVar2 = (c) it.next();
            if (cVar2.c.isEmpty()) {
                b bVar4 = this.h.get(cVar2);
                if (bVar4 != null) {
                    bVar4.f10430a.b(bVar4.b);
                }
                it.remove();
            }
        }
        return eu0VarB;
    }

    public final boolean c() {
        return this.k;
    }

    public final int b() {
        return this.b.size();
    }

    public final void e() {
        for (b bVar : this.h.values()) {
            try {
                bVar.f10430a.a(bVar.b);
            } catch (RuntimeException e) {
                at0.a("MediaSourceList", "Failed to release child source.", e);
            }
            bVar.f10430a.a((sw0) bVar.c);
            bVar.f10430a.a((e40) bVar.c);
        }
        this.h.clear();
        this.i.clear();
        this.k = false;
    }

    static final class c implements tw0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fu0 f10431a;
        public int d;
        public boolean e;
        public final ArrayList c = new ArrayList();
        public final Object b = new Object();

        public c(rw0 rw0Var, boolean z) {
            this.f10431a = new fu0(rw0Var, z);
        }

        @Override // com.yandex.mobile.ads.impl.tw0
        public final Object a() {
            return this.b;
        }

        @Override // com.yandex.mobile.ads.impl.tw0
        public final b52 b() {
            return this.f10431a.f();
        }
    }

    private final class a implements sw0, e40 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f10429a;
        private sw0.a b;
        private e40.a c;

        public a(c cVar) {
            this.b = uw0.this.f;
            this.c = uw0.this.g;
            this.f10429a = cVar;
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void a(int i, rw0.b bVar, hw0 hw0Var) {
            if (e(i, bVar)) {
                this.b.a(hw0Var);
            }
        }

        @Override // com.yandex.mobile.ads.impl.e40
        public final void c(int i, rw0.b bVar) {
            if (e(i, bVar)) {
                this.c.a();
            }
        }

        @Override // com.yandex.mobile.ads.impl.e40
        public final void d(int i, rw0.b bVar) {
            if (e(i, bVar)) {
                this.c.b();
            }
        }

        @Override // com.yandex.mobile.ads.impl.e40
        public final void b(int i, rw0.b bVar) {
            if (e(i, bVar)) {
                this.c.d();
            }
        }

        private boolean e(int i, rw0.b bVar) {
            rw0.b bVar2 = null;
            if (bVar != null) {
                c cVar = this.f10429a;
                for (int i2 = 0; i2 < cVar.c.size(); i2++) {
                    if (((rw0.b) cVar.c.get(i2)).d == bVar.d) {
                        bVar2 = new rw0.b(bVar.a(h.a(cVar.b, bVar.f9759a)));
                        break;
                    }
                }
                if (bVar2 == null) {
                    return false;
                }
            }
            int i3 = i + this.f10429a.d;
            sw0.a aVar = this.b;
            if (aVar.f10241a != i3 || !x82.a(aVar.b, bVar2)) {
                this.b = uw0.this.f.a(i3, bVar2);
            }
            e40.a aVar2 = this.c;
            if (aVar2.f8756a == i3 && x82.a(aVar2.b, bVar2)) {
                return true;
            }
            this.c = uw0.this.g.a(i3, bVar2);
            return true;
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void c(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var) {
            if (e(i, bVar)) {
                this.b.c(as0Var, hw0Var);
            }
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void b(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var) {
            if (e(i, bVar)) {
                this.b.b(as0Var, hw0Var);
            }
        }

        @Override // com.yandex.mobile.ads.impl.e40
        public final void a(int i, rw0.b bVar) {
            if (e(i, bVar)) {
                this.c.c();
            }
        }

        @Override // com.yandex.mobile.ads.impl.e40
        public final void a(int i, rw0.b bVar, int i2) {
            if (e(i, bVar)) {
                this.c.a(i2);
            }
        }

        @Override // com.yandex.mobile.ads.impl.e40
        public final void a(int i, rw0.b bVar, Exception exc) {
            if (e(i, bVar)) {
                this.c.a(exc);
            }
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void a(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var) {
            if (e(i, bVar)) {
                this.b.a(as0Var, hw0Var);
            }
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void a(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var, IOException iOException, boolean z) {
            if (e(i, bVar)) {
                this.b.a(as0Var, hw0Var, iOException, z);
            }
        }
    }

    public final b52 a() {
        if (this.b.isEmpty()) {
            return b52.b;
        }
        int iB = 0;
        for (int i = 0; i < this.b.size(); i++) {
            c cVar = (c) this.b.get(i);
            cVar.d = iB;
            iB += cVar.f10431a.f().b();
        }
        return new ej1(this.b, this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(rw0 rw0Var, b52 b52Var) {
        ((q60) this.e).h();
    }

    public final void a(w62 w62Var) {
        if (!this.k) {
            this.l = w62Var;
            for (int i = 0; i < this.b.size(); i++) {
                c cVar = (c) this.b.get(i);
                a(cVar);
                this.i.add(cVar);
            }
            this.k = true;
            return;
        }
        throw new IllegalStateException();
    }

    private void a(c cVar) {
        fu0 fu0Var = cVar.f10431a;
        rw0.c cVar2 = new rw0.c() { // from class: com.yandex.mobile.ads.impl.uw0$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.rw0.c
            public final void a(rw0 rw0Var, b52 b52Var) {
                this.f$0.a(rw0Var, b52Var);
            }
        };
        a aVar = new a(cVar);
        this.h.put(cVar, new b(fu0Var, cVar2, aVar));
        fu0Var.a(x82.b((Handler.Callback) null), (sw0) aVar);
        fu0Var.a(x82.b((Handler.Callback) null), (e40) aVar);
        fu0Var.a(cVar2, this.l, this.f10428a);
    }

    public final void a(lw0 lw0Var) {
        c cVarRemove = this.c.remove(lw0Var);
        cVarRemove.getClass();
        cVarRemove.f10431a.a(lw0Var);
        cVarRemove.c.remove(((eu0) lw0Var).b);
        if (!this.c.isEmpty()) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.c.isEmpty()) {
                    b bVar = this.h.get(cVar);
                    if (bVar != null) {
                        bVar.f10430a.b(bVar.b);
                    }
                    it.remove();
                }
            }
        }
        if (cVarRemove.e && cVarRemove.c.isEmpty()) {
            b bVarRemove = this.h.remove(cVarRemove);
            bVarRemove.getClass();
            bVarRemove.f10430a.a(bVarRemove.b);
            bVarRemove.f10430a.a((sw0) bVarRemove.c);
            bVarRemove.f10430a.a((e40) bVarRemove.c);
            this.i.remove(cVarRemove);
        }
    }

    public final b52 a(int i, int i2, by1 by1Var) {
        if (i >= 0 && i <= i2 && i2 <= this.b.size()) {
            this.j = by1Var;
            a(i, i2);
            return a();
        }
        throw new IllegalArgumentException();
    }

    private void a(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVar = (c) this.b.remove(i3);
            this.d.remove(cVar.b);
            int i4 = -cVar.f10431a.f().b();
            for (int i5 = i3; i5 < this.b.size(); i5++) {
                ((c) this.b.get(i5)).d += i4;
            }
            cVar.e = true;
            if (this.k && cVar.c.isEmpty()) {
                b bVarRemove = this.h.remove(cVar);
                bVarRemove.getClass();
                bVarRemove.f10430a.a(bVarRemove.b);
                bVarRemove.f10430a.a((sw0) bVarRemove.c);
                bVarRemove.f10430a.a((e40) bVarRemove.c);
                this.i.remove(cVar);
            }
        }
    }

    public final b52 a(List<c> list, by1 by1Var) {
        a(0, this.b.size());
        return a(this.b.size(), list, by1Var);
    }

    public final b52 a(by1 by1Var) {
        int size = this.b.size();
        if (by1Var.b() != size) {
            by1Var = by1Var.d().b(size);
        }
        this.j = by1Var;
        return a();
    }
}
