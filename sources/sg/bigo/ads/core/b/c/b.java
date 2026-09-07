package sg.bigo.ads.core.b.c;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.common.n.c;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f13523a;
    private static final ExecutorService b = Executors.newFixedThreadPool(1, new c("Callback-Worker"));

    static class a extends AbstractRunnableC0890b {
        private Future c;

        a(Runnable runnable) {
            super(runnable);
        }

        @Override // sg.bigo.ads.core.b.c.b.AbstractRunnableC0890b
        protected final void a() {
            if (this.f13525a != null) {
                this.c = b.a(this.f13525a);
            }
        }
    }

    /* JADX INFO: renamed from: sg.bigo.ads.core.b.c.b$b, reason: collision with other inner class name */
    public static abstract class AbstractRunnableC0890b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f13525a;
        final AtomicBoolean b = new AtomicBoolean(false);

        AbstractRunnableC0890b(Runnable runnable) {
            this.f13525a = runnable;
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
        HandlerThread handlerThread = new HandlerThread("BGAd-Callback-Handler");
        handlerThread.start();
        f13523a = new Handler(handlerThread.getLooper());
    }

    public static Future<?> a(final Runnable runnable) {
        return b.submit(new Runnable() { // from class: sg.bigo.ads.core.b.c.b.1
            @Override // java.lang.Runnable
            public final void run() {
                StringBuilder sb;
                String localizedMessage;
                try {
                    runnable.run();
                } catch (Exception e) {
                    sb = new StringBuilder("callback thread get exception:");
                    localizedMessage = e.getLocalizedMessage();
                    sg.bigo.ads.core.b.c.a.a(sb.append(localizedMessage).toString());
                } catch (Throwable th) {
                    sb = new StringBuilder("callback thread get throwable:");
                    localizedMessage = th.getLocalizedMessage();
                    sg.bigo.ads.core.b.c.a.a(sb.append(localizedMessage).toString());
                }
            }
        });
    }

    public static AbstractRunnableC0890b a(Runnable runnable, long j) {
        a aVar = new a(runnable);
        f13523a.postDelayed(aVar, j);
        return aVar;
    }

    public static void a(AbstractRunnableC0890b abstractRunnableC0890b) {
        Future future;
        if (abstractRunnableC0890b != null) {
            abstractRunnableC0890b.b.set(true);
            if (abstractRunnableC0890b instanceof a) {
                a aVar = (a) abstractRunnableC0890b;
                if (aVar.c != null && (future = aVar.c) != null && !future.isCancelled() && !future.isDone()) {
                    future.cancel(true);
                }
            }
            f13523a.removeCallbacks(abstractRunnableC0890b);
        }
    }
}
