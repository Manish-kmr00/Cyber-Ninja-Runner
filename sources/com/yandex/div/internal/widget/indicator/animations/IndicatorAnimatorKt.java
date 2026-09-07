package com.yandex.div.internal.widget.indicator.animations;

import com.yandex.div.internal.widget.indicator.IndicatorParams;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndicatorAnimator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"getIndicatorAnimator", "Lcom/yandex/div/internal/widget/indicator/animations/IndicatorAnimator;", "style", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class IndicatorAnimatorKt {

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndicatorParams.Animation.values().length];
            try {
                iArr[IndicatorParams.Animation.SCALE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndicatorParams.Animation.WORM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndicatorParams.Animation.SLIDER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final IndicatorAnimator getIndicatorAnimator(IndicatorParams.Style style) {
        Intrinsics.checkNotNullParameter(style, "style");
        int i = WhenMappings.$EnumSwitchMapping$0[style.getAnimation().ordinal()];
        if (i == 1) {
            return new ScaleIndicatorAnimator(style);
        }
        if (i == 2) {
            return new WormIndicatorAnimator(style);
        }
        if (i == 3) {
            return new SliderIndicatorAnimator(style);
        }
        throw new NoWhenBranchMatchedException();
    }
}
