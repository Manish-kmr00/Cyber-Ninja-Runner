package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.util.Joiner;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Size;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.core.util.fi.Supplier;
import com.smaato.sdk.video.utils.DateFormatUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
final class PlayerStateInfoMacros {
    private final String adServingId;
    private final String assetUrl;
    private final DateFormatUtils dateFormatUtils;
    private final ScreenSizeProvider screenSizeProvider;

    interface ScreenSizeProvider extends Supplier<Size> {
    }

    PlayerStateInfoMacros(ScreenSizeProvider screenSizeProvider, DateFormatUtils dateFormatUtils, String str, String str2) {
        this.screenSizeProvider = (ScreenSizeProvider) Objects.requireNonNull(screenSizeProvider);
        this.dateFormatUtils = (DateFormatUtils) Objects.requireNonNull(dateFormatUtils);
        this.assetUrl = str;
        this.adServingId = str2;
    }

    Map<String, String> toMap(PlayerState playerState) {
        Size size = this.screenSizeProvider.get();
        return Maps.mapOf(Maps.entryOf("[PLAYERSTATE]", getPlayerState(playerState.isMuted)), Maps.entryOf("[INVENTORYSTATE]", "skippable,mautoplayed"), Maps.entryOf("[PLAYERSIZE]", Joiner.join(StringUtils.COMMA, Integer.valueOf(size.width), Integer.valueOf(size.height))), Maps.entryOf("[ADPLAYHEAD]", getAdPlayhead(playerState.offsetMillis)), Maps.entryOf("[ASSETURI]", TextUtils.isEmpty(this.assetUrl) ? "-2" : this.assetUrl), Maps.entryOf("[CONTENTID]", "-1"), Maps.entryOf("[CONTENTURI]", "-1"), Maps.entryOf("[PODSEQUENCE]", "-1"), Maps.entryOf("[ADSERVINGID]", TextUtils.isEmpty(this.adServingId) ? "-2" : this.adServingId));
    }

    private String getPlayerState(Boolean bool) {
        if (bool == null) {
            return "-2";
        }
        return bool.booleanValue() ? "fullscreen,muted" : "fullscreen";
    }

    private String getAdPlayhead(Long l) {
        if (l == null) {
            return "-2";
        }
        return this.dateFormatUtils.offsetFromTimeInterval(l.longValue());
    }
}
