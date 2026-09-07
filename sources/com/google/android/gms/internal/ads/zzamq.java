package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamq implements zzamg {
    private zzaei zzc;
    private boolean zzd;
    private int zzf;
    private int zzg;
    private final String zza = "video/mp2t";
    private final zzek zzb = new zzek(10);
    private long zze = -9223372036854775807L;

    public zzamq(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zza(zzek zzekVar) {
        zzdc.zzb(this.zzc);
        if (this.zzd) {
            int iZza = zzekVar.zza();
            int i = this.zzg;
            if (i < 10) {
                int iMin = Math.min(iZza, 10 - i);
                byte[] bArrZzN = zzekVar.zzN();
                int iZzc = zzekVar.zzc();
                zzek zzekVar2 = this.zzb;
                System.arraycopy(bArrZzN, iZzc, zzekVar2.zzN(), this.zzg, iMin);
                if (this.zzg + iMin == 10) {
                    zzekVar2.zzL(0);
                    if (zzekVar2.zzm() != 73 || zzekVar2.zzm() != 68 || zzekVar2.zzm() != 51) {
                        zzdx.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzd = false;
                        return;
                    } else {
                        zzekVar2.zzM(3);
                        this.zzf = zzekVar2.zzl() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iZza, this.zzf - this.zzg);
            this.zzc.zzr(zzekVar, iMin2);
            this.zzg += iMin2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzb(zzadf zzadfVar, zzanu zzanuVar) {
        zzanuVar.zzc();
        zzaei zzaeiVarZzw = zzadfVar.zzw(zzanuVar.zza(), 5);
        this.zzc = zzaeiVarZzw;
        zzx zzxVar = new zzx();
        zzxVar.zzO(zzanuVar.zzb());
        zzxVar.zzE(this.zza);
        zzxVar.zzad("application/id3");
        zzaeiVarZzw.zzm(zzxVar.zzaj());
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzc(boolean z) {
        int i;
        zzdc.zzb(this.zzc);
        if (this.zzd && (i = this.zzf) != 0 && this.zzg == i) {
            zzdc.zzf(this.zze != -9223372036854775807L);
            this.zzc.zzt(this.zze, 1, this.zzf, 0, null);
            this.zzd = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zzd(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.zzd = true;
        this.zze = j;
        this.zzf = 0;
        this.zzg = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzamg
    public final void zze() {
        this.zzd = false;
        this.zze = -9223372036854775807L;
    }
}
