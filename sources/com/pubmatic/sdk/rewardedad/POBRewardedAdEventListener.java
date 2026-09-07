package com.pubmatic.sdk.rewardedad;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.openwrap.core.POBAdEventListener;
import com.pubmatic.sdk.openwrap.core.POBReward;

/* JADX INFO: loaded from: classes11.dex */
public interface POBRewardedAdEventListener extends POBAdEventListener {
    void onAdExpired();

    void onAdServerWin();

    void onFailedToLoad(POBError pOBError);

    void onFailedToShow(POBError pOBError);

    void onOpenWrapPartnerWin(String str);

    void onReceiveReward(POBReward pOBReward);
}
