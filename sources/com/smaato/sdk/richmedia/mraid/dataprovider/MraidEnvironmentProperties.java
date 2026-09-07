package com.smaato.sdk.richmedia.mraid.dataprovider;

/* JADX INFO: loaded from: classes12.dex */
public final class MraidEnvironmentProperties {
    public static final String SDK = "SmaatoSDK Android";
    public static final String VERSION = "3.0";
    public final String appId;
    public final Integer coppa;
    public final String googleAdId;
    public final Boolean googleDnt;
    public final String sdkVersion;

    public MraidEnvironmentProperties(String str, String str2, String str3, Boolean bool, Integer num) {
        this.sdkVersion = str;
        this.appId = str2;
        this.googleAdId = str3;
        this.googleDnt = bool;
        this.coppa = num;
    }
}
