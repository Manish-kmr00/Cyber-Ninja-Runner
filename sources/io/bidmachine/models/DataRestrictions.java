package io.bidmachine.models;

import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public interface DataRestrictions {
    boolean canSendBmIfv();

    boolean canSendDeviceInfo();

    boolean canSendGeoPosition();

    boolean canSendIfa();

    boolean canSendUserInfo();

    List<Integer> getGPPIds();

    String getGPPString();

    String getIABGDPRString();

    String getUSPrivacyString();

    boolean hasConsent();

    boolean isUserAgeRestricted();

    boolean isUserGdprProtected();

    boolean isUserHasCcpaConsent();

    boolean isUserHasConsent();

    boolean isUserInCcpaScope();

    boolean isUserInGdprScope();
}
