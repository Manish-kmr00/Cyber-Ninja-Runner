package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBError;

/* JADX INFO: loaded from: classes10.dex */
public interface POBBidEventListener {
    void onBidFailed(POBBidEvent pOBBidEvent, POBError pOBError);

    void onBidReceived(POBBidEvent pOBBidEvent, POBBid pOBBid);
}
