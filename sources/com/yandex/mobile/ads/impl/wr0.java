package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes5.dex */
public final class wr0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hp f10584a;
    private final ef0 b;
    private final b<T> c;
    private final CopyOnWriteArraySet<c<T>> d;
    private final ArrayDeque<Runnable> e;
    private final ArrayDeque<Runnable> f;
    private boolean g;

    public interface a<T> {
        void invoke(T t);
    }

    public interface b<T> {
        void a(T t, yb0 yb0Var);
    }

    public wr0(Looper looper, hp hpVar, b<T> bVar) {
        this(new CopyOnWriteArraySet(), looper, hpVar, bVar);
    }

    public final void a(T t) {
        if (this.g) {
            return;
        }
        t.getClass();
        this.d.add(new c<>(t));
    }

    private wr0(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, hp hpVar, b<T> bVar) {
        this.f10584a = hpVar;
        this.d = copyOnWriteArraySet;
        this.c = bVar;
        this.e = new ArrayDeque<>();
        this.f = new ArrayDeque<>();
        this.b = hpVar.a(looper, new Handler.Callback() { // from class: com.yandex.mobile.ads.impl.wr0$$ExternalSyntheticLambda1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f$0.a(message);
            }
        });
    }

    public final void b() {
        for (c<T> cVar : this.d) {
            b<T> bVar = this.c;
            ((c) cVar).d = true;
            if (((c) cVar).c) {
                bVar.a(cVar.f10585a, ((c) cVar).b.a());
            }
        }
        this.d.clear();
        this.g = true;
    }

    private static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f10585a;
        private yb0.a b = new yb0.a();
        private boolean c;
        private boolean d;

        public c(T t) {
            this.f10585a = t;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f10585a.equals(((c) obj).f10585a);
        }

        public final int hashCode() {
            return this.f10585a.hashCode();
        }
    }

    public final wr0<T> a(Looper looper, b<T> bVar) {
        return new wr0<>(this.d, looper, this.f10584a, bVar);
    }

    public final void b(T t) {
        for (c<T> cVar : this.d) {
            if (cVar.f10585a.equals(t)) {
                b<T> bVar = this.c;
                ((c) cVar).d = true;
                if (((c) cVar).c) {
                    bVar.a(cVar.f10585a, ((c) cVar).b.a());
                }
                this.d.remove(cVar);
            }
        }
    }

    public final void a() {
        if (this.f.isEmpty()) {
            return;
        }
        if (!this.b.b()) {
            ef0 ef0Var = this.b;
            ef0Var.a(ef0Var.b(0));
        }
        boolean zIsEmpty = this.e.isEmpty();
        this.e.addAll(this.f);
        this.f.clear();
        if (zIsEmpty) {
            while (!this.e.isEmpty()) {
                this.e.peekFirst().run();
                this.e.removeFirst();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Message message) {
        for (c<T> cVar : this.d) {
            b<T> bVar = this.c;
            if (!((c) cVar).d && ((c) cVar).c) {
                yb0 yb0VarA = ((c) cVar).b.a();
                ((c) cVar).b = new yb0.a();
                ((c) cVar).c = false;
                bVar.a(cVar.f10585a, yb0VarA);
            }
            if (this.b.b()) {
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(CopyOnWriteArraySet copyOnWriteArraySet, int i, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!cVar.d) {
                if (i != -1) {
                    cVar.b.a(i);
                }
                cVar.c = true;
                aVar.invoke(cVar.f10585a);
            }
        }
    }

    public final void a(final int i, final a<T> aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.d);
        this.f.add(new Runnable() { // from class: com.yandex.mobile.ads.impl.wr0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                wr0.a(copyOnWriteArraySet, i, aVar);
            }
        });
    }
}
