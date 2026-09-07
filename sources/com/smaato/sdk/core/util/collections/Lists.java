package com.smaato.sdk.core.util.collections;

import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.util.fi.Function;
import com.smaato.sdk.core.util.fi.NullableFunction;
import com.smaato.sdk.core.util.fi.Predicate;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes10.dex */
public final class Lists {
    public static <T> boolean all(Iterable<T> iterable, Predicate<T> predicate) {
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!predicate.test(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<T> predicate) {
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (predicate.test(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <F, T> List<T> mapLazy(List<F> list, NullableFunction<? super F, ? extends T> nullableFunction) {
        if (list instanceof RandomAccess) {
            return new MappingRandomAccessList(list, nullableFunction);
        }
        return new MappingSequentialList(list, nullableFunction);
    }

    public static <F, T> List<T> map(List<F> list, Function<? super F, ? extends T> function) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(function);
        ArrayList arrayList = new ArrayList();
        for (F f : list) {
            if (f != null) {
                arrayList.add(function.apply(f));
            }
        }
        return toImmutableList((Collection) arrayList);
    }

    @SafeVarargs
    public static <T> List<T> of(T... tArr) {
        return Arrays.asList(tArr);
    }

    @SafeVarargs
    public static <T> List<T> of(Collection<T>... collectionArr) {
        final ArrayList arrayList = new ArrayList();
        for (Collection<T> collection : collectionArr) {
            Objects.onNotNull(collection, new Consumer() { // from class: com.smaato.sdk.core.util.collections.Lists$$ExternalSyntheticLambda0
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    arrayList.addAll((Collection) obj);
                }
            });
        }
        return arrayList;
    }

    public static <T> List<T> filter(Iterable<T> iterable, Predicate<T> predicate) {
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (predicate.test(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static <T> List<T> toImmutableList(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(collection));
    }

    public static <T> List<T> toImmutableList(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return toImmutableList((Collection) arrayList);
    }

    public static <T> List<T> toImmutableListOf(T... tArr) {
        Objects.requireNonNull(tArr);
        return toImmutableList((Collection) Arrays.asList(tArr));
    }

    @SafeVarargs
    public static <T> List<T> join(List<T>... listArr) {
        int size = 0;
        for (List<T> list : listArr) {
            size += list.size();
        }
        if (size == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(size);
        for (List<T> list2 : listArr) {
            arrayList.addAll(list2);
        }
        return toImmutableList((Collection) arrayList);
    }

    public static <T> List<T> reverseList(List<T> list) {
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            arrayList.add(list.get(size));
        }
        return arrayList;
    }

    private static class MappingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        final List<F> fromList;
        final NullableFunction<? super F, ? extends T> function;

        MappingSequentialList(List<F> list, NullableFunction<? super F, ? extends T> nullableFunction) {
            this.fromList = (List) Objects.requireNonNull(list);
            this.function = (NullableFunction) Objects.requireNonNull(nullableFunction);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new MappedListIterator<F, T>(this.fromList.listIterator(i)) { // from class: com.smaato.sdk.core.util.collections.Lists.MappingSequentialList.1
                @Override // com.smaato.sdk.core.util.collections.MappedIterator
                T map(F f) {
                    return MappingSequentialList.this.function.apply(f);
                }
            };
        }
    }

    private static class MappingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        final List<F> fromList;
        final NullableFunction<? super F, ? extends T> function;

        MappingRandomAccessList(List<F> list, NullableFunction<? super F, ? extends T> nullableFunction) {
            this.fromList = (List) Objects.requireNonNull(list);
            this.function = (NullableFunction) Objects.requireNonNull(nullableFunction);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.function.apply(this.fromList.get(i));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new MappedListIterator<F, T>(this.fromList.listIterator(i)) { // from class: com.smaato.sdk.core.util.collections.Lists.MappingRandomAccessList.1
                @Override // com.smaato.sdk.core.util.collections.MappedIterator
                T map(F f) {
                    return MappingRandomAccessList.this.function.apply(f);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.function.apply(this.fromList.remove(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }
}
