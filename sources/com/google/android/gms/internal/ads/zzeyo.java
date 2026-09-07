package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeyo implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;

    public zzeyo(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00a7  */
    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeyl zzb() {
        zzeyl zzeyaVar;
        Context context = (Context) this.zza.zzb();
        zzfcy zzfcyVar = (zzfcy) this.zzb.zzb();
        zzfdq zzfdqVar = (zzfdq) this.zzc.zzb();
        zzbyu zzbyuVarZzg = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgn)).booleanValue() ? com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg() : com.google.android.gms.ads.internal.zzv.zzp().zzi().zzh();
        boolean z = false;
        if (zzbyuVarZzg != null && zzbyuVarZzg.zzh()) {
            z = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgp)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgm)).booleanValue() || z) {
                zzfdp zzfdpVarZza = zzfdqVar.zza(zzfdg.Rewarded, context, zzfcyVar, new zzexp(new zzexm()));
                zzeyb zzeybVar = new zzeyb(new zzeya());
                zzfdc zzfdcVar = zzfdpVarZza.zza;
                zzeyaVar = new zzexr(zzeybVar, new zzexx(zzfdcVar, zzbzk.zza), zzfdpVarZza.zzb, zzfdcVar.zza().zzf, zzbzk.zza);
            } else {
                zzeyaVar = new zzeya();
            }
        } else {
            zzeyaVar = new zzeya();
        }
        return zzeyaVar;
    }
}
