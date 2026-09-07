package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgsl extends zzgxv implements zzgzh {
    private static final zzgsl zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;

    static {
        zzgsl zzgslVar = new zzgsl();
        zza = zzgslVar;
        zzgxv.zzbZ(zzgsl.class, zzgslVar);
    }

    private zzgsl() {
    }

    public static zzgsj zzc() {
        return (zzgsj) zza.zzaZ();
    }

    public static zzgsl zzf() {
        return zza;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzgsc zzb() {
        zzgsc zzgscVar;
        int i = this.zzc;
        if (i == 0) {
            zzgscVar = zzgsc.UNKNOWN_HASH;
        } else if (i == 1) {
            zzgscVar = zzgsc.SHA1;
        } else if (i == 2) {
            zzgscVar = zzgsc.SHA384;
        } else if (i == 3) {
            zzgscVar = zzgsc.SHA256;
        } else if (i != 4) {
            zzgscVar = i != 5 ? null : zzgsc.SHA224;
        } else {
            zzgscVar = zzgsc.SHA512;
        }
        return zzgscVar == null ? zzgsc.UNRECOGNIZED : zzgscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzgsl();
        }
        zzgsk zzgskVar = null;
        if (iOrdinal == 4) {
            return new zzgsj(zzgskVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgsl.class) {
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
