package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhbj extends zzgxv implements zzgzh {
    private static final zzhbj zza;
    private static volatile zzgzo zzb;
    private zzgyh zzc = zzbK();

    static {
        zzhbj zzhbjVar = new zzhbj();
        zza = zzhbjVar;
        zzgxv.zzbZ(zzhbj.class, zzhbjVar);
    }

    private zzhbj() {
    }

    public static zzhbi zzc() {
        return (zzhbi) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhbj zzhbjVar, zzhbh zzhbhVar) {
        zzhbhVar.getClass();
        zzgyh zzgyhVar = zzhbjVar.zzc;
        if (!zzgyhVar.zzc()) {
            zzhbjVar.zzc = zzgxv.zzbL(zzgyhVar);
        }
        zzhbjVar.zzc.add(zzhbhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzhbh.class});
        }
        if (iOrdinal == 3) {
            return new zzhbj();
        }
        zzhbk zzhbkVar = null;
        if (iOrdinal == 4) {
            return new zzhbi(zzhbkVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzhbj.class) {
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
