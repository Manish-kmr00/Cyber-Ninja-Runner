package com.amazon.device.ads;

import android.content.SharedPreferences;
import androidx.work.PeriodicWorkRequest;
import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.ads.privacy.ApsPrivacyManager;
import com.amazon.aps.ads.util.ApsInMemoryManager;
import com.json.b9;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class DtbSharedPreferences {
    private static final String AAX_HOSTNAME_PREF_NAME = "amzn-dtb-ad-aax-hostname";
    private static final String AAX_VIDEO_HOSTNAME_PREF_NAME = "amzn-dtb-ad-aax-video-hostname";
    private static final String ADID_PREF_NAME = "amzn-dtb-ad-id";
    private static final String BID_TIMEOUT_PREF_NAME = "amzn-dtb-bid-timeout";
    private static final String CONFIG_LAST_CHECKIN_PREF_NAME = "amzn-dtb-ad-config-last-checkin";
    private static final String CONFIG_TTL_PREF_NAME = "amzn-dtb-ad-config-ttl";
    private static final String DTB_VERSION_IN_USE = "amzn-dtb-version_in_use";
    private static final String ENCODED_PRICE_CHECK_PREF_NAME = "amzn-dtb-enable-encoded-price-check";
    private static final String IDFA_PREF_NAME = "amzn-dtb-idfa";
    private static final String IS_ADID_CHANGED_PREF_NAME = "amzn-dtb-adid-changed";
    private static final String IS_ADID_NEW_PREF_NAME = "amzn-dtb-adid-new";
    private static final String IS_GPS_UNAVAILABLE_PREF_NAME = "amzn-dtb-is-gps-unavailable";
    private static final String LOG_TAG = "DtbSharedPreferences";
    private static final String NON_IAB_CMP_FLAVOR = "NON_IAB_CMP_FLAVOR";
    private static final String NON_IAB_CONSENT_STATUS = "NON_IAB_CONSENT_STATUS";
    private static final String NON_IAB_CUSTOM_CONSENT = "NON_IAB_Custom_Consent";
    private static final String NON_IAB_VENDORLIST = "NON_IAB_VENDORLIST";
    private static final String OO_PREF_NAME = "amzn-dtb-oo";
    private static final String PJ_TEMPLATE_PREF_NAME = "amzn-dtb-pj-template";
    private static final String PREF_FILE_NAME = "com.amazon.device.ads.dtb.preferences";
    private static final String PRIVACY_LOCATION_ACCURACY_IN_METERS_PREF_NAME = "amzn-dtb-privacy-location-accuracy-in-meters";
    private static final String PRIVACY_LOCATION_MODE_PREF_NAME = "amzn-dtb-privacy-location-mode";
    private static final String SDK_WRAPPER_PING = "sdk-wrapper-ping";
    private static final String SIS_ENDPOINT_PREF_NAME = "amzn-dtb-ad-sis-endpoint";
    private static final String SIS_LAST_CHECKIN_PREF_NAME = "amzn-dtb-ad-sis-last-checkin";
    private static final String SIS_LAST_PING_PREF_NAME = "amzn-dtb-ad-sis-last-ping";
    private static final String SIS_LAST_PING_WEB_RESOURCES = "amzn-dtb-web-resource-ping";
    public static DtbSharedPreferences dtbSharedPreferencesInstance;
    private static SharedPreferences sharedPreferences;
    private static ApsInMemoryManager apsInMemoryManager = ApsInMemoryManager.INSTANCE;
    private static boolean isIgnore = false;
    private static boolean IS_SIS_REGISTERATION_SUCCESSFUL = false;

    static void setIgnoreMode() {
        isIgnore = true;
    }

    public boolean getIsSisRegisterationSuccessful() {
        return IS_SIS_REGISTERATION_SUCCESSFUL;
    }

    public void setIsSisRegisterationSuccessful(boolean z) {
        IS_SIS_REGISTERATION_SUCCESSFUL = z;
    }

    private static SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences = AdRegistration.getContext().getSharedPreferences(PREF_FILE_NAME, 0);
        }
        return sharedPreferences;
    }

    public DtbSharedPreferences() {
        if (AdRegistration.getContext() != null) {
            sharedPreferences = AdRegistration.getContext().getSharedPreferences(PREF_FILE_NAME, 0);
        }
    }

    public static DtbSharedPreferences createInstance() {
        DtbSharedPreferences dtbSharedPreferences = new DtbSharedPreferences();
        dtbSharedPreferencesInstance = dtbSharedPreferences;
        return dtbSharedPreferences;
    }

    public static DtbSharedPreferences getInstance() {
        if (dtbSharedPreferencesInstance == null) {
            createInstance();
        }
        return dtbSharedPreferencesInstance;
    }

    public String getVersionInUse() {
        return (String) getPref(DTB_VERSION_IN_USE, String.class);
    }

    public void setVersionInUse(String str) {
        savePref(DTB_VERSION_IN_USE, str);
    }

    public String getAdId() {
        return (String) getPref(ADID_PREF_NAME, String.class);
    }

    public void saveAdId(String str) {
        if (str != null) {
            savePref(ADID_PREF_NAME, str);
        }
    }

    public static void clearStorage() {
        ApsLog.d(LOG_TAG, "Removing the stored shared preferences");
        try {
            if (getSharedPreferences() != null) {
                getSharedPreferences().edit().clear().commit();
            }
            flushPreference(IDFA_PREF_NAME);
        } catch (Exception e) {
            ApsLog.e("Error in clearing the storage:" + e.getMessage());
        }
    }

    public void removeAdid() {
        flushPreference(ADID_PREF_NAME);
    }

    public void removeAAXHostName() {
        flushPreference(AAX_HOSTNAME_PREF_NAME);
    }

    public String getIdfa() {
        return (String) getPref(IDFA_PREF_NAME, String.class);
    }

    public boolean isValidIdfaAvailable() {
        String idfa = getIdfa();
        return (idfa == null || DtbCommonUtils.isNullOrEmpty(idfa.trim()) || idfa.startsWith("0000")) ? false : true;
    }

    public void saveIdfa(String str) {
        if (str == null) {
            savePref(IDFA_PREF_NAME, "");
        } else {
            savePref(IDFA_PREF_NAME, str);
        }
    }

    public synchronized Boolean getOptOut() {
        if (!containsPreference(OO_PREF_NAME)) {
            return null;
        }
        return (Boolean) getPref(OO_PREF_NAME, Boolean.class);
    }

    public synchronized void saveOptOut(Boolean bool) {
        flushPreference(OO_PREF_NAME);
        if (bool != null) {
            savePref(OO_PREF_NAME, bool);
        }
    }

    public boolean getIsAdIdNew() {
        return ((Boolean) getPref(IS_ADID_NEW_PREF_NAME, Boolean.class)).booleanValue();
    }

    public void saveIsAdIdNew(boolean z) {
        savePref(IS_ADID_NEW_PREF_NAME, Boolean.valueOf(z));
    }

    public boolean getIsAdIdChanged() {
        return ((Boolean) getPref(IS_ADID_CHANGED_PREF_NAME, Boolean.class)).booleanValue();
    }

    public void saveIsAdIdChanged(boolean z) {
        savePref(IS_ADID_CHANGED_PREF_NAME, Boolean.valueOf(z));
    }

    public Long getSisLastCheckIn() {
        return (Long) getPref(SIS_LAST_CHECKIN_PREF_NAME, Long.class);
    }

    public void saveSisLastCheckIn(long j) {
        savePref(SIS_LAST_CHECKIN_PREF_NAME, Long.valueOf(j));
    }

    public Long getConfigLastCheckIn() {
        long jLongValue = ((Long) getPref(CONFIG_LAST_CHECKIN_PREF_NAME, Long.class)).longValue();
        if (jLongValue <= 0) {
            jLongValue = getSisLastCheckIn().longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public void saveConfigLastCheckIn(long j) {
        savePref(CONFIG_LAST_CHECKIN_PREF_NAME, Long.valueOf(j));
    }

    public void saveAaxHostname(String str) {
        saveHostName(str, AAX_HOSTNAME_PREF_NAME);
    }

    public void saveAaxVideoHostname(String str) {
        saveHostName(str, AAX_VIDEO_HOSTNAME_PREF_NAME);
    }

    private void saveHostName(String str, String str2) {
        if (!DtbCommonUtils.isNullOrEmpty(str)) {
            savePref(str2, str);
        } else {
            savePref(str2, DtbConstants.AAX_HOSTNAME);
        }
    }

    public String getAaxHostname() {
        String str = (String) getPref(AAX_HOSTNAME_PREF_NAME, String.class);
        if (!AdRegistration.isTestMode() || !DtbDebugProperties.isInternalDebugMode) {
            return DtbCommonUtils.isNullOrEmpty(str) ? DtbConstants.AAX_HOSTNAME : str;
        }
        if (str == null) {
            str = DtbConstants.AAX_HOSTNAME;
        }
        return DtbDebugProperties.getAaxHostName(str);
    }

    public String getAaxVideoHostName() {
        return (String) getPref(AAX_VIDEO_HOSTNAME_PREF_NAME, String.class);
    }

    public synchronized long getConfigTtlInMilliSeconds() {
        long jLongValue = ((Long) getPref(CONFIG_TTL_PREF_NAME, Long.class)).longValue();
        if (jLongValue < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
            return 172800000L;
        }
        return jLongValue;
    }

    public synchronized void saveConfigTtlInMilliSeconds(long j) {
        long j2 = j * 1000;
        try {
            if (j2 < PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS) {
                savePref(CONFIG_TTL_PREF_NAME, 172800000L);
            } else {
                savePref(CONFIG_TTL_PREF_NAME, Long.valueOf(j2));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean saveSisEndpoint(String str) {
        if (!DtbCommonUtils.isNullOrEmpty(str)) {
            String str2 = (String) getPref(SIS_ENDPOINT_PREF_NAME, String.class);
            String str3 = str + "/api3";
            if (str2 != null && str2.equals(str3)) {
                return false;
            }
            savePref(SIS_ENDPOINT_PREF_NAME, str3);
            return true;
        }
        savePref(SIS_ENDPOINT_PREF_NAME, DtbConstants.SIS_END_POINT + "/api3");
        return false;
    }

    public String getSisEndpoint() {
        String str = (String) getPref(SIS_ENDPOINT_PREF_NAME, String.class);
        return DtbCommonUtils.isNullOrEmpty(str) ? DtbConstants.SIS_END_POINT + "/api3" : str;
    }

    void saveWebResoucesLastPing(long j) {
        savePref(SIS_LAST_PING_WEB_RESOURCES, Long.valueOf(j));
    }

    Long getWebResoucesLastPing() {
        return (Long) getPref(SIS_LAST_PING_WEB_RESOURCES, Long.class);
    }

    void resetWebResoucesLastPing() {
        flushPreference(SIS_LAST_PING_WEB_RESOURCES);
    }

    void saveWrapperDetectionLastPing(long j) {
        savePref(SDK_WRAPPER_PING, Long.valueOf(j));
    }

    Long getWrapperDetectionLastPing() {
        return (Long) getPref(SDK_WRAPPER_PING, Long.class);
    }

    void resetWrapperDetectionLastPing() {
        flushPreference(SDK_WRAPPER_PING);
    }

    public void saveSisLastPing(long j) {
        savePref(SIS_LAST_PING_PREF_NAME, Long.valueOf(j));
    }

    public long getSisLastPing() {
        return ((Long) getPref(SIS_LAST_PING_PREF_NAME, Long.class)).longValue();
    }

    private static <T> void savePref(String str, T t) {
        if (isIgnore) {
            return;
        }
        apsInMemoryManager.putPref(str, t);
        savePrefInSys(str, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void savePrefInSys(String str, T t) {
        SharedPreferences sharedPreferences2;
        if (isIgnore || !ApsPrivacyManager.INSTANCE.isSystemResourceAccessAllowed() || (sharedPreferences2 = getSharedPreferences()) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
        if (t instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) t).booleanValue());
        } else if (t instanceof String) {
            editorEdit.putString(str, (String) t);
        } else if (t instanceof Integer) {
            editorEdit.putInt(str, ((Integer) t).intValue());
        } else if (t instanceof Float) {
            editorEdit.putFloat(str, ((Float) t).floatValue());
        } else if (t instanceof Long) {
            editorEdit.putLong(str, ((Long) t).longValue());
        } else if (t instanceof Set) {
            editorEdit.putStringSet(str, (Set) t);
        } else {
            throw new IllegalArgumentException("Saving of " + t.getClass() + " is not supported.");
        }
        editorEdit.apply();
    }

    private static <T> T getPref(String str, Class<T> cls) {
        if (isIgnore) {
            return null;
        }
        if (!apsInMemoryManager.contains(str)) {
            apsInMemoryManager.putPref(str, getPrefFromSys(str, cls));
        }
        return (T) apsInMemoryManager.getPrefWithDefault(str, cls);
    }

    private static <T> T getPrefFromSys(String str, Class<T> cls) {
        if (isIgnore || !ApsPrivacyManager.INSTANCE.isSystemResourceAccessAllowed()) {
            return null;
        }
        SharedPreferences sharedPreferences2 = getSharedPreferences();
        if (cls.isAssignableFrom(String.class)) {
            return (T) sharedPreferences2.getString(str, null);
        }
        if (cls.isAssignableFrom(Set.class)) {
            return (T) sharedPreferences2.getStringSet(str, null);
        }
        if (cls.isAssignableFrom(Boolean.class)) {
            return (T) Boolean.valueOf(sharedPreferences2.getBoolean(str, false));
        }
        if (cls.isAssignableFrom(Long.class)) {
            return (T) Long.valueOf(sharedPreferences2.getLong(str, 0L));
        }
        if (cls.isAssignableFrom(Integer.class)) {
            return (T) Integer.valueOf(sharedPreferences2.getInt(str, 0));
        }
        if (cls.isAssignableFrom(Float.class)) {
            return (T) Float.valueOf(sharedPreferences2.getFloat(str, 0.0f));
        }
        throw new IllegalArgumentException(cls.getName() + " is not supported");
    }

    private static boolean containsPreference(String str) {
        if (apsInMemoryManager.contains(str)) {
            return true;
        }
        if (ApsPrivacyManager.INSTANCE.isSystemResourceAccessAllowed()) {
            return getSharedPreferences().contains(str);
        }
        return false;
    }

    private static void flushPreference(String str) {
        if (ApsPrivacyManager.INSTANCE.isSystemResourceAccessAllowed()) {
            SharedPreferences sharedPreferences2 = getSharedPreferences();
            if (sharedPreferences2.contains(str)) {
                SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
                editorEdit.remove(str);
                editorEdit.apply();
            }
        }
        apsInMemoryManager.removePref(str);
    }

    public void saveVendorList(String str) {
        savePref(NON_IAB_VENDORLIST, str);
    }

    public String getVendorList() {
        return (String) getPref(NON_IAB_VENDORLIST, String.class);
    }

    public void saveConsentStatus(String str) {
        savePref(NON_IAB_CONSENT_STATUS, str);
    }

    public String getConsentStatus() {
        return (String) getPref(NON_IAB_CONSENT_STATUS, String.class);
    }

    public void saveCMPFlavor(String str) {
        savePref(NON_IAB_CMP_FLAVOR, str);
    }

    public String getCMPFlavor() {
        return (String) getPref(NON_IAB_CMP_FLAVOR, String.class);
    }

    public void saveNonIABCustomConsent(String str) {
        savePref(NON_IAB_CUSTOM_CONSENT, str);
    }

    public String getNonIABCustomConsent() {
        return (String) getPref(NON_IAB_CUSTOM_CONSENT, String.class);
    }

    public void removeVendorList() {
        flushPreference(NON_IAB_VENDORLIST);
    }

    public void removeCMPFlavor() {
        flushPreference(NON_IAB_CMP_FLAVOR);
    }

    public void removeConsentStatus() {
        flushPreference(NON_IAB_CONSENT_STATUS);
    }

    public void removeNonIABCustomConsent() {
        flushPreference(NON_IAB_CUSTOM_CONSENT);
    }

    public void savePJTemplate(JSONObject jSONObject) {
        if (jSONObject != null) {
            savePref(PJ_TEMPLATE_PREF_NAME, jSONObject.toString());
        }
    }

    public JSONObject getPJTemplate() {
        try {
            return new JSONObject((String) getPref(PJ_TEMPLATE_PREF_NAME, String.class));
        } catch (Exception unused) {
            JSONObject jSONObject = new JSONObject();
            DtbLog.warn(LOG_TAG, "Get Pj template failed when fetching from Cache");
            return jSONObject;
        }
    }

    public void removePJTemplate() {
        flushPreference(PJ_TEMPLATE_PREF_NAME);
    }

    public void saveBidTimeout(Integer num) {
        savePref(BID_TIMEOUT_PREF_NAME, num);
    }

    public int getBidTimeout() {
        Integer num = (Integer) getPref(BID_TIMEOUT_PREF_NAME, Integer.class);
        if (num == null || num.intValue() == 0) {
            return 5000;
        }
        return num.intValue();
    }

    public void removeBidTimeout() {
        flushPreference(BID_TIMEOUT_PREF_NAME);
    }

    synchronized void savePrivacyLocationConfig(JSONObject jSONObject) {
        try {
            savePref(PRIVACY_LOCATION_MODE_PREF_NAME, jSONObject.getString(b9.a.t));
            savePref(PRIVACY_LOCATION_ACCURACY_IN_METERS_PREF_NAME, Float.valueOf((float) jSONObject.getDouble("accuracyInMeters")));
        } catch (JSONException unused) {
            DtbLog.error(LOG_TAG, "Failed to save privacy configurations in shared preferences");
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    synchronized PrivacyLocationMode getPrivacyLocationConfigMode() {
        byte b;
        String str = (String) getPref(PRIVACY_LOCATION_MODE_PREF_NAME, String.class);
        if (!DtbCommonUtils.isNullOrEmpty(str)) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1679810537) {
                if (iHashCode == 67893076 && str.equals("Fixed")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("Compute")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                return PrivacyLocationMode.FIXED;
            }
            if (b == 1) {
                return PrivacyLocationMode.COMPUTE;
            }
        }
        return PrivacyLocationMode.RESTRICTED;
    }

    synchronized float getPrivacyLocationConfigAccuracyInMeters() {
        Float f = (Float) getPref(PRIVACY_LOCATION_ACCURACY_IN_METERS_PREF_NAME, Float.class);
        if (f == null) {
            return Float.MAX_VALUE;
        }
        return f.floatValue();
    }

    synchronized void removePrivacyLocationConfig() {
        flushPreference(PRIVACY_LOCATION_MODE_PREF_NAME);
        flushPreference(PRIVACY_LOCATION_ACCURACY_IN_METERS_PREF_NAME);
    }
}
