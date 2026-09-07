package com.yandex.div.core.animation;

import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReverseInterpolator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"reversed", "Landroid/view/animation/Interpolator;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ReverseInterpolatorKt {
    public static final Interpolator reversed(Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(interpolator, "<this>");
        return new ReverseInterpolator(interpolator);
    }
}
