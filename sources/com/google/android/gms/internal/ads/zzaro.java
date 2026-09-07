package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaro extends zzgxv implements zzgzh {
    private static final zzaro zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd = 2;

    static {
        zzaro zzaroVar = new zzaro();
        zza = zzaroVar;
        zzgxv.zzbZ(zzaro.class, zzaroVar);
    }

    private zzaro() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0004\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zzc", "zzd", zzarp.zza});
        }
        if (iOrdinal == 3) {
            return new zzaro();
        }
        zzars zzarsVar = null;
        if (iOrdinal == 4) {
            return new zzarn(zzarsVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzaro.class) {
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
