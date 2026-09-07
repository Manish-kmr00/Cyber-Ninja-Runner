package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.ads.ApsMigrationUtil;
import com.amazon.aps.ads.privacy.ApsPrivacyManager;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.remoteconfig.internal.Personalization;
import com.inmobi.sdk.InMobiSdk;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes13.dex */
public class DtbDeviceRegistration {
    private static final String AAX_VIDEO_HOST_NAME_KEY = "aaxVideoHostname";
    private static final String CONFIG_OS_KEY = "os";
    private static final String CONFIG_OS_VERSION_KEY = "osVersion";
    private static final String CONFIG_PRIVACY_APPLICABLE = "privacyApplicable";
    private static final String CONFIG_PRIVACY_KEY = "privacy";
    private static final String CONFIG_SEGMENT_ID_KEY = "segmentId";
    private static final String LOG_TAG = "com.amazon.device.ads.DtbDeviceRegistration";
    private static String appId;
    private static int configSeq;
    private static DtbDeviceRegistration dtbDeviceRegistrationInstance;
    private final DtbMetrics metrics = new DtbMetrics();

    public static synchronized void verifyRegistration() {
        if (dtbDeviceRegistrationInstance == null) {
            dtbDeviceRegistrationInstance = new DtbDeviceRegistration();
            ApsMigrationUtil.setApsRemoteConfigInProgress(false);
        }
        if (!ApsMigrationUtil.isApsRemoteConfigInProgress()) {
            ApsMigrationUtil.setApsRemoteConfigInProgress(true);
            DtbThreadService.getInstance().execute(new Runnable() { // from class: com.amazon.device.ads.DtbDeviceRegistration$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DtbDeviceRegistration.lambda$verifyRegistration$0();
                }
            });
        }
    }

    static /* synthetic */ void lambda$verifyRegistration$0() {
        dtbDeviceRegistrationInstance.initializeAds();
        ApsMigrationUtil.setApsRemoteConfigInProgress(false);
    }

    private DtbDeviceRegistration() {
    }

    /* JADX WARN: Code duplicated, block: B:96:0x0222 A[Catch: all -> 0x0228, TryCatch #2 {, blocks: (B:4:0x000b, B:6:0x0011, B:9:0x001a, B:11:0x0026, B:14:0x002f, B:16:0x0035, B:19:0x003c, B:21:0x005e, B:23:0x0066, B:26:0x007c, B:28:0x008a, B:30:0x0096, B:33:0x009f, B:35:0x00af, B:38:0x00b6, B:40:0x00c6, B:42:0x00e0, B:57:0x0155, B:59:0x0169, B:60:0x016e, B:94:0x020e, B:96:0x0222, B:97:0x0227, B:78:0x01be, B:80:0x01d2, B:88:0x01f2, B:90:0x0206, B:41:0x00d3), top: B:101:0x000b }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private synchronized void initializeAds() {
        if (DtbCommonUtils.isOnMainThread()) {
            DtbLog.error(LOG_TAG, "Unable to fetch advertising identifier information on main thread.");
            return;
        }
        String appKey = AdRegistration.getAppKey();
        appId = appKey;
        if (DtbCommonUtils.isNullOrEmpty(appKey)) {
            DtbLog.error(LOG_TAG, "App id not available");
            return;
        }
        if (!DtbCommonUtils.isNetworkConnected()) {
            DtbLog.debug("Network is not available");
            return;
        }
        DtbDebugProperties.getInstance();
        registerConfig(appId);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jLongValue = DtbSharedPreferences.getInstance().getSisLastCheckIn().longValue();
        if (DtbSharedPreferences.getInstance().getIsSisRegisterationSuccessful()) {
            long j = jCurrentTimeMillis - jLongValue;
            if (j <= 86400000) {
                DtbLog.debug("SIS call not required, last registration duration:" + j + ", expiration:86400000");
                return;
            }
        }
        new DtbAdvertisingInfo();
        boolean z = false;
        if (!ApsPrivacyManager.INSTANCE.isSystemResourceAccessAllowed() && !DTBMetricsConfiguration.getInstance().isFeatureEnabled(DTBMetricsConfiguration.FEATURE_AIP_CALL_IF_NO_GDPR_CONSENT, false)) {
            ApsLog.d(LOG_TAG, "No AIP calls as the feature flag is off");
            return;
        }
        String sisEndpoint = DtbSharedPreferences.getInstance().getSisEndpoint();
        if (sisEndpoint.startsWith("null")) {
            DtbLog.debug("SIS is not ready");
            return;
        }
        StringBuilder sb = new StringBuilder(DtbDebugProperties.getSISUrl(sisEndpoint));
        if (jLongValue == 0) {
            DtbLog.info(LOG_TAG, "Trying to register ad id..");
            sb.append("/generate_did");
        } else {
            DtbLog.info(LOG_TAG, "Trying to update ad id..");
            sb.append("/update_dev_info");
            z = true;
        }
        HashMap<String, Object> mapBuildSISParams = buildSISParams(appId);
        JSONObject jSONObject = null;
        DtbMetric dtbMetric = 0;
        jSONObject = null;
        jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("api", z ? "update_dev_info" : "generate_did");
                DtbHttpClient dtbHttpClient = new DtbHttpClient(sb.toString());
                dtbHttpClient.setUseSecure(DtbDebugProperties.getIsSecure(true));
                dtbHttpClient.setParams(mapBuildSISParams);
                dtbHttpClient.enableQueryParams();
                DtbMetric dtbMetric2 = z ? DtbMetric.SIS_LATENCY_UPDATE_DEVICE_INFO : DtbMetric.SIS_LATENCY_REGISTER_EVENT;
                this.metrics.startTimer(dtbMetric2);
                dtbHttpClient.executePOST(60000);
                this.metrics.stopTimer(dtbMetric2);
                if (DtbCommonUtils.isNullOrEmpty(dtbHttpClient.getResponse())) {
                    DtbLog.debug("No response from sis call.");
                    throw new Exception("SIS Response is null");
                }
                JSONObject jSONObject3 = (JSONObject) new JSONTokener(dtbHttpClient.getResponse()).nextValue();
                DtbSharedPreferences.getInstance().setIsSisRegisterationSuccessful(isRegistrationRequestSuccessful(jSONObject3));
                if (!DtbSharedPreferences.getInstance().getIsSisRegisterationSuccessful()) {
                    DtbLog.info(LOG_TAG, "ad id failed registration: " + jSONObject3);
                    throw new Exception("ad id failed registration: ");
                }
                ApsMetrics.customEvent("sisApiSuccess", String.valueOf(DtbSharedPreferences.getInstance().isValidIdfaAvailable()), jSONObject2);
                if (dtbMetric2 != null) {
                    this.metrics.resetMetric(dtbMetric2);
                }
                pingSis(sisEndpoint, appId);
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                try {
                    DtbLog.error("JSON error parsing return from SIS: " + e.getMessage());
                    ApsMetrics.customEvent("sisApiFailed", String.valueOf(DtbSharedPreferences.getInstance().isValidIdfaAvailable()), jSONObject);
                    if (jSONObject != 0) {
                        this.metrics.resetMetric(null);
                    }
                } catch (Throwable th) {
                    th = th;
                    ApsMetrics.customEvent("sisApiFailed", String.valueOf(DtbSharedPreferences.getInstance().isValidIdfaAvailable()), jSONObject);
                    if (dtbMetric != 0) {
                        this.metrics.resetMetric(dtbMetric);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                try {
                    DtbLog.error("Error registering device for ads:" + e);
                    ApsMetrics.customEvent("sisApiFailed", String.valueOf(DtbSharedPreferences.getInstance().isValidIdfaAvailable()), jSONObject);
                    if (jSONObject != 0) {
                        this.metrics.resetMetric(null);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dtbMetric = jSONObject;
                    ApsMetrics.customEvent("sisApiFailed", String.valueOf(DtbSharedPreferences.getInstance().isValidIdfaAvailable()), jSONObject);
                    if (dtbMetric != 0) {
                        this.metrics.resetMetric(dtbMetric);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dtbMetric = 0;
                jSONObject = jSONObject2;
                ApsMetrics.customEvent("sisApiFailed", String.valueOf(DtbSharedPreferences.getInstance().isValidIdfaAvailable()), jSONObject);
                if (dtbMetric != 0) {
                    this.metrics.resetMetric(dtbMetric);
                }
                throw th;
            }
        } catch (JSONException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
        } catch (Throwable th4) {
            th = th4;
            dtbMetric = 0;
        }
    }

    private void pingSis(String str, String str2) {
        if (System.currentTimeMillis() - DtbSharedPreferences.getInstance().getSisLastPing() < 2592000000L) {
            return;
        }
        String adId = DtbSharedPreferences.getInstance().getAdId();
        if (adId == null || adId.isEmpty()) {
            DtbLog.info("error retrieving ad id, cancelling sis ping");
            return;
        }
        try {
            if (!DtbCommonUtils.isNetworkConnected()) {
                DtbLog.debug("Network is not available");
                return;
            }
            DtbHttpClient dtbHttpClient = new DtbHttpClient(str + "/ping");
            dtbHttpClient.setUseSecure(DtbDebugProperties.getIsSecure(true));
            HashMap<String, Object> map = new HashMap<>();
            map.put(RemoteConfigConstants.RequestFieldKey.APP_ID, str2);
            map.put("adId", adId);
            Context context = AdRegistration.getContext();
            if (context != null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                Object obj = defaultSharedPreferences.contains("IABTCF_gdprApplies") ? defaultSharedPreferences.getAll().get("IABTCF_gdprApplies") : null;
                String string = defaultSharedPreferences.getString("IABTCF_TCString", null);
                if (obj != null) {
                    try {
                        if ((obj instanceof Integer) && (((Integer) obj).intValue() == 1 || ((Integer) obj).intValue() == 0)) {
                            map.put("gdpr", obj);
                        } else if (((obj instanceof String) && ((String) obj).equals("1")) || ((String) obj).equals("0")) {
                            map.put("gdpr", obj);
                        } else {
                            DtbLog.info("IABTCF_gdprApplies should be a 1 or 0 as per IAB guideline");
                        }
                    } catch (ClassCastException unused) {
                        DtbLog.info("IABTCF_gdprApplies should be a number as per IAB guideline");
                    }
                }
                if (string != null) {
                    map.put(InMobiSdk.IM_GDPR_CONSENT_IAB, string);
                }
                if (DTBMetricsConfiguration.getInstance().isFeatureEnabled(DTBMetricsConfiguration.FEATURE_FLAG_GPP_PARAMS_TO_AIP_CALL)) {
                    HashMap<String, Object> mapAddGPPParametersFromPreferences = DtbCommonUtils.addGPPParametersFromPreferences(defaultSharedPreferences);
                    if (!DtbCommonUtils.isNullOrEmpty(mapAddGPPParametersFromPreferences)) {
                        map.putAll(mapAddGPPParametersFromPreferences);
                    }
                }
            }
            String encodedNonIABString = AdRegistration.getEncodedNonIABString();
            if (!DtbCommonUtils.isNullOrEmpty(encodedNonIABString)) {
                map.put("gdpr_custom", encodedNonIABString);
            }
            dtbHttpClient.setParams(map);
            dtbHttpClient.executeGET(60000);
            if (DtbCommonUtils.isNullOrEmpty(dtbHttpClient.getResponse())) {
                DtbLog.debug("No response from sis ping.");
                throw new Exception("Ping SIS Response is null");
            }
            JSONObject jSONObject = (JSONObject) new JSONTokener(dtbHttpClient.getResponse()).nextValue();
            if (isPingRequestSuccessful(jSONObject)) {
                return;
            }
            DtbLog.info(LOG_TAG, "sis ping failed failed registration: " + jSONObject);
            throw new Exception("sis ping failed registration: ");
        } catch (Exception e) {
            DtbLog.error("Error pinging sis: " + e);
        }
    }

    private boolean registerConfig(String str) {
        DtbMetrics dtbMetrics;
        configSeq++;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jLongValue = jCurrentTimeMillis - DtbSharedPreferences.getInstance().getConfigLastCheckIn().longValue();
        long configTtlInMilliSeconds = DtbSharedPreferences.getInstance().getConfigTtlInMilliSeconds();
        DtbLog.debug("Config last check in duration: " + jLongValue + ", Expiration: " + configTtlInMilliSeconds);
        if (!DTBMetricsConfiguration.getInstance().isFeatureEnabled("config_check_in_ttl_feature_v2")) {
            configTtlInMilliSeconds = 172800000;
        }
        boolean registerConfigResponse = false;
        if (jLongValue <= configTtlInMilliSeconds) {
            DtbLog.debug("No config refresh required");
            return false;
        }
        if (!DtbCommonUtils.isNetworkConnected()) {
            DtbLog.debug("Network is not available");
            return false;
        }
        DtbHttpClient dtbHttpClient = new DtbHttpClient(DtbDebugProperties.getConfigHostName("mads.amazon-adsystem.com") + "/msdk/getConfig");
        dtbHttpClient.addHeader("Accept", "application/json");
        for (Map.Entry<String, String> entry : DtbDebugProperties.getConfigRequestHeaders(JsonUtils.EMPTY_JSON).entrySet()) {
            dtbHttpClient.addHeader(entry.getKey(), entry.getValue());
        }
        dtbHttpClient.setUseSecure(DtbDebugProperties.getIsSecure(true));
        dtbHttpClient.setParams(buildConfigInfoParams(str));
        try {
            try {
                this.metrics.startTimer(DtbMetric.CONFIG_DOWNLOAD_LATENCY);
                dtbHttpClient.executeGET(60000);
                this.metrics.stopTimer(DtbMetric.CONFIG_DOWNLOAD_LATENCY);
                if (DtbCommonUtils.isNullOrEmpty(dtbHttpClient.getResponse())) {
                    throw new Exception("Config Response is null");
                }
                registerConfigResponse = parseRegisterConfigResponse(dtbHttpClient.getResponse(), jCurrentTimeMillis, false);
                ApsMetrics.customEvent("remoteConfigFetchSuccess", String.valueOf(configSeq), null);
                dtbMetrics = this.metrics;
                if (dtbMetrics != null) {
                    dtbMetrics.resetMetric(DtbMetric.CONFIG_DOWNLOAD_LATENCY);
                }
                try {
                    DTBMetricsConfiguration.getInstance().loadMobileClientConfig();
                    double dIntValue = DTBMetricsConfiguration.getClientConfigVal("sampling_rate", DTBMetricsConfiguration.ANALYTIC_PIXEL_DEFAULT_VALUE.intValue(), "analytics").intValue() / 100.0f;
                    String clientConfigVal = DTBMetricsConfiguration.getClientConfigVal("url", "", "analytics");
                    String clientConfigVal2 = DTBMetricsConfiguration.getClientConfigVal("api_key", "", "analytics");
                    if (!APSAnalytics.isInitialized()) {
                        APSAnalytics.init(AdRegistration.getContext());
                        APSAnalytics.setVersion(AdRegistration.getVersion());
                    }
                    APSAnalytics.setSamplingRate((int) dIntValue);
                    APSAnalytics.setHttpUrl(clientConfigVal);
                    APSAnalytics.setApiKey(clientConfigVal2);
                    loadApsMetricsConfig();
                } catch (RuntimeException e) {
                    DtbLog.warn("Error when reading client config file for APSAndroidShared library" + e);
                }
                return registerConfigResponse;
            } catch (Exception e2) {
                DtbLog.error("Error fetching DTB config: " + e2);
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error fetching DTB config:", e2);
                ApsMetrics.customEvent("remoteConfigFetchFailed", String.valueOf(configSeq), null);
                dtbMetrics = this.metrics;
                if (dtbMetrics != null) {
                }
            }
        } catch (Throwable th) {
            DtbMetrics dtbMetrics2 = this.metrics;
            if (dtbMetrics2 != null) {
                dtbMetrics2.resetMetric(DtbMetric.CONFIG_DOWNLOAD_LATENCY);
            }
            throw th;
        }
    }

    private void loadApsMetricsConfig() {
        ApsMetrics.INSTANCE.setEndpointUrl(DTBMetricsConfiguration.getClientConfigVal(DTBMetricsConfiguration.APSMETRICS_LEVEL1_KEY, DTBMetricsConfiguration.APSMETRICS_LEVEL2_KEY, "url", ApsMetrics.METRICS_DEFAULT_ENDPOINT_URL));
        ApsMetrics.INSTANCE.setSamplingPercentage(DTBMetricsConfiguration.getClientConfigVal(DTBMetricsConfiguration.APSMETRICS_LEVEL1_KEY, DTBMetricsConfiguration.APSMETRICS_LEVEL2_KEY, DTBMetricsConfiguration.APSMETRICS_SAMPLING_RATE, 0.1d).doubleValue());
        ApsMetrics.INSTANCE.setApiKey(DTBMetricsConfiguration.getClientConfigVal(DTBMetricsConfiguration.APSMETRICS_LEVEL1_KEY, DTBMetricsConfiguration.APSMETRICS_LEVEL2_KEY, DTBMetricsConfiguration.APSMETRICS_APIKEY, ApsMetrics.METRICS_DEFAULT_METRICS_API_KEY));
    }

    private boolean parseRegisterConfigResponse(String str, long j, boolean z) throws Exception {
        JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
        if (jSONObject.has(CONFIG_PRIVACY_APPLICABLE)) {
            Object obj = jSONObject.get(CONFIG_PRIVACY_APPLICABLE);
            if (obj instanceof JSONArray) {
                ApsPrivacyManager.INSTANCE.setGdprConfiguration((JSONArray) obj);
            }
        }
        if (jSONObject.has("pj")) {
            DtbSharedPreferences.getInstance().savePJTemplate(jSONObject.getJSONObject("pj"));
        } else {
            DtbSharedPreferences.getInstance().removePJTemplate();
        }
        if (jSONObject.has("privacy")) {
            setPrivacyConfigToSharedPreferences(jSONObject.getJSONArray("privacy"));
        } else {
            DtbSharedPreferences.getInstance().removePrivacyLocationConfig();
        }
        if (jSONObject.has(DtbDebugProperties.AAX_HOSTNAME) || jSONObject.has("sisURL") || jSONObject.has(AAX_VIDEO_HOST_NAME_KEY)) {
            if (jSONObject.has(DtbDebugProperties.AAX_HOSTNAME)) {
                DtbSharedPreferences.getInstance().saveAaxHostname(jSONObject.getString(DtbDebugProperties.AAX_HOSTNAME));
            }
            if (jSONObject.has("sisURL")) {
                z = DtbSharedPreferences.getInstance().saveSisEndpoint(jSONObject.getString("sisURL"));
            }
            if (jSONObject.has("ttl")) {
                DtbSharedPreferences.getInstance().saveConfigTtlInMilliSeconds(Long.parseLong(jSONObject.getString("ttl")));
            }
            if (jSONObject.has(AAX_VIDEO_HOST_NAME_KEY)) {
                DtbSharedPreferences.getInstance().saveAaxVideoHostname(jSONObject.getString(AAX_VIDEO_HOST_NAME_KEY));
            }
            if (jSONObject.has("bidTimeout")) {
                DtbSharedPreferences.getInstance().saveBidTimeout(Integer.valueOf(jSONObject.getInt("bidTimeout")));
            } else {
                DtbSharedPreferences.getInstance().removeBidTimeout();
            }
            DtbSharedPreferences.getInstance().saveConfigLastCheckIn(j);
            DtbLog.info(LOG_TAG, "ad configuration loaded successfully.");
            return z;
        }
        DtbLog.info(LOG_TAG, "ad configuration failed load: " + jSONObject);
        throw new Exception("ad configuration failed load");
    }

    private static String convertBooleanToFlag(Boolean bool) {
        return (bool != null && bool.booleanValue()) ? "1" : "0";
    }

    private HashMap<String, Object> buildSISParams(String str) {
        HashMap<String, Object> map = new HashMap<>(DtbDeviceData.getDeviceDataInstance().getDeviceParams());
        String adId = DtbSharedPreferences.getInstance().getAdId();
        if (adId != null) {
            map.put("adId", adId);
        }
        String idfa = DtbSharedPreferences.getInstance().getIdfa();
        Boolean optOut = DtbSharedPreferences.getInstance().getOptOut();
        if (!DtbCommonUtils.isNullOrEmpty(idfa)) {
            map.put("idfa", idfa);
        }
        map.put("oo", convertBooleanToFlag(optOut));
        if (str != null) {
            map.put(RemoteConfigConstants.RequestFieldKey.APP_ID, str);
        }
        JSONObject paramsJson = DtbPackageNativeData.getPackageNativeDataInstance(AdRegistration.getContext()).getParamsJson();
        if (paramsJson != null) {
            map.put("pkg", paramsJson);
        }
        Context context = AdRegistration.getContext();
        if (context != null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Object obj = defaultSharedPreferences.contains("IABTCF_gdprApplies") ? defaultSharedPreferences.getAll().get("IABTCF_gdprApplies") : null;
            String string = defaultSharedPreferences.getString("IABTCF_TCString", null);
            if (obj != null) {
                try {
                    if ((obj instanceof Integer) && (((Integer) obj).intValue() == 1 || ((Integer) obj).intValue() == 0)) {
                        map.put("gdpr", obj);
                    } else if (((obj instanceof String) && ((String) obj).equals("1")) || ((String) obj).equals("0")) {
                        map.put("gdpr", obj);
                    } else {
                        DtbLog.info("IABTCF_gdprApplies should be a 1 or 0 as per IAB guideline");
                    }
                } catch (ClassCastException unused) {
                    DtbLog.info("IABTCF_gdprApplies should be a number as per IAB guideline");
                }
            }
            if (string != null) {
                map.put(InMobiSdk.IM_GDPR_CONSENT_IAB, string);
            }
            if (DTBMetricsConfiguration.getInstance().isFeatureEnabled(DTBMetricsConfiguration.FEATURE_FLAG_GPP_PARAMS_TO_AIP_CALL)) {
                HashMap<String, Object> mapAddGPPParametersFromPreferences = DtbCommonUtils.addGPPParametersFromPreferences(defaultSharedPreferences);
                if (!DtbCommonUtils.isNullOrEmpty(mapAddGPPParametersFromPreferences)) {
                    map.putAll(mapAddGPPParametersFromPreferences);
                }
            }
        }
        String encodedNonIABString = AdRegistration.getEncodedNonIABString();
        if (!DtbCommonUtils.isNullOrEmpty(encodedNonIABString)) {
            map.put("gdpr_custom", encodedNonIABString);
        }
        return map;
    }

    private HashMap<String, Object> buildConfigInfoParams(String str) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(RemoteConfigConstants.RequestFieldKey.APP_ID, str);
        map.put("sdkVer", DtbCommonUtils.getSDKVersion());
        map.put(Personalization.ANALYTICS_ORIGIN_PERSONALIZATION, "false");
        map.put("testMode", Boolean.toString(AdRegistration.isTestMode()));
        JSONObject paramsJsonGetSafe = DtbDeviceData.getDeviceDataInstance().getParamsJsonGetSafe();
        if (paramsJsonGetSafe != null) {
            map.put("dinfo", paramsJsonGetSafe);
        }
        JSONObject paramsJson = DtbPackageNativeData.getPackageNativeDataInstance(AdRegistration.getContext()).getParamsJson();
        if (paramsJson != null) {
            map.put("pkg", paramsJson);
        }
        if (AdRegistration.getCustomDictionary() != null && AdRegistration.getCustomDictionary().containsKey(DtbConstants.MEDIATION_NAME)) {
            String str2 = AdRegistration.getCustomDictionary().get(DtbConstants.MEDIATION_NAME);
            if (!DtbCommonUtils.isNullOrEmpty(str2)) {
                map.put(DtbConstants.MEDIATION_NAME, str2);
            }
        }
        if (Math.random() <= DTBMetricsConfiguration.getClientConfigVal("distribution_pixel", DTBMetricsConfiguration.DISTRIBUTION_PIXEL_DEFAULT_VALUE.intValue(), "sample_rates").intValue() / 100.0f) {
            String sDKDistributionPlace = AdRegistration.getSDKDistributionPlace();
            if (!DtbCommonUtils.isNullOrEmpty(sDKDistributionPlace)) {
                map.put("distribution", sDKDistributionPlace);
            }
        }
        map.put(CONFIG_SEGMENT_ID_KEY, Integer.valueOf(new SecureRandom().nextInt(1000) + 1));
        map.put("os", "android");
        map.put("osVersion", Build.VERSION.RELEASE);
        return map;
    }

    private boolean isRegistrationRequestSuccessful(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("rcode")) {
            return false;
        }
        DtbSharedPreferences.getInstance().saveSisLastCheckIn(System.currentTimeMillis());
        if (jSONObject.getInt("rcode") == 1 && jSONObject.has("adId")) {
            String string = jSONObject.getString("adId");
            if (jSONObject.has("idChanged") && jSONObject.getBoolean("idChanged")) {
                DtbLog.info(LOG_TAG, "ad id has changed, updating..");
                this.metrics.incrementMetric(DtbMetric.SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED);
            }
            DtbSharedPreferences.getInstance().saveAdId(string);
            DtbLog.info(LOG_TAG, "ad id is registered or updated successfully.");
            return true;
        }
        if (jSONObject.getInt("rcode") != 103) {
            if (jSONObject.getInt("rcode") != 101 || !jSONObject.has("msg")) {
                return false;
            }
            if (jSONObject.optInt("msg") != 103 && !"need at least one native id in parameter".equals(jSONObject.get("msg"))) {
                return false;
            }
        }
        DtbSharedPreferences.getInstance().removeAdid();
        DtbLog.debug(LOG_TAG, "No ad-id returned");
        return true;
    }

    private boolean isPingRequestSuccessful(JSONObject jSONObject) throws JSONException {
        if (!jSONObject.has("rcode")) {
            return false;
        }
        if (jSONObject.getInt("rcode") == 1) {
            DtbSharedPreferences.getInstance().saveSisLastPing(System.currentTimeMillis());
            DtbLog.info(LOG_TAG, "ad id is registered or updated successfully.");
            return true;
        }
        if (jSONObject.getInt("rcode") != 103 && (jSONObject.getInt("rcode") != 101 || !jSONObject.has("msg") || jSONObject.getInt("msg") != 103)) {
            return false;
        }
        DtbSharedPreferences.getInstance().saveSisLastPing(System.currentTimeMillis());
        DtbLog.info("gdpr consent not granted");
        return true;
    }

    private void setPrivacyConfigToSharedPreferences(JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("location")) {
                    DtbSharedPreferences.getInstance().savePrivacyLocationConfig(jSONObject.getJSONObject("location"));
                    return;
                }
            } catch (RuntimeException | JSONException e) {
                DtbLog.error(LOG_TAG, "Failed to parse privacy configuration");
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to parse privacy configuration", e);
                return;
            }
        }
        DtbSharedPreferences.getInstance().removePrivacyLocationConfig();
    }
}
