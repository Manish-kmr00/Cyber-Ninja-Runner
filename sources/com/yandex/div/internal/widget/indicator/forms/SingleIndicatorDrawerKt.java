package com.yandex.div.internal.widget.indicator.forms;

import com.yandex.div.internal.widget.indicator.IndicatorParams;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SingleIndicatorDrawer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"getIndicatorDrawer", "Lcom/yandex/div/internal/widget/indicator/forms/SingleIndicatorDrawer;", "style", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SingleIndicatorDrawerKt {
    public static final SingleIndicatorDrawer getIndicatorDrawer(IndicatorParams.Style style) {
        Intrinsics.checkNotNullParameter(style, "style");
        IndicatorParams.Shape activeShape = style.getActiveShape();
        if (activeShape instanceof IndicatorParams.Shape.RoundedRect) {
            return new RoundedRect(style);
        }
        if (activeShape instanceof IndicatorParams.Shape.Circle) {
            return new Circle(style);
        }
        throw new NoWhenBranchMatchedException();
    }
}
