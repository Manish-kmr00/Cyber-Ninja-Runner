package sg.bigo.ads.core.d.c;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.n.c;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f13550a;
    private static ExecutorService b = Executors.newFixedThreadPool(1, new c("Stat-Worker"));

    /* JADX INFO: renamed from: sg.bigo.ads.core.d.c.a$a, reason: collision with other inner class name */
    static class C0893a extends b {
        private Future c;

        C0893a(Runnable runnable) {
            super(runnable);
        }

        @Override // sg.bigo.ads.core.d.c.a.b
        protected final void a() {
            if (this.f13552a != null) {
                this.c = a.a(this.f13552a);
            }
        }
    }

    public static abstract class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f13552a;
        final AtomicBoolean b = new AtomicBoolean(false);

        b(Runnable runnable) {
            this.f13552a = runnable;
        }

        protected abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            if (this.b.get()) {
                return;
            }
            a();
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("BGAd-Stat-Handler");
        handlerThread.start();
        f13550a = new Handler(handlerThread.getLooper());
    }

    public static Future a(final Runnable runnable) {
        return b.submit(new Runnable() { // from class: sg.bigo.ads.core.d.c.a.1
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder sb;
                String localizedMessage;
                try {
                    runnable.run();
                } catch (Exception e) {
                    sb = new StringBuilder("stat thread get exception:");
                    localizedMessage = e.getLocalizedMessage();
                    sg.bigo.ads.common.t.a.a(0, "Stats", sb.append(localizedMessage).toString());
                } catch (Throwable th) {
                    sb = new StringBuilder("stat thread get throwable:");
                    localizedMessage = th.getLocalizedMessage();
                    sg.bigo.ads.common.t.a.a(0, "Stats", sb.append(localizedMessage).toString());
                }
            }
        });
    }

    public static b a(Runnable runnable, long j) {
        C0893a c0893a = new C0893a(runnable);
        f13550a.postDelayed(c0893a, j);
        return c0893a;
    }

    public static void a(b bVar) {
        Future future;
        if (bVar != null) {
            bVar.b.set(true);
            if (bVar instanceof C0893a) {
                C0893a c0893a = (C0893a) bVar;
                if (c0893a.c != null && (future = c0893a.c) != null && !future.isCancelled() && !future.isDone()) {
                    future.cancel(true);
                }
            }
            f13550a.removeCallbacks(bVar);
        }
    }
}
