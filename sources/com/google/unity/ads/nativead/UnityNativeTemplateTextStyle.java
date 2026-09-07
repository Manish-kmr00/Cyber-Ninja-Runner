package com.google.unity.ads.nativead;

import android.graphics.drawable.ColorDrawable;
import java.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public final class UnityNativeTemplateTextStyle {
    private final ColorDrawable backgroundColor;
    private final UnityNativeTemplateFontStyle fontStyle;
    private final Double size;
    private final ColorDrawable textColor;

    public UnityNativeTemplateTextStyle(ColorDrawable textColor, ColorDrawable backgroundColor, UnityNativeTemplateFontStyle fontStyle, Double size) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
        this.fontStyle = fontStyle;
        this.size = size;
    }

    public ColorDrawable getTextColor() {
        return this.textColor;
    }

    public ColorDrawable getBackgroundColor() {
        return this.backgroundColor;
    }

    public UnityNativeTemplateFontStyle getFontStyle() {
        return this.fontStyle;
    }

    public Float getSize() {
        Double d = this.size;
        if (d == null) {
            return null;
        }
        return Float.valueOf(d.floatValue());
    }

    public boolean equals(Object o) {
        ColorDrawable colorDrawable;
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof UnityNativeTemplateTextStyle)) {
            return false;
        }
        UnityNativeTemplateTextStyle unityNativeTemplateTextStyle = (UnityNativeTemplateTextStyle) o;
        ColorDrawable colorDrawable2 = this.textColor;
        return ((colorDrawable2 == null && unityNativeTemplateTextStyle.textColor == null) || colorDrawable2.getColor() == unityNativeTemplateTextStyle.textColor.getColor()) && (((colorDrawable = this.backgroundColor) == null && unityNativeTemplateTextStyle.backgroundColor == null) || colorDrawable.getColor() == unityNativeTemplateTextStyle.backgroundColor.getColor()) && Objects.equals(this.size, unityNativeTemplateTextStyle.size) && Objects.equals(this.fontStyle, unityNativeTemplateTextStyle.fontStyle);
    }

    public int hashCode() {
        ColorDrawable colorDrawable = this.textColor;
        Integer numValueOf = colorDrawable == null ? null : Integer.valueOf(colorDrawable.getColor());
        ColorDrawable colorDrawable2 = this.backgroundColor;
        return Objects.hash(numValueOf, colorDrawable2 != null ? Integer.valueOf(colorDrawable2.getColor()) : null, this.size, this.fontStyle);
    }
}
