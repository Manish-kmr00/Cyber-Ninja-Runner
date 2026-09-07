package com.playon.bridge;

import android.app.Activity;
import android.content.Context;
import com.playon.bridge.common.SdkInitializationListener;
import com.playon.bridge.common.privacy.PlayOnIdentifier;
import com.playon.bridge.dto.consent.ConsentData;
import com.playon.bridge.dto.consent.ConsentType;

/* JADX INFO: loaded from: classes7.dex */
public class PersonalInfoManager {
    private final Context appContext;
    private ConsentData consentData;
    private final String mApiKey;
    private final String mApplicationID;
    private final PlayOnIdentifier mIdentifier;
    private String country = "unknown";
    private String sessionID = "unknown";
    private boolean isChildDirected = false;

    public PersonalInfoManager(Activity activity, String str, SdkInitializationListener sdkInitializationListener) {
        this.mIdentifier = new PlayOnIdentifier(activity, sdkInitializationListener);
        this.mApiKey = str;
        this.mApplicationID = activity.getPackageName();
        this.consentData = new ConsentData(activity);
        this.appContext = activity;
    }

    public boolean canCollectPersonalInformation() {
        if (getIsLimitAdTrackingEnabled()) {
            return true;
        }
        return this.consentData.isCanCollectPersonalInfo();
    }

    public boolean getIsLimitAdTrackingEnabled() {
        return this.mIdentifier.getAdvertisingInfo().isDoNotTrack();
    }

    public String getPlayOnIdentifier() {
        return this.mIdentifier.getAdvertisingInfo().getPlayOnIdentifier();
    }

    public String getAdvertiserIdentifier() {
        return canCollectPersonalInformation() ? this.mIdentifier.getAdvertisingInfo().getAdvertiserIdentifier() : "00000000-0000-0000-0000-000000000000";
    }

    public String getApiKey() {
        return this.mApiKey;
    }

    public void clearConsentString() {
        this.consentData.clearConsentString();
    }

    public String getApplicationID() {
        if (this.mApiKey.equals("bc832bc4-aec6-4886-a791-8472f168107b") || this.mApiKey.equals("0aa0e025-d633-405e-9caa-eb95a3eac9a8") || this.mApiKey.equals("197ba55b-8e67-4332-b431-1ee645b871e8") || this.mApiKey.equals("967975f8-1eab-4348-b8a8-22067c177705")) {
            return "com.DefaultCompany.IngaAds";
        }
        return this.mApplicationID;
    }

    public String getCountry() {
        return this.country;
    }

    public void SetCountry(String str) {
        this.country = str;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    private ConsentData getConsentData() {
        if (this.consentData == null) {
            this.consentData = new ConsentData(this.appContext);
        }
        return this.consentData;
    }

    public ConsentType getRegulationType() {
        return getConsentData().getRegulationType();
    }

    public String getConsentString() {
        return getConsentData().getConsentString();
    }

    public boolean isGeneralConsentGiven() {
        return getConsentData().isGeneralConsentGiven();
    }

    public void setGdprConsent(boolean z, String str) {
        getConsentData().setGdprConsent(z, str);
    }

    public void setConsentString(String str) {
        getConsentData().setConsentString(str);
    }

    public void setDoNotSell(boolean z, String str) {
        getConsentData().setDoNotSell(z, str);
    }

    public void setIsGdprApplied(boolean z) {
        getConsentData().setGdprApplied(z);
    }

    public void setIsCcpaApplied(boolean z) {
        getConsentData().setCcpaApplied(z);
    }

    public void forceRegulationType(ConsentType consentType) {
        getConsentData().forceRegulationType(consentType);
    }

    public void clearForceRegulationType() {
        getConsentData().clearForceRegulationType();
    }

    public Boolean getIsChildDirected() {
        return Boolean.valueOf(this.isChildDirected);
    }

    public void setIsChildDirected(boolean z) {
        this.isChildDirected = z;
    }
}
