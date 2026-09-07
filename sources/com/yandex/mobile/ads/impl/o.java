package com.yandex.mobile.ads.impl;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes8.dex */
abstract class o<K, V> extends q<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> e;
    private transient int f;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends du0<K, Collection<V>> {
        final transient Map<K, Collection<V>> d;

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.o$a$a, reason: collision with other inner class name */
        class C0752a extends au0<K, Collection<V>> {
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return a.this.new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(@CheckForNull Object obj) {
                Object objRemove;
                Set<Map.Entry<K, Collection<V>>> setEntrySet = a.this.d.entrySet();
                setEntrySet.getClass();
                try {
                    if (!setEntrySet.contains(obj)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) Objects.requireNonNull((Map.Entry) obj);
                    o oVar = o.this;
                    Object key = entry.getKey();
                    Map map = oVar.e;
                    map.getClass();
                    try {
                        objRemove = map.remove(key);
                    } catch (ClassCastException | NullPointerException unused) {
                        objRemove = null;
                    }
                    Collection collection = (Collection) objRemove;
                    if (collection == null) {
                        return true;
                    }
                    int size = collection.size();
                    collection.clear();
                    oVar.f -= size;
                    return true;
                } catch (ClassCastException | NullPointerException unused2) {
                    return false;
                }
            }

            C0752a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(@CheckForNull Object obj) {
                Set<Map.Entry<K, Collection<V>>> setEntrySet = a.this.d.entrySet();
                setEntrySet.getClass();
                try {
                    return setEntrySet.contains(obj);
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
        }

        class b implements Iterator<Map.Entry<K, Collection<V>>> {
            final Iterator<Map.Entry<K, Collection<V>>> b;

            @CheckForNull
            Collection<V> c;

            @Override // java.util.Iterator
            public final Object next() {
                Map.Entry<K, Collection<V>> next = this.b.next();
                this.c = next.getValue();
                return a.this.a(next);
            }

            b() {
                this.b = a.this.d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public final void remove() {
                if (this.c != null) {
                    this.b.remove();
                    o.this.f -= this.c.size();
                    this.c.clear();
                    this.c = null;
                    return;
                }
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object get(@CheckForNull Object obj) {
            Collection<V> collection;
            Map<K, Collection<V>> map = this.d;
            map.getClass();
            try {
                collection = map.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                collection = null;
            }
            Collection<V> collection2 = collection;
            if (collection2 == null) {
                return null;
            }
            m mVar = (m) o.this;
            mVar.getClass();
            List list = (List) collection2;
            return list instanceof RandomAccess ? new f(mVar, obj, list, null) : new j(obj, list, null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public final Object remove(@CheckForNull Object obj) {
            Collection<V> collectionRemove = this.d.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            List<V> list = ((t31) o.this).g.get();
            list.addAll(collectionRemove);
            o.this.f -= collectionRemove.size();
            collectionRemove.clear();
            return list;
        }

        a(Map<K, Collection<V>> map) {
            this.d = map;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@CheckForNull Object obj) {
            Map<K, Collection<V>> map = this.d;
            map.getClass();
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return o.this.b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.d.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean equals(@CheckForNull Object obj) {
            return this == obj || this.d.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int hashCode() {
            return this.d.hashCode();
        }

        @Override // java.util.AbstractMap
        public final String toString() {
            return this.d.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            Map<K, Collection<V>> map = this.d;
            o oVar = o.this;
            if (map == oVar.e) {
                oVar.d();
                return;
            }
            b bVar = new b();
            while (bVar.hasNext()) {
                bVar.next();
                bVar.remove();
            }
        }

        final Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
            Object jVar;
            K key = entry.getKey();
            o oVar = o.this;
            Collection<V> value = entry.getValue();
            m mVar = (m) oVar;
            mVar.getClass();
            List list = (List) value;
            if (list instanceof RandomAccess) {
                jVar = new f(mVar, key, list, null);
            } else {
                jVar = new j(key, list, null);
            }
            return new gk0(key, jVar);
        }
    }

    private class c extends bu0<K, Collection<V>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection<?> collection) {
            return this.b.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final boolean equals(@CheckForNull Object obj) {
            return this == obj || this.b.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final int hashCode() {
            return this.b.keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<K> iterator() {
            return new a(this.b.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@CheckForNull Object obj) {
            Collection collection = (Collection) this.b.remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                o.this.f -= size;
                if (size > 0) {
                    return true;
                }
            }
            return false;
        }

        c(Map<K, Collection<V>> map) {
            super(map);
        }

        final class a implements Iterator<K> {

            @CheckForNull
            Map.Entry<K, Collection<V>> b;
            final /* synthetic */ Iterator c;

            a(Iterator it) {
                this.c = it;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.c.hasNext();
            }

            @Override // java.util.Iterator
            public final K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.c.next();
                this.b = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public final void remove() {
                Map.Entry<K, Collection<V>> entry = this.b;
                if (entry != null) {
                    Collection<V> value = entry.getValue();
                    this.c.remove();
                    o.this.f -= value.size();
                    value.clear();
                    this.b = null;
                    return;
                }
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            Iterator<K> it = iterator();
            while (true) {
                a aVar = (a) it;
                if (!aVar.hasNext()) {
                    return;
                }
                aVar.next();
                aVar.remove();
            }
        }
    }

    class d extends o<K, V>.g implements NavigableMap<K, Collection<V>> {
        @Override // com.yandex.mobile.ads.impl.o.g
        final SortedSet a() {
            return new e(b());
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, Collection<V>> descendingMap() {
            return new d(b().descendingMap());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.yandex.mobile.ads.impl.o.g
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) ((SortedMap) this.d);
        }

        @Override // com.yandex.mobile.ads.impl.o.g, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // com.yandex.mobile.ads.impl.o.g, com.yandex.mobile.ads.impl.o.a, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public final NavigableSet<K> navigableKeySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // com.yandex.mobile.ads.impl.o.g, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.yandex.mobile.ads.impl.o.g, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new d(b().headMap(k, z));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new d(b().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new d(b().tailMap(k, z));
        }

        @Override // com.yandex.mobile.ads.impl.o.g, com.yandex.mobile.ads.impl.o.a, java.util.AbstractMap, java.util.Map
        public final SortedSet keySet() {
            return (NavigableSet) super.keySet();
        }

        d(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> entryLowerEntry = b().lowerEntry(k);
            if (entryLowerEntry == null) {
                return null;
            }
            return a(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K lowerKey(K k) {
            return b().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> entryFloorEntry = b().floorEntry(k);
            if (entryFloorEntry == null) {
                return null;
            }
            return a(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K floorKey(K k) {
            return b().floorKey(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = b().ceilingEntry(k);
            if (entryCeilingEntry == null) {
                return null;
            }
            return a(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K ceilingKey(K k) {
            return b().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> entryHigherEntry = b().higherEntry(k);
            if (entryHigherEntry == null) {
                return null;
            }
            return a(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final K higherKey(K k) {
            return b().higherKey(k);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = b().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return a(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = b().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return a(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> pollFirstEntry() {
            Iterator<Map.Entry<K, Collection<V>>> it = entrySet().iterator();
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            List<V> list = ((t31) o.this).g.get();
            list.addAll(next.getValue());
            it.remove();
            K key = next.getKey();
            ((m) o.this).getClass();
            return new gk0(key, Collections.unmodifiableList(list));
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public final Map.Entry<K, Collection<V>> pollLastEntry() {
            Iterator<Map.Entry<K, V>> it = ((du0) descendingMap()).entrySet().iterator();
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, V> next = it.next();
            List<V> list = ((t31) o.this).g.get();
            list.addAll((Collection) next.getValue());
            it.remove();
            K key = next.getKey();
            ((m) o.this).getClass();
            return new gk0(key, Collections.unmodifiableList(list));
        }

        @Override // java.util.NavigableMap
        public final NavigableSet<K> descendingKeySet() {
            return ((d) descendingMap()).navigableKeySet();
        }
    }

    class e extends o<K, V>.h implements NavigableSet<K> {
        @Override // java.util.NavigableSet
        public final NavigableSet<K> descendingSet() {
            return new e(b().descendingMap());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.yandex.mobile.ads.impl.o.h
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final NavigableMap<K, Collection<V>> b() {
            return (NavigableMap) ((SortedMap) this.b);
        }

        @Override // com.yandex.mobile.ads.impl.o.h, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K pollLast() {
            c.a aVar = (c.a) ((c) descendingSet()).iterator();
            if (!aVar.hasNext()) {
                return null;
            }
            K k = (K) aVar.next();
            aVar.remove();
            return k;
        }

        @Override // com.yandex.mobile.ads.impl.o.h, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.yandex.mobile.ads.impl.o.h, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> headSet(K k, boolean z) {
            return new e(b().headMap(k, z));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new e(b().subMap(k, z, k2, z2));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet<K> tailSet(K k, boolean z) {
            return new e(b().tailMap(k, z));
        }

        e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K lower(K k) {
            return b().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K floor(K k) {
            return b().floorKey(k);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K ceiling(K k) {
            return b().ceilingKey(k);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K higher(K k) {
            return b().higherKey(k);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public final K pollFirst() {
            c.a aVar = (c.a) iterator();
            if (!aVar.hasNext()) {
                return null;
            }
            K k = (K) aVar.next();
            aVar.remove();
            return k;
        }

        @Override // java.util.NavigableSet
        public final Iterator<K> descendingIterator() {
            return ((c) descendingSet()).iterator();
        }
    }

    private class h extends o<K, V>.c implements SortedSet<K> {
        public SortedSet<K> headSet(K k) {
            return new h(b().headMap(k));
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new h(b().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new h(b().tailMap(k));
        }

        SortedMap<K, Collection<V>> b() {
            return (SortedMap) this.b;
        }

        h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public final Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public final K first() {
            return b().firstKey();
        }

        @Override // java.util.SortedSet
        public final K last() {
            return b().lastKey();
        }
    }

    class i extends AbstractCollection<V> {
        final K b;
        Collection<V> c;

        @CheckForNull
        final o<K, V>.i d;

        @CheckForNull
        final Collection<V> e;

        class a implements Iterator<V> {
            final Iterator<V> b;
            final Collection<V> c;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                i.this.d();
                if (i.this.c == this.c) {
                    return this.b.hasNext();
                }
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public final V next() {
                i.this.d();
                if (i.this.c == this.c) {
                    return this.b.next();
                }
                throw new ConcurrentModificationException();
            }

            a() {
                Collection<V> collection = i.this.c;
                this.c = collection;
                this.b = o.a(collection);
            }

            a(ListIterator listIterator) {
                this.c = i.this.c;
                this.b = listIterator;
            }

            @Override // java.util.Iterator
            public final void remove() {
                this.b.remove();
                i iVar = i.this;
                o.this.f--;
                iVar.e();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            d();
            int size = this.c.size();
            if (size == 0) {
                return;
            }
            this.c.clear();
            o.this.f -= size;
            e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            collection.getClass();
            d();
            int size = this.c.size();
            boolean zRetainAll = this.c.retainAll(collection);
            if (zRetainAll) {
                int size2 = this.c.size();
                o oVar = o.this;
                oVar.f = (size2 - size) + oVar.f;
                e();
            }
            return zRetainAll;
        }

        i(K k, Collection<V> collection, @CheckForNull o<K, V>.i iVar) {
            this.b = k;
            this.c = collection;
            this.d = iVar;
            this.e = iVar == null ? null : iVar.c();
        }

        final void d() {
            Collection<V> collection;
            o<K, V>.i iVar = this.d;
            if (iVar != null) {
                iVar.d();
                if (this.d.c != this.e) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.c.isEmpty() || (collection = (Collection) o.this.e.get(this.b)) == null) {
                    return;
                }
                this.c = collection;
            }
        }

        final void e() {
            o<K, V>.i iVar = this.d;
            if (iVar != null) {
                iVar.e();
            } else if (this.c.isEmpty()) {
                o.this.e.remove(this.b);
            }
        }

        final void b() {
            o<K, V>.i iVar = this.d;
            if (iVar != null) {
                iVar.b();
            } else {
                o.this.e.put(this.b, this.c);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            d();
            return this.c.size();
        }

        @Override // java.util.Collection
        public final boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            d();
            return this.c.equals(obj);
        }

        @Override // java.util.Collection
        public final int hashCode() {
            d();
            return this.c.hashCode();
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            d();
            return this.c.toString();
        }

        final Collection<V> c() {
            return this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            d();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean add(V v) {
            d();
            boolean zIsEmpty = this.c.isEmpty();
            boolean zAdd = this.c.add(v);
            if (zAdd) {
                o.this.f++;
                if (zIsEmpty) {
                    b();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            d();
            int size = this.c.size();
            boolean zAddAll = this.c.addAll(collection);
            if (zAddAll) {
                int size2 = this.c.size();
                o oVar = o.this;
                oVar.f = (size2 - size) + oVar.f;
                if (size == 0) {
                    b();
                }
            }
            return zAddAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object obj) {
            d();
            return this.c.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            d();
            return this.c.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(@CheckForNull Object obj) {
            d();
            boolean zRemove = this.c.remove(obj);
            if (zRemove) {
                o.this.f--;
                e();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            d();
            int size = this.c.size();
            boolean zRemoveAll = this.c.removeAll(collection);
            if (zRemoveAll) {
                int size2 = this.c.size();
                o oVar = o.this;
                oVar.f = (size2 - size) + oVar.f;
                e();
            }
            return zRemoveAll;
        }
    }

    class j extends o<K, V>.i implements List<V> {

        private class a extends o<K, V>.i.a implements ListIterator<V> {
            private ListIterator<V> a() {
                i.this.d();
                if (i.this.c == this.c) {
                    return (ListIterator) this.b;
                }
                throw new ConcurrentModificationException();
            }

            a() {
                super();
            }

            @Override // java.util.ListIterator
            public final boolean hasPrevious() {
                return a().hasPrevious();
            }

            @Override // java.util.ListIterator
            public final V previous() {
                return a().previous();
            }

            @Override // java.util.ListIterator
            public final int nextIndex() {
                return a().nextIndex();
            }

            @Override // java.util.ListIterator
            public final int previousIndex() {
                return a().previousIndex();
            }

            @Override // java.util.ListIterator
            public final void set(V v) {
                a().set(v);
            }

            @Override // java.util.ListIterator
            public final void add(V v) {
                boolean zIsEmpty = j.this.isEmpty();
                a().add(v);
                j jVar = j.this;
                o.this.f++;
                if (zIsEmpty) {
                    jVar.b();
                }
            }

            public a(int i) {
                super(j.this.f().listIterator(i));
            }
        }

        final List<V> f() {
            return (List) this.c;
        }

        j(K k, List<V> list, @CheckForNull o<K, V>.i iVar) {
            super(k, list, iVar);
        }

        @Override // java.util.List
        public final boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            d();
            int size = this.c.size();
            boolean zAddAll = ((List) this.c).addAll(i, collection);
            if (zAddAll) {
                int size2 = this.c.size();
                o oVar = o.this;
                oVar.f = (size2 - size) + oVar.f;
                if (size == 0) {
                    b();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public final V get(int i) {
            d();
            return (V) ((List) this.c).get(i);
        }

        @Override // java.util.List
        public final V set(int i, V v) {
            d();
            return (V) ((List) this.c).set(i, v);
        }

        @Override // java.util.List
        public final void add(int i, V v) {
            d();
            boolean zIsEmpty = this.c.isEmpty();
            ((List) this.c).add(i, v);
            o.this.f++;
            if (zIsEmpty) {
                b();
            }
        }

        @Override // java.util.List
        public final V remove(int i) {
            d();
            V v = (V) ((List) this.c).remove(i);
            o.this.f--;
            e();
            return v;
        }

        @Override // java.util.List
        public final int indexOf(@CheckForNull Object obj) {
            d();
            return ((List) this.c).indexOf(obj);
        }

        @Override // java.util.List
        public final int lastIndexOf(@CheckForNull Object obj) {
            d();
            return ((List) this.c).lastIndexOf(obj);
        }

        @Override // java.util.List
        public final ListIterator<V> listIterator() {
            d();
            return new a();
        }

        @Override // java.util.List
        public final List<V> subList(int i, int i2) {
            d();
            o oVar = o.this;
            K k = this.b;
            List listSubList = ((List) this.c).subList(i, i2);
            o<K, V>.i iVar = this.d;
            if (iVar == null) {
                iVar = this;
            }
            oVar.getClass();
            if (listSubList instanceof RandomAccess) {
                return new f(oVar, k, listSubList, iVar);
            }
            return new j(k, listSubList, iVar);
        }

        @Override // java.util.List
        public final ListIterator<V> listIterator(int i) {
            d();
            return new a(i);
        }
    }

    protected o(Map<K, Collection<V>> map) {
        rj1.a(map.isEmpty());
        this.e = map;
    }

    final Map<K, Collection<V>> c() {
        return this.e;
    }

    public final int g() {
        return this.f;
    }

    @Override // com.yandex.mobile.ads.impl.p31
    public boolean put(K k, V v) {
        Collection<V> collection = this.e.get(k);
        if (collection == null) {
            List<V> list = ((t31) this).g.get();
            if (list.add(v)) {
                this.f++;
                this.e.put(k, list);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        }
        if (!collection.add(v)) {
            return false;
        }
        this.f++;
        return true;
    }

    public final void d() {
        Iterator<Collection<V>> it = this.e.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.e.clear();
        this.f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> a(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    final void a(Map<K, Collection<V>> map) {
        this.e = map;
        this.f = 0;
        for (Collection<V> collection : map.values()) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException();
            }
            this.f = collection.size() + this.f;
        }
    }

    private class f extends o<K, V>.j implements RandomAccess {
        f(o oVar, K k, List<V> list, @CheckForNull o<K, V>.i iVar) {
            super(k, list, iVar);
        }
    }

    final Set<K> f() {
        Map<K, Collection<V>> map = this.e;
        if (map instanceof NavigableMap) {
            return new e((NavigableMap) this.e);
        }
        if (map instanceof SortedMap) {
            return new h((SortedMap) this.e);
        }
        return new c(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    abstract class b<T> implements Iterator<T> {
        final Iterator<Map.Entry<K, Collection<V>>> b;

        @CheckForNull
        K c = null;

        @CheckForNull
        Collection<V> d = null;
        Iterator<V> e = iq0.INSTANCE;

        abstract T a(K k, V v);

        b() {
            this.b = o.this.e.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b.hasNext() || this.e.hasNext();
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!this.e.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.b.next();
                this.c = next.getKey();
                Collection<V> value = next.getValue();
                this.d = value;
                this.e = value.iterator();
            }
            return a(this.c, this.e.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.e.remove();
            if (((Collection) Objects.requireNonNull(this.d)).isEmpty()) {
                this.b.remove();
            }
            o.this.f--;
        }
    }

    @Override // com.yandex.mobile.ads.impl.q, com.yandex.mobile.ads.impl.p31
    public final Collection<V> values() {
        return super.values();
    }

    final Map<K, Collection<V>> e() {
        Map<K, Collection<V>> map = this.e;
        if (map instanceof NavigableMap) {
            return new d((NavigableMap) this.e);
        }
        if (map instanceof SortedMap) {
            return new g((SortedMap) this.e);
        }
        return new a(this.e);
    }

    private class g extends o<K, V>.a implements SortedMap<K, Collection<V>> {

        @CheckForNull
        SortedSet<K> f;

        SortedSet<K> a() {
            return new h(b());
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new g(b().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new g(b().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new g(b().tailMap(k));
        }

        g(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> b() {
            return (SortedMap) this.d;
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public final Comparator<? super K> comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public final K firstKey() {
            return b().firstKey();
        }

        @Override // java.util.SortedMap
        public final K lastKey() {
            return b().lastKey();
        }

        @Override // com.yandex.mobile.ads.impl.o.a, java.util.AbstractMap, java.util.Map
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetA = a();
            this.f = sortedSetA;
            return sortedSetA;
        }
    }
}
