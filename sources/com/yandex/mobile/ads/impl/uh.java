package com.yandex.mobile.ads.impl;

import android.os.Handler;

/* JADX INFO: loaded from: classes4.dex */
public interface uh {
    default void a(int i, long j, long j2) {
    }

    default void a(long j) {
    }

    default void a(gc0 gc0Var, qy qyVar) {
    }

    default void a(my myVar) {
    }

    default void a(Exception exc) {
    }

    default void b(my myVar) {
    }

    default void b(Exception exc) {
    }

    default void b(String str) {
    }

    default void b(String str, long j, long j2) {
    }

    default void onSkipSilenceEnabledChanged(boolean z) {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f10385a;
        private final uh b;

        public a(Handler handler, uh uhVar) {
            this.f10385a = (Handler) hg.a(handler);
            this.b = uhVar;
        }

        public final void b(final Exception exc) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Exception exc) {
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.a(exc);
        }

        public final void a(final Exception exc) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Exception exc) {
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.b(exc);
        }

        public final void b(final my myVar) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.d(myVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(my myVar) {
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.b(myVar);
        }

        public final void a(final String str, final long j, final long j2) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda7
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
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.a(myVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str, long j, long j2) {
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.b(str, j, j2);
        }

        public final void a(final String str) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.b(str);
        }

        public final void a(final my myVar) {
            synchronized (myVar) {
            }
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.c(myVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(gc0 gc0Var, qy qyVar) {
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.getClass();
            this.b.a(gc0Var, qyVar);
        }

        public final void a(final gc0 gc0Var, final qy qyVar) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.b(gc0Var, qyVar);
                    }
                });
            }
        }

        public final void b(final long j) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(j);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.a(j);
        }

        public final void b(final boolean z) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(z);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            uh uhVar = this.b;
            int i = x82.f10629a;
            uhVar.onSkipSilenceEnabledChanged(z);
        }

        public final void b(final int i, final long j, final long j2) {
            Handler handler = this.f10385a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.uh$a$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(i, j, j2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, long j, long j2) {
            uh uhVar = this.b;
            int i2 = x82.f10629a;
            uhVar.a(i, j, j2);
        }
    }
}
