package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class mr0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ig<?>> f9665a;

    private mr0(List list) {
        this.f9665a = list;
    }

    public /* synthetic */ mr0(List list, int i) {
        this(list);
    }

    public final List<ig<?>> a() {
        return this.f9665a;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<? extends ig<?>> f9666a = CollectionsKt.emptyList();

        public final void a(List<? extends ig<?>> assets) {
            Intrinsics.checkNotNullParameter(assets, "assets");
            this.f9666a = assets;
        }

        public final void a(rr0 link) {
            Intrinsics.checkNotNullParameter(link, "link");
        }

        public final mr0 a() {
            return new mr0(this.f9666a, 0);
        }
    }
}
