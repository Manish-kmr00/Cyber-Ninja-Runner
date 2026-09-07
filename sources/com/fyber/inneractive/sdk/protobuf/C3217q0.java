package com.fyber.inneractive.sdk.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3217q0 extends AbstractC3174c implements InterfaceC3219r0, RandomAccess {
    public final ArrayList b;

    static {
        new C3217q0(10).f2277a = false;
    }

    public C3217q0(int i) {
        this.b = new ArrayList(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3219r0
    public final InterfaceC3219r0 a() {
        return this.f2277a ? new s1(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        c();
        this.b.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3174c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.b.size(), collection);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3202l0
    public final InterfaceC3202l0 b(int i) {
        if (i < this.b.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.b);
        return new C3217q0(arrayList);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3174c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        String strA;
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC3221s) {
            AbstractC3221s abstractC3221s = (AbstractC3221s) obj;
            strA = abstractC3221s.f();
            if (abstractC3221s.c()) {
                this.b.set(i, strA);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            strA = AbstractC3205m0.a(bArr);
            if (E1.f2253a.b(bArr, 0, bArr.length)) {
                this.b.set(i, strA);
            }
        }
        return strA;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3174c, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        c();
        Object objRemove = this.b.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        return objRemove instanceof AbstractC3221s ? ((AbstractC3221s) objRemove).f() : AbstractC3205m0.a((byte[]) objRemove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        c();
        Object obj2 = this.b.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        return obj2 instanceof AbstractC3221s ? ((AbstractC3221s) obj2).f() : AbstractC3205m0.a((byte[]) obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.size();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3219r0
    public final void a(AbstractC3221s abstractC3221s) {
        c();
        this.b.add(abstractC3221s);
        ((AbstractList) this).modCount++;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3174c, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        c();
        if (collection instanceof InterfaceC3219r0) {
            collection = ((InterfaceC3219r0) collection).b();
        }
        boolean zAddAll = this.b.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    public C3217q0(ArrayList arrayList) {
        this.b = arrayList;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3219r0
    public final Object a(int i) {
        return this.b.get(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3219r0
    public final List b() {
        return Collections.unmodifiableList(this.b);
    }
}
