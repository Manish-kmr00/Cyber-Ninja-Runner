package com.smaato.sdk.core.gdpr;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class AutoValue_CmpV1Data extends CmpV1Data {
    private final boolean cmpPresent;
    private final String consentString;
    private final Set purposesConsent;
    private final SubjectToGdpr subjectToGdpr;
    private final Set vendorConsent;

    private AutoValue_CmpV1Data(boolean z, SubjectToGdpr subjectToGdpr, String str, Set set, Set set2) {
        this.cmpPresent = z;
        this.subjectToGdpr = subjectToGdpr;
        this.consentString = str;
        this.vendorConsent = set;
        this.purposesConsent = set2;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV1Data, com.smaato.sdk.core.gdpr.CmpData
    public boolean isCmpPresent() {
        return this.cmpPresent;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV1Data, com.smaato.sdk.core.gdpr.CmpData
    public SubjectToGdpr getSubjectToGdpr() {
        return this.subjectToGdpr;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV1Data, com.smaato.sdk.core.gdpr.CmpData
    public String getConsentString() {
        return this.consentString;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV1Data, com.smaato.sdk.core.gdpr.CmpData
    public Set<Integer> getVendorConsent() {
        return this.vendorConsent;
    }

    @Override // com.smaato.sdk.core.gdpr.CmpV1Data, com.smaato.sdk.core.gdpr.CmpData
    public Set<Integer> getPurposesConsent() {
        return this.purposesConsent;
    }

    public String toString() {
        return "CmpV1Data{cmpPresent=" + this.cmpPresent + ", subjectToGdpr=" + this.subjectToGdpr + ", consentString=" + this.consentString + ", vendorConsent=" + this.vendorConsent + ", purposesConsent=" + this.purposesConsent + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CmpV1Data)) {
            return false;
        }
        CmpV1Data cmpV1Data = (CmpV1Data) obj;
        return this.cmpPresent == cmpV1Data.isCmpPresent() && this.subjectToGdpr.equals(cmpV1Data.getSubjectToGdpr()) && this.consentString.equals(cmpV1Data.getConsentString()) && this.vendorConsent.equals(cmpV1Data.getVendorConsent()) && this.purposesConsent.equals(cmpV1Data.getPurposesConsent());
    }

    public int hashCode() {
        return (((((((((this.cmpPresent ? 1231 : 1237) ^ 1000003) * 1000003) ^ this.subjectToGdpr.hashCode()) * 1000003) ^ this.consentString.hashCode()) * 1000003) ^ this.vendorConsent.hashCode()) * 1000003) ^ this.purposesConsent.hashCode();
    }

    static final class Builder extends CmpV1Data.Builder {
        private Boolean cmpPresent;
        private String consentString;
        private Set purposesConsent;
        private SubjectToGdpr subjectToGdpr;
        private Set vendorConsent;

        Builder() {
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV1Data.Builder
        public CmpV1Data.Builder setCmpPresent(boolean z) {
            this.cmpPresent = Boolean.valueOf(z);
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV1Data.Builder
        public CmpV1Data.Builder setSubjectToGdpr(SubjectToGdpr subjectToGdpr) {
            if (subjectToGdpr == null) {
                throw new NullPointerException("Null subjectToGdpr");
            }
            this.subjectToGdpr = subjectToGdpr;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV1Data.Builder
        public CmpV1Data.Builder setConsentString(String str) {
            if (str == null) {
                throw new NullPointerException("Null consentString");
            }
            this.consentString = str;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV1Data.Builder
        public CmpV1Data.Builder setVendorConsent(Set<Integer> set) {
            if (set == null) {
                throw new NullPointerException("Null vendorConsent");
            }
            this.vendorConsent = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV1Data.Builder
        public CmpV1Data.Builder setPurposesConsent(Set<Integer> set) {
            if (set == null) {
                throw new NullPointerException("Null purposesConsent");
            }
            this.purposesConsent = set;
            return this;
        }

        @Override // com.smaato.sdk.core.gdpr.CmpV1Data.Builder
        public CmpV1Data build() {
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
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_CmpV1Data(this.cmpPresent.booleanValue(), this.subjectToGdpr, this.consentString, this.vendorConsent, this.purposesConsent);
        }
    }
}
