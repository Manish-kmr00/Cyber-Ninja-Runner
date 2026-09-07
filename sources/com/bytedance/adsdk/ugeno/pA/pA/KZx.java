package com.bytedance.adsdk.ugeno.pA.pA;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class KZx extends pA {
    private Matrix BSW;
    private PorterDuffXfermode Bzk;
    private View JG;
    private String KZx;
    private float ML;
    private Paint SD;
    private LinearGradient SGo;
    private float ZZv;
    private Paint omh;

    public KZx(com.bytedance.adsdk.ugeno.Og.KZx kZx, JSONObject jSONObject) {
        super(kZx, jSONObject);
        this.JG = this.Og.Bzk();
        Paint paint = new Paint();
        this.SD = paint;
        paint.setAntiAlias(true);
        this.JG.setLayerType(2, null);
        this.Bzk = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.omh = new Paint();
        this.BSW = new Matrix();
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void Og() {
        this.KZx = this.pA.optString("direction", "left");
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void pA(Canvas canvas) {
        byte b;
        try {
            if (this.Og.JBA() > 0.0f) {
                int iJBA = (int) (this.ZZv * this.Og.JBA());
                int iJBA2 = (int) (this.ML * this.Og.JBA());
                this.SD.setXfermode(this.Bzk);
                String str = this.KZx;
                switch (str.hashCode()) {
                    case -1383228885:
                        if (!str.equals("bottom")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 115029:
                        if (!str.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case 3317767:
                        if (!str.equals("left")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 108511772:
                        if (!str.equals("right")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    float f = iJBA;
                    canvas.drawRect(f, 0.0f, this.ZZv, this.ML, this.SD);
                    this.BSW.setTranslate(f, this.ML);
                    this.SGo.setLocalMatrix(this.BSW);
                    this.omh.setShader(this.SGo);
                    if (this.Og.JBA() <= 1.0f && this.Og.JBA() > 0.9f) {
                        this.omh.setAlpha((int) (255.0f - (this.Og.JBA() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, f, this.ML, this.omh);
                    return;
                }
                if (b == 1) {
                    float f2 = iJBA;
                    canvas.drawRect(0.0f, 0.0f, this.ZZv - f2, this.ML, this.SD);
                    this.BSW.setTranslate(this.ZZv - f2, 0.0f);
                    this.SGo.setLocalMatrix(this.BSW);
                    this.omh.setShader(this.SGo);
                    if (this.Og.JBA() <= 1.0f && this.Og.JBA() > 0.9f) {
                        this.omh.setAlpha((int) (255.0f - (this.Og.JBA() * 255.0f)));
                    }
                    float f3 = this.ZZv;
                    canvas.drawRect(f3, this.ML, f3 - f2, 0.0f, this.omh);
                    return;
                }
                if (b == 2) {
                    float f4 = iJBA2;
                    canvas.drawRect(0.0f, f4, this.ZZv, this.ML, this.SD);
                    this.BSW.setTranslate(0.0f, f4);
                    this.SGo.setLocalMatrix(this.BSW);
                    this.omh.setShader(this.SGo);
                    if (this.Og.JBA() <= 1.0f && this.Og.JBA() > 0.9f) {
                        this.omh.setAlpha((int) (255.0f - (this.Og.JBA() * 255.0f)));
                    }
                    canvas.drawRect(0.0f, 0.0f, this.ZZv, f4, this.omh);
                    return;
                }
                if (b != 3) {
                    return;
                }
                float f5 = iJBA2;
                canvas.drawRect(0.0f, 0.0f, this.ZZv, this.ML - f5, this.SD);
                this.BSW.setTranslate(0.0f, this.ML - f5);
                this.SGo.setLocalMatrix(this.BSW);
                this.omh.setShader(this.SGo);
                if (this.Og.JBA() <= 1.0f && this.Og.JBA() > 0.9f) {
                    this.omh.setAlpha((int) (255.0f - (this.Og.JBA() * 255.0f)));
                }
                float f6 = this.ZZv;
                float f7 = this.ML;
                canvas.drawRect(f6, f7, 0.0f, f7 - f5, this.omh);
            }
        } catch (Throwable th) {
            Log.e("BaseEffectWrapper", th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void pA(int i, int i2) {
        this.ZZv = i;
        this.ML = i2;
        String str = this.KZx;
        str.hashCode();
        switch (str) {
            case "bottom":
                this.SGo = new LinearGradient(0.0f, -this.ML, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "top":
                this.SGo = new LinearGradient(0.0f, this.ML, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "left":
                this.SGo = new LinearGradient(this.ZZv, 0.0f, 0.0f, 0.0f, 0, -1, Shader.TileMode.CLAMP);
                break;
            case "right":
                this.SGo = new LinearGradient(-this.ZZv, 0.0f, 0.0f, this.ML, 0, -1, Shader.TileMode.CLAMP);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public List<PropertyValuesHolder> KZx() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(PropertyValuesHolder.ofFloat("rubIn", 0.0f, 1.0f));
        arrayList.add(PropertyValuesHolder.ofFloat(com.bytedance.adsdk.ugeno.pA.ZZv.ALPHA.Og(), 0.0f, 1.0f));
        return arrayList;
    }
}
