package com.bytedance.sdk.component.omh;

import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: loaded from: classes3.dex */
public class JG extends ML {
    private static volatile ScheduledExecutorService BSW;
    private static volatile ThreadPoolExecutor Bzk;
    private static volatile ThreadPoolExecutor JG;
    private static volatile ThreadPoolExecutor ML;
    public static KZx Og;
    private static volatile ThreadPoolExecutor SD;
    private static volatile ThreadPoolExecutor SGo;
    private static volatile ThreadPoolExecutor omh;
    public static final int pA = Runtime.getRuntime().availableProcessors();
    public static int KZx = 120;
    public static boolean ZZv = true;

    public static ExecutorService Og() {
        if (ML == null) {
            synchronized (JG.class) {
                if (ML == null) {
                    ML = new pA.C0206pA().pA("init").pA(0).Og(10).pA(5L).pA(TimeUnit.SECONDS).pA(new SynchronousQueue()).pA(omh()).pA(pA().createThreadFactory(10, "init")).pA();
                }
            }
        }
        return ML;
    }

    public static void pA(omh omhVar) {
        if (ML == null) {
            Og();
        }
        if (omhVar == null || ML == null) {
            return;
        }
        ML.execute(omhVar);
    }

    public static ExecutorService KZx() {
        return pA(10);
    }

    public static ExecutorService pA(int i) {
        if (JG == null) {
            synchronized (JG.class) {
                if (JG == null) {
                    pA pAVarPA = new pA.C0206pA().pA("io").pA(2).Og(i).pA(20L).pA(TimeUnit.SECONDS).pA(new LinkedBlockingQueue()).pA(omh()).pA(pA().createThreadFactory(i, "io")).pA();
                    JG = pAVarPA;
                    pAVarPA.allowCoreThreadTimeOut(true);
                }
            }
        }
        return JG;
    }

    public static void Og(omh omhVar) {
        if (JG == null) {
            KZx();
        }
        if (JG != null) {
            JG.execute(omhVar);
        }
    }

    public static void pA(omh omhVar, int i) {
        Og(omhVar);
    }

    public static void pA(omh omhVar, int i, int i2) {
        if (JG == null) {
            pA(i2);
        }
        if (omhVar == null || JG == null) {
            return;
        }
        omhVar.setPriority(i);
        JG.execute(omhVar);
    }

    public static ExecutorService ZZv() {
        if (omh == null) {
            synchronized (JG.class) {
                if (omh == null) {
                    pA pAVarPA = new pA.C0206pA().pA(CreativeInfo.f).Og(10).pA(4).pA(20L).pA(TimeUnit.SECONDS).pA(new PriorityBlockingQueue()).pA(omh()).pA(pA().createThreadFactory(10, CreativeInfo.f)).pA();
                    omh = pAVarPA;
                    pAVarPA.allowCoreThreadTimeOut(true);
                }
            }
        }
        return omh;
    }

    public static void KZx(omh omhVar) {
        if (omh == null) {
            ZZv();
        }
        if (omhVar == null || omh == null) {
            return;
        }
        omh.execute(omhVar);
    }

    public static void Og(omh omhVar, int i) {
        if (omhVar != null) {
            omhVar.setPriority(i);
        }
        KZx(omhVar);
    }

    public static ExecutorService ML() {
        if (SGo == null) {
            synchronized (JG.class) {
                if (SGo == null) {
                    pA pAVarPA = new pA.C0206pA().pA("aidl").Og(10).pA(2).pA(30L).pA(TimeUnit.SECONDS).pA(new PriorityBlockingQueue()).pA(omh()).pA(pA().createThreadFactory(10, "aidl")).pA();
                    SGo = pAVarPA;
                    pAVarPA.allowCoreThreadTimeOut(true);
                }
            }
        }
        return SGo;
    }

    public static void ZZv(omh omhVar) {
        if (SGo == null) {
            ML();
        }
        if (omhVar == null || SGo == null) {
            return;
        }
        SGo.execute(omhVar);
    }

    public static void KZx(omh omhVar, int i) {
        if (omhVar != null) {
            omhVar.setPriority(i);
        }
        ZZv(omhVar);
    }

    public static ScheduledExecutorService JG() {
        if (BSW == null) {
            synchronized (JG.class) {
                if (BSW == null) {
                    BSW = Executors.newSingleThreadScheduledExecutor(pA().createThreadFactory(5, "scheduled"));
                }
            }
        }
        return BSW;
    }

    public static boolean SD() {
        return ZZv;
    }

    public static void pA(boolean z) {
        ZZv = z;
    }

    public static RejectedExecutionHandler omh() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.omh.JG.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static KZx Bzk() {
        return Og;
    }

    public static void pA(KZx kZx) {
        Og = kZx;
    }

    public static ExecutorService Og(int i) {
        if (SD == null) {
            synchronized (JG.class) {
                if (SD == null) {
                    pA pAVarPA = new pA.C0206pA().pA(Reporting.Key.CLICK_SOURCE_TYPE_AD).pA(2).Og(i).pA(20L).pA(TimeUnit.SECONDS).pA(new LinkedBlockingQueue()).pA(omh()).pA(pA().createThreadFactory(i, Reporting.Key.CLICK_SOURCE_TYPE_AD)).pA();
                    SD = pAVarPA;
                    pAVarPA.allowCoreThreadTimeOut(true);
                }
            }
        }
        return SD;
    }

    public static void ML(omh omhVar) {
        if (SD == null) {
            Og(5);
        }
        if (omhVar == null || SD == null) {
            return;
        }
        SD.execute(omhVar);
    }

    public static ExecutorService SGo() {
        if (Bzk == null) {
            synchronized (JG.class) {
                if (Bzk == null) {
                    pA pAVarPA = new pA.C0206pA().pA("computation").pA(3).Og(10).pA(20L).pA(TimeUnit.SECONDS).pA(new PriorityBlockingQueue()).pA(omh()).pA(pA().createThreadFactory(10, "computation")).pA();
                    Bzk = pAVarPA;
                    pAVarPA.allowCoreThreadTimeOut(true);
                }
            }
        }
        return Bzk;
    }

    public static void KZx(int i) {
        KZx = i;
    }
}
