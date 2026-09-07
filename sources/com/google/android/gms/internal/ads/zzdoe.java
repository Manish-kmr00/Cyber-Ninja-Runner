package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdoe {
    private final Context zza;
    private final zzauy zzb;
    private final zzbdp zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbbg zzf;
    private final zzcxv zzg;
    private final zzebe zzh;
    private final zzfbt zzi;
    private final zzdre zzj;

    public zzdoe(zzcey zzceyVar, Context context, zzauy zzauyVar, zzbdp zzbdpVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbbg zzbbgVar, zzcxv zzcxvVar, zzebe zzebeVar, zzfbt zzfbtVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzb = zzauyVar;
        this.zzc = zzbdpVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbbgVar;
        this.zzg = zzcxvVar;
        this.zzh = zzebeVar;
        this.zzi = zzfbtVar;
        this.zzj = zzdreVar;
    }

    public final zzcel zza(com.google.android.gms.ads.internal.client.zzr zzrVar, zzfau zzfauVar, zzfax zzfaxVar) throws zzcex {
        zzcgf zzcgfVarZzc = zzcgf.zzc(zzrVar);
        String str = zzrVar.zza;
        zzdnt zzdntVar = new zzdnt(this);
        zzebe zzebeVar = this.zzh;
        zzfbt zzfbtVar = this.zzi;
        zzdre zzdreVar = this.zzj;
        com.google.android.gms.ads.internal.zza zzaVar = this.zze;
        zzbbg zzbbgVar = this.zzf;
        return zzcey.zza(this.zza, zzcgfVarZzc, str, false, false, this.zzb, this.zzc, this.zzd, null, zzdntVar, zzaVar, zzbbgVar, zzfauVar, zzfaxVar, zzebeVar, zzfbtVar, zzdreVar);
    }
}
