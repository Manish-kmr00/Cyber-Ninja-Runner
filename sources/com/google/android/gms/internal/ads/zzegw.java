package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzegw implements zzdfm {
    private final Context zza;
    private final zzdoe zzb;
    private final zzfbp zzc;
    private final VersionInfoParcel zzd;
    private final zzfau zze;
    private final ListenableFuture zzf;
    private final zzcel zzg;
    private final zzbjm zzh;
    private final boolean zzi;
    private final zzebe zzj;
    private final zzdqy zzk;
    private final zzdre zzl;

    zzegw(Context context, zzdoe zzdoeVar, zzfbp zzfbpVar, VersionInfoParcel versionInfoParcel, zzfau zzfauVar, ListenableFuture listenableFuture, zzcel zzcelVar, zzbjm zzbjmVar, boolean z, zzebe zzebeVar, zzdqy zzdqyVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzb = zzdoeVar;
        this.zzc = zzfbpVar;
        this.zzd = versionInfoParcel;
        this.zze = zzfauVar;
        this.zzf = listenableFuture;
        this.zzg = zzcelVar;
        this.zzh = zzbjmVar;
        this.zzi = z;
        this.zzj = zzebeVar;
        this.zzk = zzdqyVar;
        this.zzl = zzdreVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final zzfau zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void zzb(boolean z, Context context, zzcvp zzcvpVar) {
        zzdnj zzdnjVar = (zzdnj) zzgbs.zzq(this.zzf);
        try {
            zzfau zzfauVar = this.zze;
            final zzcel zzcelVarZza = this.zzg;
            if (zzcelVarZza.zzaG()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbb)).booleanValue()) {
                    zzcelVarZza = this.zzb.zza(this.zzc.zze, null, null);
                    zzbkb.zzb(zzcelVarZza, zzdnjVar.zzg());
                    final zzdoi zzdoiVar = new zzdoi();
                    zzdoiVar.zza(this.zza, zzcelVarZza.zzF());
                    zzdnjVar.zzl().zzi(zzcelVarZza, true, this.zzi ? this.zzh : null, this.zzk.zza());
                    zzcelVarZza.zzN().zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzegu
                        @Override // com.google.android.gms.internal.ads.zzcgb
                        public final void zza(boolean z2, int i, String str, String str2) {
                            zzdoiVar.zzb();
                            zzcel zzcelVar = zzcelVarZza;
                            zzcelVar.zzab();
                            zzcelVar.zzN().zzs();
                        }
                    });
                    zzcgd zzcgdVarZzN = zzcelVarZza.zzN();
                    Objects.requireNonNull(zzcelVarZza);
                    zzcgdVarZzN.zzJ(new zzcgc() { // from class: com.google.android.gms.internal.ads.zzegv
                        @Override // com.google.android.gms.internal.ads.zzcgc
                        public final void zza() {
                            zzcelVarZza.zzaa();
                        }
                    });
                    zzfaz zzfazVar = zzfauVar.zzs;
                    zzcelVarZza.zzae(zzfazVar.zzb, zzfazVar.zza, null);
                }
            }
            zzcel zzcelVar = zzcelVarZza;
            zzcelVar.zzaq(true);
            boolean z2 = this.zzi;
            boolean zZze = z2 ? this.zzh.zze(false) : false;
            com.google.android.gms.ads.internal.zzv.zzq();
            boolean zZzJ = com.google.android.gms.ads.internal.util.zzs.zzJ(this.zza);
            boolean zZzd = z2 ? this.zzh.zzd() : false;
            float fZza = z2 ? this.zzh.zza() : 0.0f;
            zzfau zzfauVar2 = this.zze;
            com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZze, zZzJ, zZzd, fZza, -1, z, zzfauVar2.zzO, zzfauVar2.zzP);
            if (zzcvpVar != null) {
                zzcvpVar.zzf();
            }
            com.google.android.gms.ads.internal.zzv.zzj();
            zzdfb zzdfbVarZzh = zzdnjVar.zzh();
            int i = zzfauVar2.zzQ;
            VersionInfoParcel versionInfoParcel = this.zzd;
            String str = zzfauVar2.zzB;
            zzfaz zzfazVar2 = zzfauVar2.zzs;
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzdfbVarZzh, null, zzcelVar, i, versionInfoParcel, str, zzlVar, zzfazVar2.zzb, zzfazVar2.zza, this.zzc.zzf, zzcvpVar, zzfauVar2.zzb() ? this.zzj : null, zzcelVar.zzr()), true, this.zzl);
        } catch (zzcex e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
