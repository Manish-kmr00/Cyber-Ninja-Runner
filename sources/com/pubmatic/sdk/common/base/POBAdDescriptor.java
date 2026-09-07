package com.pubmatic.sdk.common.base;

import com.pubmatic.sdk.common.models.POBDSATransparencyInfo;
import com.pubmatic.sdk.common.models.POBImpressionCountingMethod;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public interface POBAdDescriptor {
    public static final int BID_STATUS_NOT_OK = 0;
    public static final int BID_STATUS_OK = 1;
    public static final String CREATIVE_TYPE_BANNER = "banner";
    public static final String CREATIVE_TYPE_NATIVE = "native";
    public static final String CREATIVE_TYPE_VIDEO = "video";
    public static final String DYNAMIC_PRICE_BID = "dynamic";
    public static final String STATIC_PRICE_BID = "static";

    POBAdDescriptor buildWithRefreshAndExpiryTimeout(int i, int i2);

    boolean enableDsaInfoIcon();

    String getBundle();

    List<String> getClickTrackers();

    int getContentHeight();

    int getContentWidth();

    String getCreativeType();

    String getDisplayedOnBehalfOf();

    String getId();

    POBImpressionCountingMethod getImpressionCountingMethod();

    String getPaidBy();

    JSONObject getRawBid();

    int getRefreshInterval();

    String getRenderableContent();

    int getStatus();

    Map<String, String> getTargetingInfo();

    List<POBDSATransparencyInfo> getTransparencyData();

    boolean isCompanion();

    boolean isVideo();
}
