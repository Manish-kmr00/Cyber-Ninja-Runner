package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.Player;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ol1 implements xl1, ti1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xl1 f9831a;
    private yh1 b;
    private lb0 c;

    public ol1(xl1 progressProvider) {
        Intrinsics.checkNotNullParameter(progressProvider, "progressProvider");
        this.f9831a = progressProvider;
        this.b = yh1.a.a();
    }

    @Override // com.yandex.mobile.ads.impl.xl1
    public final yh1 a() {
        xl1 xl1Var = this.c;
        if (xl1Var == null) {
            xl1Var = this.f9831a;
        }
        yh1 yh1VarA = xl1Var.a();
        this.b = yh1VarA;
        return yh1VarA;
    }

    @Override // com.yandex.mobile.ads.impl.ti1
    public final void a(Player player) {
        this.c = player == null ? new lb0(this.b) : null;
    }
}
