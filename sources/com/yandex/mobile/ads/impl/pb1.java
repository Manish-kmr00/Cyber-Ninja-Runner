package com.yandex.mobile.ads.impl;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class pb1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cx0 f9910a;

    public final SortedSet b(u61 nativeAdResponse) {
        Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
        return SequencesKt.toSortedSet(SequencesKt.map(SequencesKt.map(SequencesKt.mapNotNull(SequencesKt.flatMapIterable(CollectionsKt.asSequence(nativeAdResponse.e()), new sb1(this)), tb1.b), qb1.b), rb1.b));
    }

    public final Set<uj0> c(u61 nativeAdResponse) {
        Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
        return SequencesKt.toSet(SequencesKt.mapNotNull(SequencesKt.mapNotNull(SequencesKt.flatMapIterable(CollectionsKt.asSequence(nativeAdResponse.e()), new sb1(this)), tb1.b), c.b));
    }

    public /* synthetic */ pb1() {
        this(new cx0());
    }

    public pb1(cx0 mediaValuesProvider) {
        Intrinsics.checkNotNullParameter(mediaValuesProvider, "mediaValuesProvider");
        this.f9910a = mediaValuesProvider;
    }

    public final List<Pair<String, String>> a(u61 nativeAdResponse) {
        Intrinsics.checkNotNullParameter(nativeAdResponse, "nativeAdResponse");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.map(SequencesKt.mapNotNull(SequencesKt.flatMapIterable(CollectionsKt.asSequence(nativeAdResponse.e()), new sb1(this)), tb1.b), a.b), b.b));
    }

    static final class a extends Lambda implements Function1<db2, rb2<gb1>> {
        public static final a b = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final rb2<gb1> invoke(db2 db2Var) {
            db2 it = db2Var;
            Intrinsics.checkNotNullParameter(it, "it");
            return it.b();
        }
    }

    static final class b extends Lambda implements Function1<rb2<gb1>, Pair<? extends String, ? extends String>> {
        public static final b b = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Pair<? extends String, ? extends String> invoke(rb2<gb1> rb2Var) {
            rb2<gb1> it = rb2Var;
            Intrinsics.checkNotNullParameter(it, "it");
            return TuplesKt.to(it.d().getUrl(), it.e());
        }
    }

    static final class c extends Lambda implements Function1<db2, uj0> {
        public static final c b = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final uj0 invoke(db2 db2Var) {
            db2 it = db2Var;
            Intrinsics.checkNotNullParameter(it, "it");
            return it.a();
        }
    }
}
