package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.adexpress.ZZv.omh;
import com.bytedance.sdk.component.adexpress.dynamic.ZZv.SD;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.BSW;

/* JADX INFO: loaded from: classes3.dex */
public class KZx {
    private int JG;
    private int ML;
    private int ZZv;
    Paint pA;
    Path Og = new Path();
    Path KZx = new Path();

    public KZx() {
        Paint paint = new Paint();
        this.pA = paint;
        paint.setAntiAlias(true);
    }

    public void pA(Canvas canvas, IAnimation iAnimation, View view) {
        int iIntValue;
        String str;
        float[] fArrOg;
        int iIntValue2 = 0;
        if (iAnimation.getRippleValue() != 0.0f) {
            if (com.bytedance.sdk.component.adexpress.pA.pA.pA.pA().KZx() != null) {
                try {
                    str = (String) view.getTag(2097610712);
                    try {
                        fArrOg = SD.Og(str);
                    } catch (Exception unused) {
                        fArrOg = null;
                    }
                } catch (Exception unused2) {
                    str = "";
                }
                if (str.startsWith("#")) {
                    this.pA.setColor(Color.parseColor(str));
                    this.pA.setAlpha(90);
                } else if (fArrOg != null) {
                    this.pA.setColor(omh.pA(fArrOg[3] * (1.0f - iAnimation.getRippleValue()), fArrOg[0] / 256.0f, fArrOg[1] / 256.0f, fArrOg[2] / 256.0f));
                }
            }
            ((ViewGroup) view.getParent()).setClipChildren(true);
            int i = this.ZZv;
            int i2 = this.ML;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * iAnimation.getRippleValue(), this.pA);
        }
        if (iAnimation.getShineValue() != 0.0f) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).setClipChildren(true);
            }
            if (view.getParent().getParent() != null) {
                ((ViewGroup) view.getParent().getParent()).setClipChildren(true);
            }
            this.Og.reset();
            try {
                iIntValue = ((Integer) view.getTag(2097610711)).intValue();
            } catch (Exception unused3) {
                iIntValue = 0;
            }
            if (iIntValue >= 0) {
                int shineValue = ((int) ((((this.ZZv * 4) + (iIntValue * 2)) + (this.ML * 2)) * iAnimation.getShineValue())) - ((this.ML * 2) + iIntValue);
                float f = shineValue;
                int i3 = this.ML;
                this.pA.setShader(new LinearGradient(f, 0.0f, ((iIntValue + i3) / 2) + shineValue, i3 / 2, new int[]{Color.parseColor("#20ffffff"), Color.parseColor("#60ffffff"), Color.parseColor("#65ffffff")}, (float[]) null, Shader.TileMode.MIRROR));
                this.pA.setStrokeWidth(this.ZZv * 2);
                Path path = this.KZx;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                int i4 = shineValue + iIntValue;
                int i5 = this.ML;
                canvas.drawLine(f, 0.0f, i4 + i5, i5, this.pA);
            }
        }
        if (iAnimation.getMarqueeValue() != 0.0f) {
            try {
                iIntValue2 = ((Integer) view.getTag(2097610709)).intValue();
            } catch (Exception unused4) {
            }
            if (iIntValue2 >= 0) {
                this.Og.reset();
                this.Og.moveTo(0.0f, 0.0f);
                this.Og.lineTo(this.ZZv * 2, 0.0f);
                this.Og.lineTo(this.ZZv * 2, this.ML * 2);
                this.Og.lineTo(0.0f, this.ML * 2);
                this.Og.lineTo(0.0f, 0.0f);
                this.pA.setShader(new LinearGradient(0.0f, 0.0f, this.ZZv * 2, this.ML * 2, new int[]{(int) (iAnimation.getMarqueeValue() * (-65536.0f)), (int) ((1.0f - iAnimation.getMarqueeValue()) * (-65536.0f))}, (float[]) null, Shader.TileMode.CLAMP));
                this.pA.setColor(SupportMenu.CATEGORY_MASK);
                this.pA.setStyle(Paint.Style.STROKE);
                this.pA.setStrokeWidth(iIntValue2);
                canvas.drawPath(this.Og, this.pA);
            }
        }
    }

    public void pA(View view, float f) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (this.JG * f);
        view.setTranslationX((this.JG - layoutParams.width) / 2);
        if (view instanceof BSW) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                viewGroup.getChildAt(i).setTranslationX((-(this.JG - layoutParams.width)) / 2);
                i++;
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public void pA(View view, int i, int i2) {
        String str;
        this.ZZv = i / 2;
        this.ML = i2 / 2;
        if (this.JG == 0 && view.getLayoutParams().width > 0) {
            this.JG = view.getLayoutParams().width;
        }
        try {
            str = (String) view.getTag(2097610710);
            try {
                this.KZx.addRoundRect(new RectF(0.0f, 0.0f, i, i2), i2 / 2, i2 / 2, Path.Direction.CW);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = "";
        }
        if ("right".equals(str)) {
            view.setPivotX(this.ZZv * 2);
            view.setPivotY(this.ML);
        } else if ("left".equals(str)) {
            view.setPivotX(0.0f);
            view.setPivotY(this.ML);
        } else {
            view.setPivotX(this.ZZv);
            view.setPivotY(this.ML);
        }
    }
}
