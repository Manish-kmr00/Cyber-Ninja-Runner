package com.yandex.div.core.util;

import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import androidx.core.graphics.drawable.DrawableKt;
import com.yandex.div.core.images.BitmapSource;
import com.yandex.div.core.images.CachedBitmap;
import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¨\u0006\u0007"}, d2 = {"toCachedBitmap", "Lcom/yandex/div/core/images/CachedBitmap;", "Landroid/graphics/drawable/PictureDrawable;", UnifiedMediationParams.KEY_IMAGE_URL, "Landroid/net/Uri;", "bytes", "", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ImageUtilsKt {
    public static /* synthetic */ CachedBitmap toCachedBitmap$default(PictureDrawable pictureDrawable, Uri uri, byte[] bArr, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr = null;
        }
        return toCachedBitmap(pictureDrawable, uri, bArr);
    }

    public static final CachedBitmap toCachedBitmap(PictureDrawable pictureDrawable, Uri imageUrl, byte[] bArr) {
        Intrinsics.checkNotNullParameter(pictureDrawable, "<this>");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        return new CachedBitmap(DrawableKt.toBitmap$default(pictureDrawable, 0, 0, null, 7, null), bArr, imageUrl, BitmapSource.MEMORY);
    }
}
