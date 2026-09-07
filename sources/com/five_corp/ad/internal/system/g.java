package com.five_corp.ad.internal.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes12.dex */
public final class g extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1545a;

    public g(h hVar) {
        this.f1545a = hVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        h hVar = this.f1545a;
        hVar.getClass();
        try {
            NetworkInfo activeNetworkInfo = hVar.b.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return;
            }
            hVar.a();
        } catch (Exception e) {
            hVar.c.a(e);
        }
    }
}
