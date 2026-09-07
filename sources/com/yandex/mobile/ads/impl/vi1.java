package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class vi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y60 f10483a;
    private Float b;

    public vi1(y60 playerProvider) {
        Intrinsics.checkNotNullParameter(playerProvider, "playerProvider");
        this.f10483a = playerProvider;
    }

    public final void a(float f) {
        if (this.b == null) {
            this.b = a();
        }
        Player playerA = this.f10483a.a();
        if (playerA == null) {
            return;
        }
        playerA.setVolume(f);
    }

    public final void b() {
        Float f = this.b;
        if (f != null) {
            float fFloatValue = f.floatValue();
            Player playerA = this.f10483a.a();
            if (playerA != null) {
                playerA.setVolume(fFloatValue);
            }
        }
        this.b = null;
    }

    public final Float a() {
        Player playerA = this.f10483a.a();
        if (playerA != null) {
            return Float.valueOf(playerA.getVolume());
        }
        return null;
    }
}
