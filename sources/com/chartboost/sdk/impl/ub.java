package com.chartboost.sdk.impl;

import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a5\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/view/SurfaceView;", "", "videoWidth", "videoHeight", "surfaceWidth", "surfaceHeight", "", "a", "(Landroid/view/SurfaceView;IIII)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class ub {
    public static final void a(SurfaceView surfaceView, int i, int i2, int i3, int i4) {
        if (surfaceView != null) {
            float f = i3;
            float f2 = i;
            float f3 = f / f2;
            float f4 = i4;
            float f5 = i2;
            float f6 = f4 / f5;
            float f7 = f2 / f5;
            ViewGroup.LayoutParams layoutParams = surfaceView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = null;
            FrameLayout.LayoutParams layoutParams3 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams3 != null) {
                if (f3 > f6) {
                    layoutParams3.width = (int) (f4 * f7);
                    layoutParams3.height = i4;
                } else {
                    layoutParams3.width = i3;
                    layoutParams3.height = (int) (f / f7);
                }
                layoutParams3.gravity = 17;
                layoutParams2 = layoutParams3;
            }
            surfaceView.setLayoutParams(layoutParams2);
        }
    }
}
