package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzeew implements zzecl {
    private final Context zza;
    private final zzdga zzb;
    private final Executor zzc;

    public zzeew(Context context, zzdga zzdgaVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdgaVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfbg zzfbgVar, int i) {
        return zzfbgVar.zza.zza.zzg.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        zzdhq zzdhqVarZzah;
        zzfcn zzfcnVar = (zzfcn) zzeciVar.zzb;
        zzbpj zzbpjVarZzD = zzfcnVar.zzD();
        zzbpk zzbpkVarZzE = zzfcnVar.zzE();
        zzbpn zzbpnVarZzd = zzfcnVar.zzd();
        if (zzbpnVarZzd != null && zzc(zzfbgVar, 6)) {
            zzdhqVarZzah = zzdhq.zzt(zzbpnVarZzd);
        } else if (zzbpjVarZzD != null && zzc(zzfbgVar, 6)) {
            zzdhqVarZzah = zzdhq.zzai(zzbpjVarZzD);
        } else if (zzbpjVarZzD != null && zzc(zzfbgVar, 2)) {
            zzdhqVarZzah = zzdhq.zzag(zzbpjVarZzD);
        } else if (zzbpkVarZzE != null && zzc(zzfbgVar, 6)) {
            zzdhqVarZzah = zzdhq.zzaj(zzbpkVarZzE);
        } else {
            if (zzbpkVarZzE == null || !zzc(zzfbgVar, 1)) {
                throw new zzefy(1, "No native ad mappers");
            }
            zzdhqVarZzah = zzdhq.zzah(zzbpkVarZzE);
        }
        if (zzdhqVarZzah != null) {
            zzfbp zzfbpVar = zzfbgVar.zza.zza;
            if (zzfbpVar.zzg.contains(Integer.toString(zzdhqVarZzah.zzc()))) {
                zzdhs zzdhsVarZze = this.zzb.zze(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzdic(zzdhqVarZzah), new zzdjv(zzbpkVarZzE, zzbpjVarZzD, zzbpnVarZzd));
                ((zzedw) zzeciVar.zzc).zzc(zzdhsVarZze.zzk());
                zzdhsVarZze.zzd().zzo(new zzcln(zzfcnVar), this.zzc);
                return zzdhsVarZze.zza();
            }
        }
        throw new zzefy(1, "No corresponding native ad listener");
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        zzfcn zzfcnVar = (zzfcn) zzeciVar.zzb;
        zzfbp zzfbpVar = zzfbgVar.zza.zza;
        String string = zzfauVar.zzv.toString();
        String strZzm = com.google.android.gms.ads.internal.util.zzbs.zzm(zzfauVar.zzs);
        zzfcnVar.zzp(this.zza, zzfbpVar.zzd, string, strZzm, (zzbpe) zzeciVar.zzc, zzfbpVar.zzi, zzfbpVar.zzg);
    }
}
