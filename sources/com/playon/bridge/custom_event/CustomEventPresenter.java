package com.playon.bridge.custom_event;

import com.json.mediationsdk.utils.IronSourceConstants;
import com.playon.bridge.AdUnit;
import kotlin.Metadata;

/* JADX INFO: compiled from: CustomEventPresenter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH&JI\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\rH&¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/playon/bridge/custom_event/CustomEventPresenter;", "", "sendRewardEvent", "", "eventId", "Lcom/playon/bridge/custom_event/RewardEventId;", "rewardType", "Lcom/playon/bridge/AdUnit$RewardType;", IronSourceConstants.EVENTS_REWARD_AMOUNT, "", "payload", "", "timeToReward", "", "callbackUrl", "maxVolume", "currentVolume", "sendTrackingEvent", "eventCode", "url", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "playon_debug"}, k = 1, mv = {1, 1, 13})
public interface CustomEventPresenter {
    void sendRewardEvent(RewardEventId eventId, AdUnit.RewardType rewardType, float rewardAmount, String payload, int timeToReward, String callbackUrl, int maxVolume, int currentVolume);

    void sendTrackingEvent(String eventId, String payload, int eventCode, String url, Integer maxVolume, Integer currentVolume);

    /* JADX INFO: compiled from: CustomEventPresenter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public static final class DefaultImpls {
        public static /* synthetic */ void sendTrackingEvent$default(CustomEventPresenter customEventPresenter, String str, String str2, int i, String str3, Integer num, Integer num2, int i2, Object obj) {
            Integer num3;
            Integer num4;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendTrackingEvent");
            }
            if ((i2 & 16) != 0) {
                num3 = null;
            } else {
                num3 = num;
            }
            if ((i2 & 32) != 0) {
                num4 = null;
            } else {
                num4 = num2;
            }
            customEventPresenter.sendTrackingEvent(str, str2, i, str3, num3, num4);
        }
    }
}
