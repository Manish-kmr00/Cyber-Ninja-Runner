package com.playon.bridge.custom_event;

import com.google.gson.Gson;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.playon.bridge.Ad;
import com.playon.bridge.AdUnit;
import com.playon.bridge.common.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: CustomEventPresenterImp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002JL\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016JE\u0010\u0017\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/playon/bridge/custom_event/CustomEventPresenterImp;", "Lcom/playon/bridge/custom_event/CustomEventPresenter;", "()V", "getJsonObject", "Lorg/json/JSONObject;", "customEventRequest", "Lcom/playon/bridge/custom_event/CustomEventRequest;", "sendEvent", "", "sendRewardEvent", "eventId", "Lcom/playon/bridge/custom_event/RewardEventId;", "rewardType", "Lcom/playon/bridge/AdUnit$RewardType;", IronSourceConstants.EVENTS_REWARD_AMOUNT, "", "payload", "", "timeToReward", "", "callbackUrl", "maxVolume", "currentVolume", "sendTrackingEvent", "eventCode", "url", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "playon_debug"}, k = 1, mv = {1, 1, 13})
public final class CustomEventPresenterImp implements CustomEventPresenter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG;

    @Override // com.playon.bridge.custom_event.CustomEventPresenter
    public void sendTrackingEvent(String eventId, String payload, int eventCode, String url, Integer maxVolume, Integer currentVolume) {
        Intrinsics.checkParameterIsNotNull(eventId, "eventId");
        sendEvent(new CustomEventRequest(url, eventId, payload, null, Integer.valueOf(eventCode), null, null, null, maxVolume, currentVolume, 232, null));
    }

    @Override // com.playon.bridge.custom_event.CustomEventPresenter
    public void sendRewardEvent(RewardEventId eventId, AdUnit.RewardType rewardType, float rewardAmount, String payload, int timeToReward, String callbackUrl, int maxVolume, int currentVolume) {
        Intrinsics.checkParameterIsNotNull(eventId, "eventId");
        Intrinsics.checkParameterIsNotNull(rewardType, "rewardType");
        sendEvent(new CustomEventRequest(null, eventId.getValue(), payload, Integer.valueOf(timeToReward), null, rewardType, Float.valueOf(rewardAmount), callbackUrl, Integer.valueOf(maxVolume), Integer.valueOf(currentVolume), 17, null));
    }

    private final void sendEvent(CustomEventRequest customEventRequest) {
        try {
            Ad.postCustomEvent(customEventRequest.getUrl(), getJsonObject(customEventRequest));
        } catch (Exception e) {
            Log.w(TAG, "Post exception: " + e.getMessage());
        }
    }

    public final JSONObject getJsonObject(CustomEventRequest customEventRequest) {
        Intrinsics.checkParameterIsNotNull(customEventRequest, "customEventRequest");
        return new JSONObject(new Gson().toJson(customEventRequest));
    }

    /* JADX INFO: compiled from: CustomEventPresenterImp.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/playon/bridge/custom_event/CustomEventPresenterImp$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "playon_debug"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return CustomEventPresenterImp.TAG;
        }
    }

    static {
        String strMakeTag = Log.makeTag("CustomEventPresenterImp");
        Intrinsics.checkExpressionValueIsNotNull(strMakeTag, "Log.makeTag(\"CustomEventPresenterImp\")");
        TAG = strMakeTag;
    }
}
