package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzsi extends Handler {
    final /* synthetic */ zzsk zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzsi(zzsk zzskVar, Looper looper) {
        super(looper);
        this.zza = zzskVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        zzsk.zza(this.zza, message);
    }
}
