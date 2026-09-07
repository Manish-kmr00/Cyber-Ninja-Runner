package io.bidmachine;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.utils.SharedPreferenceUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
class IABSharedPreferenceImpl implements IABSharedPreference {
    private String iabGDPRConsentString;
    private List<Integer> iabGPPIds;
    private String iabGPPString;
    private Boolean iabSubjectToGDPR;
    private Boolean iabTcfGdprApplies;
    private String iabTcfTcString;
    private String iabUSPrivacyString;
    private final SharedPreferences.OnSharedPreferenceChangeListener sharedPreferenceListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: io.bidmachine.IABSharedPreferenceImpl.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            IABSharedPreferenceImpl.this.updateMapper(sharedPreferences, str);
        }
    };

    IABSharedPreferenceImpl() {
    }

    @Override // io.bidmachine.IABSharedPreference
    public void initialize(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this.sharedPreferenceListener);
        for (String str : IAB_KEY_ARRAY) {
            updateMapper(defaultSharedPreferences, str);
        }
    }

    @Override // io.bidmachine.IABSharedPreference
    public Boolean getSubjectToGDPR() {
        return this.iabSubjectToGDPR;
    }

    @Override // io.bidmachine.IABSharedPreference
    public Boolean getTcfGdprApplies() {
        return this.iabTcfGdprApplies;
    }

    @Override // io.bidmachine.IABSharedPreference
    public String getGDPRConsentString() {
        return this.iabGDPRConsentString;
    }

    @Override // io.bidmachine.IABSharedPreference
    public String getTcfTcString() {
        return this.iabTcfTcString;
    }

    @Override // io.bidmachine.IABSharedPreference
    public String getUSPrivacyString() {
        return this.iabUSPrivacyString;
    }

    @Override // io.bidmachine.IABSharedPreference
    public String getGPPString() {
        return this.iabGPPString;
    }

    @Override // io.bidmachine.IABSharedPreference
    public List<Integer> getGPPIds() {
        return this.iabGPPIds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMapper(SharedPreferences sharedPreferences, String str) {
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "IABTCF_gdprApplies":
                updateTcfGdprApplies(sharedPreferences);
                break;
            case "IABGPP_GppSID":
                updateGPPIds(sharedPreferences);
                break;
            case "IABUSPrivacy_String":
                updateUSPrivacyString(sharedPreferences);
                break;
            case "IABConsent_ConsentString":
                updateConsentString(sharedPreferences);
                break;
            case "IABTCF_TCString":
                updateTcfTcString(sharedPreferences);
                break;
            case "IABConsent_SubjectToGDPR":
                updateGDPRSubject(sharedPreferences);
                break;
            case "IABGPP_HDR_GppString":
                updateGPPString(sharedPreferences);
                break;
        }
    }

    private void updateGDPRSubject(SharedPreferences sharedPreferences) {
        String strOptString = SharedPreferenceUtils.optString(sharedPreferences, IABSharedPreference.IAB_SUBJECT_TO_GDPR, null);
        this.iabSubjectToGDPR = strOptString != null ? Boolean.valueOf(strOptString.equals("1")) : null;
    }

    private void updateTcfGdprApplies(SharedPreferences sharedPreferences) {
        int iOptInt = SharedPreferenceUtils.optInt(sharedPreferences, "IABTCF_gdprApplies", -1);
        if (iOptInt == 1) {
            this.iabTcfGdprApplies = true;
        } else if (iOptInt == 0) {
            this.iabTcfGdprApplies = false;
        } else {
            this.iabTcfGdprApplies = null;
        }
    }

    private void updateConsentString(SharedPreferences sharedPreferences) {
        this.iabGDPRConsentString = SharedPreferenceUtils.optString(sharedPreferences, IABSharedPreference.IAB_CONSENT_STRING, null);
    }

    private void updateTcfTcString(SharedPreferences sharedPreferences) {
        this.iabTcfTcString = SharedPreferenceUtils.optString(sharedPreferences, "IABTCF_TCString", null);
    }

    private void updateUSPrivacyString(SharedPreferences sharedPreferences) {
        this.iabUSPrivacyString = SharedPreferenceUtils.optString(sharedPreferences, "IABUSPrivacy_String", null);
    }

    private void updateGPPString(SharedPreferences sharedPreferences) {
        this.iabGPPString = SharedPreferenceUtils.optString(sharedPreferences, "IABGPP_HDR_GppString", null);
    }

    private void updateGPPIds(SharedPreferences sharedPreferences) {
        String strOptString = SharedPreferenceUtils.optString(sharedPreferences, "IABGPP_GppSID", null);
        if (TextUtils.isEmpty(strOptString)) {
            this.iabGPPIds = null;
            return;
        }
        try {
            String[] strArrSplit = strOptString.split("_");
            if (strArrSplit.length == 0) {
                this.iabGPPIds = null;
                return;
            }
            this.iabGPPIds = new ArrayList();
            for (String str : strArrSplit) {
                Integer intOrDefault = Utils.parseIntOrDefault(str, (Integer) null);
                if (intOrDefault != null) {
                    this.iabGPPIds.add(intOrDefault);
                }
            }
        } catch (Throwable th) {
            Logger.w(th);
            this.iabGPPIds = null;
        }
    }
}
