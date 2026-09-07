package com.bytedance.adsdk.ugeno.yoga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class omh extends ViewGroup implements com.bytedance.adsdk.ugeno.Og.Og, com.bytedance.adsdk.ugeno.pA.ML {
    private com.bytedance.adsdk.ugeno.KZx KZx;
    private final WV Og;
    private com.bytedance.adsdk.ugeno.pA.JG ZZv;
    private final Map<View, WV> pA;

    public omh(Context context) {
        this(context, null, 0);
    }

    public omh(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ZZv = new com.bytedance.adsdk.ugeno.pA.JG(this);
        WV wvPA = Wx.pA();
        this.Og = wvPA;
        this.pA = new HashMap();
        wvPA.pA(this);
        wvPA.pA((Bzk) new Og());
        pA((pA) generateDefaultLayoutParams(), wvPA, this);
    }

    public WV getYogaNode() {
        return this.Og;
    }

    public WV pA(View view) {
        return this.pA.get(view);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.Og
    public void pA(int i) {
        WV wv = this.Og;
        if (wv != null) {
            pA(wv, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.Og
    public void Og(int i) {
        WV wv = this.Og;
        if (wv != null) {
            Og(wv, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.Og
    public void pA(View view, int i) {
        WV wvPA;
        if (view == null || (wvPA = pA(view)) == null) {
            return;
        }
        pA(wvPA, i);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.Og.Og
    public void Og(View view, int i) {
        WV wvPA;
        if (view == null || (wvPA = pA(view)) == null) {
            return;
        }
        Og(wvPA, i);
        view.requestLayout();
    }

    private void pA(WV wv, int i) {
        if (i == -1) {
            wv.ML(100.0f);
        } else if (i == -2) {
            wv.KZx();
        } else {
            wv.ZZv(i);
        }
    }

    private void Og(WV wv, int i) {
        if (i == -1) {
            wv.SD(100.0f);
        } else if (i == -2) {
            wv.ZZv();
        } else {
            wv.JG(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.Og
    public void KZx(View view, int i) {
        ZZv(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        WV wvPA;
        this.Og.pA((Bzk) null);
        if (view instanceof com.bytedance.adsdk.ugeno.yoga.pA) {
            throw null;
        }
        super.addView(view, i, layoutParams);
        if (this.pA.containsKey(view)) {
            return;
        }
        if (view instanceof omh) {
            wvPA = ((omh) view).getYogaNode();
        } else {
            if (this.pA.containsKey(view)) {
                wvPA = this.pA.get(view);
            } else {
                wvPA = Wx.pA();
            }
            wvPA.pA(view);
            wvPA.pA((Bzk) new Og());
        }
        pA((pA) view.getLayoutParams(), wvPA, view);
        this.pA.put(view, wvPA);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.Og.pA()));
        } else {
            WV wv = this.Og;
            wv.pA(wvPA, wv.pA());
        }
    }

    public void ZZv(View view, int i) {
        int iPA;
        view.setVisibility(i);
        try {
            WV wv = this.pA.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (iPA = this.Og.pA(wv)) == -1) {
                    return;
                }
                this.Og.Og(iPA);
                view.setTag(151060224, Integer.valueOf(iPA));
                pA(this.Og);
                return;
            }
            if (tag == null || this.Og.pA(wv) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.Og.pA()) {
                this.Og.pA(this.pA.get(view), iIntValue);
            } else {
                this.Og.pA(this.pA.get(view), this.Og.pA());
            }
            pA(this.Og);
        } catch (Throwable unused) {
        }
    }

    private void pA(WV wv) {
        if (wv.Og() != null) {
            pA(wv.Og());
        } else {
            wv.pA(Float.NaN, Float.NaN);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        pA(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        pA(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        pA(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            pA(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            pA(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            pA(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            pA(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    private void pA(View view, boolean z) {
        WV wv = this.pA.get(view);
        if (wv == null) {
            return;
        }
        WV wvOg = wv.Og();
        for (int i = 0; i < wvOg.pA(); i++) {
            if (wvOg.pA(i).equals(wv)) {
                wvOg.Og(i);
                break;
            }
        }
        wv.pA((Object) null);
        this.pA.remove(view);
        if (z) {
            this.Og.pA(Float.NaN, Float.NaN);
        }
    }

    private void pA(WV wv, float f, float f2) {
        View view = (View) wv.Bzk();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(wv.ML() + f);
            int iRound2 = Math.round(wv.JG() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(wv.SD()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(wv.omh()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iPA = wv.pA();
        for (int i = 0; i < iPA; i++) {
            if (equals(view)) {
                pA(wv.pA(i), f, f2);
            } else if (!(view instanceof omh)) {
                pA(wv.pA(i), wv.ML() + f, wv.JG() + f2);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.pA(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.JG();
        }
        if (!(getParent() instanceof omh)) {
            pA(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        pA(this.Og, 0.0f, 0.0f);
        com.bytedance.adsdk.ugeno.KZx kZx2 = this.KZx;
        if (kZx2 != null) {
            kZx2.pA(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(getParent() instanceof omh)) {
            pA(i, i2);
        }
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            int[] iArrPA = kZx.pA(i, i2);
            setMeasuredDimension(iArrPA[0], iArrPA[1]);
        } else {
            setMeasuredDimension(Math.round(this.Og.SD()), Math.round(this.Og.omh()));
        }
        com.bytedance.adsdk.ugeno.KZx kZx2 = this.KZx;
        if (kZx2 != null) {
            kZx2.ML();
        }
    }

    private void pA(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.Og.JG(size2);
        }
        if (mode == 1073741824) {
            this.Og.ZZv(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.Og.BSW(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.Og.SGo(size);
        }
        this.Og.pA(Float.NaN, Float.NaN);
    }

    protected static void pA(pA pAVar, WV wv, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            wv.pA(ZZv.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            Rect rect = new Rect();
            if (background.getPadding(rect)) {
                wv.Og(ML.LEFT, rect.left);
                wv.Og(ML.TOP, rect.top);
                wv.Og(ML.RIGHT, rect.right);
                wv.Og(ML.BOTTOM, rect.bottom);
            }
        }
        for (int i = 0; i < pAVar.pA.size(); i++) {
            int iKeyAt = pAVar.pA.keyAt(i);
            float fFloatValue = pAVar.pA.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                wv.KZx(com.bytedance.adsdk.ugeno.yoga.Og.pA(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                wv.pA(com.bytedance.adsdk.ugeno.yoga.Og.pA(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                wv.Og(com.bytedance.adsdk.ugeno.yoga.Og.pA(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                wv.WV(fFloatValue);
            } else if (iKeyAt == 8) {
                wv.KZx(fFloatValue);
            } else if (iKeyAt == 1) {
                wv.pA(JG.pA(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                wv.pA(fFloatValue);
            } else if (iKeyAt == 7) {
                wv.Og(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    wv.SD(100.0f);
                } else if (fFloatValue == -2.0f) {
                    wv.ZZv();
                } else {
                    wv.JG(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                wv.pA(ML.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                wv.pA(SD.pA(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                wv.pA(ML.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                wv.pA(ML.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                wv.pA(ML.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                wv.Bzk(fFloatValue);
            } else if (iKeyAt == 27) {
                wv.omh(fFloatValue);
            } else if (iKeyAt == 22) {
                wv.Og(ML.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                wv.Og(ML.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                wv.Og(ML.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                wv.Og(ML.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                wv.KZx(ML.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                wv.KZx(ML.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                wv.KZx(ML.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                wv.KZx(ML.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                wv.pA(DX.pA(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    wv.ML(100.0f);
                } else if (fFloatValue == -2.0f) {
                    wv.KZx();
                } else {
                    wv.ZZv(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                wv.pA(oX.pA(Math.round(fFloatValue)));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new pA(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new pA(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof pA;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.SD();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.omh();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.KZx kZx = this.KZx;
        if (kZx != null) {
            kZx.Og(i, i2, i3, i4);
        }
    }

    public void pA(com.bytedance.adsdk.ugeno.Og.KZx kZx) {
        this.KZx = kZx;
    }

    public void setBorderRadius(float f) {
        this.ZZv.pA(f);
    }

    public float getBorderRadius() {
        return this.ZZv.pA();
    }

    public void setRipple(float f) {
        com.bytedance.adsdk.ugeno.pA.JG jg = this.ZZv;
        if (jg != null) {
            jg.Og(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getRipple() {
        return this.ZZv.getRipple();
    }

    public void setShine(float f) {
        com.bytedance.adsdk.ugeno.pA.JG jg = this.ZZv;
        if (jg != null) {
            jg.KZx(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getShine() {
        return this.ZZv.getShine();
    }

    public void setStretch(float f) {
        com.bytedance.adsdk.ugeno.pA.JG jg = this.ZZv;
        if (jg != null) {
            jg.ZZv(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getStretch() {
        return this.ZZv.getStretch();
    }

    public void setRubIn(float f) {
        com.bytedance.adsdk.ugeno.pA.JG jg = this.ZZv;
        if (jg != null) {
            jg.ML(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pA.ML
    public float getRubIn() {
        return this.ZZv.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.ZZv.pA(i);
    }

    public static class pA extends ViewGroup.LayoutParams {
        private float BSW;
        private float Bzk;
        private float DX;
        private float JG;
        private float KZx;
        private float ML;
        SparseArray<String> Og;
        private float SD;
        private float SGo;
        private float Sn;
        private float WV;
        private float Wx;
        private float XT;
        private float ZZv;
        private float aBv;
        private float oX;
        private float omh;
        SparseArray<Float> pA;
        private float yFO;

        public pA(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof pA) {
                pA pAVar = (pA) layoutParams;
                this.pA = pAVar.pA.clone();
                this.Og = pAVar.Og.clone();
                return;
            }
            this.pA = new SparseArray<>();
            this.Og = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.pA.put(15, Float.valueOf(this.width));
            }
            if (layoutParams.height >= 0) {
                this.pA.put(16, Float.valueOf(this.height));
            }
        }

        public pA(int i, int i2) {
            super(i, i2);
            this.pA = new SparseArray<>();
            this.Og = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.pA.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.pA.put(16, Float.valueOf(i2));
            }
        }

        public void pA(float f) {
            this.SD = f;
            this.pA.put(5, Float.valueOf(f));
        }

        public void Og(float f) {
            this.omh = f;
            this.pA.put(6, Float.valueOf(f));
        }

        public void KZx(float f) {
            this.Bzk = f;
            this.pA.put(7, Float.valueOf(f));
        }

        public void ZZv(float f) {
            this.SGo = f;
            this.pA.put(8, Float.valueOf(f));
        }

        public void ML(float f) {
            this.BSW = f;
            this.pA.put(9, Float.valueOf(f));
        }

        public void JG(float f) {
            this.WV = f;
            this.pA.put(14, Float.valueOf(f));
        }

        public void SD(float f) {
            this.Wx = f;
            this.pA.put(10, Float.valueOf(f));
        }

        public void omh(float f) {
            this.Sn = f;
            this.pA.put(11, Float.valueOf(f));
        }

        public void Bzk(float f) {
            this.DX = f;
            this.pA.put(12, Float.valueOf(f));
        }

        public void SGo(float f) {
            this.oX = f;
            this.pA.put(13, Float.valueOf(f));
        }

        public void BSW(float f) {
            this.KZx = f;
            this.pA.put(17, Float.valueOf(f));
        }

        public void WV(float f) {
            this.ZZv = f;
            this.pA.put(18, Float.valueOf(f));
        }

        public void Wx(float f) {
            this.ML = f;
            this.pA.put(19, Float.valueOf(f));
        }

        public void Sn(float f) {
            this.JG = f;
            this.pA.put(20, Float.valueOf(f));
        }

        public void DX(float f) {
            this.aBv = f;
            this.pA.put(25, Float.valueOf(f));
        }

        public void oX(float f) {
            this.XT = f;
            this.pA.put(27, Float.valueOf(f));
        }

        public void aBv(float f) {
            this.yFO = f;
            this.pA.put(28, Float.valueOf(f));
        }
    }

    public static class Og implements Bzk {
        @Override // com.bytedance.adsdk.ugeno.yoga.Bzk
        public long pA(WV wv, float f, SGo sGo, float f2, SGo sGo2) {
            View view = (View) wv.Bzk();
            if (view == null || (view instanceof omh)) {
                return BSW.pA(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, pA(sGo)), View.MeasureSpec.makeMeasureSpec((int) f2, pA(sGo2)));
            return BSW.pA(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int pA(SGo sGo) {
            if (sGo == SGo.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return sGo == SGo.EXACTLY ? 1073741824 : 0;
        }
    }
}
