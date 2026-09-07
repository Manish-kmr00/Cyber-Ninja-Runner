package io.bidmachine.models;

import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public interface IUserRestrictionsParams<SelfType> {
    SelfType setConsentConfig(boolean z, String str);

    SelfType setCoppa(Boolean bool);

    SelfType setGPP(String str, List<Integer> list);

    SelfType setSubjectToGDPR(Boolean bool);

    SelfType setUSPrivacyString(String str);
}
