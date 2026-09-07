package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzqv {
    private final zzcn[] zza;
    private final zzrn zzb;
    private final zzcq zzc;

    public zzqv(zzcn... zzcnVarArr) {
        zzrn zzrnVar = new zzrn();
        zzcq zzcqVar = new zzcq();
        zzcn[] zzcnVarArr2 = {zzrnVar, zzcqVar};
        this.zza = zzcnVarArr2;
        System.arraycopy(zzcnVarArr, 0, zzcnVarArr2, 0, 0);
        this.zzb = zzrnVar;
        this.zzc = zzcqVar;
    }

    public final long zza(long j) {
        zzcq zzcqVar = this.zzc;
        return zzcqVar.zzg() ? zzcqVar.zzi(j) : j;
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzbb zzc(zzbb zzbbVar) {
        zzcq zzcqVar = this.zzc;
        zzcqVar.zzk(zzbbVar.zzb);
        zzcqVar.zzj(zzbbVar.zzc);
        return zzbbVar;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzcn[] zze() {
        return this.zza;
    }
}
