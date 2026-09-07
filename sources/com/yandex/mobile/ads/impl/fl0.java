package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.instream.inroll.Inroll;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class fl0 implements lt0<Inroll> {
    @Override // com.yandex.mobile.ads.impl.lt0
    public final tn0 a(mt0 playbackController) {
        Intrinsics.checkNotNullParameter(playbackController, "playbackController");
        return new tn0(playbackController);
    }
}
