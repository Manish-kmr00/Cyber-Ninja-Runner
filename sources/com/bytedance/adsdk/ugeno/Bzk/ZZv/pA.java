package com.bytedance.adsdk.ugeno.Bzk.ZZv;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.pA.JG;
import com.bytedance.adsdk.ugeno.pA.ML;

/* JADX INFO: loaded from: classes7.dex */
public class pA extends ImageView implements IAnimation, ML {
    static final /* synthetic */ boolean Og = true;
    private Drawable BSW;
    private ColorFilter Bzk;
    private int DX;
    private Drawable JG;
    private float KZx;
    private final float[] ML;
    private ColorStateList SD;
    private boolean SGo;
    private JG Sd;
    private boolean Sn;
    private boolean WV;
    private boolean Wx;
    private Shader.TileMode XT;
    private ImageView.ScaleType aBv;
    private int oX;
    private float omh;
    private com.bytedance.adsdk.ugeno.KZx vZF;
    private Shader.TileMode yFO;
    public static final Shader.TileMode pA = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] ZZv = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    public pA(Context context) {
        super(context);
        this.ML = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.SD = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.omh = 0.0f;
        this.Bzk = null;
        this.SGo = false;
        this.WV = false;
        this.Wx = false;
        this.Sn = false;
        Shader.TileMode tileMode = pA;
        this.XT = tileMode;
        this.yFO = tileMode;
        this.Sd = new JG(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.aBv;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!Og && scaleType == null) {
            throw new AssertionError();
        }
        if (this.aBv != scaleType) {
            this.aBv = scaleType;
            int i = AnonymousClass1.pA[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            KZx();
            pA(false);
            invalidate();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.Bzk.ZZv.pA$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            pA = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                pA[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                pA[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                pA[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                pA[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.DX = 0;
        this.BSW = Og.pA(drawable);
        KZx();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.DX = 0;
        this.BSW = Og.pA(bitmap);
        KZx();
        super.setImageDrawable(this.BSW);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.DX != i) {
            this.DX = i;
            this.BSW = pA();
            KZx();
            super.setImageDrawable(this.BSW);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable pA() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.DX;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.DX, e);
                this.DX = 0;
            }
        }
        return Og.pA(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.oX != i) {
            this.oX = i;
            Drawable drawableOg = Og();
            this.JG = drawableOg;
            setBackgroundDrawable(drawableOg);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.JG = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    private Drawable Og() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.oX;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.oX, e);
                this.oX = 0;
            }
        }
        return Og.pA(drawable);
    }

    private void KZx() {
        pA(this.BSW, this.aBv);
    }

    private void pA(boolean z) {
        if (this.Sn) {
            if (z) {
                this.JG = Og.pA(this.JG);
            }
            pA(this.JG, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.Bzk != colorFilter) {
            this.Bzk = colorFilter;
            this.WV = true;
            this.SGo = true;
            ZZv();
            invalidate();
        }
    }

    private void ZZv() {
        Drawable drawable = this.BSW;
        if (drawable == null || !this.SGo) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.BSW = drawableMutate;
        if (this.WV) {
            drawableMutate.setColorFilter(this.Bzk);
        }
    }

    private void pA(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof Og) {
            Og og = (Og) drawable;
            og.pA(scaleType).pA(this.omh).pA(this.SD).pA(this.Wx).pA(this.XT).Og(this.yFO);
            float[] fArr = this.ML;
            if (fArr != null) {
                og.pA(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            ZZv();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                pA(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.JG = drawable;
        pA(true);
        super.setBackgroundDrawable(this.JG);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.ML) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        pA(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadius(float f) {
        pA(f, f, f, f);
    }

    public void pA(float f, float f2, float f3, float f4) {
        float[] fArr = this.ML;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        KZx();
        pA(false);
        invalidate();
    }

    public float getBorderWidth() {
        return this.omh;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.omh == f) {
            return;
        }
        this.omh = f;
        KZx();
        pA(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.SD.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.SD;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.SD.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.SD = colorStateList;
        KZx();
        pA(false);
        if (this.omh > 0.0f) {
            invalidate();
        }
    }

    public void setOval(boolean z) {
        this.Wx = z;
        KZx();
        pA(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.XT;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.XT == tileMode) {
            return;
        }
        this.XT = tileMode;
        KZx();
        pA(false);
        invalidate();
    }

    public Shader.TileMode getTileModeY() {
        return this.yFO;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.yFO == tileMode) {
            return;
        }
        this.yFO = tileMode;
        KZx();
        pA(false);
        invalidate();
    }

    public void pA(com.bytedance.adsdk.ugeno.KZx kZx) {
        this.vZF = kZx;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.KZx kZx = this.vZF;
        if (kZx != null) {
            int[] iArrPA = kZx.pA(i, i2);
            super.onMeasure(iArrPA[0], iArrPA[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.KZx kZx = this.vZF;
        if (kZx != null) {
            kZx.pA(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.bytedance.adsdk.ugeno.KZx kZx = this.vZF;
        if (kZx != null) {
            kZx.pA(canvas, this);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.KZx kZx = this.vZF;
        if (kZx != null) {
            kZx.Og(i, i2, i3, i3);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.KZx kZx = this.vZF;
        if (kZx != null) {
            kZx.SD();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.KZx kZx = this.vZF;
        if (kZx != null) {
            kZx.omh();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation, com.bytedance.adsdk.ugeno.pA.ML
    public float getRipple() {
        return this.KZx;
    }

    public void setShine(float f) {
        JG jg = this.Sd;
        if (jg != null) {
            jg.KZx(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getShine() {
        return this.Sd.getShine();
    }

    public void setStretch(float f) {
        JG jg = this.Sd;
        if (jg != null) {
            jg.ZZv(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getStretch() {
        return this.Sd.getStretch();
    }

    public void setRubIn(float f) {
        JG jg = this.Sd;
        if (jg != null) {
            jg.ML(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getRubIn() {
        return this.Sd.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f) {
        this.KZx = f;
        JG jg = this.Sd;
        if (jg != null) {
            jg.Og(f);
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setBorderRadius(float f) {
        JG jg = this.Sd;
        if (jg != null) {
            jg.pA(f);
        }
    }

    public float getBorderRadius() {
        return this.Sd.pA();
    }
}
