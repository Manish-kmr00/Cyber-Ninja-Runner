package com.yandex.div.internal.graphics;

import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.view2.Div2View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Colormap.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"checkIsNotEmpty", "Lcom/yandex/div/internal/graphics/Colormap;", "divView", "Lcom/yandex/div/core/view2/Div2View;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ColormapKt {
    public static final Colormap checkIsNotEmpty(Colormap colormap, Div2View divView) {
        Intrinsics.checkNotNullParameter(colormap, "<this>");
        Intrinsics.checkNotNullParameter(divView, "divView");
        if (Intrinsics.areEqual(colormap, Colormap.EMPTY)) {
            DivActionTypedUtilsKt.logError(divView, new IllegalStateException("Colors for linear gradient are not provided. Please check if 'colors' or 'color_map' properties are defined"));
        }
        return colormap;
    }
}
