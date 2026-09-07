package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafj implements zzadc {
    private zzadf zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzafi zzo;
    private zzafn zzp;
    private final zzek zza = new zzek(4);
    private final zzek zzb = new zzek(9);
    private final zzek zzc = new zzek(11);
    private final zzek zzd = new zzek();
    private final zzafk zze = new zzafk();
    private int zzg = 1;

    private final zzek zza(zzadd zzaddVar) throws IOException {
        zzek zzekVar = this.zzd;
        if (this.zzl > zzekVar.zzb()) {
            int iZzb = zzekVar.zzb();
            zzekVar.zzJ(new byte[Math.max(iZzb + iZzb, this.zzl)], 0);
        } else {
            zzekVar.zzL(0);
        }
        zzekVar.zzK(this.zzl);
        zzaddVar.zzi(zzekVar.zzN(), 0, this.zzl);
        return zzekVar;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzg() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzP(new zzaea(-9223372036854775807L, 0L));
        this.zzn = true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:40:0x00af  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0009 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        long j;
        boolean zZzf;
        boolean z;
        long j2;
        zzdc.zzb(this.zzf);
        while (true) {
            int i = this.zzg;
            int i2 = 8;
            if (i == 1) {
                zzek zzekVar = this.zzb;
                if (!zzaddVar.zzn(zzekVar.zzN(), 0, 9, true)) {
                    return -1;
                }
                zzekVar.zzL(0);
                zzekVar.zzM(4);
                int iZzm = zzekVar.zzm();
                int i3 = iZzm & 4;
                int i4 = iZzm & 1;
                if (i3 != 0 && this.zzo == null) {
                    this.zzo = new zzafi(this.zzf.zzw(8, 1));
                }
                if (i4 != 0 && this.zzp == null) {
                    this.zzp = new zzafn(this.zzf.zzw(9, 2));
                }
                this.zzf.zzG();
                this.zzj = zzekVar.zzg() - 5;
                this.zzg = 2;
            } else if (i == 2) {
                zzaddVar.zzk(this.zzj);
                this.zzj = 0;
                this.zzg = 3;
            } else if (i == 3) {
                zzek zzekVar2 = this.zzc;
                if (!zzaddVar.zzn(zzekVar2.zzN(), 0, 11, true)) {
                    return -1;
                }
                zzekVar2.zzL(0);
                this.zzk = zzekVar2.zzm();
                this.zzl = zzekVar2.zzo();
                this.zzm = zzekVar2.zzo();
                this.zzm = (((long) (zzekVar2.zzm() << 24)) | this.zzm) * 1000;
                zzekVar2.zzM(3);
                this.zzg = 4;
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                if (this.zzh) {
                    j = this.zzi + this.zzm;
                } else {
                    j = this.zze.zzc() == -9223372036854775807L ? 0L : this.zzm;
                }
                int i5 = this.zzk;
                if (i5 == 8) {
                    if (this.zzo != null) {
                        zzg();
                        zZzf = this.zzo.zzf(zza(zzaddVar), j);
                    }
                    z = true;
                    if (!this.zzh && zZzf) {
                        this.zzh = true;
                        if (this.zze.zzc() == -9223372036854775807L) {
                            j2 = -this.zzm;
                        } else {
                            j2 = 0;
                        }
                        this.zzi = j2;
                    }
                    this.zzj = 4;
                    this.zzg = 2;
                    if (z) {
                        return 0;
                    }
                } else {
                    i2 = i5;
                }
                if (i2 == 9) {
                    if (this.zzp != null) {
                        zzg();
                        zZzf = this.zzp.zzf(zza(zzaddVar), j);
                        z = true;
                    } else {
                        zzaddVar.zzk(this.zzl);
                        zZzf = false;
                        z = false;
                    }
                } else if (i2 != 18 || this.zzn) {
                    zzaddVar.zzk(this.zzl);
                    zZzf = false;
                    z = false;
                } else {
                    zzafk zzafkVar = this.zze;
                    zZzf = zzafkVar.zzf(zza(zzaddVar), j);
                    long jZzc = zzafkVar.zzc();
                    if (jZzc != -9223372036854775807L) {
                        this.zzf.zzP(new zzadt(zzafkVar.zzd(), zzafkVar.zze(), jZzc));
                        this.zzn = true;
                    }
                    z = true;
                }
                if (!this.zzh) {
                    this.zzh = true;
                    if (this.zze.zzc() == -9223372036854775807L) {
                        j2 = -this.zzm;
                    } else {
                        j2 = 0;
                    }
                    this.zzi = j2;
                }
                this.zzj = 4;
                this.zzg = 2;
                if (z) {
                    return 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return zzfww.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        this.zzf = zzadfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        zzek zzekVar = this.zza;
        zzacr zzacrVar = (zzacr) zzaddVar;
        zzacrVar.zzm(zzekVar.zzN(), 0, 3, false);
        zzekVar.zzL(0);
        if (zzekVar.zzo() != 4607062) {
            return false;
        }
        zzacrVar.zzm(zzekVar.zzN(), 0, 2, false);
        zzekVar.zzL(0);
        if ((zzekVar.zzq() & 250) != 0) {
            return false;
        }
        zzacrVar.zzm(zzekVar.zzN(), 0, 4, false);
        zzekVar.zzL(0);
        int iZzg = zzekVar.zzg();
        zzaddVar.zzj();
        zzacrVar.zzl(iZzg, false);
        zzacrVar.zzm(zzekVar.zzN(), 0, 4, false);
        zzekVar.zzL(0);
        return zzekVar.zzg() == 0;
    }
}
