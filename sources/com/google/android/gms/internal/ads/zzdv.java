package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzdv {
    public final Object zza;
    private zzt zzb = new zzt();
    private boolean zzc;
    private boolean zzd;

    public zzdv(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzdv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i, zzdt zzdtVar) {
        if (this.zzd) {
            return;
        }
        if (i != -1) {
            this.zzb.zza(i);
        }
        this.zzc = true;
        zzdtVar.zza(this.zza);
    }

    public final void zzb(zzdu zzduVar) {
        if (this.zzd || !this.zzc) {
            return;
        }
        zzv zzvVarZzb = this.zzb.zzb();
        this.zzb = new zzt();
        this.zzc = false;
        zzduVar.zza(this.zza, zzvVarZzb);
    }

    public final void zzc(zzdu zzduVar) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzduVar.zza(this.zza, this.zzb.zzb());
        }
    }
}
