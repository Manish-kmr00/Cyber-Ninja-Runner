package com.smaato.sdk.video.vast.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.openmeasurement.ViewabilityVerificationResource;
import com.smaato.sdk.core.ui.AdContentView;
import com.smaato.sdk.core.ui.ProgressView;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.R;
import com.smaato.sdk.video.ad.VerificationResourceMapper;
import com.smaato.sdk.video.vast.model.Verification;
import com.smaato.sdk.video.vast.vastplayer.VideoPlayerView;
import com.smaato.sdk.video.vast.widget.element.VastElementView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class VastVideoAdPlayerView extends AdContentView {
    private final List adVerifications;
    private final VastElementView companionAdView;
    private final VastElementView iconView;
    private FrameLayout layoutView;
    private final VerificationResourceMapper verificationResourceMapper;
    private VideoPlayerView videoPlayerView;

    @Inject
    private VideoPlayerViewFactory videoPlayerViewFactory;

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void destroy() {
    }

    @Override // com.smaato.sdk.core.ui.AdContentView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.smaato.sdk.core.ui.AdContentView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void startShowingView() {
    }

    public VastVideoAdPlayerView(Context context, List<Verification> list) {
        super(context);
        this.verificationResourceMapper = new VerificationResourceMapper();
        AndroidsInjector.inject(this);
        View.inflate(context, R.layout.smaato_sdk_video_vast_video_player_view, this);
        initPlayerView(context);
        this.iconView = (VastElementView) findViewById(R.id.smaato_sdk_video_icon_view_id);
        this.companionAdView = (VastElementView) findViewById(R.id.smaato_sdk_video_companion_view_id);
        this.adVerifications = list;
    }

    public VastElementView getIconView() {
        return this.iconView;
    }

    public VastElementView getCompanionAdView() {
        return this.companionAdView;
    }

    public VideoPlayerView getVideoPlayerView() {
        return this.videoPlayerView;
    }

    public void showCompanion() {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5761x89c8d145();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showCompanion$0$com-smaato-sdk-video-vast-widget-VastVideoAdPlayerView, reason: not valid java name */
    /* synthetic */ void m5761x89c8d145() {
        this.companionAdView.setVisibility(0);
        this.companionAdView.requestFocus();
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public void showProgressIndicator(final boolean z) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5762xb76f38e(z);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showProgressIndicator$1$com-smaato-sdk-video-vast-widget-VastVideoAdPlayerView, reason: not valid java name */
    /* synthetic */ void m5762xb76f38e(boolean z) {
        if (z) {
            addView(new ProgressView(getContext()));
        } else {
            removeView((ProgressView) findViewById(R.id.smaato_sdk_core_progress_view_id));
        }
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForVisibilityTracking() {
        return this.layoutView;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public View getViewForOmTracking() {
        return this.videoPlayerView;
    }

    @Override // com.smaato.sdk.core.ui.AdContentView
    public Map<String, List<ViewabilityVerificationResource>> getViewabilityVerificationResourcesMap() {
        return this.verificationResourceMapper.apply(this.adVerifications);
    }

    public void hidePlayer() {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5760x35324854();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$hidePlayer$3$com-smaato-sdk-video-vast-widget-VastVideoAdPlayerView, reason: not valid java name */
    /* synthetic */ void m5760x35324854() {
        Objects.onNotNull(this.videoPlayerView, new Consumer() { // from class: com.smaato.sdk.video.vast.widget.VastVideoAdPlayerView$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerView) obj).setVisibility(8);
            }
        });
    }

    private void initPlayerView(Context context) {
        VideoPlayerView videoPlayerView = this.videoPlayerViewFactory.getVideoPlayerView(context);
        this.videoPlayerView = videoPlayerView;
        videoPlayerView.setId(R.id.smaato_sdk_video_video_player_view_id);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.smaato_sdk_video_player_layout);
        this.layoutView = frameLayout;
        frameLayout.removeAllViews();
        this.layoutView.addView(this.videoPlayerView, new RelativeLayout.LayoutParams(-1, -1));
    }
}
