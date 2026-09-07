package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzegx implements zzecf {
    private final Context zza;
    private final zzdoe zzb;
    private final zzdnn zzc;
    private final zzfbp zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbjm zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziX)).booleanValue();
    private final zzebe zzi;
    private final zzdqy zzj;
    private final zzdre zzk;

    public zzegx(Context context, VersionInfoParcel versionInfoParcel, zzfbp zzfbpVar, Executor executor, zzdnn zzdnnVar, zzdoe zzdoeVar, zzbjm zzbjmVar, zzebe zzebeVar, zzdqy zzdqyVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzd = zzfbpVar;
        this.zzc = zzdnnVar;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdoeVar;
        this.zzg = zzbjmVar;
        this.zzi = zzebeVar;
        this.zzj = zzdqyVar;
        this.zzk = zzdreVar;
    }

    public static /* synthetic */ ListenableFuture zzc(final zzegx zzegxVar, final zzfau zzfauVar, zzfbg zzfbgVar, zzdoi zzdoiVar, Object obj) throws zzcex {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            zzegxVar.zzj.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzdoe zzdoeVar = zzegxVar.zzb;
        zzfbp zzfbpVar = zzegxVar.zzd;
        final zzcel zzcelVarZza = zzdoeVar.zza(zzfbpVar.zze, zzfauVar, zzfbgVar.zzb.zzb);
        zzcelVarZza.zzac(zzfauVar.zzW);
        Context context = zzegxVar.zza;
        zzdoiVar.zza(context, zzcelVarZza.zzF());
        zzbbz zzbbzVar = zzbci.zzcs;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzegxVar.zzj.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzbzp zzbzpVar = new zzbzp();
        zzdnn zzdnnVar = zzegxVar.zzc;
        zzcqw zzcqwVar = new zzcqw(zzfbgVar, zzfauVar, null);
        VersionInfoParcel versionInfoParcel = zzegxVar.zzf;
        zzbjm zzbjmVar = zzegxVar.zzg;
        boolean z = zzegxVar.zzh;
        zzebe zzebeVar = zzegxVar.zzi;
        zzdqy zzdqyVar = zzegxVar.zzj;
        final zzdnj zzdnjVarZzd = zzdnnVar.zzd(zzcqwVar, new zzdnk(new zzegw(context, zzdoeVar, zzfbpVar, versionInfoParcel, zzfauVar, zzbzpVar, zzcelVarZza, zzbjmVar, z, zzebeVar, zzdqyVar, zzegxVar.zzk), zzcelVarZza));
        zzbzpVar.zzc(zzdnjVarZzd);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzdqyVar.zza().putLong(zzdqm.RENDERING_AD_COMPONENT_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzbkb.zzb(zzcelVarZza, zzdnjVarZzd.zzg());
        zzdnjVarZzd.zzc().zzo(new zzcvw() { // from class: com.google.android.gms.internal.ads.zzegq
            @Override // com.google.android.gms.internal.ads.zzcvw
            public final void zzs() {
                zzcel zzcelVar = zzcelVarZza;
                if (zzcelVar.zzN() != null) {
                    zzcelVar.zzN().zzs();
                }
            }
        }, zzbzk.zzg);
        zzdnjVarZzd.zzl().zzi(zzcelVarZza, true, true != z ? null : zzbjmVar, zzdqyVar.zza());
        zzfaz zzfazVar = zzfauVar.zzs;
        String strZzb = zzfazVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfp)).booleanValue() && zzdnjVarZzd.zzm().zze(true)) {
            strZzb = zzcfw.zzb(strZzb, zzcfw.zza(zzfauVar));
        }
        zzdnjVarZzd.zzl();
        return zzgbs.zzm(zzdod.zzj(zzcelVarZza, zzfazVar.zzb, strZzb, zzdqyVar.zza()), new zzftl(zzegxVar) { // from class: com.google.android.gms.internal.ads.zzegr
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj2) {
                zzcel zzcelVar = zzcelVarZza;
                if (zzfauVar.zzM) {
                    zzcelVar.zzah();
                }
                zzdnj zzdnjVar = zzdnjVarZzd;
                zzcelVar.zzab();
                zzcelVar.onPause();
                return zzdnjVar.zzi();
            }
        }, zzegxVar.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final ListenableFuture zza(final zzfbg zzfbgVar, final zzfau zzfauVar) {
        final zzdoi zzdoiVar = new zzdoi();
        ListenableFuture listenableFutureZzh = zzgbs.zzh(null);
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzegs
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzegx.zzc(this.zza, zzfauVar, zzfbgVar, zzdoiVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture listenableFutureZzn = zzgbs.zzn(listenableFutureZzh, zzgazVar, executor);
        Objects.requireNonNull(zzdoiVar);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegt
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
