package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgrg extends zzgxv implements zzgzh {
    private static final zzgrg zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgrj zzd;
    private int zze;

    static {
        zzgrg zzgrgVar = new zzgrg();
        zza = zzgrgVar;
        zzgxv.zzbZ(zzgrg.class, zzgrgVar);
    }

    private zzgrg() {
    }

    public static zzgre zzb() {
        return (zzgre) zza.zzaZ();
    }

    public static zzgrg zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgrg) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    static /* synthetic */ void zzh(zzgrg zzgrgVar, zzgrj zzgrjVar) {
        zzgrjVar.getClass();
        zzgrgVar.zzd = zzgrjVar;
        zzgrgVar.zzc |= 1;
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
            return new zzgrg();
        }
        zzgrf zzgrfVar = null;
        if (iOrdinal == 4) {
            return new zzgre(zzgrfVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgrg.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgrj zzf() {
        zzgrj zzgrjVar = this.zzd;
        return zzgrjVar == null ? zzgrj.zzd() : zzgrjVar;
    }
}
