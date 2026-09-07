package com.five_corp.ad.internal;

import java.util.Iterator;

/* JADX INFO: loaded from: classes10.dex */
public abstract class v {
    static {
        v.class.toString();
    }

    public static boolean a(com.five_corp.ad.internal.ad.a aVar, long j) {
        boolean z = false;
        if (aVar.e.longValue() < j) {
            return false;
        }
        for (com.five_corp.ad.internal.ad.format_config.a aVar2 : aVar.w) {
            Iterator it = aVar.v.iterator();
            while (it.hasNext()) {
                if (((com.five_corp.ad.internal.ad.t) it.next()).b == aVar2.f1289a) {
                    z = true;
                    break;
                }
            }
            if (z) {
                break;
            }
        }
        return z;
    }
}
