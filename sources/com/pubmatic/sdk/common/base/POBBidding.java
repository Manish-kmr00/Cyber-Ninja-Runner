package com.pubmatic.sdk.common.base;

import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.models.POBAdResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface POBBidding<T extends POBAdDescriptor> {
    void destroy();

    POBAdResponse<T> getAdResponse();

    Map<String, POBBidderResult<T>> getBidderResults();

    String getIdentifier();

    void requestBid();

    void setBidderListener(POBBidderListener<T> pOBBidderListener);
}
