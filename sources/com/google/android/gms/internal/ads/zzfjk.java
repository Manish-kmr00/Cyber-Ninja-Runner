package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdFormat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzfjk implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzdx zzb;
    final /* synthetic */ zzfjn zzc;

    zzfjk(zzfjn zzfjnVar, long j, com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        this.zza = j;
        this.zzb = zzdxVar;
        this.zzc = zzfjnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfjn zzfjnVar = this.zzc;
        if (zzfjnVar.zzn != null) {
            zzfjnVar.zzn.zzc(AdFormat.getAdFormat(zzfjnVar.zze.zzb), this.zza, zzfjn.zzH(this.zzb));
        }
    }
}
