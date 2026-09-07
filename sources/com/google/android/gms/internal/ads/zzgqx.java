package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgqx extends zzgxv implements zzgzh {
    private static final zzgqx zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgra zzd;
    private int zze;

    static {
        zzgqx zzgqxVar = new zzgqx();
        zza = zzgqxVar;
        zzgxv.zzbZ(zzgqx.class, zzgqxVar);
    }

    private zzgqx() {
    }

    public static zzgqv zzb() {
        return (zzgqv) zza.zzaZ();
    }

    public static zzgqx zzd() {
        return zza;
    }

    static /* synthetic */ void zzh(zzgqx zzgqxVar, zzgra zzgraVar) {
        zzgraVar.getClass();
        zzgqxVar.zzd = zzgraVar;
        zzgqxVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgqx();
        }
        zzgqw zzgqwVar = null;
        if (iOrdinal == 4) {
            return new zzgqv(zzgqwVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgqx.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgra zzf() {
        zzgra zzgraVar = this.zzd;
        return zzgraVar == null ? zzgra.zzd() : zzgraVar;
    }
}
