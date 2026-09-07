package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes5.dex */
final class nx1 extends k<Object> {
    final Iterator<Object> d;
    final /* synthetic */ ox1 e;

    nx1(ox1 ox1Var) {
        this.e = ox1Var;
        this.d = ox1Var.b.iterator();
    }

    @Override // com.yandex.mobile.ads.impl.k
    @CheckForNull
    protected final Object a() {
        while (this.d.hasNext()) {
            Object next = this.d.next();
            if (this.e.c.contains(next)) {
                return next;
            }
        }
        b();
        return null;
    }
}
