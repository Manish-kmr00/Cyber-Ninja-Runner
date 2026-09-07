package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgrv extends zzgxv implements zzgzh {
    private static final zzgrv zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;

    static {
        zzgrv zzgrvVar = new zzgrv();
        zza = zzgrvVar;
        zzgxv.zzbZ(zzgrv.class, zzgrvVar);
    }

    private zzgrv() {
    }

    public static zzgrt zzc() {
        return (zzgrt) zza.zzaZ();
    }

    public static zzgrv zzf(zzgwn zzgwnVar, zzgxf zzgxfVar) throws zzgyk {
        return (zzgrv) zzgxv.zzbr(zza, zzgwnVar, zzgxfVar);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzd", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzgrv();
        }
        zzgru zzgruVar = null;
        if (iOrdinal == 4) {
            return new zzgrt(zzgruVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgrv.class) {
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
