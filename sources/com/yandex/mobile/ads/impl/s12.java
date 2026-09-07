package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class s12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10162a;
    private final rb2<do0> b;
    private final ic c;

    public s12(Context context, rb2<do0> videoAdInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        this.f10162a = context;
        this.b = videoAdInfo;
        this.c = new ic(videoAdInfo.g());
    }

    public final dz a() {
        int iOrdinal = new w12(this.c).a(this.b).ordinal();
        if (iOrdinal == 0) {
            return new o00(this.f10162a);
        }
        if (iOrdinal == 1) {
            return new n00(this.f10162a);
        }
        if (iOrdinal == 2) {
            return new sz();
        }
        throw new NoWhenBranchMatchedException();
    }
}
