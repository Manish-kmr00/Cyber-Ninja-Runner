package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeko implements zzekh {
    private final zzfbn zza;
    private final zzcgl zzb;
    private final Context zzc;
    private final zzeke zzd;
    private final zzfgq zze;
    private zzcqv zzf;

    public zzeko(zzcgl zzcglVar, Context context, zzeke zzekeVar, zzfbn zzfbnVar) {
        this.zzb = zzcglVar;
        this.zzc = context;
        this.zzd = zzekeVar;
        this.zza = zzfbnVar;
        this.zze = zzcglVar.zzy();
        zzfbnVar.zzv(zzekeVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    public final boolean zza() {
        zzcqv zzcqvVar = this.zzf;
        return zzcqvVar != null && zzcqvVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzekh
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzekf zzekfVar, zzekg zzekgVar) throws RemoteException {
        zzfgn zzfgnVar;
        com.google.android.gms.ads.internal.zzv.zzq();
        Context context = this.zzc;
        if (com.google.android.gms.ads.internal.util.zzs.zzI(context) && zzmVar.zzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekj
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zza().zzdz(zzfcq.zzd(4, null, null));
                }
            });
            return false;
        }
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zza().zzdz(zzfcq.zzd(6, null, null));
                }
            });
            return false;
        }
        boolean z = zzmVar.zzf;
        zzfcm.zza(context, z);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziY)).booleanValue() && z) {
            this.zzb.zzk().zzo(true);
        }
        int i3 = ((zzeki) zzekfVar).zza;
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
        String strZza = zzdqm.PUBLIC_API_CALL.zza();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        Bundle bundleZza = zzdqo.zza(new Pair(strZza, lValueOf), new Pair(zzdqm.DYNAMITE_ENTER.zza(), lValueOf));
        zzfbn zzfbnVar = this.zza;
        zzfbnVar.zzH(zzmVar);
        zzfbnVar.zzA(bundleZza);
        zzfbnVar.zzC(i3);
        zzfbp zzfbpVarZzJ = zzfbnVar.zzJ();
        zzfgc zzfgcVarZzb = zzfgb.zzb(context, zzfgm.zzf(zzfbpVarZzJ), 8, zzmVar);
        com.google.android.gms.ads.internal.client.zzcl zzclVar = zzfbpVarZzJ.zzn;
        if (zzclVar != null) {
            this.zzd.zzd().zzm(zzclVar);
        }
        zzcgl zzcglVar = this.zzb;
        zzdfz zzdfzVarZzg = zzcglVar.zzg();
        zzcuj zzcujVar = new zzcuj();
        zzcujVar.zzf(context);
        zzcujVar.zzk(zzfbpVarZzJ);
        zzdfzVarZzg.zzf(zzcujVar.zzl());
        zzdau zzdauVar = new zzdau();
        zzeke zzekeVar = this.zzd;
        zzdauVar.zzk(zzekeVar.zzd(), zzcglVar.zzA());
        zzdfzVarZzg.zze(zzdauVar.zzn());
        zzdfzVarZzg.zzd(zzekeVar.zzc());
        zzdfzVarZzg.zzc(new zzcnw(null));
        zzdga zzdgaVarZzg = zzdfzVarZzg.zzg();
        if (((Boolean) zzbeb.zzc.zze()).booleanValue()) {
            zzfgn zzfgnVarZzf = zzdgaVarZzg.zzf();
            zzfgnVarZzf.zzi(8);
            zzfgnVarZzf.zzb(zzmVar.zzp);
            zzfgnVarZzf.zzf(zzmVar.zzm);
            zzfgnVar = zzfgnVarZzf;
        } else {
            zzfgnVar = null;
        }
        zzcglVar.zzx().zzc(1);
        zzgcd zzgcdVarZzc = zzfen.zzc();
        ScheduledExecutorService scheduledExecutorServiceZzB = zzcglVar.zzB();
        zzcrk zzcrkVarZza = zzdgaVarZzg.zza();
        zzcqv zzcqvVar = new zzcqv(zzgcdVarZzc, scheduledExecutorServiceZzB, zzcrkVarZza.zzh(zzcrkVarZza.zzi()));
        this.zzf = zzcqvVar;
        zzcqvVar.zze(new zzekn(this, zzekgVar, zzfgnVar, zzfgcVarZzb, zzdgaVarZzg));
        return true;
    }
}
