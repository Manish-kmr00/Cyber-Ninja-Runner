package com.smaato.sdk.video.vast.model;

import com.json.b9;
import com.smaato.sdk.core.util.Objects;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.pubnative.lite.sdk.vpaid.enums.EventConstants;

/* JADX INFO: loaded from: classes9.dex */
public enum VastEvent {
    CREATIVE_VIEW(EventConstants.CREATIVE_VIEW, true),
    START("start", true),
    FIRST_QUARTILE(EventConstants.FIRST_QUARTILE, true),
    MID_POINT("midpoint", true),
    THIRD_QUARTILE(EventConstants.THIRD_QUARTILE, true),
    COMPLETE("complete", true),
    OTHER_AD_INTERACTION(EventConstants.OTHER_AD_INTERACTION, false),
    PROGRESS("progress", false),
    CREATIVE_VIEW_COMPANION("creativeViewCompanion", true),
    PAUSE("pause", false),
    RESUME("resume", false),
    REWIND(EventConstants.REWIND, false),
    SKIP(EventConstants.SKIP, false),
    MUTE("mute", false),
    UNMUTE("unmute", false),
    PLAYER_EXPAND(EventConstants.PLAYER_EXPAND, false),
    PLAYER_COLLAPSE(EventConstants.PLAYER_COLLAPSE, false),
    LOADED(b9.h.r, true),
    CLOSE_LINEAR(EventConstants.CLOSE_LINEAR, true),
    CLOSE("close", true);

    public static final Set<VastEvent> EVENTS_WITH_OFFSET = getEvent();
    public final String key;
    public final boolean oneTime;

    private static Set getEvent() {
        HashSet hashSet = new HashSet();
        hashSet.add(PROGRESS);
        hashSet.add(START);
        hashSet.add(FIRST_QUARTILE);
        hashSet.add(MID_POINT);
        hashSet.add(THIRD_QUARTILE);
        return Collections.unmodifiableSet(hashSet);
    }

    VastEvent(String str, boolean z) {
        this.key = (String) Objects.requireNonNull(str);
        this.oneTime = z;
    }

    public static VastEvent parse(String str) {
        for (VastEvent vastEvent : values()) {
            if (vastEvent.key.equalsIgnoreCase(str)) {
                return vastEvent;
            }
        }
        return null;
    }
}
