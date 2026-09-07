package com.yandex.mobile.ads.impl;

import android.util.Pair;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class yj2 {
    public static Pair<Long, Long> a(d40 d40Var) {
        long j;
        Map<String, String> mapQueryKeyStatus = d40Var.queryKeyStatus();
        if (mapQueryKeyStatus == null) {
            return null;
        }
        long j2 = -9223372036854775807L;
        try {
            String str = mapQueryKeyStatus.get("LicenseDurationRemaining");
            j = str != null ? Long.parseLong(str) : -9223372036854775807L;
        } catch (NumberFormatException unused) {
        }
        Long lValueOf = Long.valueOf(j);
        try {
            String str2 = mapQueryKeyStatus.get("PlaybackDurationRemaining");
            if (str2 != null) {
                j2 = Long.parseLong(str2);
            }
        } catch (NumberFormatException unused2) {
        }
        return new Pair<>(lValueOf, Long.valueOf(j2));
    }
}
