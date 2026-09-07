package com.pubmatic.sdk.openwrap.core;

import android.app.Application;
import android.content.Context;
import com.pubmatic.sdk.common.POBAdFormat;
import com.pubmatic.sdk.common.POBInstanceProvider;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.models.POBAdResponse;
import com.pubmatic.sdk.common.utility.POBUtils;

/* JADX INFO: loaded from: classes13.dex */
public class POBAdsHelper {
    public static POBImpression getImpression(POBRequest pOBRequest) {
        POBImpression[] impressions;
        if (pOBRequest == null || (impressions = pOBRequest.getImpressions()) == null || impressions.length == 0) {
            return null;
        }
        return impressions[0];
    }

    public static void recordImpressionDepth(Context context, POBAdFormat pOBAdFormat) {
        POBInstanceProvider.getImpDepthHandler(POBInstanceProvider.getApplicationSessionHandler((Application) context.getApplicationContext())).recordImpression(pOBAdFormat);
    }

    public static <T extends POBAdDescriptor> POBAdResponse<T> updateResponseUsingPlacementType(POBAdResponse<T> pOBAdResponse, String str) {
        return pOBAdResponse.getWinningBid() != null ? new POBAdResponse.Builder(pOBAdResponse).updateWithRefreshIntervalAndExpiryTimeout(str).build() : pOBAdResponse;
    }

    public static boolean validate(Context context, String str, String str2, Object obj) {
        return (context == null || obj == null || POBUtils.isNullOrEmpty(str) || POBUtils.isNullOrEmpty(str2)) ? false : true;
    }
}
