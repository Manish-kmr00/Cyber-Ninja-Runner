package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaly implements zzamg {
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

    public zzaly(String str, int i, String str2) {
        zzej zzejVar = new zzej(new byte[128], 128);
        this.zza = zzejVar;
        this.zzb = new zzek(zzejVar.zza);
        this.zzh = 0;
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
                while (zzekVar.zza() > 0) {
                    if (this.zzj) {
                        int iZzm = zzekVar.zzm();
                        if (iZzm == 119) {
                            this.zzj = false;
                            this.zzh = 1;
                            zzek zzekVar2 = this.zzb;
                            zzekVar2.zzN()[0] = Ascii.VT;
                            zzekVar2.zzN()[1] = 119;
                            this.zzi = 2;
                            break;
                        }
                        this.zzj = iZzm == 11;
                    } else {
                        this.zzj = zzekVar.zzm() == 11;
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
                int iMin2 = Math.min(zzekVar.zza(), 128 - this.zzi);
                zzekVar.zzH(bArrZzN, this.zzi, iMin2);
                int i3 = this.zzi + iMin2;
                this.zzi = i3;
                if (i3 == 128) {
                    zzej zzejVar = this.zza;
                    zzejVar.zzl(0);
                    zzabz zzabzVarZze = zzacb.zze(zzejVar);
                    zzz zzzVar = this.zzl;
                    if (zzzVar == null || zzabzVarZze.zzc != zzzVar.zzE || zzabzVarZze.zzb != zzzVar.zzF || !Objects.equals(zzabzVarZze.zza, zzzVar.zzo)) {
                        zzx zzxVar = new zzx();
                        zzxVar.zzO(this.zzf);
                        zzxVar.zzE(this.zze);
                        String str = zzabzVarZze.zza;
                        zzxVar.zzad(str);
                        zzxVar.zzB(zzabzVarZze.zzc);
                        zzxVar.zzae(zzabzVarZze.zzb);
                        zzxVar.zzS(this.zzc);
                        zzxVar.zzab(this.zzd);
                        int i4 = zzabzVarZze.zzf;
                        zzxVar.zzY(i4);
                        if ("audio/ac3".equals(str)) {
                            zzxVar.zzA(i4);
                        }
                        zzz zzzVarZzaj = zzxVar.zzaj();
                        this.zzl = zzzVarZzaj;
                        this.zzg.zzm(zzzVarZzaj);
                    }
                    this.zzm = zzabzVarZze.zzd;
                    this.zzk = (((long) zzabzVarZze.zze) * 1000000) / ((long) this.zzl.zzF);
                    zzekVar3.zzL(0);
                    this.zzg.zzr(zzekVar3, 128);
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
