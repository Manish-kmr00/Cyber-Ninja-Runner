package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfgx extends zzgxv implements zzgzh {
    private static final zzfgx zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzfgu zzd;

    static {
        zzfgx zzfgxVar = new zzfgx();
        zza = zzfgxVar;
        zzgxv.zzbZ(zzfgx.class, zzfgxVar);
    }

    private zzfgx() {
    }

    public static zzfgw zza() {
        return (zzfgw) zza.zzaZ();
    }

    static /* synthetic */ void zzc(zzfgx zzfgxVar, zzfgu zzfguVar) {
        zzfguVar.getClass();
        zzfgxVar.zzd = zzfguVar;
        zzfgxVar.zzc |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0004\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzfgx();
        }
        zzfgy zzfgyVar = null;
        if (iOrdinal == 4) {
            return new zzfgw(zzfgyVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzfgx.class) {
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
