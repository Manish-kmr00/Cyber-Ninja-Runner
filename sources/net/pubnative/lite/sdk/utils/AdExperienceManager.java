package net.pubnative.lite.sdk.utils;

import net.pubnative.lite.sdk.models.AdExperience;

/* JADX INFO: loaded from: classes5.dex */
public class AdExperienceManager {
    private static boolean isBrandCompatible(Integer num) {
        return num.intValue() == 15;
    }

    private static boolean isPerformanceCompatible(Integer num) {
        return num.intValue() == 15 || num.intValue() == 21 || num.intValue() == 29 || num.intValue() == 23 || num.intValue() == 22 || num.intValue() == 27;
    }

    public static boolean isBrandAd(Integer num, String str) {
        return isBrandCompatible(num) && str.equalsIgnoreCase(AdExperience.BRAND);
    }

    public static boolean isPerformanceAd(Integer num, String str) {
        return isPerformanceCompatible(num) && str.equalsIgnoreCase(AdExperience.PERFORMANCE);
    }
}
