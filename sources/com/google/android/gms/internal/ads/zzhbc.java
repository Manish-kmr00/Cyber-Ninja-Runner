package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhbc extends zzgxv implements zzgzh {
    private static final zzhbc zza;
    private static volatile zzgzo zzb;
    private zzgyd zzc = zzbG();
    private zzgyd zzd = zzbG();

    static {
        zzhbc zzhbcVar = new zzhbc();
        zza = zzhbcVar;
        zzgxv.zzbZ(zzhbc.class, zzhbcVar);
    }

    private zzhbc() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0004\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0002\u0000\u0001\u0016\u0003\u0016", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhbc();
        }
        zzhbd zzhbdVar = null;
        if (iOrdinal == 4) {
            return new zzhbb(zzhbdVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzhbc.class) {
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
