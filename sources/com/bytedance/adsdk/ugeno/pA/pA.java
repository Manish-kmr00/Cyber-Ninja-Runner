package com.bytedance.adsdk.ugeno.pA;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class pA {
    private com.bytedance.adsdk.ugeno.pA.pA.pA JG;
    private ValueAnimator KZx;
    private int ML;
    private Og Og;
    private Context ZZv;
    private com.bytedance.adsdk.ugeno.Og.KZx pA;

    public pA(Context context, com.bytedance.adsdk.ugeno.Og.KZx kZx, Og og) {
        this.pA = kZx;
        this.Og = og;
        this.ZZv = context;
    }

    public void pA() {
        ValueAnimator valueAnimator = this.KZx;
        if (valueAnimator == null || this.ML == -2) {
            return;
        }
        valueAnimator.start();
    }

    public void Og() {
        ValueAnimator valueAnimator = this.KZx;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public ValueAnimator KZx() {
        com.bytedance.adsdk.ugeno.pA.Og.pA kZx;
        Og og = this.Og;
        if (og == null || this.pA == null) {
            return null;
        }
        Map<String, TreeMap<Float, String>> mapOg = og.Og();
        ArrayList arrayList = new ArrayList();
        if (mapOg != null && !mapOg.isEmpty()) {
            for (Map.Entry<String, TreeMap<Float, String>> entry : mapOg.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String strKZx = ZZv.pA(key).KZx();
                    strKZx.hashCode();
                    switch (strKZx) {
                        case "int":
                            kZx = new com.bytedance.adsdk.ugeno.pA.Og.KZx(this.ZZv, this.pA, key, entry.getValue());
                            break;
                        case "float":
                            kZx = new com.bytedance.adsdk.ugeno.pA.Og.Og(this.ZZv, this.pA, key, entry.getValue());
                            break;
                        case "point":
                            kZx = new com.bytedance.adsdk.ugeno.pA.Og.ZZv(this.ZZv, this.pA, key, entry.getValue());
                            break;
                        default:
                            kZx = null;
                            break;
                    }
                    if (kZx != null) {
                        arrayList.addAll(kZx.ML());
                    }
                }
            }
        }
        JSONObject jSONObjectPA = this.Og.pA();
        if (jSONObjectPA != null) {
            com.bytedance.adsdk.ugeno.pA.pA.pA pAVarPA = com.bytedance.adsdk.ugeno.pA.pA.pA.C0182pA.pA(this.pA, jSONObjectPA);
            this.JG = pAVarPA;
            if (pAVarPA != null) {
                arrayList.addAll(pAVarPA.KZx());
            }
        }
        final View viewBzk = this.pA.Bzk();
        if (viewBzk == null) {
            return null;
        }
        final Og.pA pAVarSD = this.Og.SD();
        if (pAVarSD != null) {
            viewBzk.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.pA.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    int width = viewBzk.getWidth();
                    int height = viewBzk.getHeight();
                    viewBzk.setPivotX(KZx.pA(pAVarSD.pA, width));
                    viewBzk.setPivotY(KZx.pA(pAVarSD.Og, height));
                }
            });
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(viewBzk, (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]));
        this.ML = KZx.pA(this.Og.ZZv());
        objectAnimatorOfPropertyValuesHolder.setDuration(this.Og.KZx());
        int i = this.ML;
        if (i != -2) {
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(i);
        }
        objectAnimatorOfPropertyValuesHolder.setStartDelay(this.Og.JG());
        objectAnimatorOfPropertyValuesHolder.setRepeatMode(KZx.pA(this.Og.ML()));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(KZx.Og(this.Og.omh()));
        this.KZx = objectAnimatorOfPropertyValuesHolder;
        return objectAnimatorOfPropertyValuesHolder;
    }

    public void pA(Canvas canvas) {
        com.bytedance.adsdk.ugeno.pA.pA.pA pAVar = this.JG;
        if (pAVar != null) {
            pAVar.pA(canvas);
        }
    }

    public void pA(int i, int i2) {
        com.bytedance.adsdk.ugeno.pA.pA.pA pAVar = this.JG;
        if (pAVar != null) {
            pAVar.pA(i, i2);
        }
    }
}
