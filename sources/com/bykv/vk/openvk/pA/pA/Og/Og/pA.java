package com.bykv.vk.openvk.pA.pA.Og.Og;

import com.google.common.net.HttpHeaders;
import io.ktor.client.utils.CacheControl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes9.dex */
abstract class pA implements BSW {
    private static final AtomicLong Wx = new AtomicLong();
    protected volatile Bzk Bzk;
    protected volatile List<Bzk.Og> JG;
    protected com.bykv.vk.openvk.pA.pA.Og.Og.ZZv.pA ML;
    protected final com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx Og;
    protected volatile String SD;
    protected volatile WV SGo;
    protected volatile String omh;
    protected volatile com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA pA;
    protected final AtomicInteger KZx = new AtomicInteger();
    protected final AtomicLong ZZv = new AtomicLong();
    protected volatile boolean BSW = false;
    public final long WV = Wx.incrementAndGet();
    private final AtomicInteger Sn = new AtomicInteger(0);
    private int DX = -1;

    public pA(com.bykv.vk.openvk.pA.pA.Og.Og.pA.pA pAVar, com.bykv.vk.openvk.pA.pA.Og.Og.Og.KZx kZx) {
        this.pA = pAVar;
        this.Og = kZx;
    }

    public void pA() {
        this.Sn.compareAndSet(0, 1);
    }

    public boolean Og() {
        return this.Sn.get() == 1;
    }

    protected void KZx() {
        this.Sn.compareAndSet(0, 2);
    }

    public boolean ZZv() {
        return this.Sn.get() == 2;
    }

    protected void ML() throws com.bykv.vk.openvk.pA.pA.Og.Og.KZx.pA {
        if (Og()) {
            throw new com.bykv.vk.openvk.pA.pA.Og.Og.KZx.pA();
        }
    }

    protected com.bykv.vk.openvk.pA.pA.Og.Og.ML.pA pA(WV.pA pAVar, int i, int i2, String str) throws IOException {
        com.bykv.vk.openvk.pA.pA.Og.Og.ML.Og Og = com.bykv.vk.openvk.pA.pA.Og.Og.ML.KZx.pA().Og();
        com.bykv.vk.openvk.pA.pA.Og.Og.ML.ML ml = new com.bykv.vk.openvk.pA.pA.Og.Og.ML.ML();
        HashMap map = new HashMap();
        ml.Og = pAVar.pA;
        ml.pA = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            ml.pA = 4;
        }
        List<Bzk.Og> list = this.JG;
        if (list != null && !list.isEmpty()) {
            for (Bzk.Og og : list) {
                if (!"Range".equalsIgnoreCase(og.pA) && !"Connection".equalsIgnoreCase(og.pA) && !"Proxy-Connection".equalsIgnoreCase(og.pA) && !HttpHeaders.HOST.equalsIgnoreCase(og.pA)) {
                    map.put(og.pA, og.Og);
                }
            }
        }
        String strPA = com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(i, i2);
        if (strPA != null) {
            map.put("Range", strPA);
        }
        if (ML.JG) {
            map.put("Cache-Control", CacheControl.NO_CACHE);
        }
        ZZv zZvKZx = ZZv.KZx();
        JG jgPA = JG.pA();
        boolean z = this.Bzk == null;
        KZx kZxPA = z ? zZvKZx.pA() : jgPA.Og();
        KZx kZxOg = z ? zZvKZx.Og() : jgPA.KZx();
        if ((kZxPA != null || kZxOg != null) && (kZxPA != null || kZxOg != null)) {
            throw null;
        }
        ml.ML = map;
        if (this.BSW) {
            this.BSW = false;
            return null;
        }
        return Og.pA(ml);
    }

    protected int JG() {
        if (this.Bzk != null) {
            return this.Bzk.KZx.pA;
        }
        return this.pA instanceof com.bykv.vk.openvk.pA.pA.Og.Og.pA.Og ? 1 : 0;
    }

    protected boolean SD() {
        return JG() == 1;
    }

    protected void pA(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = ML.SD;
        int iJG = JG();
        if (i3 == 1 || (i3 == 2 && iJG == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.DX) {
                    return;
                }
                this.DX = i4;
                com.bykv.vk.openvk.pA.pA.Og.KZx.pA.pA(new Runnable() { // from class: com.bykv.vk.openvk.pA.pA.Og.Og.pA.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (pA.this.ML != null) {
                            WV wv = pA.this.SGo;
                            int unused = pA.this.DX;
                        }
                    }
                });
            }
        }
    }
}
