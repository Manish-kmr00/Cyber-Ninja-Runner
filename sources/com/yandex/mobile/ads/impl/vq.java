package com.yandex.mobile.ads.impl;

import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes6.dex */
final class vq<T> extends ff1<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> b;

    vq(Comparator<T> comparator) {
        this.b = (Comparator) rj1.a(comparator);
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return this.b.compare(t, t2);
    }

    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof vq) {
            return this.b.equals(((vq) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b.toString();
    }
}
