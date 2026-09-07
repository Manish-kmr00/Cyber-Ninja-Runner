package io.bidmachine.rendering.internal.adform.video.player.media;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.BidMachineVideoBridge;
import com.safedk.android.utils.Logger;
import io.bidmachine.rendering.model.Error;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class a extends io.bidmachine.rendering.internal.adform.video.player.a {
    private final Context k;
    private final MediaPlayer l;
    private final io.bidmachine.rendering.internal.adform.video.player.media.b m;
    private float n = 1.0f;

    private class b implements io.bidmachine.rendering.internal.adform.video.player.media.c {
        private b() {
        }

        @Override // io.bidmachine.rendering.internal.adform.video.player.media.c
        public void a() {
            if (a.this.e()) {
                a.this.b(new Error("Surface Destroyed"));
            }
        }
    }

    private class c implements MediaPlayer.OnCompletionListener {
        private c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            Logger.d("BidMachine|SafeDK: Execution> Lio/bidmachine/rendering/internal/adform/video/player/media/a$c;->onCompletion(Landroid/media/MediaPlayer;)V");
            CreativeInfoManager.onVideoCompleted("io.bidmachine", mediaPlayer, "media-player");
            safedk_a$c_onCompletion_1dbd6b6763ec0f23b66f979ae3643c8c(mediaPlayer);
        }

        public void safedk_a$c_onCompletion_1dbd6b6763ec0f23b66f979ae3643c8c(MediaPlayer p0) {
            a.this.q();
        }
    }

    private class d implements MediaPlayer.OnErrorListener {
        private d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            a.this.a(new Error("MediaPlayer - onError (what - " + i + ", extra - " + i2 + ")"));
            return true;
        }
    }

    private class e implements MediaPlayer.OnPreparedListener {
        private e() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a.this.d();
        }
    }

    private class f implements MediaPlayer.OnSeekCompleteListener {
        private f() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            a aVar = a.this;
            aVar.a(aVar.h());
        }
    }

    public a(Context context) {
        this.k = context.getApplicationContext();
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.l = mediaPlayer;
        mediaPlayer.setLooping(false);
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build());
        mediaPlayer.setOnPreparedListener(new e());
        mediaPlayer.setOnErrorListener(new d());
        mediaPlayer.setOnSeekCompleteListener(new f());
        mediaPlayer.setOnCompletionListener(new c());
        io.bidmachine.rendering.internal.adform.video.player.media.b bVar = new io.bidmachine.rendering.internal.adform.video.player.media.b(context);
        this.m = bVar;
        bVar.setListener(new b());
        bVar.setMediaPlayer(mediaPlayer);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void A() {
        this.l.prepareAsync();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void B() {
        BidMachineVideoBridge.MediaPlayerStop(this.l);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void c(long j) {
        this.l.seekTo((int) j);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void d(float f2) {
        this.n = f2;
        this.l.setVolume(f2, f2);
        c(f2);
        a(f2);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public long g() {
        return this.l.getDuration();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public float getVolume() {
        return this.n;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public long h() {
        return this.l.getCurrentPosition();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.b
    public View o() {
        return this.m;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected boolean w() {
        return this.l.isPlaying();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected boolean x() {
        return false;
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void y() {
        BidMachineVideoBridge.MediaPlayerPause(this.l);
        k();
        b();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void z() {
        BidMachineVideoBridge.MediaPlayerStart(this.l);
        n();
        v();
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a
    protected void b(Uri uri) throws IOException {
        this.l.reset();
        BidMachineVideoBridge.MediaPlayerSetDataSource(this.l, this.k, uri);
    }

    @Override // io.bidmachine.rendering.internal.adform.video.player.a, io.bidmachine.rendering.internal.adform.video.player.b
    public void a() {
        super.a();
        this.m.a();
        this.l.reset();
        BidMachineVideoBridge.MediaPlayerRelease(this.l);
    }
}
