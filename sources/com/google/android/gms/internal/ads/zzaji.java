package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaji {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzek zzg = new zzek(255);

    zzaji() {
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0L;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzadd zzaddVar, boolean z) throws IOException {
        zza();
        zzek zzekVar = this.zzg;
        zzekVar.zzI(27);
        if (zzadg.zzc(zzaddVar, zzekVar.zzN(), 0, 27, z) && zzekVar.zzu() == 1332176723) {
            if (zzekVar.zzm() != 0) {
                if (z) {
                    return false;
                }
                throw zzaz.zzc("unsupported bit stream revision");
            }
            this.zza = zzekVar.zzm();
            this.zzb = zzekVar.zzr();
            zzekVar.zzs();
            zzekVar.zzs();
            zzekVar.zzs();
            int iZzm = zzekVar.zzm();
            this.zzc = iZzm;
            this.zzd = iZzm + 27;
            zzekVar.zzI(iZzm);
            if (zzadg.zzc(zzaddVar, zzekVar.zzN(), 0, this.zzc, z)) {
                for (int i = 0; i < this.zzc; i++) {
                    int[] iArr = this.zzf;
                    int iZzm2 = zzekVar.zzm();
                    iArr[i] = iZzm2;
                    this.zze += iZzm2;
                }
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzadd zzaddVar, long j) throws IOException {
        zzdc.zzd(zzaddVar.zzf() == zzaddVar.zze());
        zzek zzekVar = this.zzg;
        zzekVar.zzI(4);
        while (true) {
            if ((j != -1 && zzaddVar.zzf() + 4 >= j) || !zzadg.zzc(zzaddVar, zzekVar.zzN(), 0, 4, true)) {
                break;
            }
            zzekVar.zzL(0);
            if (zzekVar.zzu() == 1332176723) {
                zzaddVar.zzj();
                return true;
            }
            zzaddVar.zzk(1);
        }
        do {
            if (j != -1 && zzaddVar.zzf() >= j) {
                break;
            }
        } while (zzaddVar.zzc(1) != -1);
        return false;
    }
}
