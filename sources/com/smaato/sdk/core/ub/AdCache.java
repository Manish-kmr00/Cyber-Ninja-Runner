package com.smaato.sdk.core.ub;

import com.smaato.sdk.core.util.fi.Predicate;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes12.dex */
public class AdCache<T> {
    private final Map cache = new ConcurrentHashMap();
    private final int capacity;
    private final Predicate validator;

    public AdCache(int i, Predicate<T> predicate) {
        this.capacity = i;
        this.validator = predicate;
    }

    public int remainingCapacity(String str) {
        return this.capacity - getOrCreateBucket(str).size();
    }

    public int trim(String str) {
        Bucket orCreateBucket = getOrCreateBucket(str);
        Iterator<T> it = orCreateBucket.iterator();
        while (it.hasNext()) {
            if (!this.validator.test(it.next())) {
                it.remove();
            }
        }
        return this.capacity - orCreateBucket.size();
    }

    public boolean put(String str, T t) {
        return getOrCreateBucket(str).offer(t);
    }

    public T get(String str) {
        return (T) getOrCreateBucket(str).peek();
    }

    public T getAndRemove(String str, Predicate<T> predicate) {
        Iterator<T> it = getOrCreateBucket(str).iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.test(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    private Bucket getOrCreateBucket(String str) {
        Bucket bucket = (Bucket) this.cache.get(str);
        if (bucket == null) {
            bucket = new Bucket(this.capacity);
            Bucket bucket2 = (Bucket) this.cache.put(str, bucket);
            if (bucket2 != null) {
                return bucket2;
            }
        }
        return bucket;
    }

    private static class Bucket<T> extends AbstractQueue<T> {
        private final int capacity;
        private final Queue objects = new ConcurrentLinkedQueue();

        Bucket(int i) {
            this.capacity = i;
        }

        @Override // java.util.Queue
        public boolean offer(T t) {
            return this.objects.size() < this.capacity && this.objects.offer(t);
        }

        @Override // java.util.Queue
        public T poll() {
            return (T) this.objects.poll();
        }

        @Override // java.util.Queue
        public T peek() {
            return (T) this.objects.peek();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.objects.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return this.objects.iterator();
        }
    }
}
