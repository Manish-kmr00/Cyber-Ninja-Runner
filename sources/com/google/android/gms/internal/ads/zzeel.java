package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzeel implements zzecl {
    private final Context zza;
    private final zzdfe zzb;

    public zzeel(Context context, zzdfe zzdfeVar) {
        this.zza = context;
        this.zzb = zzdfeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        zzeef zzeefVar = new zzeef(zzfauVar, (zzbqx) zzeciVar.zzb, AdFormat.INTERSTITIAL);
        zzdeb zzdebVarZzd = this.zzb.zzd(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzdee(zzeefVar, null));
        zzeefVar.zzc(zzdebVarZzd.zzc());
        ((zzedw) zzeciVar.zzc).zzc(zzdebVarZzd.zzj());
        return zzdebVarZzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        try {
            zzbqx zzbqxVar = (zzbqx) zzeciVar.zzb;
            zzbqxVar.zzq(zzfauVar.zzZ);
            zzbqxVar.zzl(zzfauVar.zzU, zzfauVar.zzv.toString(), zzfbgVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeej(this, zzeciVar, null), (zzbpe) zzeciVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a interstitial RTB ad", e);
            throw new zzfbw(e);
        }
    }
}
