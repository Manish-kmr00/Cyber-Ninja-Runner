package com.yandex.div.internal.widget.slider;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SliderView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"com/yandex/div/internal/widget/slider/SliderView$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "hasCanceled", "", "prevThumbValue", "", "getPrevThumbValue", "()F", "setPrevThumbValue", "(F)V", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SliderView$animatorListener$1 implements Animator.AnimatorListener {
    private boolean hasCanceled;
    private float prevThumbValue;
    final /* synthetic */ SliderView this$0;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    SliderView$animatorListener$1(SliderView sliderView) {
        this.this$0 = sliderView;
    }

    public final float getPrevThumbValue() {
        return this.prevThumbValue;
    }

    public final void setPrevThumbValue(float f) {
        this.prevThumbValue = f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.sliderAnimator = null;
        if (this.hasCanceled) {
            return;
        }
        this.this$0.notifyThumbChangedListeners(Float.valueOf(this.prevThumbValue), this.this$0.getThumbValue());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.hasCanceled = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.hasCanceled = false;
    }
}
