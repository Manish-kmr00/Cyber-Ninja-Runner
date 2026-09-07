package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class jk2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ok2 f9327a;
    private final pd2 b;
    private final ek2 c;

    public final List<eb2> a(List<eb2> videoAds) {
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        mk2 mk2VarA = this.f9327a.a();
        if (mk2VarA == null) {
            return videoAds;
        }
        if (!mk2VarA.a()) {
            this.b.getClass();
            videoAds = pd2.a(videoAds).a();
        }
        if (!mk2VarA.b()) {
            videoAds = CollectionsKt.take(videoAds, 1);
        }
        return this.c.a(videoAds);
    }

    public /* synthetic */ jk2(Context context, eb2 eb2Var) {
        this(context, eb2Var, new ok2(eb2Var), new pd2(), new ek2(context, eb2Var));
    }

    public jk2(Context context, eb2 wrapperAd, ok2 wrapperConfigurationProvider, pd2 wrappersProviderFactory, ek2 wrappedVideoAdCreator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrapperAd, "wrapperAd");
        Intrinsics.checkNotNullParameter(wrapperConfigurationProvider, "wrapperConfigurationProvider");
        Intrinsics.checkNotNullParameter(wrappersProviderFactory, "wrappersProviderFactory");
        Intrinsics.checkNotNullParameter(wrappedVideoAdCreator, "wrappedVideoAdCreator");
        this.f9327a = wrapperConfigurationProvider;
        this.b = wrappersProviderFactory;
        this.c = wrappedVideoAdCreator;
    }
}
