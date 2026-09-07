package net.pubnative.lite.sdk.vpaid.enums;

import java.util.Locale;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes13.dex */
public enum AudioState {
    MUTED("muted"),
    ON(DebugKt.DEBUG_PROPERTY_VALUE_ON),
    DEFAULT("default");

    final String stateName;

    AudioState(String str) {
        this.stateName = str;
    }

    public String getStateName() {
        return this.stateName;
    }

    public static AudioState fromString(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        AudioState audioState = MUTED;
        if (lowerCase.equals(audioState.stateName)) {
            return audioState;
        }
        AudioState audioState2 = ON;
        if (lowerCase.equals(audioState2.stateName)) {
            return audioState2;
        }
        AudioState audioState3 = DEFAULT;
        if (lowerCase.equals(audioState3.stateName)) {
            return audioState3;
        }
        return null;
    }
}
