package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzasn extends zzgxv implements zzgzh {
    private static final zzasn zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private long zze = -1;

    static {
        zzasn zzasnVar = new zzasn();
        zza = zzasnVar;
        zzgxv.zzbZ(zzasn.class, zzasnVar);
    }

    private zzasn() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", zzasd.zza, "zze"});
        }
        if (iOrdinal == 3) {
            return new zzasn();
        }
        zzatm zzatmVar = null;
        if (iOrdinal == 4) {
            return new zzasm(zzatmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzasn.class) {
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
