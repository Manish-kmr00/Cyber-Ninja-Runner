package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgqi extends zzgxv implements zzgzh {
    private static final zzgqi zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzgql zze;

    static {
        zzgqi zzgqiVar = new zzgqi();
        zza = zzgqiVar;
        zzgxv.zzbZ(zzgqi.class, zzgqiVar);
    }

    private zzgqi() {
    }

    public static zzgqg zzb() {
        return (zzgqg) zza.zzaZ();
    }

    public static zzgqi zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgqi) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    static /* synthetic */ void zzh(zzgqi zzgqiVar, zzgql zzgqlVar) {
        zzgqlVar.getClass();
        zzgqiVar.zze = zzgqlVar;
        zzgqiVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgqi();
        }
        zzgqh zzgqhVar = null;
        if (iOrdinal == 4) {
            return new zzgqg(zzgqhVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgqi.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgql zzf() {
        zzgql zzgqlVar = this.zze;
        return zzgqlVar == null ? zzgql.zzd() : zzgqlVar;
    }
}
