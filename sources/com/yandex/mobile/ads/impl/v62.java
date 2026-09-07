package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
public final class v62 implements cn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gj0 f10451a;
    private final ig<?> b;
    private final mg c;

    private static final class a implements gj0.b {
        static final /* synthetic */ KProperty<Object>[] c = {ta.a(a.class, "trademarkView", "getTrademarkView()Landroid/widget/ImageView;", 0), ta.a(a.class, "delimiterView", "getDelimiterView()Landroid/widget/TextView;", 0)};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zn1 f10452a;
        private final zn1 b;

        public a(ImageView trademarkView, TextView textView) {
            Intrinsics.checkNotNullParameter(trademarkView, "trademarkView");
            this.f10452a = ao1.a(trademarkView);
            this.b = ao1.a(textView);
        }

        @Override // com.yandex.mobile.ads.impl.gj0.b
        public final void a(Bitmap bitmap) {
            if (bitmap != null) {
                zn1 zn1Var = this.f10452a;
                KProperty<?>[] kPropertyArr = c;
                ImageView imageView = (ImageView) zn1Var.getValue(this, kPropertyArr[0]);
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                    imageView.setVisibility(0);
                }
                TextView textView = (TextView) this.b.getValue(this, kPropertyArr[1]);
                if (textView == null) {
                    return;
                }
                textView.setVisibility(0);
            }
        }
    }

    public v62(gj0 imageProvider, ig<?> igVar, mg assetClickConfigurator) {
        Intrinsics.checkNotNullParameter(imageProvider, "imageProvider");
        Intrinsics.checkNotNullParameter(assetClickConfigurator, "assetClickConfigurator");
        this.f10451a = imageProvider;
        this.b = igVar;
        this.c = assetClickConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.cn0
    public final void a(gb2 uiElements) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        ImageView imageViewP = uiElements.p();
        TextView textViewO = uiElements.o();
        if (imageViewP != null) {
            ig<?> igVar = this.b;
            Object objD = igVar != null ? igVar.d() : null;
            uj0 uj0Var = objD instanceof uj0 ? (uj0) objD : null;
            if (uj0Var != null) {
                this.f10451a.a(uj0Var, new a(imageViewP, textViewO));
            }
            this.c.a(imageViewP, this.b);
        }
    }
}
