package com.smaato.sdk.video.vast.vastplayer.exception;

/* JADX INFO: loaded from: classes8.dex */
public class UnsupportedVideoPlayerException extends VideoPlayerException {
    public UnsupportedVideoPlayerException() {
        super("Bitstream is conforming to the related coding standard or file spec, but the media framework does not support the feature");
    }
}
