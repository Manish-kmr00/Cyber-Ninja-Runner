package com.yandex.div.core.view2.spannable;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import android.text.style.ParagraphStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontSizeSpan.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/yandex/div/core/view2/spannable/FontSizeSpan;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/style/ParagraphStyle;", "fontSize", "", "lineHeight", "(II)V", "getFontSize", "()I", "getLineHeight", "updateDrawState", "", "paint", "Landroid/text/TextPaint;", "updateMeasureState", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FontSizeSpan extends MetricAffectingSpan implements ParagraphStyle {
    private final int fontSize;
    private final int lineHeight;

    public /* synthetic */ FontSizeSpan(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final int getLineHeight() {
        return this.lineHeight;
    }

    public FontSizeSpan(int i, int i2) {
        this.fontSize = i;
        this.lineHeight = i2;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setTextSize(this.fontSize);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        int i = this.lineHeight;
        if (i == 0) {
            paint.setTextSize(this.fontSize);
        } else if (i < paint.getTextSize()) {
            paint.setTextScaleX(this.fontSize / this.lineHeight);
            paint.setTextSize(this.lineHeight);
        } else {
            paint.setTextScaleX(this.fontSize / paint.getTextSize());
        }
    }
}
