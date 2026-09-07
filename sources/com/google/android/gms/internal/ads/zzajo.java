package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzajo {
    private zzaei zzb;
    private zzadf zzc;
    private zzajj zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzajh zza = new zzajh();
    private zzajl zzj = new zzajl();

    protected abstract long zza(zzek zzekVar);

    protected void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzajl();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean zzc(zzek zzekVar, long j, zzajl zzajlVar) throws IOException;

    final int zze(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        zzdc.zzb(this.zzb);
        int i = zzeu.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (true) {
                zzajh zzajhVar = this.zza;
                if (!zzajhVar.zze(zzaddVar)) {
                    this.zzh = 3;
                    return -1;
                }
                long jZzf = zzaddVar.zzf();
                long j = this.zzf;
                this.zzk = jZzf - j;
                if (!zzc(zzajhVar.zza(), j, this.zzj)) {
                    zzz zzzVar = this.zzj.zza;
                    this.zzi = zzzVar.zzF;
                    if (!this.zzm) {
                        this.zzb.zzm(zzzVar);
                        this.zzm = true;
                    }
                    zzajj zzajjVar = this.zzj.zzb;
                    if (zzajjVar != null) {
                        this.zzd = zzajjVar;
                    } else if (zzaddVar.zzd() == -1) {
                        this.zzd = new zzajm(null);
                    } else {
                        zzaji zzajiVarZzb = zzajhVar.zzb();
                        this.zzd = new zzajd(this, this.zzf, zzaddVar.zzd(), zzajiVarZzb.zzd + zzajiVarZzb.zze, zzajiVarZzb.zzb, (zzajiVarZzb.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    zzajhVar.zzd();
                    break;
                }
                this.zzf = zzaddVar.zzf();
            }
        } else {
            if (i2 == 1) {
                zzaddVar.zzk((int) this.zzf);
                this.zzh = 2;
                return 0;
            }
            if (i2 != 2) {
                return -1;
            }
            long jZzd = this.zzd.zzd(zzaddVar);
            if (jZzd >= 0) {
                zzadyVar.zza = jZzd;
                return 1;
            }
            if (jZzd < -1) {
                zzi(-(jZzd + 2));
            }
            if (!this.zzl) {
                zzaeb zzaebVarZze = this.zzd.zze();
                zzdc.zzb(zzaebVarZze);
                this.zzc.zzP(zzaebVarZze);
                this.zzb.zzl(zzaebVarZze.zza());
                this.zzl = true;
            }
            if (this.zzk <= 0 && !this.zza.zze(zzaddVar)) {
                this.zzh = 3;
                return -1;
            }
            this.zzk = 0L;
            zzek zzekVarZza = this.zza.zza();
            long jZza = zza(zzekVarZza);
            if (jZza >= 0) {
                long j2 = this.zzg;
                if (j2 + jZza >= this.zze) {
                    long jZzf2 = zzf(j2);
                    this.zzb.zzr(zzekVarZza, zzekVarZza.zzd());
                    this.zzb.zzt(jZzf2, 1, zzekVarZza.zzd(), 0, null);
                    this.zze = -1L;
                }
            }
            this.zzg += jZza;
        }
        return 0;
    }

    protected final long zzf(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    protected final long zzg(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    final void zzh(zzadf zzadfVar, zzaei zzaeiVar) {
        this.zzc = zzadfVar;
        this.zzb = zzaeiVar;
        zzb(true);
    }

    protected void zzi(long j) {
        this.zzg = j;
    }

    final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzajj zzajjVar = this.zzd;
            int i = zzeu.zza;
            zzajjVar.zzg(this.zze);
            this.zzh = 2;
        }
    }
}
