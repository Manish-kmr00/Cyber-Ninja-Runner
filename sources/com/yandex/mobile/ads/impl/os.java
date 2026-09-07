package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class os<E> implements Iterable<E> {
    private final Object b = new Object();
    private final HashMap c = new HashMap();
    private Set<E> d = Collections.emptySet();
    private List<E> e = Collections.emptyList();

    public final void a(E e) {
        synchronized (this.b) {
            ArrayList arrayList = new ArrayList(this.e);
            arrayList.add(e);
            this.e = Collections.unmodifiableList(arrayList);
            Integer num = (Integer) this.c.get(e);
            if (num == null) {
                HashSet hashSet = new HashSet(this.d);
                hashSet.add(e);
                this.d = Collections.unmodifiableSet(hashSet);
            }
            this.c.put(e, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public final void c(E e) {
        synchronized (this.b) {
            Integer num = (Integer) this.c.get(e);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.e);
            arrayList.remove(e);
            this.e = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.c.remove(e);
                HashSet hashSet = new HashSet(this.d);
                hashSet.remove(e);
                this.d = Collections.unmodifiableSet(hashSet);
            } else {
                this.c.put(e, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.b) {
            it = this.e.iterator();
        }
        return it;
    }

    public final int b(E e) {
        int iIntValue;
        synchronized (this.b) {
            iIntValue = this.c.containsKey(e) ? ((Integer) this.c.get(e)).intValue() : 0;
        }
        return iIntValue;
    }

    public final Set<E> a() {
        Set<E> set;
        synchronized (this.b) {
            set = this.d;
        }
        return set;
    }
}
