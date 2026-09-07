package com.yandex.mobile.ads.impl;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;

/* JADX INFO: loaded from: classes2.dex */
public interface nf2 {
    default void a(int i, long j) {
    }

    default void a(uf2 uf2Var) {
    }

    default void a(Object obj, long j) {
    }

    default void a(String str) {
    }

    default void a(String str, long j, long j2) {
    }

    default void b(int i, long j) {
    }

    default void b(gc0 gc0Var, qy qyVar) {
    }

    default void c(my myVar) {
    }

    default void c(Exception exc) {
    }

    default void d(my myVar) {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f9727a;
        private final nf2 b;

        public a(Handler handler, nf2 nf2Var) {
            this.f9727a = (Handler) hg.a(handler);
            this.b = nf2Var;
        }

        public final void b(final my myVar) {
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(myVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(my myVar) {
            nf2 nf2Var = this.b;
            int i = x82.f10629a;
            nf2Var.d(myVar);
        }

        public final void a(final String str, final long j, final long j2) {
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(str, j, j2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(my myVar) {
            synchronized (myVar) {
            }
            nf2 nf2Var = this.b;
            int i = x82.f10629a;
            nf2Var.c(myVar);
        }

        public final void c(final int i, final long j) {
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(j, i);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, long j, long j2) {
            nf2 nf2Var = this.b;
            int i = x82.f10629a;
            nf2Var.a(str, j, j2);
        }

        public final void a(final String str) {
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            nf2 nf2Var = this.b;
            int i = x82.f10629a;
            nf2Var.a(str);
        }

        public final void a(final my myVar) {
            synchronized (myVar) {
            }
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(myVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i, long j) {
            nf2 nf2Var = this.b;
            int i2 = x82.f10629a;
            nf2Var.b(i, j);
        }

        public final void a(final int i, final long j) {
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(i, j);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(gc0 gc0Var, qy qyVar) {
            nf2 nf2Var = this.b;
            int i = x82.f10629a;
            nf2Var.getClass();
            this.b.b(gc0Var, qyVar);
        }

        public final void a(final gc0 gc0Var, final qy qyVar) {
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(gc0Var, qyVar);
                    }
                });
            }
        }

        public final void b(final Exception exc) {
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Object obj, long j) {
            nf2 nf2Var = this.b;
            int i = x82.f10629a;
            nf2Var.a(obj, j);
        }

        public final void b(final uf2 uf2Var) {
            Handler handler = this.f9727a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(uf2Var);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j, int i) {
            nf2 nf2Var = this.b;
            int i2 = x82.f10629a;
            nf2Var.a(i, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Exception exc) {
            nf2 nf2Var = this.b;
            int i = x82.f10629a;
            nf2Var.c(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(uf2 uf2Var) {
            nf2 nf2Var = this.b;
            int i = x82.f10629a;
            nf2Var.a(uf2Var);
        }

        public final void a(final Surface surface) {
            if (this.f9727a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f9727a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.nf2$a$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(surface, jElapsedRealtime);
                    }
                });
            }
        }
    }
}
