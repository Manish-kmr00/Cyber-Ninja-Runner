package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzafh implements zzadc {
    private final byte[] zza;
    private final zzek zzb;
    private final zzadi zzc;
    private zzadf zzd;
    private zzaei zze;
    private int zzf;
    private zzav zzg;
    private zzadn zzh;
    private int zzi;
    private int zzj;
    private zzafg zzk;
    private int zzl;
    private long zzm;

    public zzafh() {
        throw null;
    }

    public zzafh(int i) {
        this.zza = new byte[42];
        this.zzb = new zzek(new byte[32768], 0);
        this.zzc = new zzadi();
        this.zzf = 0;
    }

    private final long zza(zzek zzekVar, boolean z) {
        boolean zZzc;
        this.zzh.getClass();
        int iZzc = zzekVar.zzc();
        while (iZzc <= zzekVar.zzd() - 16) {
            zzekVar.zzL(iZzc);
            zzadn zzadnVar = this.zzh;
            int i = this.zzj;
            zzadi zzadiVar = this.zzc;
            if (zzadj.zzc(zzekVar, zzadnVar, i, zzadiVar)) {
                zzekVar.zzL(iZzc);
                return zzadiVar.zza;
            }
            iZzc++;
        }
        if (!z) {
            zzekVar.zzL(iZzc);
            return -1L;
        }
        while (iZzc <= zzekVar.zzd() - this.zzi) {
            zzekVar.zzL(iZzc);
            try {
                zZzc = zzadj.zzc(zzekVar, this.zzh, this.zzj, this.zzc);
            } catch (IndexOutOfBoundsException unused) {
                zZzc = false;
            }
            if (zzekVar.zzc() <= zzekVar.zzd() && zZzc) {
                zzekVar.zzL(iZzc);
                return this.zzc.zza;
            }
            iZzc++;
        }
        zzekVar.zzL(zzekVar.zzd());
        return -1L;
    }

    private final void zzg() {
        long j = this.zzm * 1000000;
        zzadn zzadnVar = this.zzh;
        int i = zzeu.zza;
        this.zze.zzt(j / ((long) zzadnVar.zze), 1, this.zzl, 0, null);
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
        this.zzd = zzadfVar;
        this.zze = zzadfVar.zzw(0, 1);
        zzadfVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        zzadk.zza(zzaddVar, false);
        zzek zzekVar = new zzek(4);
        ((zzacr) zzaddVar).zzm(zzekVar.zzN(), 0, 4, false);
        return zzekVar.zzu() == 1716281667;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzf = 0;
        } else {
            zzafg zzafgVar = this.zzk;
            if (zzafgVar != null) {
                zzafgVar.zzd(j2);
            }
        }
        this.zzm = j2 != 0 ? -1L : 0L;
        this.zzl = 0;
        this.zzb.zzI(0);
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        boolean zZzp;
        zzaeb zzaeaVar;
        boolean z;
        int i = this.zzf;
        if (i == 0) {
            zzaddVar.zzj();
            long jZze = zzaddVar.zze();
            zzav zzavVarZza = zzadk.zza(zzaddVar, true);
            zzaddVar.zzk((int) (zzaddVar.zze() - jZze));
            this.zzg = zzavVarZza;
            this.zzf = 1;
            return 0;
        }
        if (i == 1) {
            zzaddVar.zzh(this.zza, 0, 42);
            zzaddVar.zzj();
            this.zzf = 2;
            return 0;
        }
        if (i == 2) {
            zzek zzekVar = new zzek(4);
            zzaddVar.zzi(zzekVar.zzN(), 0, 4);
            if (zzekVar.zzu() != 1716281667) {
                throw zzaz.zza("Failed to read FLAC stream marker.", null);
            }
            this.zzf = 3;
            return 0;
        }
        if (i == 3) {
            zzadn zzadnVarZze = this.zzh;
            do {
                zzaddVar.zzj();
                zzej zzejVar = new zzej(new byte[4], 4);
                zzaddVar.zzh(zzejVar.zza, 0, 4);
                zZzp = zzejVar.zzp();
                int iZzd = zzejVar.zzd(7);
                int iZzd2 = zzejVar.zzd(24) + 4;
                if (iZzd == 0) {
                    byte[] bArr = new byte[38];
                    zzaddVar.zzi(bArr, 0, 38);
                    zzadnVarZze = new zzadn(bArr, 4);
                } else {
                    if (zzadnVarZze == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iZzd == 3) {
                        zzek zzekVar2 = new zzek(iZzd2);
                        zzaddVar.zzi(zzekVar2.zzN(), 0, iZzd2);
                        zzadnVarZze = zzadnVarZze.zzf(zzadk.zzb(zzekVar2));
                    } else if (iZzd == 4) {
                        zzek zzekVar3 = new zzek(iZzd2);
                        zzaddVar.zzi(zzekVar3.zzN(), 0, iZzd2);
                        zzekVar3.zzM(4);
                        zzadnVarZze = zzadnVarZze.zzg(Arrays.asList(zzaeo.zzc(zzekVar3, false, false).zza));
                    } else if (iZzd == 6) {
                        zzek zzekVar4 = new zzek(iZzd2);
                        zzaddVar.zzi(zzekVar4.zzN(), 0, iZzd2);
                        zzekVar4.zzM(4);
                        zzadnVarZze = zzadnVarZze.zze(zzfww.zzo(zzaga.zzb(zzekVar4)));
                    } else {
                        zzaddVar.zzk(iZzd2);
                    }
                }
                int i2 = zzeu.zza;
                this.zzh = zzadnVarZze;
            } while (!zZzp);
            zzadnVarZze.getClass();
            this.zzi = Math.max(zzadnVarZze.zzc, 6);
            zzz zzzVarZzc = this.zzh.zzc(this.zza, this.zzg);
            zzaei zzaeiVar = this.zze;
            zzx zzxVarZzb = zzzVarZzc.zzb();
            zzxVarZzb.zzE("audio/flac");
            zzaeiVar.zzm(zzxVarZzb.zzaj());
            this.zze.zzl(this.zzh.zza());
            this.zzf = 4;
            return 0;
        }
        if (i == 4) {
            zzaddVar.zzj();
            zzek zzekVar5 = new zzek(2);
            zzaddVar.zzh(zzekVar5.zzN(), 0, 2);
            int iZzq = zzekVar5.zzq();
            if ((iZzq >> 2) != 16382) {
                zzaddVar.zzj();
                throw zzaz.zza("First frame does not start with sync code.", null);
            }
            zzaddVar.zzj();
            this.zzj = iZzq;
            zzadf zzadfVar = this.zzd;
            int i3 = zzeu.zza;
            long jZzf = zzaddVar.zzf();
            long jZzd = zzaddVar.zzd();
            zzadn zzadnVar = this.zzh;
            zzadnVar.getClass();
            if (zzadnVar.zzk != null) {
                zzaeaVar = new zzadl(zzadnVar, jZzf);
            } else if (jZzd == -1 || zzadnVar.zzj <= 0) {
                zzaeaVar = new zzaea(zzadnVar.zza(), 0L);
            } else {
                zzafg zzafgVar = new zzafg(zzadnVar, this.zzj, jZzf, jZzd);
                this.zzk = zzafgVar;
                zzaeaVar = zzafgVar.zzb();
            }
            zzadfVar.zzP(zzaeaVar);
            this.zzf = 5;
            return 0;
        }
        this.zze.getClass();
        zzadn zzadnVar2 = this.zzh;
        zzadnVar2.getClass();
        zzafg zzafgVar2 = this.zzk;
        if (zzafgVar2 != null && zzafgVar2.zze()) {
            return zzafgVar2.zza(zzaddVar, zzadyVar);
        }
        if (this.zzm == -1) {
            this.zzm = zzadj.zzb(zzaddVar, zzadnVar2);
            return 0;
        }
        zzek zzekVar6 = this.zzb;
        int iZzd3 = zzekVar6.zzd();
        if (iZzd3 < 32768) {
            int iZza = zzaddVar.zza(zzekVar6.zzN(), iZzd3, 32768 - iZzd3);
            z = iZza == -1;
            if (!z) {
                zzekVar6.zzK(iZzd3 + iZza);
            } else if (zzekVar6.zza() == 0) {
                zzg();
                return -1;
            }
        } else {
            z = false;
        }
        int iZzc = zzekVar6.zzc();
        int i4 = this.zzl;
        int i5 = this.zzi;
        if (i4 < i5) {
            zzekVar6.zzM(Math.min(i5 - i4, zzekVar6.zza()));
        }
        long jZza = zza(zzekVar6, z);
        int iZzc2 = zzekVar6.zzc() - iZzc;
        zzekVar6.zzL(iZzc);
        this.zze.zzr(zzekVar6, iZzc2);
        this.zzl += iZzc2;
        if (jZza != -1) {
            zzg();
            this.zzl = 0;
            this.zzm = jZza;
        }
        int length = zzekVar6.zzN().length - zzekVar6.zzd();
        if (zzekVar6.zza() >= 16 || length >= 16) {
            return 0;
        }
        int iZza2 = zzekVar6.zza();
        System.arraycopy(zzekVar6.zzN(), zzekVar6.zzc(), zzekVar6.zzN(), 0, iZza2);
        zzekVar6.zzL(0);
        zzekVar6.zzK(iZza2);
        return 0;
    }
}
