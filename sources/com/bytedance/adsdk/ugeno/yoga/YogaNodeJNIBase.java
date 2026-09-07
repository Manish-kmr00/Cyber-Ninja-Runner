package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public abstract class YogaNodeJNIBase extends WV implements Cloneable {
    private Object JG;
    private List<YogaNodeJNIBase> KZx;
    private KZx ML;
    private YogaNodeJNIBase Og;
    private boolean SD;
    private Bzk ZZv;
    private float[] arr;
    private int mLayoutDirection;
    protected long pA;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.SD = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.pA = j;
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public int pA() {
        List<YogaNodeJNIBase> list = this.KZx;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    /* JADX INFO: renamed from: KZx, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase pA(int i) {
        List<YogaNodeJNIBase> list = this.KZx;
        if (list == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return list.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(WV wv, int i) {
        if (wv instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) wv;
            if (yogaNodeJNIBase.Og != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.KZx == null) {
                this.KZx = new ArrayList(4);
            }
            this.KZx.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.Og = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.pA, yogaNodeJNIBase.pA, i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    /* JADX INFO: renamed from: ZZv, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase Og(int i) {
        List<YogaNodeJNIBase> list = this.KZx;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase yogaNodeJNIBaseRemove = list.remove(i);
        yogaNodeJNIBaseRemove.Og = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.pA, yogaNodeJNIBaseRemove.pA);
        return yogaNodeJNIBaseRemove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    /* JADX INFO: renamed from: SGo, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase Og() {
        return this.Og;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public int pA(WV wv) {
        List<YogaNodeJNIBase> list = this.KZx;
        if (list == null) {
            return -1;
        }
        return list.indexOf(wv);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(float f, float f2) {
        Og((WV) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.KZx;
            if (list != null) {
                for (YogaNodeJNIBase yogaNodeJNIBase2 : list) {
                    yogaNodeJNIBase2.Og(yogaNodeJNIBase);
                    arrayList.add(yogaNodeJNIBase2);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].pA;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.pA, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    private void Og(WV wv) {
        Bzk();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(ZZv zZv) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.pA, zZv.pA());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(JG jg) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.pA, jg.pA());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(SD sd) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.pA, sd.pA());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(Og og) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.pA, og.pA());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void Og(Og og) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.pA, og.pA());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void KZx(Og og) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.pA, og.pA());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(DX dx) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.pA, dx.pA());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(oX oXVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.pA, oXVar.pA());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void Og(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void KZx(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(ML ml, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.pA, ml.pA(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void Og(ML ml, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.pA, ml.pA(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void KZx(ML ml, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.pA, ml.pA(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void ZZv(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void ML(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void KZx() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.pA);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void JG(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void SD(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void ZZv() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.pA);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void omh(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void Bzk(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void SGo(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void BSW(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void WV(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.pA, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(Bzk bzk) {
        this.ZZv = bzk;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.pA, bzk != null);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (!BSW()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.ZZv.pA(this, f, SGo.pA(i), f2, SGo.pA(i2));
    }

    public final float baseline(float f, float f2) {
        return this.ML.pA(this, f, f2);
    }

    public boolean BSW() {
        return this.ZZv != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public void pA(Object obj) {
        this.JG = obj;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public Object Bzk() {
        return this.JG;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.KZx;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.KZx.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.Og = this;
        return yogaNodeJNIBase.pA;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public float ML() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public float JG() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public float SD() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.WV
    public float omh() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }
}
