package com.bytedance.sdk.component.adexpress.pA.Og;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.component.utils.aBv;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class ML extends KZx {
    private static volatile ML Og;
    private static File pA;
    private AtomicBoolean KZx = new AtomicBoolean(true);
    private AtomicBoolean ZZv = new AtomicBoolean(false);
    private boolean ML = false;
    private AtomicBoolean JG = new AtomicBoolean(false);
    private AtomicInteger SD = new AtomicInteger(0);
    private AtomicLong omh = new AtomicLong();

    public static ML Og() {
        if (Og == null) {
            synchronized (ML.class) {
                if (Og == null) {
                    Og = new ML();
                }
            }
        }
        return Og;
    }

    private ML() {
        SGo();
    }

    public void KZx() {
        SGo();
    }

    private void SGo() {
        com.bytedance.sdk.component.adexpress.ZZv.ZZv.Og(new com.bytedance.sdk.component.omh.omh("init") { // from class: com.bytedance.sdk.component.adexpress.pA.Og.ML.1
            @Override // java.lang.Runnable
            public void run() {
                omh.pA();
                ML.this.KZx.set(false);
                ML.this.ZZv();
                ML.this.SD();
                if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx() == null || !aBv.pA(com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().Og())) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().KZx().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.pA.Og.ML.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx() != null) {
                            com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().ZZv();
                        }
                    }
                });
            }
        }, 10);
    }

    public void ZZv() {
        com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarOg = omh.Og();
        if (pAVarOg == null || !pAVarOg.SD()) {
            return;
        }
        boolean zPA = pA(pAVarOg);
        if (!zPA) {
            omh.ZZv();
        }
        this.ML = zPA;
    }

    public boolean pA(com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVar) {
        if (pAVar == null) {
            return false;
        }
        return pA(pAVar.pA()) || pA(pAVar.ML()) || pA(pAVar.JG());
    }

    public boolean ML() {
        return this.ML;
    }

    public com.bytedance.sdk.component.adexpress.pA.KZx.pA JG() {
        return omh.Og();
    }

    @Override // com.bytedance.sdk.component.adexpress.pA.Og.KZx
    public File pA() {
        return omh();
    }

    public void SD() {
        pA(false);
    }

    public void pA(boolean z) {
        List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> listPA;
        boolean z2;
        if (this.KZx.get()) {
            return;
        }
        try {
            if (this.ZZv.get()) {
                if (z) {
                    this.SD.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z3 = true;
            this.ZZv.set(true);
            com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarML = com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().ML();
            com.bytedance.sdk.component.adexpress.pA.KZx.pA pAVarOg = omh.Og();
            if (pAVarML != null && pAVarML.SD()) {
                if (!omh.Og(pAVarML)) {
                    this.ZZv.set(false);
                    this.omh.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx() != null) {
                    com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx().KZx().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.pA.Og.ML.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.ML.ML.pA().Og();
                        }
                    });
                }
                omh.pA(pAVarML);
                boolean zPA = (pAVarML.ML() == null || TextUtils.isEmpty(pAVarML.ML().pA())) ? false : pA(pAVarML.ML().pA());
                if (pAVarML.pA().size() != 0) {
                    listPA = pA(pAVarML, pAVarOg);
                    z2 = listPA != null;
                } else {
                    listPA = null;
                    z2 = zPA;
                }
                if (!zPA) {
                    List<com.bytedance.sdk.component.adexpress.pA.KZx.pA.C0204pA> listOg = Og(pAVarML, pAVarOg);
                    if (listPA == null || listOg == null) {
                        listPA = listOg;
                    } else {
                        listPA.addAll(listOg);
                    }
                    if (listOg == null) {
                        z3 = false;
                    }
                    if (listOg == null) {
                        this.ZZv.set(false);
                    }
                    z2 = z3;
                }
                if (z2 && pA(pAVarML)) {
                    omh.pA(pAVarML);
                    omh.KZx();
                    Og(listPA);
                }
                ZZv();
                this.ZZv.set(false);
                this.omh.set(System.currentTimeMillis());
                BSW();
                return;
            }
            this.ZZv.set(false);
            pA(109);
        } catch (Throwable unused) {
        }
    }

    private void BSW() {
        if (this.SD.getAndSet(0) <= 0 || System.currentTimeMillis() - this.omh.get() <= 600000) {
            return;
        }
        SD();
    }

    public static File omh() {
        if (pA == null) {
            try {
                File file = new File(new File(ZZv.pA(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                pA = file;
            } catch (Throwable th) {
                WV.pA("TemplateManager", "getTemplateDir error", th);
            }
        }
        return pA;
    }

    public void Og(boolean z) {
        this.JG.set(z);
    }

    public void Bzk() {
        this.JG.set(true);
        this.ML = false;
        this.ZZv.set(false);
    }
}
