package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.collections.Maps;
import com.smaato.sdk.core.util.fi.Function;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
final class ClickInfoMacros {
    private final PxToDpConverter converter;

    interface PxToDpConverter extends Function<Float, Integer> {
    }

    ClickInfoMacros(PxToDpConverter pxToDpConverter) {
        this.converter = (PxToDpConverter) Objects.requireNonNull(pxToDpConverter);
    }

    Map<String, String> toMap(Float f, Float f2) {
        return Maps.mapOf(Maps.entryOf("[CLICKPOS]", getClickPos(f, f2)));
    }

    private String getClickPos(Float f, Float f2) {
        return (f == null || f2 == null || f.floatValue() <= 0.0f || f2.floatValue() <= 0.0f) ? "-2" : this.converter.apply(f) + StringUtils.COMMA + this.converter.apply(f2);
    }
}
