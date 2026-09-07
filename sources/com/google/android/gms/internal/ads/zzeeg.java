package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeeg implements zzdfm {
    final /* synthetic */ zzeci zza;
    final /* synthetic */ zzfau zzb;
    final /* synthetic */ zzeeh zzc;

    zzeeg(zzeeh zzeehVar, zzeci zzeciVar, zzfau zzfauVar) {
        this.zza = zzeciVar;
        this.zzb = zzfauVar;
        this.zzc = zzeehVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final zzfau zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzb(boolean z, Context context, zzcvp zzcvpVar) throws zzdfl {
        try {
            zzfcn zzfcnVar = (zzfcn) this.zza.zzb;
            zzfcnVar.zzv(z);
            if (this.zzc.zzc.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzaW)).intValue()) {
                zzfcnVar.zzx();
            } else {
                zzfcnVar.zzy(context);
            }
        } catch (zzfbw e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot show interstitial.");
            throw new zzdfl(e.getCause());
        }
    }
}
