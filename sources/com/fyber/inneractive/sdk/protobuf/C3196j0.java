package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.bidder.C3062j;
import java.util.AbstractList;
import java.util.List;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class C3196j0 extends AbstractList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2287a;
    public final InterfaceC3193i0 b;

    public C3196j0(List list, InterfaceC3193i0 interfaceC3193i0) {
        this.f2287a = list;
        this.b = interfaceC3193i0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        InterfaceC3193i0 interfaceC3193i0 = this.b;
        Object obj = this.f2287a.get(i);
        ((C3062j) interfaceC3193i0).getClass();
        com.fyber.inneractive.sdk.bidder.L lA = com.fyber.inneractive.sdk.bidder.L.a(((Integer) obj).intValue());
        return lA == null ? com.fyber.inneractive.sdk.bidder.L.UNRECOGNIZED : lA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2287a.size();
    }
}
