package com.bytedance.adsdk.Og;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.Og.ML.BF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Bzk extends Drawable implements Animatable, Drawable.Callback {
    private boolean BF;
    private final ValueAnimator.AnimatorUpdateListener BSW;
    private Og Bzk;
    private Matrix CIG;
    private com.bytedance.adsdk.Og.Og.pA DX;
    private View FQ;
    private boolean Gx;
    private Rect IG;
    private boolean JG;
    vZF KZx;
    private final com.bytedance.adsdk.Og.JG.KZx ML;
    private Canvas Mc;
    KZx Og;
    private boolean SD;
    private final ArrayList<pA> SGo;
    private int Sd;
    private ZZv Sn;
    private Matrix SzT;
    private yFO TV;
    private boolean TX;
    private RectF Vgu;
    private boolean WQf;
    private com.bytedance.adsdk.Og.Og.Og WV;
    private String Wx;
    private boolean XT;
    private SD ZZv;
    private boolean aBv;
    private boolean du;
    private final Matrix eG;
    private RectF gbA;
    private RectF lT;
    private Map<String, Typeface> oX;
    private boolean omh;
    String pA;
    private Rect qmB;
    private Paint rB;
    private Bitmap roi;
    private com.bytedance.adsdk.Og.KZx.KZx.Og vZF;
    private Rect xy;
    private boolean yFO;

    private enum Og {
        NONE,
        PLAY,
        RESUME
    }

    private interface pA {
        void pA(SD sd);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public Bzk() {
        com.bytedance.adsdk.Og.JG.KZx kZx = new com.bytedance.adsdk.Og.JG.KZx();
        this.ML = kZx;
        this.JG = true;
        this.SD = false;
        this.omh = false;
        this.Bzk = Og.NONE;
        this.SGo = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.adsdk.Og.Bzk.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (Bzk.this.vZF != null) {
                    Bzk.this.vZF.pA(Bzk.this.ML.JG());
                }
            }
        };
        this.BSW = animatorUpdateListener;
        this.XT = false;
        this.yFO = true;
        this.Sd = 255;
        this.TV = yFO.AUTOMATIC;
        this.du = false;
        this.eG = new Matrix();
        this.Gx = false;
        kZx.addUpdateListener(animatorUpdateListener);
    }

    public void pA(View view) {
        this.FQ = view;
    }

    public View pA() {
        return this.FQ;
    }

    public void pA(boolean z, Context context) {
        if (this.aBv == z) {
            return;
        }
        this.aBv = z;
        if (this.ZZv != null) {
            pA(context);
        }
    }

    public void pA(boolean z) {
        if (z != this.yFO) {
            this.yFO = z;
            com.bytedance.adsdk.Og.KZx.KZx.Og og = this.vZF;
            if (og != null) {
                og.Og(z);
            }
            invalidateSelf();
        }
    }

    public com.bytedance.adsdk.Og.KZx.KZx.Og Og() {
        return this.vZF;
    }

    public boolean KZx() {
        return this.yFO;
    }

    public void pA(String str) {
        this.Wx = str;
    }

    public String ZZv() {
        return this.Wx;
    }

    public void Og(boolean z) {
        this.XT = z;
    }

    public boolean ML() {
        return this.XT;
    }

    public boolean pA(SD sd, Context context) {
        if (this.ZZv == sd) {
            return false;
        }
        this.Gx = true;
        SGo();
        this.ZZv = sd;
        pA(context);
        this.ML.pA(sd);
        ZZv(this.ML.getAnimatedFraction());
        Iterator it = new ArrayList(this.SGo).iterator();
        while (it.hasNext()) {
            pA pAVar = (pA) it.next();
            if (pAVar != null) {
                pAVar.pA(sd);
            }
            it.remove();
        }
        this.SGo.clear();
        sd.Og(this.TX);
        lT();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void pA(yFO yfo) {
        this.TV = yfo;
        lT();
    }

    public yFO JG() {
        return this.du ? yFO.SOFTWARE : yFO.HARDWARE;
    }

    private void lT() {
        SD sd = this.ZZv;
        if (sd == null) {
            return;
        }
        this.du = this.TV.pA(Build.VERSION.SDK_INT, sd.pA(), sd.Og());
    }

    public boolean SD() {
        return this.du;
    }

    public void KZx(boolean z) {
        this.TX = z;
        SD sd = this.ZZv;
        if (sd != null) {
            sd.Og(z);
        }
    }

    public void ZZv(boolean z) {
        if (this.BF == z) {
            return;
        }
        this.BF = z;
        com.bytedance.adsdk.Og.KZx.KZx.Og og = this.vZF;
        if (og != null) {
            og.pA(z);
        }
    }

    public XT omh() {
        SD sd = this.ZZv;
        if (sd != null) {
            return sd.KZx();
        }
        return null;
    }

    public void ML(boolean z) {
        this.WQf = z;
    }

    public boolean Bzk() {
        return this.WQf;
    }

    private void pA(Context context) {
        SD sd = this.ZZv;
        if (sd == null) {
            return;
        }
        com.bytedance.adsdk.Og.KZx.KZx.Og og = new com.bytedance.adsdk.Og.KZx.KZx.Og(this, BF.pA(sd), sd.Wx(), sd, context);
        this.vZF = og;
        if (this.BF) {
            og.pA(true);
        }
        this.vZF.Og(this.yFO);
    }

    public void SGo() {
        if (this.ML.isRunning()) {
            this.ML.cancel();
            if (!isVisible()) {
                this.Bzk = Og.NONE;
            }
        }
        this.ZZv = null;
        this.vZF = null;
        this.WV = null;
        this.ML.omh();
        invalidateSelf();
    }

    public void JG(boolean z) {
        this.omh = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.Gx) {
            return;
        }
        this.Gx = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.Sd = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.Sd;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ML.pA("Drawable#draw");
        try {
            if (this.du) {
                pA(canvas, this.vZF);
            } else {
                pA(canvas);
            }
        } catch (Throwable unused) {
        }
        this.Gx = false;
        ML.Og("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        BSW();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        WV();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return TX();
    }

    public void BSW() {
        if (this.vZF == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.6
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd) {
                    Bzk.this.BSW();
                }
            });
            return;
        }
        lT();
        if (rB() || Sd() == 0) {
            if (isVisible()) {
                this.ML.BSW();
                this.Bzk = Og.NONE;
            } else {
                this.Bzk = Og.PLAY;
            }
        }
        if (rB()) {
            return;
        }
        KZx((int) (oX() < 0.0f ? Sn() : DX()));
        this.ML.WV();
        if (isVisible()) {
            return;
        }
        this.Bzk = Og.NONE;
    }

    public void WV() {
        this.SGo.clear();
        this.ML.WV();
        if (isVisible()) {
            return;
        }
        this.Bzk = Og.NONE;
    }

    public void Wx() {
        if (this.vZF == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.7
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd) {
                    Bzk.this.Wx();
                }
            });
            return;
        }
        lT();
        if (rB() || Sd() == 0) {
            if (isVisible()) {
                this.ML.Sn();
                this.Bzk = Og.NONE;
            } else {
                this.Bzk = Og.RESUME;
            }
        }
        if (rB()) {
            return;
        }
        KZx((int) (oX() < 0.0f ? Sn() : DX()));
        this.ML.WV();
        if (isVisible()) {
            return;
        }
        this.Bzk = Og.NONE;
    }

    public void pA(final int i) {
        if (this.ZZv == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.8
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd) {
                    Bzk.this.pA(i);
                }
            });
        } else {
            this.ML.pA(i);
        }
    }

    public float Sn() {
        return this.ML.DX();
    }

    public void pA(final float f) {
        SD sd = this.ZZv;
        if (sd == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.9
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd2) {
                    Bzk.this.pA(f);
                }
            });
        } else {
            pA((int) com.bytedance.adsdk.Og.JG.ML.pA(sd.JG(), this.ZZv.SD(), f));
        }
    }

    public void Og(final int i) {
        if (this.ZZv == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.10
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd) {
                    Bzk.this.Og(i);
                }
            });
        } else {
            this.ML.Og(i + 0.99f);
        }
    }

    public float DX() {
        return this.ML.oX();
    }

    public void Og(final float f) {
        SD sd = this.ZZv;
        if (sd == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.11
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd2) {
                    Bzk.this.Og(f);
                }
            });
        } else {
            this.ML.Og(com.bytedance.adsdk.Og.JG.ML.pA(sd.JG(), this.ZZv.SD(), f));
        }
    }

    public void Og(final String str) {
        SD sd = this.ZZv;
        if (sd == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.12
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd2) {
                    Bzk.this.Og(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.Og.KZx.JG jgKZx = sd.KZx(str);
        if (jgKZx == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        pA((int) jgKZx.pA);
    }

    public void KZx(final String str) {
        SD sd = this.ZZv;
        if (sd == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.13
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd2) {
                    Bzk.this.KZx(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.Og.KZx.JG jgKZx = sd.KZx(str);
        if (jgKZx == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        Og((int) (jgKZx.pA + jgKZx.Og));
    }

    public void ZZv(final String str) {
        SD sd = this.ZZv;
        if (sd == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.2
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd2) {
                    Bzk.this.ZZv(str);
                }
            });
            return;
        }
        com.bytedance.adsdk.Og.KZx.JG jgKZx = sd.KZx(str);
        if (jgKZx == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) jgKZx.pA;
        pA(i, ((int) jgKZx.Og) + i);
    }

    public void pA(final int i, final int i2) {
        if (this.ZZv == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.3
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd) {
                    Bzk.this.pA(i, i2);
                }
            });
        } else {
            this.ML.pA(i, i2 + 0.99f);
        }
    }

    public void KZx(float f) {
        this.ML.KZx(f);
    }

    public float oX() {
        return this.ML.SGo();
    }

    public void pA(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ML.addUpdateListener(animatorUpdateListener);
    }

    public void Og(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.ML.removeUpdateListener(animatorUpdateListener);
    }

    public void aBv() {
        this.ML.removeAllUpdateListeners();
        this.ML.addUpdateListener(this.BSW);
    }

    public void pA(Animator.AnimatorListener animatorListener) {
        this.ML.addListener(animatorListener);
    }

    public void Og(Animator.AnimatorListener animatorListener) {
        this.ML.removeListener(animatorListener);
    }

    public void XT() {
        this.ML.removeAllListeners();
    }

    public void KZx(final int i) {
        if (this.ZZv == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.4
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd) {
                    Bzk.this.KZx(i);
                }
            });
        } else {
            this.ML.pA(i);
        }
    }

    public int yFO() {
        return (int) this.ML.SD();
    }

    public void ZZv(final float f) {
        if (this.ZZv == null) {
            this.SGo.add(new pA() { // from class: com.bytedance.adsdk.Og.Bzk.5
                @Override // com.bytedance.adsdk.Og.Bzk.pA
                public void pA(SD sd) {
                    Bzk.this.ZZv(f);
                }
            });
            return;
        }
        ML.pA("Drawable#setProgress");
        this.ML.pA(this.ZZv.pA(f));
        ML.Og("Drawable#setProgress");
    }

    public void ZZv(int i) {
        this.ML.setRepeatMode(i);
    }

    public int vZF() {
        return this.ML.getRepeatMode();
    }

    public void ML(int i) {
        this.ML.setRepeatCount(i);
    }

    public int Sd() {
        return this.ML.getRepeatCount();
    }

    public boolean TX() {
        com.bytedance.adsdk.Og.JG.KZx kZx = this.ML;
        if (kZx == null) {
            return false;
        }
        return kZx.isRunning();
    }

    boolean BF() {
        if (isVisible()) {
            return this.ML.isRunning();
        }
        return this.Bzk == Og.PLAY || this.Bzk == Og.RESUME;
    }

    private boolean rB() {
        return this.JG || this.SD;
    }

    public void pA(Boolean bool) {
        this.JG = bool.booleanValue();
    }

    public void SD(boolean z) {
        this.SD = z;
    }

    public void omh(boolean z) {
        this.ML.KZx(z);
    }

    public void pA(ZZv zZv) {
        this.Sn = zZv;
        com.bytedance.adsdk.Og.Og.Og og = this.WV;
        if (og != null) {
            og.pA(zZv);
        }
    }

    public void pA(KZx kZx) {
        this.Og = kZx;
        com.bytedance.adsdk.Og.Og.pA pAVar = this.DX;
        if (pAVar != null) {
            pAVar.pA(kZx);
        }
    }

    public void pA(Map<String, Typeface> map) {
        if (map == this.oX) {
            return;
        }
        this.oX = map;
        invalidateSelf();
    }

    public void pA(vZF vzf) {
        this.KZx = vzf;
    }

    public vZF WQf() {
        return this.KZx;
    }

    public boolean TV() {
        return this.oX == null && this.KZx == null && this.ZZv.Sn().size() > 0;
    }

    public SD du() {
        return this.ZZv;
    }

    public void eG() {
        this.SGo.clear();
        this.ML.cancel();
        if (isVisible()) {
            return;
        }
        this.Bzk = Og.NONE;
    }

    public void roi() {
        this.SGo.clear();
        this.ML.Wx();
        if (isVisible()) {
            return;
        }
        this.Bzk = Og.NONE;
    }

    public float Mc() {
        return this.ML.JG();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        SD sd = this.ZZv;
        if (sd == null) {
            return -1;
        }
        return sd.ZZv().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        SD sd = this.ZZv;
        if (sd == null) {
            return -1;
        }
        return sd.ZZv().height();
    }

    public Bitmap pA(String str, Bitmap bitmap) {
        com.bytedance.adsdk.Og.Og.Og ogXy = xy();
        if (ogXy == null) {
            return null;
        }
        Bitmap bitmapPA = ogXy.pA(str, bitmap);
        invalidateSelf();
        return bitmapPA;
    }

    public Bitmap ML(String str) {
        com.bytedance.adsdk.Og.Og.Og ogXy = xy();
        if (ogXy != null) {
            return ogXy.pA(str);
        }
        return null;
    }

    public SGo JG(String str) {
        SD sd = this.ZZv;
        if (sd == null) {
            return null;
        }
        return sd.oX().get(str);
    }

    private com.bytedance.adsdk.Og.Og.Og xy() {
        com.bytedance.adsdk.Og.Og.Og og = this.WV;
        if (og != null && !og.pA(gbA())) {
            this.WV = null;
        }
        if (this.WV == null) {
            this.WV = new com.bytedance.adsdk.Og.Og.Og(getCallback(), this.Wx, this.Sn, this.ZZv.oX());
        }
        return this.WV;
    }

    public Typeface pA(com.bytedance.adsdk.Og.KZx.KZx kZx) {
        Map<String, Typeface> map = this.oX;
        if (map != null) {
            String strPA = kZx.pA();
            if (map.containsKey(strPA)) {
                return map.get(strPA);
            }
            String strOg = kZx.Og();
            if (map.containsKey(strOg)) {
                return map.get(strOg);
            }
            String str = kZx.pA() + "-" + kZx.KZx();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.bytedance.adsdk.Og.Og.pA pAVarQmB = qmB();
        if (pAVarQmB != null) {
            return pAVarQmB.pA(kZx);
        }
        return null;
    }

    private com.bytedance.adsdk.Og.Og.pA qmB() {
        if (getCallback() == null) {
            return null;
        }
        if (this.DX == null) {
            com.bytedance.adsdk.Og.Og.pA pAVar = new com.bytedance.adsdk.Og.Og.pA(getCallback(), this.Og);
            this.DX = pAVar;
            String str = this.pA;
            if (str != null) {
                pAVar.pA(str);
            }
        }
        return this.DX;
    }

    public void SD(String str) {
        this.pA = str;
        com.bytedance.adsdk.Og.Og.pA pAVarQmB = qmB();
        if (pAVarQmB != null) {
            pAVarQmB.pA(str);
        }
    }

    private Context gbA() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean zIsVisible = isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            if (this.Bzk == Og.PLAY) {
                BSW();
            } else if (this.Bzk == Og.RESUME) {
                Wx();
            }
        } else if (this.ML.isRunning()) {
            roi();
            this.Bzk = Og.RESUME;
        } else if (zIsVisible) {
            this.Bzk = Og.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private void pA(Canvas canvas) {
        com.bytedance.adsdk.Og.KZx.KZx.Og og = this.vZF;
        SD sd = this.ZZv;
        if (og == null || sd == null) {
            return;
        }
        this.eG.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.eG.preScale(bounds.width() / sd.ZZv().width(), bounds.height() / sd.ZZv().height());
            this.eG.preTranslate(bounds.left, bounds.top);
        }
        og.pA(canvas, this.eG, this.Sd);
    }

    public RectF IG() {
        return this.Vgu;
    }

    private void pA(Canvas canvas, com.bytedance.adsdk.Og.KZx.KZx.Og og) {
        if (this.ZZv == null || og == null) {
            return;
        }
        Vgu();
        canvas.getMatrix(this.CIG);
        canvas.getClipBounds(this.IG);
        pA(this.IG, this.lT);
        this.CIG.mapRect(this.lT);
        pA(this.lT, this.IG);
        if (this.yFO) {
            this.Vgu.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            og.pA(this.Vgu, (Matrix) null, false);
        }
        this.CIG.mapRect(this.Vgu);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        pA(this.Vgu, fWidth, fHeight);
        if (!CIG()) {
            this.Vgu.intersect(this.IG.left, this.IG.top, this.IG.right, this.IG.bottom);
        }
        int iCeil = (int) Math.ceil(this.Vgu.width());
        int iCeil2 = (int) Math.ceil(this.Vgu.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        Og(iCeil, iCeil2);
        if (this.Gx) {
            this.eG.set(this.CIG);
            this.eG.preScale(fWidth, fHeight);
            this.eG.postTranslate(-this.Vgu.left, -this.Vgu.top);
            this.roi.eraseColor(0);
            og.pA(this.Mc, this.eG, this.Sd);
            this.CIG.invert(this.SzT);
            this.SzT.mapRect(this.gbA, this.Vgu);
            pA(this.gbA, this.qmB);
        }
        this.xy.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.roi, this.xy, this.qmB, this.rB);
    }

    private void Vgu() {
        if (this.Mc != null) {
            return;
        }
        this.Mc = new Canvas();
        this.Vgu = new RectF();
        this.CIG = new Matrix();
        this.SzT = new Matrix();
        this.IG = new Rect();
        this.lT = new RectF();
        this.rB = new com.bytedance.adsdk.Og.pA.pA();
        this.xy = new Rect();
        this.qmB = new Rect();
        this.gbA = new RectF();
    }

    private void Og(int i, int i2) {
        Bitmap bitmap = this.roi;
        if (bitmap == null || bitmap.getWidth() < i || this.roi.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.roi = bitmapCreateBitmap;
            this.Mc.setBitmap(bitmapCreateBitmap);
            this.Gx = true;
            return;
        }
        if (this.roi.getWidth() > i || this.roi.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.roi, 0, 0, i, i2);
            this.roi = bitmapCreateBitmap2;
            this.Mc.setBitmap(bitmapCreateBitmap2);
            this.Gx = true;
        }
    }

    private void pA(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void pA(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void pA(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean CIG() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }
}
