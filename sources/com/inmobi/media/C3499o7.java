package com.inmobi.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: renamed from: com.inmobi.media.o7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3499o7 implements Iterator, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3389a;
    public final /* synthetic */ C3513p7 b;

    public C3499o7(C3513p7 c3513p7) {
        this.b = c3513p7;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3389a < this.b.B;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            ArrayList arrayList = this.b.A;
            int i = this.f3389a;
            this.f3389a = i + 1;
            C3455l7 c3455l7 = (C3455l7) arrayList.get(i);
            Intrinsics.checkNotNull(c3455l7);
            return c3455l7;
        } catch (IndexOutOfBoundsException e) {
            this.f3389a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
