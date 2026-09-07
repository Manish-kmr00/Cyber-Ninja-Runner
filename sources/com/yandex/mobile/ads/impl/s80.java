package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
public final class s80 implements cn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gj0 f10183a;
    private final ig<?> b;
    private final mg c;

    private static final class a implements gj0.b {
        static final /* synthetic */ KProperty<Object>[] b = {ta.a(a.class, "faviconView", "getFaviconView()Landroid/widget/ImageView;", 0)};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zn1 f10184a;

        public a(ImageView faviconView) {
            Intrinsics.checkNotNullParameter(faviconView, "faviconView");
            this.f10184a = ao1.a(faviconView);
        }

        @Override // com.yandex.mobile.ads.impl.gj0.b
        public final void a(Bitmap bitmap) {
            Unit unit;
            ImageView imageView;
            ImageView imageView2;
            if (bitmap == null || (imageView2 = (ImageView) this.f10184a.getValue(this, b[0])) == null) {
                unit = null;
            } else {
                imageView2.setImageBitmap(bitmap);
                imageView2.setVisibility(0);
                unit = Unit.INSTANCE;
            }
            if (unit != null || (imageView = (ImageView) this.f10184a.getValue(this, b[0])) == null) {
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public s80(gj0 imageProvider, ig<?> igVar, mg clickConfigurator) {
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(clickConfigurator, "clickConfigurator");
        this.f10183a = imageProvider;
        this.b = igVar;
        this.c = clickConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        ImageView imageViewG = uiElements.g();
        if (imageViewG != null) {
            ig<?> igVar = this.b;
            Unit unit = null;
            Object objD = igVar != null ? igVar.d() : null;
            if ((objD instanceof uj0 ? (uj0) objD : null) != null) {
                this.f10183a.a((uj0) objD, new a(imageViewG));
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                imageViewG.setVisibility(8);
            }
            this.c.a(imageViewG, this.b);
        }
    }
}
