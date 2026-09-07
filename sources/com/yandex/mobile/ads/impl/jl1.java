package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes5.dex */
public final class jl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final db2 f9330a;
    private final gj0 b;

    private static final class a implements gj0.b {
        static final /* synthetic */ KProperty<Object>[] c = {ta.a(a.class, "preview", "getPreview()Landroid/widget/ImageView;", 0), ta.a(a.class, "progressBar", "getProgressBar()Landroid/widget/ProgressBar;", 0)};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final zn1 f9331a;
        private final zn1 b;

        public a(ImageView preview, ProgressBar progressBar) {
            Intrinsics.checkNotNullParameter(preview, "preview");
            Intrinsics.checkNotNullParameter(progressBar, "progressBar");
            this.f9331a = ao1.a(preview);
            this.b = ao1.a(progressBar);
        }

        @Override // com.yandex.mobile.ads.impl.gj0.b
        public final void a(Bitmap bitmap) {
            if (bitmap == null) {
                ProgressBar progressBar = (ProgressBar) this.b.getValue(this, c[1]);
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                    return;
                }
                return;
            }
            zn1 zn1Var = this.f9331a;
            KProperty<?>[] kPropertyArr = c;
            ImageView imageView = (ImageView) zn1Var.getValue(this, kPropertyArr[0]);
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(0);
            } else {
                ProgressBar progressBar2 = (ProgressBar) this.b.getValue(this, kPropertyArr[1]);
                if (progressBar2 != null) {
                    progressBar2.setVisibility(0);
                }
            }
        }
    }

    public jl1(db2 video, gj0 imageForPresentProvider) {
        Intrinsics.checkNotNullParameter(video, "video");
        Intrinsics.checkNotNullParameter(imageForPresentProvider, "imageForPresentProvider");
        this.f9330a = video;
        this.b = imageForPresentProvider;
    }

    public final void a(se2 placeholderView) {
        Intrinsics.checkNotNullParameter(placeholderView, "placeholderView");
        ImageView imageViewA = placeholderView.a();
        ProgressBar progressBarB = placeholderView.b();
        if (imageViewA == null || this.f9330a.a() == null) {
            progressBarB.setVisibility(0);
        } else {
            this.b.a(this.f9330a.a(), new a(imageViewA, progressBarB));
        }
    }
}
