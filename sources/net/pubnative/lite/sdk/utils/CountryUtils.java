package net.pubnative.lite.sdk.utils;

import com.json.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public class CountryUtils {
    private static final Set<String> GDPR_COUNTRIES;

    static {
        HashSet hashSet = new HashSet();
        GDPR_COUNTRIES = hashSet;
        hashSet.addAll(Arrays.asList("BE", "EL", "LT", "PT", "BG", "ES", "LU", "RO", "CZ", "FR", "HU", "SI", "DK", "HR", "MT", "SK", "DE", "IT", "NL", "FI", "EE", "CY", "AT", "SE", "IE", "LV", "PL", "UK", "GB", "CH", "NO", IronSourceConstants.INTERSTITIAL_EVENT_TYPE, "LI"));
    }

    public static boolean isGDPRCountry(String str) {
        return GDPR_COUNTRIES.contains(str.toUpperCase(Locale.ENGLISH));
    }
}
