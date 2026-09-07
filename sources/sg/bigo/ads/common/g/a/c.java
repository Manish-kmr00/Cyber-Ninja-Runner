package sg.bigo.ads.common.g.a;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import sg.bigo.ads.common.n.e;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final LinkedList<Runnable> f13182a = new LinkedList<>();
    final Object b = new Object();
    final e c;

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CountDownLatch f13184a = new CountDownLatch(1);
        Runnable b = new Runnable() { // from class: sg.bigo.ads.common.g.a.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.f13184a.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        };
        private final Runnable c;

        public a(Runnable runnable) {
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.c.run();
            this.f13184a.countDown();
        }
    }

    public c() {
        e eVar = new e("Waitable", 1, 1);
        this.c = eVar;
        eVar.f13228a.allowCoreThreadTimeOut(true);
    }
}
