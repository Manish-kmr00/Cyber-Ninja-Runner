package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class gg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final xa2 f9002a;
    private final kz1 b;

    public final fg2 a(Context context, rb2 videoAdInfo, sc2 videoAdPosition) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(videoAdPosition, "videoAdPosition");
        cg2 cg2Var = new cg2(context);
        je2 je2Var = new je2(context);
        er erVar = new er();
        erVar.a(new av(videoAdInfo.b(), cg2Var, je2Var));
        erVar.a(new kd2(videoAdInfo.g(), cg2Var));
        fn2 fn2VarA = this.f9002a.a(context, videoAdPosition, this.b.a(videoAdInfo.b()), videoAdInfo.g().d());
        if (fn2VarA != null) {
            erVar.a(fn2VarA);
        }
        return new fg2(erVar);
    }

    public /* synthetic */ gg2(xa2 xa2Var) {
        this(xa2Var, new kz1());
    }

    public gg2(xa2 verificationVideoTrackerProvider, kz1 skipInfoParser) {
        Intrinsics.checkNotNullParameter(verificationVideoTrackerProvider, "verificationVideoTrackerProvider");
        Intrinsics.checkNotNullParameter(skipInfoParser, "skipInfoParser");
        this.f9002a = verificationVideoTrackerProvider;
        this.b = skipInfoParser;
    }
}
