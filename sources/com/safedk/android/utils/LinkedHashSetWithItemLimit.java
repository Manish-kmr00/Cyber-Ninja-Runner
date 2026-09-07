package com.safedk.android.utils;

import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes7.dex */
public class LinkedHashSetWithItemLimit<T> extends LinkedHashSet<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8148a = "LinkedHashSetWithItemLimit";
    private long b;

    public LinkedHashSetWithItemLimit(long maxSize) {
        this.b = maxSize;
        Logger.d(f8148a, "LinkedHashSetWithItemLimit created. maxSize = " + maxSize);
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public synchronized boolean add(T item) {
        if (size() >= this.b) {
            a();
        }
        return super.add(item);
    }

    private void a() {
        if (size() > 0) {
            remove(iterator().next());
        }
    }
}
