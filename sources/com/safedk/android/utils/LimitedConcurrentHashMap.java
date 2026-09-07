package com.safedk.android.utils;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class LimitedConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8147a = 15;
    private static final String b = "LimitedConcurrentHashMap";
    private int c;
    private final ArrayDeque<K> d;

    public LimitedConcurrentHashMap() {
        this(15);
    }

    public LimitedConcurrentHashMap(int maxSize) {
        this.c = -1;
        this.d = new ArrayDeque<>();
        if (maxSize > 0) {
            this.c = maxSize;
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public synchronized V put(K key, V value) {
        if (containsKey(key)) {
            this.d.remove(key);
            this.d.addLast(key);
            super.put(key, value);
        } else {
            if (this.c > 0 && this.d.size() > 0 && size() == this.c) {
                super.remove(this.d.removeFirst());
            }
            this.d.addLast(key);
            super.put(key, value);
        }
        return value;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public synchronized V remove(Object obj) {
        this.d.remove(obj);
        return (V) super.remove(obj);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.Map, java.util.concurrent.ConcurrentMap
    public synchronized boolean remove(Object key, Object value) {
        this.d.remove(key);
        return super.remove(key, value);
    }

    public synchronized V a() {
        return get(this.d.getFirst());
    }

    public int b() {
        return this.c;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap
    public String toString() {
        return "LimitedConcurrentHashMap size=" + size() + " map is: " + super.toString();
    }

    @Override // java.util.AbstractMap
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public LimitedConcurrentHashMap<K, V> clone() {
        LimitedConcurrentHashMap<K, V> limitedConcurrentHashMap = new LimitedConcurrentHashMap<>(this.c);
        limitedConcurrentHashMap.putAll(this);
        return limitedConcurrentHashMap;
    }
}
