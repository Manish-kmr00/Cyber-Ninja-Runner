package com.smaato.sdk.richmedia.mraid;

import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public final class MraidUtils {
    public static Float parseOptFloat(String str) {
        try {
            return Float.valueOf(Float.parseFloat(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }
}
