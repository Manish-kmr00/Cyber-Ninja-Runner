package com.pubmatic.sdk.openwrap.core;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBBidsProvider;
import com.pubmatic.sdk.common.log.POBLogConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes14.dex */
public abstract class POBBaseEvent {
    public abstract void destroy();

    public abstract void requestAd(POBBid pOBBid);

    protected POBError prepareErrorFromResponse(POBBidsProvider pOBBidsProvider) {
        return new POBError(1002, (pOBBidsProvider == null || pOBBidsProvider.getNbrCode() == null) ? "No ads available" : String.format(Locale.getDefault(), POBLogConstants.MSG_NBR_ERROR_MESSAGE, pOBBidsProvider.getNbrCode()));
    }
}
