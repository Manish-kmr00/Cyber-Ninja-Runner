package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzehs implements com.google.android.gms.ads.internal.zzg {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzcva zzb;
    private final zzcvu zzc;
    private final zzdde zzd;
    private final zzdcw zze;
    private final zzcmu zzf;

    zzehs(zzcva zzcvaVar, zzcvu zzcvuVar, zzdde zzddeVar, zzdcw zzdcwVar, zzcmu zzcmuVar) {
        this.zzb = zzcvaVar;
        this.zzc = zzcvuVar;
        this.zzd = zzddeVar;
        this.zze = zzdcwVar;
        this.zzf = zzcmuVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzs();
            this.zze.zza(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
