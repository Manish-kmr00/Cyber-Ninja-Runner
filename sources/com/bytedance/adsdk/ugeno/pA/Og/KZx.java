package com.bytedance.adsdk.ugeno.pA.Og;

import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes9.dex */
public class KZx extends pA {
    public KZx(Context context, com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, TreeMap<Float, String> treeMap) {
        super(context, kZx, str, treeMap);
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public void Og() {
        if (this.ZZv == com.bytedance.adsdk.ugeno.pA.ZZv.BACKGROUND_COLOR) {
            this.ML.add(Keyframe.ofInt(0.0f, this.SD.gbA()));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public void pA(float f, String str) {
        Keyframe keyframeOfInt;
        if (this.ZZv == com.bytedance.adsdk.ugeno.pA.ZZv.BACKGROUND_COLOR) {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.SD.pA.pA(str));
        } else {
            keyframeOfInt = Keyframe.ofInt(f, com.bytedance.adsdk.ugeno.SD.KZx.pA(str, 0));
        }
        this.ML.add(keyframeOfInt);
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public TypeEvaluator JG() {
        if (this.ZZv == com.bytedance.adsdk.ugeno.pA.ZZv.BACKGROUND_COLOR) {
            return new ArgbEvaluator();
        }
        return new IntEvaluator();
    }
}
