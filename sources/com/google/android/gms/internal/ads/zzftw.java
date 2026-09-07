package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzftw {
    public static int zza(int i, int i2, String str) {
        String strZzb;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZzb = zzfun.zzb("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strZzb = zzfun.zzb("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZzb);
    }

    public static int zzb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzn(i, i2, "index"));
        }
        return i;
    }

    public static Object zzc(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static Object zzd(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(zzfun.zzb(str, obj2));
    }

    public static void zze(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzf(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zzg(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(zzfun.zzb(str, Character.valueOf(c)));
        }
    }

    public static void zzh(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(zzfun.zzb(str, Long.valueOf(j)));
        }
    }

    public static void zzi(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(zzfun.zzb(str, obj));
        }
    }

    public static void zzj(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(zzfun.zzb(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void zzk(int i, int i2, int i3) {
        String strZzn;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZzn = zzn(i, i3, "start index");
            } else {
                strZzn = (i2 < 0 || i2 > i3) ? zzn(i2, i3, "end index") : zzfun.zzb("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZzn);
        }
    }

    public static void zzl(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void zzm(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    private static String zzn(int i, int i2, String str) {
        if (i < 0) {
            return zzfun.zzb("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzfun.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
