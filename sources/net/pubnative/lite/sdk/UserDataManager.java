package net.pubnative.lite.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.concurrent.RejectedExecutionException;
import net.pubnative.lite.sdk.consent.UserConsentActivity;
import net.pubnative.lite.sdk.utils.HyBidAdvertisingId;

/* JADX INFO: loaded from: classes8.dex */
public class UserDataManager {
    private static final int CONSENT_STATE_ACCEPTED = 1;
    private static final int CONSENT_STATE_DENIED = 0;
    private static final String KEY_CCPA_CONSENT = "ccpa_consent";
    private static final String KEY_CCPA_PUBLIC_CONSENT = "IABUSPrivacy_String";
    private static final String KEY_GDPR_ADVERTISING_ID = "gdpr_advertising_id";
    private static final String KEY_GDPR_APPLIES = "IABTCF_gdprApplies";
    private static final String KEY_GDPR_CONSENT = "gdpr_consent";
    private static final String KEY_GDPR_CONSENT_STATE = "gdpr_consent_state";
    private static final String KEY_GDPR_PUBLIC_CONSENT = "IABConsent_ConsentString";
    private static final String KEY_GDPR_TCF_2_PUBLIC_CONSENT = "IABTCF_TCString";
    private static final String KEY_GPP_ID = "gpp_id";
    private static final String KEY_GPP_STRING = "gpp_string";
    private static final String KEY_PUBLIC_GPP_ID = "IABGPP_GppSID";
    private static final String KEY_PUBLIC_GPP_STRING = "IABGPP_HDR_GppString";
    private static final String PREFERENCES_CONSENT = "net.pubnative.lite.dataconsent";
    private static final String TAG = "UserDataManager";
    private final SharedPreferences mAppPreferences;
    private final SharedPreferences.OnSharedPreferenceChangeListener mAppPrefsListener;
    private final Context mContext;
    private final SharedPreferences mPreferences;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.C);
        p0.startActivity(p1);
    }

    public UserDataManager(Context context) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: net.pubnative.lite.sdk.UserDataManager.1
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                str.hashCode();
                switch (str) {
                    case "IABGPP_GppSID":
                        String publicGppId = UserDataManager.this.getPublicGppId(sharedPreferences);
                        if (!TextUtils.isEmpty(publicGppId)) {
                            UserDataManager.this.setGppSid(publicGppId);
                            break;
                        } else {
                            UserDataManager.this.removeGppSid();
                            break;
                        }
                        break;
                    case "IABUSPrivacy_String":
                        String publicCCPAConsent = UserDataManager.this.getPublicCCPAConsent(sharedPreferences);
                        if (!TextUtils.isEmpty(publicCCPAConsent)) {
                            UserDataManager.this.setIABUSPrivacyString(publicCCPAConsent);
                            break;
                        } else {
                            UserDataManager.this.removeIABUSPrivacyString();
                            break;
                        }
                        break;
                    case "IABConsent_ConsentString":
                        String publicTCFConsent = UserDataManager.this.getPublicTCFConsent(sharedPreferences);
                        if (!TextUtils.isEmpty(publicTCFConsent)) {
                            UserDataManager.this.setIABGDPRConsentString(publicTCFConsent);
                            break;
                        } else {
                            UserDataManager.this.removeIABGDPRConsentString();
                            break;
                        }
                        break;
                    case "IABTCF_TCString":
                        String publicTCF2Consent = UserDataManager.this.getPublicTCF2Consent(sharedPreferences);
                        if (!TextUtils.isEmpty(publicTCF2Consent)) {
                            UserDataManager.this.setIABGDPRConsentString(publicTCF2Consent);
                            break;
                        } else {
                            UserDataManager.this.removeIABGDPRConsentString();
                            break;
                        }
                        break;
                    case "IABGPP_HDR_GppString":
                        String publicGppString = UserDataManager.this.getPublicGppString(sharedPreferences);
                        if (!TextUtils.isEmpty(publicGppString)) {
                            UserDataManager.this.setGppString(publicGppString);
                            break;
                        } else {
                            UserDataManager.this.removeGppString();
                            break;
                        }
                        break;
                }
            }
        };
        this.mAppPrefsListener = onSharedPreferenceChangeListener;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mPreferences = applicationContext.getSharedPreferences(PREFERENCES_CONSENT, 0);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext.getApplicationContext());
        this.mAppPreferences = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
        updatePublicConsent(defaultSharedPreferences);
    }

    @Deprecated
    public String getConsentPageLink() {
        return "https://cdn.pubnative.net/static/consent/consent.html";
    }

    @Deprecated
    public String getPrivacyPolicyLink() {
        return "https://pubnative.net/privacy-notice/";
    }

    @Deprecated
    public String getVendorListLink() {
        return "https://pubnative.net/monetization-partners/";
    }

    @Deprecated
    public boolean shouldAskConsent() {
        return gdprApplies() && !askedForGDPRConsent();
    }

    public boolean canCollectData() {
        if (gdprApplies()) {
            return askedForGDPRConsent() && this.mPreferences.getInt(KEY_GDPR_CONSENT_STATE, 0) == 1;
        }
        return true;
    }

    public boolean isConsentDenied() {
        return this.mPreferences.contains(KEY_GDPR_CONSENT_STATE) && this.mPreferences.getInt(KEY_GDPR_CONSENT_STATE, 0) == 0;
    }

    @Deprecated
    public void grantConsent() {
        processConsent(true);
    }

    @Deprecated
    public void denyConsent() {
        processConsent(false);
    }

    @Deprecated
    public void revokeConsent() {
        denyConsent();
    }

    private void processConsent(final boolean z) {
        String advertisingId = HyBid.getDeviceInfo().getAdvertisingId();
        if (!TextUtils.isEmpty(advertisingId)) {
            notifyConsentGiven(advertisingId, z);
            return;
        }
        try {
            new HyBidAdvertisingId(this.mContext).execute(new HyBidAdvertisingId.Listener() { // from class: net.pubnative.lite.sdk.UserDataManager$$ExternalSyntheticLambda0
                @Override // net.pubnative.lite.sdk.utils.HyBidAdvertisingId.Listener
                public final void onHyBidAdvertisingIdFinish(String str, Boolean bool) {
                    this.f$0.m9530lambda$processConsent$0$netpubnativelitesdkUserDataManager(z, str, bool);
                }
            });
        } catch (RejectedExecutionException e) {
            net.pubnative.lite.sdk.utils.Logger.e(TAG, "processConsent", e);
            HyBid.reportException((Exception) e);
        } catch (Exception e2) {
            net.pubnative.lite.sdk.utils.Logger.e(TAG, "Error executing HyBidAdvertisingId AsyncTask");
            HyBid.reportException(e2);
        }
    }

    /* JADX INFO: renamed from: lambda$processConsent$0$net-pubnative-lite-sdk-UserDataManager, reason: not valid java name */
    /* synthetic */ void m9530lambda$processConsent$0$netpubnativelitesdkUserDataManager(boolean z, String str, Boolean bool) {
        if (TextUtils.isEmpty(str)) {
            net.pubnative.lite.sdk.utils.Logger.e(TAG, "Consent request failed with an empty advertising ID.");
        } else {
            notifyConsentGiven(str, z);
        }
    }

    private void notifyConsentGiven(String str, boolean z) {
        setConsentState(z ? 1 : 0);
    }

    public boolean gdprApplies() {
        int i;
        try {
            i = Integer.parseInt(this.mAppPreferences.getString("IABTCF_gdprApplies", "0"));
        } catch (Exception unused) {
            i = this.mAppPreferences.getInt("IABTCF_gdprApplies", 0);
        }
        return i == 1;
    }

    private boolean askedForGDPRConsent() {
        boolean zContains = this.mPreferences.contains(KEY_GDPR_CONSENT_STATE);
        if (!zContains) {
            return zContains;
        }
        String string = this.mPreferences.getString(KEY_GDPR_ADVERTISING_ID, "");
        if (TextUtils.isEmpty(string) || string.equals(HyBid.getDeviceInfo().getAdvertisingId())) {
            return zContains;
        }
        return false;
    }

    @Deprecated
    public void showConsentRequestScreen(Context context) {
        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(context, getConsentScreenIntent(context));
    }

    @Deprecated
    public Intent getConsentScreenIntent(Context context) {
        return new Intent(context, (Class<?>) UserConsentActivity.class);
    }

    private void setConsentState(int i) {
        if (i != 1 && i != 0) {
            throw new RuntimeException("Illegal consent state provided");
        }
        SharedPreferences.Editor editorEdit = this.mPreferences.edit();
        editorEdit.putString(KEY_GDPR_ADVERTISING_ID, HyBid.getDeviceInfo().getAdvertisingId());
        editorEdit.putInt(KEY_GDPR_CONSENT_STATE, i);
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPublicTCFConsent(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("IABConsent_ConsentString", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPublicTCF2Consent(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("IABTCF_TCString", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPublicCCPAConsent(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("IABUSPrivacy_String", "");
    }

    private void updatePublicConsent(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            String publicTCF2Consent = getPublicTCF2Consent(sharedPreferences);
            String publicTCFConsent = getPublicTCFConsent(sharedPreferences);
            String publicCCPAConsent = getPublicCCPAConsent(sharedPreferences);
            String publicGppString = getPublicGppString(sharedPreferences);
            String publicGppId = getPublicGppId(sharedPreferences);
            if (!TextUtils.isEmpty(publicTCF2Consent)) {
                setIABGDPRConsentString(publicTCF2Consent);
            } else if (!TextUtils.isEmpty(publicTCFConsent)) {
                setIABGDPRConsentString(publicTCFConsent);
            }
            if (!TextUtils.isEmpty(publicCCPAConsent)) {
                setIABUSPrivacyString(publicCCPAConsent);
            }
            if (!TextUtils.isEmpty(publicGppString)) {
                setGppString(publicGppString);
            }
            if (TextUtils.isEmpty(publicGppId)) {
                return;
            }
            setGppSid(publicGppId);
        }
    }

    public void setIABUSPrivacyString(String str) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(KEY_CCPA_CONSENT, str).apply();
        }
    }

    public String getIABUSPrivacyString() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(KEY_CCPA_CONSENT, null);
        }
        return null;
    }

    public void removeIABUSPrivacyString() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(KEY_CCPA_CONSENT).apply();
        }
    }

    public boolean isCCPAOptOut() {
        String iABUSPrivacyString = getIABUSPrivacyString();
        if (TextUtils.isEmpty(iABUSPrivacyString) || iABUSPrivacyString.length() < 3) {
            return false;
        }
        char cCharAt = iABUSPrivacyString.charAt(2);
        return cCharAt == 'y' || cCharAt == 'Y';
    }

    public void setIABGDPRConsentString(String str) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("gdpr_consent", str).apply();
        }
    }

    public String getIABGDPRConsentString() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences == null) {
            return null;
        }
        String string = sharedPreferences.getString("gdpr_consent", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = this.mAppPreferences.getString("IABTCF_TCString", null);
        return TextUtils.isEmpty(string2) ? this.mAppPreferences.getString("IABConsent_ConsentString", null) : string2;
    }

    public void removeIABGDPRConsentString() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("gdpr_consent").apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPublicGppString(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("IABGPP_HDR_GppString", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPublicGppId(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("IABGPP_GppSID", null);
    }

    public String getGppString() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(KEY_GPP_STRING, null);
        }
        return null;
    }

    public void setGppString(String str) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(KEY_GPP_STRING, str).apply();
        }
    }

    public void removeGppString() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(KEY_GPP_STRING).apply();
        }
    }

    public String getGppSid() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(KEY_GPP_ID, null);
        }
        return null;
    }

    public void setGppSid(String str) {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(KEY_GPP_ID, str).apply();
        }
    }

    public void removeGppSid() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(KEY_GPP_ID).apply();
        }
    }

    public void removeGppData() {
        SharedPreferences sharedPreferences = this.mPreferences;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove(KEY_GPP_STRING).apply();
            this.mPreferences.edit().remove(KEY_GPP_ID).apply();
        }
    }
}
