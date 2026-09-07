package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class gn2 implements xa2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final re1 f9022a;

    public gn2(re1 omSdkUsageValidator) {
        Intrinsics.checkNotNullParameter(omSdkUsageValidator, "omSdkUsageValidator");
        this.f9022a = omSdkUsageValidator;
    }

    @Override // com.yandex.mobile.ads.impl.xa2
    public final fn2 a(Context context, sc2 videoAdPosition, gd2 gd2Var, List verifications) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdPosition, "videoAdPosition");
        Intrinsics.checkNotNullParameter(verifications, "verifications");
        if (this.f9022a.a(context)) {
            return new fn2(context, videoAdPosition, gd2Var, verifications, new cg2(context), new se1(), new wm2(context).c());
        }
        return null;
    }
}
