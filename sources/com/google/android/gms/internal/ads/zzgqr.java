package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgqr extends zzgxv implements zzgzh {
    private static final zzgqr zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzgqx zzd;
    private zzgsi zze;

    static {
        zzgqr zzgqrVar = new zzgqr();
        zza = zzgqrVar;
        zzgxv.zzbZ(zzgqr.class, zzgqrVar);
    }

    private zzgqr() {
    }

    public static zzgqp zza() {
        return (zzgqp) zza.zzaZ();
    }

    public static zzgqr zzc(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgqr) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    static /* synthetic */ void zzg(zzgqr zzgqrVar, zzgqx zzgqxVar) {
        zzgqxVar.getClass();
        zzgqrVar.zzd = zzgqxVar;
        zzgqrVar.zzc |= 1;
    }

    static /* synthetic */ void zzh(zzgqr zzgqrVar, zzgsi zzgsiVar) {
        zzgsiVar.getClass();
        zzgqrVar.zze = zzgsiVar;
        zzgqrVar.zzc |= 2;
    }

    public final zzgqx zzd() {
        zzgqx zzgqxVar = this.zzd;
        return zzgqxVar == null ? zzgqx.zzd() : zzgqxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgqr();
        }
        zzgqq zzgqqVar = null;
        if (iOrdinal == 4) {
            return new zzgqp(zzgqqVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgqr.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgsi zzf() {
        zzgsi zzgsiVar = this.zze;
        return zzgsiVar == null ? zzgsi.zzf() : zzgsiVar;
    }
}
