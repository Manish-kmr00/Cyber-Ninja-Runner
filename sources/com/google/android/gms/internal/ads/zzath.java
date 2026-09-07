package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzath extends zzgxv implements zzgzh {
    private static final zzath zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private long zzd;
    private String zze = "";
    private zzgwn zzf = zzgwn.zzb;

    static {
        zzath zzathVar = new zzath();
        zza = zzathVar;
        zzgxv.zzbZ(zzath.class, zzathVar);
    }

    private zzath() {
    }

    public static zzath zzc() {
        return zza;
    }

    public final long zza() {
        return this.zzd;
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
            return zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzath();
        }
        zzatm zzatmVar = null;
        if (iOrdinal == 4) {
            return new zzatg(zzatmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzath.class) {
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
        return this.zze;
    }

    public final boolean zzg() {
        return (this.zzc & 1) != 0;
    }
}
