package sg.bigo.ads.common.n;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f13228a;

    public e(String str, int i, int i2) {
        this.f13228a = new ThreadPoolExecutor(i2, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(str, false));
    }

    public e(String str, int i, boolean z) {
        this.f13228a = new ThreadPoolExecutor(0, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(str, z));
    }

    public static void a(a aVar) {
        c.a(aVar);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f13228a.execute(runnable);
    }
}
