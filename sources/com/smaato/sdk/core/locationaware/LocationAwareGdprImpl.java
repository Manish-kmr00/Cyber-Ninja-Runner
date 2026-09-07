package com.smaato.sdk.core.locationaware;

import com.json.mediationsdk.utils.IronSourceConstants;
import com.smaato.sdk.core.util.Threads;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes10.dex */
public class LocationAwareGdprImpl implements LocationAware {
    static final Set<String> EU;
    private static final Set ONLY_APPLICABLE_FOR;
    static final Map<String, String> TZ_TO_COUNTRY;
    private final ConsentCountryChecker consentCountryChecker;
    private boolean isDetectionEnabled;
    private volatile Boolean isGdprCountry;

    static {
        HashMap map = new HashMap();
        TZ_TO_COUNTRY = map;
        ONLY_APPLICABLE_FOR = new HashSet();
        map.put("Europe/Amsterdam", "NL");
        map.put("Europe/Athens", "CY");
        map.put("Europe/Berlin", "DE");
        map.put("Europe/Bratislava", "SK");
        map.put("Europe/Brussels", "BE");
        map.put("Europe/Bucharest", "RO");
        map.put("Europe/Budapest", "HU");
        map.put("Europe/Copenhagen", "DK");
        map.put("Europe/Dublin", "IE");
        map.put("Europe/Helsinki", "FI");
        map.put("Europe/Lisbon", "PT");
        map.put("Europe/Ljubljana", "SI");
        map.put("Europe/London", "GB");
        map.put("Europe/Luxembourg", "LU");
        map.put("Europe/Madrid", "ES");
        map.put("Europe/Malta", "MT");
        map.put("Europe/Oslo", "NO");
        map.put("Europe/Paris", "FR");
        map.put("Europe/Prague", "CZ");
        map.put("Europe/Riga", "LV");
        map.put("Europe/Rome", "IT");
        map.put("Europe/Sofia", "BG");
        map.put("Europe/Stockholm", "SE");
        map.put("Europe/Tallinn", "EE");
        map.put("Europe/Vaduz", "LI");
        map.put("Europe/Vienna", "AT");
        map.put("Europe/Vilnius", "LT");
        map.put("Europe/Warsaw", "PL");
        map.put("Europe/Zagreb", "HR");
        map.put("Atlantic/Reykjavik", IronSourceConstants.INTERSTITIAL_EVENT_TYPE);
        EU = new HashSet(map.values());
    }

    LocationAwareGdprImpl(ConsentCountryChecker consentCountryChecker, boolean z) {
        this.consentCountryChecker = consentCountryChecker;
        this.isDetectionEnabled = z;
        if (z) {
            checkConsentCountryInBackground();
        }
    }

    @Override // com.smaato.sdk.core.locationaware.LocationAware
    public boolean isApplicable() {
        Set set = ONLY_APPLICABLE_FOR;
        return set.isEmpty() || set.contains(this.consentCountryChecker.getPackageName());
    }

    @Override // com.smaato.sdk.core.locationaware.LocationAware
    public boolean isConsentCountry() {
        return this.isDetectionEnabled && this.isGdprCountry != null && this.isGdprCountry.booleanValue();
    }

    public void checkConsentCountryInBackground() {
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.locationaware.LocationAwareGdprImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.checkConsentCountry();
            }
        });
    }

    public void checkConsentCountry() {
        if (this.isGdprCountry == null) {
            synchronized (this) {
                if (this.isGdprCountry == null) {
                    this.isGdprCountry = Boolean.FALSE;
                    this.isGdprCountry = Boolean.valueOf(this.consentCountryChecker.isConsentCountryBySIM(EU) || this.consentCountryChecker.isConsentCountryByTimeZone(TZ_TO_COUNTRY) || this.consentCountryChecker.isGeoDns("geoclue.smaato.net", "GDPR"));
                }
            }
        }
    }
}
