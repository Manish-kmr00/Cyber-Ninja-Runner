package com.bytedance.adsdk.ugeno.pA.Og;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.SD.omh;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes6.dex */
public class Og extends pA {
    public Og(Context context, com.bytedance.adsdk.ugeno.Og.KZx kZx, String str, TreeMap<Float, String> treeMap) {
        super(context, kZx, str, treeMap);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.pA.Og.Og$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pA;

        static {
            int[] iArr = new int[com.bytedance.adsdk.ugeno.pA.ZZv.values().length];
            pA = iArr;
            try {
                iArr[com.bytedance.adsdk.ugeno.pA.ZZv.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                pA[com.bytedance.adsdk.ugeno.pA.ZZv.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public void Og() {
        float fWV;
        switch (AnonymousClass1.pA[this.ZZv.ordinal()]) {
            case 1:
                fWV = this.SD.WV();
                break;
            case 2:
                fWV = this.SD.Wx();
                break;
            case 3:
                fWV = this.SD.Sn();
                break;
            case 4:
                fWV = this.SD.DX();
                break;
            case 5:
                fWV = this.SD.oX();
                break;
            case 6:
                fWV = this.SD.aBv();
                break;
            case 7:
                fWV = this.SD.XT();
                break;
            case 8:
                fWV = this.SD.yFO();
                break;
            case 9:
                fWV = this.SD.vZF();
                break;
            default:
                fWV = 0.0f;
                break;
        }
        this.ML.add(Keyframe.ofFloat(0.0f, fWV));
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public void pA(float f, String str) {
        float fPA;
        if (this.Og.startsWith(com.bytedance.adsdk.ugeno.pA.ZZv.TRANSLATE.pA()) || this.ZZv == com.bytedance.adsdk.ugeno.pA.ZZv.BORDER_RADIUS) {
            fPA = omh.pA(this.pA, com.bytedance.adsdk.ugeno.SD.KZx.pA(str, 0.0f));
        } else {
            fPA = com.bytedance.adsdk.ugeno.SD.KZx.pA(str, 0.0f);
        }
        this.ML.add(Keyframe.ofFloat(f, fPA));
    }

    @Override // com.bytedance.adsdk.ugeno.pA.Og.pA
    public TypeEvaluator JG() {
        return new FloatEvaluator();
    }
}
