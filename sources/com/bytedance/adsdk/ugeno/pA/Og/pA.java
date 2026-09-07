package com.bytedance.adsdk.ugeno.pA.Og;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes13.dex */
public abstract class pA {
    protected Map<Float, String> KZx;
    protected String Og;
    protected com.bytedance.adsdk.ugeno.Og.KZx SD;
    protected com.bytedance.adsdk.ugeno.pA.ZZv ZZv;
    protected Context pA;
    protected List<PropertyValuesHolder> JG = new ArrayList();
    protected List<Keyframe> ML = new ArrayList();

    public abstract TypeEvaluator JG();

    public abstract void Og();

    public abstract void pA(float f, String str);

    public pA(Context context, com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, Map<Float, String> map) {
        this.pA = context;
        this.Og = str;
        this.KZx = map;
        this.ZZv = com.bytedance.adsdk.ugeno.pA.ZZv.pA(this.Og);
        this.SD = kZx;
    }

    public boolean pA() {
        Map<Float, String> map = this.KZx;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.KZx.containsKey(Float.valueOf(0.0f));
    }

    public void KZx() {
        Map<Float, String> map = this.KZx;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.KZx;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                pA(100.0f, this.KZx.get(Float.valueOf(fFloatValue)));
            }
        }
    }

    public void ZZv() {
        Map<Float, String> map = this.KZx;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!pA()) {
            Og();
        }
        for (Map.Entry<Float, String> entry : this.KZx.entrySet()) {
            if (entry != null) {
                pA(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        KZx();
    }

    public List<PropertyValuesHolder> ML() {
        String strOg = this.ZZv.Og();
        ZZv();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strOg, (Keyframe[]) this.ML.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorJG = JG();
        if (typeEvaluatorJG != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorJG);
        }
        this.JG.add(propertyValuesHolderOfKeyframe);
        return this.JG;
    }
}
