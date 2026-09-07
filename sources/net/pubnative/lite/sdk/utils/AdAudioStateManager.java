package net.pubnative.lite.sdk.utils;

import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.models.Ad;
import net.pubnative.lite.sdk.vpaid.enums.AudioState;

/* JADX INFO: loaded from: classes13.dex */
public class AdAudioStateManager {
    public static AudioState getAudioState(Ad ad, boolean z) {
        if (z) {
            if (ad != null && ad.getAudioState() != null && AudioState.fromString(ad.getAudioState()) != null) {
                return AudioState.fromString(ad.getAudioState());
            }
            return HyBid.getVideoAudioStatus();
        }
        return AudioState.MUTED;
    }
}
