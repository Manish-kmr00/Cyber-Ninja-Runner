package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzajd implements zzajj {
    private final zzaji zza;
    private final long zzb;
    private final long zzc;
    private final zzajo zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajd(zzajo zzajoVar, long j, long j2, long j3, long j4, boolean z) {
        zzdc.zzd(j >= 0 && j2 > j);
        this.zzd = zzajoVar;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzaji();
    }

    @Override // com.google.android.gms.internal.ads.zzajj
    public final /* bridge */ /* synthetic */ zzaeb zze() {
        zzajc zzajcVar = null;
        if (this.zzf != 0) {
            return new zzajb(this, zzajcVar);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzajj
    public final void zzg(long j) {
        long j2 = this.zzf - 1;
        int i = zzeu.zza;
        this.zzh = Math.max(0L, Math.min(j, j2));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    @Override // com.google.android.gms.internal.ads.zzajj
    public final long zzd(zzadd zzaddVar) throws IOException {
        long jMax;
        int i = this.zze;
        if (i == 0) {
            long jZzf = zzaddVar.zzf();
            this.zzg = jZzf;
            this.zze = 1;
            long j = this.zzc - 65307;
            if (j > jZzf) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long j2 = this.zzi;
                long j3 = this.zzj;
                if (j2 == j3) {
                    jMax = -1;
                } else {
                    long jZzf2 = zzaddVar.zzf();
                    zzaji zzajiVar = this.zza;
                    if (zzajiVar.zzc(zzaddVar, j3)) {
                        zzajiVar.zzb(zzaddVar, false);
                        zzaddVar.zzj();
                        long j4 = this.zzh;
                        long j5 = zzajiVar.zzb;
                        long j6 = j4 - j5;
                        int i2 = zzajiVar.zzd + zzajiVar.zze;
                        if (j6 < 0 || j6 >= 72000) {
                            if (j6 < 0) {
                                this.zzj = jZzf2;
                                this.zzl = j5;
                            } else {
                                this.zzi = ((long) i2) + zzaddVar.zzf();
                                this.zzk = j5;
                            }
                            long j7 = this.zzj;
                            long j8 = this.zzi;
                            long j9 = j7 - j8;
                            if (j9 < 100000) {
                                this.zzj = j8;
                                jMax = j8;
                            } else {
                                long j10 = i2;
                                long j11 = j6 <= 0 ? 2L : 1L;
                                int i3 = zzeu.zza;
                                jMax = Math.max(j8, Math.min((zzaddVar.zzf() - (j10 * j11)) + ((j6 * j9) / (this.zzl - this.zzk)), j7 - 1));
                            }
                        } else {
                            jMax = -1;
                        }
                    } else {
                        jMax = this.zzi;
                        if (jMax == jZzf2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                if (jMax != -1) {
                    return jMax;
                }
                this.zze = 3;
            } else if (i != 3) {
                return -1L;
            }
            while (true) {
                zzaji zzajiVar2 = this.zza;
                zzajiVar2.zzc(zzaddVar, -1L);
                zzajiVar2.zzb(zzaddVar, false);
                if (zzajiVar2.zzb > this.zzh) {
                    zzaddVar.zzj();
                    this.zze = 4;
                    return -(this.zzk + 2);
                }
                zzaddVar.zzk(zzajiVar2.zzd + zzajiVar2.zze);
                this.zzi = zzaddVar.zzf();
                this.zzk = zzajiVar2.zzb;
            }
        }
        zzaji zzajiVar3 = this.zza;
        zzajiVar3.zza();
        if (!zzajiVar3.zzc(zzaddVar, -1L)) {
            throw new EOFException();
        }
        zzajiVar3.zzb(zzaddVar, false);
        zzaddVar.zzk(zzajiVar3.zzd + zzajiVar3.zze);
        long j12 = zzajiVar3.zzb;
        while ((zzajiVar3.zza & 4) != 4 && zzajiVar3.zzc(zzaddVar, -1L) && zzaddVar.zzf() < this.zzc && zzajiVar3.zzb(zzaddVar, true) && zzadg.zze(zzaddVar, zzajiVar3.zzd + zzajiVar3.zze)) {
            j12 = zzajiVar3.zzb;
        }
        this.zzf = j12;
        this.zze = 4;
        return this.zzg;
    }
}
