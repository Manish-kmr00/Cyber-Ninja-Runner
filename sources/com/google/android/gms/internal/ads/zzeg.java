package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzeg extends BroadcastReceiver {
    final /* synthetic */ zzei zza;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, Intent intent) {
        this.zza.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzef
            @Override // java.lang.Runnable
            public final void run() {
                zzei.zzd(this.zza.zza, context);
            }
        });
    }
}
