package com.smaato.sdk.core.util.collections;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes12.dex */
public class CacheSet<T> extends LinkedHashSet<T> {
    public T poll() {
        int size = size() - 1;
        if (size < 0) {
            return null;
        }
        T t = (T) toArray()[size];
        remove(t);
        return t;
    }
}
