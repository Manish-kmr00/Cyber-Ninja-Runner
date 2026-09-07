package com.fyber.inneractive.sdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3260y extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f2382a;

    public C3260y(B b) {
        this.f2382a = b;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        B b = this.f2382a;
        b.getClass();
        IAlog.a("%sonReceive. action = %s", IAlog.a(b), intent.getAction());
        B.a(this.f2382a, context, intent);
    }
}
