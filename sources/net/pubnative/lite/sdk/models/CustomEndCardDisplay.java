package net.pubnative.lite.sdk.models;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.pubmatic.sdk.nativead.POBNativeConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public enum CustomEndCardDisplay {
    EXTENSION(ShareConstants.MEDIA_EXTENSION),
    FALLBACK(POBNativeConstants.NATIVE_FALLBACK_URL);

    public final String display;

    CustomEndCardDisplay(String str) {
        this.display = str;
    }

    public static CustomEndCardDisplay fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return FALLBACK;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        CustomEndCardDisplay customEndCardDisplay = EXTENSION;
        if (lowerCase.equals(customEndCardDisplay.display)) {
            return customEndCardDisplay;
        }
        CustomEndCardDisplay customEndCardDisplay2 = FALLBACK;
        lowerCase.equals(customEndCardDisplay2.display);
        return customEndCardDisplay2;
    }
}
