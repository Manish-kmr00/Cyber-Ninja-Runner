package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vt0 implements wi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gm0 f10506a;
    private final dt b;

    public vt0(gm0 instreamAdPlayerController, dt instreamAdBreak) {
        Intrinsics.checkNotNullParameter(instreamAdPlayerController, "instreamAdPlayerController");
        Intrinsics.checkNotNullParameter(instreamAdBreak, "instreamAdBreak");
        this.f10506a = instreamAdPlayerController;
        this.b = instreamAdBreak;
    }

    @Override // com.yandex.mobile.ads.impl.wi1
    public final float getVolume() {
        do0 do0Var = (do0) CollectionsKt.firstOrNull((List) this.b.g());
        if (do0Var != null) {
            return this.f10506a.c(do0Var);
        }
        return 0.0f;
    }
}
