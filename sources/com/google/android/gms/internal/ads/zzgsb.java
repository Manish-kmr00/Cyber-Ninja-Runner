package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgsb extends zzgxv implements zzgzh {
    private static final zzgsb zza;
    private static volatile zzgzo zzb;

    static {
        zzgsb zzgsbVar = new zzgsb();
        zza = zzgsbVar;
        zzgxv.zzbZ(zzgsb.class, zzgsbVar);
    }

    private zzgsb() {
    }

    public static zzgsb zzb() {
        return zza;
    }

    public static zzgsb zzc(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgsb) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        zzgsa zzgsaVar = null;
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0000", null);
        }
        if (iOrdinal == 3) {
            return new zzgsb();
        }
        if (iOrdinal == 4) {
            return new zzgrz(zzgsaVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgsb.class) {
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
