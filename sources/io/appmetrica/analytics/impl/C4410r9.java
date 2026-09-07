package io.appmetrica.analytics.impl;

import java.util.LinkedList;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.r9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4410r9 extends AbstractC4392qf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4095eh f11747a;
    public final C4145gh b;
    public final Sg c;

    public C4410r9(C4282m5 c4282m5) {
        this.f11747a = new C4095eh(c4282m5);
        this.b = new C4145gh(c4282m5);
        this.c = new Sg(c4282m5);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC4392qf
    public final AbstractC4037c9 a(int i) {
        LinkedList linkedList = new LinkedList();
        int iOrdinal = EnumC4164hb.a(i).ordinal();
        if (iOrdinal == 1) {
            linkedList.add(this.f11747a);
        } else if (iOrdinal == 3) {
            linkedList.add(this.c);
        } else if (iOrdinal == 27) {
            linkedList.add(this.b);
            linkedList.add(this.f11747a);
        }
        return new C4012b9(linkedList);
    }
}
