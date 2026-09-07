package com.yandex.div.core.util.text;

import android.graphics.Canvas;
import android.text.Layout;
import androidx.compose.material.OutlinedTextFieldKt;
import com.yandex.div2.DivTextRangeBackground;
import com.yandex.div2.DivTextRangeBorder;
import io.appmetrica.analytics.impl.J2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTextRangesBackgroundRenderer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JL\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0004J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0004J\u0014\u0010\u0015\u001a\u00020\n*\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0014\u0010\u0016\u001a\u00020\n*\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0002¨\u0006\u0017"}, d2 = {"Lcom/yandex/div/core/util/text/DivTextRangesBackgroundRenderer;", "", "()V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "layout", "Landroid/text/Layout;", "startLine", "", "endLine", "startOffset", "endOffset", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivTextRangeBorder;", J2.g, "Lcom/yandex/div2/DivTextRangeBackground;", "getLineBottom", "line", "getLineTop", "getLineBottomWithoutSpacing", "getLineHeight", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DivTextRangesBackgroundRenderer {
    public abstract void draw(Canvas canvas, Layout layout, int startLine, int endLine, int startOffset, int endOffset, DivTextRangeBorder border, DivTextRangeBackground background);

    protected final int getLineTop(Layout layout, int line) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        int lineTop = layout.getLineTop(line);
        return line == 0 ? lineTop - layout.getTopPadding() : lineTop;
    }

    protected final int getLineBottom(Layout layout, int line) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        int lineBottomWithoutSpacing = getLineBottomWithoutSpacing(layout, line);
        return line == layout.getLineCount() + (-1) ? lineBottomWithoutSpacing - layout.getBottomPadding() : lineBottomWithoutSpacing;
    }

    private final int getLineBottomWithoutSpacing(Layout layout, int i) {
        int lineBottom = layout.getLineBottom(i);
        boolean z = i == layout.getLineCount() - 1;
        float spacingAdd = layout.getSpacingAdd();
        float spacingMultiplier = layout.getSpacingMultiplier();
        if ((spacingAdd == 0.0f && spacingMultiplier == 1.0f) || z) {
            return lineBottom;
        }
        if (Float.compare(spacingMultiplier, 1.0f) != 0) {
            float lineHeight = getLineHeight(layout, i);
            spacingAdd = lineHeight - ((lineHeight - spacingAdd) / spacingMultiplier);
        }
        return (int) (lineBottom - spacingAdd);
    }

    private final int getLineHeight(Layout layout, int i) {
        return layout.getLineTop(i + 1) - layout.getLineTop(i);
    }
}
