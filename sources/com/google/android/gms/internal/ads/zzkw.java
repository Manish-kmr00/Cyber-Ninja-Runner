package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzkw {
    public final zzuw zza;
    public final Object zzb;
    public boolean zzd;
    public boolean zze;
    public boolean zzf;
    public zzkx zzg;
    public boolean zzh;
    private final zzlx[] zzj;
    private final zzyv zzk;
    private final zzll zzl;
    private zzkw zzm;
    private zzyw zzo;
    private long zzp;
    private zzxd zzn = zzxd.zza;
    public final zzws[] zzc = new zzws[2];
    private final boolean[] zzi = new boolean[2];

    public zzkw(zzlx[] zzlxVarArr, long j, zzyv zzyvVar, zzze zzzeVar, zzll zzllVar, zzkx zzkxVar, zzyw zzywVar, long j2) {
        this.zzj = zzlxVarArr;
        this.zzp = j;
        this.zzk = zzyvVar;
        this.zzl = zzllVar;
        this.zzb = zzkxVar.zza.zza;
        this.zzg = zzkxVar;
        this.zzo = zzywVar;
        zzuy zzuyVar = zzkxVar.zza;
        long j3 = zzkxVar.zzb;
        long j4 = zzkxVar.zzd;
        zzuw zzuwVarZzp = zzllVar.zzp(zzuyVar, zzzeVar, j3);
        this.zza = j4 != -9223372036854775807L ? new zzuc(zzuwVarZzp, true, 0L, j4) : zzuwVarZzp;
    }

    private final void zzu() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzyw zzywVar = this.zzo;
            if (i >= zzywVar.zza) {
                return;
            }
            zzywVar.zzb(i);
            zzyp zzypVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final void zzv() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzyw zzywVar = this.zzo;
            if (i >= zzywVar.zza) {
                return;
            }
            zzywVar.zzb(i);
            zzyp zzypVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final boolean zzw() {
        return this.zzm == null;
    }

    public final long zza(zzyw zzywVar, long j, boolean z) {
        return zzb(zzywVar, j, false, new boolean[2]);
    }

    public final long zzb(zzyw zzywVar, long j, boolean z, boolean[] zArr) {
        zzlx[] zzlxVarArr;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzywVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzi;
            if (z || !zzywVar.zza(this.zzo, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzlxVarArr = this.zzj;
            if (i2 >= 2) {
                break;
            }
            zzlxVarArr[i2].zzb();
            i2++;
        }
        zzu();
        this.zzo = zzywVar;
        zzv();
        zzuw zzuwVar = this.zza;
        zzyp[] zzypVarArr = zzywVar.zzc;
        boolean[] zArr3 = this.zzi;
        zzws[] zzwsVarArr = this.zzc;
        long jZzf = zzuwVar.zzf(zzypVarArr, zArr3, zzwsVarArr, zArr, j);
        for (int i3 = 0; i3 < 2; i3++) {
            zzlxVarArr[i3].zzb();
        }
        this.zzf = false;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzwsVarArr[i4] != null) {
                zzdc.zzf(zzywVar.zzb(i4));
                zzlxVarArr[i4].zzb();
                this.zzf = true;
            } else {
                zzdc.zzf(zzypVarArr[i4] == null);
            }
        }
        return jZzf;
    }

    public final long zzc() {
        if (!this.zze) {
            return this.zzg.zzb;
        }
        long jZzb = this.zzf ? this.zza.zzb() : Long.MIN_VALUE;
        return jZzb == Long.MIN_VALUE ? this.zzg.zze : jZzb;
    }

    public final long zzd() {
        if (this.zze) {
            return this.zza.zzc();
        }
        return 0L;
    }

    public final long zze() {
        return this.zzp;
    }

    public final long zzf() {
        return this.zzg.zzb + this.zzp;
    }

    public final zzkw zzg() {
        return this.zzm;
    }

    public final zzxd zzh() {
        return this.zzn;
    }

    public final zzyw zzi() {
        return this.zzo;
    }

    public final zzyw zzj(float f, zzbl zzblVar, boolean z) throws zzii {
        zzxd zzxdVar = this.zzn;
        zzuy zzuyVar = this.zzg.zza;
        zzyv zzyvVar = this.zzk;
        zzlx[] zzlxVarArr = this.zzj;
        zzyw zzywVarZzo = zzyvVar.zzo(zzlxVarArr, zzxdVar, zzuyVar, zzblVar);
        for (int i = 0; i < zzywVarZzo.zza; i++) {
            boolean z2 = true;
            if (zzywVarZzo.zzb(i)) {
                if (zzywVarZzo.zzc[i] == null) {
                    zzlxVarArr[i].zzb();
                    z2 = false;
                }
                zzdc.zzf(z2);
            } else {
                zzdc.zzf(zzywVarZzo.zzc[i] == null);
            }
        }
        for (zzyp zzypVar : zzywVarZzo.zzc) {
        }
        return zzywVarZzo;
    }

    public final void zzk(zzku zzkuVar) {
        zzdc.zzf(zzw());
        this.zza.zzo(zzkuVar);
    }

    public final void zzl(float f, zzbl zzblVar, boolean z) throws zzii {
        this.zze = true;
        this.zzn = this.zza.zzg();
        zzyw zzywVarZzj = zzj(f, zzblVar, z);
        zzkx zzkxVar = this.zzg;
        long jMax = zzkxVar.zzb;
        long j = zzkxVar.zze;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jZza = zza(zzywVarZzj, jMax, false);
        long j2 = this.zzp;
        zzkx zzkxVar2 = this.zzg;
        this.zzp = j2 + (zzkxVar2.zzb - jZza);
        this.zzg = zzkxVar2.zzb(jZza);
    }

    public final void zzm(zzuv zzuvVar, long j) {
        this.zzd = true;
        this.zza.zzk(zzuvVar, j);
    }

    public final void zzn(long j) {
        zzdc.zzf(zzw());
        if (this.zze) {
            this.zza.zzm(j - this.zzp);
        }
    }

    public final void zzo() {
        zzu();
        zzuw zzuwVar = this.zza;
        try {
            boolean z = zzuwVar instanceof zzuc;
            zzll zzllVar = this.zzl;
            if (z) {
                zzllVar.zzi(((zzuc) zzuwVar).zza);
            } else {
                zzllVar.zzi(zzuwVar);
            }
        } catch (RuntimeException e) {
            zzdx.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzp(zzkw zzkwVar) {
        if (zzkwVar == this.zzm) {
            return;
        }
        zzu();
        this.zzm = zzkwVar;
        zzv();
    }

    public final void zzq(long j) {
        this.zzp = j;
    }

    public final void zzr() {
        zzuw zzuwVar = this.zza;
        if (zzuwVar instanceof zzuc) {
            long j = this.zzg.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zzuc) zzuwVar).zzn(0L, j);
        }
    }

    public final boolean zzs() {
        if (this.zze) {
            return !this.zzf || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean zzt() {
        if (this.zze) {
            return zzs() || zzc() - this.zzg.zzb >= -9223372036854775807L;
        }
        return false;
    }
}
