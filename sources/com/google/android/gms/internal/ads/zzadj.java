package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadj {
    public static int zza(zzek zzekVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzekVar.zzm() + 1;
            case 7:
                return zzekVar.zzq() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzadd zzaddVar, zzadn zzadnVar) throws IOException {
        zzaddVar.zzj();
        zzaddVar.zzg(1);
        byte[] bArr = new byte[1];
        zzaddVar.zzh(bArr, 0, 1);
        int i = bArr[0] & 1;
        boolean z = 1 == i;
        zzaddVar.zzg(2);
        int i2 = 1 != i ? 6 : 7;
        zzek zzekVar = new zzek(i2);
        zzekVar.zzK(zzadg.zza(zzaddVar, zzekVar.zzN(), 0, i2));
        zzaddVar.zzj();
        zzadi zzadiVar = new zzadi();
        if (zzd(zzekVar, zzadnVar, z, zzadiVar)) {
            return zzadiVar.zza;
        }
        throw zzaz.zza(null, null);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x009b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ae A[RETURN] */
    public static boolean zzc(zzek zzekVar, zzadn zzadnVar, int i, zzadi zzadiVar) {
        int iZza;
        int iZzc = zzekVar.zzc();
        long jZzu = zzekVar.zzu();
        long j = jZzu >>> 16;
        if (j != i) {
            return false;
        }
        boolean z = (j & 1) == 1;
        long j2 = jZzu >> 12;
        long j3 = jZzu >> 8;
        long j4 = jZzu >> 4;
        long j5 = jZzu >> 1;
        long j6 = jZzu & 1;
        int i2 = (int) (j4 & 15);
        if (i2 > 7 ? !(i2 > 10 || zzadnVar.zzg != 2) : i2 == zzadnVar.zzg - 1) {
            int i3 = (int) (j5 & 7);
            if ((i3 == 0 || i3 == zzadnVar.zzi) && j6 != 1 && zzd(zzekVar, zzadnVar, z, zzadiVar) && (iZza = zza(zzekVar, (int) (j2 & 15))) != -1 && iZza <= zzadnVar.zzb) {
                int i4 = zzadnVar.zze;
                int i5 = (int) (j3 & 15);
                if (i5 != 0) {
                    if (i5 <= 11) {
                        if (i5 == zzadnVar.zzf) {
                            if (zzekVar.zzm() == zzeu.zzg(zzekVar.zzN(), iZzc, zzekVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i5 == 12) {
                        if (zzekVar.zzm() * 1000 == i4) {
                            if (zzekVar.zzm() == zzeu.zzg(zzekVar.zzN(), iZzc, zzekVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i5 <= 14) {
                        int iZzq = zzekVar.zzq();
                        if (i5 == 14) {
                            iZzq *= 10;
                        }
                        if (iZzq == i4) {
                            if (zzekVar.zzm() == zzeu.zzg(zzekVar.zzN(), iZzc, zzekVar.zzc() - 1, 0)) {
                                return true;
                            }
                        }
                    }
                } else if (zzekVar.zzm() == zzeu.zzg(zzekVar.zzN(), iZzc, zzekVar.zzc() - 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzd(zzek zzekVar, zzadn zzadnVar, boolean z, zzadi zzadiVar) {
        try {
            long jZzx = zzekVar.zzx();
            if (!z) {
                jZzx *= (long) zzadnVar.zzb;
            }
            zzadiVar.zza = jZzx;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
