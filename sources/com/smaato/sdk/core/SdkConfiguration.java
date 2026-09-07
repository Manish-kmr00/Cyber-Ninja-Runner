package com.smaato.sdk.core;

import com.smaato.sdk.core.ad.UserInfo;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkConfiguration {
    public boolean isGpsEnabled() {
        return SmaatoSdk.isGPSEnabled();
    }

    public Boolean isLgpdConsentEnabled() {
        return SmaatoSdk.isLGPDConsentEnabled();
    }

    public boolean isCompanionAdSkippable() {
        return SmaatoSdk.isCompanionAdSkippable();
    }

    public boolean isWatermarkEnabled() {
        return SmaatoSdk.isWatermarkEnabled();
    }

    public boolean isCoppaEnabled() {
        return SmaatoSdk.getCoppa();
    }

    public String getPublisherId() {
        return SmaatoSdk.getPublisherId();
    }

    public String getUsPrivacyString() {
        return SmaatoSdk.getUsPrivacyString();
    }

    public String getVersion() {
        return SmaatoSdk.getVersion();
    }

    public AdContentRating getAdContentRating() {
        return SmaatoSdk.getAdContentRating();
    }

    public String getUnityVersion() {
        return SmaatoSdk.getUnityVersion();
    }

    public UserInfo getUserInfo() {
        return new UserInfo.Builder().setKeywords(SmaatoSdk.getKeywords()).setSearchQuery(SmaatoSdk.getSearchQuery()).setGender(SmaatoSdk.getGender()).setAge(SmaatoSdk.getAge()).setLatLng(SmaatoSdk.getLatLng()).setRegion(SmaatoSdk.getRegion()).setZip(SmaatoSdk.getZip()).setLanguage(SmaatoSdk.getLanguage()).setCoppa(SmaatoSdk.getCoppa()).build();
    }
}
