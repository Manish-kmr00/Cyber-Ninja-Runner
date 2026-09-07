package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdwm implements zzgbo {
    final /* synthetic */ zzdwn zza;

    zzdwm(zzdwn zzdwnVar) {
        this.zza = zzdwnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgi)).booleanValue()) {
            Matcher matcher = zzdwn.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfbg zzfbgVar = (zzfbg) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgi)).booleanValue()) {
            zzdwn zzdwnVar = this.zza;
            zzdzp zzdzpVar = zzdwnVar.zzf;
            zzfax zzfaxVar = zzfbgVar.zzb.zzb;
            zzdzpVar.zzi(zzfaxVar.zzf);
            zzdwnVar.zzf.zzj(zzfaxVar.zzg);
        }
    }
}
