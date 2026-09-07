package io.bidmachine.rendering.internal.adform.video.player.exo;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import io.bidmachine.media3.common.MediaItem;
import io.bidmachine.media3.common.PlaybackException;
import io.bidmachine.media3.common.Player;
import io.bidmachine.media3.exoplayer.ExoPlayer;
import io.bidmachine.media3.ui.PlayerView;

/* JADX INFO: loaded from: classes11.dex */
public class a extends io.bidmachine.rendering.internal.adform.video.player.a {
    private final ExoPlayer k;
    private final PlayerView l;

    /* JADX INFO: renamed from: io.bidmachine.rendering.internal.adform.video.player.exo.a$a, reason: collision with other inner class name */
    public class C0785a implements Player.Listener {
        public C0785a() {
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onIsPlayingChanged(boolean z) {
            if (z) {
                a.this.n();
                a.this.v();
            } else {
                a.this.k();
                a.this.b();
            }
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onPlaybackStateChanged(int i) {
            if (i == 3) {
                a.this.d();
            } else if (i == 4) {
                a.this.q();
            }
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onPlayerError(PlaybackException playbackException) {
            a.this.a(playbackException);
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            a.this.a(positionInfo2.positionMs);
        }

        @Override // io.bidmachine.media3.common.Player.Listener
        public void onVolumeChanged(float f) {
            a.this.c(f);
            a.this.a(f);
        }
    }

    public a(Context context) {
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(context).build();
        this.k = exoPlayerBuild;
        exoPlayerBuild.addListener(new C0785a());
        PlayerView playerView = new PlayerView(context);
        this.l = playerView;
        playerView.setPlayer(exoPlayerBuild);
        playerView.setUseController(false);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void A() {
        this.k.prepare();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void B() {
        this.k.stop();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public long g() {
        return this.k.getDuration();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public float getVolume() {
        return this.k.getVolume();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public long h() {
        return this.k.getCurrentPosition();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public View o() {
        return this.l;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected boolean w() {
        return this.k.isPlaying();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected boolean x() {
        return false;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void y() {
        this.k.pause();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void z() {
        this.k.play();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void c(long j) {
        this.k.seekTo(j);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void d(float f) {
        this.k.setVolume(f);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void b(Uri uri) {
        this.k.setMediaItem(new MediaItem.Builder().setUri(uri).build());
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a, io.bidmachine.rendering.internal.adform.video.player.b
    public void a() {
        super.a();
        this.k.release();
        this.l.setPlayer(null);
    }
}
