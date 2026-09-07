package com.google.unity.ads.nativead;

import android.graphics.Typeface;
import android.util.Log;
import com.google.unity.ads.PluginUtils;

/* JADX INFO: loaded from: classes9.dex */
public enum UnityNativeTemplateFontStyle {
    NORMAL,
    BOLD,
    ITALIC,
    MONOSPACE;

    public static UnityNativeTemplateFontStyle fromIntValue(int value) {
        if (value >= 0 && value < values().length) {
            return values()[value];
        }
        Log.w(PluginUtils.LOGTAG, "Invalid index for NativeTemplateFontStyle: " + value);
        return NORMAL;
    }

    Typeface getTypeface() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return Typeface.DEFAULT;
        }
        if (iOrdinal == 1) {
            return Typeface.DEFAULT_BOLD;
        }
        if (iOrdinal == 2) {
            return Typeface.defaultFromStyle(2);
        }
        if (iOrdinal == 3) {
            return Typeface.MONOSPACE;
        }
        return Typeface.DEFAULT;
    }
}
