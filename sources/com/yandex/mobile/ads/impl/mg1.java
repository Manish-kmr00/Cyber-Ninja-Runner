package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.pauseroll.Pauseroll;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class mg1 implements lt0<Pauseroll> {
    @Override // com.yandex.mobile.ads.impl.lt0
    public final tn0 a(mt0 playbackController) {
        Intrinsics.checkNotNullParameter(playbackController, "playbackController");
        return new tn0(playbackController);
    }
}
