package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.video.utils.DateFormatUtils;
import com.smaato.sdk.video.vast.model.UniversalAdId;
import com.smaato.sdk.video.vast.model.VastScenario;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: loaded from: classes9.dex */
final class AdBreakInfoMacros {
    private final DateFormatUtils dateFormatUtils;
    private final UniversalAdId universalAdId;
    private final VastScenario vastScenario;

    AdBreakInfoMacros(DateFormatUtils dateFormatUtils, VastScenario vastScenario, UniversalAdId universalAdId) {
        this.dateFormatUtils = (DateFormatUtils) Objects.requireNonNull(dateFormatUtils);
        this.vastScenario = vastScenario;
        this.universalAdId = universalAdId;
    }

    Map<String, String> toMap(PlayerState playerState) {
        String playhead = getPlayhead(playerState.offsetMillis);
        return Maps.mapOf(Maps.entryOf("[CONTENTPLAYHEAD]", playhead), Maps.entryOf("[MEDIAPLAYHEAD]", playhead), Maps.entryOf("[BREAKPOSITION]", Protocol.VAST_1_0_WRAPPER), Maps.entryOf("[BLOCKEDADCATEGORIES]", getBlockedAdCategories()), Maps.entryOf("[ADCATEGORIES]", "-1"), Maps.entryOf("[ADCOUNT]", "1"), Maps.entryOf("[TRANSACTIONID]", "-1"), Maps.entryOf("[PLACEMENTTYPE]", "5"), Maps.entryOf("[ADTYPE]", "video"), Maps.entryOf("[UNIVERSALADID]", getUniversalAdId()), Maps.entryOf("[BREAKMAXDURATION]", "60"), Maps.entryOf("[BREAKMINDURATION]", "1"), Maps.entryOf("[BREAKMAXADS]", "1"), Maps.entryOf("[BREAKMINADLENGTH]", "1"), Maps.entryOf("[BREAKMAXADLENGTH]", "60"));
    }

    private String getUniversalAdId() {
        if (this.universalAdId == null) {
            return "-2";
        }
        return this.universalAdId.idRegistry + " " + this.universalAdId.idValue;
    }

    private String getPlayhead(Long l) {
        if (l == null) {
            return "-2";
        }
        return this.dateFormatUtils.offsetFromTimeInterval(l.longValue());
    }

    private String getBlockedAdCategories() {
        VastScenario vastScenario = this.vastScenario;
        if (vastScenario == null) {
            return "-2";
        }
        return Joiner.join(StringUtils.COMMA, vastScenario.blockedAdCategories);
    }
}
