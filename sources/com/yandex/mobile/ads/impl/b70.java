package com.yandex.mobile.ads.impl;

import android.util.LruCache;

/* JADX INFO: loaded from: classes10.dex */
public final class b70 extends LruCache<rb2<?>, oa1> {
    public b70(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    public final void entryRemoved(boolean z, rb2<?> rb2Var, oa1 oa1Var, oa1 oa1Var2) {
        oa1 oa1Var3 = oa1Var;
        if (oa1Var3 != null) {
            oa1Var3.a();
        }
    }
}
