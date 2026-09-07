package com.fyber.inneractive.sdk.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes11.dex */
public final class s1 extends AbstractList implements InterfaceC3219r0, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC3219r0 f2298a;

    public s1(InterfaceC3219r0 interfaceC3219r0) {
        this.f2298a = interfaceC3219r0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3219r0
    public final InterfaceC3219r0 a() {
        return this;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3219r0
    public final List b() {
        return this.f2298a.b();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return (String) this.f2298a.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new C3220r1(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new C3218q1(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2298a.size();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3219r0
    public final Object a(int i) {
        return this.f2298a.a(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.InterfaceC3219r0
    public final void a(AbstractC3221s abstractC3221s) {
        throw new UnsupportedOperationException();
    }
}
