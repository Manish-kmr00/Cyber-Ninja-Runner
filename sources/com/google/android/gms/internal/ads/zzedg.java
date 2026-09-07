package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzedg implements zzecf {
    private final zzcpd zza;
    private final Context zzb;
    private final zzdoe zzc;
    private final zzfbp zzd;
    private final Executor zze;
    private final zzftl zzf;
    private final zzdqy zzg;

    public zzedg(zzcpd zzcpdVar, Context context, Executor executor, zzdoe zzdoeVar, zzfbp zzfbpVar, zzftl zzftlVar, zzdqy zzdqyVar) {
        this.zzb = context;
        this.zza = zzcpdVar;
        this.zze = executor;
        this.zzc = zzdoeVar;
        this.zzd = zzfbpVar;
        this.zzf = zzftlVar;
        this.zzg = zzdqyVar;
    }

    public static /* synthetic */ ListenableFuture zzc(final zzedg zzedgVar, zzfbg zzfbgVar, zzfau zzfauVar, Object obj) throws zzcex {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            zzedgVar.zzg.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        Context context = zzedgVar.zzb;
        com.google.android.gms.ads.internal.client.zzr zzrVarZza = zzfbv.zza(context, zzfauVar.zzu);
        final zzcel zzcelVarZza = zzedgVar.zzc.zza(zzrVarZza, zzfauVar, zzfbgVar.zzb.zzb);
        zzcelVarZza.zzac(zzfauVar.zzW);
        View viewZza = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhU)).booleanValue() && zzfauVar.zzag) ? zzcps.zza(context, zzcelVarZza.zzF(), zzfauVar) : new zzdoh(context, zzcelVarZza.zzF(), (com.google.android.gms.ads.internal.util.zzau) zzedgVar.zzf.apply(zzfauVar));
        zzbbz zzbbzVar = zzbci.zzcs;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzedgVar.zzg.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzcpd zzcpdVar = zzedgVar.zza;
        zzcqw zzcqwVar = new zzcqw(zzfbgVar, zzfauVar, null);
        Objects.requireNonNull(zzcelVarZza);
        final zzcoa zzcoaVarZza = zzcpdVar.zza(zzcqwVar, new zzcog(viewZza, zzcelVarZza, new zzcqe() { // from class: com.google.android.gms.internal.ads.zzeda
            @Override // com.google.android.gms.internal.ads.zzcqe
            public final com.google.android.gms.ads.internal.client.zzea zza() {
                return zzcelVarZza.zzq();
            }
        }, zzfbv.zzb(zzrVarZza)));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzedgVar.zzg.zza().putLong(zzdqm.RENDERING_AD_COMPONENT_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzdod zzdodVarZzi = zzcoaVarZza.zzi();
        zzdqy zzdqyVar = zzedgVar.zzg;
        zzdodVarZzi.zzi(zzcelVarZza, false, null, zzdqyVar.zza());
        zzcoaVarZza.zzc().zzo(new zzcvw() { // from class: com.google.android.gms.internal.ads.zzedb
            @Override // com.google.android.gms.internal.ads.zzcvw
            public final void zzs() {
                zzcel zzcelVar = zzcelVarZza;
                if (zzcelVar.zzN() != null) {
                    zzcelVar.zzN().zzs();
                }
            }
        }, zzbzk.zzg);
        zzfaz zzfazVar = zzfauVar.zzs;
        String strZzb = zzfazVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfp)).booleanValue() && zzcoaVarZza.zzl().zze(true)) {
            strZzb = zzcfw.zzb(strZzb, zzcfw.zza(zzfauVar));
        }
        zzcoaVarZza.zzi();
        ListenableFuture listenableFutureZzj = zzdod.zzj(zzcelVarZza, zzfazVar.zzb, strZzb, zzdqyVar.zza());
        if (zzfauVar.zzM) {
            Objects.requireNonNull(zzcelVarZza);
            listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedc
                @Override // java.lang.Runnable
                public final void run() {
                    zzcelVarZza.zzah();
                }
            }, zzedgVar.zze);
        }
        listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedd
            @Override // java.lang.Runnable
            public final void run() {
                zzedg.zzd(this.zza, zzcelVarZza);
            }
        }, zzedgVar.zze);
        return zzgbs.zzm(listenableFutureZzj, new zzftl() { // from class: com.google.android.gms.internal.ads.zzede
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj2) {
                return zzcoaVarZza.zza();
            }
        }, zzbzk.zzg);
    }

    public static /* synthetic */ void zzd(zzedg zzedgVar, zzcel zzcelVar) {
        zzcelVar.zzab();
        zzfbp zzfbpVar = zzedgVar.zzd;
        zzcfn zzcfnVarZzq = zzcelVar.zzq();
        com.google.android.gms.ads.internal.client.zzfw zzfwVar = zzfbpVar.zza;
        if (zzfwVar != null && zzcfnVarZzq != null) {
            zzcfnVarZzq.zzs(zzfwVar);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbv)).booleanValue() || zzcelVar.isAttachedToWindow()) {
            return;
        }
        zzcelVar.onPause();
        zzcelVar.zzav(true);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final ListenableFuture zza(final zzfbg zzfbgVar, final zzfau zzfauVar) {
        return zzgbs.zzn(zzgbs.zzh(null), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzedf
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzedg.zzc(this.zza, zzfbgVar, zzfauVar, obj);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final boolean zzb(zzfbg zzfbgVar, zzfau zzfauVar) {
        zzfaz zzfazVar = zzfauVar.zzs;
        return (zzfazVar == null || zzfazVar.zza == null) ? false : true;
    }
}
