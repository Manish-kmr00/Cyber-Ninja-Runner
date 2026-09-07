package com.yandex.div.core.image;

import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DivImageAssetUrlModifier.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/core/image/DivImageAssetUrlModifier;", "Lcom/yandex/div/core/image/DivImageUrlModifier;", "()V", "modifyImageUrl", "", UnifiedMediationParams.KEY_IMAGE_URL, "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DivImageAssetUrlModifier implements DivImageUrlModifier {
    @Override // com.yandex.div.core.image.DivImageUrlModifier
    public String modifyImageUrl(String imageUrl) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        return StringsKt.startsWith$default(imageUrl, "divkit-asset", false, 2, (Object) null) ? "file:///android_asset/divkit/" + StringsKt.removePrefix(imageUrl, (CharSequence) "divkit-asset://") : imageUrl;
    }
}
