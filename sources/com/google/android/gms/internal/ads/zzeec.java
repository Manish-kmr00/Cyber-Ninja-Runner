package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeec implements zzdfm {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzfau zzd;
    private final zzcel zze;
    private final zzfbp zzf;
    private final zzbjm zzg;
    private final boolean zzh;
    private final zzebe zzi;
    private final zzdre zzj;

    zzeec(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfau zzfauVar, zzcel zzcelVar, zzfbp zzfbpVar, boolean z, zzbjm zzbjmVar, zzebe zzebeVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzfauVar;
        this.zze = zzcelVar;
        this.zzf = zzfbpVar;
        this.zzg = zzbjmVar;
        this.zzh = z;
        this.zzi = zzebeVar;
        this.zzj = zzdreVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final zzfau zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzb(boolean z, Context context, zzcvp zzcvpVar) {
        zzdeb zzdebVar = (zzdeb) zzgbs.zzq(this.zzc);
        zzcel zzcelVar = this.zze;
        zzcelVar.zzaq(true);
        boolean z2 = this.zzh;
        boolean zZze = z2 ? this.zzg.zze(false) : false;
        com.google.android.gms.ads.internal.zzv.zzq();
        boolean zZzJ = com.google.android.gms.ads.internal.util.zzs.zzJ(this.zza);
        boolean zZzd = z2 ? this.zzg.zzd() : false;
        float fZza = z2 ? this.zzg.zza() : 0.0f;
        zzfau zzfauVar = this.zzd;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZze, zZzJ, zZzd, fZza, -1, z, zzfauVar.zzO, false);
        if (zzcvpVar != null) {
            zzcvpVar.zzf();
        }
        com.google.android.gms.ads.internal.zzv.zzj();
        zzdfb zzdfbVarZzh = zzdebVar.zzh();
        int i = zzfauVar.zzQ;
        VersionInfoParcel versionInfoParcel = this.zzb;
        String str = zzfauVar.zzB;
        zzfaz zzfazVar = zzfauVar.zzs;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzdfbVarZzh, null, zzcelVar, i, versionInfoParcel, str, zzlVar, zzfazVar.zzb, zzfazVar.zza, this.zzf.zzf, zzcvpVar, zzfauVar.zzb() ? this.zzi : null, zzcelVar.zzr()), true, this.zzj);
    }
}
