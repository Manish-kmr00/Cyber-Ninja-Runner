package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhdx extends zzgxv implements zzgzh {
    private static final zzhdx zza;
    private static volatile zzgzo zzb;
    private int zzc;
    private int zzd;
    private int zzg;
    private String zze = "";
    private zzgyd zzf = zzbG();
    private zzgyh zzh = zzbK();
    private zzgwn zzi = zzgwn.zzb;

    static {
        zzhdx zzhdxVar = new zzhdx();
        zza = zzhdxVar;
        zzgxv.zzbZ(zzhdx.class, zzhdxVar);
    }

    private zzhdx() {
    }

    @Override // com.google.android.gms.internal.ads.zzgxv
    protected final Object zzdc(zzgxu zzgxuVar, Object obj, Object obj2) {
        int iOrdinal = zzgxuVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzhdv.class, "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzhdx();
        }
        zzhee zzheeVar = null;
        if (iOrdinal == 4) {
            return new zzhdw(zzheeVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzgzo zzgxqVar = zzb;
        if (zzgxqVar == null) {
            synchronized (zzhdx.class) {
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
