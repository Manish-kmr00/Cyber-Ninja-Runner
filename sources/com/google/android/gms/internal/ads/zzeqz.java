package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeqz implements zzesv {
    private final zzgcd zza;
    private final zzfbp zzb;
    private final PackageInfo zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;

    public zzeqz(zzgcd zzgcdVar, zzfbp zzfbpVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgcdVar;
        this.zzb = zzfbpVar;
        this.zzc = packageInfo;
        this.zzd = zzgVar;
    }

    public static /* synthetic */ zzera zzc(zzeqz zzeqzVar) {
        return new zzera(zzeqzVar.zzb, zzeqzVar.zzc, zzeqzVar.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 26;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeqz.zzc(this.zza);
            }
        });
    }
}
