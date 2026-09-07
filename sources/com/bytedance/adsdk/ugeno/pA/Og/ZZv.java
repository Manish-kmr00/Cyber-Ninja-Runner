package com.bytedance.adsdk.ugeno.pA.Og;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.SD.omh;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes11.dex */
public class ZZv extends pA {
    private List<Keyframe> omh;

    public ZZv(Context context, com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, Map<Float, String> map) {
        super(context, kZx, str, map);
        this.omh = new ArrayList();
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.pA.Og.ZZv$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.pA.ZZv.values().length];
            pA = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.pA.ZZv.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public void Og() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2;
        int i = AnonymousClass1.pA[this.ZZv.ordinal()];
        if (i == 1) {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.SD.WV());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.SD.Wx());
        } else if (i != 2) {
            keyframeOfFloat = null;
            keyframeOfFloat2 = null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.SD.Sn());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.SD.DX());
        }
        if (keyframeOfFloat != null) {
            this.ML.add(keyframeOfFloat);
        }
        if (keyframeOfFloat2 != null) {
            this.omh.add(keyframeOfFloat2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public void pA(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float fOptDouble = (float) jSONArray.optDouble(0);
            float fOptDouble2 = (float) jSONArray.optDouble(1);
            if (this.ZZv == com.bytedance.adsdk.ugeno.pA.ZZv.TRANSLATE) {
                fOptDouble = omh.pA(this.pA, fOptDouble);
                fOptDouble2 = omh.pA(this.pA, fOptDouble2);
            }
            this.ML.add(Keyframe.ofFloat(f, fOptDouble));
            this.omh.add(Keyframe.ofFloat(f, fOptDouble2));
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public List<PropertyValuesHolder> ML() {
        String strOg = this.ZZv.Og();
        ZZv();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strOg + "X", (Keyframe[]) this.ML.toArray(new Keyframe[0]));
        this.JG.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strOg + "Y", (Keyframe[]) this.omh.toArray(new Keyframe[0]));
        this.JG.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorJG = JG();
        if (typeEvaluatorJG != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorJG);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorJG);
        }
        return this.JG;
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public TypeEvaluator JG() {
        return new FloatEvaluator();
    }
}
