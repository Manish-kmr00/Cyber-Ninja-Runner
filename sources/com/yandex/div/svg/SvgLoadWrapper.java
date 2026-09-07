package com.yandex.div.svg;

import android.widget.ImageView;
import com.yandex.div.core.images.DivImageDownloadCallback;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SvgLoadWrapper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/svg/SvgLoadWrapper;", "Lcom/yandex/div/core/images/DivImageLoader;", "providedImageLoader", "(Lcom/yandex/div/core/images/DivImageLoader;)V", "svgImageLoader", "Lcom/yandex/div/svg/SvgDivImageLoader;", "getProperLoader", UnifiedMediationParams.KEY_IMAGE_URL, "", "isSvg", "", "loadImage", "Lcom/yandex/div/core/images/LoadReference;", "imageView", "Landroid/widget/ImageView;", "callback", "Lcom/yandex/div/core/images/DivImageDownloadCallback;", "loadImageBytes", "div-svg_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SvgLoadWrapper implements DivImageLoader {
    private final DivImageLoader providedImageLoader;
    private final SvgDivImageLoader svgImageLoader;

    public SvgLoadWrapper(DivImageLoader providedImageLoader) {
        Intrinsics.checkNotNullParameter(providedImageLoader, "providedImageLoader");
        this.providedImageLoader = providedImageLoader;
        this.svgImageLoader = !providedImageLoader.hasSvgSupport().booleanValue() ? new SvgDivImageLoader() : null;
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImage(String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoadReference loadReferenceLoadImage = getProperLoader(imageUrl).loadImage(imageUrl, callback);
        Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImage, "getProperLoader(imageUrl…Image(imageUrl, callback)");
        return loadReferenceLoadImage;
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImage(String imageUrl, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        LoadReference loadReferenceLoadImage = getProperLoader(imageUrl).loadImage(imageUrl, imageView);
        Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImage, "getProperLoader(imageUrl…mage(imageUrl, imageView)");
        return loadReferenceLoadImage;
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImageBytes(String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        LoadReference loadReferenceLoadImageBytes = getProperLoader(imageUrl).loadImageBytes(imageUrl, callback);
        Intrinsics.checkNotNullExpressionValue(loadReferenceLoadImageBytes, "getProperLoader(imageUrl…Bytes(imageUrl, callback)");
        return loadReferenceLoadImageBytes;
    }

    private final DivImageLoader getProperLoader(String imageUrl) {
        if (this.svgImageLoader != null && isSvg(imageUrl)) {
            return this.svgImageLoader;
        }
        return this.providedImageLoader;
    }

    private final boolean isSvg(String imageUrl) {
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) imageUrl, '?', 0, false, 6, (Object) null);
        if (iIndexOf$default == -1) {
            iIndexOf$default = imageUrl.length();
        }
        String strSubstring = imageUrl.substring(0, iIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return StringsKt.endsWith$default(strSubstring, ".svg", false, 2, (Object) null);
    }
}
