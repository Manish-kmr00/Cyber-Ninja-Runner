package com.yandex.div.core.image;

import android.widget.ImageView;
import com.yandex.div.core.images.DivImageDownloadCallback;
import com.yandex.div.core.images.DivImageLoader;
import com.yandex.div.core.images.LoadReference;
import com.yandex.div.svg.SvgLoadWrapper;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivImageLoaderWrapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/core/image/DivImageLoaderWrapper;", "Lcom/yandex/div/core/images/DivImageLoader;", "providedImageLoader", "(Lcom/yandex/div/core/images/DivImageLoader;)V", "imageLoader", "Lcom/yandex/div/svg/SvgLoadWrapper;", "modifiers", "", "Lcom/yandex/div/core/image/DivImageUrlModifier;", "getModifiedUrl", "", "initialUrl", "loadImage", "Lcom/yandex/div/core/images/LoadReference;", UnifiedMediationParams.KEY_IMAGE_URL, "imageView", "Landroid/widget/ImageView;", "callback", "Lcom/yandex/div/core/images/DivImageDownloadCallback;", "loadImageBytes", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivImageLoaderWrapper implements DivImageLoader {
    private final SvgLoadWrapper imageLoader;
    private final List<DivImageUrlModifier> modifiers;

    public DivImageLoaderWrapper(DivImageLoader providedImageLoader) {
        Intrinsics.checkNotNullParameter(providedImageLoader, "providedImageLoader");
        this.imageLoader = new SvgLoadWrapper(providedImageLoader);
        this.modifiers = CollectionsKt.listOf(new DivImageAssetUrlModifier());
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImage(String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.imageLoader.loadImage(getModifiedUrl(imageUrl), callback);
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImage(String imageUrl, ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        return this.imageLoader.loadImage(getModifiedUrl(imageUrl), imageView);
    }

    @Override // com.yandex.div.core.images.DivImageLoader
    public LoadReference loadImageBytes(String imageUrl, DivImageDownloadCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return this.imageLoader.loadImageBytes(getModifiedUrl(imageUrl), callback);
    }

    private final String getModifiedUrl(String initialUrl) {
        Iterator<T> it = this.modifiers.iterator();
        while (it.hasNext()) {
            initialUrl = ((DivImageUrlModifier) it.next()).modifyImageUrl(initialUrl);
        }
        return initialUrl;
    }
}
