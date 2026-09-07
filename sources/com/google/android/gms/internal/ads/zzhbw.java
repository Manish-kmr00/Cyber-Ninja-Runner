package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhbw extends zzgxv implements zzgzh {
    private static final zzhbw zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private String zzd = "";

    static {
        zzhbw zzhbwVar = new zzhbw();
        zza = zzhbwVar;
        zzgxv.zzbZ(zzhbw.class, zzhbwVar);
    }

    private zzhbw() {
    }

    public static zzhbv zzc() {
        return (zzhbv) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhbw zzhbwVar, String str) {
        zzhbwVar.zzc |= 1;
        zzhbwVar.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhbw();
        }
        zzhee zzheeVar = null;
        if (iOrdinal == 4) {
            return new zzhbv(zzheeVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzhbw.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }
}
