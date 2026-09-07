package com.pubmatic.sdk.common.base;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;
import com.pubmatic.sdk.common.models.POBAdResponse;

/* JADX INFO: loaded from: classes6.dex */
public interface POBBidderListener<T extends POBAdDescriptor> {
    void onBidsFailed(POBBidding<T> pOBBidding, POBError pOBError);

    void onBidsFetched(POBBidding<T> pOBBidding, POBAdResponse<T> pOBAdResponse);
}
