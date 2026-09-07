package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzegl implements zzecl {
    private final Context zza;
    private final zzdnn zzb;

    public zzegl(Context context, zzdnn zzdnnVar) {
        this.zza = context;
        this.zzb = zzdnnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        zzeef zzeefVar = new zzeef(zzfauVar, (zzbqx) zzeciVar.zzb, AdFormat.REWARDED);
        zzdnj zzdnjVarZzd = this.zzb.zzd(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzdnk(zzeefVar));
        zzeefVar.zzc(zzdnjVarZzd.zzc());
        ((zzedw) zzeciVar.zzc).zzc(zzdnjVarZzd.zzo());
        return zzdnjVarZzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        try {
            zzbqx zzbqxVar = (zzbqx) zzeciVar.zzb;
            zzbqxVar.zzq(zzfauVar.zzZ);
            zzfbp zzfbpVar = zzfbgVar.zza.zza;
            if (zzfbpVar.zzo.zza == 3) {
                zzbqxVar.zzo(zzfauVar.zzU, zzfauVar.zzv.toString(), zzfbpVar.zzd, ObjectWrapper.wrap(this.zza), new zzegj(this, zzeciVar, null), (zzbpe) zzeciVar.zzc);
            } else {
                zzbqxVar.zzp(zzfauVar.zzU, zzfauVar.zzv.toString(), zzfbpVar.zzd, ObjectWrapper.wrap(this.zza), new zzegj(this, zzeciVar, null), (zzbpe) zzeciVar.zzc);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }
}
