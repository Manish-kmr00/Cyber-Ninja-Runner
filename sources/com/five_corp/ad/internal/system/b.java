package com.five_corp.ad.internal.system;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements DefaultLifecycleObserver {
    public boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.util.h f1541a = new com.five_corp.ad.internal.util.h();

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(LifecycleOwner lifecycleOwner) {
        this.b = false;
        com.five_corp.ad.internal.util.h hVar = this.f1541a;
        hVar.getClass();
        ArrayList<com.five_corp.ad.internal.k> arrayList = new ArrayList();
        hVar.a(arrayList);
        for (com.five_corp.ad.internal.k kVar : arrayList) {
            boolean z = kVar.b && kVar.c;
            if (kVar.c) {
                kVar.c = false;
                if (z) {
                    kVar.f1412a.n();
                }
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        this.b = true;
        com.five_corp.ad.internal.util.h hVar = this.f1541a;
        hVar.getClass();
        ArrayList<com.five_corp.ad.internal.k> arrayList = new ArrayList();
        hVar.a(arrayList);
        for (com.five_corp.ad.internal.k kVar : arrayList) {
            if (!kVar.c) {
                kVar.c = true;
                if (kVar.b) {
                    kVar.f1412a.m();
                }
            }
        }
    }
}
