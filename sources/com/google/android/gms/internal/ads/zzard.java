package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzard extends zzgxv implements zzgzh {
    private static final zzard zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private boolean zzg;
    private zzarv zzi;
    private zzary zzj;
    private boolean zzk;
    private boolean zze = true;
    private String zzf = "unknown_host";
    private boolean zzh = true;

    static {
        zzard zzardVar = new zzard();
        zza = zzardVar;
        zzgxv.zzbZ(zzard.class, zzardVar);
    }

    private zzard() {
    }

    public static zzarb zza() {
        return (zzarb) zza.zzaZ();
    }

    static /* synthetic */ void zzg(zzard zzardVar, boolean z) {
        zzardVar.zzc |= 8;
        zzardVar.zzg = z;
    }

    static /* synthetic */ void zzh(zzard zzardVar, String str) {
        str.getClass();
        zzardVar.zzc |= 4;
        zzardVar.zzf = str;
    }

    public final zzarv zzc() {
        zzarv zzarvVar = this.zzi;
        return zzarvVar == null ? zzarv.zzc() : zzarvVar;
    }

    public final zzary zzd() {
        zzary zzaryVar = this.zzj;
        return zzaryVar == null ? zzary.zzb() : zzaryVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", zzare.zza, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzard();
        }
        zzarc zzarcVar = null;
        if (iOrdinal == 4) {
            return new zzarb(zzarcVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzard.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final String zzf() {
        return this.zzf;
    }

    @Deprecated
    public final boolean zzi() {
        return this.zzg;
    }
}
