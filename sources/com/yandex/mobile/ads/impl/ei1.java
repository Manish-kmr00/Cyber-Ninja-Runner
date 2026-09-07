package com.yandex.mobile.ads.impl;

import androidx.media3.common.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ei1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x60 f8803a;

    public ei1(x60 playerProvider) {
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        this.f8803a = playerProvider;
    }

    public final void a() {
        Player playerA = this.f8803a.a();
        if (playerA == null) {
            return;
        }
        playerA.setPlayWhenReady(false);
    }

    public final void b() {
        Player playerA = this.f8803a.a();
        if (playerA == null) {
            return;
        }
        playerA.setPlayWhenReady(true);
    }
}
