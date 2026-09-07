package com.amazon.device.ads;

/* JADX INFO: loaded from: classes9.dex */
public interface DTBAdLoader {
    public static final String A9_BID_ID_KEY = "amzn_b";
    public static final String A9_HOST_KEY = "amzn_h";
    public static final String A9_PRICE_POINTS_KEY = "amznslots";
    public static final String A9_VID_KEY = "amzn_vid";
    public static final String APS_VIDEO_APP_KEY = "appkey";
    public static final String APS_VIDEO_FLAG = "isv";
    public static final String APS_VIDEO_SKIP_AFTER = "skipafter";
    public static final String APS_VIDEO_TYPE = "vtype";

    String getSlotGroupName();

    void loadAd(DTBAdCallback dTBAdCallback);

    void loadSmartBanner(DTBAdCallback dTBAdCallback) throws DTBLoadException;

    void pauseAutoRefresh();

    void putCustomTarget(String str, String str2);

    void resumeAutoRefresh();

    void setAutoRefresh();

    void setAutoRefresh(int i);

    void setSizes(DTBAdSize... dTBAdSizeArr) throws IllegalArgumentException;

    void setSlotGroup(String str);

    void stop();
}
