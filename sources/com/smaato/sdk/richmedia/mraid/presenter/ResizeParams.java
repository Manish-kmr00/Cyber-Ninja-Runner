package com.smaato.sdk.richmedia.mraid.presenter;

import android.graphics.Rect;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public final class ResizeParams {
    public final Rect maxSizeRectInPx;
    public final Rect resizeRectInPx;

    ResizeParams(Rect rect, Rect rect2) {
        this.maxSizeRectInPx = (Rect) Objects.requireNonNull(rect);
        this.resizeRectInPx = (Rect) Objects.requireNonNull(rect2);
    }
}
