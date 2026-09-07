package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzgqu extends zzgxv implements zzgzh {
    private static final zzgqu zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private zzgra zze;
    private zzgwn zzf = zzgwn.zzb;

    static {
        zzgqu zzgquVar = new zzgqu();
        zza = zzgquVar;
        zzgxv.zzbZ(zzgqu.class, zzgquVar);
    }

    private zzgqu() {
    }

    public static zzgqs zzb() {
        return (zzgqs) zza.zzaZ();
    }

    public static zzgqu zzd() {
        return zza;
    }

    static /* synthetic */ void zzi(zzgqu zzgquVar, zzgra zzgraVar) {
        zzgraVar.getClass();
        zzgquVar.zze = zzgraVar;
        zzgquVar.zzc |= 1;
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
            return new zzgqu();
        }
        zzgqt zzgqtVar = null;
        if (iOrdinal == 4) {
            return new zzgqs(zzgqtVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzgqu.class) {
                zzgxqVar = zzb;
                if (zzgxqVar == null) {
                    zzgxqVar = new zzgxq(zza);
                    zzb = zzgxqVar;
                }
            }
        }
        return zzgxqVar;
    }

    public final zzgra zzf() {
        zzgra zzgraVar = this.zze;
        return zzgraVar == null ? zzgra.zzd() : zzgraVar;
    }

    public final zzgwn zzg() {
        return this.zzf;
    }
}
