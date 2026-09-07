package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzpe extends BroadcastReceiver {
    final /* synthetic */ zzpg zza;

    /* synthetic */ zzpe(zzpg zzpgVar, zzpf zzpfVar) {
        this.zza = zzpgVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        zzpg zzpgVar = this.zza;
        zzpgVar.zzj(zzpb.zzd(context, intent, zzpgVar.zzh, zzpgVar.zzg));
    }
}
