package com.smaato.sdk.core.locationaware;

import com.smaato.sdk.core.util.Threads;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public class LocationAwareLgpdImpl implements LocationAware {
    static final Set<String> LGPD;
    private static final Set ONLY_APPLICABLE_FOR;
    static final Map<String, String> TZ_TO_COUNTRY;
    private final ConsentCountryChecker consentCountryChecker;
    private boolean isDetectionEnabled;
    private volatile Boolean isLgpdCountry;

    static {
        HashMap map = new HashMap();
        TZ_TO_COUNTRY = map;
        ONLY_APPLICABLE_FOR = new HashSet();
        map.put("America/Araguaina", "BR");
        map.put("America/Bahia", "BR");
        map.put("America/Belem", "BR");
        map.put("America/Boa_Vista", "BR");
        map.put("America/Campo_Grande", "BR");
        map.put("America/Cuiaba", "BR");
        map.put("America/Eirunepe", "BR");
        map.put("America/Fortaleza", "BR");
        map.put("America/Maceio", "BR");
        map.put("America/Manaus", "BR");
        map.put("America/Noronha", "BR");
        map.put("America/Porto_Acre", "BR");
        map.put("America/Porto_Velho", "BR");
        map.put("America/Recife", "BR");
        map.put("America/Rio_Branco", "BR");
        map.put("America/Santarem", "BR");
        map.put("America/Sao_Paulo", "BR");
        map.put("Brazil/Acre", "BR");
        map.put("Brazil/DeNoronha", "BR");
        map.put("Brazil/East", "BR");
        map.put("Brazil/West", "BR");
        LGPD = new HashSet(map.values());
    }

    LocationAwareLgpdImpl(ConsentCountryChecker consentCountryChecker, boolean z) {
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
        return this.isDetectionEnabled && this.isLgpdCountry != null && this.isLgpdCountry.booleanValue();
    }

    public void checkConsentCountryInBackground() {
        Threads.runOnBackgroundThread(new Runnable() { // from class: com.smaato.sdk.core.locationaware.LocationAwareLgpdImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.checkConsentCountry();
            }
        });
    }

    public void checkConsentCountry() {
        if (this.isLgpdCountry == null) {
            synchronized (this) {
                if (this.isLgpdCountry == null) {
                    this.isLgpdCountry = Boolean.FALSE;
                    this.isLgpdCountry = Boolean.valueOf(this.consentCountryChecker.isConsentCountryBySIM(LGPD) || this.consentCountryChecker.isConsentCountryByTimeZone(TZ_TO_COUNTRY) || this.consentCountryChecker.isGeoDns("geoclue.smaato.net", "LGPD"));
                }
            }
        }
    }
}
