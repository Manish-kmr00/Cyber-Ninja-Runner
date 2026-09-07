package com.inmobi.media;

import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class O4 {
    public static void a() {
        try {
            Iterator it = P4.f3165a.iterator();
            while (it.hasNext()) {
                C3468m6 c3468m6 = (C3468m6) ((WeakReference) it.next()).get();
                if (c3468m6 != null) {
                    c3468m6.a();
                }
            }
        } catch (Exception e) {
            C3339d5 c3339d5 = C3339d5.f3292a;
            C3339d5.c.a(I4.a(e, "event"));
        }
    }
}
