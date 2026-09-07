package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgqf extends zzgxv implements zzgzh {
    private static final zzgqf zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzgwn zze = zzgwn.zzb;
    private zzgql zzf;

    static {
        zzgqf zzgqfVar = new zzgqf();
        zza = zzgqfVar;
        zzgxv.zzbZ(zzgqf.class, zzgqfVar);
    }

    private zzgqf() {
    }

    public static zzgqd zzb() {
        return (zzgqd) zza.zzaZ();
    }

    public static zzgqf zzd(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgqf) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    public static zzgzo zzh() {
        return zza.zzbN();
    }

    static /* synthetic */ void zzj(zzgqf zzgqfVar, zzgql zzgqlVar) {
        zzgqlVar.getClass();
        zzgqfVar.zzf = zzgqlVar;
        zzgqfVar.zzc |= 1;
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
            return zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgqf();
        }
        zzgqe zzgqeVar = null;
        if (iOrdinal == 4) {
            return new zzgqd(zzgqeVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgqf.class) {
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
        zzgql zzgqlVar = this.zzf;
        return zzgqlVar == null ? zzgql.zzd() : zzgqlVar;
    }

    public final zzgwn zzg() {
        return this.zze;
    }
}
