package com.smaato.sdk.core.util.collections;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.BiConsumer;
import com.smaato.sdk.core.util.fi.BiFunction;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class Maps {
    public static <F, K, V> Map<K, V> toMap(Iterable<F> iterable, Function<F, K> function, Function<F, V> function2) {
        HashMap map = new HashMap();
        for (F f : iterable) {
            map.put(function.apply(f), function2.apply(f));
        }
        return map;
    }

    public static <F, K, V> Map<K, V> toMapWithOrder(Iterable<F> iterable, Function<F, K> function, Function<F, V> function2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (F f : iterable) {
            linkedHashMap.put(function.apply(f), function2.apply(f));
        }
        return linkedHashMap;
    }

    public static <K, V> List<K> filteredKeys(Map<K, V> map, Predicate<V> predicate) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (predicate.test(entry.getValue())) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    public static <K, V> K firstMatchedKey(Map<K, V> map, Predicate<V> predicate) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (predicate.test(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static <K, V> Map.Entry<K, V> firstMatchedEntry(Map<K, V> map, Predicate<V> predicate) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (predicate.test(entry.getValue())) {
                return entry;
            }
        }
        return null;
    }

    public static <K, V> Map<K, V> filter(Map<K, V> map, Predicate<V> predicate) {
        HashMap map2 = new HashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            if (predicate.test(value)) {
                map2.put(entry.getKey(), value);
            }
        }
        return map2;
    }

    public static <K, V> Map<K, V> toImmutableMap(Map<? extends K, ? extends V> map) {
        if (map == null || map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static <K, V> void forEach(Map<K, V> map, BiConsumer<? super K, ? super V> biConsumer) {
        Objects.requireNonNull(biConsumer);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException e) {
                throw new ConcurrentModificationException(e.getMessage());
            }
        }
    }

    @SafeVarargs
    public static <K, V> Map<K, V> mapOf(Map.Entry<K, V>... entryArr) {
        return Collections.unmodifiableMap(mutableMapOf(entryArr));
    }

    public static <K, V> Map.Entry<K, V> entryOf(K k, V v) {
        return new AbstractMap.SimpleImmutableEntry(k, v);
    }

    private static Map mutableMapOf(Map.Entry... entryArr) {
        Objects.requireNonNull(entryArr, "entries is null");
        HashMap map = new HashMap();
        for (int i = 0; i < entryArr.length; i++) {
            Map.Entry entry = entryArr[i];
            Objects.requireNonNull(entry, "entry at index " + i + "is null");
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    public static <K, V, R> R reduce(Map<K, V> map, R r, BiFunction<Map.Entry<K, V>, R, R> biFunction) {
        Objects.requireNonNull(biFunction);
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            r = biFunction.apply(it.next(), r);
        }
        return r;
    }

    @SafeVarargs
    public static <K, V> Map<K, V> merge(Map<K, V>... mapArr) {
        HashMap map = new HashMap();
        for (Map<K, V> map2 : mapArr) {
            map.putAll(map2);
        }
        return map;
    }
}
