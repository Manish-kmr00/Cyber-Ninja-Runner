package com.yandex.mobile.ads.impl;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class mb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<r70> f9622a;
    private final List<e62> b;

    private mb2(List<r70> list, List<e62> list2) {
        this.f9622a = list;
        this.b = list2;
    }

    public final List<r70> a() {
        return this.f9622a;
    }

    public final List<e62> b() {
        return this.b;
    }

    public /* synthetic */ mb2(List list, List list2, int i) {
        this(list, list2);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<r70> f9623a = CollectionsKt.emptyList();
        private List<e62> b = CollectionsKt.emptyList();

        public final a a(List<r70> extensions) {
            Intrinsics.checkNotNullParameter(extensions, "extensions");
            this.f9623a = extensions;
            return this;
        }

        public final a b(List<e62> trackingEvents) {
            Intrinsics.checkNotNullParameter(trackingEvents, "trackingEvents");
            this.b = trackingEvents;
            return this;
        }

        public final mb2 a() {
            return new mb2(this.f9623a, this.b, 0);
        }
    }
}
