package com.smaato.sdk.core.gdpr;

import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
public interface CmpData {
    String getConsentString();

    Set<Integer> getPurposesConsent();

    SubjectToGdpr getSubjectToGdpr();

    Set<Integer> getVendorConsent();

    boolean isCmpPresent();
}
