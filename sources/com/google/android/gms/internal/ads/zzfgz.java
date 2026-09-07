package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfgz extends zzgxv implements zzgzh {
    private static final zzfgz zza;
    private static volatile zzgzo zzb;
    private zzgyh zzc = zzbK();

    static {
        zzfgz zzfgzVar = new zzfgz();
        zza = zzfgzVar;
        zzgxv.zzbZ(zzfgz.class, zzfgzVar);
    }

    private zzfgz() {
    }

    public static zzfgv zzb() {
        return (zzfgv) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzfgz zzfgzVar, zzfgx zzfgxVar) {
        zzfgxVar.getClass();
        zzgyh zzgyhVar = zzfgzVar.zzc;
        if (!zzgyhVar.zzc()) {
            zzfgzVar.zzc = zzgxv.zzbL(zzgyhVar);
        }
        zzfgzVar.zzc.add(zzfgxVar);
    }

    public final int zza() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfgx.class});
        }
        if (iOrdinal == 3) {
            return new zzfgz();
        }
        zzfgy zzfgyVar = null;
        if (iOrdinal == 4) {
            return new zzfgv(zzfgyVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzfgz.class) {
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
