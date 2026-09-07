package com.inmobi.media;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.r8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class TextureViewSurfaceTextureListenerC3541r8 implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3556s8 f3416a;

    public TextureViewSurfaceTextureListenerC3541r8(C3556s8 c3556s8) {
        this.f3416a = c3556s8;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture texture, int i, int i2) {
        Intrinsics.checkNotNullParameter(texture, "texture");
        this.f3416a.b = new Surface(texture);
        this.f3416a.e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture texture) {
        Intrinsics.checkNotNullParameter(texture, "texture");
        Surface surface = this.f3416a.b;
        if (surface != null) {
            surface.release();
        }
        C3556s8 c3556s8 = this.f3416a;
        c3556s8.b = null;
        C3456l8 c3456l8 = c3556s8.n;
        if (c3456l8 != null) {
            c3456l8.c();
        }
        this.f3416a.g();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surface, int i, int i2) {
        O7 o7;
        Intrinsics.checkNotNullParameter(surface, "surface");
        O7 mediaPlayer = this.f3416a.getMediaPlayer();
        boolean z = mediaPlayer != null && mediaPlayer.b == 3;
        boolean z2 = i > 0 && i2 > 0;
        if (z && z2) {
            Object tag = this.f3416a.getTag();
            if (tag instanceof C3426j8) {
                Object obj = ((C3426j8) tag).t.get("seekPosition");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue != 0) {
                    C3556s8 c3556s8 = this.f3416a;
                    if (c3556s8.a() && (o7 = c3556s8.c) != null) {
                        o7.seekTo(iIntValue);
                    }
                }
            }
            this.f3416a.start();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture texture) {
        Intrinsics.checkNotNullParameter(texture, "texture");
    }
}
