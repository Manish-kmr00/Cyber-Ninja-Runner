package com.yandex.mobile.ads.impl;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes12.dex */
final class hq0 extends b82<Object> {
    boolean b;
    final /* synthetic */ Object c;

    hq0(Object obj) {
        this.c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.b) {
            this.b = true;
            return this.c;
        }
        throw new NoSuchElementException();
    }
}
