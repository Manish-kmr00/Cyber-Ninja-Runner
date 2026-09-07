package com.bytedance.sdk.openadsdk.BF.Og;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes13.dex */
public abstract class Og {
    private volatile boolean Bzk = false;
    private final ML.pA JG;
    protected final AtomicBoolean KZx;
    private final AtomicBoolean ML;
    protected yFO Og;
    private final int SD;
    private final AtomicLong ZZv;
    private final Integer omh;
    protected WeakReference<View> pA;

    public abstract int JG();

    protected abstract boolean KZx();

    protected abstract void Og(int i);

    public static Og pA(boolean z, Integer num, View view, yFO yfo, ML.pA pAVar) {
        return z ? new omh(num, view, yfo, pAVar) : new KZx(num, view, yfo, pAVar);
    }

    public Og(Integer num, View view, yFO yfo, int i, ML.pA pAVar) {
        this.omh = num;
        this.SD = i;
        this.Og = yfo;
        this.JG = pAVar;
        pA(view);
        this.KZx = new AtomicBoolean(false);
        this.ZZv = new AtomicLong(-1L);
        this.ML = new AtomicBoolean(false);
    }

    public void pA() {
        if (this.KZx.compareAndSet(false, true)) {
            SD.pA(this);
        }
    }

    public int Og() {
        if (Bzk()) {
            return 1;
        }
        WeakReference<View> weakReference = this.pA;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null || this.Bzk) {
            return 3;
        }
        if (BSW().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI))) {
            return (BSW().equals(view.getTag(InputDeviceCompat.SOURCE_HDMI)) && KZx()) ? 1 : 2;
        }
        SGo();
        ML.Og(BSW());
        return 3;
    }

    protected void ZZv() {
        if (this.ML.compareAndSet(false, true)) {
            ZZv.pA(this.Og, ML(), this.JG);
        }
    }

    protected pA ML() {
        WeakReference<View> weakReference = this.pA;
        if (weakReference == null) {
            return new pA(-1, -1, -1.0f);
        }
        View view = weakReference.get();
        if (view == null) {
            return new pA(0, 0, 0.0f);
        }
        return new pA(view.getWidth(), view.getHeight(), view.getAlpha());
    }

    public void SD() {
        if (Bzk()) {
            return;
        }
        if (!this.KZx.get()) {
            omh();
        } else if (!this.ZZv.compareAndSet(-1L, System.currentTimeMillis()) && System.currentTimeMillis() - this.ZZv.get() >= this.SD) {
            ZZv();
        }
    }

    public void omh() {
        this.ZZv.set(-1L);
    }

    public boolean Bzk() {
        return this.ML.get();
    }

    public void SGo() {
        this.Bzk = true;
        SD.Og(this);
    }

    public void pA(int i) {
        if (i == 4) {
            pA();
            return;
        }
        if (i == 8) {
            Wx();
        } else if (i == 9) {
            ZZv();
        } else {
            Og(i);
        }
    }

    public Integer BSW() {
        return this.omh;
    }

    public boolean WV() {
        return this.KZx.get();
    }

    public void Wx() {
        this.KZx.set(false);
        omh();
    }

    public void pA(View view) {
        if (view != null) {
            view.setTag(InputDeviceCompat.SOURCE_HDMI, BSW());
        }
        this.pA = new WeakReference<>(view);
    }
}
