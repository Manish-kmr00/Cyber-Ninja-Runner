package net.pubnative.lite.sdk.utils;

import java.util.Locale;

/* JADX INFO: loaded from: classes12.dex */
public class ProgressTimeFormatter {
    public static String formatSeconds(int i) {
        return String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60));
    }
}
