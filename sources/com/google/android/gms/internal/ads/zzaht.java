package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaht {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzek zzf;
    private final zzek zzg;
    private int zzh;
    private int zzi;

    public zzaht(zzek zzekVar, zzek zzekVar2, boolean z) throws zzaz {
        this.zzg = zzekVar;
        this.zzf = zzekVar2;
        this.zze = z;
        zzekVar2.zzL(12);
        this.zza = zzekVar2.zzp();
        zzekVar.zzL(12);
        this.zzi = zzekVar.zzp();
        zzadg.zzb(zzekVar.zzg() == 1, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        this.zzd = this.zze ? this.zzf.zzw() : this.zzf.zzu();
        if (this.zzb == this.zzh) {
            zzek zzekVar = this.zzg;
            this.zzc = zzekVar.zzp();
            zzekVar.zzM(4);
            int i2 = this.zzi - 1;
            this.zzi = i2;
            this.zzh = i2 > 0 ? (-1) + zzekVar.zzp() : -1;
        }
        return true;
    }
}
