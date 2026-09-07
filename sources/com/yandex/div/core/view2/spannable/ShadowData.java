package com.yandex.div.core.view2.spannable;

import kotlin.Metadata;

/* JADX INFO: compiled from: ShadowData.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/yandex/div/core/view2/spannable/ShadowData;", "", "offsetX", "", "offsetY", "radius", "color", "", "(FFFI)V", "getColor", "()I", "getOffsetX", "()F", "getOffsetY", "getRadius", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class ShadowData {
    private final int color;
    private final float offsetX;
    private final float offsetY;
    private final float radius;

    public static /* synthetic */ ShadowData copy$default(ShadowData shadowData, float f, float f2, float f3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = shadowData.offsetX;
        }
        if ((i2 & 2) != 0) {
            f2 = shadowData.offsetY;
        }
        if ((i2 & 4) != 0) {
            f3 = shadowData.radius;
        }
        if ((i2 & 8) != 0) {
            i = shadowData.color;
        }
        return shadowData.copy(f, f2, f3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getOffsetX() {
        return this.offsetX;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getOffsetY() {
        return this.offsetY;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getRadius() {
        return this.radius;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final ShadowData copy(float offsetX, float offsetY, float radius, int color) {
        return new ShadowData(offsetX, offsetY, radius, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShadowData)) {
            return false;
        }
        ShadowData shadowData = (ShadowData) other;
        return Float.compare(this.offsetX, shadowData.offsetX) == 0 && Float.compare(this.offsetY, shadowData.offsetY) == 0 && Float.compare(this.radius, shadowData.radius) == 0 && this.color == shadowData.color;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.offsetX) * 31) + Float.hashCode(this.offsetY)) * 31) + Float.hashCode(this.radius)) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        return "ShadowData(offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", radius=" + this.radius + ", color=" + this.color + ')';
    }

    public ShadowData(float f, float f2, float f3, int i) {
        this.offsetX = f;
        this.offsetY = f2;
        this.radius = f3;
        this.color = i;
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final int getColor() {
        return this.color;
    }
}
