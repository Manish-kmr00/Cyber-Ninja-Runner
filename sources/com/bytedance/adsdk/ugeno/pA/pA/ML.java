package com.bytedance.adsdk.ugeno.pA.pA;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class ML extends pA {
    private Path BSW;
    private boolean Bzk;
    private float JG;
    private float KZx;
    private Paint ML;
    private String SD;
    private Path SGo;
    private Path WV;
    private PorterDuffXfermode Wx;
    private float ZZv;
    private boolean omh;

    public ML(com.bytedance.adsdk.ugeno.Og.KZx kZx, JSONObject jSONObject) {
        super(kZx, jSONObject);
        this.omh = true;
        this.Bzk = true;
        Paint paint = new Paint();
        this.ML = paint;
        paint.setAntiAlias(true);
        this.Og.Bzk().setLayerType(2, null);
        this.Wx = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.SGo = new Path();
        this.BSW = new Path();
        this.WV = new Path();
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void Og() {
        this.JG = (float) this.pA.optDouble("start", 0.0d);
        this.SD = this.pA.optString("direction", "center");
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void pA(Canvas canvas) {
        if (this.Og.HSv() > 0.0f) {
            int iHSv = (int) (this.KZx * this.Og.HSv());
            int iHSv2 = (int) (this.ZZv * this.Og.HSv());
            this.ML.setXfermode(this.Wx);
            String str = this.SD;
            str.hashCode();
            switch (str) {
                case "bottom":
                    canvas.drawRect(0.0f, iHSv2, this.KZx, this.ZZv, this.ML);
                    break;
                case "center":
                    this.SGo.reset();
                    this.BSW.reset();
                    this.WV.reset();
                    this.SGo.addCircle(this.KZx / 2.0f, this.ZZv / 2.0f, iHSv, Path.Direction.CW);
                    Path path = this.BSW;
                    float f = this.KZx;
                    path.addRect(f / 2.0f, 0.0f, f, this.ZZv, Path.Direction.CW);
                    this.BSW.op(this.SGo, Path.Op.DIFFERENCE);
                    this.WV.addRect(0.0f, 0.0f, this.KZx / 2.0f, this.ZZv, Path.Direction.CW);
                    this.WV.op(this.SGo, Path.Op.DIFFERENCE);
                    canvas.drawPath(this.BSW, this.ML);
                    canvas.drawPath(this.WV, this.ML);
                    break;
                case "top":
                    canvas.drawRect(0.0f, 0.0f, this.KZx, this.ZZv - iHSv2, this.ML);
                    break;
                case "left":
                    canvas.drawRect(0.0f, 0.0f, this.KZx - iHSv, this.ZZv, this.ML);
                    break;
                case "right":
                    canvas.drawRect(iHSv, 0.0f, this.KZx, this.ZZv, this.ML);
                    break;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void pA(int i, int i2) {
        if (i > 0 && this.omh) {
            this.KZx = i;
            this.omh = false;
        }
        if (i2 <= 0 || !this.Bzk) {
            return;
        }
        this.ZZv = i2;
        this.Bzk = false;
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public List<PropertyValuesHolder> KZx() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(ZZv(), this.JG, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
