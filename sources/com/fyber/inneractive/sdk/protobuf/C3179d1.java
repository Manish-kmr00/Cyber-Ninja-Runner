package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.d1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C3179d1 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2280a = -1;
    public boolean b;
    public Iterator c;
    public final /* synthetic */ AbstractC3185f1 d;

    public C3179d1(AbstractC3185f1 abstractC3185f1) {
        this.d = abstractC3185f1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f2280a + 1 < this.d.b.size()) {
            return true;
        }
        if (!this.d.c.isEmpty()) {
            if (this.c == null) {
                this.c = this.d.c.entrySet().iterator();
            }
            if (this.c.hasNext()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        this.b = true;
        int i = this.f2280a + 1;
        this.f2280a = i;
        if (i < this.d.b.size()) {
            return (Map.Entry) this.d.b.get(this.f2280a);
        }
        if (this.c == null) {
            this.c = this.d.c.entrySet().iterator();
        }
        return (Map.Entry) this.c.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.b) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.b = false;
        AbstractC3185f1 abstractC3185f1 = this.d;
        int i = AbstractC3185f1.h;
        abstractC3185f1.a();
        if (this.f2280a >= this.d.b.size()) {
            if (this.c == null) {
                this.c = this.d.c.entrySet().iterator();
            }
            this.c.remove();
            return;
        }
        AbstractC3185f1 abstractC3185f2 = this.d;
        int i2 = this.f2280a;
        this.f2280a = i2 - 1;
        abstractC3185f2.a();
        Object obj = ((C3176c1) abstractC3185f2.b.remove(i2)).b;
        if (abstractC3185f2.c.isEmpty()) {
            return;
        }
        Iterator it = abstractC3185f2.c().entrySet().iterator();
        abstractC3185f2.b.add(new C3176c1(abstractC3185f2, (Map.Entry) it.next()));
        it.remove();
    }
}
