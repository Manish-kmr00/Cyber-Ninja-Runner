package com.inmobi.media;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.inmobi.media.s0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3547s0 {
    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    public static HashMap a(String creativeTypeString, String customRefData, boolean z, JSONObject jSONObject, byte b) {
        String str;
        Intrinsics.checkNotNullParameter(creativeTypeString, "creativeTypeString");
        Intrinsics.checkNotNullParameter(customRefData, "customRefData");
        HashMap map = new HashMap();
        int iHashCode = creativeTypeString.hashCode();
        if (iHashCode == 93166550) {
            str = "audio";
            if (!creativeTypeString.equals("audio")) {
                str = "unknown";
            }
        } else if (iHashCode == 112202875) {
            str = "video";
            if (!creativeTypeString.equals("video")) {
                str = "unknown";
            }
        } else if (iHashCode != 1425678798) {
            str = "unknown";
        } else {
            str = "nonvideo";
            if (!creativeTypeString.equals("nonvideo")) {
                str = "unknown";
            }
        }
        map.put("creativeType", str);
        map.put("customReferenceData", customRefData);
        map.put("impressionType", Byte.valueOf(b));
        HashMap map2 = new HashMap();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                Intrinsics.checkNotNull(next);
                Intrinsics.checkNotNull(strOptString);
                map2.put(next, strOptString);
            }
        }
        map.put("macros", map2);
        map.put("isolateVerificationScripts", Boolean.valueOf(z));
        return map;
    }
}
