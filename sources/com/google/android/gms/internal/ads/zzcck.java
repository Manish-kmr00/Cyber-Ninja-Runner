package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcck extends com.google.android.gms.ads.internal.util.zzb {
    final zzcbg zza;
    final zzccs zzb;
    private final String zzc;
    private final String[] zzd;

    zzcck(zzcbg zzcbgVar, zzccs zzccsVar, String str, String[] strArr) {
        this.zza = zzcbgVar;
        this.zzb = zzccsVar;
        this.zzc = str;
        this.zzd = strArr;
        com.google.android.gms.ads.internal.zzv.zzz().zzb(this);
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new zzccj(this));
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final ListenableFuture zzb() {
        return (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzci)).booleanValue() && (this.zzb instanceof zzcdb)) ? zzbzk.zzf.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcci
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcck zzcckVar = this.zza;
                return Boolean.valueOf(zzcckVar.zzb.zzw(zzcckVar.zzc, zzcckVar.zzd, zzcckVar));
            }
        }) : super.zzb();
    }

    public final String zze() {
        return this.zzc;
    }
}
