package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.t5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4456t5 implements Yn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11774a;

    public C4456t5(List<? extends Pair<String, ? extends Yn>> list) {
        this.f11774a = list;
    }

    @Override // io.appmetrica.analytics.impl.Yn
    public final String a() {
        Iterator it = this.f11774a.iterator();
        while (it.hasNext()) {
            String strA = ((Yn) ((Pair) it.next()).getSecond()).a();
            if (strA != null && strA.length() > 0) {
                return strA;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.Yn
    public final void a(String str) {
        Iterator it = this.f11774a.iterator();
        while (it.hasNext()) {
            ((Yn) ((Pair) it.next()).getSecond()).a(str);
        }
    }
}
