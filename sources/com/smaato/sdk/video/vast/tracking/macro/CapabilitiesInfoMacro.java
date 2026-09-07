package com.smaato.sdk.video.vast.tracking.macro;

import com.smaato.sdk.core.util.collections.Maps;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
final class CapabilitiesInfoMacro {
    private static final Map MACROS = Maps.mapOf(Maps.entryOf("[VASTVERSIONS]", "1,2,3,4,5,6,7,8,11,12"), Maps.entryOf("[APIFRAMEWORKS]", "7"), Maps.entryOf("[EXTENSIONS]", "AdVerifications"), Maps.entryOf("[VERIFICATIONVENDORS]", "moat.com-omid,ias.com-omid"), Maps.entryOf("[OMIDPARTNER]", "SmaatoInc/20.4.1"), Maps.entryOf("[MEDIAMIME]", "video/mp4,video/3gp,video/mp2t,video/webm,video/mkv"), Maps.entryOf("[PLAYERCAPABILITIES]", "skip,mute,mautoplay,fullscreen,icon"), Maps.entryOf("[CLICKTYPE]", "1"));

    CapabilitiesInfoMacro() {
    }

    Map<String, String> toMap() {
        return MACROS;
    }
}
