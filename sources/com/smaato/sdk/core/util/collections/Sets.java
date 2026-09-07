package com.smaato.sdk.core.util.collections;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.core.util.fi.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes9.dex */
public final class Sets {
    public static <T> Set<T> retainToSet(Collection<T> collection, Predicate<T> predicate) {
        HashSet hashSet = new HashSet();
        for (T t : collection) {
            if (predicate.test(t)) {
                hashSet.add(t);
            }
        }
        return hashSet;
    }

    public static <E> Set<E> toSet(Iterable<E> iterable) {
        HashSet hashSet = new HashSet();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next());
        }
        return hashSet;
    }

    public static <E, R> Set<R> toSet(Iterable<E> iterable, Function<E, R> function) {
        HashSet hashSet = new HashSet();
        for (E e : iterable) {
            if (e != null) {
                hashSet.add(function.apply(e));
            }
        }
        return hashSet;
    }

    public static <E> Set<E> toImmutableSet(Collection<E> collection) {
        if (collection == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(collection));
    }

    @SafeVarargs
    public static <E> Set<E> toImmutableSetOf(E... eArr) {
        Objects.requireNonNull(eArr);
        return toImmutableSet(Arrays.asList(eArr));
    }

    public static <E> Set<E> of(E... eArr) {
        return new HashSet(Arrays.asList(eArr));
    }
}
