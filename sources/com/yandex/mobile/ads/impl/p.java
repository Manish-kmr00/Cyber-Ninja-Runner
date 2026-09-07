package com.yandex.mobile.ads.impl;

import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes8.dex */
abstract class p<K, V> implements Map.Entry<K, V> {
    public final String toString() {
        return getKey() + "=" + getValue();
    }

    p() {
    }

    @Override // java.util.Map.Entry
    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return vd1.a(getKey(), entry.getKey()) && vd1.a(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }
}
