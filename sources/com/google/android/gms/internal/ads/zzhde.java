package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhde extends zzgxv implements zzgzh {
    private static final zzhde zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgwn zzf = zzgwn.zzb;
    private zzgwn zzg = zzgwn.zzb;

    static {
        zzhde zzhdeVar = new zzhde();
        zza = zzhdeVar;
        zzgxv.zzbZ(zzhde.class, zzhdeVar);
    }

    private zzhde() {
    }

    public static zzhdc zzc() {
        return (zzhdc) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhde zzhdeVar, zzgwn zzgwnVar) {
        zzgwnVar.getClass();
        zzhdeVar.zzc |= 4;
        zzhdeVar.zzf = zzgwnVar;
    }

    static /* synthetic */ void zzg(zzhde zzhdeVar, String str) {
        zzhdeVar.zzc |= 2;
        zzhdeVar.zze = "image/png";
    }

    static /* synthetic */ void zzh(zzhde zzhdeVar, int i) {
        zzhdeVar.zzd = 1;
        zzhdeVar.zzc = 1 | zzhdeVar.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", zzhdd.zza, "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzhde();
        }
        zzhee zzheeVar = null;
        if (iOrdinal == 4) {
            return new zzhdc(zzheeVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzhde.class) {
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
