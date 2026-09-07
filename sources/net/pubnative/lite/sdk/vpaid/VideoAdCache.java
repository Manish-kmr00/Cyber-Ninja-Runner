package net.pubnative.lite.sdk.vpaid;

import java.util.HashMap;
import java.util.Map;
import net.pubnative.lite.sdk.utils.Logger;

/* JADX INFO: loaded from: classes11.dex */
public class VideoAdCache {
    private static final String TAG = "VideoAdCache";
    private final String mLatestZoneId = "latestZoneId";
    private final Map<String, VideoAdCacheItem> mAdMap = new HashMap();

    public VideoAdCacheItem remove(String str) {
        return this.mAdMap.remove(str);
    }

    public VideoAdCacheItem inspect(String str) {
        return this.mAdMap.get(str);
    }

    public VideoAdCacheItem inspectLatest() {
        return this.mAdMap.get("latestZoneId");
    }

    public void put(String str, VideoAdCacheItem videoAdCacheItem) {
        Logger.d(TAG, "VideoAdCache putting video for zone id: " + str);
        this.mAdMap.put(str, videoAdCacheItem);
        this.mAdMap.put("latestZoneId", videoAdCacheItem);
    }
}
