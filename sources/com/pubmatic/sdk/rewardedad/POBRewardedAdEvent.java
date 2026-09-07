package com.pubmatic.sdk.rewardedad;

import com.pubmatic.sdk.common.ui.POBRewardedAdRendering;
import com.pubmatic.sdk.openwrap.core.POBBaseEvent;
import com.pubmatic.sdk.openwrap.core.POBReward;
import com.pubmatic.sdk.openwrap.core.POBRewardedAdInteractionListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class POBRewardedAdEvent extends POBBaseEvent {
    public static final String KEY_ALLOW_MULTIPLE_INSTANCES_FOR_ADUNIT_ID = "AllowMultipleInstancesForAdUnit";
    public static final String KEY_IDENTIFER = "Identifier";

    public POBRewardedAdInteractionListener getAdInteractionListener() {
        return null;
    }

    public abstract Map<String, String> getAdServerConfig();

    public List<POBReward> getAdServerRewards() {
        return null;
    }

    public POBRewardedAdRendering getRenderer(String str) {
        return null;
    }

    public POBReward getSelectedReward() {
        return null;
    }

    public void setCustomData(Map<String, Object> map) {
    }

    public abstract void setEventListener(POBRewardedAdEventListener pOBRewardedAdEventListener);

    public void show() {
    }
}
