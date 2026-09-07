package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbrr implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbrt zza;

    zzbrr(zzbrt zzbrtVar) {
        this.zza = zzbrtVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbrt zzbrtVar = this.zza;
        Intent intentZzb = zzbrtVar.zzb();
        com.google.android.gms.ads.internal.zzv.zzq();
        com.google.android.gms.ads.internal.util.zzs.zzU(zzbrtVar.zzb, intentZzb);
    }
}
