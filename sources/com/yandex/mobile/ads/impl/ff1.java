package com.yandex.mobile.ads.impl;

import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ff1<T> implements Comparator<T> {
    public <S extends T> ff1<S> b() {
        return new jr1(this);
    }

    public static <T> ff1<T> a(Comparator<T> comparator) {
        if (comparator instanceof ff1) {
            return (ff1) comparator;
        }
        return new vq(comparator);
    }

    public static <C extends Comparable> ff1<C> a() {
        return mc1.b;
    }

    protected ff1() {
    }
}
