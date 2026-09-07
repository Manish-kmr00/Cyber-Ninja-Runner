package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.r1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C3220r1 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f2296a;

    public C3220r1(s1 s1Var) {
        this.f2296a = s1Var.f2298a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2296a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f2296a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
