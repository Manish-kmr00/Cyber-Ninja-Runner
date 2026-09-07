package io.bidmachine.nativead.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.BidMachineVideoBridge;
import com.safedk.android.utils.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.iab.utils.Assets;
import io.bidmachine.iab.vast.view.CircleCountdownView;
import io.bidmachine.utils.lazy.LazyValue;

/* JADX INFO: loaded from: classes11.dex */
public class VideoPlayerActivity extends Activity implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    private static final String FILE_URI = "io.bidmachine.fileUri";
    private static final String SEEK_TO = "io.bidmachine.seekTo";
    private VideoPlayerActivityListener listener;
    private int seekTo;
    private VideoView videoView;

    interface VideoPlayerActivityListener {
        void videoPlayerActivityClosed(int i, boolean z);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch("io.bidmachine", me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/nativead/view/VideoPlayerActivity;->onCompletion(Landroid/media/MediaPlayer;)V");
        CreativeInfoManager.onVideoCompleted("io.bidmachine", mediaPlayer, "media-player");
        safedk_VideoPlayerActivity_onCompletion_b224a727624a602e022b4b2f6600be7c(mediaPlayer);
    }

    public static Intent getIntent(Context context, String str, int i) {
        Intent intent = new Intent(context, (Class<?>) VideoPlayerActivity.class);
        intent.putExtra(FILE_URI, str);
        intent.putExtra(SEEK_TO, i);
        return intent;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(FILE_URI);
        this.seekTo = intent.getIntExtra(SEEK_TO, 0);
        io.bidmachine.core.Logger.d((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.nativead.view.VideoPlayerActivity$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                return this.f$0.m7579xbe57e9da();
            }
        });
        if (stringExtra == null) {
            return;
        }
        this.listener = MediaView.listener;
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.videoView = new VideoView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.videoView.setLayoutParams(layoutParams);
        this.videoView.setOnCompletionListener(this);
        this.videoView.setOnPreparedListener(this);
        this.videoView.setVideoPath(stringExtra);
        relativeLayout.addView(this.videoView);
        float screenDensity = Utils.getScreenDensity(this);
        int iRound = Math.round(24.0f * screenDensity);
        int iRound2 = Math.round(screenDensity * 8.0f);
        CircleCountdownView circleCountdownView = new CircleCountdownView(this);
        circleCountdownView.setColors(Assets.MAIN_ASSETS_COLOR, Assets.BACKGROUND_COLOR);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iRound, iRound);
        layoutParams2.addRule(11, -1);
        layoutParams2.addRule(10, -1);
        layoutParams2.setMargins(iRound2, iRound2, iRound2, iRound2);
        circleCountdownView.setImage(Assets.getBitmapFromBase64(Assets.CLOSE));
        circleCountdownView.setLayoutParams(layoutParams2);
        circleCountdownView.setOnClickListener(new View.OnClickListener() { // from class: io.bidmachine.nativead.view.VideoPlayerActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayerActivity.this.closeClicked();
            }
        });
        relativeLayout.addView(circleCountdownView);
        setContentView(relativeLayout);
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$io-bidmachine-nativead-view-VideoPlayerActivity, reason: not valid java name */
    /* synthetic */ String m7579xbe57e9da() {
        return String.format("VideoPlayerActivity started, position: %s", Integer.valueOf(this.seekTo));
    }

    private void finishActivity() {
        runOnUiThread(new Runnable() { // from class: io.bidmachine.nativead.view.VideoPlayerActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    VideoPlayerActivity.this.getWindow().clearFlags(128);
                } catch (Exception e) {
                    io.bidmachine.core.Logger.w(e);
                }
            }
        });
        finish();
    }

    public void safedk_VideoPlayerActivity_onCompletion_b224a727624a602e022b4b2f6600be7c(MediaPlayer p0) {
        VideoPlayerActivityListener videoPlayerActivityListener = this.listener;
        if (videoPlayerActivityListener != null) {
            videoPlayerActivityListener.videoPlayerActivityClosed(0, true);
        }
        finishActivity();
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        finishActivity();
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        VideoView videoView = this.videoView;
        if (videoView == null || !videoView.canSeekForward()) {
            return;
        }
        this.videoView.seekTo(this.seekTo);
        BidMachineVideoBridge.VideoViewPlay(this.videoView);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        closeClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeClicked() {
        if (this.listener != null) {
            this.listener.videoPlayerActivityClosed(this.videoView.isPlaying() ? this.videoView.getCurrentPosition() : 0, false);
        }
        finishActivity();
    }
}
