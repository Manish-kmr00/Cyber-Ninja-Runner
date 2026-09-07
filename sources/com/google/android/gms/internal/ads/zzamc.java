package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzamc implements zzamg {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzaei zzi;
    private zzaei zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzaei zzw;
    private long zzx;
    private final zzej zzc = new zzej(new byte[7], 7);
    private final zzek zzd = new zzek(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = -9223372036854775807L;
    private long zzv = -9223372036854775807L;

    public zzamc(boolean z, String str, int i, String str2) {
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
        this.zzg = str2;
        zzh();
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzh();
    }

    private final void zzh() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 256;
    }

    private final void zzi() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private final void zzj(zzaei zzaeiVar, long j, int i, int i2) {
        this.zzk = 4;
        this.zzl = i;
        this.zzw = zzaeiVar;
        this.zzx = j;
        this.zzu = i2;
    }

    private final boolean zzk(zzek zzekVar, byte[] bArr, int i) {
        int iMin = Math.min(zzekVar.zza(), i - this.zzl);
        zzekVar.zzH(bArr, this.zzl, iMin);
        int i2 = this.zzl + iMin;
        this.zzl = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzek zzekVar, byte[] bArr, int i) {
        if (zzekVar.zza() < i) {
            return false;
        }
        zzekVar.zzH(bArr, 0, i);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:144:0x023f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x023f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x023f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:74:0x0205  */
    /* JADX WARN: Code duplicated, block: B:76:0x0210  */
    /* JADX WARN: Code duplicated, block: B:78:0x0214  */
    /* JADX WARN: Code duplicated, block: B:80:0x0218  */
    /* JADX WARN: Code duplicated, block: B:85:0x0227  */
    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) throws zzaz {
        int i;
        char c;
        boolean z;
        int i2;
        int iZzd;
        byte[] bArrZzN;
        int iZzd2;
        int i3;
        byte b;
        int i4;
        int i5;
        int i6;
        byte b2;
        this.zzi.getClass();
        int i7 = zzeu.zza;
        while (zzekVar.zza() > 0) {
            int i8 = this.zzk;
            char c2 = 7;
            int i9 = 2;
            if (i8 == 0) {
                byte[] bArrZzN2 = zzekVar.zzN();
                int iZzc = zzekVar.zzc();
                int iZzd3 = zzekVar.zzd();
                while (true) {
                    if (iZzc < iZzd3) {
                        int i10 = iZzc + 1;
                        byte b3 = bArrZzN2[iZzc];
                        int i11 = b3 & 255;
                        if (this.zzm == 512 && zzl((byte) -1, (byte) i11)) {
                            if (!this.zzo) {
                                int i12 = iZzc - 1;
                                zzekVar.zzL(iZzc);
                                zzej zzejVar = this.zzc;
                                if (zzm(zzekVar, zzejVar.zza, 1)) {
                                    zzejVar.zzl(4);
                                    int iZzd4 = zzejVar.zzd(1);
                                    int i13 = this.zzp;
                                    if (i13 != -1 && iZzd4 != i13) {
                                        c2 = 7;
                                    } else if (this.zzq == -1) {
                                        if (zzm(zzekVar, zzejVar.zza, 4)) {
                                            zzejVar.zzl(14);
                                            iZzd = zzejVar.zzd(13);
                                            c2 = 7;
                                            if (iZzd >= 7) {
                                                bArrZzN = zzekVar.zzN();
                                                iZzd2 = zzekVar.zzd();
                                                i3 = i12 + iZzd;
                                                if (i3 >= iZzd2) {
                                                    b = bArrZzN[i3];
                                                    if (b == -1) {
                                                        i6 = i3 + 1;
                                                        if (i6 != iZzd2) {
                                                            b2 = bArrZzN[i6];
                                                            if (zzl((byte) -1, b2) || ((b2 & 8) >> 3) != iZzd4) {
                                                            }
                                                        }
                                                    } else if (b == 73 || ((i4 = i3 + 1) != iZzd2 && (bArrZzN[i4] != 68 || ((i5 = i3 + 2) != iZzd2 && bArrZzN[i5] != 51)))) {
                                                    }
                                                }
                                            }
                                        }
                                    } else if (zzm(zzekVar, zzejVar.zza, 1)) {
                                        zzejVar.zzl(i9);
                                        if (zzejVar.zzd(4) == this.zzq) {
                                            zzekVar.zzL(iZzc + 1);
                                            if (zzm(zzekVar, zzejVar.zza, 4)) {
                                                zzejVar.zzl(14);
                                                iZzd = zzejVar.zzd(13);
                                                c2 = 7;
                                                if (iZzd >= 7) {
                                                    bArrZzN = zzekVar.zzN();
                                                    iZzd2 = zzekVar.zzd();
                                                    i3 = i12 + iZzd;
                                                    if (i3 >= iZzd2) {
                                                        b = bArrZzN[i3];
                                                        if (b == -1) {
                                                            i6 = i3 + 1;
                                                            if (i6 != iZzd2) {
                                                                b2 = bArrZzN[i6];
                                                                if (zzl((byte) -1, b2)) {
                                                                }
                                                            }
                                                        } else if (b == 73) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            c2 = 7;
                                        }
                                    }
                                } else {
                                    c2 = 7;
                                }
                            }
                            this.zzr = (b3 & 8) >> 3;
                            this.zzn = 1 == ((b3 & 1) ^ 1);
                            if (this.zzo) {
                                zzi();
                            } else {
                                this.zzk = 1;
                                this.zzl = 0;
                            }
                            zzekVar.zzL(i10);
                        } else {
                            c2 = c2;
                        }
                        int i14 = this.zzm;
                        int i15 = i14 | i11;
                        if (i15 == 329) {
                            i = 2;
                            c = 3;
                            z = false;
                            i2 = 768;
                        } else if (i15 == 511) {
                            i = 2;
                            c = 3;
                            z = false;
                            i2 = 512;
                        } else if (i15 == 836) {
                            i = 2;
                            c = 3;
                            z = false;
                            i2 = 1024;
                        } else if (i15 == 1075) {
                            this.zzk = 2;
                            this.zzl = 3;
                            this.zzu = 0;
                            this.zzd.zzL(0);
                            zzekVar.zzL(i10);
                        } else if (i14 != 256) {
                            this.zzm = 256;
                            i9 = 2;
                        } else {
                            i = 2;
                            c = 3;
                            z = false;
                            iZzc = i10;
                            i9 = i;
                        }
                        this.zzm = i2;
                        iZzc = i10;
                        i9 = i;
                    } else {
                        zzekVar.zzL(iZzc);
                    }
                }
            } else if (i8 != 1) {
                if (i8 == 2) {
                    zzek zzekVar2 = this.zzd;
                    if (zzk(zzekVar, zzekVar2.zzN(), 10)) {
                        this.zzj.zzr(zzekVar2, 10);
                        zzekVar2.zzL(6);
                        zzj(this.zzj, 0L, 10, zzekVar2.zzl() + 10);
                    }
                } else if (i8 != 3) {
                    int iMin = Math.min(zzekVar.zza(), this.zzu - this.zzl);
                    this.zzw.zzr(zzekVar, iMin);
                    int i16 = this.zzl + iMin;
                    this.zzl = i16;
                    if (i16 == this.zzu) {
                        zzdc.zzf(this.zzv != -9223372036854775807L);
                        this.zzw.zzt(this.zzv, 1, this.zzu, 0, null);
                        this.zzv += this.zzx;
                        zzh();
                    }
                } else {
                    int i17 = true != this.zzn ? 5 : 7;
                    zzej zzejVar2 = this.zzc;
                    if (zzk(zzekVar, zzejVar2.zza, i17)) {
                        zzejVar2.zzl(0);
                        if (this.zzs) {
                            zzejVar2.zzn(10);
                        } else {
                            int iZzd5 = zzejVar2.zzd(2) + 1;
                            if (iZzd5 != 2) {
                                zzdx.zzf("AdtsReader", "Detected audio object type: " + iZzd5 + ", but assuming AAC LC.");
                            }
                            zzejVar2.zzn(5);
                            int iZzd6 = zzejVar2.zzd(3);
                            int i18 = this.zzq;
                            int i19 = zzaby.zza;
                            byte[] bArr = {(byte) (((i18 >> 1) & 7) | 16), (byte) (((iZzd6 << 3) & 120) | ((i18 << 7) & 128))};
                            zzabw zzabwVarZza = zzaby.zza(bArr);
                            zzx zzxVar = new zzx();
                            zzxVar.zzO(this.zzh);
                            zzxVar.zzE(this.zzg);
                            zzxVar.zzad("audio/mp4a-latm");
                            zzxVar.zzC(zzabwVarZza.zzc);
                            zzxVar.zzB(zzabwVarZza.zzb);
                            zzxVar.zzae(zzabwVarZza.zza);
                            zzxVar.zzP(Collections.singletonList(bArr));
                            zzxVar.zzS(this.zze);
                            zzxVar.zzab(this.zzf);
                            zzz zzzVarZzaj = zzxVar.zzaj();
                            this.zzt = 1024000000 / ((long) zzzVarZzaj.zzF);
                            this.zzi.zzm(zzzVarZzaj);
                            this.zzs = true;
                        }
                        zzejVar2.zzn(4);
                        int iZzd7 = zzejVar2.zzd(13);
                        zzj(this.zzi, this.zzt, 0, this.zzn ? iZzd7 - 9 : iZzd7 - 7);
                    }
                }
            } else if (zzekVar.zza() != 0) {
                zzej zzejVar3 = this.zzc;
                zzejVar3.zza[0] = zzekVar.zzN()[zzekVar.zzc()];
                zzejVar3.zzl(2);
                int iZzd8 = zzejVar3.zzd(4);
                int i20 = this.zzq;
                if (i20 == -1 || iZzd8 == i20) {
                    if (!this.zzo) {
                        this.zzo = true;
                        this.zzp = this.zzr;
                        this.zzq = iZzd8;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        this.zzh = zzanuVar.zzb();
        zzaei zzaeiVarZzw = zzadfVar.zzw(zzanuVar.zza(), 1);
        this.zzi = zzaeiVarZzw;
        this.zzw = zzaeiVarZzw;
        if (!this.zzb) {
            this.zzj = new zzacx();
            return;
        }
        zzanuVar.zzc();
        zzaei zzaeiVarZzw2 = zzadfVar.zzw(zzanuVar.zza(), 5);
        this.zzj = zzaeiVarZzw2;
        zzx zzxVar = new zzx();
        zzxVar.zzO(zzanuVar.zzb());
        zzxVar.zzE(this.zzg);
        zzxVar.zzad("application/id3");
        zzaeiVarZzw2.zzm(zzxVar.zzaj());
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        this.zzv = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zzv = -9223372036854775807L;
        zzg();
    }
}
