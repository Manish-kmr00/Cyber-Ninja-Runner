package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2912nY<T> implements Comparator<T> {
    @Override // java.util.Comparator
    public abstract int compare(@ParametricNullness T left, @ParametricNullness T right);

    public static <C extends Comparable> AbstractC2912nY<C> A03() {
        return C1794Nw.A02;
    }

    public static <T> AbstractC2912nY<T> A04(Comparator<T> comparator) {
        if (comparator instanceof AbstractC2912nY) {
            return (AbstractC2912nY) comparator;
        }
        return new OS(comparator);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.hs != com.google.common.base.Function<F, ? extends T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nY != com.google.common.collect.Ordering<T> */
    public final <F> AbstractC2912nY<F> A05(InterfaceC2570hs<F, ? extends T> function) {
        return new OY(function, this);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.nY != com.google.common.collect.Ordering<T> */
    public <S extends T> AbstractC2912nY<S> A06() {
        return new C1791Nt(this);
    }
}
