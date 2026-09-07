package com.yandex.mobile.ads.impl;

import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class vb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oa1 f10470a;

    public vb1(oa1 videoAdPlayer) {
        Intrinsics.checkNotNullParameter(videoAdPlayer, "videoAdPlayer");
        this.f10470a = videoAdPlayer;
    }

    public final void a(ub1 nativeVideoView) {
        Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
        TextureView textureViewC = nativeVideoView.c();
        this.f10470a.a(textureViewC);
        textureViewC.setVisibility(0);
        nativeVideoView.a().setVisibility(0);
        nativeVideoView.b().setVisibility(0);
    }

    public final void b(ub1 nativeVideoView) {
        Intrinsics.checkNotNullParameter(nativeVideoView, "nativeVideoView");
        TextureView textureViewC = nativeVideoView.c();
        this.f10470a.a((TextureView) null);
        textureViewC.setVisibility(8);
        nativeVideoView.a().setVisibility(8);
        nativeVideoView.b().setVisibility(8);
    }
}
