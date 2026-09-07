package com.yandex.div.core.view2.spannable;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LineMetricsSpan.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J`\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/spannable/LineMetricsSpan;", "Landroid/text/style/LineBackgroundSpan;", "()V", "linePaint", "Landroid/graphics/Paint;", "drawBackground", "", "canvas", "Landroid/graphics/Canvas;", "paint", "left", "", "right", ViewHierarchyConstants.DIMENSION_TOP_KEY, "baseline", "bottom", "text", "", "start", "end", "lineNumber", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LineMetricsSpan implements LineBackgroundSpan {
    private final Paint linePaint;

    public LineMetricsSpan() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(false);
        paint.setStrokeWidth(0.0f);
        this.linePaint = paint;
    }

    @Override // android.text.style.LineBackgroundSpan
    public void drawBackground(Canvas canvas, Paint paint, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lineNumber) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        this.linePaint.setColor(-16764855);
        float f = top;
        float f2 = left;
        float f3 = right;
        canvas.drawLine(f2, f, f3, f, this.linePaint);
        this.linePaint.setColor(-557312);
        this.linePaint.setPathEffect(new DashPathEffect(new float[]{8.0f, 4.0f, 1.0f, 4.0f}, 0.0f));
        float f4 = f + ((bottom - top) / 2.0f);
        canvas.drawLine(f2, f4, f3, f4, this.linePaint);
        this.linePaint.setColor(-2742232);
        this.linePaint.setPathEffect(null);
        float f5 = baseline - 1;
        canvas.drawLine(f2, f5, f3, f5, this.linePaint);
        this.linePaint.setColor(-213175);
        float f6 = bottom - 1;
        canvas.drawLine(f2, f6, f3, f6, this.linePaint);
    }
}
