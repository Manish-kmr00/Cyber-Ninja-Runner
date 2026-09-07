package com.fyber.inneractive.sdk.web;

import android.util.LruCache;

/* JADX INFO: loaded from: classes11.dex */
public final class a0 extends LruCache {
    public a0() {
        super(1048576);
    }

    @Override // android.util.LruCache
    public final int sizeOf(Object obj, Object obj2) {
        String str;
        d0 d0Var = (d0) obj2;
        int length = 0;
        for (String str2 : d0Var.b.keySet()) {
            if (str2 != null && (str = (String) d0Var.b.get(str2)) != null) {
                length += str.length() + str2.length();
            }
        }
        return length + d0Var.f2405a.length;
    }
}
