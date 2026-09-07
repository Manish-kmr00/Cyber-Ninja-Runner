package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.wa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4536wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f11830a;
    public final boolean b;

    public C4536wa() {
        this(false);
    }

    public final void a(Object obj, Object obj2) {
        Collection collection = (Collection) this.f11830a.get(obj);
        ArrayList arrayList = collection == null ? new ArrayList() : new ArrayList(collection);
        arrayList.add(obj2);
    }

    public final String toString() {
        return this.f11830a.toString();
    }

    public C4536wa(boolean z) {
        this.f11830a = new HashMap();
        this.b = z;
    }
}
