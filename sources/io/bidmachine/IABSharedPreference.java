package io.bidmachine;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
interface IABSharedPreference {
    public static final String IAB_GPP_HDR_STRING = "IABGPP_HDR_GppString";
    public static final String IAB_GPP_SID = "IABGPP_GppSID";
    public static final String IAB_TCF_GDPR_APPLIES = "IABTCF_gdprApplies";
    public static final String IAB_TCF_TC_STRING = "IABTCF_TCString";
    public static final String IAB_US_PRIVACY_STRING = "IABUSPrivacy_String";
    public static final String IAB_SUBJECT_TO_GDPR = "IABConsent_SubjectToGDPR";
    public static final String IAB_CONSENT_STRING = "IABConsent_ConsentString";
    public static final String[] IAB_KEY_ARRAY = {IAB_SUBJECT_TO_GDPR, "IABTCF_gdprApplies", IAB_CONSENT_STRING, "IABTCF_TCString", "IABUSPrivacy_String", "IABGPP_HDR_GppString", "IABGPP_GppSID"};

    String getGDPRConsentString();

    List<Integer> getGPPIds();

    String getGPPString();

    Boolean getSubjectToGDPR();

    Boolean getTcfGdprApplies();

    String getTcfTcString();

    String getUSPrivacyString();

    void initialize(Context context);
}
