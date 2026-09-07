package com.yandex.mobile.ads.impl;

import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h31 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final og2<ImageView, uj0> f9058a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h31(ImageView imageView, ck0 imageViewAdapter) {
        super(imageView);
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(imageViewAdapter, "imageViewAdapter");
        this.f9058a = new og2<>(imageViewAdapter);
    }

    public final void a(uj0 value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f9058a.b(value);
    }
}
