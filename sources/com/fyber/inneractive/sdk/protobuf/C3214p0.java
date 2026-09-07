package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C3214p0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f2294a;

    public C3214p0(Iterator it) {
        this.f2294a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2294a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f2294a.next();
        entry.getValue();
        return entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f2294a.remove();
    }
}
