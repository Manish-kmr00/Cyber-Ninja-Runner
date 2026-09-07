package com.facebook.ads.redexgen.core;

import com.google.common.collect.ParametricNullness;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2755kv<T> implements Iterator<T> {
    public int A00;
    public int A01;
    public int A02;
    public final /* synthetic */ C2758ky A03;

    @ParametricNullness
    public abstract T A03(int entry);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kv != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    public AbstractC2755kv(final C2758ky this$0) {
        this.A03 = this$0;
        this.A01 = this.A03.A03;
        this.A00 = this.A03.A0a();
        this.A02 = -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kv != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    public /* synthetic */ AbstractC2755kv(C2758ky c2758ky, OX ox) {
        this(c2758ky);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kv != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    private void A01() {
        if (this.A03.A03 == this.A01) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kv != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    private final void A02() {
        this.A01 += 32;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kv != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00 >= 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kv != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    @Override // java.util.Iterator
    @ParametricNullness
    public final T next() {
        A01();
        if (hasNext()) {
            this.A02 = this.A00;
            T tA03 = A03(this.A00);
            this.A00 = this.A03.A0b(this.A00);
            return tA03;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kv != com.google.common.collect.CompactHashMap<K, V>$Itr<T> */
    @Override // java.util.Iterator
    public final void remove() {
        A01();
        AbstractC2748ko.A04(this.A02 >= 0);
        A02();
        this.A03.remove(this.A03.A0E(this.A02));
        this.A00 = this.A03.A0c(this.A00, this.A02);
        this.A02 = -1;
    }
}
