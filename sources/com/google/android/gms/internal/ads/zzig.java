package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzig implements zzkv {
    private final zzmd zza;
    private final zzif zzb;
    private zzlu zzc;
    private zzkv zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzig(zzif zzifVar, zzdg zzdgVar) {
        this.zzb = zzifVar;
        this.zza = new zzmd(zzdgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final long zza() {
        if (this.zze) {
            return this.zza.zza();
        }
        zzkv zzkvVar = this.zzd;
        zzkvVar.getClass();
        return zzkvVar.zza();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0063  */
    public final long zzb(boolean z) {
        zzmd zzmdVar;
        zzbb zzbbVarZzc;
        zzlu zzluVar = this.zzc;
        if (zzluVar == null || zzluVar.zzW() || ((z && this.zzc.zzcT() != 2) || (!this.zzc.zzX() && (z || this.zzc.zzQ())))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzkv zzkvVar = this.zzd;
            zzkvVar.getClass();
            long jZza = zzkvVar.zza();
            if (this.zze) {
                zzmd zzmdVar2 = this.zza;
                if (jZza < zzmdVar2.zza()) {
                    zzmdVar2.zze();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        zzmdVar2.zzd();
                    }
                    zzmdVar = this.zza;
                    zzmdVar.zzb(jZza);
                    zzbbVarZzc = zzkvVar.zzc();
                    if (!zzbbVarZzc.equals(zzmdVar.zzc())) {
                        zzmdVar.zzg(zzbbVarZzc);
                        this.zzb.zzc(zzbbVarZzc);
                    }
                }
            } else {
                zzmdVar = this.zza;
                zzmdVar.zzb(jZza);
                zzbbVarZzc = zzkvVar.zzc();
                if (!zzbbVarZzc.equals(zzmdVar.zzc())) {
                    zzmdVar.zzg(zzbbVarZzc);
                    this.zzb.zzc(zzbbVarZzc);
                }
            }
        }
        return zza();
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final zzbb zzc() {
        zzkv zzkvVar = this.zzd;
        return zzkvVar != null ? zzkvVar.zzc() : this.zza.zzc();
    }

    public final void zzd(zzlu zzluVar) {
        if (zzluVar == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzlu zzluVar) throws zzii {
        zzkv zzkvVar;
        zzkv zzkvVarZzl = zzluVar.zzl();
        if (zzkvVarZzl == null || zzkvVarZzl == (zzkvVar = this.zzd)) {
            return;
        }
        if (zzkvVar != null) {
            throw zzii.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.zzd = zzkvVarZzl;
        this.zzc = zzluVar;
        zzkvVarZzl.zzg(this.zza.zzc());
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zzg(zzbb zzbbVar) {
        zzkv zzkvVar = this.zzd;
        if (zzkvVar != null) {
            zzkvVar.zzg(zzbbVar);
            zzbbVar = this.zzd.zzc();
        }
        this.zza.zzg(zzbbVar);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final boolean zzj() {
        if (this.zze) {
            return false;
        }
        zzkv zzkvVar = this.zzd;
        zzkvVar.getClass();
        return zzkvVar.zzj();
    }
}
