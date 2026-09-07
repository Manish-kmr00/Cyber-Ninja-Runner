package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class gz1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn0 f9047a;

    public gz1(zn0 instreamVastAdPlayer) {
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        this.f9047a = instreamVastAdPlayer;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.f9047a.e();
    }
}
