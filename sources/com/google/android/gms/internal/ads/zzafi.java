package com.google.android.gms.internal.ads;

import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafi extends zzafm {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzafi(zzaei zzaeiVar) {
        super(zzaeiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafm
    protected final boolean zza(zzek zzekVar) throws zzafl {
        if (this.zzc) {
            zzekVar.zzM(1);
        } else {
            int iZzm = zzekVar.zzm();
            int i = iZzm >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(iZzm >> 2) & 3];
                zzx zzxVar = new zzx();
                zzxVar.zzE("video/x-flv");
                zzxVar.zzad("audio/mpeg");
                zzxVar.zzB(1);
                zzxVar.zzae(i2);
                this.zza.zzm(zzxVar.zzaj());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzx zzxVar2 = new zzx();
                zzxVar2.zzE("video/x-flv");
                zzxVar2.zzad(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw");
                zzxVar2.zzB(1);
                zzxVar2.zzae(8000);
                this.zza.zzm(zzxVar2.zzaj());
                this.zzd = true;
            } else if (i != 10) {
                throw new zzafl("Audio format not supported: " + i);
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafm
    protected final boolean zzb(zzek zzekVar, long j) throws zzaz {
        if (this.zze == 2) {
            int iZza = zzekVar.zza();
            zzaei zzaeiVar = this.zza;
            zzaeiVar.zzr(zzekVar, iZza);
            zzaeiVar.zzt(j, 1, iZza, 0, null);
            return true;
        }
        int iZzm = zzekVar.zzm();
        if (iZzm != 0 || this.zzd) {
            if (this.zze == 10 && iZzm != 1) {
                return false;
            }
            int iZza2 = zzekVar.zza();
            zzaei zzaeiVar2 = this.zza;
            zzaeiVar2.zzr(zzekVar, iZza2);
            zzaeiVar2.zzt(j, 1, iZza2, 0, null);
            return true;
        }
        int iZza3 = zzekVar.zza();
        byte[] bArr = new byte[iZza3];
        zzekVar.zzH(bArr, 0, iZza3);
        zzabw zzabwVarZza = zzaby.zza(bArr);
        zzx zzxVar = new zzx();
        zzxVar.zzE("video/x-flv");
        zzxVar.zzad("audio/mp4a-latm");
        zzxVar.zzC(zzabwVarZza.zzc);
        zzxVar.zzB(zzabwVarZza.zzb);
        zzxVar.zzae(zzabwVarZza.zza);
        zzxVar.zzP(Collections.singletonList(bArr));
        this.zza.zzm(zzxVar.zzaj());
        this.zzd = true;
        return false;
    }
}
