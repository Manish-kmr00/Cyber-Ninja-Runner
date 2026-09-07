package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.yandex.mobile.ads.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class oa0 {
    private static final int d = Color.parseColor("#66000000");
    private static final int e = Color.parseColor("#00000000");
    private static final int f = Color.parseColor("#7f7f7f");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9798a;
    private final ot b;
    private final pa0 c;

    public oa0(Context context, ot nativeAdAssets, pa0 feedbackAppearanceResolver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Intrinsics.checkNotNullParameter(feedbackAppearanceResolver, "feedbackAppearanceResolver");
        this.f9798a = context;
        this.b = nativeAdAssets;
        this.c = feedbackAppearanceResolver;
    }

    public final void a(ImageView feedbackView, FrameLayout feedbackContainer, int i) {
        Intrinsics.checkNotNullParameter(feedbackView, "feedbackView");
        Intrinsics.checkNotNullParameter(feedbackContainer, "feedbackContainer");
        if (!this.c.a()) {
            int i2 = f;
            Drawable drawable = ContextCompat.getDrawable(this.f9798a, R.drawable.monetization_ads_internal_ic_close_gray);
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
            if (drawable != null) {
                drawable.setColorFilter(porterDuffColorFilter);
            }
            feedbackView.setImageDrawable(drawable);
            feedbackContainer.setPadding(0, 0, 0, 0);
            feedbackContainer.setBackground(null);
            feedbackContainer.setVisibility(0);
            return;
        }
        if (this.b.i() != null) {
            int i3 = f;
            Drawable drawable2 = ContextCompat.getDrawable(this.f9798a, R.drawable.monetization_ads_internal_ic_close_gray);
            PorterDuffColorFilter porterDuffColorFilter2 = new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
            if (drawable2 != null) {
                drawable2.setColorFilter(porterDuffColorFilter2);
            }
            feedbackView.setImageDrawable(drawable2);
            feedbackContainer.setPadding(0, 0, 0, 0);
            feedbackContainer.setBackground(null);
            feedbackContainer.setVisibility(8);
            return;
        }
        if (this.b.h() != null) {
            Drawable drawable3 = ContextCompat.getDrawable(this.f9798a, R.drawable.monetization_ads_internal_ic_close_gray);
            PorterDuffColorFilter porterDuffColorFilter3 = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            if (drawable3 != null) {
                drawable3.setColorFilter(porterDuffColorFilter3);
            }
            feedbackView.setImageDrawable(drawable3);
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{d, e});
            feedbackContainer.setPadding(0, 0, 0, i);
            feedbackContainer.setBackground(gradientDrawable);
            feedbackContainer.setVisibility(0);
        }
    }
}
