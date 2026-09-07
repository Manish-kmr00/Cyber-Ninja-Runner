package io.bidmachine.rendering.model;

import android.content.Context;
import io.bidmachine.rendering.utils.UiUtils;

/* JADX INFO: loaded from: classes11.dex */
public class ElementLayoutParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f12407a;
    private final float b;
    private final float c;
    private final float d;
    private final SideBindParams e;
    private final SideBindParams f;
    private final SideBindParams g;
    private final SideBindParams h;
    private final float i;
    private final float j;
    private final float k;
    private final float l;
    private final float m;
    private final float n;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f12408a;
        private float b;
        private float c;
        private float d;
        private SideBindParams e;
        private SideBindParams f;
        private SideBindParams g;
        private SideBindParams h;
        private float i;
        private float j;
        private float k;
        private float l;
        private float m;
        private float n;

        public ElementLayoutParams build() {
            return new ElementLayoutParams(this.f12408a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n);
        }

        public Builder setBottomSideBindParams(SideBindParams bottomSideBindParams) {
            this.h = bottomSideBindParams;
            return this;
        }

        public Builder setHeight(float heightDp) {
            this.b = heightDp;
            return this;
        }

        public Builder setHeightPercent(float heightPercent) {
            this.d = heightPercent;
            return this;
        }

        public Builder setLeftSideBindParams(SideBindParams leftSideBindParams) {
            this.e = leftSideBindParams;
            return this;
        }

        public Builder setMarginBottom(float marginBottomDp) {
            this.l = marginBottomDp;
            return this;
        }

        public Builder setMarginLeft(float marginLeftDp) {
            this.i = marginLeftDp;
            return this;
        }

        public Builder setMarginRight(float marginRightDp) {
            this.k = marginRightDp;
            return this;
        }

        public Builder setMarginTop(float marginTopDp) {
            this.j = marginTopDp;
            return this;
        }

        public Builder setRightSideBindParams(SideBindParams rightSideBindParams) {
            this.g = rightSideBindParams;
            return this;
        }

        public Builder setTopSideBindParams(SideBindParams topSideBindParams) {
            this.f = topSideBindParams;
            return this;
        }

        public Builder setTranslationX(float translationXDp) {
            this.m = translationXDp;
            return this;
        }

        public Builder setTranslationY(float translationYDp) {
            this.n = translationYDp;
            return this;
        }

        public Builder setWidth(float widthDp) {
            this.f12408a = widthDp;
            return this;
        }

        public Builder setWidthPercent(float widthPercent) {
            this.c = widthPercent;
            return this;
        }
    }

    public ElementLayoutParams(float width, float height, float widthPercent, float heightPercent, SideBindParams leftSideBindParams, SideBindParams topSideBindParams, SideBindParams rightSideBindParams, SideBindParams bottomSideBindParams, float marginLeft, float marginTop, float marginRight, float marginBottom, float translationX, float translationY) {
        this.f12407a = width;
        this.b = height;
        this.c = widthPercent;
        this.d = heightPercent;
        this.e = leftSideBindParams;
        this.f = topSideBindParams;
        this.g = rightSideBindParams;
        this.h = bottomSideBindParams;
        this.i = marginLeft;
        this.j = marginTop;
        this.k = marginRight;
        this.l = marginBottom;
        this.m = translationX;
        this.n = translationY;
    }

    public SideBindParams getBottomSideBindParams() {
        return this.h;
    }

    public float getHeight() {
        return this.b;
    }

    public float getHeightPercent() {
        return this.d;
    }

    public int getHeightPx(Context context) {
        return UiUtils.dpToPx(context, getHeight());
    }

    public SideBindParams getLeftSideBindParams() {
        return this.e;
    }

    public float getMarginBottom() {
        return this.l;
    }

    public int getMarginBottomPx(Context context) {
        return UiUtils.dpToPx(context, getMarginBottom());
    }

    public float getMarginLeft() {
        return this.i;
    }

    public int getMarginLeftPx(Context context) {
        return UiUtils.dpToPx(context, getMarginLeft());
    }

    public float getMarginRight() {
        return this.k;
    }

    public int getMarginRightPx(Context context) {
        return UiUtils.dpToPx(context, getMarginRight());
    }

    public float getMarginTop() {
        return this.j;
    }

    public int getMarginTopPx(Context context) {
        return UiUtils.dpToPx(context, getMarginTop());
    }

    public SideBindParams getRightSideBindParams() {
        return this.g;
    }

    public SideBindParams getTopSideBindParams() {
        return this.f;
    }

    public float getTranslationX() {
        return this.m;
    }

    public int getTranslationXPx(Context context) {
        return UiUtils.dpToPx(context, getTranslationX());
    }

    public float getTranslationY() {
        return this.n;
    }

    public int getTranslationYPx(Context context) {
        return UiUtils.dpToPx(context, getTranslationY());
    }

    public float getWidth() {
        return this.f12407a;
    }

    public float getWidthPercent() {
        return this.c;
    }

    public int getWidthPx(Context context) {
        return UiUtils.dpToPx(context, getWidth());
    }
}
