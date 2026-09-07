package io.bidmachine.iab.mraid;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
public final class MraidResizeProperties {
    public boolean allowOffscreen;
    public ViewPosition customClosePosition;
    public int height;
    public int offsetX;
    public int offsetY;
    public int width;

    public MraidResizeProperties() {
        this(0, 0, 0, 0, ViewPosition.TopRight, true);
    }

    public String toString() {
        return "MRAIDResizeProperties{width=" + this.width + ", height=" + this.height + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", customClosePosition=" + this.customClosePosition + ", allowOffscreen=" + this.allowOffscreen + AbstractJsonLexerKt.END_OBJ;
    }

    public MraidResizeProperties(int width, int height, int offsetX, int offsetY, ViewPosition customClosePosition, boolean allowOffscreen) {
        this.width = width;
        this.height = height;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.customClosePosition = customClosePosition;
        this.allowOffscreen = allowOffscreen;
    }
}
