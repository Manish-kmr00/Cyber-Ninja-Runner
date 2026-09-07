package io.bidmachine.rendering.model;

import android.content.Context;
import io.bidmachine.rendering.utils.UiUtils;

/* JADX INFO: loaded from: classes6.dex */
public class AppearanceParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f12404a;
    private final Boolean b;
    private final Boolean c;
    private final Float d;
    private final FontStyleType e;
    private final Float f;
    private final Integer g;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f12405a;
        private Boolean b;
        private Boolean c;
        private Float d;
        private FontStyleType e;
        private Float f;
        private Integer g;

        public AppearanceParams build() {
            return new AppearanceParams(this.f12405a, this.b, this.c, this.d, this.e, this.f, this.g);
        }

        public Builder setBackgroundColor(Integer backgroundColor) {
            this.f12405a = backgroundColor;
            return this;
        }

        public Builder setClickable(Boolean clickable) {
            this.c = clickable;
            return this;
        }

        public Builder setFontStyleType(FontStyleType fontStyleType) {
            this.e = fontStyleType;
            return this;
        }

        public Builder setOpacity(Float opacity) {
            this.d = opacity;
            return this;
        }

        public Builder setStrokeColor(Integer strokeColor) {
            this.g = strokeColor;
            return this;
        }

        public Builder setStrokeWidth(Float strokeWidthDp) {
            this.f = strokeWidthDp;
            return this;
        }

        public Builder setVisible(Boolean visible) {
            this.b = visible;
            return this;
        }
    }

    public AppearanceParams(Integer backgroundColor, Boolean visible, Boolean clickable, Float opacity, FontStyleType fontStyleType, Float strokeWidth, Integer strokeColor) {
        this.f12404a = backgroundColor;
        this.b = visible;
        this.c = clickable;
        this.d = opacity;
        this.e = fontStyleType;
        this.f = strokeWidth;
        this.g = strokeColor;
    }

    public Integer getBackgroundColor() {
        return this.f12404a;
    }

    public Boolean getClickable() {
        return this.c;
    }

    public FontStyleType getFontStyleType() {
        return this.e;
    }

    public Float getOpacity() {
        return this.d;
    }

    public Integer getStrokeColor() {
        return this.g;
    }

    public Float getStrokeWidth() {
        return this.f;
    }

    public Integer getStrokeWidthPx(Context context) {
        Float f = this.f;
        if (f != null) {
            return Integer.valueOf(UiUtils.dpToPx(context, f.floatValue()));
        }
        return null;
    }

    public Boolean getVisible() {
        return this.b;
    }
}
