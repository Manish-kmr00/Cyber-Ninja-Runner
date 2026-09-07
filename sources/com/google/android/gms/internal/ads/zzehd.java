package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzehd implements zzecl {
    private final Context zza;
    private final Executor zzb;
    private final zzdnn zzc;

    public zzehd(Context context, Executor executor, zzdnn zzdnnVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdnnVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zze(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) {
        try {
            ((zzfcn) zzeciVar.zzb).zzk(zzfbgVar.zza.zza.zzd, zzfauVar.zzv.toString());
        } catch (Exception e) {
            String str = zzeciVar.zza;
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Fail to load ad from adapter ".concat(String.valueOf(str)), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        zzdnj zzdnjVarZzd = this.zzc.zzd(new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza), new zzdnk(new zzehb(this, zzeciVar, zzfauVar)));
        zzdnjVarZzd.zzd().zzo(new zzcln((zzfcn) zzeciVar.zzb), this.zzb);
        zzcwj zzcwjVarZze = zzdnjVarZzd.zze();
        zzcva zzcvaVarZzb = zzdnjVarZzd.zzb();
        ((zzedx) zzeciVar.zzc).zzc(new zzehc(this, zzdnjVarZzd.zza(), zzcvaVarZzb, zzcwjVarZze, zzdnjVarZzd.zzg()));
        return zzdnjVarZzd.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        zzfcn zzfcnVar = (zzfcn) zzeciVar.zzb;
        if (zzfcnVar.zzC()) {
            zze(zzfbgVar, zzfauVar, zzeciVar);
            return;
        }
        zzeha zzehaVar = new zzeha(this, zzfbgVar, zzfauVar, zzeciVar);
        zzcwm zzcwmVar = zzeciVar.zzc;
        ((zzedx) zzcwmVar).zzd(zzehaVar);
        Context context = this.zza;
        zzfbp zzfbpVar = zzfbgVar.zza.zza;
        String string = zzfauVar.zzv.toString();
        zzfcnVar.zzh(context, zzfbpVar.zzd, null, (zzbvv) zzcwmVar, string);
    }
}
