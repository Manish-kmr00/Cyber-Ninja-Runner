package com.smaato.sdk.richmedia.mraid;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes8.dex */
public final class Views {
    public static boolean isViewable(float f) {
        return f > 0.0f;
    }

    public static Rect positionOnScreenOf(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static ViewVisibilityContext visibilityContextRelativeToView(View view) {
        Rect visibleRectRelativeToView = getVisibleRectRelativeToView(view);
        return new ViewVisibilityContext(getVisiblePercent(view, visibleRectRelativeToView.width() * visibleRectRelativeToView.height()), visibleRectRelativeToView);
    }

    private static float getVisiblePercent(View view, float f) {
        if (isViewVisible(view)) {
            return (f / (view.getWidth() * view.getHeight())) * 100.0f;
        }
        return 0.0f;
    }

    private static Rect getVisibleRectRelativeToView(View view) {
        Rect rectPositionOnScreenOf = positionOnScreenOf(view);
        Rect globalVisibleRect = getGlobalVisibleRect(view);
        if (globalVisibleRect.isEmpty()) {
            return new Rect();
        }
        globalVisibleRect.offset(-rectPositionOnScreenOf.left, -rectPositionOnScreenOf.top);
        return globalVisibleRect;
    }

    private static Rect getGlobalVisibleRect(View view) {
        if (!isViewVisible(view)) {
            return new Rect();
        }
        Rect rect = new Rect();
        return !view.getGlobalVisibleRect(rect) ? new Rect() : rect;
    }

    private static boolean isViewVisible(View view) {
        if (view.hasWindowFocus() && view.getWidth() > 0 && view.getHeight() > 0) {
            return view.isShown();
        }
        return false;
    }

    public static void addOnPreDrawListener(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.smaato.sdk.richmedia.mraid.Views.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                runnable.run();
                return true;
            }
        });
    }

    public static final class ViewVisibilityContext {
        public final float visibilityPercent;
        public final Rect visibleRect;

        private ViewVisibilityContext(float f, Rect rect) {
            this.visibilityPercent = f;
            this.visibleRect = rect;
        }
    }
}
