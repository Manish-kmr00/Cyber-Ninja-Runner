package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.1.1 */
/* JADX INFO: loaded from: classes13.dex */
final class zziz {
    public static final /* synthetic */ int zza = 0;
    private static final zzjj zzb;

    static {
        int i = zziu.zza;
        zzb = new zzjl();
    }

    public static void zzA(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzL(i, list, z);
    }

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhl) {
            zzhl zzhlVar = (zzhl) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(zzhlVar.zze(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgr.zzz(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgr.zzz(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhl) {
            zzhl zzhlVar = (zzhl) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(zzhlVar.zze(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzg(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(zzibVar.zze(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzh(int i, Object obj, zzix zzixVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzhx)) {
            return zzgr.zzz(i2) + zzgr.zzx((zzim) obj, zzixVar);
        }
        int iZzz = zzgr.zzz(i2);
        int iZza = ((zzhx) obj).zza();
        return iZzz + zzgr.zzz(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzz;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhl) {
            zzhl zzhlVar = (zzhl) list;
            iZzz = 0;
            while (i < size) {
                int iZze = zzhlVar.zze(i);
                iZzz += zzgr.zzz((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzz = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzz += zzgr.zzz((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzz;
    }

    static int zzj(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            iZzA = 0;
            while (i < size) {
                long jZze = zzibVar.zze(i);
                iZzA += zzgr.zzA((jZze >> 63) ^ (jZze + jZze));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzA += zzgr.zzA((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzA;
    }

    static int zzk(List list) {
        int iZzz;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhl) {
            zzhl zzhlVar = (zzhl) list;
            iZzz = 0;
            while (i < size) {
                iZzz += zzgr.zzz(zzhlVar.zze(i));
                i++;
            }
        } else {
            iZzz = 0;
            while (i < size) {
                iZzz += zzgr.zzz(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzz;
    }

    static int zzl(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzib) {
            zzib zzibVar = (zzib) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(zzibVar.zze(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzgr.zzA(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzA;
    }

    public static zzjj zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, int i2, Object obj2, zzjj zzjjVar) {
        zzhk zzhkVar;
        zzjk zzjkVar;
        Object obj3 = obj2;
        if (obj2 == null && (zzjkVar = (zzhkVar = (zzhk) obj).zzc) == zzjk.zzc()) {
            obj3 = zzjkVar;
            zzjk zzjkVarZzf = zzjk.zzf();
            zzhkVar.zzc = zzjkVarZzf;
            obj3 = zzjkVarZzf;
        }
        obj3 = zzjkVar;
        ((zzjk) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    static void zzo(zzgx zzgxVar, Object obj, Object obj2) {
        if (((zzhh) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzp(zzjj zzjjVar, Object obj, Object obj2) {
        zzhk zzhkVar = (zzhk) obj;
        zzjk zzjkVarZze = zzhkVar.zzc;
        zzjk zzjkVar = ((zzhk) obj2).zzc;
        if (!zzjk.zzc().equals(zzjkVar)) {
            if (zzjk.zzc().equals(zzjkVarZze)) {
                zzjkVarZze = zzjk.zze(zzjkVarZze, zzjkVar);
            } else {
                zzjkVarZze.zzd(zzjkVar);
            }
        }
        zzhkVar.zzc = zzjkVarZze;
    }

    public static void zzq(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzjw zzjwVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjwVar.zzA(i, list, z);
    }
}
