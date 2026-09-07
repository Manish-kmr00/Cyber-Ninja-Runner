package com.yandex.mobile.ads.impl;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes7.dex */
public interface vi {

    public interface a {

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.vi$a$a, reason: collision with other inner class name */
        public static final class C0758a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList<C0759a> f10480a = new CopyOnWriteArrayList<>();

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.vi$a$a$a, reason: collision with other inner class name */
            static final class C0759a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final Handler f10481a;
                private final a b;
                private boolean c;

                public C0759a(Handler handler, ed edVar) {
                    this.f10481a = handler;
                    this.b = edVar;
                }
            }

            public final void a(Handler handler, ed edVar) {
                edVar.getClass();
                a(edVar);
                this.f10480a.add(new C0759a(handler, edVar));
            }

            public final void a(final int i, final long j, final long j2) {
                for (final C0759a c0759a : this.f10480a) {
                    if (!c0759a.c) {
                        c0759a.f10481a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.vi$a$a$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                vi.a.C0758a.a(c0759a, i, j, j2);
                            }
                        });
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void a(C0759a c0759a, int i, long j, long j2) {
                c0759a.b.b(i, j, j2);
            }

            public final void a(ed edVar) {
                for (C0759a c0759a : this.f10480a) {
                    if (c0759a.b == edVar) {
                        c0759a.c = true;
                        this.f10480a.remove(c0759a);
                    }
                }
            }
        }

        void b(int i, long j, long j2);
    }

    gz a();

    void a(Handler handler, ed edVar);

    void a(ed edVar);
}
