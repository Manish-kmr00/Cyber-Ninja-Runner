package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxt extends zzgxv implements zzgzh {
    private static final zzaxt zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private zzaxw zzd;
    private zzgwn zze = zzgwn.zzb;
    private zzgwn zzf = zzgwn.zzb;

    static {
        zzaxt zzaxtVar = new zzaxt();
        zza = zzaxtVar;
        zzgxv.zzbZ(zzaxt.class, zzaxtVar);
    }

    private zzaxt() {
    }

    public static zzaxt zzb(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzaxt) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    public final zzaxw zzc() {
        zzaxw zzaxwVar = this.zzd;
        return zzaxwVar == null ? zzaxw.zzg() : zzaxwVar;
    }

    public final zzgwn zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzaxt();
        }
        zzaxs zzaxsVar = null;
        if (iOrdinal == 4) {
            return new zzaxr(zzaxsVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzaxt.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgwn zzf() {
        return this.zze;
    }
}
