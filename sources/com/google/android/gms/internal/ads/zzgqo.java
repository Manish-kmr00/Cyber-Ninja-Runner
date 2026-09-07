package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgqo extends zzgxv implements zzgzh {
    private static final zzgqo zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzgqu zze;
    private zzgsf zzf;

    static {
        zzgqo zzgqoVar = new zzgqo();
        zza = zzgqoVar;
        zzgxv.zzbZ(zzgqo.class, zzgqoVar);
    }

    private zzgqo() {
    }

    public static zzgqm zzb() {
        return (zzgqm) zza.zzaZ();
    }

    public static zzgqo zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgqo) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    public static zzgzo zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzi(zzgqo zzgqoVar, zzgqu zzgquVar) {
        zzgquVar.getClass();
        zzgqoVar.zze = zzgquVar;
        zzgqoVar.zzc |= 1;
    }

    static /* synthetic */ void zzj(zzgqo zzgqoVar, zzgsf zzgsfVar) {
        zzgsfVar.getClass();
        zzgqoVar.zzf = zzgsfVar;
        zzgqoVar.zzc |= 2;
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
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgqo();
        }
        zzgqn zzgqnVar = null;
        if (iOrdinal == 4) {
            return new zzgqm(zzgqnVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgqo.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgqu zzf() {
        zzgqu zzgquVar = this.zze;
        return zzgquVar == null ? zzgqu.zzd() : zzgquVar;
    }

    public final zzgsf zzg() {
        zzgsf zzgsfVar = this.zzf;
        return zzgsfVar == null ? zzgsf.zzd() : zzgsfVar;
    }
}
