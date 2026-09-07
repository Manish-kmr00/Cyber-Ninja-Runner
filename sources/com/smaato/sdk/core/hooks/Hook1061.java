package com.smaato.sdk.core.hooks;

import com.smaato.sdk.core.util.collections.Maps;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public abstract class Hook1061 {
    private static final Map MAPPING = Maps.mapOf(Maps.entryOf("130626424", "1100042525"), Maps.entryOf("130635694", "1100042525"), Maps.entryOf("130635706", "1100042525"), Maps.entryOf("130626426", "1100042525"), Maps.entryOf("130626427", "1100042525"), Maps.entryOf("130626428", "1100042525"), Maps.entryOf("130635048", "1100042525"), Maps.entryOf("130563103", "1100042525"), Maps.entryOf("130560861", "1100042525"), Maps.entryOf("130619168", "1100042525"), Maps.entryOf("130620582", "1100042525"), Maps.entryOf("130684311", "1100042525"), Maps.entryOf("130684312", "1100042525"), Maps.entryOf("130684313", "1100042525"), Maps.entryOf("130684314", "1100042525"), Maps.entryOf("130710114", "1100042525"), Maps.entryOf("130710115", "1100042525"), Maps.entryOf("130710116", "1100042525"), Maps.entryOf("130820645", "1100042525"), Maps.entryOf("130783664", "1100042525"), Maps.entryOf("131993634", "1100043571"), Maps.entryOf("0", "0"), Maps.entryOf("3090", "0"), Maps.entryOf("130512792", "0"), Maps.entryOf("130699906", "1100044195"), Maps.entryOf("130702154", "1100044195"), Maps.entryOf("130702184", "1100044195"), Maps.entryOf("130702490", "1100044195"), Maps.entryOf("130702855", "1100044195"), Maps.entryOf("130706712", "1100044195"), Maps.entryOf("130706713", "1100044195"), Maps.entryOf("130706714", "1100044195"), Maps.entryOf("130706715", "1100044195"), Maps.entryOf("130706716", "1100044195"), Maps.entryOf("130706717", "1100044195"));

    public static String onGetPublisherId(String str, String str2) {
        String str3;
        return (str2 == null || (str3 = (String) MAPPING.get(str2)) == null) ? str : str3;
    }
}
