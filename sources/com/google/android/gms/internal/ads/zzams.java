package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzams implements zzamg {
    private final zzek zza;
    private final zzadu zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private zzaei zzf;
    private String zzg;
    private int zzh = 0;
    private int zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzams(String str, int i, String str2) {
        zzek zzekVar = new zzek(4);
        this.zza = zzekVar;
        zzekVar.zzN()[0] = -1;
        this.zzb = new zzadu();
        this.zzn = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) {
        zzdc.zzb(this.zzf);
        while (zzekVar.zza() > 0) {
            int i = this.zzh;
            if (i == 0) {
                byte[] bArrZzN = zzekVar.zzN();
                int iZzc = zzekVar.zzc();
                int iZzd = zzekVar.zzd();
                while (true) {
                    if (iZzc >= iZzd) {
                        zzekVar.zzL(iZzd);
                        break;
                    }
                    int i2 = iZzc + 1;
                    byte b = bArrZzN[iZzc];
                    boolean z = (b & 255) == 255;
                    boolean z2 = this.zzk && (b & 224) == 224;
                    this.zzk = z;
                    if (z2) {
                        zzekVar.zzL(i2);
                        this.zzk = false;
                        this.zza.zzN()[1] = bArrZzN[iZzc];
                        this.zzi = 2;
                        this.zzh = 1;
                        break;
                    }
                    iZzc = i2;
                }
            } else if (i != 1) {
                int iMin = Math.min(zzekVar.zza(), this.zzm - this.zzi);
                this.zzf.zzr(zzekVar, iMin);
                int i3 = this.zzi + iMin;
                this.zzi = i3;
                if (i3 >= this.zzm) {
                    zzdc.zzf(this.zzn != -9223372036854775807L);
                    this.zzf.zzt(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzl;
                    this.zzi = 0;
                    this.zzh = 0;
                }
            } else {
                int iMin2 = Math.min(zzekVar.zza(), 4 - this.zzi);
                zzek zzekVar2 = this.zza;
                zzekVar.zzH(zzekVar2.zzN(), this.zzi, iMin2);
                int i4 = this.zzi + iMin2;
                this.zzi = i4;
                if (i4 >= 4) {
                    zzekVar2.zzL(0);
                    zzadu zzaduVar = this.zzb;
                    if (zzaduVar.zza(zzekVar2.zzg())) {
                        this.zzm = zzaduVar.zzc;
                        if (!this.zzj) {
                            this.zzl = (((long) zzaduVar.zzg) * 1000000) / ((long) zzaduVar.zzd);
                            zzx zzxVar = new zzx();
                            zzxVar.zzO(this.zzg);
                            zzxVar.zzE(this.zze);
                            zzxVar.zzad(zzaduVar.zzb);
                            zzxVar.zzT(4096);
                            zzxVar.zzB(zzaduVar.zze);
                            zzxVar.zzae(zzaduVar.zzd);
                            zzxVar.zzS(this.zzc);
                            zzxVar.zzab(this.zzd);
                            this.zzf.zzm(zzxVar.zzaj());
                            this.zzj = true;
                        }
                        zzekVar2.zzL(0);
                        this.zzf.zzr(zzekVar2, 4);
                        this.zzh = 2;
                    } else {
                        this.zzi = 0;
                        this.zzh = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        this.zzg = zzanuVar.zzb();
        this.zzf = zzadfVar.zzw(zzanuVar.zza(), 1);
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
        this.zzk = false;
        this.zzn = -9223372036854775807L;
    }
}
