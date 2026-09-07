package com.smaato.sdk.core.gdpr;

/* JADX INFO: loaded from: classes8.dex */
public interface IabCmpDataStorage {
    CmpData getCmpData();

    String getConsentString();

    int getConsentVersion();

    String getPurposesString();

    SubjectToGdpr getSubjectToGdpr();

    String getVendorsString();

    boolean isCmpPresent();
}
