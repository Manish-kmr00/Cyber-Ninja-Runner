package com.yandex.div.core.util.text;

import android.graphics.Canvas;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.compose.material.OutlinedTextFieldKt;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivTextRangeBackground;
import com.yandex.div2.DivTextRangeBorder;
import io.appmetrica.analytics.impl.J2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTextRangesBackgroundRenderer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JL\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yandex/div/core/util/text/MultiLineRenderer;", "Lcom/yandex/div/core/util/text/DivTextRangesBackgroundRenderer;", "view", "Landroid/view/View;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Landroid/view/View;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "layout", "Landroid/text/Layout;", "startLine", "", "endLine", "startOffset", "endOffset", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivTextRangeBorder;", J2.g, "Lcom/yandex/div2/DivTextRangeBackground;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MultiLineRenderer extends DivTextRangesBackgroundRenderer {
    private final ExpressionResolver resolver;
    private final View view;

    public MultiLineRenderer(View view, ExpressionResolver resolver) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        this.view = view;
        this.resolver = resolver;
    }

    @Override // com.yandex.div.core.util.text.DivTextRangesBackgroundRenderer
    public void draw(Canvas canvas, Layout layout, int startLine, int endLine, int startOffset, int endOffset, DivTextRangeBorder border, DivTextRangeBackground background) {
        float lineRight;
        float lineLeft;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layout, "layout");
        int paragraphDirection = layout.getParagraphDirection(startLine);
        if (paragraphDirection == -1) {
            lineRight = layout.getLineLeft(startLine);
        } else {
            lineRight = layout.getLineRight(startLine);
        }
        int lineBottom = getLineBottom(layout, startLine);
        int lineTop = getLineTop(layout, startLine);
        DisplayMetrics displayMetrics = this.view.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "view.resources.displayMetrics");
        BackgroundDrawer backgroundDrawer = new BackgroundDrawer(displayMetrics, border, background, canvas, this.resolver);
        backgroundDrawer.drawBackgroundStart(startOffset, lineTop, (int) lineRight, lineBottom);
        for (int i = startLine + 1; i < endLine; i++) {
            backgroundDrawer.drawBackgroundMiddle((int) layout.getLineLeft(i), getLineTop(layout, i), (int) layout.getLineRight(i), getLineBottom(layout, i));
        }
        if (paragraphDirection == -1) {
            lineLeft = layout.getLineRight(startLine);
        } else {
            lineLeft = layout.getLineLeft(startLine);
        }
        backgroundDrawer.drawBackgroundEnd((int) lineLeft, getLineTop(layout, endLine), endOffset, getLineBottom(layout, endLine));
    }
}
