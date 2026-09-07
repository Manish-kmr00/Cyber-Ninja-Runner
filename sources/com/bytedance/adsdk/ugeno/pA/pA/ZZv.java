package com.bytedance.adsdk.ugeno.pA.pA;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.SD.omh;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ZZv extends pA {
    private static final float DX;
    private static final float Sn;
    private static final float aBv;
    private static final float oX;
    private int BSW;
    private float Bzk;
    private com.bytedance.adsdk.ugeno.SD.pA.C0175pA JG;
    private int KZx;
    private Path ML;
    private int SD;
    private int SGo;
    private boolean WV;
    private Path Wx;
    private float XT;
    private Paint ZZv;
    private int omh;

    static {
        float radians = (float) Math.toRadians(30.0d);
        Sn = radians;
        DX = (float) Math.tan(radians);
        oX = (float) Math.cos(radians);
        aBv = (float) Math.sin(radians);
    }

    public ZZv(com.bytedance.adsdk.ugeno.Og.KZx kZx, JSONObject jSONObject) {
        super(kZx, jSONObject);
        this.WV = true;
        Paint paint = new Paint();
        this.ZZv = paint;
        paint.setAntiAlias(true);
        this.ML = new Path();
        this.Bzk = this.Og.vZF();
        this.Wx = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void Og() {
        this.KZx = (int) omh.pA(this.Og.Bzk().getContext(), this.pA.optInt("shineWidth", 30));
        String strOptString = this.pA.optString("backgroundColor", "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))");
        String str = TextUtils.isEmpty(strOptString) ? "linear-gradient(90deg, rgba(255, 255, 255, 0), rgba(255, 255, 255, 0.25) 30%, rgba(255, 255, 255, 0.3) 50%, rgba(255, 255, 255, 0.25) 70%, rgba(255, 255, 255, 0))" : strOptString;
        if (str.startsWith("linear")) {
            this.JG = com.bytedance.adsdk.ugeno.SD.pA.Og(str);
        } else {
            int iPA = com.bytedance.adsdk.ugeno.SD.pA.pA(str);
            this.SD = iPA;
            this.omh = com.bytedance.adsdk.ugeno.SD.pA.pA(iPA, 32);
            this.WV = false;
        }
        this.XT = oX * this.KZx;
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void pA(Canvas canvas) {
        LinearGradient linearGradient;
        try {
            if (this.Og.Bf() > 0.0f) {
                int i = this.SGo;
                float f = DX;
                float fBf = (i + (i * f)) * this.Og.Bf();
                this.Wx.reset();
                this.Wx.moveTo(fBf, 0.0f);
                int i2 = this.BSW;
                float f2 = fBf - (i2 * f);
                this.Wx.lineTo(f2, i2);
                this.Wx.lineTo(f2 + this.KZx, this.BSW);
                this.Wx.lineTo(this.KZx + fBf, 0.0f);
                this.Wx.close();
                float f3 = this.XT;
                float f4 = oX * f3;
                float f5 = f3 * aBv;
                if (this.WV && this.JG != null) {
                    linearGradient = new LinearGradient(fBf, 0.0f, fBf + f4, f5, this.JG.Og, (float[]) null, Shader.TileMode.CLAMP);
                } else {
                    float f6 = fBf + f4;
                    int i3 = this.omh;
                    linearGradient = new LinearGradient(fBf, 0.0f, f6, f5, new int[]{i3, this.SD, i3}, (float[]) null, Shader.TileMode.CLAMP);
                }
                this.ZZv.setShader(linearGradient);
                Path path = this.ML;
                if (path != null) {
                    canvas.clipPath(path, Region.Op.INTERSECT);
                }
                canvas.drawPath(this.Wx, this.ZZv);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void pA(int i, int i2) {
        this.SGo = i;
        this.BSW = i2;
        try {
            RectF rectF = new RectF(0.0f, 0.0f, i, i2);
            Path path = this.ML;
            float f = this.Bzk;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public List<PropertyValuesHolder> KZx() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(ZZv(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
