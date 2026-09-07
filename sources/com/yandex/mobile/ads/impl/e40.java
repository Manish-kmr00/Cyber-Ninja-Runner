package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes5.dex */
public interface e40 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8756a;
        public final rw0.b b;
        private final CopyOnWriteArrayList<C0742a> c;

        public final void a(Handler handler, e40 e40Var) {
            e40Var.getClass();
            this.c.add(new C0742a(handler, e40Var));
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        public final void e(e40 e40Var) {
            for (C0742a c0742a : this.c) {
                if (c0742a.b == e40Var) {
                    this.c.remove(c0742a);
                }
            }
        }

        public final void a() {
            for (C0742a c0742a : this.c) {
                final e40 e40Var = c0742a.b;
                x82.a(c0742a.f8757a, new Runnable() { // from class: com.yandex.mobile.ads.impl.e40$a$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(e40Var);
                    }
                });
            }
        }

        public final void c() {
            for (C0742a c0742a : this.c) {
                final e40 e40Var = c0742a.b;
                x82.a(c0742a.f8757a, new Runnable() { // from class: com.yandex.mobile.ads.impl.e40$a$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(e40Var);
                    }
                });
            }
        }

        public final void b() {
            for (C0742a c0742a : this.c) {
                final e40 e40Var = c0742a.b;
                x82.a(c0742a.f8757a, new Runnable() { // from class: com.yandex.mobile.ads.impl.e40$a$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(e40Var);
                    }
                });
            }
        }

        public final void d() {
            for (C0742a c0742a : this.c) {
                final e40 e40Var = c0742a.b;
                x82.a(c0742a.f8757a, new Runnable() { // from class: com.yandex.mobile.ads.impl.e40$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(e40Var);
                    }
                });
            }
        }

        private a(CopyOnWriteArrayList<C0742a> copyOnWriteArrayList, int i, rw0.b bVar) {
            this.c = copyOnWriteArrayList;
            this.f8756a = i;
            this.b = bVar;
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.e40$a$a, reason: collision with other inner class name */
        private static final class C0742a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f8757a;
            public e40 b;

            public C0742a(Handler handler, e40 e40Var) {
                this.f8757a = handler;
                this.b = e40Var;
            }
        }

        public final void a(final int i) {
            for (C0742a c0742a : this.c) {
                final e40 e40Var = c0742a.b;
                x82.a(c0742a.f8757a, new Runnable() { // from class: com.yandex.mobile.ads.impl.e40$a$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(e40Var, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(e40 e40Var) {
            e40Var.a(this.f8756a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(e40 e40Var) {
            e40Var.d(this.f8756a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(e40 e40Var) {
            e40Var.b(this.f8756a, this.b);
        }

        public final void a(final Exception exc) {
            for (C0742a c0742a : this.c) {
                final e40 e40Var = c0742a.b;
                x82.a(c0742a.f8757a, new Runnable() { // from class: com.yandex.mobile.ads.impl.e40$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(e40Var, exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(e40 e40Var) {
            e40Var.c(this.f8756a, this.b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(e40 e40Var, int i) {
            e40Var.getClass();
            e40Var.a(this.f8756a, this.b, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(e40 e40Var, Exception exc) {
            e40Var.a(this.f8756a, this.b, exc);
        }

        public final a a(int i, rw0.b bVar) {
            return new a(this.c, i, bVar);
        }
    }

    default void a(int i, rw0.b bVar) {
    }

    default void a(int i, rw0.b bVar, int i2) {
    }

    default void a(int i, rw0.b bVar, Exception exc) {
    }

    default void b(int i, rw0.b bVar) {
    }

    default void c(int i, rw0.b bVar) {
    }

    default void d(int i, rw0.b bVar) {
    }
}
