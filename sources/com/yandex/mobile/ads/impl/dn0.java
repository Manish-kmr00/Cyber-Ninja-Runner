package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class dn0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rb2<do0> f8715a;
    private final su b;
    private final s12 c;
    private final hz d;

    public dn0(Context context, rb2<do0> videoAdInfo, su creativeAssetsProvider, s12 sponsoredAssetProviderCreator, hz callToActionAssetProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
        Intrinsics.checkNotNullParameter(creativeAssetsProvider, "creativeAssetsProvider");
        Intrinsics.checkNotNullParameter(sponsoredAssetProviderCreator, "sponsoredAssetProviderCreator");
        Intrinsics.checkNotNullParameter(callToActionAssetProvider, "callToActionAssetProvider");
        this.f8715a = videoAdInfo;
        this.b = creativeAssetsProvider;
        this.c = sponsoredAssetProviderCreator;
        this.d = callToActionAssetProvider;
    }

    public final List<ig<?>> a() {
        Object next;
        ru ruVarB = this.f8715a.b();
        this.b.getClass();
        List<ig<?>> mutableList = CollectionsKt.toMutableList((Collection) su.a(ruVarB));
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{new Pair("sponsored", this.c.a()), new Pair("call_to_action", this.d)})) {
            String str = (String) pair.component1();
            dz dzVar = (dz) pair.component2();
            Iterator<T> it = mutableList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.areEqual(((ig) next).b(), str));
            if (((ig) next) == null) {
                mutableList.add(dzVar.a());
            }
        }
        return mutableList;
    }
}
