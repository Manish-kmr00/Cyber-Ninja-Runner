package com.yandex.mobile.ads.impl;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes8.dex */
public abstract class k<T> extends b82<T> {
    private int b = 2;

    @CheckForNull
    private T c;

    @CheckForNull
    protected abstract T a();

    @CheckForNull
    protected final void b() {
        this.b = 3;
    }

    protected k() {
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.b;
        if (i != 4) {
            int iA = f9.a(i);
            if (iA == 0) {
                return true;
            }
            if (iA == 2) {
                return false;
            }
            this.b = 4;
            this.c = a();
            if (this.b == 3) {
                return false;
            }
            this.b = 1;
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.b = 2;
            T t = this.c;
            this.c = null;
            return t;
        }
        throw new NoSuchElementException();
    }
}
