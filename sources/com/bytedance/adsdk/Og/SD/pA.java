package com.bytedance.adsdk.Og.SD;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.Og.SD;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes11.dex */
public class pA<T> {
    private float BSW;
    public PointF Bzk;
    private float DX;
    public final float JG;
    public final Interpolator KZx;
    public final Interpolator ML;
    public T Og;
    public Float SD;
    private final SD SGo;
    private int Sn;
    private float WV;
    private int Wx;
    public final Interpolator ZZv;
    private float oX;
    public PointF omh;
    public final T pA;

    public pA(SD sd, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.BSW = -3987645.8f;
        this.WV = -3987645.8f;
        this.Wx = 784923401;
        this.Sn = 784923401;
        this.DX = Float.MIN_VALUE;
        this.oX = Float.MIN_VALUE;
        this.omh = null;
        this.Bzk = null;
        this.SGo = sd;
        this.pA = t;
        this.Og = t2;
        this.KZx = interpolator;
        this.ZZv = null;
        this.ML = null;
        this.JG = f;
        this.SD = f2;
    }

    public pA(SD sd, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.BSW = -3987645.8f;
        this.WV = -3987645.8f;
        this.Wx = 784923401;
        this.Sn = 784923401;
        this.DX = Float.MIN_VALUE;
        this.oX = Float.MIN_VALUE;
        this.omh = null;
        this.Bzk = null;
        this.SGo = sd;
        this.pA = t;
        this.Og = t2;
        this.KZx = null;
        this.ZZv = interpolator;
        this.ML = interpolator2;
        this.JG = f;
        this.SD = f2;
    }

    protected pA(SD sd, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.BSW = -3987645.8f;
        this.WV = -3987645.8f;
        this.Wx = 784923401;
        this.Sn = 784923401;
        this.DX = Float.MIN_VALUE;
        this.oX = Float.MIN_VALUE;
        this.omh = null;
        this.Bzk = null;
        this.SGo = sd;
        this.pA = t;
        this.Og = t2;
        this.KZx = interpolator;
        this.ZZv = interpolator2;
        this.ML = interpolator3;
        this.JG = f;
        this.SD = f2;
    }

    public pA(T t) {
        this.BSW = -3987645.8f;
        this.WV = -3987645.8f;
        this.Wx = 784923401;
        this.Sn = 784923401;
        this.DX = Float.MIN_VALUE;
        this.oX = Float.MIN_VALUE;
        this.omh = null;
        this.Bzk = null;
        this.SGo = null;
        this.pA = t;
        this.Og = t;
        this.KZx = null;
        this.ZZv = null;
        this.ML = null;
        this.JG = Float.MIN_VALUE;
        this.SD = Float.valueOf(Float.MAX_VALUE);
    }

    private pA(T t, T t2) {
        this.BSW = -3987645.8f;
        this.WV = -3987645.8f;
        this.Wx = 784923401;
        this.Sn = 784923401;
        this.DX = Float.MIN_VALUE;
        this.oX = Float.MIN_VALUE;
        this.omh = null;
        this.Bzk = null;
        this.SGo = null;
        this.pA = t;
        this.Og = t2;
        this.KZx = null;
        this.ZZv = null;
        this.ML = null;
        this.JG = Float.MIN_VALUE;
        this.SD = Float.valueOf(Float.MAX_VALUE);
    }

    public pA<T> pA(T t, T t2) {
        return new pA<>(t, t2);
    }

    public float KZx() {
        SD sd = this.SGo;
        if (sd == null) {
            return 0.0f;
        }
        if (this.DX == Float.MIN_VALUE) {
            this.DX = (this.JG - sd.JG()) / this.SGo.aBv();
        }
        return this.DX;
    }

    public float ZZv() {
        if (this.SGo == null) {
            return 1.0f;
        }
        if (this.oX == Float.MIN_VALUE) {
            if (this.SD == null) {
                this.oX = 1.0f;
            } else {
                this.oX = KZx() + ((this.SD.floatValue() - this.JG) / this.SGo.aBv());
            }
        }
        return this.oX;
    }

    public boolean ML() {
        return this.KZx == null && this.ZZv == null && this.ML == null;
    }

    public boolean pA(float f) {
        return f >= KZx() && f < ZZv();
    }

    public float JG() {
        if (this.BSW == -3987645.8f) {
            this.BSW = ((Float) this.pA).floatValue();
        }
        return this.BSW;
    }

    public float SD() {
        if (this.WV == -3987645.8f) {
            this.WV = ((Float) this.Og).floatValue();
        }
        return this.WV;
    }

    public int omh() {
        if (this.Wx == 784923401) {
            this.Wx = ((Integer) this.pA).intValue();
        }
        return this.Wx;
    }

    public int Bzk() {
        if (this.Sn == 784923401) {
            this.Sn = ((Integer) this.Og).intValue();
        }
        return this.Sn;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.pA + ", endValue=" + this.Og + ", startFrame=" + this.JG + ", endFrame=" + this.SD + ", interpolator=" + this.KZx + AbstractJsonLexerKt.END_OBJ;
    }
}
