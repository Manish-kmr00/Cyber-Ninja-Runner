package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzedk implements zzecl {
    private final Context zza;
    private final zzcpd zzb;
    private final Executor zzc;

    public zzedk(Context context, zzcpd zzcpdVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcpdVar;
        this.zzc = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzecl
    public final /* bridge */ /* synthetic */ Object zza(zzfbg zzfbgVar, final zzfau zzfauVar, zzeci zzeciVar) throws zzefy, zzfbw {
        final View viewZza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhU)).booleanValue() && zzfauVar.zzag) {
            zzbph zzbphVarZzc = ((zzfcn) zzeciVar.zzb).zzc();
            if (zzbphVarZzc == null) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzfbw(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
            try {
                viewZza = (View) ObjectWrapper.unwrap(zzbphVarZzc.zze());
                boolean zZzf = zzbphVarZzc.zzf();
                if (viewZza == null) {
                    throw new zzfbw(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        viewZza = (View) zzgbs.zzn(zzgbs.zzh(null), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzedi
                            @Override // com.google.android.gms.internal.ads.zzgaz
                            public final ListenableFuture zza(Object obj) {
                                return zzgbs.zzh(zzcps.zza(this.zza.zza, viewZza, zzfauVar));
                            }
                        }, zzbzk.zzf).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfbw(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfbw(e2);
            }
        } else {
            viewZza = ((zzfcn) zzeciVar.zzb).zza();
        }
        zzcpd zzcpdVar = this.zzb;
        zzcqw zzcqwVar = new zzcqw(zzfbgVar, zzfauVar, zzeciVar.zza);
        final zzfcn zzfcnVar = (zzfcn) zzeciVar.zzb;
        Objects.requireNonNull(zzfcnVar);
        zzcoa zzcoaVarZza = zzcpdVar.zza(zzcqwVar, new zzcog(viewZza, null, new zzcqe() { // from class: com.google.android.gms.internal.ads.zzedj
            @Override // com.google.android.gms.internal.ads.zzcqe
            public final com.google.android.gms.ads.internal.client.zzea zza() {
                return zzfcnVar.zzb();
            }
        }, (zzfav) zzfauVar.zzu.get(0)));
        zzcoaVarZza.zzh().zza(viewZza);
        zzcoaVarZza.zzd().zzo(new zzcln(zzfcnVar), this.zzc);
        ((zzedw) zzeciVar.zzc).zzc(zzcoaVarZza.zzk());
        return zzcoaVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzecl
    public final void zzb(zzfbg zzfbgVar, zzfau zzfauVar, zzeci zzeciVar) throws zzfbw {
        com.google.android.gms.ads.internal.client.zzr zzrVar;
        zzfbp zzfbpVar = zzfbgVar.zza.zza;
        com.google.android.gms.ads.internal.client.zzr zzrVar2 = zzfbpVar.zze;
        if (zzrVar2.zzn) {
            zzrVar = new com.google.android.gms.ads.internal.client.zzr(this.zza, com.google.android.gms.ads.zzc.zzd(zzrVar2.zze, zzrVar2.zzb));
        } else {
            zzrVar = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhU)).booleanValue() && zzfauVar.zzag) ? new com.google.android.gms.ads.internal.client.zzr(this.zza, com.google.android.gms.ads.zzc.zze(zzrVar2.zze, zzrVar2.zzb)) : zzfbv.zza(this.zza, zzfauVar.zzu);
        }
        com.google.android.gms.ads.internal.client.zzr zzrVar3 = zzrVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhU)).booleanValue() && zzfauVar.zzag) {
            ((zzfcn) zzeciVar.zzb).zzn(this.zza, zzrVar3, zzfbpVar.zzd, zzfauVar.zzv.toString(), com.google.android.gms.ads.internal.util.zzbs.zzm(zzfauVar.zzs), (zzbpe) zzeciVar.zzc);
        } else {
            ((zzfcn) zzeciVar.zzb).zzm(this.zza, zzrVar3, zzfbpVar.zzd, zzfauVar.zzv.toString(), com.google.android.gms.ads.internal.util.zzbs.zzm(zzfauVar.zzs), (zzbpe) zzeciVar.zzc);
        }
    }
}
