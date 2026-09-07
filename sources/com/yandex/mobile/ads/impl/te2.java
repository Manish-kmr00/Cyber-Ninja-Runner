package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class te2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ll1 f10293a;
    private final hf2 b;

    public final se2 a(Context context, db2 db2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = null;
        if ((db2Var != null ? db2Var.a() : null) != null) {
            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ProgressBar progressBarA = this.f10293a.a(context);
        progressBarA.setVisibility(8);
        se2 se2Var = new se2(context, progressBarA, imageView);
        se2Var.addView(progressBarA);
        if (imageView != null) {
            se2Var.addView(imageView);
        }
        se2Var.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        return se2Var;
    }

    public /* synthetic */ te2() {
        this(new ll1(), new hf2());
    }

    public te2(ll1 progressBarCreator, hf2 videoPreviewCreator) {
        Intrinsics.checkNotNullParameter(progressBarCreator, "progressBarCreator");
        Intrinsics.checkNotNullParameter(videoPreviewCreator, "videoPreviewCreator");
        this.f10293a = progressBarCreator;
        this.b = videoPreviewCreator;
    }
}
