package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class i31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pj0 f9170a;
    private final o8<?> b;

    public i31(pj0 imageProvider, o8<?> adResponse) {
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        this.f9170a = imageProvider;
        this.b = adResponse;
    }

    public final h31 a(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNull(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setOnClickListener(new a());
        return new h31(imageView, new ck0(imageView, this.f9170a, this.b));
    }

    private static final class a implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ViewParent parent = view != null ? view.getParent() : null;
            ViewParent parent2 = parent != null ? parent.getParent() : null;
            ViewPager2 viewPager2 = parent2 instanceof ViewPager2 ? (ViewPager2) parent2 : null;
            if (viewPager2 != null) {
                viewPager2.callOnClick();
            }
        }
    }
}
