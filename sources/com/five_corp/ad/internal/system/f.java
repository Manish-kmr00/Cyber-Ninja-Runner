package com.five_corp.ad.internal.system;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: loaded from: classes12.dex */
public final class f extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1544a;

    public f(h hVar) {
        this.f1544a = hVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        h hVar = this.f1544a;
        hVar.getClass();
        try {
            hVar.a();
        } catch (Exception e) {
            hVar.c.a(e);
        }
    }
}
