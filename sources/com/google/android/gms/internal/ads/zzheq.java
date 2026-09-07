package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public abstract class zzheq {
    public static zzheq zzb(Class cls) {
        return System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik") ? new zzhel(cls.getSimpleName()) : new zzhen(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
