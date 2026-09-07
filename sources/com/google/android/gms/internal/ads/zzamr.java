package com.google.android.gms.internal.ads;

import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamr implements zzamg {
    private final String zza;
    private final int zzb;
    private final String zzc = "video/mp2t";
    private final zzek zzd;
    private final zzej zze;
    private zzaei zzf;
    private String zzg;
    private zzz zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private long zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private String zzw;

    public zzamr(String str, int i, String str2) {
        this.zza = str;
        this.zzb = i;
        zzek zzekVar = new zzek(1024);
        this.zzd = zzekVar;
        byte[] bArrZzN = zzekVar.zzN();
        this.zze = new zzej(bArrZzN, bArrZzN.length);
        this.zzm = -9223372036854775807L;
    }

    private final int zzf(zzej zzejVar) throws zzaz {
        int iZza = zzejVar.zza();
        zzabw zzabwVarZzb = zzaby.zzb(zzejVar, true);
        this.zzw = zzabwVarZzb.zzc;
        this.zzt = zzabwVarZzb.zza;
        this.zzv = zzabwVarZzb.zzb;
        return iZza - zzejVar.zza();
    }

    private static long zzg(zzej zzejVar) {
        return zzejVar.zzd((zzejVar.zzd(2) + 1) * 8);
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) throws zzaz {
        int i;
        int i2;
        int iZzd;
        boolean zZzp;
        zzdc.zzb(this.zzf);
        while (zzekVar.zza() > 0) {
            int i3 = this.zzi;
            if (i3 != 0) {
                if (i3 == 1) {
                    int iZzm = zzekVar.zzm();
                    if ((iZzm & 224) == 224) {
                        this.zzl = iZzm;
                        this.zzi = 2;
                    } else if (iZzm != 86) {
                        this.zzi = 0;
                    }
                } else if (i3 != 2) {
                    int iMin = Math.min(zzekVar.zza(), this.zzk - this.zzj);
                    zzej zzejVar = this.zze;
                    zzekVar.zzH(zzejVar.zza, this.zzj, iMin);
                    int i4 = this.zzj + iMin;
                    this.zzj = i4;
                    if (i4 == this.zzk) {
                        zzejVar.zzl(0);
                        if (zzejVar.zzp()) {
                            if (this.zzn) {
                            }
                            this.zzi = 0;
                        } else {
                            this.zzn = true;
                            int iZzd2 = zzejVar.zzd(1);
                            if (iZzd2 == 1) {
                                iZzd = zzejVar.zzd(1);
                                i2 = 1;
                            } else {
                                i2 = iZzd2;
                                iZzd = 0;
                            }
                            this.zzo = iZzd;
                            if (iZzd != 0) {
                                throw zzaz.zza(null, null);
                            }
                            if (i2 == 1) {
                                zzg(zzejVar);
                                i2 = 1;
                            }
                            if (!zzejVar.zzp()) {
                                throw zzaz.zza(null, null);
                            }
                            this.zzp = zzejVar.zzd(6);
                            int iZzd3 = zzejVar.zzd(4);
                            int iZzd4 = zzejVar.zzd(3);
                            if (iZzd3 != 0 || iZzd4 != 0) {
                                throw zzaz.zza(null, null);
                            }
                            if (i2 == 0) {
                                int iZzc = zzejVar.zzc();
                                int iZzf = zzf(zzejVar);
                                zzejVar.zzl(iZzc);
                                byte[] bArr = new byte[(iZzf + 7) / 8];
                                zzejVar.zzh(bArr, 0, iZzf);
                                zzx zzxVar = new zzx();
                                zzxVar.zzO(this.zzg);
                                zzxVar.zzE(this.zzc);
                                zzxVar.zzad("audio/mp4a-latm");
                                zzxVar.zzC(this.zzw);
                                zzxVar.zzB(this.zzv);
                                zzxVar.zzae(this.zzt);
                                zzxVar.zzP(Collections.singletonList(bArr));
                                zzxVar.zzS(this.zza);
                                zzxVar.zzab(this.zzb);
                                zzz zzzVarZzaj = zzxVar.zzaj();
                                if (!zzzVarZzaj.equals(this.zzh)) {
                                    this.zzh = zzzVarZzaj;
                                    this.zzu = 1024000000 / ((long) zzzVarZzaj.zzF);
                                    this.zzf.zzm(zzzVarZzaj);
                                }
                            } else {
                                zzejVar.zzn(((int) zzg(zzejVar)) - zzf(zzejVar));
                            }
                            int iZzd5 = zzejVar.zzd(3);
                            this.zzq = iZzd5;
                            if (iZzd5 == 0) {
                                zzejVar.zzn(8);
                            } else if (iZzd5 == 1) {
                                zzejVar.zzn(9);
                            } else if (iZzd5 == 3 || iZzd5 == 4 || iZzd5 == 5) {
                                zzejVar.zzn(6);
                            } else {
                                if (iZzd5 != 6 && iZzd5 != 7) {
                                    throw new IllegalStateException();
                                }
                                zzejVar.zzn(1);
                            }
                            boolean zZzp2 = zzejVar.zzp();
                            this.zzr = zZzp2;
                            this.zzs = 0L;
                            if (zZzp2) {
                                if (i2 != 1) {
                                    do {
                                        zZzp = zzejVar.zzp();
                                        this.zzs = (this.zzs << 8) + ((long) zzejVar.zzd(8));
                                    } while (zZzp);
                                } else {
                                    this.zzs = zzg(zzejVar);
                                }
                            }
                            if (zzejVar.zzp()) {
                                zzejVar.zzn(8);
                            }
                        }
                        if (this.zzo != 0) {
                            throw zzaz.zza(null, null);
                        }
                        if (this.zzp != 0) {
                            throw zzaz.zza(null, null);
                        }
                        if (this.zzq != 0) {
                            throw zzaz.zza(null, null);
                        }
                        int i5 = 0;
                        while (true) {
                            int iZzd6 = zzejVar.zzd(8);
                            i = i5 + iZzd6;
                            if (iZzd6 != 255) {
                                break;
                            } else {
                                i5 = i;
                            }
                        }
                        int iZzc2 = zzejVar.zzc();
                        if ((iZzc2 & 7) == 0) {
                            this.zzd.zzL(iZzc2 >> 3);
                        } else {
                            zzek zzekVar2 = this.zzd;
                            zzejVar.zzh(zzekVar2.zzN(), 0, i * 8);
                            zzekVar2.zzL(0);
                        }
                        this.zzf.zzr(this.zzd, i);
                        zzdc.zzf(this.zzm != -9223372036854775807L);
                        this.zzf.zzt(this.zzm, 1, i, 0, null);
                        this.zzm += this.zzu;
                        if (this.zzr) {
                            zzejVar.zzn((int) this.zzs);
                        }
                        this.zzi = 0;
                    } else {
                        continue;
                    }
                } else {
                    int iZzm2 = ((this.zzl & (-225)) << 8) | zzekVar.zzm();
                    this.zzk = iZzm2;
                    zzek zzekVar3 = this.zzd;
                    if (iZzm2 > zzekVar3.zzN().length) {
                        zzekVar3.zzI(iZzm2);
                        zzej zzejVar2 = this.zze;
                        byte[] bArrZzN = zzekVar3.zzN();
                        zzejVar2.zzk(bArrZzN, bArrZzN.length);
                    }
                    this.zzj = 0;
                    this.zzi = 3;
                }
            } else if (zzekVar.zzm() == 86) {
                this.zzi = 1;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        this.zzf = zzadfVar.zzw(zzanuVar.zza(), 1);
        this.zzg = zzanuVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zzi = 0;
        this.zzm = -9223372036854775807L;
        this.zzn = false;
    }
}
