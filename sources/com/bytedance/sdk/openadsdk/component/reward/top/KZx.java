package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Sn;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class KZx extends View implements pA<KZx> {
    private pA<KZx> pA;

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public KZx(Context context) {
        this(context, null);
    }

    public KZx(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KZx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View getITopLayout() {
        Object obj = this.pA;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public KZx pA(yFO yfo) {
        if (this.pA != null) {
            return this;
        }
        TopLayoutDislike2 topLayoutDislike2M4736load = new TopLayoutDislike2(getContext()).load(yfo);
        this.pA = topLayoutDislike2M4736load;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            pA(topLayoutDislike2M4736load, (ViewGroup) parent);
        }
        return this;
    }

    private void pA(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
        if (view != null) {
            view.setId(Sn.gl);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setShowSkip(boolean z) {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setShowSkip(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setSkipEnable(boolean z) {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setSkipEnable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setSkipInvisiable() {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setSkipInvisiable();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setSkipText(CharSequence charSequence) {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setSkipText(charSequence);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void showCountDownText() {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.showCountDownText();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void showSkipButton() {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.showSkipButton();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setShowSound(boolean z) {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setShowSound(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setSoundMute(boolean z) {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setTime(charSequence, charSequence2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setShowDislike(boolean z) {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setShowDislike(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void setListener(Og og) {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.setListener(og);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void clickSkip() {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.clickSkip();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void clickSound() {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.clickSound();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public void showCloseButton() {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            pAVar.showCloseButton();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.pA
    public View getCloseButton() {
        pA<KZx> pAVar = this.pA;
        if (pAVar != null) {
            return pAVar.getCloseButton();
        }
        return null;
    }
}
