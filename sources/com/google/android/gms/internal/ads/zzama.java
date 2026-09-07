package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzama implements zzamg {
    private final zzej zza;
    private final zzek zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private String zzf;
    private zzaei zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private long zzk;
    private zzz zzl;
    private int zzm;
    private long zzn;

    public zzama(String str, int i, String str2) {
        zzej zzejVar = new zzej(new byte[16], 16);
        this.zza = zzejVar;
        this.zzb = new zzek(zzejVar.zza);
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzn = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) {
        zzdc.zzb(this.zzg);
        while (zzekVar.zza() > 0) {
            int i = this.zzh;
            if (i == 0) {
                while (true) {
                    if (zzekVar.zza() > 0) {
                        if (this.zzj) {
                            int iZzm = zzekVar.zzm();
                            this.zzj = iZzm == 172;
                            byte b = SignedBytes.MAX_POWER_OF_TWO;
                            if (iZzm != 64) {
                                if (iZzm == 65) {
                                    iZzm = 65;
                                }
                            }
                            this.zzh = 1;
                            zzek zzekVar2 = this.zzb;
                            zzekVar2.zzN()[0] = -84;
                            if (iZzm == 65) {
                                b = 65;
                            }
                            zzekVar2.zzN()[1] = b;
                            this.zzi = 2;
                        } else {
                            this.zzj = zzekVar.zzm() == 172;
                        }
                    }
                }
            } else if (i != 1) {
                int iMin = Math.min(zzekVar.zza(), this.zzm - this.zzi);
                this.zzg.zzr(zzekVar, iMin);
                int i2 = this.zzi + iMin;
                this.zzi = i2;
                if (i2 == this.zzm) {
                    zzdc.zzf(this.zzn != -9223372036854775807L);
                    this.zzg.zzt(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzk;
                    this.zzh = 0;
                }
            } else {
                zzek zzekVar3 = this.zzb;
                byte[] bArrZzN = zzekVar3.zzN();
                int iMin2 = Math.min(zzekVar.zza(), 16 - this.zzi);
                zzekVar.zzH(bArrZzN, this.zzi, iMin2);
                int i3 = this.zzi + iMin2;
                this.zzi = i3;
                if (i3 == 16) {
                    zzej zzejVar = this.zza;
                    zzejVar.zzl(0);
                    zzacd zzacdVarZzb = zzacf.zzb(zzejVar);
                    zzz zzzVar = this.zzl;
                    if (zzzVar == null || zzzVar.zzE != 2 || zzacdVarZzb.zza != zzzVar.zzF || !"audio/ac4".equals(zzzVar.zzo)) {
                        zzx zzxVar = new zzx();
                        zzxVar.zzO(this.zzf);
                        zzxVar.zzE(this.zze);
                        zzxVar.zzad("audio/ac4");
                        zzxVar.zzB(2);
                        zzxVar.zzae(zzacdVarZzb.zza);
                        zzxVar.zzS(this.zzc);
                        zzxVar.zzab(this.zzd);
                        zzz zzzVarZzaj = zzxVar.zzaj();
                        this.zzl = zzzVarZzaj;
                        this.zzg.zzm(zzzVarZzaj);
                    }
                    this.zzm = zzacdVarZzb.zzb;
                    this.zzk = (((long) zzacdVarZzb.zzc) * 1000000) / ((long) this.zzl.zzF);
                    zzekVar3.zzL(0);
                    this.zzg.zzr(zzekVar3, 16);
                    this.zzh = 2;
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
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzn = -9223372036854775807L;
    }
}
