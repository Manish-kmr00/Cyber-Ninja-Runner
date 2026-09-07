package com.yandex.mobile.ads.impl;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class h91 {
    @JvmStatic
    public static final boolean a(JSONObject jsonNative, String... keys) {
        Intrinsics.checkNotNullParameter(jsonNative, "jsonNative");
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (String str : keys) {
            if (!jsonNative.has(str)) {
                return false;
            }
        }
        return true;
    }
}
