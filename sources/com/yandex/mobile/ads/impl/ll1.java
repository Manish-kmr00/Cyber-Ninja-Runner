package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class ll1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l10 f9536a;

    public final ProgressBar a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminateDrawable(ContextCompat.getDrawable(context, R.drawable.monetization_ads_video_progress_bar_background));
        this.f9536a.getClass();
        int iA = l10.a(context, 45.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 17;
        progressBar.setLayoutParams(layoutParams);
        return progressBar;
    }

    public /* synthetic */ ll1() {
        this(new l10());
    }

    public ll1(l10 dimensionConverter) {
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        this.f9536a = dimensionConverter;
    }
}
