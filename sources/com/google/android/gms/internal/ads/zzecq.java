package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzecq implements zzecf {
    private final zzcnn zza;
    private final Context zzb;
    private final zzdoe zzc;
    private final zzfbp zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbjm zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziX)).booleanValue();
    private final zzebe zzi;
    private final zzdqy zzj;
    private final zzdre zzk;

    public zzecq(zzcnn zzcnnVar, Context context, Executor executor, zzdoe zzdoeVar, zzfbp zzfbpVar, VersionInfoParcel versionInfoParcel, zzbjm zzbjmVar, zzebe zzebeVar, zzdqy zzdqyVar, zzdre zzdreVar) {
        this.zzb = context;
        this.zza = zzcnnVar;
        this.zze = executor;
        this.zzc = zzdoeVar;
        this.zzd = zzfbpVar;
        this.zzf = versionInfoParcel;
        this.zzg = zzbjmVar;
        this.zzi = zzebeVar;
        this.zzj = zzdqyVar;
        this.zzk = zzdreVar;
    }

    public static /* synthetic */ ListenableFuture zzc(zzecq zzecqVar, final zzfau zzfauVar, zzfbg zzfbgVar, zzdoi zzdoiVar, Object obj) throws zzcex {
        final zzecq zzecqVar2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            zzecqVar.zzj.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzdoe zzdoeVar = zzecqVar.zzc;
        zzfbp zzfbpVar = zzecqVar.zzd;
        final zzcel zzcelVarZza = zzdoeVar.zza(zzfbpVar.zze, zzfauVar, zzfbgVar.zzb.zzb);
        zzcelVarZza.zzac(zzfauVar.zzW);
        zzdoiVar.zza(zzecqVar.zzb, zzcelVarZza.zzF());
        zzbbz zzbbzVar = zzbci.zzcs;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzecqVar.zzj.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzbzp zzbzpVar = new zzbzp();
        zzcnn zzcnnVar = zzecqVar.zza;
        zzcqw zzcqwVar = new zzcqw(zzfbgVar, zzfauVar, null);
        VersionInfoParcel versionInfoParcel = zzecqVar.zzf;
        boolean z = zzecqVar.zzh;
        zzbjm zzbjmVar = zzecqVar.zzg;
        final zzcnk zzcnkVarZza = zzcnnVar.zza(zzcqwVar, new zzdee(new zzecs(versionInfoParcel, zzbzpVar, zzfauVar, zzcelVarZza, zzfbpVar, z, zzbjmVar, zzecqVar.zzi, zzecqVar.zzk), zzcelVarZza), new zzcnl(zzfauVar.zzaa));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzecqVar2 = zzecqVar;
            zzecqVar2.zzj.zza().putLong(zzdqm.RENDERING_AD_COMPONENT_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        } else {
            zzecqVar2 = zzecqVar;
        }
        zzdod zzdodVarZzh = zzcnkVarZza.zzh();
        zzbjm zzbjmVar2 = true != z ? null : zzbjmVar;
        zzdqy zzdqyVar = zzecqVar2.zzj;
        zzdodVarZzh.zzi(zzcelVarZza, false, zzbjmVar2, zzdqyVar.zza());
        zzbzpVar.zzc(zzcnkVarZza);
        zzcnkVarZza.zzc().zzo(new zzcvw() { // from class: com.google.android.gms.internal.ads.zzeco
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
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfp)).booleanValue() && zzcnkVarZza.zzi().zze(true)) {
            strZzb = zzcfw.zzb(strZzb, zzcfw.zza(zzfauVar));
        }
        zzcnkVarZza.zzh();
        return zzgbs.zzm(zzdod.zzj(zzcelVarZza, zzfazVar.zzb, strZzb, zzdqyVar.zza()), new zzftl(zzecqVar2) { // from class: com.google.android.gms.internal.ads.zzecp
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj2) {
                zzcel zzcelVar = zzcelVarZza;
                if (zzfauVar.zzM) {
                    zzcelVar.zzah();
                }
                zzcnk zzcnkVar = zzcnkVarZza;
                zzcelVar.zzab();
                zzcelVar.onPause();
                return zzcnkVar.zza();
            }
        }, zzecqVar2.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final ListenableFuture zza(final zzfbg zzfbgVar, final zzfau zzfauVar) {
        final zzdoi zzdoiVar = new zzdoi();
        ListenableFuture listenableFutureZzh = zzgbs.zzh(null);
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzecm
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzecq.zzc(this.zza, zzfauVar, zzfbgVar, zzdoiVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture listenableFutureZzn = zzgbs.zzn(listenableFutureZzh, zzgazVar, executor);
        Objects.requireNonNull(zzdoiVar);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzecn
            @Override // java.lang.Runnable
            public final void run() {
                zzdoiVar.zzb();
            }
        }, executor);
        return listenableFutureZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final boolean zzb(zzfbg zzfbgVar, zzfau zzfauVar) {
        zzfaz zzfazVar = zzfauVar.zzs;
        return (zzfazVar == null || zzfazVar.zza == null) ? false : true;
    }
}
