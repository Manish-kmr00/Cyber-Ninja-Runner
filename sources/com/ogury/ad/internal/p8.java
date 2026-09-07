package com.ogury.ad.internal;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p8 {
    public static final String a(SharedPreferences sharedPreferences, String key) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        String string = sharedPreferences.getString(key, "");
        return string == null ? "" : string;
    }
}
