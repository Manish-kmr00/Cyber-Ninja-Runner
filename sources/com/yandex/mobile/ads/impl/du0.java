package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.impl.o.a.C0752a;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes9.dex */
abstract class du0<K, V> extends AbstractMap<K, V> {

    @CheckForNull
    private transient Set<Map.Entry<K, V>> b;

    @CheckForNull
    private transient Collection<V> c;

    du0() {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.b;
        if (set != null) {
            return set;
        }
        o.a.C0752a c0752a = ((o.a) this).new C0752a();
        this.b = c0752a;
        return c0752a;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.c;
        if (collection != null) {
            return collection;
        }
        cu0 cu0Var = new cu0(this);
        this.c = cu0Var;
        return cu0Var;
    }
}
