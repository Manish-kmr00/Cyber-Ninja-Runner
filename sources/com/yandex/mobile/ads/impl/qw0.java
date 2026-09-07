package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class qw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cx0 f10054a = new cx0();

    public final Set<su0> a(o41 nativeAdBlock) {
        Intrinsics.checkNotNullParameter(nativeAdBlock, "nativeAdBlock");
        return SequencesKt.toSet(SequencesKt.filterNotNull(SequencesKt.map(SequencesKt.flatMapIterable(CollectionsKt.asSequence(nativeAdBlock.c().e()), new a()), b.b)));
    }

    static final class a extends Lambda implements Function1<c41, Set<? extends ax0>> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Set<? extends ax0> invoke(c41 c41Var) {
            c41 nativeAd = c41Var;
            Intrinsics.checkNotNullParameter(nativeAd, "nativeAd");
            qw0.this.f10054a.getClass();
            return cx0.a(nativeAd);
        }
    }

    static final class b extends Lambda implements Function1<ax0, su0> {
        public static final b b = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final su0 invoke(ax0 ax0Var) {
            ax0 mediaValue = ax0Var;
            Intrinsics.checkNotNullParameter(mediaValue, "mediaValue");
            return mediaValue.b();
        }
    }
}
