package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.yandex.div.core.images.LoadReference;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lj0 f9263a;
    private final List<LoadReference> b;

    public static final class a implements lj0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f9264a;

        a(ImageView imageView) {
            this.f9264a = imageView;
        }

        @Override // com.yandex.mobile.ads.impl.qq1.a
        public final void a(ki2 ki2Var) {
        }

        @Override // com.yandex.mobile.ads.impl.lj0.d
        public final void a(lj0.c response, boolean z) {
            Intrinsics.checkNotNullParameter(response, "response");
            Bitmap bitmapB = response.b();
            if (bitmapB != null) {
                this.f9264a.setImageBitmap(bitmapB);
            }
        }
    }

    public ix(cz1 imageLoader, List loadReferencesStorage) {
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(loadReferencesStorage, "loadReferencesStorage");
        this.f9263a = imageLoader;
        this.b = loadReferencesStorage;
    }

    public final void a() {
        Iterator<T> it = this.b.iterator();
        while (it.hasNext()) {
            ((LoadReference) it.next()).cancel();
        }
        this.b.clear();
    }

    public final LoadReference a(String imageUrl, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        final lj0.c cVarA = this.f9263a.a(imageUrl, new a(imageView), 0, 0);
        Intrinsics.checkNotNullExpressionValue(cVarA, "get(...)");
        LoadReference loadReference = new LoadReference() { // from class: com.yandex.mobile.ads.impl.ix$$ExternalSyntheticLambda0
            @Override // com.yandex.div.core.images.LoadReference
            public final void cancel() {
                ix.a(cVarA);
            }
        };
        this.b.add(loadReference);
        return loadReference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(lj0.c imageContainer) {
        Intrinsics.checkNotNullParameter(imageContainer, "$imageContainer");
        imageContainer.a();
    }
}
