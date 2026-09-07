package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhbh extends zzgxv implements zzgzh {
    private static final zzhbh zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private long zzd;
    private long zze;

    static {
        zzhbh zzhbhVar = new zzhbh();
        zza = zzhbhVar;
        zzgxv.zzbZ(zzhbh.class, zzhbhVar);
    }

    private zzhbh() {
    }

    public static zzhbg zzc() {
        return (zzhbg) zza.zzaZ();
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhbh();
        }
        zzhbk zzhbkVar = null;
        if (iOrdinal == 4) {
            return new zzhbg(zzhbkVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzhbh.class) {
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
