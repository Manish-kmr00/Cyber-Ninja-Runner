package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class jz1 implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iz1 f9366a;
    private final gd2 b;
    private boolean c;

    public /* synthetic */ jz1(zm0 zm0Var, do0 do0Var) {
        this(zm0Var, do0Var, new iz1(zm0Var), do0Var.g());
    }

    public jz1(zm0 viewHolderManager, do0 instreamVideoAd, iz1 skipCountDownConfigurator, gd2 gd2Var) {
        Intrinsics.checkNotNullParameter(viewHolderManager, "viewHolderManager");
        Intrinsics.checkNotNullParameter(instreamVideoAd, "instreamVideoAd");
        Intrinsics.checkNotNullParameter(skipCountDownConfigurator, "skipCountDownConfigurator");
        this.f9366a = skipCountDownConfigurator;
        this.b = gd2Var;
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        gd2 gd2Var;
        if (this.c || (gd2Var = this.b) == null) {
            return;
        }
        if (j2 >= gd2Var.a()) {
            this.f9366a.a();
            this.c = true;
        } else {
            this.f9366a.a(this.b.a(), j2);
        }
    }
}
