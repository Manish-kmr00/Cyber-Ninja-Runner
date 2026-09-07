package com.smaato.sdk.core.ad;

import com.smaato.sdk.core.AdContentRating;
import com.smaato.sdk.core.LatLng;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.datacollector.LocationProvider;
import com.smaato.sdk.core.datacollector.SystemInfo;
import com.smaato.sdk.core.gdpr.PiiParam;
import com.smaato.sdk.core.gdpr.SomaGdprData;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.lgpd.SomaLgpdData;
import com.smaato.sdk.core.lgpd.SomaLgpdDataSource;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.TextUtils;
import com.smaato.sdk.core.util.collections.Lists;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public final class RequestInfoProvider {
    private final DataCollector dataCollector;
    private final SdkConfiguration sdkConfiguration;
    private final SomaGdprDataSource somaGdprDataSource;
    private final SomaLgpdDataSource somaLgpdDataSource;
    private final SystemInfo systemInfo;

    public RequestInfoProvider(DataCollector dataCollector, SomaGdprDataSource somaGdprDataSource, SomaLgpdDataSource somaLgpdDataSource, SdkConfiguration sdkConfiguration, SystemInfo systemInfo) {
        this.dataCollector = (DataCollector) Objects.requireNonNull(dataCollector);
        this.somaGdprDataSource = (SomaGdprDataSource) Objects.requireNonNull(somaGdprDataSource);
        this.somaLgpdDataSource = (SomaLgpdDataSource) Objects.requireNonNull(somaLgpdDataSource);
        this.sdkConfiguration = (SdkConfiguration) Objects.requireNonNull(sdkConfiguration);
        this.systemInfo = (SystemInfo) Objects.requireNonNull(systemInfo);
    }

    public GeoInfo getGeoInfo(UserInfo userInfo) {
        LatLng latLng;
        SomaGdprData somaGdprData = this.somaGdprDataSource.getSomaGdprData();
        SomaLgpdData somaLgpdData = this.somaLgpdDataSource.getSomaLgpdData();
        if (!somaGdprData.isUsageAllowedFor(PiiParam.GPS) || ((somaLgpdData.isLgpdEnabled() && !somaLgpdData.isUsageAllowedFor()) || !this.sdkConfiguration.isGpsEnabled() || this.sdkConfiguration.isCoppaEnabled() || SmaatoSdk.isAgeRestrictedUser())) {
            return null;
        }
        LocationProvider.DetectedLocation locationData = this.dataCollector.getLocationData();
        if (locationData != null) {
            return new GeoInfo(new LatLng(locationData.getLatitude(), locationData.getLongitude(), locationData.getAccuracy(), locationData.getLastUpdatedMillis()), locationData.getType() == LocationProvider.DetectedLocation.TYPE.GPS ? GeoType.GPS : GeoType.IP_ADDRESS);
        }
        if (userInfo != null && (latLng = userInfo.getLatLng()) != null) {
            return new GeoInfo(latLng, GeoType.USER_PROVIDED);
        }
        return null;
    }

    public AdContentRating getAdContentRating() {
        SomaGdprData somaGdprData = this.somaGdprDataSource.getSomaGdprData();
        AdContentRating adContentRating = this.sdkConfiguration.getAdContentRating();
        return (adContentRating == null || !somaGdprData.isUsageAllowedFor(PiiParam.AGE)) ? AdContentRating.MAX_AD_CONTENT_RATING_UNDEFINED : adContentRating;
    }

    public String getGoogleAdId() {
        SomaGdprData somaGdprData = this.somaGdprDataSource.getSomaGdprData();
        SomaLgpdData somaLgpdData = this.somaLgpdDataSource.getSomaLgpdData();
        if (!somaGdprData.isUsageAllowedFor(PiiParam.GOOGLE_AD_ID)) {
            return null;
        }
        if ((!somaLgpdData.isLgpdEnabled() || somaLgpdData.isUsageAllowedFor()) && !this.sdkConfiguration.isCoppaEnabled()) {
            return this.systemInfo.getGoogleAdvertisingId();
        }
        return null;
    }

    public String getLanguage(UserInfo userInfo) {
        final String language = userInfo.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return this.systemInfo.getLanguage();
        }
        List listOf = Lists.of(Locale.getISOLanguages());
        java.util.Objects.requireNonNull(language);
        return Lists.any(listOf, new Predicate() { // from class: com.smaato.sdk.core.ad.RequestInfoProvider$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Predicate
            public final boolean test(Object obj) {
                return language.equals((String) obj);
            }
        }) ? language : this.systemInfo.getLanguage();
    }
}
