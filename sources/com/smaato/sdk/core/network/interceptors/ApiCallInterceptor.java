package com.smaato.sdk.core.network.interceptors;

import android.net.Uri;
import android.security.NetworkSecurityPolicy;
import com.inmobi.sdk.InMobiSdk;
import com.json.cc;
import com.json.fe;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.smaato.sdk.core.AdContentRating;
import com.smaato.sdk.core.SdkConfiguration;
import com.smaato.sdk.core.SmaatoSdk;
import com.smaato.sdk.core.ad.GeoInfo;
import com.smaato.sdk.core.ad.RequestInfoProvider;
import com.smaato.sdk.core.ad.UserInfo;
import com.smaato.sdk.core.api.ApiParams;
import com.smaato.sdk.core.datacollector.DataCollector;
import com.smaato.sdk.core.datacollector.SystemInfo;
import com.smaato.sdk.core.gdpr.PiiParam;
import com.smaato.sdk.core.gdpr.SomaGdprData;
import com.smaato.sdk.core.gdpr.SomaGdprDataSource;
import com.smaato.sdk.core.gpp.SomaGppData;
import com.smaato.sdk.core.hooks.Hook1061;
import com.smaato.sdk.core.lgpd.SomaLgpdData;
import com.smaato.sdk.core.lgpd.SomaLgpdDataSource;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.network.Headers;
import com.smaato.sdk.core.network.Interceptor;
import com.smaato.sdk.core.network.Request;
import com.smaato.sdk.core.network.Response;
import com.smaato.sdk.core.network.SomaException;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class ApiCallInterceptor implements Interceptor {
    private final ApiParams apiParams;
    private final DataCollector dataCollector;
    private final boolean isHttpsOnly;
    private final Logger logger;
    private final RequestInfoProvider requestInfoProvider;
    private final SdkConfiguration sdkConfiguration;
    private final SomaGdprDataSource somaGdprDataSource;
    private final SomaGppData somaGppData;
    private final SomaLgpdDataSource somaLgpdDataSource;

    public ApiCallInterceptor(SomaGdprDataSource somaGdprDataSource, SomaLgpdDataSource somaLgpdDataSource, SomaGppData somaGppData, SdkConfiguration sdkConfiguration, RequestInfoProvider requestInfoProvider, DataCollector dataCollector, boolean z, Logger logger, ApiParams apiParams) {
        this.somaGdprDataSource = somaGdprDataSource;
        this.somaLgpdDataSource = somaLgpdDataSource;
        this.somaGppData = somaGppData;
        this.sdkConfiguration = sdkConfiguration;
        this.requestInfoProvider = requestInfoProvider;
        this.dataCollector = dataCollector;
        this.isHttpsOnly = z;
        this.logger = logger;
        this.apiParams = apiParams;
    }

    @Override // com.smaato.sdk.core.network.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Uri.Builder builderBuildUpon = request.uri().buildUpon();
        Headers.Builder builderBuildUpon2 = request.headers().buildUpon();
        try {
            fillSdkStaticData(request.uri(), builderBuildUpon);
            fillGdprData(builderBuildUpon);
            fillLgpdData(builderBuildUpon);
            fillGppData(builderBuildUpon);
            fillUserInfoData(builderBuildUpon);
            fillDeviceInfoData(builderBuildUpon, builderBuildUpon2);
        } catch (Exception e) {
            this.logger.error(LogDomain.NETWORK, "ApiCallInterceptor failed: ", e);
        }
        return chain.proceed(request.buildUpon().uri(builderBuildUpon.build()).headers(builderBuildUpon2.build()).build());
    }

    private void fillSdkStaticData(Uri uri, Uri.Builder builder) {
        String publisherId = SmaatoSdk.getPublisherId();
        String queryParameter = uri.getQueryParameter("adspace");
        if (publisherId != null && queryParameter != null) {
            builder.appendQueryParameter("pub", Hook1061.onGetPublisherId(publisherId, queryParameter));
        } else {
            builder.appendQueryParameter("pub", publisherId);
        }
        builder.appendQueryParameter("extensions", CampaignEx.KEY_OMID);
        boolean z = this.isHttpsOnly;
        if (!z) {
            z = !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            this.logger.warning(LogDomain.NETWORK, "\"`httpsOnly` value overridden to TRUE, due to Network Security Configuration settings.\"", new Object[0]);
        }
        builder.appendQueryParameter(POBConstants.KEY_SECURE, z ? "1" : "0");
        builder.appendQueryParameter(SmaatoSdk.KEY_DEEPLINK, "true");
    }

    private void fillLgpdData(Uri.Builder builder) {
        SomaLgpdData somaLgpdData = this.somaLgpdDataSource.getSomaLgpdData();
        builder.appendQueryParameter("lgpd", somaLgpdData.isLgpdEnabled() ? "1" : "0");
        Boolean boolIsLgpdConsentEnabled = somaLgpdData.isLgpdConsentEnabled();
        if (boolIsLgpdConsentEnabled != null) {
            builder.appendQueryParameter("lgpd_consent", boolIsLgpdConsentEnabled.booleanValue() ? "1" : "0");
        } else {
            builder.appendQueryParameter("lgpd_consent", "1");
        }
    }

    private void fillGppData(Uri.Builder builder) {
        SomaGppData somaGppData = this.somaGppData;
        if (somaGppData != null) {
            if (somaGppData.getGppString() != null && !this.somaGppData.getGppString().isEmpty()) {
                builder.appendQueryParameter("gpp", this.somaGppData.getGppString());
            }
            if (this.somaGppData.getGppSid() == null || this.somaGppData.getGppSid().isEmpty()) {
                return;
            }
            builder.appendQueryParameter("gpp_sid", this.somaGppData.getGppSid());
        }
    }

    private void fillGdprData(Uri.Builder builder) throws SomaException {
        SomaGdprData somaGdprData = this.somaGdprDataSource.getSomaGdprData();
        if (!somaGdprData.isUsageAllowedFor(PiiParam.LOAD_ADS)) {
            throw new SomaException(SomaException.Type.NO_CONTENT, "GDPR permissions do not allow ad loading!");
        }
        Boolean boolIsGdprEnabled = somaGdprData.isGdprEnabled();
        if (boolIsGdprEnabled != null) {
            builder.appendQueryParameter("gdpr", boolIsGdprEnabled.booleanValue() ? "1" : "0");
        }
        if (!somaGdprData.getConsentString().isEmpty()) {
            builder.appendQueryParameter(InMobiSdk.IM_GDPR_CONSENT_IAB, somaGdprData.getConsentString());
        }
        SdkConfiguration sdkConfiguration = this.sdkConfiguration;
        if (sdkConfiguration.getUsPrivacyString().isEmpty()) {
            return;
        }
        builder.appendQueryParameter("us_privacy", sdkConfiguration.getUsPrivacyString());
    }

    private void fillUserInfoData(Uri.Builder builder) {
        UserInfo userInfo = this.sdkConfiguration.getUserInfo();
        builder.appendQueryParameter("coppa", userInfo.getCoppa() ? "1" : "0");
        if (userInfo.getKeywords() != null) {
            builder.appendQueryParameter("kws", userInfo.getKeywords());
        }
        if (userInfo.getSearchQuery() != null) {
            builder.appendQueryParameter("qs", userInfo.getSearchQuery());
        }
        SomaGdprData somaGdprData = this.somaGdprDataSource.getSomaGdprData();
        SomaLgpdData somaLgpdData = this.somaLgpdDataSource.getSomaLgpdData();
        if (somaGdprData.isUsageAllowedFor(PiiParam.GENDER) && !SmaatoSdk.isAgeRestrictedUser() && userInfo.getGender() != null) {
            builder.appendQueryParameter("gender", userInfo.getGender().toString());
        }
        if (somaGdprData.isUsageAllowedFor(PiiParam.AGE) && !SmaatoSdk.isAgeRestrictedUser() && userInfo.getAge() != null) {
            builder.appendQueryParameter("age", userInfo.getAge().toString());
        }
        if (userInfo.getRegion() != null) {
            builder.appendQueryParameter("region", userInfo.getRegion());
        }
        if (somaGdprData.isUsageAllowedFor(PiiParam.ZIP) && !SmaatoSdk.isAgeRestrictedUser() && userInfo.getZip() != null) {
            builder.appendQueryParameter(POBCommonConstants.ZIP_PARAM, userInfo.getZip());
        }
        RequestInfoProvider requestInfoProvider = this.requestInfoProvider;
        builder.appendQueryParameter(fe.q, requestInfoProvider.getLanguage(userInfo));
        GeoInfo geoInfo = requestInfoProvider.getGeoInfo(userInfo);
        if (geoInfo != null && (!somaLgpdData.isLgpdEnabled() || somaLgpdData.isUsageAllowedFor())) {
            builder.appendQueryParameter("gps", geoInfo.getFormattedLatitude() + StringUtils.COMMA + geoInfo.getFormattedLongitude());
            builder.appendQueryParameter("geotype", geoInfo.getGeoType().toString());
        }
        AdContentRating adContentRating = requestInfoProvider.getAdContentRating();
        if (AdContentRating.MAX_AD_CONTENT_RATING_UNDEFINED != adContentRating) {
            builder.appendQueryParameter("madcr", adContentRating.toString());
        }
    }

    private void fillDeviceInfoData(Uri.Builder builder, Headers.Builder builder2) {
        SystemInfo systemInfo = this.dataCollector.getSystemInfo();
        if (systemInfo.getCarrierName() != null) {
            builder.appendQueryParameter("carrier", systemInfo.getCarrierName());
        }
        if (systemInfo.getCarrierCode() != null) {
            builder.appendQueryParameter("carriercode", systemInfo.getCarrierCode());
        }
        Boolean boolIsGoogleLimitAdTrackingEnabled = systemInfo.isGoogleLimitAdTrackingEnabled();
        if (boolIsGoogleLimitAdTrackingEnabled != null) {
            builder.appendQueryParameter("dnt", boolIsGoogleLimitAdTrackingEnabled.toString());
        }
        builder.appendQueryParameter("connection", this.apiParams.getConnectionType());
        builder.appendQueryParameter(POBConstants.KEY_BUNDLE, this.apiParams.getBundle());
        builder.appendQueryParameter("client", this.apiParams.getClient());
        builder2.put("X-SMT-Client", "sdk/android/" + SmaatoSdk.getVersion());
        SomaGdprData somaGdprData = this.somaGdprDataSource.getSomaGdprData();
        this.somaLgpdDataSource.getSomaLgpdData();
        if (somaGdprData.isUsageAllowedFor(PiiParam.DEVICE_MODEL) && !SmaatoSdk.isAgeRestrictedUser() && systemInfo.getDeviceModelName() != null) {
            builder.appendQueryParameter(cc.n, systemInfo.getDeviceModelName());
        }
        String googleAdId = getGoogleAdId(systemInfo);
        if (googleAdId != null) {
            builder.appendQueryParameter(POBConstants.KEY_IFA, googleAdId);
        }
    }

    private String getGoogleAdId(SystemInfo systemInfo) {
        SomaGdprData somaGdprData = this.somaGdprDataSource.getSomaGdprData();
        SomaLgpdData somaLgpdData = this.somaLgpdDataSource.getSomaLgpdData();
        if (!somaGdprData.isUsageAllowedFor(PiiParam.GOOGLE_AD_ID)) {
            return null;
        }
        if ((somaLgpdData.isLgpdEnabled() && !somaLgpdData.isUsageAllowedFor()) || this.sdkConfiguration.isCoppaEnabled() || SmaatoSdk.isAgeRestrictedUser()) {
            return null;
        }
        return systemInfo.getGoogleAdvertisingId();
    }
}
