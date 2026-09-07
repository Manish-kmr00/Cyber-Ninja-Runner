package net.pubnative.lite.sdk.utils;

import net.pubnative.lite.sdk.models.Ad;

/* JADX INFO: loaded from: classes6.dex */
public class AdEndCardManager {
    private static final Boolean END_CARD_ENABLED = true;
    private static final Boolean CUSTOM_END_CARD_ENABLED = false;

    public static Boolean isEndCardEnabled(Ad ad) {
        if (ad == null) {
            return false;
        }
        boolean zShouldShowEndcard = shouldShowEndcard(ad);
        if (!zShouldShowEndcard) {
            zShouldShowEndcard = shouldShowCustomEndcard(ad);
        }
        return Boolean.valueOf(zShouldShowEndcard);
    }

    public static boolean shouldShowEndcard(Ad ad) {
        if (!ad.hasEndCard()) {
            return false;
        }
        if (hasEndcardRemoteConfig(ad).booleanValue()) {
            return ad.isEndCardEnabled().booleanValue();
        }
        return END_CARD_ENABLED.booleanValue();
    }

    public static boolean shouldShowCustomEndcard(Ad ad) {
        if (!ad.hasCustomEndCard()) {
            return false;
        }
        if (ad.isCustomEndCardEnabled() != null) {
            return ad.isCustomEndCardEnabled().booleanValue();
        }
        return CUSTOM_END_CARD_ENABLED.booleanValue();
    }

    private static Boolean hasEndcardRemoteConfig(Ad ad) {
        return Boolean.valueOf(ad.isEndCardEnabled() != null);
    }

    public static Boolean getDefaultEndCard() {
        return END_CARD_ENABLED;
    }
}
