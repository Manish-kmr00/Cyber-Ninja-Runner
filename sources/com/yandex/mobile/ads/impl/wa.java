package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class wa {
    public static String a(List list) {
        Object next;
        Object obj;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((e5) next).a() != f5.c);
        e5 e5Var = (e5) next;
        if (e5Var == null || (obj = e5Var.b().get(f5.c.a())) == null) {
            return null;
        }
        return obj.toString();
    }
}
