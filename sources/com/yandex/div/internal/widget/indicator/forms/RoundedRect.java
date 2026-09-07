package com.yandex.div.internal.widget.indicator.forms;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.yandex.div.internal.widget.indicator.IndicatorParams;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundedRect.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/forms/RoundedRect;", "Lcom/yandex/div/internal/widget/indicator/forms/SingleIndicatorDrawer;", "params", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;", "(Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;)V", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/RectF;", "strokePaint", "draw", "", "canvas", "Landroid/graphics/Canvas;", VastAttributes.HORIZONTAL_POSITION, "", VastAttributes.VERTICAL_POSITION, "itemSize", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "color", "", "strokeWidth", "strokeColor", "drawSelected", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RoundedRect implements SingleIndicatorDrawer {
    private final Paint paint;
    private final IndicatorParams.Style params;
    private final RectF rect;
    private final Paint strokePaint;

    public RoundedRect(IndicatorParams.Style params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        this.paint = new Paint();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        this.strokePaint = paint;
        this.rect = new RectF();
    }

    @Override // com.yandex.div.internal.widget.indicator.forms.SingleIndicatorDrawer
    public void draw(Canvas canvas, float x, float y, IndicatorParams.ItemSize itemSize, int color, float strokeWidth, int strokeColor) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(itemSize, "itemSize");
        IndicatorParams.ItemSize.RoundedRect roundedRect = (IndicatorParams.ItemSize.RoundedRect) itemSize;
        this.paint.setColor(color);
        RectF rectF = this.rect;
        rectF.left = (float) Math.ceil(x - (roundedRect.getItemWidth() / 2.0f));
        rectF.top = (float) Math.ceil(y - (roundedRect.getItemHeight() / 2.0f));
        rectF.right = (float) Math.ceil(x + (roundedRect.getItemWidth() / 2.0f));
        rectF.bottom = (float) Math.ceil(y + (roundedRect.getItemHeight() / 2.0f));
        if (strokeWidth > 0.0f) {
            float f = strokeWidth / 2.0f;
            rectF.left += f;
            rectF.top += f;
            rectF.right -= f;
            rectF.bottom -= f;
        }
        canvas.drawRoundRect(this.rect, roundedRect.getCornerRadius(), roundedRect.getCornerRadius(), this.paint);
        if (strokeColor == 0 || strokeWidth == 0.0f) {
            return;
        }
        Paint paint = this.strokePaint;
        paint.setColor(strokeColor);
        paint.setStrokeWidth(strokeWidth);
        canvas.drawRoundRect(this.rect, roundedRect.getCornerRadius(), roundedRect.getCornerRadius(), this.strokePaint);
    }

    @Override // com.yandex.div.internal.widget.indicator.forms.SingleIndicatorDrawer
    public void drawSelected(Canvas canvas, RectF rect) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(rect, "rect");
        IndicatorParams.Shape activeShape = this.params.getActiveShape();
        Intrinsics.checkNotNull(activeShape, "null cannot be cast to non-null type com.yandex.div.internal.widget.indicator.IndicatorParams.Shape.RoundedRect");
        IndicatorParams.Shape.RoundedRect roundedRect = (IndicatorParams.Shape.RoundedRect) activeShape;
        IndicatorParams.ItemSize.RoundedRect itemSize = roundedRect.getItemSize();
        this.paint.setColor(this.params.getActiveShape().getColor());
        canvas.drawRoundRect(rect, itemSize.getCornerRadius(), itemSize.getCornerRadius(), this.paint);
        if (roundedRect.getStrokeColor() == 0 || roundedRect.getStrokeWidth() == 0.0f) {
            return;
        }
        Paint paint = this.strokePaint;
        paint.setColor(roundedRect.getStrokeColor());
        paint.setStrokeWidth(roundedRect.getStrokeWidth());
        canvas.drawRoundRect(rect, itemSize.getCornerRadius(), itemSize.getCornerRadius(), this.strokePaint);
    }
}
