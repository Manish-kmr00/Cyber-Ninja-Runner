package com.five_corp.ad.internal.system;

import androidx.lifecycle.ProcessLifecycleOwner;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1540a;

    public a(b bVar) {
        this.f1540a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this.f1540a);
    }
}
