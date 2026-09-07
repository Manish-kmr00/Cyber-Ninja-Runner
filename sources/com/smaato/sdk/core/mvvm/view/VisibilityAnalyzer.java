package com.smaato.sdk.core.mvvm.view;

import android.graphics.Rect;
import android.view.View;
import com.smaato.sdk.core.api.ImpressionCountingType;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public class VisibilityAnalyzer {
    private static final double MIN_VISIBILITY_IMPRESSED = 0.1d;
    private final ImpressionCountingType impressionCountingType;
    private final WeakReference<View> viewReference;

    public VisibilityAnalyzer(View view, ImpressionCountingType impressionCountingType) {
        this.viewReference = new WeakReference<>(view);
        this.impressionCountingType = impressionCountingType;
    }

    public boolean isImpressed() {
        if (this.impressionCountingType.equals(ImpressionCountingType.VIEWABLE)) {
            return getViewVisibilityRatio() > 0.1d && checkVisibilityForImpressionTypeViewable();
        }
        return getViewVisibilityRatio() > 0.1d;
    }

    public boolean is50PercentVisible() {
        return getViewVisibilityRatio() >= 0.5d;
    }

    public boolean is100PercentVisible() {
        return getViewVisibilityRatio() >= 1.0d;
    }

    private double getViewVisibilityRatio() {
        View view = this.viewReference.get();
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0 || !view.isShown()) {
            return 0.0d;
        }
        int visibleArea = getVisibleArea();
        return ((double) visibleArea) / (((double) view.getWidth()) * ((double) view.getHeight()));
    }

    private boolean checkVisibilityForImpressionTypeViewable() {
        View view = this.viewReference.get();
        if (view == null) {
            return false;
        }
        int height = view.getHeight() * view.getWidth();
        if (height < 242500) {
            return ((double) getVisibleArea()) >= ((double) height) * 0.5d;
        }
        return ((double) getVisibleArea()) >= ((double) height) * 0.3d;
    }

    private int getVisibleArea() {
        View view = this.viewReference.get();
        Rect rect = new Rect();
        if (view == null || !view.getGlobalVisibleRect(rect)) {
            return 0;
        }
        return rect.width() * rect.height();
    }
}
