package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes12.dex */
public final class fq0 {
    public static void a(Collection collection, sj1 sj1Var) {
        if (!(collection instanceof RandomAccess) || !(collection instanceof List)) {
            Iterator it = collection.iterator();
            sj1Var.getClass();
            while (it.hasNext()) {
                if (sj1Var.apply(it.next())) {
                    it.remove();
                }
            }
            return;
        }
        List list = (List) collection;
        sj1Var.getClass();
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj = list.get(i2);
            if (!sj1Var.apply(obj)) {
                if (i2 > i) {
                    try {
                        list.set(i, obj);
                    } catch (IllegalArgumentException unused) {
                        for (int size = list.size() - 1; size > i2; size--) {
                            if (sj1Var.apply(list.get(size))) {
                                list.remove(size);
                            }
                        }
                        for (int i3 = i2 - 1; i3 >= i; i3--) {
                            list.remove(i3);
                        }
                        return;
                    } catch (UnsupportedOperationException unused2) {
                        for (int size2 = list.size() - 1; size2 > i2; size2--) {
                            if (sj1Var.apply(list.get(size2))) {
                                list.remove(size2);
                            }
                        }
                        for (int i4 = i2 - 1; i4 >= i; i4--) {
                            list.remove(i4);
                        }
                        return;
                    }
                }
                i++;
            }
        }
        list.subList(i, list.size()).clear();
    }
}
