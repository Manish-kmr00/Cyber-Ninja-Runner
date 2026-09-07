package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import com.monetization.ads.mediation.nativeads.MediatedNativeAd;
import com.monetization.ads.mediation.nativeads.MediatedNativeAdImage;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class wx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hj0 f10601a;
    private final jy0 b;
    private final b51 c;

    public interface a {
        void a(o8<u61> o8Var);
    }

    public static final class b implements dk0 {
        final /* synthetic */ MediatedNativeAd b;
        final /* synthetic */ zq1 c;
        final /* synthetic */ a d;

        b(MediatedNativeAd mediatedNativeAd, zq1 zq1Var, a aVar) {
            this.b = mediatedNativeAd;
            this.c = zq1Var;
            this.d = aVar;
        }

        @Override // com.yandex.mobile.ads.impl.dk0
        public final void a(String url, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        }

        @Override // com.yandex.mobile.ads.impl.dk0
        public final void a(Map<String, Bitmap> images) {
            Intrinsics.checkNotNullParameter(images, "images");
            wx0.a(wx0.this, this.b, images, this.c, this.d);
        }
    }

    public /* synthetic */ wx0(Context context, hj0 hj0Var, jy0 jy0Var) {
        this(context, hj0Var, jy0Var, new b51(context));
    }

    public static final void a(wx0 wx0Var, MediatedNativeAd mediatedNativeAd, Map map, zq1 zq1Var, a aVar) {
        aVar.a(wx0Var.c.a(mediatedNativeAd, map, zq1Var));
    }

    public wx0(Context context, hj0 imageLoadManager, jy0 mediatedImagesDataExtractor, b51 nativeAdConverter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageLoadManager, "imageLoadManager");
        Intrinsics.checkNotNullParameter(mediatedImagesDataExtractor, "mediatedImagesDataExtractor");
        Intrinsics.checkNotNullParameter(nativeAdConverter, "nativeAdConverter");
        this.f10601a = imageLoadManager;
        this.b = mediatedImagesDataExtractor;
        this.c = nativeAdConverter;
    }

    public final void a(MediatedNativeAd mediatedNativeAd, zq1 responseNativeType, List<MediatedNativeAdImage> mediatedImages, a listener) {
        Intrinsics.checkNotNullParameter(mediatedNativeAd, "mediatedNativeAd");
        Intrinsics.checkNotNullParameter(responseNativeType, "responseNativeType");
        Intrinsics.checkNotNullParameter(mediatedImages, "mediatedImages");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10601a.a(this.b.a(mediatedImages), new b(mediatedNativeAd, responseNativeType, listener));
    }
}
