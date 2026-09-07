package com.monetization.ads.mediation.nativeads.assets;

import com.monetization.ads.mediation.nativeads.MediatedNativeAdImage;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/monetization/ads/mediation/nativeads/assets/MediatedAssetFactory;", "", "makeFeedback", "Lcom/monetization/ads/mediation/nativeads/MediatedNativeAdImage;", "resourceId", "", "makeSponsored", "", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface MediatedAssetFactory {
    MediatedNativeAdImage makeFeedback(int resourceId);

    String makeSponsored(int resourceId);
}
