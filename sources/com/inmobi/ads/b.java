package com.inmobi.ads;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import com.inmobi.media.I0;
import com.inmobi.media.J0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b {
    public static final Animation a(InMobiBanner.AnimationType animationType, float f, float f2) {
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        int i = a.f3018a[animationType.ordinal()];
        if (i == 1) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
            alphaAnimation.setDuration(1000L);
            alphaAnimation.setFillAfter(false);
            alphaAnimation.setInterpolator(new DecelerateInterpolator());
            return alphaAnimation;
        }
        if (i == 2) {
            I0 i0 = new I0(f / 2.0f, f2 / 2.0f);
            i0.setDuration(500L);
            i0.setFillAfter(false);
            i0.setInterpolator(new AccelerateInterpolator());
            return i0;
        }
        if (i != 3) {
            return null;
        }
        J0 j0 = new J0(f / 2.0f, f2 / 2.0f);
        j0.setDuration(500L);
        j0.setFillAfter(false);
        j0.setInterpolator(new AccelerateInterpolator());
        return j0;
    }
}
