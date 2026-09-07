package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzhab {
    public static final /* synthetic */ int zza = 0;
    private static final zzhal zzb;

    static {
        int i = zzgzq.zza;
        zzb = new zzhan();
    }

    public static void zzA(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzu(i, list, z);
    }

    public static void zzB(int i, List list, zzhba zzhbaVar, zzgzz zzgzzVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzgxb) zzhbaVar).zzv(i, list.get(i2), zzgzzVar);
        }
    }

    public static void zzC(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzy(i, list, z);
    }

    public static void zzD(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzA(i, list, z);
    }

    public static void zzE(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzC(i, list, z);
    }

    public static void zzF(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzE(i, list, z);
    }

    public static void zzG(int i, List list, zzhba zzhbaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzH(i, list);
    }

    public static void zzH(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzJ(i, list, z);
    }

    public static void zzI(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzL(i, list, z);
    }

    static boolean zzJ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzgxa.zzE(zzgxwVar.zzd(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzgxa.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzE;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgxa.zzD(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgxa.zzD(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzgxa.zzE(zzgxwVar.zzd(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzgxa.zzE(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzE;
    }

    static int zzg(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyv) {
            zzgyv zzgyvVar = (zzgyv) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzgxa.zzE(zzgyvVar.zza(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzgxa.zzE(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzE;
    }

    static int zzh(int i, Object obj, zzgzz zzgzzVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzgyr)) {
            return zzgxa.zzD(i2) + zzgxa.zzA((zzgzg) obj, zzgzzVar);
        }
        int iZzD = zzgxa.zzD(i2);
        int iZza = ((zzgyr) obj).zza();
        return iZzD + zzgxa.zzD(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            iZzD = 0;
            while (i < size) {
                int iZzd = zzgxwVar.zzd(i);
                iZzD += zzgxa.zzD((iZzd >> 31) ^ (iZzd + iZzd));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzD += zzgxa.zzD((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzD;
    }

    static int zzj(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyv) {
            zzgyv zzgyvVar = (zzgyv) list;
            iZzE = 0;
            while (i < size) {
                long jZza = zzgyvVar.zza(i);
                iZzE += zzgxa.zzE((jZza >> 63) ^ (jZza + jZza));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzE += zzgxa.zzE((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzE;
    }

    static int zzk(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgxw) {
            zzgxw zzgxwVar = (zzgxw) list;
            iZzD = 0;
            while (i < size) {
                iZzD += zzgxa.zzD(zzgxwVar.zzd(i));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                iZzD += zzgxa.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzD;
    }

    static int zzl(List list) {
        int iZzE;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgyv) {
            zzgyv zzgyvVar = (zzgyv) list;
            iZzE = 0;
            while (i < size) {
                iZzE += zzgxa.zzE(zzgyvVar.zza(i));
                i++;
            }
        } else {
            iZzE = 0;
            while (i < size) {
                iZzE += zzgxa.zzE(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzE;
    }

    public static zzhal zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, List list, zzgyb zzgybVar, Object obj2, zzhal zzhalVar) {
        if (zzgybVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue = ((Integer) list.get(i3)).intValue();
                if (zzgybVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue));
                    }
                    i2++;
                } else {
                    obj2 = zzo(obj, i, iIntValue, obj2, zzhalVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzgybVar.zza(iIntValue2)) {
                    obj2 = zzo(obj, i, iIntValue2, obj2, zzhalVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzhal zzhalVar) {
        if (obj2 == null) {
            obj2 = zzhalVar.zza(obj);
        }
        zzhalVar.zzh(obj2, i, i2);
        return obj2;
    }

    static void zzp(zzgxg zzgxgVar, Object obj, Object obj2) {
        if (((zzgxr) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzq(zzhal zzhalVar, Object obj, Object obj2) {
        zzgxv zzgxvVar = (zzgxv) obj;
        zzham zzhamVarZze = zzgxvVar.zzt;
        zzham zzhamVar = ((zzgxv) obj2).zzt;
        if (!zzham.zzc().equals(zzhamVar)) {
            if (zzham.zzc().equals(zzhamVarZze)) {
                zzhamVarZze = zzham.zze(zzhamVarZze, zzhamVar);
            } else {
                zzhamVarZze.zzd(zzhamVar);
            }
        }
        zzgxvVar.zzt = zzhamVarZze;
    }

    public static void zzr(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzhba zzhbaVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zze(i, list);
    }

    public static void zzt(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzg(i, list, z);
    }

    public static void zzu(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzj(i, list, z);
    }

    public static void zzv(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzl(i, list, z);
    }

    public static void zzw(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzn(i, list, z);
    }

    public static void zzx(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzp(i, list, z);
    }

    public static void zzy(int i, List list, zzhba zzhbaVar, zzgzz zzgzzVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzgxb) zzhbaVar).zzq(i, list.get(i2), zzgzzVar);
        }
    }

    public static void zzz(int i, List list, zzhba zzhbaVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhbaVar.zzs(i, list, z);
    }
}
