package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes14.dex */
final class gq0 extends k<Object> {
    final /* synthetic */ Iterator d;
    final /* synthetic */ sj1 e;

    gq0(Iterator it, sj1 sj1Var) {
        this.d = it;
        this.e = sj1Var;
    }

    @Override // com.yandex.mobile.ads.impl.k
    @CheckForNull
    protected final Object a() {
        while (this.d.hasNext()) {
            Object next = this.d.next();
            if (this.e.apply(next)) {
                return next;
            }
        }
        b();
        return null;
    }
}
