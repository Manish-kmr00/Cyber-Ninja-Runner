package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.hl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4174hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4223jl f11588a;

    public C4174hl(C4223jl c4223jl) {
        this.f11588a = c4223jl;
    }

    public final void a(String str, EnumC4273ll enumC4273ll, Hl hl) {
        ArrayList arrayList;
        synchronized (this.f11588a.b) {
            Collection collection = (Collection) this.f11588a.f11622a.f11830a.get(str);
            arrayList = collection == null ? new ArrayList() : new ArrayList(collection);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((InterfaceC4447sl) it.next()).a(enumC4273ll, hl);
        }
    }
}
