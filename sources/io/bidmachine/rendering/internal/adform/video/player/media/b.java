package io.bidmachine.rendering.internal.adform.video.player.media;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.internal.partials.BidMachineVideoBridge;
import io.bidmachine.rendering.internal.adform.video.player.e;

/* JADX INFO: loaded from: classes5.dex */
public class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final io.bidmachine.rendering.internal.view.a f12345a;
    private io.bidmachine.rendering.internal.adform.video.player.media.c b;
    private MediaPlayer c;
    private Surface d;

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.adform.video.player.media.b$b, reason: collision with other inner class name */
    private class C0787b implements MediaPlayer.OnVideoSizeChangedListener {
        private C0787b() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            b.this.setVideoAspectRatio(i / i2);
        }
    }

    private class c implements e {
        private c() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.d = new Surface(surfaceTexture);
            b bVar = b.this;
            bVar.setMediaPlayerSurface(bVar.d);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (b.this.b == null) {
                return false;
            }
            b.this.b.a();
            return false;
        }
    }

    public b(Context context) {
        super(context);
        io.bidmachine.rendering.internal.view.a aVar = new io.bidmachine.rendering.internal.view.a(context);
        this.f12345a = aVar;
        aVar.setSurfaceTextureListener(new c());
        addView(aVar, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMediaPlayerSurface(Surface surface) {
        try {
            MediaPlayer mediaPlayer = this.c;
            if (mediaPlayer != null) {
                BidMachineVideoBridge.MediaPlayerSetSurface(mediaPlayer, surface);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void setListener(io.bidmachine.rendering.internal.adform.video.player.media.c mediaPlayerViewListener) {
        this.b = mediaPlayerViewListener;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.c = mediaPlayer;
        if (mediaPlayer != null) {
            setVideoAspectRatio(mediaPlayer.getVideoWidth() / mediaPlayer.getVideoHeight());
            mediaPlayer.setOnVideoSizeChangedListener(new C0787b());
        }
    }

    public void setVideoAspectRatio(float videoAspectRatio) {
        this.f12345a.setVideoAspectRatio(videoAspectRatio);
    }

    private void b() {
        Surface surface = this.d;
        if (surface != null) {
            surface.release();
        }
        this.d = null;
    }

    public void a() {
        setMediaPlayerSurface(null);
        b();
        this.c = null;
        this.f12345a.setSurfaceTextureListener(null);
    }
}
