package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class qm1 implements is1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private is1 f10036a;

    @Override // com.yandex.mobile.ads.impl.is1
    public final void a(hw1 reward) {
        Intrinsics.checkNotNullParameter(reward, "reward");
        is1 is1Var = this.f10036a;
        if (is1Var != null) {
            is1Var.a(reward);
        }
    }

    public final void a(is1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.f10036a = listener;
    }
}
