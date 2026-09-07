package com.bytedance.adsdk.Og.JG;

import android.view.Choreographer;
import com.bytedance.adsdk.Og.SD;

/* JADX INFO: loaded from: classes9.dex */
public class KZx extends pA implements Choreographer.FrameCallback {
    private SD SGo;
    private float Og = 1.0f;
    private boolean KZx = false;
    private long ZZv = 0;
    private float ML = 0.0f;
    private float JG = 0.0f;
    private int SD = 0;
    private float omh = -2.1474836E9f;
    private float Bzk = 2.1474836E9f;
    protected boolean pA = false;
    private boolean BSW = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(JG());
    }

    public float JG() {
        SD sd = this.SGo;
        if (sd == null) {
            return 0.0f;
        }
        return (this.JG - sd.JG()) / (this.SGo.SD() - this.SGo.JG());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fDX;
        float fOX;
        float fDX2;
        if (this.SGo == null) {
            return 0.0f;
        }
        if (vZF()) {
            fDX = oX() - this.JG;
            fOX = oX();
            fDX2 = DX();
        } else {
            fDX = this.JG - DX();
            fOX = oX();
            fDX2 = DX();
        }
        return fDX / (fOX - fDX2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        SD sd = this.SGo;
        if (sd == null) {
            return 0L;
        }
        return (long) sd.ML();
    }

    public float SD() {
        return this.JG;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.pA;
    }

    public void KZx(boolean z) {
        this.BSW = z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        aBv();
        if (this.SGo == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.Og.ML.pA("LottieValueAnimator#doFrame");
        long j2 = this.ZZv;
        float fYFO = (j2 != 0 ? j - j2 : 0L) / yFO();
        float f = this.ML;
        if (vZF()) {
            fYFO = -fYFO;
        }
        float f2 = f + fYFO;
        boolean zKZx = ML.KZx(f2, DX(), oX());
        float f3 = this.ML;
        float fOg = ML.Og(f2, DX(), oX());
        this.ML = fOg;
        if (this.BSW) {
            fOg = (float) Math.floor(fOg);
        }
        this.JG = fOg;
        this.ZZv = j;
        if (!this.BSW || this.ML != f3) {
            KZx();
        }
        if (!zKZx) {
            if (getRepeatCount() != -1 && this.SD >= getRepeatCount()) {
                float fDX = this.Og < 0.0f ? DX() : oX();
                this.ML = fDX;
                this.JG = fDX;
                XT();
                Og(vZF());
            } else {
                pA();
                this.SD++;
                if (getRepeatMode() == 2) {
                    this.KZx = !this.KZx;
                    Bzk();
                } else {
                    float fOX = vZF() ? oX() : DX();
                    this.ML = fOX;
                    this.JG = fOX;
                }
                this.ZZv = j;
            }
        }
        Sd();
        com.bytedance.adsdk.Og.ML.Og("LottieValueAnimator#doFrame");
    }

    private float yFO() {
        SD sd = this.SGo;
        if (sd == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / sd.WV()) / Math.abs(this.Og);
    }

    public void omh() {
        this.SGo = null;
        this.omh = -2.1474836E9f;
        this.Bzk = 2.1474836E9f;
    }

    public void pA(SD sd) {
        boolean z = this.SGo == null;
        this.SGo = sd;
        if (z) {
            pA(Math.max(this.omh, sd.JG()), Math.min(this.Bzk, sd.SD()));
        } else {
            pA((int) sd.JG(), (int) sd.SD());
        }
        float f = this.JG;
        this.JG = 0.0f;
        this.ML = 0.0f;
        pA((int) f);
        KZx();
    }

    public void pA(float f) {
        if (this.ML == f) {
            return;
        }
        float fOg = ML.Og(f, DX(), oX());
        this.ML = fOg;
        if (this.BSW) {
            fOg = (float) Math.floor(fOg);
        }
        this.JG = fOg;
        this.ZZv = 0L;
        KZx();
    }

    public void pA(int i) {
        pA(i, (int) this.Bzk);
    }

    public void Og(float f) {
        pA(this.omh, f);
    }

    public void pA(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        SD sd = this.SGo;
        float fJG = sd == null ? -3.4028235E38f : sd.JG();
        SD sd2 = this.SGo;
        float fSD = sd2 == null ? Float.MAX_VALUE : sd2.SD();
        float fOg = ML.Og(f, fJG, fSD);
        float fOg2 = ML.Og(f2, fJG, fSD);
        if (fOg == this.omh && fOg2 == this.Bzk) {
            return;
        }
        this.omh = fOg;
        this.Bzk = fOg2;
        pA((int) ML.Og(this.JG, fOg, fOg2));
    }

    public void Bzk() {
        KZx(-SGo());
    }

    public void KZx(float f) {
        this.Og = f;
    }

    public float SGo() {
        return this.Og;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.KZx) {
            return;
        }
        this.KZx = false;
        Bzk();
    }

    public void BSW() {
        this.pA = true;
        pA(vZF());
        pA((int) (vZF() ? oX() : DX()));
        this.ZZv = 0L;
        this.SD = 0;
        aBv();
    }

    public void WV() {
        XT();
        Og(vZF());
    }

    public void Wx() {
        XT();
        ZZv();
    }

    public void Sn() {
        this.pA = true;
        aBv();
        this.ZZv = 0L;
        if (vZF() && SD() == DX()) {
            pA(oX());
        } else if (!vZF() && SD() == oX()) {
            pA(DX());
        }
        ML();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        Og();
        XT();
    }

    private boolean vZF() {
        return SGo() < 0.0f;
    }

    public float DX() {
        SD sd = this.SGo;
        if (sd == null) {
            return 0.0f;
        }
        float f = this.omh;
        return f == -2.1474836E9f ? sd.JG() : f;
    }

    public float oX() {
        SD sd = this.SGo;
        if (sd == null) {
            return 0.0f;
        }
        float f = this.Bzk;
        return f == 2.1474836E9f ? sd.SD() : f;
    }

    @Override // com.bytedance.adsdk.Og.JG.pA
    void Og() {
        super.Og();
        Og(vZF());
    }

    protected void aBv() {
        if (isRunning()) {
            ZZv(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void XT() {
        ZZv(true);
    }

    protected void ZZv(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.pA = false;
        }
    }

    private void Sd() {
        if (this.SGo == null) {
            return;
        }
        float f = this.JG;
        if (f < this.omh || f > this.Bzk) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.omh), Float.valueOf(this.Bzk), Float.valueOf(this.JG)));
        }
    }
}
