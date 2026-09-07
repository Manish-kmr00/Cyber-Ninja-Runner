package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class gx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o8<?> f9043a;
    private final tj0 b;

    public final sv1 a(CustomizableMediaView mediaView, pj0 imageProvider, kx0 mediaViewRenderController) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(mediaViewRenderController, "mediaViewRenderController");
        ImageView imageView = new ImageView(mediaView.getContext());
        this.b.getClass();
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Context context = mediaView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (!u80.a(context, t80.e)) {
            mediaView.removeAllViews();
        }
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mediaView.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        ck0 ck0Var = new ck0(imageView, imageProvider, this.f9043a);
        return new sv1(mediaView, ck0Var, mediaViewRenderController, new og2(ck0Var));
    }

    public /* synthetic */ gx0(o8 o8Var) {
        this(o8Var, new tj0());
    }

    public gx0(o8<?> adResponse, tj0 imageSubViewBinder) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(imageSubViewBinder, "imageSubViewBinder");
        this.f9043a = adResponse;
        this.b = imageSubViewBinder;
    }
}
