package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.util.collections.Maps;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
final class ErrorInfoMacros {
    ErrorInfoMacros() {
    }

    Map<String, String> toMap(Integer num) {
        return Maps.mapOf(Maps.entryOf("[ERRORCODE]", num == null ? "-2" : String.valueOf(num)));
    }
}
