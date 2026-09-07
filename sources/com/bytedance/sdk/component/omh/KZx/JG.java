package com.bytedance.sdk.component.omh.KZx;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.WV;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes2.dex */
public class JG extends ThreadPoolExecutor {
    private int JG;
    private int KZx;
    private int ML;
    private int Og;
    private boolean SD;
    private int ZZv;
    private LinkedHashMap<String, com.bytedance.sdk.component.omh.KZx.pA.pA> omh;
    private final String pA;

    private JG(pA pAVar) {
        super(pAVar.Og, Integer.MAX_VALUE, pAVar.ML, pAVar.SD, (BlockingQueue<Runnable>) pAVar.BSW, pAVar.WV);
        this.SD = false;
        new Object[]{"create poolType = ", pAVar.pA, " coreSize=", Integer.valueOf(pAVar.Og), " maxSize=", Integer.valueOf(pAVar.KZx), " keepAlive=", Long.valueOf(pAVar.ML), " createSize=", Integer.valueOf(pAVar.ZZv), "  logTaskCount=", Integer.valueOf(pAVar.Bzk), " isUseConfig=", Boolean.valueOf(pAVar.SGo), "  workQueue", pAVar.BSW};
        this.pA = pAVar.pA;
        this.ZZv = pAVar.Og;
        this.ML = pAVar.KZx;
        this.JG = pAVar.ZZv;
        allowCoreThreadTimeOut(pAVar.JG);
        this.Og = pAVar.omh;
        this.KZx = pAVar.Bzk;
        this.SD = pAVar.SGo;
        if (SD()) {
            final int i = this.KZx + 4;
            this.omh = new LinkedHashMap<String, com.bytedance.sdk.component.omh.KZx.pA.pA>(i, 0.75f, true) { // from class: com.bytedance.sdk.component.omh.KZx.JG.1
                @Override // java.util.LinkedHashMap
                protected boolean removeEldestEntry(Map.Entry<String, com.bytedance.sdk.component.omh.KZx.pA.pA> entry) {
                    return size() > i;
                }
            };
        }
    }

    public void pA(pA pAVar) {
        try {
            if (pAVar.Og >= 0 && this.ZZv != pAVar.Og) {
                int i = pAVar.Og;
                this.ZZv = i;
                setCorePoolSize(i);
            }
            this.ML = pAVar.KZx;
            this.JG = pAVar.ZZv;
            allowCoreThreadTimeOut(pAVar.JG);
            this.Og = pAVar.omh;
            this.KZx = pAVar.Bzk;
            this.SD = pAVar.SGo;
        } catch (Throwable th) {
            WV.pA("PAGThreadPoolExecutor", th.getMessage());
        }
        new Object[]{"update poolType = ", pAVar.pA, " coreSize=", Integer.valueOf(pAVar.Og), " maxSize=", Integer.valueOf(pAVar.KZx), " keepAlive=", Long.valueOf(pAVar.ML), " createSize=", Integer.valueOf(pAVar.ZZv), "  logTaskCount=", Integer.valueOf(pAVar.Bzk), " isUseConfig=", Boolean.valueOf(pAVar.SGo), "  workQueue", pAVar.BSW};
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        if (runnable instanceof Og) {
            ((Og) runnable).Og(SystemClock.elapsedRealtime());
        }
        super.beforeExecute(thread, runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        boolean z = runnable instanceof Og;
        if (z) {
            ((Og) runnable).KZx(SystemClock.elapsedRealtime());
            try {
                if (SD() && this.omh != null) {
                    pA((Og) runnable);
                    JG();
                }
            } catch (Exception e) {
                WV.pA("PAGThreadPoolExecutor", e.getMessage());
            }
        }
        super.afterExecute(runnable, th);
        if (z) {
            Og og = (Og) runnable;
            new Object[]{"submit  poolType = ", this.pA, " taskName=", og.Og(), "    ", "priority = ", Integer.valueOf(og.pA()), " SubmitTimestamp=", Long.valueOf(og.KZx()), "  BeforeTimestamp=", Long.valueOf(og.ZZv()), "  AfterTimestamp=", Long.valueOf(og.ML())};
        }
        ML();
    }

    private void ZZv() {
        int corePoolSize;
        try {
            if (this.ZZv != 0 && (corePoolSize = getCorePoolSize()) < this.ML) {
                int size = getQueue().size();
                if (getActiveCount() < this.ZZv || size < this.JG) {
                    return;
                }
                setCorePoolSize(this.ML);
                new Object[]{this.pA, " increaseToMaxThread  queueSize=", Integer.valueOf(size), "    ", Integer.valueOf(corePoolSize), " --> ", Integer.valueOf(this.ML)};
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void ML() {
        int corePoolSize;
        int size;
        try {
            if (this.ZZv != 0 && (corePoolSize = getCorePoolSize()) > this.ZZv && (size = getQueue().size()) == 0) {
                setCorePoolSize(this.ZZv);
                new Object[]{this.pA, " reduceToCoreThread  queueSize=", Integer.valueOf(size), "    ", Integer.valueOf(corePoolSize), " --> ", Integer.valueOf(this.ZZv)};
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        int iPA;
        String strOg;
        runnable.getClass();
        final RunnableFuture runnableFutureNewTaskFor = newTaskFor(runnable, null);
        if (!(runnable instanceof Og)) {
            iPA = 6;
            strOg = "";
        } else {
            Og og = (Og) runnable;
            iPA = og.pA();
            strOg = og.Og();
        }
        if (iPA == 0 || TextUtils.isEmpty(strOg)) {
            new RuntimeException();
        }
        execute(new Og(iPA, strOg) { // from class: com.bytedance.sdk.component.omh.KZx.JG.2
            @Override // java.lang.Runnable
            public void run() {
                runnableFutureNewTaskFor.run();
            }
        });
        return runnableFutureNewTaskFor;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bytedance.sdk.component.omh.KZx.pA pAVarOg;
        if (!(runnable instanceof Og)) {
            runnable = new Og("unknown", runnable) { // from class: com.bytedance.sdk.component.omh.KZx.JG.3
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnableOmh = omh();
                    if (runnableOmh != null) {
                        runnableOmh.run();
                    }
                }
            };
        }
        if (!Reporting.EventType.CACHE.equals(this.pA)) {
            String name = Thread.currentThread().getName();
            if (!TextUtils.isEmpty(name) && name.startsWith(ZZv.pA(this.pA)) && (pAVarOg = KZx.Og()) != null) {
                pAVarOg.pA(this, (Og) runnable);
            }
        }
        ((Og) runnable).pA(SystemClock.elapsedRealtime());
        try {
            super.execute(runnable);
            ZZv();
        } catch (Throwable th) {
            pA(runnable, th);
        }
    }

    private void pA(Runnable runnable, Throwable th) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Handler handlerKZx = KZx.KZx();
                if (handlerKZx != null) {
                    handlerKZx.post(runnable);
                    return;
                }
                return;
            }
            runnable.run();
        } catch (Throwable th2) {
            WV.pA("PAGThreadPoolExecutor", "try exc failed", th2);
        }
    }

    private void pA(Og og) {
        LinkedHashMap<String, com.bytedance.sdk.component.omh.KZx.pA.pA> linkedHashMap = this.omh;
        if (linkedHashMap != null) {
            com.bytedance.sdk.component.omh.KZx.pA.pA pAVar = linkedHashMap.get(og.Og());
            if (pAVar == null) {
                synchronized (linkedHashMap) {
                    pAVar = linkedHashMap.get(og.Og());
                    if (pAVar == null) {
                        pAVar = new com.bytedance.sdk.component.omh.KZx.pA.pA();
                        linkedHashMap.put(og.Og(), pAVar);
                    }
                }
            }
            pAVar.pA(og);
        }
    }

    public LinkedHashMap<String, com.bytedance.sdk.component.omh.KZx.pA.pA> pA() {
        return this.omh;
    }

    private void JG() {
        if (getCompletedTaskCount() > this.Og) {
            ML mlPA = KZx.pA();
            if (mlPA != null) {
                mlPA.pA(this);
            }
            this.Og = -1;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        if ("aidl".equals(this.pA)) {
            return Collections.emptyList();
        }
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("aidl".equals(this.pA)) {
            return;
        }
        super.shutdown();
    }

    public String Og() {
        return this.pA;
    }

    private boolean SD() {
        return this.Og > 0;
    }

    public boolean KZx() {
        return this.SD;
    }

    public static class pA {
        private String pA = Reporting.EventType.CACHE;
        private int Og = 4;
        private int KZx = 100;
        private int ZZv = 0;
        private long ML = 30000;
        private boolean JG = false;
        private TimeUnit SD = TimeUnit.MILLISECONDS;
        private int omh = -1;
        private int Bzk = 20;
        private boolean SGo = false;
        private BlockingQueue<Runnable> BSW = new PriorityBlockingQueue();
        private ThreadFactory WV = null;

        public pA pA(String str) {
            this.pA = str;
            return this;
        }

        public pA pA(int i) {
            this.Og = i;
            return this;
        }

        public pA Og(int i) {
            this.KZx = i;
            return this;
        }

        public pA KZx(int i) {
            this.ZZv = i;
            return this;
        }

        public pA pA(long j) {
            this.ML = j;
            return this;
        }

        public pA pA(boolean z) {
            this.JG = z;
            return this;
        }

        public pA ZZv(int i) {
            this.Bzk = i;
            return this;
        }

        public pA ML(int i) {
            this.omh = i;
            return this;
        }

        public pA Og(boolean z) {
            this.SGo = z;
            return this;
        }

        public JG pA() {
            if (this.WV == null) {
                this.WV = new ZZv(this.pA);
            }
            if (this.Og < 0) {
                this.Og = 8;
            }
            if (this.Og == 0) {
                this.BSW = new SynchronousQueue();
            }
            if (this.BSW == null) {
                this.BSW = new LinkedBlockingQueue();
            }
            if (this.KZx > 100) {
                this.KZx = 100;
            }
            int i = this.KZx;
            int i2 = this.Og;
            if (i < i2) {
                this.KZx = i2;
            }
            if (this.Bzk < 0) {
                this.Bzk = 20;
            }
            if (this.Bzk > 100) {
                this.Bzk = 100;
            }
            return new JG(this);
        }
    }
}
