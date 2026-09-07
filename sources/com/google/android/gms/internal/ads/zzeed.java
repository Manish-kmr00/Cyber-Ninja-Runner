package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzeed implements zzecf {
    private final Context zza;
    private final zzdoe zzb;
    private final zzdfe zzc;
    private final zzfbp zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbjm zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziX)).booleanValue();
    private final zzebe zzi;
    private final zzdqy zzj;
    private final zzdre zzk;

    public zzeed(Context context, VersionInfoParcel versionInfoParcel, zzfbp zzfbpVar, Executor executor, zzdfe zzdfeVar, zzdoe zzdoeVar, zzbjm zzbjmVar, zzebe zzebeVar, zzdqy zzdqyVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzd = zzfbpVar;
        this.zzc = zzdfeVar;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdoeVar;
        this.zzg = zzbjmVar;
        this.zzi = zzebeVar;
        this.zzj = zzdqyVar;
        this.zzk = zzdreVar;
    }

    public static /* synthetic */ ListenableFuture zzc(zzeed zzeedVar, final zzfau zzfauVar, zzfbg zzfbgVar, zzdoi zzdoiVar, Object obj) throws zzcex {
        final zzeed zzeedVar2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            zzeedVar.zzj.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzdoe zzdoeVar = zzeedVar.zzb;
        zzfbp zzfbpVar = zzeedVar.zzd;
        final zzcel zzcelVarZza = zzdoeVar.zza(zzfbpVar.zze, zzfauVar, zzfbgVar.zzb.zzb);
        zzcelVarZza.zzac(zzfauVar.zzW);
        Context context = zzeedVar.zza;
        zzdoiVar.zza(context, zzcelVarZza.zzF());
        zzbbz zzbbzVar = zzbci.zzcs;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzeedVar.zzj.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzbzp zzbzpVar = new zzbzp();
        zzdfe zzdfeVar = zzeedVar.zzc;
        zzcqw zzcqwVar = new zzcqw(zzfbgVar, zzfauVar, null);
        VersionInfoParcel versionInfoParcel = zzeedVar.zzf;
        boolean z = zzeedVar.zzh;
        zzbjm zzbjmVar = zzeedVar.zzg;
        final zzdeb zzdebVarZzd = zzdfeVar.zzd(zzcqwVar, new zzdee(new zzeec(context, versionInfoParcel, zzbzpVar, zzfauVar, zzcelVarZza, zzfbpVar, z, zzbjmVar, zzeedVar.zzi, zzeedVar.zzk), zzcelVarZza));
        zzbzpVar.zzc(zzdebVarZzd);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzeedVar2 = zzeedVar;
            zzeedVar2.zzj.zza().putLong(zzdqm.RENDERING_AD_COMPONENT_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        } else {
            zzeedVar2 = zzeedVar;
        }
        zzdebVarZzd.zzc().zzo(new zzcvw() { // from class: com.google.android.gms.internal.ads.zzeea
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
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfp)).booleanValue() && zzdebVarZzd.zzl().zze(true)) {
            strZzb = zzcfw.zzb(strZzb, zzcfw.zza(zzfauVar));
        }
        zzdod zzdodVarZzi = zzdebVarZzd.zzi();
        zzbjm zzbjmVar2 = true != z ? null : zzbjmVar;
        zzdqy zzdqyVar = zzeedVar2.zzj;
        zzdodVarZzi.zzi(zzcelVarZza, true, zzbjmVar2, zzdqyVar.zza());
        zzdebVarZzd.zzi();
        return zzgbs.zzm(zzdod.zzj(zzcelVarZza, zzfazVar.zzb, strZzb, zzdqyVar.zza()), new zzftl(zzeedVar2) { // from class: com.google.android.gms.internal.ads.zzeeb
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj2) {
                zzcel zzcelVar = zzcelVarZza;
                if (zzfauVar.zzM) {
                    zzcelVar.zzah();
                }
                zzdeb zzdebVar = zzdebVarZzd;
                zzcelVar.zzab();
                zzcelVar.onPause();
                return zzdebVar.zzg();
            }
        }, zzeedVar2.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final ListenableFuture zza(final zzfbg zzfbgVar, final zzfau zzfauVar) {
        final zzdoi zzdoiVar = new zzdoi();
        ListenableFuture listenableFutureZzh = zzgbs.zzh(null);
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzedy
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzeed.zzc(this.zza, zzfauVar, zzfbgVar, zzdoiVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture listenableFutureZzn = zzgbs.zzn(listenableFutureZzh, zzgazVar, executor);
        Objects.requireNonNull(zzdoiVar);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedz
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
