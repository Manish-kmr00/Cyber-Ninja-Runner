package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.yandex.div.core.images.BitmapSource;
import com.yandex.div.core.images.CachedBitmap;
import com.yandex.div.core.images.DivImageDownloadCallback;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class g20 implements DivImageLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cz1 f8958a;
    private final dt0 b;

    public static final class b implements lj0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DivImageDownloadCallback f8960a;
        final /* synthetic */ String b;

        b(String str, DivImageDownloadCallback divImageDownloadCallback) {
            this.f8960a = divImageDownloadCallback;
            this.b = str;
        }

        @Override // com.yandex.mobile.ads.impl.qq1.a
        public final void a(ki2 ki2Var) {
            this.f8960a.onError();
        }

        @Override // com.yandex.mobile.ads.impl.lj0.d
        public final void a(lj0.c cVar, boolean z) {
            Bitmap bitmapB = cVar.b();
            if (bitmapB != null) {
                this.f8960a.onSuccess(new CachedBitmap(bitmapB, Uri.parse(this.b), z ? BitmapSource.MEMORY : BitmapSource.NETWORK));
            }
        }
    }

    public g20(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8958a = ed1.c.a(context).b();
        this.b = new dt0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.yandex.mobile.ads.impl.lj0$c] */
    public static final void a(Ref.ObjectRef imageContainer, g20 this$0, String imageUrl, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageContainer, "$imageContainer");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageUrl, "$imageUrl");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        imageContainer.element = this$0.f8958a.a(imageUrl, new a(imageView), 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(Ref.ObjectRef imageContainer) {
        Intrinsics.checkNotNullParameter(imageContainer, "$imageContainer");
        lj0.c cVar = (lj0.c) imageContainer.element;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public final LoadReference loadImage(final String imageUrl, final ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.g20$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                g20.a(objectRef, this, imageUrl, imageView);
            }
        });
        return new LoadReference() { // from class: com.yandex.mobile.ads.impl.g20$$ExternalSyntheticLambda1
            @Override // com.yandex.div.core.images.LoadReference
            public final void cancel() {
                g20.a(objectRef);
            }
        };
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public final LoadReference loadImageBytes(String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return a(imageUrl, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(Ref.ObjectRef imageContainer) {
        Intrinsics.checkNotNullParameter(imageContainer, "$imageContainer");
        lj0.c cVar = (lj0.c) imageContainer.element;
        if (cVar != null) {
            cVar.a();
        }
    }

    public static final class a implements lj0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f8959a;

        a(ImageView imageView) {
            this.f8959a = imageView;
        }

        @Override // com.yandex.mobile.ads.impl.qq1.a
        public final void a(ki2 ki2Var) {
        }

        @Override // com.yandex.mobile.ads.impl.lj0.d
        public final void a(lj0.c cVar, boolean z) {
            Bitmap bitmapB = cVar.b();
            if (bitmapB != null) {
                this.f8959a.setImageBitmap(bitmapB);
            }
        }
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public final LoadReference loadImage(String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return a(imageUrl, callback);
    }

    private final LoadReference a(final String str, final DivImageDownloadCallback divImageDownloadCallback) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        this.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.g20$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                g20.a(objectRef, this, str, divImageDownloadCallback);
            }
        });
        return new LoadReference() { // from class: com.yandex.mobile.ads.impl.g20$$ExternalSyntheticLambda4
            @Override // com.yandex.div.core.images.LoadReference
            public final void cancel() {
                g20.a(this.f$0, objectRef);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.yandex.mobile.ads.impl.lj0$c] */
    public static final void a(Ref.ObjectRef imageContainer, g20 this$0, String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageContainer, "$imageContainer");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageUrl, "$imageUrl");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        imageContainer.element = this$0.f8958a.a(imageUrl, new b(imageUrl, callback), 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(g20 this$0, final Ref.ObjectRef imageContainer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(imageContainer, "$imageContainer");
        this$0.b.a(new Runnable() { // from class: com.yandex.mobile.ads.impl.g20$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                g20.b(imageContainer);
            }
        });
    }
}
