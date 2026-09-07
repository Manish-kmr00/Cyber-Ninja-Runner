package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.g5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4133g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f11562a = new CopyOnWriteArrayList();

    public final void a(InterfaceC4530w4 interfaceC4530w4) {
        this.f11562a.add(interfaceC4530w4);
    }

    public final void b(InterfaceC4530w4 interfaceC4530w4) {
        this.f11562a.remove(interfaceC4530w4);
    }

    public final List<InterfaceC4530w4> a() {
        return this.f11562a;
    }
}
