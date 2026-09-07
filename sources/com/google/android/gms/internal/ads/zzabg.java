package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzabg {
    private final zzabb zza;
    private final zzaaz zzb = new zzaaz();
    private final zzeq zzc = new zzeq(10);
    private final zzeq zzd = new zzeq(10);
    private final zzdz zze = new zzdz(16);
    private long zzf = -9223372036854775807L;
    private zzcd zzg = zzcd.zza;
    private long zzh;
    private final zzaac zzi;

    public zzabg(zzaac zzaacVar, zzabb zzabbVar) {
        this.zzi = zzaacVar;
        this.zza = zzabbVar;
    }

    private static Object zze(zzeq zzeqVar) {
        zzdc.zzd(zzeqVar.zza() > 0);
        while (zzeqVar.zza() > 1) {
            zzeqVar.zzb();
        }
        Object objZzb = zzeqVar.zzb();
        objZzb.getClass();
        return objZzb;
    }

    public final void zza() {
        this.zze.zzc();
        this.zzf = -9223372036854775807L;
        zzeq zzeqVar = this.zzd;
        if (zzeqVar.zza() > 0) {
            this.zzh = ((Long) zze(zzeqVar)).longValue();
        }
        zzeq zzeqVar2 = this.zzc;
        if (zzeqVar2.zza() > 0) {
            zzeqVar2.zzd(0L, (zzcd) zze(zzeqVar2));
        }
    }

    public final void zzb(int i, long j) {
        if (this.zze.zzd()) {
            this.zza.zzf(i);
            this.zzh = j;
        } else {
            zzeq zzeqVar = this.zzd;
            long j2 = this.zzf;
            zzeqVar.zzd(j2 == -9223372036854775807L ? 0L : j2 + 1, Long.valueOf(j));
        }
    }

    public final void zzc(int i, int i2) {
        long j = this.zzf;
        this.zzc.zzd(j == -9223372036854775807L ? 0L : j + 1, new zzcd(i, i2, 1.0f));
    }

    public final void zzd(long j, long j2) throws zzii {
        while (true) {
            zzdz zzdzVar = this.zze;
            if (zzdzVar.zzd()) {
                return;
            }
            zzeq zzeqVar = this.zzd;
            long jZza = zzdzVar.zza();
            Long l = (Long) zzeqVar.zzc(jZza);
            if (l != null && l.longValue() != this.zzh) {
                this.zzh = l.longValue();
                this.zza.zzf(2);
            }
            zzabb zzabbVar = this.zza;
            long j3 = this.zzh;
            zzaaz zzaazVar = this.zzb;
            int iZza = zzabbVar.zza(jZza, j, j2, j3, false, false, zzaazVar);
            if (iZza == 0 || iZza == 1) {
                long jZzb = zzdzVar.zzb();
                zzcd zzcdVar = (zzcd) this.zzc.zzc(jZzb);
                if (zzcdVar != null && !zzcdVar.equals(zzcd.zza) && !zzcdVar.equals(this.zzg)) {
                    this.zzg = zzcdVar;
                    this.zzi.zza(zzcdVar);
                }
                this.zzi.zzb(iZza == 0 ? System.nanoTime() : zzaazVar.zzd(), jZzb, zzabbVar.zzn());
            } else if (iZza == 2 || iZza == 3) {
                zzdzVar.zzb();
                ((zzabt) this.zzi.zza.zzc.remove()).zza();
            } else if (iZza != 4) {
                return;
            }
        }
    }
}
