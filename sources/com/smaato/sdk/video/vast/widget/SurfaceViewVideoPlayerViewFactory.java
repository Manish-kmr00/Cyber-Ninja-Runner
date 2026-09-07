package com.smaato.sdk.video.vast.widget;

import android.content.Context;
import com.smaato.sdk.video.vast.vastplayer.VideoPlayerView;

/* JADX INFO: loaded from: classes10.dex */
public class SurfaceViewVideoPlayerViewFactory implements VideoPlayerViewFactory {
    @Override // com.smaato.sdk.video.vast.widget.VideoPlayerViewFactory
    public VideoPlayerView getVideoPlayerView(Context context) {
        return new SurfaceViewVideoPlayerView(context);
    }
}
