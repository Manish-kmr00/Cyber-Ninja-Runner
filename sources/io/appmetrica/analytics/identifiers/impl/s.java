package io.appmetrica.analytics.identifiers.impl;

import android.os.IBinder;

/* JADX INFO: loaded from: classes12.dex */
public final class s implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f11047a;

    public s(IBinder iBinder) {
        this.f11047a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f11047a;
    }
}
