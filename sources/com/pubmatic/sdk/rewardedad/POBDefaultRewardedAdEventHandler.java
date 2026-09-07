package com.pubmatic.sdk.rewardedad;

import com.pubmatic.sdk.common.OpenWrapSDK;
import com.pubmatic.sdk.openwrap.core.POBBid;
import com.pubmatic.sdk.openwrap.core.POBReward;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class POBDefaultRewardedAdEventHandler extends POBRewardedAdEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBRewardedAdEventListener f7775a;
    private POBBid b;
    private Map c;

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseEvent
    public void destroy() {
        this.b = null;
        this.f7775a = null;
        this.c = null;
    }

    @Override // com.pubmatic.sdk.rewardedad.POBRewardedAdEvent
    public Map<String, String> getAdServerConfig() {
        HashMap map = new HashMap(1);
        map.put(POBRewardedAdEvent.KEY_ALLOW_MULTIPLE_INSTANCES_FOR_ADUNIT_ID, "true");
        return map;
    }

    @Override // com.pubmatic.sdk.rewardedad.POBRewardedAdEvent
    public List<POBReward> getAdServerRewards() {
        POBBid pOBBid = this.b;
        if (pOBBid != null) {
            return pOBBid.getAllRewards();
        }
        return null;
    }

    @Override // com.pubmatic.sdk.rewardedad.POBRewardedAdEvent
    public POBReward getSelectedReward() {
        POBBid pOBBid = this.b;
        POBReward firstReward = pOBBid != null ? pOBBid.getFirstReward() : null;
        Map map = this.c;
        if (map == null) {
            return firstReward;
        }
        Object obj = map.get(OpenWrapSDK.KEY_SELECTED_REWARD);
        List<POBReward> adServerRewards = getAdServerRewards();
        if (adServerRewards == null || obj == null) {
            return firstReward;
        }
        Iterator<POBReward> it = adServerRewards.iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return (POBReward) obj;
            }
        }
        return firstReward;
    }

    @Override // com.pubmatic.sdk.openwrap.core.POBBaseEvent
    public void requestAd(POBBid pOBBid) {
        this.c = null;
        if (this.f7775a != null) {
            if (pOBBid != null && pOBBid.getStatus() == 1) {
                this.b = pOBBid;
                this.f7775a.onOpenWrapPartnerWin(pOBBid.getId());
            } else {
                this.b = null;
                this.f7775a.onFailedToLoad(prepareErrorFromResponse(this.f7775a.getBidsProvider()));
            }
        }
    }

    @Override // com.pubmatic.sdk.rewardedad.POBRewardedAdEvent
    public void setCustomData(Map<String, Object> map) {
        this.c = map;
    }

    @Override // com.pubmatic.sdk.rewardedad.POBRewardedAdEvent
    public void setEventListener(POBRewardedAdEventListener pOBRewardedAdEventListener) {
        this.f7775a = pOBRewardedAdEventListener;
    }
}
