package com.five_corp.ad.internal.util;

import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f1561a = new ArrayList();

    public final void a(AbstractCollection abstractCollection) {
        ArrayList arrayList = new ArrayList();
        for (WeakReference weakReference : this.f1561a) {
            Object obj = weakReference.get();
            if (obj != null) {
                arrayList.add(weakReference);
                abstractCollection.add(obj);
            }
        }
        this.f1561a = arrayList;
    }
}
