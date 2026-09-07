package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class zm1 implements uc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final eg2 f10829a;
    private final List<a> b;

    public zm1(fg2 videoTracker) {
        Intrinsics.checkNotNullParameter(videoTracker, "videoTracker");
        this.f10829a = videoTracker;
        this.b = CollectionsKt.mutableListOf(new a(eg2.a.b, 0.25f), new a(eg2.a.c, 0.5f), new a(eg2.a.d, 0.75f));
    }

    @Override // com.yandex.mobile.ads.impl.uc2
    public final void a(long j, long j2) {
        if (j != 0) {
            Iterator<a> it = this.b.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.a() * j <= j2) {
                    this.f10829a.a(next.b());
                    it.remove();
                }
            }
        }
    }

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final eg2.a f10830a;
        private final float b;

        public a(eg2.a trackerQuartile, float f) {
            Intrinsics.checkNotNullParameter(trackerQuartile, "trackerQuartile");
            this.f10830a = trackerQuartile;
            this.b = f;
        }

        public final eg2.a b() {
            return this.f10830a;
        }

        public final float a() {
            return this.b;
        }
    }
}
