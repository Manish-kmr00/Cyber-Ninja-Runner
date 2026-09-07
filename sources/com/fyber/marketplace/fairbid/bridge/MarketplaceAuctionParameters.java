package com.fyber.marketplace.fairbid.bridge;

import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.dv.j;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface MarketplaceAuctionParameters {
    String getAdvertisingId();

    String getAmazonAdvertisingId();

    String getAppVersion();

    String getBundleId();

    String getCarrier();

    String getDeviceModel();

    r getFeatureProvider(String str);

    int getHeight();

    @Deprecated
    String getHorizontalAccuracy();

    List<String> getInputLanguages();

    String getLanguage();

    @Deprecated
    String getLatitudeLongitude();

    JSONObject getMarketplaceEntry();

    String getMobileCountryCode();

    String getMobileNetworkCode();

    String getNetwork();

    List<Integer> getSupportedApis();

    List<Integer> getSupportedProtocols();

    int getSupportedTypesBitwise();

    @Deprecated
    String getTimeAccuracy();

    @Deprecated
    String getVerticalAccuracy();

    int getWidth();

    j getWrapperQueryInfo(String str);

    boolean hasAmazonAdvertisingId();

    Boolean isLimitTrackingEnabled();
}
