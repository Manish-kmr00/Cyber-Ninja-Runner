package com.smaato.sdk.core.gdpr;

import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public abstract class CmpV1Data implements CmpData {

    public static abstract class Builder {
        public abstract CmpV1Data build();

        public abstract Builder setCmpPresent(boolean z);

        public abstract Builder setConsentString(String str);

        public abstract Builder setPurposesConsent(Set<Integer> set);

        public abstract Builder setSubjectToGdpr(SubjectToGdpr subjectToGdpr);

        public abstract Builder setVendorConsent(Set<Integer> set);
    }

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract String getConsentString();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract Set<Integer> getPurposesConsent();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract SubjectToGdpr getSubjectToGdpr();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract Set<Integer> getVendorConsent();

    @Override // com.smaato.sdk.core.gdpr.CmpData
    public abstract boolean isCmpPresent();

    public static Builder builder() {
        return new AutoValue_CmpV1Data.Builder();
    }
}
