package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzecs implements zzdfm {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzfau zzc;
    private final zzcel zzd;
    private final zzfbp zze;
    private final zzbjm zzf;
    private final boolean zzg;
    private final zzebe zzh;
    private final zzdre zzi;

    zzecs(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfau zzfauVar, zzcel zzcelVar, zzfbp zzfbpVar, boolean z, zzbjm zzbjmVar, zzebe zzebeVar, zzdre zzdreVar) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzfauVar;
        this.zzd = zzcelVar;
        this.zze = zzfbpVar;
        this.zzg = z;
        this.zzf = zzbjmVar;
        this.zzh = zzebeVar;
        this.zzi = zzdreVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final zzfau zza() {
        return this.zzc;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0071  */
    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzb(boolean z, Context context, zzcvp zzcvpVar) {
        zzcnk zzcnkVar = (zzcnk) zzgbs.zzq(this.zzb);
        zzcel zzcelVar = this.zzd;
        zzcelVar.zzaq(true);
        boolean z2 = this.zzg;
        boolean zZze = z2 ? this.zzf.zze(true) : true;
        boolean zZzd = z2 ? this.zzf.zzd() : false;
        float fZza = z2 ? this.zzf.zza() : 0.0f;
        zzfau zzfauVar = this.zzc;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZze, true, zZzd, fZza, -1, z, zzfauVar.zzO, false);
        if (zzcvpVar != null) {
            zzcvpVar.zzf();
        }
        com.google.android.gms.ads.internal.zzv.zzj();
        zzdfb zzdfbVarZzg = zzcnkVar.zzg();
        int i = zzfauVar.zzQ;
        if (i == -1) {
            com.google.android.gms.ads.internal.client.zzx zzxVar = this.zze.zzj;
            if (zzxVar == null) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Error setting app open orientation; no targeting orientation available.");
            } else {
                int i3 = zzxVar.zza;
                if (i3 == 1) {
                    i = 7;
                } else if (i3 == 2) {
                    i = 6;
                } else {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Error setting app open orientation; no targeting orientation available.");
                }
            }
        }
        int i5 = i;
        VersionInfoParcel versionInfoParcel = this.zza;
        String str = zzfauVar.zzB;
        zzfaz zzfazVar = zzfauVar.zzs;
        String str2 = zzfazVar.zzb;
        String str3 = zzfazVar.zza;
        zzfbp zzfbpVar = this.zze;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzdfbVarZzg, null, zzcelVar, i5, versionInfoParcel, str, zzlVar, str2, str3, zzfbpVar.zzf, zzcvpVar, zzfauVar.zzb() ? this.zzh : null, zzcelVar.zzr()), true, this.zzi);
    }
}
