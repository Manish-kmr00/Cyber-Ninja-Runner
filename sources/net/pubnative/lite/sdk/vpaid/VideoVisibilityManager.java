package net.pubnative.lite.sdk.vpaid;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public class VideoVisibilityManager {
    private static VideoVisibilityManager instance;
    ArrayList<VideoVisibilityListener> videoVisibilityListeners = new ArrayList<>();

    public enum VideoAdStatus {
        PAUSED,
        RESUMED
    }

    private VideoVisibilityManager() {
    }

    public static VideoVisibilityManager getInstance() {
        if (instance == null) {
            instance = new VideoVisibilityManager();
        }
        return instance;
    }

    public void addCallback(VideoVisibilityListener videoVisibilityListener) {
        this.videoVisibilityListeners.add(videoVisibilityListener);
    }

    public void removeCallback(VideoVisibilityListener videoVisibilityListener) {
        this.videoVisibilityListeners.remove(videoVisibilityListener);
    }

    public void reportChange(VideoAdStatus videoAdStatus) {
        for (VideoVisibilityListener videoVisibilityListener : this.videoVisibilityListeners) {
            if (videoAdStatus == VideoAdStatus.PAUSED) {
                videoVisibilityListener.pauseAd();
            } else {
                videoVisibilityListener.resumeAd();
            }
        }
    }
}
