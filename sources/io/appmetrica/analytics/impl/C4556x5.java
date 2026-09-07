package io.appmetrica.analytics.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.x5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4556x5 implements InterfaceC4535w9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final B9 f11840a;
    public final List b;
    public final List c;
    public final AtomicBoolean d;

    public C4556x5(B9 b9, List<? extends J8> list, List<? extends J8> list2, C4108f5 c4108f5) {
        this.f11840a = b9;
        this.b = list;
        this.c = list2;
        Objects.toString(c4108f5);
        this.d = new AtomicBoolean(true);
    }

    public final void a() {
        this.d.set(false);
    }

    public final void b() {
        this.d.set(true);
    }

    public final void c() {
        if (this.d.get()) {
            List list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((J8) it.next()).b()) {
                        return;
                    }
                }
            }
            ((Jm) this.f11840a).b();
        }
    }

    public final void d() {
        if (this.d.get()) {
            List list = this.c;
            if (!list.isEmpty() && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((J8) it.next()).b()) {
                        return;
                    }
                }
            }
            List list2 = this.b;
            if (list2.isEmpty() || list2.isEmpty()) {
                return;
            }
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                if (((J8) it2.next()).b()) {
                    ((Jm) this.f11840a).b();
                    return;
                }
            }
        }
    }
}
