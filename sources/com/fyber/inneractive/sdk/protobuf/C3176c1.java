package com.fyber.inneractive.sdk.protobuf;

import java.util.Map;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.c1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C3176c1 implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparable f2278a;
    public Object b;
    public final /* synthetic */ AbstractC3185f1 c;

    public C3176c1(AbstractC3185f1 abstractC3185f1, Map.Entry entry) {
        Comparable comparable = (Comparable) entry.getKey();
        Object value = entry.getValue();
        this.c = abstractC3185f1;
        this.f2278a = comparable;
        this.b = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f2278a.compareTo(((C3176c1) obj).f2278a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean zEquals;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Comparable comparable = this.f2278a;
        Object key = entry.getKey();
        if (comparable == null) {
            zEquals = key == null;
        } else {
            zEquals = comparable.equals(key);
        }
        if (zEquals) {
            Object obj2 = this.b;
            Object value = entry.getValue();
            if (obj2 == null) {
                zEquals2 = value == null;
            } else {
                zEquals2 = obj2.equals(value);
            }
            if (zEquals2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f2278a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f2278a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.b;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.c.a();
        Object obj2 = this.b;
        this.b = obj;
        return obj2;
    }

    public final String toString() {
        return this.f2278a + "=" + this.b;
    }

    public C3176c1(AbstractC3185f1 abstractC3185f1, Comparable comparable, Object obj) {
        this.c = abstractC3185f1;
        this.f2278a = comparable;
        this.b = obj;
    }
}
