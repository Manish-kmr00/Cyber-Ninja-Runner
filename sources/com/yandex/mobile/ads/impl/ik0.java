package com.yandex.mobile.ads.impl;

import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import io.ktor.http.ContentDisposition;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes10.dex */
@DoNotMock("Use ImmutableMap.of or another implementation")
public abstract class ik0<K, V> implements Map<K, V>, Serializable {

    @CheckForNull
    @LazyInit
    private transient jk0<Map.Entry<K, V>> b;

    @CheckForNull
    @LazyInit
    private transient jk0<K> c;

    @CheckForNull
    @LazyInit
    private transient fk0<V> d;

    public static <K, V> ik0<K, V> g() {
        return (ik0<K, V>) fo1.h;
    }

    abstract jk0<Map.Entry<K, V>> b();

    abstract jk0<K> c();

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    abstract fk0<V> d();

    @Override // java.util.Map
    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    Object writeReplace() {
        return new b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ik0 a(HashMap map) {
        if ((map instanceof ik0) && !(map instanceof SortedMap)) {
            ik0 ik0Var = (ik0) map;
            ik0Var.getClass();
            return ik0Var;
        }
        Set<Map.Entry> setEntrySet = map.entrySet();
        boolean z = setEntrySet instanceof Collection;
        a aVar = new a(z ? setEntrySet.size() : 4);
        if (z) {
            aVar.a(setEntrySet.size());
        }
        for (Map.Entry entry : setEntrySet) {
            aVar.a(entry.getKey(), entry.getValue());
        }
        return fo1.a(aVar.b, aVar.f9231a);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return ((jk0) entrySet()).equals(((Map) obj).entrySet());
    }

    public final String toString() {
        int size = size();
        nq.a(size, ContentDisposition.Parameters.Size);
        StringBuilder sbAppend = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L)).append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sbAppend.append(", ");
            }
            sbAppend.append(entry.getKey()).append(com.json.cc.T).append(entry.getValue());
            z = false;
        }
        return sbAppend.append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    public static <K, V> a<K, V> a() {
        return new a<>(4);
    }

    @DoNotMock
    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f9231a;
        int b;

        public a() {
            this(4);
        }

        public final ik0<K, V> a() {
            return fo1.a(this.b, this.f9231a);
        }

        a(int i) {
            this.f9231a = new Object[i * 2];
            this.b = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i) {
            int i2 = i * 2;
            Object[] objArr = this.f9231a;
            if (i2 > objArr.length) {
                int length = objArr.length;
                if (i2 >= 0) {
                    int iHighestOneBit = length + (length >> 1) + 1;
                    if (iHighestOneBit < i2) {
                        iHighestOneBit = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (iHighestOneBit < 0) {
                        iHighestOneBit = Integer.MAX_VALUE;
                    }
                    this.f9231a = Arrays.copyOf(objArr, iHighestOneBit);
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }

        public final a<K, V> a(K k, V v) {
            a(this.b + 1);
            if (k == null) {
                throw new NullPointerException("null key in entry: null=" + v);
            }
            if (v != null) {
                Object[] objArr = this.f9231a;
                int i = this.b;
                int i2 = i * 2;
                objArr[i2] = k;
                objArr[i2 + 1] = v;
                this.b = i + 1;
                return this;
            }
            throw new NullPointerException("null value in entry: " + k + "=null");
        }
    }

    ik0() {
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final jk0<Map.Entry<K, V>> entrySet() {
        jk0<Map.Entry<K, V>> jk0Var = this.b;
        if (jk0Var != null) {
            return jk0Var;
        }
        jk0<Map.Entry<K, V>> jk0VarB = b();
        this.b = jk0VarB;
        return jk0VarB;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final jk0<K> keySet() {
        jk0<K> jk0Var = this.c;
        if (jk0Var != null) {
            return jk0Var;
        }
        jk0<K> jk0VarC = c();
        this.c = jk0VarC;
        return jk0VarC;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final fk0<V> values() {
        fk0<V> fk0Var = this.d;
        if (fk0Var != null) {
            return fk0Var;
        }
        fk0<V> fk0VarD = d();
        this.d = fk0VarD;
        return fk0VarD;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return px1.a(entrySet());
    }

    static class b<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] b;
        private final Object[] c;

        b(ik0<K, V> ik0Var) {
            Object[] objArr = new Object[ik0Var.size()];
            Object[] objArr2 = new Object[ik0Var.size()];
            b82<Map.Entry<K, V>> it = ik0Var.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objArr[i] = next.getKey();
                objArr2[i] = next.getValue();
                i++;
            }
            this.b = objArr;
            this.c = objArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        final Object readResolve() {
            Object[] objArr = this.b;
            if (!(objArr instanceof jk0)) {
                Object[] objArr2 = this.c;
                a aVar = new a(objArr.length);
                for (int i = 0; i < objArr.length; i++) {
                    aVar.a(objArr[i], objArr2[i]);
                }
                return fo1.a(aVar.b, aVar.f9231a);
            }
            jk0 jk0Var = (jk0) objArr;
            fk0 fk0Var = (fk0) this.c;
            a aVar2 = new a(jk0Var.size());
            Iterator it = jk0Var.iterator();
            b82 it2 = fk0Var.iterator();
            while (it.hasNext()) {
                aVar2.a(it.next(), it2.next());
            }
            return fo1.a(aVar2.b, aVar2.f9231a);
        }
    }
}
