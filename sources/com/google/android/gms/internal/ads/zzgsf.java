package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgsf extends zzgxv implements zzgzh {
    private static final zzgsf zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzgsl zze;
    private zzgwn zzf = zzgwn.zzb;

    static {
        zzgsf zzgsfVar = new zzgsf();
        zza = zzgsfVar;
        zzgxv.zzbZ(zzgsf.class, zzgsfVar);
    }

    private zzgsf() {
    }

    public static zzgsd zzb() {
        return (zzgsd) zza.zzaZ();
    }

    public static zzgsf zzd() {
        return zza;
    }

    public static zzgsf zzf(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgsf) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    public static zzgzo zzi() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzk(zzgsf zzgsfVar, zzgsl zzgslVar) {
        zzgslVar.getClass();
        zzgsfVar.zze = zzgslVar;
        zzgsfVar.zzc |= 1;
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
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgsf();
        }
        zzgse zzgseVar = null;
        if (iOrdinal == 4) {
            return new zzgsd(zzgseVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgsf.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgsl zzg() {
        zzgsl zzgslVar = this.zze;
        return zzgslVar == null ? zzgsl.zzf() : zzgslVar;
    }

    public final zzgwn zzh() {
        return this.zzf;
    }
}
