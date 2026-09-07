package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcpv implements zzcwq, zzayh {
    private final zzfau zza;
    private final zzcvu zzb;
    private final zzcwz zzc;
    private final AtomicBoolean zzd = new AtomicBoolean();
    private final AtomicBoolean zze = new AtomicBoolean();

    public zzcpv(zzfau zzfauVar, zzcvu zzcvuVar, zzcwz zzcwzVar) {
        this.zza = zzfauVar;
        this.zzb = zzcvuVar;
        this.zzc = zzcwzVar;
    }

    private final void zza() {
        if (this.zzd.compareAndSet(false, true)) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    public final void zzdn(zzayg zzaygVar) {
        if (this.zza.zze == 1 && zzaygVar.zzj) {
            zza();
        }
        if (zzaygVar.zzj && this.zze.compareAndSet(false, true)) {
            this.zzc.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final synchronized void zzt() {
        if (this.zza.zze != 1) {
            zza();
        }
    }
}
