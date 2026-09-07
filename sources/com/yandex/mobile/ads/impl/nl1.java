package com.yandex.mobile.ads.impl;

import androidx.media3.common.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class nl1 implements wl1, si1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wl1 f9739a;
    private zh1 b;
    private kb0 c;

    public nl1(wl1 progressProvider) {
        Intrinsics.checkNotNullParameter(progressProvider, "progressProvider");
        this.f9739a = progressProvider;
        this.b = zh1.a.a();
    }

    @Override // com.yandex.mobile.ads.impl.wl1
    public final zh1 a() {
        wl1 wl1Var = this.c;
        if (wl1Var == null) {
            wl1Var = this.f9739a;
        }
        zh1 zh1VarA = wl1Var.a();
        this.b = zh1VarA;
        return zh1VarA;
    }

    @Override // com.yandex.mobile.ads.impl.si1
    public final void a(Player player) {
        this.c = player == null ? new kb0(this.b) : null;
    }
}
