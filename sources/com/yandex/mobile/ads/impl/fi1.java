package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class fi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y60 f8899a;

    public fi1(y60 playerProvider) {
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        this.f8899a = playerProvider;
    }

    public final void a() {
        Player playerA = this.f8899a.a();
        if (playerA == null) {
            return;
        }
        playerA.setPlayWhenReady(false);
    }

    public final void b() {
        Player playerA = this.f8899a.a();
        if (playerA == null) {
            return;
        }
        playerA.setPlayWhenReady(true);
    }
}
