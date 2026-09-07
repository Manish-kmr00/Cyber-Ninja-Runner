package net.pubnative.lite.sdk.utils;

import android.text.TextUtils;
import net.pubnative.lite.sdk.models.Ad;

/* JADX INFO: loaded from: classes9.dex */
public class AdCustomCTAManager {
    public static final Integer CUSTOM_CTA_DELAY_DEFAULT = 2;
    public static final Integer CUSTOM_CTA_DELAY_MAX = 10;

    public static Boolean isAbleShow(Ad ad) {
        return Boolean.valueOf(isEnabled(ad).booleanValue() && hasIcon(ad).booleanValue());
    }

    public static Integer getCustomCtaDelay(Ad ad) {
        return Integer.valueOf(Math.min(((ad.getCustomCTADelay() == null || ad.getCustomCTADelay().intValue() < 0) ? CUSTOM_CTA_DELAY_DEFAULT : ad.getCustomCTADelay()).intValue(), CUSTOM_CTA_DELAY_MAX.intValue()));
    }

    public static CtaType getCustomCtaType(Ad ad) {
        String customCTAType = ad.getCustomCTAType();
        if (customCTAType != null && customCTAType.equals(CtaType.EXTENDED.toString())) {
            return CtaType.EXTENDED;
        }
        return CtaType.DEFAULT;
    }

    private static Boolean isEnabled(Ad ad) {
        return Boolean.valueOf(ad.isCustomCTAEnabled() != null && ad.isCustomCTAEnabled().booleanValue());
    }

    private static Boolean hasIcon(Ad ad) {
        return Boolean.valueOf(ad.hasCustomCTA() && !TextUtils.isEmpty(ad.getAsset("custom_cta").getStringField("icon")) && URLValidator.isValidURL(ad.getAsset("custom_cta").getStringField("icon")));
    }

    public enum CtaType {
        DEFAULT("default"),
        EXTENDED("extended");

        private final String mCtaType;

        CtaType(String str) {
            this.mCtaType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.mCtaType;
        }
    }
}
