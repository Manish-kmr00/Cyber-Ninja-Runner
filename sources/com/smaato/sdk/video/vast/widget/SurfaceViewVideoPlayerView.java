package com.smaato.sdk.video.vast.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.video.vast.vastplayer.VideoPlayerView;

/* JADX INFO: loaded from: classes12.dex */
public class SurfaceViewVideoPlayerView extends VideoPlayerView {
    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SurfaceViewVideoPlayerView(Context context) {
        super(context);
    }

    @Override // com.smaato.sdk.video.vast.vastplayer.VideoPlayerView
    protected VastSurfaceHolder initVastSurfaceHolder(Context context) {
        return new SurfaceViewVastSurfaceHolder(new SurfaceView(context));
    }
}
