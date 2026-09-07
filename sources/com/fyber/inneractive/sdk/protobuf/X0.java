package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class X0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2273a;
    public Iterator b;
    public final /* synthetic */ AbstractC3185f1 c;

    public X0(AbstractC3185f1 abstractC3185f1) {
        this.c = abstractC3185f1;
        this.f2273a = abstractC3185f1.b.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f2273a;
        if (i <= 0 || i > this.c.b.size()) {
            if (this.b == null) {
                this.b = this.c.f.entrySet().iterator();
            }
            if (!this.b.hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.b == null) {
            this.b = this.c.f.entrySet().iterator();
        }
        if (this.b.hasNext()) {
            if (this.b == null) {
                this.b = this.c.f.entrySet().iterator();
            }
            return (Map.Entry) this.b.next();
        }
        List list = this.c.b;
        int i = this.f2273a - 1;
        this.f2273a = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
