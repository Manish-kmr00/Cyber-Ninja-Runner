package com.smaato.sdk.video.vast.vastplayer;

import android.content.Context;
import android.content.res.Configuration;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.StubOnGestureListener;
import com.smaato.sdk.core.util.Threads;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.video.R;
import com.smaato.sdk.video.vast.widget.VastSurfaceHolder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class VideoPlayerView extends FrameLayout {
    private final ImageButton muteButton;
    private final ImageButton skipButton;
    private final TextView skipButtonCountDown;
    private final View surfaceHolderView;
    private VideoPlayerPresenter videoPlayerPresenter;
    private final ProgressBar videoProgressBar;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.v, this, me);
        return super.dispatchTouchEvent(me);
    }

    protected abstract VastSurfaceHolder initVastSurfaceHolder(Context context);

    protected VideoPlayerView(Context context) {
        super(context);
        View.inflate(context, R.layout.smaato_sdk_video_player_view, this);
        this.surfaceHolderView = initSurfaceHolderView(context);
        this.videoProgressBar = initProgressView();
        this.muteButton = initMuteButton();
        this.skipButton = initSkipButton();
        this.skipButtonCountDown = initSkipButtonCountDown();
    }

    private static boolean isInLayoutJellyBeanMR2(View view) {
        return view.isInLayout();
    }

    void setVideoPlayerPresenter(VideoPlayerPresenter videoPlayerPresenter) {
        Threads.ensureMainThread();
        this.videoPlayerPresenter = videoPlayerPresenter;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        final int size = View.MeasureSpec.getSize(i);
        final int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(size, size2);
        if (size <= 0 || size2 <= 0) {
            return;
        }
        Objects.onNotNull(this.videoPlayerPresenter, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                this.f$0.m5751x63bc85a7(size, size2, (VideoPlayerPresenter) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onMeasure$0$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5751x63bc85a7(int i, int i2, VideoPlayerPresenter videoPlayerPresenter) {
        videoPlayerPresenter.onViewMeasured(this, i, i2);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (isInLayoutJellyBeanMR2(this)) {
            return;
        }
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeMuteIcon(final boolean z) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5744x32db6109(z);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$changeMuteIcon$1$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5744x32db6109(boolean z) {
        this.muteButton.setImageResource(z ? R.drawable.smaato_sdk_video_muted : R.drawable.smaato_sdk_video_unmuted);
    }

    private View initSurfaceHolderView(Context context) {
        VastSurfaceHolder vastSurfaceHolderInitVastSurfaceHolder = initVastSurfaceHolder(context);
        vastSurfaceHolderInitVastSurfaceHolder.setOnSurfaceAvailableListener(new VastSurfaceHolder.OnSurfaceAvailableListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.video.vast.widget.VastSurfaceHolder.OnSurfaceAvailableListener
            public final void onSurfaceAvailable(Surface surface, int i, int i2) {
                this.f$0.onSurfaceAvailable(surface, i, i2);
            }
        });
        vastSurfaceHolderInitVastSurfaceHolder.setOnSurfaceChangedListener(new VastSurfaceHolder.OnSurfaceChangedListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda17
            @Override // com.smaato.sdk.video.vast.widget.VastSurfaceHolder.OnSurfaceChangedListener
            public final void onSurfaceChanged(Surface surface, int i, int i2) {
                this.f$0.onSurfaceChanged(surface, i, i2);
            }
        });
        vastSurfaceHolderInitVastSurfaceHolder.setOnSurfaceDestroyedListener(new VastSurfaceHolder.OnSurfaceDestroyedListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda18
            @Override // com.smaato.sdk.video.vast.widget.VastSurfaceHolder.OnSurfaceDestroyedListener
            public final void onSurfaceDestroyed(Surface surface) {
                this.f$0.onSurfaceDestroyed(surface);
            }
        });
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new AnonymousClass1());
        View view = vastSurfaceHolderInitVastSurfaceHolder.getView();
        view.setId(R.id.smaato_sdk_video_surface_holder_view_id);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.smaato_sdk_video_player_surface_layout);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda19
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return VideoPlayerView.lambda$initSurfaceHolderView$2(gestureDetector, view2, motionEvent);
            }
        });
        return view;
    }

    /* JADX INFO: renamed from: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$1, reason: invalid class name */
    class AnonymousClass1 extends StubOnGestureListener {
        AnonymousClass1() {
        }

        @Override // com.smaato.sdk.core.util.StubOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(final MotionEvent motionEvent) {
            Objects.onNotNull(VideoPlayerView.this.videoPlayerPresenter, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$1$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    MotionEvent motionEvent2 = motionEvent;
                    ((VideoPlayerPresenter) obj).onVideoClicked(motionEvent2.getX(), motionEvent2.getY());
                }
            });
            return true;
        }
    }

    static /* synthetic */ boolean lambda$initSurfaceHolderView$2(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Objects.onNotNull(this.videoPlayerPresenter, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter) obj).detachView();
            }
        });
    }

    void setVideoSize(final int i, final int i2) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5753x33bd992f(i, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setVideoSize$3$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5753x33bd992f(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.surfaceHolderView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        layoutParams.gravity = 17;
        this.surfaceHolderView.setLayoutParams(layoutParams);
    }

    private ProgressBar initProgressView() {
        return (ProgressBar) findViewById(R.id.smaato_sdk_video_video_progress);
    }

    private ImageButton initSkipButton() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.smaato_sdk_video_skip_button);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5750xf02a7d47(view);
            }
        });
        return imageButton;
    }

    /* JADX INFO: renamed from: lambda$initSkipButton$4$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5750xf02a7d47(View view) {
        Objects.onNotNull(this.videoPlayerPresenter, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter) obj).onSkipClicked();
            }
        });
    }

    private TextView initSkipButtonCountDown() {
        TextView textView = (TextView) findViewById(R.id.smaato_sdk_video_skip_countdown);
        textView.setVisibility(0);
        return textView;
    }

    private ImageButton initMuteButton() {
        ImageButton imageButton = (ImageButton) findViewById(R.id.smaato_sdk_video_mute_button);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m5749x400f358c(view);
            }
        });
        return imageButton;
    }

    /* JADX INFO: renamed from: lambda$initMuteButton$5$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5749x400f358c(View view) {
        Objects.onNotNull(this.videoPlayerPresenter, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter) obj).onMuteClicked();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceAvailable(final Surface surface, int i, int i2) {
        Objects.onNotNull(this.videoPlayerPresenter, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter) obj).onSurfaceAvailable(surface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceChanged(final Surface surface, final int i, final int i2) {
        Objects.onNotNull(this.videoPlayerPresenter, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter) obj).onSurfaceChanged(surface, i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSurfaceDestroyed(final Surface surface) {
        Objects.onNotNull(this.videoPlayerPresenter, new Consumer() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda21
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((VideoPlayerPresenter) obj).onSurfaceDestroyed(surface);
            }
        });
        surface.release();
    }

    void updateProgressBar(final long j, final long j2) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5756x451f9ae0(j2, j);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateProgressBar$9$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5756x451f9ae0(long j, long j2) {
        this.videoProgressBar.setMax((int) j);
        this.videoProgressBar.setProgress((int) j2, true);
    }

    /* JADX INFO: renamed from: lambda$updateCountdownText$10$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5755x9912c9ca(int i) {
        this.skipButtonCountDown.setText(String.valueOf(i));
    }

    void updateCountdownText(final int i) {
        if (i > 0) {
            Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m5755x9912c9ca(i);
                }
            });
        }
    }

    void hideCountdownText() {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5745x8d8a1c50();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$hideCountdownText$11$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5745x8d8a1c50() {
        if (this.skipButtonCountDown.getVisibility() == 0) {
            this.skipButtonCountDown.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSkipButtonSize(final int i) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5752x54d4ac47(i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setSkipButtonSize$12$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5752x54d4ac47(int i) {
        ViewGroup.LayoutParams layoutParams = this.skipButton.getLayoutParams();
        int iApplyDimension = (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
        layoutParams.height = iApplyDimension;
        layoutParams.width = iApplyDimension;
        this.skipButton.setLayoutParams(layoutParams);
    }

    void showSkipButton(final boolean z) {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5754x5dc8ff3a(z);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showSkipButton$13$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5754x5dc8ff3a(boolean z) {
        if (!z) {
            this.skipButton.setImageResource(R.drawable.smaato_sdk_core_circle_close);
        }
        if (this.skipButton.getVisibility() == 0) {
            return;
        }
        this.skipButton.setAlpha(0.0f);
        this.skipButton.setVisibility(0);
        this.skipButton.animate().alpha(1.0f).setDuration(300L).start();
    }

    void hideSkipButton() {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5748xcb3d5ade();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$hideSkipButton$14$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5748xcb3d5ade() {
        if (this.skipButton.getVisibility() == 0) {
            this.skipButton.setVisibility(8);
        }
    }

    void hideProgressBar() {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5747xf193c2b4();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$hideProgressBar$15$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5747xf193c2b4() {
        if (this.videoProgressBar.getVisibility() == 0) {
            this.videoProgressBar.setVisibility(8);
        }
    }

    void hideMuteButton() {
        Threads.runOnUi(new Runnable() { // from class: com.smaato.sdk.video.vast.vastplayer.VideoPlayerView$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5746x82d25336();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$hideMuteButton$16$com-smaato-sdk-video-vast-vastplayer-VideoPlayerView, reason: not valid java name */
    /* synthetic */ void m5746x82d25336() {
        if (this.muteButton.getVisibility() == 0) {
            this.muteButton.setVisibility(8);
        }
    }
}
