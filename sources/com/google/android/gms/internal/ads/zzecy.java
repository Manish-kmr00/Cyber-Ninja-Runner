package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzecy implements zzecl {
    private final Context zza;
    private final zzcnn zzb;

    zzecy(Context context, zzcnn zzcnnVar) {
        this.zza = context;
        this.zzb = zzcnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        zzeef zzeefVar = new zzeef(zzfauVar, (zzbqx) zzeciVar.zzb, AdFormat.APP_OPEN_AD);
        zzcnk zzcnkVarZza = this.zzb.zza(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzdee(zzeefVar, null), new zzcnl(zzfauVar.zzaa));
        zzeefVar.zzc(zzcnkVarZza.zzc());
        ((zzedw) zzeciVar.zzc).zzc(zzcnkVarZza.zzj());
        return zzcnkVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        try {
            zzbqx zzbqxVar = (zzbqx) zzeciVar.zzb;
            zzbqxVar.zzq(zzfauVar.zzZ);
            zzbqxVar.zzi(zzfauVar.zzU, zzfauVar.zzv.toString(), zzfbgVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzecw(zzeciVar, null), (zzbpe) zzeciVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading an app open RTB ad", e);
            throw new zzfbw(e);
        }
    }
}
