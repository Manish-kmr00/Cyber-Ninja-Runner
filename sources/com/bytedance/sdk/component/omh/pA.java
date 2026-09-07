package com.bytedance.sdk.component.omh;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.WV;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes12.dex */
class pA extends ThreadPoolExecutor {
    private String pA;

    public pA(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.pA = str;
    }

    private void pA(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            pA(runnable, e);
        } catch (Throwable th) {
            pA(runnable, th);
        }
    }

    private void pA(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        pA(runnable, (Throwable) outOfMemoryError);
    }

    private void pA(Runnable runnable, Throwable th) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                runnable.run();
            } catch (Throwable th2) {
                WV.pA("", "try exc failed", th2);
            }
        }
    }

    private void pA(BlockingQueue<Runnable> blockingQueue, int i) {
        if (getCorePoolSize() == i || blockingQueue == null || blockingQueue.size() > 0) {
            return;
        }
        try {
            setCorePoolSize(i);
            new Object[]{"reduceCoreThreadSize: reduce poolType =  ", this.pA, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize())};
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void pA(BlockingQueue<Runnable> blockingQueue, int i, int i2) {
        if (getCorePoolSize() == i || blockingQueue == null || blockingQueue.size() < i2) {
            return;
        }
        try {
            setCorePoolSize(i);
            new Object[]{"increaseCoreThreadSize: increase poolType =  ", this.pA, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize())};
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof omh) {
            pA(new Og((omh) runnable, this));
        } else {
            pA(new Og(new omh("unknown") { // from class: com.bytedance.sdk.component.omh.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (!JG.SD() || TextUtils.isEmpty(this.pA) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.pA;
        str.hashCode();
        switch (str) {
            case "io":
                pA(queue, JG.pA + 2, getCorePoolSize() * 2);
                break;
            case "log":
                pA(queue, 8, 8);
                break;
            case "aidl":
                pA(queue, 5, 5);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!JG.SD() || TextUtils.isEmpty(this.pA) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.pA;
        str.hashCode();
        switch (str) {
            case "io":
                pA(queue, 2);
                break;
            case "log":
                pA(queue, 4);
                break;
            case "aidl":
                pA(queue, 2);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if ("io".equals(this.pA) || "aidl".equals(this.pA)) {
            return Collections.emptyList();
        }
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.pA) || "aidl".equals(this.pA)) {
            return;
        }
        super.shutdown();
    }

    public String pA() {
        return this.pA;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.omh.pA$pA, reason: collision with other inner class name */
    public static class C0206pA {
        private RejectedExecutionHandler omh;
        private String pA = "io";
        private int Og = 1;
        private long KZx = 30;
        private TimeUnit ZZv = TimeUnit.SECONDS;
        private int ML = Integer.MAX_VALUE;
        private BlockingQueue<Runnable> JG = null;
        private ThreadFactory SD = null;
        private int Bzk = 5;

        public C0206pA pA(String str) {
            this.pA = str;
            return this;
        }

        public C0206pA pA(int i) {
            this.Og = i;
            return this;
        }

        public C0206pA pA(long j) {
            this.KZx = j;
            return this;
        }

        public C0206pA pA(TimeUnit timeUnit) {
            this.ZZv = timeUnit;
            return this;
        }

        public C0206pA pA(BlockingQueue<Runnable> blockingQueue) {
            this.JG = blockingQueue;
            return this;
        }

        public C0206pA pA(ThreadFactory threadFactory) {
            this.SD = threadFactory;
            return this;
        }

        public C0206pA pA(RejectedExecutionHandler rejectedExecutionHandler) {
            this.omh = rejectedExecutionHandler;
            return this;
        }

        public C0206pA Og(int i) {
            this.Bzk = i;
            return this;
        }

        public pA pA() {
            if (this.SD == null) {
                this.SD = ML.pA().createThreadFactory(this.Bzk, this.pA);
            }
            if (this.omh == null) {
                this.omh = JG.omh();
            }
            if (this.JG == null) {
                this.JG = new LinkedBlockingQueue();
            }
            return new pA(this.pA, this.Og, this.ML, this.KZx, this.ZZv, this.JG, this.SD, this.omh);
        }
    }
}
