package com.pubmatic.sdk.common.ui;

import com.pubmatic.sdk.common.POBDataType;
import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.common.base.POBAdDescriptor;

/* JADX INFO: loaded from: classes12.dex */
public interface POBRewardedAdRendererListener {
    void onAdClicked();

    @Deprecated
    void onAdEventOccurred(POBDataType.POBVideoAdEventType pOBVideoAdEventType);

    void onAdExpired();

    void onAdImpression();

    void onAdInteractionStarted();

    void onAdInteractionStopped();

    void onAdRender(POBAdDescriptor pOBAdDescriptor);

    void onAdRenderingFailed(POBError pOBError);

    void onLeavingApplication();

    void onReceiveReward(POBCoreReward pOBCoreReward);
}
