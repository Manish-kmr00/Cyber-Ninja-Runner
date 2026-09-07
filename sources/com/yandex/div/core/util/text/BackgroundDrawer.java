package com.yandex.div.core.util.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import androidx.compose.material.OutlinedTextFieldKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.core.view2.divs.widgets.DivBorderDrawerKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivSolidBackground;
import com.yandex.div2.DivStroke;
import com.yandex.div2.DivTextRangeBackground;
import com.yandex.div2.DivTextRangeBorder;
import io.appmetrica.analytics.impl.J2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTextRangesBackgroundRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018J2\u0010\u0015\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J&\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018J&\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018J&\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018J2\u0010\u001f\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u001a\u0010 \u001a\u00020!2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020#H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/yandex/div/core/util/text/BackgroundDrawer;", "", "metrics", "Landroid/util/DisplayMetrics;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivTextRangeBorder;", J2.g, "Lcom/yandex/div2/DivTextRangeBackground;", "canvas", "Landroid/graphics/Canvas;", "resolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Landroid/util/DisplayMetrics;Lcom/yandex/div2/DivTextRangeBorder;Lcom/yandex/div2/DivTextRangeBackground;Landroid/graphics/Canvas;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "borerPaint", "Landroid/graphics/Paint;", "getBorerPaint", "()Landroid/graphics/Paint;", "radii", "", "getRadii", "()[F", "drawBackground", "", "start", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "end", "bottom", "drawBackgroundEnd", "drawBackgroundMiddle", "drawBackgroundStart", "drawBorder", "getPath", "Landroid/graphics/Path;", "rect", "Landroid/graphics/RectF;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class BackgroundDrawer {
    private final DivTextRangeBackground background;
    private final DivTextRangeBorder border;
    private final Paint borerPaint;
    private final Canvas canvas;
    private final DisplayMetrics metrics;
    private final float[] radii;
    private final ExpressionResolver resolver;

    public BackgroundDrawer(DisplayMetrics metrics, DivTextRangeBorder divTextRangeBorder, DivTextRangeBackground divTextRangeBackground, Canvas canvas, ExpressionResolver resolver) {
        Expression<Integer> expression;
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        this.metrics = metrics;
        this.border = divTextRangeBorder;
        this.background = divTextRangeBackground;
        this.canvas = canvas;
        this.resolver = resolver;
        Paint paint = new Paint();
        this.borerPaint = paint;
        if (divTextRangeBorder != null) {
            this.radii = DivTextRangesBackgroundRendererKt.getCornerRadii(divTextRangeBorder, metrics, resolver);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(DivBorderDrawerKt.widthPx(divTextRangeBorder.stroke, resolver, metrics));
            DivStroke divStroke = divTextRangeBorder.stroke;
            if (divStroke == null || (expression = divStroke.color) == null) {
                return;
            }
            paint.setColor(expression.evaluate(resolver).intValue());
            return;
        }
        this.radii = null;
    }

    public final Paint getBorerPaint() {
        return this.borerPaint;
    }

    public final float[] getRadii() {
        return this.radii;
    }

    public final void drawBackgroundEnd(float start, float top, float end, float bottom) {
        float[] fArr = new float[8];
        float[] fArr2 = this.radii;
        if (fArr2 != null) {
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = fArr2[2];
            fArr[3] = fArr2[3];
            fArr[4] = fArr2[4];
            fArr[5] = fArr2[5];
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
        }
        drawBackground(fArr, start, top, end, bottom);
    }

    public final void drawBackgroundStart(float start, float top, float end, float bottom) {
        float[] fArr = new float[8];
        float[] fArr2 = this.radii;
        if (fArr2 != null) {
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = fArr2[6];
            fArr[7] = fArr2[7];
        }
        drawBackground(fArr, start, top, end, bottom);
    }

    public final void drawBackgroundMiddle(float start, float top, float end, float bottom) {
        drawBackground(new float[8], start, top, end, bottom);
    }

    public final void drawBackground(float start, float top, float end, float bottom) {
        drawBackground(this.radii, start, top, end, bottom);
    }

    private final void drawBackground(float[] radii, float start, float top, float end, float bottom) {
        RectF rectF = new RectF();
        rectF.set(start, top, end, bottom);
        DivTextRangeBackground divTextRangeBackground = this.background;
        Object objValue = divTextRangeBackground != null ? divTextRangeBackground.value() : null;
        if (objValue instanceof DivSolidBackground) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(((DivSolidBackground) objValue).color.evaluate(this.resolver).intValue());
            this.canvas.drawPath(getPath(radii, rectF), paint);
        }
        drawBorder(radii, start, top, end, bottom);
    }

    private final void drawBorder(float[] radii, float start, float top, float end, float bottom) {
        DivTextRangeBorder divTextRangeBorder = this.border;
        if ((divTextRangeBorder != null ? divTextRangeBorder.stroke : null) == null) {
            return;
        }
        RectF rectF = new RectF();
        DivStroke divStroke = this.border.stroke;
        Intrinsics.checkNotNull(divStroke);
        float fWidthPx = DivBorderDrawerKt.widthPx(divStroke, this.resolver, this.metrics) / 2.0f;
        rectF.set(Math.max(0.0f, start + fWidthPx), Math.max(0.0f, top + fWidthPx), Math.max(0.0f, end - fWidthPx), Math.max(0.0f, bottom - fWidthPx));
        float[] fArr = radii != null ? (float[]) radii.clone() : null;
        if (fArr != null) {
            int length = fArr.length;
            for (int i = 0; i < length; i++) {
                fArr[i] = Math.max(0.0f, radii[i] - fWidthPx);
            }
        }
        this.canvas.drawPath(getPath(fArr, rectF), this.borerPaint);
    }

    private final Path getPath(float[] radii, RectF rect) {
        Path path = new Path();
        path.reset();
        if (radii == null) {
            path.addRect(rect, Path.Direction.CW);
        } else {
            path.addRoundRect(rect, radii, Path.Direction.CW);
        }
        path.close();
        return path;
    }
}
