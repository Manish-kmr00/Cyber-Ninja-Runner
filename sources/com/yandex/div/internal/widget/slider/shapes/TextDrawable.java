package com.yandex.div.internal.widget.slider.shapes;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.yandex.div.internal.widget.slider.SliderTextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/internal/widget/slider/shapes/TextDrawable;", "Landroid/graphics/drawable/Drawable;", "textStyle", "Lcom/yandex/div/internal/widget/slider/SliderTextStyle;", "(Lcom/yandex/div/internal/widget/slider/SliderTextStyle;)V", "rect", "Landroid/graphics/RectF;", "textDrawDelegate", "Lcom/yandex/div/internal/widget/slider/shapes/TextDrawDelegate;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "", "getIntrinsicWidth", "getOffsetY", "getOpacity", "getTextHeight", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setText", "text", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TextDrawable extends Drawable {
    private final RectF rect;
    private TextDrawDelegate textDrawDelegate;
    private final SliderTextStyle textStyle;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public TextDrawable(SliderTextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        this.textStyle = textStyle;
        this.textDrawDelegate = new TextDrawDelegate(textStyle);
        this.rect = new RectF();
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.textDrawDelegate.setText(text);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.rect.set(getBounds());
        this.textDrawDelegate.draw(canvas, this.rect.centerX(), this.rect.centerY());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (this.textStyle.getFontSize() + Math.abs(this.textStyle.getOffsetY()));
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (this.rect.width() + Math.abs(this.textStyle.getOffsetX()));
    }

    public final int getOffsetY() {
        return (int) this.textStyle.getOffsetY();
    }

    public final int getTextHeight() {
        return (int) this.textStyle.getFontSize();
    }
}
