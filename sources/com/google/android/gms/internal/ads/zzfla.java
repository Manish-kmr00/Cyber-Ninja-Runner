package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfla extends BroadcastReceiver {
    final /* synthetic */ zzflb zza;

    zzfla(zzflb zzflbVar) {
        this.zza = zzflbVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            zzflb zzflbVar = this.zza;
            zzflbVar.zzd(true, zzflbVar.zzd);
            zzflbVar.zzc = true;
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            zzflb zzflbVar2 = this.zza;
            zzflbVar2.zzd(false, zzflbVar2.zzd);
            zzflbVar2.zzc = false;
        }
    }
}
