package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.q;
import java.util.Comparator;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements Comparator<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f6797a;
    public final Long b;
    public final Integer c;
    public final Integer d;

    public b(double d, Long l, Integer num, Integer num2) {
        this.f6797a = d;
        this.b = l;
        this.c = num;
        this.d = num2;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(q mf1, q mf2) {
        Intrinsics.checkNotNullParameter(mf1, "mf1");
        Intrinsics.checkNotNullParameter(mf2, "mf2");
        Pair pairB = g.b(mf1, mf2, this.f6797a, this.b, this.c, this.d);
        return Intrinsics.compare(((Number) pairB.component2()).intValue(), ((Number) pairB.component1()).intValue());
    }

    public /* synthetic */ b(double d, Long l, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2);
    }
}
