package com.yandex.div.internal.widget.slider;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SliderView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"com/yandex/div/internal/widget/slider/SliderView$animatorSecondaryListener$1", "Landroid/animation/Animator$AnimatorListener;", "hasCanceled", "", "prevThumbSecondaryValue", "", "getPrevThumbSecondaryValue", "()Ljava/lang/Float;", "setPrevThumbSecondaryValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SliderView$animatorSecondaryListener$1 implements Animator.AnimatorListener {
    private boolean hasCanceled;
    private Float prevThumbSecondaryValue;
    final /* synthetic */ SliderView this$0;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    SliderView$animatorSecondaryListener$1(SliderView sliderView) {
        this.this$0 = sliderView;
    }

    public final Float getPrevThumbSecondaryValue() {
        return this.prevThumbSecondaryValue;
    }

    public final void setPrevThumbSecondaryValue(Float f) {
        this.prevThumbSecondaryValue = f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.this$0.sliderSecondaryAnimator = null;
        if (this.hasCanceled) {
            return;
        }
        SliderView sliderView = this.this$0;
        sliderView.notifyThumbSecondaryChangedListeners(this.prevThumbSecondaryValue, sliderView.getThumbSecondaryValue());
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
