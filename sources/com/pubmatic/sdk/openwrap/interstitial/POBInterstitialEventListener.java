package com.pubmatic.sdk.openwrap.interstitial;

import com.pubmatic.sdk.common.POBError;
import com.pubmatic.sdk.openwrap.core.POBAdEventListener;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface POBInterstitialEventListener extends POBAdEventListener {
    Map<String, Object> getCustomData();

    void onAdExpired();

    void onAdServerWin();

    void onFailedToLoad(POBError pOBError);

    void onFailedToShow(POBError pOBError);

    void onOpenWrapPartnerWin(String str);
}
