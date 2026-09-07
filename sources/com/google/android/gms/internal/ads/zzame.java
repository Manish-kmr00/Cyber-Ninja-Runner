package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzame implements zzamg {
    private final zzek zza;
    private final String zzc;
    private final int zzd;
    private String zzf;
    private zzaei zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzz zzl;
    private int zzm;
    private int zzn;
    private int zzh = 0;
    private long zzq = -9223372036854775807L;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzo = -1;
    private int zzp = -1;
    private final String zze = "video/mp2t";

    public zzame(String str, int i, int i2, String str2) {
        this.zza = new zzek(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    @RequiresNonNull({"output"})
    private final void zzf(zzacz zzaczVar) {
        int i;
        int i2 = zzaczVar.zzb;
        if (i2 == -2147483647 || (i = zzaczVar.zzc) == -1) {
            return;
        }
        zzz zzzVar = this.zzl;
        if (zzzVar != null && i == zzzVar.zzE && i2 == zzzVar.zzF && Objects.equals(zzaczVar.zza, zzzVar.zzo)) {
            return;
        }
        zzz zzzVar2 = this.zzl;
        zzx zzxVar = zzzVar2 == null ? new zzx() : zzzVar2.zzb();
        zzxVar.zzO(this.zzf);
        zzxVar.zzE(this.zze);
        zzxVar.zzad(zzaczVar.zza);
        zzxVar.zzB(i);
        zzxVar.zzae(i2);
        zzxVar.zzS(this.zzc);
        zzxVar.zzab(this.zzd);
        zzz zzzVarZzaj = zzxVar.zzaj();
        this.zzl = zzzVarZzaj;
        this.zzg.zzm(zzzVarZzaj);
    }

    private final boolean zzg(zzek zzekVar, byte[] bArr, int i) {
        int iMin = Math.min(zzekVar.zza(), i - this.zzi);
        zzekVar.zzH(bArr, this.zzi, iMin);
        int i2 = this.zzi + iMin;
        this.zzi = i2;
        return i2 == i;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x01be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x01c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:76:0x01de  */
    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) throws zzaz {
        int i;
        int i2;
        byte b;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        byte b2;
        int i7;
        int i8;
        zzdc.zzb(this.zzg);
        while (zzekVar.zza() > 0) {
            int i9 = this.zzh;
            if (i9 == 0) {
                while (zzekVar.zza() > 0) {
                    int i10 = this.zzj << 8;
                    this.zzj = i10;
                    int iZzm = i10 | zzekVar.zzm();
                    this.zzj = iZzm;
                    int i11 = zzadb.zza;
                    if (iZzm == 2147385345 || iZzm == -25230976 || iZzm == 536864768 || iZzm == -14745368) {
                        i8 = 1;
                    } else if (iZzm == 1683496997 || iZzm == 622876772) {
                        i8 = 2;
                    } else if (iZzm == 1078008818 || iZzm == -233094848) {
                        i8 = 3;
                    } else {
                        i8 = (iZzm == 1908687592 || iZzm == -398277519) ? 4 : 0;
                    }
                    this.zzn = i8;
                    if (i8 != 0) {
                        byte[] bArrZzN = this.zza.zzN();
                        int i12 = this.zzj;
                        bArrZzN[0] = (byte) ((i12 >> 24) & 255);
                        bArrZzN[1] = (byte) ((i12 >> 16) & 255);
                        bArrZzN[2] = (byte) ((i12 >> 8) & 255);
                        bArrZzN[3] = (byte) (i12 & 255);
                        this.zzi = 4;
                        this.zzj = 0;
                        if (i8 != 3 && i8 != 4) {
                            if (i8 != 1) {
                                this.zzh = 2;
                                break;
                            } else {
                                this.zzh = 1;
                                break;
                            }
                        }
                        this.zzh = 4;
                        break;
                    }
                }
            } else if (i9 == 1) {
                zzek zzekVar2 = this.zza;
                if (zzg(zzekVar, zzekVar2.zzN(), 18)) {
                    byte[] bArrZzN2 = zzekVar2.zzN();
                    if (this.zzl == null) {
                        zzz zzzVarZzc = zzadb.zzc(bArrZzN2, this.zzf, this.zzc, this.zzd, this.zze, null);
                        this.zzl = zzzVarZzc;
                        this.zzg.zzm(zzzVarZzc);
                    }
                    int i13 = zzadb.zza;
                    byte b3 = bArrZzN2[0];
                    if (b3 != -2) {
                        if (b3 == -1) {
                            i7 = ((bArrZzN2[7] & 3) << 12) | ((bArrZzN2[6] & 255) << 4) | ((bArrZzN2[9] & 60) >> 2);
                        } else if (b3 != 31) {
                            i = (bArrZzN2[5] & 3) << 12;
                            i2 = (bArrZzN2[6] & 255) << 4;
                            b = bArrZzN2[7];
                        } else {
                            i7 = ((bArrZzN2[8] & 60) >> 2) | ((3 & bArrZzN2[6]) << 12) | ((bArrZzN2[7] & 255) << 4);
                        }
                        i3 = i7 + 1;
                        z = true;
                        if (z) {
                            i3 = (i3 * 16) / 14;
                        }
                        this.zzm = i3;
                        if (b3 != -2) {
                            if (b3 != -1) {
                                i4 = 2;
                                i5 = (bArrZzN2[4] & 7) << 4;
                                b2 = bArrZzN2[7];
                            } else if (b3 != 31) {
                                i5 = (bArrZzN2[4] & 1) << 6;
                                i6 = bArrZzN2[5] & 252;
                                i4 = 2;
                            } else {
                                i4 = 2;
                                i5 = (bArrZzN2[5] & 7) << 4;
                                b2 = bArrZzN2[6];
                            }
                            i6 = b2 & 60;
                        } else {
                            i4 = 2;
                            i5 = (bArrZzN2[5] & 1) << 6;
                            i6 = bArrZzN2[4] & 252;
                        }
                        this.zzk = zzfzz.zzb(zzeu.zzt(((i5 | (i6 >> i4)) + 1) * 32, this.zzl.zzF));
                        zzekVar2.zzL(0);
                        this.zzg.zzr(zzekVar2, 18);
                        this.zzh = 6;
                    } else {
                        i = (bArrZzN2[4] & 3) << 12;
                        i2 = (bArrZzN2[7] & 255) << 4;
                        b = bArrZzN2[6];
                    }
                    i3 = (i | i2 | ((b & 240) >> 4)) + 1;
                    z = false;
                    if (z) {
                        i3 = (i3 * 16) / 14;
                    }
                    this.zzm = i3;
                    if (b3 != -2) {
                        if (b3 != -1) {
                            i4 = 2;
                            i5 = (bArrZzN2[4] & 7) << 4;
                            b2 = bArrZzN2[7];
                        } else if (b3 != 31) {
                            i5 = (bArrZzN2[4] & 1) << 6;
                            i6 = bArrZzN2[5] & 252;
                            i4 = 2;
                        } else {
                            i4 = 2;
                            i5 = (bArrZzN2[5] & 7) << 4;
                            b2 = bArrZzN2[6];
                        }
                        i6 = b2 & 60;
                    } else {
                        i4 = 2;
                        i5 = (bArrZzN2[5] & 1) << 6;
                        i6 = bArrZzN2[4] & 252;
                    }
                    this.zzk = zzfzz.zzb(zzeu.zzt(((i5 | (i6 >> i4)) + 1) * 32, this.zzl.zzF));
                    zzekVar2.zzL(0);
                    this.zzg.zzr(zzekVar2, 18);
                    this.zzh = 6;
                }
            } else if (i9 != 2) {
                if (i9 == 3) {
                    zzek zzekVar3 = this.zza;
                    if (zzg(zzekVar, zzekVar3.zzN(), this.zzo)) {
                        zzacz zzaczVarZzd = zzadb.zzd(zzekVar3.zzN());
                        zzf(zzaczVarZzd);
                        this.zzm = zzaczVarZzd.zzd;
                        long j = zzaczVarZzd.zze;
                        this.zzk = j != -9223372036854775807L ? j : 0L;
                        zzekVar3.zzL(0);
                        this.zzg.zzr(zzekVar3, this.zzo);
                        this.zzh = 6;
                    }
                } else if (i9 == 4) {
                    zzek zzekVar4 = this.zza;
                    if (zzg(zzekVar, zzekVar4.zzN(), 6)) {
                        int iZzb = zzadb.zzb(zzekVar4.zzN());
                        this.zzp = iZzb;
                        int i14 = this.zzi;
                        if (i14 > iZzb) {
                            int i15 = i14 - iZzb;
                            this.zzi = i14 - i15;
                            zzekVar.zzL(zzekVar.zzc() - i15);
                        }
                        this.zzh = 5;
                    }
                } else if (i9 != 5) {
                    int iMin = Math.min(zzekVar.zza(), this.zzm - this.zzi);
                    this.zzg.zzr(zzekVar, iMin);
                    int i16 = this.zzi + iMin;
                    this.zzi = i16;
                    if (i16 == this.zzm) {
                        zzdc.zzf(this.zzq != -9223372036854775807L);
                        this.zzg.zzt(this.zzq, this.zzn == 4 ? 0 : 1, this.zzm, 0, null);
                        this.zzq += this.zzk;
                        this.zzh = 0;
                    }
                } else {
                    zzek zzekVar5 = this.zza;
                    if (zzg(zzekVar, zzekVar5.zzN(), this.zzp)) {
                        zzacz zzaczVarZze = zzadb.zze(zzekVar5.zzN(), this.zzb);
                        if (this.zzn == 3) {
                            zzf(zzaczVarZze);
                        }
                        this.zzm = zzaczVarZze.zzd;
                        long j2 = zzaczVarZze.zze;
                        this.zzk = j2 != -9223372036854775807L ? j2 : 0L;
                        zzekVar5.zzL(0);
                        this.zzg.zzr(zzekVar5, this.zzp);
                        this.zzh = 6;
                    }
                }
            } else {
                zzek zzekVar6 = this.zza;
                if (zzg(zzekVar, zzekVar6.zzN(), 7)) {
                    this.zzo = zzadb.zza(zzekVar6.zzN());
                    this.zzh = 3;
                }
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
        this.zzq = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzq = -9223372036854775807L;
        this.zzb.set(0);
    }
}
