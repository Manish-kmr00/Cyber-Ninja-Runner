package com.safedk.android.analytics.brandsafety.creatives.infos;

import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
@AdNetworkIdentifier(packageName = h.D)
public class MobileFuseCreativeInfo extends CreativeInfo {
    private static final long serialVersionUID = 0;

    public MobileFuseCreativeInfo() {
    }

    public MobileFuseCreativeInfo(BrandSafetyUtils.AdType adType, String sdk, String id, String creativeId, String sdkVersion, String placementId, String eventId) {
        super(adType, sdk, id, creativeId, null, null, null, sdkVersion);
        this.K = placementId;
        h(eventId);
    }
}
