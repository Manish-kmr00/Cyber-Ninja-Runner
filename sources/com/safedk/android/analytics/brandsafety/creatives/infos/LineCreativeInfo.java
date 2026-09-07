package com.safedk.android.analytics.brandsafety.creatives.infos;

import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.annotations.AdNetworkIdentifier;

/* JADX INFO: loaded from: classes12.dex */
@AdNetworkIdentifier(packageName = "com.five_corp.ad")
public class LineCreativeInfo extends CreativeInfo {
    private static final long serialVersionUID = 0;

    public LineCreativeInfo() {
    }

    public LineCreativeInfo(BrandSafetyUtils.AdType adType, String id, String creativeId, String clickUrl, String placementId, String sdkVersion) {
        super(adType == null ? BrandSafetyUtils.AdType.INTERSTITIAL : adType, "com.five_corp.ad", id, creativeId, clickUrl, null, null, sdkVersion);
        j(placementId);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo
    public boolean u(String str) {
        return super.u(str);
    }
}
