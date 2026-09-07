package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzecu implements zzecl {
    private final Context zza;
    private final zzcnn zzb;
    private final Executor zzc;

    zzecu(Context context, zzcnn zzcnnVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcnnVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        zzcnk zzcnkVarZza = this.zzb.zza(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzdee(new zzect(this, zzeciVar, zzfauVar), null), new zzcnl(zzfauVar.zzaa));
        zzcnkVarZza.zzd().zzo(new zzcln((zzfcn) zzeciVar.zzb), this.zzc);
        ((zzedw) zzeciVar.zzc).zzc(zzcnkVarZza.zzk());
        return zzcnkVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        zzfcn zzfcnVar = (zzfcn) zzeciVar.zzb;
        zzfbp zzfbpVar = zzfbgVar.zza.zza;
        String string = zzfauVar.zzv.toString();
        zzfcnVar.zzl(this.zza, zzfbpVar.zzd, string, (zzbpe) zzeciVar.zzc);
    }
}
