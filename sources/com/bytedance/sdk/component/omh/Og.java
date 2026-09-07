package com.bytedance.sdk.component.omh;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.WV;

/* JADX INFO: loaded from: classes13.dex */
class Og implements Comparable, Runnable {
    private long KZx;
    private pA Og;
    private Thread ZZv = null;
    private omh pA;

    public Og(omh omhVar, pA pAVar) {
        this.KZx = 0L;
        this.pA = omhVar;
        this.Og = pAVar;
        this.KZx = SystemClock.uptimeMillis();
    }

    @Override // java.lang.Runnable
    public void run() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.KZx;
        this.ZZv = Thread.currentThread();
        omh omhVar = this.pA;
        if (omhVar != null) {
            omhVar.run();
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        if (this.Og != null) {
            ZZv.pA();
        }
        if (WV.pA()) {
            pA pAVar = this.Og;
            String strPA = pAVar != null ? pAVar.pA() : "null";
            Long lValueOf = Long.valueOf(j);
            Long lValueOf2 = Long.valueOf(jUptimeMillis2);
            omh omhVar2 = this.pA;
            new Object[]{"run: pool  = ", strPA, " waitTime =", lValueOf, " taskCost = ", lValueOf2, " name=", omhVar2 != null ? omhVar2.getName() : "null"};
            String strPA2 = this.Og.pA();
            strPA2.hashCode();
            switch (strPA2) {
                case "ad":
                case "init":
                    if (jUptimeMillis2 > 2000) {
                        pA pAVar2 = this.Og;
                        String strPA3 = pAVar2 != null ? pAVar2.pA() : "null";
                        omh omhVar3 = this.pA;
                        pA(strPA3, omhVar3 != null ? omhVar3.getName() : "null", jUptimeMillis2);
                        break;
                    }
                    break;
                case "io":
                    if (jUptimeMillis2 > 5000) {
                        pA pAVar3 = this.Og;
                        String strPA4 = pAVar3 != null ? pAVar3.pA() : "null";
                        omh omhVar4 = this.pA;
                        pA(strPA4, omhVar4 != null ? omhVar4.getName() : "null", jUptimeMillis2);
                        break;
                    }
                    break;
                case "log":
                    if (jUptimeMillis2 > 3000) {
                        pA pAVar4 = this.Og;
                        String strPA5 = pAVar4 != null ? pAVar4.pA() : "null";
                        omh omhVar5 = this.pA;
                        pA(strPA5, omhVar5 != null ? omhVar5.getName() : "null", jUptimeMillis2);
                        break;
                    }
                    break;
                case "computation":
                    if (jUptimeMillis2 > 1000) {
                        pA pAVar5 = this.Og;
                        String strPA6 = pAVar5 != null ? pAVar5.pA() : "null";
                        omh omhVar6 = this.pA;
                        pA(strPA6, omhVar6 != null ? omhVar6.getName() : "null", jUptimeMillis2);
                        break;
                    }
                    break;
            }
        }
    }

    private void pA(String str, String str2, long j) {
        WV.pA("DelegateRunnable", "pool is " + str + "  name is " + str2 + "is timeout,cost " + j);
    }

    public omh pA() {
        return this.pA;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof Og) {
            return this.pA.compareTo(((Og) obj).pA());
        }
        return 0;
    }

    public int hashCode() {
        return this.pA.hashCode();
    }

    public boolean equals(Object obj) {
        omh omhVar;
        return (obj instanceof Og) && (omhVar = this.pA) != null && omhVar.equals(((Og) obj).pA());
    }
}
