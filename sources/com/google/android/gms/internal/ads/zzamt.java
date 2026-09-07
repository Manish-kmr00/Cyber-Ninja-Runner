package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamt implements zzamg {
    private String zzf;
    private zzaei zzg;
    private boolean zzj;
    private int zzl;
    private int zzm;
    private int zzo;
    private int zzp;
    private int zzt;
    private boolean zzv;
    private final String zza = "video/mp2t";
    private int zze = 0;
    private final zzek zzb = new zzek(new byte[15], 2);
    private final zzej zzc = new zzej();
    private final zzek zzd = new zzek();
    private final zzamu zzq = new zzamu();
    private int zzr = -2147483647;
    private int zzs = -1;
    private long zzu = -1;
    private boolean zzk = true;
    private boolean zzn = true;
    private double zzh = -9.223372036854776E18d;
    private double zzi = -9.223372036854776E18d;

    public zzamt(String str) {
    }

    private static final void zzf(zzek zzekVar, zzek zzekVar2, boolean z) {
        int iZzc = zzekVar.zzc();
        int iMin = Math.min(zzekVar.zza(), zzekVar2.zza());
        zzekVar.zzH(zzekVar2.zzN(), zzekVar2.zzc(), iMin);
        zzekVar2.zzM(iMin);
        if (z) {
            zzekVar.zzL(iZzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) throws zzaz {
        int i;
        zzdc.zzb(this.zzg);
        while (zzekVar.zza() > 0) {
            int i2 = this.zze;
            int iZzd = 0;
            if (i2 == 0) {
                int i3 = this.zzl;
                if ((i3 & 2) != 0) {
                    if ((i3 & 4) == 0) {
                        while (zzekVar.zza() > 0) {
                            int i4 = this.zzm << 8;
                            this.zzm = i4;
                            int iZzm = i4 | zzekVar.zzm();
                            this.zzm = iZzm;
                            if ((iZzm & ViewCompat.MEASURED_SIZE_MASK) == 12583333) {
                                zzekVar.zzL(zzekVar.zzc() - 3);
                                this.zzm = 0;
                            }
                        }
                    }
                    this.zze = 1;
                    break;
                }
                zzekVar.zzL(zzekVar.zzd());
            } else if (i2 != 1) {
                zzamu zzamuVar = this.zzq;
                int i5 = zzamuVar.zza;
                if (i5 == 1 || i5 == 17) {
                    zzf(zzekVar, this.zzd, true);
                }
                int iMin = Math.min(zzekVar.zza(), zzamuVar.zzc - this.zzo);
                this.zzg.zzr(zzekVar, iMin);
                int i6 = this.zzo + iMin;
                this.zzo = i6;
                if (i6 == zzamuVar.zzc) {
                    int i7 = zzamuVar.zza;
                    if (i7 == 1) {
                        byte[] bArrZzN = this.zzd.zzN();
                        zzamv zzamvVarZza = zzamx.zza(new zzej(bArrZzN, bArrZzN.length));
                        this.zzr = zzamvVarZza.zzb;
                        this.zzs = zzamvVarZza.zzc;
                        long j = this.zzu;
                        long j2 = zzamuVar.zzb;
                        if (j != j2) {
                            this.zzu = j2;
                            int i8 = zzamvVarZza.zza;
                            String strConcat = i8 != -1 ? "mhm1".concat(String.valueOf(String.format(".%02X", Integer.valueOf(i8)))) : "mhm1";
                            byte[] bArr = zzamvVarZza.zzd;
                            zzfww zzfwwVarZzp = null;
                            if (bArr != null && bArr.length > 0) {
                                zzfwwVarZzp = zzfww.zzp(zzeu.zzc, bArr);
                            }
                            zzx zzxVar = new zzx();
                            zzxVar.zzO(this.zzf);
                            zzxVar.zzE(this.zza);
                            zzxVar.zzad("audio/mhm1");
                            zzxVar.zzae(this.zzr);
                            zzxVar.zzC(strConcat);
                            zzxVar.zzP(zzfwwVarZzp);
                            this.zzg.zzm(zzxVar.zzaj());
                        }
                        this.zzv = true;
                    } else if (i7 == 17) {
                        byte[] bArrZzN2 = this.zzd.zzN();
                        zzej zzejVar = new zzej(bArrZzN2, bArrZzN2.length);
                        if (zzejVar.zzp()) {
                            zzejVar.zzn(2);
                            iZzd = zzejVar.zzd(13);
                        }
                        this.zzt = iZzd;
                    } else if (i7 == 2) {
                        if (this.zzv) {
                            this.zzk = false;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        int i9 = this.zzs - this.zzt;
                        double d = this.zzr;
                        long jRound = Math.round(this.zzh);
                        if (this.zzj) {
                            this.zzj = false;
                            this.zzh = this.zzi;
                        } else {
                            this.zzh += (((double) i9) * 1000000.0d) / d;
                        }
                        this.zzg.zzt(jRound, i, this.zzp, 0, null);
                        this.zzv = false;
                        this.zzt = 0;
                        this.zzp = 0;
                    }
                    this.zze = 1;
                }
            } else {
                zzek zzekVar2 = this.zzb;
                zzf(zzekVar, zzekVar2, false);
                if (zzekVar2.zza() == 0) {
                    zzej zzejVar2 = this.zzc;
                    int iZzd2 = zzekVar2.zzd();
                    zzejVar2.zzk(zzekVar2.zzN(), iZzd2);
                    zzamu zzamuVar2 = this.zzq;
                    if (zzamx.zzb(zzejVar2, zzamuVar2)) {
                        this.zzo = 0;
                        this.zzp += zzamuVar2.zzc + iZzd2;
                        zzekVar2.zzL(0);
                        this.zzg.zzr(zzekVar2, zzekVar2.zzd());
                        zzekVar2.zzI(2);
                        this.zzd.zzI(zzamuVar2.zzc);
                        this.zzn = true;
                        this.zze = 2;
                    } else if (zzekVar2.zzd() < 15) {
                        zzekVar2.zzK(zzekVar2.zzd() + 1);
                    }
                }
                this.zzn = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        this.zzf = zzanuVar.zzb();
        this.zzg = zzadfVar.zzw(zzanuVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        this.zzl = i;
        if (!this.zzk && (this.zzp != 0 || !this.zzn)) {
            this.zzj = true;
        }
        if (j != -9223372036854775807L) {
            double d = j;
            if (this.zzj) {
                this.zzi = d;
            } else {
                this.zzh = d;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zze = 0;
        this.zzm = 0;
        this.zzb.zzI(2);
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = -2147483647;
        this.zzs = -1;
        this.zzt = 0;
        this.zzu = -1L;
        this.zzv = false;
        this.zzj = false;
        this.zzn = true;
        this.zzk = true;
        this.zzh = -9.223372036854776E18d;
        this.zzi = -9.223372036854776E18d;
    }
}
