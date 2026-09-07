package com.smaato.sdk.core.gdpr;

import android.content.SharedPreferences;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes13.dex */
public class IabCmpV2DataStorage implements IabCmpDataStorage {
    private final SharedPreferences defaultSharedPreferences;

    @Override // com.smaato.sdk.core.gdpr.IabCmpDataStorage
    public int getConsentVersion() {
        return 2;
    }

    public IabCmpV2DataStorage(SharedPreferences sharedPreferences) {
        this.defaultSharedPreferences = (SharedPreferences) Objects.requireNonNull(sharedPreferences, "defaultSharedPreferences must not be null for IabCmpV2DataStorage::new");
    }

    @Override // com.smaato.sdk.core.gdpr.IabCmpDataStorage
    public CmpData getCmpData() {
        return CmpV2Data.buildEmpty(isCmpPresent(), getSubjectToGdpr(), getConsentString()).build();
    }

    @Override // com.smaato.sdk.core.gdpr.IabCmpDataStorage
    public SubjectToGdpr getSubjectToGdpr() {
        String asString = getAsString("IABTCF_gdprApplies", null);
        for (SubjectToGdpr subjectToGdpr : SubjectToGdpr.values()) {
            if (subjectToGdpr.id.equals(asString)) {
                return subjectToGdpr;
            }
        }
        return SubjectToGdpr.CMP_GDPR_UNKNOWN;
    }

    @Override // com.smaato.sdk.core.gdpr.IabCmpDataStorage
    public String getConsentString() {
        return getAsString("IABTCF_TCString", "");
    }

    @Override // com.smaato.sdk.core.gdpr.IabCmpDataStorage
    public boolean isCmpPresent() {
        return this.defaultSharedPreferences.contains("IABTCF_TCString");
    }

    @Override // com.smaato.sdk.core.gdpr.IabCmpDataStorage
    public String getVendorsString() {
        return getAsString(CmpApiConstants.IABTCF_VENDOR_CONSENT, "");
    }

    @Override // com.smaato.sdk.core.gdpr.IabCmpDataStorage
    public String getPurposesString() {
        return getAsString(CmpApiConstants.IABTCF_PURPOSE_CONSENTS, "");
    }

    public String getSdkId() {
        return getAsString(CmpApiConstants.IABTCF_CMP_SDK_ID, "");
    }

    public String getCmpSdkVersion() {
        return getAsString(CmpApiConstants.IABTCF_CMP_SDK_VERSION, "");
    }

    public String getPolicyVersion() {
        return getAsString(CmpApiConstants.IABTCF_POLICY_VERSION, "");
    }

    public String getPublisherCC() {
        return getAsString(CmpApiConstants.IABTCF_PUBLISHER_CC, "AA");
    }

    public String getPurposeOneTreatment() {
        return getAsString(CmpApiConstants.IABTCF_PURPOSE_ONE_TREATMENT, "");
    }

    public String getUseNonStandardStacks() {
        return getAsString(CmpApiConstants.IABTCF_USE_NON_STANDARD_STACKS, "");
    }

    public String getVendorLegitimateInterests() {
        return getAsString(CmpApiConstants.IABTCF_VENDOR_LEGITIMATE_INTERESTS, "");
    }

    public String getPurposeLegitimateInterests() {
        return getAsString(CmpApiConstants.IABTCF_PURPOSE_LEGITIMATE_INTERESTS, "");
    }

    public String getSpecialFeaturesOptIns() {
        return getAsString(CmpApiConstants.IABTCF_SPECIAL_FEATURES_OPT_INS, "");
    }

    public String getPublisherRestrictions() {
        return getAsString(CmpApiConstants.IABTCF_PUBLISHER_RERSTRICTIONS, "");
    }

    public String getPublisherConsent() {
        return getAsString(CmpApiConstants.IABTCF_PUBLISHER_CONSENT, "");
    }

    public String getPublisherLegitimateInterests() {
        return getAsString(CmpApiConstants.IABTCF_PUBLISHER_LEGITIMATE_INTERESTS, "");
    }

    public String getPublisherCustomPurposesConsents() {
        return getAsString(CmpApiConstants.IABTCF_PUBLISHER_CUSTOM_PURPOSES_CONSENTS, "");
    }

    public String getPublisherCustomPurposesLegitimateInterests() {
        return getAsString(CmpApiConstants.IABTCF_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS, "");
    }

    public boolean isVendorConsentGivenForVendorId(int i) {
        String vendorsString = getVendorsString();
        return i > 0 && vendorsString.length() >= i && vendorsString.charAt(i - 1) == '1';
    }

    public boolean isVendorLegitimateInterestsGivenForVendorId(int i) {
        String vendorLegitimateInterests = getVendorLegitimateInterests();
        return i > 0 && vendorLegitimateInterests.length() >= i && vendorLegitimateInterests.charAt(i - 1) == '1';
    }

    public boolean isPurposeLegitimateInterestsGivenForVendorId(int i) {
        String purposeLegitimateInterests = getPurposeLegitimateInterests();
        return i > 0 && purposeLegitimateInterests.length() >= i && purposeLegitimateInterests.charAt(i - 1) == '1';
    }

    public boolean isPurposeConsentGivenForPurposeId(int i) {
        String purposesString = getPurposesString();
        return i > 0 && purposesString.length() >= i && purposesString.charAt(i - 1) == '1';
    }

    private String getAsString(String str, String str2) {
        Object obj = this.defaultSharedPreferences.getAll().get(str);
        if (obj == null) {
            return str2;
        }
        if (obj instanceof String) {
            String str3 = (String) obj;
            if ("true".equals(str3)) {
                return "1";
            }
            return "false".equals(str3) ? "0" : str3;
        }
        return String.valueOf(obj);
    }
}
