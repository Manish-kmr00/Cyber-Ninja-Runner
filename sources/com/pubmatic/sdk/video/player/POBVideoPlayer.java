package com.pubmatic.sdk.video.player;

import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes5.dex */
public interface POBVideoPlayer {
    public static final int MAX_STALLING_TIMEOUT = 15000;
    public static final int MEDIA_FILE_TIMEOUT_ERROR = -1;
    public static final int RUNTIME_ERROR = -2;
    public static final SupportedMediaType[] SUPPORTED_MEDIA_TYPE = SupportedMediaType.values();

    public enum SupportedMediaType {
        MEDIA_3GPP("video/3gpp"),
        MEDIA_MP4("video/mp4"),
        MEDIA_WEBM("video/webm");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7837a;

        SupportedMediaType(String str) {
            this.f7837a = str;
        }

        public static String[] getStringValues() {
            SupportedMediaType[] supportedMediaTypeArrValues = values();
            String[] strArr = new String[supportedMediaTypeArrValues.length];
            for (int i = 0; i < supportedMediaTypeArrValues.length; i++) {
                strArr[i] = supportedMediaTypeArrValues[i].getValue();
            }
            return strArr;
        }

        public String getValue() {
            return this.f7837a;
        }
    }

    public enum VideoPlayerState {
        UNKNOWN,
        LOADED,
        PLAYING,
        PAUSED,
        STOPPED,
        COMPLETE,
        ERROR
    }

    void destroy();

    POBPlayerController getControllerView();

    int getMediaDuration();

    VideoPlayerState getPlayerState();

    boolean isMute();

    void load(String str);

    void mute();

    void pause();

    void play();

    void playOnMute(boolean z);

    void setAutoPlayOnForeground(boolean z);

    void setControllerView(POBPlayerController pOBPlayerController, FrameLayout.LayoutParams layoutParams);

    void setListener(POBVideoPlayerView.POBVideoPlayerListener pOBVideoPlayerListener);

    void setPrepareTimeout(int i);

    void stop();

    void unMute();
}
