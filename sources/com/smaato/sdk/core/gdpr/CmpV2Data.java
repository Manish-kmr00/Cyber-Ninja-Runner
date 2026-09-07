package com.smaato.sdk.core.gdpr;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public abstract class CmpV2Data implements CmpData {

    public static abstract class Builder {
        public abstract CmpV2Data build();

        public abstract Builder setCmpPresent(boolean z);

        public abstract Builder setCmpSdkVersion(String str);

        public abstract Builder setConsentString(String str);

        public abstract Builder setPolicyVersion(String str);

        public abstract Builder setPublisherCC(String str);

        public abstract Builder setPublisherConsent(Set<Integer> set);

        public abstract Builder setPublisherCustomPurposesConsents(Set<Integer> set);

        public abstract Builder setPublisherCustomPurposesLegitimateInterests(Set<Integer> set);

        public abstract Builder setPublisherLegitimateInterests(Set<Integer> set);

        public abstract Builder setPublisherRestrictions(String str);

        public abstract Builder setPurposeLegitimateInterests(Set<Integer> set);

        public abstract Builder setPurposeOneTreatment(Boolean bool);

        public abstract Builder setPurposesConsent(Set<Integer> set);

        public abstract Builder setSdkId(String str);

        public abstract Builder setSpecialFeaturesOptIns(Set<Integer> set);

        public abstract Builder setSubjectToGdpr(SubjectToGdpr subjectToGdpr);

        public abstract Builder setUseNonStandardStacks(Boolean bool);

        public abstract Builder setVendorConsent(Set<Integer> set);

        public abstract Builder setVendorLegitimateInterests(Set<Integer> set);
    }

    public abstract String getCmpSdkVersion();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract String getConsentString();

    public abstract String getPolicyVersion();

    public abstract String getPublisherCC();

    public abstract Set<Integer> getPublisherConsent();

    public abstract Set<Integer> getPublisherCustomPurposesConsents();

    public abstract Set<Integer> getPublisherCustomPurposesLegitimateInterests();

    public abstract Set<Integer> getPublisherLegitimateInterests();

    public abstract String getPublisherRestrictions();

    public abstract Set<Integer> getPurposeLegitimateInterests();

    public abstract Boolean getPurposeOneTreatment();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract Set<Integer> getPurposesConsent();

    public abstract String getSdkId();

    public abstract Set<Integer> getSpecialFeaturesOptIns();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract SubjectToGdpr getSubjectToGdpr();

    public abstract Boolean getUseNonStandardStacks();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract Set<Integer> getVendorConsent();

    public abstract Set<Integer> getVendorLegitimateInterests();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract boolean isCmpPresent();

    public static Builder builder() {
        return new AutoValue_CmpV2Data.Builder();
    }

    public static Builder buildEmpty(boolean z, SubjectToGdpr subjectToGdpr, String str) {
        Builder publisherCC = new AutoValue_CmpV2Data.Builder().setCmpPresent(z).setSubjectToGdpr(subjectToGdpr).setConsentString(str).setVendorConsent(new HashSet()).setPurposesConsent(new HashSet()).setSdkId("").setCmpSdkVersion("").setPolicyVersion("").setPublisherCC("");
        Boolean bool = Boolean.FALSE;
        return publisherCC.setPurposeOneTreatment(bool).setUseNonStandardStacks(bool).setVendorLegitimateInterests(new HashSet()).setPurposeLegitimateInterests(new HashSet()).setSpecialFeaturesOptIns(new HashSet()).setPublisherConsent(new HashSet()).setPublisherLegitimateInterests(new HashSet()).setPublisherLegitimateInterests(new HashSet()).setPublisherLegitimateInterests(new HashSet());
    }
}
