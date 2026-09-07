package com.fyber.inneractive.sdk.protobuf;

import java.util.List;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.t0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3224t0 extends AbstractC3226u0 {
    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3226u0
    public final void a(Object obj, long j) {
        ((AbstractC3174c) ((InterfaceC3202l0) y1.e(obj, j))).f2277a = false;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3226u0
    public final List b(Object obj, long j) {
        InterfaceC3202l0 interfaceC3202l0 = (InterfaceC3202l0) y1.e(obj, j);
        if (((AbstractC3174c) interfaceC3202l0).f2277a) {
            return interfaceC3202l0;
        }
        int size = interfaceC3202l0.size();
        InterfaceC3202l0 interfaceC3202l0B = interfaceC3202l0.b(size == 0 ? 10 : size * 2);
        y1.a(j, obj, interfaceC3202l0B);
        return interfaceC3202l0B;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.AbstractC3226u0
    public final void a(long j, Object obj, Object obj2) {
        InterfaceC3202l0 interfaceC3202l0B = (InterfaceC3202l0) y1.e(obj, j);
        InterfaceC3202l0 interfaceC3202l0 = (InterfaceC3202l0) y1.e(obj2, j);
        int size = interfaceC3202l0B.size();
        int size2 = interfaceC3202l0.size();
        if (size > 0 && size2 > 0) {
            if (!((AbstractC3174c) interfaceC3202l0B).f2277a) {
                interfaceC3202l0B = interfaceC3202l0B.b(size2 + size);
            }
            interfaceC3202l0B.addAll(interfaceC3202l0);
        }
        if (size > 0) {
            interfaceC3202l0 = interfaceC3202l0B;
        }
        y1.a(j, obj, interfaceC3202l0);
    }
}
