package com.bykv.vk.openvk.pA.pA.Og.ZZv;

/* JADX INFO: loaded from: classes13.dex */
public abstract class pA implements KZx {
    private KZx.SD JG;
    private KZx.Og KZx;
    private KZx.JG ML;
    private KZx.ML Og;
    private KZx.InterfaceC0158KZx SD;
    private KZx.pA ZZv;
    private KZx.ZZv omh;
    protected boolean pA = false;

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public final void pA(KZx.ML ml) {
        this.Og = ml;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public final void pA(KZx.Og og) {
        this.KZx = og;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public final void pA(KZx.pA pAVar) {
        this.ZZv = pAVar;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public final void pA(KZx.JG jg) {
        this.ML = jg;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public final void pA(KZx.InterfaceC0158KZx interfaceC0158KZx) {
        this.SD = interfaceC0158KZx;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public final void pA(KZx.ZZv zZv) {
        this.omh = zZv;
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public final void pA(KZx.SD sd) {
        this.JG = sd;
    }

    public void pA() {
        this.Og = null;
        this.ZZv = null;
        this.KZx = null;
        this.ML = null;
        this.JG = null;
        this.SD = null;
        this.omh = null;
    }

    protected final void Og() {
        try {
            KZx.ML ml = this.Og;
            if (ml != null) {
                ml.Og(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void KZx() {
        try {
            KZx.Og og = this.KZx;
            if (og != null) {
                og.pA(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void pA(int i) {
        try {
            KZx.pA pAVar = this.ZZv;
            if (pAVar != null) {
                pAVar.pA(this, i);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void ZZv() {
        try {
            KZx.JG jg = this.ML;
            if (jg != null) {
                jg.KZx(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void pA(int i, int i2, int i3, int i4) {
        try {
            KZx.SD sd = this.JG;
            if (sd != null) {
                sd.pA(this, i, i2, i3, i4);
            }
        } catch (Throwable unused) {
        }
    }

    protected final boolean pA(int i, int i2) {
        try {
            KZx.InterfaceC0158KZx interfaceC0158KZx = this.SD;
            return interfaceC0158KZx != null && interfaceC0158KZx.pA(this, i, i2);
        } catch (Throwable unused) {
        }
    }

    protected final boolean Og(int i, int i2) {
        try {
            KZx.ZZv zZv = this.omh;
            return zZv != null && zZv.Og(this, i, i2);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.Og.ZZv.KZx
    public void pA(boolean z) {
        this.pA = z;
    }
}
