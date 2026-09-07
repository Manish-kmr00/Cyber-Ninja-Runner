package com.yandex.div.svg;

import android.graphics.drawable.PictureDrawable;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.pubnative.lite.sdk.analytics.Reporting;

/* JADX INFO: compiled from: SvgCacheManager.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yandex/div/svg/SvgCacheManager;", "", "()V", Reporting.EventType.CACHE, "Ljava/util/WeakHashMap;", "", "Landroid/graphics/drawable/PictureDrawable;", "get", UnifiedMediationParams.KEY_IMAGE_URL, "set", "", "pictureDrawable", "div-svg_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SvgCacheManager {
    private final WeakHashMap<String, PictureDrawable> cache = new WeakHashMap<>();

    public final PictureDrawable get(String imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        return this.cache.get(imageUrl);
    }

    public final void set(String imageUrl, PictureDrawable pictureDrawable) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(pictureDrawable, "pictureDrawable");
        this.cache.put(imageUrl, pictureDrawable);
    }
}
