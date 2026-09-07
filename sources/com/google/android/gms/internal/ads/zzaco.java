package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzaco {
    public static void zza(long j, zzek zzekVar, zzaei[] zzaeiVarArr) {
        int iZzg;
        while (true) {
            if (zzekVar.zza() <= 1) {
                return;
            }
            int iZzc = zzc(zzekVar);
            int iZzc2 = zzc(zzekVar);
            int iZzc3 = zzekVar.zzc() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzekVar.zza()) {
                zzdx.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzc3 = zzekVar.zzd();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzm = zzekVar.zzm();
                int iZzq = zzekVar.zzq();
                if (iZzq == 49) {
                    iZzg = zzekVar.zzg();
                    iZzq = 49;
                } else {
                    iZzg = 0;
                }
                int iZzm2 = zzekVar.zzm();
                if (iZzq == 47) {
                    zzekVar.zzM(1);
                    iZzq = 47;
                }
                boolean z = iZzm == 181 && (iZzq == 49 || iZzq == 47) && iZzm2 == 3;
                if (iZzq == 49) {
                    z &= iZzg == 1195456820;
                }
                if (z) {
                    zzb(j, zzekVar, zzaeiVarArr);
                }
            }
            zzekVar.zzL(iZzc3);
        }
    }

    public static void zzb(long j, zzek zzekVar, zzaei[] zzaeiVarArr) {
        int iZzm = zzekVar.zzm();
        if ((iZzm & 64) != 0) {
            int i = iZzm & 31;
            zzekVar.zzM(1);
            int iZzc = zzekVar.zzc();
            for (zzaei zzaeiVar : zzaeiVarArr) {
                int i2 = i * 3;
                zzekVar.zzL(iZzc);
                zzaeiVar.zzr(zzekVar, i2);
                zzdc.zzf(j != -9223372036854775807L);
                zzaeiVar.zzt(j, 1, i2, 0, null);
            }
        }
    }

    private static int zzc(zzek zzekVar) {
        int i = 0;
        while (zzekVar.zza() != 0) {
            int iZzm = zzekVar.zzm();
            i += iZzm;
            if (iZzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
