package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class Kc {
    public static final int d;
    public static final int e;
    public static final Jc f;
    public static final LinkedBlockingQueue g;
    public static ThreadPoolExecutor h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CountDownLatch f3119a;
    public final S8 b;
    public final WeakReference c;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        d = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        e = (iAvailableProcessors * 2) + 1;
        f = new Jc();
        g = new LinkedBlockingQueue(128);
    }

    public Kc(Ic vastMediaFile, int i, CountDownLatch countDownLatch) {
        Intrinsics.checkNotNullParameter(vastMediaFile, "vastMediaFile");
        S8 s8 = new S8(vastMediaFile.f3100a, null);
        this.b = s8;
        s8.t = false;
        s8.u = false;
        s8.x = false;
        s8.p = i;
        s8.s = true;
        this.c = new WeakReference(vastMediaFile);
        this.f3119a = countDownLatch;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(d, e, 30L, TimeUnit.SECONDS, g, f);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        h = threadPoolExecutor;
    }

    public final void a() {
        ThreadPoolExecutor threadPoolExecutor = h;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.execute(new Runnable() { // from class: com.inmobi.media.Kc$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Kc.a(this.f$0);
                }
            });
        }
    }

    public static final void a(Kc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            T8 t8B = this$0.b.b();
            if (t8B.b()) {
                CountDownLatch countDownLatch = this$0.f3119a;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            } else {
                this$0.a(t8B);
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("Kc", "TAG");
            I3 errorCode = I3.e;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            this$0.getClass();
            CountDownLatch countDownLatch2 = this$0.f3119a;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
        }
    }

    public final void a(T8 t8) {
        CountDownLatch countDownLatch;
        try {
            try {
                Ic ic = (Ic) this.c.get();
                if (ic != null) {
                    ic.c = (((double) t8.d) * 1.0d) / ((double) 1048576);
                }
                countDownLatch = this.f3119a;
                if (countDownLatch == null) {
                    return;
                }
            } catch (Exception e2) {
                C3339d5 c3339d5 = C3339d5.f3292a;
                P1 event = new P1(e2);
                Intrinsics.checkNotNullParameter(event, "event");
                C3339d5.c.a(event);
                countDownLatch = this.f3119a;
                if (countDownLatch == null) {
                    return;
                }
            }
            countDownLatch.countDown();
        } catch (Throwable th) {
            CountDownLatch countDownLatch2 = this.f3119a;
            if (countDownLatch2 != null) {
                countDownLatch2.countDown();
            }
            throw th;
        }
    }
}
