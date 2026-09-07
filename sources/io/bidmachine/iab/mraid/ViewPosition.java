package io.bidmachine.iab.mraid;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public enum ViewPosition {
    TopLeft(51),
    TopCenter(49),
    TopRight(53),
    Center(17),
    BottomLeft(83),
    BottomCenter(81),
    BottomRight(85);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12225a;

    ViewPosition(final int gravity) {
        this.f12225a = gravity;
    }

    public static ViewPosition fromJsString(String jsValue) {
        return fromJsString(jsValue, TopRight);
    }

    public int getGravity() {
        return this.f12225a;
    }

    public static ViewPosition fromJsString(String jsValue, ViewPosition def) {
        if (TextUtils.isEmpty(jsValue)) {
            return def;
        }
        jsValue.hashCode();
        jsValue.hashCode();
        switch (jsValue) {
            case "center":
                return Center;
            case "top-right":
                return TopRight;
            case "top-left":
                return TopLeft;
            case "bottom-left":
                return BottomLeft;
            case "bottom-right":
                return BottomRight;
            case "bottom-center":
                return BottomCenter;
            case "top-center":
                return TopCenter;
            default:
                return def;
        }
    }
}
