package net.pubnative.lite.sdk;

import android.text.TextUtils;
import java.util.Locale;
import net.pubnative.lite.sdk.models.IntegrationType;

/* JADX INFO: loaded from: classes4.dex */
public class DisplayManager {
    private static final String DISPLAY_MANAGER_ENGINE = "sdkandroid";
    private static final String DISPLAY_MANAGER_NAME = "HyBid";

    public String getDisplayManagerVersion() {
        return getDisplayManagerVersion(IntegrationType.IN_APP_BIDDING);
    }

    public String getDisplayManagerVersion(IntegrationType integrationType) {
        return getDisplayManagerVersion(null, integrationType);
    }

    public String getDisplayManagerVersion(String str, IntegrationType integrationType) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = String.format(Locale.ENGLISH, "_%s", str);
        }
        return String.format(Locale.ENGLISH, "%s_%s%s_%s", DISPLAY_MANAGER_ENGINE, integrationType.getCode(), str2, "3.3.0");
    }

    public String getDisplayManager() {
        return DISPLAY_MANAGER_NAME;
    }
}
