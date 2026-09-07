package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public interface sw0 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10241a;
        public final rw0.b b;
        private final CopyOnWriteArrayList<C0756a> c;
        private final long d;

        public final void a(Handler handler, sw0 sw0Var) {
            sw0Var.getClass();
            this.c.add(new C0756a(handler, sw0Var));
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i, rw0.b bVar) {
            this.c = copyOnWriteArrayList;
            this.f10241a = i;
            this.b = bVar;
            this.d = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(sw0 sw0Var, as0 as0Var, hw0 hw0Var) {
            sw0Var.c(this.f10241a, this.b, as0Var, hw0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(sw0 sw0Var, as0 as0Var, hw0 hw0Var) {
            sw0Var.b(this.f10241a, this.b, as0Var, hw0Var);
        }

        private long a(long j) {
            long jB = x82.b(j);
            if (jB == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.d + jB;
        }

        public final void a(int i, gc0 gc0Var, long j) {
            a(new hw0(1, i, gc0Var, 0, null, a(j), -9223372036854775807L));
        }

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.sw0$a$a, reason: collision with other inner class name */
        private static final class C0756a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f10242a;
            public sw0 b;

            public C0756a(Handler handler, sw0 sw0Var) {
                this.f10242a = handler;
                this.b = sw0Var;
            }
        }

        public final void c(final as0 as0Var, final hw0 hw0Var) {
            for (C0756a c0756a : this.c) {
                final sw0 sw0Var = c0756a.b;
                x82.a(c0756a.f10242a, new Runnable() { // from class: com.yandex.mobile.ads.impl.sw0$a$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(sw0Var, as0Var, hw0Var);
                    }
                });
            }
        }

        public final void b(final as0 as0Var, final hw0 hw0Var) {
            for (C0756a c0756a : this.c) {
                final sw0 sw0Var = c0756a.b;
                x82.a(c0756a.f10242a, new Runnable() { // from class: com.yandex.mobile.ads.impl.sw0$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(sw0Var, as0Var, hw0Var);
                    }
                });
            }
        }

        public final void b(as0 as0Var, gc0 gc0Var, long j, long j2) {
            c(as0Var, new hw0(1, -1, gc0Var, 0, null, a(j), a(j2)));
        }

        public final void a(final hw0 hw0Var) {
            for (C0756a c0756a : this.c) {
                final sw0 sw0Var = c0756a.b;
                x82.a(c0756a.f10242a, new Runnable() { // from class: com.yandex.mobile.ads.impl.sw0$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(sw0Var, hw0Var);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(sw0 sw0Var, hw0 hw0Var) {
            sw0Var.a(this.f10241a, this.b, hw0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(sw0 sw0Var, as0 as0Var, hw0 hw0Var) {
            sw0Var.a(this.f10241a, this.b, as0Var, hw0Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(sw0 sw0Var, as0 as0Var, hw0 hw0Var, IOException iOException, boolean z) {
            sw0Var.a(this.f10241a, this.b, as0Var, hw0Var, iOException, z);
        }

        public final void a(as0 as0Var, long j, long j2) {
            a(as0Var, new hw0(1, -1, null, 0, null, a(j), a(j2)));
        }

        public final void a(final as0 as0Var, final hw0 hw0Var) {
            for (C0756a c0756a : this.c) {
                final sw0 sw0Var = c0756a.b;
                x82.a(c0756a.f10242a, new Runnable() { // from class: com.yandex.mobile.ads.impl.sw0$a$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(sw0Var, as0Var, hw0Var);
                    }
                });
            }
        }

        public final void a(as0 as0Var, gc0 gc0Var, long j, long j2) {
            b(as0Var, new hw0(1, -1, gc0Var, 0, null, a(j), a(j2)));
        }

        public final void a(as0 as0Var, int i, gc0 gc0Var, long j, long j2, IOException iOException, boolean z) {
            a(as0Var, new hw0(i, -1, gc0Var, 0, null, a(j), a(j2)), iOException, z);
        }

        public final void a(final as0 as0Var, final hw0 hw0Var, final IOException iOException, final boolean z) {
            for (C0756a c0756a : this.c) {
                final sw0 sw0Var = c0756a.b;
                x82.a(c0756a.f10242a, new Runnable() { // from class: com.yandex.mobile.ads.impl.sw0$a$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(sw0Var, as0Var, hw0Var, iOException, z);
                    }
                });
            }
        }

        public final void a(sw0 sw0Var) {
            for (C0756a c0756a : this.c) {
                if (c0756a.b == sw0Var) {
                    this.c.remove(c0756a);
                }
            }
        }

        public final a a(int i, rw0.b bVar) {
            return new a(this.c, i, bVar);
        }
    }

    default void a(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var) {
    }

    default void a(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var, IOException iOException, boolean z) {
    }

    default void a(int i, rw0.b bVar, hw0 hw0Var) {
    }

    default void b(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var) {
    }

    default void c(int i, rw0.b bVar, as0 as0Var, hw0 hw0Var) {
    }
}
