package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfjm implements Runnable {
    final /* synthetic */ zzfjn zza;

    zzfjm(zzfjn zzfjnVar) {
        this.zza = zzfjnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfjn zzfjnVar = this.zza;
        if (zzfjnVar.zzn != null) {
            zzfjnVar.zzn.zzd(AdFormat.getAdFormat(zzfjnVar.zze.zzb), zzfjnVar.zzo.currentTimeMillis());
        }
    }
}
