package com.smaato.sdk.core.gdpr;

import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_CmpV2Data extends CmpV2Data {
    private final boolean cmpPresent;
    private final String cmpSdkVersion;
    private final String consentString;
    private final String policyVersion;
    private final String publisherCC;
    private final Set publisherConsent;
    private final Set publisherCustomPurposesConsents;
    private final Set publisherCustomPurposesLegitimateInterests;
    private final Set publisherLegitimateInterests;
    private final String publisherRestrictions;
    private final Set purposeLegitimateInterests;
    private final Boolean purposeOneTreatment;
    private final Set purposesConsent;
    private final String sdkId;
    private final Set specialFeaturesOptIns;
    private final SubjectToGdpr subjectToGdpr;
    private final Boolean useNonStandardStacks;
    private final Set vendorConsent;
    private final Set vendorLegitimateInterests;

    private AutoValue_CmpV2Data(boolean z, SubjectToGdpr subjectToGdpr, String str, Set set, Set set2, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, Set set3, Set set4, Set set5, String str6, Set set6, Set set7, Set set8, Set set9) {
        this.cmpPresent = z;
        this.subjectToGdpr = subjectToGdpr;
        this.consentString = str;
        this.vendorConsent = set;
        this.purposesConsent = set2;
        this.sdkId = str2;
        this.cmpSdkVersion = str3;
        this.policyVersion = str4;
        this.publisherCC = str5;
        this.purposeOneTreatment = bool;
        this.useNonStandardStacks = bool2;
        this.vendorLegitimateInterests = set3;
        this.purposeLegitimateInterests = set4;
        this.specialFeaturesOptIns = set5;
        this.publisherRestrictions = str6;
        this.publisherConsent = set6;
        this.publisherLegitimateInterests = set7;
        this.publisherCustomPurposesConsents = set8;
        this.publisherCustomPurposesLegitimateInterests = set9;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data, com.smaato.sdk.core.gdpr.CmpData
    public boolean isCmpPresent() {
        return this.cmpPresent;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data, com.smaato.sdk.core.gdpr.CmpData
    public SubjectToGdpr getSubjectToGdpr() {
        return this.subjectToGdpr;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data, com.smaato.sdk.core.gdpr.CmpData
    public String getConsentString() {
        return this.consentString;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data, com.smaato.sdk.core.gdpr.CmpData
    public Set<Integer> getVendorConsent() {
        return this.vendorConsent;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data, com.smaato.sdk.core.gdpr.CmpData
    public Set<Integer> getPurposesConsent() {
        return this.purposesConsent;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public String getSdkId() {
        return this.sdkId;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public String getCmpSdkVersion() {
        return this.cmpSdkVersion;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public String getPolicyVersion() {
        return this.policyVersion;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public String getPublisherCC() {
        return this.publisherCC;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Boolean getPurposeOneTreatment() {
        return this.purposeOneTreatment;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Boolean getUseNonStandardStacks() {
        return this.useNonStandardStacks;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Set<Integer> getVendorLegitimateInterests() {
        return this.vendorLegitimateInterests;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Set<Integer> getPurposeLegitimateInterests() {
        return this.purposeLegitimateInterests;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Set<Integer> getSpecialFeaturesOptIns() {
        return this.specialFeaturesOptIns;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public String getPublisherRestrictions() {
        return this.publisherRestrictions;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Set<Integer> getPublisherConsent() {
        return this.publisherConsent;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Set<Integer> getPublisherLegitimateInterests() {
        return this.publisherLegitimateInterests;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Set<Integer> getPublisherCustomPurposesConsents() {
        return this.publisherCustomPurposesConsents;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV2Data
    public Set<Integer> getPublisherCustomPurposesLegitimateInterests() {
        return this.publisherCustomPurposesLegitimateInterests;
    }

    public String toString() {
        return "CmpV2Data{cmpPresent=" + this.cmpPresent + ", subjectToGdpr=" + this.subjectToGdpr + ", consentString=" + this.consentString + ", vendorConsent=" + this.vendorConsent + ", purposesConsent=" + this.purposesConsent + ", sdkId=" + this.sdkId + ", cmpSdkVersion=" + this.cmpSdkVersion + ", policyVersion=" + this.policyVersion + ", publisherCC=" + this.publisherCC + ", purposeOneTreatment=" + this.purposeOneTreatment + ", useNonStandardStacks=" + this.useNonStandardStacks + ", vendorLegitimateInterests=" + this.vendorLegitimateInterests + ", purposeLegitimateInterests=" + this.purposeLegitimateInterests + ", specialFeaturesOptIns=" + this.specialFeaturesOptIns + ", publisherRestrictions=" + this.publisherRestrictions + ", publisherConsent=" + this.publisherConsent + ", publisherLegitimateInterests=" + this.publisherLegitimateInterests + ", publisherCustomPurposesConsents=" + this.publisherCustomPurposesConsents + ", publisherCustomPurposesLegitimateInterests=" + this.publisherCustomPurposesLegitimateInterests + "}";
    }

    public boolean equals(Object obj) {
        String str;
        Set set;
        Set set2;
        Set set3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CmpV2Data)) {
            return false;
        }
        CmpV2Data cmpV2Data = (CmpV2Data) obj;
        if (this.cmpPresent == cmpV2Data.isCmpPresent() && this.subjectToGdpr.equals(cmpV2Data.getSubjectToGdpr()) && this.consentString.equals(cmpV2Data.getConsentString()) && this.vendorConsent.equals(cmpV2Data.getVendorConsent()) && this.purposesConsent.equals(cmpV2Data.getPurposesConsent()) && this.sdkId.equals(cmpV2Data.getSdkId()) && this.cmpSdkVersion.equals(cmpV2Data.getCmpSdkVersion()) && this.policyVersion.equals(cmpV2Data.getPolicyVersion()) && this.publisherCC.equals(cmpV2Data.getPublisherCC()) && this.purposeOneTreatment.equals(cmpV2Data.getPurposeOneTreatment()) && this.useNonStandardStacks.equals(cmpV2Data.getUseNonStandardStacks()) && this.vendorLegitimateInterests.equals(cmpV2Data.getVendorLegitimateInterests()) && this.purposeLegitimateInterests.equals(cmpV2Data.getPurposeLegitimateInterests()) && this.specialFeaturesOptIns.equals(cmpV2Data.getSpecialFeaturesOptIns()) && ((str = this.publisherRestrictions) != null ? str.equals(cmpV2Data.getPublisherRestrictions()) : cmpV2Data.getPublisherRestrictions() == null) && ((set = this.publisherConsent) != null ? set.equals(cmpV2Data.getPublisherConsent()) : cmpV2Data.getPublisherConsent() == null) && ((set2 = this.publisherLegitimateInterests) != null ? set2.equals(cmpV2Data.getPublisherLegitimateInterests()) : cmpV2Data.getPublisherLegitimateInterests() == null) && ((set3 = this.publisherCustomPurposesConsents) != null ? set3.equals(cmpV2Data.getPublisherCustomPurposesConsents()) : cmpV2Data.getPublisherCustomPurposesConsents() == null)) {
            Set set4 = this.publisherCustomPurposesLegitimateInterests;
            if (set4 == null) {
                if (cmpV2Data.getPublisherCustomPurposesLegitimateInterests() == null) {
                    return true;
                }
            } else if (set4.equals(cmpV2Data.getPublisherCustomPurposesLegitimateInterests())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((this.cmpPresent ? 1231 : 1237) ^ 1000003) * 1000003) ^ this.subjectToGdpr.hashCode()) * 1000003) ^ this.consentString.hashCode()) * 1000003) ^ this.vendorConsent.hashCode()) * 1000003) ^ this.purposesConsent.hashCode()) * 1000003) ^ this.sdkId.hashCode()) * 1000003) ^ this.cmpSdkVersion.hashCode()) * 1000003) ^ this.policyVersion.hashCode()) * 1000003) ^ this.publisherCC.hashCode()) * 1000003) ^ this.purposeOneTreatment.hashCode()) * 1000003) ^ this.useNonStandardStacks.hashCode()) * 1000003) ^ this.vendorLegitimateInterests.hashCode()) * 1000003) ^ this.purposeLegitimateInterests.hashCode()) * 1000003) ^ this.specialFeaturesOptIns.hashCode()) * 1000003;
        String str = this.publisherRestrictions;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Set set = this.publisherConsent;
        int iHashCode3 = (iHashCode2 ^ (set == null ? 0 : set.hashCode())) * 1000003;
        Set set2 = this.publisherLegitimateInterests;
        int iHashCode4 = (iHashCode3 ^ (set2 == null ? 0 : set2.hashCode())) * 1000003;
        Set set3 = this.publisherCustomPurposesConsents;
        int iHashCode5 = (iHashCode4 ^ (set3 == null ? 0 : set3.hashCode())) * 1000003;
        Set set4 = this.publisherCustomPurposesLegitimateInterests;
        return iHashCode5 ^ (set4 != null ? set4.hashCode() : 0);
    }

    static final class Builder extends CmpV2Data.Builder {
        private Boolean cmpPresent;
        private String cmpSdkVersion;
        private String consentString;
        private String policyVersion;
        private String publisherCC;
        private Set publisherConsent;
        private Set publisherCustomPurposesConsents;
        private Set publisherCustomPurposesLegitimateInterests;
        private Set publisherLegitimateInterests;
        private String publisherRestrictions;
        private Set purposeLegitimateInterests;
        private Boolean purposeOneTreatment;
        private Set purposesConsent;
        private String sdkId;
        private Set specialFeaturesOptIns;
        private SubjectToGdpr subjectToGdpr;
        private Boolean useNonStandardStacks;
        private Set vendorConsent;
        private Set vendorLegitimateInterests;

        Builder() {
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setCmpPresent(boolean z) {
            this.cmpPresent = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setSubjectToGdpr(SubjectToGdpr subjectToGdpr) {
            if (subjectToGdpr == null) {
                throw new NullPointerException("Null subjectToGdpr");
            }
            this.subjectToGdpr = subjectToGdpr;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setConsentString(String str) {
            if (str == null) {
                throw new NullPointerException("Null consentString");
            }
            this.consentString = str;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setVendorConsent(Set<Integer> set) {
            if (set == null) {
                throw new NullPointerException("Null vendorConsent");
            }
            this.vendorConsent = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPurposesConsent(Set<Integer> set) {
            if (set == null) {
                throw new NullPointerException("Null purposesConsent");
            }
            this.purposesConsent = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setSdkId(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkId");
            }
            this.sdkId = str;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setCmpSdkVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null cmpSdkVersion");
            }
            this.cmpSdkVersion = str;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPolicyVersion(String str) {
            if (str == null) {
                throw new NullPointerException("Null policyVersion");
            }
            this.policyVersion = str;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPublisherCC(String str) {
            if (str == null) {
                throw new NullPointerException("Null publisherCC");
            }
            this.publisherCC = str;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPurposeOneTreatment(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null purposeOneTreatment");
            }
            this.purposeOneTreatment = bool;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setUseNonStandardStacks(Boolean bool) {
            if (bool == null) {
                throw new NullPointerException("Null useNonStandardStacks");
            }
            this.useNonStandardStacks = bool;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setVendorLegitimateInterests(Set<Integer> set) {
            if (set == null) {
                throw new NullPointerException("Null vendorLegitimateInterests");
            }
            this.vendorLegitimateInterests = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPurposeLegitimateInterests(Set<Integer> set) {
            if (set == null) {
                throw new NullPointerException("Null purposeLegitimateInterests");
            }
            this.purposeLegitimateInterests = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setSpecialFeaturesOptIns(Set<Integer> set) {
            if (set == null) {
                throw new NullPointerException("Null specialFeaturesOptIns");
            }
            this.specialFeaturesOptIns = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPublisherRestrictions(String str) {
            this.publisherRestrictions = str;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPublisherConsent(Set<Integer> set) {
            this.publisherConsent = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPublisherLegitimateInterests(Set<Integer> set) {
            this.publisherLegitimateInterests = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPublisherCustomPurposesConsents(Set<Integer> set) {
            this.publisherCustomPurposesConsents = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data.Builder setPublisherCustomPurposesLegitimateInterests(Set<Integer> set) {
            this.publisherCustomPurposesLegitimateInterests = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV2Data.Builder
        public CmpV2Data build() {
            String str;
            if (this.cmpPresent != null) {
                str = "";
            } else {
                str = " cmpPresent";
            }
            if (this.subjectToGdpr == null) {
                str = str + " subjectToGdpr";
            }
            if (this.consentString == null) {
                str = str + " consentString";
            }
            if (this.vendorConsent == null) {
                str = str + " vendorConsent";
            }
            if (this.purposesConsent == null) {
                str = str + " purposesConsent";
            }
            if (this.sdkId == null) {
                str = str + " sdkId";
            }
            if (this.cmpSdkVersion == null) {
                str = str + " cmpSdkVersion";
            }
            if (this.policyVersion == null) {
                str = str + " policyVersion";
            }
            if (this.publisherCC == null) {
                str = str + " publisherCC";
            }
            if (this.purposeOneTreatment == null) {
                str = str + " purposeOneTreatment";
            }
            if (this.useNonStandardStacks == null) {
                str = str + " useNonStandardStacks";
            }
            if (this.vendorLegitimateInterests == null) {
                str = str + " vendorLegitimateInterests";
            }
            if (this.purposeLegitimateInterests == null) {
                str = str + " purposeLegitimateInterests";
            }
            if (this.specialFeaturesOptIns == null) {
                str = str + " specialFeaturesOptIns";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_CmpV2Data(this.cmpPresent.booleanValue(), this.subjectToGdpr, this.consentString, this.vendorConsent, this.purposesConsent, this.sdkId, this.cmpSdkVersion, this.policyVersion, this.publisherCC, this.purposeOneTreatment, this.useNonStandardStacks, this.vendorLegitimateInterests, this.purposeLegitimateInterests, this.specialFeaturesOptIns, this.publisherRestrictions, this.publisherConsent, this.publisherLegitimateInterests, this.publisherCustomPurposesConsents, this.publisherCustomPurposesLegitimateInterests);
        }
    }
}
