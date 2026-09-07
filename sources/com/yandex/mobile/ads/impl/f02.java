package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i02 f8858a = new i02();
    private final ri b = new ri();
    private final al c = new al();
    private h02 d;

    public final void a(ImageView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this.d);
    }

    public final void a(Bitmap originalBitmap, ImageView view, uj0 imageValue) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        Intrinsics.checkNotNullParameter(originalBitmap, "originalBitmap");
        h02 h02Var = new h02(this.b, this.c, this.f8858a, imageValue, originalBitmap);
        this.d = h02Var;
        view.addOnLayoutChangeListener(h02Var);
        if (view.getLayoutParams().width == -1 || view.getLayoutParams().height == -1 || view.getLayoutParams().width == -2 || view.getLayoutParams().height == -2) {
            view.setImageBitmap(originalBitmap);
        }
    }
}
