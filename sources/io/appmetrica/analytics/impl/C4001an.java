package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.BiFunction;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.an, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4001an {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Zm f11468a;
    public final BiFunction b;
    public final C4264lc c;

    public C4001an() {
        this(new Xm(), new C4436sa(), C4455t4.i().l());
    }

    public final ArrayList a(Thread thread, Thread thread2) {
        Map mapC;
        ArrayList arrayList = new ArrayList();
        TreeMap treeMap = new TreeMap(new Ym());
        try {
            mapC = this.f11468a.c();
        } catch (SecurityException unused) {
            mapC = null;
        }
        if (mapC != null) {
            treeMap.putAll(mapC);
        }
        if (thread2 != null) {
            treeMap.remove(thread2);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread3 = (Thread) entry.getKey();
            if (thread3 != thread && thread3 != thread2) {
                arrayList.add((Tm) this.b.apply(thread3, (StackTraceElement[]) entry.getValue()));
            }
        }
        return arrayList;
    }

    public C4001an(Zm zm, C4436sa c4436sa, C4264lc c4264lc) {
        this.f11468a = zm;
        this.b = c4436sa;
        this.c = c4264lc;
    }
}
