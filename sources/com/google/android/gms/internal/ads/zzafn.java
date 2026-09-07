package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafn extends zzafm {
    private final zzek zzb;
    private final zzek zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzafn(zzaei zzaeiVar) {
        super(zzaeiVar);
        this.zzb = new zzek(zzfq.zza);
        this.zzc = new zzek(4);
    }

    @Override // com.google.android.gms.internal.ads.zzafm
    protected final boolean zza(zzek zzekVar) throws zzafl {
        int iZzm = zzekVar.zzm();
        int i = iZzm >> 4;
        int i2 = iZzm & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        throw new zzafl("Video format not supported: " + i2);
    }

    @Override // com.google.android.gms.internal.ads.zzafm
    protected final boolean zzb(zzek zzekVar, long j) throws zzaz {
        int i;
        int iZzm = zzekVar.zzm();
        long jZzh = zzekVar.zzh();
        if (iZzm == 0) {
            if (!this.zze) {
                zzek zzekVar2 = new zzek(new byte[zzekVar.zza()]);
                zzekVar.zzH(zzekVar2.zzN(), 0, zzekVar.zza());
                zzacg zzacgVarZza = zzacg.zza(zzekVar2);
                this.zzd = zzacgVarZza.zzb;
                zzx zzxVar = new zzx();
                zzxVar.zzE("video/x-flv");
                zzxVar.zzad("video/avc");
                zzxVar.zzC(zzacgVarZza.zzl);
                zzxVar.zzai(zzacgVarZza.zzc);
                zzxVar.zzM(zzacgVarZza.zzd);
                zzxVar.zzZ(zzacgVarZza.zzk);
                zzxVar.zzP(zzacgVarZza.zza);
                this.zza.zzm(zzxVar.zzaj());
                this.zze = true;
                return false;
            }
        } else if (iZzm == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            zzek zzekVar3 = this.zzc;
            byte[] bArrZzN = zzekVar3.zzN();
            bArrZzN[0] = 0;
            bArrZzN[1] = 0;
            bArrZzN[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzekVar.zza() > 0) {
                zzekVar.zzH(zzekVar3.zzN(), i3, this.zzd);
                zzekVar3.zzL(0);
                zzek zzekVar4 = this.zzb;
                int iZzp = zzekVar3.zzp();
                zzekVar4.zzL(0);
                zzaei zzaeiVar = this.zza;
                zzaeiVar.zzr(zzekVar4, 4);
                zzaeiVar.zzr(zzekVar, iZzp);
                i4 = i4 + 4 + iZzp;
            }
            this.zza.zzt(j + (jZzh * 1000), i, i4, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
