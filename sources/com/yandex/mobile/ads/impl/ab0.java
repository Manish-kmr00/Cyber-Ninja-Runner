package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class ab0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8388a;

    public ab0(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8388a = context;
    }

    public final ImageView a(int i, int i2) {
        ImageView imageView = new ImageView(this.f8388a);
        int iA = oh2.a(this.f8388a, 28.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
        layoutParams.gravity = GravityCompat.END;
        layoutParams.rightMargin = i;
        layoutParams.topMargin = i2;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
