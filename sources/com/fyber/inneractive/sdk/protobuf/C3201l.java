package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3201l implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2289a = 0;
    public final int b;
    public final /* synthetic */ AbstractC3221s c;

    public C3201l(AbstractC3221s abstractC3221s) {
        this.c = abstractC3221s;
        this.b = abstractC3221s.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2289a < this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f2289a;
        if (i >= this.b) {
            throw new NoSuchElementException();
        }
        this.f2289a = i + 1;
        return Byte.valueOf(this.c.d(i));
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
