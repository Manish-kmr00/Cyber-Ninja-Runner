package com.pubmatic.sdk.video.player;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes3.dex */
public class POBVideoPlayerController extends POBPlayerController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private POBVideoPlayer f7839a;
    private SeekBar b;
    private ImageButton c;
    private Resources d;

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (POBVideoPlayerController.this.f7839a != null) {
                POBVideoPlayerController pOBVideoPlayerController = POBVideoPlayerController.this;
                pOBVideoPlayerController.a(!pOBVideoPlayerController.f7839a.isMute());
                POBVideoPlayerController pOBVideoPlayerController2 = POBVideoPlayerController.this;
                pOBVideoPlayerController2.b(pOBVideoPlayerController2.f7839a.isMute());
            }
        }
    }

    public POBVideoPlayerController(Context context) {
        super(context);
        this.d = getResources();
        this.b = c();
        this.c = b();
        a();
    }

    private SeekBar c() {
        SeekBar seekBar = new SeekBar(getContext());
        seekBar.setPadding(0, 0, 0, POBUtils.convertDpToPixel(1));
        seekBar.setThumb(null);
        seekBar.getProgressDrawable().setColorFilter(this.d.getColor(R.color.holo_blue_light), PorterDuff.Mode.SRC_ATOP);
        seekBar.setOnTouchListener(new a());
        return seekBar;
    }

    @Override // com.pubmatic.sdk.video.player.POBPlayerController, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.F, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.pubmatic.sdk.video.player.POBPlayerController, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onMute(boolean z) {
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onPause() {
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onProgressUpdate(int i) {
        this.b.setProgress(i);
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onResume() {
    }

    @Override // com.pubmatic.sdk.video.player.POBVideoPlayerView.POBVideoPlayerListener
    public void onStart() {
        POBVideoPlayer pOBVideoPlayer = this.f7839a;
        if (pOBVideoPlayer != null) {
            this.b.setMax(pOBVideoPlayer.getMediaDuration());
            b(this.f7839a.isMute());
        }
    }

    @Override // com.pubmatic.sdk.video.player.POBPlayerController
    public void setVideoPlayerEvents(POBVideoPlayer pOBVideoPlayer) {
        this.f7839a = pOBVideoPlayer;
    }

    private ImageButton b() {
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setId(com.pubmatic.sdk.video.R.id.pob_mute_btn);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(this.d.getColor(com.pubmatic.sdk.webrendering.R.color.pob_controls_background_color));
        gradientDrawable.setStroke(this.d.getDimensionPixelOffset(com.pubmatic.sdk.webrendering.R.dimen.pob_control_stroke_width), this.d.getColor(com.pubmatic.sdk.webrendering.R.color.pob_controls_stroke_color));
        gradientDrawable.setAlpha(this.d.getInteger(com.pubmatic.sdk.webrendering.R.integer.pob_controls_alpha));
        imageButton.setBackground(gradientDrawable);
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setImageResource(com.pubmatic.sdk.video.R.drawable.pob_ic_volume_up_black_24dp);
        imageButton.setOnClickListener(new b());
        return imageButton;
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.d.getDimensionPixelOffset(com.pubmatic.sdk.video.R.dimen.pob_seek_bar_height));
        layoutParams.gravity = 80;
        layoutParams.leftMargin = this.d.getDimensionPixelOffset(com.pubmatic.sdk.video.R.dimen.pob_seek_left_margin);
        layoutParams.rightMargin = this.d.getDimensionPixelOffset(com.pubmatic.sdk.video.R.dimen.pob_seek_right_margin);
        addView(this.b, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.d.getDimensionPixelOffset(com.pubmatic.sdk.webrendering.R.dimen.pob_control_width), this.d.getDimensionPixelOffset(com.pubmatic.sdk.webrendering.R.dimen.pob_control_height));
        layoutParams2.gravity = 8388691;
        layoutParams2.bottomMargin = this.d.getDimensionPixelOffset(com.pubmatic.sdk.video.R.dimen.pob_mute_button_bottom_margin);
        layoutParams2.leftMargin = this.d.getDimensionPixelOffset(com.pubmatic.sdk.video.R.dimen.pob_mute_button_left_margin);
        addView(this.c, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.c.setImageResource(com.pubmatic.sdk.video.R.drawable.pob_ic_volume_off_black_24dp);
        } else {
            this.c.setImageResource(com.pubmatic.sdk.video.R.drawable.pob_ic_volume_up_black_24dp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        POBVideoPlayer pOBVideoPlayer = this.f7839a;
        if (pOBVideoPlayer != null) {
            if (z) {
                pOBVideoPlayer.mute();
            } else {
                pOBVideoPlayer.unMute();
            }
        }
    }
}
