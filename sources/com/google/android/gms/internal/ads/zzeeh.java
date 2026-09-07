package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzeeh implements zzecl {
    private final Context zza;
    private final zzdfe zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzeeh(Context context, VersionInfoParcel versionInfoParcel, zzdfe zzdfeVar, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdfeVar;
        this.zzd = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        zzdeb zzdebVarZzd = this.zzb.zzd(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzdee(new zzeeg(this, zzeciVar, zzfauVar), null));
        zzdebVarZzd.zzd().zzo(new zzcln((zzfcn) zzeciVar.zzb), this.zzd);
        ((zzedw) zzeciVar.zzc).zzc(zzdebVarZzd.zzk());
        return zzdebVarZzd.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        zzfcn zzfcnVar = (zzfcn) zzeciVar.zzb;
        zzfbp zzfbpVar = zzfbgVar.zza.zza;
        String string = zzfauVar.zzv.toString();
        String strZzm = com.google.android.gms.ads.internal.util.zzbs.zzm(zzfauVar.zzs);
        zzfcnVar.zzo(this.zza, zzfbpVar.zzd, string, strZzm, (zzbpe) zzeciVar.zzc);
    }
}
