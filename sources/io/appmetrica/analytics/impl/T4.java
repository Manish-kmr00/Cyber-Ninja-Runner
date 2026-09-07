package io.appmetrica.analytics.impl;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class T4 extends AbstractC4392qf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S4 f11359a;

    public T4(O4 o4) {
        this.f11359a = new S4(o4);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4392qf
    public final AbstractC4037c9 a(int i) {
        ArrayList arrayList = new ArrayList();
        int iOrdinal = EnumC4164hb.a(i).ordinal();
        if (iOrdinal == 12) {
            arrayList.add(this.f11359a.f11343a);
        } else if (iOrdinal == 14) {
            arrayList.add(this.f11359a.b);
        } else if (iOrdinal == 34) {
            arrayList.add(this.f11359a.c);
        }
        return new C4012b9(arrayList);
    }
}
