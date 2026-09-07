package com.smaato.sdk.core.datacollector;

import com.smaato.sdk.core.network.NetworkConnectionType;
import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes10.dex */
public final class SystemInfo {
    private final String carrierCode;
    private final String carrierName;
    private final String deviceModelName;
    private final String googleAdvertisingId;
    private final Boolean isGoogleLimitAdTrackingEnabled;
    private final String language;
    private final NetworkConnectionType networkConnectionType;
    private final String packageName;
    private final String userAgent;

    SystemInfo(String str, String str2, String str3, Boolean bool, String str4, NetworkConnectionType networkConnectionType, String str5, String str6, String str7) {
        this.carrierName = str;
        this.carrierCode = str2;
        this.googleAdvertisingId = str3;
        this.isGoogleLimitAdTrackingEnabled = bool;
        this.deviceModelName = str4;
        this.networkConnectionType = networkConnectionType;
        this.userAgent = (String) Objects.requireNonNull(str5, "Parameter userAgent cannot be null for SystemInfo::SystemInfo");
        this.packageName = (String) Objects.requireNonNull(str6, "Parameter packageName cannot be null for SystemInfo::SystemInfo");
        this.language = (String) Objects.requireNonNull(str7, "Parameter language cannot be null for SystemInfo::SystemInfo");
    }

    public String getCarrierName() {
        return this.carrierName;
    }

    public String getCarrierCode() {
        return this.carrierCode;
    }

    public String getGoogleAdvertisingId() {
        return this.googleAdvertisingId;
    }

    public Boolean isGoogleLimitAdTrackingEnabled() {
        return this.isGoogleLimitAdTrackingEnabled;
    }

    public String getDeviceModelName() {
        return this.deviceModelName;
    }

    public NetworkConnectionType getNetworkConnectionType() {
        return this.networkConnectionType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public String getLanguage() {
        return this.language;
    }
}
