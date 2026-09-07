package com.yandex.mobile.ads.impl;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import kotlin.UShort;

/* JADX INFO: loaded from: classes12.dex */
final class fo1<K, V> extends ik0<K, V> {
    static final ik0<Object, Object> h = new fo1(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    @CheckForNull
    private final transient Object e;
    final transient Object[] f;
    private final transient int g;

    static class a<K, V> extends jk0<Map.Entry<K, V>> {
        private final transient ik0<K, V> d;
        private final transient Object[] e;
        private final transient int f = 0;
        private final transient int g;

        /* JADX INFO: renamed from: com.yandex.mobile.ads.impl.fo1$a$a, reason: collision with other inner class name */
        final class C0745a extends hk0<Map.Entry<K, V>> {
            @Override // com.yandex.mobile.ads.impl.fk0
            public final boolean f() {
                return true;
            }

            @Override // java.util.List
            public final Object get(int i) {
                rj1.a(i, a.this.g);
                a aVar = a.this;
                int i2 = i * 2;
                Object objRequireNonNull = Objects.requireNonNull(aVar.e[aVar.f + i2]);
                a aVar2 = a.this;
                return new AbstractMap.SimpleImmutableEntry(objRequireNonNull, Objects.requireNonNull(aVar2.e[i2 + (aVar2.f ^ 1)]));
            }

            C0745a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                return a.this.g;
            }
        }

        @Override // com.yandex.mobile.ads.impl.fk0
        final boolean f() {
            return true;
        }

        @Override // com.yandex.mobile.ads.impl.jk0
        final hk0<Map.Entry<K, V>> g() {
            return new C0745a();
        }

        a(ik0 ik0Var, Object[] objArr, int i) {
            this.d = ik0Var;
            this.e = objArr;
            this.g = i;
        }

        @Override // com.yandex.mobile.ads.impl.fk0
        final int a(int i, Object[] objArr) {
            return b().a(i, objArr);
        }

        @Override // com.yandex.mobile.ads.impl.jk0, com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final b82<Map.Entry<K, V>> iterator() {
            return b().listIterator(0);
        }

        @Override // com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.d.get(key));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.g;
        }
    }

    static final class b<K> extends jk0<K> {
        private final transient ik0<K, ?> d;
        private final transient hk0<K> e;

        @Override // com.yandex.mobile.ads.impl.fk0
        final boolean f() {
            return true;
        }

        @Override // com.yandex.mobile.ads.impl.fk0
        final int a(int i, Object[] objArr) {
            return this.e.a(i, objArr);
        }

        @Override // com.yandex.mobile.ads.impl.jk0, com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final b82<K> iterator() {
            return this.e.listIterator(0);
        }

        b(ik0<K, ?> ik0Var, hk0<K> hk0Var) {
            this.d = ik0Var;
            this.e = hk0Var;
        }

        @Override // com.yandex.mobile.ads.impl.jk0, com.yandex.mobile.ads.impl.fk0
        public final hk0<K> b() {
            return this.e;
        }

        @Override // com.yandex.mobile.ads.impl.fk0, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(@CheckForNull Object obj) {
            return this.d.get(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return this.d.size();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ik0
    final jk0<Map.Entry<K, V>> b() {
        return new a(this, this.f, this.g);
    }

    @Override // com.yandex.mobile.ads.impl.ik0
    final jk0<K> c() {
        return new b(this, new c(this.f, 0, this.g));
    }

    @Override // com.yandex.mobile.ads.impl.ik0
    final fk0<V> d() {
        return new c(this.f, 1, this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    static <K, V> fo1<K, V> a(int i, Object[] objArr) {
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            return (fo1) h;
        }
        ?? r0 = 0;
        int i5 = 0;
        if (i == 1) {
            Objects.requireNonNull(objArr[0]);
            Objects.requireNonNull(objArr[1]);
            return new fo1<>(null, objArr, 1);
        }
        rj1.b(i, objArr.length >> 1);
        int iA = jk0.a(i);
        if (i == 1) {
            Objects.requireNonNull(objArr[0]);
            Objects.requireNonNull(objArr[1]);
        } else {
            int i6 = iA - 1;
            if (iA <= 128) {
                bArr = new byte[iA];
                Arrays.fill(bArr, (byte) -1);
                while (i5 < i) {
                    int i7 = i5 * 2;
                    Object objRequireNonNull = Objects.requireNonNull(objArr[i7]);
                    Object objRequireNonNull2 = Objects.requireNonNull(objArr[i7 ^ 1]);
                    int iA2 = gf0.a(objRequireNonNull.hashCode());
                    while (true) {
                        i4 = iA2 & i6;
                        int i8 = bArr[i4] & 255;
                        if (i8 == 255) {
                            break;
                        }
                        if (objRequireNonNull.equals(objArr[i8])) {
                            throw a(objRequireNonNull, objRequireNonNull2, objArr, i8);
                        }
                        iA2 = i4 + 1;
                    }
                    bArr[i4] = (byte) i7;
                    i5++;
                }
            } else if (iA <= 32768) {
                bArr = new short[iA];
                Arrays.fill(bArr, (short) -1);
                while (i5 < i) {
                    int i9 = i5 * 2;
                    Object objRequireNonNull3 = Objects.requireNonNull(objArr[i9]);
                    Object objRequireNonNull4 = Objects.requireNonNull(objArr[i9 ^ 1]);
                    int iA3 = gf0.a(objRequireNonNull3.hashCode());
                    while (true) {
                        i3 = iA3 & i6;
                        int i10 = bArr[i3] & UShort.MAX_VALUE;
                        if (i10 == 65535) {
                            break;
                        }
                        if (objRequireNonNull3.equals(objArr[i10])) {
                            throw a(objRequireNonNull3, objRequireNonNull4, objArr, i10);
                        }
                        iA3 = i3 + 1;
                    }
                    bArr[i3] = (short) i9;
                    i5++;
                }
            } else {
                bArr = new int[iA];
                Arrays.fill((int[]) bArr, -1);
                while (i5 < i) {
                    int i11 = i5 * 2;
                    Object objRequireNonNull5 = Objects.requireNonNull(objArr[i11]);
                    Object objRequireNonNull6 = Objects.requireNonNull(objArr[i11 ^ 1]);
                    int iA4 = gf0.a(objRequireNonNull5.hashCode());
                    while (true) {
                        i2 = iA4 & i6;
                        ?? r8 = bArr[i2];
                        if (r8 == -1) {
                            break;
                        }
                        if (objRequireNonNull5.equals(objArr[r8])) {
                            throw a(objRequireNonNull5, objRequireNonNull6, objArr, r8);
                        }
                        iA4 = i2 + 1;
                    }
                    bArr[i2] = i11;
                    i5++;
                }
            }
            r0 = bArr;
        }
        return new fo1<>(r0, objArr, i);
    }

    private static IllegalArgumentException a(Object obj, Object obj2, Object[] objArr, int i) {
        return new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i] + "=" + objArr[i ^ 1]);
    }

    private fo1(@CheckForNull Object obj, Object[] objArr, int i) {
        this.e = obj;
        this.f = objArr;
        this.g = i;
    }

    @Override // java.util.Map
    public final int size() {
        return this.g;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x008f A[EDGE_INSN: B:43:0x008f->B:35:0x008f BREAK  A[LOOP:0: B:15:0x0038->B:21:0x004e], EDGE_INSN: B:45:0x008f->B:35:0x008f BREAK  A[LOOP:1: B:25:0x0063->B:31:0x007a], EDGE_INSN: B:47:0x008f->B:35:0x008f BREAK  A[LOOP:2: B:33:0x0089->B:42:0x00a1]] */
    @Override // com.yandex.mobile.ads.impl.ik0, java.util.Map
    @CheckForNull
    public final V get(@CheckForNull Object obj) {
        V v;
        Object obj2 = this.e;
        Object[] objArr = this.f;
        int i = this.g;
        if (obj == null) {
            v = null;
        } else if (i == 1) {
            if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                v = (V) Objects.requireNonNull(objArr[1]);
            } else {
                v = null;
            }
        } else if (obj2 == null) {
            v = null;
        } else if (obj2 instanceof byte[]) {
            byte[] bArr = (byte[]) obj2;
            int length = bArr.length - 1;
            int iA = gf0.a(obj.hashCode());
            while (true) {
                int i2 = iA & length;
                int i3 = bArr[i2] & 255;
                if (i3 == 255) {
                    break;
                }
                if (obj.equals(objArr[i3])) {
                    v = (V) objArr[i3 ^ 1];
                } else {
                    iA = i2 + 1;
                }
            }
            v = null;
        } else if (obj2 instanceof short[]) {
            short[] sArr = (short[]) obj2;
            int length2 = sArr.length - 1;
            int iA2 = gf0.a(obj.hashCode());
            while (true) {
                int i4 = iA2 & length2;
                int i5 = sArr[i4] & UShort.MAX_VALUE;
                if (i5 == 65535) {
                    break;
                }
                if (obj.equals(objArr[i5])) {
                    v = (V) objArr[i5 ^ 1];
                } else {
                    iA2 = i4 + 1;
                }
            }
            v = null;
        } else {
            int[] iArr = (int[]) obj2;
            int length3 = iArr.length - 1;
            int iA3 = gf0.a(obj.hashCode());
            while (true) {
                int i6 = iA3 & length3;
                int i7 = iArr[i6];
                if (i7 == -1) {
                    break;
                }
                if (obj.equals(objArr[i7])) {
                    v = (V) objArr[i7 ^ 1];
                } else {
                    iA3 = i6 + 1;
                }
            }
            v = null;
        }
        if (v == null) {
            return null;
        }
        return v;
    }

    static final class c extends hk0<Object> {
        private final transient Object[] e;
        private final transient int f;
        private final transient int g;

        @Override // com.yandex.mobile.ads.impl.fk0
        final boolean f() {
            return true;
        }

        c(Object[] objArr, int i, int i2) {
            this.e = objArr;
            this.f = i;
            this.g = i2;
        }

        @Override // java.util.List
        public final Object get(int i) {
            rj1.a(i, this.g);
            return Objects.requireNonNull(this.e[(i * 2) + this.f]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.g;
        }
    }
}
