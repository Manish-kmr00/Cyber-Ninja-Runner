package com.yandex.div.internal.widget.slider;

import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SliderTextStyle.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/yandex/div/internal/widget/slider/SliderTextStyle;", "", "fontSize", "", "fontWeight", "Landroid/graphics/Typeface;", "offsetX", "offsetY", "textColor", "", "(FLandroid/graphics/Typeface;FFI)V", "getFontSize", "()F", "getFontWeight", "()Landroid/graphics/Typeface;", "getOffsetX", "getOffsetY", "getTextColor", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class SliderTextStyle {
    private final float fontSize;
    private final Typeface fontWeight;
    private final float offsetX;
    private final float offsetY;
    private final int textColor;

    public static /* synthetic */ SliderTextStyle copy$default(SliderTextStyle sliderTextStyle, float f, Typeface typeface, float f2, float f3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = sliderTextStyle.fontSize;
        }
        if ((i2 & 2) != 0) {
            typeface = sliderTextStyle.fontWeight;
        }
        Typeface typeface2 = typeface;
        if ((i2 & 4) != 0) {
            f2 = sliderTextStyle.offsetX;
        }
        float f4 = f2;
        if ((i2 & 8) != 0) {
            f3 = sliderTextStyle.offsetY;
        }
        float f5 = f3;
        if ((i2 & 16) != 0) {
            i = sliderTextStyle.textColor;
        }
        return sliderTextStyle.copy(f, typeface2, f4, f5, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getFontSize() {
        return this.fontSize;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Typeface getFontWeight() {
        return this.fontWeight;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getOffsetX() {
        return this.offsetX;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getOffsetY() {
        return this.offsetY;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    public final SliderTextStyle copy(float fontSize, Typeface fontWeight, float offsetX, float offsetY, int textColor) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        return new SliderTextStyle(fontSize, fontWeight, offsetX, offsetY, textColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SliderTextStyle)) {
            return false;
        }
        SliderTextStyle sliderTextStyle = (SliderTextStyle) other;
        return Float.compare(this.fontSize, sliderTextStyle.fontSize) == 0 && Intrinsics.areEqual(this.fontWeight, sliderTextStyle.fontWeight) && Float.compare(this.offsetX, sliderTextStyle.offsetX) == 0 && Float.compare(this.offsetY, sliderTextStyle.offsetY) == 0 && this.textColor == sliderTextStyle.textColor;
    }

    public int hashCode() {
        return (((((((Float.hashCode(this.fontSize) * 31) + this.fontWeight.hashCode()) * 31) + Float.hashCode(this.offsetX)) * 31) + Float.hashCode(this.offsetY)) * 31) + Integer.hashCode(this.textColor);
    }

    public String toString() {
        return "SliderTextStyle(fontSize=" + this.fontSize + ", fontWeight=" + this.fontWeight + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", textColor=" + this.textColor + ')';
    }

    public SliderTextStyle(float f, Typeface fontWeight, float f2, float f3, int i) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        this.fontSize = f;
        this.fontWeight = fontWeight;
        this.offsetX = f2;
        this.offsetY = f3;
        this.textColor = i;
    }

    public final float getFontSize() {
        return this.fontSize;
    }

    public final Typeface getFontWeight() {
        return this.fontWeight;
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final int getTextColor() {
        return this.textColor;
    }
}
