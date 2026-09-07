package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ep1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l10 f8822a;

    public final Button a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Button button = new Button(context);
        button.setBackground(ContextCompat.getDrawable(context, R.drawable.monetization_ads_video_ic_replay));
        this.f8822a.getClass();
        int iA = l10.a(context, 90.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = 17;
        button.setLayoutParams(layoutParams);
        return button;
    }

    public /* synthetic */ ep1() {
        this(new l10());
    }

    public ep1(l10 dimensionConverter) {
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        this.f8822a = dimensionConverter;
    }
}
