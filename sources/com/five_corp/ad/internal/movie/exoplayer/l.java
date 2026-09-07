package com.five_corp.ad.internal.movie.exoplayer;

import android.content.Context;
import android.view.TextureView;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import com.five_corp.ad.internal.view.B;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1445a;
    public final DefaultMediaSourceFactory b;
    public final TextureView c;
    public final B d;
    public final MediaItem e;
    public final com.five_corp.ad.internal.ad.m f;
    public a g = null;

    public l(Context context, TextureView textureView, B b, MediaItem mediaItem, com.five_corp.ad.internal.ad.m mVar) {
        this.f1445a = context;
        this.b = new DefaultMediaSourceFactory(context);
        this.c = textureView;
        this.d = b;
        this.e = mediaItem;
        this.f = mVar;
    }

    public final n a() {
        if (this.g == null) {
            throw new IllegalStateException("PlayerResourceBuilderImpl.registerCallback must be called.");
        }
        ExoPlayer.Builder builder = new ExoPlayer.Builder(this.f1445a);
        builder.setMediaSourceFactory(this.b);
        ExoPlayer exoPlayerBuild = builder.build();
        exoPlayerBuild.setMediaItem(this.e);
        exoPlayerBuild.setPlayWhenReady(false);
        exoPlayerBuild.setVideoTextureView(this.c);
        com.five_corp.ad.internal.ad.m mVar = this.f;
        return new n(exoPlayerBuild, this.d, mVar != null ? mVar.f1306a : null, this.g);
    }
}
