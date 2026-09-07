package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class jc0<K, V> extends kc0 implements Map<K, V> {
    protected abstract Map<K, V> b();

    protected final boolean a(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return ((px1.a) entrySet()).equals(((Map) obj).entrySet());
    }

    protected jc0() {
    }

    @Override // java.util.Map
    public int size() {
        return b().size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return b().isEmpty();
    }

    @Override // java.util.Map
    @CheckForNull
    public final V remove(@CheckForNull Object obj) {
        return b().remove(obj);
    }

    @Override // java.util.Map
    public final void clear() {
        b().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return b().containsKey(obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        return b().get(obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public final V put(K k, V v) {
        return b().put(k, v);
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        b().putAll(map);
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return b().keySet();
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return b().values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return b().entrySet();
    }

    protected final int c() {
        return px1.a(entrySet());
    }
}
