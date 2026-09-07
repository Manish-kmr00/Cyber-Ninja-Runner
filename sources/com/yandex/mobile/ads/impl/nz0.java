package com.yandex.mobile.ads.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class nz0 {
    public static boolean a(mz0 network) {
        Intrinsics.checkNotNullParameter(network, "network");
        List<mz0.c> listB = network.b();
        if (!(listB instanceof Collection) || !listB.isEmpty()) {
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                if (!((mz0.c) it.next()).c()) {
                    return false;
                }
            }
        }
        return true;
    }
}
