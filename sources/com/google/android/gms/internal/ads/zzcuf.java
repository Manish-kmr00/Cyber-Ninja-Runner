package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcuf {
    private final zzfft zza;
    private final VersionInfoParcel zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhes zzg;
    private final String zzh;
    private final zzesy zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;
    private final zzfbp zzk;
    private final int zzl;
    private final zzdao zzm;

    zzcuf(zzfft zzfftVar, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzhes zzhesVar, com.google.android.gms.ads.internal.util.zzg zzgVar, String str2, zzesy zzesyVar, zzfbp zzfbpVar, zzdao zzdaoVar, int i) {
        this.zza = zzfftVar;
        this.zzb = versionInfoParcel;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhesVar;
        this.zzh = str2;
        this.zzi = zzesyVar;
        this.zzj = zzgVar;
        this.zzk = zzfbpVar;
        this.zzm = zzdaoVar;
        this.zzl = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ zzbuy zza(zzcuf zzcufVar, ListenableFuture listenableFuture, Bundle bundle) {
        zzcue zzcueVar = (zzcue) listenableFuture.get();
        Bundle bundle2 = zzcueVar.zza;
        String str = (String) ((ListenableFuture) zzcufVar.zzg.zzb()).get();
        boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgX)).booleanValue() && zzcufVar.zzj.zzN();
        String str2 = zzcufVar.zzh;
        PackageInfo packageInfo = zzcufVar.zzf;
        List list = zzcufVar.zze;
        return new zzbuy(bundle2, zzcufVar.zzb, zzcufVar.zzc, zzcufVar.zzd, list, packageInfo, str, str2, null, null, z, zzcufVar.zzk.zza(), bundle, zzcueVar.zzb, zzcufVar.zzl);
    }

    public final ListenableFuture zzb(Bundle bundle) {
        this.zzm.zza();
        return zzffd.zzc(this.zzi.zza(new zzcue(new Bundle(), new Bundle()), bundle, this.zzl == 2), zzffn.SIGNALS, this.zza).zza();
    }

    public final ListenableFuture zzc() {
        final Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue()) {
            Bundle bundle2 = this.zzk.zzs;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putBoolean("ls", false);
        }
        final ListenableFuture listenableFutureZzb = zzb(bundle);
        return this.zza.zza(zzffn.REQUEST_PARCEL, listenableFutureZzb, (ListenableFuture) this.zzg.zzb()).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcud
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzcuf.zza(this.zza, listenableFutureZzb, bundle);
            }
        }).zza();
    }
}
