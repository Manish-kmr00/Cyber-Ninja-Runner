package com.yandex.mobile.ads.impl;

import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class wa1 implements cb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final oa1 f10548a;
    private final ub1 b;

    public wa1(oa1 player, ub1 videoView) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.f10548a = player;
        this.b = videoView;
    }

    @Override // com.yandex.mobile.ads.impl.cb1
    public final void b() {
        this.f10548a.a(this.b.c());
    }

    @Override // com.yandex.mobile.ads.impl.cb1
    public final void a() {
        this.b.b().b().clearAnimation();
        this.f10548a.a((TextureView) null);
    }
}
