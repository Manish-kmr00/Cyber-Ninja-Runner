package com.bytedance.adsdk.ugeno.pA.pA;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class Og extends pA {
    private static final int SD = Color.parseColor("#7ed321");
    private Paint JG;
    private int KZx;
    private int ML;
    private int ZZv;

    public Og(com.bytedance.adsdk.ugeno.Og.KZx kZx, JSONObject jSONObject) {
        super(kZx, jSONObject);
        Paint paint = new Paint();
        this.JG = paint;
        paint.setAntiAlias(true);
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void Og() {
        this.KZx = com.bytedance.adsdk.ugeno.SD.pA.pA(this.pA.optString("backgroundColor"), SD);
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void pA(Canvas canvas) {
        try {
            if (this.Og.Gx() > 0.0f) {
                this.JG.setColor(this.KZx);
                this.JG.setAlpha((int) ((1.0f - this.Og.Gx()) * 255.0f));
                ViewGroup viewGroup = (ViewGroup) this.Og.Bzk().getParent();
                viewGroup.setClipChildren(true);
                int i = this.ZZv;
                int i2 = this.ML;
                canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * this.Og.Gx(), this.JG);
            }
        } catch (Throwable th) {
            Log.d("BaseEffectWrapper", "ripple animation error " + th.getMessage());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public void pA(int i, int i2) {
        this.ZZv = i / 2;
        this.ML = i2 / 2;
    }

    @Override // com.bytedance.adsdk.ugeno.pA.pA.pA
    public List<PropertyValuesHolder> KZx() {
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(ZZv(), 0.0f, 1.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(propertyValuesHolderOfFloat);
        return arrayList;
    }
}
