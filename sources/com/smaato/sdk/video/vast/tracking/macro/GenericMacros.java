package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.video.utils.DateFormatUtils;
import com.smaato.sdk.video.utils.RandomUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class GenericMacros {
    private final DateFormatUtils dateFormatUtils;
    private final RandomUtils randomUtils;

    GenericMacros(DateFormatUtils dateFormatUtils, RandomUtils randomUtils) {
        this.dateFormatUtils = (DateFormatUtils) Objects.requireNonNull(dateFormatUtils);
        this.randomUtils = (RandomUtils) Objects.requireNonNull(randomUtils);
    }

    Map<String, String> toMap() {
        return Maps.mapOf(Maps.entryOf("[TIMESTAMP]", this.dateFormatUtils.currentTimestamp()), Maps.entryOf("[CACHEBUSTING]", this.randomUtils.random8DigitNumber()));
    }
}
