package com.fyber.inneractive.sdk.protobuf;

import java.util.ListIterator;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.q1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3218q1 implements ListIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListIterator f2295a;

    public C3218q1(s1 s1Var, int i) {
        this.f2295a = s1Var.f2298a.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f2295a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f2295a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return (String) this.f2295a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f2295a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return (String) this.f2295a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f2295a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
