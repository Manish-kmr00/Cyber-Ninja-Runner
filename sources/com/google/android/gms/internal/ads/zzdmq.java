package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdmq implements Callable {
    private final com.google.android.gms.ads.internal.zza zza;
    private final Context zzb;
    private final zzdre zzc;
    private final zzeat zzd;
    private final Executor zze;
    private final zzauy zzf;
    private final VersionInfoParcel zzg;
    private final zzfio zzh;
    private final zzebe zzi;
    private final zzfbt zzj;

    public zzdmq(Context context, Executor executor, zzauy zzauyVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzcey zzceyVar, zzeat zzeatVar, zzfio zzfioVar, zzdre zzdreVar, zzebe zzebeVar, zzfbt zzfbtVar) {
        this.zzb = context;
        this.zze = executor;
        this.zzf = zzauyVar;
        this.zzg = versionInfoParcel;
        this.zza = zzaVar;
        this.zzd = zzeatVar;
        this.zzh = zzfioVar;
        this.zzc = zzdreVar;
        this.zzi = zzebeVar;
        this.zzj = zzfbtVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdmt zzdmtVar = new zzdmt(this);
        zzdmtVar.zzk();
        return zzdmtVar;
    }
}
