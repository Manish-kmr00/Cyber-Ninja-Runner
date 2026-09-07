package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasp extends zzgxv implements zzgzh {
    private static final zzasp zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private long zzd = -1;
    private int zze = 1000;

    static {
        zzasp zzaspVar = new zzasp();
        zza = zzaspVar;
        zzgxv.zzbZ(zzasp.class, zzaspVar);
    }

    private zzasp() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zzc", "zzd", "zze", zzatc.zza});
        }
        if (iOrdinal == 3) {
            return new zzasp();
        }
        zzatm zzatmVar = null;
        if (iOrdinal == 4) {
            return new zzaso(zzatmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzasp.class) {
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
