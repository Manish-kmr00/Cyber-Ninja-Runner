package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dr<T> extends ok {
    private final HashMap<T, b<T>> h = new HashMap<>();
    private Handler i;
    private w62 j;

    protected abstract rw0.b a(T t, rw0.b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract void a(T t, rw0 rw0Var, b52 b52Var);

    protected dr() {
    }

    @Override // com.yandex.mobile.ads.impl.ok
    protected final void b() {
        for (b<T> bVar : this.h.values()) {
            bVar.f8724a.c(bVar.b);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ok
    protected final void a() {
        for (b<T> bVar : this.h.values()) {
            bVar.f8724a.b(bVar.b);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ok
    protected void e() {
        for (b<T> bVar : this.h.values()) {
            bVar.f8724a.a(bVar.b);
            bVar.f8724a.a((sw0) bVar.c);
            bVar.f8724a.a((e40) bVar.c);
        }
        this.h.clear();
    }

    private static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rw0 f8724a;
        public final rw0.c b;
        public final dr<T>.a c;

        public b(rw0 rw0Var, rw0.c cVar, dr<T>.a aVar) {
            this.f8724a = rw0Var;
            this.b = cVar;
            this.c = aVar;
        }
    }

    private final class a implements sw0, e40 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f8723a;
        private sw0.a b;
        private e40.a c;

        public a(T t) {
            this.b = dr.this.b((rw0.b) null);
            this.c = dr.this.a((rw0.b) null);
            this.f8723a = t;
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
            rw0.b bVarA;
            if (bVar != null) {
                bVarA = dr.this.a(this.f8723a, bVar);
                if (bVarA == null) {
                    return false;
                }
            } else {
                bVarA = null;
            }
            dr.this.getClass();
            sw0.a aVar = this.b;
            if (aVar.f10241a != i || !x82.a(aVar.b, bVarA)) {
                this.b = dr.this.b(i, bVarA);
            }
            e40.a aVar2 = this.c;
            if (aVar2.f8756a == i && x82.a(aVar2.b, bVarA)) {
                return true;
            }
            this.c = dr.this.a(i, bVarA);
            return true;
        }

        private hw0 a(hw0 hw0Var) {
            dr drVar = dr.this;
            long j = hw0Var.f;
            drVar.getClass();
            dr drVar2 = dr.this;
            long j2 = hw0Var.g;
            drVar2.getClass();
            return (j == hw0Var.f && j2 == hw0Var.g) ? hw0Var : new hw0(hw0Var.f9142a, hw0Var.b, hw0Var.c, hw0Var.d, hw0Var.e, j, j2);
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void c(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var) {
            if (e(i, bVar)) {
                this.b.c(as0Var, a(hw0Var));
            }
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void b(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var) {
            if (e(i, bVar)) {
                this.b.b(as0Var, a(hw0Var));
            }
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void a(int i, rw0.b bVar, hw0 hw0Var) {
            if (e(i, bVar)) {
                this.b.a(a(hw0Var));
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
                this.b.a(as0Var, a(hw0Var));
            }
        }

        @Override // com.yandex.mobile.ads.impl.sw0
        public final void a(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var, IOException iOException, boolean z) {
            if (e(i, bVar)) {
                this.b.a(as0Var, a(hw0Var), iOException, z);
            }
        }
    }

    protected final void a(final T t, rw0 rw0Var) {
        if (!this.h.containsKey(t)) {
            rw0.c cVar = new rw0.c() { // from class: com.yandex.mobile.ads.impl.dr$$ExternalSyntheticLambda0
                @Override // com.yandex.mobile.ads.impl.rw0.c
                public final void a(rw0 rw0Var2, b52 b52Var) {
                    this.f$0.a(t, rw0Var2, b52Var);
                }
            };
            a aVar = new a(t);
            this.h.put(t, new b<>(rw0Var, cVar, aVar));
            Handler handler = this.i;
            handler.getClass();
            rw0Var.a(handler, (sw0) aVar);
            Handler handler2 = this.i;
            handler2.getClass();
            rw0Var.a(handler2, (e40) aVar);
            rw0Var.a(cVar, this.j, c());
            if (d()) {
                return;
            }
            rw0Var.b(cVar);
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.yandex.mobile.ads.impl.ok
    protected void a(w62 w62Var) {
        this.j = w62Var;
        this.i = x82.a((Handler.Callback) null);
    }
}
