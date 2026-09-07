package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzgwc {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzgwb zzgwbVar) throws zzgyk {
        int iZzh = zzh(bArr, i, zzgwbVar);
        int i2 = zzgwbVar.zza;
        if (i2 < 0) {
            throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZzh) {
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzgwbVar.zzc = zzgwn.zzb;
            return iZzh;
        }
        zzgwbVar.zzc = zzgwn.zzv(bArr, iZzh, i2);
        return iZzh + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzgzz zzgzzVar, byte[] bArr, int i, int i2, int i3, zzgwb zzgwbVar) throws IOException {
        Object objZze = zzgzzVar.zze();
        int iZzl = zzl(objZze, zzgzzVar, bArr, i, i2, i3, zzgwbVar);
        zzgzzVar.zzf(objZze);
        zzgwbVar.zzc = objZze;
        return iZzl;
    }

    static int zzd(zzgzz zzgzzVar, byte[] bArr, int i, int i2, zzgwb zzgwbVar) throws IOException {
        Object objZze = zzgzzVar.zze();
        int iZzm = zzm(objZze, zzgzzVar, bArr, i, i2, zzgwbVar);
        zzgzzVar.zzf(objZze);
        zzgwbVar.zzc = objZze;
        return iZzm;
    }

    static int zze(zzgzz zzgzzVar, int i, byte[] bArr, int i2, int i3, zzgyh zzgyhVar, zzgwb zzgwbVar) throws IOException {
        int iZzd = zzd(zzgzzVar, bArr, i2, i3, zzgwbVar);
        zzgyhVar.add(zzgwbVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzgwbVar);
            if (i != zzgwbVar.zza) {
                break;
            }
            iZzd = zzd(zzgzzVar, bArr, iZzh, i3, zzgwbVar);
            zzgyhVar.add(zzgwbVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzgyh zzgyhVar, zzgwb zzgwbVar) throws IOException {
        zzgxw zzgxwVar = (zzgxw) zzgyhVar;
        int iZzh = zzh(bArr, i, zzgwbVar);
        int i2 = zzgwbVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzgwbVar);
            zzgxwVar.zzi(zzgwbVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzham zzhamVar, zzgwb zzgwbVar) throws zzgyk {
        if ((i >>> 3) == 0) {
            throw new zzgyk("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzgwbVar);
            zzhamVar.zzj(i, Long.valueOf(zzgwbVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzhamVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzgwbVar);
            int i5 = zzgwbVar.zza;
            if (i5 < 0) {
                throw new zzgyk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZzh) {
                throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzhamVar.zzj(i, zzgwn.zzb);
            } else {
                zzhamVar.zzj(i, zzgwn.zzv(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzgyk("Protocol message contained an invalid tag (zero).");
            }
            zzhamVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzham zzhamVarZzf = zzham.zzf();
        int i7 = zzgwbVar.zze + 1;
        zzgwbVar.zze = i7;
        zzo(i7);
        int i8 = 0;
        while (i2 < i3) {
            int iZzh2 = zzh(bArr, i2, zzgwbVar);
            i8 = zzgwbVar.zza;
            if (i8 == i6) {
                i2 = iZzh2;
                break;
            }
            i2 = zzg(i8, bArr, iZzh2, i3, zzhamVarZzf, zzgwbVar);
        }
        zzgwbVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzgyk("Failed to parse the message.");
        }
        zzhamVar.zzj(i, zzhamVarZzf);
        return i2;
    }

    static int zzh(byte[] bArr, int i, zzgwb zzgwbVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgwbVar);
        }
        zzgwbVar.zza = b;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzgwb zzgwbVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzgwbVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgwbVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgwbVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgwbVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgwbVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzgyh zzgyhVar, zzgwb zzgwbVar) {
        zzgxw zzgxwVar = (zzgxw) zzgyhVar;
        int iZzh = zzh(bArr, i2, zzgwbVar);
        zzgxwVar.zzi(zzgwbVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzgwbVar);
            if (i != zzgwbVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzgwbVar);
            zzgxwVar.zzi(zzgwbVar.zza);
        }
        return iZzh;
    }

    static int zzk(byte[] bArr, int i, zzgwb zzgwbVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgwbVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzgwbVar.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzgzz zzgzzVar, byte[] bArr, int i, int i2, int i3, zzgwb zzgwbVar) throws IOException {
        zzgzj zzgzjVar = (zzgzj) zzgzzVar;
        int i4 = zzgwbVar.zze + 1;
        zzgwbVar.zze = i4;
        zzo(i4);
        int iZzc = zzgzjVar.zzc(obj, bArr, i, i2, i3, zzgwbVar);
        zzgwbVar.zze--;
        zzgwbVar.zzc = obj;
        return iZzc;
    }

    static int zzm(Object obj, zzgzz zzgzzVar, byte[] bArr, int i, int i2, zzgwb zzgwbVar) throws IOException {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzgwbVar);
            i3 = zzgwbVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzgyk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzgwbVar.zze + 1;
        zzgwbVar.zze = i5;
        zzo(i5);
        int i6 = i3 + i4;
        zzgzzVar.zzi(obj, bArr, i4, i6, zzgwbVar);
        zzgwbVar.zze--;
        zzgwbVar.zzc = obj;
        return i6;
    }

    static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzo(int i) throws zzgyk {
        if (i >= zzb) {
            throw new zzgyk("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
