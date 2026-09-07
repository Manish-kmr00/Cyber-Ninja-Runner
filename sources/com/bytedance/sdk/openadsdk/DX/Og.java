package com.bytedance.sdk.openadsdk.DX;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class Og {
    public static int KZx = 1;
    public static int ML = 3;
    public static int Og = 0;
    public static int ZZv = 2;
    public static int pA = -1;
    private int JG = pA;
    private long SD = 0;
    private long omh = 0;
    private final List<KZx> Bzk = new ArrayList();
    private long SGo = 0;

    public void pA(long j) {
        this.JG = Og;
        this.SD = j;
    }

    public void Og(long j) {
        int i;
        int i2 = this.JG;
        if (i2 == pA || i2 == (i = ML)) {
            return;
        }
        this.JG = i;
        this.omh = j;
    }

    public void KZx(long j) {
        int i;
        int i2 = this.JG;
        if (i2 == pA || i2 == (i = ZZv) || i2 == ML) {
            return;
        }
        this.JG = i;
        this.SGo = j;
    }

    public void ZZv(long j) {
        int i = this.JG;
        if (i == pA || i != ZZv) {
            return;
        }
        this.JG = KZx;
        this.Bzk.add(new KZx(this.SGo, j));
        this.SGo = 0L;
    }

    public long pA(long j, long j2) {
        long j3;
        long j4;
        long jOg;
        long j5 = this.omh;
        if (j5 != 0 && j > j5) {
            return 0L;
        }
        int i = 0;
        for (KZx kZx : this.Bzk) {
            if (kZx.Og() > j) {
                if (j < kZx.pA()) {
                    j4 = i;
                    jOg = kZx.Og() - kZx.pA();
                } else {
                    j4 = i;
                    jOg = kZx.Og() - j;
                }
                i = (int) (j4 + jOg);
            }
        }
        long j6 = this.SD;
        if (j6 < j) {
            long j7 = this.SGo;
            if (j7 == 0) {
                j7 = this.omh;
                if (j7 == 0) {
                    j3 = j2 - j;
                }
            } else if (j7 <= j) {
                return 0L;
            }
            return (j7 - j) - ((long) i);
        }
        long j8 = this.SGo;
        if (j8 == 0) {
            j8 = this.omh;
            if (j8 == 0) {
                j3 = j2 - j6;
            }
        } else if (j8 <= j6) {
            return 0L;
        }
        return (j8 - j6) - ((long) i);
        return j3 - ((long) i);
    }

    public int pA() {
        return this.JG;
    }
}
