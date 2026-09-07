package net.pubnative.lite.sdk.vpaid;

import net.pubnative.lite.sdk.models.EndCardData;
import net.pubnative.lite.sdk.vpaid.response.AdParams;

/* JADX INFO: loaded from: classes12.dex */
public class VideoAdCacheItem {
    private final AdParams mAdParams;
    private final EndCardData mEndCardData;
    private final String mEndCardFilePath;
    private final String mVideoFilePath;

    public VideoAdCacheItem(AdParams adParams, String str, EndCardData endCardData, String str2) {
        this.mAdParams = adParams;
        this.mVideoFilePath = str;
        this.mEndCardData = endCardData;
        this.mEndCardFilePath = str2;
    }

    public AdParams getAdParams() {
        return this.mAdParams;
    }

    public String getVideoFilePath() {
        return this.mVideoFilePath;
    }

    public EndCardData getEndCardData() {
        return this.mEndCardData;
    }

    public String getEndCardFilePath() {
        return this.mEndCardFilePath;
    }
}
