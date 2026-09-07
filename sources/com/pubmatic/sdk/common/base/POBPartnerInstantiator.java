package com.pubmatic.sdk.common.base;

import com.pubmatic.sdk.common.base.POBAdDescriptor;

/* JADX INFO: loaded from: classes12.dex */
public interface POBPartnerInstantiator<T extends POBAdDescriptor> {
    POBBidding<T> getBidder();
}
