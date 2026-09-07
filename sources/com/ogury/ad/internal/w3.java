package com.ogury.ad.internal;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w3 {
    public static final int a(LinkedHashMap linkedHashMap, String key) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String str = (String) linkedHashMap.get(key);
        if (str != null) {
            return Integer.parseInt(str);
        }
        throw new IllegalStateException(("Key " + key + " not found in map").toString());
    }
}
